package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.qrcode.detector.FinderPattern;
import com.didi.dqrutil.DqrConfigHelper;
import com.didi.dqrutil.DqrDecodeConfig;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.scale.ScaleGestureDetector;
import com.didi.zxing.client.BeepManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class BarcodeView extends CameraPreview {

    /* renamed from: a */
    private static final String f47863a = "BarcodeView";

    /* renamed from: b */
    private String f47864b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DecodeMode f47865c = DecodeMode.NONE;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BarcodeCallback f47866d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DecodeThreadInter f47867e;

    /* renamed from: f */
    private DecoderFactory f47868f;

    /* renamed from: g */
    private Handler f47869g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f47870h = 1.0f;

    /* renamed from: i */
    private Rect f47871i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public BeepManager f47872j;

    /* renamed from: k */
    private final Handler.Callback f47873k = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == R.id.zxing_decode_succeeded) {
                BarcodeResult barcodeResult = (BarcodeResult) message.obj;
                if (!(barcodeResult == null || BarcodeView.this.f47866d == null || BarcodeView.this.f47865c == DecodeMode.NONE)) {
                    BarcodeView.this.f47872j.playBeepSoundAndVibrate();
                    BarcodeView.this.f47866d.barcodeResult(barcodeResult);
                    if (BarcodeView.this.f47865c == DecodeMode.SINGLE) {
                        BarcodeView.this.stopDecoding();
                    }
                }
                return true;
            } else if (message.what == R.id.zxing_decode_failed) {
                return true;
            } else {
                if (message.what != R.id.zxing_possible_result_points) {
                    return false;
                }
                DecodeConfig config = DecodeConfigUtil.getConfig();
                if (config != null && config.autoZoom()) {
                    FinderPattern finderPattern = (FinderPattern) message.obj;
                    float dip2px = (float) C15738Util.dip2px(BarcodeView.this.getContext(), (float) config.zoomMinDp());
                    float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
                    if (finderPattern.getEstimatedModuleSize() < dip2px) {
                        BarcodeView.this.setZoom(dip2px / estimatedModuleSize);
                    }
                }
                return true;
            }
        }
    };

    private enum DecodeMode {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public void setZoom(float f) {
        try {
            if (getCameraInstance() == null) {
                return;
            }
            if (getCameraInstance().getCameraManager() != null) {
                Camera camera = getCameraInstance().getCameraManager().getCamera();
                if (camera != null) {
                    Camera.Parameters parameters = camera.getParameters();
                    if (camera == null) {
                        return;
                    }
                    if (parameters.isZoomSupported()) {
                        int maxZoom = parameters.getMaxZoom();
                        int a = m35954a(f, camera);
                        this.f47870h = ((float) camera.getParameters().getZoomRatios().get(a).intValue()) / 100.0f;
                        if (a <= maxZoom) {
                            maxZoom = a;
                        }
                        if (parameters.isSmoothZoomSupported()) {
                            camera.startSmoothZoom(maxZoom);
                            return;
                        }
                        parameters.setZoom(maxZoom);
                        camera.setParameters(parameters);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m35954a(float f, Camera camera) {
        List<Integer> zoomRatios = camera.getParameters().getZoomRatios();
        int i = (int) (f * 100.0f);
        int i2 = 0;
        while (true) {
            if (i2 >= zoomRatios.size()) {
                i2 = -1;
                break;
            } else if (zoomRatios.get(i2).intValue() >= i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        if (i > zoomRatios.get(zoomRatios.size() - 1).intValue()) {
            return zoomRatios.size() - 1;
        }
        return 0;
    }

    public BarcodeView(Context context) {
        super(context);
        m35956a();
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35956a();
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m35956a();
    }

    /* renamed from: a */
    private void m35956a() {
        final DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null && config.analysisDqr()) {
            AnalysisManager.init(config.getAnalysis());
        }
        this.f47868f = new DefaultDecoderFactory(config != null ? config.extraBarcodeFormats() : "");
        this.f47869g = new Handler(this.f47873k);
        this.f47872j = new BeepManager(getContext());
        if (config != null && config.autoZoom()) {
            setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (BarcodeView.this.f47870h > 1.0f) {
                        if (BarcodeView.this.f47867e != null) {
                            BarcodeView.this.f47867e.setCheckPattern(true);
                        }
                        BarcodeView.this.setZoom(1.0f);
                        return;
                    }
                    if (BarcodeView.this.f47867e != null) {
                        BarcodeView.this.f47867e.setCheckPattern(false);
                    }
                    DecodeConfig decodeConfig = config;
                    if (decodeConfig != null) {
                        BarcodeView.this.setZoom((float) decodeConfig.zoomSize());
                    }
                }
            });
        }
        final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.OnScaleGestureListener() {
            float lastScale = 1.0f;

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                BarcodeView barcodeView = BarcodeView.this;
                barcodeView.setZoom(barcodeView.f47870h + ((scaleFactor - this.lastScale) * 4.0f));
                this.lastScale = scaleFactor;
                return false;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                this.lastScale = 1.0f;
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            long lastClick;
            long lastUp;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (SystemClock.elapsedRealtime() - this.lastUp >= 500 || SystemClock.elapsedRealtime() - this.lastClick <= 1000) {
                        this.lastUp = SystemClock.elapsedRealtime();
                    } else {
                        this.lastClick = SystemClock.elapsedRealtime();
                        view.performClick();
                    }
                }
                return scaleGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public void setDecoderFactory(DecoderFactory decoderFactory) {
        C15738Util.validateMainThread();
        this.f47868f = decoderFactory;
        DecodeThreadInter decodeThreadInter = this.f47867e;
        if (decodeThreadInter != null) {
            decodeThreadInter.setDecoder(m35958b());
        }
    }

    /* renamed from: b */
    private Decoder m35958b() {
        if (this.f47868f == null) {
            this.f47868f = createDefaultDecoderFactory();
        }
        return this.f47868f.createDecoder(new HashMap());
    }

    public DecoderFactory getDecoderFactory() {
        return this.f47868f;
    }

    public void decodeSingle(BarcodeCallback barcodeCallback) {
        this.f47865c = DecodeMode.SINGLE;
        this.f47866d = barcodeCallback;
        startDecoderThread();
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.f47865c = DecodeMode.CONTINUOUS;
        this.f47866d = barcodeCallback;
        startDecoderThread();
    }

    public void stopDecoding() {
        this.f47865c = DecodeMode.NONE;
        this.f47866d = null;
        m35960c();
    }

    /* access modifiers changed from: protected */
    public DecoderFactory createDefaultDecoderFactory() {
        return new DefaultDecoderFactory();
    }

    public void startDecoderThread() {
        m35960c();
        if (this.f47865c != DecodeMode.NONE && isPreviewActive()) {
            DecodeConfig config = DecodeConfigUtil.getConfig();
            if (config != null) {
                DqrConfigHelper.init(config);
            }
            SystemUtils.log(4, f47863a, "useMultiThread", (Throwable) null, "com.didi.zxing.barcodescanner.BarcodeView", 328);
            MultiDecoderThread multiDecoderThread = new MultiDecoderThread(getContext(), getCameraInstance(), m35958b(), this.f47869g);
            this.f47867e = multiDecoderThread;
            Rect rect = this.f47871i;
            if (rect != null) {
                multiDecoderThread.setCropRect(rect);
            } else {
                multiDecoderThread.setCropRect(getPreviewFramingRect());
            }
            this.f47867e.setProductId(this.f47864b);
            this.f47867e.start();
        }
    }

    public void setCropRect(Rect rect) {
        if (rect != null && rect.width() > 0 && rect.height() > 0) {
            this.f47871i = rect;
            DecodeThreadInter decodeThreadInter = this.f47867e;
            if (decodeThreadInter != null) {
                decodeThreadInter.setCropRect(rect);
            }
        }
    }

    public void resume() {
        super.resume();
    }

    /* access modifiers changed from: protected */
    public void previewStarted() {
        super.previewStarted();
        startDecoderThread();
    }

    /* renamed from: c */
    private void m35960c() {
        DecodeThreadInter decodeThreadInter = this.f47867e;
        if (decodeThreadInter != null) {
            decodeThreadInter.stop();
            this.f47867e = null;
        }
        DqrConfigHelper.init((DqrDecodeConfig) null);
    }

    public void pause() {
        super.pause();
        m35960c();
        AnalysisManager.reportAll();
    }

    public void pauseAndHoldCamera() {
        m35960c();
    }

    public void destroy() {
        m35960c();
        if (this.cameraInstance != null && this.cameraInstance.isOpen()) {
            this.cameraInstance.close();
            this.cameraInstance = null;
        }
    }

    @Deprecated
    public void setDecodeFormats(Collection<BarcodeFormat> collection) {
        DecoderFactory decoderFactory = this.f47868f;
        if (decoderFactory != null) {
            decoderFactory.setDecodeFormats(collection);
        }
    }

    public void setDecodeFormats(String str) {
        if (this.f47868f != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            C15738Util.addExtraBarcodeFormats(str, arrayList);
            if (arrayList.isEmpty()) {
                arrayList.add(BarcodeFormat.QR_CODE);
            }
            this.f47868f.setDecodeFormats(arrayList);
        }
    }

    public void setProductId(String str) {
        this.f47864b = str;
    }
}
