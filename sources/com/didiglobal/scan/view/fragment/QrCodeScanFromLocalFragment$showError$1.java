package com.didiglobal.scan.view.fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didiglobal.scan.view.ScanErrorDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: QrCodeScanFromLocalFragment.kt */
final class QrCodeScanFromLocalFragment$showError$1 implements Runnable {
    final /* synthetic */ String $actionType;
    final /* synthetic */ String $buttonTitle;
    final /* synthetic */ String $error;
    final /* synthetic */ String $scheme;
    final /* synthetic */ String $title;
    final /* synthetic */ QrCodeScanFromLocalFragment this$0;

    QrCodeScanFromLocalFragment$showError$1(QrCodeScanFromLocalFragment qrCodeScanFromLocalFragment, String str, String str2, String str3, String str4, String str5) {
        this.this$0 = qrCodeScanFromLocalFragment;
        this.$error = str;
        this.$title = str2;
        this.$buttonTitle = str3;
        this.$scheme = str4;
        this.$actionType = str5;
    }

    public final void run() {
        if (this.this$0.getActivity() != null) {
            FragmentActivity activity = this.this$0.getActivity();
            if (activity == null || !activity.isDestroyed()) {
                this.this$0.hideLoading();
                ScanErrorDialogFragment.Companion companion = ScanErrorDialogFragment.Companion;
                String str = this.$error;
                String str2 = this.$title;
                String str3 = this.$buttonTitle;
                String str4 = this.$scheme;
                String str5 = this.$actionType;
                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
                ScanErrorDialogFragment.Companion.show$default(companion, str, str2, str3, str4, str5, childFragmentManager, new ScanErrorDialogFragment.ClickCallBack() {
                    public void onClick() {
                    }
                }, (ScanErrorDialogFragment.ShowCallBack) null, 128, (Object) null);
            }
        }
    }
}
