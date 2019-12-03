package com.young.android.oz.lib.common.exceptions;

import com.young.android.oz.lib.common.http.HttpCode;

/**
 * 定义基础异常类
 *
 * @author O.z Young
 * @version 2019-12-02
 */
public class BaseException extends RuntimeException {

    private int errorCode = HttpCode.CODE_UNKNOWN;

    public BaseException() {
    }

    public BaseException(int code, String errorMsg) {
        super(errorMsg);
        this.errorCode = code;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
