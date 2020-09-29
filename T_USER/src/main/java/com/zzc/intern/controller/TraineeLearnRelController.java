package com.zzc.intern.controller;

import com.zzc.intern.DTO.TraineeLearnRelDTO;
import com.zzc.intern.service.TraineeLearnRelService;
import com.zzc.intern.vo.TraineeLearnRelVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 实习生信息与学习内容信息关联表 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@RestController
@Api(value = "实习生的学习内容管理", tags = "实习生的学习内容管理", description = "实习生的学习内容管理")
@RequestMapping("/TraineeLearnRel")
public class TraineeLearnRelController {

    @Autowired
    private TraineeLearnRelService traineeLearnRelService;

    @ApiOperation("添加实习生的学习内容信息")
    @PostMapping("/addTraineeLearn")
    public boolean addTraineeLearn(@ApiParam(name = "traineeId", value = "实习生编号", required = true)
                                   @RequestParam("traineeId") Integer traineeId,
                                   @ApiParam(name = "learnIds", value = "学习内容编号", required = true)
                                   @RequestParam("learnIds") List<Integer> learnIds) {
        return traineeLearnRelService.addTraineeLearn(traineeId, learnIds);
    }

    @ApiOperation("根据实习生id查询学习内容信息")
    @GetMapping("/queryTraineeLearn/{traineeId}")
    public TraineeLearnRelVO queryTraineeLearn(@ApiParam(name = "traineeId", value = "实习生编号", required = true)
                                               @PathVariable("traineeId") Integer traineeId) {
        return traineeLearnRelService.queryTraineeLearn(traineeId);
    }

    @ApiOperation("根据实习生id修改学习内容信息")
    @PostMapping("/updateTraineeLearn")
    public boolean updateTraineeLearn(@ApiParam(name = "实习生的学习内容", value = "传入json格式", required = true)
                                      @RequestBody TraineeLearnRelDTO traineeLearnRelDTO) {
        return traineeLearnRelService.updateTraineeLearn(traineeLearnRelDTO);
    }
}
