package org.ishwar.practice.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ishwar.practice.messenger.Model.Profiles;
import org.ishwar.practice.messenger.database.DatabaseClass;


public class ProfileService {


	private Map<Long, Profiles> profile = DatabaseClass.getProfile();
	
	public ProfileService() {
		Date date = new Date();
		profile.put(1L, new Profiles(1L, "ichau", "ishwar", "chaulagain", date));
		profile.put(2L, new Profiles(2L, "slama", "senji", "lama", date));

	}
	
	public List<Profiles> getProfileAll(){
		return new ArrayList<Profiles>(profile.values());
	}
	
	public Profiles getProfile(long id){
		return profile.get(id);
	}
	
	public Profiles addProfile(Profiles prof){
		prof.setId(profile.size()+1);
		return profile.put(prof.getId(), prof);
	}
	
	public Profiles deleteProfile(long id){
		return profile.remove(id);
	}
	
	public Profiles updateProfile(String name, Profiles prof){
		
		prof.setFirstName(name);
		return profile.put(prof.getId(), prof); 
	}
	
	
	
	

}
