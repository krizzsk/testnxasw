package com.didiglobal.scan.view.fragment;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
final class QrCodeScanFragment$initListener$4 implements View.OnClickListener {
    final /* synthetic */ QrCodeScanFragment this$0;

    QrCodeScanFragment$initListener$4(QrCodeScanFragment qrCodeScanFragment) {
        this.this$0 = qrCodeScanFragment;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.this$0.m40215a(new Function0<Unit>(this) {
            final /* synthetic */ QrCodeScanFragment$initListener$4 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.this$0.m40216b();
            }
        }, C179972.INSTANCE);
    }
}
