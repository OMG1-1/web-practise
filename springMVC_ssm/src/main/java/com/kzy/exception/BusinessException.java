package com.kzy.exception;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/12
 * @time 21:09
 * @note ……
 */
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
