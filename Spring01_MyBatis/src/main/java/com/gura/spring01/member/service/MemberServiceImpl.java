package com.gura.spring01.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring01.member.dao.MemberDao;
import com.gura.spring01.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	// 서비스는 주로 Dao에 의존한다.
	
	@Autowired
	private MemberDao dao;
	
	@Override
	public void addMember(MemberDto dto) {
		dao.insert(dto);
	}

	@Override
	public void updateMember(MemberDto dto) {
		dao.update(dto);
	}

	@Override
	public void deleteMember(int num) {
		dao.delete(num);
	}

	@Override
	public void getMember(int num, ModelAndView mView) {
		// 번호를 이용해서 회원 한명의 정보를 얻어와서
		MemberDto dto = dao.getData(num);
		// 메소드의 인자로 전달받은 ModelAndView 객체에 담아준다.
		mView.addObject("dto", dto);
	}

	@Override
	public void getListMember(ModelAndView mView) {
		// 회원 전체 목록을 얻어와서
		List<MemberDto> list = dao.getList();
		// 메소드의 인자로 전달받은 ModelAndView 객체에 담아준다.
		mView.addObject("list",list);
	}

}
