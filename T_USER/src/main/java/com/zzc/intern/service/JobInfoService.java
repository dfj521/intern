package com.zzc.intern.service;

import com.zzc.intern.DTO.JobInfoDTO;
import com.zzc.intern.entity.JobInfo;
import com.zzc.intern.entity.ResourceInfo;
import com.zzc.intern.util.ResponseUtil;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 岗位信息 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface JobInfoService extends IService<JobInfo> {
	//添加一条岗位信息
    ResponseUtil<Integer> insert(Integer Id,String jName);
		//查询所有岗位信息
	ResponseUtil<List<JobInfo>> findAll();
		//根据id查询岗位信息
	 ResponseUtil<JobInfo>  findById(Integer jid);
		//根据岗位名字查询岗位信息
	 ResponseUtil<List<JobInfo>>findByName(String jname);
		//修改岗位信息
	ResponseUtil<Integer> updateId(JobInfo jobInfo);
	//删除岗位信息
	ResponseUtil<Integer> deleteId(Integer jid);
	//根据岗位id查询学生姓名
	ResponseUtil<List<JobInfoDTO>> findId(Integer jId);
	//根据岗位id查询学习内容
	ResponseUtil<List<JobInfoDTO>> findGId(Integer jId);
	//根据岗位名称模糊查询岗位信息和学生信息
	ResponseUtil<List<JobInfoDTO>> selectId(String jName);
	//根据岗位名称模糊查询岗位信息和学习内容
	ResponseUtil<List<JobInfoDTO>> selectGId(String jName);
	//根据岗位id和考试阶段查询考试成绩,岗位信息,考试成绩,考试阶段
	ResponseUtil<List<JobInfoDTO>> selectJId(Integer jId,String lStage);
}
