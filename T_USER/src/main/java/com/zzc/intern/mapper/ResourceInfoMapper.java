package com.zzc.intern.mapper;

import com.zzc.intern.DTO.ResourceInfoDTO;
import com.zzc.intern.entity.ResourceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 资源信息 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface ResourceInfoMapper extends BaseMapper<ResourceInfo> {

    /**
     * 查询所有资源
     *
     * @return
     */
    List<ResourceInfo> findAll();

    /**
     * 查询所有资源和实习生信息
     *
     * @return
     */
    List<ResourceInfoDTO> findResAndTra();

    /**
     * 根据id查询一条资源信息
     *
     * @param id
     * @return
     */
    ResourceInfo findById(Integer id);

    /**
     * 根据电脑名称模糊查询资源信息
     *
     * @param computer
     * @return
     */
    List<ResourceInfo> findByComputer(String computer);

    /**
     * 根据GitHub账号模糊查询资源信息
     *
     * @param gitHub
     * @return
     */
    List<ResourceInfo> findByGitHub(String gitHub);

    /**
     * 添加一条资源信息
     *
     * @param resourceInfo
     * @return
     */
    int add(ResourceInfo resourceInfo);

    /**
     * 更新一条资源信息
     *
     * @param resourceInfo
     * @return
     */
    int update(ResourceInfo resourceInfo);

    /**
     * 删除一条资源信息
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据条件查询一条资源信息和实习生信息
     *
     * @param resourceInfoDTO
     * @return
     */
    List<ResourceInfoDTO> findByCondition(ResourceInfoDTO resourceInfoDTO);
}
