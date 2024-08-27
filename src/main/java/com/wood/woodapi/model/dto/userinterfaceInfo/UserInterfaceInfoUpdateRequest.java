package com.wood.woodapi.model.dto.userinterfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 *
 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {
    /**
     * 自增ID
     */
    private Long id;

//    /**
//     * 调用用户 id
//     */
//    private Long userId;
//
//    /**
//     * 调用接口 id
//     */
//    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 是否允许调用(0 - 允许 1 - 不允许)
     */
    private Integer status;
}