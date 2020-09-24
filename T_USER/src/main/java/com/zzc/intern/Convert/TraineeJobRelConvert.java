package com.zzc.intern.Convert;

import com.zzc.intern.DTO.TraineeJobRelDTO;
import com.zzc.intern.entity.TraineeJobRel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TraineeJobRelConvert {

    TraineeJobRelConvert INSTANCE = Mappers.getMapper(TraineeJobRelConvert.class);

    TraineeJobRelDTO TJREntity2TJRDto(TraineeJobRel traineeJobRel);

    List<TraineeJobRelDTO> listTJREntity2listTJRDto(List<TraineeJobRel> traineeJobRels);

}
