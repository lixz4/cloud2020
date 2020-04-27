package com.lixz.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lixz
 * @date 2020/4/26 - 17:35
 */
@Data
@AllArgsConstructor //全参构造器
@NoArgsConstructor  //无参构造器
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
