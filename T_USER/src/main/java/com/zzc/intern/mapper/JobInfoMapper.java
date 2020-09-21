package com.zzc.intern.mapper;

import com.zzc.intern.DTO.JobInfoDTO;
import com.zzc.intern.entity.JobInfo;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.ApiOperation;

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
	 @ApiOperation("添加一条岗位信息")
    int insert(JobInfo jobInfo);
		//查询所有岗位信息
	 @ApiOperation("查询所有岗位")
	List<JobInfo> findAll();
		//根据id查询岗位信息
	  @ApiOperation("根据id查询岗位信息")
	JobInfo findById(Integer jid);
		//根据岗位名字查询岗位信息
	  @ApiOperation("根据jName模糊查询")
	List<JobInfo > findByName(String jname);
		//修改岗位信息
	  @ApiOperation("更改一条岗位信息")
	int updateId(JobInfo jobInfo);
	//删除岗位信息
	  @ApiOperation("更改一条岗位信息")
	int deleteId(Integer jid);
	//根据岗位id查询学生姓名
	  @ApiOperation("根据岗位id查询学生姓名")
	List<JobInfoDTO> findId(Integer jId);
	//根据岗位id查询学生内容
	  @ApiOperation("根据岗位id查询学习内容")
	List<JobInfoDTO> findGId(Integer jId);
	//根据岗位名称模糊查询岗位信息和实习生信息
	  @ApiOperation("根据岗位名称模糊查询岗位信息和实习生信息")
	List<JobInfoDTO> selectId(String jName);
	//根据岗位名称模糊查询岗位信息和学习内容
	  @ApiOperation("根据岗位名称模糊查询岗位信息和学习内容")
	List<JobInfoDTO> selectGId(String jName);
}
