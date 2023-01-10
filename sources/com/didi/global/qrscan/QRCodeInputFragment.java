package com.didi.global.qrscan;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.qrscan.inter.QRCodeProcess;
import com.didi.global.widget.QRCodeInputLayout;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class QRCodeInputFragment extends C9390a implements QRCodeInputLayout.OnStateChangedListener {

    /* renamed from: b */
    private CommonTitleBar f24823b;

    /* renamed from: c */
    private TextView f24824c;

    /* renamed from: d */
    private RelativeLayout f24825d;

    /* renamed from: e */
    private QRCodeInputLayout f24826e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public QRScanFragment f24827f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OpenLightManager f24828g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextureView f24829h;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72661a(boolean z) {
    }

    public /* bridge */ /* synthetic */ void setProcess(QRCodeProcess qRCodeProcess) {
        super.setProcess(qRCodeProcess);
    }

    public void setParent(QRScanFragment qRScanFragment) {
        this.f24827f = qRScanFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f24848a != null) {
            if (this.f24848a.autoTorchEnabled()) {
                this.f24828g = new OpenLightManager();
            }
            this.f24848a.onEnterInputCode();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.global_qr_code_input_fragment_new, viewGroup, false);
        this.f24825d = relativeLayout;
        m19900a((ViewGroup) relativeLayout);
        TextureView textureView = new TextureView(getContext());
        this.f24829h = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QRCodeInputFragment.this.f24828g != null) {
                    QRCodeInputFragment.this.f24828g.start(QRCodeInputFragment.this.getContext(), QRCodeInputFragment.this.f24829h);
                }
            }
        });
        ((FrameLayout) this.f24825d.findViewById(R.id.frame)).addView(this.f24829h);
        return this.f24825d;
    }

    /* renamed from: a */
    private void m19900a(ViewGroup viewGroup) {
        m19902b(viewGroup);
        QRCodeInputLayout qRCodeInputLayout = (QRCodeInputLayout) viewGroup.findViewById(R.id.oc_pin_input_layout);
        this.f24826e = qRCodeInputLayout;
        qRCodeInputLayout.setOnStateChangedListener(this);
        TextView textView = (TextView) this.f24825d.findViewById(R.id.oc_tips_content);
        if (this.f24848a != null) {
            textView.setText(this.f24848a.getPinCodeTipText());
            this.f24826e.initView(this.f24848a.getPinCodeInputCount());
        }
    }

    /* renamed from: b */
    private void m19902b(ViewGroup viewGroup) {
        CommonTitleBar commonTitleBar = (CommonTitleBar) viewGroup.findViewById(R.id.oc_title_bar);
        this.f24823b = commonTitleBar;
        commonTitleBar.setTitleBarLineVisible(8);
        this.f24823b.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                QRCodeInputFragment.this.f24827f.mo72676b();
                if (QRCodeInputFragment.this.f24848a != null) {
                    QRCodeInputFragment.this.f24848a.onLeaveInputCode();
                }
            }
        });
        TextView textView = (TextView) this.f24825d.findViewById(R.id.oc_tips_title);
        this.f24824c = textView;
        textView.setText(Html.fromHtml(getString(R.string.global_openride_pin_input_title)));
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f24825d = null;
        this.f24823b = null;
    }

    public void setTitle(String str) {
        this.f24823b.setTitle(str);
    }

    public void clear() {
        this.f24826e.clearPin();
    }

    public View getTitleBar() {
        return this.f24823b;
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        hideSoftKeyboard();
        OpenLightManager openLightManager = this.f24828g;
        if (openLightManager != null) {
            openLightManager.stop();
        }
    }

    public void hideSoftKeyboard() {
        this.f24826e.hideSoftKeyboard();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72660a() {
        QRCodeInputLayout qRCodeInputLayout = this.f24826e;
        if (qRCodeInputLayout != null) {
            qRCodeInputLayout.clearPin();
        }
    }

    public void onStateChanged(QRCodeInputLayout.State state) {
        if (state.equals(QRCodeInputLayout.State.COMPLETE)) {
            hideSoftKeyboard();
            if (this.f24848a != null) {
                this.f24848a.onInputCode(this.f24826e.getPin());
            }
        }
    }
}
