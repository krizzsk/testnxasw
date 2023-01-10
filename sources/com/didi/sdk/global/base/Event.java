package com.didi.sdk.global.base;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\r\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/sdk/global/base/Event;", "T", "", "content", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "<set-?>", "", "hasBeenHandled", "getHasBeenHandled$annotations", "()V", "getHasBeenHandled", "()Z", "getContentIfNotHandled", "()Ljava/lang/Object;", "peekContent", "payment_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Event.kt */
public class Event<T> {

    /* renamed from: a */
    private final T f38818a;

    /* renamed from: b */
    private boolean f38819b;

    public static /* synthetic */ void getHasBeenHandled$annotations() {
    }

    public Event(T t) {
        this.f38818a = t;
    }

    public final boolean getHasBeenHandled() {
        return this.f38819b;
    }

    public final T getContentIfNotHandled() {
        if (this.f38819b) {
            return null;
        }
        this.f38819b = true;
        return this.f38818a;
    }

    public final T peekContent() {
        return this.f38818a;
    }
}
