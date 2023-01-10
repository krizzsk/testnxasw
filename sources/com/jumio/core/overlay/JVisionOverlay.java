package com.jumio.core.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.jumio.commons.utils.DrawingUtil;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.MobileContext;
import com.jumio.core.data.ScanMode;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.models.IDScanPartModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.sdk.enums.JumioScanSide;
import com.taxis99.R;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001b¢\u0006\u0004\bv\u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0016\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018H\u0016R\"\u0010\"\u001a\u00020\u001b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010'\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b'\u0010$R\"\u0010-\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b(\u0010$\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b.\u0010$R\u0016\u0010/\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b/\u0010$R\u0016\u00100\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b0\u0010$R\u0016\u00101\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b1\u0010$R\u0016\u00102\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b2\u0010$R\"\u00106\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b3\u0010$\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R\"\u0010:\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b7\u0010$\u001a\u0004\b8\u0010*\"\u0004\b9\u0010,R\u0016\u0010;\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b;\u0010$R\u0016\u0010<\u001a\u00020\u00128\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b<\u0010$R\u0016\u0010>\u001a\u00020=8\u0004@\u0005X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010C\u001a\u00020=8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b@\u0010?\u001a\u0004\bA\u0010BR\u001c\u0010F\u001a\u00020=8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bE\u0010BR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR$\u0010Q\u001a\u0004\u0018\u00010J8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Y\u001a\u00020R8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\\\u0010[R\u0016\u0010]\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b]\u0010[R\u0016\u0010^\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b^\u0010$R\u0016\u0010_\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b_\u0010$R\"\u0010c\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b`\u0010$\u001a\u0004\ba\u0010*\"\u0004\bb\u0010,R\"\u0010g\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bd\u0010$\u001a\u0004\be\u0010*\"\u0004\bf\u0010,R\u0016\u0010\u0013\u001a\u00020h8\u0004@\u0005X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010iR(\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120j8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u001c\u0010r\u001a\u00020\u00128\u0004@\u0004XD¢\u0006\f\n\u0004\bp\u0010$\u001a\u0004\bq\u0010*R\u0016\u0010u\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bs\u0010t¨\u0006w"}, mo148868d2 = {"Lcom/jumio/core/overlay/JVisionOverlay;", "Lcom/jumio/core/overlay/Overlay;", "Landroid/graphics/Rect;", "extractionArea", "", "calculate", "Landroid/view/ViewGroup;", "rootView", "addViews", "Lcom/jumio/core/models/ScanPartModel;", "scanPartModel", "setScanPart", "Landroid/content/Context;", "context", "updateOverlayConfiguration", "", "isFrontCamera", "prepareDraw", "", "visibility", "setVisible", "Landroid/graphics/Canvas;", "canvas", "doDraw", "Lcom/jumio/core/extraction/ExtractionClient$ExtractionUpdate;", "extractionUpdate", "update", "Lcom/jumio/core/MobileContext;", "a", "Lcom/jumio/core/MobileContext;", "getMobileContext", "()Lcom/jumio/core/MobileContext;", "setMobileContext", "(Lcom/jumio/core/MobileContext;)V", "mobileContext", "overlayLeftMargin", "I", "overlayRightMargin", "overlayTopMargin", "overlayBottomMargin", "b", "getOverlayWidth", "()I", "setOverlayWidth", "(I)V", "overlayWidth", "overlayHeight", "overlayTopPixel", "overlayBottomPixel", "overlayLeftPixel", "overlayRightPixel", "c", "getTopOffset", "setTopOffset", "topOffset", "d", "getLeftOffset", "setLeftOffset", "leftOffset", "width", "height", "Landroid/graphics/Paint;", "borderPaint", "Landroid/graphics/Paint;", "e", "getLargeBorderPaint", "()Landroid/graphics/Paint;", "largeBorderPaint", "f", "getBackgroundPaint", "backgroundPaint", "Lcom/jumio/core/data/ScanMode;", "scanMode", "Lcom/jumio/core/data/ScanMode;", "Lcom/jumio/sdk/enums/JumioScanSide;", "k", "Lcom/jumio/sdk/enums/JumioScanSide;", "getScanSide", "()Lcom/jumio/sdk/enums/JumioScanSide;", "setScanSide", "(Lcom/jumio/sdk/enums/JumioScanSide;)V", "scanSide", "Lcom/jumio/core/data/document/DocumentFormat;", "l", "Lcom/jumio/core/data/document/DocumentFormat;", "getDocumentFormat", "()Lcom/jumio/core/data/document/DocumentFormat;", "setDocumentFormat", "(Lcom/jumio/core/data/document/DocumentFormat;)V", "documentFormat", "dimBackground", "Z", "drawBrackets", "detectLines", "topLeftCornerRadius", "topRightCornerRadius", "m", "getBottomLeftCornerRadius", "setBottomLeftCornerRadius", "bottomLeftCornerRadius", "n", "getBottomRightCornerRadius", "setBottomRightCornerRadius", "bottomRightCornerRadius", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "", "p", "Ljava/util/Map;", "getStyleMap", "()Ljava/util/Map;", "styleMap", "q", "getCORNER_RADIUS_IN_DP", "CORNER_RADIUS_IN_DP", "getOverlayBounds", "()Landroid/graphics/Rect;", "overlayBounds", "<init>", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: JVisionOverlay.kt */
public class JVisionOverlay implements Overlay {

    /* renamed from: a */
    public MobileContext f57762a;

    /* renamed from: b */
    public int f57763b;
    public final Paint borderPaint = new Paint();

    /* renamed from: c */
    public int f57764c;

    /* renamed from: d */
    public int f57765d;
    public boolean detectLines;
    public boolean dimBackground;
    public boolean drawBrackets;

    /* renamed from: e */
    public final Paint f57766e = new Paint();

    /* renamed from: f */
    public final Paint f57767f = new Paint();

    /* renamed from: g */
    public Path f57768g = new Path();

    /* renamed from: h */
    public Path f57769h = new Path();
    public int height;

    /* renamed from: i */
    public Path f57770i = new Path();

    /* renamed from: j */
    public Path f57771j = new Path();

    /* renamed from: k */
    public JumioScanSide f57772k;

    /* renamed from: l */
    public DocumentFormat f57773l = DocumentFormat.NONE;

    /* renamed from: m */
    public int f57774m;

    /* renamed from: n */
    public int f57775n;

    /* renamed from: o */
    public boolean f57776o;
    public int overlayBottomMargin;
    public int overlayBottomPixel;
    public int overlayHeight;
    public int overlayLeftMargin;
    public int overlayLeftPixel;
    public int overlayRightMargin;
    public int overlayRightPixel;
    public int overlayTopMargin;
    public int overlayTopPixel;

    /* renamed from: p */
    public final Map<Integer, Integer> f57777p = Overlay.Companion.getCustomizations$jumio_core_release(this.f57762a);

    /* renamed from: q */
    public final int f57778q = 16;
    public ScanMode scanMode;
    public int topLeftCornerRadius;
    public int topRightCornerRadius;
    public final AtomicInteger visibility = new AtomicInteger();
    public int width;

    /* renamed from: com.jumio.core.overlay.JVisionOverlay$a */
    /* compiled from: JVisionOverlay.kt */
    public /* synthetic */ class C20986a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f57779a;

        static {
            int[] iArr = new int[DocumentFormat.values().length];
            iArr[DocumentFormat.NONE.ordinal()] = 1;
            iArr[DocumentFormat.ID1.ordinal()] = 2;
            iArr[DocumentFormat.ID2.ordinal()] = 3;
            iArr[DocumentFormat.ID3.ordinal()] = 4;
            f57779a = iArr;
        }
    }

    public JVisionOverlay(MobileContext mobileContext) {
        Intrinsics.checkNotNullParameter(mobileContext, "mobileContext");
        this.f57762a = mobileContext;
    }

    public void addViews(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
    }

    public void calculate(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "extractionArea");
        this.width = rect.width();
        int height2 = rect.height();
        this.height = height2;
        int i = 0;
        boolean z = ((float) this.width) / ((float) height2) >= 1.3333334f;
        int i2 = C20986a.f57779a[this.f57773l.ordinal()];
        if (i2 == 1) {
            this.overlayLeftPixel = 0;
            this.overlayTopPixel = 0;
            this.overlayRightPixel = this.width;
            this.overlayBottomPixel = this.height;
        } else if (i2 == 2 || i2 == 3) {
            if (z) {
                int i3 = this.height;
                this.overlayHeight = i3;
                int i4 = (i3 * 4) / 3;
                this.f57763b = i4;
                this.f57764c = rect.top;
                this.f57765d = ((this.width - i4) / 2) + rect.left;
            } else {
                int i5 = this.width;
                this.f57763b = i5;
                int i6 = (i5 * 3) / 4;
                this.overlayHeight = i6;
                this.f57764c = ((this.height - i6) / 2) + rect.top;
                this.f57765d = rect.left;
            }
            this.overlayLeftMargin = this.f57773l.getOverlayLeftInPx(this.f57763b);
            this.overlayRightMargin = this.f57773l.getOverlayRightInPx(this.f57763b);
            this.overlayTopMargin = this.f57773l.getOverlayTopInPx(this.overlayHeight);
            int overlayBottomInPx = this.f57773l.getOverlayBottomInPx(this.overlayHeight);
            this.overlayBottomMargin = overlayBottomInPx;
            int i7 = this.width;
            int i8 = this.overlayRightMargin;
            int i9 = this.f57765d;
            this.overlayRightPixel = i7 - (i8 + i9);
            int i10 = this.height;
            int i11 = this.f57764c;
            this.overlayBottomPixel = i10 - (overlayBottomInPx + i11);
            this.overlayLeftPixel = this.overlayLeftMargin + i9;
            this.overlayTopPixel = this.overlayTopMargin + i11;
        } else if (i2 == 4) {
            this.overlayLeftMargin = this.f57773l.getOverlayLeftInPx(this.width);
            this.overlayRightMargin = this.f57773l.getOverlayRightInPx(this.width);
            this.overlayTopMargin = this.f57773l.getOverlayTopInPx(this.height);
            int overlayBottomInPx2 = this.f57773l.getOverlayBottomInPx(this.height);
            this.overlayBottomMargin = overlayBottomInPx2;
            if (z) {
                this.f57764c = 0;
                this.f57765d = (this.width - ((((int) (((double) ((this.height - this.overlayTopMargin) - overlayBottomInPx2)) * this.f57773l.getOverlayRatio())) + this.overlayLeftMargin) + this.overlayRightMargin)) / 2;
            } else {
                this.f57765d = 0;
                i = (this.height - ((((int) (((double) ((this.width - this.overlayLeftMargin) - this.overlayRightMargin)) / this.f57773l.getOverlayRatio())) + this.overlayTopMargin) + this.overlayBottomMargin)) / 2;
                this.f57764c = i;
            }
            int i12 = this.width;
            int i13 = this.f57765d;
            this.f57763b = i12 - (i13 * 2);
            int i14 = this.height;
            int i15 = this.f57764c;
            this.overlayHeight = (i14 - i15) - i;
            this.overlayRightPixel = (i12 - i13) - this.overlayRightMargin;
            this.overlayBottomPixel = (i14 - i) - this.overlayBottomMargin;
            this.overlayLeftPixel = this.overlayLeftMargin + i13;
            this.overlayTopPixel = this.overlayTopMargin + i15;
        }
    }

    public void doDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.visibility.get() == 0 && this.f57776o) {
            if (!this.f57771j.isEmpty()) {
                canvas.drawPath(this.f57771j, this.f57767f);
            }
            if (!this.f57769h.isEmpty()) {
                canvas.drawPath(this.f57769h, this.f57766e);
            }
            if (!this.f57768g.isEmpty()) {
                canvas.drawPath(this.f57768g, this.borderPaint);
            }
        }
    }

    public final Paint getBackgroundPaint() {
        return this.f57767f;
    }

    public final int getBottomLeftCornerRadius() {
        return this.f57774m;
    }

    public final int getBottomRightCornerRadius() {
        return this.f57775n;
    }

    public final int getCORNER_RADIUS_IN_DP() {
        return this.f57778q;
    }

    public final DocumentFormat getDocumentFormat() {
        return this.f57773l;
    }

    public final Paint getLargeBorderPaint() {
        return this.f57766e;
    }

    public final int getLeftOffset() {
        return this.f57765d;
    }

    public final MobileContext getMobileContext() {
        return this.f57762a;
    }

    public Rect getOverlayBounds() {
        return new Rect(this.overlayLeftPixel, this.overlayTopPixel, this.overlayRightPixel, this.overlayBottomPixel);
    }

    public final int getOverlayWidth() {
        return this.f57763b;
    }

    public final JumioScanSide getScanSide() {
        return this.f57772k;
    }

    public final Map<Integer, Integer> getStyleMap() {
        return this.f57777p;
    }

    public final int getTopOffset() {
        return this.f57764c;
    }

    public void prepareDraw(boolean z) {
        updateOverlayConfiguration(this.f57762a);
        Paint paint = this.borderPaint;
        Map<Integer, Integer> map = this.f57777p;
        Integer valueOf = Integer.valueOf(R.attr.jumio_scanOverlay);
        Integer num = map.get(valueOf);
        paint.setColor(num == null ? -1 : num.intValue());
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setDither(true);
        this.borderPaint.setStrokeJoin(Paint.Join.ROUND);
        this.borderPaint.setStrokeCap(Paint.Cap.ROUND);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setStrokeWidth((float) ScreenUtil.dpToPx((Context) this.f57762a, 2));
        Paint paint2 = this.f57766e;
        Integer num2 = this.f57777p.get(valueOf);
        paint2.setColor(num2 == null ? Color.parseColor("#80000000") : num2.intValue());
        this.f57766e.setAlpha(0);
        this.f57766e.setStyle(Paint.Style.STROKE);
        this.f57766e.setDither(true);
        this.f57766e.setStrokeJoin(Paint.Join.ROUND);
        this.f57766e.setStrokeCap(Paint.Cap.ROUND);
        this.f57766e.setAntiAlias(true);
        this.f57766e.setStrokeWidth((float) ScreenUtil.dpToPx((Context) this.f57762a, 6));
        Paint paint3 = this.f57767f;
        Integer num3 = this.f57777p.get(Integer.valueOf(R.attr.jumio_scanBackground));
        paint3.setColor(num3 == null ? Color.parseColor("#80000000") : num3.intValue());
        this.f57767f.setStyle(Paint.Style.FILL);
        this.f57767f.setDither(true);
        this.f57767f.setStrokeJoin(Paint.Join.ROUND);
        this.f57767f.setStrokeCap(Paint.Cap.ROUND);
        this.f57767f.setAntiAlias(true);
        if (this.drawBrackets) {
            Path createRectWithRoundedCornersAsPath = DrawingUtil.createRectWithRoundedCornersAsPath(getOverlayBounds(), this.topLeftCornerRadius, this.topRightCornerRadius, this.f57774m, this.f57775n);
            Intrinsics.checkNotNullExpressionValue(createRectWithRoundedCornersAsPath, "createRectWithRoundedCor…tomRightCornerRadius\n\t\t\t)");
            this.f57768g = createRectWithRoundedCornersAsPath;
            int dpToPx = ScreenUtil.dpToPx((Context) this.f57762a, 4) / 2;
            Path createRectWithRoundedCornersAsPath2 = DrawingUtil.createRectWithRoundedCornersAsPath(new Rect(getOverlayBounds().left - dpToPx, getOverlayBounds().top - dpToPx, getOverlayBounds().right + dpToPx, getOverlayBounds().bottom + dpToPx), this.topLeftCornerRadius + dpToPx, this.topRightCornerRadius + dpToPx, this.f57774m + dpToPx, this.f57775n + dpToPx);
            Intrinsics.checkNotNullExpressionValue(createRectWithRoundedCornersAsPath2, "createRectWithRoundedCor…ornerRadius + margin\n\t\t\t)");
            this.f57769h = createRectWithRoundedCornersAsPath2;
            int dpToPx2 = ScreenUtil.dpToPx((Context) this.f57762a, 2) / 2;
            Path createRectWithRoundedCornersAsPath3 = DrawingUtil.createRectWithRoundedCornersAsPath(new Rect(getOverlayBounds().left + dpToPx2, getOverlayBounds().top + dpToPx2, getOverlayBounds().right - dpToPx2, getOverlayBounds().bottom - dpToPx2), this.topLeftCornerRadius - dpToPx2, this.topRightCornerRadius - dpToPx2, this.f57774m - dpToPx2, this.f57775n - dpToPx2);
            Intrinsics.checkNotNullExpressionValue(createRectWithRoundedCornersAsPath3, "createRectWithRoundedCor…ornerRadius - margin\n\t\t\t)");
            this.f57770i = createRectWithRoundedCornersAsPath3;
        }
        if (this.dimBackground) {
            Path path = new Path();
            this.f57771j = path;
            path.setFillType(Path.FillType.EVEN_ODD);
            this.f57771j.addRect(0.0f, 0.0f, (float) this.width, (float) this.height, Path.Direction.CW);
            this.f57771j.addPath(this.f57770i);
        }
        this.f57776o = true;
    }

    public final void setBottomLeftCornerRadius(int i) {
        this.f57774m = i;
    }

    public final void setBottomRightCornerRadius(int i) {
        this.f57775n = i;
    }

    public final void setDocumentFormat(DocumentFormat documentFormat) {
        Intrinsics.checkNotNullParameter(documentFormat, "<set-?>");
        this.f57773l = documentFormat;
    }

    public final void setLeftOffset(int i) {
        this.f57765d = i;
    }

    public final void setMobileContext(MobileContext mobileContext) {
        Intrinsics.checkNotNullParameter(mobileContext, "<set-?>");
        this.f57762a = mobileContext;
    }

    public final void setOverlayWidth(int i) {
        this.f57763b = i;
    }

    public void setScanPart(ScanPartModel scanPartModel) {
        Intrinsics.checkNotNullParameter(scanPartModel, "scanPartModel");
        this.scanMode = scanPartModel.getMode();
        this.f57772k = scanPartModel.getSide();
        if (scanPartModel instanceof IDScanPartModel) {
            this.f57773l = ((IDScanPartModel) scanPartModel).getFormat();
        }
        updateOverlayConfiguration(this.f57762a);
    }

    public final void setScanSide(JumioScanSide jumioScanSide) {
        this.f57772k = jumioScanSide;
    }

    public final void setTopOffset(int i) {
        this.f57764c = i;
    }

    public void setVisible(int i) {
        this.visibility.set(i);
    }

    public void update(ExtractionClient.ExtractionUpdate<?> extractionUpdate) {
    }

    public void updateOverlayConfiguration(Context context) {
        DocumentFormat documentFormat = this.f57773l;
        if (documentFormat == DocumentFormat.ID1 || documentFormat == DocumentFormat.ID2) {
            this.drawBrackets = true;
            this.dimBackground = true;
            this.detectLines = false;
            int dpToPx = ScreenUtil.dpToPx(context, this.f57778q);
            this.topLeftCornerRadius = dpToPx;
            this.topRightCornerRadius = dpToPx;
            this.f57774m = dpToPx;
            this.f57775n = dpToPx;
        } else if (documentFormat == DocumentFormat.ID3) {
            this.drawBrackets = true;
            this.dimBackground = true;
            this.detectLines = false;
            this.topLeftCornerRadius = 0;
            this.topRightCornerRadius = 0;
            int dpToPx2 = ScreenUtil.dpToPx(context, this.f57778q);
            this.f57774m = dpToPx2;
            this.f57775n = dpToPx2;
        } else {
            this.drawBrackets = false;
            this.dimBackground = false;
            this.detectLines = false;
        }
    }
}
