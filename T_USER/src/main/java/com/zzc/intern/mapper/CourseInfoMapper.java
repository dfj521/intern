package com.zzc.intern.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzc.intern.entity.CourseInfo;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * <p>
课程信息 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface CourseInfoMapper extends BaseMapper<CourseInfo> {
	
	/**
	 * 分页查询所有课程信息
	 * @param page 页数
	 * @param size 一页总数
	 * @return 课程信息
	 */
	List<CourseInfo> findCourse(Integer page,Integer size);
	/**
	 * 根据课程id查询课程
	 * @param courseId 课程id
	 * @return 课程对象
	 */
	CourseInfo findCourseById(Integer courseId);
	/**
	 * 添加课程
	 * @param courseInfo 课程信息
	 * @return
	 */
	int addCourse(CourseInfo  courseInfo);
	/**
	 * 修改课程信息
	 * @param courseInfo 课程信息
	 * @return
	 */
	int updateCourse(CourseInfo  courseInfo);
	/**
	 * 删除课程信息
	 * @param courseId 课程id
	 * @return
	 */
	int delCourse(Integer courseId);
}
