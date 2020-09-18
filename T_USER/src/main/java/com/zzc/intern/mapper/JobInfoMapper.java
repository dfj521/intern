package com.zzc.intern.mapper;

import com.zzc.intern.entity.JobInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * 岗位信息 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface JobInfoMapper extends BaseMapper<JobInfo> {
	//添加一条宿舍信息
    int insert(JobInfo jobInfo);
		//查询所有岗位信息
	List<JobInfo> findAll();
		//根据id查询岗位信息
	JobInfo findById(Integer jid);
		//根据岗位名字查询岗位信息
	List<JobInfo > findByName(String jname);
		//修改岗位信息
	int updateId(JobInfo jobInfo);
	//删除岗位信息
	int deleteId(Integer jid);
}
