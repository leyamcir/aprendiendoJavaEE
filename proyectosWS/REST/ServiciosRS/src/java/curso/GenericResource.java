/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author cas
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    //private HttpServletRequest req;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of curso.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(
        @DefaultValue("") 
        @QueryParam("codigo") String codigo
    ) {
        
        //return "!Hola curso!";
        return "Hola. codigo="+codigo;
    }
    
    @Path("/ipcli")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIpClient(@Context HttpServletRequest req) {
        String ipAddress = req.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = req.getRemoteAddr();
        }
        return "ipAddress:" + ipAddress;
    }
    
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getId(
        @PathParam("id") String id) {
        return "Hola "+id+" !";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
