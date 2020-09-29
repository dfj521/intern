package com.zzc.intern.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.entity.CourseInfo;
import com.zzc.intern.mapper.CourseInfoMapper;
import com.zzc.intern.mapper.LearnInfoMapper;
import com.zzc.intern.service.CourseInfoService;
import com.zzc.intern.util.ResponseUtil;

/**
 * <p>
 * 课程信息 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Service
@Transactional
public class CourseInfoServiceImpl extends ServiceImpl<CourseInfoMapper, CourseInfo> implements CourseInfoService {

	@Resource
	private CourseInfoMapper courseInfoMapper;
	
	@Resource
	private LearnInfoMapper learnInfoMapper;

	@Override
	public List<CourseInfo> findCourse(Integer page, Integer size) {
		page=(page-1)*size;
		return courseInfoMapper.findCourse(page, size);
	}

	@Override
	public CourseInfo findCourseById(Integer courseId) {
		return courseInfoMapper.findCourseById(courseId);
	}

	@Override
	public int addCourse(String courseName) {
		CourseInfo courseInfo=new CourseInfo();
		courseInfo.setCourseName(courseName);
		return courseInfoMapper.addCourse(courseInfo);
	}

	@Override
	public ResponseUtil<Integer> updateCourse(String courseName,Integer courseId) {
		ResponseUtil<Integer> responseUtil=new ResponseUtil<Integer>();
		if (StringUtils.isEmpty(learnInfoMapper.findByCourseId(courseId))) {
			CourseInfo courseInfo=new CourseInfo();
			courseInfo.setCourseName(courseName);
			courseInfo.setCourseId(courseId);
			courseInfoMapper.updateCourse(courseInfo);
			responseUtil.setCode(1);
			responseUtil.setMessage("修改成功");
		}
		responseUtil.setCode(2);
		responseUtil.setMessage("该课程有对应的学习内容，不可以修改！");
		return responseUtil;
	}

	@Override
	public int delCourse(Integer courseId) {
		return courseInfoMapper.delCourse(courseId);
	}

}
