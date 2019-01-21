package com.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class ClientServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Client client = Client.create();	//from jersey library
		WebResource webResource = client.resource("http://localhost:8080/RESTful_Web_Service/backend/user/service/processInput");	//locates the method in web service
		
		User user = new User();
		user.setUserID(request.getParameter("username"));		//recieved from client.jsp
		user.setPassword(request.getParameter("password"));		//recieved from client.jsp
		ClientResponse clientResponse = webResource.accept(MediaType.TEXT_PLAIN).entity(user, MediaType.APPLICATION_JSON).post(ClientResponse.class);	//creates response object from processInput method in UserServices
		String output = clientResponse.getEntity(String.class);		//get output from UserServices
		System.out.println("Output from webservice: " + output);
		JOptionPane.showMessageDialog(null, output);
	}

}
