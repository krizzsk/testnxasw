package jumio.p220lf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.MobileContext;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.overlay.JVisionOverlay;
import com.taxis99.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.lf.b */
/* compiled from: LineFinderOverlay.kt */
public final class C19538b extends JVisionOverlay {

    /* renamed from: a */
    public final Paint f55504a;

    /* renamed from: b */
    public int f55505b;

    /* renamed from: c */
    public Path f55506c = new Path();

    /* renamed from: d */
    public C19540b f55507d;

    /* renamed from: e */
    public C19540b f55508e;

    /* renamed from: f */
    public C19540b f55509f;

    /* renamed from: g */
    public C19540b f55510g;

    /* renamed from: jumio.lf.b$a */
    /* compiled from: LineFinderOverlay.kt */
    public static final class C19539a {
        public C19539a() {
        }

        public /* synthetic */ C19539a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: jumio.lf.b$b */
    /* compiled from: LineFinderOverlay.kt */
    public final class C19540b {

        /* renamed from: a */
        public final Paint f55511a;

        /* renamed from: b */
        public boolean f55512b;

        /* renamed from: c */
        public final Path f55513c = new Path();

        public C19540b(C19538b bVar, Paint paint) {
            Intrinsics.checkNotNullParameter(bVar, "this$0");
            Intrinsics.checkNotNullParameter(paint, "paint");
            this.f55511a = paint;
        }

        /* renamed from: a */
        public final void mo148839a(boolean z) {
            this.f55512b = z;
        }

        /* renamed from: a */
        public final void mo148837a(int i, int i2, int i3, int i4) {
            this.f55513c.reset();
            this.f55513c.moveTo((float) i, (float) i2);
            this.f55513c.lineTo((float) i3, (float) i4);
            this.f55513c.close();
        }

        /* renamed from: a */
        public final void mo148838a(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (this.f55512b) {
                canvas.drawPath(this.f55513c, this.f55511a);
            }
        }
    }

    static {
        new C19539a((DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C19538b(MobileContext mobileContext) {
        super(mobileContext);
        Intrinsics.checkNotNullParameter(mobileContext, "context");
        Paint paint = new Paint(1);
        this.f55504a = paint;
        this.f55505b = (int) ScreenUtil.dipToPx(mobileContext, 20.0f);
        this.f55507d = new C19540b(this, paint);
        this.f55508e = new C19540b(this, paint);
        this.f55509f = new C19540b(this, paint);
        this.f55510g = new C19540b(this, paint);
    }

    /* renamed from: a */
    public final Path mo148832a(Rect rect, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        float f = (float) rect.left;
        float f2 = (float) rect.right;
        float f3 = (float) rect.top;
        float f4 = (float) rect.bottom;
        Path path = new Path();
        float f5 = (float) i;
        float f6 = f3 + f5;
        path.moveTo(f, f6);
        if (i2 <= 0) {
            path.lineTo(f, f3);
            path.lineTo(f + f5, f3);
        } else {
            float f7 = (float) i2;
            path.lineTo(f, f3 + f7);
            path.quadTo(f, f3, f7 + f, f3);
            path.lineTo(f + f5, f3);
        }
        float f8 = f2 - f5;
        path.moveTo(f8, f3);
        if (i3 <= 0) {
            path.lineTo(f2, f3);
            path.lineTo(f2, f6);
        } else {
            float f9 = (float) i3;
            path.lineTo(f2 - f9, f3);
            path.quadTo(f2, f3, f2, f9 + f3);
            path.lineTo(f2, f6);
        }
        float f10 = f4 - f5;
        path.moveTo(f2, f10);
        if (i4 <= 0) {
            path.lineTo(f2, f4);
            path.lineTo(f8, f4);
        } else {
            float f11 = (float) i4;
            path.lineTo(f2, f4 - f11);
            path.quadTo(f2, f4, f2 - f11, f4);
            path.lineTo(f8, f4);
        }
        path.moveTo(f5 + f, f4);
        if (i5 <= 0) {
            path.lineTo(f, f4);
            path.lineTo(f, f10);
        } else {
            float f12 = (float) i5;
            path.lineTo(f + f12, f4);
            path.quadTo(f, f4, f, f4 - f12);
            path.lineTo(f, f10);
        }
        path.moveTo(f, f6);
        path.close();
        return path;
    }

    public void calculate(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "extractionArea");
        super.calculate(rect);
        int dpToPx = ScreenUtil.dpToPx((Context) getMobileContext(), 4) / 2;
        Rect rect2 = new Rect(getOverlayBounds().left - dpToPx, getOverlayBounds().top - dpToPx, getOverlayBounds().right + dpToPx, getOverlayBounds().bottom + dpToPx);
        this.f55506c = mo148832a(rect2, this.f55505b + dpToPx, this.topLeftCornerRadius + dpToPx, this.topRightCornerRadius + dpToPx, getBottomLeftCornerRadius() + dpToPx, getBottomRightCornerRadius() + dpToPx);
        C19540b bVar = this.f55507d;
        int i = rect2.left;
        int i2 = rect2.top;
        int i3 = this.f55505b;
        bVar.mo148837a(i, i2 + i3, i, rect2.bottom - i3);
        C19540b bVar2 = this.f55508e;
        int i4 = rect2.left;
        int i5 = this.f55505b;
        int i6 = rect2.top;
        bVar2.mo148837a(i4 + i5, i6, rect2.right - i5, i6);
        C19540b bVar3 = this.f55509f;
        int i7 = rect2.right;
        int i8 = rect2.top;
        int i9 = this.f55505b;
        bVar3.mo148837a(i7, i8 + i9, i7, rect2.bottom - i9);
        C19540b bVar4 = this.f55510g;
        int i10 = rect2.left;
        int i11 = this.f55505b;
        int i12 = rect2.bottom;
        bVar4.mo148837a(i10 + i11, i12, rect2.right - i11, i12);
    }

    public void doDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.doDraw(canvas);
        if (this.visibility.get() == 0) {
            canvas.drawPath(this.f55506c, this.f55504a);
            this.f55507d.mo148838a(canvas);
            this.f55508e.mo148838a(canvas);
            this.f55509f.mo148838a(canvas);
            this.f55510g.mo148838a(canvas);
        }
    }

    public void prepareDraw(boolean z) {
        super.prepareDraw(z);
        Paint largeBorderPaint = getLargeBorderPaint();
        Integer num = getStyleMap().get(Integer.valueOf(R.attr.jumio_scanOverlayTransparent));
        largeBorderPaint.setColor(num == null ? Color.parseColor("#401C2229") : num.intValue());
        this.borderPaint.setAlpha(0);
        this.f55504a.setStyle(Paint.Style.STROKE);
        Paint paint = this.f55504a;
        Integer num2 = getStyleMap().get(Integer.valueOf(R.attr.jumio_scanOverlay));
        paint.setColor(num2 == null ? -1 : num2.intValue());
        this.f55504a.setDither(true);
        this.f55504a.setAntiAlias(true);
        this.f55504a.setStrokeWidth((float) ScreenUtil.dpToPx((Context) getMobileContext(), 6));
    }

    public void update(ExtractionClient.ExtractionUpdate<?> extractionUpdate) {
        if ((extractionUpdate == null ? null : extractionUpdate.getData()) instanceof C19541c) {
            Object data = extractionUpdate.getData();
            if (data != null) {
                C19541c cVar = (C19541c) data;
                this.f55507d.mo148839a(cVar.mo148841b());
                this.f55508e.mo148839a(cVar.mo148843d());
                this.f55509f.mo148839a(cVar.mo148842c());
                this.f55510g.mo148839a(cVar.mo148840a());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.jumio.core.extraction.linefinder.extraction.LineFinderUpdate");
        }
        if (extractionUpdate != null && extractionUpdate.getState() == ExtractionUpdateState.resetOverlay) {
            this.f55507d.mo148839a(false);
            this.f55508e.mo148839a(false);
            this.f55509f.mo148839a(false);
            this.f55510g.mo148839a(false);
        }
    }
}
