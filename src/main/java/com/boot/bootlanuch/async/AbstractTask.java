package com.boot.bootlanuch.async;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * @author admin
 */
public abstract class AbstractTask {
    public static Random random = new Random();
    public void doTaskOne() throws Exception{
        System.out.println("任务一开始");
        long startTime=System.currentTimeMillis();
        sleep(random.nextInt(1000));
        long endTime=System.currentTimeMillis();
        System.out.println("任务一完成，消耗时间："+(endTime-startTime)+"毫秒");
    }
    public void doTaskTwo() throws Exception{
        System.out.println("任务二开始");
        long startTime=System.currentTimeMillis();
        sleep(random.nextInt(1000));
        long endTime=System.currentTimeMillis();
        System.out.println("任务二完成，消耗时间："+(endTime-startTime)+"毫秒");
    }
    public void doTaskThree() throws Exception{
        System.out.println("任务三开始");
        long startTime=System.currentTimeMillis();
        sleep(random.nextInt(1000));
        long endTime=System.currentTimeMillis();
        System.out.println("任务三完成，消耗时间："+(endTime-startTime)+"毫秒");
    }
}
