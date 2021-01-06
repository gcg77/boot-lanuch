package com.boot.bootlanuch;

import com.boot.bootlanuch.async.AsyncCallExecutorTask;
import com.boot.bootlanuch.async.AsyncCallTask;
import com.boot.bootlanuch.async.AsyncTask;
import com.boot.bootlanuch.async.SyncTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class SyncTaskTest {
    @Resource
    private SyncTask syncTask;
    @Resource
    private AsyncTask asyncTask;
    @Resource
    private AsyncCallTask callTask;
    @Resource
    private AsyncCallExecutorTask callExecutorTask;
    @Test
    public void syncTaskTest() throws Exception {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }
    @Test
    public void AsyncTaskTest() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }
    @Test
    public void AsyncCallTaskTest() throws Exception {
        long start=currentTimeMillis();
        Future<String> taskOne=callTask.doTaskCallOne();
        Future<String> taskTwo=callTask.doTaskCallTwo();
        Future<String> taskThree=callTask.doTaskCallThree();
       while (!taskOne.isDone()||!taskTwo.isDone()||!taskThree.isDone()){
           sleep(1000);
       }
        long end=currentTimeMillis();
        System.out.println("执行完成，耗时："+(end-start)+"毫秒");
    }
    @Test
    public void AsyncCallExeTaskTest() throws Exception {
        long start=currentTimeMillis();
        Future<String> taskOne=callExecutorTask.doTaskCallOne();
        Future<String> taskTwo=callExecutorTask.doTaskCallTwo();
        Future<String> taskThree=callExecutorTask.doTaskCallThree();
        while (!taskOne.isDone()||!taskTwo.isDone()||!taskThree.isDone()){
            sleep(1000);
        }
        long end=currentTimeMillis();
        System.out.println("执行完成，耗时："+(end-start)+"毫秒");
    }
}
