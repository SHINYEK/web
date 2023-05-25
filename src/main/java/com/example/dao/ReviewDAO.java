package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.ReviewVO;

public interface ReviewDAO {
	public List<HashMap<String,Object>> list(int code, int page, int size, String uid);
	public int total(int code);
	public void update(ReviewVO vo);
	public void insert(ReviewVO vo);
	public void delete(int id);
	public void finsert(ReviewVO vo);
	public void fdelete(ReviewVO vo);
}
