package org.trt.micro.resource;

import com.hujingli.micro.common.constant.AuthConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.trt.micro.dao.RoleResourceDao;
import org.trt.micro.dto.RoleResourceDTO;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description 资源处理器，服务启动的时候获取数据库所有角色与资源的关系，并将其存入Redis
 */
@Slf4j
@Service
public class ResourceHandler {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RoleResourceDao roleResourceDao;

    @PostConstruct
    public void initResource() {
        log.info("初始化权限资源信息");
        List<RoleResourceDTO> roleResource = roleResourceDao.getRoleResource();

        // 将查出的角色资源按资源名称分组， 一个资源对应多个角色
        Map<String, List<RoleResourceDTO>> collect = roleResource.stream().collect(Collectors.groupingBy(RoleResourceDTO::getResource));

        redisTemplate.opsForHash().putAll(AuthConstant.ROLES_RESOURCE_MAP, collect);

        log.info("完成初始化权限资源信息");

    }

}
