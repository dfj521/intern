package com.zzc.intern.Convert;

import com.zzc.intern.DTO.TraineeInfoDTO;
import com.zzc.intern.entity.TraineeInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TraineeInfoConvert {

    TraineeInfoConvert INSTANCE = Mappers.getMapper(TraineeInfoConvert.class);

    TraineeInfo TISDto2TIEntity(TraineeInfoDTO traineeInfoDTO);

    TraineeInfoDTO TIEntity2TIDto(TraineeInfo traineeInfo);

    List<TraineeInfoDTO> listTIEntity2listTIDto(List<TraineeInfo> traineeInfoList);

}
