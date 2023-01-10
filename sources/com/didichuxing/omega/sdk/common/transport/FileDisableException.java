package com.didichuxing.omega.sdk.common.transport;

import java.io.IOException;

public class FileDisableException extends IOException {
    public static final int EXCEPTION_TYPE_413 = 1;
    public static final int EXCEPTION_TYPE_596 = 2;
    public static final int EXCEPTION_TYPE_DEFAULT = 0;
    private int mType = 0;

    public FileDisableException(int i) {
    }

    public FileDisableException(String str) {
        super(str);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }
}
