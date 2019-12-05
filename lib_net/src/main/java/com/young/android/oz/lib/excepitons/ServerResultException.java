package com.young.android.oz.lib.excepitons;

import com.young.android.oz.lib.common.exceptions.BaseException;

public class ServerResultException extends BaseException {

    public ServerResultException(int code, String msg) {
        super(code, msg);
    }

}
