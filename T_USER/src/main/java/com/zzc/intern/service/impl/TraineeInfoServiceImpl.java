package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzc.intern.Convert.TraineeInfoConvert;
import com.zzc.intern.DTO.TraineeInfoDTO;
import com.zzc.intern.entity.*;
import com.zzc.intern.exception.BusinessException;
import com.zzc.intern.exception.CommonErrorCode;
import com.zzc.intern.mapper.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.requestbody.ReqTraineeInfo;
import com.zzc.intern.service.TraineeInfoService;
import com.zzc.intern.vo.TraineeInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 实习生个人信息 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class TraineeInfoServiceImpl extends ServiceImpl<TraineeInfoMapper, TraineeInfo> implements TraineeInfoService {

    @Autowired
    private TraineeInfoMapper traineeInfoMapper;

    @Autowired
    private TraineePhoneMapper traineePhoneMapper;

    @Autowired
    private TraineeBankMapper traineeBankMapper;

    @Autowired
    private TraineeContactsMapper traineeContactsMapper;

    @Autowired
    private TraineeCourseRelMapper traineeCourseRelMapper;

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    /**
     * 添加实习生信息
     *
     * @param traineeInfoDTO 实习生对象
     * @return 是否添加成功
     */
    @Override
    public boolean add(TraineeInfoDTO traineeInfoDTO) throws BusinessException {

        //校验参数
        if (traineeInfoDTO == null) {
            throw new BusinessException(CommonErrorCode.E_100108);
        }
        String traineeName = traineeInfoDTO.getTraineeName();
        String traineePhoneNumber = traineeInfoDTO.getTraineePhoneNumber();
        String traineeBankName = traineeInfoDTO.getTraineeBankName();
        String traineeBankCard = traineeInfoDTO.getTraineeBankCard();
        String traineeContactsName = traineeInfoDTO.getTraineeContactsName();
        String traineeContactsRelation = traineeInfoDTO.getTraineeContactsRelation();
        String traineeContactsPhone = traineeInfoDTO.getTraineeContactsPhone();
        if (
                traineeName == null || "".equals(traineeName) ||
                        traineePhoneNumber == null || "".equals(traineePhoneNumber) ||
                        traineeBankName == null || "".equals(traineeBankName) ||
                        traineeContactsName == null || "".equals(traineeContactsName) ||
                        traineeBankCard == null || "".equals(traineeBankCard) ||
                        traineeContactsRelation == null || "".equals(traineeContactsRelation) ||
                        traineeContactsPhone == null || "".equals(traineeContactsPhone)
        ) {
            throw new BusinessException(CommonErrorCode.E_100101);
        }

        //添加实习生信息
        TraineeInfo traineeInfo = TraineeInfoConvert.INSTANCE.TISDto2TIEntity(traineeInfoDTO);
        traineeInfo.setTraineeId(null);
        traineeInfo.setTraineeStatus("1");
        traineeInfoMapper.insert(traineeInfo);

        //获取添加的实习生id
        Integer tId = traineeInfo.getTraineeId();

        //添加实习生的电话信息
        TraineePhone traineePhone = new TraineePhone();
        traineePhone.setTraineeId(tId);
        traineePhone.setTraineePhoneNumber(traineePhoneNumber);
        traineePhone.setTraineePhoneStatus("1");
        traineePhoneMapper.insert(traineePhone);
        String phoneNumber2 = traineeInfoDTO.getTraineePhoneNumber2();
        if (phoneNumber2 != null && !"".equals(phoneNumber2)) {
            traineePhone.setId(null);
            traineePhone.setTraineePhoneNumber(phoneNumber2);
            traineePhoneMapper.insert(traineePhone);
        }

        //添加实习生的银行卡信息
        TraineeBank traineeBank = new TraineeBank();
        traineeBank.setTraineeId(tId);
        traineeBank.setTraineeBankCard(traineeBankCard);
        traineeBank.setTraineeBankName(traineeBankName);
        traineeBank.setTraineeBankStatus("1");
        traineeBankMapper.insert(traineeBank);
        String bankCard2 = traineeInfoDTO.getTraineeBankCard2();
        String bankName2 = traineeInfoDTO.getTraineeBankName2();
        if (bankCard2 != null && !"".equals(bankCard2) &&
                bankName2 != null && !"".equals(bankName2)) {
            traineeBank.setId(null);
            traineeBank.setTraineeBankCard(bankCard2);
            traineeBank.setTraineeBankName(bankName2);
            traineeBankMapper.insert(traineeBank);
        }


        //添加实习生的紧急联系人信息
        TraineeContacts traineeContacts = new TraineeContacts();
        traineeContacts.setTraineeId(tId);
        traineeContacts.setTraineeContactsName(traineeContactsName);
        traineeContacts.setTraineeContactsRelation(traineeContactsRelation);
        traineeContacts.setTraineeContactsPhone(traineeContactsPhone);
        traineeContacts.setTraineeContactsStatus("1");
        int i = traineeContactsMapper.insert(traineeContacts);
        String contactsName2 = traineeInfoDTO.getTraineeContactsName2();
        String contactsRelation2 = traineeInfoDTO.getTraineeContactsRelation2();
        String contactsPhone2 = traineeInfoDTO.getTraineeContactsPhone2();
        if (contactsName2 != null && !"".equals(contactsName2) &&
                contactsRelation2 != null && !"".equals(bankName2) &&
                contactsPhone2 != null && !"".equals(contactsPhone2)) {
            traineeContacts.setId(null);
            traineeContacts.setTraineeContactsName(contactsName2);
            traineeContacts.setTraineeContactsRelation(contactsRelation2);
            traineeContacts.setTraineeContactsPhone(contactsPhone2);
            traineeContactsMapper.insert(traineeContacts);
        }

        //返回是否添加成功
        return i > 0;
    }

    /**
     * 根据条件查询实习生信息
     *
     * @param reqTraineeInfo 实习生的条件查询信息
     * @return 实习生的基本信息
     */
    @Override
    public TraineeInfoVO queryByCondition(ReqTraineeInfo reqTraineeInfo) throws BusinessException {
        TraineeInfoVO traineeInfoVO = new TraineeInfoVO();

        Integer current = reqTraineeInfo.getCurrent();
        Integer size = reqTraineeInfo.getSize();
        String tName = reqTraineeInfo.getTName();
        LocalDateTime startTime = reqTraineeInfo.getStartTime();
        LocalDateTime endTime = reqTraineeInfo.getEndTime();

        if (current == null || size == null) {
            return null;
        }

        IPage<TraineeInfo> traineeInfoIPage = traineeInfoMapper.selectPage(
                new Page<>(current, size), new LambdaQueryWrapper<TraineeInfo>()
                        .eq(tName != null && !"".equals(tName), TraineeInfo::getTraineeName, tName)
                        .ge(startTime != null, TraineeInfo::getTraineeEntryTime, startTime)
                        .le(endTime != null, TraineeInfo::getTraineeEntryTime, endTime)
                        .eq(TraineeInfo::getTraineeStatus, "1"));

        List<TraineeInfo> traineeInfos = traineeInfoIPage.getRecords();

        if (traineeInfos.size() == 0) {
            traineeInfoVO.setCurrent(current);
            traineeInfoVO.setSize(size);
            traineeInfoVO.setTotal(traineeInfoIPage.getTotal());
            return traineeInfoVO;
        }

        List<TraineeInfoDTO> traineeInfoDTOS = TraineeInfoConvert.INSTANCE.listTIEntity2listTIDto(traineeInfos);

        for (TraineeInfoDTO traineeInfoDTO : traineeInfoDTOS) {
            Integer tId = traineeInfoDTO.getTraineeId();
            List<TraineePhone> traineePhones = traineePhoneMapper.selectList(
                    new LambdaQueryWrapper<TraineePhone>()
                            .eq(TraineePhone::getTraineeId, tId)
                            .eq(TraineePhone::getTraineePhoneStatus, "1"));
            List<TraineeBank> traineeBanks = traineeBankMapper.selectList(
                    new LambdaQueryWrapper<TraineeBank>()
                            .eq(TraineeBank::getTraineeId, tId)
                            .eq(TraineeBank::getTraineeBankStatus, "1"));
            List<TraineeContacts> traineeContacts = traineeContactsMapper.selectList(
                    new LambdaQueryWrapper<TraineeContacts>()
                            .eq(TraineeContacts::getTraineeId, tId)
                            .eq(TraineeContacts::getTraineeContactsStatus, "1"));

            //实习生的课程信息
            TraineeCourseRel traineeCourseRel = traineeCourseRelMapper.selectOne(
                    new LambdaQueryWrapper<TraineeCourseRel>()
                            .eq(TraineeCourseRel::getTraineeId, tId)
                            .eq(TraineeCourseRel::getTraineeCourseStatus, "1"));
            if (traineeCourseRel != null) {
                CourseInfo courseInfo = courseInfoMapper.selectOne(
                        new LambdaQueryWrapper<CourseInfo>()
                                .eq(CourseInfo::getCourseId, traineeCourseRel.getCourseId()));
                traineeInfoDTO.setCourseName(courseInfo.getCourseName());
            }

            traineeInfoDTO.setTraineePhoneNumber(traineePhones.get(0).getTraineePhoneNumber());
            traineeInfoDTO.setTraineeBankName(traineeBanks.get(0).getTraineeBankName());
            traineeInfoDTO.setTraineeBankCard(traineeBanks.get(0).getTraineeBankCard());
            traineeInfoDTO.setTraineeContactsName(traineeContacts.get(0).getTraineeContactsName());
            traineeInfoDTO.setTraineeContactsRelation(traineeContacts.get(0).getTraineeContactsRelation());
            traineeInfoDTO.setTraineeContactsPhone(traineeContacts.get(0).getTraineeContactsPhone());
        }

        traineeInfoVO.setCurrent(current);
        traineeInfoVO.setSize(size);
        traineeInfoVO.setTotal(traineeInfoIPage.getTotal());
        traineeInfoVO.setTraineeInfoDTOList(traineeInfoDTOS);
        return traineeInfoVO;
    }

    /**
     * 根据id删除实习生基本信息
     *
     * @param tId 实习生工号
     * @return 是否成功删除
     */
    @Override
    public boolean deleteById(Integer tId) throws BusinessException {
        int i = 0;
        //删除实习生基本信息
        Integer tiCount = traineeInfoMapper.selectCount(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(TraineeInfo::getTraineeId, tId)
                        .eq(TraineeInfo::getTraineeStatus, "1"));
        if (tiCount > 0) {
            TraineeInfo traineeInfo = new TraineeInfo();
            traineeInfo.setTraineeStatus("0");
            i = traineeInfoMapper.update(traineeInfo,
                    new LambdaUpdateWrapper<TraineeInfo>()
                            .eq(TraineeInfo::getTraineeId, tId));
        }

        //删除实习生的电话信息
        Integer tpCount = traineePhoneMapper.selectCount(
                new LambdaQueryWrapper<TraineePhone>()
                        .eq(TraineePhone::getTraineeId, tId)
                        .eq(TraineePhone::getTraineePhoneStatus, "1"));
        if (tpCount > 0) {
            TraineePhone traineePhone = new TraineePhone();
            traineePhone.setTraineePhoneStatus("0");
            i = traineePhoneMapper.update(traineePhone,
                    new LambdaUpdateWrapper<TraineePhone>()
                            .eq(TraineePhone::getTraineeId, tId));
        }

        //删除实习生的银行卡信息
        Integer tbCount = traineeBankMapper.selectCount(
                new LambdaQueryWrapper<TraineeBank>()
                        .eq(TraineeBank::getTraineeId, tId)
                        .eq(TraineeBank::getTraineeBankStatus, "1"));
        if (tbCount > 0) {
            TraineeBank traineeBank = new TraineeBank();
            traineeBank.setTraineeBankStatus("0");
            i = traineeBankMapper.update(traineeBank,
                    new LambdaUpdateWrapper<TraineeBank>()
                            .eq(TraineeBank::getTraineeId, tId));
        }

        //删除实习生的紧急联系人信息
        Integer trCount = traineeContactsMapper.selectCount(
                new LambdaQueryWrapper<TraineeContacts>()
                        .eq(TraineeContacts::getTraineeId, tId)
                        .eq(TraineeContacts::getTraineeContactsStatus, "1"));
        if (trCount > 0) {
            TraineeContacts traineeContacts = new TraineeContacts();
            traineeContacts.setTraineeContactsStatus("0");
            i = traineeContactsMapper.update(traineeContacts,
                    new LambdaUpdateWrapper<TraineeContacts>()
                            .eq(TraineeContacts::getTraineeId, tId));
        }

        return i > 0;
    }

    /**
     * 根据id查询实习生信息
     *
     * @param tId 实习生工号
     * @return 实习生信息
     */
    @Override
    public TraineeInfoDTO queryById(Integer tId) throws BusinessException {
        TraineeInfo traineeInfo = traineeInfoMapper.selectOne(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(TraineeInfo::getTraineeId, tId)
                        .eq(TraineeInfo::getTraineeStatus, "1"));

        TraineeInfoDTO traineeInfoDTO = TraineeInfoConvert.INSTANCE.TIEntity2TIDto(traineeInfo);

        List<TraineePhone> traineePhones = traineePhoneMapper.selectList(
                new LambdaQueryWrapper<TraineePhone>()
                        .eq(TraineePhone::getTraineeId, tId)
                        .eq(TraineePhone::getTraineePhoneStatus, "1"));

        List<TraineeBank> traineeBanks = traineeBankMapper.selectList(
                new LambdaQueryWrapper<TraineeBank>()
                        .eq(TraineeBank::getTraineeId, tId)
                        .eq(TraineeBank::getTraineeBankStatus, "1"));

        List<TraineeContacts> traineeContacts = traineeContactsMapper.selectList(
                new LambdaQueryWrapper<TraineeContacts>()
                        .eq(TraineeContacts::getTraineeId, tId)
                        .eq(TraineeContacts::getTraineeContactsStatus, "1"));

        traineeInfoDTO.setTraineePhoneNumber(traineePhones.get(0).getTraineePhoneNumber());
        if (traineePhones.size() > 1) {
            traineeInfoDTO.setTraineePhoneNumber2(traineePhones.get(1).getTraineePhoneNumber());
        }
        traineeInfoDTO.setTraineeBankName(traineeBanks.get(0).getTraineeBankName());
        traineeInfoDTO.setTraineeBankCard(traineeBanks.get(0).getTraineeBankCard());
        if (traineeBanks.size() > 1) {
            traineeInfoDTO.setTraineeBankName2(traineeBanks.get(1).getTraineeBankName());
            traineeInfoDTO.setTraineeBankCard2(traineeBanks.get(1).getTraineeBankCard());
        }
        traineeInfoDTO.setTraineeContactsName(traineeContacts.get(0).getTraineeContactsName());
        traineeInfoDTO.setTraineeContactsRelation(traineeContacts.get(0).getTraineeContactsRelation());
        traineeInfoDTO.setTraineeContactsPhone(traineeContacts.get(0).getTraineeContactsPhone());
        if (traineeContacts.size() > 1) {
            traineeInfoDTO.setTraineeContactsName2(traineeContacts.get(1).getTraineeContactsName());
            traineeInfoDTO.setTraineeContactsRelation2(traineeContacts.get(1).getTraineeContactsRelation());
            traineeInfoDTO.setTraineeContactsPhone2(traineeContacts.get(1).getTraineeContactsPhone());
        }

        return traineeInfoDTO;
    }

    /**
     * 根据id更新实习生基本信息
     *
     * @param traineeInfoDTO 实习生对象
     * @return 是否保存成功
     */
    @Override
    public boolean saveById(TraineeInfoDTO traineeInfoDTO) throws BusinessException {

        //校验参数
        Integer traineeId = traineeInfoDTO.getTraineeId();
        String traineeName = traineeInfoDTO.getTraineeName();
        String traineePhoneNumber = traineeInfoDTO.getTraineePhoneNumber();
        String traineeBankName = traineeInfoDTO.getTraineeBankName();
        String traineeBankCard = traineeInfoDTO.getTraineeBankCard();
        String traineeContactsName = traineeInfoDTO.getTraineeContactsName();
        String traineeContactsRelation = traineeInfoDTO.getTraineeContactsRelation();
        String traineeContactsPhone = traineeInfoDTO.getTraineeContactsPhone();
        if (
                traineeId == null || traineeName == null || "".equals(traineeName) ||
                        traineePhoneNumber == null || "".equals(traineePhoneNumber) ||
                        traineeBankName == null || "".equals(traineeBankName) ||
                        traineeContactsName == null || "".equals(traineeContactsName) ||
                        traineeBankCard == null || "".equals(traineeBankCard) ||
                        traineeContactsRelation == null || "".equals(traineeContactsRelation) ||
                        traineeContactsPhone == null || "".equals(traineeContactsPhone)
        ) {
            return false;
        }

        //查询是否有这条记录
        TraineeInfo info = traineeInfoMapper.selectById(traineeId);
        List<TraineePhone> traineePhones = traineePhoneMapper.selectList(
                new LambdaQueryWrapper<TraineePhone>()
                        .eq(TraineePhone::getTraineeId, traineeId)
                        .eq(TraineePhone::getTraineePhoneStatus, "1"));
        List<TraineeBank> traineeBanks = traineeBankMapper.selectList(
                new LambdaQueryWrapper<TraineeBank>()
                        .eq(TraineeBank::getTraineeId, traineeId)
                        .eq(TraineeBank::getTraineeBankStatus, "1"));
        List<TraineeContacts> traineeContactsList = traineeContactsMapper.selectList(
                new LambdaQueryWrapper<TraineeContacts>()
                        .eq(TraineeContacts::getTraineeId, traineeId)
                        .eq(TraineeContacts::getTraineeContactsStatus, "1"));
        if (info == null || traineePhones.size() == 0 ||
                traineeBanks.size() == 0 || traineeContactsList.size() == 0) {
            return false;
        }

        int i;

        //修改实习生信息
        TraineeInfo traineeInfo = TraineeInfoConvert.INSTANCE.TISDto2TIEntity(traineeInfoDTO);
        traineeInfoMapper.updateById(traineeInfo);

        //修改实习生电话
        TraineePhone traineePhone = new TraineePhone();
        traineePhone.setId(traineePhones.get(0).getId());
        traineePhone.setTraineePhoneNumber(traineePhoneNumber);
        traineePhoneMapper.updateById(traineePhone);
        String phoneNumber2 = traineeInfoDTO.getTraineePhoneNumber2();
        if (phoneNumber2 != null && !phoneNumber2.trim().equals("")) {
            traineePhone.setId(null);
            traineePhone.setTraineePhoneNumber(traineeInfoDTO.getTraineePhoneNumber2());
            traineePhone.setTraineePhoneStatus("1");
            traineePhone.setTraineeId(traineeId);
            if (traineePhones.size() > 1) {
                traineePhone.setId(traineePhones.get(1).getId());
                traineePhone.setTraineePhoneStatus(null);
                traineePhone.setTraineeId(null);
                traineePhoneMapper.updateById(traineePhone);
            } else {
                traineePhoneMapper.insert(traineePhone);
            }
        }

        //修改实习生银行卡
        TraineeBank traineeBank = new TraineeBank();
        traineeBank.setId(traineeBanks.get(0).getId());
        traineeBank.setTraineeBankName(traineeBankName);
        traineeBank.setTraineeBankCard(traineeBankCard);
        traineeBankMapper.updateById(traineeBank);
        String bankCard2 = traineeInfoDTO.getTraineeBankCard2();
        String bankName2 = traineeInfoDTO.getTraineeBankName2();
        if (bankName2 != null && !bankName2.trim().equals("") &&
                bankCard2 != null && !bankCard2.trim().equals("")) {
            traineeBank.setId(null);
            traineeBank.setTraineeBankName(bankName2);
            traineeBank.setTraineeBankCard(bankCard2);
            traineeBank.setTraineeBankStatus("1");
            traineeBank.setTraineeId(traineeId);
            if (traineeBanks.size() > 1) {
                traineeBank.setId(traineeBanks.get(1).getId());
                traineeBank.setTraineeBankName(bankName2);
                traineeBank.setTraineeBankCard(bankCard2);
                traineeBank.setTraineeBankStatus(null);
                traineeBank.setTraineeId(null);
                traineeBankMapper.updateById(traineeBank);
            } else {
                traineeBankMapper.insert(traineeBank);
            }

        }

        //修改实习生紧急联系人
        TraineeContacts traineeContacts = new TraineeContacts();
        traineeContacts.setId(traineeContactsList.get(0).getId());
        traineeContacts.setTraineeContactsName(traineeContactsName);
        traineeContacts.setTraineeContactsRelation(traineeContactsRelation);
        traineeContacts.setTraineeContactsPhone(traineeContactsPhone);
        i = traineeContactsMapper.updateById(traineeContacts);
        String contactsName2 = traineeInfoDTO.getTraineeContactsName2();
        String contactsRelation2 = traineeInfoDTO.getTraineeContactsRelation2();
        String contactsPhone2 = traineeInfoDTO.getTraineeContactsPhone2();
        if (contactsName2 != null && !contactsName2.trim().equals("") &&
                contactsRelation2 != null && !contactsRelation2.trim().equals("") &&
                contactsPhone2 != null && !contactsPhone2.trim().equals("")) {
            traineeContacts.setId(null);
            traineeContacts.setTraineeContactsName(contactsName2);
            traineeContacts.setTraineeContactsRelation(contactsRelation2);
            traineeContacts.setTraineeContactsPhone(contactsPhone2);
            traineeContacts.setTraineeContactsStatus("1");
            traineeContacts.setTraineeId(traineeId);
            if (traineeContactsList.size() > 1) {
                traineeContacts.setId(traineeContactsList.get(1).getId());
                traineeContacts.setTraineeContactsName(contactsName2);
                traineeContacts.setTraineeContactsRelation(contactsRelation2);
                traineeContacts.setTraineeContactsPhone(contactsPhone2);
                traineeContacts.setTraineeContactsStatus(null);
                traineeContacts.setTraineeId(null);
                i = traineeContactsMapper.updateById(traineeContacts);
            } else {
                i = traineeContactsMapper.insert(traineeContacts);
            }
        }

        return i > 0;
    }
}
