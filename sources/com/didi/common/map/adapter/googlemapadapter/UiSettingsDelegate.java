package com.didi.common.map.adapter.googlemapadapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.common.map.internal.IUiSettingsDelegate;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DLog;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;

public class UiSettingsDelegate implements IUiSettingsDelegate {

    /* renamed from: a */
    private GoogleMap f12614a;

    /* renamed from: b */
    private UiSettings f12615b;

    /* renamed from: c */
    private ImageView f12616c;

    /* renamed from: d */
    private Handler f12617d = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Bundle data = message.getData();
                UiSettingsDelegate.this.m10726a(data.getInt("top", 0), data.getInt("bottom", 0), data.getInt("left", 0), data.getInt("right", 0));
            }
        }
    };

    public void setCompassPadding(int i, int i2) throws MapNotExistApiException {
    }

    public void setLogoGravity(int i) {
    }

    public void setScaleGravity(int i) {
    }

    public void setScaleGravityWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void setScaleViewEnabled(boolean z) {
    }

    public void setTouchEnabled(boolean z) throws MapNotExistApiException {
    }

    public void setZoomFromCenterByDoubleClickEnabled(boolean z) throws MapNotExistApiException {
    }

    public void setZoomFromCenterByGestureEnabled(boolean z) throws MapNotExistApiException {
    }

    public UiSettingsDelegate(GoogleMap googleMap, ImageView imageView) {
        this.f12614a = googleMap;
        this.f12615b = googleMap.getUiSettings();
        this.f12616c = imageView;
    }

    public void setCompassEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings != null) {
            uiSettings.setCompassEnabled(z);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings != null) {
            uiSettings.setMyLocationButtonEnabled(z);
        }
    }

    public void setLogoGravityWithMargin(int i, int i2, int i3, int i4, int i5) {
        if (this.f12617d != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            Bundle bundle = new Bundle();
            bundle.putInt("top", i2);
            bundle.putInt("bottom", i3);
            bundle.putInt("left", i4);
            bundle.putInt("right", i5);
            obtain.setData(bundle);
            this.f12617d.removeMessages(1);
            this.f12617d.sendMessageDelayed(obtain, 100);
            return;
        }
        m10726a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10726a(int i, int i2, int i3, int i4) {
        if (this.f12616c != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f12616c.getLayoutParams());
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = i2;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i4;
            layoutParams.addRule(12);
            this.f12616c.setLayoutParams(layoutParams);
            DLog.m10773d("dev_logo", "top = " + i + "; bottom = " + i2 + "; left = " + i3 + "; right = " + i4, new Object[0]);
        }
    }

    public void setLogoVisibility(int i) {
        ImageView imageView = this.f12616c;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public boolean isZoomControlsEnabled() throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings == null) {
            return false;
        }
        return uiSettings.isZoomControlsEnabled();
    }

    public void setZoomControlsEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings != null) {
            uiSettings.setZoomControlsEnabled(z);
        }
    }

    public boolean isZoomEnabled() throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings != null) {
            return uiSettings.isZoomGesturesEnabled();
        }
        return false;
    }

    public void setZoomEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings != null) {
            uiSettings.setZoomGesturesEnabled(z);
        }
    }

    public boolean isScrollEnabled() throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings == null) {
            return false;
        }
        return uiSettings.isScrollGesturesEnabled();
    }

    public void setScrollEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings != null) {
            uiSettings.setScrollGesturesEnabled(z);
        }
    }

    public boolean isTiltEnabled() throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings == null) {
            return false;
        }
        return uiSettings.isTiltGesturesEnabled();
    }

    public void setTiltEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings != null) {
            uiSettings.setTiltGesturesEnabled(z);
        }
    }

    public boolean isRotateGesturesEnabled() throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings == null) {
            return false;
        }
        return uiSettings.isRotateGesturesEnabled();
    }

    public void setRotateGesturesEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings != null) {
            uiSettings.setRotateGesturesEnabled(z);
        }
    }

    public void setAllGesturesEnabled(boolean z) throws MapNotExistApiException {
        UiSettings uiSettings = this.f12615b;
        if (uiSettings != null) {
            uiSettings.setAllGesturesEnabled(z);
        }
    }

    public void clear() throws MapNotExistApiException {
        Handler handler = this.f12617d;
        if (handler != null) {
            handler.removeMessages(1);
            this.f12617d = null;
        }
    }
}
