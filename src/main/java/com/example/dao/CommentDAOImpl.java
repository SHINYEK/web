package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.CommentsVO;

@Repository
public class CommentDAOImpl implements CommentDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.CommentMapper";

	@Override
	public List<HashMap<String, Object>> list(int postid, int page, int size, String uid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("postid", postid);
		map.put("start", (page-1)*size);
		map.put("size", size);
		map.put("uid", uid);
		return session.selectList(namespace+".list",map);
	}

	@Override
	public int total(int postid) {	
		return session.selectOne(namespace+".total",postid);
	}

	@Override
	public void insert(CommentsVO vo) {
		session.insert(namespace+".insert",vo);
		
	}

	@Override
	public void update(CommentsVO vo) {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void delete(int id) {
		session.delete(namespace+".delete",id);
		
	}

	@Override
	public void favorite_insert(CommentsVO vo) {
		session.insert(namespace+".favorite_insert",vo);
		
	}

	@Override
	public void favorite_delete(CommentsVO vo) {
		session.delete(namespace+".favorite_delete",vo);
		
	}

}
