package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.ReviewMapper";
	
	@Override
	public List<HashMap<String, Object>> list(int code, int page, int size, String uid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("start", (page - 1) * size);
		map.put("size", size);
		map.put("uid", uid);
		return session.selectList(namespace+".list",map);
	}

	@Override
	public int total(int code) {
		return session.selectOne(namespace+".total",code);
	}

	@Override
	public void update(ReviewVO vo) {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void insert(ReviewVO vo) {
		session.update(namespace+".insert",vo);
		
	}

	@Override
	public void delete(int id) {
		session.delete(namespace+".delete",id);
		
	}

	@Override
	public void finsert(ReviewVO vo) {
		session.insert(namespace+".finsert",vo);
		
	}

	@Override
	public void fdelete(ReviewVO vo) {
		session.delete(namespace+".fdelete",vo);
		
	}

}
