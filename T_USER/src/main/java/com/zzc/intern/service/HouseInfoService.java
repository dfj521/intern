package com.zzc.intern.service;

import com.zzc.intern.entity.HouseInfo;

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
		public List<HouseInfo> findAll();
		//添加
		public Integer add(HouseInfo houseInfo);
		//修改
		public Integer update(HouseInfo houseInfo);
		//删除
		public Integer delete(Integer id);
		//id查询
		public HouseInfo findById(Integer id);
		//宿舍地址查询
		public List<HouseInfo> findHouseInfoByAddress(String hAddress);
}
