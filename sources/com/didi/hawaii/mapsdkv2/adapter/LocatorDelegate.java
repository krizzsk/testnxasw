package com.didi.hawaii.mapsdkv2.adapter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import com.didi.hawaii.mapsdkv2.common.DataUtil;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.GLLocator;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.Resources;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.map.alpha.maps.internal.ILocatorDelegate;
import com.didi.map.alpha.maps.internal.LocatorControl;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.CompassDescriptor;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.Locator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class LocatorDelegate extends C9761b implements ILocatorDelegate {

    /* renamed from: b */
    private final GLLocator f25960b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Locator f25961c;

    public void setCompassZIndex(float f) {
    }

    public LocatorDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        super(gLViewManager, map);
        GLLocator locator = gLViewManager.getBaseMap().getLocator();
        this.f25960b = locator;
        if (locator != null) {
            locator.setOnNaviModeChangeListener(new GLLocator.OnNaviModeChangeListener() {
                public void onChange(int i) {
                    if (LocatorDelegate.this.f25961c != null) {
                        LocatorDelegate.this.f25961c.setNaviMode(i);
                    }
                }
            });
        }
    }

    public void setCarVisible(boolean z) {
        this.f25960b.setCarVisible(z);
    }

    public boolean isCarVisible() {
        return this.f25960b.isCarVisible();
    }

    public void setCompassVisible(boolean z) {
        this.f25960b.setCompassVisible(z);
    }

    public boolean isCompassVisible() {
        return this.f25960b.isCompassVisible();
    }

    public Locator getLocator(LocatorControl locatorControl) {
        if (this.f25961c == null) {
            this.f25961c = new Locator(locatorControl);
        }
        return this.f25961c;
    }

    public LatLng getPosition() {
        return this.f25960b.getPosition();
    }

    public void setPositionAndAngle(LatLng latLng, float f) {
        this.f25960b.setPositionAndAngle(latLng, f);
    }

    public void setCarIcon(BitmapDescriptor bitmapDescriptor) {
        Bitmap bitmap;
        if (bitmapDescriptor != null && (bitmap = bitmapDescriptor.getBitmap(this.viewManager.getMapContext().getAndroidContext())) != null) {
            this.f25960b.setCarTexture(Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap));
        }
    }

    public RectF getPiexBound(float f) {
        return this.f25960b.getPiexBound(f);
    }

    public void setCompassIcon(CompassDescriptor compassDescriptor) {
        if (compassDescriptor.getCompassBack() != null) {
            Bitmap bitmap = compassDescriptor.getCompassBack().getBitmap(this.viewManager.getMapContext().getAndroidContext());
            Bitmap bitmap2 = compassDescriptor.getNorth().getBitmap(this.viewManager.getMapContext().getAndroidContext());
            Bitmap bitmap3 = compassDescriptor.getSouth().getBitmap(this.viewManager.getMapContext().getAndroidContext());
            Bitmap bitmap4 = compassDescriptor.getEast().getBitmap(this.viewManager.getMapContext().getAndroidContext());
            Bitmap bitmap5 = compassDescriptor.getWest().getBitmap(this.viewManager.getMapContext().getAndroidContext());
            if (bitmap != null && bitmap2 != null && bitmap3 != null && bitmap4 != null && bitmap5 != null) {
                Resources resources = this.viewManager.getMapContext().getResources();
                this.f25960b.setCompassTexture(Texture.bitmap(resources, bitmap), Texture.bitmap(resources, bitmap2), Texture.bitmap(resources, bitmap3), Texture.bitmap(resources, bitmap4), Texture.bitmap(resources, bitmap5));
            }
        }
    }

    public float getAngle() {
        return this.f25960b.getAngle();
    }

    public void setCarZIndex(float f) {
        this.f25960b.setZIndex((int) f);
    }

    public void setNaviMode(int i) {
        if (i == 1) {
            this.f25960b.setNaviMode(1);
        } else if (i != 2) {
            this.f25960b.setNaviMode(0);
        } else {
            this.f25960b.setNaviMode(2);
        }
    }

    public int getNaviMode() {
        int naviMode = this.f25960b.getNaviMode();
        int i = 1;
        if (naviMode != 1) {
            i = 2;
            if (naviMode != 2) {
                return 0;
            }
        }
        return i;
    }

    public Rect getBound() {
        LatLngBounds geoBound = this.f25960b.getGeoBound();
        if (geoBound != null) {
            return DataUtil.toRect(geoBound);
        }
        return null;
    }

    public Rect getScreenBound() {
        RectF screenBound = this.f25960b.getScreenBound();
        if (screenBound != null) {
            return new Rect((int) screenBound.left, (int) screenBound.top, (int) screenBound.right, (int) screenBound.bottom);
        }
        return null;
    }

    public void showGuideLine(boolean z) {
        this.f25960b.showGuideLine(z);
    }

    public void setDestination(LatLng latLng) {
        this.f25960b.setGuideLineDestination(latLng);
    }

    public boolean navigateToPosition(boolean z, LatLng latLng, float f, float f2, int i, int i2, boolean z2, long j, long j2) {
        return this.f25960b.navigateToPosition(z, latLng, f, f2, i, i2, z2, j, j2);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f) {
        this.f25960b.navigateToPosition(z, latLng, f);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f, float f2, float f3, float f4) {
        this.f25960b.navigateToPosition(z, latLng, f, f2, f4, (float) MathsUtils.getScale((double) f3));
    }

    public void navigateToPosition(boolean z, float f, float f2, float f3, float f4, float f5, List<LatLng> list, int i, int i2, LatLng latLng) {
        ArrayList arrayList;
        int i3;
        List<LatLng> list2 = list;
        int i4 = i2;
        LatLng latLng2 = latLng;
        if (!z || list2 == null || (i3 = i4 - i) <= 0) {
            arrayList = new ArrayList(1);
        } else {
            ArrayList arrayList2 = new ArrayList(i3 + 1);
            int i5 = i;
            while (i5 < i4) {
                if (i5 <= list.size() - 1) {
                    arrayList2.add(list2.get(i5));
                    i5++;
                } else {
                    return;
                }
            }
            arrayList = arrayList2;
        }
        if (latLng2 != null) {
            arrayList.add(new LatLng(latLng2.latitude, latLng2.longitude));
        }
        if (arrayList.size() != 0) {
            this.f25960b.navigateToPosition(z, arrayList, f, f2, (float) MathsUtils.getScale((double) f4), f3, f5);
        }
    }

    public void stopNavigate() {
        this.f25960b.stopAnimation();
    }
}
