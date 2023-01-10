package com.didi.sdk.p147ad;

import com.didi.sdk.p147ad.model.AdConfigItem;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo148868d2 = {"Lcom/didi/sdk/ad/IAdObserver;", "", "observe", "", "adConfigItem", "Lcom/didi/sdk/ad/model/AdConfigItem;", "type", "", "TheOneSDKGlobal_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.sdk.ad.IAdObserver */
/* compiled from: IAdObserver.kt */
public interface IAdObserver {
    void observe(AdConfigItem adConfigItem);

    String type();
}
