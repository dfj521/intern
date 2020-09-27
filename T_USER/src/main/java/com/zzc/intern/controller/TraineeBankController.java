package com.zzc.intern.controller;

import com.zzc.intern.entity.TraineeBank;
import com.zzc.intern.service.TraineeBankService;
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
@Api(value = "实习生的所有银行卡信息", tags = "实习生的所有银行卡信息", description="实习生的所有银行卡信息")
@RequestMapping("/traineeBank")
public class TraineeBankController {

    @Autowired
    TraineeBankService traineeBankService;

    @ApiOperation("根据实习生id查询该实习生的银行卡信息")
    @ApiImplicitParam(name = "tId", value = "实习生id", required = true, dataType = "int", paramType = "path")
    @GetMapping("/queryById/{tId}")
    public List<TraineeBank> queryById(@PathVariable("tId") Integer tId) {
        return traineeBankService.queryById(tId);
    }

}
