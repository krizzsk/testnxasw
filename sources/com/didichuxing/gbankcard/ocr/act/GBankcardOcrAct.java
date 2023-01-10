package com.didichuxing.gbankcard.ocr.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.utils.CameraUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.didichuxing.gbankcard.ocr.ScanCardHelper;
import com.didichuxing.gbankcard.ocr.ScanCardParam;
import com.didichuxing.gbankcard.ocr.ScanCardResult;
import com.didichuxing.gbankcard.ocr.bankcard.BankcardDetector;
import com.didichuxing.gbankcard.ocr.bankcard.BankcardResult;
import com.didichuxing.gbankcard.ocr.log.GLogReporter;
import com.didichuxing.gbankcard.ocr.log.LogData;
import com.didichuxing.gbankcard.ocr.network.GBankcardApi;
import com.didichuxing.gbankcard.ocr.network.data.GuideResp;
import com.didichuxing.gbankcard.ocr.ottoevent.OcrVerifyDoneEvent;
import com.didichuxing.gbankcard.ocr.utils.ICamera;
import com.didichuxing.gbankcard.ocr.utils.YuvCroper;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.HashMap;

public class GBankcardOcrAct extends C16510a implements Camera.PreviewCallback, TextureView.SurfaceTextureListener {

    /* renamed from: p */
    private static final int f50228p = 1;

    /* renamed from: q */
    private static final int f50229q = 2;

    /* renamed from: a */
    private TextureView f50230a;

    /* renamed from: b */
    private SurfaceTexture f50231b;

    /* renamed from: c */
    private HollowEffectView f50232c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout f50233d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Button f50234e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ICamera f50235f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile BankcardDetector f50236g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ScanCardParam f50237h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f50238i;

    /* renamed from: j */
    private Runnable f50239j;

    /* renamed from: k */
    private boolean f50240k;

    /* renamed from: l */
    private GLogReporter f50241l;

    /* renamed from: m */
    private int f50242m;

    /* renamed from: n */
    private HandlerThread f50243n;

    /* renamed from: o */
    private Handler f50244o;

    /* renamed from: r */
    private ScanCardResult f50245r;

    /* renamed from: s */
    private long f50246s;

    /* renamed from: t */
    private YuvCroper f50247t;

    /* renamed from: u */
    private final Object f50248u = new Object();

    /* renamed from: v */
    private TmpDetectResult f50249v;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.gbankcard_ocr_act;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public static void start(Context context, ScanCardParam scanCardParam) {
        AppContextHolder.init(context);
        GBankcardApi.getInstance().buildClientDeviceInfo(context);
        Intent intent = new Intent(context, GBankcardOcrAct.class);
        intent.putExtra("param", scanCardParam);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f50237h = (ScanCardParam) getIntent().getParcelableExtra("param");
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f50237h = (ScanCardParam) intent.getParcelableExtra("param");
        this.f50242m = 2;
        m37564a().onEnter();
        m37576b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public GLogReporter m37564a() {
        GLogReporter gLogReporter = this.f50241l;
        if (gLogReporter != null) {
            return gLogReporter;
        }
        if (this.f50237h == null) {
            this.f50237h = (ScanCardParam) getIntent().getParcelableExtra("param");
        }
        ScanCardParam scanCardParam = this.f50237h;
        GLogReporter gLogReporter2 = new GLogReporter(scanCardParam != null ? scanCardParam.getUid() : "", GBankcardApi.getInstance().getClientDeviceInfo());
        this.f50241l = gLogReporter2;
        return gLogReporter2;
    }

    /* renamed from: b */
    private void m37576b() {
        LogData logData = new LogData(LogData.EVENT_ENTER);
        logData.addDetail("type", Integer.valueOf(this.f50237h.getType())).addDetail("ocrType", Integer.valueOf(this.f50242m)).addDetail("countryCode", this.f50237h.getCountryCode()).addDetail("cardBin", this.f50237h.getCardBin());
        this.f50241l.report(logData);
    }

    /* renamed from: c */
    private void m37580c() {
        this.f50240k = ContextCompat.checkSelfPermission(this, Permission.CAMERA) == 0;
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        hideTitleArea();
        getWindow().addFlags(16777216);
        TextureView textureView = (TextureView) findViewById(R.id.camera_preview_tv);
        this.f50230a = textureView;
        textureView.setSurfaceTextureListener(this);
        this.f50232c = (HollowEffectView) findViewById(R.id.hollow_effect_view);
        this.f50235f = new ICamera();
        m37580c();
        if (!this.f50240k) {
            ActivityCompat.requestPermissions(this, new String[]{Permission.CAMERA}, 666);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.card_preview_rect);
        this.f50233d = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GBankcardOcrAct.this.f50235f.refocus();
            }
        });
        findViewById(R.id.back_icon).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GBankcardOcrAct.this.m37577b(103);
            }
        });
        this.f50234e = (Button) findViewById(R.id.bottom_back_btn);
        if (this.f50237h.isForceType()) {
            this.f50234e.setVisibility(4);
        } else {
            this.f50234e.setVisibility(0);
            this.f50234e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GBankcardOcrAct.this.m37577b(105);
                }
            });
            if (this.f50239j == null) {
                this.f50239j = new Runnable() {
                    public void run() {
                        GBankcardOcrAct.this.f50234e.setSelected(true);
                    }
                };
            }
            UIHandler.postDelayed(10000, this.f50239j);
        }
        this.f50236g = new BankcardDetector(GuideResp.newDefaultOne(this.f50242m));
    }

    /* renamed from: d */
    private void m37583d() {
        this.f50242m = 1;
        this.f50236g = new BankcardDetector(GuideResp.newDefaultOne(1));
        m37564a().report(m37566a(LogData.EVENT_FALLBACK_CARDIO));
    }

    /* renamed from: e */
    private void m37584e() {
        TextView textView = (TextView) findViewById(R.id.gbankcard_title);
        String charSequence = textView.getText().toString();
        textView.setText(charSequence + this.f50242m);
    }

    /* renamed from: a */
    private void m37568a(int i) {
        LogData logData = new LogData(LogData.EVENT_GUIDE);
        logData.addDetail("supportCardIO", Integer.valueOf(i));
        m37564a().report(logData);
    }

    /* renamed from: a */
    private void m37569a(ScanCardResult scanCardResult) {
        if (scanCardResult != null) {
            LogData logData = new LogData(LogData.EVENT_EXIT);
            HashMap hashMap = new HashMap();
            hashMap.put("code", Integer.valueOf(scanCardResult.code));
            hashMap.put("type", Integer.valueOf(scanCardResult.type));
            hashMap.put("ocrType", Integer.valueOf(this.f50242m));
            hashMap.put("cardNum", scanCardResult.getMaskedCardNum());
            if (scanCardResult.cardRect != null) {
                hashMap.put("cardRect", Arrays.toString(scanCardResult.cardRect));
            }
            if (scanCardResult.cardNumRect != null) {
                hashMap.put("cardNumRect", Arrays.toString(scanCardResult.cardNumRect));
            }
            hashMap.put("cardNumState", Integer.valueOf(scanCardResult.cardNumState));
            hashMap.put("cardNumScore", Float.valueOf(scanCardResult.prob));
            logData.addDetails(hashMap);
            m37564a().report(logData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m37578b(ScanCardResult scanCardResult) {
        if (scanCardResult.isForceType() && scanCardResult.code == 0) {
            LogUtils.m37051d("no need finish act case, wait outer biz verify done...");
            this.f50245r = scanCardResult;
        } else {
            m37569a(scanCardResult);
            finish();
        }
        ScanCardHelper.notifyCallback(scanCardResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m37577b(int i) {
        this.f50238i = true;
        ScanCardResult scanCardResult = new ScanCardResult(i, this.f50237h.getType());
        synchronized (this.f50248u) {
            if (this.f50249v != null) {
                scanCardResult.cardNum = this.f50249v.cardNum;
                scanCardResult.cardNumState = this.f50249v.state;
                scanCardResult.prob = this.f50249v.prob;
                scanCardResult.cardRect = this.f50249v.rect1;
                scanCardResult.cardNumRect = this.f50249v.rect2;
            }
        }
        m37578b(scanCardResult);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initDataFromIntent(intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        for (int i2 : iArr) {
            if (i2 != 0) {
                m37587f();
                return;
            }
        }
        this.f50240k = true;
    }

    /* renamed from: f */
    private void m37587f() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.GBANKCARD_RETRY_DIALOG);
        builder.setView((int) R.layout.gbankcard_ask_camera_permission_dialog_view).setCancelable(false);
        final AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        SystemUtils.showDialog(create);
        create.findViewById(R.id.dialog_left_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                create.dismiss();
                GBankcardOcrAct.this.m37577b(102);
            }
        });
        create.findViewById(R.id.dialog_right_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GBankcardOcrAct.this.m37589g();
                create.dismiss();
                GBankcardOcrAct.this.m37577b(102);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m37589g() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(268435456);
            intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
            startActivity(intent);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            try {
                Intent intent2 = new Intent("android.settings.SETTINGS");
                intent2.addFlags(268435456);
                startActivity(intent2);
            } catch (Exception e2) {
                LogUtils.logStackTrace(e2);
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        LogUtils.m37057i("onSurface avail, surface===" + surfaceTexture);
        this.f50231b = surfaceTexture;
        m37591h();
    }

    /* renamed from: h */
    private void m37591h() {
        LogUtils.m37057i("doPreview() called...");
        SurfaceTexture surfaceTexture = this.f50231b;
        if (surfaceTexture == null) {
            LogUtils.m37057i("ignore, surfaceTexture==null!!!");
        } else if (!this.f50240k) {
            LogUtils.m37057i("ignore, no camera permisson!!!");
        } else {
            try {
                this.f50235f.startPreview(surfaceTexture);
                this.f50235f.setPreviewCallback(this);
                this.f50235f.autoFocus();
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
            this.f50232c.setHollowArea(this.f50233d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LogData m37566a(String str) {
        LogData logData = new LogData(str);
        logData.addDetail("type", Integer.valueOf(this.f50237h.getType())).addDetail("ocrType", Integer.valueOf(this.f50242m));
        return logData;
    }

    /* renamed from: i */
    private void m37592i() {
        m37564a().report(m37566a(LogData.EVENT_BEGIN_SCAN));
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null || bArr.length == 0) {
            LogUtils.m37057i("ignore, cause of invalid bytes!!!");
        } else if (!this.f50235f.hasFocus) {
            LogUtils.m37057i("ignore, cause of no focus!!!");
        } else if (this.f50238i) {
            LogUtils.m37057i("ignore, cause of paused!!!");
        } else if (this.f50236g == null) {
            LogUtils.m37057i("ignore, cause of null bankcardDetector!!!");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f50246s == 0) {
                m37592i();
            }
            long j = this.f50246s;
            if (j == 0 || currentTimeMillis - j >= 200) {
                this.f50246s = currentTimeMillis;
                LogUtils.m37051d("send data to detect, timestamp===" + currentTimeMillis);
                int i = this.f50235f.cameraWidth;
                int i2 = this.f50235f.cameraHeight;
                if (this.f50247t == null) {
                    int width = this.f50230a.getWidth();
                    int height = this.f50230a.getHeight();
                    int width2 = this.f50233d.getWidth();
                    int height2 = this.f50233d.getHeight();
                    float f = ((float) width2) * 0.05f;
                    float max = Math.max(((float) this.f50233d.getLeft()) - f, 0.0f);
                    float f2 = ((float) height2) * 0.05f;
                    float f3 = (float) width;
                    float f4 = (float) height;
                    RectF rectF = new RectF(Math.max(((float) this.f50233d.getTop()) - f2, 0.0f) / f4, max / f3, Math.min(((float) this.f50233d.getBottom()) + f2, f4) / f4, Math.min(((float) this.f50233d.getRight()) + f, f3) / f3);
                    LogUtils.m37051d("rectf===" + rectF);
                    this.f50247t = new YuvCroper(YuvCroper.YUV_420SP, i, i2, rectF);
                }
                if (this.f50243n == null) {
                    HandlerThread handlerThread = new HandlerThread("gbankcard_scan", 10);
                    this.f50243n = handlerThread;
                    handlerThread.start();
                    this.f50244o = new Handler(this.f50243n.getLooper()) {
                        public void handleMessage(Message message) {
                            if (message != null) {
                                int i = message.what;
                                if (i == 1) {
                                    if (message.obj instanceof byte[]) {
                                        GBankcardOcrAct.this.m37573a((byte[]) message.obj, message.arg1, message.arg2);
                                    }
                                } else if (i == 2) {
                                    LogUtils.m37051d("handle MSG_DESTROY!!!");
                                    if (GBankcardOcrAct.this.f50236g != null) {
                                        GBankcardOcrAct.this.f50236g.stop();
                                    }
                                    GBankcardOcrAct.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            GBankcardOcrAct.this.m37595l();
                                        }
                                    });
                                } else {
                                    LogUtils.m37051d("unknown msg what===" + i);
                                }
                            }
                        }
                    };
                }
                byte[] crop = this.f50247t.crop(bArr);
                Message obtain = Message.obtain(this.f50244o);
                obtain.what = 1;
                obtain.arg1 = this.f50247t.getCropWidth();
                obtain.arg2 = this.f50247t.getCropHeight();
                obtain.obj = crop;
                obtain.sendToTarget();
            }
        }
    }

    private static class TmpDetectResult {
        /* access modifiers changed from: private */
        public String cardNum;
        /* access modifiers changed from: private */
        public float prob;
        /* access modifiers changed from: private */
        public float[] rect1;
        /* access modifiers changed from: private */
        public float[] rect2;
        /* access modifiers changed from: private */
        public int state;

        private TmpDetectResult() {
        }

        /* access modifiers changed from: private */
        public static int getProbCount(TmpDetectResult tmpDetectResult) {
            int i = 0;
            if (tmpDetectResult == null) {
                return 0;
            }
            if (!TextUtils.isEmpty(tmpDetectResult.cardNum)) {
                i = 1;
            }
            float[] fArr = tmpDetectResult.rect1;
            if (fArr != null && fArr[1] > 0.0f) {
                i++;
            }
            float[] fArr2 = tmpDetectResult.rect2;
            return (fArr2 == null || fArr2[1] <= 0.0f) ? i : i + 1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37573a(byte[] bArr, int i, int i2) {
        final float[] fArr;
        final float[] fArr2;
        if (this.f50236g != null) {
            if (this.f50238i) {
                LogUtils.m37051d("ignore paused111!!!");
                return;
            }
            LogUtils.m37051d("detectInner, w===" + i + ", h=" + i2);
            if (this.f50236g.detect(bArr, i, i2) != 1) {
                LogUtils.m37051d("alpha ocr init failed!!!");
                return;
            }
            BankcardResult.CardNumInfo cardNumInfo = this.f50236g.getCardNumInfo();
            final int i3 = cardNumInfo.state;
            final String str = cardNumInfo.cardNum;
            final float f = cardNumInfo.score;
            LogUtils.m37051d("detected cardNumState===" + i3);
            float[] cardRect = this.f50236g.getCardRect();
            if (cardRect != null) {
                fArr = new float[6];
                System.arraycopy(cardRect, 0, fArr, 0, cardRect.length);
            } else {
                fArr = null;
            }
            float[] cardNumRect = this.f50236g.getCardNumRect();
            if (cardNumRect != null) {
                float[] fArr3 = new float[6];
                System.arraycopy(cardNumRect, 0, fArr3, 0, cardNumRect.length);
                fArr2 = fArr3;
            } else {
                fArr2 = null;
            }
            TmpDetectResult tmpDetectResult = new TmpDetectResult();
            int unused = tmpDetectResult.state = i3;
            String unused2 = tmpDetectResult.cardNum = str;
            float unused3 = tmpDetectResult.prob = f;
            float[] unused4 = tmpDetectResult.rect1 = fArr;
            float[] unused5 = tmpDetectResult.rect2 = fArr2;
            this.f50236g.reset();
            if (this.f50238i) {
                LogUtils.m37051d("ignore paused222!!!");
                return;
            }
            synchronized (this.f50248u) {
                if (TmpDetectResult.getProbCount(tmpDetectResult) >= TmpDetectResult.getProbCount(this.f50249v)) {
                    this.f50249v = tmpDetectResult;
                }
            }
            if (i3 == 5) {
                LogUtils.m37051d("detected cardNum===" + str);
                this.f50238i = true;
                runOnUiThread(new Runnable() {
                    public void run() {
                        GBankcardOcrAct.this.f50233d.setBackgroundResource(R.drawable.gbankcard_preview_rect_orange);
                        ScanCardResult scanCardResult = new ScanCardResult(0, GBankcardOcrAct.this.f50237h.getType());
                        scanCardResult.cardNum = str;
                        scanCardResult.cardNumState = i3;
                        scanCardResult.prob = f;
                        scanCardResult.cardRect = fArr;
                        scanCardResult.cardNumRect = fArr2;
                        GBankcardOcrAct.this.m37578b(scanCardResult);
                    }
                });
                return;
            }
            LogUtils.m37051d("detected nothing!!!");
            if (i3 == 4 || (i3 == 0 && fArr != null && fArr[0] > 0.0f)) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        GBankcardOcrAct.this.f50235f.refocus();
                    }
                });
            }
        }
    }

    /* renamed from: b */
    private void m37579b(byte[] bArr, int i, int i2) {
        if (!this.f50238i) {
            this.f50238i = true;
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ((ImageView) findViewById(R.id.test_img)).setImageBitmap(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LogUtils.m37051d("resume===");
        ICamera iCamera = this.f50235f;
        if (iCamera != null) {
            CameraUtils.setCameraDisplayOrientation((Activity) this, 0, iCamera.openCamera(0));
            m37591h();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        LogUtils.m37051d("pause===");
        ICamera iCamera = this.f50235f;
        if (iCamera != null) {
            iCamera.closeCamera();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onBackKeyIntercept() {
        m37577b(104);
        return true;
    }

    @Subscribe
    public void onOcrVerifyDoneEvent(OcrVerifyDoneEvent ocrVerifyDoneEvent) {
        if (ocrVerifyDoneEvent.verifyOk) {
            m37569a(this.f50245r);
            finish();
            return;
        }
        m37593j();
    }

    /* renamed from: j */
    private void m37593j() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.GBANKCARD_RETRY_DIALOG);
        builder.setView((int) R.layout.gbankcard_retry_dialog_view).setCancelable(false);
        final AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        SystemUtils.showDialog(create);
        create.findViewById(R.id.dialog_rescan_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                create.dismiss();
                GBankcardOcrAct.this.f50233d.setBackgroundResource(R.drawable.gbankcard_preview_rect_white);
                boolean unused = GBankcardOcrAct.this.f50238i = false;
                GBankcardOcrAct.this.f50235f.refocus();
                GBankcardOcrAct.this.m37564a().report(GBankcardOcrAct.this.m37566a(LogData.EVENT_RESCAN));
            }
        });
        create.findViewById(R.id.dialog_quit_btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                create.dismiss();
                GBankcardOcrAct.this.m37564a().report(GBankcardOcrAct.this.m37566a(LogData.EVENT_QUIT));
                GBankcardOcrAct.this.m37577b(106);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LogUtils.m37051d("onDestroy, ocrType===" + this.f50242m);
        if (this.f50236g != null) {
            m37594k();
        }
        Runnable runnable = this.f50239j;
        if (runnable != null) {
            UIHandler.removeCallbacks(runnable);
        }
        if (m37564a() != null) {
            m37564a().onExit();
        }
    }

    /* renamed from: k */
    private void m37594k() {
        StringBuilder sb = new StringBuilder();
        sb.append("scheduleDestroyDetector, scanHandler != null? ");
        sb.append(this.f50244o != null);
        LogUtils.m37051d(sb.toString());
        Handler handler = this.f50244o;
        if (handler != null) {
            handler.removeMessages(1);
            this.f50244o.obtainMessage(2).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m37595l() {
        if (this.f50243n != null) {
            LogUtils.m37051d("quit scanThread...");
            this.f50243n.quit();
            this.f50243n = null;
            this.f50244o = null;
        }
    }
}
