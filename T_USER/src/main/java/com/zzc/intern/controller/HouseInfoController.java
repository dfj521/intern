package com.zzc.intern.controller;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.zzc.intern.DTO.HouseInfoDTO;
import com.zzc.intern.entity.HouseInfo;
import com.zzc.intern.service.HouseInfoService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 * 宿舍信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
//@RestController
@Api(value = "宿舍内容", tags = "宿舍内容", description="宿舍内容")
@RequestMapping("/houseInfo")
@ResponseBody
public class HouseInfoController {
	@Autowired
    private HouseInfoService houseInfoService;
	@ApiOperation("查询所有宿舍")
    @GetMapping("/findAll")
    public List<HouseInfo>  findAll(){
    	return houseInfoService.list();
    }
	@ApiOperation("通过id查询宿舍")
    @GetMapping("/findById/{id}")
    public ResponseUtil<HouseInfo> findById(@PathVariable("id") Integer id) {
    	return houseInfoService.findById(id);
    }
	@ApiOperation("删除宿舍")
    @GetMapping("/delete/{id}")
    public ResponseUtil<Integer> delete(@PathVariable("id") Integer id) {
    	return houseInfoService.delete(id);
    	
    }
	@ApiOperation("添加宿舍")
    @PostMapping("/add")
    public ResponseUtil<Integer> add(HouseInfo houseInfo) {
    	return houseInfoService.add(houseInfo);
    }
	@ApiOperation("模糊查询")
	@GetMapping("/findByHouseInfoId/{hAddress}")
	public ResponseUtil<List<HouseInfo>> findHouseInfoByAddress(@PathVariable ("hAddress") @Validated  String hAddress) {
		return houseInfoService.findHouseInfoByAddress(hAddress);
	}
	@ApiOperation("更新")
	@PostMapping("/update")
	public ResponseUtil<Integer> update(HouseInfo houseInfo) {
		return houseInfoService.update(houseInfo);
	}
	@ApiOperation("根据id查询宿舍内容")
	@GetMapping("/findHouseInfoById/{hId}")
	public ResponseUtil<List<HouseInfoDTO>> findHouseInfoById(@PathVariable ("hId") Integer hId) {
		return houseInfoService.findHousInfoById(hId);
	}
	@ApiOperation("根据地址查询宿舍内容")
	@GetMapping("/findAssessByAddress/{hAddress}")
	public ResponseUtil<List<HouseInfoDTO>> findAssessByAddress(@PathVariable ("hAddress")  String hAddress) {
		return houseInfoService.findAssessByAddress(hAddress);
	}
	@ApiOperation("根据id查询宿舍内容")
	@GetMapping("/findNameById/{hId}")
	public ResponseUtil<List<HouseInfoDTO>> findNameById(@PathVariable ("hId") Integer hId) {
		return houseInfoService.findHousInfoById(hId);
	}
}
