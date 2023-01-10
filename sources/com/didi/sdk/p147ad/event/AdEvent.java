package com.didi.sdk.p147ad.event;

import com.didi.sdk.p147ad.model.AdConfigItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/sdk/ad/event/AdEvent;", "", "()V", "adConfigItem", "Lcom/didi/sdk/ad/model/AdConfigItem;", "getAdConfigItem", "()Lcom/didi/sdk/ad/model/AdConfigItem;", "setAdConfigItem", "(Lcom/didi/sdk/ad/model/AdConfigItem;)V", "ddlType", "", "getDdlType", "()Ljava/lang/String;", "setDdlType", "(Ljava/lang/String;)V", "type", "getType", "setType", "TheOneSDKGlobal_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.sdk.ad.event.AdEvent */
/* compiled from: AdEvent.kt */
public final class AdEvent {

    /* renamed from: a */
    private AdConfigItem f37683a;

    /* renamed from: b */
    private String f37684b = "";

    /* renamed from: c */
    private String f37685c = "";

    public final AdConfigItem getAdConfigItem() {
        return this.f37683a;
    }

    public final void setAdConfigItem(AdConfigItem adConfigItem) {
        this.f37683a = adConfigItem;
    }

    public final String getType() {
        return this.f37684b;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f37684b = str;
    }

    public final String getDdlType() {
        return this.f37685c;
    }

    public final void setDdlType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f37685c = str;
    }
}
