package com.endpoint.manager;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.beans.UserInformation;
import com.dao.entity.UserInformationEntity;
import com.dao.managers.UserManager;
import com.service.manager.UserInformationToUserInformationEntity;

@Path("/userManagerEndPoint")
public class UserManagerEndPoint {

	@Autowired
	UserManager userManager;

	@Autowired
	UserInformationToUserInformationEntity userInformationToUserInformationEntity;
		
		@POST
		@Path("/addUser")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public Response  addUser(UserInformation  userInformation){
				
			UserInformationEntity userInformationEntity = userInformationToUserInformationEntity.convertUserToUserEntity(userInformation);
			userManager.addUser(userInformationEntity);

			String result = "Successful";
			return Response.status(200).entity(result).build();
			}
		
		@GET
		@Path("/firstLastName/{emailId}")
		//@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
		@Produces(MediaType.TEXT_PLAIN)
		public String getUserFirstLastName(@PathParam(value = "emailId") String emailId){
			
			return userManager.getUserFirstLastName(emailId);
	}

		@GET
		@Path("/test")
		//@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
		@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
		public ItemObject2  test(){
			ItemObject2 library = new ItemObject2();
			library.setItemId(25);
			library.setItemName("sabin");
			return library;
	}
}




