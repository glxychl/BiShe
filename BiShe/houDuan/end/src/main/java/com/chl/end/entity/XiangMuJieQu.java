package com.chl.end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class XiangMuJieQu {
    private Integer id;
    private Integer xiangMu_id;
    private Integer shenQingRen_id;
    private Integer qiYe_id;
    private Integer chuLiJieDuan;
    private String xiangMu_name;
    private String shenQingRen_name;
    private String qiYe_name;
}
