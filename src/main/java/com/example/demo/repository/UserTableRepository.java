package com.example.demo.repository;

import com.example.demo.repository.dto.UserDataDTO;

public interface UserTableRepository {

	public UserDataDTO selectById(String id);
}
