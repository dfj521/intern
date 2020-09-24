package com.zzc.intern.Convert;

import com.zzc.intern.DTO.TraineeDepartmentRelDTO;
import com.zzc.intern.entity.TraineeDepartmentRel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TraineeDepartmentRelConvert {

    TraineeDepartmentRelConvert INSTANCE = Mappers.getMapper(TraineeDepartmentRelConvert.class);

    TraineeDepartmentRelDTO TDREntity2TDRDto(TraineeDepartmentRel traineeDepartmentRel);

    List<TraineeDepartmentRelDTO> listTDREntity2listTDRDto(List<TraineeDepartmentRel> traineeDepartmentRels);
}
