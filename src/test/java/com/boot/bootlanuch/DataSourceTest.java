package com.boot.bootlanuch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Slf4j
public class DataSourceTest {
    @Test
    public void testDataSource() throws Exception{
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/master/*.xml");

        for(Resource r : resources){
            System.out.println(r.getFilename()); //文件名
            System.out.println(r.getURL().getPath()); //文件绝对路径
            System.out.println(r.getFile()); //File对象
            System.out.println(r.getInputStream()); //InputStream对象
        }
    }
}
