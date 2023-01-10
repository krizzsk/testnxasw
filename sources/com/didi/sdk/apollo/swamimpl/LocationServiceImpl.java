package com.didi.sdk.apollo.swamimpl;

import android.app.Application;
import android.location.Location;
import android.os.Bundle;
import com.didi.sdk.data.CityDataGenerator;
import com.didi.sdk.data.DataLoadUtil;
import com.didi.sdk.data.LocationDataGenerator2;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.swarm.launcher.SwarmLauncher;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.OnCityChangeListener;
import com.didichuxing.swarm.toolkit.OnLocationChangeListener;
import org.osgi.framework.BundleContext;

@ServiceProvider({LocationService.class})
public class LocationServiceImpl implements LocationService {

    /* renamed from: a */
    final LocationDataGenerator2 f37838a = ((LocationDataGenerator2) DataLoadUtil.loadGenerator(LocationDataGenerator2.class));

    /* renamed from: b */
    final CityDataGenerator f37839b = ((CityDataGenerator) DataLoadUtil.loadGenerator(CityDataGenerator.class));

    public void addCityChangeListener(OnCityChangeListener onCityChangeListener) {
    }

    public void addLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
    }

    public void removeCityChangeListener(OnCityChangeListener onCityChangeListener) {
    }

    public void removeLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
    }

    public Location getLocation() {
        BundleContext bundleContext = SwarmLauncher.getInstance().getFramework().getBundleContext();
        Application application = (Application) bundleContext.getService(bundleContext.getServiceReference(Application.class));
        if (this.f37838a == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city_id", this.f37839b.getCityID());
        Location location = new Location("");
        location.setLatitude(this.f37838a.getLat(application.getApplicationContext()));
        location.setLongitude(this.f37838a.getLng(application.getApplicationContext()));
        location.setAccuracy(this.f37838a.getAccuracy(application.getApplicationContext()));
        location.setBearing(this.f37838a.getBearing(application.getApplicationContext()));
        location.setExtras(bundle);
        location.setSpeed(this.f37838a.getSpeed(application.getApplicationContext()));
        location.setTime(this.f37838a.getTime(application.getApplicationContext()));
        return location;
    }

    public String getCityId() {
        return this.f37839b.getCityID() + "";
    }
}
