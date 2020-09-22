package com.zzc.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.service.LearnInfoService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 学习内容 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Controller
@Api(value = "学习内容管理", tags = "学习内容管理", description = "学习内容管理")
@RequestMapping("learn")
public class LearnInfoController {

	@Resource
	private LearnInfoService learnInfoService;

	@GetMapping("/findAllLearn")
	@ResponseBody
	@ApiOperation("查询所有学习内容")
	public ResponseUtil<List<LearnInfo>> findAllLearn() {
		return learnInfoService.findAllLearn();
	}

	@GetMapping("/findById")
	@ResponseBody
	@ApiOperation("根据学习id查询所有学习内容")
	public ResponseUtil<LearnInfo> findById(
			@ApiParam(name = "id", value = "学习内容id", required = true) @RequestParam("id") Integer id) {
		return learnInfoService.findById(id);
	}

	@PostMapping("/updateLearn")
	@ResponseBody
	@ApiOperation("修改学习内容")
	public ResponseUtil<Integer> updateLearn(
			@ApiParam(name = "id", value = "学习内容id", required = true) @RequestParam("id") Integer id,
			@ApiParam(name = "lElementary", value = "学习内容", required = true) @RequestParam("lElementary") String lElementary,
			@ApiParam(name = "lStage", value = "学习内容级别", required = true) @RequestParam("lStage") Integer lStage) {
		return learnInfoService.updateLearn(id, lElementary, lStage);
	}

	@PostMapping("/addLearn")
	@ResponseBody
	@ApiOperation("添加学习内容")
	public ResponseUtil<Integer> addLearn(
			@ApiParam(name = "lElementary", value = "学习内容", required = true) @RequestParam("lElementary") String lElementary,
			@ApiParam(name = "lStage", value = "学习内容级别", required = true) @RequestParam("lStage") Integer lStage,
			@ApiParam(name = "id", value = "岗位id", required = true) @RequestParam("id") Integer id) {
		return learnInfoService.addLearn(id,lElementary, lStage);
	}
	@PostMapping("/delLearn")
	@ResponseBody
	@ApiOperation("删除学习内容")
	public ResponseUtil<Integer> delLearn(@ApiParam(name = "id", value = "学习内容id", required = true) @RequestParam("id") Integer id){
		return learnInfoService.delLearn(id);
		
	}

}
