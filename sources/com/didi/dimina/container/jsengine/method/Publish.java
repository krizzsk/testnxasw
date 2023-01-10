package com.didi.dimina.container.jsengine.method;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.jsengine.JSArray;

public class Publish implements JSCallback {

    /* renamed from: a */
    DMMina f18728a;

    public Publish(DMMina dMMina) {
        this.f18728a = dMMina;
    }

    public Object callback(JSArray jSArray) {
        Integer integer = jSArray.getInteger(1);
        this.f18728a.getMessageTransfer().sendMessageToWebView(integer.intValue(), jSArray.getString(0));
        return null;
    }
}
