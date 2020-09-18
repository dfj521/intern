package com.zzc.intern.service;

import com.zzc.intern.DTO.ResourceInfoDTO;
import com.zzc.intern.entity.ResourceInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.util.ResponseUtil;

import java.util.List;

/**
 * <p>
 * 资源信息 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface ResourceInfoService extends IService<ResourceInfo> {

    /**
     * 查询所有资源
     *
     * @return
     */
    ResponseUtil<List<ResourceInfo>> findAll();

    /**
     * 根据id查询一条资源信息
     *
     * @param id
     * @return
     */
    ResponseUtil<ResourceInfo> findById(Integer id);

    /**
     * 根据电脑名称模糊查询资源信息
     *
     * @param computer
     * @return
     */
    ResponseUtil<List<ResourceInfo>> findByComputer(String computer);

    /**
     * 根据GitHub账号模糊查询资源信息
     *
     * @param gitHub
     * @return
     */
    ResponseUtil<List<ResourceInfo>> findByGitHub(String gitHub);

    /**
     * 添加一条资源信息
     *
     * @param resourceInfo
     * @return
     */
    ResponseUtil<Integer> add(ResourceInfo resourceInfo);

    /**
     * 更新一条资源信息
     *
     * @param resourceInfo
     * @return
     */
    ResponseUtil<Integer> update(ResourceInfo resourceInfo);

    /**
     * 删除一条资源信息
     *
     * @param id
     * @return
     */
    ResponseUtil<Integer> deleteById(Integer id);

    /**
     * 查询所有资源和实习生信息
     *
     * @return
     */
    ResponseUtil<List<ResourceInfoDTO>> findResAndTra();

    /**
     * 根据id查询资源信息和实习生信息
     *
     * @param id
     * @return
     */
    ResponseUtil<List<ResourceInfoDTO>> findByIdRAT(Integer id);

    /**
     * 根据电脑名称模糊查询资源和实习生信息
     *
     * @param computer
     * @return
     */
    ResponseUtil<List<ResourceInfoDTO>> findByComputerRAT(String computer);

    /**
     * 根据GitHub账号模糊查询资源和实习生信息
     *
     * @param gitHub
     * @return
     */
    ResponseUtil<List<ResourceInfoDTO>> findByGitHubRAT(String gitHub);
}
