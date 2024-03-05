package com.chl.end.service;


import com.chl.end.entity.User;
import com.chl.end.entity.XiangMuJieQu;
import com.chl.end.mapper.XiangMuJieQuMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XiangMuJieQuService {
    @Autowired(required=false)
    private XiangMuJieQuMapper xiangMuJieQuMapper;

    //申请接取
    public void shenQing(Integer xiangMu_id,String xiangMu_name,Integer shenQingRen_id,String shenQingRen_name,Integer qiYe_id,String qiYe_name){
        xiangMuJieQuMapper.shenQing(xiangMu_id,xiangMu_name,shenQingRen_id,shenQingRen_name,qiYe_id,qiYe_name);
    }

    //查看项目申请人
    public List<XiangMuJieQu> getShenQingByXiangmuId(Integer xiangMu_id){
        return xiangMuJieQuMapper.getShenQingByXiangmuId(xiangMu_id);
    }

    //改变项目接取阶段
    public void changeJieduanById(Integer id,Integer xiangMu_id){
        xiangMuJieQuMapper.updateJieduanById(id);
        xiangMuJieQuMapper.updateJieduanFail(id,xiangMu_id);
    }

    //合作结束改变项目接取阶段
    public void endJiequ(Integer xiangMu_id,Integer shenQingRen_id){
        xiangMuJieQuMapper.endJiequ(xiangMu_id,shenQingRen_id);
    }

    public List<XiangMuJieQu> getAllXiangMuJieQu() {
        return xiangMuJieQuMapper.getAllXiangMuJieQu();
    }

    public void deleteXiangMuJieQuById(Integer id) {
        xiangMuJieQuMapper.deleteXiangMuJieQuById(id);
    }
}
