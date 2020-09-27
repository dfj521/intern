package com.zzc.intern.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzc.intern.DTO.JobInfoDTO;
import com.zzc.intern.entity.JobInfo;
import com.zzc.intern.entity.ResourceInfo;
import com.zzc.intern.service.JobInfoService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 岗位信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
//@RestController
@Api(value = "实习生岗位管理", tags = "实习生岗位管理", description="实习生岗位管理")
@RequestMapping("/jobInfo")
public class JobInfoController {

    @Autowired
    private JobInfoService jobInfoService;
    @ApiOperation("添加一条岗位信息")
    @GetMapping("/insert")
    public ResponseUtil<Integer> insert(Integer Id,String jName) {
    	return jobInfoService.insert(Id,jName);
    }
    @ApiOperation("查询所有岗位")
    @GetMapping("/findAll")
    public ResponseUtil<List<JobInfo>>  findAll() {
    	return jobInfoService.findAll();
    }
    @ApiOperation("根据id查询岗位信息")
    @PostMapping("/findById")
    public ResponseUtil<JobInfo> findbyId( Integer jid) {
    	return jobInfoService.findById(jid);
    }
    @ApiOperation("根据jName模糊查询")
    @GetMapping("/findByName/{jName}")
    public ResponseUtil<List<JobInfo>>  findByName(@PathVariable("jName") @Validated String jName) {
    	return jobInfoService.findByName(jName);
    }
    @ApiOperation("更改一条岗位信息")
    @GetMapping("/updateId")
    public ResponseUtil<Integer> updateId(JobInfo jobInfo) {
    	return jobInfoService.updateId(jobInfo);
    }
    @ApiOperation("删除一条岗位信息")
    @GetMapping("/deleteId")
    public ResponseUtil<Integer> deleteId(Integer jid) {
    	return jobInfoService.deleteId(jid);
    }
    @ApiOperation("根据岗位id查询学生姓名")
    @GetMapping("/findId")
    public ResponseUtil<List<JobInfoDTO>>findId(Integer jId) {
    	return jobInfoService.findId(jId);
    }
    @ApiOperation("根据岗位id查询学习内容")
    @PostMapping("/findGId")
    public ResponseUtil<List<JobInfoDTO>>findGId(Integer jId) {
    	return jobInfoService.findGId(jId);
    }
    @ApiOperation("根据岗位名称模糊查询岗位信息和实习生信息")
    @GetMapping("/selectId")
    public ResponseUtil<List<JobInfoDTO>> selectId(String jName) {
    	return jobInfoService.selectId(jName);
    }
   @ApiOperation("根据岗位名称模糊查询岗位信息和学习内容")
   @GetMapping("/selecGId")
   public ResponseUtil<List<JobInfoDTO>> selectGId(String jName) {
   return jobInfoService.selectGId(jName);
   }
   @ApiOperation("根据岗位id和考试阶段查询考试成绩,岗位信息,考试成绩,考试阶段")
   @GetMapping("/selectJId")
   public ResponseUtil<List<JobInfoDTO>> selectJId(Integer jId,String lStage){
	   return jobInfoService.selectJId(jId ,lStage);
   
   }
}
