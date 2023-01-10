package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.CameraView;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;

public class TakePhotoActivity extends TheOneBaseActivity {
    public static final String KEY_DMMINA_INDEX = "key_dmmina_index";
    public static final String KEY_FILEPATH = "key_filepath";
    public static final String KEY_PHOTOTYPE = "key_phototype";

    /* renamed from: a */
    private static final String f19134a = "TakePhotoActivity";

    /* renamed from: b */
    private static final int f19135b = 2000;

    /* renamed from: c */
    private static final int f19136c = 10;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f19137d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CameraView f19138e;

    /* renamed from: f */
    private DMMina f19139f;

    /* renamed from: g */
    private Handler f19140g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f19141h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ImageView f19142i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f19143j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f19144k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f19145l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f19146m;

    /* renamed from: n */
    private int f19147n;

    /* renamed from: o */
    private final Runnable f19148o = new Runnable() {
        public void run() {
            TakePhotoActivity.this.m16243b();
        }
    };

    /* renamed from: p */
    private final CameraView.Callback f19149p = new CameraView.Callback() {
        public void onCameraOpened(CameraView cameraView) {
            LogUtil.m16841i("onCameraOpened");
        }

        public void onCameraClosed(CameraView cameraView) {
            LogUtil.m16841i("onCameraClosed");
        }

        public void onPictureTaken(CameraView cameraView, byte[] bArr) {
            boolean unused = TakePhotoActivity.this.f19145l = false;
            if (!TakePhotoActivity.this.f19141h) {
                boolean unused2 = TakePhotoActivity.this.f19141h = true;
                TakePhotoActivity.this.f19143j.setVisibility(8);
                TakePhotoActivity.this.f19144k.setVisibility(0);
                LogUtil.m16841i("onPictureTaken " + bArr.length);
                final Bitmap cropBitmap = Utils.cropBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), TakePhotoActivity.this.f19138e.getWidth(), TakePhotoActivity.this.f19138e.getHeight());
                TakePhotoActivity.this.f19142i.setImageBitmap(cropBitmap);
                TakePhotoActivity.this.m16246c().post(new Runnable() {
                    public void run() {
                        Utils.m16262a(cropBitmap, TakePhotoActivity.this.f19137d);
                    }
                });
            }
        }
    };

    public enum PhotoType {
        TYPE_PEOPLE_HOLD_CARD,
        TYPE_CARD
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m16241a();
        this.f19137d = getIntent().getStringExtra(KEY_FILEPATH);
        this.f19139f = DMMinaPool.get(getIntent().getIntExtra(KEY_DMMINA_INDEX, -1));
    }

    /* renamed from: a */
    private void m16241a() {
        setContentView((int) R.layout.dimina_card_activity_take_photo);
        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoActivity.this.finish();
            }
        });
        findViewById(R.id.takePhoto).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SystemClock.elapsedRealtime() - TakePhotoActivity.this.f19146m > 2000 && !TakePhotoActivity.this.f19145l && TakePhotoActivity.this.f19138e != null && TakePhotoActivity.this.f19138e.isCameraOpened()) {
                    TakePhotoActivity.this.f19138e.takePicture();
                    long unused = TakePhotoActivity.this.f19146m = SystemClock.elapsedRealtime();
                    boolean unused2 = TakePhotoActivity.this.f19145l = true;
                }
            }
        });
        findViewById(R.id.retake).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoActivity.this.m16243b();
            }
        });
        findViewById(R.id.accept).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoActivity.this.setResult(-1);
                TakePhotoActivity.this.finish();
            }
        });
        PreviewCover previewCover = (PreviewCover) findViewById(R.id.takePhoto_bg);
        TextView textView = (TextView) findViewById(R.id.tips);
        int intExtra = getIntent().getIntExtra(KEY_PHOTOTYPE, PhotoType.TYPE_CARD.ordinal());
        if (intExtra == PhotoType.TYPE_CARD.ordinal()) {
            previewCover.setContent(R.color.dimina_color_CD000000, R.drawable.dimina_auth_camera_normal);
            textView.setText(R.string.dimina_takephoto_normal_tip);
        } else if (intExtra == PhotoType.TYPE_PEOPLE_HOLD_CARD.ordinal()) {
            previewCover.setContent(R.color.dimina_color_CD000000, R.drawable.dimina_auth_camera_hold);
            textView.setText(R.string.dimina_takephoto_normal_tip);
        }
        this.f19143j = findViewById(R.id.take_layout);
        this.f19144k = findViewById(R.id.retake_layout);
        this.f19138e = (CameraView) findViewById(R.id.camera);
        this.f19142i = (ImageView) findViewById(R.id.photo);
        CameraView cameraView = this.f19138e;
        if (cameraView != null) {
            cameraView.addCallback(this.f19149p);
            this.f19138e.setAspectRatio(AspectRatio.m40759of(1, 1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16243b() {
        if (!this.f19138e.start()) {
            int i = this.f19147n + 1;
            this.f19147n = i;
            if (i > 10) {
                SystemUtils.showToast(Toast.makeText(this, getString(R.string.dimina_opencamera_fail), 0));
                finish();
                return;
            }
            Utils.m16264a(this.f19148o, 200);
            return;
        }
        this.f19147n = 0;
        this.f19141h = false;
        this.f19143j.setVisibility(0);
        this.f19144k.setVisibility(8);
        this.f19142i.setImageBitmap((Bitmap) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        PermissionUtil.INSTANCE.checkAndRequestPermissionsWithDescDialog(this, Permission.CAMERA, DiminaPermissionDescDialog.createCameraDescInfo(this.f19139f), new SinglePermissionCallBack() {
            public void onDenied(String str) {
                TakePhotoActivity takePhotoActivity = TakePhotoActivity.this;
                ToastUtil.show((Context) takePhotoActivity, (CharSequence) takePhotoActivity.getString(R.string.dimina_permission_camera_grant_failed));
            }

            public void onGranted(String str) {
                if (!TakePhotoActivity.this.f19138e.start()) {
                    TakePhotoActivity takePhotoActivity = TakePhotoActivity.this;
                    SystemUtils.showToast(Toast.makeText(takePhotoActivity, takePhotoActivity.getString(R.string.dimina_opencamera_fail), 0));
                    TakePhotoActivity.this.finish();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f19138e.stop();
        Utils.m16263a(this.f19148o);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f19140g != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.f19140g.getLooper().quitSafely();
            } else {
                this.f19140g.getLooper().quit();
            }
            this.f19140g = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Handler m16246c() {
        if (this.f19140g == null) {
            HandlerThread handlerThread = new HandlerThread(Constants.BACKGROUND);
            handlerThread.start();
            this.f19140g = new Handler(handlerThread.getLooper());
        }
        return this.f19140g;
    }
}
