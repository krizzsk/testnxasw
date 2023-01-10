package com.didi.component.safetoolkit.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.presenter.AbsJarvisPresenterV2;
import com.didi.globalsafetoolkit.business.bubble.GlobalSfViewOwner;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class JarvisViewV2 implements IJarvisViewV2 {

    /* renamed from: a */
    private GlobalSfViewOwner f17309a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f17310b;

    /* renamed from: c */
    private Context f17311c;

    public void setPresenter(AbsJarvisPresenterV2 absJarvisPresenterV2) {
    }

    public JarvisViewV2(Context context) {
        this.f17311c = context;
        GlobalSfViewOwner globalSfViewOwner = new GlobalSfViewOwner(context);
        this.f17309a = globalSfViewOwner;
        View view = globalSfViewOwner.getView();
        this.f17310b = view;
        view.setContentDescription(ResourcesHelper.getString(context, R.string.GRider_0111_Security_Centre_lydb));
    }

    public View getView() {
        return this.f17310b;
    }

    public void setTranslationY(int i) {
        if (getView() != null) {
            getView().setTranslationY((float) i);
        }
    }

    public void setJarvisData(SfJarvisData sfJarvisData) {
        if (this.f17309a != null && this.f17310b.getVisibility() == 0) {
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, Integer.valueOf(this.f17310b.getMeasuredHeight()));
        }
    }

    public void closeSafePanel() {
        GlobalSfViewOwner globalSfViewOwner = this.f17309a;
        if (globalSfViewOwner != null) {
            globalSfViewOwner.closeSafePanel();
        }
    }

    public void onRemove() {
        GlobalSfViewOwner globalSfViewOwner = this.f17309a;
        if (globalSfViewOwner != null) {
            globalSfViewOwner.onRemove();
            this.f17309a.removeCallback();
        }
    }

    public void onLeaveHome() {
        GlobalSfViewOwner globalSfViewOwner = this.f17309a;
        if (globalSfViewOwner != null) {
            globalSfViewOwner.onRemove();
        }
    }

    public void onBackHome() {
        if (this.f17309a != null) {
            if (this.f17310b.getVisibility() == 0) {
                BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, Integer.valueOf(this.f17310b.getMeasuredHeight()));
            } else {
                BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, 0);
            }
        }
    }

    public GlobalSfViewOwner getViewOwner() {
        return this.f17309a;
    }

    public void setJarvisVisible(int i) {
        View view = this.f17310b;
        if (view != null && view.getVisibility() != i) {
            this.f17310b.setVisibility(i);
        }
    }

    public void setJarvisDismissedByAlpha(boolean z) {
        ObjectAnimator objectAnimator;
        View view = this.f17310b;
        if (view != null) {
            if (z) {
                objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f}).setDuration(300);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        JarvisViewV2.this.f17310b.setVisibility(4);
                    }
                });
            } else {
                objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f}).setDuration(300);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        JarvisViewV2.this.f17310b.setVisibility(0);
                    }
                });
            }
            objectAnimator.start();
        }
    }

    public void setBubbleData(SfBubbleData sfBubbleData) {
        if (this.f17309a == null) {
        }
    }
}
