package com.didi.dimina.container.jsengine.method;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.jsengine.JSArray;

public class Invoke implements JSCallback {

    /* renamed from: a */
    DMMina f18724a;

    public Invoke(DMMina dMMina) {
        this.f18724a = dMMina;
    }

    public Object callback(JSArray jSArray) {
        return this.f18724a.getMessageTransfer().invokeNativeFromService(jSArray);
    }
}
