package com.zzc.intern.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzc.intern.DTO.TraineeInfoSaveDTO;
import com.zzc.intern.entity.TraineeInfo;
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

    @ApiOperation("分页查询")
    @PostMapping("/page")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "tName", value = "实习生姓名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间",dataType = "date-time", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "终止时间", dataType = "date-time", paramType = "query")
    })
    public IPage<TraineeInfo> page(@RequestParam Integer current, @RequestParam Integer size,
                                   @RequestParam(required = false) String tName,
                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                       @RequestParam(required = false) LocalDateTime startTime,
                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                       @RequestParam(required = false) LocalDateTime endTime) {
        return traineeInfoService.page(new Page<>(current, size),
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(tName != null && !"".equals(tName), TraineeInfo::getTName, tName)
                        .gt(startTime != null, TraineeInfo::getTEntryTime, startTime)
                        .lt(endTime != null, TraineeInfo::getTEntryTime, endTime)
                        .eq(TraineeInfo::getTStatus, "1"));
    }

    @ApiOperation("分页查询所有实习生基本信息")
    @GetMapping("/queryList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, dataType = "int", paramType = "query")
    })
    public TraineeInfoVO queryList(@RequestParam Integer current, @RequestParam Integer size) {
        return traineeInfoService.queryList(current, size);
    }

    @ApiOperation("根据id查询实习生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tId", value = "实习生id", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping("/queryById/{tId}")
    public TraineeInfo queryById(@PathVariable("tId") Integer tId) {
        return traineeInfoService.getById(tId);
    }

    @ApiOperation("根据条件分页查询实习生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "tName", value = "实习生姓名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间",dataType = "date-time", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "终止时间", dataType = "date-time", paramType = "query")
    })
    @GetMapping("/queryByCondition")
    public TraineeInfoVO queryByCondition(@RequestParam Integer current,
                                          @RequestParam Integer size,
                                          @RequestParam(required = false) String tName,
                                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                              @RequestParam(required = false) LocalDateTime startTime,
                                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                              @RequestParam(required = false) LocalDateTime endTime) {
        return traineeInfoService.queryByCondition(current, size, tName, startTime, endTime);

    }

    @ApiOperation("添加实习生信息")
    @PostMapping("/add")
    public boolean add(@ApiParam(name = "实习生对象", value = "传入json格式", required = true)
                           @RequestBody TraineeInfoSaveDTO traineeInfoSaveDTO) {
        return traineeInfoService.add(traineeInfoSaveDTO);
    }

    @ApiOperation("根据id更新实习生基本信息")
    @PostMapping("/update")
    public boolean update(@ApiParam(name = "实习生对象", value = "传入json格式", required = true)
                              @RequestBody TraineeInfo traineeInfo) {
        return traineeInfoService.updateById(traineeInfo);
    }

    @ApiOperation("根据id删除实习生基本信息")
    @GetMapping("/deleteById/{tId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tId", value = "实习生id", required = true, dataType = "int", paramType = "path")
    })
    public boolean deleteById(@PathVariable("tId") Integer tId) {
        return traineeInfoService.deleteById(tId);
    }
}
