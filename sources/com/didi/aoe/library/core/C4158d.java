package com.didi.aoe.library.core;

import android.content.Context;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.core.AoeClient;
import java.util.List;

/* renamed from: com.didi.aoe.library.core.d */
/* compiled from: NativeProcessorWrapper */
final class C4158d extends C4155a {

    /* renamed from: b */
    private final AoeProcessor.InterpreterComponent f10025b;

    /* renamed from: c */
    private final AoeProcessor.ParcelComponent f10026c;

    public C4158d(Context context, AoeClient.Options options) {
        super(context, options);
        this.f10025b = C4157c.m8699b(options.interpreterClassName);
        this.f10026c = C4157c.m8700c(options.parcelerClassName);
    }

    public void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener) {
        this.f10025b.init(context, list, onInterpreterInitListener);
    }

    public Object run(Object obj) {
        return this.f10025b.run(obj);
    }

    public void release() {
        this.f10025b.release();
    }

    public AoeProcessor.InterpreterComponent getInterpreterComponent() {
        return this.f10025b;
    }

    public AoeProcessor.ParcelComponent getParcelComponent() {
        return this.f10026c;
    }
}
