package com.zzc.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.service.LearnInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import javax.annotation.Resource;

/**
 * 学习内容 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Controller
@Api(value = "学习内容管理", tags = "学习内容管理", description = "学习内容管理")
@RequestMapping("learn")
public class LearnInfoController {

	@Resource
	private LearnInfoService learnInfoService;

	@GetMapping("/findAllLearn")
	@ResponseBody
	@ApiOperation("查询所有学习内容")
	public List<LearnInfo> findAllLearn(
			@ApiParam(name = "page", value = "页数", required = true) @RequestParam("page") Integer page,
			@ApiParam(name = "size", value = "数量", required = true) @RequestParam("size") Integer size) {

		return learnInfoService.findAllLearn(page, size);
	}

	@GetMapping("/findById")
	@ResponseBody
	@ApiOperation("根据学习id查询所有学习内容")
	public LearnInfo findById(
			@ApiParam(name = "learnId", value = "学习内容id", required = true) @RequestParam("learnId") Integer learnId) {
		return learnInfoService.findByid(learnId);
	}

	@GetMapping("/findByCourseId")
	@ResponseBody
	@ApiOperation("根据岗位id查询所有学习内容")
	public List<LearnInfo> findByCourseId(
			@ApiParam(name = "courseId", value = "岗位id", required = true) @RequestParam("courseId") Integer courseId) {
		// TODO Auto-generated method stub
		return learnInfoService.findByCourseId(courseId);
	}

	@PostMapping("/updateLearn")
	@ResponseBody
	@ApiOperation("修改学习内容")
	public int updateLearn(
			@ApiParam(name = "learnId", value = "学习内容id", required = true) @RequestParam("learnId") Integer learnId,
			@ApiParam(name = "learnElementary", value = "学习内容", required = true) @RequestParam("learnElementary") String learnElementary,
			@ApiParam(name = "learnStage", value = "学习内容阶段", required = true) @RequestParam("learnStage") Integer learnStage,
			@ApiParam(name = "courseId", value = "岗位id", required = true) @RequestParam("courseId") Integer courseId) {
		return learnInfoService.updateLearn(learnId, learnElementary, learnStage,courseId);
	}

	@PostMapping("/addLearn")
	@ResponseBody
	@ApiOperation("添加学习内容")
	public int addLearn(
			@ApiParam(name = "learnElementary", value = "学习内容", required = true) @RequestParam("learnElementary") String learnElementary,
			@ApiParam(name = "learnStage", value = "学习内容阶段", required = true) @RequestParam("learnStage") Integer learnStage,
			@ApiParam(name = "courseId", value = "岗位id", required = true) @RequestParam("courseId") Integer courseId) {
		return learnInfoService.addLearn(learnElementary, courseId, learnStage);
	}

	@PostMapping("/delLearn")
	@ResponseBody
	@ApiOperation("删除学习内容")
	public int delLearn(
			@ApiParam(name = "learnId", value = "学习内容id", required = true) @RequestParam("learnId") Integer learnId) {
		return learnInfoService.delLearn(learnId);

	}

}
