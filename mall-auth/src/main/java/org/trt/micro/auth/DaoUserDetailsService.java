package org.trt.micro.auth;

import org.trt.micro.common.constant.AuthConstant;
import org.trt.micro.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.trt.micro.bean.UserInfo;
import org.trt.micro.dao.AdminUserDao;
import org.trt.micro.dao.AppUserDao;
import org.trt.micro.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description 用户认证
 */
@Slf4j
@Service
public class DaoUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Autowired
    private AppUserDao appUserDao;

    /**
     * 密码加密
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("进入用户认证:[{}]", username);
        // 从数据库查询用户信息  UserInfo
        String clientId = request.getParameter("client_id");
        UserDTO userDTO = null;
        if (AuthConstant.ADMIN_CLIENT_ID.equals(clientId)) {
            // 后台用户
            userDTO = adminUserDao.loadByUsername(username);
        } else {
            // 前台用户
            userDTO = appUserDao.loadByUsername(username);
        }

        if (userDTO == null) {
            log.error("登录用户不存在:[{}]", username);
            throw new BusinessException(HttpStatus.NOT_FOUND.value(), "账号或密码错误");
        }

        UserInfo userInfo = new UserInfo(userDTO);
        if (!userInfo.isEnabled()) {
            log.error("登录用户账号不可用:[{}]", username);
            throw new BusinessException(HttpStatus.FORBIDDEN.value(), "登录用户账号不可用");
        }
        // 判断用户账号信息  是否被锁等
        log.info("用户认证成功:[{}]", username);
        return userInfo;
    }


}
