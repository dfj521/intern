package com.zzc.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzc.intern.DTO.JobSubsidyDTO;
import com.zzc.intern.entity.SubsidyInfo;
import com.zzc.intern.mapper.TraineeSubsidyRelMapper;
import com.zzc.intern.service.SubsidyInfoService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 补贴 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Controller
@Api(value = "补助管理", tags = "补助管理", description = "补助管理")
public class SubsidyInfoController {

	@Autowired
	private SubsidyInfoService subsidyInfoService;

	
	@ApiOperation("查询所有补助信息")
	@GetMapping("/findSubsidy")
	@ResponseBody
	public ResponseUtil<List<JobSubsidyDTO>> findSubsidy() {
		return subsidyInfoService.findSubsidy();
	}

	@ApiOperation("根据补助id查询补助信息")
	@GetMapping("/findSubsidyByid")
	@ResponseBody
	public ResponseUtil<SubsidyInfo> findSubsidyByid(
			@ApiParam(name = "id", value = "补助id", required = true) @RequestParam("id") Integer id) {
		return subsidyInfoService.findSubsidyByid(id);
	}

	/*
	 * @ApiOperation("根据岗位id查询补助信息")
	 * 
	 * @GetMapping("/findSubsidyByjId")
	 * 
	 * @ResponseBody public ResponseUtil<SubsidyInfo> findSubsidyByjId(
	 * 
	 * @ApiParam(name = "jId", value = "岗位id", required = true) @RequestParam("jId")
	 * Integer jId) { return subsidyInfoService.findSubsidyByjId(jId); }
	 */

	@ApiOperation("添加补助信息")
	@PostMapping("/addSubsidy")
	@ResponseBody
	public ResponseUtil<Integer> addSubsidy(
			@ApiParam(name = "sSubsidies", value = "补助金额", required = true) @RequestParam("sSubsidies") Double sSubsidies,
			@ApiParam(name = "sIssuedTime", value = "发放时间", required = true) @RequestParam("sIssuedTime") Integer sIssuedTime,
			@ApiParam(name = "sLssueNum", value ="补助总次数", required = true) @RequestParam("sLssueNum") Integer sLssueNum,
			@ApiParam(name = "jId", value = "岗位id", required = true) @RequestParam("jId") Integer jId) {
		return subsidyInfoService.addSubsidy(sSubsidies,sIssuedTime,sLssueNum,jId);
	}

	@ApiOperation("修改补助信息")
	@PostMapping("/updateSubsidy")

	@ResponseBody
	public ResponseUtil<Integer> updateSubsidy(@ApiParam(name = "sSubsidies", value = "补助金额", required = true) @RequestParam("sSubsidies") Double sSubsidies,
			@ApiParam(name = "sIssuedTime", value = "发放时间", required = true) @RequestParam("sIssuedTime") Integer sIssuedTime,
			@ApiParam(name = "sLssueNum", value ="补助总次数", required = true) @RequestParam("sLssueNum") Integer sLssueNum,
			@ApiParam(name = "sId", value = "补助id", required = true) @RequestParam("sId") Integer sId){
		return subsidyInfoService.updateSubsidy(sSubsidies,sIssuedTime,sLssueNum,sId);
	}

	@ApiOperation("删除补助信息")
	@PostMapping("/delSubsidy")
	@ResponseBody
	public ResponseUtil<Integer> delSubsidy(
			@ApiParam(name = "id", value = "补助id", required = true) @RequestParam("id") Integer id) {
		return subsidyInfoService.delSubsidy(id);
	}

}
