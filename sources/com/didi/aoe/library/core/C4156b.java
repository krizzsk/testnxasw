package com.didi.aoe.library.core;

import android.content.Context;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.core.AoeClient;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.util.List;

/* renamed from: com.didi.aoe.library.core.b */
/* compiled from: AoeProcessorImpl */
class C4156b implements AoeProcessor, AoeProcessor.InterpreterComponent<Object, Object>, AoeProcessor.ParcelComponent {

    /* renamed from: a */
    private final Logger f10019a = LoggerFactory.getLogger("AoeProcessor");

    /* renamed from: b */
    private final C4155a f10020b;

    public C4156b(Context context, AoeClient.Options options) {
        if (options.useRemoteService) {
            this.f10020b = new C4161g(context, options);
        } else {
            this.f10020b = new C4158d(context, options);
        }
    }

    public void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener) {
        this.f10020b.init(context, list, onInterpreterInitListener);
    }

    public Object run(Object obj) {
        return this.f10020b.run(obj);
    }

    public void release() {
        this.f10019a.debug("release", new Object[0]);
        this.f10020b.release();
    }

    public void setId(String str) {
        this.f10020b.setId(str);
    }

    public AoeProcessor.InterpreterComponent getInterpreterComponent() {
        return this.f10020b;
    }

    public AoeProcessor.ParcelComponent getParcelComponent() {
        return this.f10020b;
    }

    public boolean isReady() {
        return this.f10020b.isReady();
    }

    public byte[] obj2Byte(Object obj) {
        return this.f10020b.obj2Byte(obj);
    }

    public Object byte2Obj(byte[] bArr) {
        return this.f10020b.byte2Obj(bArr);
    }
}
