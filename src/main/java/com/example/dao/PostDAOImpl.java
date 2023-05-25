package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.PostVO;

@Repository
public class PostDAOImpl implements PostDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.PostMapper";

	@Override
	public List<HashMap<String, Object>> list(int page, int size) {
		HashMap<String,Object>map = new HashMap<>();
		map.put("start", (page-1)*size);
		map.put("size", size);
		return session.selectList(namespace+".list",map);
	}

	@Override
	public void insert(PostVO vo) {
		session.insert(namespace+".insert",vo);
		
	}

	@Override
	public void update(PostVO vo) {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void delete(int id) {
		session.delete(namespace+".delete",id);
		
	}

	@Override
	public HashMap<String, Object> read(int id) {		
		return session.selectOne(namespace+".read",id);
	}

	@Override
	public int total() {		
		return session.selectOne(namespace+".total");
	}

	@Override
	public void update_viewcnt(int id) {
		session.update(namespace+".update_viewcnt",id);
		
	}

}
