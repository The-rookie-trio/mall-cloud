package org.trt.micro.dao;

import org.trt.micro.dto.RoleResourceDTO;

import java.util.List;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description 角色资源数据库操作
 */
public interface RoleResourceDao {

    /**
     * 获取角色资源信息
     *
     * @return list
     */
    List<RoleResourceDTO> getRoleResource();

}
