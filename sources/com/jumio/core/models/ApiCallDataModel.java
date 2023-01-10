package com.jumio.core.models;

import androidx.core.app.NotificationCompat;
import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b&\u0010'R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR5\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f` 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, mo148868d2 = {"Lcom/jumio/core/models/ApiCallDataModel;", "T", "Lcom/jumio/core/model/StaticModel;", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "getCall", "()Ljava/lang/Class;", "call", "", "b", "Z", "getFireAndForget", "()Z", "setFireAndForget", "(Z)V", "fireAndForget", "c", "getIgnoreErrors", "setIgnoreErrors", "ignoreErrors", "", "d", "I", "getTimeout", "()I", "setTimeout", "(I)V", "timeout", "Ljava/util/HashMap;", "", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "getData", "()Ljava/util/HashMap;", "data", "<init>", "(Ljava/lang/Class;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
@PersistWith("ApiCallDataModel")
/* compiled from: ApiCallDataModel.kt */
public final class ApiCallDataModel<T> implements StaticModel {

    /* renamed from: a */
    public final Class<T> f57644a;

    /* renamed from: b */
    public boolean f57645b;

    /* renamed from: c */
    public boolean f57646c;

    /* renamed from: d */
    public int f57647d;

    /* renamed from: e */
    public final HashMap<String, Serializable> f57648e = new HashMap<>();

    public ApiCallDataModel(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, NotificationCompat.CATEGORY_CALL);
        this.f57644a = cls;
    }

    public final Class<T> getCall() {
        return this.f57644a;
    }

    public final HashMap<String, Serializable> getData() {
        return this.f57648e;
    }

    public final boolean getFireAndForget() {
        return this.f57645b;
    }

    public final boolean getIgnoreErrors() {
        return this.f57646c;
    }

    public final int getTimeout() {
        return this.f57647d;
    }

    public final void setFireAndForget(boolean z) {
        this.f57645b = z;
    }

    public final void setIgnoreErrors(boolean z) {
        this.f57646c = z;
    }

    public final void setTimeout(int i) {
        this.f57647d = i;
    }
}
