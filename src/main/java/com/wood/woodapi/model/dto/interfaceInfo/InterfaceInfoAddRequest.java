package com.wood.woodapi.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建请求
 *
*
 */
@Data
public class InterfaceInfoAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 接口请求参数
     */
    private List<RequestParamsField> requestParams;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求示例
     */
    private String requestExample;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 接口响应参数
     */
    private List<ResponseParamsField> responseParams;

    /**
     * 返回格式
     */
    private String returnFormat;
}