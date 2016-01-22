package de.akquinet.rest.service.login;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import de.akquinet.address.model.User;


@Path("login")
public class LoginService {
	
	private static Map<String, User> userAngemeldet = new HashMap<String, User>();


	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void login(User user) {
		System.out.println("benutzer: " + user.getName() + " " + user.getPassword());
		userAngemeldet.put(user.getName(), user);	
	}
	
	
	public boolean isUserAngemeldet(String name)
	{
		return userAngemeldet.containsKey(name);
	}
}
