package com.zzc.intern.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zzc.intern.service.TraineeDepartmentRelService;

/**
 * <p>
 * 实习生&部门 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-17
 */
@Slf4j
@Controller
@Api(value = "", tags = "", description="")
public class TraineeDepartmentRelController {

    @Autowired
    private TraineeDepartmentRelService traineeDepartmentRelService;
}
