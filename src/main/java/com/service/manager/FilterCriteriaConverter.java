package com.service.manager;

import org.springframework.stereotype.Component;

import com.beans.FilterCriteriaEntity;
import com.dao.entity.FilterCriteriaObject;

@Component
public class FilterCriteriaConverter {
	public FilterCriteriaObject convertEntityToObject(FilterCriteriaEntity filterCriteriaEntity){
		FilterCriteriaObject filterCriteriaObject = new FilterCriteriaObject();
		if(filterCriteriaEntity.getSubCategoryList() != null){
			filterCriteriaObject.setSubCategoryList(filterCriteriaEntity.getSubCategoryList());
		}
		if(filterCriteriaEntity.getNewItem() != null){
			filterCriteriaObject.setNewItem(filterCriteriaEntity.getNewItem());
		}
		
		if(filterCriteriaEntity.getUsedItem() != null){
			filterCriteriaObject.setUsedItem(filterCriteriaEntity.getUsedItem());
		}
		
		if(filterCriteriaEntity.getCategory() != null){
			filterCriteriaObject.setCategory(filterCriteriaEntity.getCategory());
		}
		
		if(filterCriteriaEntity.getMaxAmount() != null){
			filterCriteriaObject.setMaxAmount(filterCriteriaEntity.getMaxAmount());
		}
		
		if(filterCriteriaEntity.getMinAmount() != null){
			filterCriteriaObject.setMinAmount(filterCriteriaEntity.getMinAmount());
		}
		return filterCriteriaObject;
	}

}
