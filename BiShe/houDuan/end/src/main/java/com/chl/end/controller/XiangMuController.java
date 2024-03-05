package com.chl.end.controller;


import com.chl.end.common.Result;
import com.chl.end.entity.DuiWu;
import com.chl.end.entity.XiangMu;
import com.chl.end.service.XiangMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/XiangMu")
public class XiangMuController {
    @Autowired
    private XiangMuService xiangMuService;
    //需求发布
    @RequestMapping("/xuQiuSend")
    public Result xuQiuSend(String xiangMuMing,String zhuan_ye,String shan_chang,String str_end_shijian,Integer qiye_id,String xiang_qing) {
        Timestamp end_shijian = Timestamp.valueOf(str_end_shijian);
        return xiangMuService.xuQiuSend(xiangMuMing,zhuan_ye,shan_chang,end_shijian,qiye_id,xiang_qing);
    }

    //查询队伍所接取的项目
    @RequestMapping("/getXiangMuName")
    public Result getXiangMuName(Integer duizhang_id){
        return Result.success(xiangMuService.getXiangMuName(duizhang_id));
    }

    //查询所有项目
    @RequestMapping("/findAllXiangMu")
    public Result findAllXiangMu(String zhuan_ye, String shan_chang, String bu_shanchang){
        List<XiangMu> all = xiangMuService.findAllXiangMu();
        List<XiangMu> first = new ArrayList<>();
        List<XiangMu> second = new ArrayList<>();
        List<XiangMu> third = new ArrayList<>();
        List<XiangMu> last = new ArrayList<>();
        List<XiangMu> newList = new ArrayList<>();
        for (XiangMu xm:all) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            xm.setStart_shijianStr(sdf.format(xm.getStart_shijian()));
            xm.setEnd_shijianStr(sdf.format(xm.getEnd_shijian()));
            if (xm.getShan_chang().equals(shan_chang)) {
                first.add(xm);
            } else if (xm.getShan_chang().equals(bu_shanchang)) {
                third.add(xm);
            } else if (xm.getZhuan_ye().equals(zhuan_ye)) {
                second.add(xm);
            } else {
                last.add(xm);
            }
        }
        newList.addAll(first);
        newList.addAll(second);
        newList.addAll(third);
        newList.addAll(last);
        return Result.success(newList);
    }

    //查看本人作为队长或独自接取过的项目
    @RequestMapping("/getXiangMuNameByDuizhangId")
    public Result getXiangMuNameByDuizhangId(Integer duizhang_id){
        return Result.success(xiangMuService.getXiangMuNameByDuizhangId(duizhang_id));
    }

    //查询企业发布的项目
    @RequestMapping("/getXiangMuByQiyeId")
    public Result getXiangMuByQiyeId(Integer qiye_id){
        return Result.success(xiangMuService.getXiangMuByQiyeId(qiye_id));
    }

    //通过项目id获取项目
    @RequestMapping("/findXiangmuById")
    public Result findXiangmuById(Integer id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        XiangMu xiangMu = xiangMuService.findXiangmuById(id);
        xiangMu.setStart_shijianStr(sdf.format(xiangMu.getStart_shijian()));
        xiangMu.setEnd_shijianStr(sdf.format(xiangMu.getEnd_shijian()));
        return Result.success(xiangMu);
    }

    //查询项目中所有专业及数量
    @RequestMapping("/findXiangmuListWithZhuanye")
    public Result findXiangmuListWithZhuanye(){
        return Result.success(xiangMuService.findXiangmuListWithZhuanye());
    }

    @RequestMapping("/getAllXiangMu")
    public Result getAllXiangMu(){
        return Result.success(xiangMuService.getAllXiangMu());
    }

    @RequestMapping("/deleteXiangMuById")
    public Result deleteXiangMuById(Integer id) {
        xiangMuService.deleteXiangMuById(id);
        return Result.success();
    }
}
