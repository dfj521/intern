package com.zzc.intern.service;

import com.zzc.intern.DTO.TraineeInfoAllDTO;
import com.zzc.intern.util.ResponseUtil;

import java.util.List;

public interface TraineeInfoAllService {

    ResponseUtil<List<TraineeInfoAllDTO>> findAll();

    ResponseUtil<List<TraineeInfoAllDTO>> findByCondition(TraineeInfoAllDTO traineeInfoAllDTO);

    ResponseUtil<Integer> addTrainee(TraineeInfoAllDTO traineeInfoAllDTO);
}
