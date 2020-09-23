package com.zzc.intern.controller;


import com.zzc.intern.service.DepartmentJobRelService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门&岗位 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-17
 */
@Slf4j
@Controller
@Api(value = "", tags = "", description="")
public class DepartmentJobRelController {

    @Autowired
    private DepartmentJobRelService departmentJobRelService;
   
}
