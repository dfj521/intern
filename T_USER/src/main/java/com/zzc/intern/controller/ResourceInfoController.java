package com.zzc.intern.controller;


import com.zzc.intern.entity.ResourceInfo;
import com.zzc.intern.service.ResourceInfoService;
import com.zzc.intern.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 资源信息 前端控制器
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@RestController
@Api(value = "实习生资源管理", tags = "实习生资源管理", description = "实习生资源管理")
@RequestMapping("/resourceInfo")
public class ResourceInfoController {

    @Autowired
    private ResourceInfoService resourceInfoService;

    /**
     * 查询所有资源
     *
     * @return
     */
    @ApiOperation("查询所有资源")
    @GetMapping("/findAll")
    public ResponseUtil<List<ResourceInfo>> findAll() {

        return resourceInfoService.findAll();

    }

    /**
     * 根据id查询一条资源信息
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id查询一条资源信息")
    @GetMapping("/findById/{id}")
    public ResponseUtil<ResourceInfo> findById(@PathVariable("id") Integer id) {

        return resourceInfoService.findById(id);

    }

    /**
     * 根据电脑名称模糊查询资源信息
     *
     * @param computer
     * @return
     */
    @ApiOperation("根据电脑名称模糊查询资源信息")
    @GetMapping("/findByComputer")
    public ResponseUtil<List<ResourceInfo>> findByComputer(String computer) {

        return resourceInfoService.findByComputer(computer);

    }

    /**
     * 根据GitHub账号模糊查询资源信息
     *
     * @param gitHub
     * @return
     */
    @ApiOperation("根据GitHub账号模糊查询资源信息")
    @GetMapping("/findByGitHub")
    public ResponseUtil<List<ResourceInfo>> findByGitHub(String gitHub) {

        return resourceInfoService.findByGitHub(gitHub);

    }

    /**
     * 添加一条资源信息
     *
     * @param resourceInfo
     * @return
     */
    @ApiOperation("添加一条资源信息")
    @PostMapping("/add")
    public ResponseUtil<Integer> add(ResourceInfo resourceInfo) {

        return resourceInfoService.add(resourceInfo);

    }

    /**
     * 更新一条资源信息
     *
     * @param resourceInfo
     * @return
     */
    @ApiOperation("更新一条资源信息")
    @PostMapping("/update")
    public ResponseUtil<Integer> update(ResourceInfo resourceInfo) {

        return resourceInfoService.update(resourceInfo);

    }

    /**
     * 删除一条资源信息
     *
     * @param id
     * @return
     */
    @ApiOperation("删除一条资源信息")
    @GetMapping("/deleteById/{id}")
    public ResponseUtil<Integer> deleteById(@PathVariable("id") Integer id) {

        return resourceInfoService.deleteById(id);

    }
}
