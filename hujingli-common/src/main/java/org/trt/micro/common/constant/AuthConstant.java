package org.trt.micro.common.constant;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description 认真相关常量
 * @since
 */
public interface AuthConstant {

    /**
     * 后台管理client_id
     */
    String ADMIN_CLIENT_ID = "admin-app";

    /**
     * 前台商城client_id
     */
    String PORTAL_CLIENT_ID = "portal-app";

    /**
     * 密钥
     */
    String KEY_PAIR_PWD = "123456";

    /**
     * redis保存角色和资源
     */
    String ROLES_RESOURCE_MAP = "roles_resource_map";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

}
