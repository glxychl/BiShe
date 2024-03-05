package com.chl.end.controller;

import com.chl.end.common.Result;
import com.chl.end.entity.DuiWu;
import com.chl.end.service.DuiWuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/DuiWu")
public class DuiWuController {
    @Autowired
    private DuiWuService duiWuService;
    //查询所有队伍
    @RequestMapping("/findAllDuiwu")
    public Result findAllDuiwu(String zhuan_ye, String shan_chang, String bu_shanchang){
        List<DuiWu> all;
        List<DuiWu> first = new ArrayList<>();
        List<DuiWu> second = new ArrayList<>();
        List<DuiWu> third = new ArrayList<>();
        List<DuiWu> last = new ArrayList<>();
        List<DuiWu> newList = new ArrayList<>();
        all = duiWuService.findAllDuiWu();
        for (DuiWu timeNew:all) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            timeNew.setChuangJian_timeStr(sdf.format(timeNew.getChuangJian_time()));
            if (timeNew.getShan_chang().equals(shan_chang)) {
                first.add(timeNew);
            } else if (timeNew.getShan_chang().equals(bu_shanchang)) {
                third.add(timeNew);
            } else if (timeNew.getZhuan_ye().equals(zhuan_ye)) {
                second.add(timeNew);
            } else {
                last.add(timeNew);
            }
        }
        newList.addAll(first);
        newList.addAll(second);
        newList.addAll(third);
        newList.addAll(last);
        return Result.success(newList);
    }

    //创建队伍
    @RequestMapping("/createDuiWu")
    public Result createDuiWu(Integer duizhang_id, String duiwuName, String zhuan_ye, String shan_chang, String jian_jie){
        Timestamp chuangJian_time = new Timestamp(System.currentTimeMillis());//获取当前时间
        duiWuService.createDuiWu(duizhang_id,duiwuName,zhuan_ye,shan_chang,jian_jie,chuangJian_time);
        return Result.success();
    }

    //申请入队
    @RequestMapping("/shenQingRuDui")
    public Result shenQingRuDui(Integer id,Integer duiWuId){
        duiWuService.shenQingRuDui(id,duiWuId);
        return Result.success();
    }

    //有无申请
    @RequestMapping("/haveShenQing")
    public Result haveShenQing(Integer duiWuId){
        return Result.success(duiWuService.haveShenQing(duiWuId));
    }

    //获取队伍信息
    @RequestMapping("/getDuiWuInfo")
    public Result getDuiWuInfo(Integer duiWuId){
        return Result.success(duiWuService.getDuiWuInfo(duiWuId));
    }

    //同意入队申请，duiwu表修改
    @RequestMapping("/tongYiShenQingToDuiwu")
    public Result tongYiShenQingToDuiwu(Integer duiWuId,Integer shu_liang){
        duiWuService.tongYiShenQingToDuiwu(duiWuId,shu_liang);
        return Result.success();
    }

    //拒绝入队申请
    @RequestMapping("/juJueShenQingToDuiWu")
    public Result juJueShenQingToDuiWu(Integer duiWuId){
        duiWuService.juJueShenQingToDuiWu(duiWuId);
        return Result.success();
    }

    //解散队伍，队伍表修改
    @RequestMapping("/jieSanDuiWuToDuiWu")
    public void jieSanDuiWuToDuiWu(Integer id){
        duiWuService.jieSanDuiWuToDuiWu(id);
    }

    //退出队伍，队伍表修改数量--
    @RequestMapping("/tuiChuDuiWuToDuiWu")
    public Result tuiChuDuiWuToDuiWu(Integer duiWuId,Integer shu_liang){
        duiWuService.tuiChuDuiWuToDuiWu(duiWuId,shu_liang);
        return Result.success();
    }

    //队伍接取成功
    @RequestMapping("/duiwuJiequChengong")
    public Result duiwuJiequChengong(Integer id,Integer xiangMu_id){
        duiWuService.duiwuJiequChengong(id,xiangMu_id);
        return Result.success();
    }

    //合作结束,项目置空
    @RequestMapping("/duiwuEndXiangmu")
    public Result duiwuEndXiangmu(Integer duizhang_id){
        duiWuService.duiwuEndXiangmu(duizhang_id);
        return Result.success();
    }

    //查询所有队伍
    @RequestMapping("/findAllduiwu")
    public Result findAllduiwu(){
        return Result.success(duiWuService.findAllduiwu());
    }

    //删除队伍
    @RequestMapping("/deleteDuiwuById")
    public Result deleteDuiwuById(Integer id){
        duiWuService.deleteDuiwuById(id);
        return Result.success();
    }
}
