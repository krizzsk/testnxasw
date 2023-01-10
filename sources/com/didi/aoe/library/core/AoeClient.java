package com.didi.aoe.library.core;

import android.content.Context;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.api.interpreter.InterpreterInitResult;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.lang.AoeIOException;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class AoeClient {

    /* renamed from: a */
    private final Logger f10010a;

    /* renamed from: b */
    private final Context f10011b;

    /* renamed from: c */
    private final AoeProcessor f10012c;

    /* renamed from: d */
    private final List<AoeModelOption> f10013d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public InterpreterInitResult f10014e;

    public static class OnInitListener {
        public void onFailed(int i, String str) {
        }

        public void onSuccess() {
        }
    }

    public AoeClient(Context context, Options options, String str) {
        this(context, str, options, str, new String[0]);
    }

    public AoeClient(Context context, String str, Options options, String str2, String... strArr) {
        this.f10010a = LoggerFactory.getLogger("AoeClient");
        this.f10013d = new ArrayList();
        this.f10014e = InterpreterInitResult.create(-1);
        this.f10011b = context;
        try {
            m8689a(context, C4157c.m8697a(options.modelOptionLoaderClassName), str2, strArr);
        } catch (AoeIOException e) {
            this.f10014e = InterpreterInitResult.create(1, "ModelOption parse error: " + e.getMessage());
        }
        C4156b bVar = new C4156b(context, options);
        this.f10012c = bVar;
        bVar.setId(str);
    }

    public void init(OnInitListener onInitListener) {
        m8691a(onInitListener);
    }

    /* renamed from: a */
    private void m8689a(Context context, AoeProcessor.ModelOptionLoaderComponent modelOptionLoaderComponent, String str, String... strArr) throws AoeIOException {
        AoeModelOption load = modelOptionLoaderComponent.load(context, str);
        Logger logger = this.f10010a;
        logger.debug("[tryLoadModelOptions] ModelOption: " + load, new Object[0]);
        if (load != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(load);
            if (strArr != null) {
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    AoeModelOption load2 = modelOptionLoaderComponent.load(context, strArr[i]);
                    Logger logger2 = this.f10010a;
                    logger2.debug("Subsequent model: " + load2, new Object[0]);
                    if (load2 != null) {
                        arrayList.add(load2);
                        i++;
                    } else {
                        throw new AoeIOException("ModelOption load error, no sub model.");
                    }
                }
            }
            this.f10013d.clear();
            this.f10013d.addAll(arrayList);
            return;
        }
        throw new AoeIOException("ModelOption load error, no main model.");
    }

    /* renamed from: a */
    private void m8691a(final OnInitListener onInitListener) {
        if (-1 != this.f10014e.getCode() && 3 != this.f10014e.getCode()) {
            m8690a(this.f10014e, onInitListener);
        } else if (m8693a()) {
            this.f10012c.getInterpreterComponent().init(this.f10011b, this.f10013d, new OnInterpreterInitListener() {
                public void onInitResult(InterpreterInitResult interpreterInitResult) {
                    InterpreterInitResult unused = AoeClient.this.f10014e = interpreterInitResult;
                    AoeClient.this.m8690a(interpreterInitResult, onInitListener);
                }
            });
        } else {
            m8690a(this.f10014e, onInitListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8690a(InterpreterInitResult interpreterInitResult, OnInitListener onInitListener) {
        if (onInitListener == null) {
            return;
        }
        if (interpreterInitResult.getCode() == 0) {
            onInitListener.onSuccess();
        } else {
            onInitListener.onFailed(interpreterInitResult.getCode(), interpreterInitResult.getMsg());
        }
    }

    public boolean isRunning() {
        return this.f10012c.getInterpreterComponent().isReady();
    }

    /* renamed from: a */
    private boolean m8693a() {
        return !this.f10013d.isEmpty();
    }

    /* renamed from: b */
    private boolean m8694b() {
        return this.f10014e.getCode() == 0;
    }

    public Object process(Object obj) {
        if (m8694b()) {
            return this.f10012c.getInterpreterComponent().run(obj);
        }
        m8691a((OnInitListener) null);
        return null;
    }

    public void release() {
        this.f10012c.getInterpreterComponent().release();
    }

    public static class Options implements Serializable {
        String interpreterClassName;
        String modelOptionLoaderClassName;
        String parcelerClassName;
        int threadNum = 1;
        boolean useRemoteService = true;

        public Options setModelOptionLoader(Class<? extends AoeProcessor.ModelOptionLoaderComponent> cls) {
            this.modelOptionLoaderClassName = cls.getName();
            return this;
        }

        public Options setInterpreter(Class<? extends AoeProcessor.InterpreterComponent> cls) {
            this.interpreterClassName = cls.getName();
            return this;
        }

        public Options setParceler(Class<? extends AoeProcessor.ParcelComponent> cls) {
            this.parcelerClassName = cls.getName();
            return this;
        }

        public Options useRemoteService(boolean z) {
            this.useRemoteService = z;
            return this;
        }

        public Options setThreadNum(int i) {
            this.threadNum = i;
            return this;
        }
    }
}
