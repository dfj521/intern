package com.zzc.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzc.intern.entity.CourseInfo;
import com.zzc.intern.service.CourseInfoService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import javax.annotation.Resource;

/**
 * <p>
 * 课程信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Controller
@Api(value = "课程管理", tags = "课程管理", description = "课程管理")
@RequestMapping("course")
public class CourseInfoController {

	@Resource
	private CourseInfoService courseInfoService;

	@ApiOperation("查询所有考核并根据条件查询")
	@GetMapping("/findCourse")
	@ResponseBody
	public List<CourseInfo> findCourse(
			@ApiParam(name = "page", value = "页数", required = true) @RequestParam("page") Integer page,
			@ApiParam(name = "size", value = "数量", required = true) @RequestParam("size") Integer size) {
		return courseInfoService.findCourse(page, size);
	}

	@ApiOperation("根据课程id查询课程信息")
	@GetMapping("/findCourseById")
	@ResponseBody
	public CourseInfo findCourseById(
			@ApiParam(name = "courseId", value = "课程id", required = true) @RequestParam("courseId") Integer courseId) {
		return courseInfoService.findCourseById(courseId);
	}

	@ApiOperation("添加课程信息")
	@PostMapping("/addCourse")
	@ResponseBody
	public int addCourse(
			@ApiParam(name = "courseName", value = "课程名字", required = true) @RequestParam("courseName") String courseName) {
		return courseInfoService.addCourse(courseName);
	}

	@ApiOperation("修改课程信息")
	@PostMapping("/updateCourse")
	@ResponseBody
	public ResponseUtil<Integer> updateCourse(
			@ApiParam(name = "courseId", value = "课程id", required = true) @RequestParam("courseId") Integer courseId,
			@ApiParam(name = "courseName", value = "课程名字", required = true) @RequestParam("courseName") String courseName) {
		return courseInfoService.updateCourse(courseName,courseId);
	}

	@ApiOperation("删除课程信息")
	@PostMapping("/delCourse")
	@ResponseBody
	public int delCourse(
			@ApiParam(name = "courseId", value = "课程id", required = true) @RequestParam("courseId") Integer courseId) {
		return courseInfoService.delCourse(courseId);
	}
}
