package org.ishwar.practice.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.ishwar.practice.messenger.Model.Messages;
import org.ishwar.practice.messenger.database.DatabaseClass;

public class MessengerService {
	
	private Map<Long,Messages>message = DatabaseClass. getMessage(); 
	
	
	
	public MessengerService() {
		Date date = new Date();
		message.put(1L, new Messages(1L, "Ishwar1", "Message1", date));
		message.put(2L, new Messages(3L, "Ishwar2", "Message2", date));

	}
	
	public List<Messages> getGetAllMessages() {
    	
        return new ArrayList<Messages>(message.values());
    }
	
	public Messages getGetMessage(long id) {
    	
        return message.get(id);
    }
	
	public Messages updateMessage(Messages mess) {
		
		if(mess.getId() <= 0)
			return null;
		else{
			message.put(mess.getId(), mess);
			return mess;
		}    	
    }
	
	public List<Messages> getAllMessageForYear(int year){
		List<Messages> allmessage = new ArrayList<>();
		Calendar lCal = Calendar.getInstance();
		for(Messages message : getGetAllMessages()){
			
			lCal.setTime(message.getCreated());
			if(year==lCal.get(Calendar.YEAR)){
				allmessage.add(message);
			}
		}
		return allmessage;
	}
	
	public List<Messages> getAllMessagePaginated(int start, int size){
		List<Messages> paginatedall = new ArrayList<>();
		
		for(int i = start; i < size; i++){
			paginatedall.add(getGetMessage(i));
		}		
		return paginatedall;
	}
	
	public Messages addMessage(Messages mess) {		
		mess.setId(message.size()+1);
		message.put(mess.getId(), mess);
		return mess;  	
    }
	
	public Messages removeMessage(long id) {   	
        return message.remove(id);
    }

}
