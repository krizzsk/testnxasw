package com.didi.map.sdk.navtracker;

import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/map/sdk/navtracker/ApolloUtil;", "", "()V", "toggle", "Lcom/didichuxing/apollo/sdk/IToggle;", "getToggle", "()Lcom/didichuxing/apollo/sdk/IToggle;", "toggle$delegate", "Lkotlin/Lazy;", "isNeedUploadByGoogleStatements", "", "navtracker_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* compiled from: ApolloUtil.kt */
public final class ApolloUtil {
    public static final ApolloUtil INSTANCE = new ApolloUtil();

    /* renamed from: a */
    static final /* synthetic */ KProperty[] f31004a = {C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(ApolloUtil.class), "toggle", "getToggle()Lcom/didichuxing/apollo/sdk/IToggle;"))};

    /* renamed from: b */
    private static final Lazy f31005b = LazyKt.lazy(ApolloUtil$toggle$2.INSTANCE);

    /* renamed from: a */
    private final IToggle m23793a() {
        Lazy lazy = f31005b;
        KProperty kProperty = f31004a[0];
        return (IToggle) lazy.getValue();
    }

    private ApolloUtil() {
    }

    public final boolean isNeedUploadByGoogleStatements() {
        if (m23793a() != null) {
            return m23793a().allow();
        }
        return false;
    }
}
