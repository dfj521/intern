package com.zzc.intern.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.entity.CourseInfo;

/**
 * <p>
 * 课程信息 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface CourseInfoService extends IService<CourseInfo> {
	/**
	 * 分页查询所有课程信息
	 * 
	 * @param page 页数
	 * @param size 一页总数
	 * @return 课程信息
	 */
	List<CourseInfo> findCourse(Integer page, Integer size);

	/**
	 * 根据课程id查询课程
	 * 
	 * @param courseId 课程id
	 * @return 课程对象
	 */
	CourseInfo findCourseById(Integer courseId);

	/**
	 * 添加课程信息
	 * 
	 * @param courseInfo 课程信息
	 * @return
	 */
	int addCourse(String courseName);

	/**
	 * 修改课程信息
	 * 
	 * @param courseInfo 课程信息
	 * @return
	 */
	int updateCourse(String courseName,Integer courseId);

	/**
	 * 删除课程信息
	 * 
	 * @param courseId 课程id
	 * @return
	 */
	int delCourse(Integer courseId);

}
