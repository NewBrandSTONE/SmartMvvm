package ztc.com.fragmentation.smart.smart.mvvm.base;

import java.io.Serializable;

public class BaseRequest<T> implements Serializable {

    private String reqId;
    private String token;
    private String sign;
    private T data;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "reqId='" + reqId + '\'' +
                ", token='" + token + '\'' +
                ", sign='" + sign + '\'' +
                ", data=" + data +
                '}';
    }
}
