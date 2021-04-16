package org.trt.micro.dao;

import org.apache.ibatis.annotations.Param;
import org.trt.micro.bean.UserInfo;
import org.trt.micro.dto.UserDTO;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description 后台用户数据库操作
 */
public interface AdminUserDao {

    /**
     * 通过用户名加载用户
     * @param username 用户名
     * @return UserInfo
     */
    UserDTO loadByUsername(@Param("username") String username);

}
