package com.didi.payment.pix.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.passenger.C11267R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0014J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo148868d2 = {"Lcom/didi/payment/pix/widget/AuthCodeInputView;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBorderHeight", "mBorderImage", "Landroid/graphics/drawable/Drawable;", "mBorderSpacing", "mBorderWidth", "mMaxLength", "mRect", "Landroid/graphics/Rect;", "mTextColor", "drawBorderBackground", "", "canvas", "Landroid/graphics/Canvas;", "drawText", "init", "initAttrs", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxLength", "maxLength", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AuthCodeInputView.kt */
public final class AuthCodeInputView extends AppCompatEditText {

    /* renamed from: a */
    private int f33816a = 4;

    /* renamed from: b */
    private int f33817b = 100;

    /* renamed from: c */
    private int f33818c = 100;

    /* renamed from: d */
    private int f33819d = 24;

    /* renamed from: e */
    private Drawable f33820e;

    /* renamed from: f */
    private final Rect f33821f = new Rect();

    /* renamed from: g */
    private int f33822g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthCodeInputView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        m25680a(context, (AttributeSet) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthCodeInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        m25680a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthCodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        m25680a(context, attributeSet);
    }

    /* renamed from: a */
    private final void m25680a(Context context, AttributeSet attributeSet) {
        m25682b(context, attributeSet);
        setMaxLength(this.f33816a);
        setLongClickable(false);
        setBackgroundColor(0);
        setCursorVisible(false);
    }

    private final void setMaxLength(int i) {
        if (i >= 0) {
            setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(i)});
        }
    }

    /* renamed from: b */
    private final void m25682b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.AuthCodeInputView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…leable.AuthCodeInputView)");
            int integer = obtainStyledAttributes.getInteger(0, 4);
            this.f33816a = integer;
            if (integer <= 1) {
                integer = 1;
            }
            this.f33816a = integer;
            this.f33817b = (int) obtainStyledAttributes.getDimension(4, 100.0f);
            this.f33818c = (int) obtainStyledAttributes.getDimension(1, 100.0f);
            this.f33819d = (int) obtainStyledAttributes.getDimension(3, 24.0f);
            Drawable drawable = obtainStyledAttributes.getDrawable(2);
            if (drawable != null) {
                this.f33820e = drawable;
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i3 = this.f33817b;
        int i4 = this.f33816a;
        int i5 = (i3 * i4) + (this.f33819d * (i4 - 1));
        if (measuredWidth < i5) {
            measuredWidth = i5;
        }
        int i6 = this.f33818c;
        if (measuredHeight < i6) {
            measuredHeight = i6;
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(measuredWidth, mode), View.MeasureSpec.makeMeasureSpec(measuredHeight, mode2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.f33822g = getCurrentTextColor();
        setTextColor(0);
        super.onDraw(canvas);
        setTextColor(this.f33822g);
        m25681a(canvas);
        m25683b(canvas);
    }

    /* renamed from: a */
    private final void m25681a(Canvas canvas) {
        int height = getHeight();
        this.f33821f.left = 0;
        this.f33821f.top = (height - this.f33818c) / 2;
        this.f33821f.right = this.f33817b;
        Rect rect = this.f33821f;
        rect.bottom = rect.top + this.f33818c;
        int saveCount = canvas.getSaveCount();
        canvas.save();
        int length = getEditableText().length();
        int i = this.f33816a;
        if (i > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                Drawable drawable = this.f33820e;
                Intrinsics.checkNotNull(drawable);
                drawable.setBounds(this.f33821f);
                if (i2 == length && isFocused()) {
                    Drawable drawable2 = this.f33820e;
                    Intrinsics.checkNotNull(drawable2);
                    drawable2.setState(new int[]{16842908});
                } else if (i2 < length) {
                    Drawable drawable3 = this.f33820e;
                    Intrinsics.checkNotNull(drawable3);
                    drawable3.setState(new int[]{16842914});
                } else {
                    Drawable drawable4 = this.f33820e;
                    Intrinsics.checkNotNull(drawable4);
                    drawable4.setState(new int[]{16842910});
                }
                Drawable drawable5 = this.f33820e;
                Intrinsics.checkNotNull(drawable5);
                drawable5.draw(canvas);
                canvas.save();
                canvas.translate((float) (this.f33821f.right + this.f33819d), 0.0f);
                if (i3 >= i) {
                    break;
                }
                i2 = i3;
            }
        }
        canvas.restoreToCount(saveCount);
        canvas.translate(0.0f, 0.0f);
    }

    /* renamed from: b */
    private final void m25683b(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.translate(0.0f, 0.0f);
        int length = getEditableText().length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                String valueOf = String.valueOf(getEditableText().charAt(i));
                TextPaint paint = getPaint();
                paint.setColor(this.f33822g);
                paint.getTextBounds(valueOf, 0, 1, this.f33821f);
                int i3 = this.f33817b;
                canvas.drawText(valueOf, (float) (((i3 / 2) + ((i3 + this.f33819d) * i)) - this.f33821f.centerX()), (float) ((canvas.getHeight() / 2) + (this.f33821f.height() / 2)), paint);
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        canvas.restoreToCount(saveCount);
    }
}
