package jumio.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.didi.raven.config.RavenKey;
import com.google.common.base.Ascii;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.barcode.BaseBarcodeClient;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import com.microblink.blinkbarcode.MicroblinkSDK;
import com.microblink.blinkbarcode.directApi.DirectApiErrorListener;
import com.microblink.blinkbarcode.directApi.RecognizerRunner;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.entities.recognizers.blinkbarcode.barcode.BarcodeRecognizer;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.image.Image;
import com.microblink.blinkbarcode.image.ImageBuilder;
import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;
import java.nio.charset.Charset;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: jumio.barcode.a */
/* compiled from: BarcodeClient.kt */
public final class C19460a extends BaseBarcodeClient implements ScanResultListener {

    /* renamed from: j */
    public static final C19461a f55304j = new C19461a((DefaultConstructorMarker) null);

    /* renamed from: k */
    public static final String f55305k = C19460a.class.getSimpleName();

    /* renamed from: a */
    public final Object f55306a = new Object();

    /* renamed from: b */
    public PreviewProperties f55307b;

    /* renamed from: c */
    public Rect f55308c;

    /* renamed from: d */
    public RecognizerBundle f55309d = new RecognizerBundle(new Recognizer[0]);

    /* renamed from: e */
    public RecognizerRunner f55310e;

    /* renamed from: f */
    public BarcodeRecognizer f55311f;

    /* renamed from: g */
    public int f55312g;

    /* renamed from: h */
    public int f55313h;

    /* renamed from: i */
    public Image f55314i;

    /* renamed from: jumio.barcode.a$a */
    /* compiled from: BarcodeClient.kt */
    public static final class C19461a {
        public C19461a() {
        }

        public /* synthetic */ C19461a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public final boolean mo148596a(Context context, DataManager dataManager) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dataManager, "dataManager");
            try {
                String barcodeScannerKey = ((SettingsModel) dataManager.get(SettingsModel.class)).getBarcodeScannerKey();
                if (barcodeScannerKey != null) {
                    MicroblinkSDK.setLicenseKey(barcodeScannerKey, StringDeobfuscator.deobfuscate(new byte[]{49, 106, 69, Ascii.f55140EM, 49}, 2707057876264250875L), context);
                    return true;
                }
                throw new Exception("No license found for barcode scanning, please set one!");
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C19460a(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    public static final void m41109a(C19460a aVar, Throwable th) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Intrinsics.checkNotNullParameter(th, RavenKey.TYPE);
        Log.m43651e(f55305k, "Failed to initialize recognizer.", th);
        aVar.f55310e = null;
        aVar.publishError(new Error(ErrorCase.OCR_LOADING_FAILED, 0, 0, 6, (DefaultConstructorMarker) null));
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        Intrinsics.checkNotNullParameter(staticModel, "configurationModel");
        synchronized (this.f55306a) {
            try {
                super.configure(dataManager, staticModel);
                C19461a aVar = f55304j;
                Context context = this.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (aVar.mo148596a(context, dataManager)) {
                    com.microblink.blinkbarcode.util.Log.setLogLevel(Log.LogLevel.LOG_QUIET);
                    BarcodeRecognizer barcodeRecognizer = new BarcodeRecognizer();
                    barcodeRecognizer.setScanPdf417(true);
                    barcodeRecognizer.setNullQuietZoneAllowed(true);
                    barcodeRecognizer.setScanUncertain(true);
                    barcodeRecognizer.setAutoScaleDetection(true);
                    Unit unit = Unit.INSTANCE;
                    this.f55311f = barcodeRecognizer;
                    this.f55309d = new RecognizerBundle(barcodeRecognizer);
                    RecognizerRunner singletonInstance = RecognizerRunner.getSingletonInstance();
                    this.f55310e = singletonInstance;
                    Intrinsics.checkNotNull(singletonInstance);
                    singletonInstance.initialize(this.context, this.f55309d, new DirectApiErrorListener() {
                        public final void onRecognizerError(Throwable th) {
                            C19460a.m41109a(C19460a.this, th);
                        }
                    });
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    throw new Exception("License not valid");
                }
            } catch (Exception e) {
                com.jumio.commons.log.Log.m43651e(f55305k, "Failed to configure", (Throwable) e);
                this.f55310e = null;
                publishError(new Error(ErrorCase.OCR_LOADING_FAILED, 0, 0, 6, (DefaultConstructorMarker) null));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void destroy() {
        synchronized (this.f55306a) {
            RecognizerRunner recognizerRunner = this.f55310e;
            if (recognizerRunner != null) {
                recognizerRunner.terminate();
            }
            this.f55310e = null;
            this.f55311f = null;
            Unit unit = Unit.INSTANCE;
        }
        super.destroy();
    }

    public void init(PreviewProperties previewProperties, Rect rect) {
        super.init(previewProperties, rect);
        synchronized (this.f55306a) {
            RecognizerRunner recognizerRunner = this.f55310e;
            if (recognizerRunner != null) {
                recognizerRunner.resetRecognitionState();
            }
            this.imageSource = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onScanningDone(RecognitionSuccessType recognitionSuccessType) {
        String str;
        Intrinsics.checkNotNullParameter(recognitionSuccessType, "recognitionSuccessType");
        Image image = this.f55314i;
        if (image != null) {
            try {
                image.dispose();
                this.f55314i = null;
            } catch (Exception e) {
                com.jumio.commons.log.Log.m43646d(f55305k, "Exception during disposing the image!", (Throwable) e);
            }
        }
        com.jumio.commons.log.Log.m43645d(f55305k, Intrinsics.stringPlus("Photopay ", recognitionSuccessType));
        boolean z = false;
        if (recognitionSuccessType == RecognitionSuccessType.SUCCESSFUL) {
            BarcodeRecognizer barcodeRecognizer = this.f55311f;
            Intrinsics.checkNotNull(barcodeRecognizer);
            Entity.Result result = barcodeRecognizer.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "barcodeRecognizer!!.result");
            BarcodeRecognizer.Result result2 = (BarcodeRecognizer.Result) result;
            ImageSource imageSource = this.imageSource;
            PreviewProperties previewProperties = this.f55307b;
            Intrinsics.checkNotNull(previewProperties);
            Bitmap yuv2bitmap = CameraUtils.yuv2bitmap(imageSource, previewProperties.isPortrait, this.f55307b, this.f55308c, -1);
            try {
                byte[] rawData = result2.getRawData();
                Intrinsics.checkNotNullExpressionValue(rawData, "result.rawData");
                Charset forName = Charset.forName("ISO-8859-1");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(\"ISO-8859-1\")");
                str = new String(rawData, forName);
            } catch (Exception unused) {
                byte[] rawData2 = result2.getRawData();
                Intrinsics.checkNotNullExpressionValue(rawData2, "result.rawData");
                str = new String(rawData2, Charsets.UTF_8);
            }
            z = onFinished(str, yuv2bitmap, this.f55312g, this.f55313h);
        }
        synchronized (this.f55306a) {
            RecognizerRunner recognizerRunner = this.f55310e;
            if (recognizerRunner != null) {
                recognizerRunner.resetRecognitionState();
            }
            setResult(z);
            this.imageSource = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onUnrecoverableError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        com.jumio.commons.log.Log.m43666w(f55305k, "Barcode scanning failed with exception!", th);
        publishError(new Error(ErrorCase.OCR_LOADING_FAILED, 0, 0, 6, (DefaultConstructorMarker) null));
    }

    public void process(ImageSource imageSource, PreviewProperties previewProperties, Rect rect) {
        Intrinsics.checkNotNullParameter(imageSource, "data");
        Intrinsics.checkNotNullParameter(previewProperties, "previewProperties");
        Intrinsics.checkNotNullParameter(rect, "extractionArea");
        byte[] bytes = imageSource.getImage().toBytes();
        Size size = previewProperties.camera;
        this.f55312g = size.width;
        this.f55313h = size.height;
        this.f55307b = previewProperties;
        this.f55308c = rect;
        synchronized (this.f55306a) {
            this.imageSource = imageSource;
            this.f55314i = ImageBuilder.buildImageFromCamera1NV21Frame(bytes, this.f55312g, this.f55313h, Orientation.ORIENTATION_LANDSCAPE_LEFT, (Rectangle) null);
            try {
                RecognizerRunner recognizerRunner = this.f55310e;
                if ((recognizerRunner == null ? null : recognizerRunner.getCurrentState()) != RecognizerRunner.State.READY) {
                    RecognizerRunner recognizerRunner2 = this.f55310e;
                    if (recognizerRunner2 != null) {
                        recognizerRunner2.cancel();
                    }
                }
                RecognizerRunner recognizerRunner3 = this.f55310e;
                Intrinsics.checkNotNull(recognizerRunner3);
                Image image = this.f55314i;
                Intrinsics.checkNotNull(image);
                recognizerRunner3.recognizeImage(image, this);
            } catch (Exception e) {
                com.jumio.commons.log.Log.m43651e(f55305k, "Exception during recognizing the image!", (Throwable) e);
                RecognizerRunner recognizerRunner4 = this.f55310e;
                if (recognizerRunner4 != null) {
                    recognizerRunner4.resetRecognitionState();
                }
                RecognizerRunner recognizerRunner5 = this.f55310e;
                if (recognizerRunner5 != null) {
                    recognizerRunner5.cancel();
                }
                this.imageSource = null;
                setResult(false);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean shouldFeed() {
        boolean z;
        synchronized (this.f55306a) {
            z = this.f55310e != null && this.imageSource == null;
        }
        return z;
    }
}
