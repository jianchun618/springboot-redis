package redis;

import com.sxyh.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestRedis {
/*
    @Autowired
    RedisTemplate redisTemplate;
*/

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1(){

//       redisTemplate.opsForValue().set("name","zhangsan");
//        Object name = redisTemplate.opsForValue().get("name");
//        System.out.println(name);

//        （1）、基本的存取值
//       stringRedisTemplate.opsForValue().set("id","1");
//        stringRedisTemplate.opsForValue().set("bir","2012-12-12");
//        stringRedisTemplate.opsForValue().set("name","zhangsan");

        //存活100秒 ttl id 查看
//        stringRedisTemplate.opsForValue().set("id","1",100, TimeUnit.SECONDS);

//        （2）、批量删除
//        List<String> strings = Arrays.asList("id", "name");
//        stringRedisTemplate.delete(strings);

//        （3）、//为key设置超时时间
//        stringRedisTemplate.expire("name",100, TimeUnit.SECONDS);//为key设置超时时间
//        Long name = stringRedisTemplate.getExpire("name");//获取可以的存活时间
//        System.out.println(name);

      //（4）、获取所有的key
        Set<String> keys = stringRedisTemplate.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }


//      （5）、随机获取数据
    /*    String s = stringRedisTemplate.randomKey();
        String s1 = stringRedisTemplate.randomKey();
        String s2 = stringRedisTemplate.randomKey();
        String s3 = stringRedisTemplate.randomKey();
        String s4 = stringRedisTemplate.randomKey();
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);*/

    }
    @Test
    public void testList(){
//        （1）、测试list 集合
//        Long aLong = stringRedisTemplate.opsForList().leftPush("names", "xiaohei");
        stringRedisTemplate.opsForList().leftPushAll("names","xiaohei","xiaohei1","xiaohei2","xiaohei3","xiaohei4","xiaohei5");
        List<String> names = stringRedisTemplate.opsForList().range("names", 0, -1);
        for (String name : names) {
            System.out.println(name);
        }
    }
    @Test
    public void testSet(){
//（1）、测试 Set 集合 存取
        Long add = stringRedisTemplate.opsForSet().add("s1", "s2", "s3");
        Set<String> s1 = stringRedisTemplate.opsForSet().members("s1");

        for (String s : s1) {
            System.out.println(s);
        }
        DataType s11 = stringRedisTemplate.type("s1");

        if (s11.equals(DataType.SET)){
            System.out.println("this is set");
        }
    }


    @Test
    public void testBind(){
        BoundListOperations<String, String> boundListOperations = stringRedisTemplate.boundListOps("name");
        List<String> range = boundListOperations.range(0, -1);
        for (String s : range) {
            System.out.println(s);
        }
    }
}
