package org.ishwar.practice.messenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.ishwar.practice.messenger.Model.Messages;
import org.ishwar.practice.messenger.service.MessengerService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("message")
public class MessageResource {
	
	MessengerService messengerService = new MessengerService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Messages> getGetAllMessage(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
    	if(year >  0){
    		return messengerService.getAllMessageForYear(year);
    	}
    	
    	if(size >= 0 && size >= 0){
    		 return messengerService.getAllMessagePaginated(start, size);
    	}
    	
    	return messengerService.getGetAllMessages(); 
    } 
    
    /*@GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Messages getMessageById(@PathParam("messageId") long messageId){
    	return messengerService.getGetMessage(messageId);
    }*/
    
   /* @GET
    @Path("/{year}")
    public List<Messages>getMessageByYear(@PathParam("year") int year){
    	return messengerService.getAllMessageForYear(year);
    }*/
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Messages postMessageById(Messages messageId){
    	return messengerService.addMessage(messageId); 
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Messages updateMessageById(Messages mess){
    	return messengerService.updateMessage(mess); 
    }
    
    
    @DELETE
    @Path("/{messageid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Messages deleteMessageById(@PathParam("messageid") long messageid){
    	return messengerService.removeMessage(messageid); 
    }
    
}
