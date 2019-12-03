package com.young.android.oz.lib.common.exceptions;

import com.young.android.oz.lib.common.http.HttpCode;

/**
 * 参数错误异常类
 *
 * @author O.z Young
 * @version 2019-12-03
 */
public class ParameterInvalidException extends BaseException {

    public ParameterInvalidException() {
        super(HttpCode.CODE_PARAM_INVALID, "参数错误");
    }

}
