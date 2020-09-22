package com.zzc.intern.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value="TraineeInfoAllDTO", description="实习生所有信息")
public class TraineeInfoAllDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生id
     */
    @ApiModelProperty(value = "实习生id", example = "0")
    private Integer tId;

    /**
     * 实习生姓名
     */
    @ApiModelProperty("实习生姓名")
    private String tName;

    /**
     * 实习生性别
     */
    @ApiModelProperty("实习生性别")
    private String tSex;

    /**
     * 实习生年龄
     */
    @ApiModelProperty(value = "实习生年龄", example = "0")
    private Integer tAge;

    /**
     * 实习生最大年龄
     */
    @ApiModelProperty(value = "实习生最大年龄", example = "0")
    private Integer maxTAge;

    /**
     * 实习生最小年龄
     */
    @ApiModelProperty(value = "实习生最小年龄", example = "0")
    private Integer minTAge;

    /**
     * 实习生出生日期
     */
    @ApiModelProperty("实习生出生日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime tBirthday;

    /**
     * 实习生身份证号
     */
    @ApiModelProperty("实习生身份证号")
    private String tIdCard;

    /**
     * 实习生手机号1
     */
    @ApiModelProperty("实习生手机号1")
    private String tPhone1;

    /**
     * 实习生手机号2
     */
    @ApiModelProperty("实习生手机号2")
    private String tPhone2;

    /**
     * 实习生银行卡号1
     */
    @ApiModelProperty("实习生银行卡号1")
    private String tBankNum1;

    /**
     * 实习生银行卡号2
     */
    @ApiModelProperty("实习生银行卡号2")
    private String tBankNum2;

    /**
     * 实习生家庭住址
     */
    @ApiModelProperty("实习生家庭住址")
    private String tAddress;

    /**
     * 实习生紧急联系人1电话
     */
    @ApiModelProperty("实习生紧急联系人1电话")
    private String tWornningNum1;

    /**
     * 实习生紧急联系人1关系
     */
    @ApiModelProperty("实习生紧急联系人1关系")
    private String tWornningRelation1;

    /**
     * 实习生紧急联系人1姓名
     */
    @ApiModelProperty("实习生紧急联系人1姓名")
    private String tWornningName1;

    /**
     * 实习生紧急联系人2电话
     */
    @ApiModelProperty("实习生紧急联系人2电话")
    private String tWornningNum2;

    /**
     * 实习生紧急联系人2关系
     */
    @ApiModelProperty("实习生紧急联系人2关系")
    private String tWornningRelation2;

    /**
     * 实习生紧急联系人2姓名
     */
    @ApiModelProperty("实习生紧急联系人2姓名")
    private String tWornningName2;

    /**
     * 实习生学历
     */
    @ApiModelProperty("实习生学历")
    private String tEducation;

    /**
     * 实习生毕业学校
     */
    @ApiModelProperty("实习生毕业学校")
    private String tSchool;

    /**
     * 实习生毕业院系
     */
    @ApiModelProperty("实习生毕业院系")
    private String tFaculty;

    /**
     * 实习生专业
     */
    @ApiModelProperty("实习生专业")
    private String tMajor;

    /**
     * 实习生入职时间
     */
    @ApiModelProperty("实习生入职时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime tEntryTime;

    /**
     * 实习生最小入职时间
     */
    @ApiModelProperty("实习生最小入职时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime maxTEntryTime;

    /**
     * 实习生最大入职时间
     */
    @ApiModelProperty("实习生最大入职时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime minTEntryTime;

    /**
     * 实习生修改时间
     */
    @ApiModelProperty("实习生修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime tUpdateTime;

    /**
     * 实习生状态（0：不存在，1：存在）
     */
    private String tStatus;

    /**
     * 实习生&部门id
     */
    private Integer tdId;

    /**
     * 实习生&部门状态（0：不存在，1：存在）
     */
    private String tdStatus;

    /**
     * 部门编号
     */
    @ApiModelProperty(value = "部门编号", example = "0")
    private Integer dId;

    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String dName;

    /**
     * 部门状态（0：不存在，1：存在）
     */
    private String dStatus;

    /**
     * 实习生&岗位id
     */
    private Integer tjId;

    /**
     * 实习生&岗位状态（0：不存在，1：存在）
     */
    private String tjStatus;

    /**
     * 部门&岗位id
     */
    private Integer djId;

    /**
     * 部门&岗位状态（0：不存在，1：存在）
     */
    private String djStatus;

    /**
     * 岗位编号
     */
    @ApiModelProperty(value = "岗位编号", example = "0")
    private Integer jId;

    /**
     * 岗位名称
     */
    @ApiModelProperty("岗位名称")
    private String jName;

    /**
     * 岗位状态（0：不存在，1：存在）
     */
    private String jStatus;

    /**
     * ID
     */
    private Integer tlId;

    /**
     * 学习状态（0，进行中，1，已完成）
     */
    private Integer lState;

    /**
     * 实习生&学习内容状态（0：不存在，1：存在）
     */
    private String tlStatus;

    /**
     * ID
     */
    private Integer jlId;

    /**
     * 岗位&学习内容状态（0：不存在，1：存在）
     */
    private String jlStatus;

    /**
     * 学习内容ID
     */
    @ApiModelProperty(value = "学习内容ID", example = "0")
    private Integer lId;

    /**
     * 学习内容
     */
    @ApiModelProperty("学习内容")
    private String lElementary;

    /**
     * 学习阶段(1.初级、2.中级、3.高级)
     */
    @ApiModelProperty(value = "学习阶段(1.初级、2.中级、3.高级)", example = "0")
    private Integer lStage;

    /**
     * 学习内容状态（0：不存在，1：存在）
     */
    private String lStatus;

    /**
     * 实习生&考核id
     */
    private Integer taId;

    /**
     * 实习生&考核状态（0：不存在，1：存在）
     */
    private String taStatus;

    /**
     * 考核ID
     */
    @ApiModelProperty(value = "考核ID", example = "0")
    private Integer aId;

    /**
     * 考核成绩
     */
    @ApiModelProperty("考核成绩")
    private Double aGrade;

    /**
     * 考核状态（0：不存在，1：存在）
     */
    private String aStatus;

    /**
     * 实习生&补贴id
     */
    private Integer tsId;

    /**
     * 实习生&补贴状态（0：不存在，1：存在）
     */
    private String tsStatus;

    /**
     * 实习生补贴id
     */
    @ApiModelProperty(value = "实习生补贴id", example = "0")
    private Integer sId;

    /**
     * 补贴金额
     */
    @ApiModelProperty("补贴金额")
    private Double sSubsidies;

    /**
     * 发放时间
     */
    @ApiModelProperty(value = "发放时间", example = "0")
    private Integer sIssuedTime;

    /**
     * 发放总次数
     */
    @ApiModelProperty(value = "发放总次数", example = "0")
    private Integer sLssueNum;

    /**
     * 发放次数（发了几次）
     */
    private Integer sCount;

    /**
     * 实习生补贴状态（0：不存在，1：存在）
     */
    private String sStatus;

    /**
     * 实习生&宿舍id
     */
    private Integer thId;

    /**
     * 实习生&宿舍状态（0：不存在，1：存在）
     */
    private String thStatus;

    /**
     * 住宿id
     */
    @ApiModelProperty(value = "住宿id", example = "0")
    private Integer hId;

    /**
     * 住宿地址
     */
    @ApiModelProperty("住宿地址")
    private String hAddress;

    /**
     * 宿舍人数
     */
    @ApiModelProperty(value = "宿舍人数", example = "0")
    private Integer hNumber;

    /**
     * 宿舍描述
     */
    private String hDescribe;

    /**
     * 宿舍图片
     */
    private String hUrl;

    /**
     * 宿舍管理员
     */
    private String hAdministrators;

    /**
     * 宿舍状态（0：不存在，1：存在）
     */
    private String hStatus;

    /**
     * 实习生&资源id
     */
    private Integer trId;

    /**
     * 实习生&资源状态（0：不存在，1：存在）
     */
    private String trStatus;

    /**
     * 资源ID
     */
    @ApiModelProperty(value = "资源ID", example = "0")
    private Integer rId;

    /**
     * 电脑型号
     */
    @ApiModelProperty("电脑型号")
    private String rComputer;

    /**
     * GitHub账号
     */
    @ApiModelProperty("GitHub账号")
    private String rGithub;

    /**
     * 资源状态（0：不存在，1：存在）
     */
    private String rStatus;
}
