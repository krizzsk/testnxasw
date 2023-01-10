package com.didi.map.sdk.nav.car;

import android.content.Context;
import android.os.AsyncTask;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarIconsPreloader {

    /* renamed from: a */
    private static final String f30822a = "CarIconsPreloader";

    /* renamed from: b */
    private static final CarIconsPreloader f30823b = new CarIconsPreloader();

    /* renamed from: c */
    private static final int f30824c = 30;

    /* renamed from: d */
    private static final float f30825d = 0.8f;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f30826e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile CopyOnWriteArrayList<LatLng> f30827f = new CopyOnWriteArrayList<>();

    /* renamed from: g */
    private int f30828g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f30829h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f30830i = 30;

    /* renamed from: j */
    private int f30831j = 24;

    /* renamed from: k */
    private boolean f30832k = false;

    private CarIconsPreloader() {
    }

    public static CarIconsPreloader getInstance() {
        return f30823b;
    }

    public void set3DCarEnabled(boolean z) {
        this.f30832k = z;
    }

    public void setRoutePoints(Context context, List<LatLng> list) {
        if (context != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f30826e = context.getApplicationContext();
            this.f30827f.clear();
            this.f30827f.addAll(list);
            int size = list.size();
            this.f30828g = size;
            this.f30829h = 0;
            if (size <= 30) {
                this.f30830i = size - 1;
                this.f30831j = size - 1;
            } else {
                this.f30830i = 30;
                this.f30831j = 24;
            }
            m23714a();
        }
    }

    public void preloadCarIcons(int i) {
        int i2;
        if (this.f30832k && this.f30827f != null && (i2 = this.f30828g) > 0 && i > this.f30831j && i < i2 - 1) {
            int i3 = this.f30830i;
            this.f30829h = i3;
            int i4 = i3 + 30;
            this.f30830i = i4;
            if (i4 > i2) {
                this.f30830i = i2 - 1;
                this.f30831j = i2 - 1;
            } else {
                this.f30831j = (int) (((float) i4) * 0.8f);
            }
            m23714a();
        }
    }

    /* renamed from: a */
    private void m23714a() {
        int i;
        int i2;
        if (this.f30832k && !CollectionUtil.isEmpty((Collection<?>) this.f30827f) && CarAngleUtil.CAR_ICONS_CACHE.size() < CarAngleUtil.CAR_ICONS_COUNT && (i = this.f30828g) != 0 && (i2 = this.f30829h) < this.f30830i && i2 < i - 1) {
            try {
                new PreloadAsyncTask().execute(new Void[0]);
            } catch (Exception e) {
                DLog.m10773d(f30822a, "loadCarIcons: %s ", e.toString());
            }
        }
    }

    private class PreloadAsyncTask extends AsyncTask<Void, Void, Void> {
        private PreloadAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            int i;
            if (CollectionUtil.isEmpty((Collection<?>) CarIconsPreloader.this.f30827f)) {
                return null;
            }
            int b = CarIconsPreloader.this.f30829h;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (b > CarIconsPreloader.this.f30830i - 2 || CollectionUtil.isEmpty((Collection<?>) CarIconsPreloader.this.f30827f) || (i = b + 2) >= CarIconsPreloader.this.f30827f.size()) {
                    break;
                }
                try {
                    LatLng latLng = (LatLng) CarIconsPreloader.this.f30827f.get(b);
                    b++;
                    LatLng latLng2 = (LatLng) CarIconsPreloader.this.f30827f.get(b);
                    LatLng latLng3 = (LatLng) CarIconsPreloader.this.f30827f.get(i);
                    if (latLng == null || latLng2 == null) {
                        break;
                    } else if (latLng3 == null) {
                        break;
                    } else {
                        if (!latLng.toString().equals(latLng2.toString())) {
                            i2 = CarAngleUtil.getIndexByLocation(latLng, latLng2);
                        }
                        if (!latLng2.toString().equals(latLng3.toString())) {
                            i3 = CarAngleUtil.getIndexByLocation(latLng2, latLng3);
                        }
                        List<Integer> rotateIndexes = CarAngleUtil.getRotateIndexes(i2, i3);
                        if (rotateIndexes != null) {
                            if (rotateIndexes.size() != 0) {
                                for (Integer intValue : rotateIndexes) {
                                    int intValue2 = intValue.intValue();
                                    if (!CarAngleUtil.isCarIconCache(intValue2)) {
                                        CarAngleUtil.getCarBitmapDescriptor(CarIconsPreloader.this.f30826e, intValue2);
                                    }
                                }
                            }
                        }
                        if (!CarAngleUtil.isCarIconCache(i2)) {
                            CarAngleUtil.getCarBitmapDescriptor(CarIconsPreloader.this.f30826e, i2);
                        }
                    }
                } catch (Exception e) {
                    DLog.m10773d("3dcar", "CarIconsPreloader Exception:" + e.toString(), new Object[0]);
                }
            }
            DLog.m10773d("3dcar", "CarIconsPreloader cache size:" + CarAngleUtil.CAR_ICONS_CACHE.size(), new Object[0]);
            return null;
        }
    }

    public void destory() {
        this.f30827f.clear();
        this.f30828g = 0;
        this.f30829h = 0;
        this.f30830i = 30;
        this.f30831j = 24;
        this.f30832k = false;
    }
}
