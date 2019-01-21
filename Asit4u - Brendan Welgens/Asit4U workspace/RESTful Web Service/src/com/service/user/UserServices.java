//This is the web service class. It is used for handling requests and sending 
//responses to and from the client servlet.


package com.service.user;

import java.io.IOException;

//import java.awt.PageAttributes.MediaType;

import java.sql.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@Path("/user/service")		//Indicates a resource class
public class UserServices 	//Root resource class, Entry point to web service methods
{	
	
	@POST
	@Path("/processInput")					//Indicates the path this method uses
	@Consumes(MediaType.APPLICATION_JSON)	//Object type recieved
	@Produces(MediaType.TEXT_PLAIN)			//Object type returned
	public String processInput(String input) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(input, User.class);	//Converts json recieved into a User object
		
		String username = u.getUserID();
		String password = u.getPassword();
		String output = "";
		
		try 	//Connection to database and query to check for user credentials
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host/asit4u","asit4u","Wa03_c1Hk?ES");
			Statement st = con.createStatement();
			String query = "Select * from user where user_username = '"+username+"' and user_password = '"+password+"'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next())
			{
				output = "Login successful";
			}
			else
			{
				output = "Incorrect username or password";
			}
			con.close();
		} catch(Exception e) 
		{
			System.out.println(e);
		}
		
		return output;
	}
}



















