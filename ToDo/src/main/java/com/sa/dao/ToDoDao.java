package com.sa.dao;

import java.util.List;

import com.sa.bean.EditToDoBean;
import com.sa.bean.ToDoBean;

public interface ToDoDao {
	
	public boolean saveToDo(ToDoBean toDoBean);
	public List<ToDoBean> getToDoById(Integer id);
	public boolean deleteToDo(Integer id);
	public boolean updateToDo(EditToDoBean editToDoBean);
	public List<ToDoBean> getAllToDo();
}
