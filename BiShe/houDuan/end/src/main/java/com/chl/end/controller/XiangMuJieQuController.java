package com.chl.end.controller;

import com.chl.end.common.Result;
import com.chl.end.entity.XiangMuJieQu;
import com.chl.end.service.XiangMuJieQuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/XiangMuJieQu")
public class XiangMuJieQuController {
    @Autowired
    private XiangMuJieQuService xiangMuJieQuService;

    //查看项目申请人
    @RequestMapping("/getShenQingByXiangmuId")
    public Result getShenQingByXiangmuId(Integer xiangMu_id){
        return Result.success(xiangMuJieQuService.getShenQingByXiangmuId(xiangMu_id));
    }

    @RequestMapping("/getAllXiangMuJieQu")
    public Result getAllXiangMuJieQu(){
        return Result.success(xiangMuJieQuService.getAllXiangMuJieQu());
    }

    @RequestMapping("/deleteXiangMuJieQuById")
    public Result deleteXiangMuJieQuById(Integer id) {
        xiangMuJieQuService.deleteXiangMuJieQuById(id);
        return Result.success();
    }

}
