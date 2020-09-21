package com.zzc.intern.mapper;

import com.zzc.intern.DTO.TraineeInfoAllDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeInfoAllMapper {

    List<TraineeInfoAllDTO> findByCondition(TraineeInfoAllDTO traineeInfoAllDTO);
}
