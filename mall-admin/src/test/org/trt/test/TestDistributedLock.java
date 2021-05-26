package org.trt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.trt.micro.MallAdminApplication;
import org.trt.micro.distributelock.mysql.service.AddIntegerService;
import org.trt.micro.distributelock.mysql.service.DistributedLockService;

import java.util.concurrent.*;

/**
 * @author exphuhong
 * @date 2021/5/26 0026
 */
@SpringBootTest(classes = MallAdminApplication.class)
@RunWith(SpringRunner.class)
public class TestDistributedLock {

    public static ExecutorService executorService = new ThreadPoolExecutor(
            10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20), r -> new Thread(r),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    @Autowired
    private AddIntegerService addIntegerService;

    @Test
    public void testMysqlDistributedLock() {
        for (int i = 0; i < 105; i++) {
            executorService.submit(() -> {
                addIntegerService.addInteger();
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(AddIntegerService.i);
                return;
            }
        }
    }

}
