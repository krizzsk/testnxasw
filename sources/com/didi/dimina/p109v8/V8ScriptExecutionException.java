package com.didi.dimina.p109v8;

/* renamed from: com.didi.dimina.v8.V8ScriptExecutionException */
public class V8ScriptExecutionException extends V8ScriptException {
    V8ScriptExecutionException(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        this(str, i, str2, str3, i2, i3, str4, (Throwable) null);
    }

    V8ScriptExecutionException(String str, int i, String str2, String str3, int i2, int i3, String str4, Throwable th) {
        super(str, i, str2, str3, i2, i3, str4, th);
    }
}
