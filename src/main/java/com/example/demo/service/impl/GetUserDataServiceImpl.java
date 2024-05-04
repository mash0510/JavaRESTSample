package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserTableRepository;
import com.example.demo.repository.dto.UserDataDTO;
import com.example.demo.service.GetUserDataService;

@Service
public class GetUserDataServiceImpl implements GetUserDataService {

	@Autowired
	UserTableRepository utRep;
	
	@Override
	public UserDataDTO getUserData(String id) {
		UserDataDTO result = utRep.selectById(id);
		return result;
	}

}
