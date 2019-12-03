package com.young.android.oz.lib.common.http;

/**
 * 定义HTTP常量
 *
 * @author O.z Young
 * @version 2019-12-03
 */
public class HttpCode {

    private HttpCode() {

    }

    public static final int CODE_SUCCESS = 0;

    public static final int CODE_UNKNOWN = -1;

    public static final int CODE_TOKEN_INVALID = -2;

    public static final int CODE_ACCOUNT_INVALID = -3;

    public static final int CODE_PARAM_INVALID = -4;

    public static final int CODE_CONNECTION_FAILED = -5;

    public static final int CODE_FORBIDDEN = -6;

    public static final int CODE_RESULT_INVALID = -7;

}
