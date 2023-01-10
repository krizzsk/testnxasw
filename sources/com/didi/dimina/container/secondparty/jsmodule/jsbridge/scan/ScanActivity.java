package com.didi.dimina.container.secondparty.jsmodule.jsbridge.scan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.dqr.ResultPoint;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.taxis99.R;
import java.util.List;

public class ScanActivity extends Activity {
    public static ScanResultListener scanListener;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f19153a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CaptureManager f19154b;

    /* renamed from: c */
    private DecoratedBarcodeView f19155c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewfinderView f19156d;

    /* renamed from: e */
    private View f19157e;

    /* renamed from: f */
    private View f19158f;

    /* renamed from: g */
    private ImageView f19159g;

    /* renamed from: h */
    private ImageView f19160h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f19161i;

    public interface ScanResultListener {
        void onCancel();

        void onSuccess(String str);
    }

    public static void start(Activity activity, ScanResultListener scanResultListener) {
        scanListener = scanResultListener;
        Intent intent = new Intent();
        intent.setClass(activity, ScanActivity.class);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.dimina_scan_activity);
        m16266a();
        m16274b();
    }

    /* renamed from: a */
    private void m16266a() {
        this.f19160h = (ImageView) findViewById(R.id.iv_back);
        this.f19155c = (DecoratedBarcodeView) findViewById(R.id.bv_scanner_container);
        this.f19157e = findViewById(R.id.zxing_rl_surface_loading);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.f19156d = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        this.f19158f = findViewById(R.id.torch_view);
        this.f19159g = (ImageView) findViewById(R.id.torch_button);
        this.f19160h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanActivity.this.m16275b(view);
            }
        });
        this.f19158f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanActivity.this.m16268a(view);
            }
        });
        this.f19155c.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                ScanActivity.this.m16267a((int) R.drawable.dimina_open_torch_on);
                boolean unused = ScanActivity.this.f19161i = true;
            }

            public void onTorchOff() {
                ScanActivity.this.m16267a((int) R.drawable.dimina_open_torch_off);
                boolean unused = ScanActivity.this.f19161i = false;
            }
        });
        this.f19155c.getBarcodeView().setDecodeFormats("QR_CODE,CODE_128,EAN_13,EAN_8,ITF");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m16275b(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m16268a(View view) {
        if (this.f19161i) {
            this.f19155c.setTorchOff();
        } else {
            this.f19155c.setTorchOn();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16267a(int i) {
        this.f19159g.setBackgroundResource(i);
    }

    /* renamed from: b */
    private void m16274b() {
        CaptureManager captureManager = new CaptureManager(this, this.f19155c);
        this.f19154b = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                ScanActivity.this.f19154b.onPauseWhioutWait();
                ScanActivity.this.m16271a(barcodeResult);
            }
        });
        this.f19154b.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                ScanActivity.this.hideScannerLoading();
                ScanActivity.this.f19156d.setAnimeFlag(true);
            }

            public void previewStopped() {
                ScanActivity.this.f19156d.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                ScanActivity.this.f19153a.postDelayed(new Runnable() {
                    public void run() {
                        ScanActivity.this.f19154b.onResume();
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        this.f19154b.onResume();
    }

    public void hideScannerLoading() {
        View view = this.f19157e;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f19157e.getParent()).removeView(this.f19157e);
            this.f19157e = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16271a(BarcodeResult barcodeResult) {
        String text = barcodeResult.getText();
        ScanResultListener scanResultListener = scanListener;
        if (scanResultListener != null) {
            scanResultListener.onSuccess(text);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f19154b.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f19154b.onPauseWhioutWait();
    }

    public void onBackPressed() {
        ScanResultListener scanResultListener = scanListener;
        if (scanResultListener != null) {
            scanResultListener.onCancel();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        scanListener = null;
        this.f19154b.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f19154b.onRequestPermissionsResult(i, strArr, iArr);
    }
}
