package com.zzc.intern.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.service.LearnInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 学习内容 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Controller
<<<<<<< HEAD
@Api(value = "学习内容管理", tags = "学习内容管理", description="学习内容管理")
@RequestMapping("learn")
=======
@Api(value = "", tags = "", description="")
>>>>>>> branch 'master' of https://github.com/dfj521/intern
public class LearnInfoController {
<<<<<<< HEAD
	
	@Resource
	private LearnInfoService learnInfoService;
	
	/*
	 * @GetMapping("/findAllLearn")
	 * 
	 * @ResponseBody
	 * 
	 * @ApiOperation("查询所有学习内容") public List<LearnInfo> findAllLearn() { return
	 * learnInfoService.findAllLearn(); }
	 * 
	 * @GetMapping("/findById")
	 * 
	 * @ResponseBody
	 * 
	 * @ApiOperation("根据学习id查询所有学习内容") public LearnInfo findById(int id) { return
	 * learnInfoService.findById(id); }
	 * 
	 * @PostMapping("/updateLearn")
	 * 
	 * @ResponseBody
	 * 
	 * @ApiOperation("修改学习内容") public int updateLearn(LearnInfo learnInfo) { return
	 * learnInfoService.updateLearn(learnInfo); }
	 * 
	 * @PostMapping("/addLearn")
	 * 
	 * @ResponseBody
	 * 
	 * @ApiOperation("添加学习内容") public int addLearn(LearnInfo learnInfo) { return
	 * learnInfoService.addLearn(learnInfo); }
	 */
=======

>>>>>>> branch 'master' of https://github.com/dfj521/intern
}
