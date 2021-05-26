package org.trt.micro.distributelock.mysql.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author exphuhong
 * @date 2021/5/26 0026
 */
@Data
 public class DistributedLock implements Serializable {

    private int id;

    private String moduleCode;

    private String moduleName;

    private Date expirationTime;

    private String creater;

    private Date createTime;

    private String modifier;

    private Date modifyTime;

}
