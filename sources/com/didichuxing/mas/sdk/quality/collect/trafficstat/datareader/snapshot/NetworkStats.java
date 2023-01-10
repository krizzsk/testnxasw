package com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseBooleanArray;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

public class NetworkStats implements Parcelable {
    public static final Parcelable.Creator<NetworkStats> CREATOR = new Parcelable.Creator<NetworkStats>() {
        public NetworkStats createFromParcel(Parcel parcel) {
            return new NetworkStats(parcel);
        }

        public NetworkStats[] newArray(int i) {
            return new NetworkStats[i];
        }
    };
    public static final int DEFAULT_NETWORK_ALL = -1;
    public static final int DEFAULT_NETWORK_NO = 0;
    public static final int DEFAULT_NETWORK_YES = 1;
    public static final String IFACE_ALL = null;
    public static final int METERED_ALL = -1;
    public static final int METERED_NO = 0;
    public static final int METERED_YES = 1;
    public static final int ROAMING_ALL = -1;
    public static final int ROAMING_NO = 0;
    public static final int ROAMING_YES = 1;
    public static final int SET_ALL = -1;
    public static final int SET_DBG_VPN_IN = 1001;
    public static final int SET_DBG_VPN_OUT = 1002;
    public static final int SET_DEBUG_START = 1000;
    public static final int SET_DEFAULT = 0;
    public static final int SET_FOREGROUND = 1;
    public static final int STATS_PER_IFACE = 0;
    public static final int STATS_PER_UID = 1;
    public static final int TAG_ALL = -1;
    public static final int TAG_NONE = 0;
    public static final int UID_ALL = -1;

    /* renamed from: a */
    private long f50787a;

    /* renamed from: b */
    private int f50788b;

    /* renamed from: c */
    private int f50789c;

    /* renamed from: d */
    private String[] f50790d;

    /* renamed from: e */
    private int[] f50791e;

    /* renamed from: f */
    private int[] f50792f;

    /* renamed from: g */
    private int[] f50793g;

    /* renamed from: h */
    private int[] f50794h;

    /* renamed from: i */
    private int[] f50795i;

    /* renamed from: j */
    private int[] f50796j;

    /* renamed from: k */
    private long[] f50797k;

    /* renamed from: l */
    private long[] f50798l;

    /* renamed from: m */
    private long[] f50799m;

    /* renamed from: n */
    private long[] f50800n;

    /* renamed from: o */
    private long[] f50801o;

    public interface NonMonotonicObserver<C> {
        void foundNonMonotonic(NetworkStats networkStats, int i, NetworkStats networkStats2, int i2, C c);
    }

    public static String defaultNetworkToString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? "UNKNOWN" : DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK : DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK : "ALL";
    }

    public static String meteredToString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? "UNKNOWN" : DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK : DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK : "ALL";
    }

    public static String roamingToString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? "UNKNOWN" : DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK : DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK : "ALL";
    }

    public static boolean setMatches(int i, int i2) {
        if (i == i2) {
            return true;
        }
        return i == -1 && i2 < 1000;
    }

    public static String setToCheckinString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 1001 ? i != 1002 ? "unk" : "vpnout" : "vpnin" : "fg" : "def" : "all";
    }

    public static String setToString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 1001 ? i != 1002 ? "UNKNOWN" : "DBG_VPN_OUT" : "DBG_VPN_IN" : "FOREGROUND" : DCryptoUtils.KEY_IP_BLOCKING_STATUS_DEFAULT : "ALL";
    }

    public int describeContents() {
        return 0;
    }

    public static class Entry {
        public int defaultNetwork;
        public String iface;
        public int metered;
        public long operations;
        public int roaming;
        public long rxBytes;
        public long rxPackets;
        public int set;
        public int tag;
        public long txBytes;
        public long txPackets;
        public int uid;

        public Entry() {
            this(NetworkStats.IFACE_ALL, -1, 0, 0, 0, 0, 0, 0, 0);
        }

        public Entry(long j, long j2, long j3, long j4, long j5) {
            this(NetworkStats.IFACE_ALL, -1, 0, 0, j, j2, j3, j4, j5);
        }

        public Entry(String str, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
            this(str, i, i2, i3, 0, 0, 0, j, j2, j3, j4, j5);
        }

        public Entry(String str, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3, long j4, long j5) {
            this.iface = str;
            this.uid = i;
            this.set = i2;
            this.tag = i3;
            this.metered = i4;
            this.roaming = i5;
            this.defaultNetwork = i6;
            this.rxBytes = j;
            this.rxPackets = j2;
            this.txBytes = j3;
            this.txPackets = j4;
            this.operations = j5;
        }

        public boolean isNegative() {
            return this.rxBytes < 0 || this.rxPackets < 0 || this.txBytes < 0 || this.txPackets < 0 || this.operations < 0;
        }

        public boolean isEmpty() {
            return this.rxBytes == 0 && this.rxPackets == 0 && this.txBytes == 0 && this.txPackets == 0 && this.operations == 0;
        }

        public void add(Entry entry) {
            this.rxBytes += entry.rxBytes;
            this.rxPackets += entry.rxPackets;
            this.txBytes += entry.txBytes;
            this.txPackets += entry.txPackets;
            this.operations += entry.operations;
        }

        public String toString() {
            return "iface=" + this.iface + " uid=" + this.uid + " set=" + NetworkStats.setToString(this.set) + " tag=" + NetworkStats.tagToString(this.tag) + " metered=" + NetworkStats.meteredToString(this.metered) + " roaming=" + NetworkStats.roamingToString(this.roaming) + " defaultNetwork=" + NetworkStats.defaultNetworkToString(this.defaultNetwork) + " rxBytes=" + this.rxBytes + " rxPackets=" + this.rxPackets + " txBytes=" + this.txBytes + " txPackets=" + this.txPackets + " operations=" + this.operations;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.uid == entry.uid && this.set == entry.set && this.tag == entry.tag && this.metered == entry.metered && this.roaming == entry.roaming && this.defaultNetwork == entry.defaultNetwork && this.rxBytes == entry.rxBytes && this.rxPackets == entry.rxPackets && this.txBytes == entry.txBytes && this.txPackets == entry.txPackets && this.operations == entry.operations && this.iface.equals(entry.iface)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ArrayUtils.hash(Integer.valueOf(this.uid), Integer.valueOf(this.set), Integer.valueOf(this.tag), Integer.valueOf(this.metered), Integer.valueOf(this.roaming), Integer.valueOf(this.defaultNetwork), this.iface);
        }
    }

    public NetworkStats(long j, int i) {
        this.f50787a = j;
        this.f50788b = 0;
        if (i >= 0) {
            this.f50789c = i;
            this.f50790d = new String[i];
            this.f50791e = new int[i];
            this.f50792f = new int[i];
            this.f50793g = new int[i];
            this.f50794h = new int[i];
            this.f50795i = new int[i];
            this.f50796j = new int[i];
            this.f50797k = new long[i];
            this.f50798l = new long[i];
            this.f50799m = new long[i];
            this.f50800n = new long[i];
            this.f50801o = new long[i];
            return;
        }
        this.f50789c = 0;
        this.f50790d = ArrayUtils.STRING;
        this.f50791e = ArrayUtils.INT;
        this.f50792f = ArrayUtils.INT;
        this.f50793g = ArrayUtils.INT;
        this.f50794h = ArrayUtils.INT;
        this.f50795i = ArrayUtils.INT;
        this.f50796j = ArrayUtils.INT;
        this.f50797k = ArrayUtils.LONG;
        this.f50798l = ArrayUtils.LONG;
        this.f50799m = ArrayUtils.LONG;
        this.f50800n = ArrayUtils.LONG;
        this.f50801o = ArrayUtils.LONG;
    }

    public NetworkStats(Parcel parcel) {
        this.f50787a = parcel.readLong();
        this.f50788b = parcel.readInt();
        this.f50789c = parcel.readInt();
        this.f50790d = parcel.createStringArray();
        this.f50791e = parcel.createIntArray();
        this.f50792f = parcel.createIntArray();
        this.f50793g = parcel.createIntArray();
        this.f50794h = parcel.createIntArray();
        this.f50795i = parcel.createIntArray();
        this.f50796j = parcel.createIntArray();
        this.f50797k = parcel.createLongArray();
        this.f50798l = parcel.createLongArray();
        this.f50799m = parcel.createLongArray();
        this.f50800n = parcel.createLongArray();
        this.f50801o = parcel.createLongArray();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f50787a);
        parcel.writeInt(this.f50788b);
        parcel.writeInt(this.f50789c);
        parcel.writeStringArray(this.f50790d);
        parcel.writeIntArray(this.f50791e);
        parcel.writeIntArray(this.f50792f);
        parcel.writeIntArray(this.f50793g);
        parcel.writeIntArray(this.f50794h);
        parcel.writeIntArray(this.f50795i);
        parcel.writeIntArray(this.f50796j);
        parcel.writeLongArray(this.f50797k);
        parcel.writeLongArray(this.f50798l);
        parcel.writeLongArray(this.f50799m);
        parcel.writeLongArray(this.f50800n);
        parcel.writeLongArray(this.f50801o);
    }

    public NetworkStats clone() {
        NetworkStats networkStats = new NetworkStats(this.f50787a, this.f50788b);
        Entry entry = null;
        for (int i = 0; i < this.f50788b; i++) {
            entry = getValues(i, entry);
            networkStats.addValues(entry);
        }
        return networkStats;
    }

    public NetworkStats addIfaceValues(String str, long j, long j2, long j3, long j4) {
        return addValues(str, -1, 0, 0, j, j2, j3, j4, 0);
    }

    public NetworkStats addValues(String str, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
        return addValues(new Entry(str, i, i2, i3, j, j2, j3, j4, j5));
    }

    public NetworkStats addValues(String str, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3, long j4, long j5) {
        Entry entry = r0;
        Entry entry2 = new Entry(str, i, i2, i3, i4, i5, i6, j, j2, j3, j4, j5);
        return addValues(entry);
    }

    public NetworkStats addValues(Entry entry) {
        int i = this.f50788b;
        if (i >= this.f50789c) {
            int max = (Math.max(i, 10) * 3) / 2;
            this.f50790d = (String[]) Arrays.copyOf(this.f50790d, max);
            this.f50791e = Arrays.copyOf(this.f50791e, max);
            this.f50792f = Arrays.copyOf(this.f50792f, max);
            this.f50793g = Arrays.copyOf(this.f50793g, max);
            this.f50794h = Arrays.copyOf(this.f50794h, max);
            this.f50795i = Arrays.copyOf(this.f50795i, max);
            this.f50796j = Arrays.copyOf(this.f50796j, max);
            this.f50797k = Arrays.copyOf(this.f50797k, max);
            this.f50798l = Arrays.copyOf(this.f50798l, max);
            this.f50799m = Arrays.copyOf(this.f50799m, max);
            this.f50800n = Arrays.copyOf(this.f50800n, max);
            this.f50801o = Arrays.copyOf(this.f50801o, max);
            this.f50789c = max;
        }
        this.f50790d[this.f50788b] = entry.iface;
        this.f50791e[this.f50788b] = entry.uid;
        this.f50792f[this.f50788b] = entry.set;
        this.f50793g[this.f50788b] = entry.tag;
        this.f50794h[this.f50788b] = entry.metered;
        this.f50795i[this.f50788b] = entry.roaming;
        this.f50796j[this.f50788b] = entry.defaultNetwork;
        this.f50797k[this.f50788b] = entry.rxBytes;
        this.f50798l[this.f50788b] = entry.rxPackets;
        this.f50799m[this.f50788b] = entry.txBytes;
        this.f50800n[this.f50788b] = entry.txPackets;
        this.f50801o[this.f50788b] = entry.operations;
        this.f50788b++;
        return this;
    }

    public Entry getValues(int i, Entry entry) {
        if (entry == null) {
            entry = new Entry();
        }
        entry.iface = this.f50790d[i];
        entry.uid = this.f50791e[i];
        entry.set = this.f50792f[i];
        entry.tag = this.f50793g[i];
        entry.metered = this.f50794h[i];
        entry.roaming = this.f50795i[i];
        entry.defaultNetwork = this.f50796j[i];
        entry.rxBytes = this.f50797k[i];
        entry.rxPackets = this.f50798l[i];
        entry.txBytes = this.f50799m[i];
        entry.txPackets = this.f50800n[i];
        entry.operations = this.f50801o[i];
        return entry;
    }

    public long getElapsedRealtime() {
        return this.f50787a;
    }

    public void setElapsedRealtime(long j) {
        this.f50787a = j;
    }

    public long getElapsedRealtimeAge() {
        return SystemClock.elapsedRealtime() - this.f50787a;
    }

    public int size() {
        return this.f50788b;
    }

    public int internalSize() {
        return this.f50789c;
    }

    @Deprecated
    public NetworkStats combineValues(String str, int i, int i2, long j, long j2, long j3, long j4, long j5) {
        return combineValues(str, i, 0, i2, j, j2, j3, j4, j5);
    }

    public NetworkStats combineValues(String str, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
        return combineValues(new Entry(str, i, i2, i3, j, j2, j3, j4, j5));
    }

    public NetworkStats combineValues(Entry entry) {
        int findIndex = findIndex(entry.iface, entry.uid, entry.set, entry.tag, entry.metered, entry.roaming, entry.defaultNetwork);
        if (findIndex == -1) {
            addValues(entry);
        } else {
            long[] jArr = this.f50797k;
            jArr[findIndex] = jArr[findIndex] + entry.rxBytes;
            long[] jArr2 = this.f50798l;
            jArr2[findIndex] = jArr2[findIndex] + entry.rxPackets;
            long[] jArr3 = this.f50799m;
            jArr3[findIndex] = jArr3[findIndex] + entry.txBytes;
            long[] jArr4 = this.f50800n;
            jArr4[findIndex] = jArr4[findIndex] + entry.txPackets;
            long[] jArr5 = this.f50801o;
            jArr5[findIndex] = jArr5[findIndex] + entry.operations;
        }
        return this;
    }

    public void combineAllValues(NetworkStats networkStats) {
        Entry entry = null;
        for (int i = 0; i < networkStats.f50788b; i++) {
            entry = networkStats.getValues(i, entry);
            combineValues(entry);
        }
    }

    public int findIndex(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < this.f50788b; i7++) {
            if (i == this.f50791e[i7] && i2 == this.f50792f[i7] && i3 == this.f50793g[i7] && i4 == this.f50794h[i7] && i5 == this.f50795i[i7] && i6 == this.f50796j[i7] && ArrayUtils.equals(str, this.f50790d[i7])) {
                return i7;
            }
        }
        return -1;
    }

    public int findIndexHinted(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9 = 0;
        while (true) {
            int i10 = this.f50788b;
            if (i9 >= i10) {
                return -1;
            }
            int i11 = i9 / 2;
            if (i9 % 2 == 0) {
                i8 = (i11 + i7) % i10;
            } else {
                i8 = (((i10 + i7) - i11) - 1) % i10;
            }
            if (i == this.f50791e[i8] && i2 == this.f50792f[i8] && i3 == this.f50793g[i8] && i4 == this.f50794h[i8] && i5 == this.f50795i[i8] && i6 == this.f50796j[i8] && ArrayUtils.equals(str, this.f50790d[i8])) {
                return i8;
            }
            i9++;
        }
    }

    public void spliceOperationsFrom(NetworkStats networkStats) {
        for (int i = 0; i < this.f50788b; i++) {
            int findIndex = networkStats.findIndex(this.f50790d[i], this.f50791e[i], this.f50792f[i], this.f50793g[i], this.f50794h[i], this.f50795i[i], this.f50796j[i]);
            if (findIndex == -1) {
                this.f50801o[i] = 0;
            } else {
                this.f50801o[i] = networkStats.f50801o[findIndex];
            }
        }
    }

    public String[] getUniqueIfaces() {
        HashSet hashSet = new HashSet();
        for (String str : this.f50790d) {
            if (str != IFACE_ALL) {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public int[] getUniqueUids() {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int put : this.f50791e) {
            sparseBooleanArray.put(put, true);
        }
        int size = sparseBooleanArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = sparseBooleanArray.keyAt(i);
        }
        return iArr;
    }

    public int[] getUniqueTags() {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int put : this.f50793g) {
            sparseBooleanArray.put(put, true);
        }
        int size = sparseBooleanArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = sparseBooleanArray.keyAt(i);
        }
        return iArr;
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.f50788b; i++) {
            if (this.f50797k[i] > 0 || this.f50798l[i] > 0 || this.f50799m[i] > 0 || this.f50800n[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public long getTotalBytes() {
        Entry total = getTotal((Entry) null);
        return total.rxBytes + total.txBytes;
    }

    public Entry getTotal(Entry entry) {
        return m37820a(entry, (HashSet<String>) null, -1, false);
    }

    public Entry getTotal(Entry entry, int i) {
        return m37820a(entry, (HashSet<String>) null, i, false);
    }

    public Entry getTotal(Entry entry, HashSet<String> hashSet) {
        return m37820a(entry, hashSet, -1, false);
    }

    public Entry getTotalIncludingTags(Entry entry) {
        return m37820a(entry, (HashSet<String>) null, -1, true);
    }

    /* renamed from: a */
    private Entry m37820a(Entry entry, HashSet<String> hashSet, int i, boolean z) {
        if (entry == null) {
            entry = new Entry();
        }
        entry.iface = IFACE_ALL;
        entry.uid = i;
        entry.set = -1;
        entry.tag = 0;
        entry.metered = -1;
        entry.roaming = -1;
        entry.defaultNetwork = -1;
        entry.rxBytes = 0;
        entry.rxPackets = 0;
        entry.txBytes = 0;
        entry.txPackets = 0;
        entry.operations = 0;
        for (int i2 = 0; i2 < this.f50788b; i2++) {
            boolean z2 = true;
            boolean z3 = i == -1 || i == this.f50791e[i2];
            if (hashSet != null && !hashSet.contains(this.f50790d[i2])) {
                z2 = false;
            }
            if (z3 && z2 && (this.f50793g[i2] == 0 || z)) {
                entry.rxBytes += this.f50797k[i2];
                entry.rxPackets += this.f50798l[i2];
                entry.txBytes += this.f50799m[i2];
                entry.txPackets += this.f50800n[i2];
                entry.operations += this.f50801o[i2];
            }
        }
        return entry;
    }

    public long getTotalPackets() {
        long j = 0;
        for (int i = this.f50788b - 1; i >= 0; i--) {
            j += this.f50798l[i] + this.f50800n[i];
        }
        return j;
    }

    public NetworkStats subtract(NetworkStats networkStats) {
        return subtract(this, networkStats, (NonMonotonicObserver) null, (Object) null);
    }

    public static <C> NetworkStats subtract(NetworkStats networkStats, NetworkStats networkStats2, NonMonotonicObserver<C> nonMonotonicObserver, C c) {
        return subtract(networkStats, networkStats2, nonMonotonicObserver, c, (NetworkStats) null);
    }

    public static <C> NetworkStats subtract(NetworkStats networkStats, NetworkStats networkStats2, NonMonotonicObserver<C> nonMonotonicObserver, C c, NetworkStats networkStats3) {
        NetworkStats networkStats4;
        NetworkStats networkStats5;
        int i;
        Entry entry;
        long j;
        NetworkStats networkStats6 = networkStats;
        NetworkStats networkStats7 = networkStats2;
        NetworkStats networkStats8 = networkStats3;
        long j2 = networkStats6.f50787a - networkStats7.f50787a;
        if (j2 < 0) {
            if (nonMonotonicObserver != null) {
                nonMonotonicObserver.foundNonMonotonic(networkStats, -1, networkStats2, -1, c);
            }
            j2 = 0;
        }
        Entry entry2 = new Entry();
        if (networkStats8 == null || networkStats8.f50789c < networkStats6.f50788b) {
            networkStats4 = new NetworkStats(j2, networkStats6.f50788b);
        } else {
            networkStats8.f50788b = 0;
            networkStats8.f50787a = j2;
            networkStats4 = networkStats8;
        }
        int i2 = 0;
        while (i2 < networkStats6.f50788b) {
            entry2.iface = networkStats6.f50790d[i2];
            entry2.uid = networkStats6.f50791e[i2];
            entry2.set = networkStats6.f50792f[i2];
            entry2.tag = networkStats6.f50793g[i2];
            entry2.metered = networkStats6.f50794h[i2];
            entry2.roaming = networkStats6.f50795i[i2];
            entry2.defaultNetwork = networkStats6.f50796j[i2];
            entry2.rxBytes = networkStats6.f50797k[i2];
            entry2.rxPackets = networkStats6.f50798l[i2];
            entry2.txBytes = networkStats6.f50799m[i2];
            entry2.txPackets = networkStats6.f50800n[i2];
            entry2.operations = networkStats6.f50801o[i2];
            NetworkStats networkStats9 = networkStats7;
            int findIndexHinted = networkStats2.findIndexHinted(entry2.iface, entry2.uid, entry2.set, entry2.tag, entry2.metered, entry2.roaming, entry2.defaultNetwork, i2);
            if (findIndexHinted != -1) {
                entry2.rxBytes -= networkStats9.f50797k[findIndexHinted];
                entry2.rxPackets -= networkStats9.f50798l[findIndexHinted];
                entry2.txBytes -= networkStats9.f50799m[findIndexHinted];
                entry2.txPackets -= networkStats9.f50800n[findIndexHinted];
                entry2.operations -= networkStats9.f50801o[findIndexHinted];
            }
            if (entry2.isNegative()) {
                if (nonMonotonicObserver != null) {
                    i = i2;
                    networkStats5 = networkStats4;
                    int i3 = findIndexHinted;
                    entry = entry2;
                    nonMonotonicObserver.foundNonMonotonic(networkStats, i2, networkStats2, i3, c);
                } else {
                    i = i2;
                    networkStats5 = networkStats4;
                    entry = entry2;
                }
                j = 0;
                entry.rxBytes = Math.max(entry.rxBytes, 0);
                entry.rxPackets = Math.max(entry.rxPackets, 0);
                entry.txBytes = Math.max(entry.txBytes, 0);
                entry.txPackets = Math.max(entry.txPackets, 0);
                entry.operations = Math.max(entry.operations, 0);
            } else {
                i = i2;
                networkStats5 = networkStats4;
                entry = entry2;
                j = 0;
            }
            networkStats5.addValues(entry);
            networkStats7 = networkStats2;
            long j3 = j;
            entry2 = entry;
            networkStats4 = networkStats5;
            i2 = i + 1;
        }
        return networkStats4;
    }

    public NetworkStats groupedByIface() {
        NetworkStats networkStats = new NetworkStats(this.f50787a, 10);
        Entry entry = new Entry();
        entry.uid = -1;
        entry.set = -1;
        entry.tag = 0;
        entry.metered = -1;
        entry.roaming = -1;
        entry.defaultNetwork = -1;
        entry.operations = 0;
        for (int i = 0; i < this.f50788b; i++) {
            if (this.f50793g[i] == 0) {
                entry.iface = this.f50790d[i];
                entry.rxBytes = this.f50797k[i];
                entry.rxPackets = this.f50798l[i];
                entry.txBytes = this.f50799m[i];
                entry.txPackets = this.f50800n[i];
                networkStats.combineValues(entry);
            }
        }
        return networkStats;
    }

    public NetworkStats groupedByUid() {
        NetworkStats networkStats = new NetworkStats(this.f50787a, 10);
        Entry entry = new Entry();
        entry.iface = IFACE_ALL;
        entry.set = -1;
        entry.tag = 0;
        entry.metered = -1;
        entry.roaming = -1;
        entry.defaultNetwork = -1;
        for (int i = 0; i < this.f50788b; i++) {
            if (this.f50793g[i] == 0) {
                entry.uid = this.f50791e[i];
                entry.rxBytes = this.f50797k[i];
                entry.rxPackets = this.f50798l[i];
                entry.txBytes = this.f50799m[i];
                entry.txPackets = this.f50800n[i];
                entry.operations = this.f50801o[i];
                networkStats.combineValues(entry);
            }
        }
        return networkStats;
    }

    public NetworkStats withoutUids(int[] iArr) {
        NetworkStats networkStats = new NetworkStats(this.f50787a, 10);
        Entry entry = new Entry();
        for (int i = 0; i < this.f50788b; i++) {
            entry = getValues(i, entry);
            if (!ArrayUtils.contains(iArr, entry.uid)) {
                networkStats.addValues(entry);
            }
        }
        return networkStats;
    }

    public void dump(String str, PrintWriter printWriter) {
        printWriter.print(str);
        printWriter.print("NetworkStats: elapsedRealtime=");
        printWriter.println(this.f50787a);
        for (int i = 0; i < this.f50788b; i++) {
            printWriter.print(str);
            printWriter.print("  [");
            printWriter.print(i);
            printWriter.print(Const.jaRight);
            printWriter.print(" iface=");
            printWriter.print(this.f50790d[i]);
            printWriter.print(" uid=");
            printWriter.print(this.f50791e[i]);
            printWriter.print(" set=");
            printWriter.print(setToString(this.f50792f[i]));
            printWriter.print(" tag=");
            printWriter.print(tagToString(this.f50793g[i]));
            printWriter.print(" metered=");
            printWriter.print(meteredToString(this.f50794h[i]));
            printWriter.print(" roaming=");
            printWriter.print(roamingToString(this.f50795i[i]));
            printWriter.print(" defaultNetwork=");
            printWriter.print(defaultNetworkToString(this.f50796j[i]));
            printWriter.print(" rxBytes=");
            printWriter.print(this.f50797k[i]);
            printWriter.print(" rxPackets=");
            printWriter.print(this.f50798l[i]);
            printWriter.print(" txBytes=");
            printWriter.print(this.f50799m[i]);
            printWriter.print(" txPackets=");
            printWriter.print(this.f50800n[i]);
            printWriter.print(" operations=");
            printWriter.println(this.f50801o[i]);
        }
    }

    public static String tagToString(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static int kernelToTag(String str) {
        int length = str.length();
        if (length > 10) {
            return Long.decode(str.substring(0, length - 8)).intValue();
        }
        return 0;
    }

    public String toString() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        dump("", new PrintWriter(charArrayWriter));
        return charArrayWriter.toString();
    }

    public boolean migrateTun(int i, String str, String str2) {
        Entry entry = new Entry();
        Entry entry2 = new Entry();
        m37823a(i, str, str2, entry, entry2);
        Entry a = m37819a(entry, entry2);
        if (a.isEmpty()) {
            return true;
        }
        Entry b = m37824b(i, str, str2, entry, a);
        m37822a(i, str2, b);
        return b.isEmpty();
    }

    /* renamed from: a */
    private void m37823a(int i, String str, String str2, Entry entry, Entry entry2) {
        Entry entry3 = new Entry();
        int i2 = 0;
        while (i2 < this.f50788b) {
            getValues(i2, entry3);
            if (entry3.uid == -1) {
                throw new IllegalStateException("Cannot adjust VPN accounting on an iface aggregated NetworkStats.");
            } else if (entry3.set == 1001 || entry3.set == 1002) {
                throw new IllegalStateException("Cannot adjust VPN accounting on a NetworkStats containing SET_DBG_VPN_*");
            } else {
                if (entry3.uid == i && entry3.tag == 0 && ArrayUtils.equals(str2, entry3.iface)) {
                    entry2.add(entry3);
                }
                if (entry3.uid != i && entry3.tag == 0 && ArrayUtils.equals(str, entry3.iface)) {
                    entry.add(entry3);
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    private static Entry m37819a(Entry entry, Entry entry2) {
        Entry entry3 = new Entry();
        entry3.rxBytes = Math.min(entry.rxBytes, entry2.rxBytes);
        entry3.rxPackets = Math.min(entry.rxPackets, entry2.rxPackets);
        entry3.txBytes = Math.min(entry.txBytes, entry2.txBytes);
        entry3.txPackets = Math.min(entry.txPackets, entry2.txPackets);
        entry3.operations = Math.min(entry.operations, entry2.operations);
        return entry3;
    }

    /* renamed from: b */
    private Entry m37824b(int i, String str, String str2, Entry entry, Entry entry2) {
        Entry entry3 = new Entry();
        Entry entry4 = new Entry();
        entry4.iface = str2;
        for (int i2 = 0; i2 < this.f50788b; i2++) {
            if (ArrayUtils.equals(this.f50790d[i2], str) && this.f50791e[i2] != i) {
                if (entry.rxBytes > 0) {
                    entry4.rxBytes = (entry2.rxBytes * this.f50797k[i2]) / entry.rxBytes;
                } else {
                    entry4.rxBytes = 0;
                }
                if (entry.rxPackets > 0) {
                    entry4.rxPackets = (entry2.rxPackets * this.f50798l[i2]) / entry.rxPackets;
                } else {
                    entry4.rxPackets = 0;
                }
                if (entry.txBytes > 0) {
                    entry4.txBytes = (entry2.txBytes * this.f50799m[i2]) / entry.txBytes;
                } else {
                    entry4.txBytes = 0;
                }
                if (entry.txPackets > 0) {
                    entry4.txPackets = (entry2.txPackets * this.f50800n[i2]) / entry.txPackets;
                } else {
                    entry4.txPackets = 0;
                }
                if (entry.operations > 0) {
                    entry4.operations = (entry2.operations * this.f50801o[i2]) / entry.operations;
                } else {
                    entry4.operations = 0;
                }
                entry4.uid = this.f50791e[i2];
                entry4.tag = this.f50793g[i2];
                entry4.set = this.f50792f[i2];
                entry4.metered = this.f50794h[i2];
                entry4.roaming = this.f50795i[i2];
                entry4.defaultNetwork = this.f50796j[i2];
                combineValues(entry4);
                if (this.f50793g[i2] == 0) {
                    entry3.add(entry4);
                    entry4.set = 1001;
                    combineValues(entry4);
                }
            }
        }
        return entry3;
    }

    /* renamed from: a */
    private void m37822a(int i, String str, Entry entry) {
        entry.uid = i;
        entry.set = 1002;
        entry.tag = 0;
        entry.iface = str;
        entry.metered = -1;
        entry.roaming = -1;
        entry.defaultNetwork = -1;
        combineValues(entry);
        int findIndex = findIndex(str, i, 0, 0, 0, 0, 0);
        if (findIndex != -1) {
            m37821a(findIndex, this, entry);
        }
        int findIndex2 = findIndex(str, i, 1, 0, 0, 0, 0);
        if (findIndex2 != -1) {
            m37821a(findIndex2, this, entry);
        }
    }

    /* renamed from: a */
    private static void m37821a(int i, NetworkStats networkStats, Entry entry) {
        long min = Math.min(networkStats.f50797k[i], entry.rxBytes);
        long[] jArr = networkStats.f50797k;
        jArr[i] = jArr[i] - min;
        entry.rxBytes -= min;
        long min2 = Math.min(networkStats.f50798l[i], entry.rxPackets);
        long[] jArr2 = networkStats.f50798l;
        jArr2[i] = jArr2[i] - min2;
        entry.rxPackets -= min2;
        long min3 = Math.min(networkStats.f50799m[i], entry.txBytes);
        long[] jArr3 = networkStats.f50799m;
        jArr3[i] = jArr3[i] - min3;
        entry.txBytes -= min3;
        long min4 = Math.min(networkStats.f50800n[i], entry.txPackets);
        long[] jArr4 = networkStats.f50800n;
        jArr4[i] = jArr4[i] - min4;
        entry.txPackets -= min4;
    }
}
