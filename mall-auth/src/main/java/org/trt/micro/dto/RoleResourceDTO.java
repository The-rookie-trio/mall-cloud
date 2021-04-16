package org.trt.micro.dto;

import lombok.Data;

import java.util.List;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description 角色资源数据库传输对象
 */
@Data
public class RoleResourceDTO {


    /**
     * 资源
     */
    private String resource;

    /**
     * 角色信息
     */
    private String role;


}
