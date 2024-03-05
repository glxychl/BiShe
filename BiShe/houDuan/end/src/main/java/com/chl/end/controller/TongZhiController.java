package com.chl.end.controller;


import com.chl.end.common.Result;
import com.chl.end.entity.TongZhi;
import com.chl.end.service.TongZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/TongZhi")
public class TongZhiController {
    @Autowired
    private TongZhiService tongZhiService;

    //通知被通知人
    @RequestMapping("/tongZhi")
    public Result tongZhi(Integer beiTongZhiRen_id){
        return Result.success(tongZhiService.tongZhi(beiTongZhiRen_id));
    }

    //未读消息通知
    @RequestMapping("/noRead")
    public Result noRead(Integer beiTongZhiRen_id){
        return Result.success(tongZhiService.noRead(beiTongZhiRen_id));
    }

    //已读消息通知
    @RequestMapping("/read")
    public Result read(Integer beiTongZhiRen_id){
        return Result.success(tongZhiService.read(beiTongZhiRen_id));
    }

    //全部已读按钮
    @RequestMapping("/allRead")
    public Result allRead(Integer beiTongZhiRen_id) {
        tongZhiService.allRead(beiTongZhiRen_id);
        return Result.success();
    }

    //发送邀请信息
    @RequestMapping("/yaoQingTeacher")
    public Result yaoQingTeacher(Integer beiTongZhiRen_id,String beiTongZhiRen_name,Integer tongZhiRen_id,String tongZhiRen_name,String xiangMuMing){
        String tongZhiNeiRong = tongZhiRen_name+"邀请您承接"+xiangMuMing+"项目";
        tongZhiService.shenQingToQiYe(beiTongZhiRen_id,beiTongZhiRen_name,tongZhiRen_id,tongZhiRen_name,tongZhiNeiRong);
        return Result.success();
    }

    @RequestMapping("/getAllTongzhi")
    public Result getAllTongzhi(){
        return Result.success(tongZhiService.getAllTongzhi());
    }

    @RequestMapping("/deleteTongZhiById")
    public Result deleteTongZhiById(Integer id) {
        tongZhiService.deleteTongZhiById(id);
        return Result.success();
    }
}
