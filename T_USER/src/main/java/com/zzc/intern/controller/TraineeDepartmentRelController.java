package com.zzc.intern.controller;

import com.zzc.intern.DTO.TraineeDepartmentRelDTO;
import com.zzc.intern.entity.TraineeDepartmentRel;
import com.zzc.intern.vo.TraineeDepartmentRelVO;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzc.intern.service.TraineeDepartmentRelService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 实习生&部门 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-17
 */
@Slf4j
//@RestController
@Api(value = "实习生的部门管理", tags = "实习生的部门管理", description="实习生的部门管理")
@RequestMapping("/traineeDepartmentRel")
public class TraineeDepartmentRelController {

    @Autowired
    private TraineeDepartmentRelService traineeDepartmentRelService;

    @ApiOperation("按条件分页查询实习生的部门信息")
    @PostMapping("/queryByCondition")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "tName", value = "实习生姓名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "dName", value = "部门名称",dataType = "string", paramType = "query")
    })
    public TraineeDepartmentRelVO queryByCondition(@RequestParam Integer current, @RequestParam Integer size,
                                                   @RequestParam(required = false) String tName,
                                                   @RequestParam(required = false) String dName) {
        return traineeDepartmentRelService.queryByCondition(current, size, tName, dName);
    }

    @ApiOperation("根据id查询实习生的部门信息")
    @GetMapping("/queryById/{tdId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tdId", value = "实习生的部门信息id", required = true, dataType = "int", paramType = "path")
    })
    public TraineeDepartmentRelDTO queryById(@PathVariable("tdId") Integer tdId) {
        return traineeDepartmentRelService.queryById(tdId);
    }

    /*@ApiOperation("根据id更新实习生的部门信息")
    @PostMapping("/updateById")
    public boolean updateById(@ApiParam(name = "实习生的部门信息对象", value = "传入json格式", required = true)
                               @RequestBody TraineeDepartmentRel traineeDepartmentRel) {
        return traineeDepartmentRelService.updateById(traineeDepartmentRel);
    }*/

    /*@ApiOperation("根据id删除实习生的部门信息")
    @GetMapping("/deleteById/{tdId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tdId", value = "实习生的部门信息id", required = true, dataType = "int", paramType = "path")
    })
    public boolean deleteById(@PathVariable("tdId") Integer tdId) {
        return traineeDepartmentRelService.deleteById(tdId);
    }*/

}
