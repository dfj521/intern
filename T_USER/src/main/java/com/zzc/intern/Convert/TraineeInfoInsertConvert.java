package com.zzc.intern.Convert;

import com.zzc.intern.DTO.TraineeInfoAllDTO;
import com.zzc.intern.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TraineeInfoInsertConvert {

    TraineeInfoInsertConvert INSTANCE = Mappers.getMapper(TraineeInfoInsertConvert.class);

    TraineeInfo dto2traineeInfo(TraineeInfoAllDTO traineeInfoAllDTO);

    TraineeDepartmentRel dto2traineeDepartmentRel(TraineeInfoAllDTO traineeInfoAllDTO);

    TraineeJobRel dto2traineeJobRel(TraineeInfoAllDTO traineeInfoAllDTO);

    TraineeResourceRel dto2traineeResourceRel(TraineeInfoAllDTO traineeInfoAllDTO);

    TraineeLearnRel dto2traineeLearnRel(TraineeInfoAllDTO traineeInfoAllDTO);

    TraineeHouseRel dto2traineeHouseRel(TraineeInfoAllDTO traineeInfoAllDTO);

    TraineeSubsidyRel dto2traineeSubsidyRel(TraineeInfoAllDTO traineeInfoAllDTO);
}
