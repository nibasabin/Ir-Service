package com.service.manager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beans.UserInformation;
import com.dao.entity.UserInformationEntity;

@Component
public class UserInformationToUserInformationEntity {

	@Autowired
	UserInformationEntity userInformationEntity;
	
	public UserInformationEntity convertUserToUserEntity (UserInformation userInformation){
		
		if(userInformation.getFirstName()!= null){
			userInformationEntity.setFirstName(userInformation.getFirstName());
		}
		if(userInformation.getFirstName()!= null){
			userInformationEntity.setFirstName(userInformation.getFirstName());
		}
		if(userInformation.getLastName()!= null){
			userInformationEntity.setLastName(userInformation.getLastName());
		}
		if(userInformation.getEmailId()!= null){
			userInformationEntity.setEmailId(userInformation.getEmailId());
		}
		if(userInformation.getPassword()!= null){
			userInformationEntity.setPassword(userInformation.getPassword());
		}
		if(userInformation.getDateOfBirth()!= null){
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date date;
			try {
				date = format.parse(userInformation.getDateOfBirth());
				userInformationEntity.setDateOfBirth(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		

		}
		if(userInformation.getAddress()!= null){
			userInformationEntity.setAddress(userInformation.getAddress());
		}
		if(userInformation.getCity()!= null){
			userInformationEntity.setCity(userInformation.getCity());
		}
		if(userInformation.getState()!= null){
			userInformationEntity.setState(userInformation.getState());
		}
		if(userInformation.getZipCode()!= null){
			userInformationEntity.setZipCode(userInformation.getZipCode());
		}
		userInformationEntity.setEnabled(true);
		userInformationEntity.setRole("ROLE_ADMIN");

		return userInformationEntity;
	}
	
}
