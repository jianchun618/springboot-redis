import com.baizhi.App;
import com.baizhi.entity.User;
import com.baizhi.dao.UserMapper;
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
        User user = new User();
        user.setId(99);
        user.setName("老oo");
        user.setPassword("123456");
        userMapper.save(user);
    }
}
