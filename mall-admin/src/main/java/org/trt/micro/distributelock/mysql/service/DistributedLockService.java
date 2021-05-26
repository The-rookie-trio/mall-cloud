package org.trt.micro.distributelock.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trt.micro.distributelock.mysql.bean.DistributedLock;
import org.trt.micro.distributelock.mysql.dao.DistributedLockDao;

import java.util.List;

/**
 * @author exphuhong
 * @date 2021/5/26 0026
 */
@Service
public class DistributedLockService {

    @Autowired
    private DistributedLockDao distributedLockDao;

    public boolean tryLock(String code){
        DistributedLock distributedLock = new DistributedLock();
        distributedLock.setModuleCode(code);
        List<DistributedLock> list = distributedLockDao.getDistributedLock(distributedLock);
        return list != null && list.size() > 0;
    }

}

