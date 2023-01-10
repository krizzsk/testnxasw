package com.didi.common.map.model.animation;

import com.didi.common.map.model.animation.Animation;
import java.util.ArrayList;

public class AnimationSet extends Animation {

    /* renamed from: a */
    private ArrayList<Animation> f12744a = new ArrayList<>();

    /* renamed from: b */
    private boolean f12745b;

    public AnimationSet(boolean z) {
        this.mType = Animation.AnimationType.SET;
        this.f12745b = z;
    }

    public boolean addAnimation(Animation animation) {
        if (animation == null) {
            return false;
        }
        synchronized (this) {
            this.f12744a.add(animation);
        }
        return true;
    }

    public void cleanAnimation() {
        synchronized (this) {
            this.f12744a.clear();
        }
    }

    public ArrayList<Animation> getAllAnimations() {
        return this.f12744a;
    }

    public boolean getShareInterpolator() {
        return this.f12745b;
    }
}
