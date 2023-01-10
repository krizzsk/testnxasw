package com.didi.zxing.scan;

import android.app.AlertDialog;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.IntentUtil;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.dqr.ResultPoint;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.security.wireless.ISecurityConf;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.didi.zxing.scan.callback.IQrCodeOperation;
import com.didi.zxing.scan.util.ActivityCompatUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;
import java.util.UUID;

public abstract class BaseQrCodeScanActivity extends TheOneBaseActivity implements IQrCodeOperation.IBarcodeCallback, IQrCodeOperation.IScannerLoadingView, IQrCodeOperation.ITorchStateChangedListener {
    public static final int REQUEST_CODE_CAMERA_PERMISSION = 1008;

    /* renamed from: e */
    private static final float f48153e = 40.0f;

    /* renamed from: a */
    private Logger f48154a = LoggerFactory.getLogger("BaseQrCodeScanActivity");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f48155b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DecoratedBarcodeView f48156c;

    /* renamed from: d */
    private Sensor f48157d;

    /* renamed from: f */
    private AlertDialog f48158f;

    /* renamed from: g */
    private AlertDialogFragment f48159g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f48160h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f48161i;

    /* renamed from: j */
    private SensorManager f48162j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f48163k;

    /* renamed from: l */
    private SensorEventListener f48164l = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.values[0] <= 40.0f && !BaseQrCodeScanActivity.this.f48160h && !BaseQrCodeScanActivity.this.f48161i) {
                BaseQrCodeScanActivity.this.f48156c.setTorchOn();
                boolean unused = BaseQrCodeScanActivity.this.f48160h = true;
            }
        }
    };
    protected CaptureManager mCaptureManager;
    protected View mLoadingView;
    protected ViewfinderView mViewFinderView;

    /* access modifiers changed from: protected */
    public abstract int getCustomLayoutResId();

    /* access modifiers changed from: protected */
    public int getRootLayoutResId() {
        return R.layout.a_qr_code_scan;
    }

    public int getScannerLoadingResId() {
        return R.layout.zxing_qr_code_loading;
    }

    /* access modifiers changed from: protected */
    public abstract void initCustomView();

    /* access modifiers changed from: protected */
    public boolean isAutoLight() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        AnalysisManager.setSessionId(UUID.randomUUID().toString());
        setContentView(getRootLayoutResId());
        m36116b();
        m36119c();
    }

    /* renamed from: a */
    private void m36114a() {
        if (PermissionUtil.checkPermissionAllGranted(getApplicationContext(), new String[]{Permission.CAMERA})) {
            this.f48163k = true;
            CaptureManager captureManager = this.mCaptureManager;
            if (captureManager != null) {
                captureManager.onResume();
                return;
            }
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{Permission.CAMERA}, 1008);
    }

    /* renamed from: b */
    private void m36116b() {
        LayoutInflater layoutInflater = getLayoutInflater();
        if (getCustomLayoutResId() != 0) {
            layoutInflater.inflate(getCustomLayoutResId(), (ViewGroup) findViewById(R.id.qr_code_custom_view));
        }
        layoutInflater.inflate(getScannerLoadingResId(), (ViewGroup) findViewById(R.id.zxing_barcode_loading));
        DecoratedBarcodeView decoratedBarcodeView = (DecoratedBarcodeView) findViewById(R.id.bv_scanner_container);
        this.f48156c = decoratedBarcodeView;
        decoratedBarcodeView.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                boolean unused = BaseQrCodeScanActivity.this.f48160h = true;
                BaseQrCodeScanActivity.this.onTorchStateChanged(true);
            }

            public void onTorchOff() {
                boolean unused = BaseQrCodeScanActivity.this.f48160h = false;
                BaseQrCodeScanActivity.this.onTorchStateChanged(false);
            }
        });
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.mViewFinderView = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        initScannerLoading();
        initCustomView();
    }

    /* renamed from: c */
    private void m36119c() {
        CaptureManager captureManager = new CaptureManager(this, this.f48156c);
        this.mCaptureManager = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                if (BaseQrCodeScanActivity.this.mCaptureManager != null) {
                    BaseQrCodeScanActivity.this.mCaptureManager.onPauseWhioutWait();
                }
                BaseQrCodeScanActivity.this.onBarCodeResult(barcodeResult);
            }
        });
        this.mCaptureManager.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                BaseQrCodeScanActivity.this.hideScannerLoading();
                BaseQrCodeScanActivity.this.mViewFinderView.setAnimeFlag(true);
            }

            public void previewStopped() {
                BaseQrCodeScanActivity.this.mViewFinderView.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                BaseQrCodeScanActivity.this.f48155b.postDelayed(new Runnable() {
                    public void run() {
                        if (BaseQrCodeScanActivity.this.mCaptureManager != null) {
                            BaseQrCodeScanActivity.this.mCaptureManager.onResume();
                        }
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        m36122d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[SYNTHETIC, Splitter:B:10:0x0011] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCameraCanUse() {
        /*
            android.hardware.Camera r0 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x000d }
            android.hardware.Camera$Parameters r1 = r0.getParameters()     // Catch:{ Exception -> 0x000e }
            r0.setParameters(r1)     // Catch:{ Exception -> 0x000e }
            r1 = 1
            goto L_0x000f
        L_0x000d:
            r0 = 0
        L_0x000e:
            r1 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0019
            r0.release()     // Catch:{ Exception -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.zxing.scan.BaseQrCodeScanActivity.isCameraCanUse():boolean");
    }

    /* renamed from: d */
    private void m36122d() {
        if (isAutoLight()) {
            SensorManager sensorManager = (SensorManager) getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR);
            this.f48162j = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f48157d = defaultSensor;
            if (defaultSensor != null) {
                this.f48162j.registerListener(this.f48164l, defaultSensor, 3);
            }
        }
    }

    /* renamed from: e */
    private void m36123e() {
        if (this.f48157d != null) {
            if (this.f48162j == null) {
                this.f48162j = (SensorManager) getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR);
            }
            this.f48162j.unregisterListener(this.f48164l);
            this.f48157d = null;
            this.f48161i = false;
        }
    }

    public void initScannerLoading() {
        this.mLoadingView = findViewById(R.id.zxing_rl_surface_loading);
    }

    public void hideScannerLoading() {
        this.f48155b.postDelayed(new Runnable() {
            public void run() {
                if (BaseQrCodeScanActivity.this.mLoadingView != null && BaseQrCodeScanActivity.this.mLoadingView.getParent() != null) {
                    ((ViewGroup) BaseQrCodeScanActivity.this.mLoadingView.getParent()).removeView(BaseQrCodeScanActivity.this.mLoadingView);
                    BaseQrCodeScanActivity.this.mLoadingView = null;
                }
            }
        }, 100);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        CaptureManager captureManager;
        super.onResume();
        if (this.f48163k && (captureManager = this.mCaptureManager) != null) {
            captureManager.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mCaptureManager.onPauseWhioutWait();
        dissPermissionDialog();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m36124f();
    }

    /* renamed from: f */
    private void m36124f() {
        CaptureManager captureManager = this.mCaptureManager;
        if (captureManager != null) {
            captureManager.onPauseWhioutWait();
            this.mCaptureManager.onDestroy();
            this.mCaptureManager = null;
        }
        if (this.f48160h) {
            this.f48156c.setTorchOff();
        }
        m36123e();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, final int[] iArr) {
        this.f48154a.info("BaseQrCodeScanActivity#onRequestPermissionsResult", new Object[0]);
        if (!ActivityCompatUtils.isDestroyed(this) && i == 1008 && iArr.length > 0) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    if (iArr[0] == 0) {
                        boolean unused = BaseQrCodeScanActivity.this.f48163k = true;
                        if (BaseQrCodeScanActivity.this.mCaptureManager != null) {
                            BaseQrCodeScanActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (!BaseQrCodeScanActivity.this.isFinishing() && BaseQrCodeScanActivity.this.mCaptureManager != null) {
                                        BaseQrCodeScanActivity.this.mCaptureManager.onResume();
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void showPermissionDialog(String[] strArr) {
        this.f48158f = IntentUtil.showPermissionDialog(this, strArr[0], new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BaseQrCodeScanActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void dissPermissionDialog() {
        AlertDialog alertDialog = this.f48158f;
        if (alertDialog != null && alertDialog.isShowing()) {
            try {
                this.f48158f.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m36114a();
    }

    public void finish() {
        super.finish();
        this.f48155b.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: protected */
    public void notifyTorchStateChanged() {
        if (this.f48160h) {
            this.f48161i = true;
            this.f48156c.setTorchOff();
            this.f48160h = false;
            return;
        }
        this.f48156c.setTorchOn();
        this.f48160h = true;
    }
}
