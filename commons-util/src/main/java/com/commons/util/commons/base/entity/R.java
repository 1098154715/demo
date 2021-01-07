package com.commons.util.commons.base.entity;

import lombok.Data;

/**
 * 返回标准格式
 * @author cxk
 * @date 2020/12/31 15:37
 */
@Data
public class R {
    Integer code;
    String msg;
    Object data;

    private R(){}
    private R(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    private R(Integer code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
    public static R success(){
        return new R(0,"执行成功！");
    }

    public static R error(){
        return new R(1,"执行失败！");
    }
    public static R success(String msg){
        return new R(0,msg);
    }

    public static R error(String msg){
        return new R(1,msg);
    }

    public static R success(String msg,Object data){
        return new R(0,msg,data);
    }

    public static R error(String msg,Object data){
        return new R(1,msg,data);
    }

    public static R success(Integer code,String msg,Object data){
        return new R(code,msg,data);
    }

    public static R error(Integer code,String msg,Object data){
        return new R(code,msg,data);
    }


}
