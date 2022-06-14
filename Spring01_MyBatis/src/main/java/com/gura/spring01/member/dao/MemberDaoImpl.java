package com.gura.spring01.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring01.member.dto.MemberDto;

// component scan을 통해서 bean이 될 수 있도록 적당한 어노테이션 붙이기
@Repository
public class MemberDaoImpl implements MemberDao {

	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<MemberDto> getList() {
		/*
		 *  mapper 의 namespace : member
		 *	sql id : getList
		 *  resultType : MemberDto   
		 */
		
		List<MemberDto> list = session.selectList("member.getList");
		
		return list;
	}

	@Override
	public MemberDto getData(int num) {
		/*
		 *  mapper 의 namespace : member
		 *	sql id : getData
		 *  resultType : MemberDto
		 *  parameterType : int
		 */
		
		MemberDto dto = session.selectOne("member.getData", num);
		
		return dto;
	}

	@Override
	public void insert(MemberDto dto) {
		/*
		 *  mapper 의 namespace : member
		 *  sql id : insert
		 *  parameterType : MemberDto
		 */
		
		session.insert("member.insert", dto);
		
	}

	@Override
	public void update(MemberDto dto) {
		/*
		 *  mapper 의 namespace : member
		 *  sql id : update
		 *  parameterType : MemberDto
		 */
		
		session.update("member.update", dto);
	}

	@Override
	public void delete(int num) {
		/*
		 *  mapper 의 namespace : member
		 *  sql id : delete
		 *  parameterType : int
		 */
		
		session.delete("member.delete", num);
	}

}
