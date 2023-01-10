package com.didi.payment.utilities.scan.widget;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.didi.dqr.SoLoader;
import com.didi.global.globalgenerickit.utils.UIThreadHandler;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.payment.utilities.scan.collect.CollectionManager;
import com.didi.payment.utilities.scan.utils.PreviewCollectionUtils;
import com.didi.payment.utilities.scan.utils.PreviewImageUtils;
import com.didi.payment.utilities.scan.utils.ZbarSoLoader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import p068me.dm7.barcodescanner.core.BarcodeScannerView;
import p068me.dm7.barcodescanner.core.CameraWrapper;
import p068me.dm7.barcodescanner.zbar.BarcodeFormat;
import p068me.dm7.barcodescanner.zbar.Result;

public class CsI25ZBarScannerView extends BarcodeScannerView {

    /* renamed from: b */
    private static final String f34237b = "ZBarScannerView";

    /* renamed from: a */
    boolean f34238a = false;

    /* renamed from: c */
    private ImageScanner f34239c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ResultHandler f34240d;

    /* renamed from: e */
    private boolean f34241e;

    /* renamed from: f */
    private boolean f34242f;

    /* renamed from: g */
    private Rect f34243g;

    /* renamed from: h */
    private boolean f34244h;

    /* renamed from: i */
    private boolean f34245i;

    /* renamed from: j */
    private volatile boolean f34246j;

    /* renamed from: k */
    private float f34247k;

    /* renamed from: l */
    private int f34248l;

    /* renamed from: m */
    private boolean f34249m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public EventListener f34250n;

    /* renamed from: o */
    private CollectionManager f34251o;

    /* renamed from: p */
    private CameraWrapper f34252p;

    public interface EventListener {
        void onPreviewUploadDone();

        void onQRCodeFound();

        void onScanningActionTracked();
    }

    public interface ResultHandler {
        boolean handleResult(Result result);
    }

    static {
        ZbarSoLoader.load();
        SoLoader.load();
    }

    public CsI25ZBarScannerView(Context context) {
        super(context);
        m26159a();
    }

    public CsI25ZBarScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26159a();
    }

    public void setResultHandler(ResultHandler resultHandler) {
        this.f34240d = resultHandler;
    }

    public void setEventListener(EventListener eventListener) {
        this.f34250n = eventListener;
    }

    public void doUploadOnceInNextPreview() {
        this.f34246j = true;
    }

    /* renamed from: a */
    private void m26159a() {
        if (!ZbarSoLoader.loadSoError) {
            this.f34241e = WalletApolloUtil.getStatus("ibt_wallet_one_barcode_reg_toggle");
            boolean status = WalletApolloUtil.getStatus(CollectionConstant.APOLLO_ID);
            this.f34244h = status;
            if (status) {
                this.f34251o = new CollectionManager();
            }
            boolean boletoScanOptTimeoutFlag = WalletApolloUtil.getBoletoScanOptTimeoutFlag();
            this.f34245i = boletoScanOptTimeoutFlag;
            if (boletoScanOptTimeoutFlag) {
                this.f34247k = WalletApolloUtil.getBoletoScanOptTimeoutRatio();
                this.f34248l = WalletApolloUtil.getBoletoScanOptTimeoutQuality();
            }
            this.f34249m = WalletApolloUtil.getBoletoScanOptQRTipsFlag();
            try {
                ImageScanner imageScanner = new ImageScanner();
                this.f34239c = imageScanner;
                imageScanner.setConfig(0, 256, 1);
                this.f34239c.setConfig(0, 257, 1);
                this.f34239c.setConfig(0, 0, 0);
                this.f34239c.setConfig(25, 0, 1);
                this.f34239c.setConfig(38, 0, 1);
                this.f34239c.setConfig(128, 0, 1);
                this.f34239c.setConfig(25, 32, 44);
                this.f34239c.setConfig(38, 32, 44);
                this.f34239c.setConfig(128, 32, 44);
                if (this.f34249m) {
                    this.f34239c.setConfig(64, 0, 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                ZbarSoLoader.loadSoError = true;
                HashMap hashMap = new HashMap();
                hashMap.put("error", th.getCause());
                PayTracker.trackEvent("ibt_gp_scan_zbar_so_load_error_bt", hashMap);
            }
            setAutoFocus(true);
        }
    }

    public void setMexicoScannerType(int i, int i2) {
        this.f34238a = true;
        if (i <= 0) {
            i = 10;
        }
        if (i2 <= 0) {
            i2 = 33;
        }
        for (BarcodeFormat next : BarcodeFormat.ALL_FORMATS) {
            this.f34239c.setConfig(next.getId(), 0, 1);
            this.f34239c.setConfig(next.getId(), 32, i);
            this.f34239c.setConfig(next.getId(), 33, i2);
        }
    }

    public void setupCameraPreview(CameraWrapper cameraWrapper) {
        super.setupCameraPreview(cameraWrapper);
        this.f34252p = cameraWrapper;
    }

    public void stopCamera() {
        super.stopCamera();
        this.f34252p = null;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int i;
        BarcodeFormat barcodeFormat;
        if (this.f34240d != null && !ZbarSoLoader.loadSoError) {
            try {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                int i2 = previewSize.width;
                int i3 = previewSize.height;
                PreviewImageUtils.BarcodeFeatureModel b = m26163b(bArr, i2, i3);
                Rect rect = (b == null || b.rect == null) ? this.f34243g : b.rect;
                this.f34243g = rect;
                if (rect != null) {
                    byte[] clipData = PreviewImageUtils.clipData(bArr, i2, i3, rect.left, this.f34243g.top, this.f34243g.width(), this.f34243g.height());
                    Image image = new Image(this.f34243g.width(), this.f34243g.height(), "Y800");
                    image.setData(clipData);
                    i = this.f34239c.scanImage(image);
                    if (i != 0) {
                        System.out.println("crop hit!!!!!!!!!");
                    }
                } else {
                    i = 0;
                }
                if (i == 0) {
                    Image image2 = new Image(i2, i3, "Y800");
                    image2.setData(bArr);
                    i = this.f34239c.scanImage(image2);
                }
                if (this.f34246j) {
                    m26161a(bArr, i2, i3);
                }
                if (i == 0) {
                    m26162a(bArr, i2, i3, b, false);
                    camera.setOneShotPreviewCallback(this);
                    return;
                }
                Result b2 = m26165b();
                if (TextUtils.isEmpty(b2.getContents())) {
                    m26162a(bArr, i2, i3, b, false);
                    camera.setOneShotPreviewCallback(this);
                } else if ((this.f34249m || this.f34238a) && (barcodeFormat = b2.getBarcodeFormat()) != null && barcodeFormat.getId() == 64) {
                    m26166c();
                    m26162a(bArr, i2, i3, b, false);
                    camera.setOneShotPreviewCallback(this);
                } else {
                    m26162a(bArr, i2, i3, b, true);
                    if (!this.f34242f) {
                        this.f34242f = true;
                        PayTracker.getTracker().trackEvent("ibt_boleto_scan_scanning_action_bt");
                    }
                    m26160a(b2);
                }
            } catch (Throwable th) {
                this.f34241e = false;
                this.f34244h = false;
                this.f34251o = null;
                try {
                    camera.setOneShotPreviewCallback(this);
                } catch (Exception unused) {
                }
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m26161a(byte[] bArr, int i, int i2) {
        this.f34246j = false;
        if (this.f34245i) {
            String compressData = PreviewCollectionUtils.compressData(bArr, i, i2, this.f34247k, this.f34248l);
            HashMap hashMap = new HashMap();
            hashMap.put("data", compressData);
            hashMap.put("action_tracked", Integer.valueOf(this.f34242f ? 1 : 0));
            PayTracker.trackEvent("ibt_boleto_scan_preview_upload_once_bt", hashMap);
            m26168e();
        }
    }

    /* renamed from: a */
    private void m26162a(byte[] bArr, int i, int i2, PreviewImageUtils.BarcodeFeatureModel barcodeFeatureModel, boolean z) {
        CollectionManager collectionManager;
        if (this.f34244h && (collectionManager = this.f34251o) != null) {
            collectionManager.collectIfNeeded(bArr, i, i2, barcodeFeatureModel != null && barcodeFeatureModel.hasBarcodeFeature, z);
        }
    }

    /* renamed from: b */
    private PreviewImageUtils.BarcodeFeatureModel m26163b(byte[] bArr, int i, int i2) {
        if (SoLoader.loadLibraryError || !this.f34241e) {
            return null;
        }
        PreviewImageUtils.BarcodeFeatureModel checkOneBarcodeFeature = PreviewImageUtils.checkOneBarcodeFeature(bArr, i, i2);
        if (!this.f34242f && checkOneBarcodeFeature != null && checkOneBarcodeFeature.hasBarcodeFeature) {
            this.f34242f = true;
            System.out.println("scanning barcode!!!!!!!!!!!!!!!");
            PayTracker.getTracker().trackEvent("ibt_boleto_scan_scanning_action_bt");
            PayTracker.getTracker().trackEvent("ibt_boleto_scan_scanning_real_bt");
            m26167d();
        }
        return checkOneBarcodeFeature;
    }

    /* renamed from: b */
    private Result m26165b() {
        String str;
        Result result = new Result();
        Iterator<Symbol> it = this.f34239c.getResults().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Symbol next = it.next();
            if (Build.VERSION.SDK_INT >= 19) {
                str = new String(next.getDataBytes(), StandardCharsets.UTF_8);
            } else {
                str = next.getData();
            }
            if (!TextUtils.isEmpty(str)) {
                result.setContents(str);
                result.setBarcodeFormat(BarcodeFormat.getFormatById(next.getType()));
                break;
            }
        }
        return result;
    }

    /* renamed from: a */
    private void m26160a(final Result result) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (CsI25ZBarScannerView.this.f34240d != null && CsI25ZBarScannerView.this.f34240d.handleResult(result)) {
                    CsI25ZBarScannerView.this.stopCameraPreview();
                    ResultHandler unused = CsI25ZBarScannerView.this.f34240d = null;
                }
            }
        });
    }

    public void resumeCameraPreview(ResultHandler resultHandler) {
        this.f34240d = resultHandler;
        super.resumeCameraPreview();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f34251o;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasCollectedData() {
        /*
            r1 = this;
            boolean r0 = r1.f34244h
            if (r0 == 0) goto L_0x0010
            com.didi.payment.utilities.scan.collect.CollectionManager r0 = r1.f34251o
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.hasCollectedData()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.utilities.scan.widget.CsI25ZBarScannerView.hasCollectedData():boolean");
    }

    public void dumpCollectedData(boolean z) {
        CollectionManager collectionManager;
        if (this.f34244h && (collectionManager = this.f34251o) != null) {
            collectionManager.dump(z);
        }
    }

    /* renamed from: c */
    private void m26166c() {
        UIThreadHandler.post(new Runnable() {
            public void run() {
                if (CsI25ZBarScannerView.this.f34250n != null) {
                    CsI25ZBarScannerView.this.f34250n.onQRCodeFound();
                }
            }
        });
    }

    /* renamed from: d */
    private void m26167d() {
        UIThreadHandler.post(new Runnable() {
            public void run() {
                if (CsI25ZBarScannerView.this.f34250n != null) {
                    CsI25ZBarScannerView.this.f34250n.onScanningActionTracked();
                }
            }
        });
    }

    /* renamed from: e */
    private void m26168e() {
        UIThreadHandler.post(new Runnable() {
            public void run() {
                if (CsI25ZBarScannerView.this.f34250n != null) {
                    CsI25ZBarScannerView.this.f34250n.onPreviewUploadDone();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setZoom(boolean z) {
        Camera camera;
        Camera.Parameters parameters;
        CameraWrapper cameraWrapper = this.f34252p;
        if (cameraWrapper != null && (camera = cameraWrapper.mCamera) != null && (parameters = camera.getParameters()) != null && parameters.isZoomSupported()) {
            int maxZoom = parameters.getMaxZoom();
            int zoom = parameters.getZoom();
            if (z && zoom < maxZoom) {
                zoom++;
            } else if (zoom > 0) {
                zoom--;
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
        }
    }
}
