package com.didi.dimina.container.secondparty.trace.inner.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, mo148868d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/net/LogResponseType;", "", "Companion", "2party-impl_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: LogResponse.kt */
public @interface LogResponseType {
    public static final String CONNECT = "connect";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String RECEIVE = "receive";

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/net/LogResponseType$Companion;", "", "()V", "CONNECT", "", "RECEIVE", "2party-impl_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: LogResponse.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CONNECT = "connect";
        public static final String RECEIVE = "receive";

        private Companion() {
        }
    }
}
