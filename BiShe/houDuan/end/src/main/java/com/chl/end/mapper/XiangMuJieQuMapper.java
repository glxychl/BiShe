package com.chl.end.mapper;

import com.chl.end.entity.User;
import com.chl.end.entity.XiangMuJieQu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface XiangMuJieQuMapper {
    //申请接取
    @Insert("insert into xiangmujiequ(xiangMu_id,xiangMu_name,shenQingRen_id,shenQingRen_name,qiYe_id,qiYe_name) values(#{xiangMu_id},#{xiangMu_name},#{shenQingRen_id},#{shenQingRen_name},#{qiYe_id},#{qiYe_name})")
    public void shenQing(Integer xiangMu_id,String xiangMu_name,Integer shenQingRen_id,String shenQingRen_name,Integer qiYe_id,String qiYe_name);

    //查看阶段为申请中的项目申请人
    @Select("select * from xiangmujiequ where xiangMu_id=#{xiangMu_id} and chuLiJieDuan=1")
    public List<XiangMuJieQu> getShenQingByXiangmuId(Integer xiangMu_id);

    //改变项目接取阶段
    @Update("update xiangmujiequ set chuLiJieDuan=2 where shenQingRen_id=#{id}")
    public void updateJieduanById(Integer id);
    @Update("update xiangmujiequ set chuLiJieDuan=0 where shenQingRen_id!=#{id} and xiangMu_id=#{xiangMu_id}")
    public void updateJieduanFail(Integer id,Integer xiangMu_id);

    //合作结束改变项目接取阶段
    @Update("update xiangmujiequ set chuLiJieDuan=3 where xiangMu_id=#{xiangMu_id} and shenQingRen_id=#{shenQingRen_id}")
    public void endJiequ(Integer xiangMu_id,Integer shenQingRen_id);

    @Select("select * from xiangmujiequ")
    List<XiangMuJieQu> getAllXiangMuJieQu();

    @Delete("delete from xiangmujiequ where id=#{id}")
    void deleteXiangMuJieQuById(Integer id);
}
