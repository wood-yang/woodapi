package com.wood.woodapi.controller;

import com.wood.woodapi.annotation.AuthCheck;
import com.wood.woodapi.common.BaseResponse;
import com.wood.woodapi.common.ErrorCode;
import com.wood.woodapi.common.ResultUtils;
import com.wood.woodapi.constant.UserConstant;
import com.wood.woodapi.exception.BusinessException;
import com.wood.woodapi.model.vo.InterfaceInfoVO;
import com.wood.woodapi.service.InterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分析控制器
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @GetMapping("/interfaceInfo")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<List<InterfaceInfoVO>> analysisInterfaceInfo() {
        List<InterfaceInfoVO> interfaceInfoVOList = interfaceInfoService.getTopInterfaceInvoke();
        if (interfaceInfoVOList == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(interfaceInfoVOList);
    }
}
