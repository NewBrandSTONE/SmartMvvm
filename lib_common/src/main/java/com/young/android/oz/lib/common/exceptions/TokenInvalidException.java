package com.young.android.oz.lib.common.exceptions;

import com.young.android.oz.lib.common.http.HttpCode;

/**
 * Token无效异常类
 *
 * @author O.z Young
 * @version 2019-12-03
 */
public class TokenInvalidException extends BaseException {

    public TokenInvalidException() {
        super(HttpCode.CODE_TOKEN_INVALID, "Token失效");
    }

}
