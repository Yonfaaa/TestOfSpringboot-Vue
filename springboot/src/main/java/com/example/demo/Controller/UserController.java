package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.Result;
import com.example.demo.entity.User;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

//    @GetMapping("/test")
//    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
//                              @RequestParam(defaultValue = "10") Integer pageSize,
//                              @RequestParam(defaultValue = "") String search){
//        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
//        if(StringUtils.isNotBlank(search)){
//            wrapper.like(User::getNickName,search);
//        }
//        Page<User> userPage=userMapper.findPage(new Page<>(pageNum,pageSize));
//        return Result.success(userPage);
//    }

    @PostMapping
    public Result<?> save(@RequestBody User user){
        if(user.getPassword()==null){
            user.setPassword("123456");
        }
        userMapper.insert(user);
        return Result.success();
    }

//    @GetMapping
//    public Result<?> findPage(@RequestParam Integer pageNum,
//                              @RequestParam Integer pageSize,
//                              @RequestParam String search){
//        if(user.getPassword()==null){
//            user.setPassword("123456");
//        }
//        userMapper.insert(user);
//        return Result.success();
//    }
}


