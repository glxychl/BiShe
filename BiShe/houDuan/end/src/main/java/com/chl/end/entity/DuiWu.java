package com.chl.end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuiWu {
    private Integer id;
    private Integer duizhang_id;
    private Integer xiangMu_id;
    private String duiwuName;
    private String zhuan_ye;
    private String shan_chang;
    private String jian_jie;
    private Integer shu_liang;
    private Timestamp chuangJian_time;
    private String chuangJian_timeStr;
    private Integer shenQing;
}
