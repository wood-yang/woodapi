package com.wood.woodapi.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口调用请求
 *
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 用户请求参数
     */
    private String userRequestParams;
}