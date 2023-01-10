package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.AppUtils;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.sapanel.model.PageTouchEventManger;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.ClipRecyclerView */
public class ClipRecyclerView extends RecyclerView {

    /* renamed from: a */
    private static final String f53667a = "ClipRecyclerView";

    /* renamed from: b */
    private Paint f53668b;

    /* renamed from: c */
    private Bitmap f53669c;

    /* renamed from: d */
    private PorterDuffXfermode f53670d;

    /* renamed from: e */
    private Paint f53671e;

    /* renamed from: f */
    private int f53672f;

    /* renamed from: g */
    private int f53673g;

    public ClipRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ClipRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ClipRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f53672f = 0;
        m40058a();
    }

    /* renamed from: a */
    private void m40058a() {
        setBackgroundColor(0);
        this.f53673g = (int) getContext().getResources().getDimension(R.dimen.view_radius);
    }

    /* renamed from: a */
    private Bitmap m40057a(int i, int i2) {
        Bitmap copy = BitmapFactory.decodeResource(getResources(), R.drawable.panel_top_bg, new BitmapFactory.Options()).copy(Bitmap.Config.ARGB_8888, true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        float f = ((float) i) / ((float) width);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(copy, 0, 0, width, height, matrix, true);
    }

    /* renamed from: b */
    private Bitmap m40059b(int i, int i2) {
        Bitmap copy = BitmapFactory.decodeResource(getResources(), R.drawable.panel_top_bg, new BitmapFactory.Options()).copy(Bitmap.Config.ARGB_8888, true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        float f = ((float) i) / ((float) width);
        Matrix matrix = new Matrix();
        matrix.postScale(f, 0.01f + f);
        Bitmap createBitmap = Bitmap.createBitmap(copy, 0, 0, width, height, matrix, true);
        Bitmap createBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawColor(Color.parseColor("#fafafa"));
        canvas.drawBitmap(createBitmap, (Rect) null, new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()), (Paint) null);
        canvas.save();
        canvas.restore();
        return createBitmap2;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PageTouchEventManger.mapConsume = false;
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        SystemUtils.log(6, f53667a, String.valueOf(PageTouchEventManger.mapConsume), (Throwable) null, "com.didiglobal.sa.biz.component.sapanel.view.ClipRecyclerView", 114);
        if (PageTouchEventManger.mapConsume) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        this.f53672f += i2;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f53668b == null) {
            this.f53668b = new Paint();
            PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
            this.f53670d = porterDuffXfermode;
            this.f53668b.setXfermode(porterDuffXfermode);
            this.f53668b.setAntiAlias(true);
        }
        if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
            if (this.f53669c == null) {
                AppUtils.getRealScreenSize(getContext());
                this.f53669c = m40059b(getWidth(), getHeight() * 2);
            }
            Bitmap bitmap = this.f53669c;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f53669c.getHeight());
            Canvas canvas2 = new Canvas(createBitmap);
            if (this.f53671e == null) {
                this.f53671e = new Paint();
            }
            int i = 0;
            while (true) {
                if (i >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i);
                if (ComponentType.COMPONENT_RIDE_CARD.equals(childAt.getTag())) {
                    int left = childAt.getLeft();
                    int top = childAt.getTop();
                    int paddingLeft = childAt.getPaddingLeft();
                    int paddingTop = childAt.getPaddingTop();
                    int paddingBottom = childAt.getPaddingBottom();
                    int i2 = top + paddingTop + this.f53672f;
                    RectF rectF = new RectF((float) (left + paddingLeft), (float) i2, (float) ((left + childAt.getWidth()) - paddingLeft), (float) (((childAt.getHeight() + i2) - paddingBottom) - paddingTop));
                    int i3 = this.f53673g;
                    canvas2.drawRoundRect(rectF, (float) i3, (float) i3, this.f53668b);
                    break;
                }
                i++;
            }
            int i4 = this.f53672f;
            int height = getHeight() + this.f53672f;
            if (i4 > getHeight() - 20) {
                i4 = createBitmap.getHeight() - 20;
                height = createBitmap.getHeight();
            }
            canvas.drawBitmap(createBitmap, new Rect(0, i4, getWidth(), height), new Rect(0, 0, getWidth(), getHeight()), this.f53671e);
        }
    }
}
