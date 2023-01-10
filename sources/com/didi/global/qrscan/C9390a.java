package com.didi.global.qrscan;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.didi.global.qrscan.inter.QRCodeProcess;

/* renamed from: com.didi.global.qrscan.a */
/* compiled from: BaseQrScanFragment */
abstract class C9390a extends Fragment {

    /* renamed from: a */
    QRCodeProcess f24848a;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo72660a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo72661a(boolean z);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72673b() {
    }

    /* access modifiers changed from: package-private */
    public abstract View getTitleBar();

    /* access modifiers changed from: package-private */
    public abstract void setParent(QRScanFragment qRScanFragment);

    C9390a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f24848a == null && getParentFragment() != null && (getParentFragment() instanceof QRScanFragment)) {
            this.f24848a = ((QRScanFragment) getParentFragment()).f24845a;
        }
    }

    public void setProcess(QRCodeProcess qRCodeProcess) {
        this.f24848a = qRCodeProcess;
    }
}
