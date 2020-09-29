package com.zzc.intern.exception;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "RestErrorResponse", description = "错误响应参数包装")
@Data
public class RestErrorResponse {

    private Integer errCode;

    private String errMessage;

    public RestErrorResponse(Integer errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

}
