package com.threatmetrix.TrustDefender;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TMXConfig {
    public static final int b006F006F006F006Fo006F = ((int) TimeUnit.MINUTES.toMillis(3));
    private static final long b006F006Foo006F006F = TimeUnit.MINUTES.toMillis(15);
    private static final int b006Fo006Fo006F006F = 1;
    public static final String b006Fooo006F006F = "h-sdk.online-metrix.net";
    public static final int bo006F006F006Fo006F = ((int) TimeUnit.MINUTES.toMillis(30));
    private static final int bo006Foo006F006F = ((int) TimeUnit.SECONDS.toMillis(30));
    private static final long boo006Fo006F006F = TimeUnit.MINUTES.toMillis(60);
    public static final int boooo006F006F = ((int) TimeUnit.SECONDS.toMillis(30));
    @Nullable
    private Context b006400640064ddd;
    private boolean b00640064dddd;
    private String b0064d0064ddd;
    private int b0064dd0064dd;
    private boolean b0064ddddd;
    private boolean b006F006F006Fo006F006F = false;
    private int b006F006Fo006F006F006F;
    private long b006Fo006F006F006F006F;
    private boolean b006Foo006F006F006F;
    @Nullable
    private String bd00640064ddd;
    private boolean bd0064dddd;
    @Nullable
    private String bdd0064ddd;
    @Nullable
    private TMXProfilingConnectionsInterface bddd0064dd;
    private long bo006F006F006F006F006F;
    private int bo006F006Fo006F006F;
    private int bo006Fo006F006F006F;
    private long boo006F006F006F006F;
    private int booo006F006F006F;

    public TMXConfig() {
        int i = bo006Foo006F006F;
        this.bo006F006Fo006F006F = i;
        this.booo006F006F006F = i;
        this.b006Foo006F006F006F = false;
        this.bo006Fo006F006F006F = b006F006F006F006Fo006F;
        this.b006F006Fo006F006F006F = 1;
        this.boo006F006F006F006F = qqqqqy.OPTION_ALL;
        this.b006Fo006F006F006F006F = b006F006Foo006F006F;
        this.bo006F006F006F006F006F = boo006Fo006F006F;
        this.b0064ddddd = false;
        this.bd0064dddd = false;
        this.b00640064dddd = false;
        this.bdd0064ddd = null;
        this.b0064d0064ddd = b006Fooo006F006F;
        this.bd00640064ddd = null;
        this.b006400640064ddd = null;
        this.bddd0064dd = null;
        this.b0064dd0064dd = boooo006F006F;
    }

    public int b00730073007300730073ss() {
        return this.b0064dd0064dd;
    }

    public String b007300730073s0073ss() {
        return this.b0064d0064ddd;
    }

    public long b00730073s00730073ss() {
        return this.b006Fo006F006F006F006F;
    }

    @Nullable
    public tqtqqt b00730073ss0073ss() {
        Context context = this.b006400640064ddd;
        if (context == null) {
            return null;
        }
        return new tqtqqt(context.getApplicationContext());
    }

    @Nullable
    public String b0073s007300730073ss() {
        return this.bd00640064ddd;
    }

    public boolean b0073s0073s0073ss() {
        return this.bd0064dddd;
    }

    public int b0073ss00730073ss() {
        return this.bo006F006Fo006F006F;
    }

    public int b0073ssss0073s() {
        return this.bo006Fo006F006F006F;
    }

    public int bs0073007300730073ss() {
        return this.booo006F006F006F;
    }

    public boolean bs00730073s0073ss() {
        return this.b006Foo006F006F006F;
    }

    public int bs0073s00730073ss() {
        return this.b006F006Fo006F006F006F;
    }

    @Nullable
    public String bs0073ss0073ss() {
        return this.bdd0064ddd;
    }

    public boolean bs0073sss0073s() {
        return this.b0064ddddd;
    }

    public long bss007300730073ss() {
        long j = this.boo006F006F006F006F;
        return this.b00640064dddd ? j & -12289 : j;
    }

    public boolean bss0073s0073ss() {
        return this.b006F006F006Fo006F006F;
    }

    public long bsss00730073ss() {
        return this.bo006F006F006F006F006F;
    }

    @Nullable
    public TMXProfilingConnectionsInterface bsssss0073s() {
        return this.bddd0064dd;
    }

    @Nonnull
    public TMXConfig disableInitPackageScanTimeLimit() {
        this.bo006F006Fo006F006F = 0;
        return this;
    }

    @Nonnull
    public TMXConfig disableNonfatalLogs() {
        yyyyqy.b00740074ttt0074(true);
        return this;
    }

    @Nonnull
    public TMXConfig disableOption(long j) {
        this.boo006F006F006F006F = (~j) & this.boo006F006F006F006F;
        return this;
    }

    @Nonnull
    public TMXConfig disablePackageScanTimeLimit() {
        this.booo006F006F006F = 0;
        return this;
    }

    @Nonnull
    public TMXConfig enableOption(long j) {
        this.boo006F006F006F006F = j | this.boo006F006F006F006F;
        return this;
    }

    @Nonnull
    public TMXConfig setApiKey(String str) {
        this.bdd0064ddd = str;
        return this;
    }

    @Nonnull
    public TMXConfig setContext(Context context) {
        this.b006400640064ddd = context;
        return this;
    }

    @Nonnull
    public TMXConfig setDisableAppHashing(boolean z) {
        this.b00640064dddd = z;
        return this;
    }

    @Nonnull
    public TMXConfig setDisableAuthenticationModule(boolean z) {
        long j = this.boo006F006F006F006F;
        this.boo006F006F006F006F = z ? j & -2097153 : j | 2097152;
        return this;
    }

    @Nonnull
    public TMXConfig setDisableInitPackageScan(boolean z) {
        this.b006F006F006Fo006F006F = z;
        return this;
    }

    @Nonnull
    public TMXConfig setDisableLocSerOnBatteryLow(boolean z) {
        this.bd0064dddd = z;
        return this;
    }

    @Nonnull
    public TMXConfig setDisableProfilePackageScan(boolean z) {
        this.b006Foo006F006F006F = z;
        return this;
    }

    @Nonnull
    public TMXConfig setFPServer(String str) {
        this.b0064d0064ddd = str;
        return this;
    }

    @Nonnull
    public TMXConfig setHighPowerUpdateTime(long j, @Nonnull TimeUnit timeUnit) {
        this.bo006F006F006F006F006F = timeUnit.toMillis(j);
        return this;
    }

    @Nonnull
    public TMXConfig setInitPackageScanTimeLimit(int i, @Nonnull TimeUnit timeUnit) {
        int millis = (int) timeUnit.toMillis((long) i);
        this.bo006F006Fo006F006F = millis;
        if (millis == 0 && i != 0) {
            this.bo006F006Fo006F006F = 1;
        }
        return this;
    }

    @Nonnull
    public TMXConfig setLocationAccuracy(int i) {
        this.b006F006Fo006F006F006F = i;
        return this;
    }

    @Nonnull
    public TMXConfig setLowPowerUpdateTime(long j, @Nonnull TimeUnit timeUnit) {
        this.b006Fo006F006F006F006F = timeUnit.toMillis(j);
        return this;
    }

    @Nonnull
    public TMXConfig setOrgId(String str) {
        this.bd00640064ddd = str;
        return this;
    }

    @Nonnull
    public TMXConfig setPackageScanTimeLimit(int i, @Nonnull TimeUnit timeUnit) {
        int millis = (int) timeUnit.toMillis((long) i);
        this.booo006F006F006F = millis;
        if (millis == 0 && i != 0) {
            this.booo006F006F006F = 1;
        }
        return this;
    }

    @Nonnull
    public TMXConfig setProfileTimeout(int i, @Nonnull TimeUnit timeUnit) {
        this.b0064dd0064dd = (int) timeUnit.toMillis((long) i);
        return this;
    }

    @Nonnull
    public TMXConfig setProfilingConnections(TMXProfilingConnectionsInterface tMXProfilingConnectionsInterface) {
        this.bddd0064dd = tMXProfilingConnectionsInterface;
        return this;
    }

    @Nonnull
    public TMXConfig setRegisterForLocationServices(boolean z) {
        this.b0064ddddd = z;
        return this;
    }

    @Nonnull
    public TMXConfig setScreenOffTimeout(int i, @Nonnull TimeUnit timeUnit) {
        this.bo006Fo006F006F006F = (int) timeUnit.toMillis((long) i);
        return this;
    }
}
