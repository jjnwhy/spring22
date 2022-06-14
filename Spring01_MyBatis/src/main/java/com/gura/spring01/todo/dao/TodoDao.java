package com.gura.spring01.todo.dao;

import java.util.List;

import com.gura.spring01.todo.dto.TodoDto;

public interface TodoDao {
	public List<TodoDto> getList();
	public TodoDto getData(int num);
	public void insert(TodoDto dto);
	public void update(TodoDto dto);
	public void delete(int num);
}
