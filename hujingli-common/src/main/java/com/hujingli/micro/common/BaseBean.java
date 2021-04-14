package com.hujingli.micro.common;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 所有实体的父类bean
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseBean implements Serializable {


    private static final long serialVersionUID = -2602879350224561877L;
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    /**
     * 创建时间
     */
    @CreatedDate
    private Date createDate;

    /**
     * 修改时间
     */
    @LastModifiedDate
    private Date updateDate;

    /**
     * 备注
     */
    private String remark;


}
