package com.sxyh.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {

    //    @Autowired
// 由于  RedisCache  mabatis实例化的没有交给工厂管理，所以不能注入  stringRedisTemplate

    //       StringRedisTemplate stringRedisTemplate;
//        需要获取工厂， 自动没有，需要自己拿
    private String id;    //id 为namespace

    public RedisCache(String id) {
        System.out.println(id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }


    // 第一个参数 是key（namespace，方法名，sq语句等）  第二个参数是查询结果
    @Override
    public void putObject(Object key, Object value) {
        System.out.println("存放缓存");
        //手动操作工厂获取缓存对象  stringRedisTemplate
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) ApplicationContextUtil.getBeanByClass(StringRedisTemplate.class);
        //将查询结果，进行序列化为String字符串
        String serialize = SerializeUtils.serialize(value);

        //存入redis数据库
        stringRedisTemplate.opsForHash().put(id, key.toString(), serialize);
    }

    //获取对应方法的缓存数据
    @Override
    public Object getObject(Object key) {
        System.out.println("获取缓存");
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) ApplicationContextUtil.getBeanByClass(StringRedisTemplate.class);
        if (stringRedisTemplate.opsForHash().hasKey(id, key.toString())) {
            String o = (String) stringRedisTemplate.opsForHash().get(id, key.toString());
            //反序列化
            return SerializeUtils.serializeToObject(o);
        } else {
            return null;
        }
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    //增删改--调用clear
    @Override
    public void clear() {
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) ApplicationContextUtil.getBeanByClass(StringRedisTemplate.class);
        //根据id清空数据
        stringRedisTemplate.delete(id);
        System.out.println("清空缓存");
    }

    @Override
    public int getSize() {
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) ApplicationContextUtil.getBeanByClass(StringRedisTemplate.class);
        Long size = stringRedisTemplate.opsForHash().size(id);
        return size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
