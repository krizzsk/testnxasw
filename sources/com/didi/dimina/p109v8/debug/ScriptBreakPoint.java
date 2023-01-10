package com.didi.dimina.p109v8.debug;

import com.didi.dimina.p109v8.Releasable;
import com.didi.dimina.p109v8.V8Array;
import com.didi.dimina.p109v8.V8Object;
import com.didi.dimina.p109v8.V8ResultUndefined;

/* renamed from: com.didi.dimina.v8.debug.ScriptBreakPoint */
public class ScriptBreakPoint implements Releasable {
    private static final String CONDITION = "condition";
    private static final String LINE = "line";
    private static final String NUMBER = "number";
    private static final String SET_CONDITION = "setCondition";
    private V8Object v8Object;

    ScriptBreakPoint(V8Object v8Object2) {
        this.v8Object = v8Object2.twin();
    }

    public int getBreakPointNumber() {
        return this.v8Object.executeIntegerFunction(NUMBER, (V8Array) null);
    }

    public int getLine() {
        return this.v8Object.executeIntegerFunction("line", (V8Array) null);
    }

    public void setCondition(String str) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        try {
            this.v8Object.executeVoidFunction(SET_CONDITION, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public String getCondition() {
        try {
            return this.v8Object.executeStringFunction(CONDITION, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return "undefined";
        }
    }

    public void close() {
        V8Object v8Object2 = this.v8Object;
        if (v8Object2 != null && !v8Object2.isReleased()) {
            this.v8Object.close();
            this.v8Object = null;
        }
    }

    public void release() {
        close();
    }
}
