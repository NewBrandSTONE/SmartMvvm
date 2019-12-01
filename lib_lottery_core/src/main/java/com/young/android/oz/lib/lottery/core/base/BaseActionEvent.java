package com.young.android.oz.lib.lottery.core.base;

/**
 * 定义基础的消息驱动类
 *
 * @author O.z Young
 * @version 2019-12-01
 */
public class BaseActionEvent extends BaseAction {

    public static final int SHOW_LOADING_DIALOG = 1;

    public static final int DISMISS_LOADING_DIALOG = 2;

    public static final int SHOW_TOAST = 3;

    public static final int FINISH = 4;

    public static final int FINISH_WITH_RESULT_OK = 5;

    private String message;

    public BaseActionEvent(int action) {
        super(action);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
