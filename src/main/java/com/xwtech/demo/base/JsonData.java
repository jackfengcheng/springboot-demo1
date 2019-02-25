package com.xwtech.demo.base;

import lombok.Data;

@Data
public class JsonData {

    private String msg;
    private Integer code;
    private Object data;

    public JsonData(Integer code) {
        this.code = code;
    }



    public static JsonData success(String msg,Object data){
        JsonData jsonData = new JsonData(0);
        jsonData.data =data;
        jsonData.msg =msg;
        return jsonData;
    }
    public static JsonData success(Object data){
        JsonData jsonData = new JsonData(0);
        jsonData.data =data;
        return jsonData;
    }

    public static JsonData success(){
        JsonData jsonData = new JsonData(0);
        return jsonData;
    }

    public static JsonData fail(String msg){
        JsonData jsonData = new JsonData(1);
        jsonData.msg =msg;
        return jsonData;
    }
}
