package com.wood.woodapi.model.dto.userinterfaceInfo;

import com.wood.woodapi.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInterfaceInfoQueryRequest extends PageRequest implements Serializable {
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 调用接口 id
     */
    private Long interfaceInfoId;

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