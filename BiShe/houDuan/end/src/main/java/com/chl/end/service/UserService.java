package com.chl.end.service;

import com.chl.end.common.Result;
import com.chl.end.entity.TongZhi;
import com.chl.end.entity.Tu;
import com.chl.end.entity.User;
import com.chl.end.mapper.UserMapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired(required=false)
    private UserMapper userMapper;
    //注册
    public Result register(String username, String password, String safe, Integer role){
        if (userMapper.findUser(username) != 0){
            return Result.username_error();
        } else {
            userMapper.register(username,password,safe,role);
            return Result.success();
        }
    }

    //登录
    public Result login(String username,String password){
        User user = new User();
        user = userMapper.login(username,password);
        if (user == null) {
            return Result.error("401","用户名或密码错误");
        } else {
            return Result.success(user);
        }
    }

    //忘记密码
    public String findSafeByUsername(String username){
        String safe = userMapper.findSafeByUsername(username);
        return safe;
    }
    public void updatePassword(String username,String password){
        userMapper.updatePassword(username,password);
    }

    //信息录入
    public Result luruqy(String name,String address,String contact,String gui_mo,String ye_wu,Integer id){
        userMapper.luruqy(name,address,contact,gui_mo,ye_wu,id);
        return Result.success();
    }
    public Result luru(String name,String address,String contact,String zhuan_ye,String shan_chang,String bu_shanchang,String experience,Integer id){
        userMapper.luru(name,address,contact,zhuan_ye,shan_chang,bu_shanchang,experience,id);
        return Result.success();
    }

    //通过id获取用户信息
    public User gengXingUser(Integer id){
        return userMapper.gengXingUser(id);
    }

    //获取队长信息
    public User getDuiZhangInfo(Integer duiWu){
        return userMapper.getDuiZhangInfo(duiWu);
    }

    //获取队员信息
    public List<User> getDuiYuanInfo(Integer duiWu){
        return userMapper.getDuiYuanInfo(duiWu);
    }

    //同意入队申请，user表修改
    public void tongYiShenQingToUser(Integer duiWuId,Integer id){
        userMapper.tongYiShenQingToUser(duiWuId,id);
    }

    //解散队伍,用户表修改
    public void jieSanDuiWuToUser(Integer duiWu){
        userMapper.jieSanDuiWuToUser(duiWu);
    }

    //退出队伍，队伍表修改
    public void tuiChuDuiWuToUser(Integer id){
        userMapper.tuiChuDuiWuToUser(id);
    }

    //查询所有教师
    public List<User> getAllTeacher(){
        return userMapper.getAllTeacher();
    }

    //企业同意申请，user表插入项目id
    public void updateXiangmuIdInUser(Integer xiangMu_id,Integer id){
        userMapper.updateXiangmuIdInUser(xiangMu_id,id);
    }

    //查询教师中所有专业及数量
    public List<Tu> findUserListWithZhuanye(){
        return userMapper.findUserListWithZhuanye();
    }

    //合作结束项目id置空
    public void endNullXiangmu(Integer id){
        userMapper.endNullXiangmu(id);
    }

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }
}
