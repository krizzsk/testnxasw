package com.didi.foundation.sdk.net;

public abstract class SFRpcResult<T> {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNKNOWN = -1;

    public abstract int getCode();

    public abstract T getData();

    public abstract String getMessage();

    public abstract long getServiceTime();
}
