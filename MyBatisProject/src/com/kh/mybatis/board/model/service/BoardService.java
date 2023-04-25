package com.kh.mybatis.board.model.service;

import static com.kh.mybatis.common.template.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardService {
	
	private BoardDao boardDao = new BoardDao();
	
	public int selectListCount() {
		
		SqlSession sqlSession = getSqlSession();
		
		int listCount = boardDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
		
	}
	
	public ArrayList<Board> selectList(PageInfo pi) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
		
	}
	
	public int increaseCount(int bno) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = boardDao.increaseCount(sqlSession, bno);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	
	}
	
	public Board selectBoard(int bno) {
		
		SqlSession sqlSession = getSqlSession();
		
		Board b = boardDao.selectBoard(sqlSession, bno);
		
		sqlSession.close();
		
		return b;
	}
	
	public ArrayList<Reply> selectReplyList(int bno) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Reply> list = boardDao.selectReplyList(sqlSession, bno);
		
		sqlSession.close();
		
		return list;
	}
	
	public int insertReply(int bno, String content, String userNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = boardDao.insertReply(sqlSession, bno, content, userNo);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}
	
	public int selectSearchCount(HashMap<String, String> map) {
		
		SqlSession sqlSession = getSqlSession();
		
		int result = boardDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		
		return result;
	
	}
	
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = boardDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		
		return list;
	}
}
