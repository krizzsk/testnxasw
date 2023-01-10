package com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.widget.ImageView;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.ImageUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.flow.scene.vamos.sctx.driver.omega.VamosDriverSctxOmegaUtil;
import com.didi.map.sdk.passengerlocation.PassengerInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PassengerMarkerDrawer {

    /* renamed from: a */
    private static final int f29678a = 30000;

    /* renamed from: b */
    private static final String f29679b = "PassengerMarkerDrawer";

    /* renamed from: c */
    private Context f29680c;

    /* renamed from: d */
    private Map f29681d;

    /* renamed from: e */
    private List<PassengerMarkerSet> f29682e = new ArrayList();

    /* renamed from: f */
    private final Object f29683f = new Object();

    public PassengerMarkerDrawer(Map map, Context context) {
        this.f29681d = map;
        this.f29680c = context;
    }

    public List<PassengerMarkerSet> getPassengerMarkers() {
        return this.f29682e;
    }

    public void removePassengerMarkers() {
        synchronized (this.f29683f) {
            if (this.f29682e != null && !this.f29682e.isEmpty()) {
                for (PassengerMarkerSet next : this.f29682e) {
                    DLog.m10773d(f29679b, "removePassengerMarkers:" + next.f29684id, new Object[0]);
                    if (!(next.marker == null || this.f29681d == null)) {
                        this.f29681d.remove(next.marker);
                        next.marker = null;
                    }
                    if (!(next.marker_direct == null || this.f29681d == null)) {
                        this.f29681d.remove(next.marker_direct);
                        next.marker_direct = null;
                    }
                }
                this.f29682e.clear();
                this.f29682e = null;
            }
        }
    }

    public void removeInvalidPassengerMarkers(List<PassengerInfo> list) {
        boolean z;
        DLog.m10773d(f29679b, "removeInvalidPassengerMarkers start", new Object[0]);
        synchronized (this.f29683f) {
            if (this.f29682e != null) {
                for (int size = this.f29682e.size(); size > 0; size--) {
                    int i = size - 1;
                    PassengerMarkerSet passengerMarkerSet = this.f29682e.get(i);
                    if (passengerMarkerSet != null) {
                        DLog.m10773d(f29679b, "removeInvalidPassengerMarkers list:" + passengerMarkerSet.f29684id, new Object[0]);
                        if (list != null && list.size() > 0) {
                            Iterator<PassengerInfo> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().getId().equalsIgnoreCase(passengerMarkerSet.f29684id)) {
                                        DLog.m10773d(f29679b, "exist passenger id： " + passengerMarkerSet.f29684id, new Object[0]);
                                        z = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            if (this.f29681d != null) {
                                if (passengerMarkerSet.marker != null) {
                                    this.f29681d.remove(passengerMarkerSet.marker);
                                    passengerMarkerSet.marker = null;
                                }
                                if (passengerMarkerSet.marker_direct != null) {
                                    this.f29681d.remove(passengerMarkerSet.marker_direct);
                                    passengerMarkerSet.marker_direct = null;
                                }
                                DLog.m10773d(f29679b, "removeMarkerSet : ok", new Object[0]);
                            }
                            this.f29682e.remove(i);
                            DLog.m10773d(f29679b, "removeMarkerSet : " + passengerMarkerSet.f29684id, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private PassengerMarkerSet m23004a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f29683f) {
            if (this.f29682e != null) {
                for (PassengerMarkerSet next : this.f29682e) {
                    if (next != null && str.compareTo(next.f29684id) == 0) {
                        return next;
                    }
                }
            } else {
                this.f29682e = new ArrayList();
            }
            PassengerMarkerSet passengerMarkerSet = new PassengerMarkerSet(str);
            this.f29682e.add(passengerMarkerSet);
            return passengerMarkerSet;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m23005a(com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f29683f
            monitor-enter(r0)
            if (r5 != 0) goto L_0x0007
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x0007:
            com.didi.common.map.Map r1 = r4.f29681d     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0041
            com.didi.common.map.model.Marker r1 = r5.marker     // Catch:{ all -> 0x004c }
            r2 = 0
            if (r1 == 0) goto L_0x0019
            com.didi.common.map.Map r1 = r4.f29681d     // Catch:{ all -> 0x004c }
            com.didi.common.map.model.Marker r3 = r5.marker     // Catch:{ all -> 0x004c }
            r1.remove(r3)     // Catch:{ all -> 0x004c }
            r5.marker = r2     // Catch:{ all -> 0x004c }
        L_0x0019:
            com.didi.common.map.model.Marker r1 = r5.marker_direct     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0026
            com.didi.common.map.Map r1 = r4.f29681d     // Catch:{ all -> 0x004c }
            com.didi.common.map.model.Marker r3 = r5.marker_direct     // Catch:{ all -> 0x004c }
            r1.remove(r3)     // Catch:{ all -> 0x004c }
            r5.marker_direct = r2     // Catch:{ all -> 0x004c }
        L_0x0026:
            java.lang.String r1 = "PassengerMarkerDrawer"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r2.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "removeMarkerSet : "
            r2.append(r3)     // Catch:{ all -> 0x004c }
            java.lang.String r3 = r5.f29684id     // Catch:{ all -> 0x004c }
            r2.append(r3)     // Catch:{ all -> 0x004c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004c }
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x004c }
            com.didi.common.map.util.DLog.m10773d(r1, r2, r3)     // Catch:{ all -> 0x004c }
        L_0x0041:
            java.util.List<com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet> r1 = r4.f29682e     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x004a
            java.util.List<com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet> r1 = r4.f29682e     // Catch:{ all -> 0x004c }
            r1.remove(r5)     // Catch:{ all -> 0x004c }
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x004c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerDrawer.m23005a(com.didi.map.global.flow.scene.vamos.sctx.driver.psglocation.PassengerMarkerSet):void");
    }

    public boolean addPassengerMarkers(List<PassengerInfo> list, int i) {
        boolean z;
        if (list == null || list.size() == 0) {
            return false;
        }
        DLog.m10773d(f29679b, "addPassengerMarkers:start ", new Object[0]);
        synchronized (this.f29683f) {
            z = true;
            for (PassengerInfo next : list) {
                if (next.getGpsLocation() != null) {
                    if (System.currentTimeMillis() - next.getGpsLocation().time <= 30000 || next.getGpsLocation().time == 0) {
                        if (next.getGpsLocation() != null) {
                            z = addPassengerMarker(next, i);
                        }
                    }
                }
                DLog.m10773d(f29679b, "addPassengerMarkers: passenger location is invalid!", new Object[0]);
                PassengerMarkerSet a = m23004a(next.getId());
                if (a != null) {
                    m23005a(a);
                }
            }
        }
        return z;
    }

    public boolean addPassengerMarker(PassengerInfo passengerInfo, int i) {
        PassengerMarkerSet a;
        BitmapDescriptor a2;
        BitmapDescriptor a3;
        if (passengerInfo == null || (a = m23004a(passengerInfo.getId())) == null) {
            return false;
        }
        if (a.marker != null) {
            if (LatLngUtils.locateCorrect(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude)) {
                a.marker.setPosition(new LatLng(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude));
                if (a.marker_direct != null) {
                    a.marker_direct.setPosition(new LatLng(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude));
                    a.marker_direct.setRotation(passengerInfo.getGpsLocation().direction);
                }
                DLog.m10773d(f29679b, "updatePassengerMarker:" + passengerInfo.toString(), new Object[0]);
            }
            a.marker.setZIndex(i);
            if (a.marker_direct != null) {
                a.marker_direct.setZIndex(i - 1);
            }
            if (!(passengerInfo.getHeadIcon() == null || (a3 = m23002a(passengerInfo.getHeadIcon(), a.marker.getIcon().getBitmap().getWidth(), a.marker.getIcon().getBitmap().getHeight())) == null || this.f29680c == null)) {
                a.marker.setIcon(this.f29680c, a3);
            }
        } else {
            if (LatLngUtils.locateCorrect(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude)) {
                a.marker = m23003a(R.drawable.passenger_map_location_nodirect, new LatLng(passengerInfo.getGpsLocation().latitude, passengerInfo.getGpsLocation().longitude), 0.0f, 0.5f, 0.5f, i);
                if (a.marker != null) {
                    if (!(passengerInfo.getHeadIcon() == null || (a2 = m23002a(passengerInfo.getHeadIcon(), a.marker.getIcon().getBitmap().getWidth(), a.marker.getIcon().getBitmap().getHeight())) == null || this.f29680c == null)) {
                        a.marker.setIcon(this.f29680c, a2);
                    }
                    DLog.m10773d(f29679b, "addPassengerMarker:" + passengerInfo.toString(), new Object[0]);
                }
            }
            if (!TextUtils.isEmpty(passengerInfo.getOrderId())) {
                VamosDriverSctxOmegaUtil.onPaxLocationShow();
            }
        }
        return true;
    }

    /* renamed from: a */
    private Marker m23003a(int i, LatLng latLng, float f, float f2, float f3, int i2) {
        Context context;
        if (this.f29681d == null || (context = this.f29680c) == null) {
            return null;
        }
        MarkerOptions rotation = new MarkerOptions().anchor(f2, f3).icon(BitmapDescriptorFactory.fromBitmap(m23001a(this.f29680c, BitmapDescriptorFactory.fromResource(context, i).getBitmap()))).position(new LatLng(latLng.latitude, latLng.longitude)).rotation(f);
        rotation.flat(false);
        rotation.zIndex(i2);
        return this.f29681d.addMarker(rotation);
    }

    /* renamed from: a */
    private Bitmap m23001a(Context context, Bitmap bitmap) {
        float f = context.getResources().getDisplayMetrics().density / 3.0f;
        if (f == 1.0f) {
            return bitmap;
        }
        return ImageUtil.scale(bitmap, ((float) bitmap.getWidth()) * f, ((float) bitmap.getHeight()) * f, ImageView.ScaleType.CENTER_CROP, true);
    }

    /* renamed from: a */
    private BitmapDescriptor m23002a(Bitmap bitmap, int i, int i2) {
        Bitmap extractThumbnail;
        if (bitmap == null || bitmap.isRecycled() || (extractThumbnail = ThumbnailUtils.extractThumbnail(ImageUtil.getCircleBitmap(bitmap), i, i2, 2)) == null) {
            return null;
        }
        return BitmapDescriptorFactory.fromBitmap(extractThumbnail);
    }
}
