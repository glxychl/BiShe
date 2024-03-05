package com.chl.end.mapper;

import com.chl.end.entity.FanKui;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FanKuiMapper {
    //对平台反馈
    @Insert("insert into fankui(fanKuiRen_id,fanKuiRen_name,fanKui) values(#{fanKuiRen_id},#{fanKuiRen_name},#{fanKui})")
    public void fankuiPingtai(Integer fanKuiRen_id,String fanKuiRen_name,String fanKui);

    //对项目反馈
    @Insert("insert into fankui(xiangMu_id,xiangMu_name,fanKuiRen_id,fanKuiRen_name,fanKui) values(#{xiangMu_id},#{xiangMu_name},#{fanKuiRen_id},#{fanKuiRen_name},#{fanKui})")
    public void fankuiXiangmu(Integer xiangMu_id,String xiangMu_name,Integer fanKuiRen_id,String fanKuiRen_name,String fanKui);

    //查询所有反馈
    @Select("select * from fankui")
    List<FanKui> getAllFankui();

    @Delete("delete from fankui where id=#{id}")
    void deleteFankuiById(Integer id);
}
