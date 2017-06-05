package com.endpoint.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.beans.FilterCriteriaObject;
import com.beans.ItemEntity;
import com.beans.ItemEntityList;

@Path("/service")
public class serviceEndPointManager {
	
	@POST
	@Path("/getFilterdResults")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFilteredResult(FilterCriteriaObject filterCriteria){
		//ItemEntityList itemEntityList = new ItemEntityList();
		List<ItemEntity> list = new ArrayList<ItemEntity>();
		
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setType("laalala");
		itemEntity.setPrice(34);
		itemEntity.setDescription("dfdafda");
		
		ItemEntity itemEntity2 = new ItemEntity();
		itemEntity2.setType("laalala");
		itemEntity2.setPrice(34);
		itemEntity2.setDescription("dfdafda");
		
		list.add(itemEntity);
		list.add(itemEntity2);
	//	itemEntityList.setItemEntityList(list);
		
		GenericEntity< List< ItemEntity > > entity = new GenericEntity< List< ItemEntity > >( list ) { };
		return Response.ok( entity ).build();


	}
	
	@GET
	@Path("/getAllInventory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllInventory(){
		List<ItemEntity> list = new ArrayList<ItemEntity>();
		
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setType("laalala");
		itemEntity.setPrice(34);
		itemEntity.setDescription("dfdafda");
		
		ItemEntity itemEntity2 = new ItemEntity();
		itemEntity2.setType("laalala");
		itemEntity2.setPrice(34);
		itemEntity2.setDescription("dfdafda");
		
		list.add(itemEntity);
		list.add(itemEntity2);
		
		GenericEntity< List< ItemEntity > > entity = new GenericEntity< List< ItemEntity > >( list ) { };
		return Response.ok( entity ).build();


	}
}
