package com.bkc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bkc.bean.EditEmpBean;
import com.bkc.bean.EmployeeBean;
import com.bkc.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sf;

	public void saveEmployeeDetails(EmployeeBean empBean) {
		Session session = sf.getCurrentSession();
		Employee emp = new Employee();

		String id = empBean.getId();
		String name = empBean.getName();
		String email = empBean.getEmail();
		String mobile = empBean.getMobile();

		emp.setId(id);
		emp.setName(name);
		emp.setEmail(email);
		emp.setMobile(mobile);

		session.saveOrUpdate(emp);
		/*
		 * String q1 = "select max(id) from employee"; SQLQuery qry =
		 * session.createSQLQuery(q1); String counter =
		 * qry.list().toString().replaceAll("[<>\\[\\],-]", ""); int id =
		 * Integer.parseInt(counter) + 1; System.out.println(id); //bkc_user_detail
		 * String query =
		 * "insert into employee values('"+id+"','"+empBean.getName()+"','"+empBean.
		 * getEmail()+"','"+empBean.getMobile()+"','"+empBean.getPassword()+"')";
		 * SQLQuery query2 = session.createSQLQuery(query); query2.executeUpdate();
		 */
//		try {
//			Employee emp = new Employee();
//			emp.setEmail(empBean.getEmail());
//			emp.setId(empBean.getId());
//			emp.setMobile(empBean.getMobile());
//			emp.setName(empBean.getName());
//			emp.setPassword(empBean.getPassword());
//			session.save(emp);
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
	}
	
	public List<EmployeeBean> getUser(Integer id) {
		try {
			Session session = sf.getCurrentSession();
			List<EmployeeBean> empBean = new ArrayList<EmployeeBean>();
			
			String query = "select id,name,email,mobile from employee where id="+id;
			
			SQLQuery query2 = session.createSQLQuery(query);
			query2.setCacheable(true);
			
			List list = query2.list();
			
			for(Object obj : list) {
				EmployeeBean eb = new EmployeeBean();
				Object[] arr = (Object[]) obj;
				
//				System.out.println("Id : "+arr[0].toString()+"\nName : "+arr[1].toString()+"\nEmail : "+arr[2].toString()+"\nMobile : "+arr[3].toString());
				
				eb.setId(arr[0].toString());				
				eb.setName(arr[1].toString());
				eb.setEmail(arr[2].toString());
				eb.setMobile(arr[3].toString());
				
				
				empBean.add(eb);
			}
//			System.out.println("Single user : "+empBean);
			return empBean;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
//	public EmployeeBean getUser(Integer id) {
//		try {
//			Session session = sf.getCurrentSession();
//			String query = "select id,name,email,mobile where id="+id;
//			SQLQuery query2 = session.createSQLQuery(query);
//			List list = query2.list();
//			EmployeeBean eb = new EmployeeBean();
//			for(Object obj : list) {
//				Object arr[]= (Object[]) obj;
////				eb.setId(arr[0].toString());
////				eb.setEmail(arr[1].toString());
////				eb.setMobile(arr[2].toString());
////				eb.setName(arr[3].toString());
//				System.out.println(arr[0].toString());
//				System.out.println(arr[1].toString());
//				System.out.println(arr[2].toString());
//				System.out.println(arr[3].toString());
//			}
//			System.out.println("inside dao"+eb);
//			return eb;
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

//	public List<EmployeeBean> getUsersList() {
//		
//		Session s = sf.getCurrentSession();
//		List<EmployeeBean> empBean = new ArrayList<EmployeeBean>();
//		
//		String query = "select * from employee";
//		SQLQuery query2 = s.createSQLQuery(query);
//		List tempList = query2.list();
//		
//		for(Object obj:tempList) {
//			EmployeeBean eb = new EmployeeBean();
//			Object[] arr = (Object[]) obj;
//			
//			eb.setId(arr[0].toString());
//			eb.setName(arr[1].toString());
//			eb.setMobile(arr[2].toString());
//			eb.setEmail(arr[2].toString());
//			eb.setPassword(arr[2].toString());
//			
//			empBean.add(eb);
//		}
////		System.out.println(query+":- "+empBean);
//		return empBean;
//	}

	public boolean updateUser(EditEmpBean editEmpBean) {
		Session session = sf.getCurrentSession();
		String query = "update employee set name='" + editEmpBean.getName() + "', email='" + editEmpBean.getEmail()
				+ "', mobile='" + editEmpBean.getMobile() + "'  where id='" + editEmpBean.getId()+"' ";
		
//		String query = "update employee set name= '"+ editEmpBean.getName() + "', email='" + editEmpBean.getEmail()
//		+ "', mobile='" + editEmpBean.getMobile() + "'  where id='" + editEmpBean.getId()+"' ";
		
		try {
			SQLQuery query2 = session.createSQLQuery(query);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public void deleteUser(Integer id) {
		Session session = sf.getCurrentSession();

		String query = "delete from employee where id=" + id;
		SQLQuery query2 = session.createSQLQuery(query);
		query2.executeUpdate();

	}

	public List<EmployeeBean> getUsersList() {
		try {
			Session session = sf.getCurrentSession();
			List<EmployeeBean> emps = new ArrayList<EmployeeBean>();

			String query = "select * from employee";
			SQLQuery query2 = session.createSQLQuery(query);
			List list = query2.list();

			for (Object obj : list) {
				EmployeeBean empBean = new EmployeeBean();
				Object[] arr = (Object[]) obj;
//				System.out.println(arr[0].toString()+" ");
//				System.out.println(arr[1].toString()+" ");
//				System.out.println(arr[2].toString()+" ");

				empBean.setId(arr[0].toString());
				empBean.setEmail(arr[1].toString());
				empBean.setMobile(arr[2].toString());
				empBean.setName(arr[3].toString());

				emps.add(empBean);
			}
			return emps;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
