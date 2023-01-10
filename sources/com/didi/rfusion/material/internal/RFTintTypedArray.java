package com.didi.rfusion.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;

public final class RFTintTypedArray {

    /* renamed from: a */
    private final Context f36058a;

    /* renamed from: b */
    private final TypedArray f36059b;

    /* renamed from: c */
    private TypedValue f36060c;

    public static RFTintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new RFTintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static RFTintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new RFTintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static RFTintTypedArray obtainStyledAttributes(Context context, int i, int[] iArr) {
        return new RFTintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }

    private RFTintTypedArray(Context context, TypedArray typedArray) {
        this.f36058a = context;
        this.f36059b = typedArray;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        if (!this.f36059b.hasValue(i) || (resourceId = this.f36059b.getResourceId(i, 0)) == 0) {
            return this.f36059b.getDrawable(i);
        }
        return AppCompatResources.getDrawable(this.f36058a, resourceId);
    }

    public int length() {
        return this.f36059b.length();
    }

    public int getIndexCount() {
        return this.f36059b.getIndexCount();
    }

    public int getIndex(int i) {
        return this.f36059b.getIndex(i);
    }

    public Resources getResources() {
        return this.f36059b.getResources();
    }

    public CharSequence getText(int i) {
        return this.f36059b.getText(i);
    }

    public String getString(int i) {
        return this.f36059b.getString(i);
    }

    public String getNonResourceString(int i) {
        return this.f36059b.getNonResourceString(i);
    }

    public boolean getBoolean(int i, boolean z) {
        return this.f36059b.getBoolean(i, z);
    }

    public int getInt(int i, int i2) {
        return this.f36059b.getInt(i, i2);
    }

    public float getFloat(int i, float f) {
        return this.f36059b.getFloat(i, f);
    }

    public int getColor(int i, int i2) {
        return this.f36059b.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        if (!this.f36059b.hasValue(i) || (resourceId = this.f36059b.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.f36058a, resourceId)) == null) {
            return this.f36059b.getColorStateList(i);
        }
        return colorStateList;
    }

    public int getInteger(int i, int i2) {
        return this.f36059b.getInteger(i, i2);
    }

    public float getDimension(int i, float f) {
        return this.f36059b.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.f36059b.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.f36059b.getDimensionPixelSize(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.f36059b.getLayoutDimension(i, str);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.f36059b.getLayoutDimension(i, i2);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.f36059b.getFraction(i, i2, i3, f);
    }

    public int getResourceId(int i, int i2) {
        return this.f36059b.getResourceId(i, i2);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f36059b.getTextArray(i);
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.f36059b.getValue(i, typedValue);
    }

    public int getType(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f36059b.getType(i);
        }
        if (this.f36060c == null) {
            this.f36060c = new TypedValue();
        }
        this.f36059b.getValue(i, this.f36060c);
        return this.f36060c.type;
    }

    public boolean hasValue(int i) {
        return this.f36059b.hasValue(i);
    }

    public TypedValue peekValue(int i) {
        return this.f36059b.peekValue(i);
    }

    public String getPositionDescription() {
        return this.f36059b.getPositionDescription();
    }

    public void recycle() {
        this.f36059b.recycle();
    }

    public int getChangingConfigurations() {
        return this.f36059b.getChangingConfigurations();
    }
}
