package com.zzc.intern.service.impl;

import com.zzc.intern.entity.HouseInfo;
import com.zzc.intern.mapper.HouseInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.HouseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 宿舍信息 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class HouseInfoServiceImpl extends ServiceImpl<HouseInfoMapper, HouseInfo> implements HouseInfoService {

	
	@Resource
	private HouseInfoMapper houseInfoMapper;
	
	public List<HouseInfo> findAll() {
		// TODO Auto-generated method stub
		return houseInfoMapper.findAll();
	}



	@Override
	public Integer update(HouseInfo houseInfo) {
		// TODO Auto-generated method stub
		return houseInfoMapper.update(houseInfo);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return houseInfoMapper.delete(id);
	}

	@Override
	public HouseInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return houseInfoMapper.findById(id);
	}

	@Override
	public Integer add(HouseInfo houseInfo) {
		// TODO Auto-generated method stub
		return houseInfoMapper.add(houseInfo);
	}

	@Override
	public List<HouseInfo> findHouseInfoByAddress(String hAddress) {
		// TODO Auto-generated method stub
		return houseInfoMapper.findHouseInfoByAddress(hAddress);
	}



	

}
