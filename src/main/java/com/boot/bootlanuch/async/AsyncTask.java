package com.boot.bootlanuch.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author admin
 */
@Component
public class AsyncTask extends AbstractTask{
    @Async
    @Override
    public void doTaskOne() throws Exception {
        super.doTaskOne();
    }
    @Async
    @Override
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
    }
    @Async
    @Override
    public void doTaskThree() throws Exception {
        super.doTaskThree();
    }
}
