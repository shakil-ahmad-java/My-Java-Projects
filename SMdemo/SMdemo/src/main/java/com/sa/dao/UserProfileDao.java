package com.sa.dao;

import java.util.List;

import com.sa.bean.Login;
import com.sa.bean.UserProfileBean;
import com.sa.model.UserProfile;

public interface UserProfileDao {

	public boolean saveUser(UserProfileBean userProfileBean);
	public boolean isValidUser(Login login);
	public List<UserProfile> getAllUsers();
	public List<UserProfile> getOneUserById(Integer id);
	public boolean deleteUser();
}
