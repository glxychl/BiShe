package com.chl.end.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String safe;
    private Integer role;
    private String name;
    private String address;
    private String contact;
    private String zhuan_ye;
    private String shan_chang;
    private String bu_shanchang;
    private String experience;
    private String gui_mo;
    private String ye_wu;
    private Integer duiWu;
    private Integer isDuiZhang;
    private Integer xiangMu_id;
}
