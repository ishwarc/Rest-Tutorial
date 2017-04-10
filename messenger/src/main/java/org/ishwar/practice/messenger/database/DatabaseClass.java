package org.ishwar.practice.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.ishwar.practice.messenger.Model.Messages;
import org.ishwar.practice.messenger.Model.Profiles;

public class DatabaseClass {
	
	private static Map<Long, Messages> message = new HashMap<>();
	private static Map<Long, Profiles> profile = new HashMap<>();
	
	
	
	
	public  void setMessage(Map<Long, Messages> message) {
		DatabaseClass.message = message;
	}
	public static  Map<Long, Profiles> getProfile() {
		return profile;
	}
	public  void setProfile(Map<Long, Profiles> profile) {
		DatabaseClass.profile = profile;
	}
	public static  Map<Long, Messages> getMessage() {
		// TODO Auto-generated method stub
		return message;	
	}


}
