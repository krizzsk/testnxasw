package com.didiglobal.scan.view.fragment;

import com.didi.zxing.barcodescanner.CaptureManager;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
final class QrCodeScanFragment$initCapture$2$cameraError$1 implements Runnable {
    final /* synthetic */ QrCodeScanFragment$initCapture$2 this$0;

    QrCodeScanFragment$initCapture$2$cameraError$1(QrCodeScanFragment$initCapture$2 qrCodeScanFragment$initCapture$2) {
        this.this$0 = qrCodeScanFragment$initCapture$2;
    }

    public final void run() {
        CaptureManager access$getCaptureManager$p = this.this$0.this$0.f53929h;
        if (access$getCaptureManager$p != null) {
            access$getCaptureManager$p.onResume();
        }
    }
}
