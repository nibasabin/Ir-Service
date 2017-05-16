package com.endpoint.manager;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.ItemEntity;
import com.dao.entity.Inventory;
import com.dao.managers.InventoryManagerImpl;
import com.service.manager.ItemEnityToInventoryConverter;
@Path("/InventoryEndPoint")
public class ServiceManager {


	@POST
	@Path("/addInventory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response  addInventory(ItemEntity  itemEntity){
//	
//context = new ClassPathXmlApplicationContext("springMVC.xml");
//	InventoryManagerImpl inventoryManagerImpl = (InventoryManagerImpl)context.getBean("inventoryManagerImpl");
		System.out.println("Item Name "+ itemEntity.getType());
		System.out.println("Item Description "+ itemEntity.getDescription());
		System.out.println("Item Quantity "+ itemEntity.getPrice());
		System.out.println("Item UnitPrice "+ itemEntity.getImage());
			
		InventoryManagerImpl inventoryManagerImpl = new InventoryManagerImpl();
		ItemEnityToInventoryConverter entityToInventory = new ItemEnityToInventoryConverter();
		Inventory inventory = entityToInventory.convertItemEntityToInventory(itemEntity , inventoryManagerImpl);
		inventoryManagerImpl.addInventory(inventory);

			String result = "Successful";
			return Response.status(200).entity(result).build();
		}
	
/*	@POST
	@Path("/test2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response  test2(String data){
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			ItemEntity item = (ItemEntity) mapper.readValue(data,ItemEntity.class);
			
			System.out.println("Item id "+ item.getItemId());
			System.out.println("Item Name "+ item.getItemName());
			System.out.println("Item Description "+ item.getItemDescription());
			System.out.println("Item Quantity "+ item.getItemQuantity());
			System.out.println("Item UnitPrice "+ item.getItemUnitPrice());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = "Successful";
		return Response.status(200).entity(data).build();
	}*/



	@GET
	@Path("/test")
	//@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public Library  test(){
		Library library = new Library();
		library.setAge("25");
		library.setName("sabin");
		return library;
}
}