package com.didi.zxing.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dqr.ResultMetadataType;
import com.didi.dqr.ResultPoint;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.client.BeepManager;
import com.didi.zxing.client.InactivityTimer;
import com.didi.zxing.client.Intents;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CaptureManager {

    /* renamed from: a */
    private static final String f47904a = "CaptureManager";

    /* renamed from: b */
    private static int f47905b = 250;

    /* renamed from: f */
    private static final String f47906f = "SAVED_ORIENTATION_LOCK";

    /* renamed from: c */
    private Activity f47907c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DecoratedBarcodeView f47908d;

    /* renamed from: e */
    private int f47909e;

    /* renamed from: g */
    private boolean f47910g;

    /* renamed from: h */
    private boolean f47911h;

    /* renamed from: i */
    private InactivityTimer f47912i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public BeepManager f47913j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f47914k;

    /* renamed from: l */
    private boolean f47915l;

    /* renamed from: m */
    private boolean f47916m;

    /* renamed from: n */
    private boolean f47917n;

    /* renamed from: o */
    private BarcodeCallback f47918o;

    /* renamed from: p */
    private final CameraPreview.StateListener f47919p;

    /* renamed from: q */
    private boolean f47920q;

    public CaptureManager(Activity activity, final DecoratedBarcodeView decoratedBarcodeView) {
        this.f47909e = -1;
        this.f47910g = false;
        this.f47911h = false;
        this.f47915l = false;
        this.f47916m = true;
        this.f47917n = true;
        this.f47918o = new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(final BarcodeResult barcodeResult) {
                CaptureManager.this.f47908d.pause();
                CaptureManager.this.f47913j.playBeepSoundAndVibrate();
                CaptureManager.this.f47914k.post(new Runnable() {
                    public void run() {
                        CaptureManager.this.returnResult(barcodeResult);
                    }
                });
            }
        };
        this.f47919p = new CameraPreview.StateListener() {
            public void previewSized() {
            }

            public void previewStarted() {
            }

            public void previewStopped() {
            }

            public void cameraError(Exception exc) {
                SystemUtils.log(5, CaptureManager.f47904a, "error " + exc.getMessage(), (Throwable) null, "com.didi.zxing.barcodescanner.CaptureManager$2", 116);
            }

            public void cameraClosed() {
                SystemUtils.log(3, CaptureManager.f47904a, "Camera closed; finishing activity", (Throwable) null, "com.didi.zxing.barcodescanner.CaptureManager$2", 122);
            }
        };
        this.f47920q = false;
        this.f47907c = activity;
        this.f47908d = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().addStateListener(this.f47919p);
        this.f47914k = new Handler();
        this.f47912i = new InactivityTimer(activity, new Runnable() {
            public void run() {
                SystemUtils.log(3, CaptureManager.f47904a, "Finishing due to inactivity", (Throwable) null, "com.didi.zxing.barcodescanner.CaptureManager$3", 139);
                CaptureManager.this.m35991b();
            }
        });
        this.f47913j = new BeepManager(activity);
        decoratedBarcodeView.getBarcodeView().setLumListener(new LumListener() {
            private int changeCount;
            private int total;

            public int frequency() {
                return 3;
            }

            public void onLumChange(int i) {
                int i2 = this.total + i;
                this.total = i2;
                int i3 = this.changeCount + 1;
                this.changeCount = i3;
                if (i3 > 10) {
                    int i4 = i2 / i3;
                    DecodeConfigUtil.lum = i4;
                    DecodeConfig config = DecodeConfigUtil.getConfig();
                    if (config != null && config.autoTorch() && i4 <= config.autoTorchLum()) {
                        CaptureManager.this.f47914k.post(new Runnable() {
                            public void run() {
                                decoratedBarcodeView.mo120200a(true);
                            }
                        });
                    }
                    this.changeCount = 0;
                    this.total = 0;
                }
            }
        });
    }

    public CaptureManager(Activity activity, DecoratedBarcodeView decoratedBarcodeView, boolean z, boolean z2) {
        this(activity, decoratedBarcodeView);
        this.f47916m = z;
        this.f47917n = z2;
    }

    public CaptureManager(Activity activity, DecoratedBarcodeView decoratedBarcodeView, boolean z) {
        this(activity, decoratedBarcodeView);
        this.f47916m = z;
    }

    public void addStateListener(CameraPreview.StateListener stateListener) {
        this.f47908d.getBarcodeView().addStateListener(stateListener);
    }

    public void initializeFromIntent(Intent intent, Bundle bundle) {
        Activity activity = this.f47907c;
        if (activity != null) {
            activity.getWindow().addFlags(128);
            if (bundle != null) {
                this.f47909e = bundle.getInt(f47906f, -1);
            }
            if (intent != null) {
                if (intent.getBooleanExtra(Intents.Scan.ORIENTATION_LOCKED, true)) {
                    lockOrientation();
                }
                if (Intents.Scan.ACTION.equals(intent.getAction())) {
                    this.f47908d.initializeFromIntent(intent);
                }
                if (!intent.getBooleanExtra(Intents.Scan.BEEP_ENABLED, true)) {
                    this.f47913j.setBeepEnabled(false);
                }
                if (intent.hasExtra("TIMEOUT")) {
                    this.f47914k.postDelayed(new Runnable() {
                        public void run() {
                            CaptureManager.this.returnResultTimeout();
                        }
                    }, intent.getLongExtra("TIMEOUT", 0));
                }
                if (intent.getBooleanExtra(Intents.Scan.BARCODE_IMAGE_ENABLED, false)) {
                    this.f47910g = true;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void lockOrientation() {
        Activity activity = this.f47907c;
        if (activity != null) {
            if (this.f47909e == -1) {
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                int i = this.f47907c.getResources().getConfiguration().orientation;
                int i2 = 0;
                if (i == 2) {
                    if (!(rotation == 0 || rotation == 1)) {
                        i2 = 8;
                    }
                } else if (i == 1) {
                    i2 = (rotation == 0 || rotation == 3) ? 1 : 9;
                }
                this.f47909e = i2;
            }
            SystemUtils.hookSetRequestedOrientation(this.f47907c, this.f47909e);
        }
    }

    public void decode() {
        this.f47908d.decodeSingle(this.f47918o);
    }

    public void decode(BarcodeCallback barcodeCallback) {
        this.f47908d.decodeSingle(barcodeCallback);
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.f47908d.decodeContinuous(barcodeCallback);
    }

    public void onResume() {
        if (Build.VERSION.SDK_INT < 23 || !this.f47916m) {
            this.f47908d.resume();
        } else {
            m35989a();
        }
        if (this.f47917n) {
            this.f47912i.start();
        }
    }

    public boolean resume(Activity activity) {
        boolean z = this.f47907c == null;
        this.f47907c = activity;
        onResume();
        return z;
    }

    /* renamed from: a */
    private void m35989a() {
        Activity activity = this.f47907c;
        if (activity != null) {
            if (ContextCompat.checkSelfPermission(activity, Permission.CAMERA) == 0) {
                this.f47908d.resume();
            } else if (!this.f47920q) {
                ActivityCompat.requestPermissions(this.f47907c, new String[]{Permission.CAMERA}, f47905b);
                this.f47920q = true;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != f47905b) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            displayFrameworkBugMessageAndExit();
        } else {
            this.f47908d.resume();
        }
    }

    public void onPause() {
        this.f47912i.cancel();
        this.f47908d.pauseAndWait();
    }

    public void onPauseWhioutWait() {
        this.f47912i.cancel();
        this.f47908d.pause();
    }

    public void pauseAndHoldCamera() {
        DecoratedBarcodeView decoratedBarcodeView = this.f47908d;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.pauseAndHoldCamera();
        }
    }

    public void resumeScan() {
        DecoratedBarcodeView decoratedBarcodeView = this.f47908d;
        if (decoratedBarcodeView != null && decoratedBarcodeView.getBarcodeView() != null) {
            this.f47908d.getBarcodeView().startDecoderThread();
        }
    }

    public void onDestroy() {
        this.f47908d.destroy();
        this.f47911h = true;
        this.f47912i.cancel();
        this.f47914k.removeCallbacksAndMessages((Object) null);
        this.f47907c = null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(f47906f, this.f47909e);
    }

    public static Intent resultIntent(BarcodeResult barcodeResult, String str) {
        Intent intent = new Intent(Intents.Scan.ACTION);
        intent.addFlags(524288);
        intent.putExtra(Intents.Scan.RESULT, barcodeResult.toString());
        intent.putExtra(Intents.Scan.RESULT_FORMAT, barcodeResult.getBarcodeFormat().toString());
        byte[] rawBytes = barcodeResult.getRawBytes();
        if (rawBytes != null && rawBytes.length > 0) {
            intent.putExtra(Intents.Scan.RESULT_BYTES, rawBytes);
        }
        Map<ResultMetadataType, Object> resultMetadata = barcodeResult.getResultMetadata();
        if (resultMetadata != null) {
            if (resultMetadata.containsKey(ResultMetadataType.UPC_EAN_EXTENSION)) {
                intent.putExtra(Intents.Scan.RESULT_UPC_EAN_EXTENSION, resultMetadata.get(ResultMetadataType.UPC_EAN_EXTENSION).toString());
            }
            Number number = (Number) resultMetadata.get(ResultMetadataType.ORIENTATION);
            if (number != null) {
                intent.putExtra(Intents.Scan.RESULT_ORIENTATION, number.intValue());
            }
            String str2 = (String) resultMetadata.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra(Intents.Scan.RESULT_ERROR_CORRECTION_LEVEL, str2);
            }
            Iterable<byte[]> iterable = (Iterable) resultMetadata.get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                int i = 0;
                for (byte[] putExtra : iterable) {
                    intent.putExtra(Intents.Scan.RESULT_BYTE_SEGMENTS_PREFIX + i, putExtra);
                    i++;
                }
            }
        }
        if (str != null) {
            intent.putExtra(Intents.Scan.RESULT_BARCODE_IMAGE_PATH, str);
        }
        return intent;
    }

    /* renamed from: a */
    private String m35988a(BarcodeResult barcodeResult) {
        if (this.f47907c == null || !this.f47910g) {
            return null;
        }
        Bitmap bitmap = barcodeResult.getBitmap();
        try {
            File createTempFile = File.createTempFile("barcodeimage", ".jpg", this.f47907c.getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            return createTempFile.getAbsolutePath();
        } catch (IOException e) {
            SystemUtils.log(5, f47904a, "Unable to create temporary file and store bitmap! " + e, (Throwable) null, "com.didi.zxing.barcodescanner.CaptureManager", 480);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35991b() {
        Activity activity = this.f47907c;
        if (activity != null) {
            activity.finish();
        }
        InactivityTimer inactivityTimer = this.f47912i;
        if (inactivityTimer != null) {
            inactivityTimer.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void closeAndFinish() {
        if (this.f47908d.getBarcodeView().isCameraClosed()) {
            m35991b();
        } else {
            this.f47915l = true;
        }
        this.f47908d.pause();
        this.f47912i.cancel();
    }

    /* access modifiers changed from: protected */
    public void returnResultTimeout() {
        if (this.f47907c != null) {
            Intent intent = new Intent(Intents.Scan.ACTION);
            intent.putExtra("TIMEOUT", true);
            this.f47907c.setResult(0, intent);
            closeAndFinish();
        }
    }

    /* access modifiers changed from: protected */
    public void returnResult(BarcodeResult barcodeResult) {
        if (this.f47907c != null) {
            this.f47907c.setResult(-1, resultIntent(barcodeResult, m35988a(barcodeResult)));
            closeAndFinish();
        }
    }

    /* access modifiers changed from: protected */
    public void displayFrameworkBugMessageAndExit() {
        Activity activity = this.f47907c;
        if (activity != null && !activity.isFinishing() && !this.f47911h && !this.f47915l) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f47907c);
            builder.setMessage(this.f47907c.getString(R.string.zxing_msg_camera_framework_bug));
            builder.setPositiveButton(R.string.zxing_button_ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                    CaptureManager.this.m35991b();
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    CaptureManager.this.m35991b();
                }
            });
            builder.show();
        }
    }

    public static int getCameraPermissionReqCode() {
        return f47905b;
    }

    public static void setCameraPermissionReqCode(int i) {
        f47905b = i;
    }

    public BarcodeView barcodeView() {
        DecoratedBarcodeView decoratedBarcodeView = this.f47908d;
        if (decoratedBarcodeView == null) {
            return null;
        }
        return decoratedBarcodeView.getBarcodeView();
    }

    public boolean isTorchOn() {
        DecoratedBarcodeView decoratedBarcodeView = this.f47908d;
        if (decoratedBarcodeView == null || decoratedBarcodeView.getBarcodeView() == null) {
            return false;
        }
        return this.f47908d.getBarcodeView().isTorchOn();
    }

    public void setProductId(String str) {
        DecoratedBarcodeView decoratedBarcodeView = this.f47908d;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.setProductId(str);
        }
    }
}
