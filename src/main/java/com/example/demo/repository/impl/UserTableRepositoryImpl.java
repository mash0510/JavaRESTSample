package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.BaseRepository;
import com.example.demo.repository.UserTableRepository;
import com.example.demo.repository.dto.UserDataDTO;

@Repository
public class UserTableRepositoryImpl extends BaseRepository implements UserTableRepository {

	@Override
	public UserDataDTO selectById(String userId) {
		
		String selectSql = "select * from UserDataTable where user_id=?";
		
		List<UserDataDTO> dataList = dbPrimary.query(selectSql, new DataClassRowMapper<>(UserDataDTO.class), userId);
		
		UserDataDTO result = null;
		
		for (UserDataDTO data : dataList) {
			result = data;
			break;
		}
		
		return result;
	}
}
