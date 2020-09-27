package com.zzc.intern.controller;

import com.zzc.intern.entity.TraineeContacts;
import com.zzc.intern.service.TraineeContactsService;
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
@Api(value = "实习生的所有紧急联系人信息", tags = "实习生的所有紧急联系人信息", description="实习生的所有紧急联系人信息")
@RequestMapping("/traineeContacts")
public class TraineeContactsController {

    @Autowired
    TraineeContactsService traineeContactsService;

    @ApiOperation("根据实习生工号查询该实习生的紧急联系人信息")
    @ApiImplicitParam(name = "tId", value = "实习生id", required = true, dataType = "int", paramType = "path")
    @GetMapping("/queryById/{tId}")
    public List<TraineeContacts> queryById(@PathVariable("tId") Integer tId) {
        return traineeContactsService.queryById(tId);
    }
}
