package com.tyyd.hadoop.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyyd.hadoop.service.DataOperateService;

@RestController
@RequestMapping("/hiveOp")
public class HiveOpController {
		
	@Autowired
	private DataOperateService dataOpService;
	
	@GetMapping("initData")
	public void initData(){
		dataOpService.initUserData();
	}
	
	@GetMapping("say")
	public String say(){
		return "i'am sevin";
	}
}
