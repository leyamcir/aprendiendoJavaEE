/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.web.websocketbot;

import javaeetutorial.web.websocketbot.encoders.UsersMessageEncoder;
import javaeetutorial.web.websocketbot.encoders.ChatMessageEncoder;
import javaeetutorial.web.websocketbot.encoders.InfoMessageEncoder;
import javaeetutorial.web.websocketbot.encoders.JoinMessageEncoder;
import javaeetutorial.web.websocketbot.messages.ChatMessage;
import javaeetutorial.web.websocketbot.messages.UsersMessage;
import javaeetutorial.web.websocketbot.messages.JoinMessage;
import javaeetutorial.web.websocketbot.messages.InfoMessage;
import javaeetutorial.web.websocketbot.decoders.MessageDecoder;
import javaeetutorial.web.websocketbot.messages.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;

/* Websocket endpoint */
@ServerEndpoint(
        value = "/websocketbot",
        configurator = CustomConfigurator.class,
        decoders = { MessageDecoder.class }, 
        encoders = { JoinMessageEncoder.class, ChatMessageEncoder.class, 
                     InfoMessageEncoder.class, UsersMessageEncoder.class }
    )
/* There is a BotEndpoint instance per connetion */
public class BotEndpoint {
    private static final Logger logger = Logger.getLogger("BotEndpoint");
    /* Bot functionality bean */
    @Inject
    private BotBean botbean;
    /* Executor service for asynchronous processing */
    @Resource(name="comp/DefaultManagedExecutorService")
    private ManagedExecutorService mes;
    
    @OnOpen
    public void openConnection(Session session, EndpointConfig conf) {
        logger.log(Level.INFO, "Connection opened.");
        HandshakeRequest req = (HandshakeRequest) conf.getUserProperties()
                                        .get("handshakereq");
        
        Map<String,List<String>> headers = req.getHeaders();
        Iterator it = headers.entrySet().iterator();
        
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            logger.log(Level.INFO, "HEADERS: "+pair.getKey() + " = " + pair.getValue());
            
            if (pair.getKey().equals("host")){
                logger.log(Level.INFO, "HEADER HOST: "+pair.getKey() + " = " + pair.getValue());
            } else if (pair.getKey().equals("origin")){
                logger.log(Level.INFO, "HEADER ORIGIN: "+pair.getKey() + " = " + pair.getValue());
            }
        }
        
    }
    
    @OnMessage
    public void message(final Session session, Message msg) {
        logger.log(Level.INFO, "Received: {0}", msg.toString());
        
        if (msg instanceof JoinMessage) {
            /* Add the new user and notify everybody */
            JoinMessage jmsg = (JoinMessage) msg;
            session.getUserProperties().put("name", jmsg.getName());
            session.getUserProperties().put("active", true);
            logger.log(Level.INFO, "Received: {0}", jmsg.toString());
            sendAll(session, new InfoMessage(jmsg.getName() + 
                    " has joined the chat"));
            sendAll(session, new ChatMessage("Duke", jmsg.getName(),
                    "Hi there!!"));
            sendAll(session, new UsersMessage(this.getUserList(session)));
            
        } else if (msg instanceof ChatMessage) {
            /* Forward the message to everybody */
            final ChatMessage cmsg = (ChatMessage) msg;
            logger.log(Level.INFO, "Received: {0}", cmsg.toString());
            sendAll(session, cmsg);
            if (cmsg.getTarget().compareTo("Duke") == 0) {
                /* The bot replies to the message */
                mes.submit(new Runnable() {
                    @Override
                    public void run() {
                        String resp = botbean.respond(cmsg.getMessage());
                        sendAll(session, new ChatMessage("Duke", 
                                cmsg.getName(), resp));
                    }
                });
            } else if (cmsg.toString().contains("hola")) {
                banUser(session, cmsg.getName(), cmsg.getMessage());
            }
        }
    }
    
    @OnClose
    public void closedConnection(Session session) {
        /* Notify everybody */
        session.getUserProperties().put("active", false);
        if (session.getUserProperties().containsKey("name")) {
            String name = session.getUserProperties().get("name").toString();
            //if() // Not show twice on ban
            sendAll(session, new InfoMessage(name + " has left the chat"));
            sendAll(session, new UsersMessage(this.getUserList(session)));
        }
        logger.log(Level.INFO, "Connection closed.");
    }
    
    @OnError
    public void error(Session session, Throwable t) {
        logger.log(Level.INFO, "Connection error ({0})", t.toString());
    }
    
    /* Forward a message to all connected clients
     * The endpoint figures what encoder to use based on the message type */
    public synchronized void sendAll(Session session, Object msg) {
        try {
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen()) {
                    s.getBasicRemote().sendObject(msg);
                    logger.log(Level.INFO, "Sent: {0}", msg.toString());
                }
            }
        } catch (IOException | EncodeException e) {
            logger.log(Level.INFO, e.toString());
        }   
    }
    
    /* Returns the list of users from the properties of all open sessions */
    public List<String> getUserList(Session session) {
        List<String> users = new ArrayList<>();
        users.add("Duke");
        for (Session s : session.getOpenSessions()) {
            if (s.isOpen() && (boolean) s.getUserProperties().get("active"))
                users.add(s.getUserProperties().get("name").toString());
        }
        return users;
    }
    
    /* Ban user when some word is used */
    public void banUser (final Session session, String name, String msg){
        
        //Set<Session> sessions = session.getOpenSessions();
        // Search user in sessions
        
        if (session.isOpen()){
            session.getUserProperties().put("active", false);
            sendAll(session, new UsersMessage(this.getUserList(session)));
            sendAll(session, new InfoMessage(name + " has been banned after writing this: " + msg));
        
            try {
                CloseReason reason = new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "Forbidden word used");
                session.close(reason);

            } catch (IOException e) {
                logger.log(Level.INFO, e.toString());
            } 
        }
        
         
        
    }
}
