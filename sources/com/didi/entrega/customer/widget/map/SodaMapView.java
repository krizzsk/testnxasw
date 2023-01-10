package com.didi.entrega.customer.widget.map;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.Projection;
import com.didi.common.map.UiSettings;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.map.OnMapInitCallback;
import com.didi.entrega.customer.map.marker.ReceiverMarker;
import com.didi.entrega.customer.map.marker.SenderMarker;
import com.didi.entrega.customer.map.model.BestViewModel;
import com.didi.foundation.sdk.map.MapViewImpl;
import com.didichuxing.dfbasesdk.utils.UIHandler;

public class SodaMapView extends RelativeLayout {

    /* renamed from: a */
    private static final int f22449a = 1000;

    /* renamed from: b */
    private Map f22450b;

    /* renamed from: c */
    private MapViewImpl f22451c;

    /* renamed from: d */
    private boolean f22452d = false;

    /* renamed from: e */
    private OnMapReadyCallBack f22453e;

    public void onPause() {
    }

    public SodaMapView(Context context) {
        super(context);
        m18479a();
    }

    public SodaMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18479a();
    }

    public SodaMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18479a();
    }

    public void centerBestView(BestViewModel bestViewModel, BestViewer.IBestViewListener iBestViewListener) {
        BestViewModel bestViewModel2 = bestViewModel;
        if (this.f22452d) {
            BestViewer.setDefaultDuration(1000);
            if (bestViewModel2.mIncludes.size() == 1) {
                BestViewer.doBestView(this.f22450b, true, Float.valueOf(15.0f), bestViewModel2.mIncludes.get(0), bestViewModel2.mPadding, iBestViewListener);
            } else {
                BestViewer.doBestView(this.f22450b, true, (LatLng) null, bestViewModel2.mIncludes, bestViewModel2.mPadding, (Padding) null, iBestViewListener);
            }
        }
    }

    public void centerBestZoomView(BestViewModel bestViewModel) {
        if (this.f22452d && bestViewModel != null && bestViewModel.mIncludes.size() > 0) {
            BestViewer.setDefaultDuration(1000);
            BestViewer.doBestView(this.f22450b, true, bestViewModel.zoomCenter, bestViewModel.mIncludes, bestViewModel.mPadding, (Padding) null);
        }
    }

    public void centerBestZoomViewNoAnimation(BestViewModel bestViewModel) {
        if (this.f22452d && bestViewModel != null && bestViewModel.mIncludes.size() > 0) {
            BestViewer.doBestView(this.f22450b, false, bestViewModel.zoomCenter, bestViewModel.mIncludes, bestViewModel.mPadding, (Padding) null);
        }
    }

    public MapViewImpl getMapImpl() {
        return this.f22451c;
    }

    public void getSodaMapAsync(OnMapReadyCallBack onMapReadyCallBack) {
        if (this.f22452d) {
            onMapReadyCallBack.onMapReady(this.f22450b);
        } else {
            this.f22453e = onMapReadyCallBack;
        }
    }

    public PointF getScreenLocation(LatLng latLng) {
        Projection projection = this.f22450b.getProjection();
        if (projection == null || latLng == null) {
            return null;
        }
        try {
            return projection.toScreenLocation(latLng);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PointF getVisibleRegionCenterInScreen() {
        if (this.f22452d) {
            return getMapImpl().getDidiCommonMap().getVisibleRegionCenterInScreen();
        }
        return new PointF();
    }

    public void setTopViewToCenter(View view) {
        if (this.f22452d) {
            UIHandler.post(new Runnable(view) {
                public final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SodaMapView.this.m18480a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18480a(View view) {
        getMapImpl().getDidiCommonMap().setTopViewToCenter(view, 0.5f, 1.0f);
    }

    public void setMapGestureEnable(boolean z) {
        if (this.f22452d && getMapImpl().getDidiCommonMap().getUiSettings() != null) {
            getMapImpl().getDidiCommonMap().getUiSettings().setAllGesturesEnabled(z);
            getMapImpl().getDidiCommonMap().getUiSettings().setZoomEnabled(z);
        }
    }

    public void removeTopView() {
        if (this.f22452d) {
            UIHandler.post(new Runnable() {
                public final void run() {
                    SodaMapView.this.m18482b();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18482b() {
        getMapImpl().getDidiCommonMap().removeTopView();
    }

    public LatLng getMapCenterLatLng() {
        if (this.f22452d) {
            return getMapImpl().getDidiCommonMap().getMapVisibleRegionCenter();
        }
        return null;
    }

    public void onDestroy() {
        if (this.f22452d) {
            GlobalContext.onMapDestroy();
            this.f22451c.clearElements();
            this.f22453e = null;
        }
    }

    public void onResume() {
        GlobalContext.onMapResume();
    }

    public void removeAllElement() {
        if (this.f22452d && this.f22451c != null) {
            removeTopView();
            this.f22451c.removeElement(SenderMarker.TAG_SENDER_ADDRESS_MARKER);
            this.f22451c.removeElement(ReceiverMarker.TAG_RECEIVER_ADDRESS_MARKER);
            this.f22451c.removeElement("tag_rider_marker");
        }
    }

    /* renamed from: a */
    private void m18479a() {
        GlobalContext.initMapView(new OnMapInitCallback() {
            public final void onMapInitFinish(Map map) {
                SodaMapView.this.m18481a(map);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18481a(Map map) {
        this.f22452d = true;
        this.f22450b = map;
        MapViewImpl mapViewImpl = new MapViewImpl(getContext(), this.f22450b);
        this.f22451c = mapViewImpl;
        mapViewImpl.setAllGesturesEnable(true);
        this.f22451c.setRotateGesturesEnabled(false);
        this.f22451c.setTiltEnabled(false);
        this.f22451c.hideTrafficRoute();
        OnMapReadyCallBack onMapReadyCallBack = this.f22453e;
        if (onMapReadyCallBack != null) {
            onMapReadyCallBack.onMapReady(map);
        }
    }

    public void setLogoVisibility(boolean z) {
        UiSettings uiSettings;
        if (this.f22452d && (uiSettings = this.f22451c.getDidiCommonMap().getUiSettings()) != null) {
            uiSettings.setLogoVisibility(z ? 0 : 8);
        }
    }
}
