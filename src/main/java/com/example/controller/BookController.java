package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.dao.BookDAO;
import com.example.domain.ReviewVO;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookDAO dao;
	
	@RequestMapping("/list")
	public List<HashMap<String,Object>>list(int page, int size, String uid, String query){
		 return dao.list(page, size,uid, query);
	}
	
	@RequestMapping("/total")
	public int total(String query){
		 return dao.total(query);
	}
	@RequestMapping("/read")
	public HashMap<String,Object> read(int code,String uid){
		return dao.read(code,uid);
	}
	
	@RequestMapping("/update/viewcnt")
	public void update_viewcnt(int code){
		dao.update_viewcnt(code);
	}
	
	@RequestMapping(value="/favorite/insert",method=RequestMethod.POST)
	public void favorite_insert(@RequestBody ReviewVO vo){
		dao.favorite_insert(vo);
	}
	
	@RequestMapping(value="/favorite/delete",method=RequestMethod.POST)
	public void favorite_delete(@RequestBody ReviewVO vo){
		dao.favorite_delete(vo);
	}
}
