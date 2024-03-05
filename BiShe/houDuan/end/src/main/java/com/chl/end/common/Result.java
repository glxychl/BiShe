package com.chl.end.common;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
    public static final String CODE_SUCCESS="200";
    public static final String CODE_SYS_ERROR="500";
    public static final String CODE_USERNAME_ERROR="502";

    private String code;
    private String msg;
    private Object data;


    public static Result success(){
        return Result.builder().code(CODE_SUCCESS).msg("请求成功").build();
    }

    public static Result success(Object date){
        return new Result(CODE_SUCCESS,"请求成功",date);
    }

    public static Result error(String msg){
        return new Result(CODE_SYS_ERROR,msg,null);
    }

    public static Result error(String code,String msg){
        return new Result(code,msg ,null);
    }

    public static Result error(){
        return new Result(CODE_SYS_ERROR,"系统错误" ,null);
    }

    public static Result username_error(){
        return new Result(CODE_USERNAME_ERROR,"该用户名已注册！" ,null);
    }
}