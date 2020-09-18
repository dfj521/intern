package com.zzc.intern.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.mapper.LearnInfoMapper;
import com.zzc.intern.service.LearnInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.annotation.Resource;

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
@Api(value = "", tags = "", description="")
@RequestMapping("learn")
public class LearnInfoController {
	
	@Resource
	private LearnInfoService learnInfoService;
	
	@RequestMapping("/findAllLearn")
	@ResponseBody
	public List<LearnInfo> findAllLearn() {
		return learnInfoService.findAllLearn();
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public LearnInfo findById(int id) {
		return learnInfoService.findById(id);
	}
	@RequestMapping("/updateLearn")
	@ResponseBody
	public int updateLearn(LearnInfo learnInfo) {
		return learnInfoService.updateLearn(learnInfo);
	}
	@RequestMapping("/addLearn")
	@ResponseBody
	public int addLearn(LearnInfo learnInfo) {
		return learnInfoService.addLearn(learnInfo);
	}
}
