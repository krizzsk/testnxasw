package jumio.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

/* renamed from: jumio.core.n0 */
/* compiled from: ScaleableImageView */
public class C19494n0 extends View {

    /* renamed from: a */
    public int f55385a = 0;

    /* renamed from: b */
    public int f55386b = 0;

    /* renamed from: c */
    public BitmapShader f55387c;

    /* renamed from: d */
    public Paint f55388d;

    /* renamed from: e */
    public Matrix f55389e;

    /* renamed from: f */
    public RectF f55390f;

    /* renamed from: g */
    public float f55391g;

    public C19494n0(Context context) {
        super(context);
        mo148682a();
    }

    /* renamed from: a */
    public final void mo148682a() {
        Paint paint = new Paint();
        this.f55388d = paint;
        paint.setAntiAlias(true);
    }

    /* renamed from: b */
    public final void mo148684b() {
        this.f55389e = new Matrix();
        this.f55390f = new RectF(0.0f, 0.0f, (float) this.f55385a, (float) this.f55386b);
        this.f55389e.setRectToRect(this.f55390f, new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), Matrix.ScaleToFit.CENTER);
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f55389e);
        RectF rectF = this.f55390f;
        float f = this.f55391g;
        canvas.drawRoundRect(rectF, f, f, this.f55388d);
        canvas.restore();
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = false;
        boolean z2 = mode == Integer.MIN_VALUE || mode == 0;
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            z = true;
        }
        float f = ((float) this.f55385a) / ((float) this.f55386b);
        if (size != 0 && z && f != 1.0f) {
            size2 = (int) (((float) size) / f);
        } else if (!(!z2 || size2 == 0 || f == 1.0f)) {
            size = (int) (((float) size2) * f);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        mo148684b();
    }

    public void setImageBitmap(Bitmap bitmap) {
        mo148683a(bitmap, 0.0f);
    }

    /* renamed from: a */
    public void mo148683a(Bitmap bitmap, float f) {
        this.f55385a = bitmap.getWidth();
        this.f55386b = bitmap.getHeight();
        this.f55391g = f;
        mo148684b();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f55387c = bitmapShader;
        this.f55388d.setShader(bitmapShader);
        requestLayout();
        invalidate();
    }
}
