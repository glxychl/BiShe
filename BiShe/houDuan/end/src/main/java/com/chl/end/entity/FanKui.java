package com.chl.end.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FanKui {
    Integer id;
    Integer xiangMu_id;
    String xiangMu_name;
    Integer fanKuiRen_id;
    String fanKuiRen_name;
    String fanKui;
}
