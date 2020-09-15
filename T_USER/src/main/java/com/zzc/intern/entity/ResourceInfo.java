package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("resource_info")
public class ResourceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
    @TableId(value = "r_id", type = IdType.AUTO)
    private Integer rId;

    /**
     * 电脑型号
     */
    private String rComputer;

    /**
     * 是否使用公司电脑 0：不使用 1：使用
     */
    private String rIsComputer;

    /**
     * GitHub账号
     */
    private String rGithub;

    /**
     * 实习生编号
     */
    private Integer tId;


}
