package com.zzc.intern.controller;


import com.zzc.intern.entity.TraineeInfo;
import com.zzc.intern.service.TraineeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("                                    /traineeInfo")
public class TraineeInfoController {

    @Autowired
    private TraineeInfoService traineeInfoService;

    /**
     * 查询所有实习生基本信息
     *
     * @return
     */
    @ApiOperation("查询所有实习生基本信息")
    @GetMapping("/findAll")
    public List<TraineeInfo> findAll() {
        return traineeInfoService.list();
    }

    /**
     * 添加实习生基本信息
     *
     * @param traineeInfo
     * @return
     */
    @ApiOperation("添加实习生基本信息")
    @PostMapping("/save")
    public boolean save(TraineeInfo traineeInfo) {
        return traineeInfoService.save(traineeInfo);
    }
}
