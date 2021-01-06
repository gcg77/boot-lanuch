package com.boot.bootlanuch.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author admin
 */
@Component
public class AsyncCallExecutorTask extends AbstractTask {
    @Async("taskExecutor")
    public Future<String> doTaskCallOne() throws Exception {
        super.doTaskOne();
        System.out.println("当前线程:" + Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskCallTwo() throws Exception {
        super.doTaskTwo();
        System.out.println("当前线程:" + Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskCallThree() throws Exception {
        super.doTaskThree();
        System.out.println("当前线程:" + Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");
    }
}
