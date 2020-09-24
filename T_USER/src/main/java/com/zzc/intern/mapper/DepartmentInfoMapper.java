package com.zzc.intern.mapper;

import com.zzc.intern.DTO.DepartmentInfoDTO;
import com.zzc.intern.entity.DepartmentInfo;

import io.swagger.annotations.ApiOperation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * 部门信息 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface DepartmentInfoMapper extends BaseMapper<DepartmentInfo> {
	//@ApiOperation("根据id查询部门信息")
	//DepartmentInfo findById(Integer id);
	@ApiOperation("通过部门名字查询部门消息")
	List<DepartmentInfo> selectName(String name);
	@ApiOperation("通过id删除部门信息")
	int deleteById(Integer id);
	@ApiOperation("添加部门信息")
	int add(DepartmentInfo departmentInfo);
	@ApiOperation("修改部门消息")
	int update(DepartmentInfo departmentInfo);
	@ApiOperation("查询所有部门信息")
	List<DepartmentInfo> findAll();
	//@ApiOperation("通过部门id查询部门中的岗位信息")
	//List<DepartmentInfoDTO> selectById(Integer id);
	@ApiOperation("通过部门名称模糊查询部门信息和岗位信息")
	List<DepartmentInfoDTO> selectByName(String dName);
	@ApiOperation("通过岗位名称模糊查询部门信息和岗位信息")
	List<DepartmentInfoDTO> selectByJname(String jName);
	@ApiOperation("查询某个部门的实习生考核信息")
	List<DepartmentInfoDTO> selectByLearn(Integer tId,String dName);
}
