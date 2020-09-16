package com.zzc.intern.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zzc.intern.entity.DepartmentInfo;
import com.zzc.intern.service.DepartmentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 部门信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Controller
@Api(value = "", tags = "", description="")
public class DepartmentInfoController {

    @Autowired
    private DepartmentInfoService departmentInfoService;
    @GetMapping("/findAll")
    public List<DepartmentInfo> findAll(){
    	return departmentInfoService.list();
    }
    @GetMapping("/findById/{id}")
    public DepartmentInfo findById(@PathVariable("id")int id) {
    	return departmentInfoService.getById(id);
    }
    @GetMapping("/insert")
    public boolean insert(DepartmentInfo departmentInfo) {
    	return departmentInfoService.save(departmentInfo);
    }
    @GetMapping("/deleteById/{id}")
   public boolean deleteById(@PathVariable("id")int id) {
    	DepartmentInfo Id = departmentInfoService.getById(id);
    	return departmentInfoService.removeById(Id);
    }
}
