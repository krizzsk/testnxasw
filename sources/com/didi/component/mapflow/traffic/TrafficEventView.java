package com.didi.component.mapflow.traffic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.component.core.IView;
import com.didiglobal.travel.infra.view.ViewKt;

public class TrafficEventView implements IView<TrafficEventPresenter> {
    protected FrameLayout mContainer;

    public void setPresenter(TrafficEventPresenter trafficEventPresenter) {
    }

    public View getView() {
        return this.mContainer;
    }

    public TrafficEventView(Context context, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.mContainer = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void update(View view) {
        if (view != null && this.mContainer != null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            ViewKt.removeFromParent(view);
            this.mContainer.addView(view, layoutParams);
            if (this.mContainer.getChildCount() > 1) {
                this.mContainer.removeViewAt(0);
            }
        }
    }

    public void removeView(View view) {
        FrameLayout frameLayout;
        if (view != null && (frameLayout = this.mContainer) != null) {
            frameLayout.removeView(view);
        }
    }
}
