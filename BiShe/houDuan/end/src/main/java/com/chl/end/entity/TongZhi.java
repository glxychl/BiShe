package com.chl.end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TongZhi {
    private Integer id;
    private Integer beiTongZhiRen_id;
    public String beiTongZhiRen_name;
    private Integer tongZhiRen_id;
    private String tongZhiRen_name;
    private String tongZhiNeiRong;
    private Integer isRead;
}
