package com.chl.end.controller;

import com.chl.end.common.Result;
import com.chl.end.service.TongZhiService;
import com.chl.end.service.UserService;
import com.chl.end.service.XiangMuJieQuService;
import com.chl.end.service.XiangMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/Mix")
public class MixController {
    @Autowired
    XiangMuJieQuService xiangMuJieQuService;
    @Autowired
    TongZhiService tongZhiService;
    @Autowired
    UserService userService;
    @Autowired
    XiangMuService xiangMuService;

    //申请接取,通知企业
    @RequestMapping("/shenQing")
    public Result shenQing(Integer xiangMu_id,String xiangMu_name,Integer shenQingRen_id,String shenQingRen_name,Integer qiYe_id,String qiYe_name){
        xiangMuJieQuService.shenQing(xiangMu_id,xiangMu_name,shenQingRen_id,shenQingRen_name,qiYe_id,qiYe_name);
        String tongZhiNeiRong = shenQingRen_name+"申请接取"+xiangMu_name+"项目";
        tongZhiService.shenQingToQiYe(qiYe_id,qiYe_name,shenQingRen_id,shenQingRen_name,tongZhiNeiRong);
        return Result.success();
    }

    //企业同意申请
    @RequestMapping("/acceptShenqing")
    public Result acceptShenqing(Integer xiangMu_id,Integer beiTongZhiRen_id,String beiTongZhiRen_name,Integer tongZhiRen_id,String tongZhiRen_name,String xiangMuMing){
        //企业同意申请，user表插入项目id
        userService.updateXiangmuIdInUser(xiangMu_id,beiTongZhiRen_id);
        //企业同意申请后，通知教师
        String tongZhiNeiRong = "接取"+xiangMuMing+"项目成功";
        tongZhiService.shenQingToQiYe(beiTongZhiRen_id,beiTongZhiRen_name,tongZhiRen_id,tongZhiRen_name,tongZhiNeiRong);
        //企业同意申请后，项目表update队长id
        xiangMuService.updateDuizhangIdInXiangmu(beiTongZhiRen_id, xiangMu_id);
        //改变项目接取阶段
        xiangMuJieQuService.changeJieduanById(beiTongZhiRen_id,xiangMu_id);
        return Result.success();
    }

    //jieduan1To2
    @RequestMapping("/jieduan1To2")
    public Result jieduan1To2(Integer id,Integer id1,Integer id2,String xiangMuMing){
        String tongZhiNeiRong = xiangMuMing+"项目合同已经签署";
        xiangMuService.jieduan1To2(id);
        tongZhiService.jianyiTongzhi(id1,tongZhiNeiRong);
        tongZhiService.jianyiTongzhi(id2,tongZhiNeiRong);
        return Result.success();
    }

    //jieduan2To3
    @RequestMapping("/jieduan2To3")
    public Result jieduan2To3(Integer id,Integer id1,Integer id2,String xiangMuMing){
        String tongZhiNeiRong = xiangMuMing+"项目已完成，等待资金结算";
        xiangMuService.jieduan2To3(id);
        tongZhiService.jianyiTongzhi(id1,tongZhiNeiRong);
        tongZhiService.jianyiTongzhi(id2,tongZhiNeiRong);
        return Result.success();
    }

    //jieduan3To4结束项目
    @RequestMapping("/jieduan3To4")
    public Result jieduan3To4(Integer xiangmuId,Integer qiYeId,Integer teacherId,String xiangMuMing){
        //消息通知和阶段改变
        String tongZhiNeiRong = xiangMuMing+"项目已结束";
        xiangMuService.jieduan3To4(xiangmuId);
        tongZhiService.jianyiTongzhi(qiYeId,tongZhiNeiRong);
        tongZhiService.jianyiTongzhi(teacherId,tongZhiNeiRong);
        //user表更新
        userService.endNullXiangmu(teacherId);
        //项目接取表更新
        xiangMuJieQuService.endJiequ(xiangmuId,teacherId);
        return Result.success();
    }
}
