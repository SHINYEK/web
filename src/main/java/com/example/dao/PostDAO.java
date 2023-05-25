package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.PostVO;

public interface PostDAO {
	//모든 타입 들어간것이 object
	public List<HashMap<String,Object>>list(int page, int size);
	public HashMap<String,Object> read(int id);
	public void insert(PostVO vo);
	public void update(PostVO vo);
	public void delete(int id);
	public int total();
	public void update_viewcnt(int id);
}
