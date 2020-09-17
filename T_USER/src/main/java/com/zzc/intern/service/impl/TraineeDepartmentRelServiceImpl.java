package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.entity.TraineeDepartmentRel;
import com.zzc.intern.mapper.TraineeDepartmentRelMapper;
import com.zzc.intern.service.TraineeDepartmentRelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 实习生&部门 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-17
 */
@Slf4j
@Service
@Transactional
public class TraineeDepartmentRelServiceImpl extends ServiceImpl<TraineeDepartmentRelMapper, TraineeDepartmentRel> implements TraineeDepartmentRelService {

}
