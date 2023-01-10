package com.didi.entrega.customer.map.marker;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.MapUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.map.infowindow.AbInfoWindowView;
import com.didi.entrega.customer.map.infowindow.InfoWindowOptions;
import com.didi.entrega.customer.map.infowindow.MapInfoWindowManager;
import com.didi.foundation.sdk.map.IMapView;
import com.didi.global.map.animation.util.AngleUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public abstract class AbsMarker {
    protected static final String TAG = "AbsMarker";

    /* renamed from: d */
    private static final int f22044d = 4;

    /* renamed from: a */
    private Marker f22045a;

    /* renamed from: b */
    private IMapView f22046b;

    /* renamed from: c */
    private ICompLineContract f22047c;

    /* renamed from: e */
    private boolean f22048e = false;
    protected Context mContext;
    protected InfoWindow mInfoWindow;
    protected AbInfoWindowView mInfoWindowView;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MarkerShownScene {
        public static final int FromBill = 1;
        public static final int FromOrder = 2;
    }

    public abstract String getTag();

    public void onAdd() {
    }

    public abstract void show(LatLng latLng);

    AbsMarker(Context context, IMapView iMapView) {
        this.mContext = context;
        this.f22046b = iMapView;
    }

    public void updateMapView(IMapView iMapView) {
        if (this.f22046b == null) {
            this.f22046b = iMapView;
        }
    }

    public Marker getMarker() {
        return this.f22045a;
    }

    public void setVisible(boolean z) {
        Marker marker = this.f22045a;
        if (marker != null) {
            marker.setVisible(z);
        }
    }

    public boolean isVisible() {
        Marker marker = this.f22045a;
        if (marker == null) {
            return false;
        }
        return marker.isVisible();
    }

    public boolean isExist() {
        return this.f22048e;
    }

    public void removeLine() {
        ICompLineContract iCompLineContract = this.f22047c;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f22047c = null;
        }
    }

    /* access modifiers changed from: protected */
    public void draw(MarkerOptions markerOptions) {
        if (this.f22048e) {
            remove();
        }
        IMapView iMapView = this.f22046b;
        if (iMapView != null) {
            this.f22045a = iMapView.addMarker(getTag(), markerOptions);
            this.f22048e = true;
            onAdd();
        }
        setVisible(true);
    }

    /* access modifiers changed from: protected */
    public void draw(MarkerOptions markerOptions, List<LatLng> list) {
        if (this.f22048e) {
            remove();
        }
        if (this.f22046b != null) {
            if (list != null && list.size() == 2) {
                LineParams lineParams = new LineParams(list, ResourceHelper.getColor(R.color.rf_color_gery_2_40_666666), 4);
                lineParams.setEnableEarthWormLine(false);
                lineParams.setZIndex(10);
                lineParams.setLinePoints(list);
                lineParams.setEnableDirArrow(false);
                if (m18287a(list.get(0), list.get(1))) {
                    this.f22047c = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_ARC, this.f22046b.getDidiCommonMap(), this.mContext, lineParams);
                } else {
                    this.f22047c = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f22046b.getDidiCommonMap(), this.mContext, lineParams);
                }
                this.f22047c.start();
            }
            this.f22045a = this.f22046b.addMarker(getTag(), markerOptions);
            this.f22048e = true;
            onAdd();
        }
    }

    public void remove() {
        removeInfoWindow();
        IMapView iMapView = this.f22046b;
        if (iMapView != null) {
            iMapView.removeElement(getTag());
        }
        if (this.f22047c != null) {
            LogUtil.m18185i(TAG, "line called destroy method start in  remove");
            this.f22047c.destroy();
            LogUtil.m18185i(TAG, "line called destroy method end in  remove");
        }
        this.mInfoWindow = null;
        this.mInfoWindowView = null;
        this.f22048e = false;
    }

    public void onDestroy() {
        removeInfoWindow();
        LogUtil.m18185i(TAG, "AbsMarker----start");
        IMapView iMapView = this.f22046b;
        if (iMapView != null) {
            iMapView.removeElement(getTag());
        }
        if (this.f22047c != null) {
            LogUtil.m18185i(TAG, "line called destroy method start in onDestroy");
            this.f22047c.destroy();
            this.f22047c = null;
            LogUtil.m18185i(TAG, "line called destroy method end in  onDestroy");
        }
        this.f22045a = null;
        this.mInfoWindow = null;
        this.mInfoWindowView = null;
        this.f22048e = false;
        LogUtil.m18185i(TAG, "AbsMarker----end");
    }

    public void hideInfoWindow() {
        m18286a(false);
    }

    public void showInfoWindow() {
        m18286a(true);
    }

    /* renamed from: a */
    private void m18286a(boolean z) {
        MapInfoWindowManager.Companion.getInstance().setInfoWindowVisible(this.f22045a, z);
    }

    public InfoWindow buildInfoWindow(Context context, InfoWindowOptions infoWindowOptions) {
        return MapInfoWindowManager.Companion.getInstance().createInfoWindow(this.f22045a, this.f22046b, infoWindowOptions, context);
    }

    public void removeInfoWindow() {
        MapInfoWindowManager.Companion.getInstance().removeInfoWindow(this.f22045a);
    }

    /* renamed from: a */
    private boolean m18287a(LatLng latLng, LatLng latLng2) {
        double angle = (double) AngleUtil.getAngle(latLng, latLng2);
        return Math.abs(angle) % 90.0d > 15.0d && Math.abs(angle) % 90.0d < 90.0d;
    }

    /* access modifiers changed from: protected */
    public void setIcon(Context context, BitmapDescriptor bitmapDescriptor) {
        Marker marker = this.f22045a;
        if (marker != null && this.f22046b != null) {
            marker.setIcon(context, bitmapDescriptor);
        }
    }

    public void updateInfoWindow(InfoWindowViewBuildConfig infoWindowViewBuildConfig, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (infoWindowViewBuildConfig != null && !TextUtils.isEmpty(infoWindowViewBuildConfig.getTitle())) {
            if (this.mInfoWindowView == null) {
                this.mInfoWindowView = InfoWindowViewFactory.Companion.getInstance().createInfoViewByCategory(this.mContext, infoWindowViewBuildConfig);
            }
            this.mInfoWindowView.updateView(infoWindowViewBuildConfig);
            InfoWindow infoWindow = this.mInfoWindow;
            if (infoWindow == null || infoWindow.getInfoWindowMarker() == null) {
                this.mInfoWindow = buildInfoWindow(GlobalContext.getContext(), new InfoWindowOptions.Builder(this.mInfoWindowView).setPosition(InfoWindow.Position.TOP).setVisible(true).setZIndex(14).build());
            } else {
                this.mInfoWindow.getInfoWindowMarker().setIcon(GlobalContext.getContext(), BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(this.mInfoWindowView)));
                this.mInfoWindow.getInfoWindowMarker().setVisible(true);
            }
            InfoWindow infoWindow2 = this.mInfoWindow;
            if (infoWindow2 != null) {
                infoWindow2.addOnInfoWindowClickListener(onInfoWindowClickListener);
            }
        } else if (this.mInfoWindow != null) {
            removeInfoWindow();
            this.mInfoWindow = null;
            this.mInfoWindowView = null;
        }
    }
}
