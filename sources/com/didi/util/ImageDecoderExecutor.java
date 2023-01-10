package com.didi.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinarizerEnum;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.LuminanceSource;
import com.didi.dqr.MultiFormatReader;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didi.zxing.barcodescanner.Decoder;
import com.didi.zxing.barcodescanner.SourceData;
import com.didi.zxing.barcodescanner.executor.BalanceExecutor;
import com.didi.zxing.barcodescanner.executor.BalanceRunnable;
import com.didi.zxing.barcodescanner.store.DqrStore;
import com.didi.zxing.barcodescanner.store.DqrStoreConstants;
import com.didi.zxing.barcodescanner.tasker.ZxingRunnable;
import com.didi.zxing.barcodescanner.trace.ScanTrace;
import com.didi.zxing.barcodescanner.trace.ScanTraceId;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

class ImageDecoderExecutor {

    /* renamed from: a */
    private static final String f47804a = "ImageDecoderExecutor";

    /* renamed from: b */
    private static final int f47805b = 3;

    /* renamed from: c */
    private Decoder f47806c;

    /* renamed from: d */
    private Rect f47807d;

    /* renamed from: e */
    private volatile boolean f47808e = false;

    /* renamed from: f */
    private final Object f47809f = new Object();

    /* renamed from: g */
    private BalanceExecutor<ZxingRunnable> f47810g;

    /* renamed from: h */
    private BinarizerEnum f47811h;

    /* renamed from: i */
    private MultiFormatReader f47812i;

    /* renamed from: j */
    private int f47813j = Integer.MAX_VALUE;

    /* renamed from: k */
    private String f47814k;

    /* renamed from: l */
    private volatile long f47815l;

    /* renamed from: m */
    private long f47816m;

    /* renamed from: n */
    private Context f47817n;

    /* renamed from: o */
    private String f47818o;

    /* renamed from: p */
    private volatile boolean f47819p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public DecodeCallBack f47820q;

    /* renamed from: r */
    private HandlerThread f47821r;

    /* renamed from: s */
    private Handler f47822s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public SourceData f47823t;

    public interface DecodeCallBack {
        void onResult(String str);

        void onTimeout();
    }

    public ImageDecoderExecutor(Context context, Decoder decoder, DecodeCallBack decodeCallBack) {
        this.f47817n = context.getApplicationContext();
        this.f47806c = decoder;
        this.f47820q = decodeCallBack;
        Map<DecodeHintType, ?> a = m35915a(decoder.getDecodeOptions());
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f47812i = multiFormatReader;
        multiFormatReader.setHints(a);
    }

    /* renamed from: a */
    private Map<DecodeHintType, ?> m35915a(DecodeOptions decodeOptions) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        if (decodeOptions.baseHints != null) {
            enumMap.putAll(decodeOptions.baseHints);
        }
        if (decodeOptions.decodeFormats == null || decodeOptions.decodeFormats.isEmpty()) {
            decodeOptions.decodeFormats = EnumSet.of(BarcodeFormat.QR_CODE);
        }
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, decodeOptions.decodeFormats);
        enumMap.put(DecodeHintType.TRY_HARDER, Boolean.FALSE);
        if (decodeOptions.characterSet != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, decodeOptions.characterSet);
        }
        return enumMap;
    }

    /* renamed from: a */
    public Rect mo119957a() {
        return this.f47807d;
    }

    /* renamed from: a */
    public void mo119959a(Rect rect) {
        String str;
        this.f47807d = rect;
        if (rect == null) {
            str = "null";
        } else {
            str = rect.toString();
        }
        SystemUtils.log(3, f47804a, "setCropRect " + str, (Throwable) null, "com.didi.util.ImageDecoderExecutor", 107);
    }

    /* renamed from: a */
    public void mo119960a(SourceData sourceData, long j) {
        this.f47823t = sourceData;
        this.f47808e = true;
        if (this.f47821r == null) {
            HandlerThread handlerThread = new HandlerThread(f47804a);
            this.f47821r = handlerThread;
            handlerThread.start();
            this.f47822s = new Handler(this.f47821r.getLooper());
            DecodeConfig config = DecodeConfigUtil.getConfig();
            int i = DqrStore.getInstance().getInt(this.f47817n, DqrStoreConstants.KEY_INTERVAL, 100);
            int i2 = 3;
            if (config == null || !config.threadCountRelatedCpu()) {
                this.f47810g = new BalanceExecutor(this.f47817n, 3, 3, 3, 100) {
                    public void onFinish(BalanceRunnable balanceRunnable, long j) {
                        super.onFinish(balanceRunnable, j);
                        ImageDecoderExecutor.this.m35923d();
                        ImageDecoderExecutor.this.m35923d();
                    }
                };
            } else {
                int availableProcessors = Runtime.getRuntime().availableProcessors();
                int i3 = DqrStore.getInstance().getInt(this.f47817n, DqrStoreConstants.KEY_POOLSIZE, 3);
                i2 = Math.max(3, availableProcessors + 2);
                this.f47810g = new BalanceExecutor(this.f47817n, 3, i2, i3, i) {
                    public void onFinish(BalanceRunnable balanceRunnable, long j) {
                        super.onFinish(balanceRunnable, j);
                        ImageDecoderExecutor.this.m35923d();
                        ImageDecoderExecutor.this.m35923d();
                    }
                };
            }
            for (int i4 = 0; i4 < i2; i4++) {
                m35920b(sourceData);
            }
        }
        this.f47816m = SystemClock.elapsedRealtime();
        HashMap hashMap = new HashMap();
        hashMap.put("productId", this.f47818o);
        ScanTrace.trace(ScanTraceId.SCAN_START, hashMap);
        this.f47822s.postDelayed(new Runnable() {
            public void run() {
                if (ImageDecoderExecutor.this.f47820q != null) {
                    ImageDecoderExecutor.this.f47820q.onTimeout();
                }
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m35923d() {
        if (this.f47808e) {
            this.f47822s.post(new Runnable() {
                public void run() {
                    ImageDecoderExecutor imageDecoderExecutor = ImageDecoderExecutor.this;
                    imageDecoderExecutor.m35920b(imageDecoderExecutor.f47823t);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35920b(SourceData sourceData) {
        ZxingRunnable obtain = this.f47810g.obtain();
        if (obtain == null) {
            obtain = new ZxingRunnable(sourceData) {
                public void execute() {
                    try {
                        ImageDecoderExecutor.this.m35922c(getSource());
                    } catch (Exception e) {
                        e.printStackTrace();
                        SystemUtils.log(3, ImageDecoderExecutor.f47804a, "error = " + e.toString(), (Throwable) null, "com.didi.util.ImageDecoderExecutor$5", 189);
                    }
                }
            };
        } else {
            obtain.setSource(sourceData);
        }
        this.f47810g.execute(obtain);
    }

    /* renamed from: b */
    public void mo119962b() {
        this.f47808e = false;
        synchronized (this.f47809f) {
            if (this.f47821r != null) {
                this.f47822s.removeCallbacksAndMessages((Object) null);
                this.f47821r.quit();
                this.f47821r = null;
                this.f47810g.destroy();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("productId", this.f47818o);
        ScanTrace.trace(ScanTraceId.SCAN_STOP, hashMap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LuminanceSource mo119958a(SourceData sourceData) {
        if (this.f47807d == null && sourceData.getCropRect() == null) {
            sourceData.setCropRect(new Rect(0, 0, sourceData.getDataWidth(), sourceData.getDataHeight()));
        }
        return sourceData.createSource();
    }

    /* renamed from: c */
    public void mo119963c() {
        this.f47808e = false;
        DqrStore.getInstance().putAndSave(this.f47817n, DqrStoreConstants.KEY_INTERVAL, this.f47810g.getInitInterval());
        DqrStore.getInstance().putAndSave(this.f47817n, DqrStoreConstants.KEY_POOLSIZE, this.f47810g.getPoolSize());
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010f  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m35922c(com.didi.zxing.barcodescanner.SourceData r15) {
        /*
            r14 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.graphics.Rect r2 = r14.f47807d
            r15.setCropRect(r2)
            com.didi.dqr.LuminanceSource r15 = r14.mo119958a((com.didi.zxing.barcodescanner.SourceData) r15)
            if (r15 == 0) goto L_0x028c
            int[] r2 = com.didi.util.ImageDecoderExecutor.C156666.$SwitchMap$com$didi$dqr$BinarizerEnum
            com.didi.zxing.barcodescanner.Decoder r3 = r14.f47806c
            com.didi.dqr.DecodeOptions r3 = r3.getDecodeOptions()
            com.didi.dqr.BinarizerEnum r3 = r3.binarizer
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto L_0x00d3
            r4 = 2
            if (r2 == r4) goto L_0x00c2
            r4 = 3
            if (r2 == r4) goto L_0x005f
            r4 = 4
            if (r2 == r4) goto L_0x009a
            r4 = 5
            if (r2 == r4) goto L_0x002f
            goto L_0x0050
        L_0x002f:
            boolean r2 = com.didi.dqr.OpenCVBinarizer.isLoadLibraryError()
            if (r2 != 0) goto L_0x0050
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.OpenCV
            com.didi.dqr.OpenCVBinarizer r4 = new com.didi.dqr.OpenCVBinarizer
            r4.<init>(r15)
            com.didi.zxing.barcodescanner.DecodeConfig r15 = com.didi.util.DecodeConfigUtil.getConfig()
            if (r15 == 0) goto L_0x0049
            float r15 = r15.cvBlockSizeFact()
            r4.setBlockSizeFact(r15)
        L_0x0049:
            com.didi.dqr.BinaryBitmap r15 = new com.didi.dqr.BinaryBitmap
            r15.<init>(r4)
            goto L_0x00e5
        L_0x0050:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r5 = new com.didi.dqr.common.HybridBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
        L_0x005c:
            r15 = r4
            goto L_0x00e5
        L_0x005f:
            boolean r2 = com.didi.dqr.OpenCVBinarizer.isLoadLibraryError()
            if (r2 != 0) goto L_0x009a
            com.didi.dqr.BinarizerEnum r2 = r14.f47811h
            com.didi.dqr.BinarizerEnum r4 = com.didi.dqr.BinarizerEnum.OpenCV
            if (r2 != r4) goto L_0x007c
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            r14.f47811h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r5 = new com.didi.dqr.common.HybridBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x007c:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.OpenCV
            r14.f47811h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.OpenCV
            com.didi.dqr.OpenCVBinarizer r4 = new com.didi.dqr.OpenCVBinarizer
            r4.<init>(r15)
            com.didi.zxing.barcodescanner.DecodeConfig r15 = com.didi.util.DecodeConfigUtil.getConfig()
            if (r15 == 0) goto L_0x0094
            float r15 = r15.cvBlockSizeFact()
            r4.setBlockSizeFact(r15)
        L_0x0094:
            com.didi.dqr.BinaryBitmap r15 = new com.didi.dqr.BinaryBitmap
            r15.<init>(r4)
            goto L_0x00e5
        L_0x009a:
            com.didi.dqr.BinarizerEnum r2 = r14.f47811h
            com.didi.dqr.BinarizerEnum r4 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            if (r2 != r4) goto L_0x00b1
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            r14.f47811h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r5 = new com.didi.dqr.common.HybridBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x00b1:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            r14.f47811h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.GlobalHistogramBinarizer r5 = new com.didi.dqr.common.GlobalHistogramBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x00c2:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            r14.f47811h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.GlobalHistogramBinarizer r5 = new com.didi.dqr.common.GlobalHistogramBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x00d3:
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            r14.f47811h = r2
            com.didi.dqr.BinarizerEnum r2 = com.didi.dqr.BinarizerEnum.HybridBinarizer
            com.didi.dqr.BinaryBitmap r4 = new com.didi.dqr.BinaryBitmap
            com.didi.dqr.common.HybridBinarizer r5 = new com.didi.dqr.common.HybridBinarizer
            r5.<init>(r15)
            r4.<init>(r5)
            goto L_0x005c
        L_0x00e5:
            com.didi.dqr.MultiFormatReader r4 = r14.f47812i     // Catch:{ ReaderException -> 0x00f8, all -> 0x00f1 }
            com.didi.dqr.Result r15 = r4.decodeWithState(r15)     // Catch:{ ReaderException -> 0x00f8, all -> 0x00f1 }
            com.didi.dqr.MultiFormatReader r4 = r14.f47812i
            r4.reset()
            goto L_0x00fe
        L_0x00f1:
            r15 = move-exception
            com.didi.dqr.MultiFormatReader r0 = r14.f47812i
            r0.reset()
            throw r15
        L_0x00f8:
            com.didi.dqr.MultiFormatReader r15 = r14.f47812i
            r15.reset()
            r15 = 0
        L_0x00fe:
            if (r15 == 0) goto L_0x0299
            java.lang.String r4 = r15.getText()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0299
            boolean r4 = r14.f47808e
            if (r4 != 0) goto L_0x010f
            return
        L_0x010f:
            java.lang.String r4 = r14.f47814k
            java.lang.String r5 = r15.getText()
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 == 0) goto L_0x012a
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r14.f47815l
            long r4 = r4 - r6
            int r6 = r14.f47813j
            long r6 = (long) r6
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x012a
            return
        L_0x012a:
            java.lang.String r4 = r15.getText()
            r14.f47814k = r4
            long r4 = android.os.SystemClock.elapsedRealtime()
            r14.f47815l = r4
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Found barcode in "
            r6.append(r7)
            long r4 = r4 - r0
            r6.append(r4)
            java.lang.String r0 = " ms"
            r6.append(r0)
            java.lang.String r9 = r6.toString()
            r7 = 3
            r10 = 0
            r12 = 315(0x13b, float:4.41E-43)
            java.lang.String r8 = "ImageDecoderExecutor"
            java.lang.String r11 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "opencv "
            r0.append(r1)
            int r1 = com.didi.dqr.OpenCVBinarizer.blockSize
            r0.append(r1)
            java.lang.String r6 = r0.toString()
            r4 = 3
            r7 = 0
            r9 = 316(0x13c, float:4.43E-43)
            java.lang.String r5 = "ImageDecoderExecutor"
            java.lang.String r8 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "type "
            r0.append(r1)
            java.lang.String r1 = r2.name()
            r0.append(r1)
            java.lang.String r6 = r0.toString()
            r9 = 317(0x13d, float:4.44E-43)
            java.lang.String r5 = "ImageDecoderExecutor"
            java.lang.String r8 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ret "
            r0.append(r1)
            java.lang.String r1 = r15.getText()
            r0.append(r1)
            java.lang.String r6 = r0.toString()
            r9 = 318(0x13e, float:4.46E-43)
            java.lang.String r5 = "ImageDecoderExecutor"
            java.lang.String r8 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            com.didi.util.ImageDecoderExecutor$DecodeCallBack r0 = r14.f47820q
            if (r0 == 0) goto L_0x0288
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r4 = r14.f47816m
            long r0 = r0 - r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.didi.dqr.BinarizerEnum r5 = r14.f47811h
            com.didi.dqr.BinarizerEnum r6 = com.didi.dqr.BinarizerEnum.OpenCV
            java.lang.String r7 = "cvBlockSize"
            if (r5 != r6) goto L_0x01d7
            int r5 = com.didi.dqr.OpenCVBinarizer.blockSize
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.put(r7, r5)
        L_0x01d7:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r6 = ""
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r8 = "cost"
            r4.put(r8, r5)
            java.lang.String r2 = r2.name()
            java.lang.String r5 = "realBinarizerType"
            r4.put(r5, r2)
            int r2 = r15.contourDilateCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r9 = "contourDilateCount"
            r4.put(r9, r2)
            int r2 = r15.realContourDilateCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r10 = "realContourDilateCount"
            r4.put(r10, r2)
            boolean r2 = r15.isQRCode
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r11 = "isQRCode"
            r4.put(r11, r2)
            java.lang.String r2 = r14.f47818o
            java.lang.String r12 = "productId"
            r4.put(r12, r2)
            java.lang.String r2 = "dqr_scan_success"
            com.didi.zxing.barcodescanner.trace.ScanTrace.trace(r2, r4)
            boolean r2 = r14.f47819p
            if (r2 == 0) goto L_0x027b
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.didi.dqr.BinarizerEnum r4 = r14.f47811h
            com.didi.dqr.BinarizerEnum r13 = com.didi.dqr.BinarizerEnum.OpenCV
            if (r4 != r13) goto L_0x023b
            int r4 = com.didi.dqr.OpenCVBinarizer.blockSize
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.put(r7, r4)
        L_0x023b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r6)
            java.lang.String r0 = r4.toString()
            r2.put(r8, r0)
            com.didi.dqr.BinarizerEnum r0 = r14.f47811h
            java.lang.String r0 = r0.name()
            r2.put(r5, r0)
            int r0 = r15.contourDilateCount
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.put(r9, r0)
            int r0 = r15.realContourDilateCount
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.put(r10, r0)
            boolean r0 = r15.isQRCode
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r2.put(r11, r0)
            java.lang.String r0 = r14.f47818o
            r2.put(r12, r0)
            java.lang.String r0 = "dqr_scan_duplicate"
            com.didi.zxing.barcodescanner.trace.ScanTrace.trace(r0, r2)
        L_0x027b:
            r14.f47819p = r3
            com.didi.util.ImageDecoderExecutor$DecodeCallBack r0 = r14.f47820q
            if (r0 == 0) goto L_0x0288
            java.lang.String r15 = r15.getText()
            r0.onResult(r15)
        L_0x0288:
            r14.mo119962b()
            goto L_0x0299
        L_0x028c:
            r1 = 5
            r4 = 0
            r6 = 354(0x162, float:4.96E-43)
            java.lang.String r2 = "ImageDecoderExecutor"
            java.lang.String r3 = "source = null"
            java.lang.String r5 = "com.didi.util.ImageDecoderExecutor"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
        L_0x0299:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.util.ImageDecoderExecutor.m35922c(com.didi.zxing.barcodescanner.SourceData):void");
    }

    /* renamed from: com.didi.util.ImageDecoderExecutor$6 */
    static /* synthetic */ class C156666 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$dqr$BinarizerEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.dqr.BinarizerEnum[] r0 = com.didi.dqr.BinarizerEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$dqr$BinarizerEnum = r0
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.HybridBinarizer     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.GlobalHistogramBinarizer     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.CommixtureWithOpenCV     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.Commixture     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$dqr$BinarizerEnum     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.dqr.BinarizerEnum r1 = com.didi.dqr.BinarizerEnum.OpenCV     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.util.ImageDecoderExecutor.C156666.<clinit>():void");
        }
    }

    /* renamed from: a */
    public void mo119961a(String str) {
        if (str == null) {
            str = "notSet";
        }
        this.f47818o = str;
    }
}
