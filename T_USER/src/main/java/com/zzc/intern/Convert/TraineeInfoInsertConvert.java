package com.zzc.intern.Convert;

import com.zzc.intern.DTO.TraineeInfoAllDTO;
import com.zzc.intern.entity.*;
import com.zzc.intern.vo.AssessInfoVO;
import com.zzc.intern.vo.LearnInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

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

    LearnInfoVO TLR2LIVO(TraineeLearnRel traineeLearnRel);

    LearnInfoVO LIVO2LI(LearnInfo learnInfos);

    AssessInfoVO AI2AIVO(AssessInfo assessInfo);

    List<LearnInfoVO> listTLR2listLIVO(List<TraineeLearnRel> traineeLearnRels);

    List<LearnInfoVO> listLI2listLIVO(List<LearnInfo> learnInfos);

    List<AssessInfoVO> listAI2listAIVO(List<AssessInfo> assessInfos);

}
