package com.zzc.intern.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zzc.intern.DTO.DepartmentInfoDTO;
import com.zzc.intern.entity.DepartmentInfo;
import com.zzc.intern.service.DepartmentInfoService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
//@RestController
@Api(value = "实习生部门管理", tags = "实习生部门管理", description="实习生部门管理")
@RequestMapping("/departmentInfo")
public class DepartmentInfoController {

	@Autowired
    private DepartmentInfoService departmentInfoService;
    
    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    public ResponseUtil<List<DepartmentInfo>>  findAll(){
    	return departmentInfoService.findAll();
    }
    
    @ApiOperation("通过id查询部门信息")
    @GetMapping("/findById/{id}")
    public ResponseUtil<DepartmentInfo> findById(@PathVariable("id")int id) {
    	return departmentInfoService.findById(id);
    }
    
    @ApiOperation("添加信息")
    @PostMapping("/insert")
    public ResponseUtil<Integer> insert(DepartmentInfo departmentInfo) {
    	
    	return departmentInfoService.add(departmentInfo);
    }
    
    @ApiOperation("通过id删除部门信息")
    @GetMapping("/deleteById/{dId}")
   public ResponseUtil<Integer> deleteById(@PathVariable("dId")int dId) {
    	return departmentInfoService.delete(dId);
    }
    
    @ApiOperation("修改部门信息")
    @PostMapping("/update")
    public ResponseUtil<Integer> update(DepartmentInfo departmentInfo) {
    	
    	return departmentInfoService.update(departmentInfo);
    }
    
    @ApiOperation("通过部门查部门信息")
    @GetMapping("/insertName/{name}")
    public ResponseUtil<List<DepartmentInfo>> insertName(@PathVariable("name")String name) {
    	return departmentInfoService.selectName(name);
    }
    @ApiOperation("通过部门id查询部门中的岗位信息")
    @GetMapping("/selectById/{dId}")
    public ResponseUtil<List<DepartmentInfoDTO>>  selectById(@PathVariable("dId")Integer id){
    	return departmentInfoService.selectById(id);
    }
    @ApiOperation("通过部门名称模糊查询部门信息和岗位信息")
    @GetMapping("/selectByName")
    public ResponseUtil<List<DepartmentInfoDTO>> selectByName(String dName){
    	System.out.println("sad");
    	return departmentInfoService.selectByName(dName);
    }
    @ApiOperation("通过岗位名称模糊查询部门信息和岗位信息")
    @GetMapping("/selectByJname")
    public ResponseUtil<List<DepartmentInfoDTO>> selectByJname(String jName){
    	System.out.println(jName);
    	return departmentInfoService.selectByJname(jName);
    }
    @ApiOperation("查询某个部门的实习生考核信息")
    @GetMapping("selectByLearn")
    public ResponseUtil<List<DepartmentInfoDTO>>  selectByLearn(Integer tId,String dName){
    	return departmentInfoService.selectByLearn(tId,dName);
    }
}
