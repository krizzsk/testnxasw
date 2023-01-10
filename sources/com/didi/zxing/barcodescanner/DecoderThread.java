package com.didi.zxing.barcodescanner;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.LuminanceSource;
import com.didi.dqr.MultiFormatReader;
import com.didi.dqr.ReaderException;
import com.didi.dqr.Result;
import com.didi.dqr.common.HybridBinarizer;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.camera.CameraInstance;
import com.didi.zxing.barcodescanner.camera.PreviewCallback;
import com.didi.zxing.barcodescanner.trace.ScanTrace;
import com.didi.zxing.barcodescanner.trace.ScanTraceId;
import com.taxis99.R;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class DecoderThread implements DecodeThreadInter {

    /* renamed from: a */
    private static final String f47923a = "DecoderThread";

    /* renamed from: b */
    private CameraInstance f47924b;

    /* renamed from: c */
    private HandlerThread f47925c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Handler f47926d;

    /* renamed from: e */
    private Decoder f47927e;

    /* renamed from: f */
    private Handler f47928f;

    /* renamed from: g */
    private Rect f47929g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f47930h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Object f47931i = new Object();

    /* renamed from: j */
    private MultiFormatReader f47932j;

    /* renamed from: k */
    private long f47933k;

    /* renamed from: l */
    private final Handler.Callback f47934l = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == R.id.zxing_decode) {
                DecoderThread.this.m35998a((SourceData) message.obj);
                return true;
            } else if (message.what != R.id.zxing_preview_failed) {
                return true;
            } else {
                DecoderThread.this.m35995a();
                return true;
            }
        }
    };

    /* renamed from: m */
    private final PreviewCallback f47935m = new PreviewCallback() {
        public boolean oneShot() {
            return true;
        }

        public void onPreview(SourceData sourceData) {
            synchronized (DecoderThread.this.f47931i) {
                if (DecoderThread.this.f47930h) {
                    DecoderThread.this.f47926d.obtainMessage(R.id.zxing_decode, sourceData).sendToTarget();
                }
            }
        }

        public void onPreviewError(Exception exc) {
            synchronized (DecoderThread.this.f47931i) {
                if (DecoderThread.this.f47930h) {
                    DecoderThread.this.f47926d.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                }
            }
        }
    };

    public void setCheckPattern(boolean z) {
    }

    public void setProductId(String str) {
    }

    public DecoderThread(CameraInstance cameraInstance, Decoder decoder, Handler handler) {
        C15738Util.validateMainThread();
        this.f47924b = cameraInstance;
        this.f47927e = decoder;
        this.f47928f = handler;
        Map<DecodeHintType, ?> a = m35994a(decoder.getDecodeOptions());
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f47932j = multiFormatReader;
        multiFormatReader.setHints(a);
        this.f47932j.setDecodeOptions(decoder.getDecodeOptions());
    }

    /* renamed from: a */
    private Map<DecodeHintType, ?> m35994a(DecodeOptions decodeOptions) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        if (decodeOptions.baseHints != null) {
            enumMap.putAll(decodeOptions.baseHints);
        }
        if (decodeOptions.decodeFormats == null || decodeOptions.decodeFormats.isEmpty()) {
            decodeOptions.decodeFormats = EnumSet.of(BarcodeFormat.QR_CODE);
        }
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, decodeOptions.decodeFormats);
        enumMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        if (decodeOptions.characterSet != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, decodeOptions.characterSet);
        }
        return enumMap;
    }

    public Decoder getDecoder() {
        return this.f47927e;
    }

    public void setDecoder(Decoder decoder) {
        this.f47927e = decoder;
    }

    public Rect getCropRect() {
        return this.f47929g;
    }

    public void setCropRect(Rect rect) {
        this.f47929g = rect;
    }

    public void start() {
        C15738Util.validateMainThread();
        HandlerThread handlerThread = new HandlerThread(f47923a);
        this.f47925c = handlerThread;
        handlerThread.start();
        this.f47926d = new Handler(this.f47925c.getLooper(), this.f47934l);
        this.f47930h = true;
        m35995a();
        this.f47933k = SystemClock.elapsedRealtime();
        ScanTrace.trace(ScanTraceId.SCAN_START);
    }

    public void stop() {
        C15738Util.validateMainThread();
        synchronized (this.f47931i) {
            this.f47930h = false;
            this.f47926d.removeCallbacksAndMessages((Object) null);
            this.f47925c.quit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35995a() {
        if (this.f47924b.isOpen()) {
            this.f47924b.requestPreview(this.f47935m);
        }
    }

    /* access modifiers changed from: protected */
    public LuminanceSource createSource(SourceData sourceData) {
        if (this.f47929g == null) {
            return null;
        }
        return sourceData.createSource();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35998a(SourceData sourceData) {
        Result result;
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        sourceData.setCropRect(this.f47929g);
        LuminanceSource createSource = createSource(sourceData);
        if (createSource != null) {
            try {
                result = this.f47932j.decodeWithState(new BinaryBitmap(new HybridBinarizer(createSource)));
                this.f47932j.reset();
            } catch (ReaderException unused) {
                this.f47932j.reset();
                result = null;
            } catch (Throwable th) {
                this.f47932j.reset();
                throw th;
            }
            if (result != null) {
                SystemUtils.log(6, "rawResult", "rawResult = " + result.getText(), (Throwable) null, "com.didi.zxing.barcodescanner.DecoderThread", 202);
            }
            if (result == null || TextUtils.isEmpty(result.getText())) {
                Handler handler = this.f47928f;
                if (handler != null) {
                    Message.obtain(handler, R.id.zxing_decode_failed).sendToTarget();
                }
            } else if (this.f47930h) {
                long currentTimeMillis2 = System.currentTimeMillis();
                SystemUtils.log(3, f47923a, "Found barcode in " + (currentTimeMillis2 - currentTimeMillis) + " ms", (Throwable) null, "com.didi.zxing.barcodescanner.DecoderThread", 210);
                if (this.f47928f != null) {
                    Message obtain = Message.obtain(this.f47928f, R.id.zxing_decode_succeeded, new BarcodeResult(result, sourceData, elapsedRealtime));
                    obtain.setData(new Bundle());
                    obtain.sendToTarget();
                    ScanTrace.traceSingle(ScanTraceId.SCAN_SUCCESS, "cost", (SystemClock.elapsedRealtime() - this.f47933k) + "");
                }
            } else {
                return;
            }
        } else {
            SystemUtils.log(5, "zxing", "source = null", (Throwable) null, "com.didi.zxing.barcodescanner.DecoderThread", 228);
        }
        m35995a();
    }

    public void pause() {
        this.f47930h = false;
        stop();
    }
}
