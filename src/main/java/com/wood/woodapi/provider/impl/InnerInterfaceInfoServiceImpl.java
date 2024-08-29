package com.wood.woodapi.provider.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wood.common.model.entity.InterfaceInfo;
import com.wood.common.service.InnerInterfaceInfoService;
import com.wood.woodapi.mapper.InterfaceInfoMapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    InterfaceInfoMapper interfaceInfoMapper;

    /**
     * 从数据库中查询模拟接口(请求路径，请求方法、请求参数 => 返回接口信息)
     * @param uri
     * @return
     */
    @Override
    public InterfaceInfo getInterfaceInfoByUri(String uri) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", uri);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
