package com.endpoint.manager;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.beans.ItemEntity;
import com.dao.entity.Inventory;
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
		System.out.println("Item Category "+ itemEntity.getCategory());
		System.out.println("Item ItemType "+ itemEntity.getType());
		System.out.println("Item Quantity "+ itemEntity.getPrice());
		System.out.println("Item UnitPrice "+ itemEntity.getImage());
		System.out.println("Item Used "+ itemEntity.getUsedItem());
		System.out.println("Item New "+ itemEntity.getNewItem());
		System.out.println("Item Description "+ itemEntity.getDescription());
		System.out.println("Item sold by : "+ itemEntity.getSellerName());
		
			
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