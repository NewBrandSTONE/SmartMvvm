package com.young.android.oz.lib.lottery.core.base;

/**
 * 消息驱动类
 * <p>
 * 参考资料
 * https://www.wanandroid.com/blog/show/2529
 *
 * @author O.z Young
 * @version 2019-12-01
 */
public class BaseAction {

    private int action;

    public BaseAction(int action) {
        this.action = action;
    }

    public int getAction() {
        return this.action;
    }

}
