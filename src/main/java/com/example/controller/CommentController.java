package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CommentDAO;
import com.example.domain.CommentsVO;

@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	CommentDAO dao;

	@RequestMapping("/list.json")
	public List<HashMap<String, Object>> list(int postid, int page, int size, String uid) {
		return dao.list(postid, page, size, uid);
	}

	@RequestMapping("/total")
	public int total(int postid) {
		return dao.total(postid);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody CommentsVO vo) {
		dao.insert(vo);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestBody CommentsVO vo) {
		dao.update(vo);
	}

	@RequestMapping(value = "/delete")
	public void delete(int id) {
		dao.delete(id);
	}

	@RequestMapping(value = "/favorite/insert", method = RequestMethod.POST)
	public void favorite_insert(@RequestBody CommentsVO vo) {
		dao.favorite_insert(vo);
	}
	@RequestMapping(value = "/favorite/delete", method = RequestMethod.POST)
	public void favorite_delete(@RequestBody CommentsVO vo) {
		dao.favorite_delete(vo);
	}
}
