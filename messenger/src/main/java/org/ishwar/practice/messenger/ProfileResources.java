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
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.model.ParamQualifier;
import org.ishwar.practice.messenger.Model.Profiles;
import org.ishwar.practice.messenger.service.ProfileService;

@Path("profile")
public class ProfileResources {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profiles> getAllProfile(){
		return profileService.getProfileAll();
	}
	
	@GET
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profiles getProfile(@PathParam("messageid") long messageid){
		return profileService.getProfile(messageid);
	}
	
	@PUT
	@Path("/{pname}")
	public Profiles updateProfile(@PathParam("pname") String name, Profiles prof){
		return profileService.updateProfile(name, prof);
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profiles remove(@PathParam("id") long id){
		return profileService.deleteProfile(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profiles addProfile(Profiles prof){
		return profileService.addProfile(prof);
	}
}
