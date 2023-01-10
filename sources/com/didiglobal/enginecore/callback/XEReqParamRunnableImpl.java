package com.didiglobal.enginecore.callback;

public abstract class XEReqParamRunnableImpl implements XEReqParamRunnable, Cloneable {
    protected XERunnableCallback runnableCallback;

    public void setRunnableCallback(XERunnableCallback xERunnableCallback) {
        this.runnableCallback = xERunnableCallback;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
