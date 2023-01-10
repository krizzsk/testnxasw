package com.didi.global.qrscan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.global.qrscan.inter.QRCodeProcess;
import com.didi.global.qrscan.inter.QRScanDelegate;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;

public class QRScanFragment extends Fragment implements QRScanDelegate {

    /* renamed from: a */
    QRCodeProcess f24845a;

    /* renamed from: b */
    private String f24846b;

    /* renamed from: c */
    private C9390a f24847c;

    public void finish() {
        try {
            m19923d();
        } catch (IllegalStateException e) {
            Log.d("QRScanFragment", XPanelScene.SCENE_FINISH, e);
        }
    }

    public Fragment getFragment() {
        return this;
    }

    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public void setProductId(String str) {
        this.f24846b = str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.f24846b) && (getContext() instanceof BaseGlobalScanActivity)) {
            this.f24846b = ((BaseGlobalScanActivity) getContext()).getProductId();
        }
        ServiceLoader<S> load = ServiceLoader.load(QRCodeProcess.class, this.f24846b);
        if (load != null) {
            this.f24845a = (QRCodeProcess) load.get();
        }
        QRCodeProcess qRCodeProcess = this.f24845a;
        if (qRCodeProcess != null) {
            qRCodeProcess.onEnter(this);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_qr_fragment_new, viewGroup, false);
        mo72676b();
        return inflate;
    }

    /* renamed from: d */
    private void m19923d() {
        getFragmentManager().popBackStack();
        QRCodeProcess qRCodeProcess = this.f24845a;
        if (qRCodeProcess != null) {
            qRCodeProcess.onLeave();
        }
    }

    public void onRestart() {
        C9390a aVar = this.f24847c;
        if (aVar != null) {
            aVar.mo72660a();
        }
    }

    public void stopScan() {
        C9390a aVar = this.f24847c;
        if (aVar != null && (aVar instanceof QRCodeScannerFragment)) {
            aVar.mo72673b();
        }
    }

    public View getTitleBar() {
        C9390a aVar = this.f24847c;
        if (aVar != null) {
            return aVar.getTitleBar();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72675a() {
        getActivity().onBackPressed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72676b() {
        if (!(this.f24847c instanceof QRCodeScannerFragment)) {
            QRCodeProcess qRCodeProcess = this.f24845a;
            if (qRCodeProcess != null) {
                qRCodeProcess.onScanStart();
            }
            QRCodeScannerFragment qRCodeScannerFragment = new QRCodeScannerFragment();
            this.f24847c = qRCodeScannerFragment;
            qRCodeScannerFragment.setProcess(this.f24845a);
            this.f24847c.setParent(this);
            getChildFragmentManager().beginTransaction().replace(R.id.global_scan_container, this.f24847c).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo72677c() {
        if (!(this.f24847c instanceof QRCodeInputFragment)) {
            StatusBarLightingCompat.setStatusBarBgLightning(getActivity(), true, 0);
            QRCodeInputFragment qRCodeInputFragment = new QRCodeInputFragment();
            this.f24847c = qRCodeInputFragment;
            qRCodeInputFragment.setProcess(this.f24845a);
            this.f24847c.setParent(this);
            getChildFragmentManager().beginTransaction().replace(R.id.global_scan_container, this.f24847c).commitAllowingStateLoss();
        }
    }

    public boolean onBackPressed() {
        C9390a aVar = this.f24847c;
        if (aVar == null || !(aVar instanceof QRCodeInputFragment)) {
            return false;
        }
        mo72676b();
        QRCodeProcess qRCodeProcess = this.f24845a;
        if (qRCodeProcess == null) {
            return true;
        }
        qRCodeProcess.onLeaveInputCode();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        QRCodeProcess qRCodeProcess = this.f24845a;
        if (qRCodeProcess != null) {
            qRCodeProcess.onActivityResult(i, i2, intent);
        }
    }

    public void goInputCode() {
        mo72677c();
    }
}
