package com.wood.woodapi.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wood.woodapi.model.dto.userinterfaceInfo.UserInterfaceInfoQueryRequest;
import com.wood.woodapi.model.entity.UserInterfaceInfo;

/**
* @author 24420
* @description 针对表【user_interface_info(用户调用接口信息)】的数据库操作Service
* @createDate 2024-08-27 09:52:18
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    Wrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest);

    boolean invokeCount(Long userId, Long interfaceInfoId);
}
