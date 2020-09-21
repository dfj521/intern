package com.zzc.intern.controller;

import org.springframework.stereotype.Controller;
import com.zzc.intern.service.AssessInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
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
@Controller
@Api(value = "", tags = "", description = "")
public class AssessInfoController {

	@Autowired
	private AssessInfoService assessInfoService;

<<<<<<< HEAD
	@ApiOperation("查询所有考核并根据条件查询")
	@GetMapping("/findByEerm")
	@ResponseBody
	public ResponseUtil<List<TraineeAssessLearnResultDTO>> findByEerm(
			@ApiParam(name = "name", value = "实习生姓名", required = false) @RequestParam(value = "name", required = false) String name,
			@ApiParam(name = "minaGrade", value = "考核成绩min", required = false) @RequestParam(value = "minaGrade", required = false) Double minaGrade,
			@ApiParam(name = "maxaGrade", value = "考核成绩max", required = false) @RequestParam(value = "maxaGrade", required = false) Double maxaGrade,
			@ApiParam(name = "lstage", value = "考核级别", required = false) @RequestParam(value = "lstage", required = false) Integer lstage) {
		return assessInfoService.findByEerm(name, minaGrade, maxaGrade, lstage);
	}

	@ApiOperation("查询考核根据id查询")
	@GetMapping("/findById")
	@ResponseBody
	public ResponseUtil<TraineeAssessLearnResultDTO> findById(@ApiParam(name = "id", value = "实习生姓名", required = true)int id) {
		return assessInfoService.findById(id);
	}

	@ApiOperation("添加考核")
	@PostMapping("/addAssess")
	@ResponseBody
	public ResponseUtil addAssess(AssessInfo assessInfo) {
		return assessInfoService.addAssess(assessInfo);
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

=======
>>>>>>> branch 'master' of https://github.com/dfj521/intern
}
