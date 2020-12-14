package com.boot.bootlanuch;

import com.boot.bootlanuch.model.bo.FriendBO;
import com.boot.bootlanuch.model.po.FriendPO;
import com.boot.bootlanuch.model.vo.FriendVO;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FriendBOTest {

    @Test
    public void BeanCopyTest() {
        FriendVO friendVO = FriendVO.builder()
                .age("23")
                .name("123")
                .build();
        FriendBO friendBO = new FriendBO();
        BeanUtils.copyProperties(friendVO,friendBO);
        DozerBeanMapper dozerBeanMapper=new DozerBeanMapper();
        FriendPO friendPO2=new FriendPO();
        BeanUtils.copyProperties(friendVO,friendPO2);
        FriendPO friendPO=dozerBeanMapper.map(friendVO,FriendPO.class);
        log.info("friendBO:"+friendBO.toString());
        log.info("friendPO2:"+friendPO2.toString());
        log.info("friendPO:"+friendPO.toString());
    }
}
