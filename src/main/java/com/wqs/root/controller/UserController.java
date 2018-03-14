package com.wqs.root.controller;

import com.github.pagehelper.Page;
import com.wqs.root.domain.User;
import com.wqs.root.service.UserService;
import com.wqs.root.util.MyPage;
import com.wqs.root.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/user")
    @ResponseBody
    public MyPage<User> findUserPage(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,@RequestParam(value = "pageSize",defaultValue = "5")int pageSize){
        Page<User> persons = userService.findUserPage(pageNum, pageSize);
        MyPage<User> myPage=new MyPage<User>(persons);
        return  myPage;
    }
    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    @ResponseBody
    public String redisTest(){
        Page<User> persons = userService.findUserPage(1, 5);
        redisUtil.set("persons",persons);
        System.out.println("进入了方法");
        return  redisUtil.get("persons").toString();
    }
}
