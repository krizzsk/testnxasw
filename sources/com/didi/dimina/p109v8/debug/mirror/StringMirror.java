package com.didi.dimina.p109v8.debug.mirror;

import com.didi.dimina.p109v8.V8Array;
import com.didi.dimina.p109v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.StringMirror */
public class StringMirror extends ValueMirror {
    public boolean isString() {
        return true;
    }

    StringMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String toString() {
        return this.v8Object.executeStringFunction("toText", (V8Array) null);
    }
}
