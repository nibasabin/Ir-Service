package com.config.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.managers.InventoryManagerImpl;

@Configuration
public class ApplicationContextConfig {

	private ApplicationContext context;

	@Bean
	public ApplicationContext getContext(){
		context = new ClassPathXmlApplicationContext("springMVC.xml");
		return context;
	}
	@Bean
	public InventoryManagerImpl inventorymanagerImpl(){
		InventoryManagerImpl inventoryManager = (InventoryManagerImpl) context.getBean("inventoryManagerImpl");
		return inventoryManager;
	}
}
