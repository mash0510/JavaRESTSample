package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.BaseRepository;
import com.example.demo.repository.EmpTableRepository;
import com.example.demo.repository.dto.EmpDataDTO;

@Repository
public class EmpTableRepositoryImpl extends BaseRepository implements EmpTableRepository {

	@Override
	public EmpDataDTO getEmpData(String empId) {
		
		String selectSql = "select * from EmployeeTable where emp_id = ?";
		
		List<EmpDataDTO> dataList = dbSecondary.query(selectSql, new DataClassRowMapper<>(EmpDataDTO.class), empId);
		
		EmpDataDTO result = null;
		
		for(EmpDataDTO data : dataList) {
			result = data;
			break;
		}
		
		return result;
	}
}
