package com.didi.global.qrscan;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.dqr.ResultPoint;
import com.didi.global.qrscan.NetWorkStatusBar;
import com.didi.global.qrscan.inter.QRCodeProcess;
import com.didi.sdk.util.Utils;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.taxis99.R;
import java.util.List;

public class QRCodeScannerFragment extends C9390a implements NetWorkStatusBar.OnViewVisibilityChangeListener {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CaptureManager f24830b;

    /* renamed from: c */
    private RelativeLayout f24831c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DecoratedBarcodeView f24832d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewfinderView f24833e;

    /* renamed from: f */
    private TextView f24834f;

    /* renamed from: g */
    private Button f24835g;

    /* renamed from: h */
    private ImageView f24836h;

    /* renamed from: i */
    private TextView f24837i;

    /* renamed from: j */
    private View f24838j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f24839k = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f24840l;

    /* renamed from: m */
    private View f24841m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public QRScanFragment f24842n;

    /* renamed from: o */
    private NetWorkStatusBar f24843o;

    /* renamed from: p */
    private boolean f24844p;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72661a(boolean z) {
    }

    public /* bridge */ /* synthetic */ void setProcess(QRCodeProcess qRCodeProcess) {
        super.setProcess(qRCodeProcess);
    }

    public void setParent(QRScanFragment qRScanFragment) {
        this.f24842n = qRScanFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarLightingCompat.setStatusBarBgLightning(getActivity(), true, 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f24831c = (RelativeLayout) layoutInflater.inflate(R.layout.global_qrcode_scanner_fragment_new, viewGroup, false);
        m19914c();
        m19918e();
        return this.f24831c;
    }

    /* renamed from: c */
    private void m19914c() {
        this.f24832d = (DecoratedBarcodeView) this.f24831c.findViewById(R.id.bv_scanner_container);
        ViewfinderView viewfinderView = (ViewfinderView) this.f24831c.findViewById(R.id.zxing_viewfinder_view);
        this.f24833e = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        TextView textView = (TextView) this.f24831c.findViewById(R.id.g_pincode_manually_btn);
        this.f24834f = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                QRCodeScannerFragment.this.f24842n.mo72677c();
            }
        });
        Button button = (Button) this.f24831c.findViewById(R.id.g_scan_torch_img);
        this.f24835g = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (QRCodeScannerFragment.this.f24840l) {
                    QRCodeScannerFragment.this.f24832d.setTorchOff();
                } else {
                    QRCodeScannerFragment.this.f24832d.setTorchOn();
                }
            }
        });
        this.f24832d.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                QRCodeScannerFragment.this.m19907a((int) R.drawable.open_ride_torch_on);
                boolean unused = QRCodeScannerFragment.this.f24840l = true;
            }

            public void onTorchOff() {
                QRCodeScannerFragment.this.m19907a((int) R.drawable.open_ride_torch_off);
                boolean unused = QRCodeScannerFragment.this.f24840l = false;
            }
        });
        CameraSettings cameraSettings = this.f24832d.getBarcodeView().getCameraSettings();
        if (this.f24848a != null) {
            cameraSettings.setAutoTorchEnabled(this.f24848a.autoTorchEnabled());
        }
        ImageView imageView = (ImageView) this.f24831c.findViewById(R.id.g_scan_back_img);
        this.f24836h = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                QRCodeScannerFragment.this.f24842n.mo72675a();
            }
        });
        TextView textView2 = (TextView) this.f24831c.findViewById(R.id.g_scan_guide_rule_btn);
        this.f24837i = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (QRCodeScannerFragment.this.f24848a != null && QRCodeScannerFragment.this.f24848a.getGuideClickListener() != null) {
                    QRCodeScannerFragment.this.f24848a.getGuideClickListener().onClick(view);
                }
            }
        });
        this.f24838j = this.f24831c.findViewById(R.id.global_code_scanner_title_bar);
        this.f24841m = this.f24831c.findViewById(R.id.g_view_below_scan);
        TextView textView3 = (TextView) this.f24831c.findViewById(R.id.g_scan_intro_tv);
        if (this.f24848a != null) {
            textView3.setText(this.f24848a.getScanText());
            this.f24837i.setText(this.f24848a.getGuideText());
        }
        NetWorkStatusBar netWorkStatusBar = (NetWorkStatusBar) this.f24831c.findViewById(R.id.networkBar);
        this.f24843o = netWorkStatusBar;
        netWorkStatusBar.setOnViewVisibilityChangeListener(this);
        m19916d();
    }

    /* renamed from: d */
    private void m19916d() {
        int statusBarHeight = UiUtils.getStatusBarHeight(getContext());
        int dip2px = UiUtils.dip2px(getContext(), 44.0f);
        int dip2px2 = UiUtils.dip2px(getContext(), 46.0f);
        int dip2px3 = UiUtils.dip2px(getContext(), 18.0f);
        int dip2px4 = UiUtils.dip2px(getContext(), 16.0f);
        int dip2px5 = UiUtils.dip2px(getContext(), 112.0f);
        int windowHeight = UiUtils.getWindowHeight(getActivity());
        int dip2px6 = UiUtils.dip2px(getContext(), 250.0f);
        int dip2px7 = ((((windowHeight - statusBarHeight) - dip2px) - dip2px2) - dip2px3) - UiUtils.dip2px(getContext(), 80.0f);
        int i = dip2px6 + dip2px4 + dip2px5;
        if (dip2px7 < i) {
            dip2px6 = (dip2px7 - dip2px4) - dip2px5;
            i = dip2px7;
        }
        int dip2px8 = dip2px + UiUtils.dip2px(getContext(), 60.0f) + ((dip2px7 - i) / 2);
        this.f24833e.setViewPosition(dip2px6, dip2px6, dip2px8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, dip2px6 + dip2px8 + UiUtils.dip2px(getContext(), 20.0f), 0, 0);
        layoutParams.addRule(14);
        this.f24841m.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19907a(int i) {
        this.f24835g.setBackgroundResource(i);
    }

    public Context getContext() {
        return super.getContext();
    }

    public void onResume() {
        super.onResume();
        if (!this.f24844p) {
            this.f24830b.onResume();
            if (this.f24848a != null) {
                this.f24848a.onScanStart();
            }
        }
        this.f24843o.refreshOnResume();
    }

    public void onPause() {
        super.onPause();
        this.f24830b.onPauseWhioutWait();
        if (this.f24848a != null) {
            this.f24848a.onScanStop();
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f24830b.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f24830b.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* renamed from: e */
    private void m19918e() {
        CaptureManager captureManager = new CaptureManager(getActivity(), this.f24832d);
        this.f24830b = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                if (QRCodeScannerFragment.this.f24830b != null) {
                    QRCodeScannerFragment.this.m19910a(barcodeResult);
                }
            }
        });
        this.f24830b.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                if (Utils.isNetworkConnected(QRCodeScannerFragment.this.getContext())) {
                    QRCodeScannerFragment.this.f24833e.setAnimeFlag(true);
                }
            }

            public void previewStopped() {
                QRCodeScannerFragment.this.f24833e.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                QRCodeScannerFragment.this.f24839k.postDelayed(new Runnable() {
                    public void run() {
                        QRCodeScannerFragment.this.f24830b.onResume();
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19910a(BarcodeResult barcodeResult) {
        if (barcodeResult != null && !TextUtils.isEmpty(barcodeResult.getText()) && Utils.isNetworkConnected(getContext())) {
            this.f24844p = true;
            this.f24830b.onPauseWhioutWait();
            if (this.f24848a != null) {
                this.f24848a.onScanResult(barcodeResult.getText());
            }
        }
    }

    public View getTitleBar() {
        return this.f24838j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72660a() {
        this.f24844p = false;
        CaptureManager captureManager = this.f24830b;
        if (captureManager != null) {
            captureManager.onResume();
        }
        if (this.f24848a != null) {
            this.f24848a.onScanStart();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72673b() {
        this.f24844p = true;
        this.f24830b.onPauseWhioutWait();
        if (this.f24848a != null) {
            this.f24848a.onScanStop();
        }
    }

    public void onNetWorkStateChanged(View view) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getTitleBar().getLayoutParams();
        if (view.getVisibility() == 0) {
            this.f24833e.setAnimeFlag(false);
            layoutParams.topMargin = (int) getContext().getResources().getDimension(R.dimen.qr_network_error_height);
            this.f24831c.findViewById(R.id.scan_mask).setVisibility(0);
            this.f24831c.findViewById(R.id.title_mask).setVisibility(0);
            if (this.f24848a != null) {
                ((TextView) this.f24831c.findViewById(R.id.no_net_dis)).setText(this.f24848a.getNoNetworkText());
                return;
            }
            return;
        }
        if (!this.f24844p) {
            this.f24833e.setAnimeFlag(true);
        }
        layoutParams.topMargin = (int) getContext().getResources().getDimension(R.dimen.qr_network_normal_marginTop);
        this.f24831c.findViewById(R.id.scan_mask).setVisibility(8);
        this.f24831c.findViewById(R.id.title_mask).setVisibility(8);
    }
}
