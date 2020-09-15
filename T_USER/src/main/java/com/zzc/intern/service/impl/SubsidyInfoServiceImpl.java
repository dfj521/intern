package com.zzc.intern.service.impl;

import com.zzc.intern.entity.SubsidyInfo;
import com.zzc.intern.mapper.SubsidyInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.SubsidyInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 补贴 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class SubsidyInfoServiceImpl extends ServiceImpl<SubsidyInfoMapper, SubsidyInfo> implements SubsidyInfoService {

}
