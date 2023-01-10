package com.didi.component.safetoolkit.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.presenter.AbsJarvisPresenter;
import com.didi.safetoolkit.business.bubble.ISfJarvisController;
import com.didi.safetoolkit.business.bubble.SfJarvisController;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class JarvisView implements IJarvisView {

    /* renamed from: a */
    private ISfJarvisController f17306a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f17307b;

    /* renamed from: c */
    private Context f17308c;

    public void setPresenter(AbsJarvisPresenter absJarvisPresenter) {
    }

    public JarvisView(Context context) {
        this.f17308c = context;
        SfJarvisController sfJarvisController = new SfJarvisController(context);
        this.f17306a = sfJarvisController;
        View view = sfJarvisController.getView();
        this.f17307b = view;
        view.setContentDescription(ResourcesHelper.getString(context, R.string.GRider_0111_Security_Centre_lydb));
    }

    public View getView() {
        return this.f17307b;
    }

    public void setTranslationY(int i) {
        if (getView() != null) {
            getView().setTranslationY((float) i);
        }
    }

    public void setJarvisData(SfJarvisData sfJarvisData) {
        ISfJarvisController iSfJarvisController = this.f17306a;
        if (iSfJarvisController != null) {
            iSfJarvisController.refreshJarvisData(sfJarvisData);
            if (this.f17307b.getVisibility() == 0) {
                BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, Integer.valueOf(this.f17307b.getMeasuredHeight()));
            }
        }
    }

    public void closeSafePanel() {
        ISfJarvisController iSfJarvisController = this.f17306a;
        if (iSfJarvisController != null) {
            iSfJarvisController.closeSafePanel();
        }
    }

    public void onRemove() {
        ISfJarvisController iSfJarvisController = this.f17306a;
        if (iSfJarvisController != null) {
            iSfJarvisController.onRemove();
            this.f17306a.removeCallback();
        }
    }

    public void onLeaveHome() {
        ISfJarvisController iSfJarvisController = this.f17306a;
        if (iSfJarvisController != null) {
            iSfJarvisController.onRemove();
        }
    }

    public void onBackHome() {
        ISfJarvisController iSfJarvisController = this.f17306a;
        if (iSfJarvisController != null) {
            iSfJarvisController.init();
            if (this.f17307b.getVisibility() == 0) {
                BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, Integer.valueOf(this.f17307b.getMeasuredHeight()));
            } else {
                BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, 0);
            }
        }
    }

    public void setJarvisVisible(int i) {
        View view = this.f17307b;
        if (view != null && view.getVisibility() != i) {
            this.f17307b.setVisibility(i);
        }
    }

    public void setJarvisDismissedByAlpha(boolean z) {
        ObjectAnimator objectAnimator;
        View view = this.f17307b;
        if (view != null) {
            if (z) {
                objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f}).setDuration(300);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        JarvisView.this.f17307b.setVisibility(4);
                    }
                });
            } else {
                objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f}).setDuration(300);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        JarvisView.this.f17307b.setVisibility(0);
                    }
                });
            }
            objectAnimator.start();
        }
    }

    public void setBubbleData(SfBubbleData sfBubbleData) {
        ISfJarvisController iSfJarvisController = this.f17306a;
        if (iSfJarvisController != null) {
            iSfJarvisController.setBubbleStatusAndShow(sfBubbleData);
        }
    }
}
