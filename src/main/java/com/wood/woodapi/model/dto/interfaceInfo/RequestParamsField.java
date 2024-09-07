package com.wood.woodapi.model.dto.interfaceInfo;

import lombok.Data;

@Data
public class RequestParamsField {
    private String id;
    private String fieldName;
    private String type;
    private String desc;
    private String required;
}