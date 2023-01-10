package com.didiglobal.scan.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didiglobal.scan.net.ScanNetRequest;
import com.didiglobal.scan.util.ScanSchemeDispatcher;
import com.didiglobal.scan.view.ScanErrorDialogFragment;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: ScanErrorDialogFragment.kt */
final class ScanErrorDialogFragment$initListener$2 implements View.OnClickListener {
    final /* synthetic */ ScanErrorDialogFragment this$0;

    ScanErrorDialogFragment$initListener$2(ScanErrorDialogFragment scanErrorDialogFragment) {
        this.this$0 = scanErrorDialogFragment;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!TextUtil.isEmpty(this.this$0.f53910f) && !TextUtil.isEmpty(this.this$0.f53911g)) {
            ScanSchemeDispatcher scanSchemeDispatcher = ScanSchemeDispatcher.INSTANCE;
            String access$getActionScheme$p = this.this$0.f53911g;
            if (access$getActionScheme$p == null) {
                Intrinsics.throwNpe();
            }
            ScanNetRequest scanNetRequest = ScanNetRequest.INSTANCE;
            String access$getActionType$p = this.this$0.f53910f;
            if (access$getActionType$p == null) {
                Intrinsics.throwNpe();
            }
            scanSchemeDispatcher.dispatcher(access$getActionScheme$p, scanNetRequest.transActionType(access$getActionType$p), (JsonObject) null);
        }
        ScanErrorDialogFragment.ClickCallBack access$getClickCallBack$p = this.this$0.f53908d;
        if (access$getClickCallBack$p != null) {
            access$getClickCallBack$p.onClick();
        }
        this.this$0.dismiss();
    }
}
