package com.chl.end.service;

import com.chl.end.common.Result;
import com.chl.end.entity.DuiWu;
import com.chl.end.mapper.DuiWuMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DuiWuService {
    @Autowired(required=false)
    private DuiWuMapper duiWuMapper;

    //查询所有队伍
    public List<DuiWu> findAllDuiWu(){
        return duiWuMapper.findAllDuiWu();
    }

    //创建队伍
    public void createDuiWu(Integer duizhang_id, String duiwuName, String zhuan_ye, String shan_chang, String jian_jie, Timestamp chuangJian_time){
        duiWuMapper.createDuiWu(duizhang_id,duiwuName,zhuan_ye,shan_chang,jian_jie,chuangJian_time);
        duiWuMapper.DuiZhangDuiWuId(duizhang_id);
    }

    //申请入队
    public void shenQingRuDui(Integer id,Integer duiWuId){
        duiWuMapper.shenQingRuDui(id,duiWuId);
    }

    //有无申请
    public Integer haveShenQing(Integer duiWuId){
        return duiWuMapper.haveShenQing(duiWuId);
    }

    //获取队伍信息
    public DuiWu getDuiWuInfo(Integer duiWuId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        DuiWu duiWu = duiWuMapper.getDuiWuInfo(duiWuId);
        duiWu.setChuangJian_timeStr(sdf.format(duiWu.getChuangJian_time()));
        return duiWu;
    }

    //同意入队申请，duiwu表修改
    public void tongYiShenQingToDuiwu(Integer duiWuId,Integer shu_liang){
        shu_liang++;
        duiWuMapper.tongYiShenQingToDuiwu(duiWuId,shu_liang);
    }

    //拒绝入队申请
    public void juJueShenQingToDuiWu(Integer duiWuId){
        duiWuMapper.juJueShenQingToDuiWu(duiWuId);
    }

    //解散队伍，队伍表修改
    public void jieSanDuiWuToDuiWu(Integer id){
        duiWuMapper.jieSanDuiWuToDuiWu(id);
    }

    //退出队伍，队伍表修改数量--
    public void tuiChuDuiWuToDuiWu(Integer duiWuId,Integer shu_liang){
        shu_liang--;
        duiWuMapper.tuiChuDuiWuToDuiWu(duiWuId,shu_liang);
    }

    //队伍接取成功
    public void duiwuJiequChengong(Integer id,Integer xiangMu_id){
        duiWuMapper.duiwuJiequChengong(id,xiangMu_id);
    }

    //合作结束,项目置空
    public void duiwuEndXiangmu(Integer duizhang_id){
        duiWuMapper.duiwuEndXiangmu(duizhang_id);
    }

    public List<DuiWu> findAllduiwu() {
        return duiWuMapper.findAllduiwu();
    }

    public void deleteDuiwuById(Integer id) {
        duiWuMapper.deleteDuiwuById(id);
    }
}
