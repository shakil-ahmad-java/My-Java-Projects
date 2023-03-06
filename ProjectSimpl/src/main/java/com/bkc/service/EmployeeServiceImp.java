package com.bkc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkc.bean.EditEmpBean;
import com.bkc.bean.EmployeeBean;
import com.bkc.dao.EmployeeDao;
import com.bkc.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public void saveEmployeeDetails(EmployeeBean empBean) {
		employeeDao.saveEmployeeDetails(empBean);
	}

	public List<EmployeeBean> getUsersList() {
		
		return employeeDao.getUsersList();
	}	

	public void deleteUser(Integer id) {
		employeeDao.deleteUser(id);
	}

	public boolean updateUser(EditEmpBean editEmpBean) {
		return employeeDao.updateUser(editEmpBean);
	}

	public List<EmployeeBean> getUser(Integer id) {
		// TODO Auto-generated method stub
		return employeeDao.getUser(id);
	}

}
