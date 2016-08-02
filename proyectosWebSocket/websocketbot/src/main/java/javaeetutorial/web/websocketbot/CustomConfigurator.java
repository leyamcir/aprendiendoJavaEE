/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.web.websocketbot;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 *
 * @author Alicia Daza
 */
public class CustomConfigurator
    extends ServerEndpointConfig.Configurator {
    
    @Override
    public void modifyHandshake(ServerEndpointConfig conf,
        HandshakeRequest req,HandshakeResponse resp) {
        conf.getUserProperties().put("handshakereq", req);
    }
}