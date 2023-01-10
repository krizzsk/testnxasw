package com.didi.global.fintech.cashier.network;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000bR\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/network/SingletonHolder;", "T", "", "A", "creator", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "instance", "Ljava/lang/Object;", "getInstance", "arg", "(Ljava/lang/Object;)Ljava/lang/Object;", "cashier_network_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SingletonHolder.kt */
public class SingletonHolder<T, A> {
    private Function1<? super A, ? extends T> creator;
    private volatile T instance;

    public SingletonHolder(Function1<? super A, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "creator");
        this.creator = function1;
    }

    public final T getInstance(A a) {
        T t;
        T t2 = this.instance;
        if (t2 != null) {
            return t2;
        }
        synchronized (this) {
            t = this.instance;
            if (t == null) {
                Function1 function1 = this.creator;
                Intrinsics.checkNotNull(function1);
                t = function1.invoke(a);
                this.instance = t;
                this.creator = null;
            }
        }
        return t;
    }
}
