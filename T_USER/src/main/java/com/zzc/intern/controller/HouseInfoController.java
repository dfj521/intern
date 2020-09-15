package com.zzc.intern.controller;


import org.springframework.stereotype.Controller;
import com.zzc.intern.service.HouseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 宿舍信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Controller
@Api(value = "", tags = "", description="")
public class HouseInfoController {

    @Autowired
    private HouseInfoService houseInfoService;
}
