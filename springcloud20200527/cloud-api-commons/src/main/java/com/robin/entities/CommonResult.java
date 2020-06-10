package com.robin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/27 14:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

//    设置一下，如果返回前端为空的情况
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
