package com.zzc.intern.Convert;

import com.zzc.intern.DTO.TraineeInfoSaveDTO;
import com.zzc.intern.entity.TraineeInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TraineeInfoConvert {

    TraineeInfoConvert INSTANCE = Mappers.getMapper(TraineeInfoConvert.class);

    TraineeInfo TISDto2TIEntity(TraineeInfoSaveDTO traineeInfoSaveDTO);

}
