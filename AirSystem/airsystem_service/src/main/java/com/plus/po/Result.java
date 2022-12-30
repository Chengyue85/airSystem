package com.plus.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 要返回的实体类
@Data
@NoArgsConstructor
public class Result {
    private int code;
    private String msg;
    private List data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}


