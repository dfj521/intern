package com.zzc.intern.service.impl;

import com.zzc.intern.DTO.JobInfoDTO;
import com.zzc.intern.entity.JobInfo;
import com.zzc.intern.entity.ResourceInfo;
import com.zzc.intern.mapper.JobInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.JobInfoService;
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
 * 岗位信息 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper, JobInfo> implements JobInfoService {
	@Resource
	private JobInfoMapper jobinfoMapper;
	@Override
	public ResponseUtil<Integer> insert(JobInfo jobInfo) {
		// TODO Auto-generated method stub
		  ResponseUtil<Integer> result = new ResponseUtil<>();
	        int i = 0;
	        try {
	            i = jobinfoMapper.insert(jobInfo);
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
	public ResponseUtil<List<JobInfo>> findAll() {
		// TODO Auto-generated method stub
		ResponseUtil<List<JobInfo>> result = new ResponseUtil<>();
		List<JobInfo> jonInfos= new ArrayList<>();
		  try {
			 jonInfos = jobinfoMapper.findAll();
	            if (jonInfos.size() == 0) {
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
	        result.setData(jonInfos);
	        return result;
	    }


	@Override
	public ResponseUtil<JobInfo>  findById(Integer jid) {
		// TODO Auto-generated method stub
		ResponseUtil<JobInfo> result = new ResponseUtil<>();
		if (jid <= 0) {
            result.setCode(400);
            result.setMessage("格式不正确");
            return result;
            }
		JobInfo jobInfo = null;
		 try {
			jobInfo  = jobinfoMapper.findById(jid);
	            if (jid <= 0) {
	                result.setCode(300);
	                result.setMessage("没有查到数据");
	            } else {
	                result.setCode(200);
	                result.setMessage("查询成功");
	            }
	        } catch (Exception e) {
	            result.setCode(500);
	            result.setMessage("查询失败");
	        }
	        result.setData(jobInfo);
	        return result;
	    }

	@Override
	public ResponseUtil<List<JobInfo>>findByName(String jName) {
		// TODO Auto-generated method stub
		ResponseUtil<List<JobInfo>> result = new ResponseUtil<>();
		List<JobInfo> jonInfos= new ArrayList<>();
		 try {
			 jonInfos  = jobinfoMapper.findByName(jName);
	            if (jonInfos.size() == 0) {
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
	        result.setData(jonInfos);
	        return result;
	    }
	

	@Override
	public ResponseUtil<Integer> updateId(JobInfo jobInfo) {
		// TODO Auto-generated method stub
		 ResponseUtil<Integer> result = new ResponseUtil<>();
	        if (jobInfo.getJId() == null ||jobInfo.getJId()  <= 0) {
	            result.setCode(400);
	            result.setMessage("格式不正确");
	            return result;
	        }
	        int i = 0;
	        try {
	            i = jobinfoMapper.updateId(jobInfo);
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



	public ResponseUtil<Integer> deleteId(Integer jid) {
		// TODO Auto-generated method stub
		 ResponseUtil<Integer> result = new ResponseUtil<>();
		//
		 
	        int i = 0;
	        try {
	            i = jobinfoMapper.deleteById(jid);
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
	public ResponseUtil<List<JobInfoDTO>> findId(Integer jId) {
		// TODO Auto-generated method stub
		ResponseUtil<List<JobInfoDTO>> result = new ResponseUtil<>();
		List<JobInfoDTO> jonInfos= new ArrayList<>();
		  try {
			 jonInfos = jobinfoMapper.findId(jId);
	            if (jonInfos.size() == 0) {
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
	        result.setData(jonInfos);
	        return result;
	}

	@Override
	public ResponseUtil<List<JobInfoDTO>> findGId(Integer jId) {
		// TODO Auto-generated method stub
		ResponseUtil<List<JobInfoDTO>> result = new ResponseUtil<>();
		List<JobInfoDTO> jonInfos= new ArrayList<>();
		  try {
			 jonInfos = jobinfoMapper.findGId(jId);
	            if (jonInfos.size() == 0) {
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
	        result.setData(jonInfos);
	        return result;
	
	}

	@Override
	public ResponseUtil<List<JobInfoDTO>> selectId(String jName) {
		// TODO Auto-generated method stub
		ResponseUtil<List<JobInfoDTO>> result = new ResponseUtil<>();
		List<JobInfoDTO> jonInfos= new ArrayList<>();
		 try {
			 jonInfos = jobinfoMapper.selectId(jName);
	            if (jonInfos.size() == 0) {
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
	        result.setData(jonInfos);
	        return result;
	}

	@Override
	public ResponseUtil<List<JobInfoDTO>> selectGId(String jName) {
		// TODO Auto-generated method stub
		ResponseUtil<List<JobInfoDTO>> result = new ResponseUtil<>();
		List<JobInfoDTO> jonInfos= new ArrayList<>();
		 try {
			 jonInfos = jobinfoMapper.selectGId(jName);
	            if (jonInfos.size() == 0) {
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
	        result.setData(jonInfos);
	        return result;
	}
}