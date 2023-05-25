package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ReviewDAO;
import com.example.domain.ReviewVO;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	ReviewDAO dao;
	
	@RequestMapping("/list.json")
	public List<HashMap<String,Object>> list(int code, int page, int size, String uid){
		return dao.list(code, page, size, uid);
	}
	
	@RequestMapping("/total")
	public int total(int code){
		return dao.total(code);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(@RequestBody ReviewVO vo){
		dao.insert(vo);
	}
	
	@RequestMapping(value="/finsert",method=RequestMethod.POST)
	public void finsert(@RequestBody ReviewVO vo){
		dao.finsert(vo);
	}
	
	@RequestMapping(value="/fdelete",method=RequestMethod.POST)
	public void fdelete(@RequestBody ReviewVO vo){
		dao.fdelete(vo);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(@RequestBody ReviewVO vo){
		dao.update(vo);
	}
	@RequestMapping("/delete")
	public void delete(int id){
		dao.delete(id);
	}
	
}
