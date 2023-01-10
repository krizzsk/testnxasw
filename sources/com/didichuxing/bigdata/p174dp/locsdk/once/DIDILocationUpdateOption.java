package com.didichuxing.bigdata.p174dp.locsdk.once;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.once.util.ApolloProxy;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDILocationUpdateOption */
public class DIDILocationUpdateOption {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final float f48730a = ApolloProxy.getInstance().getDirectNotifyIntervalRate();

    /* renamed from: b */
    private IntervalMode f48731b = IntervalMode.NORMAL;

    /* renamed from: c */
    private String f48732c;

    /* renamed from: d */
    private String f48733d;

    /* renamed from: e */
    private boolean f48734e = false;

    public boolean isDirectNotify() {
        return this.f48734e;
    }

    public void setDirectNotify(boolean z) {
        this.f48734e = z;
        DLog.m36225d("setDirectNotify=" + z + " IntervalMode=" + this.f48731b + " Key=" + this.f48732c + ":" + this.f48733d);
    }

    public String getModuleKey() {
        return this.f48732c;
    }

    public String getHexModuleKey() {
        return this.f48733d;
    }

    public void setModuleKey(String str) {
        this.f48732c = str;
        this.f48733d = str != null ? Integer.toHexString(str.hashCode()) : "null";
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDILocationUpdateOption$IntervalMode */
    public enum IntervalMode {
        SUPER_HIGH_FREQUENCY(200, (long) (DIDILocationUpdateOption.f48730a * 200.0f)),
        HIGH_FREQUENCY(1000, (long) (DIDILocationUpdateOption.f48730a * 1000.0f)),
        NORMAL(3000, (long) (DIDILocationUpdateOption.f48730a * 3000.0f)),
        LOW_FREQUENCY(9000, 9000),
        BATTERY_SAVE(36000, 36000),
        MORE_BATTERY_SAVE(72000, 72000);
        
        private long mDirectNotifyInterval;
        private long mInterval;
        private String mName;

        private IntervalMode(long j, long j2) {
            this.mInterval = j;
            this.mDirectNotifyInterval = j2;
            this.mName = name() + Const.joLeft + this.mInterval + ", " + this.mDirectNotifyInterval + "}";
        }

        public long getValue() {
            return this.mInterval;
        }

        public long getDirectNotifyValue() {
            return this.mDirectNotifyInterval;
        }

        public String toString() {
            return this.mName;
        }
    }

    public void setInterval(IntervalMode intervalMode) {
        this.f48731b = intervalMode;
    }

    public IntervalMode getInterval() {
        return this.f48731b;
    }
}
