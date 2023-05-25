package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PostDAO;
import com.example.domain.PostVO;

//레스트 컨트롤러를 사용해서 서버 관리하는걸 restapi라고 함
@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostDAO dao;
	
	@RequestMapping("/total")
	public int total(){
		return dao.total();
	}
	
	@RequestMapping("/read")
	public HashMap<String,Object> read(int id){
		return dao.read(id);
	}
	
	@RequestMapping("/update/viewcnt")
	public void update_viewcnt(int id){
		dao.update_viewcnt(id);
	}
	
	@RequestMapping("/list.json")
	public List<HashMap<String,Object>> list(int page, int size){
		return dao.list(page, size);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insert(@RequestBody PostVO vo){
		dao.insert(vo);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(@RequestBody PostVO vo){
		dao.update(vo);
	}
	
	@RequestMapping("/delete")
	public void delete(int id){
		dao.delete(id);
	}
	
}
