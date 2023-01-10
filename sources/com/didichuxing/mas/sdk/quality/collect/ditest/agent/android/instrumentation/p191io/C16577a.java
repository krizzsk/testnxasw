package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.io.a */
/* compiled from: StreamCompleteListenerManager */
class C16577a {

    /* renamed from: a */
    private boolean f50563a = false;

    /* renamed from: b */
    private ArrayList<StreamCompleteListener> f50564b = new ArrayList<>();

    C16577a() {
    }

    /* renamed from: a */
    public boolean mo124756a() {
        boolean z;
        synchronized (this) {
            z = this.f50563a;
        }
        return z;
    }

    /* renamed from: a */
    public void mo124755a(StreamCompleteListener streamCompleteListener) {
        synchronized (this.f50564b) {
            this.f50564b.add(streamCompleteListener);
        }
    }

    /* renamed from: b */
    public void mo124758b(StreamCompleteListener streamCompleteListener) {
        synchronized (this.f50564b) {
            this.f50564b.remove(streamCompleteListener);
        }
    }

    /* renamed from: a */
    public void mo124754a(StreamCompleteEvent streamCompleteEvent) {
        if (!m37702b()) {
            for (StreamCompleteListener streamComplete : m37703c()) {
                streamComplete.streamComplete(streamCompleteEvent);
            }
        }
    }

    /* renamed from: b */
    public void mo124757b(StreamCompleteEvent streamCompleteEvent) {
        if (!m37702b()) {
            for (StreamCompleteListener streamError : m37703c()) {
                streamError.streamError(streamCompleteEvent);
            }
        }
    }

    /* renamed from: b */
    private boolean m37702b() {
        boolean a;
        synchronized (this) {
            a = mo124756a();
            if (!a) {
                this.f50563a = true;
            }
        }
        return a;
    }

    /* renamed from: c */
    private List<StreamCompleteListener> m37703c() {
        ArrayList arrayList;
        synchronized (this.f50564b) {
            arrayList = new ArrayList(this.f50564b);
            this.f50564b.clear();
        }
        return arrayList;
    }
}
