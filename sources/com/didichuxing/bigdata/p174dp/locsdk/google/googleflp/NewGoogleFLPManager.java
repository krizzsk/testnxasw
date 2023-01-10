package com.didichuxing.bigdata.p174dp.locsdk.google.googleflp;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.PermRetryApollo;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.LocNTPHelper;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.ThreadDispatcher;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.locator.IFLPLocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.locator.IFLPLocator;
import com.didichuxing.bigdata.p174dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.bigdata.p174dp.locsdk.utils.LocExceptionTracker;
import com.didichuxing.bigdata.p174dp.locsdk.utils.MockLocationChecker;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.List;

@ServiceProvider({IFLPLocator.class})
/* renamed from: com.didichuxing.bigdata.dp.locsdk.google.googleflp.NewGoogleFLPManager */
public class NewGoogleFLPManager implements IFLPLocator {

    /* renamed from: a */
    private static final String f48425a = "NewGoogleFLPManager";

    /* renamed from: i */
    private static final long f48426i = 15000;

    /* renamed from: b */
    private Context f48427b;

    /* renamed from: c */
    private volatile DIDILocation f48428c;

    /* renamed from: d */
    private long f48429d;

    /* renamed from: e */
    private boolean f48430e = false;

    /* renamed from: f */
    private long f48431f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f48432g = false;

    /* renamed from: h */
    private long f48433h;

    /* renamed from: j */
    private IFLPLocationListener f48434j;

    /* renamed from: k */
    private LocationRequest f48435k;

    /* renamed from: l */
    private FusedLocationProviderClient f48436l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f48437m = 0;

    /* renamed from: n */
    private LocationCallback f48438n = new LocationCallback() {
        public void onLocationResult(LocationResult locationResult) {
            List<Location> locations = locationResult.getLocations();
            if (locations.size() > 0) {
                NewGoogleFLPManager.this.m36264a(locations.get(locations.size() - 1));
                NewGoogleFLPManager.m36261a(NewGoogleFLPManager.this);
                if (NewGoogleFLPManager.this.f48437m >= 10) {
                    int unused = NewGoogleFLPManager.this.f48437m = 0;
                    DLog.m36225d("NewGoogleFLPManager location arrived: google flp");
                }
            }
        }

        public void onLocationAvailability(LocationAvailability locationAvailability) {
            super.onLocationAvailability(locationAvailability);
            DLog.m36225d(" googleFlp available = " + locationAvailability.isLocationAvailable());
        }
    };

    /* renamed from: o */
    private long f48439o;

    /* renamed from: a */
    static /* synthetic */ int m36261a(NewGoogleFLPManager newGoogleFLPManager) {
        int i = newGoogleFLPManager.f48437m;
        newGoogleFLPManager.f48437m = i + 1;
        return i;
    }

    public void init(Context context, long j) {
        if (context != null) {
            this.f48427b = context;
            this.f48431f = j;
            this.f48430e = true;
            this.f48436l = LocationServices.getFusedLocationProviderClient(context);
            createLocationRequest(this.f48431f);
            m36263a();
        }
    }

    public void setLocationListener(IFLPLocationListener iFLPLocationListener) {
        this.f48434j = iFLPLocationListener;
    }

    /* renamed from: a */
    private void m36263a() {
        try {
            this.f48432g = false;
            this.f48436l.requestLocationUpdates(this.f48435k, this.f48438n, ThreadDispatcher.getWorkThread().getLooper()).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    DLog.m36225d("NewGoogleFLPManager Google fusedLocation provider client success");
                }
            }).addOnCanceledListener(new OnCanceledListener() {
                public void onCanceled() {
                }
            }).addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    if (LocExceptionTracker.getInstance().enable()) {
                        if (exc instanceof SecurityException) {
                            LocExceptionTracker.getInstance().trackInnerException(1, "GMS_NoPerm");
                        } else if (!(exc instanceof ApiException) || ((ApiException) exc).getStatusCode() != 17) {
                            LocExceptionTracker instance = LocExceptionTracker.getInstance();
                            instance.trackInnerException(5, "GMS_" + exc.getClass().getCanonicalName());
                        } else {
                            LocExceptionTracker.getInstance().trackInnerException(3, "GMS_InvalidClientException");
                        }
                    }
                    if (PermRetryApollo.getInstance().shouldRetryLoc() && (exc instanceof SecurityException)) {
                        DLog.m36225d("NewGoogleFLPManager Security exception");
                        boolean unused = NewGoogleFLPManager.this.f48432g = true;
                    }
                    DLog.m36225d("NewGoogleFLPManager Google fusedLocation provider client failed: " + exc.getClass() + "," + exc.getCause() + "," + exc.getMessage() + "," + exc.getLocalizedMessage());
                }
            });
        } catch (SecurityException unused) {
            if (LocExceptionTracker.getInstance().enable()) {
                LocExceptionTracker.getInstance().trackInnerException(1, "GMS_NoPerm");
            }
            this.f48432g = true;
        } catch (Throwable th) {
            if (LocExceptionTracker.getInstance().enable()) {
                LocExceptionTracker instance = LocExceptionTracker.getInstance();
                instance.trackInnerException(5, "GMS_" + th.getClass().getCanonicalName());
            }
            this.f48432g = false;
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m36268b() {
        if (this.f48430e && this.f48432g && this.f48427b != null && SystemClock.elapsedRealtime() - this.f48433h > 15000) {
            DLog.m36225d("NewGoogleFLPManager retry loc google flp");
            this.f48433h = SystemClock.elapsedRealtime();
            if (Utils.isLocationPermissionGranted(this.f48427b)) {
                DLog.m36225d("NewGoogleFLPManager RESTART loc when permission granted");
                m36263a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public LocationRequest createLocationRequest(long j) {
        this.f48435k = new LocationRequest();
        long value = DIDILocationUpdateOption.IntervalMode.LOW_FREQUENCY.getValue();
        if (j >= value) {
            j = value;
        }
        this.f48435k.setInterval(j);
        this.f48435k.setFastestInterval(1000);
        this.f48435k.setPriority(100);
        return this.f48435k;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36264a(Location location) {
        if (Utils.locCorrect(location)) {
            if (DIDILocationManager.enableMockLocation || !MockLocationChecker.isMockLocation(this.f48427b, location, true)) {
                LocNTPHelper.adjustSystemLocationTimestamp(location);
                DIDILocation loadFromSystemLoc = DIDILocation.loadFromSystemLoc(location, ETraceSource.googleflp, Utils.getCoordinateType());
                IFLPLocationListener iFLPLocationListener = this.f48434j;
                if (iFLPLocationListener != null) {
                    iFLPLocationListener.onLocationChanged(loadFromSystemLoc);
                }
                this.f48428c = loadFromSystemLoc;
                this.f48429d = Utils.getTimeBoot();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f48439o > 15000) {
                    DLog.m36225d("callback gms location: " + location.getLongitude() + "," + location.getLatitude() + ", " + location.getSpeed() + ", " + location.getBearing());
                    this.f48439o = currentTimeMillis;
                }
            }
        }
    }

    public DIDILocation getFLPLocation() {
        if (!Utils.locCorrect(this.f48428c)) {
            this.f48428c = null;
        } else if (Utils.getTimeBoot() - this.f48429d > 20000) {
            this.f48428c = null;
        }
        if (this.f48428c == null) {
            m36268b();
        }
        return this.f48428c;
    }

    public void destroy() {
        FusedLocationProviderClient fusedLocationProviderClient = this.f48436l;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(this.f48438n);
            this.f48436l = null;
        }
        this.f48429d = 0;
        this.f48428c = null;
        this.f48434j = null;
        this.f48431f = 0;
        this.f48430e = false;
    }
}
