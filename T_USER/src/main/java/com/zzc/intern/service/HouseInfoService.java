package com.zzc.intern.service;

import com.zzc.intern.DTO.HouseInfoDTO;
import com.zzc.intern.entity.HouseInfo;
import com.zzc.intern.entity.ResourceInfo;
import com.zzc.intern.util.ResponseUtil;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 宿舍信息 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface HouseInfoService extends IService<HouseInfo> {
		//查询
		ResponseUtil<List<HouseInfo>>  findAll();
		//添加
		 ResponseUtil<Integer> add(HouseInfo houseInfo);
		//修改
		 ResponseUtil<Integer> update(HouseInfo houseInfo);
		//删除
		 ResponseUtil<Integer> delete(Integer id);
		//id查询
		 ResponseUtil<HouseInfo> findById(Integer id);
		//宿舍地址查询
		 ResponseUtil<List<HouseInfo>> findHouseInfoByAddress(String hAddress);
		//根据id查询宿舍内容
		 ResponseUtil<List<HouseInfoDTO>> findHousInfoById(Integer hId);
		 
		//根据宿舍查实习生信息和考核
		 ResponseUtil< List<HouseInfoDTO>> findAssessByAddress(String hAddress);
		 
		//根据id查姓名
		 ResponseUtil<HouseInfo>  findNameById(Integer hId);
		
}
