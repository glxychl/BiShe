package com.chl.end.controller;

import com.chl.end.common.Result;
import com.chl.end.entity.Tu;
import com.chl.end.entity.User;
import com.chl.end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    @RequestMapping("/register")
    public Result register(String username,String password,String safe,Integer role){
        return userService.register(username,password,safe,role);
    }

    //登录
    @RequestMapping("/login")
    public Result login(String username, String password){
        return userService.login(username,password);
    }

    //忘记密码
    @RequestMapping("/forget")
    public Result forget(String username,String password,String safe){
        String mSafe = userService.findSafeByUsername(username);
        if (safe.equals(mSafe)){
            userService.updatePassword(username,password);
            return Result.success();
        }else {
            return Result.error("402","用户名或安全码错误");
        }
    }

    //信息录入
    @RequestMapping("/luruqy")
    public Result luruqy(String name,String address,String contact,String gui_mo,String ye_wu,Integer id){
        return userService.luruqy(name,address,contact,gui_mo,ye_wu,id);
    }
    @RequestMapping("/luru")
    public Result luru(String name,String address,String contact,String zhuan_ye,String shan_chang,String bu_shanchang,String experience,Integer id){
        return userService.luru(name,address,contact,zhuan_ye,shan_chang,bu_shanchang,experience,id);
    }

    //通过id获取用户信息
    @RequestMapping("/gengXingUser")
    public Result gengXingUser(Integer id){
        return Result.success(userService.gengXingUser(id));
    }

    //获取队长信息
    @RequestMapping("/getDuiZhangInfo")
    public Result getDuiZhangInfo(Integer duiWu){
        return Result.success(userService.getDuiZhangInfo(duiWu));
    }

    //获取队员信息
    @RequestMapping("/getDuiYuanInfo")
    public Result getDuiYuanInfo(Integer duiWu) {
        return Result.success(userService.getDuiYuanInfo(duiWu));
    }

    //同意入队申请，user表修改
    @RequestMapping("/tongYiShenQingToUser")
    public void tongYiShenQingToUser(Integer duiWuId,Integer id){
        userService.tongYiShenQingToUser(duiWuId,id);
    }

    //解散队伍,用户表修改
    @RequestMapping("/jieSanDuiWuToUser")
    public Result jieSanDuiWuToUser(Integer duiWu){
        userService.jieSanDuiWuToUser(duiWu);
        return Result.success();
    }

    //退出队伍，队伍表修改
    @RequestMapping("/tuiChuDuiWuToUser")
    public Result tuiChuDuiWuToUser(Integer id){
        userService.tuiChuDuiWuToUser(id);
        return Result.success();
    }

    //推荐教师
    @RequestMapping("/tuiJianTeacher")
    public Result tuiJianTeacher(String shan_chang,String zhuan_ye){
        List<User> all = userService.getAllTeacher();
        List<User> first = new ArrayList<>();
        List<User> second = new ArrayList<>();
        List<User> newList = new ArrayList<>();
        for (User user:all) {
            if (user.getShan_chang().equals(shan_chang))
                first.add(user);
            else if (user.getZhuan_ye().equals(zhuan_ye) && !user.getBu_shanchang().equals(shan_chang))
                second.add(user);
        }
        newList.addAll(first);
        newList.addAll(second);
        return Result.success(newList);
    }

    //查询教师中所有专业及数量
    @RequestMapping("/findUserListWithZhuanye")
    public Result findUserListWithZhuanye(){
        return Result.success(userService.findUserListWithZhuanye());
    }

    @RequestMapping("/getAllUser")
    public Result getAllUser(){
        return Result.success(userService.getAllUser());
    }

    @RequestMapping("/deleteUserById")
    public Result deleteUserById(Integer id) {
        userService.deleteUserById(id);
        return Result.success();
    }
}

