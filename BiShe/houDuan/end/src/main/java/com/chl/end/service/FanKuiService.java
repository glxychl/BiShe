package com.chl.end.service;

import com.chl.end.entity.FanKui;
import com.chl.end.mapper.FanKuiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FanKuiService {
    @Autowired(required=false)
    private FanKuiMapper fanKuiMapper;

    //对平台反馈
    public void fankuiPingtai(Integer fanKuiRen_id,String fanKuiRen_name,String fanKui){
        fanKuiMapper.fankuiPingtai(fanKuiRen_id,fanKuiRen_name,fanKui);
    }

    //对项目反馈
    public void fankuiXiangmu(Integer xiangMu_id,String xiangMu_name,Integer fanKuiRen_id,String fanKuiRen_name,String fanKui){
        fanKuiMapper.fankuiXiangmu(xiangMu_id,xiangMu_name,fanKuiRen_id,fanKuiRen_name,fanKui);
    }

    public List<FanKui> getAllFankui() {
        return fanKuiMapper.getAllFankui();
    }

    public void deleteFankuiById(Integer id) {
        fanKuiMapper.deleteFankuiById(id);
    }
}
