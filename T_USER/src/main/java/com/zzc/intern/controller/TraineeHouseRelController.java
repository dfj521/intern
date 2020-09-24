package com.zzc.intern.controller;

import com.zzc.intern.service.TraineeHouseRelService;
import com.zzc.intern.vo.TraineeHouseRelVO;
import com.zzc.intern.vo.TraineeJobRelVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@RestController
@Api(value = "实习生的宿舍管理", tags = "实习生的宿舍管理", description="实习生的宿舍管理")
@RequestMapping("/traineeHouseRel")
public class TraineeHouseRelController {

    @Autowired
    private TraineeHouseRelService traineeHouseRelService;

    @ApiOperation("按条件分页查询实习生的宿舍信息")
    @PostMapping("/queryByCondition")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "tName", value = "实习生姓名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "hAddress", value = "宿舍地址",dataType = "string", paramType = "query")
    })
    public TraineeHouseRelVO queryByCondition(@RequestParam Integer current, @RequestParam Integer size,
                                              @RequestParam(required = false) String tName,
                                              @RequestParam(required = false) String hAddress) {
        return traineeHouseRelService.queryByCondition(current, size, tName, hAddress);
    }
}
