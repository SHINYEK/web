package com.example.controller;

import java.io.File;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDAO dao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public int login(@RequestBody UserVO vo) {
		int result = 0;
		HashMap<String, Object> map = dao.read(vo.getUid());
		if (map != null) {
			if (map.get("upass").equals(vo.getUpass())) {
				result = 1;
			} else {
				result = 2;
			}
		}
		return result;
	}

	@RequestMapping("/read")
	public HashMap<String, Object> read(String uid) {
		return dao.read(uid);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(UserVO vo, MultipartHttpServletRequest multi) {
		try {
			if (multi.getFile("file") != null) {
				MultipartFile file = multi.getFile("file");
				// 파일업로드(있는경우)
				String path = "c:/images/photos/";
				String fileName = System.currentTimeMillis() + ".jpg";
				file.transferTo(new File(path + fileName));
				vo.setPhoto(fileName);
			}
			dao.update(vo);
		} catch (Exception e) {
			System.out.println("정보수정오류" + e.toString());
		}
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(UserVO vo, MultipartHttpServletRequest multi) {
		try {
			if (multi.getFile("file") != null) {
				MultipartFile file = multi.getFile("file");
				// 파일업로드(있는경우)
				String path = "c:/images/photos/";
				String fileName = System.currentTimeMillis() + ".jpg";
				file.transferTo(new File(path + fileName));
				vo.setPhoto(fileName);
			}
			dao.insert(vo);
		} catch (Exception e) {
			System.out.println("정보입력오류" + e.toString());
		}
	}

}
