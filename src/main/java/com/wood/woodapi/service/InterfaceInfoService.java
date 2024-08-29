package com.wood.woodapi.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wood.woodapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.wood.common.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 24420
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-08-24 16:35:41
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    Wrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);
}
