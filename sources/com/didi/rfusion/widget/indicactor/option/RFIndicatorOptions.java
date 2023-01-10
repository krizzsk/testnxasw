package com.didi.rfusion.widget.indicactor.option;

import android.graphics.Color;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\u001a\u0010!\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001c\u0010*\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006-"}, mo148868d2 = {"Lcom/didi/rfusion/widget/indicactor/option/RFIndicatorOptions;", "", "()V", "checkedProgress", "", "getCheckedProgress", "()Ljava/lang/Float;", "setCheckedProgress", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "checkedSliderColor", "", "getCheckedSliderColor", "()I", "setCheckedSliderColor", "(I)V", "checkedSliderWidth", "getCheckedSliderWidth", "()F", "setCheckedSliderWidth", "(F)V", "currentPosition", "getCurrentPosition", "setCurrentPosition", "normalSliderColor", "getNormalSliderColor", "setNormalSliderColor", "normalSliderWidth", "getNormalSliderWidth", "setNormalSliderWidth", "pageSize", "getPageSize", "setPageSize", "slideMode", "getSlideMode", "setSlideMode", "slideProgress", "getSlideProgress", "setSlideProgress", "sliderGap", "getSliderGap", "setSliderGap", "sliderHeight", "getSliderHeight", "setSliderHeight", "r-fusion_ninePhoneRelease"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: RFIndicatorOptions.kt */
public final class RFIndicatorOptions {

    /* renamed from: a */
    private int f36360a = 0;

    /* renamed from: b */
    private int f36361b;

    /* renamed from: c */
    private int f36362c = Color.parseColor("#8C18171C");

    /* renamed from: d */
    private int f36363d = Color.parseColor("#8C6C6D72");

    /* renamed from: e */
    private float f36364e;

    /* renamed from: f */
    private float f36365f;

    /* renamed from: g */
    private float f36366g;

    /* renamed from: h */
    private float f36367h;

    /* renamed from: i */
    private int f36368i;

    /* renamed from: j */
    private float f36369j;

    /* renamed from: k */
    private Float f36370k;

    public RFIndicatorOptions() {
        float dimens = RFResUtils.getDimens(R.dimen.rf_dimen_8);
        this.f36366g = dimens;
        this.f36367h = dimens;
        this.f36364e = dimens;
    }

    public final int getSlideMode() {
        return this.f36360a;
    }

    public final void setSlideMode(int i) {
        this.f36360a = i;
    }

    public final int getPageSize() {
        return this.f36361b;
    }

    public final void setPageSize(int i) {
        this.f36361b = i;
    }

    public final int getNormalSliderColor() {
        return this.f36362c;
    }

    public final void setNormalSliderColor(int i) {
        this.f36362c = i;
    }

    public final int getCheckedSliderColor() {
        return this.f36363d;
    }

    public final void setCheckedSliderColor(int i) {
        this.f36363d = i;
    }

    public final float getSliderGap() {
        return this.f36364e;
    }

    public final void setSliderGap(float f) {
        this.f36364e = f;
    }

    public final void setSliderHeight(float f) {
        this.f36365f = f;
    }

    public final float getSliderHeight() {
        float f = this.f36365f;
        return f > ((float) 0) ? f : this.f36366g / ((float) 2);
    }

    public final float getNormalSliderWidth() {
        return this.f36366g;
    }

    public final void setNormalSliderWidth(float f) {
        this.f36366g = f;
    }

    public final float getCheckedSliderWidth() {
        return this.f36367h;
    }

    public final void setCheckedSliderWidth(float f) {
        this.f36367h = f;
    }

    public final int getCurrentPosition() {
        return this.f36368i;
    }

    public final void setCurrentPosition(int i) {
        this.f36368i = i;
    }

    public final float getSlideProgress() {
        return this.f36369j;
    }

    public final void setSlideProgress(float f) {
        this.f36369j = f;
    }

    public final Float getCheckedProgress() {
        return this.f36370k;
    }

    public final void setCheckedProgress(Float f) {
        this.f36370k = f;
    }
}
