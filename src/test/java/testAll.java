import com.alibaba.fastjson.JSONObject;
import com.sxyh.App;
import com.sxyh.entity.User;
import com.sxyh.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class testAll {

    @Autowired
    private UserMapper userMapper;
    
    @Test
    public  void test1(){
        List<User> users = userMapper.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public  void  testSave(){
/*        User user = new User();
        user.setId(99);
        user.setName("老oo");
        user.setPassword("123456");
        userMapper.save(user);*/

        long [] type = {1L,2L};
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<type.length;i++){
            //主要判断是否是最后一个条件
            if (i==type.length-1 ) {
                sb.append("'" + type[i] + "'");
            } else {
                sb.append("'" + type[i] + "'" + ",");
            }
        }
        System.out.println(sb);
    }
}
