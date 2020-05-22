package com.znsd.controller;

import com.znsd.entry.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
@Api(description = "用户管理")
public class UserController {

    @Autowired
    private User user;

    @ApiOperation(value = "根据ID信息，添加相应的用户",notes = "aaaaaaaaaaaaaa")
    @PostMapping("/addSigle/{id}")
    public User addSigle(Model model,@PathVariable(name = "id") String id){
        System.out.println(model.toString()+"==="+id);
        User u = new User("admin","123456");
        return u;
    }

    @ApiOperation("获取所有用户的信息")
    @GetMapping("/getAllUser")
    public List<User> getAll(Model model){
        System.out.println("this is first springboot jsp");
        model.addAttribute("name","测试数据");
        List<User> list = new ArrayList<>();
        list.add(new User("111","111"));
        list.add(new User("222","222"));

        return list;
    }
    @PostMapping("/addUser")
    @ApiOperation(value = "用户添加服务", notes = "获取单个用户信息")
    //@ApiImplicitParam(name = "users", value = "用户详细实体user", required = true, dataType = "User")
    @ApiResponses({ @ApiResponse(code = 400, message = "无效的用户信息") })
    public User add(@ApiParam(value = "单个用户信息",required = true) @RequestBody User users){
        System.out.println("this is add springboot jsp"+users);
        users.status = "success  haha";
        return users;
    }

    @ApiOperation("根据ID删除对应的用户")
    @DeleteMapping("/deleteUser/{id}")
    public void delete(@PathVariable String id){
        System.out.println("删除："+id);
    }
    @ApiOperation("根据ID修改对应的用户")
    @PutMapping("/updateUser/{id}")
    public void udpate(@PathVariable String id){
        System.out.println("修改："+id);
    }
}
