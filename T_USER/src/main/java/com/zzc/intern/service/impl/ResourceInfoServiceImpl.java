package com.zzc.intern.service.impl;

import com.zzc.intern.DTO.ResourceInfoDTO;
import com.zzc.intern.entity.ResourceInfo;
import com.zzc.intern.mapper.ResourceInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.ResourceInfoService;
import com.zzc.intern.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 资源信息 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class ResourceInfoServiceImpl extends ServiceImpl<ResourceInfoMapper, ResourceInfo> implements ResourceInfoService {

    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    /**
     * 查询所有资源
     *
     * @return
     */
    @Override
    public ResponseUtil<List<ResourceInfo>> findAll() {
        ResponseUtil<List<ResourceInfo>> result = new ResponseUtil<>();
        List<ResourceInfo> resourceInfos = new ArrayList<>();
        try {
            resourceInfos = resourceInfoMapper.findAll();
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

    /**
     * 根据id查询一条资源信息
     *
     * @param id
     * @return
     */
    @Override
    public ResponseUtil<ResourceInfo> findById(Integer id) {
        ResponseUtil<ResourceInfo> result = new ResponseUtil<>();
        if (id <= 0) {
            result.setCode(400);
            result.setMessage("格式不正确");
            return result;
        }
        ResourceInfo resourceInfo = null;
        try {
            resourceInfo = resourceInfoMapper.findById(id);
            if (resourceInfo == null) {
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
        result.setData(resourceInfo);
        return result;
    }

    /**
     * 根据id查询资源信息和实习生信息
     *
     * @param id
     * @return
     */
    @Override
    public ResponseUtil<List<ResourceInfoDTO>> findByIdRAT(Integer id) {
        ResponseUtil<List<ResourceInfoDTO>> result = new ResponseUtil<>();
        if (id <= 0) {
            result.setCode(400);
            result.setMessage("格式不正确");
            return result;
        }
        List<ResourceInfoDTO> resourceInfoDTOS = new ArrayList<>();
        ResourceInfoDTO resourceInfoDTO = new ResourceInfoDTO();
        resourceInfoDTO.setRId(id);
        try {
            resourceInfoDTOS = resourceInfoMapper.findByCondition(resourceInfoDTO);
            result.setCode(200);
            result.setMessage("查询成功");
        } catch (Exception e) {
            result.setCode(500);
            result.setMessage("查询失败");
        }
        result.setData(resourceInfoDTOS);
        return result;
    }

    /**
     * 根据电脑名称模糊查询资源信息
     *
     * @param computer
     * @return
     */
    @Override
    public ResponseUtil<List<ResourceInfo>> findByComputer(String computer) {
        ResponseUtil<List<ResourceInfo>> result = new ResponseUtil<>();
        List<ResourceInfo> resourceInfos = new ArrayList<>();
        try {
            resourceInfos = resourceInfoMapper.findByComputer(computer);
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

    /**
     * 根据电脑名称模糊查询资源和实习生信息
     *
     * @param computer
     * @return
     */
    @Override
    public ResponseUtil<List<ResourceInfoDTO>> findByComputerRAT(String computer) {
        ResponseUtil<List<ResourceInfoDTO>> result = new ResponseUtil<>();
        if (computer == null || computer.equals("")) {
            result.setCode(400);
            result.setMessage("格式不正确");
            return result;
        }
        List<ResourceInfoDTO> resourceInfoDTOS = new ArrayList<>();
        ResourceInfoDTO resourceInfoDTO = new ResourceInfoDTO();
        resourceInfoDTO.setRComputer(computer);
        try {
            resourceInfoDTOS = resourceInfoMapper.findByCondition(resourceInfoDTO);
            result.setCode(200);
            result.setMessage("查询成功");
        } catch (Exception e) {
            result.setCode(500);
            result.setMessage("查询失败");
        }
        result.setData(resourceInfoDTOS);
        return result;
    }

    /**
     * 根据GitHub账号模糊查询资源信息
     *
     * @param gitHub
     * @return
     */
    @Override
    public ResponseUtil<List<ResourceInfo>> findByGitHub(String gitHub) {
        ResponseUtil<List<ResourceInfo>> result = new ResponseUtil<>();
        List<ResourceInfo> resourceInfos = new ArrayList<>();
        try {
            resourceInfos = resourceInfoMapper.findByGitHub(gitHub);
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

    /**
     * 根据GitHub账号模糊查询资源和实习生信息
     *
     * @param gitHub
     * @return
     */
    @Override
    public ResponseUtil<List<ResourceInfoDTO>> findByGitHubRAT(String gitHub) {
        ResponseUtil<List<ResourceInfoDTO>> result = new ResponseUtil<>();
        if (gitHub == null || gitHub.equals("")) {
            result.setCode(400);
            result.setMessage("格式不正确");
            return result;
        }
        List<ResourceInfoDTO> resourceInfoDTOS = new ArrayList<>();
        ResourceInfoDTO resourceInfoDTO = new ResourceInfoDTO();
        resourceInfoDTO.setRGithub(gitHub);
        try {
            resourceInfoDTOS = resourceInfoMapper.findByCondition(resourceInfoDTO);
            result.setCode(200);
            result.setMessage("查询成功");
        } catch (Exception e) {
            result.setCode(500);
            result.setMessage("查询失败");
        }
        result.setData(resourceInfoDTOS);
        return result;
    }

    /**
     * 添加一条资源信息
     *
     * @param resourceInfo
     * @return
     */
    @Override
    public ResponseUtil<Integer> add(ResourceInfo resourceInfo) {
        ResponseUtil<Integer> result = new ResponseUtil<>();
        int i = 0;
        try {
            i = resourceInfoMapper.add(resourceInfo);
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

    /**
     * 更新一条资源信息
     *
     * @param resourceInfo
     * @return
     */
    @Override
    public ResponseUtil<Integer> update(ResourceInfo resourceInfo) {
        ResponseUtil<Integer> result = new ResponseUtil<>();
        if (resourceInfo.getRId() == null || resourceInfo.getRId() <= 0) {
            result.setCode(400);
            result.setMessage("格式不正确");
            return result;
        }
        int i = 0;
        try {
            i = resourceInfoMapper.update(resourceInfo);
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

    /**
     * 删除一条资源信息
     *
     * @param id
     * @return
     */
    @Override
    public ResponseUtil<Integer> deleteById(Integer id) {
        ResponseUtil<Integer> result = new ResponseUtil<>();
        int i = 0;
        try {
            i = resourceInfoMapper.deleteById(id);
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

    /**
     * 查询所有资源和实习生信息
     *
     * @return
     */
    @Override
    public ResponseUtil<List<ResourceInfoDTO>> findResAndTra() {
        ResponseUtil<List<ResourceInfoDTO>> result = new ResponseUtil<>();
        List<ResourceInfoDTO> resourceInfos = new ArrayList<>();
        try {
            resourceInfos = resourceInfoMapper.findResAndTra();
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


}
