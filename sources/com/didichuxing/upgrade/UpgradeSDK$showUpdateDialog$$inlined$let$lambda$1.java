package com.didichuxing.upgrade;

import android.app.Activity;
import com.didichuxing.IAU.IauManager;
import com.didichuxing.bean.UpdateResponse;
import com.didichuxing.util.OmegaUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005¸\u0006\u0000"}, mo148868d2 = {"com/didichuxing/upgrade/UpgradeSDK$showUpdateDialog$2$1", "Lcom/didichuxing/upgrade/IUpdateDialogCallback;", "onNagetiveBtnClick", "", "onPositiveBtnClick", "upgrade_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: UpgradeSDK.kt */
public final class UpgradeSDK$showUpdateDialog$$inlined$let$lambda$1 implements IUpdateDialogCallback {
    final /* synthetic */ Activity $context$inlined;
    final /* synthetic */ UpdateResponse $response$inlined;

    UpgradeSDK$showUpdateDialog$$inlined$let$lambda$1(Activity activity, UpdateResponse updateResponse) {
        this.$context$inlined = activity;
        this.$response$inlined = updateResponse;
    }

    public void onPositiveBtnClick() {
        int i = this.$response$inlined.updateType;
        String str = this.$response$inlined.updateUrl;
        Intrinsics.checkExpressionValueIsNotNull(str, "response.updateUrl");
        IauManager.Companion.getInstance().checkAvailableUpdates(this.$context$inlined, i, str);
        OmegaUtilsKt.OmegaTrack_alert_ck();
    }

    public void onNagetiveBtnClick() {
        OmegaUtilsKt.OmegaTrack_alert_ignoe();
    }
}
