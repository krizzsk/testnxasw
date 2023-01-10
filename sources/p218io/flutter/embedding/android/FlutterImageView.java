package p218io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.Locale;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.renderer.FlutterRenderer;
import p218io.flutter.embedding.engine.renderer.RenderSurface;

/* renamed from: io.flutter.embedding.android.FlutterImageView */
public class FlutterImageView extends View implements RenderSurface {

    /* renamed from: a */
    private static final String f60196a = "FlutterImageView";

    /* renamed from: b */
    private ImageReader f60197b;

    /* renamed from: c */
    private Image f60198c;

    /* renamed from: d */
    private Bitmap f60199d;

    /* renamed from: e */
    private FlutterRenderer f60200e;

    /* renamed from: f */
    private SurfaceKind f60201f;

    /* renamed from: g */
    private boolean f60202g;

    /* renamed from: io.flutter.embedding.android.FlutterImageView$SurfaceKind */
    public enum SurfaceKind {
        background,
        overlay
    }

    public void pause() {
    }

    public ImageReader getImageReader() {
        return this.f60197b;
    }

    public FlutterImageView(Context context, int i, int i2, SurfaceKind surfaceKind) {
        this(context, m45430a(i, i2), surfaceKind);
    }

    public FlutterImageView(Context context) {
        this(context, 1, 1, SurfaceKind.background);
    }

    public FlutterImageView(Context context, AttributeSet attributeSet) {
        this(context, 1, 1, SurfaceKind.background);
    }

    FlutterImageView(Context context, ImageReader imageReader, SurfaceKind surfaceKind) {
        super(context, (AttributeSet) null);
        this.f60202g = false;
        this.f60197b = imageReader;
        this.f60201f = surfaceKind;
        m45431a();
    }

    /* renamed from: a */
    private void m45431a() {
        setAlpha(0.0f);
    }

    /* renamed from: a */
    private static void m45432a(String str, Object... objArr) {
        Log.m45261w(f60196a, String.format(Locale.US, str, objArr));
    }

    /* renamed from: a */
    private static ImageReader m45430a(int i, int i2) {
        int i3;
        int i4;
        if (i <= 0) {
            m45432a("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i));
            i3 = 1;
        } else {
            i3 = i;
        }
        if (i2 <= 0) {
            m45432a("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i2));
            i4 = 1;
        } else {
            i4 = i2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return ImageReader.newInstance(i3, i4, 1, 3, 768);
        }
        return ImageReader.newInstance(i3, i4, 1, 3);
    }

    public Surface getSurface() {
        return this.f60197b.getSurface();
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.f60200e;
    }

    /* renamed from: io.flutter.embedding.android.FlutterImageView$1 */
    static /* synthetic */ class C220451 {

        /* renamed from: $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind */
        static final /* synthetic */ int[] f60203x435d6649;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.flutter.embedding.android.FlutterImageView$SurfaceKind[] r0 = p218io.flutter.embedding.android.FlutterImageView.SurfaceKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f60203x435d6649 = r0
                io.flutter.embedding.android.FlutterImageView$SurfaceKind r1 = p218io.flutter.embedding.android.FlutterImageView.SurfaceKind.background     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f60203x435d6649     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.android.FlutterImageView$SurfaceKind r1 = p218io.flutter.embedding.android.FlutterImageView.SurfaceKind.overlay     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterImageView.C220451.<clinit>():void");
        }
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer) {
        if (C220451.f60203x435d6649[this.f60201f.ordinal()] == 1) {
            flutterRenderer.swapSurface(this.f60197b.getSurface());
        }
        setAlpha(1.0f);
        this.f60200e = flutterRenderer;
        this.f60202g = true;
    }

    public void detachFromRenderer() {
        if (this.f60202g) {
            setAlpha(0.0f);
            acquireLatestImage();
            this.f60199d = null;
            m45433b();
            invalidate();
            this.f60202g = false;
        }
    }

    public boolean acquireLatestImage() {
        if (!this.f60202g) {
            return false;
        }
        Image acquireLatestImage = this.f60197b.acquireLatestImage();
        if (acquireLatestImage != null) {
            m45433b();
            this.f60198c = acquireLatestImage;
            invalidate();
        }
        if (acquireLatestImage != null) {
            return true;
        }
        return false;
    }

    public void resizeIfNeeded(int i, int i2) {
        if (this.f60200e != null) {
            if (i != this.f60197b.getWidth() || i2 != this.f60197b.getHeight()) {
                m45433b();
                closeImageReader();
                this.f60197b = m45430a(i, i2);
            }
        }
    }

    public void closeImageReader() {
        this.f60197b.close();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f60198c != null) {
            m45434c();
        }
        Bitmap bitmap = this.f60199d;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    /* renamed from: b */
    private void m45433b() {
        Image image = this.f60198c;
        if (image != null) {
            image.close();
            this.f60198c = null;
        }
    }

    /* renamed from: c */
    private void m45434c() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.f60198c.getHardwareBuffer();
            this.f60199d = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f60198c.getPlanes();
        if (planes.length == 1) {
            Image.Plane plane = planes[0];
            int rowStride = plane.getRowStride() / plane.getPixelStride();
            int height = this.f60198c.getHeight();
            Bitmap bitmap = this.f60199d;
            if (!(bitmap != null && bitmap.getWidth() == rowStride && this.f60199d.getHeight() == height)) {
                this.f60199d = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
            }
            ByteBuffer buffer = plane.getBuffer();
            buffer.rewind();
            this.f60199d.copyPixelsFromBuffer(buffer);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == this.f60197b.getWidth() && i2 == this.f60197b.getHeight()) && this.f60201f == SurfaceKind.background && this.f60202g) {
            resizeIfNeeded(i, i2);
            this.f60200e.swapSurface(this.f60197b.getSurface());
        }
    }
}
