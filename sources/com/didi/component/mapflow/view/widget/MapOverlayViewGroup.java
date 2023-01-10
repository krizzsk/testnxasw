package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleObserver;
import com.didi.map.global.flow.MapFlowView;

public class MapOverlayViewGroup extends FrameLayout implements LifecycleObserver {

    /* renamed from: a */
    private MapFlowView f16376a;

    /* renamed from: b */
    private Context f16377b;

    public interface OverlayViewsBuilder {
        View getOverlayContentView(Context context);
    }

    public MapOverlayViewGroup(Context context, MapFlowView mapFlowView) {
        super(context);
        this.f16377b = context;
        this.f16376a = mapFlowView;
    }

    public void attachToMapFlowView() {
        if (getParent() != null) {
            detachFromMapFlowView();
        }
        MapFlowView mapFlowView = this.f16376a;
        if (mapFlowView != null) {
            mapFlowView.addView(this, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void detachFromMapFlowView() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        MapFlowView mapFlowView = this.f16376a;
        if (mapFlowView != null) {
            mapFlowView.removeView(this);
        }
    }

    public void clearAllOverlayViews() {
        removeAllViews();
    }

    public void buildOverlayViews(OverlayViewsBuilder overlayViewsBuilder) {
        View overlayContentView;
        if (overlayViewsBuilder != null && (overlayContentView = overlayViewsBuilder.getOverlayContentView(this.f16377b)) != null) {
            addView(overlayContentView);
        }
    }
}
