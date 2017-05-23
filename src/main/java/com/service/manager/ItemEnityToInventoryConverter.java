package com.service.manager;

import org.springframework.stereotype.Component;

import com.beans.ItemEntity;
import com.dao.entity.Inventory;
import com.dao.exception.DataBaseException;
import com.dao.managers.InventoryManagerImpl;

@Component
public class ItemEnityToInventoryConverter {
	
	public Inventory convertItemEntityToInventory (ItemEntity itemEntity, InventoryManagerImpl inventoryManagerImpl){
		Inventory inventory = new Inventory();
		if(itemEntity.getType()!= null){
			inventory.setInventoryType(itemEntity.getType());
		}
		if(itemEntity.getDescription()!= null){
			inventory.setInventoryDescription(itemEntity.getDescription());
		}
		if(itemEntity.getImage()!=null){
			inventory.setInventoryImage(itemEntity.getImage().getBytes());
		}
		if (itemEntity.getPrice()!=null){
			inventory.setInventoryPrice(itemEntity.getPrice());
		}
		try {
			inventory.setInventoryTypeId(inventoryManagerImpl.getInventoryTypeId(itemEntity.getType()));
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inventory;
	}
	

}
