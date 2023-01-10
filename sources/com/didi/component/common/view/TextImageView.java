package com.didi.component.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.passenger.C11267R;

public class TextImageView extends AppCompatTextView {

    /* renamed from: a */
    private int f13724a;

    /* renamed from: b */
    private int f13725b;

    /* renamed from: c */
    private int f13726c;

    /* renamed from: d */
    private int f13727d;

    /* renamed from: e */
    private int f13728e;

    /* renamed from: f */
    private int f13729f;

    /* renamed from: g */
    private int f13730g;

    /* renamed from: h */
    private int f13731h;

    public TextImageView(Context context) {
        super(context);
    }

    public TextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public TextImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.TextImageView);
        this.f13724a = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
        this.f13725b = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.f13726c = obtainStyledAttributes.getDimensionPixelOffset(7, 0);
        this.f13727d = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
        this.f13728e = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
        this.f13729f = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
        this.f13730g = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f13731h = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        obtainStyledAttributes.recycle();
        setDrawablesSize();
    }

    public void setDrawablesSize() {
        Drawable[] compoundDrawables = getCompoundDrawables();
        for (int i = 0; i < compoundDrawables.length; i++) {
            if (i == 0) {
                m11425a(compoundDrawables[0], this.f13724a, this.f13725b);
            } else if (i == 1) {
                m11425a(compoundDrawables[1], this.f13726c, this.f13727d);
            } else if (i == 2) {
                m11425a(compoundDrawables[2], this.f13728e, this.f13729f);
            } else if (i == 3) {
                m11425a(compoundDrawables[3], this.f13730g, this.f13731h);
            }
        }
        setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    /* renamed from: a */
    private void m11425a(Drawable drawable, int i, int i2) {
        if (drawable != null) {
            double intrinsicHeight = ((double) drawable.getIntrinsicHeight()) / ((double) drawable.getIntrinsicWidth());
            drawable.setBounds(0, 0, i, i2);
            Rect bounds = drawable.getBounds();
            if (bounds.right != 0 || bounds.bottom != 0) {
                if (bounds.right == 0) {
                    bounds.right = (int) (((double) bounds.bottom) / intrinsicHeight);
                    drawable.setBounds(bounds);
                }
                if (bounds.bottom == 0) {
                    bounds.bottom = (int) (((double) bounds.right) * intrinsicHeight);
                    drawable.setBounds(bounds);
                }
            }
        }
    }
}
