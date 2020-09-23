package com.zzc.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzc.intern.DTO.TraineeAssessLearnResultDTO;
import com.zzc.intern.DTO.TraineeSubsidyDTO;
import com.zzc.intern.service.TraineeSubsidyRelService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Controller
@Api(value = "实习发放生补助管理", tags = "实习发放生补助管理", description = "实习发放生补助管理")
public class TraineeSubsidyRelController {

	@Autowired
	private TraineeSubsidyRelService traineeSubsidyRelService;

	@ApiOperation("查询所有实习生发放补助信息")
	@GetMapping("/findTraineeSubsidy")
	@ResponseBody
	public ResponseUtil<List<TraineeSubsidyDTO>> findTraineeSubsidy() {
		return traineeSubsidyRelService.findTraineeSubsidy();
	}

	@ApiOperation("根据实习生Id查询所有实习生发放补助信息")
	@GetMapping("/findTraineeSubsidybyId")
	@ResponseBody
	public ResponseUtil<List<TraineeSubsidyDTO>> findTraineeSubsidybyId(Integer tId) {
		return traineeSubsidyRelService.findTraineeSubsidybyId(tId);
	}

	@ApiOperation("添加实习生发放补助信息")
	@PostMapping("/addAssess")
	@ResponseBody
	public ResponseUtil<Integer> addTraineeSubsidy(
			@ApiParam(name = "tId", value = "实习生id", required = true) @RequestParam("tId") Integer tId,
			@ApiParam(name = "sId", value = "学习内容id", required = true) @RequestParam("sId") Integer sId) {
		return traineeSubsidyRelService.addTraineeSubsidy(tId, sId);
	}

}
