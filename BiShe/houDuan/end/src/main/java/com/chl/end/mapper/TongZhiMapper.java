package com.chl.end.mapper;

import com.chl.end.entity.FanKui;
import com.chl.end.entity.TongZhi;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TongZhiMapper {
    //有人申请接取后，通知企业/插入新通知通用
    @Insert("insert into tongzhi(beiTongZhiRen_id,beiTongZhiRen_name,tongZhiRen_id,tongZhiRen_name,tongZhiNeiRong) values(#{beiTongZhiRen_id},#{beiTongZhiRen_name},#{tongZhiRen_id},#{tongZhiRen_name},#{tongZhiNeiRong})")
    public void shenQingToQiYe(Integer beiTongZhiRen_id,String beiTongZhiRen_name,Integer tongZhiRen_id,String tongZhiRen_name,String tongZhiNeiRong);

    //通知被通知人
    @Select("select count(*) from tongzhi where beiTongZhiRen_id=#{beiTongZhiRen_id} and isRead=1")
    public Integer tongZhi(Integer beiTongZhiRen_id);

    //未读消息通知
    @Select("select * from tongzhi where beiTongZhiRen_id=#{beiTongZhiRen_id} and isRead=1")
    public List<TongZhi> noRead(Integer beiTongZhiRen_id);

    //已读消息通知
    @Select("select * from tongzhi where beiTongZhiRen_id=#{beiTongZhiRen_id} and isRead=0")
    public List<TongZhi> read(Integer beiTongZhiRen_id);

    //全部已读按钮
    @Update("update tongzhi set isRead=0 where beiTongZhiRen_id=#{beiTongZhiRen_id}")
    public void allRead(Integer beiTongZhiRen_id);

    //简易通知
    @Insert("insert into tongzhi(beiTongZhiRen_id,tongZhiNeiRong) values(#{beiTongZhiRen_id},#{tongZhiNeiRong})")
    public void jianyiTongzhi(Integer beiTongZhiRen_id,String tongZhiNeiRong);

    @Select("select * from tongzhi")
    List<TongZhi> getAllTongzhi();

    @Delete("delete from tongzhi where id=#{id}")
    void deleteTongzhiById(Integer id);
}
