package com.zzc.intern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.DTO.TraineeDepartmentRelDTO;
import com.zzc.intern.entity.TraineeDepartmentRel;
import com.zzc.intern.vo.TraineeDepartmentRelVO;

/**
 * <p>
 * 实习生&部门 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-17
 */
public interface TraineeDepartmentRelService extends IService<TraineeDepartmentRel> {

    /**
     * 按条件分页查询实习生的部门信息
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param tName   实习生姓名
     * @param dName   部门名称
     * @return 实习生的部门信息
     */
    TraineeDepartmentRelVO queryByCondition(Integer current, Integer size, String tName, String dName);

    /**
     * 根据id查询实习生的部门信息
     *
     * @param tdId 实习生的部门信息id
     * @return 实习生的部门信息
     */
    TraineeDepartmentRelDTO queryById(Integer tdId);

    /**
     * 根据id删除实习生的部门信息
     *
     * @param tdId 实习生的部门信息id
     * @return 是否删除
     */
    boolean deleteById(Integer tdId);
}
