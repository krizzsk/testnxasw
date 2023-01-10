package com.didi.zxing.barcodescanner.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.didi.zxing.barcodescanner.trace.ScanTrace;
import com.didi.zxing.barcodescanner.trace.ScanTraceId;
import com.didi.zxing.client.camera.CameraConfigurationUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlinx.coroutines.DebugKt;

public final class AutoFocusManager {

    /* renamed from: a */
    private static final String f47985a = "AutoFocusManager";

    /* renamed from: b */
    private static final long f47986b = 1000;

    /* renamed from: k */
    private static final Collection<String> f47987k;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f47988c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f47989d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f47990e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Camera f47991f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f47992g = new Handler(this.f47997m);

    /* renamed from: h */
    private final int f47993h = 1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f47994i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f47995j;

    /* renamed from: l */
    private CameraSettings f47996l;

    /* renamed from: m */
    private final Handler.Callback f47997m = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            AutoFocusManager.this.m36038b();
            return true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Runnable f47998n = new Runnable() {
        public void run() {
            if (!AutoFocusManager.this.f47988c) {
                if (AutoFocusManager.this.f47994i > 0 && SystemClock.elapsedRealtime() - AutoFocusManager.this.f47994i > ((long) AutoFocusManager.this.f47995j)) {
                    DecodeConfig config = DecodeConfigUtil.getConfig();
                    ScanTrace.trace(ScanTraceId.SCAN_FOCUS_TIMEOUT);
                    if (config != null && config.autoSelectFocusMode() && DecodeConfigUtil.lum > config.useContinousFocusModeLum()) {
                        Camera.Parameters parameters = AutoFocusManager.this.f47991f.getParameters();
                        CameraConfigurationUtils.setFocus(parameters, CameraSettings.FocusMode.CONTINUOUS, false);
                        AutoFocusManager.this.f47991f.setParameters(parameters);
                        if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(AutoFocusManager.this.f47991f.getParameters().getFocusMode())) {
                            boolean unused = AutoFocusManager.this.f47990e = false;
                            return;
                        }
                    }
                }
                AutoFocusManager.this.f47992g.postDelayed(AutoFocusManager.this.f47998n, 1000);
            }
        }
    };

    /* renamed from: o */
    private final Camera.AutoFocusCallback f47999o = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean z, Camera camera) {
            SystemUtils.log(4, AutoFocusManager.f47985a, "onAutoFocus() called, success===" + z + ", camera=" + camera, (Throwable) null, "com.didi.zxing.barcodescanner.camera.AutoFocusManager$3", 101);
            if (!z) {
                ScanTrace.trace(ScanTraceId.SCAN_FOCUS_FAIL);
            } else {
                long unused = AutoFocusManager.this.f47994i = SystemClock.elapsedRealtime();
            }
            if (AutoFocusManager.this.f47990e) {
                AutoFocusManager.this.f47992g.post(new Runnable() {
                    public void run() {
                        boolean unused = AutoFocusManager.this.f47989d = false;
                        AutoFocusManager.this.m36035a();
                    }
                });
            }
        }
    };

    static {
        ArrayList arrayList = new ArrayList(2);
        f47987k = arrayList;
        arrayList.add(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        f47987k.add("macro");
    }

    public AutoFocusManager(Camera camera, CameraSettings cameraSettings) {
        this.f47991f = camera;
        this.f47996l = cameraSettings;
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null) {
            this.f47995j = config.autoFocusTimeout();
        }
        start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m36035a() {
        if (!this.f47988c && !this.f47992g.hasMessages(1)) {
            this.f47992g.sendMessageDelayed(this.f47992g.obtainMessage(1), 1000);
        }
    }

    public void start() {
        String focusMode = this.f47991f.getParameters().getFocusMode();
        this.f47990e = this.f47996l.isAutoFocusEnabled() && f47987k.contains(focusMode);
        SystemUtils.log(4, f47985a, "Current focus mode '" + focusMode + "'; use auto focus? " + this.f47990e, (Throwable) null, "com.didi.zxing.barcodescanner.camera.AutoFocusManager", 143);
        this.f47988c = false;
        m36038b();
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null && config.autoSelectFocusMode()) {
            this.f47992g.postDelayed(this.f47998n, 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36038b() {
        SystemUtils.log(4, f47985a, "focus() called, useAutoFocus===" + this.f47990e + ", stopped=" + this.f47988c + ", focusing=" + this.f47989d, (Throwable) null, "com.didi.zxing.barcodescanner.camera.AutoFocusManager", 154);
        if (this.f47990e && !this.f47988c && !this.f47989d) {
            try {
                this.f47991f.autoFocus(this.f47999o);
                this.f47989d = true;
            } catch (RuntimeException e) {
                SystemUtils.log(5, f47985a, "Unexpected exception while focusing", e, "com.didi.zxing.barcodescanner.camera.AutoFocusManager", 162);
                m36035a();
            }
        }
    }

    /* renamed from: c */
    private void m36042c() {
        this.f47992g.removeMessages(1);
    }

    public void stop() {
        this.f47988c = true;
        this.f47989d = false;
        this.f47992g.removeCallbacks(this.f47998n);
        m36042c();
        if (this.f47990e) {
            try {
                this.f47991f.cancelAutoFocus();
            } catch (RuntimeException e) {
                SystemUtils.log(5, f47985a, "Unexpected exception while cancelling focusing", e, "com.didi.zxing.barcodescanner.camera.AutoFocusManager", 188);
            }
        }
    }
}
