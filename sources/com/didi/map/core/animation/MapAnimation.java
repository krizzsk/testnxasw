package com.didi.map.core.animation;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.didi.map.core.point.GeoPoint;
import com.didi.trackupload.sdk.Constants;

public abstract class MapAnimation {

    /* renamed from: a */
    private boolean f26960a = false;
    protected InnerAnimationListener animationListener = null;
    protected SetAnimatePropertyListener animationProperty = null;

    /* renamed from: b */
    private boolean f26961b = false;

    /* renamed from: c */
    private boolean f26962c = false;

    /* renamed from: d */
    private Interpolator f26963d = new LinearInterpolator();
    protected long iDuration = Constants.SUBTITUDE_LOC_EFFECTIVE_TIME;
    protected long ltimeStart = 0;
    protected long ltimeStartOffset = 0;

    public interface InnerAnimationListener {
        void onAnimationFinish();

        void onAnimationStart();
    }

    public interface SetAnimatePropertyListener {
        void setAlpha(float f);

        void setPosition(int i, int i2);

        void setRatio(float f);

        void setRotate(float f, float f2, float f3, float f4);

        void setScale(float f, float f2);
    }

    /* access modifiers changed from: protected */
    public abstract void performAnimation(float f, Interpolator interpolator);

    public void setAnimationListener(InnerAnimationListener innerAnimationListener) {
        this.animationListener = innerAnimationListener;
    }

    public void setAnimationProperty(SetAnimatePropertyListener setAnimatePropertyListener) {
        this.animationProperty = setAnimatePropertyListener;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f26963d = interpolator;
    }

    public Interpolator getInterpolator() {
        return this.f26963d;
    }

    /* renamed from: a */
    private long m21247a() {
        return SystemClock.uptimeMillis();
    }

    public void setDuration(long j) {
        this.iDuration = j;
    }

    public void setDelay(long j) {
        this.ltimeStartOffset = j;
    }

    public boolean startAnimation(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (this.iDuration <= 0) {
            return false;
        }
        this.f26961b = true;
        this.ltimeStart = m21247a();
        this.f26960a = true;
        InnerAnimationListener innerAnimationListener = this.animationListener;
        if (innerAnimationListener != null) {
            innerAnimationListener.onAnimationStart();
        }
        return true;
    }

    public void stopAnimation() {
        this.f26960a = false;
    }

    public boolean isRunning() {
        return this.f26960a;
    }

    public void drawAnimation() {
        InnerAnimationListener innerAnimationListener;
        if (this.f26960a) {
            long a = m21247a() - (this.ltimeStart + this.ltimeStartOffset);
            if (a < 0) {
                a = 0;
            }
            float f = ((float) a) / ((float) this.iDuration);
            if (f > 1.0f) {
                this.f26960a = false;
                performAnimation(1.0f, this.f26963d);
                InnerAnimationListener innerAnimationListener2 = this.animationListener;
                if (innerAnimationListener2 != null) {
                    innerAnimationListener2.onAnimationFinish();
                }
                this.f26962c = true;
                return;
            }
            performAnimation(f, this.f26963d);
        } else if (!this.f26962c && (innerAnimationListener = this.animationListener) != null) {
            innerAnimationListener.onAnimationFinish();
        }
    }

    public boolean isStarted() {
        return this.f26961b;
    }

    public boolean isEnded() {
        return this.f26962c;
    }
}
