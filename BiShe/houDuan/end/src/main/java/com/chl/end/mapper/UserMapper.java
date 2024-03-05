package com.chl.end.mapper;

import com.chl.end.entity.TongZhi;
import com.chl.end.entity.Tu;
import com.chl.end.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //注册
    @Insert("insert into user(username,password,safe,role) values(#{username},#{password},#{safe},#{role})")
    public void register(String username,String password,String safe,Integer role);
    @Select("select count(*) from user where username=#{username}")
    public Integer findUser(String username);

    //登录
    @Select("select * from user where username=#{username} and password=#{password}")
    public User login(String username,String password);

    //忘记密码
    @Select("select safe from user where username=#{username}")
    public String findSafeByUsername(String username);
    @Update("update user set password=#{password} where username=#{username}")
    public void updatePassword(String username,String password);

    //信息录入
    @Update("update user set name=#{name},address=#{address},contact=#{contact},gui_mo=#{gui_mo},ye_wu=#{ye_wu} where id=#{id}")
    public void luruqy(String name,String address,String contact,String gui_mo,String ye_wu,Integer id);
    @Update("update user set name=#{name},address=#{address},contact=#{contact},zhuan_ye=#{zhuan_ye},shan_chang=#{shan_chang},bu_shanchang=#{bu_shanchang},experience=#{experience} where id=#{id}")
    public void luru(String name,String address,String contact,String zhuan_ye,String shan_chang,String bu_shanchang,String experience,Integer id);

    //通过id获取用户信息
    @Select("select * from user where id=#{id}")
    public User gengXingUser(Integer id);

    //获取队长信息
    @Select("select * from user where duiWu=#{duiWu} and isDuiZhang=1")
    public User getDuiZhangInfo(Integer duiWu);

    //获取队员信息
    @Select("select * from user where duiWu=#{duiWu} and isDuiZhang is NULL")
    public List<User> getDuiYuanInfo(Integer duiWu);

    //同意入队申请，user表修改
    @Update("update user set duiWu=#{duiWuId} where id=#{id}")
    public void tongYiShenQingToUser(Integer duiWuId,Integer id);

    //解散队伍,用户表修改
    @Update("update user set duiWu=0,isDuiZhang=null where duiWu=#{duiWu}")
    public void jieSanDuiWuToUser(Integer duiWu);

    //退出队伍，队伍表修改
    @Update("update user set duiWu=0 where id=#{id}")
    public void tuiChuDuiWuToUser(Integer id);

    //查询所有队长或者无队伍教师
    @Select("select * from user where role=2 AND (isDuiZhang=1 OR duiWu=0)")
    public List<User> getAllTeacher();

    //企业同意申请，user表插入项目id
    @Update("update user set xiangMu_id=#{xiangMu_id} where id=#{id}")
    public void updateXiangmuIdInUser(Integer xiangMu_id,Integer id);

    //查询教师中所有专业及数量
    @Select("select zhuan_ye AS name,count(zhuan_ye) AS value from user  WHERE role=2 GROUP BY zhuan_ye")
    public List<Tu> findUserListWithZhuanye();

    //合作结束项目id置空
    @Update("update user set xiangMu_id=null where id=#{id}")
    public void endNullXiangmu(Integer id);

    @Select("select * from user")
    List<User> getAllUser();

    @Delete("delete from user where id=#{id}")
    void deleteUserById(Integer id);
}
