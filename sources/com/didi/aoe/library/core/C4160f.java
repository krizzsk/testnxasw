package com.didi.aoe.library.core;

import com.didi.aoe.library.api.AoeProcessor;

/* renamed from: com.didi.aoe.library.core.f */
/* compiled from: ProcessorDelegate */
final class C4160f implements AoeProcessor {

    /* renamed from: a */
    private final AoeProcessor f10031a;

    /* renamed from: b */
    private final C4159e f10032b = new C4159e();

    public C4160f(AoeProcessor aoeProcessor) {
        this.f10031a = aoeProcessor;
    }

    public void setId(String str) {
        this.f10031a.setId(str);
    }

    public AoeProcessor.InterpreterComponent getInterpreterComponent() {
        return this.f10031a.getInterpreterComponent();
    }

    public AoeProcessor.ParcelComponent getParcelComponent() {
        return this.f10031a.getParcelComponent();
    }

    /* renamed from: a */
    public C4159e mo45121a() {
        return this.f10032b;
    }
}
