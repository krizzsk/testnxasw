package com.didiglobal.scan.view.fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.util.TextUtil;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didiglobal.scan.view.ScanErrorDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
final class QrCodeScanFragment$showError$1 implements Runnable {
    final /* synthetic */ String $actionType;
    final /* synthetic */ String $buttonTitle;
    final /* synthetic */ String $error;
    final /* synthetic */ String $scheme;
    final /* synthetic */ String $title;
    final /* synthetic */ QrCodeScanFragment this$0;

    QrCodeScanFragment$showError$1(QrCodeScanFragment qrCodeScanFragment, String str, String str2, String str3, String str4, String str5) {
        this.this$0 = qrCodeScanFragment;
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
                companion.show(str, str2, str3, str4, str5, childFragmentManager, new ScanErrorDialogFragment.ClickCallBack(this) {
                    final /* synthetic */ QrCodeScanFragment$showError$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public void onClick() {
                        if (TextUtil.isEmpty(this.this$0.$actionType) || TextUtil.isEmpty(this.this$0.$scheme)) {
                            this.this$0.this$0.f53932k = false;
                            CaptureManager access$getCaptureManager$p = this.this$0.this$0.f53929h;
                            if (access$getCaptureManager$p != null) {
                                access$getCaptureManager$p.onResume();
                            }
                        }
                    }
                }, new ScanErrorDialogFragment.ShowCallBack(this) {
                    final /* synthetic */ QrCodeScanFragment$showError$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public void show(boolean z) {
                        this.this$0.this$0.f53933l = z;
                    }
                });
            }
        }
    }
}
