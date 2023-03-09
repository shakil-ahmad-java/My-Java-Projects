package com.sa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sa.bean.EditToDoBean;
import com.sa.bean.ToDoBean;
import com.sa.model.ToDo;

@Repository
@Transactional
public class ToDoDaoImp implements ToDoDao {
	@Autowired
	private SessionFactory sf;

	public boolean saveToDo(ToDoBean toDoBean) {

		try {
			Session session = sf.getCurrentSession();
			ToDo todo = new ToDo();
			todo.setTitle(toDoBean.getTitle());
			todo.setDescription(toDoBean.getDescription());
			session.save(todo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("deprecation")
	public List<ToDoBean> getToDoById(Integer id) {
		Session session = sf.getCurrentSession();
		List<ToDoBean> list = new ArrayList<ToDoBean>();
		String query = "select id, title, description from todotask where id=" + id;
		@SuppressWarnings("rawtypes")
		SQLQuery query2 = session.createSQLQuery(query);
		List list2 = query2.list();
		for (Object obj : list2) {
			ToDoBean tdb = new ToDoBean();
			Object arr[] = (Object[]) obj;
//			System.out.println("Title : "+arr[0]+"\nTitle : "+arr[1]);
			tdb.setId((Integer) arr[0]);
			tdb.setTitle(arr[1].toString());
			tdb.setDescription(arr[2].toString());
			list.add(tdb);
		}
		return list;
	}

	public boolean deleteToDo(Integer id) {

		try {
			Session s = sf.getCurrentSession();
			String query = "delete from todotask where id=" + id;
			SQLQuery query2 = s.createSQLQuery(query);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateToDo(EditToDoBean editToDoBean) {
		Session s = sf.getCurrentSession();
		String query = "update todotask set title='"+editToDoBean.getTitle()
						+"', description='"+editToDoBean.getDescription()+"' where id='"+editToDoBean.getId()+"'";
		
		try {
			SQLQuery query2 = s.createSQLQuery(query);
			query2.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
//		ToDo todo = new ToDo();
//		todo.setTitle(editToDoBean.getTitle());
//		todo.setDescription(editToDoBean.getDescription());
//		s.saveOrUpdate(todo);
		
	}

	public List<ToDoBean> getAllToDo() {
		Session session = sf.getCurrentSession();
		List<ToDoBean> list = new ArrayList<ToDoBean>();
		String query = "select id, title, description from todotask";
		@SuppressWarnings("rawtypes")
		SQLQuery query2 = session.createSQLQuery(query);
		List list2 = query2.list();
		for (Object obj : list2) {
			ToDoBean tdb = new ToDoBean();
			Object arr[] = (Object[]) obj;
			tdb.setId((Integer) arr[0]);
			tdb.setTitle(arr[1].toString());
			tdb.setDescription(arr[2].toString());
			list.add(tdb);
		}
		return list;
	}

}
