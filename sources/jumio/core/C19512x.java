package jumio.core;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.didi.sdk.util.GlobalCountryCode;
import com.jumio.commons.log.Log;
import com.jumio.sdk.JumioSDK;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: jumio.core.x */
/* compiled from: LocationUtil */
public class C19512x implements LocationListener {

    /* renamed from: f */
    public static final Object f55411f = new Object();

    /* renamed from: a */
    public Context f55412a;

    /* renamed from: b */
    public C19514b f55413b;

    /* renamed from: c */
    public LocationManager f55414c;

    /* renamed from: d */
    public Address f55415d = null;

    /* renamed from: e */
    public boolean f55416e = false;

    /* renamed from: jumio.core.x$a */
    /* compiled from: LocationUtil */
    public class C19513a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Location f55417a;

        /* renamed from: b */
        public final /* synthetic */ boolean f55418b;

        public C19513a(Location location, boolean z) {
            this.f55417a = location;
            this.f55418b = z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r0 = new android.location.Geocoder(jumio.core.C19512x.m41236a(r9.f55419c), java.util.Locale.US).getFromLocation(r9.f55417a.getLatitude(), r9.f55417a.getLongitude(), 1);
            r1 = jumio.core.C19512x.m41238a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
            if (jumio.core.C19512x.m41240b(r9.f55419c) == null) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
            r3 = r9.f55419c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
            if (r0 == null) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
            if (r0.size() <= 0) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
            r2 = r0.get(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
            jumio.core.C19512x.m41237a(r3, r2);
            jumio.core.C19512x.m41240b(r9.f55419c).onAddressAvailable(jumio.core.C19512x.m41241c(r9.f55419c));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0071, code lost:
            com.jumio.commons.log.Log.m43652e("No geocoded information available ", (java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0092, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                java.lang.Object r0 = jumio.core.C19512x.f55411f
                monitor-enter(r0)
                jumio.core.x r1 = jumio.core.C19512x.this     // Catch:{ all -> 0x0093 }
                android.content.Context r1 = r1.f55412a     // Catch:{ all -> 0x0093 }
                r2 = 0
                if (r1 == 0) goto L_0x0080
                android.location.Location r1 = r9.f55417a     // Catch:{ all -> 0x0093 }
                if (r1 == 0) goto L_0x0080
                jumio.core.x r1 = jumio.core.C19512x.this     // Catch:{ all -> 0x0093 }
                boolean r1 = r1.mo148757c()     // Catch:{ all -> 0x0093 }
                if (r1 != 0) goto L_0x001b
                goto L_0x0080
            L_0x001b:
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                android.location.Geocoder r3 = new android.location.Geocoder     // Catch:{ Exception -> 0x0070 }
                jumio.core.x r0 = jumio.core.C19512x.this     // Catch:{ Exception -> 0x0070 }
                android.content.Context r0 = r0.f55412a     // Catch:{ Exception -> 0x0070 }
                java.util.Locale r1 = java.util.Locale.US     // Catch:{ Exception -> 0x0070 }
                r3.<init>(r0, r1)     // Catch:{ Exception -> 0x0070 }
                android.location.Location r0 = r9.f55417a     // Catch:{ Exception -> 0x0070 }
                double r4 = r0.getLatitude()     // Catch:{ Exception -> 0x0070 }
                android.location.Location r0 = r9.f55417a     // Catch:{ Exception -> 0x0070 }
                double r6 = r0.getLongitude()     // Catch:{ Exception -> 0x0070 }
                r8 = 1
                java.util.List r0 = r3.getFromLocation(r4, r6, r8)     // Catch:{ Exception -> 0x0070 }
                java.lang.Object r1 = jumio.core.C19512x.f55411f     // Catch:{ Exception -> 0x0070 }
                monitor-enter(r1)     // Catch:{ Exception -> 0x0070 }
                jumio.core.x r3 = jumio.core.C19512x.this     // Catch:{ all -> 0x006d }
                jumio.core.x$b r3 = r3.f55413b     // Catch:{ all -> 0x006d }
                if (r3 == 0) goto L_0x006b
                jumio.core.x r3 = jumio.core.C19512x.this     // Catch:{ all -> 0x006d }
                if (r0 == 0) goto L_0x0059
                int r4 = r0.size()     // Catch:{ all -> 0x006d }
                if (r4 <= 0) goto L_0x0059
                r2 = 0
                java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x006d }
                r2 = r0
                android.location.Address r2 = (android.location.Address) r2     // Catch:{ all -> 0x006d }
            L_0x0059:
                android.location.Address unused = r3.f55415d = r2     // Catch:{ all -> 0x006d }
                jumio.core.x r0 = jumio.core.C19512x.this     // Catch:{ all -> 0x006d }
                jumio.core.x$b r0 = r0.f55413b     // Catch:{ all -> 0x006d }
                jumio.core.x r2 = jumio.core.C19512x.this     // Catch:{ all -> 0x006d }
                android.location.Address r2 = r2.f55415d     // Catch:{ all -> 0x006d }
                r0.onAddressAvailable(r2)     // Catch:{ all -> 0x006d }
            L_0x006b:
                monitor-exit(r1)     // Catch:{ all -> 0x006d }
                goto L_0x0076
            L_0x006d:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x006d }
                throw r0     // Catch:{ Exception -> 0x0070 }
            L_0x0070:
                r0 = move-exception
                java.lang.String r1 = "No geocoded information available "
                com.jumio.commons.log.Log.m43652e((java.lang.String) r1, (java.lang.Throwable) r0)
            L_0x0076:
                boolean r0 = r9.f55418b
                if (r0 == 0) goto L_0x007f
                jumio.core.x r0 = jumio.core.C19512x.this
                r0.mo148758d()
            L_0x007f:
                return
            L_0x0080:
                jumio.core.x r1 = jumio.core.C19512x.this     // Catch:{ all -> 0x0093 }
                jumio.core.x$b r1 = r1.f55413b     // Catch:{ all -> 0x0093 }
                if (r1 == 0) goto L_0x0091
                jumio.core.x r1 = jumio.core.C19512x.this     // Catch:{ all -> 0x0093 }
                jumio.core.x$b r1 = r1.f55413b     // Catch:{ all -> 0x0093 }
                r1.onAddressAvailable(r2)     // Catch:{ all -> 0x0093 }
            L_0x0091:
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                return
            L_0x0093:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.core.C19512x.C19513a.run():void");
        }
    }

    /* renamed from: jumio.core.x$b */
    /* compiled from: LocationUtil */
    public interface C19514b {
        void onAddressAvailable(Address address);
    }

    public C19512x(Context context, C19514b bVar) {
        this.f55412a = context;
        this.f55413b = bVar;
    }

    /* renamed from: d */
    public void mo148758d() {
        synchronized (f55411f) {
            try {
                LocationManager locationManager = this.f55414c;
                if (locationManager != null) {
                    locationManager.removeUpdates(this);
                    this.f55414c = null;
                }
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
            this.f55412a = null;
            this.f55413b = null;
        }
    }

    public void onLocationChanged(Location location) {
        new Thread(new C19513a(location, this.f55416e)).start();
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* renamed from: b */
    public boolean mo148756b() {
        return JumioSDK.Companion.hasPermissionsFor(this.f55412a, new String[]{Permission.ACCESS_COARSE_LOCATION});
    }

    /* renamed from: c */
    public boolean mo148757c() {
        return Geocoder.isPresent();
    }

    /* renamed from: a */
    public static String m41239a(C19464b bVar) {
        if (bVar == null) {
            return null;
        }
        String c = bVar.mo148603c();
        if (!GlobalCountryCode.AMERICA.equals(c)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = bVar.mo148600a().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                sb.append(next);
                sb.append(" ");
            }
        }
        String b = bVar.mo148602b();
        Matcher matcher = Pattern.compile(" [A-Z]{2} ").matcher(sb);
        while (matcher.find()) {
            b = matcher.group().trim();
        }
        if (b == null || b.length() != 2) {
            return null;
        }
        return String.format("%s-%s", new Object[]{c, b});
    }

    /* renamed from: a */
    public void mo148755a(boolean z, boolean z2) {
        if (mo148756b()) {
            try {
                synchronized (f55411f) {
                    LocationManager locationManager = (LocationManager) this.f55412a.getSystemService("location");
                    this.f55414c = locationManager;
                    if (locationManager.getAllProviders().contains("network")) {
                        if (z) {
                            this.f55416e = false;
                            onLocationChanged(this.f55414c.getLastKnownLocation("network"));
                        }
                        this.f55416e = z2;
                        this.f55414c.requestSingleUpdate("network", this, Looper.getMainLooper());
                    }
                }
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
        }
    }
}
