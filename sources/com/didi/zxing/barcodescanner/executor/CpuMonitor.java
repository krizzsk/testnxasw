package com.didi.zxing.barcodescanner.executor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.sdk.apm.SystemUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class CpuMonitor {

    /* renamed from: a */
    private static final String f48058a = "CpuMonitor";

    /* renamed from: b */
    private static final int f48059b = 5;

    /* renamed from: c */
    private static final int f48060c = 2000;

    /* renamed from: d */
    private static final int f48061d = 6000;

    /* renamed from: e */
    private final Context f48062e;

    /* renamed from: f */
    private final MovingAverage f48063f = new MovingAverage(5);

    /* renamed from: g */
    private final MovingAverage f48064g = new MovingAverage(5);

    /* renamed from: h */
    private final MovingAverage f48065h = new MovingAverage(5);

    /* renamed from: i */
    private final MovingAverage f48066i = new MovingAverage(5);

    /* renamed from: j */
    private ScheduledExecutorService f48067j;

    /* renamed from: k */
    private long f48068k = SystemClock.elapsedRealtime();

    /* renamed from: l */
    private long[] f48069l;

    /* renamed from: m */
    private int f48070m;

    /* renamed from: n */
    private int f48071n;

    /* renamed from: o */
    private boolean f48072o;

    /* renamed from: p */
    private boolean f48073p;

    /* renamed from: q */
    private String[] f48074q;

    /* renamed from: r */
    private String[] f48075r;

    /* renamed from: s */
    private double[] f48076s;

    /* renamed from: t */
    private ProcStat f48077t;

    /* renamed from: a */
    private int m36074a(double d) {
        return (int) ((d * 100.0d) + 0.5d);
    }

    private static class ProcStat {
        final long idleTime;
        final long systemTime;
        final long userTime;

        ProcStat(long j, long j2, long j3) {
            this.userTime = j;
            this.systemTime = j2;
            this.idleTime = j3;
        }
    }

    private static class MovingAverage {
        private double[] circBuffer;
        private int circBufferIndex;
        private double currentValue;
        private final int size;
        private double sum;

        public MovingAverage(int i) {
            if (i > 0) {
                this.size = i;
                this.circBuffer = new double[i];
                return;
            }
            throw new AssertionError("Size value in MovingAverage ctor should be positive.");
        }

        public void reset() {
            Arrays.fill(this.circBuffer, 0.0d);
            this.circBufferIndex = 0;
            this.sum = 0.0d;
            this.currentValue = 0.0d;
        }

        public void addValue(double d) {
            double d2 = this.sum;
            double[] dArr = this.circBuffer;
            int i = this.circBufferIndex;
            double d3 = d2 - dArr[i];
            this.sum = d3;
            int i2 = i + 1;
            this.circBufferIndex = i2;
            dArr[i] = d;
            this.currentValue = d;
            this.sum = d3 + d;
            if (i2 >= this.size) {
                this.circBufferIndex = 0;
            }
        }

        public double getCurrent() {
            return this.currentValue;
        }

        public double getAverage() {
            return this.sum / ((double) this.size);
        }
    }

    public CpuMonitor(Context context) {
        SystemUtils.log(3, f48058a, "CpuMonitor ctor.", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 156);
        this.f48062e = context.getApplicationContext();
        m36078g();
    }

    /* renamed from: a */
    public void mo120382a() {
        if (this.f48067j != null) {
            SystemUtils.log(3, f48058a, "pause", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 169);
            this.f48067j.shutdownNow();
        }
    }

    /* renamed from: b */
    public void mo120383b() {
        SystemUtils.log(3, f48058a, "resume", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 176);
        m36081j();
        m36078g();
    }

    /* renamed from: c */
    public synchronized void mo120384c() {
        if (this.f48067j != null) {
            SystemUtils.log(3, f48058a, "reset", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 183);
            m36081j();
            this.f48073p = false;
        }
    }

    /* renamed from: d */
    public synchronized int mo120385d() {
        return m36074a(this.f48063f.getCurrent() + this.f48064g.getCurrent());
    }

    /* renamed from: e */
    public synchronized int mo120386e() {
        return m36074a(this.f48063f.getAverage() + this.f48064g.getAverage());
    }

    /* renamed from: f */
    public synchronized int mo120387f() {
        return m36074a(this.f48066i.getAverage());
    }

    /* renamed from: g */
    private void m36078g() {
        ScheduledExecutorService scheduledExecutorService = this.f48067j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f48067j = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                CpuMonitor.this.m36079h();
            }
        }, 0, 2000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m36079h() {
        if (m36083l() && SystemClock.elapsedRealtime() - this.f48068k >= 6000) {
            this.f48068k = SystemClock.elapsedRealtime();
            SystemUtils.log(3, f48058a, m36084m(), (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 223);
        }
    }

    /* renamed from: i */
    private void m36080i() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/present");
            try {
                Scanner useDelimiter = new Scanner(new BufferedReader(fileReader)).useDelimiter("[-\n]");
                useDelimiter.nextInt();
                this.f48070m = useDelimiter.nextInt() + 1;
                useDelimiter.close();
            } catch (Exception unused) {
                SystemUtils.log(6, f48058a, "Cannot do CPU stats due to /sys/devices/system/cpu/present parsing problem", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 237);
            }
            fileReader.close();
        } catch (FileNotFoundException unused2) {
            SystemUtils.log(6, f48058a, "Cannot do CPU stats since /sys/devices/system/cpu/present is missing", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 242);
        } catch (IOException unused3) {
            SystemUtils.log(6, f48058a, "Error closing file", (Throwable) null, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 244);
        } catch (Throwable th) {
            fileReader.close();
            throw th;
        }
        int i = this.f48070m;
        this.f48069l = new long[i];
        this.f48074q = new String[i];
        this.f48075r = new String[i];
        this.f48076s = new double[i];
        for (int i2 = 0; i2 < this.f48070m; i2++) {
            this.f48069l[i2] = 0;
            this.f48076s[i2] = 0.0d;
            String[] strArr = this.f48074q;
            strArr[i2] = "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.f48075r;
            strArr2[i2] = "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/scaling_cur_freq";
        }
        this.f48077t = new ProcStat(0, 0, 0);
        m36081j();
        this.f48072o = true;
    }

    /* renamed from: j */
    private synchronized void m36081j() {
        this.f48063f.reset();
        this.f48064g.reset();
        this.f48065h.reset();
        this.f48066i.reset();
        this.f48068k = SystemClock.elapsedRealtime();
    }

    /* renamed from: k */
    private int m36082k() {
        Intent intent = null;
        try {
            intent = this.f48062e.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        int intExtra = intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, 100);
        if (intExtra > 0) {
            return (int) ((((float) intent.getIntExtra("level", 0)) * 100.0f) / ((float) intExtra));
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0105, code lost:
        return false;
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m36083l() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            boolean r0 = r1.f48072o     // Catch:{ all -> 0x0117 }
            if (r0 != 0) goto L_0x000a
            r21.m36080i()     // Catch:{ all -> 0x0117 }
        L_0x000a:
            int r0 = r1.f48070m     // Catch:{ all -> 0x0117 }
            r2 = 0
            if (r0 != 0) goto L_0x0011
            monitor-exit(r21)
            return r2
        L_0x0011:
            r1.f48071n = r2     // Catch:{ all -> 0x0117 }
            r3 = 0
            r5 = r3
            r7 = r5
            r9 = r7
            r0 = 0
        L_0x0019:
            int r11 = r1.f48070m     // Catch:{ all -> 0x0117 }
            r12 = 1
            r13 = 0
            if (r0 >= r11) goto L_0x0095
            double[] r11 = r1.f48076s     // Catch:{ all -> 0x0117 }
            r11[r0] = r13     // Catch:{ all -> 0x0117 }
            long[] r11 = r1.f48069l     // Catch:{ all -> 0x0117 }
            r13 = r11[r0]     // Catch:{ all -> 0x0117 }
            int r11 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r11 != 0) goto L_0x0068
            java.lang.String[] r11 = r1.f48074q     // Catch:{ all -> 0x0117 }
            r11 = r11[r0]     // Catch:{ all -> 0x0117 }
            long r13 = r1.m36075a((java.lang.String) r11)     // Catch:{ all -> 0x0117 }
            int r11 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r11 <= 0) goto L_0x006d
            java.lang.String r16 = "CpuMonitor"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0117 }
            r9.<init>()     // Catch:{ all -> 0x0117 }
            java.lang.String r10 = "Core "
            r9.append(r10)     // Catch:{ all -> 0x0117 }
            r9.append(r0)     // Catch:{ all -> 0x0117 }
            java.lang.String r10 = ". Max frequency: "
            r9.append(r10)     // Catch:{ all -> 0x0117 }
            r9.append(r13)     // Catch:{ all -> 0x0117 }
            java.lang.String r17 = r9.toString()     // Catch:{ all -> 0x0117 }
            r15 = 3
            r18 = 0
            java.lang.String r19 = "com.didi.zxing.barcodescanner.executor.CpuMonitor"
            r20 = 319(0x13f, float:4.47E-43)
            com.didi.sdk.apm.SystemUtils.log(r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0117 }
            long[] r9 = r1.f48069l     // Catch:{ all -> 0x0117 }
            r9[r0] = r13     // Catch:{ all -> 0x0117 }
            java.lang.String[] r9 = r1.f48074q     // Catch:{ all -> 0x0117 }
            r10 = 0
            r9[r0] = r10     // Catch:{ all -> 0x0117 }
            r9 = r13
            goto L_0x006d
        L_0x0068:
            long[] r9 = r1.f48069l     // Catch:{ all -> 0x0117 }
            r10 = r9[r0]     // Catch:{ all -> 0x0117 }
            r9 = r10
        L_0x006d:
            java.lang.String[] r11 = r1.f48075r     // Catch:{ all -> 0x0117 }
            r11 = r11[r0]     // Catch:{ all -> 0x0117 }
            long r13 = r1.m36075a((java.lang.String) r11)     // Catch:{ all -> 0x0117 }
            int r11 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r11 != 0) goto L_0x007e
            int r15 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r15 != 0) goto L_0x007e
            goto L_0x0092
        L_0x007e:
            if (r11 <= 0) goto L_0x0085
            int r11 = r1.f48071n     // Catch:{ all -> 0x0117 }
            int r11 = r11 + r12
            r1.f48071n = r11     // Catch:{ all -> 0x0117 }
        L_0x0085:
            long r5 = r5 + r13
            long r7 = r7 + r9
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 <= 0) goto L_0x0092
            double[] r11 = r1.f48076s     // Catch:{ all -> 0x0117 }
            double r12 = (double) r13     // Catch:{ all -> 0x0117 }
            double r14 = (double) r9     // Catch:{ all -> 0x0117 }
            double r12 = r12 / r14
            r11[r0] = r12     // Catch:{ all -> 0x0117 }
        L_0x0092:
            int r0 = r0 + 1
            goto L_0x0019
        L_0x0095:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0107
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x009e
            goto L_0x0107
        L_0x009e:
            double r5 = (double) r5     // Catch:{ all -> 0x0117 }
            double r7 = (double) r7     // Catch:{ all -> 0x0117 }
            double r5 = r5 / r7
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r0 = r1.f48066i     // Catch:{ all -> 0x0117 }
            double r7 = r0.getCurrent()     // Catch:{ all -> 0x0117 }
            int r0 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b6
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r0 = r1.f48066i     // Catch:{ all -> 0x0117 }
            double r7 = r0.getCurrent()     // Catch:{ all -> 0x0117 }
            double r7 = r7 + r5
            r5 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r5 = r5 * r7
        L_0x00b6:
            com.didi.zxing.barcodescanner.executor.CpuMonitor$ProcStat r0 = r21.m36085n()     // Catch:{ all -> 0x0117 }
            if (r0 != 0) goto L_0x00be
            monitor-exit(r21)
            return r2
        L_0x00be:
            long r7 = r0.userTime     // Catch:{ all -> 0x0117 }
            com.didi.zxing.barcodescanner.executor.CpuMonitor$ProcStat r9 = r1.f48077t     // Catch:{ all -> 0x0117 }
            long r9 = r9.userTime     // Catch:{ all -> 0x0117 }
            long r7 = r7 - r9
            long r9 = r0.systemTime     // Catch:{ all -> 0x0117 }
            com.didi.zxing.barcodescanner.executor.CpuMonitor$ProcStat r11 = r1.f48077t     // Catch:{ all -> 0x0117 }
            long r2 = r11.systemTime     // Catch:{ all -> 0x0117 }
            long r9 = r9 - r2
            long r2 = r0.idleTime     // Catch:{ all -> 0x0117 }
            com.didi.zxing.barcodescanner.executor.CpuMonitor$ProcStat r4 = r1.f48077t     // Catch:{ all -> 0x0117 }
            long r12 = r4.idleTime     // Catch:{ all -> 0x0117 }
            long r2 = r2 - r12
            long r12 = r7 + r9
            long r12 = r12 + r2
            r2 = 0
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0104
            r2 = 0
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00e3
            goto L_0x0104
        L_0x00e3:
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r2 = r1.f48066i     // Catch:{ all -> 0x0117 }
            r2.addValue(r5)     // Catch:{ all -> 0x0117 }
            double r2 = (double) r7     // Catch:{ all -> 0x0117 }
            double r7 = (double) r12     // Catch:{ all -> 0x0117 }
            double r2 = r2 / r7
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r4 = r1.f48063f     // Catch:{ all -> 0x0117 }
            r4.addValue(r2)     // Catch:{ all -> 0x0117 }
            double r9 = (double) r9     // Catch:{ all -> 0x0117 }
            double r9 = r9 / r7
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r4 = r1.f48064g     // Catch:{ all -> 0x0117 }
            r4.addValue(r9)     // Catch:{ all -> 0x0117 }
            double r2 = r2 + r9
            double r2 = r2 * r5
            com.didi.zxing.barcodescanner.executor.CpuMonitor$MovingAverage r4 = r1.f48065h     // Catch:{ all -> 0x0117 }
            r4.addValue(r2)     // Catch:{ all -> 0x0117 }
            r1.f48077t = r0     // Catch:{ all -> 0x0117 }
            monitor-exit(r21)
            r0 = 1
            return r0
        L_0x0104:
            monitor-exit(r21)
            r0 = 0
            return r0
        L_0x0107:
            java.lang.String r3 = "CpuMonitor"
            java.lang.String r4 = "Could not read max or current frequency for any CPU"
            r2 = 6
            r5 = 0
            java.lang.String r6 = "com.didi.zxing.barcodescanner.executor.CpuMonitor"
            r7 = 351(0x15f, float:4.92E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0117 }
            monitor-exit(r21)
            r0 = 0
            return r0
        L_0x0117:
            r0 = move-exception
            monitor-exit(r21)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.zxing.barcodescanner.executor.CpuMonitor.m36083l():boolean");
    }

    /* renamed from: m */
    private synchronized String m36084m() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("CPU User: ");
        sb.append(m36074a(this.f48063f.getCurrent()));
        sb.append("/");
        sb.append(m36074a(this.f48063f.getAverage()));
        sb.append(". System: ");
        sb.append(m36074a(this.f48064g.getCurrent()));
        sb.append("/");
        sb.append(m36074a(this.f48064g.getAverage()));
        sb.append(". Freq: ");
        sb.append(m36074a(this.f48066i.getCurrent()));
        sb.append("/");
        sb.append(m36074a(this.f48066i.getAverage()));
        sb.append(". Total usage: ");
        sb.append(m36074a(this.f48065h.getCurrent()));
        sb.append("/");
        sb.append(m36074a(this.f48065h.getAverage()));
        sb.append(". Cores: ");
        sb.append(this.f48071n);
        sb.append("( ");
        for (int i = 0; i < this.f48070m; i++) {
            sb.append(m36074a(this.f48076s[i]));
            sb.append(" ");
        }
        sb.append("). Battery: ");
        sb.append(m36082k());
        if (this.f48073p) {
            sb.append(". Overuse.");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private long m36075a(String str) {
        BufferedReader bufferedReader;
        long j = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            j = m36077b(bufferedReader.readLine());
            bufferedReader.close();
        } catch (FileNotFoundException | IOException unused) {
        } catch (Throwable th) {
            bufferedReader.close();
            throw th;
        }
        return j;
    }

    /* renamed from: b */
    private static long m36077b(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            SystemUtils.log(6, f48058a, "parseLong error.", e, "com.didi.zxing.barcodescanner.executor.CpuMonitor", 464);
            return 0;
        }
    }

    /* renamed from: n */
    private ProcStat m36085n() {
        BufferedReader bufferedReader;
        long j;
        long j2;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/stat"));
            String[] split = bufferedReader.readLine().split("\\s+");
            int length = split.length;
            long j3 = 0;
            if (length >= 5) {
                j3 = m36077b(split[1]) + m36077b(split[2]);
                j2 = m36077b(split[3]);
                j = m36077b(split[4]);
            } else {
                j2 = 0;
                j = 0;
            }
            if (length >= 8) {
                j3 += m36077b(split[5]);
                j2 = j2 + m36077b(split[6]) + m36077b(split[7]);
            }
            long j4 = j3;
            long j5 = j2;
            bufferedReader.close();
            return new ProcStat(j4, j5, j);
        } catch (Exception unused) {
            bufferedReader.close();
            return null;
        } catch (FileNotFoundException | IOException unused2) {
            return null;
        } catch (Throwable th) {
            bufferedReader.close();
            throw th;
        }
    }
}
