package com.zzc.intern.service;

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
	//添加一条宿舍信息
    ResponseUtil<Integer> insert(JobInfo jobInfo);
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
}
