package com.zzc.intern.controller;

import com.zzc.intern.DTO.TraineeInfoAllDTO;
import com.zzc.intern.service.TraineeInfoAllService;
import com.zzc.intern.util.ResponseUtil;
import com.zzc.intern.vo.AssessInfoVO;
import com.zzc.intern.vo.LearnInfoVO;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(value = "实习生所有信息管理", tags = "实习生所有信息管理", description = "实习生所有信息管理")
@RequestMapping("/traineeInfoAll")
public class TraineeInfoAllController {

    @Autowired
    private TraineeInfoAllService traineeInfoAllService;

    @ApiOperation("查询所有实习生信息")
    @GetMapping("/findAll")
    public ResponseUtil<List<TraineeInfoAllDTO>> findAll() {

        return traineeInfoAllService.findAll();

    }

    @ApiOperation("根据实习生条件查询实习生信息")
    @PostMapping("/findByCondition")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "traineeInfoAllDTO", value = "实习生信息", required = true, dataType = "TraineeInfoAllDTO", paramType = "body")
    })
    public ResponseUtil<List<TraineeInfoAllDTO>> findByCondition(@RequestBody TraineeInfoAllDTO traineeInfoAllDTO) {

        return traineeInfoAllService.findByCondition(traineeInfoAllDTO);

    }

    @ApiOperation("添加实习生信息")
    @PostMapping("/addTrainee")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "traineeInfoAllDTO", value = "实习生信息", required = true, dataType = "TraineeInfoAllDTO", paramType = "body")
    })
    public ResponseUtil<Integer> addTrainee(@RequestBody TraineeInfoAllDTO traineeInfoAllDTO) {

        return traineeInfoAllService.addTrainee(traineeInfoAllDTO);

    }

    @ApiOperation("更新实习生信息")
    @PostMapping("/updateTrainee")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "traineeInfoAllDTO", value = "实习生信息", required = true, dataType = "TraineeInfoAllDTO", paramType = "body")
    })
    public ResponseUtil<Integer> updateTrainee(@RequestBody TraineeInfoAllDTO traineeInfoAllDTO) {

        return traineeInfoAllService.updateTrainee(traineeInfoAllDTO);

    }

    @ApiOperation("删除实习生信息")
    @GetMapping("/deleteTrainee/{tId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tId", value = "实习生编号", required = true, dataType = "Int", paramType = "path")
    })
    public ResponseUtil<Integer> deleteTrainee(@PathVariable("tId") Integer tId) {

        return traineeInfoAllService.deleteTrainee(tId);
    }

    @ApiOperation("根据实习生的id查询实习生的学习情况")
    @GetMapping("/selectTraineeLearn/{tId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tId", value = "实习生编号", required = true, dataType = "Int", paramType = "path")
    })
    public ResponseUtil<List<LearnInfoVO>> selectTraineeLearn(@PathVariable("tId") Integer tId) {

        return traineeInfoAllService.selectTraineeLearn(tId);

    }

    @ApiOperation("根据实习生的id和学习内容id查询实习生的考核情况")
    @GetMapping("/selectTraineeAssess")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tId", value = "实习生编号", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "lId", value = "学习内容编号", required = true, dataType = "Int", paramType = "query")
    })
    public ResponseUtil<List<AssessInfoVO>> selectTraineeLearn(
            @RequestParam("tId") Integer tId, @RequestParam("lId") Integer lId) {

        return traineeInfoAllService.selectTraineeAssess(tId, lId);

    }
}
