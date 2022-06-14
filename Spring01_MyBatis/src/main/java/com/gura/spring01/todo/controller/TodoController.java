package com.gura.spring01.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring01.todo.dao.TodoDao;
import com.gura.spring01.todo.dto.TodoDto;

@Controller
public class TodoController {
	
	// 핵심 의존 객체 주입 받기
	@Autowired
	private TodoDao dao;
	
	
	
	@RequestMapping("/todo/delete")
	public String delete(int num) {
		dao.delete(num);
		
		return "redirect:/todo/list.do";
	}
	
	@RequestMapping("/todo/update")
	public String update(TodoDto dto) {
		dao.update(dto);
		return "todo/update";
	}
	
	@RequestMapping("/todo/updateform")
	public String updateform(int num, HttpServletRequest request) {
		
		// 수정할 회원의 정보 불러오기
		TodoDto dto = dao.getData(num);
		
		request.setAttribute("dto", dto);
		
		return "todo/updateform";
	}
	
	@RequestMapping("/todo/insert")
	public String insert(TodoDto dto) {
		dao.insert(dto);
		
		return "todo/insert";
	}
	
	@RequestMapping("/todo/insertform")
	public String insertform() {
		return "todo/insertform";
	}
	
	@RequestMapping("/todo/list")
	public ModelAndView list(ModelAndView mView) {
		
		// 응답에 필요한 Model(데이터)
		List<TodoDto> list = dao.getList();
		
		// ModelAndView 객체에 model과 view page 정보를 담고
		mView.addObject("list", list);
		mView.setViewName("todo/list");
		
		return mView;
	}
}
