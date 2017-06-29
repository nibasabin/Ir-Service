package com.service.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.beans.ItemEntity;
import com.dao.entity.Inventory;

@Component
public class InventoryToItemEntityConverter {

	public List<ItemEntity> convertInventoryToItemEntityList (List<Inventory> inventoryList){
		List<ItemEntity> itemEntityList = new ArrayList<ItemEntity>();
		for( Inventory inventory :inventoryList){
			ItemEntity itemEntity = new ItemEntity();
			
			if(inventory.getInventoryId()!= null){
				itemEntity.setId(inventory.getInventoryId());
			}
			if(inventory.getInventoryTypeId()!= null){
				itemEntity.setTypeId(inventory.getInventoryTypeId());
			}
			
			if(inventory.getInventoryDescription()!= null){
				itemEntity.setDescription(inventory.getInventoryDescription());
			}
			if(inventory.getInventoryPrice() != null){
				itemEntity.setPrice(inventory.getInventoryPrice());
			}
			
			if(inventory.getInventoryImage() != null){
				itemEntity.setImage( new String(inventory.getInventoryImage()));
			}
			
			if(inventory.getInventoryType() != null){
				itemEntity.setType(inventory.getInventoryType());
			}
			
			if(inventory.getNewInventory() != null){
				itemEntity.setNewItem(inventory.getNewInventory());
			}
			if(inventory.getUsedInventory() != null){
				itemEntity.setUsedItem(inventory.getUsedInventory());
			}
			if(inventory.getItemSold() != null){
				itemEntity.setItemSold(inventory.getItemSold());
			}
			if(inventory.getSellerName() != null){
				itemEntity.setSellerName(inventory.getSellerName());
			}
			itemEntityList.add(itemEntity);
		}
		return itemEntityList;
	}
	
}
