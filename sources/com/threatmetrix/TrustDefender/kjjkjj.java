package com.threatmetrix.TrustDefender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.threatmetrix.TrustDefender.jjkjkj;
import com.threatmetrix.TrustDefender.jkjjkj;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import com.yanzhenjie.permission.runtime.Permission;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class kjjkjj implements jjkjkj.jjjjjk {
    private static final String b006Fo006F006F006Fo = "Failed to register locationServices: ";
    /* access modifiers changed from: private */
    public static final String boo006F006F006Fo = yyyyqy.b0074t007400740074t(kjjkjj.class);
    private long b006F006F006F006F006Fo;
    @Nullable
    private jjjkjj b006F006F006Foo006F;
    private boolean b006F006Fooo006F = false;
    @Nullable
    private jkjjkj.GenericLocation b006Fo006Foo006F;
    @Nonnull
    private jkjkjj b006Foo006Fo006F = jkjkjj.NONE;
    private boolean b006Foooo006F = false;
    private int bo006F006F006F006Fo;
    @Nullable
    private LocationManager bo006F006Foo006F;
    private final HandlerThread bo006Fo006Fo006F = new HandlerThread("THMLocationHandler");
    private boolean bo006Fooo006F = false;
    private Context boo006Foo006F;
    @Nullable
    private jkjjjj booo006Fo006F;
    private long booooo006F;

    public class jjkkjj extends BroadcastReceiver {
        public jjkkjj() {
        }

        public void onReceive(@Nonnull Context context, Intent intent) {
            if (NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION.equals(intent.getAction()) && tqttqq.qqqttq.b0076vvv0076v()) {
                try {
                    Object systemService = context.getSystemService("connectivity");
                    if (systemService instanceof ConnectivityManager) {
                        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) systemService);
                        if (!(activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting())) {
                            kjjkjj.this.pause();
                        } else {
                            kjjkjj.this.resume();
                        }
                    }
                } catch (SecurityException e) {
                    qqqtqt.b0079yyy0079y(e, kjjkjj.boo006F006F006Fo);
                } catch (Exception e2) {
                    yyyyqy.bt0074007400740074t(kjjkjj.boo006F006F006Fo, e2.toString());
                }
            }
        }
    }

    public private enum jkjkjj {
        NONE,
        FINE,
        COARSE
    }

    public class kkjkjj extends BroadcastReceiver {
        public kkjkjj() {
        }

        public void onReceive(Context context, @Nonnull Intent intent) {
            if ("android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                kjjkjj.this.pause();
            } else {
                kjjkjj.this.resume();
            }
        }
    }

    private boolean b0073007300730073sss(LocationManager locationManager, String str, long j, Criteria criteria, Looper looper) {
        if (looper == null) {
            return false;
        }
        if (str != null) {
            try {
                locationManager.requestLocationUpdates(str, this.booooo006F, (float) j, this.b006F006F006Foo006F, looper);
            } catch (IllegalArgumentException e) {
                String str2 = boo006F006F006Fo;
                yyyyqy.btt0074tt0074(str2, b006Fo006F006F006Fo + e.toString());
                return false;
            } catch (SecurityException e2) {
                String str3 = boo006F006F006Fo;
                yyyyqy.btt0074tt0074(str3, b006Fo006F006F006Fo + e2.toString());
                qqqtqt.byyyy0079y(e2);
                return false;
            }
        } else {
            locationManager.requestLocationUpdates(this.booooo006F, (float) j, criteria, this.b006F006F006Foo006F, looper);
        }
        yyyyqy.bt0074007400740074t(boo006F006F006Fo, "rlu");
        String str4 = boo006F006F006Fo;
        yyyyqy.qyyyqy.bt0074tttt(str4, "GenericLocationManager created: " + locationManager.getBestProvider(criteria, true));
        return true;
    }

    private void b0073s00730073sss() {
        if (this.b006F006Fooo006F && this.b006F006F006Foo006F != null && !b0073ss0073sss()) {
            yyyyqy.bt0074007400740074t(boo006F006F006Fo, "rls");
            String str = boo006F006F006Fo;
            yyyyqy.qyyyqy.b00740074t0074tt(str, "registerLocationServices: low power " + this.b006F006F006F006F006Fo + " high power " + this.booooo006F + " with accuracy " + this.bo006F006F006F006Fo);
            try {
                Object systemService = this.boo006Foo006F.getSystemService("location");
                if (!(systemService instanceof LocationManager)) {
                    yyyyqy.bt0074t00740074t(boo006F006F006Fo, "Location Manager is not available");
                    return;
                }
                LocationManager locationManager = (LocationManager) systemService;
                this.bo006F006Foo006F = locationManager;
                locationManager.removeUpdates(this.b006F006F006Foo006F);
                Criteria criteria = new Criteria();
                criteria.setAccuracy(this.bo006F006F006F006Fo);
                boolean z = false;
                criteria.setAltitudeRequired(false);
                criteria.setBearingAccuracy(0);
                criteria.setCostAllowed(false);
                criteria.setSpeedAccuracy(0);
                criteria.setSpeedRequired(false);
                criteria.setVerticalAccuracy(0);
                Criteria criteria2 = new Criteria();
                criteria2.setPowerRequirement(1);
                criteria2.setAccuracy(2);
                String bestProvider = locationManager.getBestProvider(criteria, true);
                if (bestProvider != null) {
                    String str2 = boo006F006F006Fo;
                    yyyyqy.qyyyqy.bt0074tttt(str2, "fine provider: " + bestProvider);
                }
                String bestProvider2 = locationManager.getBestProvider(criteria2, true);
                if (bestProvider2 != null) {
                    String str3 = boo006F006F006Fo;
                    yyyyqy.qyyyqy.bt0074tttt(str3, "course provider: " + bestProvider2);
                }
                if (bestProvider == null && bestProvider2 == null) {
                    this.bo006F006Foo006F = null;
                    yyyyqy.bt0074t00740074t(boo006F006F006Fo, "Unable to find location provider, possibly incorrect permissions. Check that android.permission.ACCESS_COARSE_LOCATION or android.permission.ACCESS_FINE_LOCATION is set");
                    return;
                }
                Location bsss0073sss = bsss0073sss();
                boolean equals = (bestProvider == null || bestProvider2 == null) ? false : bestProvider.equals(bestProvider2);
                if (bsss0073sss != null) {
                    this.b006F006F006Foo006F.onLocationChanged(bsss0073sss);
                }
                if (this.b006Foo006Fo006F != jkjkjj.NONE) {
                    z = b0073007300730073sss(locationManager, bestProvider2, 0, criteria2, this.bo006Fo006Fo006F.getLooper());
                }
                if (!equals && !z && this.b006Foo006Fo006F != jkjkjj.NONE) {
                    z = b0073007300730073sss(locationManager, bestProvider, 0, criteria, this.bo006Fo006Fo006F.getLooper());
                }
                if (!z) {
                    this.bo006F006Foo006F = null;
                }
            } catch (SecurityException e) {
                qqqtqt.b0079yyy0079y(e, boo006F006F006Fo);
                this.bo006F006Foo006F = null;
            } catch (Exception e2) {
                yyyyqy.bt0074007400740074t(boo006F006F006Fo, e2.toString());
                this.bo006F006Foo006F = null;
            }
        }
    }

    private boolean b0073ss0073sss() {
        jkjjjj jkjjjj = this.booo006Fo006F;
        return jkjjjj != null && jkjjjj.b00680068h0068h0068();
    }

    private void bs007300730073sss(Context context, long j, long j2, int i) {
        Context context2 = context;
        if (!tqttqq.tttqtq.b00760076v0076vv()) {
            this.b006F006Fooo006F = false;
        }
        if (this.b006F006Fooo006F) {
            this.bo006Fo006Fo006F.start();
            this.boo006Foo006F = context2;
            this.b006F006F006F006F006Fo = j;
            this.booooo006F = j2;
            this.bo006F006F006F006Fo = i;
            this.b006F006F006Foo006F = new jjjkjj();
            tqttqq tqttqq = new tqttqq();
            tqttqq.getClass();
            tqttqq.qtqttq qtqttq = new tqttqq.qtqttq(context);
            if (qtqttq.b0076v0076v0076v(Permission.ACCESS_COARSE_LOCATION, context.getPackageName())) {
                this.b006Foo006Fo006F = jkjkjj.COARSE;
            }
            if (qtqttq.b0076v0076v0076v(Permission.ACCESS_FINE_LOCATION, context.getPackageName())) {
                this.b006Foo006Fo006F = jkjkjj.FINE;
            }
            try {
                jkjjjj jkjjjj = new jkjjjj();
                this.booo006Fo006F = jkjjjj;
                boolean bh0068h0068h0068 = jkjjjj.bh0068h0068h0068(this.boo006Foo006F, this.booooo006F, this.b006F006F006F006F006Fo, this.bo006F006F006F006Fo, this.b006F006F006Foo006F, this, this.bo006Fo006Fo006F);
                b0073s00730073sss();
                if (bh0068h0068h0068 || bs0073s0073sss()) {
                    bss00730073sss();
                }
            } catch (SecurityException e) {
                qqqtqt.b0079yyy0079y(e, boo006F006F006Fo);
                this.b006F006Fooo006F = false;
            } catch (Exception e2) {
                yyyyqy.bt0074007400740074t(boo006F006F006Fo, e2.toString());
                this.b006F006Fooo006F = false;
            }
        }
    }

    private boolean bs0073s0073sss() {
        return (this.bo006F006Foo006F == null || this.b006F006F006Foo006F == null) ? false : true;
    }

    private void bss00730073sss() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        try {
            this.boo006Foo006F.registerReceiver(new jjkkjj(), intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        if (this.bo006Fooo006F) {
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.BATTERY_LOW");
            intentFilter2.addAction("android.intent.action.BATTERY_OKAY");
            intentFilter2.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            try {
                this.boo006Foo006F.registerReceiver(new kkjkjj(), intentFilter2);
            } catch (Exception e2) {
                Log.d("Context", "registerReceiver", e2);
            }
        }
    }

    private Location bsss0073sss() {
        yyyyqy.bt0074007400740074t(boo006F006F006Fo, "gll");
        yyyyqy.qyyyqy.bt0074tttt(boo006F006F006Fo, "Attempting to find an existing location to prime things");
        LocationManager locationManager = this.bo006F006Foo006F;
        Location location = null;
        if (locationManager == null) {
            return null;
        }
        try {
            long j = 0;
            float f = Float.MAX_VALUE;
            for (String next : locationManager.getAllProviders()) {
                if (next == null) {
                    yyyyqy.qyyyqy.bt00740074ttt(boo006F006F006Fo, "null provider (wut?)");
                } else {
                    String str = boo006F006F006Fo;
                    yyyyqy.qyyyqy.bt0074tttt(str, "getLastLocation() : " + next);
                    if (this.b006Foo006Fo006F != jkjkjj.COARSE || next.equals("network")) {
                        Location lastKnownLocation = locationManager.getLastKnownLocation(next);
                        if (lastKnownLocation != null) {
                            yyyyqy.bt0074007400740074t(boo006F006F006Fo, "gllnn");
                            String str2 = boo006F006F006Fo;
                            yyyyqy.qyyyqy.bt0074tttt(str2, "getLastLocation() : " + lastKnownLocation.getProvider() + ":" + lastKnownLocation.getLatitude() + ":" + lastKnownLocation.getLongitude() + ":" + lastKnownLocation.getAccuracy());
                            float accuracy = lastKnownLocation.getAccuracy();
                            long time = lastKnownLocation.getTime();
                            if (time > this.b006F006F006F006F006Fo && accuracy < f) {
                                location = lastKnownLocation;
                                f = accuracy;
                            } else if (time < this.b006F006F006F006F006Fo && f == Float.MAX_VALUE && time > j) {
                                location = lastKnownLocation;
                            }
                            j = time;
                        }
                    }
                }
            }
        } catch (SecurityException e) {
            yyyyqy.qyyyqy.b00740074tttt(boo006F006F006Fo, "User refuse granting permission {}", e.toString());
            qqqtqt.byyyy0079y(e);
        } catch (Exception e2) {
            yyyyqy.bt0074007400740074t(boo006F006F006Fo, e2.toString());
        }
        return location;
    }

    public void b007300730073ssss() {
        LocationManager locationManager = this.bo006F006Foo006F;
        if (bs0073s0073sss() && locationManager != null) {
            try {
                locationManager.removeUpdates(this.b006F006F006Foo006F);
            } catch (SecurityException e) {
                yyyyqy.qyyyqy.b00740074tttt(boo006F006F006Fo, "User refuse granting permission {}", e.toString());
                qqqtqt.byyyy0079y(e);
            } catch (Exception e2) {
                yyyyqy.bt0074007400740074t(boo006F006F006Fo, e2.toString());
            }
        }
    }

    public boolean b00730073s0073sss() {
        return this.b006F006Fooo006F;
    }

    public void b0073sss0073ss(boolean z) {
        if (!tqttqq.tttqtq.bv0076v0076vv() || !tqttqq.tttqtq.b00760076v0076vv()) {
            this.b006F006Fooo006F = false;
        }
        this.b006F006Fooo006F = z;
    }

    public void bssss0073ss(boolean z) {
        this.bo006Fooo006F = z;
    }

    public void config(@Nonnull TMXConfig tMXConfig) {
        b0073sss0073ss(tMXConfig.bs0073sss0073s());
        bssss0073ss(tMXConfig.b0073s0073s0073ss());
        long b00730073s00730073ss = tMXConfig.b00730073s00730073ss();
        long bsss00730073ss = tMXConfig.bsss00730073ss();
        int bs0073s00730073ss = tMXConfig.bs0073s00730073ss();
        tqtqqt b00730073ss0073ss = tMXConfig.b00730073ss0073ss();
        if (b00730073ss0073ss != null && b00730073ss0073ss.bll006C006C006C006C != null) {
            bs007300730073sss(b00730073ss0073ss.bll006C006C006C006C, b00730073s00730073ss, bsss00730073ss, bs0073s00730073ss);
        }
    }

    @Nullable
    public jkjjkj.GenericLocation getLocation() {
        Location b00730073sssss;
        jkjjkj.GenericLocation genericLocation = this.b006Fo006Foo006F;
        if (genericLocation != null) {
            return genericLocation;
        }
        jjjkjj jjjkjj = this.b006F006F006Foo006F;
        if (jjjkjj == null || !this.b006F006Fooo006F || (b00730073sssss = jjjkjj.b00730073sssss()) == null || (b00730073sssss.getLatitude() == 0.0d && b00730073sssss.getLongitude() == 0.0d)) {
            return null;
        }
        return yyqyyy.bq0071q0071qq(b00730073sssss, false);
    }

    public void pause() {
        String str;
        String str2;
        if (this.b006F006Fooo006F && !this.b006Foooo006F) {
            if (b0073ss0073sss()) {
                this.booo006Fo006F.b0068006800680068h0068(true);
                str2 = boo006F006F006Fo;
                str = "paused FUSED location services";
            } else {
                b007300730073ssss();
                str2 = boo006F006F006Fo;
                str = "paused NON-FUSED location services";
            }
            yyyyqy.bt0074007400740074t(str2, str);
            this.b006Foooo006F = true;
        }
    }

    public void resume() {
        if (this.b006F006Fooo006F && this.b006Foooo006F) {
            if (b0073ss0073sss()) {
                yyyyqy.bt0074007400740074t(boo006F006F006Fo, "resuming FUSED location services");
                this.booo006Fo006F.b0068006800680068h0068(false);
            } else {
                yyyyqy.bt0074007400740074t(boo006F006F006Fo, "resuming NON-FUSED location services");
                b0073s00730073sss();
            }
            this.b006Foooo006F = false;
        }
    }

    public void setLocation(jkjjkj.GenericLocation genericLocation) {
        if (genericLocation == null) {
            genericLocation = null;
        }
        this.b006Fo006Foo006F = genericLocation;
    }

    public void unregister() {
        if (this.b006F006Fooo006F) {
            b007300730073ssss();
            this.b006F006F006Foo006F = null;
            jkjjjj jkjjjj = this.booo006Fo006F;
            if (b0073ss0073sss() && jkjjjj != null) {
                jkjjjj.b0068hh0068h0068();
            }
        }
    }
}
