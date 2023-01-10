package com.didichuxing.security.quickjs;

public abstract class JSNumber extends JSValue {
    public abstract byte getByte();

    public abstract double getDouble();

    public abstract float getFloat();

    public abstract int getInt();

    public abstract long getLong();

    public abstract short getShort();

    JSNumber(long j, JSContext jSContext) {
        super(j, jSContext);
    }
}
