package com.study.spring.sail.config.web;

import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.core.io.ClassPathResource;

/**
 * 使用ehcache 做数据缓存
 * 缓存配置类
 *
 * @author JoinHan on 2017/04/24
 */
//@Configuration
public class CacheConfig {

    /**
     * ehcache 主要的管理器
     * @param bean
     * @return
     */
    //@Bean
    //@Primary
    /*public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
    	EhCacheCacheManager ehCacheManager = new EhCacheCacheManager(bean.getObject());
    	return ehCacheManager;
    }*/


    /**
     * 读取配置文件
     *
     * @return
     */
    //@Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factoryBean.setShared(true);
        return factoryBean;
    }

}
