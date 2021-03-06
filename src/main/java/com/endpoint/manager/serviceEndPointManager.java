package com.endpoint.manager;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.beans.FilterCriteriaEntity;
import com.beans.ItemEntity;
import com.dao.entity.FilterCriteriaObject;
import com.dao.entity.Inventory;
import com.dao.exception.DataBaseException;
import com.dao.managers.InventoryManager;
import com.service.manager.FilterCriteriaConverter;
import com.service.manager.InventoryToItemEntityConverter;

@Path("/service")
public class serviceEndPointManager {
	
	@Autowired
	InventoryManager inventoryManager;
	
	@Autowired
	InventoryToItemEntityConverter inventoryToItemEntityConverter ;
	
	@Autowired
	FilterCriteriaConverter FilterCriteriaConverter;
	
	@POST
	@Path("/getFilterdResults")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFilteredResult(FilterCriteriaEntity filterCriteria){
		FilterCriteriaObject  filterCriteriaObject= FilterCriteriaConverter.convertEntityToObject(filterCriteria);
		List<Inventory> inventoryList = inventoryManager.getFilteredInventory(filterCriteriaObject);
		List<ItemEntity> itemEntityLit = inventoryToItemEntityConverter.convertInventoryToItemEntityList(inventoryList);		
		GenericEntity< List< ItemEntity > > entity = new GenericEntity< List< ItemEntity > >( itemEntityLit ) { };
		return Response.ok( entity ).build();


	}
	
	@POST
	@Path("/getAllInventory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllInventory(String category){
		List<Inventory> inventoryList = inventoryManager.getAllInventory(category);
		List<ItemEntity> itemEntityList = inventoryToItemEntityConverter.convertInventoryToItemEntityList(inventoryList);		
		GenericEntity< List< ItemEntity > > entity = new GenericEntity< List< ItemEntity > >( itemEntityList ) { };
		return Response.ok( entity ).build();
	}
	
	@POST
	@Path("/getUsersInventory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsersInventory(String userName){
		List<Inventory> inventoryList = inventoryManager.getUsersInventory(userName);
		List<ItemEntity> itemEntityList = inventoryToItemEntityConverter.convertInventoryToItemEntityList(inventoryList);		
		GenericEntity< List< ItemEntity > > entity = new GenericEntity< List< ItemEntity > >( itemEntityList ) { };
		return Response.ok( entity ).build();
	}
	
	@POST
	@Path("/addToGlobalInventory")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addToGlobalInventory(String userName){
		try {
			inventoryManager.addToGlobalInventory(Integer.parseInt(userName));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@POST
	@Path("/deleteItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteItem(String userName){
		try {
			inventoryManager.deleteItem(Integer.parseInt(userName));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
