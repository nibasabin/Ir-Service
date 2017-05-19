package com.endpoint.manager;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.ItemEntity;
import com.dao.entity.Inventory;
import com.dao.entity.InventoryType;
import com.dao.entityManagerFactory.SessionFactoryInstance;
import com.dao.managers.InventoryManagerImpl;
import com.service.manager.ItemEnityToInventoryConverter;


@Path("/InventoryEndPoint")
public class ServiceManager {

@Autowired
InventoryManagerImpl inventoryManagerImpl;


	
	@POST
	@Path("/addInventory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response  addInventory(ItemEntity  itemEntity){
//	
		System.out.println("Item Name "+ itemEntity.getType());
		System.out.println("Item Description "+ itemEntity.getDescription());
		System.out.println("Item Quantity "+ itemEntity.getPrice());
		System.out.println("Item UnitPrice "+ itemEntity.getImage());
			
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



//	@GET
//	@Path("/test")
//	//@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
//	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
//	public Library  test(){
//		Library library = new Library();
//		library.setAge("25");
//		library.setName("sabin");
//		return library;
//}
	public static void main(String args[]){
		SessionFactoryInstance obj = new SessionFactoryInstance();
		SessionFactory factory = obj.createSession();
		Session session = factory.openSession();
		InventoryType inventoryType = new InventoryType();
		inventoryType.setInventoryTypeId(109);
		inventoryType.setInventoryType("Speaker");
		Transaction transaction = null ;
		try{
			transaction = session.beginTransaction();
			session.persist(inventoryType);
			transaction.commit();		
		}catch(HibernateException e){
	        if (transaction!=null) transaction.rollback();
	        e.printStackTrace(); 
	     }finally {
	        session.close(); 
	     }
	}
}