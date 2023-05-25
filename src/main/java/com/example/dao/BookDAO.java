package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.ReviewVO;

public interface BookDAO {
	public List<HashMap<String,Object>> list(int page, int size, String uid, String query);
	public void favorite_insert(ReviewVO vo);
	public void favorite_delete(ReviewVO vo);
	public int total(String query);
	public HashMap<String,Object> read(int code, String uid);
	public void update_viewcnt(int code);
}
