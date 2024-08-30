package com.wood.woodapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wood.common.model.entity.UserInterfaceInfo;
import com.wood.woodapi.common.ErrorCode;
import com.wood.woodapi.constant.CommonConstant;
import com.wood.woodapi.exception.BusinessException;
import com.wood.woodapi.exception.ThrowUtils;
import com.wood.woodapi.mapper.UserInterfaceInfoMapper;
import com.wood.woodapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.wood.common.model.entity.InterfaceInfo;
import com.wood.woodapi.model.vo.InterfaceInfoVO;
import com.wood.woodapi.service.InterfaceInfoService;
import com.wood.woodapi.mapper.InterfaceInfoMapper;
import com.wood.woodapi.utils.SqlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 24420
 * @description 针对表【interface_info(接口信息)】的数据库操作Service实现
 * @createDate 2024-08-24 16:35:41
 */
@Service
@Slf4j
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {

    @Resource
    UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        String url = interfaceInfo.getUrl();
        String method = interfaceInfo.getMethod();

        Long id = interfaceInfo.getId();
        Long userId = interfaceInfo.getUserId();
        String description = interfaceInfo.getDescription();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name, url, method), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (id != null && id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "id 错误");
        }
        if (userId != null && userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "userId 错误");
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口名称过长");
        }
        if (StringUtils.isNotBlank(url) && url.length() > 2000) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口地址过长");
        }
        if (StringUtils.isNotBlank(method) && method.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口方法过长");
        }
        if (StringUtils.isNotBlank(description) && description.length() > 2000) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口描述过长");
        }
        if (StringUtils.isNotBlank(requestHeader) && requestHeader.length() > 2000) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求头过长");
        }
        if (StringUtils.isNotBlank(responseHeader) && responseHeader.length() > 2000) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "响应头过长");
        }
    }


    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (interfaceInfoQueryRequest == null) {
            return queryWrapper;
        }
        String searchText = interfaceInfoQueryRequest.getSearchText();
        String sortField = interfaceInfoQueryRequest.getSortField();
        String sortOrder = interfaceInfoQueryRequest.getSortOrder();

        String name = interfaceInfoQueryRequest.getName();
        String url = interfaceInfoQueryRequest.getUrl();
        String method = interfaceInfoQueryRequest.getMethod();
        Long id = interfaceInfoQueryRequest.getId();
        Long userId = interfaceInfoQueryRequest.getUserId();
        String description = interfaceInfoQueryRequest.getDescription();
        String requestHeader = interfaceInfoQueryRequest.getRequestHeader();
        String responseHeader = interfaceInfoQueryRequest.getResponseHeader();

        // 拼接查询条件
        if (StringUtils.isNotBlank(searchText)) {
            queryWrapper.and(qw -> qw.like("name", searchText).or().like("description", searchText));
        }
        queryWrapper.like(StringUtils.isNotBlank(name), "name", name);
        queryWrapper.like(StringUtils.isNotBlank(description), "description", description);
        queryWrapper.eq(ObjectUtils.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.like(StringUtils.isNotBlank(url), "url", url);
        queryWrapper.like(StringUtils.isNotBlank(method), "method", method);
        queryWrapper.like(StringUtils.isNotBlank(requestHeader), "requestHeader", requestHeader);
        queryWrapper.like(StringUtils.isNotBlank(responseHeader), "responseHeader", responseHeader);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

    @Override
    public List<InterfaceInfoVO> getTopInterfaceInvoke() {
        List<InterfaceInfoVO> interfaceInfoVOList = userInterfaceInfoMapper.getTopInterfaceInvoke();
        InterfaceInfoVO other = new InterfaceInfoVO();
        if (interfaceInfoVOList.size() >= 4) {
            other.setName("其他接口");
            other.setTotalInvokeNum(0);
            for (int i = 4; i <= interfaceInfoVOList.size(); i++) {
                InterfaceInfoVO interfaceInfoVO = interfaceInfoVOList.get(i - 1);
                other.setTotalInvokeNum(other.getTotalInvokeNum() + interfaceInfoVO.getTotalInvokeNum());
            }
        }
        for (int i = 1; i <= 3 && i <= interfaceInfoVOList.size(); i++) {
            InterfaceInfoVO interfaceInfoVO = interfaceInfoVOList.get(i - 1);
            Long id = interfaceInfoVO.getId();
            InterfaceInfo interfaceInfo = this.getById(id);
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            interfaceInfoVOList.set(i - 1, interfaceInfoVO);
        }
        while (interfaceInfoVOList.size() > 3) {
            interfaceInfoVOList.remove(3);
        }
        if (other.getTotalInvokeNum() > 0) {
            interfaceInfoVOList.add(other);
        }
        return interfaceInfoVOList;
    }

}




