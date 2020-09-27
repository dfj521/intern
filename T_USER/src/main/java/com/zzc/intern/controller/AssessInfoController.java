package com.zzc.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzc.intern.DTO.TraineeAssessLearnResultDTO;
import com.zzc.intern.entity.AssessInfo;
import com.zzc.intern.service.AssessInfoService;
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
 * 考核信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
//@Controller
@Api(value = "实习生考核管理", tags = "实习生考核管理", description = "实习生考核管理")
@RequestMapping("assess")
public class AssessInfoController {

	@Autowired
	private AssessInfoService assessInfoService;

	@ApiOperation("查询所有考核并根据条件查询")
	@GetMapping("/findByEerm")
	@ResponseBody
	public ResponseUtil<List<TraineeAssessLearnResultDTO>> findByEerm(
			@ApiParam(name = "name", value = "实习生姓名") @RequestParam(value = "name", required = false) String name,
			@ApiParam(name = "minaGrade", value = "考核成绩min") @RequestParam(value = "minaGrade", required = false) Double minaGrade,
			@ApiParam(name = "maxaGrade", value = "考核成绩max") @RequestParam(value = "maxaGrade", required = false) Double maxaGrade,
			@ApiParam(name = "lstage", value = "考核级别") @RequestParam(value = "lstage", required = false) Integer lstage) {
		return assessInfoService.findByEerm(name, minaGrade, maxaGrade, lstage);
	}

	@ApiOperation("查询考核根据id查询")
	@GetMapping("/findById")
	@ResponseBody
	public ResponseUtil<TraineeAssessLearnResultDTO> findById(
			@ApiParam(name = "id", value = "实习生id", required = true) @RequestParam("id") int id) {
		return assessInfoService.findById(id);
	}

	@ApiOperation("添加考核")
	@PostMapping("/addAssess")
	@ResponseBody
	public ResponseUtil addAssess(
			@ApiParam(name = "grade", value = "考核成绩", required = true) @RequestParam("grade") Double grade,
			@ApiParam(name = "lId", value = "学习内容id", required = true) @RequestParam("lId") Integer lId,
			@ApiParam(name = "lStage", value = "学习内容阶段", required = true) @RequestParam("lStage") Integer lStage,
			@ApiParam(name = "tId", value = "实习生id", required = true) @RequestParam("tId") Integer tId) {
		return assessInfoService.addAssess(grade, lId, lStage, tId);
	}

	@ApiOperation("修改考核")
	@PostMapping("/updateAssess")
	@ResponseBody
	public ResponseUtil updateAssess(AssessInfo assessInfo) {
		return assessInfoService.updateAssess(assessInfo);
	}

	@ApiOperation("删除考核")
	@GetMapping("/delAssess")
	@ResponseBody
	public ResponseUtil delAssess(int id) {
		return assessInfoService.delAssess(id);
	}

}
