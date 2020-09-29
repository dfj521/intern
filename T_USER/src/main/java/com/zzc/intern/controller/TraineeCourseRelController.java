package com.zzc.intern.controller;

import com.zzc.intern.service.TraineeCourseRelService;
import com.zzc.intern.vo.TraineeCourseRelVO;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 实习生信息与课程信息的关联表 前端控制器
 */
@Slf4j
@RestController
@Api(value = "实习生的课程管理", tags = "实习生的课程管理", description="实习生的课程管理")
@RequestMapping("/TraineeCourseRel")
public class TraineeCourseRelController {

    @Autowired
    private TraineeCourseRelService traineeCourseRelService;

    @ApiOperation("添加实习生的课程信息")
    @PostMapping("/addTraineeCourse")
    public boolean addTraineeCourse(@ApiParam(name = "traineeId", value = "实习生编号", required = true)
                                     @RequestParam("traineeId") Integer traineeId,
                                 @ApiParam(name = "courseId", value = "课程编号", required = true)
                                     @RequestParam("courseId") Integer courseId) {
        return traineeCourseRelService.addTraineeCourse(traineeId, courseId);
    }

    @ApiOperation("根据实习生id查询课程信息")
    @GetMapping("/queryTraineeCourse/{traineeId}")
    public TraineeCourseRelVO queryTraineeCourse(@ApiParam(name = "traineeId", value = "实习生编号", required = true)
                                                     @PathVariable("traineeId") Integer traineeId) {
        return traineeCourseRelService.queryTraineeCourse(traineeId);
    }
}
