package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmpTableRepository;
import com.example.demo.repository.dto.EmpDataDTO;
import com.example.demo.service.GetEmpDataService;

@Service
public class GetEmpDataServiceImpl implements GetEmpDataService {

	@Autowired
	EmpTableRepository empRep;
	
	@Override
	public EmpDataDTO getEmpData(String empId) {
		EmpDataDTO result = empRep.getEmpData(empId);
		return result;
	}
}
