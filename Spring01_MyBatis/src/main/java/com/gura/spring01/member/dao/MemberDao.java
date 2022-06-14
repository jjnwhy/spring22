package com.gura.spring01.member.dao;

import com.gura.spring01.member.dto.MemberDto;

import java.util.List;
/*
 *  MemberDaoImpl 클래스가 구현할 인터페이스를 미리 만들어 놓기
 */
public interface MemberDao {
	public List<MemberDto> getList();
	public MemberDto getData(int num);
	public void insert(MemberDto dto);
	public void update(MemberDto dto);
	public void delete(int num);
}
