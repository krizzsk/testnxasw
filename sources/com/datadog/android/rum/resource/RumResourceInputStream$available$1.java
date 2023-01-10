package com.datadog.android.rum.resource;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo148868d2 = {"<anonymous>", "", "Ljava/io/InputStream;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: RumResourceInputStream.kt */
final class RumResourceInputStream$available$1 extends Lambda implements Function1<InputStream, Integer> {
    public static final RumResourceInputStream$available$1 INSTANCE = new RumResourceInputStream$available$1();

    RumResourceInputStream$available$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(invoke((InputStream) obj));
    }

    public final int invoke(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "$this$callWithErrorTracking");
        return inputStream.available();
    }
}
