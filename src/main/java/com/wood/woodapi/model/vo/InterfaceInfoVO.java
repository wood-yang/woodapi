package com.wood.woodapi.model.vo;

import com.wood.common.model.entity.InterfaceInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * 接口信息封装类
 *
 */
@Data
public class InterfaceInfoVO extends InterfaceInfo implements Serializable {

    /**
     * 总调用次数
     */
    private Integer totalInvokeNum;

}
