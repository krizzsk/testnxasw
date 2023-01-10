package com.didi.payment.kycservice.kyc.fragment;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/fragment/StepBaseInfoFragment$initTermView$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepBaseInfoFragment.kt */
public final class StepBaseInfoFragment$initTermView$clickableSpan$1 extends ClickableSpan {
    final /* synthetic */ StepBaseInfoFragment this$0;

    StepBaseInfoFragment$initTermView$clickableSpan$1(StepBaseInfoFragment stepBaseInfoFragment) {
        this.this$0 = stepBaseInfoFragment;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkNotNullParameter(view, "widget");
        this.this$0.m25396l();
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        textPaint.setColor(ApplicationContextProvider.Companion.getContext().getResources().getColor(R.color.wallet_color_FF6F26));
    }
}
