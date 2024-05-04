package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.indto.GetEmpDataDTO;
import com.example.demo.controller.indto.GetUserDataDTO;
import com.example.demo.controller.outdto.OutEmpDataDTO;
import com.example.demo.controller.outdto.OutUserDataDTO;
import com.example.demo.repository.dto.EmpDataDTO;
import com.example.demo.repository.dto.UserDataDTO;
import com.example.demo.service.GetEmpDataService;
import com.example.demo.service.GetUserDataService;

@RestController
public class UserDataController {

	@Autowired
	GetUserDataService getUserService;
	
	@PostMapping(value="/GetUserData")
	public OutUserDataDTO GetUserData(@RequestBody GetUserDataDTO inDTO) {
		UserDataDTO dbDTO = getUserService.getUserData(inDTO.getUserId());
		
		OutUserDataDTO outDTO = new OutUserDataDTO();
		outDTO.setUserId(dbDTO.getUserId());
		outDTO.setUserName(dbDTO.getUserName());
		outDTO.setAddress(dbDTO.getAddress());
		
		return outDTO;
		
	}
	
	@Autowired
	GetEmpDataService getEmpService;
	
	@PostMapping(value="/GetEmpData")
	public OutEmpDataDTO GetEmpData(@RequestBody GetEmpDataDTO inDTO) {
		EmpDataDTO dbDTO = getEmpService.getEmpData(inDTO.getEmpId());
		
		OutEmpDataDTO outDTO = new OutEmpDataDTO();
		outDTO.setDepartment(dbDTO.getDepartment());
		outDTO.setEmpId(dbDTO.getEmpId());
		outDTO.setPosition(dbDTO.getPosition());
		
		return outDTO;
	}
}
