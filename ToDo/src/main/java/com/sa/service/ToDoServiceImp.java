package com.sa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.bean.EditToDoBean;
import com.sa.bean.ToDoBean;
import com.sa.dao.ToDoDao;

@Service
public class ToDoServiceImp implements ToDoService {

	@Autowired
	private ToDoDao toDao;
	
	public boolean saveToDo(ToDoBean toDoBean) {
		// TODO Auto-generated method stub
		return toDao.saveToDo(toDoBean);
	}

	public List<ToDoBean> getToDoById(Integer id) {
		// TODO Auto-generated method stub
		return toDao.getToDoById(id);
	}

	public boolean deleteToDo(Integer id) {
		// TODO Auto-generated method stub
		return toDao.deleteToDo(id);
	}

	public boolean updateToDo(EditToDoBean editToDoBean) {
		// TODO Auto-generated method stub
		return toDao.updateToDo(editToDoBean);
	}

	public List<ToDoBean> getAllToDo() {
		// TODO Auto-generated method stub
		return toDao.getAllToDo();
	}

}
