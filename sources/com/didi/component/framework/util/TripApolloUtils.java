package com.didi.component.framework.util;

import com.didi.component.business.util.GlobalApolloUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo148868d2 = {"Lcom/didi/component/framework/util/TripApolloUtils;", "", "()V", "isFirstGetMapPaddingTop", "", "mapPaddingTop", "", "getTripMapPaddingTop", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TripApolloUtils.kt */
public final class TripApolloUtils {
    public static final TripApolloUtils INSTANCE = new TripApolloUtils();

    /* renamed from: a */
    private static boolean f15844a = true;

    /* renamed from: b */
    private static int f15845b = 60;

    private TripApolloUtils() {
    }

    public final int getTripMapPaddingTop() {
        if (f15844a) {
            Object param = GlobalApolloUtil.getParam("APP_Revision_Trip_Map_Padding_Top", "paddingTop", Integer.valueOf(f15845b));
            Intrinsics.checkNotNullExpressionValue(param, "getParam(\n              …dingTop\n                )");
            f15845b = ((Number) param).intValue();
            f15844a = false;
        }
        return f15845b;
    }
}
