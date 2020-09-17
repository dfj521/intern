package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.entity.DepartmentJobRel;
import com.zzc.intern.mapper.DepartmentJobRelMapper;
import com.zzc.intern.service.DepartmentJobRelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 部门&岗位 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-17
 */
@Slf4j
@Service
@Transactional
public class DepartmentJobRelServiceImpl extends ServiceImpl<DepartmentJobRelMapper, DepartmentJobRel> implements DepartmentJobRelService {

}