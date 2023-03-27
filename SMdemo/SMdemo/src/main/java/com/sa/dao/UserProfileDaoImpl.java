package com.sa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sa.bean.Login;
import com.sa.bean.UserProfileBean;
import com.sa.model.UserProfile;

@Repository
@Transactional
public class UserProfileDaoImpl implements UserProfileDao {

	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public boolean saveUser(UserProfileBean userProfileBean) {
		Session session = sf.getCurrentSession();
		UserProfile user = new UserProfile();
		user.setFullname(userProfileBean.getFullname());
		user.setEmail(userProfileBean.getEmail());
		user.setMobile(userProfileBean.getMobile());
		user.setDob(userProfileBean.getDob());
		user.setPassword(passwordEncoder.encode(userProfileBean.getPassword()));
		session.save(user);
		return true;
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

	public boolean isValidUser(Login login) {
		Session session = sf.getCurrentSession();
		String query = "from UserProfile where email=:e";
		Query query2 = session.createQuery(query);
		query2.setParameter("e", query2);
		List tempList = query2.list();
		
		List<UserProfile> users = new ArrayList<UserProfile>();
		
		return false;
	}

}
