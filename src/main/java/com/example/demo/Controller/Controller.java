package com.example.demo.Controller;


import com.example.demo.Model.TestUser;
import com.example.demo.ViewModel.TestUserRepository;
import com.example.demo.Model.User;
import com.example.demo.ViewModel.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @Autowired  // 框架自动装配，不写会是null
    private TestUserRepository testUserRepository;

    @RequestMapping("/test")
    public String test() {
        return "Hello CYC666";
    }

    @RequestMapping("/getOne")
    public User getOne(User user) {
        return userRepository.findOne(Example.of(user)).orElse(null);
    }

    @RequestMapping("/getList")
    public List<User> getList(User user) {

        return userRepository.findAll(Example.of(user));
    }


    @RequestMapping("/GetUsers")
    public Map getUserWithUserName() {


//        return testUserRepository.findAll(Example.of(userName), PageRequest.of(pageIndex, pageSize));
        List body = testUserRepository.findAll();

        TestUser testUser = testUserRepository.getTestUserByUserName("123");
        List list = new ArrayList();
        list.add(testUser);

        list = testUserRepository.getList("test1");


        Map result = new HashMap();
        result.put("code","200");
        result.put("msg","成功");
        result.put("body",list);


        return result;
    }

    @RequestMapping("/getHaha")
    public String getHaha () {
        return "hahahahahahhahah";
    }

}
