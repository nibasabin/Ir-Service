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
		if(itemEntity.getCategory() != null){
			inventory.setInventoryCategory(itemEntity.getCategory());
		}
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
		if(itemEntity.getNewItem() !=null){
			inventory.setNewInventory(itemEntity.getNewItem());
		}
		
		if(itemEntity.getUsedItem() != null){
			inventory.setUsedInventory(itemEntity.getUsedItem());
		}
		if(itemEntity.getSellerName() != null){
			inventory.setSellerName(itemEntity.getSellerName());
		}
		if(itemEntity.getItemSold() != null){
			inventory.setItemSold(itemEntity.getItemSold());
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
