package com.wood.woodapi.provider.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wood.common.model.entity.UserInterfaceInfo;
import com.wood.common.service.InnerUserInterfaceInfoService;
import com.wood.woodapi.mapper.UserInterfaceInfoMapper;
import com.wood.woodapi.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;

    @Resource
    UserInterfaceInfoMapper userInterfaceInfoMapper;

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

    @Override
    public boolean isEnough(Long userId, Long interfaceInfoId) {
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();

        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.selectList(queryWrapper);
        if (userInterfaceInfoList == null) {
            return false;
        }
        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoList.get(0);
        if (userInterfaceInfo == null || userInterfaceInfo.getLeftNum() <= 0 || userInterfaceInfo.getTotalNum() > 1000) {
            return false;
        }
        return true;
    }
}
