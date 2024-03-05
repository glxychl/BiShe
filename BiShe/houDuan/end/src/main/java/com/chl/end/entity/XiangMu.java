package com.chl.end.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XiangMu {
    private Integer id;
    private String xiangMuMing;
    private String zhuan_ye;
    private String shan_chang;
    private Timestamp start_shijian;
    private Timestamp end_shijian;
    private String qiye_id;
    private Integer duizhang_id;
    private Integer jie_duan;
    private String xiang_qing;
    private String start_shijianStr;
    private String end_shijianStr;
}
