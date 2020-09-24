package com.zzc.intern.controller;

import com.zzc.intern.DTO.TraineeJobRelDTO;
import com.zzc.intern.service.TraineeJobRelService;
import com.zzc.intern.vo.TraineeJobRelVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 实习生信息与岗位信息的关联表 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@RestController
@Api(value = "实习生的岗位管理", tags = "实习生的岗位管理", description="实习生的岗位管理")
@RequestMapping("/traineeJobRel")
public class TraineeJobRelController {

    @Autowired
    private TraineeJobRelService traineeJobRelService;

    @ApiOperation("按条件分页查询实习生的岗位信息")
    @PostMapping("/queryByCondition")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "tName", value = "实习生姓名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "jName", value = "岗位名称",dataType = "string", paramType = "query")
    })
    public TraineeJobRelVO queryByCondition(@RequestParam Integer current, @RequestParam Integer size,
                                            @RequestParam(required = false) String tName,
                                            @RequestParam(required = false) String jName) {
        return traineeJobRelService.queryByCondition(current, size, tName, jName);
    }

    @ApiOperation("根据id查询实习生的岗位信息")
    @GetMapping("/queryById/{tjId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tjId", value = "实习生的岗位信息id", required = true, dataType = "int", paramType = "path")
    })
    public TraineeJobRelDTO queryById(@PathVariable("tjId") Integer tjId) {
        return traineeJobRelService.queryById(tjId);
    }
}
