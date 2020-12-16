package com.boot.bootlanuch.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.Nullable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * @author admin
 */
public class MixPropertySourceUtils extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();
        String yml=".yml";
        String yaml=".yaml";
        if (StringUtils.isNotBlank(sourceName) && (sourceName.endsWith(yml) || sourceName.endsWith(yaml))) {
            Properties propertiesYml = loadYml(resource);
            return new PropertiesPropertySource(sourceName, propertiesYml);
        } else {
            return super.createPropertySource(name, resource);
        }
    }

    private Properties loadYml(EncodedResource resource) throws FileNotFoundException {
        try {
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
            factory.setResources(resource.getResource());
            factory.afterPropertiesSet();
            return factory.getObject();
        } catch (IllegalStateException e) {
            // for ignoreResourceNotFound
            Throwable cause = e.getCause();
            if (cause instanceof FileNotFoundException){
                throw (FileNotFoundException) e.getCause();
            }
            throw e;
        }
    }
}
