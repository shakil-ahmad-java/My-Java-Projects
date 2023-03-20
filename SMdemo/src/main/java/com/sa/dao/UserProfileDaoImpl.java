package com.sa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sa.model.UserProfile;

@Repository
@Transactional
public class UserProfileDaoImpl implements UserProfileDao {

	@Autowired
	private SessionFactory sf;
	
	public boolean saveUser(UserProfile user) {
		Session session = sf.getCurrentSession();
		try {
			session.save(user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<UserProfile> getAllUsers() {
		Session sess = sf.getCurrentSession();
//		ArrayList<UserProfile> users = new ArrayList<UserProfile>();
		@SuppressWarnings("deprecation")
		Criteria c = sess.createCriteria(UserProfile.class);
		List list = c.list();
		
		return list;
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
