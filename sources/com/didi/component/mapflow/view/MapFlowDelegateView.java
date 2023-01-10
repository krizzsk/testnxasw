package com.didi.component.mapflow.view;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter;
import com.didi.component.mapflow.view.widget.MapOverlayViewGroup;
import com.didi.map.global.flow.MapFlowView;
import com.didi.sdk.view.tips.TipsContainer;
import com.didi.sdk.view.tips.TipsView;
import com.taxis99.R;

public class MapFlowDelegateView implements IMapFlowDelegateView {

    /* renamed from: a */
    private AbsMapFlowDelegatePresenter f16348a;

    /* renamed from: b */
    private Context f16349b;

    /* renamed from: c */
    private MapFlowView f16350c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TipsContainer f16351d;

    /* renamed from: e */
    private MapOverlayViewGroup f16352e;

    /* renamed from: f */
    private boolean f16353f;

    /* renamed from: g */
    private View f16354g;

    /* renamed from: h */
    private int f16355h = 1;

    /* renamed from: i */
    private int f16356i;

    public View getView() {
        return null;
    }

    public MapFlowDelegateView(Context context, MapFlowView mapFlowView) {
        this.f16349b = context;
        this.f16350c = mapFlowView;
        if (mapFlowView != null) {
            this.f16352e = (MapOverlayViewGroup) mapFlowView.getTag(R.id.id_mapflow_overlayviewgroup);
        }
    }

    public void addBottomMask(int i) {
        this.f16356i = i;
        if (this.f16354g == null) {
            m13706a();
        }
        if (i > 0) {
            if (this.f16354g.getParent() != null) {
                ((ViewGroup) this.f16354g.getParent()).removeView(this.f16354g);
            }
            int i2 = 0;
            while (i2 < this.f16350c.getChildCount()) {
                Object tag = this.f16350c.getChildAt(i2).getTag();
                if (tag == null || !(tag instanceof Integer) || ((Integer) tag).intValue() != this.f16355h) {
                    i2++;
                } else {
                    ((RelativeLayout.LayoutParams) this.f16350c.getChildAt(i2).getLayoutParams()).height = i;
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(12);
            this.f16350c.addView(this.f16354g, layoutParams);
        }
    }

    public void removeBottomMask() {
        int i = 0;
        while (true) {
            if (i >= this.f16350c.getChildCount()) {
                i = -1;
                break;
            }
            Object tag = this.f16350c.getChildAt(i).getTag();
            if (tag != null && (tag instanceof Integer) && ((Integer) tag).intValue() == this.f16355h) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            this.f16350c.removeViewAt(i);
        }
    }

    /* renamed from: a */
    private void m13706a() {
        View view = new View(this.f16349b);
        this.f16354g = view;
        view.setTag(Integer.valueOf(this.f16355h));
        this.f16354g.setBackgroundResource(R.drawable.tab_gradient_bg);
    }

    public void setPresenter(AbsMapFlowDelegatePresenter absMapFlowDelegatePresenter) {
        this.f16348a = absMapFlowDelegatePresenter;
    }

    public MapFlowView getMapFlowView() {
        return this.f16350c;
    }

    public void showPopup(String str, int i, int i2) {
        if (this.f16350c != null) {
            if (this.f16351d == null) {
                if (this.f16349b instanceof Activity) {
                    this.f16351d = new TipsContainer((Activity) this.f16349b);
                } else {
                    return;
                }
            }
            TipsView tipsView = new TipsView(this.f16349b);
            tipsView.setTips(str);
            tipsView.setId(this.f16350c.hashCode());
            tipsView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (MapFlowDelegateView.this.f16351d != null) {
                        MapFlowDelegateView.this.f16351d.clearAllTips();
                    }
                }
            });
            this.f16351d.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (MapFlowDelegateView.this.f16351d == null) {
                        return false;
                    }
                    MapFlowDelegateView.this.f16351d.clearAllTips();
                    MapFlowDelegateView.this.f16351d.setOnTouchListener((View.OnTouchListener) null);
                    return false;
                }
            });
            this.f16351d.show(tipsView, this.f16350c, 0, 0, i, i2, false);
        }
    }

    public void dismissPopup() {
        TipsContainer tipsContainer = this.f16351d;
        if (tipsContainer != null) {
            tipsContainer.clearAllTips();
            this.f16351d.setOnTouchListener((View.OnTouchListener) null);
            this.f16351d = null;
        }
    }

    public void showMapOverlayView(final MapOverlayViewGroup.OverlayViewsBuilder overlayViewsBuilder) {
        if (this.f16350c != null) {
            if (this.f16352e == null) {
                MapOverlayViewGroup mapOverlayViewGroup = new MapOverlayViewGroup(this.f16349b, this.f16350c);
                this.f16352e = mapOverlayViewGroup;
                this.f16350c.setTag(R.id.id_mapflow_overlayviewgroup, mapOverlayViewGroup);
            }
            C67623 r0 = new MapOverlayViewGroup.OverlayViewsBuilder() {
                public View getOverlayContentView(Context context) {
                    MapOverlayViewGroup.OverlayViewsBuilder overlayViewsBuilder = overlayViewsBuilder;
                    if (overlayViewsBuilder != null) {
                        return overlayViewsBuilder.getOverlayContentView(context);
                    }
                    return null;
                }
            };
            this.f16352e.clearAllOverlayViews();
            this.f16352e.buildOverlayViews(r0);
            this.f16352e.attachToMapFlowView();
        }
    }

    public void dismissMapOverlayView() {
        MapOverlayViewGroup mapOverlayViewGroup = this.f16352e;
        if (mapOverlayViewGroup != null) {
            mapOverlayViewGroup.detachFromMapFlowView();
            this.f16350c.setTag(R.id.id_mapflow_overlayviewgroup, (Object) null);
        }
    }
}
