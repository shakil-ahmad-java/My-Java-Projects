package com.sa.dao;

import java.util.List;

import com.sa.model.UserProfile;

public interface UserProfileDao {

	public boolean saveUser(UserProfile user);
	public List<UserProfile> getAllUsers();
	public List<UserProfile> getOneUserById(Integer id);
	public boolean deleteUser();
}
