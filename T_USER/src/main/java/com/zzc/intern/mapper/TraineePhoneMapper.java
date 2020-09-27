package com.zzc.intern.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzc.intern.entity.TraineePhone;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-25
 */
@Repository
public interface TraineePhoneMapper extends BaseMapper<TraineePhone> {

    List<String> findBytId(Integer tId);
}
