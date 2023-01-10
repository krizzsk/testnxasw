package com.didi.component.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class IconTextTipsView extends GlobalTipsView {

    /* renamed from: a */
    private Paint f13669a;

    /* renamed from: b */
    private Paint f13670b;

    /* renamed from: c */
    private int f13671c = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.global_tips_icon_width);

    /* renamed from: d */
    private int f13672d = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.global_tips_icon_height);

    /* renamed from: e */
    private int f13673e = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.global_tips_icon_bg_round);

    public IconTextTipsView(Context context) {
        super(context);
        int color = ResourcesHelper.getColor(getContext(), R.color.global_tips_icon_bg);
        int color2 = ResourcesHelper.getColor(getContext(), R.color.global_tips_icon_text);
        int dimensionPixelSize = ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.ms_10sp);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(color);
        paint.setAntiAlias(true);
        this.f13669a = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(color2);
        paint2.setTextSize((float) dimensionPixelSize);
        this.f13670b = paint2;
    }

    public void setIcon(String str) {
        Bitmap bitmap;
        try {
            bitmap = m11405a(str);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null) {
            ViewGroup.LayoutParams layoutParams = this.mIvGuide.getLayoutParams();
            layoutParams.width = -2;
            this.mIvGuide.setLayoutParams(layoutParams);
            this.mIvGuide.setBackground(new BitmapDrawable(getResources(), bitmap));
            this.mIvGuide.setImageBitmap((Bitmap) null);
        }
    }

    /* renamed from: a */
    private Bitmap m11405a(String str) {
        float measureText = this.f13670b.measureText(str) + ((float) ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.dp_8));
        int i = this.f13671c;
        if (measureText > ((float) i)) {
            i = (int) measureText;
        }
        int i2 = this.f13672d;
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF();
        rectF.left = 1.0f;
        rectF.top = 1.0f;
        rectF.right = (float) (i - 1);
        rectF.bottom = (float) (i2 - 1);
        int i3 = this.f13673e;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, this.f13669a);
        Rect rect = new Rect();
        this.f13670b.getTextBounds(str, 0, str.length(), rect);
        Paint.FontMetrics fontMetrics = this.f13670b.getFontMetrics();
        canvas.drawText(str, ((float) (i - rect.width())) / 2.0f, (((float) (i2 / 2)) - fontMetrics.descent) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.f13670b);
        return createBitmap;
    }
}
