package p068me.dm7.barcodescanner.zbar;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.didi.sdk.apm.SystemUtils;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import net.sourceforge.zbar.SymbolSet;
import p068me.dm7.barcodescanner.core.BarcodeScannerView;
import p068me.dm7.barcodescanner.core.DisplayUtils;

/* renamed from: me.dm7.barcodescanner.zbar.ZBarScannerView */
public class ZBarScannerView extends BarcodeScannerView {

    /* renamed from: a */
    private static final String f6628a = "ZBarScannerView";

    /* renamed from: b */
    private ImageScanner f6629b;

    /* renamed from: c */
    private List<BarcodeFormat> f6630c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ResultHandler f6631d;

    /* renamed from: me.dm7.barcodescanner.zbar.ZBarScannerView$ResultHandler */
    public interface ResultHandler {
        void handleResult(Result result);
    }

    static {
        System.loadLibrary("iconv");
    }

    public ZBarScannerView(Context context) {
        super(context);
        setupScanner();
    }

    public ZBarScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupScanner();
    }

    public void setFormats(List<BarcodeFormat> list) {
        this.f6630c = list;
        setupScanner();
    }

    public void setResultHandler(ResultHandler resultHandler) {
        this.f6631d = resultHandler;
    }

    public Collection<BarcodeFormat> getFormats() {
        List<BarcodeFormat> list = this.f6630c;
        return list == null ? BarcodeFormat.ALL_FORMATS : list;
    }

    public void setupScanner() {
        ImageScanner imageScanner = new ImageScanner();
        this.f6629b = imageScanner;
        imageScanner.setConfig(0, 256, 3);
        this.f6629b.setConfig(0, 257, 3);
        this.f6629b.setConfig(0, 0, 0);
        for (BarcodeFormat id : getFormats()) {
            this.f6629b.setConfig(id.getId(), 0, 1);
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        String str;
        if (this.f6631d != null) {
            try {
                Camera.Size previewSize = camera.getParameters().getPreviewSize();
                int i = previewSize.width;
                int i2 = previewSize.height;
                if (DisplayUtils.getScreenOrientation(getContext()) == 1) {
                    int rotationCount = getRotationCount();
                    if (rotationCount == 1 || rotationCount == 3) {
                        int i3 = i;
                        i = i2;
                        i2 = i3;
                    }
                    bArr = getRotatedData(bArr, camera);
                }
                Rect framingRectInPreview = getFramingRectInPreview(i, i2);
                Image image = new Image(i, i2, "Y800");
                image.setData(bArr);
                image.setCrop(framingRectInPreview.left, framingRectInPreview.top, framingRectInPreview.width(), framingRectInPreview.height());
                if (this.f6629b.scanImage(image) != 0) {
                    SymbolSet results = this.f6629b.getResults();
                    final Result result = new Result();
                    Iterator<Symbol> it = results.iterator();
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
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            ResultHandler a = ZBarScannerView.this.f6631d;
                            ResultHandler unused = ZBarScannerView.this.f6631d = null;
                            ZBarScannerView.this.stopCameraPreview();
                            if (a != null) {
                                a.handleResult(result);
                            }
                        }
                    });
                    return;
                }
                camera.setOneShotPreviewCallback(this);
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                SystemUtils.log(6, f6628a, runtimeException.toString(), runtimeException, "me.dm7.barcodescanner.zbar.ZBarScannerView", 149);
            }
        }
    }

    public void resumeCameraPreview(ResultHandler resultHandler) {
        this.f6631d = resultHandler;
        super.resumeCameraPreview();
    }
}
