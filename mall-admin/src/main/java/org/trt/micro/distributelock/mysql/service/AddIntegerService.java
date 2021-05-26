package org.trt.micro.distributelock.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.*;

/**
 * @author exphuhong
 * @date 2021/5/26 0026
 */
@Service
public class AddIntegerService {


    public static Integer i = 0;

    @Autowired
    private DistributedLockService distributedLockService;

    @Transactional(rollbackFor = Exception.class)
    public void addInteger() {

        while (true) {
            boolean order = distributedLockService.tryLock("order");
            if (order) {
                i++;
                break;
            }
        }

    }
}
