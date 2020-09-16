package com.zzc.intern.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.zzc.intern.entity.HouseInfo;
import com.zzc.intern.service.HouseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
@RestController
@Api(value = "", tags = "", description="")
@RequestMapping("/houseInfo")
public class HouseInfoController {
	@Autowired
    private HouseInfoService houseInfoService;
    @GetMapping("/findAll")
    public List<HouseInfo>  findAll(){
    	return houseInfoService.list();
    }
    @GetMapping("/findById/{id}")
    public HouseInfo findById(@PathVariable("id") int id) {
    	return houseInfoService.getById(id);
    }
    @GetMapping("/deleteById/{id}")
    public boolean DeleteById(@PathVariable("id") int id) {
    	HouseInfo Id = houseInfoService.getById(id);
    	return houseInfoService.removeById(Id);
    }
    @PostMapping("/save")
    public boolean save(HouseInfo houseInfo) {
    	return houseInfoService.save(houseInfo);
    }
}
