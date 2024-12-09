package com.tracking.generate.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private String errorMessage;
    private int errorCode;
    private List<String> errorMessageList;
    private String fieldName;

    public ApiError(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public ApiError(List<String> errorMessageList, int errorCode) {
        this.errorMessageList = errorMessageList;
        this.errorCode = errorCode;
    }
}
