package com.google.android.play.core.missingsplits;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public class MissingSplitsManagerFactory {

    /* renamed from: a */
    private static final AtomicReference<Boolean> f56135a = new AtomicReference<>((Object) null);

    public static MissingSplitsManager create(Context context) {
        return new C20139b(context, Runtime.getRuntime(), new C20138a(context, context.getPackageManager()), f56135a);
    }
}
