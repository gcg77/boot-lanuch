package com.boot.bootlanuch.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author admin
 */
@Component
public class AsyncCallTask extends AbstractTask{
    @Async
    public Future<String> doTaskCallOne() throws Exception {
        super.doTaskOne();
        return new AsyncResult<>("任务一完成");
    }
    @Async
    public Future<String> doTaskCallTwo() throws Exception {
        super.doTaskTwo();
        return new AsyncResult<>("任务一完成");
    }
    @Async
    public Future<String> doTaskCallThree() throws Exception {
        super.doTaskThree();
        return new AsyncResult<>("任务一完成");
    }
}
