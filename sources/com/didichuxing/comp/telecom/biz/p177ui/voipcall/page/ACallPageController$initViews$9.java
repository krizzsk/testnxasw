package com.didichuxing.comp.telecom.biz.p177ui.voipcall.page;

import android.view.View;
import com.didi.raven.config.RavenKey;
import com.didichuxing.comp.telecom.biz.p177ui.view.DebounceClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didichuxing/comp/telecom/biz/ui/voipcall/page/ACallPageController$initViews$9", "Lcom/didichuxing/comp/telecom/biz/ui/view/DebounceClickListener;", "onBtnClick", "", "v", "Landroid/view/View;", "voip-biz_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$9 */
/* compiled from: ACallPageController.kt */
public final class ACallPageController$initViews$9 extends DebounceClickListener {
    final /* synthetic */ ACallPageController this$0;

    ACallPageController$initViews$9(ACallPageController aCallPageController) {
        this.this$0 = aCallPageController;
    }

    public void onBtnClick(View view) {
        Intrinsics.checkParameterIsNotNull(view, RavenKey.VERSION);
        this.this$0.onAnswerClick();
    }
}
