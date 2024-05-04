package com.example.demo.repository;

import com.example.demo.repository.dto.EmpDataDTO;

public interface EmpTableRepository {

	public EmpDataDTO getEmpData(String empId);
}
