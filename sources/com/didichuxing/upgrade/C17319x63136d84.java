package com.didichuxing.upgrade;

import com.didichuxing.bean.UpdateResponse;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo148868d2 = {"<anonymous>", "", "run", "com/didichuxing/upgrade/UpgradeSDK$syncUpdates$1$onRequestSuccess$2$1"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* renamed from: com.didichuxing.upgrade.UpgradeSDK$syncUpdates$1$onRequestSuccess$$inlined$apply$lambda$1 */
/* compiled from: UpgradeSDK.kt */
final class C17319x63136d84 implements Runnable {
    final /* synthetic */ UpdateResponse $response$inlined;
    final /* synthetic */ UpgradeSDK$syncUpdates$1 this$0;

    C17319x63136d84(UpgradeSDK$syncUpdates$1 upgradeSDK$syncUpdates$1, UpdateResponse updateResponse) {
        this.this$0 = upgradeSDK$syncUpdates$1;
        this.$response$inlined = updateResponse;
    }

    public final void run() {
        this.this$0.this$0.m38960a(this.$response$inlined);
    }
}
