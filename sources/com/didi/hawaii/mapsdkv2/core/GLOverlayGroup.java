package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GLOverlayGroup extends GLPrimaryShape {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<GLOverlayView> f26177a = new ArrayList(12);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f26178b = false;

    public static class Option extends GLOverlayView.Option {
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    public void setZIndex(int i) {
    }

    public GLOverlayGroup(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
    }

    public void addView(GLOverlayView... gLOverlayViewArr) {
        if (gLOverlayViewArr != null) {
            Collections.addAll(this.f26177a, gLOverlayViewArr);
            if (isAdded()) {
                for (GLOverlayView gLOverlayView : gLOverlayViewArr) {
                    if (!this.f26178b) {
                        gLOverlayView.setAlpha(getAlpha());
                        gLOverlayView.setZIndex(gLOverlayView.getZIndex() > getZIndex() ? gLOverlayView.getZIndex() : getZIndex());
                    }
                    gLOverlayView.setVisible(isVisible());
                }
                this.mViewManager.addView(gLOverlayViewArr);
            }
        }
    }

    public void setIgnoreGroupAttrs(boolean z) {
        this.f26178b = z;
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        getMainHandler().post(new Runnable() {
            public void run() {
                int i;
                for (GLOverlayView gLOverlayView : GLOverlayGroup.this.f26177a) {
                    if (!GLOverlayGroup.this.f26178b) {
                        gLOverlayView.setAlpha(GLOverlayGroup.this.getAlpha());
                        if (gLOverlayView.getZIndex() > GLOverlayGroup.this.getZIndex()) {
                            i = gLOverlayView.getZIndex();
                        } else {
                            i = GLOverlayGroup.this.getZIndex();
                        }
                        gLOverlayView.setZIndex(i);
                    }
                    gLOverlayView.setVisible(GLOverlayGroup.this.isVisible());
                }
                GLOverlayGroup.this.mViewManager.addView((GLOverlayView[]) GLOverlayGroup.this.f26177a.toArray(new GLOverlayView[GLOverlayGroup.this.f26177a.size()]));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        getMainHandler().post(new Runnable() {
            public void run() {
                for (GLOverlayView removeView : GLOverlayGroup.this.f26177a) {
                    GLOverlayGroup.this.mViewManager.removeView(removeView);
                }
                GLOverlayGroup.this.f26177a.clear();
            }
        });
    }

    public void removeView(GLOverlayView gLOverlayView) {
        this.f26177a.remove(gLOverlayView);
        this.mViewManager.removeView(gLOverlayView);
    }

    public void clearView() {
        for (GLOverlayView removeView : this.f26177a) {
            this.mViewManager.removeView(removeView);
        }
        this.f26177a.clear();
    }

    public void setVisible(boolean z) {
        super.setVisible(z);
        beginSetTransaction();
        for (GLOverlayView visible : this.f26177a) {
            visible.setVisible(z);
        }
        commitSetTransaction();
    }

    public void setAlpha(float f) {
        super.setAlpha(f);
        beginSetTransaction();
        for (GLOverlayView alpha : this.f26177a) {
            alpha.setAlpha(f);
        }
        commitSetTransaction();
    }

    public GLOverlayView getChildAt(int i) {
        if (i < 0 || i >= this.f26177a.size()) {
            return null;
        }
        return this.f26177a.get(i);
    }

    public int getChildCount() {
        return this.f26177a.size();
    }

    public GLOverlayView findViewById(String str) {
        checkThread();
        for (GLOverlayView next : this.f26177a) {
            if (next.getId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void beginSetTransaction() {
        super.beginSetTransaction();
        for (GLOverlayView beginSetTransaction : this.f26177a) {
            beginSetTransaction.beginSetTransaction(this.mSetTransaction);
        }
    }

    /* access modifiers changed from: protected */
    public void commitSetTransaction() {
        super.commitSetTransaction();
        for (GLOverlayView commitSetTransaction : this.f26177a) {
            commitSetTransaction.commitSetTransaction();
        }
    }

    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        beginSetTransaction();
        for (GLOverlayView onUpdateOption : this.f26177a) {
            onUpdateOption.onUpdateOption(option);
        }
        commitSetTransaction();
    }
}
