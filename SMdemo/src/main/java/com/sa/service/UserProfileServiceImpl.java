package com.sa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.dao.UserProfileDao;
import com.sa.model.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileDao userProfileDao;
	
	public boolean saveUser(UserProfile user) {
		// TODO Auto-generated method stub
		return userProfileDao.saveUser(user);
	}

	public List<UserProfile> getAllUsers() {
		// TODO Auto-generated method stub
		return userProfileDao.getAllUsers();
	}

	public List<UserProfile> getOneUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser() {
		// TODO Auto-generated method stub
		return false;
	}

}
