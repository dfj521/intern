package com.zzc.intern.service.impl;

import com.zzc.intern.entity.AssessInfo;
import com.zzc.intern.mapper.AssessInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.AssessInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 考核信息 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class AssessInfoServiceImpl extends ServiceImpl<AssessInfoMapper, AssessInfo> implements AssessInfoService {

}
