package com.didi.zxing.scan;

import android.app.AlertDialog;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.IntentUtil;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.commoninterfacelib.permission.TheOneBaseFragment;
import com.didi.dqr.ResultPoint;
import com.didi.dqrutil.analysis.AnalysisManager;
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
import com.didi.zxing.scan.util.TopPermissionViewHelper;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;
import java.util.UUID;

public abstract class BaseQrCodeScanFragment extends TheOneBaseFragment implements IQrCodeOperation.IBarcodeCallback, IQrCodeOperation.IScannerLoadingView, IQrCodeOperation.ITorchStateChangedListener {
    public static final int REQUEST_CODE_CAMERA_PERMISSION = 1008;

    /* renamed from: e */
    private static final float f48165e = 40.0f;

    /* renamed from: a */
    private Logger f48166a = LoggerFactory.getLogger("BaseQrCodeScanActivity");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f48167b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DecoratedBarcodeView f48168c;

    /* renamed from: d */
    private Sensor f48169d;

    /* renamed from: f */
    private AlertDialog f48170f;

    /* renamed from: g */
    private AlertDialogFragment f48171g = null;

    /* renamed from: h */
    private TopPermissionViewHelper f48172h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f48173i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f48174j;

    /* renamed from: k */
    private SensorManager f48175k;

    /* renamed from: l */
    private boolean f48176l;

    /* renamed from: m */
    private SensorEventListener f48177m = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.values[0] <= 40.0f && !BaseQrCodeScanFragment.this.f48173i && !BaseQrCodeScanFragment.this.f48174j) {
                BaseQrCodeScanFragment.this.f48168c.setTorchOn();
                boolean unused = BaseQrCodeScanFragment.this.f48173i = true;
            }
        }
    };
    protected CaptureManager mCaptureManager;
    protected View mLoadingView;
    protected View mRootView;
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AnalysisManager.setSessionId(UUID.randomUUID().toString());
        View inflate = layoutInflater.inflate(getRootLayoutResId(), viewGroup, false);
        this.mRootView = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m36128b();
        m36130c();
        View view2 = this.mRootView;
        if (view2 instanceof ViewGroup) {
            this.f48172h = new TopPermissionViewHelper((ViewGroup) view2);
        }
    }

    /* renamed from: a */
    private void m36126a() {
        if (PermissionUtil.checkPermissionAllGranted(getContext(), new String[]{Permission.CAMERA})) {
            this.f48176l = true;
            CaptureManager captureManager = this.mCaptureManager;
            if (captureManager != null) {
                captureManager.onResume();
                return;
            }
            return;
        }
        TopPermissionViewHelper topPermissionViewHelper = this.f48172h;
        if (topPermissionViewHelper != null) {
            topPermissionViewHelper.showViewDelayed(R.string.qr_code_scan_camera_permission_title_text, R.string.qr_code_scan_camera_permission_desc_text, 100);
        }
        requestPermissions(new String[]{Permission.CAMERA}, 1008);
    }

    /* renamed from: b */
    private void m36128b() {
        LayoutInflater layoutInflater = getLayoutInflater();
        int customLayoutResId = getCustomLayoutResId();
        if (customLayoutResId != 0) {
            layoutInflater.inflate(customLayoutResId, (ViewGroup) this.mRootView.findViewById(R.id.qr_code_custom_view));
            initCustomView();
        }
        layoutInflater.inflate(getScannerLoadingResId(), (ViewGroup) this.mRootView.findViewById(R.id.zxing_barcode_loading));
        DecoratedBarcodeView decoratedBarcodeView = (DecoratedBarcodeView) this.mRootView.findViewById(R.id.bv_scanner_container);
        this.f48168c = decoratedBarcodeView;
        decoratedBarcodeView.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                boolean unused = BaseQrCodeScanFragment.this.f48173i = true;
                BaseQrCodeScanFragment.this.onTorchStateChanged(true);
            }

            public void onTorchOff() {
                boolean unused = BaseQrCodeScanFragment.this.f48173i = false;
                BaseQrCodeScanFragment.this.onTorchStateChanged(false);
            }
        });
        ViewfinderView viewfinderView = (ViewfinderView) this.mRootView.findViewById(R.id.zxing_viewfinder_view);
        this.mViewFinderView = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        initScannerLoading();
    }

    /* renamed from: c */
    private void m36130c() {
        CaptureManager captureManager = new CaptureManager(getActivity(), this.f48168c);
        this.mCaptureManager = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                if (BaseQrCodeScanFragment.this.mCaptureManager != null) {
                    BaseQrCodeScanFragment.this.mCaptureManager.onPauseWhioutWait();
                }
                BaseQrCodeScanFragment.this.onBarCodeResult(barcodeResult);
            }
        });
        this.mCaptureManager.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                BaseQrCodeScanFragment.this.hideScannerLoading();
                BaseQrCodeScanFragment.this.mViewFinderView.setAnimeFlag(true);
            }

            public void previewStopped() {
                BaseQrCodeScanFragment.this.mViewFinderView.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                BaseQrCodeScanFragment.this.f48167b.postDelayed(new Runnable() {
                    public void run() {
                        if (BaseQrCodeScanFragment.this.mCaptureManager != null) {
                            BaseQrCodeScanFragment.this.mCaptureManager.onResume();
                        }
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        m36132d();
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.zxing.scan.BaseQrCodeScanFragment.isCameraCanUse():boolean");
    }

    /* renamed from: d */
    private void m36132d() {
        if (isAutoLight()) {
            SensorManager sensorManager = (SensorManager) getContext().getSystemService(ISecurityConf.KEY_SENSOR);
            this.f48175k = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f48169d = defaultSensor;
            if (defaultSensor != null) {
                this.f48175k.registerListener(this.f48177m, defaultSensor, 3);
            }
        }
    }

    /* renamed from: e */
    private void m36135e() {
        if (this.f48169d != null) {
            if (this.f48175k == null) {
                this.f48175k = (SensorManager) getContext().getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR);
            }
            this.f48175k.unregisterListener(this.f48177m);
            this.f48169d = null;
            this.f48174j = false;
        }
    }

    public void initScannerLoading() {
        this.mLoadingView = this.mRootView.findViewById(R.id.zxing_rl_surface_loading);
    }

    public void hideScannerLoading() {
        this.f48167b.postDelayed(new Runnable() {
            public void run() {
                if (BaseQrCodeScanFragment.this.mLoadingView != null && BaseQrCodeScanFragment.this.mLoadingView.getParent() != null) {
                    ((ViewGroup) BaseQrCodeScanFragment.this.mLoadingView.getParent()).removeView(BaseQrCodeScanFragment.this.mLoadingView);
                    BaseQrCodeScanFragment.this.mLoadingView = null;
                }
            }
        }, 100);
    }

    public void onResume() {
        super.onResume();
        resumeInner();
    }

    /* access modifiers changed from: protected */
    public void resumeInner() {
        CaptureManager captureManager;
        if (this.f48176l && (captureManager = this.mCaptureManager) != null) {
            captureManager.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        CaptureManager captureManager = this.mCaptureManager;
        if (captureManager != null) {
            captureManager.onPauseWhioutWait();
        }
        dissPermissionDialog();
    }

    public void onDestroy() {
        super.onDestroy();
        m36136f();
    }

    /* renamed from: f */
    private void m36136f() {
        CaptureManager captureManager = this.mCaptureManager;
        if (captureManager != null) {
            captureManager.onPauseWhioutWait();
            this.mCaptureManager.onDestroy();
            this.mCaptureManager = null;
        }
        if (this.f48173i) {
            this.f48168c.setTorchOff();
        }
        m36135e();
        this.f48167b.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m36137g() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        FragmentActivity activity;
        this.f48166a.info("BaseQrCodeScanFragment#onRequestPermissionsResult", new Object[0]);
        if (!isDetached() && (activity = getActivity()) != null && !ActivityCompatUtils.isDestroyed(activity) && i == 1008 && iArr.length > 0) {
            TopPermissionViewHelper topPermissionViewHelper = this.f48172h;
            if (topPermissionViewHelper != null) {
                topPermissionViewHelper.removeIfNeeded();
            }
            if (iArr[0] == 0) {
                this.f48176l = true;
                CaptureManager captureManager = this.mCaptureManager;
                if (captureManager != null) {
                    captureManager.onResume();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void showPermissionDialog(String[] strArr) {
        this.f48170f = IntentUtil.showPermissionDialog(getActivity(), strArr[0], new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BaseQrCodeScanFragment.this.m36137g();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void dissPermissionDialog() {
        AlertDialog alertDialog = this.f48170f;
        if (alertDialog != null && alertDialog.isShowing()) {
            try {
                this.f48170f.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onStart() {
        super.onStart();
        m36126a();
    }

    /* access modifiers changed from: protected */
    public void notifyTorchStateChanged() {
        if (this.f48173i) {
            this.f48174j = true;
            this.f48168c.setTorchOff();
            this.f48173i = false;
            return;
        }
        this.f48168c.setTorchOn();
        this.f48173i = true;
    }
}
