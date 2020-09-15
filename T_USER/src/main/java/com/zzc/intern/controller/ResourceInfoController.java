package com.zzc.intern.controller;


import org.springframework.stereotype.Controller;
import com.zzc.intern.service.ResourceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 资源信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Controller
@Api(value = "", tags = "", description="")
public class ResourceInfoController {

    @Autowired
    private ResourceInfoService resourceInfoService;
}
