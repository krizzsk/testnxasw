package com.adyen.checkout.components.api;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import com.adyen.checkout.core.api.Connection;
import com.adyen.checkout.core.log.Logger;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, mo148868d2 = {"Lcom/adyen/checkout/components/api/LogoConnection;", "Lcom/adyen/checkout/core/api/Connection;", "Landroid/graphics/drawable/BitmapDrawable;", "logoUrl", "", "(Ljava/lang/String;)V", "call", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LogoConnection.kt */
public final class LogoConnection extends Connection<BitmapDrawable> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LogoConnection(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "logoUrl");
    }

    public BitmapDrawable call() throws IOException {
        Logger.m1082v(LogoConnectionKt.f637a, Intrinsics.stringPlus("call - ", Integer.valueOf(getUrl().hashCode())));
        byte[] bArr = get();
        Intrinsics.checkNotNullExpressionValue(bArr, "get()");
        return new BitmapDrawable(Resources.getSystem(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }
}
