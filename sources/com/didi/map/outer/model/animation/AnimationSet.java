package com.didi.map.outer.model.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.animation.MapAnimationSet;
import java.util.ArrayList;
import java.util.List;

public class AnimationSet extends Animation {

    /* renamed from: a */
    private List<Animation> f30523a = new ArrayList();

    /* renamed from: b */
    private boolean f30524b = true;

    public AnimationSet(boolean z) {
        this.f30524b = z;
        if (this.animation == null) {
            this.animation = new MapAnimationSet(z);
        }
    }

    public List<Animation> getAnimationList() {
        return this.f30523a;
    }

    public boolean isShareInterpolator() {
        return this.f30524b;
    }

    public void setDuration(long j) {
        super.setDuration(j);
        if (this.animation != null) {
            this.animation.setDuration(j);
        }
    }

    public void setDelay(long j) {
        super.setDelay(j);
        if (this.animation != null) {
            this.animation.setDelay(j);
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        if (this.animation != null && interpolator != null) {
            this.animation.setInterpolator(interpolator);
        }
    }

    public boolean addAnimation(Animation animation) {
        this.f30523a.add(animation);
        if (animation == null || animation.animation == null || this.animation == null) {
            return false;
        }
        ((MapAnimationSet) this.animation).addAnimation(animation.animation);
        return true;
    }

    public void cleanAnimation() {
        this.f30523a.clear();
        if (this.animation != null) {
            ((MapAnimationSet) this.animation).cleanAnimation();
        }
    }
}
