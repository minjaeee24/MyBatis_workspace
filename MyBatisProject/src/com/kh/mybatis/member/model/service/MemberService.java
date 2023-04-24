package com.kh.mybatis.member.model.service;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();
	
	public Member loginMember(Member m) {
		// connection객체 반환
//		HashMap<String, Object> ss = new HashMap();
//		ss.put(key, value)
//		ss.put(key, value)
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = memberDao.loginMember(sqlSession, m);
		
		// connection객체 종료
		sqlSession.close();
	
		return loginUser;
	}
	
	public int insertMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession();

		int result = memberDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;

	}
}
