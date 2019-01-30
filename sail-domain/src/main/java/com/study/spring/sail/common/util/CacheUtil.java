package com.study.spring.sail.common.util;

import com.study.spring.sail.common.status.CacheKey;
import com.study.spring.sail.modules.sys.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 缓存工具类
 *
 * @author 韩炜
 * @date 2019-01-30 19:25
 */
@Component
public class CacheUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    private static CacheUtil cacheUtil;

    private synchronized static CacheUtil getInstance() {
        if (cacheUtil == null) {
            cacheUtil = (CacheUtil) SpringContextUtil.getBean("cacheUtil");
        }
        return cacheUtil;
    }

    public static void cacheUserInfo(String key, UserInfo userInfo) {
        getInstance().redisTemplate.opsForHash().put(CacheKey.USER_CACHE, key, userInfo);
    }
}
