package org.trt.micro.dto;

import lombok.Data;

import java.util.List;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description 用户数据库传输对象
 */
@Data
public class UserDTO {

    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 角色信息
     */
    private List<String> roles;

}
