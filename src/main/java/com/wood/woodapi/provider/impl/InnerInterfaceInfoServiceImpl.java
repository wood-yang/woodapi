package com.wood.woodapi.provider.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wood.common.model.entity.InterfaceInfo;
import com.wood.common.service.InnerInterfaceInfoService;
import com.wood.woodapi.mapper.InterfaceInfoMapper;

import javax.annotation.Resource;

public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    InterfaceInfoMapper interfaceInfoMapper;

    /**
     * 从数据库中查询模拟接口(请求路径，请求方法、请求参数 => 返回接口信息)
     * @param uri
     * @param path
     * @return
     */
    @Override
    public InterfaceInfo getInterfaceInfoByUriAndPath(String uri, String path) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        String url = uri + path;
        queryWrapper.eq("url", url);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
