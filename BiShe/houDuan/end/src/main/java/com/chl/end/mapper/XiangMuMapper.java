package com.chl.end.mapper;

import com.chl.end.entity.DuiWu;
import com.chl.end.entity.Tu;
import com.chl.end.entity.XiangMu;
import com.chl.end.entity.XiangMuJieQu;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface XiangMuMapper {
    //需求发布
    @Insert("insert into xiangmu(xiangMuMing,zhuan_ye,shan_chang,start_shijian,end_shijian,qiye_id,xiang_qing) values(#{xiangMuMing},#{zhuan_ye},#{shan_chang},#{start_shijian},#{end_shijian},#{qiye_id},#{xiang_qing})")
    public void xuQiuSend(String xiangMuMing,String zhuan_ye,String shan_chang,Timestamp start_shijian,Timestamp end_shijian,Integer qiye_id,String xiang_qing);

    //查询队伍所接取的项目
    @Select("select xiangMuMing from xiangmu where duizhang_id=#{duizhang_id} AND jie_duan!=4")
    public String getXiangMuName(Integer duizhang_id);

    //查询所有项目,按时间排序
    @Select("select * from xiangmu where jie_duan=0 ORDER BY start_shijian DESC")
    public List<XiangMu> findAllXiangMu();

    //查看本人作为队长或独自接取过的项目
    @Select("select * from xiangmu where duizhang_id=#{duizhang_id}")
    public List<XiangMu> getXiangMuNameByDuizhangId(Integer duizhang_id);

    //查询企业发布的项目
    @Select("select * from xiangmu where qiye_id=#{qiye_id}")
    public List<XiangMu> getXiangMuByQiyeId(Integer qiye_id);

    //企业同意申请后，项目表update队长id和阶段
    @Update("update xiangmu set duizhang_id=#{id},jie_duan=1 where id=#{xiangMu_id}")
    public void updateDuizhangIdInXiangmu(Integer id,Integer xiangMu_id);

    //通过项目id获取项目
    @Select("select * from xiangmu where id=#{id}")
    public XiangMu findXiangmuById(Integer id);

    //查询项目中所有专业及数量
    @Select("select zhuan_ye AS name,count(zhuan_ye) AS value from xiangmu GROUP BY zhuan_ye")
    public List<Tu> findXiangmuListWithZhuanye();

    //jieduan1To2
    @Update("update xiangmu set jie_duan=2 where id=#{id}")
    public void jieduan1To2(Integer id);

    //jieduan2To3
    @Update("update xiangmu set jie_duan=3 where id=#{id}")
    public void jieduan2To3(Integer id);

    //jieduan3To4
    @Update("update xiangmu set jie_duan=4 where id=#{id}")
    public void jieduan3To4(Integer id);

    @Select("select * from xiangmu")
    List<XiangMu> getAllXiangMu();

    @Delete("delete from xiangmu where id=#{id}")
    void deleteXiangMuById(Integer id);
}
