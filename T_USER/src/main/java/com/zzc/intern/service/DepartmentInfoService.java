package com.zzc.intern.service;

import com.zzc.intern.DTO.DepartmentInfoDTO;
import com.zzc.intern.entity.DepartmentInfo;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门信息 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface DepartmentInfoService extends IService<DepartmentInfo> {
	@ApiOperation("查询所有部门信息")
	ResponseUtil<List<DepartmentInfo>>  findAll();

	@ApiOperation("根据id查询部门信息")
	ResponseUtil<DepartmentInfo>  findById(Integer id);

	@ApiOperation("通过部门名字查询部门消息(模糊查询)")
	ResponseUtil<List<DepartmentInfo>> selectName(String name);

	@ApiOperation("通过id删除部门信息")
	ResponseUtil<Integer> delete(Integer id);

	@ApiOperation("修改部门消息")
	ResponseUtil<Integer> update(DepartmentInfo departmentInfo);

	@ApiOperation("添加部门信息")
	ResponseUtil<Integer> add(DepartmentInfo departmentInfo);
	
	@ApiOperation("通过部门id查询部门中的岗位信息")
	ResponseUtil <List<DepartmentInfoDTO>>  selectById(Integer dId);
	@ApiOperation("通过部门名称模糊查询部门信息和岗位信息")
	ResponseUtil<List<DepartmentInfoDTO>> selectByName(String dName);
	@ApiOperation("通过部门名称模糊查询部门信息和岗位信息")
	ResponseUtil<List<DepartmentInfoDTO>> selectByJname(String jName);
	@ApiOperation("查询某个部门的实习生考核信息")
	ResponseUtil<List<DepartmentInfoDTO>> selectByLearn(Integer tId,String dName);
}
