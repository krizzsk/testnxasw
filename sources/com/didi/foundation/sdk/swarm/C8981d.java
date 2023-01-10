package com.didi.foundation.sdk.swarm;

import android.location.Location;
import android.os.Bundle;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.swarm.toolkit.LocationChangeEvent;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.OnCityChangeListener;
import com.didichuxing.swarm.toolkit.OnLocationChangeListener;
import java.util.Vector;

/* renamed from: com.didi.foundation.sdk.swarm.d */
/* compiled from: LocationServiceImpl */
final class C8981d implements LocationService {

    /* renamed from: a */
    private final Vector<OnCityChangeListener> f23209a = new Vector<>();

    /* renamed from: b */
    private final Vector<OnLocationChangeListener> f23210b = new Vector<>();

    public String getCityId() {
        return "-1";
    }

    C8981d() {
        com.didi.foundation.sdk.location.LocationService.getInstance().registerLocationListener(new LocationServiceImpl$1(this));
    }

    public Location getLocation() {
        return m19105b(com.didi.foundation.sdk.location.LocationService.getInstance().getLastKnownLocation());
    }

    public void addLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
        this.f23210b.add(onLocationChangeListener);
    }

    public void removeLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
        this.f23210b.remove(onLocationChangeListener);
    }

    public void addCityChangeListener(OnCityChangeListener onCityChangeListener) {
        this.f23209a.add(onCityChangeListener);
    }

    public void removeCityChangeListener(OnCityChangeListener onCityChangeListener) {
        this.f23209a.remove(onCityChangeListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19104a(DIDILocation dIDILocation) {
        if (!this.f23210b.isEmpty()) {
            LocationChangeEvent locationChangeEvent = new LocationChangeEvent(this, m19105b(dIDILocation));
            Vector<OnLocationChangeListener> vector = this.f23210b;
            for (OnLocationChangeListener onLocationChangeListener : (OnLocationChangeListener[]) vector.toArray(new OnLocationChangeListener[vector.size()])) {
                if (onLocationChangeListener != null) {
                    onLocationChangeListener.onLocationChanged(locationChangeEvent);
                }
            }
        }
    }

    /* renamed from: b */
    private Location m19105b(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return null;
        }
        Location location = new Location(dIDILocation.getProvider());
        Bundle bundle = new Bundle();
        bundle.putString("city_id", "-1");
        location.setLatitude(dIDILocation.getLatitude());
        location.setLongitude(dIDILocation.getLongitude());
        location.setAltitude(dIDILocation.getAltitude());
        location.setAccuracy(dIDILocation.getAccuracy());
        location.setBearing(dIDILocation.getBearing());
        location.setExtras(bundle);
        location.setSpeed(dIDILocation.getSpeed());
        location.setTime(dIDILocation.getTime());
        return location;
    }
}
