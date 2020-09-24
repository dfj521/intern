package com.zzc.intern.service.impl;

import com.zzc.intern.DTO.DepartmentInfoDTO;
import com.zzc.intern.DTO.HouseInfoDTO;
import com.zzc.intern.entity.DepartmentInfo;
import com.zzc.intern.entity.HouseInfo;
import com.zzc.intern.entity.JobInfo;
import com.zzc.intern.entity.ResourceInfo;
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

	@Override
	public ResponseUtil<List<HouseInfo>> findAll() {
		// TODO Auto-generated method stub
		 ResponseUtil<List<HouseInfo>> result = new ResponseUtil<>();
	        List<HouseInfo> resourceInfos = new ArrayList<>();
	        try {
	            resourceInfos = houseInfoMapper.findAll();
	            if (resourceInfos.size() == 0) {
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
	        result.setData(resourceInfos);
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
		}
		 HouseInfo houseInfo = null;
		 try {
			 houseInfo = houseInfoMapper.findById(id);
			if (houseInfo == null) {
				result.setCode(300);
				result.setMessage("没有查询到数据");
			}else {
				result.setCode(200);
				result.setMessage("查询成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMessage("查询失败");
		}
		 result.setData(houseInfo);
		return result;
	}

	@Override
	public ResponseUtil<List<HouseInfo>> findHouseInfoByAddress(String hAddress) {
		// TODO Auto-generated method stub
		ResponseUtil<List<HouseInfo>> result = new ResponseUtil<>();
		List<HouseInfo> departmentInfos = new ArrayList<>();
		try {
			departmentInfos = houseInfoMapper.findHouseInfoByAddress(hAddress);
			if (departmentInfos.size() == 0) {
				result.setCode(300);
				result.setMessage("没有查询到数据");
			}else {
				result.setCode(200);
				result.setMessage("查询成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMessage("查询失败");
		}
		result.setData(departmentInfos);
		return result;
	}

	@Override
	public ResponseUtil<List<HouseInfoDTO>> findHousInfoById(Integer hId) {
		// TODO Auto-generated method stub
		ResponseUtil<List<HouseInfoDTO>> result = new ResponseUtil<>();
		List<HouseInfoDTO> departmentInfoDTOs = new ArrayList<>();
		if (hId <= 0) {
			result.setCode(400);
			result.setMessage("格式不正确");
		}
		 try {
			 departmentInfoDTOs = houseInfoMapper.findHousInfoById(hId);
			 if (departmentInfoDTOs == null) {
				result.setCode(300);
				result.setMessage("没有查询到数据");
			}else {
				result.setCode(200);
				result.setMessage("查询成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMessage("查询失败");
			System.out.println(e.getMessage());
		}
		 result.setData(departmentInfoDTOs);
		return result;
	}

	@Override
	public ResponseUtil<List<HouseInfoDTO>> findAssessByAddress(String hAddress) {
		// TODO Auto-generated method stub
		ResponseUtil<List<HouseInfoDTO>> result = new ResponseUtil<>();
		List<HouseInfoDTO> departmentInfos = new ArrayList<>();
		try {
			departmentInfos = houseInfoMapper.findAssessByAddress(hAddress);
			if (departmentInfos.size() == 0) {
				result.setCode(300);
				result.setMessage("没有查询到数据");
			}else {
				result.setCode(200);
				result.setMessage("查询成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMessage("查询失败");
		}
		result.setData(departmentInfos);
		return result;
	}

	@Override
	public ResponseUtil<HouseInfo> findNameById(Integer hId) {
		// TODO Auto-generated method stub
		 ResponseUtil<HouseInfo> result = new ResponseUtil<>();
		 if (hId <= 0) {
			result.setCode(400);
			result.setMessage("格式不正确");
		}
		 HouseInfo houseInfo = null;
		 try {
			 houseInfo = houseInfoMapper.findNameById(hId);
			if (houseInfo == null) {
				result.setCode(300);
				result.setMessage("没有查询到数据");
			}else {
				result.setCode(200);
				result.setMessage("查询成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMessage("查询失败");
		}
		 result.setData(houseInfo);
		return result;
	}

	

	
	



	

}
