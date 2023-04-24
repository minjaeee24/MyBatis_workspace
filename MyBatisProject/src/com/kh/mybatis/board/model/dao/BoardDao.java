package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectListCount");
		
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		
		// sqlSession.selectList("boardMapper.selectList", pi);
		
		// 마이바티스에서는 페이징처리를 위해 RowBounds라는 클래스를 제공한다.
		
		// * offset : 몇 개의 게시글을 건너뛰고 조회할것인지에 대한 값을 설정할 수 있음
		/*
		 * ex) boardLimit가 5인 경우
		 * 									offset(건너뛸 숫자)		limit(조회할 숫자)
		 * 	currentPage : 1 => 1 ~ 5					0						5
		 * 	currentPage : 2 => 6 ~ 10					5						5
		 * 	currentPage : 3 => 11 ~ 15					10						5
		 * 			
		 */
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		// RowBounds객체를 넘겨줘야하는 경우, selectList함수의 오버로딩된 메소드 중 매개변수가 3개인 베소드를 사용해야함.
		// 딱히 두 번째 자리에 파라미터로 넘길 값이 없더라도 null값이라도 넘겨줘야한다.
		
		return (ArrayList) sqlSession.selectList("boardMapper.selectList", null, rowBounds);
		
	}
}
