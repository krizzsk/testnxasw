package com.didiglobal.enginecore.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0010\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, mo148868d2 = {"Lcom/didiglobal/enginecore/cache/FaultHidingSink;", "Lokio/ForwardingSink;", "delegate", "Lokio/Sink;", "onException", "Lkotlin/Function1;", "Ljava/io/IOException;", "", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "hasErrors", "", "getOnException", "()Lkotlin/jvm/functions/Function1;", "close", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "engine-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: FaultHidingSink.kt */
public class FaultHidingSink extends ForwardingSink {

    /* renamed from: a */
    private boolean f39551a;

    /* renamed from: b */
    private final Function1<IOException, Unit> f39552b;

    public final Function1<IOException, Unit> getOnException() {
        return this.f39552b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(Sink sink, Function1<? super IOException, Unit> function1) {
        super(sink);
        Intrinsics.checkParameterIsNotNull(sink, "delegate");
        Intrinsics.checkParameterIsNotNull(function1, "onException");
        this.f39552b = function1;
    }

    public void write(Buffer buffer, long j) {
        Intrinsics.checkParameterIsNotNull(buffer, "source");
        if (this.f39551a) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e) {
            this.f39551a = true;
            this.f39552b.invoke(e);
        }
    }

    public void flush() {
        if (!this.f39551a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f39551a = true;
                this.f39552b.invoke(e);
            }
        }
    }

    public void close() {
        if (!this.f39551a) {
            try {
                super.close();
            } catch (IOException e) {
                this.f39551a = true;
                this.f39552b.invoke(e);
            }
        }
    }
}
