package com.iproov.sdk.core;

/* renamed from: com.iproov.sdk.core.this */
/* compiled from: InternalOptions */
public class C20889this {

    /* renamed from: do */
    public final C20890do f57184do;

    /* renamed from: com.iproov.sdk.core.this$do */
    /* compiled from: InternalOptions */
    public enum C20890do {
        f57185if("native"),
        NATIVE_BRIDGE("native_bridge");
        

        /* renamed from: do */
        public final String f57186do;

        private C20890do(String str) {
            this.f57186do = str;
        }
    }

    public C20889this(C20890do doVar) {
        this.f57184do = doVar;
    }

    public C20889this() {
        this.f57184do = C20890do.f57185if;
    }
}
