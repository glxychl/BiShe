package com.chl.end.mapper;

import com.chl.end.entity.DuiWu;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface DuiWuMapper {
    //查询所有队伍
    @Select("select * from duiwu ORDER BY chuangJian_time DESC")
    public List<DuiWu> findAllDuiWu();

    //创建队伍
    @Insert("insert into duiwu(duizhang_id,duiwuName,zhuan_ye,shan_chang,jian_jie,chuangJian_time) values(#{duizhang_id},#{duiwuName},#{zhuan_ye},#{shan_chang},#{jian_jie},#{chuangJian_time})")
    public void createDuiWu(Integer duizhang_id, String duiwuName, String zhuan_ye, String shan_chang, String jian_jie, Timestamp chuangJian_time);
    @Select("update user set duiWu = (select id from duiwu where duizhang_id=#{duizhang_id}),isDuiZhang=1 where id=#{duizhang_id}")
    public void DuiZhangDuiWuId(Integer duizhang_id);

    //申请入队
    @Update("update duiwu set shenQing=#{id} where id=#{duiWuId}")
    public void shenQingRuDui(Integer id,Integer duiWuId);

    //有无申请
    @Select("select shenQing from duiwu where id=#{duiWuId}")
    public Integer haveShenQing(Integer duiWuId);

    //获取队伍信息
    @Select("select * from duiwu where id=#{duiWuId}")
    public DuiWu getDuiWuInfo(Integer duiWuId);

    //同意入队申请，duiwu表修改
    @Update("update duiwu set shenQing=null,shu_liang=#{shu_liang} where id=#{duiWuId}")
    public void tongYiShenQingToDuiwu(Integer duiWuId,Integer shu_liang);

    //拒绝入队申请
    @Update("update duiwu set shenQing=null where id=#{duiWuId}")
    public void juJueShenQingToDuiWu(Integer duiWuId);

    //解散队伍，队伍表修改
    @Update("delete from duiwu where id=#{id}")
    public void jieSanDuiWuToDuiWu(Integer id);

    //退出队伍，队伍表修改数量--
    @Update("update duiwu set shu_liang=#{shu_liang} where id=#{duiWuId}")
    public void tuiChuDuiWuToDuiWu(Integer duiWuId,Integer shu_liang);

    //队伍接取成功
    @Update("update duiwu set xiangMu_id=#{xiangMu_id} where duizhang_id=#{id}")
    public void duiwuJiequChengong(Integer id,Integer xiangMu_id);

    //合作结束,项目置空
    @Update("update duiwu set xiangMu_id=null where duizhang_id=#{duizhang_id}")
    public void duiwuEndXiangmu(Integer duizhang_id);

    //获取所有队伍
    @Select("select * from duiwu")
    List<DuiWu> findAllduiwu();

    @Delete("delete from duiwu where id=#{id}")
    void deleteDuiwuById(Integer id);
}
