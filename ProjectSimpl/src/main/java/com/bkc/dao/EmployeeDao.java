package com.bkc.dao;

import java.util.List;

import com.bkc.bean.EditEmpBean;
import com.bkc.bean.EmployeeBean;

public interface EmployeeDao {

	public void saveEmployeeDetails(EmployeeBean empBean );
	public List<EmployeeBean> getUser(Integer id);
	public List<EmployeeBean> getUsersList();
	public boolean updateUser(EditEmpBean editEmpBean);
	public void deleteUser(Integer id);
}
