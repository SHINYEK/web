package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.ReviewVO;

@Repository
public class BookDAOImpl implements BookDAO{
@Autowired
SqlSession session;
String namespace="com.example.mapper.BookMapper";

@Override
public List<HashMap<String, Object>> list(int page, int size, String uid, String query) {
	HashMap<String,Object> map = new HashMap<>();
	map.put("start", (page-1)*size);	
	map.put("size", size);
	map.put("uid", uid);
	map.put("query",query);
	return session.selectList(namespace+".list",map);
}

@Override
public void favorite_insert(ReviewVO vo) {
	session.insert(namespace+".favorite_insert",vo);
	
}

@Override
public void favorite_delete(ReviewVO vo) {
	session.delete(namespace+".favorite_delete",vo);
	
}

@Override
public int total(String query) {	
	return session.selectOne(namespace+".total",query);
}

@Override
public HashMap<String, Object> read(int code, String uid) {
	HashMap<String ,Object> map = new HashMap<>();
	map.put("code", code);
	map.put("uid", uid);
	return session.selectOne(namespace+".read",map);
}

@Override
public void update_viewcnt(int code) {
	session.update(namespace+".update_viewcnt",code);
	
}

}
