package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.CommentsVO;

public interface CommentDAO {
	public List<HashMap<String, Object>> list(int postid, int page, int size, String uid);
	public int total(int postid);
	public void insert(CommentsVO vo);
	public void update(CommentsVO vo);
	public void delete(int id);
	public void favorite_insert(CommentsVO vo);
	public void favorite_delete(CommentsVO vo);
}
