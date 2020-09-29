package com.zzc.intern.controller;

import com.zzc.intern.DTO.TraineeInfoDTO;
import com.zzc.intern.entity.TraineeInfo;
import com.zzc.intern.exception.BusinessException;
import com.zzc.intern.requestbody.ReqTraineeInfo;
import com.zzc.intern.service.TraineeInfoService;
import com.zzc.intern.vo.TraineeInfoVO;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 实习生个人信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@RestController
@Api(value = "实习生基本信息", tags = "实习生基本信息", description="实习生基本信息")
@RequestMapping("/traineeInfo")
public class TraineeInfoController {

    @Autowired
    private TraineeInfoService traineeInfoService;

    @ApiOperation("根据id查询实习生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tId", value = "实习生工号", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping("/queryById/{tId}")
    public TraineeInfoDTO queryById(@PathVariable("tId") Integer tId) throws BusinessException {
        return traineeInfoService.queryById(tId);
    }

    @ApiOperation("根据条件分页查询实习生信息")
    @PostMapping("/queryByCondition")
    public TraineeInfoVO queryByCondition(@ApiParam(name = "实习生对象", value = "传入json格式", required = true)
                                              @RequestBody ReqTraineeInfo reqTraineeInfo)  throws BusinessException {
        return traineeInfoService.queryByCondition(reqTraineeInfo);
    }

    @ApiOperation("添加实习生信息")
    @PostMapping("/add")
    public boolean add(@ApiParam(name = "实习生对象", value = "传入json格式", required = true)
                           @RequestBody TraineeInfoDTO traineeInfoDTO)  throws BusinessException {
        return traineeInfoService.add(traineeInfoDTO);
    }

    @ApiOperation("根据id更新实习生基本信息")
    @PostMapping("/saveById")
    public boolean update(@ApiParam(name = "实习生对象", value = "传入json格式", required = true)
                              @RequestBody TraineeInfoDTO traineeInfoDTO) throws BusinessException {
        return traineeInfoService.saveById(traineeInfoDTO);
    }

    @ApiOperation("根据id删除实习生基本信息")
    @GetMapping("/deleteById/{tId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tId", value = "实习生id", required = true, dataType = "int", paramType = "path")
    })
    public boolean deleteById(@PathVariable("tId") Integer tId) throws BusinessException {
        return traineeInfoService.deleteById(tId);
    }
}
