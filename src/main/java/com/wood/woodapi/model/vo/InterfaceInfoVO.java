package com.wood.woodapi.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子视图
 *
 *
 */
@Data
public class InterfaceInfoVO implements Serializable {

    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 接口描述
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 接口类型
     */
    private String method;

    /**
     * 状态(0 - 关闭 1 - 打开)
     */
    private Integer status;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 创建人 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
