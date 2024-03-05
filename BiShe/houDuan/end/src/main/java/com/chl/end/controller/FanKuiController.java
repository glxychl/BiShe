package com.chl.end.controller;


import com.chl.end.common.Result;
import com.chl.end.service.FanKuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/fanKui")
public class FanKuiController {
    @Autowired
    private FanKuiService fanKuiService;

    //对平台反馈
    @RequestMapping("/fankuiPingtai")
    public Result fankuiPingtai(Integer fanKuiRen_id, String fanKuiRen_name, String fanKui){
        fanKuiService.fankuiPingtai(fanKuiRen_id,fanKuiRen_name,fanKui);
        return Result.success();
    }

    //对项目反馈
    @RequestMapping("/fankuiXiangmu")
    public Result fankuiXiangmu(Integer xiangMu_id,String xiangMu_name,Integer fanKuiRen_id,String fanKuiRen_name,String fanKui){
        fanKuiService.fankuiXiangmu(xiangMu_id,xiangMu_name,fanKuiRen_id,fanKuiRen_name,fanKui);
        return Result.success();
    }

    //获取所有反馈
    @RequestMapping("/getAllFankui")
    public Result getAllFankui(){
        return Result.success(fanKuiService.getAllFankui());
    }

    @RequestMapping("/deleteFankuiById")
    public Result deleteFankuiById(Integer id){
        fanKuiService.deleteFankuiById(id);
        return Result.success();
    }
}
