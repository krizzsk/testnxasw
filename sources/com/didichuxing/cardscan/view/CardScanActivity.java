package com.didichuxing.cardscan.view;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.cardscan.CardScanCallback;
import com.didichuxing.cardscan.CardScanResult;
import com.didichuxing.cardscan.DidiCardScanner;
import com.didichuxing.cardscan.p176a.C15997a;
import com.didichuxing.cardscan.p176a.C16000d;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import p218io.card.payment.CardScanner;
import p218io.card.payment.CreditCard;
import p218io.card.payment.DetectionInfo;

public class CardScanActivity extends Activity {

    /* renamed from: a */
    static final /* synthetic */ boolean f48852a = (!CardScanActivity.class.desiredAssertionStatus());

    /* renamed from: b */
    private CardScanner f48853b;

    /* renamed from: c */
    private C16004a f48854c;

    /* renamed from: d */
    private OverlayView f48855d;

    /* renamed from: e */
    private boolean f48856e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f48857f = 0;

    /* renamed from: a */
    private void m36668a(int i) {
        CardScanResult cardScanResult = new CardScanResult();
        cardScanResult.resultCode = i;
        cardScanResult.requestCode = DidiCardScanner.getInstance().getRequestCode();
        cardScanResult.duration = System.currentTimeMillis() - this.f48857f;
        CardScanCallback cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
        if (cardScanCallback != null) {
            cardScanCallback.onScanResult(cardScanResult);
            DidiCardScanner.getInstance().setScanCallback((CardScanCallback) null);
        }
    }

    /* renamed from: c */
    private boolean m36669c() {
        C16004a aVar;
        if (f48852a || this.f48854c != null) {
            CardScanner cardScanner = this.f48853b;
            if (cardScanner == null || (aVar = this.f48854c) == null) {
                return false;
            }
            return cardScanner.resumeScanning(aVar.getSurfaceHolder());
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    private void m36670d() {
        SurfaceView surfaceView = this.f48854c.getSurfaceView();
        if (surfaceView != null) {
            int width = (int) (((float) ((surfaceView.getWidth() * 640) / 480)) * (((((float) surfaceView.getHeight()) * ((float) CardScanner.sDesiredPreviewHeight)) / ((float) surfaceView.getWidth())) / ((float) CardScanner.sDesiredPreviewWidth)));
            Rect guideFrame = this.f48853b.getGuideFrame(surfaceView.getWidth(), width);
            int height = (surfaceView.getHeight() - width) / 2;
            guideFrame.top += height;
            guideFrame.bottom += height;
            guideFrame.top += surfaceView.getTop();
            guideFrame.bottom += surfaceView.getTop();
            this.f48855d.mo121461a(guideFrame, 0);
        }
    }

    /* renamed from: e */
    private void m36671e() {
        Camera camera;
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.x;
        int i2 = point.y;
        int height = getWindow().getDecorView().getHeight();
        if (i2 < height) {
            i2 = height;
        }
        int i3 = (i2 * 100) / i;
        Camera.Size size = null;
        try {
            camera = Camera.open();
        } catch (RuntimeException unused) {
            m36668a(1);
            finish();
            camera = null;
        }
        if (camera != null) {
            int i4 = 100;
            for (Camera.Size next : camera.getParameters().getSupportedPreviewSizes()) {
                int abs = Math.abs(((next.width * 100) / next.height) - i3);
                if (abs < i4 || (abs <= i4 && next.width == i2)) {
                    size = next;
                    i4 = abs;
                }
            }
            if (size != null) {
                CardScanner.sDesiredPreviewHeight = size.height;
                CardScanner.sDesiredPreviewWidth = size.width;
            }
            camera.release();
        }
    }

    /* renamed from: f */
    private void m36672f() {
        m36671e();
        if (C16000d.m36659a()) {
            if (Build.VERSION.SDK_INT >= 16) {
                getWindow().getDecorView().setSystemUiVisibility(4);
                ActionBar actionBar = getActionBar();
                if (actionBar != null) {
                    actionBar.hide();
                }
            }
            try {
                CardScanner cardScanner = new CardScanner(this);
                this.f48853b = cardScanner;
                cardScanner.prepareScanner();
            } catch (Exception e) {
                e.printStackTrace();
                m36668a(4);
                finish();
            }
            m36673g();
        }
    }

    /* renamed from: g */
    private void m36673g() {
        String str;
        OverlayView overlayView;
        FrameLayout frameLayout = new FrameLayout(this);
        C16004a aVar = new C16004a(this, (AttributeSet) null);
        this.f48854c = aVar;
        aVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.f48854c);
        OverlayView overlayView2 = (OverlayView) LayoutInflater.from(this).inflate(R.layout.cardscan_overlay_layout, frameLayout, false);
        this.f48855d = overlayView2;
        overlayView2.mo121462a(this);
        this.f48855d.setWillNotDraw(false);
        this.f48855d.setTorchEnabled(false);
        this.f48855d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (getApplicationContext().getPackageName().contains("com.taxis99")) {
            overlayView = this.f48855d;
            str = "#fffea330";
        } else {
            overlayView = this.f48855d;
            str = "#ffff7733";
        }
        overlayView.setGuideColor(Color.parseColor(str));
        ((TextView) this.f48855d.findViewById(R.id.title_tv)).setText(DidiCardScanner.getInstance().getTitleText());
        frameLayout.addView(this.f48855d);
        setContentView(frameLayout);
    }

    /* renamed from: a */
    public void mo121449a() {
        SurfaceView surfaceView = this.f48854c.getSurfaceView();
        OverlayView overlayView = this.f48855d;
        if (overlayView != null) {
            overlayView.setCameraPreviewRect(new Rect(surfaceView.getLeft(), surfaceView.getTop(), surfaceView.getRight(), surfaceView.getBottom()));
        }
        m36670d();
        mo121450a(new DetectionInfo());
    }

    /* renamed from: a */
    public void mo121450a(DetectionInfo detectionInfo) {
        OverlayView overlayView = this.f48855d;
        if (overlayView != null) {
            overlayView.setDetectionInfo(detectionInfo);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = r1.f48853b;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo121451a(boolean r2) {
        /*
            r1 = this;
            com.didichuxing.cardscan.view.a r0 = r1.f48854c
            if (r0 == 0) goto L_0x0014
            com.didichuxing.cardscan.view.OverlayView r0 = r1.f48855d
            if (r0 == 0) goto L_0x0014
            io.card.payment.CardScanner r0 = r1.f48853b
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.setFlashOn(r2)
            if (r0 == 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001c
            com.didichuxing.cardscan.view.OverlayView r0 = r1.f48855d
            r0.setTorchOn(r2)
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.cardscan.view.CardScanActivity.mo121451a(boolean):void");
    }

    /* renamed from: b */
    public void mo121452b() {
        CardScanner cardScanner = this.f48853b;
        if (cardScanner != null) {
            cardScanner.triggerAutoFocus();
        }
    }

    /* renamed from: b */
    public void mo121453b(final DetectionInfo detectionInfo) {
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(new long[]{0, 70, 10, 40}, -1);
        }
        C160031 r0 = new Runnable() {
            public void run() {
                CreditCard creditCard = detectionInfo.creditCard();
                CardScanResult cardScanResult = new CardScanResult();
                cardScanResult.cardNumber = creditCard.cardNumber;
                cardScanResult.expiryMonth = creditCard.expiryMonth;
                cardScanResult.expiryYear = creditCard.expiryYear;
                cardScanResult.resultCode = 0;
                cardScanResult.requestCode = DidiCardScanner.getInstance().getRequestCode();
                cardScanResult.duration = System.currentTimeMillis() - CardScanActivity.this.f48857f;
                CardScanCallback cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
                if (cardScanCallback != null) {
                    cardScanCallback.onScanResult(cardScanResult);
                    DidiCardScanner.getInstance().setScanCallback((CardScanCallback) null);
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
        } else {
            runOnUiThread(r0);
        }
        finish();
    }

    public void onBackPressed() {
        CardScanCallback cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
        if (cardScanCallback != null) {
            cardScanCallback.onKeyBackBtnClick();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        C15997a.m36650a(this);
        super.onCreate(bundle);
        getWindow().addFlags(8192);
        this.f48857f = System.currentTimeMillis();
        if (CardScanner.processorSupported()) {
            if (Build.VERSION.SDK_INT < 23) {
                requestWindowFeature(1);
            } else if (checkSelfPermission(Permission.CAMERA) == -1) {
                this.f48856e = true;
                requestPermissions(new String[]{Permission.CAMERA}, 11);
                return;
            }
            m36672f();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        mo121451a(false);
        CardScanner cardScanner = this.f48853b;
        if (cardScanner != null) {
            cardScanner.endScanning();
            this.f48853b = null;
        }
        super.onDestroy();
        DidiCardScanner.getInstance().reset();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        mo121451a(false);
        CardScanner cardScanner = this.f48853b;
        if (cardScanner != null) {
            cardScanner.pauseScanning();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 11) {
            if (strArr.length > 0) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    if (!Permission.CAMERA.equals(strArr[i2]) || iArr[i2] != 0) {
                        i2++;
                    } else {
                        m36672f();
                        m36669c();
                        return;
                    }
                }
            }
            m36668a(1);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f48856e && m36669c()) {
            mo121451a(false);
        }
    }
}
