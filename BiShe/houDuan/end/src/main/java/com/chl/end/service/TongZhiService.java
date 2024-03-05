package com.chl.end.service;


import com.chl.end.entity.FanKui;
import com.chl.end.entity.TongZhi;
import com.chl.end.mapper.TongZhiMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TongZhiService {
    @Autowired(required=false)
    private TongZhiMapper tongZhiMapper;

    //有人申请接取后，通知企业
    public void shenQingToQiYe(Integer beiTongZhiRen_id,String beiTongZhiRen_name,Integer tongZhiRen_id,String tongZhiRen_name,String tongZhiNeiRong){
        tongZhiMapper.shenQingToQiYe(beiTongZhiRen_id,beiTongZhiRen_name,tongZhiRen_id,tongZhiRen_name,tongZhiNeiRong);
    }

    //通知被通知人
    public Integer tongZhi(Integer beiTongZhiRen_id){
        return tongZhiMapper.tongZhi(beiTongZhiRen_id);
    }

    //未读消息通知
    public List<TongZhi> noRead(Integer beiTongZhiRen_id){
        return tongZhiMapper.noRead(beiTongZhiRen_id);
    }

    //已读消息通知
    public List<TongZhi> read(Integer beiTongZhiRen_id){
        return tongZhiMapper.read(beiTongZhiRen_id);
    }

    //全部已读按钮
    public void allRead(Integer beiTongZhiRen_id) {
        tongZhiMapper.allRead(beiTongZhiRen_id);
    }

    //简易通知
    public void jianyiTongzhi(Integer beiTongZhiRen_id,String tongZhiNeiRong){
        tongZhiMapper.jianyiTongzhi(beiTongZhiRen_id,tongZhiNeiRong);
    }

    public List<TongZhi> getAllTongzhi() {
        return tongZhiMapper.getAllTongzhi();
    }

    public void deleteTongZhiById(Integer id) {
        tongZhiMapper.deleteTongzhiById(id);
    }
}
