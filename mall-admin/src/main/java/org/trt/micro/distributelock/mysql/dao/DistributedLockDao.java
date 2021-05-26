package org.trt.micro.distributelock.mysql.dao;

import org.trt.micro.distributelock.mysql.bean.DistributedLock;

import java.util.List;

/**
 * @author exphuhong
 * @date 2021/5/26 0026
 */
public interface DistributedLockDao {

    public List<DistributedLock> getDistributedLock(DistributedLock lock);


}
