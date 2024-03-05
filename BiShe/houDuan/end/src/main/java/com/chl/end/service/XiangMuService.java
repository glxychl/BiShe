package com.chl.end.service;

import com.chl.end.common.Result;
import com.chl.end.entity.Tu;
import com.chl.end.entity.XiangMu;
import com.chl.end.entity.XiangMuJieQu;
import com.chl.end.mapper.XiangMuMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class XiangMuService {
    @Autowired(required=false)
    private XiangMuMapper xiangMuMapper;
    //需求发布
    public Result xuQiuSend(String xiangMuMing,String zhuan_ye,String shan_chang,Timestamp end_shijian,Integer qiye_id,String xiang_qing){
        Timestamp start_shijian = new Timestamp(System.currentTimeMillis());//获取当前时间
        xiangMuMapper.xuQiuSend(xiangMuMing,zhuan_ye,shan_chang,start_shijian,end_shijian,qiye_id,xiang_qing);
        return Result.success();
    }

    //查询队伍所接取的项目
    public String getXiangMuName(Integer duizhang_id){
        String name = xiangMuMapper.getXiangMuName(duizhang_id);
        if (name == null) {
            return "该队伍暂未接取项目";
        } else {
            return name;
        }
    }

    //查询所有项目
    public List<XiangMu> findAllXiangMu(){
        return xiangMuMapper.findAllXiangMu();
    }

    //查看本人作为队长或独自接取过的项目
    public List<XiangMu> getXiangMuNameByDuizhangId(Integer duizhang_id){
        return xiangMuMapper.getXiangMuNameByDuizhangId(duizhang_id);
    }

    //查询企业发布的项目
    public List<XiangMu> getXiangMuByQiyeId(Integer qiye_id){
        List<XiangMu> all = xiangMuMapper.getXiangMuByQiyeId(qiye_id);
        List<XiangMu> newList = new ArrayList<>();
        for (XiangMu xm:all){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            xm.setStart_shijianStr(sdf.format(xm.getStart_shijian()));
            xm.setEnd_shijianStr(sdf.format(xm.getEnd_shijian()));
            newList.add(xm);
        }
        return newList;
    }

    //企业同意申请后，项目表update队长id
    public void updateDuizhangIdInXiangmu(Integer id,Integer xiangMu_id){
        xiangMuMapper.updateDuizhangIdInXiangmu(id,xiangMu_id);
    }

    //通过项目id获取项目
    public XiangMu findXiangmuById(Integer id){
        return xiangMuMapper.findXiangmuById(id);
    }

    //查询项目中所有专业及数量
    public List<Tu> findXiangmuListWithZhuanye(){
        return xiangMuMapper.findXiangmuListWithZhuanye();
    }

    //jieduan1To2
    public void jieduan1To2(Integer id){
        xiangMuMapper.jieduan1To2(id);
    }

    //jieduan2To3
    public void jieduan2To3(Integer id){
        xiangMuMapper.jieduan2To3(id);
    }

    //jieduan3To4
    public void jieduan3To4(Integer id){
        xiangMuMapper.jieduan3To4(id);
    }

    public List<XiangMu> getAllXiangMu() {
        return xiangMuMapper.getAllXiangMu();
    }

    public void deleteXiangMuById(Integer id) {
        xiangMuMapper.deleteXiangMuById(id);
    }
}
