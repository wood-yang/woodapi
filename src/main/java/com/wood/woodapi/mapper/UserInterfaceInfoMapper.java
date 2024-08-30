package com.wood.woodapi.mapper;

import com.wood.common.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wood.woodapi.model.vo.InterfaceInfoVO;

import java.util.List;

/**
* @author 24420
* @description 针对表【user_interface_info(用户调用接口信息)】的数据库操作Mapper
* @createDate 2024-08-27 09:52:18
* @Entity com.wood.common.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {


    List<InterfaceInfoVO> getTopInterfaceInvoke();
}




