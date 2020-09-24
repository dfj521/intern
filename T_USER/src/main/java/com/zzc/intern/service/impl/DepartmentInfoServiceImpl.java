package com.zzc.intern.service.impl;

import com.zzc.intern.DTO.DepartmentInfoDTO;
import com.zzc.intern.entity.DepartmentInfo;
import com.zzc.intern.mapper.DepartmentInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.DepartmentInfoService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 部门信息 服务实现类
 * </p>
 * 
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class DepartmentInfoServiceImpl extends ServiceImpl<DepartmentInfoMapper, DepartmentInfo> implements DepartmentInfoService {
	@Autowired
	private DepartmentInfoMapper departmentInfoMapper;
	@ApiOperation("查询所有部门信息")
	@Override
	public ResponseUtil<List<DepartmentInfo>> findAll() {
		// TODO Auto-generated method stub
		ResponseUtil<List<DepartmentInfo>>  result =new ResponseUtil<>();
		List<DepartmentInfo> resuInfos = new ArrayList<>();
		try {
			 resuInfos = departmentInfoMapper.findAll();
			if (resuInfos.size()==0) {
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
		result.setData(resuInfos);
		return result;
	}
	@ApiOperation("通过id查询部门信息")
	@Override
	public ResponseUtil<DepartmentInfo> findById(Integer id) {
		// TODO Auto-generated method stub
		 ResponseUtil<DepartmentInfo> result = new ResponseUtil<>();
		 if (id <= 0) {
			result.setCode(400);
			result.setMessage("格式不正确");
		}
		 DepartmentInfo departmentInfo = null;
		 try {
			//departmentInfo = departmentInfoMapper.findById(id);
			if (departmentInfo == null) {
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
		 result.setData(departmentInfo);
		return result;
	}
	@ApiOperation("通过名字查询部门信息")
	@Override
	public ResponseUtil<List<DepartmentInfo>> selectName(String name) {
		// TODO Auto-generated method stub
		ResponseUtil<List<DepartmentInfo>> result = new ResponseUtil<>();
		List<DepartmentInfo> departmentInfos = new ArrayList<>();
		try {
			departmentInfos = departmentInfoMapper.selectName(name);
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
	@ApiOperation("通过id删除部门信息")
	@Override
	public ResponseUtil<Integer> delete(Integer id) {
		// TODO Auto-generated method stub
		ResponseUtil<Integer> result = new ResponseUtil<>();
		int i = 0;
		try {
			i = departmentInfoMapper.deleteById(id);
			if (i == 1) {
				result.setCode(200);
				result.setMessage("删除成功");
			}else {
				result.setCode(500);
				result.setMessage("删除失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMessage("删除失败");
		}
		result.setData(i);
		return result;
	}
	@ApiOperation("修改部门信息")
	@Override
	public ResponseUtil<Integer> update(DepartmentInfo departmentInfo) {
		// TODO Auto-generated method stub
		ResponseUtil<Integer> result = new ResponseUtil<>();
		if (departmentInfo.getDId() == null || departmentInfo.getDId() <=0 ) {
			result.setCode(400);
			result.setMessage("格式不正确");
			return result;
		}
		int i = 0;
		try {
			i = departmentInfoMapper.update(departmentInfo);
			if (i == 1) {
				result.setCode(200);
				result.setMessage("更新成功");
			}else {
				result.setCode(500);
				result.setMessage("更新失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMessage("更新失败");
		}
		result.setData(i);
		return result;
	}
	@ApiOperation("添加部门信息")
	@Override
	public ResponseUtil<Integer> add(DepartmentInfo departmentInfo) {
		// TODO Auto-generated method stub
		ResponseUtil<Integer> result = new ResponseUtil<>();
		int i = 0;
		try {
			i = departmentInfoMapper.add(departmentInfo);
			if (i == 1) {
				result.setCode(200);
				result.setMessage("添加成功");
			}else {
				result.setCode(500);
				result.setMessage("添加失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setCode(500);
			result.setMessage("添加失败");
		}
		result.setData(i);
		return result;
	}
	@ApiOperation("通过部门id查询部门中的岗位信息")
	@Override
	public ResponseUtil<List<DepartmentInfoDTO>>  selectById(Integer id) {
		// TODO Auto-generated method stub
		ResponseUtil<List<DepartmentInfoDTO>> result = new ResponseUtil<>();
		List<DepartmentInfoDTO> departmentInfoDTOs = new ArrayList<>();
		if (id <= 0) {
			result.setCode(400);
			result.setMessage("格式不正确");
		}
		 try {
			 //departmentInfoDTOs = departmentInfoMapper.selectById(id);
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
	@ApiOperation("通过部门名称模糊查询部门信息和岗位信息")
	@Override
	public ResponseUtil<List<DepartmentInfoDTO>> selectByName(String dName){
		// TODO Auto-generated method stub
		
		  ResponseUtil<List<DepartmentInfoDTO>> result = new ResponseUtil<>();
		  List<DepartmentInfoDTO> departmentInfoDTOs = new ArrayList<>();
		  try {
		  departmentInfoDTOs = departmentInfoMapper.selectByName(dName);
		  if(departmentInfoDTOs == null) 
		  { result.setCode(300);
		  result.setMessage("没有查询到数据"); 
		  }else { 
			  result.setCode(200);
		  result.setMessage("查询成功"); 
		  } 
		  } catch (Exception e) {
			result.setCode(500); 
			result.setMessage("查询失败"); 
		}
		  result.setData(departmentInfoDTOs);
		 return result;
		
	}
	@Override
	@ApiOperation("通过岗位名称模糊查询部门信息和岗位信息")
	public ResponseUtil<List<DepartmentInfoDTO>> selectByJname(String jName) {
		// TODO Auto-generated method stub
		ResponseUtil<List<DepartmentInfoDTO>> result = new ResponseUtil<>();
		List<DepartmentInfoDTO> departmentInfos = new ArrayList<>();
		try {
			departmentInfos = departmentInfoMapper.selectByJname(jName);
			if (departmentInfos == null) {
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
	@ApiOperation("查询某个部门的实习生考核信息")
	public ResponseUtil<List<DepartmentInfoDTO>> selectByLearn(Integer tId,String dName) {
		// TODO Auto-generated method stub
		ResponseUtil<List<DepartmentInfoDTO>> result = new ResponseUtil<>();
		List<DepartmentInfoDTO> departmentInfos = new ArrayList<>();
		try {
			departmentInfos = departmentInfoMapper.selectByLearn(tId,dName);
			if (tId == null || dName == null) {
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
}
