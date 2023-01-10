package com.didi.map.sdk.passengerlocation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.common.map.Map;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.passengerlocation.IPsgLocationDataSource;
import java.util.Iterator;
import java.util.List;

public final class PsgLocationDelegateImpl implements IPassengerLocation {

    /* renamed from: a */
    private static final String f31046a = "PsgLocationDelegateImpl";

    /* renamed from: b */
    private static final int f31047b = 900;

    /* renamed from: c */
    private static final int f31048c = 3000;

    /* renamed from: d */
    private PsgLocationRunnable f31049d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f31050e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f31051f;

    /* renamed from: g */
    private LatLng f31052g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<PassengerInfo> f31053h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PassengerLocationParam f31054i;

    /* renamed from: j */
    private int f31055j = 100;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f31056k = new Handler(Looper.getMainLooper()) {
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            if (message != null && message.what == 900 && PsgLocationDelegateImpl.this.f31050e) {
                PsgLocationDelegateImpl.this.m23807a((List<PassengerInfo>) (List) message.obj);
            }
        }
    };

    public void setConfigParam(PassengerLocationParam passengerLocationParam) {
        this.f31054i = passengerLocationParam;
        this.f31055j = passengerLocationParam.locationAccuracy;
        this.f31052g = passengerLocationParam.startPoint;
        this.f31053h = passengerLocationParam.passengerInfoList;
    }

    public void start() {
        List<PassengerInfo> list = this.f31053h;
        if (list == null || list.isEmpty() || ((this.f31052g == null && this.f31051f == null) || this.f31050e)) {
            DLog.m10773d(f31046a, "start param error", new Object[0]);
            return;
        }
        for (final PassengerInfo next : this.f31053h) {
            if (!TextUtils.isEmpty(next.getHeadUrl())) {
                DLog.m10773d(f31046a, "start() headUrl: " + next.getHeadUrl(), new Object[0]);
                try {
                    Glide.with(this.f31051f).asBitmap().load(next.getHeadUrl()).into(new CustomTarget<Bitmap>(50, 50) {
                        public void onLoadCleared(Drawable drawable) {
                        }

                        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                            if (bitmap != null) {
                                next.setHeadIcon(bitmap);
                                DLog.m10773d(PsgLocationDelegateImpl.f31046a, "replace head icon", new Object[0]);
                            }
                        }
                    });
                } catch (Exception e) {
                    DLog.m10773d("glide", "start() Exception:" + e.toString(), new Object[0]);
                }
            }
        }
        if (this.f31049d == null) {
            this.f31049d = new PsgLocationRunnable();
        }
        Handler handler = this.f31056k;
        if (handler != null) {
            handler.removeCallbacks(this.f31049d);
            this.f31056k.post(this.f31049d);
            this.f31050e = true;
        }
    }

    public void stop() {
        Handler handler = this.f31056k;
        if (handler != null) {
            PsgLocationRunnable psgLocationRunnable = this.f31049d;
            if (psgLocationRunnable != null) {
                handler.removeCallbacks(psgLocationRunnable);
            }
            this.f31056k.removeMessages(900);
        }
        this.f31049d = null;
        this.f31054i = null;
        this.f31052g = null;
        this.f31053h = null;
        this.f31050e = false;
    }

    public void create(Context context, Map map) {
        this.f31051f = context.getApplicationContext();
    }

    public void destroy() {
        stop();
        this.f31051f = null;
        this.f31056k = null;
    }

    public void onMapVisible(boolean z) {
        PsgLocationRunnable psgLocationRunnable = this.f31049d;
        if (psgLocationRunnable != null) {
            psgLocationRunnable.onMapVisible(z);
        }
    }

    private final class PsgLocationRunnable implements Runnable {
        private IPsgLocationDataSource mLocationModel;

        PsgLocationRunnable() {
            this.mLocationModel = new PsgLocationDataSource(PsgLocationDelegateImpl.this.f31051f);
            if (PsgLocationDelegateImpl.this.f31054i != null) {
                this.mLocationModel.setBizType(Integer.valueOf(PaxEnvironment.getInstance().getProductId()).intValue());
                this.mLocationModel.setPhoneNum(PaxEnvironment.getInstance().getPhoneNumber());
                this.mLocationModel.setToken(PaxEnvironment.getInstance().getToken());
                this.mLocationModel.setTraverID(PsgLocationDelegateImpl.this.f31054i.travelId);
            }
        }

        public void run() {
            if (!PsgLocationDelegateImpl.this.f31050e) {
                DLog.m10773d(PsgLocationDelegateImpl.f31046a, "PsgLocationRunnable run() isStarted() is false!", new Object[0]);
                return;
            }
            DLog.m10773d(PsgLocationDelegateImpl.f31046a, "PsgLocationRunnable run() loop", new Object[0]);
            this.mLocationModel.fetchPassengerLocation(PsgLocationDelegateImpl.this.f31053h, new IPsgLocationDataSource.PsgLocationCallback() {
                public void onSuccess(List<PassengerInfo> list) {
                    if (PsgLocationDelegateImpl.this.f31056k != null && PsgLocationDelegateImpl.this.f31050e) {
                        Message obtain = Message.obtain();
                        obtain.what = 900;
                        obtain.obj = list;
                        PsgLocationDelegateImpl.this.f31056k.sendMessage(obtain);
                    }
                }
            });
            if (PsgLocationDelegateImpl.this.f31056k != null) {
                PsgLocationDelegateImpl.this.f31056k.postDelayed(this, 3000);
            }
        }

        public void onMapVisible(boolean z) {
            IPsgLocationDataSource iPsgLocationDataSource = this.mLocationModel;
            if (iPsgLocationDataSource != null) {
                iPsgLocationDataSource.onMapVisible(z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23807a(List<PassengerInfo> list) {
        for (PassengerInfo next : list) {
            if (next != null && next.getGpsLocation() != null) {
                GpsLocation gpsLocation = next.getGpsLocation();
                LatLng latLng = new LatLng(gpsLocation.latitude, gpsLocation.longitude);
                if (LatLngUtils.locateCorrect(latLng)) {
                    if (gpsLocation.accuracy >= 0 && gpsLocation.accuracy <= this.f31055j) {
                        LatLng latLng2 = this.f31052g;
                        if (latLng2 == null) {
                            break;
                        }
                        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
                        if (computeDistanceBetween > 1000.0d) {
                            DLog.m10773d("sfs", "PsgLocationDelegateImpl updatePassengerMarkersCallback() passenger2StartDistance: " + computeDistanceBetween, new Object[0]);
                        } else {
                            List<PassengerInfo> list2 = this.f31053h;
                            if (list2 != null && !list2.isEmpty()) {
                                Iterator<PassengerInfo> it = this.f31053h.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    PassengerInfo next2 = it.next();
                                    if (next2.getPassengerId() == next.getPassengerId()) {
                                        if (next2.getGpsLocation() != null && next2.getGpsLocation().time < gpsLocation.time) {
                                            next2.setGpsLocation(gpsLocation);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        DLog.m10773d("sfs", "PsgLocationDelegateImpl updatePassengerMarkersCallback() location.accuracy: " + gpsLocation.accuracy, new Object[0]);
                    }
                } else {
                    DLog.m10773d("sfs", "PsgLocationDelegateImpl updatePassengerMarkersCallback() passengerLatLng is not valid", new Object[0]);
                }
            } else {
                DLog.m10773d("sfs", "PsgLocationDelegateImpl updatePassengerMarkersCallback() passengerInfo == null || passengerInfo.getGpsLocation() == null", new Object[0]);
            }
        }
        PassengerLocationParam passengerLocationParam = this.f31054i;
        if (passengerLocationParam != null && passengerLocationParam.listener != null) {
            this.f31054i.listener.updatePassengerMarkers(this.f31053h);
        }
    }
}
