package com.wood.woodapi.provider.impl;

import com.wood.common.service.InnerUserInterfaceInfoService;
import com.wood.woodapi.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;

    /**
     * 调用成功，接口调用次数 +1 invokeCount (ak，sk (标识用户)，请求接口路径)
     * @param userId
     * @param interfaceInfoId
     * @return
     */
    @Override
    public boolean invokeCount(Long userId, Long interfaceInfoId) {
        return userInterfaceInfoService.invokeCount(userId, interfaceInfoId);
    }
}
