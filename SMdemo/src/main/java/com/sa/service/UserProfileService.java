package com.sa.service;

import java.util.List;

import com.sa.model.UserProfile;

public interface UserProfileService {

	public boolean saveUser(UserProfile user);
	public List<UserProfile> getAllUsers();
	public List<UserProfile> getOneUserById(Integer id);
	public boolean deleteUser();
}
