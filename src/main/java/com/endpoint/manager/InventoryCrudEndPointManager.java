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
import com.dao.exception.DataBaseException;
import com.dao.managers.InventoryManagerImpl;
import com.service.manager.ItemEnityToInventoryConverter;


@Path("/InventoryEndPoint")
public class InventoryCrudEndPointManager {

@Autowired
InventoryManagerImpl inventoryManagerImpl;

@Autowired
ItemEnityToInventoryConverter entityToInventory;
	
	@POST
	@Path("/addInventory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response  addInventory(ItemEntity  itemEntity){
	
		System.out.println("Item Name "+ itemEntity.getType());
		System.out.println("Item Description "+ itemEntity.getDescription());
		System.out.println("Item Quantity "+ itemEntity.getPrice());
		System.out.println("Item UnitPrice "+ itemEntity.getImage());
			
		Inventory inventory = entityToInventory.convertItemEntityToInventory(itemEntity , inventoryManagerImpl);
		try {
			inventoryManagerImpl.addInventory(inventory);
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			String result = "Successful";
			return Response.status(200).entity(result).build();
		}
	
}