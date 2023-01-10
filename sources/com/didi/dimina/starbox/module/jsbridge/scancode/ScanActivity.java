package com.didi.dimina.starbox.module.jsbridge.scancode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
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
    public final Handler f19971a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CaptureManager f19972b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DecoratedBarcodeView f19973c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewfinderView f19974d;

    /* renamed from: e */
    private View f19975e;

    /* renamed from: f */
    private Button f19976f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f19977g;

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
        setContentView(R.layout.dimina_starbox_activity_scan);
        m16944a();
        m16952b();
    }

    /* renamed from: a */
    private void m16944a() {
        this.f19973c = (DecoratedBarcodeView) findViewById(R.id.bv_scanner_container);
        this.f19975e = findViewById(R.id.zxing_rl_surface_loading);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.f19974d = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        this.f19976f = (Button) findViewById(R.id.torch_button);
        TextView textView = (TextView) findViewById(R.id.title_bar);
        textView.setText(R.string.dm_kit_scan_title);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ScanActivity.this.onBackPressed();
            }
        });
        this.f19976f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ScanActivity.this.f19977g) {
                    ScanActivity.this.f19973c.setTorchOff();
                } else {
                    ScanActivity.this.f19973c.setTorchOn();
                }
            }
        });
        this.f19973c.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                ScanActivity.this.m16945a((int) R.drawable.dimina_starbox_open_ride_torch_on);
                boolean unused = ScanActivity.this.f19977g = true;
            }

            public void onTorchOff() {
                ScanActivity.this.m16945a((int) R.drawable.dimina_starbox_open_ride_torch_off);
                boolean unused = ScanActivity.this.f19977g = false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16945a(int i) {
        this.f19976f.setBackgroundResource(i);
    }

    /* renamed from: b */
    private void m16952b() {
        CaptureManager captureManager = new CaptureManager(this, this.f19973c);
        this.f19972b = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                ScanActivity.this.f19972b.onPauseWhioutWait();
                ScanActivity.this.m16948a(barcodeResult);
            }
        });
        this.f19972b.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                ScanActivity.this.hideScannerLoading();
                ScanActivity.this.f19974d.setAnimeFlag(true);
            }

            public void previewStopped() {
                ScanActivity.this.f19974d.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                ScanActivity.this.f19971a.postDelayed(new Runnable() {
                    public void run() {
                        ScanActivity.this.f19972b.onResume();
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        this.f19972b.onResume();
    }

    public void hideScannerLoading() {
        View view = this.f19975e;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f19975e.getParent()).removeView(this.f19975e);
            this.f19975e = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16948a(BarcodeResult barcodeResult) {
        ScanResultListener scanResultListener = scanListener;
        if (scanResultListener != null) {
            scanResultListener.onSuccess(barcodeResult.getText());
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f19972b.onPauseWhioutWait();
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
        this.f19972b.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f19972b.onRequestPermissionsResult(i, strArr, iArr);
    }
}
