package com.zzc.intern.service.impl;

import com.zzc.intern.entity.HouseInfo;

import com.zzc.intern.mapper.HouseInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.HouseInfoService;
import com.zzc.intern.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;



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
	
	public ResponseUtil <List<HouseInfo>> findAll() {
		// TODO Auto-generated method stub
		 ResponseUtil<List<HouseInfo>> result = new ResponseUtil<>();
		 List<HouseInfo> houseInfo = new ArrayList<>();
		 try {
			 houseInfo = houseInfoMapper.findAll();
	            if (houseInfo.size() == 0) {
	                result.setCode(300);
	                result.setMessage("没有查询到数据");
	            } else {
	                result.setCode(200);
	                result.setMessage("查询成功");
	            }
	        } catch (Exception e) {
	            result.setCode(500);
	            result.setMessage("查询失败");
	        }
	        result.setData(houseInfo);
	        return result;
	}



	@Override
	public ResponseUtil<Integer> update(HouseInfo houseInfo) {
		// TODO Auto-generated method stub
		 ResponseUtil<Integer> result = new ResponseUtil<>();
	        if (houseInfo.getHId() == null || houseInfo.getHId() <= 0) {
	            result.setCode(400);
	            result.setMessage("格式不正确");
	            return result;
	        }
	        int i = 0;
	        try {
	            i = houseInfoMapper.update(houseInfo);
	            if (i == 1) {
	                result.setCode(200);
	                result.setMessage("更新成功");
	            } else {
	                result.setCode(500);
	                result.setMessage("更新失败");
	            }
	        } catch (Exception e) {
	            result.setCode(500);
	            result.setMessage("更新失败");
	        }
	        result.setData(i);
	        return result;
	}

	@Override
	public ResponseUtil<Integer> delete(Integer id) {
		// TODO Auto-generated method stub
		  ResponseUtil<Integer> result = new ResponseUtil<>();
	        int i = 0;
	        try {
	            i = houseInfoMapper.delete(id);
	            if (i == 1) {
	                result.setCode(200);
	                result.setMessage("删除成功");
	            } else {
	                result.setCode(500);
	                result.setMessage("删除失败");
	            }
	        } catch (Exception e) {
	            result.setCode(500);
	            result.setMessage("删除失败");
	        }
	        result.setData(i);
	        return result;
	}

	@Override
	public ResponseUtil<HouseInfo> findById(Integer id) {
		// TODO Auto-generated method stub
		ResponseUtil<HouseInfo> result = new ResponseUtil<>();
        if (id <= 0) {
            result.setCode(400);
            result.setMessage("格式不正确");
            return result;
        }
        HouseInfo houseInfo = null;
        try {
        	houseInfo = houseInfoMapper.findById(id);
            if (houseInfo == null) {
                result.setCode(300);
                result.setMessage("没有查询到数据");
            } else {
                result.setCode(200);
                result.setMessage("查询成功");
            }
        } catch (Exception e) {
            result.setCode(500);
            result.setMessage("查询失败");
        }
        result.setData(houseInfo);
        return result;
	}

	@Override
	public ResponseUtil<Integer> add(HouseInfo houseInfo) {
		// TODO Auto-generated method stub
		 ResponseUtil<Integer> result = new ResponseUtil<>();
	        int i = 0;
	        try {
	            i = houseInfoMapper.add(houseInfo);
	            if (i == 1) {
	                result.setCode(200);
	                result.setMessage("添加成功");
	            }
	        } catch (Exception e) {
	            result.setCode(500);
	            result.setMessage("添加失败");
	        }
	        result.setData(i);
	        return result;
	}

	@Override
	public ResponseUtil<List<HouseInfo>> findHouseInfoByAddress(String hAddress) {
		// TODO Auto-generated method stub
		 ResponseUtil<List<HouseInfo>> result = new ResponseUtil<>();
	        List<HouseInfo> houseInfo = new ArrayList<>();
	        try {
	        	houseInfo = houseInfoMapper.findHouseInfoByAddress(hAddress);
	            if (houseInfo.size() == 0) {
	                result.setCode(300);
	                result.setMessage("没有查询到数据");
	            } else {
	                result.setCode(200);
	                result.setMessage("查询成功");
	            }
	        } catch (Exception e) {
	            result.setCode(500);
	            result.setMessage("查询失败");
	        }
	        result.setData(houseInfo);
	        return result;
	}



	

}
