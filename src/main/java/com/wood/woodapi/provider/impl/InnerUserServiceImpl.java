package com.wood.woodapi.provider.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wood.common.model.entity.User;
import com.wood.common.service.InnerUserService;
import com.wood.woodapi.mapper.UserMapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    UserMapper userMapper;

    /**
     * 数据库中查是否已经分配给用户密钥(ak，sk=>返回用户信息)
     * @param accessKey
     * @return
     */
    @Override
    public User getUserByAccessKey(String accessKey) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
