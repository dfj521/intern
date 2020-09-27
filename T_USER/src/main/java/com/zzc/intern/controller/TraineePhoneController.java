package com.zzc.intern.controller;

import com.zzc.intern.entity.TraineePhone;
import com.zzc.intern.service.TraineePhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Api(value = "实习生的所有电话", tags = "实习生的所有电话", description="实习生的所有电话")
@RequestMapping("/traineePhone")
public class TraineePhoneController {

    @Autowired
    TraineePhoneService traineePhoneService;

    @ApiOperation("根据实习生id查询该实习生的电话")
    @ApiImplicitParam(name = "tId", value = "实习生id", required = true, dataType = "int", paramType = "path")
    @GetMapping("/queryById/{tId}")
    public List<TraineePhone> queryById(@PathVariable("tId") Integer tId) {
        return traineePhoneService.queryById(tId);
    }
}
