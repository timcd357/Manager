package com.apixel.manager;

import com.apixel.manager.dao.UserMapper;
import com.apixel.manager.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ManagerApplicationTests {

    @Resource
    private UserMapper testMapper;

    @Test
    public void contextLoads() {
        /*System.out.println(("----- selectAll method test ------"));
        List<User> userList = testMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);*/
        String s = "4175627/1220137张俊/441053上海千拓医药科技有限公司/季爱琼/2010200714209/480/20200722 2020-07-22 06:07:16";
        System.out.println(s.substring(0,s.indexOf("-")-4));
    }

}
