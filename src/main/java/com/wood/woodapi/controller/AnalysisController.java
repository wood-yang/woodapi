package com.wood.woodapi.controller;

import com.wood.common.model.entity.InterfaceInfo;
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
import javax.servlet.http.HttpServletRequest;
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

    /**
     * 查出topN的接口信息
     * @param request
     * @return
     */
    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<List<InterfaceInfoVO>> getTopInterfaceInvoke(HttpServletRequest request) {
        List<InterfaceInfoVO> topInterfaceInvoke = interfaceInfoService.getTopInterfaceInvoke();
        if (topInterfaceInvoke == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(topInterfaceInvoke);
    }
}
