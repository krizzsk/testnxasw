package com.threatmetrix.TrustDefender;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.threatmetrix.TrustDefender.IInternalService;
import com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface;
import com.threatmetrix.TrustDefender.TMXProfilingHandle;
import com.threatmetrix.TrustDefender.TMXProfilingModule.BuildConfig;
import com.threatmetrix.TrustDefender.TMXStrongAuth;
import com.threatmetrix.TrustDefender.jkjjkj;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class jjkjkj {
    public static volatile yyqyqy b00730073ss0073s = null;
    /* access modifiers changed from: private */
    public static final String b0073sss0073s = yyyyqy.b0074t007400740074t(jjkjkj.class);
    private static final boolean bs0073ss0073s;
    public static final String version = "6.3-80";
    private volatile boolean b00730073007300730073s = false;
    /* access modifiers changed from: private */
    @Nullable
    public volatile String b007300730073s0073s = null;
    public volatile boolean b007300730073ss0073 = true;
    /* access modifiers changed from: private */
    public volatile long b00730073s00730073s = 0;
    public final yqyyyq b00730073sss0073 = new yqyyyq();
    /* access modifiers changed from: private */
    public volatile boolean b0073s007300730073s = false;
    @Nullable
    private final jjjjjk b0073s0073s0073s;
    @Nullable
    public volatile TMXProfilingConnectionsInterface b0073s0073ss0073 = null;
    @Nullable
    private volatile Thread b0073ss00730073s = null;
    private final kjjkjk b0073ss0073s0073 = new kjjkjk();
    @Nullable
    public yqqqyq b0073ssss0073 = null;
    /* access modifiers changed from: private */
    public int bs0073007300730073s = 30000;
    @Nullable
    private final jjjkjk bs00730073s0073s;
    public volatile int bs00730073ss0073 = 0;
    /* access modifiers changed from: private */
    @Nullable
    public volatile kjjjjj bs0073s00730073s = null;
    @Nullable
    public jkjjkj bs0073sss0073 = null;
    /* access modifiers changed from: private */
    public volatile int bss007300730073s = 0;
    /* access modifiers changed from: private */
    @Nullable
    public final kjjjjk bss0073s0073s;
    @Nullable
    public tqtqqt bss0073ss0073 = null;
    @Nullable
    private volatile Thread bsss00730073s = null;
    public final AtomicLong bsss0073s0073 = new AtomicLong(0);
    private volatile int bsssss0073 = 10000;

    public interface jjjjjk {
        void config(TMXConfig tMXConfig);

        jkjjkj.GenericLocation getLocation();

        void pause();

        void resume();

        void setLocation(jkjjkj.GenericLocation genericLocation);

        void unregister();
    }

    public interface jjjkjk {
        void attest(tqtqqt tqtqqt, String str);

        String getNonce();

        String getResult();
    }

    public class jjkjjk implements TMXProfilingConnectionsInterface.TMXCallback {
        @Nonnull
        public final String b006A006A006A006A006Aj;
        @Nonnull
        public TMXProfilingConnectionsInterface.TMXHttpResponseCode bjjjjj006A = new TMXProfilingConnectionsInterface.TMXHttpResponseCode(-2);

        public jjkjjk(String str) {
            this.b006A006A006A006A006Aj = str;
        }

        @Nonnull
        public TMXStatusCode bs00730073007300730073s() {
            int httpResponseCode = this.bjjjjj006A.getHttpResponseCode();
            if (httpResponseCode == 200) {
                return TMXStatusCode.TMX_OK;
            }
            switch (httpResponseCode) {
                case -15:
                    return TMXStatusCode.TMX_CRLError;
                case -14:
                    return TMXStatusCode.TMX_CertStoreError;
                case -13:
                    return TMXStatusCode.TMX_CertPathValidatorError;
                case -12:
                    return TMXStatusCode.TMX_CertPathBuilderError;
                case -11:
                    return TMXStatusCode.TMX_CertificateParsingError;
                case -10:
                    return TMXStatusCode.TMX_CertificateNotYetValid;
                case -9:
                    return TMXStatusCode.TMX_CertificateExpired;
                case -8:
                    return TMXStatusCode.TMX_CertificateEncodingError;
                case -7:
                    return TMXStatusCode.TMX_CertificateError;
                case -6:
                    return TMXStatusCode.TMX_Certificate_Mismatch;
                case -5:
                    return TMXStatusCode.TMX_HostVerification_Error;
                case -4:
                    return TMXStatusCode.TMX_NetworkTimeout_Error;
                case -3:
                    return TMXStatusCode.TMX_HostNotFound_Error;
                case -2:
                    return TMXStatusCode.TMX_NotYet;
                default:
                    return TMXStatusCode.TMX_Connection_Error;
            }
        }

        public boolean onComplete(TMXProfilingConnectionsInterface.TMXHttpResponseCode tMXHttpResponseCode, InputStream inputStream) {
            this.bjjjjj006A = tMXHttpResponseCode;
            if (tMXHttpResponseCode.succeeded()) {
                return true;
            }
            yyyyqy.bt00740074tt0074(jjkjkj.b0073sss0073s, "Failed to request {} with http response {}", this.b006A006A006A006A006Aj, tMXHttpResponseCode.toString());
            return false;
        }
    }

    public private final class jkjjjk implements Runnable {
        private boolean b006A006Aj006A006Aj = false;
        private final boolean bjj006A006A006Aj;

        public jkjjjk(boolean z) {
            this.bjj006A006A006Aj = z;
        }

        public boolean b0073s0073007300730073s() {
            return this.b006A006Aj006A006Aj;
        }

        public void run() {
            try {
                qyqqqy.b007800780078xxx(jjkjkj.this.bss0073ss0073.bll006C006C006C006C);
                String str = null;
                kjjjjk bs007300730073ss0073 = jjkjkj.this.bss0073s0073s;
                if (!(bs007300730073ss0073 == null || !jjkjkj.this.b0073s007300730073s || (jjkjkj.this.bsss0073s0073.get() & 131072) == 0)) {
                    str = bs007300730073ss0073.getAdvertisingId(jjkjkj.this.bs00730073ss0073 / 10);
                }
                if (jjkjkj.this.b00730073sss0073.bx0078xxx0078() || Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                jjkjkj.this.bs0073sss0073.b0073ss007300730073s(str, jjkjkj.this.b00730073sss0073, jjkjkj.this.b007300730073s0073s, this.bjj006A006A006Aj);
            } catch (InterruptedException unused) {
                this.b006A006Aj006A006Aj = true;
            }
        }
    }

    public private class jkkjjk implements TMXProfilingHandle {
        private final String b006A006Ajjj006A;

        public jkkjjk(String str) {
            this.b006A006Ajjj006A = str;
        }

        public void cancel() {
            jjkjkj.this.b0073ss00730073s0073();
        }

        public String getSessionID() {
            return this.b006A006Ajjj006A;
        }
    }

    public class jkkkkj extends jjkjjk {
        @Nonnull
        public CountDownLatch b006A006Ajj006Aj;
        @Nonnull
        public String b006Aj006Aj006Aj;
        @Nonnull
        public String bj006A006Aj006Aj;
        @Nonnull
        public yqqqqq bjj006Aj006Aj;

        public jkkkkj(String str, @Nonnull CountDownLatch countDownLatch, @Nonnull yqqqqq yqqqqq, @Nonnull String str2, @Nonnull String str3) {
            super(str);
            this.b006A006Ajj006Aj = countDownLatch;
            this.bjj006Aj006Aj = yqqqqq;
            this.b006Aj006Aj006Aj = str2;
            this.bj006A006Aj006Aj = str3;
        }

        public boolean onComplete(TMXProfilingConnectionsInterface.TMXHttpResponseCode tMXHttpResponseCode, @Nullable InputStream inputStream) {
            String b0073ss0073ss0073;
            String str;
            if (super.onComplete(tMXHttpResponseCode, inputStream)) {
                if (inputStream == null) {
                    b0073ss0073ss0073 = jjkjkj.b0073sss0073s;
                    str = "Configure request succeeded but stream is null";
                } else {
                    try {
                        this.bjj006Aj006Aj.bhhhh0068h(inputStream, this.b006Aj006Aj006Aj, this.bj006A006Aj006Aj);
                        this.b006A006Ajj006Aj.countDown();
                        return true;
                    } catch (InterruptedIOException unused) {
                        b0073ss0073ss0073 = jjkjkj.b0073sss0073s;
                        str = "Failed to read the input stream";
                    }
                }
                yyyyqy.btt0074tt0074(b0073ss0073ss0073, str);
            }
            this.b006A006Ajj006Aj.countDown();
            return false;
        }
    }

    public interface kjjjjk {
        boolean bindToGooglePlayService(@Nonnull tqtqqt tqtqqt);

        String getAdvertisingId(int i);
    }

    public final class kjjkjk implements ServiceConnection {
        /* access modifiers changed from: private */
        public boolean b006A006A006Ajj006A = false;
        /* access modifiers changed from: private */
        public List<String> b006Ajj006Aj006A;
        /* access modifiers changed from: private */
        public IInternalService bj006A006Ajj006A = null;
        private Thread bj006Aj006Aj006A;
        /* access modifiers changed from: private */
        public final ReentrantLock bjjj006Aj006A = new ReentrantLock();

        public kjjkjk() {
        }

        /* access modifiers changed from: private */
        public boolean b0073s0073sss0073(Context context) {
            if ((jjkjkj.b00730073ss0073s.b0067ggggg() & 4) == 0) {
                return false;
            }
            Intent intent = new Intent(context, InternalService.class);
            this.bjjj006Aj006A.lock();
            try {
                return context.bindService(intent, this, 1);
            } catch (SecurityException e) {
                String b0073ss0073ss0073 = jjkjkj.b0073sss0073s;
                yyyyqy.qyyyqy.bt0074tttt(b0073ss0073ss0073, "Filed to bind the service " + e.toString());
                return false;
            } finally {
                this.bjjj006Aj006A.unlock();
            }
        }

        /* access modifiers changed from: private */
        public void bsss0073ss0073(Context context) {
            this.bjjj006Aj006A.lock();
            try {
                if (!this.b006A006A006Ajj006A) {
                    this.bjjj006Aj006A.unlock();
                    return;
                }
                context.unbindService(this);
                this.b006A006A006Ajj006A = false;
                this.bj006A006Ajj006A = null;
                this.bjjj006Aj006A.unlock();
            } catch (Throwable th) {
                this.bjjj006Aj006A.unlock();
                throw th;
            }
        }

        public void b007300730073sss0073(final List<String> list) {
            if (list != null && !list.isEmpty()) {
                this.bjjj006Aj006A.lock();
                try {
                    if (this.b006A006A006Ajj006A) {
                        this.bjjj006Aj006A.unlock();
                        this.b006Ajj006Aj006A = new ArrayList(list.size());
                        Thread thread = new Thread(new Runnable() {
                            public void run() {
                                kjjkjk.this.bjjj006Aj006A.lock();
                                try {
                                    if (kjjkjk.this.b006A006A006Ajj006A && kjjkjk.this.bj006A006Ajj006A != null) {
                                        kjjkjk.this.b006Ajj006Aj006A.addAll(kjjkjk.this.bj006A006Ajj006A.getResults(list));
                                    }
                                } catch (RemoteException e) {
                                    String b0073ss0073ss0073 = jjkjkj.b0073sss0073s;
                                    yyyyqy.qyyyqy.bt00740074ttt(b0073ss0073ss0073, "Failed to use the service " + e.toString());
                                } catch (Throwable th) {
                                    kjjkjk.this.bjjj006Aj006A.unlock();
                                    throw th;
                                }
                                kjjkjk.this.bjjj006Aj006A.unlock();
                            }
                        });
                        this.bj006Aj006Aj006A = thread;
                        thread.start();
                    }
                } finally {
                    this.bjjj006Aj006A.unlock();
                }
            }
        }

        @Nullable
        public List<String> bs00730073sss0073() {
            Thread thread = this.bj006Aj006Aj006A;
            if (thread == null) {
                return null;
            }
            if (thread.isAlive()) {
                try {
                    this.bj006Aj006Aj006A.join(Math.abs(((long) jjkjkj.this.bs00730073ss0073) - qqyyyq.bxxxx00780078().bxx0078x00780078()));
                } catch (InterruptedException e) {
                    String b0073ss0073ss0073 = jjkjkj.b0073sss0073s;
                    yyyyqy.qyyyqy.bt00740074ttt(b0073ss0073ss0073, "Interrupted while joining serviceThread " + e.toString());
                }
            }
            return new ArrayList(this.b006Ajj006Aj006A);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.bjjj006Aj006A.lock();
            try {
                this.bj006A006Ajj006A = IInternalService.Stub.asInterface(iBinder);
                this.b006A006A006Ajj006A = true;
            } finally {
                this.bjjj006Aj006A.unlock();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.bjjj006Aj006A.lock();
            try {
                this.b006A006A006Ajj006A = false;
                this.bj006A006Ajj006A = null;
            } finally {
                this.bjjj006Aj006A.unlock();
            }
        }
    }

    public enum kjkjjk {
        PROFILE,
        SCAN_PACKAGES,
        INIT
    }

    public class kjkkkj extends jjkjjk {
        public CountDownLatch b006Ajjj006Aj;

        public kjkkkj(String str, @Nonnull CountDownLatch countDownLatch) {
            super(str);
            this.b006Ajjj006Aj = countDownLatch;
        }

        public boolean onComplete(TMXProfilingConnectionsInterface.TMXHttpResponseCode tMXHttpResponseCode, @Nullable InputStream inputStream) {
            if (!super.onComplete(tMXHttpResponseCode, inputStream)) {
                yyyyqy.btt0074tt0074(jjkjkj.b0073sss0073s, "profiling will be incomplete");
                this.b006Ajjj006Aj.countDown();
                return false;
            }
            yyyyqy.bt0074007400740074t(jjkjkj.b0073sss0073s, "profile request complete");
            long unused = jjkjkj.this.b00730073s00730073s = System.currentTimeMillis();
            this.b006Ajjj006Aj.countDown();
            return true;
        }
    }

    public private final class kkjjjk extends Thread {
        @Nonnull
        public final Runnable m_runnable;

        public kkjjjk(Runnable runnable) {
            this.m_runnable = runnable;
        }

        public void run() {
            this.m_runnable.run();
        }
    }

    public static class kkkjjk extends Exception {
        public final TMXStatusCode b006Aj006Ajj006A;

        public kkkjjk(TMXStatusCode tMXStatusCode) {
            this.b006Aj006Ajj006A = tMXStatusCode;
        }
    }

    public private final class kkkkkj implements Runnable {
        public final TMXEndNotifier b006Ajj006A006Aj;
        public final TMXProfilingHandle.Result bjjj006A006Aj;

        public kkkkkj(TMXProfilingHandle.Result result, TMXEndNotifier tMXEndNotifier) {
            this.bjjj006A006Aj = result;
            this.b006Ajj006A006Aj = tMXEndNotifier;
        }

        public void run() {
            TMXEndNotifier tMXEndNotifier = this.b006Ajj006A006Aj;
            if (tMXEndNotifier != null) {
                try {
                    tMXEndNotifier.complete(this.bjjj006A006Aj);
                } catch (Throwable th) {
                    String b0073ss0073ss0073 = jjkjkj.b0073sss0073s;
                    yyyyqy.bt0074t00740074t(b0073ss0073ss0073, "Unexpected exception occurred when calling EndNotifier " + th.toString());
                }
            }
        }
    }

    static {
        String property = System.getProperty("java.vm.version");
        boolean z = property != null && property.equals("2.0.0");
        bs0073ss0073s = z;
        if (z) {
            yyyyqy.bt0074007400740074t(b0073sss0073s, "Broken join() detected, activating fallback routine");
        }
    }

    public jjkjkj(@Nullable jjjkjk jjjkjk2, @Nullable jjjjjk jjjjjk2, @Nullable kjjjjk kjjjjk2) {
        this.bs00730073s0073s = jjjkjk2;
        this.b0073s0073s0073s = jjjjjk2;
        this.bss0073s0073s = kjjjjk2;
    }

    private boolean b00730073007300730073s0073() {
        return (this.b00730073s00730073s == 0 || this.bss007300730073s == 0 || this.b00730073s00730073s + TimeUnit.MILLISECONDS.convert((long) this.bss007300730073s, TimeUnit.MINUTES) <= System.currentTimeMillis()) ? false : true;
    }

    private TMXProfilingHandle b007300730073s0073s0073(TMXProfilingHandle.Result result, @Nullable TMXEndNotifier tMXEndNotifier, @Nonnull TMXProfilingHandle tMXProfilingHandle) {
        if (tMXEndNotifier != null) {
            Executors.newSingleThreadExecutor().execute(new kkkkkj(result, tMXEndNotifier));
        }
        return tMXProfilingHandle;
    }

    private boolean b007300730073ss00730073(@Nonnull yqqqqq yqqqqq) throws InterruptedException {
        StringBuilder sb;
        kjjjjj kjjjjj = this.bs0073s00730073s;
        tqtqqt tqtqqt = this.bss0073ss0073;
        String str = this.b007300730073s0073s;
        if (kjjjjj != null) {
            if (!kjjjjj.bhhhhh0068(yqqqqq.bmmmmm006D, yqqqqq.b006Dmmmm006D, "6.3-80", yqqqqq.bm006Dmmm006D)) {
                return false;
            }
        }
        kkkkjj kkkkjj = new kkkkjj();
        String str2 = b0073sss0073s;
        if (kjjjjj != null) {
            sb.append("dynamic enableOptions / disableOptions (");
            sb.append(yqqqqq.bmmmmm006D);
            sb.append(" / ");
            sb.append(yqqqqq.b006Dmmmm006D);
            sb.append(") != saved: m_default values enableOptions / disableOptions / sdk_version / quietPeriod (");
            sb.append(kjjjjj.b0068hh00680068h());
            sb.append(" / ");
            sb.append(kjjjjj.bhhh00680068h());
            sb.append(" / ");
            sb.append(kjjjjj.b00680068h00680068h());
            sb.append(" / ");
            sb.append(kjjjjj.bh0068h00680068h());
            sb.append(")");
            yyyyqy.qyyyqy.bt0074tttt(str2, sb.toString());
        } else {
            sb = new StringBuilder();
            sb.append("dynamic enableOptions / disableOptions (");
            sb.append(yqqqqq.bmmmmm006D);
            sb.append(" / ");
            sb.append(yqqqqq.b006Dmmmm006D);
            sb.append(") != saved: m_default is null");
            yyyyqy.qyyyqy.bt0074tttt(str2, sb.toString());
            kjjjjj = new kjjjjj();
            this.bs0073s00730073s = kjjjjj;
        }
        kjjjjj.b0068h006800680068h(yqqqqq.bmmmmm006D);
        kjjjjj.bhh006800680068h(yqqqqq.b006Dmmmm006D);
        kjjjjj.b00680068006800680068h("6.3-80");
        kjjjjj.bh0068006800680068h(yqqqqq.bm006Dmmm006D);
        if (qqqyqy.bg00670067g0067g().b00670067ggg0067()) {
            String str3 = str;
            qqqyqy.bg00670067g0067g().b0067gg0067g0067(this.bss0073ss0073, str3, kjjjjj.b006D006Dm006D006D006D, yqqqqq.bmmmmm006D);
            qqqyqy.bg00670067g0067g().b0067gg0067g0067(this.bss0073ss0073, str3, kjjjjj.bmm006D006D006D006D, yqqqqq.b006Dmmmm006D);
            qqqyqy.bg00670067g0067g().bg0067g0067g0067(this.bss0073ss0073, str, "sdkVersion", "6.3-80");
            qqqyqy.bg00670067g0067g().bggg0067g0067(this.bss0073ss0073, str, kjjjjj.b006Dm006D006D006D006D, yqqqqq.bm006Dmmm006D);
        } else if (!(tqtqqt == null || str == null)) {
            qyqyqq.b0069ii00690069i(tqtqqt, str, kjjjjj);
        }
        kkkkjj.b0073s0073s00730073s("Processed stored options", "pso");
        return true;
    }

    /* access modifiers changed from: private */
    public void b00730073s00730073s0073(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nonnull String str4, @Nonnull String str5, @Nonnull TMXStrongAuth.AuthMethod authMethod, boolean z, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, @Nullable TMXEndNotifier tMXEndNotifier, boolean z2) {
        TMXStatusCode tMXStatusCode;
        TMXStrongAuth.AuthParamResult authParamResult;
        String str6;
        yqqqqq yqqqqq;
        String str7 = str;
        TMXEndNotifier tMXEndNotifier2 = tMXEndNotifier;
        try {
            if (!this.b00730073sss0073.b0078x0078xx0078()) {
                yyyyqy.bt0074007400740074t(b0073sss0073s, "StrongAuth Failed: init() is not called");
                bsss00730073s0073(str7, TMXStatusCode.TMX_Internal_Error, tMXEndNotifier2);
                return;
            } else if (!this.b00730073sss0073.bx007800780078x0078(this.bs00730073ss0073)) {
                yyyyqy.bt0074007400740074t(b0073sss0073s, "StrongAuth Failed: Timeout while waiting for init to finish");
                bsss00730073s0073(str7, TMXStatusCode.TMX_Internal_Error, tMXEndNotifier2);
                return;
            } else {
                qqqtqq btt0074007400740074 = b00730073ss0073s.btt0074007400740074();
                if ((this.bsss0073s0073.get() & 2097152) != 0) {
                    if (btt0074007400740074 != null) {
                        tqtqqt tqtqqt = this.bss0073ss0073;
                        if (tqtqqt == null) {
                            bsss00730073s0073(str7, TMXStatusCode.TMX_Internal_Error, tMXEndNotifier2);
                            return;
                        }
                        new kkjjjk(new jkjjjk(true)).start();
                        yqqqqq bs0073007300730073s0073 = bs0073007300730073s0073(str);
                        String str8 = bs0073007300730073s0073.b006Dm006Dm006D006D;
                        if (!bs0073007300730073s0073.b006D006D006D006D006Dm) {
                            yyyyqy.bt0074t00740074t(b0073sss0073s, "StrongAuth Failed: Authentication module is not enabled, please contact ThreatMetrix support.");
                            bsss00730073s0073(str7, TMXStatusCode.TMX_StrongAuth_Failed, tMXEndNotifier2);
                            return;
                        }
                        waitForInfoCollectionAndUpdateDefaultOptions(bs0073007300730073s0073);
                        String str9 = str3 == null ? "" : str3;
                        byte[] bi00690069ii0069 = yqqyqq.bi00690069ii0069(bs0073007300730073s0073.b006D006Dmm006D006D);
                        if (z2) {
                            authParamResult = btt0074007400740074.b0075uuuu0075(tqtqqt.bll006C006C006C006C, str9, str4, str5, bi00690069ii0069, strongAuthCallback);
                            str6 = str8;
                            yqqqqq = bs0073007300730073s0073;
                        } else {
                            boolean isAvailable = yyyqqq.isAvailable(tqtqqt.bll006C006C006C006C);
                            PrivateKey privateKey = isAvailable ? yyyqqq.bmm006D006Dmm : null;
                            long j = isAvailable ? yyyqqq.b006Dmm006Dmm : 0;
                            str6 = str8;
                            Context context = tqtqqt.bll006C006C006C006C;
                            yqqqqq = bs0073007300730073s0073;
                            authParamResult = btt0074007400740074.bu0075uuu0075(context, authMethod, str9, str4, str5, bi00690069ii0069, strongAuthCallback, isAvailable, privateKey, j);
                        }
                        qttttt qttttt = new qttttt();
                        if (yqqyqq.b0069ii0069i0069(str2)) {
                            qttttt.byyyy00790079("sarq", str2);
                        }
                        if (authParamResult == null) {
                            yyyyqy.bt0074007400740074t(b0073sss0073s, "StrongAuth Failed: ");
                            bsss00730073s0073(str7, TMXStatusCode.TMX_StrongAuth_Failed, tMXEndNotifier2);
                            return;
                        }
                        if (!z) {
                            qttttt.put("sa_st", authParamResult.b00640064006400640064d.b0064dddd0064);
                        } else if (authParamResult.b00640064006400640064d.bd0064ddd0064 != TMXStatusCode.TMX_OK) {
                            TMXStatusCode tMXStatusCode2 = authParamResult.b00640064006400640064d.bd0064ddd0064;
                            String str10 = b0073sss0073s;
                            yyyyqy.bt0074007400740074t(str10, "StrongAuth Failed: " + tMXStatusCode2);
                            bsss00730073s0073(str7, tMXStatusCode2, tMXEndNotifier2);
                            return;
                        }
                        if (authParamResult.bddddd0064 != null) {
                            qttttt.b0079yyy00790079(z2 ? "sa_pk" : "sa_sig", authParamResult.bddddd0064, Integer.valueOf(authParamResult.bddddd0064.length() + 1));
                            String str11 = b0073sss0073s;
                            yyyyqy.qyyyqy.bt0074tttt(str11, "Generated registration credential is:" + authParamResult.bddddd0064);
                        }
                        TMXStatusCode b00730073sss00730073 = b00730073sss00730073(str6, this.bs0073sss0073.bss0073007300730073s(yqqqqq, this.b0073ssss0073.bb0062b0062bb, str, (jkjjkj.GenericLocation) null, qttttt, b00730073ss0073s, false));
                        if (b00730073sss00730073 == TMXStatusCode.TMX_OK) {
                            b00730073sss00730073 = authParamResult.b00640064006400640064d.bd0064ddd0064;
                        }
                        yyyyqy.bt0074007400740074t(b0073sss0073s, "StrongAuth request complete");
                        bsss00730073s0073(str7, b00730073sss00730073, tMXEndNotifier2);
                        return;
                    }
                }
                yyyyqy.bt0074t00740074t(b0073sss0073s, "StrongAuth Failed: TMXAuthentication is disabled or module is not valid. Please make sure the correct version of TMXAuthentication module is included in the app.");
                bsss00730073s0073(str7, TMXStatusCode.TMX_StrongAuth_Failed, tMXEndNotifier2);
                return;
            }
        } catch (kkkjjk e) {
            tMXStatusCode = e.b006Aj006Ajj006A;
        } catch (InterruptedException e2) {
            yyyyqy.b00740074007400740074t(b0073sss0073s, "StrongAuth request interrupted: ", e2);
            tMXStatusCode = TMXStatusCode.TMX_StrongAuth_Cancelled;
        } catch (IllegalArgumentException unused) {
            tMXStatusCode = TMXStatusCode.TMX_StrongAuth_Unsupported;
        } catch (Throwable th) {
            bsss00730073s0073(str7, (TMXStatusCode) null, tMXEndNotifier2);
            throw th;
        }
        bsss00730073s0073(str7, tMXStatusCode, tMXEndNotifier2);
    }

    private TMXStatusCode b00730073sss00730073(String str, qttttt qttttt) throws InterruptedException, kkkjjk {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        yqqqyq yqqqyq = this.b0073ssss0073;
        String b0069006900690069ii = yqqqyq.b0069006900690069ii(yqqqyq.b0062bb0062bb, str, "clear.png");
        kjkkkj kjkkkj2 = new kjkkkj(b0069006900690069ii, countDownLatch);
        byte[] b0079yy007900790079 = qttttt.b0079yy007900790079();
        this.b0073s0073ss0073.httpRequest(TMXProfilingConnectionsInterface.HttpMethod.POST, b0069006900690069ii, yqqqyq.bii00690069ii(this.bs0073sss0073, (String) null, b0079yy007900790079 == null ? 0 : b0079yy007900790079.length), b0079yy007900790079, kjkkkj2);
        if (!countDownLatch.await((long) this.bs00730073ss0073, TimeUnit.MILLISECONDS)) {
            throw new kkkjjk(TMXStatusCode.TMX_NetworkTimeout_Error);
        } else if (kjkkkj2.bs00730073007300730073s() == TMXStatusCode.TMX_OK) {
            return TMXStatusCode.TMX_OK;
        } else {
            throw new kkkjjk(TMXStatusCode.TMX_PartialProfile);
        }
    }

    private qttttt b0073s007300730073s0073(@Nonnull String str, boolean z, @Nonnull TMXProfilingOptions tMXProfilingOptions, yqqqqq yqqqqq) throws InterruptedException, kkkjjk {
        yqqqqq yqqqqq2 = yqqqqq;
        kkkkjj kkkkjj = new kkkkjj();
        jjjkjk jjjkjk2 = this.bs00730073s0073s;
        if (!((this.bsss0073s0073.get() & qqqqqy.be0065ee00650065) == 0 || jjjkjk2 == null)) {
            jjjkjk2.attest(this.bss0073ss0073, yqqqqq2.bmm006Dm006D006D);
        }
        waitForInfoCollectionAndUpdateDefaultOptions(yqqqqq2);
        this.b00730073sss0073.b0078007800780078x0078(true, z ? Long.valueOf(((long) this.bs00730073ss0073) - qqyyyq.bxxxx00780078().bxx0078x00780078()) : null);
        kkkkjj.b0073s0073s00730073s("Scan packages finished", "spf");
        qttttt qttttt = new qttttt();
        if (tMXProfilingOptions.bs0073s0073s0073s() != null) {
            int i = 0;
            for (String by0079yy00790079 : tMXProfilingOptions.bs0073s0073s0073s()) {
                StringBuilder sb = new StringBuilder();
                sb.append("aca");
                int i2 = i + 1;
                sb.append(i);
                qttttt.by0079yy00790079(sb.toString(), by0079yy00790079, true);
                if (i2 >= 5) {
                    break;
                }
                i = i2;
            }
        }
        String result = jjjkjk2 == null ? null : this.bs00730073s0073s.getResult();
        String nonce = jjjkjk2 == null ? null : this.bs00730073s0073s.getNonce();
        if (yqqyqq.b0069ii0069i0069(result) && yqqyqq.b0069ii0069i0069(nonce)) {
            qttttt.b0079yyy00790079("snet", result, 5000);
            qttttt.byyyy00790079("snetn", nonce);
        }
        jjjjjk jjjjjk2 = this.b0073s0073s0073s;
        qttttt bss0073007300730073s = this.bs0073sss0073.bss0073007300730073s(yqqqqq, this.b0073ssss0073.bb0062b0062bb, str, jjjjjk2 == null ? null : jjjjjk2.getLocation(), qttttt, b00730073ss0073s, true);
        kkkkjj.b0073s0073s00730073s("Risk Body formed", "rbf");
        return bss0073007300730073s;
    }

    /* access modifiers changed from: private */
    public void b0073s0073ss00730073(long j, long j2) {
        this.bsss0073s0073.set(((~j) & this.bs0073sss0073.b0064d0064006400640064) | j2);
    }

    public static long b0073ss0073s00730073(long j, long j2, String str) {
        if (j >= 0 && (j2 == 0 || j <= j2)) {
            return j;
        }
        yyyyqy.btt007400740074t(b0073sss0073s, "Invalid value for {}, {}", str, String.valueOf(j));
        throw new IllegalArgumentException("Invalid value for {" + str + "}");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A[RETURN] */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.threatmetrix.TrustDefender.kjjjjj b0073ssss00730073() {
        /*
            r9 = this;
            com.threatmetrix.TrustDefender.tqtqqt r0 = r9.bss0073ss0073
            java.lang.String r1 = r9.b007300730073s0073s
            com.threatmetrix.TrustDefender.qqqyqy r2 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()
            boolean r2 = r2.b00670067ggg0067()
            r3 = 0
            if (r2 == 0) goto L_0x0060
            com.threatmetrix.TrustDefender.kjjjjj r2 = new com.threatmetrix.TrustDefender.kjjjjj
            r2.<init>()
            com.threatmetrix.TrustDefender.qqqyqy r4 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()     // Catch:{ NumberFormatException -> 0x0058 }
            java.lang.String r5 = "enableOptions"
            long r4 = r4.bggg00670067g(r0, r1, r5)     // Catch:{ NumberFormatException -> 0x0058 }
            r6 = -1
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0027
            r2.b0068h006800680068h(r4)     // Catch:{ NumberFormatException -> 0x0058 }
        L_0x0027:
            com.threatmetrix.TrustDefender.qqqyqy r4 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()     // Catch:{ NumberFormatException -> 0x0058 }
            java.lang.String r5 = "disableOptions"
            long r4 = r4.bggg00670067g(r0, r1, r5)     // Catch:{ NumberFormatException -> 0x0058 }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0038
            r2.bhh006800680068h(r4)     // Catch:{ NumberFormatException -> 0x0058 }
        L_0x0038:
            com.threatmetrix.TrustDefender.qqqyqy r4 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()     // Catch:{ NumberFormatException -> 0x0058 }
            java.lang.String r5 = "quietPeriod"
            int r4 = r4.b006700670067g0067g(r0, r1, r5)     // Catch:{ NumberFormatException -> 0x0058 }
            r5 = -1
            if (r4 == r5) goto L_0x0048
            r2.bh0068006800680068h(r4)     // Catch:{ NumberFormatException -> 0x0058 }
        L_0x0048:
            com.threatmetrix.TrustDefender.qqqyqy r4 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()     // Catch:{ NumberFormatException -> 0x0058 }
            java.lang.String r5 = "sdkVersion"
            java.lang.String r4 = r4.b0067g006700670067g(r0, r1, r5)     // Catch:{ NumberFormatException -> 0x0058 }
            if (r4 == 0) goto L_0x0060
            r2.b00680068006800680068h(r4)     // Catch:{ NumberFormatException -> 0x0058 }
            goto L_0x0061
        L_0x0058:
            r2 = move-exception
            java.lang.String r4 = b0073sss0073s
            java.lang.String r5 = "Options/QuietPeriod are not a number"
            com.threatmetrix.TrustDefender.yyyyqy.b00740074007400740074t(r4, r5, r2)
        L_0x0060:
            r2 = r3
        L_0x0061:
            java.lang.String r4 = "6.3-80"
            if (r2 == 0) goto L_0x006f
            java.lang.String r5 = r2.b00680068h00680068h()
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0077
        L_0x006f:
            if (r0 == 0) goto L_0x0077
            if (r1 == 0) goto L_0x0077
            com.threatmetrix.TrustDefender.kjjjjj r2 = com.threatmetrix.TrustDefender.qyqyqq.biii00690069i(r0, r1)
        L_0x0077:
            if (r2 == 0) goto L_0x0085
            java.lang.String r0 = r2.b00680068h00680068h()
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            return r2
        L_0x0085:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.jjkjkj.b0073ssss00730073():com.threatmetrix.TrustDefender.kjjjjj");
    }

    private yqqqqq bs0073007300730073s0073(@Nonnull String str) throws InterruptedException, kkkjjk {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        yqqqqq yqqqqq = new yqqqqq();
        byte[] b0079yy007900790079 = this.b0073ssss0073.b0069i00690069ii(str).b0079yy007900790079();
        Map<String, String> bii00690069ii = yqqqyq.bii00690069ii(this.bs0073sss0073, (String) null, b0079yy007900790079 == null ? 0 : b0079yy007900790079.length);
        jkkkkj jkkkkj2 = new jkkkkj(this.b0073ssss0073.bi006900690069ii(), countDownLatch, yqqqqq, this.b0073ssss0073.bb0062b0062bb, str);
        this.b0073s0073ss0073.httpRequest(TMXProfilingConnectionsInterface.HttpMethod.POST, this.b0073ssss0073.bi006900690069ii(), bii00690069ii, b0079yy007900790079, jkkkkj2);
        if (!countDownLatch.await((long) this.bs00730073ss0073, TimeUnit.MILLISECONDS)) {
            throw new kkkjjk(TMXStatusCode.TMX_NetworkTimeout_Error);
        } else if (jkkkkj2.bs00730073007300730073s() != TMXStatusCode.TMX_OK) {
            throw new kkkjjk(jkkkkj2.bs00730073007300730073s());
        } else if (yqqqqq.bh006800680068hh()) {
            return yqqqqq;
        } else {
            throw new kkkjjk(TMXStatusCode.TMX_ConfigurationError);
        }
    }

    private void bs00730073ss00730073(yqqqqq yqqqqq, String str) throws InterruptedException {
        HashMap hashMap = new HashMap(4);
        TMXProfilingConnectionsInterface tMXProfilingConnectionsInterface = this.b0073s0073ss0073;
        HashMap hashMap2 = new HashMap(3);
        hashMap2.put("org_id", this.b0073ssss0073.bb0062b0062bb);
        hashMap2.put("session_id", str);
        hashMap2.put("nonce", yqqqqq.b006D006Dmm006D006D);
        hashMap.put("connectionInstance", tMXProfilingConnectionsInterface);
        hashMap.put("requestFixedPayload", hashMap2);
        hashMap.put("requestHeader", yqqqyq.bii00690069ii(this.bs0073sss0073, (String) null, 0));
        yqqqyq yqqqyq = this.b0073ssss0073;
        hashMap.put("requestUrl", yqqqyq.b0069006900690069ii(yqqqyq.b0062bb0062bb, yqqqqq.b006Dm006Dm006D006D, "clear3.png"));
        b00730073ss0073s.b00670067g0067gg(yqqqqq, this.bsss0073s0073.get(), hashMap);
    }

    /* access modifiers changed from: private */
    public void bs0073s00730073s0073(@Nonnull String str, @Nonnull TMXProfilingOptions tMXProfilingOptions, @Nonnull TMXEndNotifier tMXEndNotifier, @Nonnull jkkjjk jkkjjk2) {
        TMXStatusCode tMXStatusCode;
        TMXProfilingHandle.Result result;
        boolean z;
        String str2 = str;
        TMXEndNotifier tMXEndNotifier2 = tMXEndNotifier;
        jkkjjk jkkjjk3 = jkkjjk2;
        TMXStatusCode tMXStatusCode2 = TMXStatusCode.TMX_NotYet;
        try {
            String str3 = b0073sss0073s;
            StringBuilder sb = new StringBuilder();
            sb.append("continuing profile request ");
            sb.append(this.b00730073sss0073.b0078x0078xx0078() ? "inited already" : " needs init");
            yyyyqy.bt0074007400740074t(str3, sb.toString());
            if (this.b00730073sss0073.bx0078xxx0078() || Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            } else if (!this.b00730073sss0073.b0078x0078xx0078()) {
                yyyyqy.bt0074007400740074t(b0073sss0073s, "Not inited");
                throw new IllegalArgumentException("Not inited");
            } else if (this.b00730073sss0073.bx007800780078x0078(this.bs00730073ss0073)) {
                boolean b007300730073007300730073s = this.b0073ss0073s0073.b0073s0073sss0073(this.bss0073ss0073.bll006C006C006C006C);
                String str4 = b0073sss0073s;
                yyyyqy.qyyyqy.bt0074tttt(str4, "Result of binding service " + b007300730073007300730073s);
                qqqtqt.b0079y0079y0079y();
                if (!this.b00730073sss0073.b00780078xxx0078() || this.b00730073007300730073s) {
                    yyyyqy.bt0074t00740074t(b0073sss0073s, "scanPackages(profile): aborted! not inited or disabled");
                    z = false;
                } else {
                    z = b00730073ss0073s.bg0067g0067gg(this.bss0073ss0073, this.b00730073sss0073, kjkjjk.PROFILE, 0, this.bsssss0073, (TMXScanEndNotifier) null);
                }
                kkjjjk kkjjjk2 = new kkjjjk(new jkjjjk(false));
                this.b0073ss00730073s = kkjjjk2;
                kkjjjk2.start();
                if (this.b00730073sss0073.bx0078xxx0078() || Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                yqqqqq bs0073007300730073s0073 = bs0073007300730073s0073(str);
                if (this.b00730073sss0073.bx0078xxx0078() || Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                bs00730073ss00730073(bs0073007300730073s0073, str2);
                String str5 = bs0073007300730073s0073.b006Dm006Dm006D006D;
                bs0073sss00730073(bs0073007300730073s0073, str2);
                qttttt b0073s007300730073s0073 = b0073s007300730073s0073(str2, z, tMXProfilingOptions, bs0073007300730073s0073);
                if (this.b00730073sss0073.bx0078xxx0078() || Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
                tMXStatusCode = b00730073sss00730073(str5, b0073s007300730073s0073);
                this.b0073ss0073s0073.bsss0073ss0073(this.bss0073ss0073.bll006C006C006C006C);
                kkkkjj.bs00730073s00730073s();
                if (this.b00730073sss0073.bx0078xxx0078()) {
                    tMXStatusCode = TMXStatusCode.TMX_Interrupted_Error;
                    Thread.interrupted();
                }
                this.b0073ss00730073s = null;
                result = new TMXProfilingHandle.Result(str2, tMXStatusCode);
                bss007300730073s0073(result, tMXEndNotifier2, jkkjjk3);
                qqyyyq.bxxxx00780078().b007800780078x00780078(str2, tMXStatusCode);
            } else {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            if (!this.b00730073sss0073.bx0078xxx0078()) {
                yyyyqy.b00740074007400740074t(b0073sss0073s, "profile request interrupted", e);
                TMXStatusCode tMXStatusCode3 = TMXStatusCode.TMX_Internal_Error;
            } else {
                yyyyqy.bt0074007400740074t(b0073sss0073s, "profile request interrupted due to cancel");
            }
            TMXStatusCode tMXStatusCode4 = TMXStatusCode.TMX_Interrupted_Error;
            this.b0073ss0073s0073.bsss0073ss0073(this.bss0073ss0073.bll006C006C006C006C);
            kkkkjj.bs00730073s00730073s();
            if (this.b00730073sss0073.bx0078xxx0078()) {
                tMXStatusCode4 = TMXStatusCode.TMX_Interrupted_Error;
                Thread.interrupted();
            }
            this.b0073ss00730073s = null;
            result = new TMXProfilingHandle.Result(str2, tMXStatusCode);
        } catch (kkkjjk e2) {
            TMXStatusCode tMXStatusCode5 = e2.b006Aj006Ajj006A;
            this.b0073ss0073s0073.bsss0073ss0073(this.bss0073ss0073.bll006C006C006C006C);
            kkkkjj.bs00730073s00730073s();
            if (this.b00730073sss0073.bx0078xxx0078()) {
                tMXStatusCode5 = TMXStatusCode.TMX_Interrupted_Error;
                Thread.interrupted();
            }
            this.b0073ss00730073s = null;
            result = new TMXProfilingHandle.Result(str2, tMXStatusCode);
        } catch (Throwable th) {
            this.b0073ss0073s0073.bsss0073ss0073(this.bss0073ss0073.bll006C006C006C006C);
            kkkkjj.bs00730073s00730073s();
            if (this.b00730073sss0073.bx0078xxx0078()) {
                tMXStatusCode2 = TMXStatusCode.TMX_Interrupted_Error;
                Thread.interrupted();
            }
            this.b0073ss00730073s = null;
            bss007300730073s0073(new TMXProfilingHandle.Result(str2, tMXStatusCode2), tMXEndNotifier2, jkkjjk3);
            qqyyyq.bxxxx00780078().b007800780078x00780078(str2, tMXStatusCode2);
            throw th;
        }
    }

    public static boolean bs0073s0073s00730073(@Nonnull Thread thread, boolean z, int i) {
        yyyyqy.bt0074007400740074t(b0073sss0073s, "wift");
        String str = b0073sss0073s;
        yyyyqy.qyyyqy.bt0074tttt(str, "waiting for thread to complete - " + thread.getId());
        int i2 = 100;
        if (bs0073ss0073s) {
            int i3 = i / 100;
            if (i3 >= 100) {
                i2 = i3;
            }
        } else {
            i2 = i;
        }
        int i4 = 0;
        boolean z2 = false;
        do {
            try {
                thread.join((long) i2);
            } catch (InterruptedException e) {
                if (z) {
                    yyyyqy.b00740074007400740074t(b0073sss0073s, "thread join", e);
                }
                z2 = true;
            }
            i4 += i2;
            if (!thread.isAlive() || i4 >= i) {
            }
        } while (!z2);
        if (!thread.isAlive()) {
            return true;
        }
        if (!z2) {
            Exception exc = new Exception();
            exc.setStackTrace(thread.getStackTrace());
            String str2 = b0073sss0073s;
            yyyyqy.b0074t0074tt0074(str2, "join() timeout expired, but thread is still alive (!). Stack trace of TID " + thread.getId(), exc);
        }
        return false;
    }

    private void bs0073sss00730073(@Nonnull final yqqqqq yqqqqq, final String str) {
        new Thread(new Runnable() {
            public void run() {
                if ((jjkjkj.this.bsss0073s0073.get() & 1024) != 0) {
                    kkkkjj kkkkjj = new kkkkjj();
                    if (!yqqqqq.b006Dmm006D006D006D.isEmpty()) {
                        for (String b00690069i0069ii : yqqqqq.b006Dmm006D006D006D) {
                            jjkjkj.this.b0073s0073ss0073.resolveHostByName(jjkjkj.this.b0073ssss0073.b00690069i0069ii(str, yqqqqq.b006D006Dmm006D006D, b00690069i0069ii));
                        }
                    }
                    kkkkjj.b0073s0073s00730073s("Started DNS request", "sdr");
                }
                if ((jjkjkj.this.bsss0073s0073.get() & 64) != 0) {
                    jjkjkj.this.b0073s0073ss0073.socketRequest(jjkjkj.this.b0073ssss0073.b0062bb0062bb, 8080, "<handle sig=FF44EE55 session_id=" + str + " org_id=" + jjkjkj.this.b0073ssss0073.bb0062b0062bb + " w=" + yqqqqq.bm006Dmm006D006D + " />");
                }
                if ((jjkjkj.this.bsss0073s0073.get() & qqqqqy.b0061aa0061aa) != 0 && yqqyqq.b0069ii0069i0069(yqqqqq.bm006D006Dm006D006D)) {
                    qttttt qttttt = new qttttt();
                    qttttt.byyyy00790079("org_id", jjkjkj.this.b0073ssss0073.bb0062b0062bb);
                    qttttt.byyyy00790079("session_id", str);
                    qttttt.byyyy00790079("nonce", yqqqqq.b006D006Dmm006D006D);
                    qttttt.byyyy00790079("i", "1");
                    byte[] b0079yy007900790079 = qttttt.b0079yy007900790079();
                    jjkjkj.this.b0073s0073ss0073.httpRequest(TMXProfilingConnectionsInterface.HttpMethod.POST, jjkjkj.this.b0073ssss0073.b0069006900690069ii(yqqqqq.bm006D006Dm006D006D, yqqqqq.b006Dm006Dm006D006D, "clear.png"), yqqqyq.bii00690069ii(jjkjkj.this.bs0073sss0073, (String) null, b0079yy007900790079 == null ? 0 : b0079yy007900790079.length), b0079yy007900790079, new TMXProfilingConnectionsInterface.TMXCallback() {
                        public boolean onComplete(TMXProfilingConnectionsInterface.TMXHttpResponseCode tMXHttpResponseCode, @Nullable InputStream inputStream) {
                            if (tMXHttpResponseCode.succeeded()) {
                                return true;
                            }
                            String b0073ss0073ss0073 = jjkjkj.b0073sss0073s;
                            yyyyqy.bt0074007400740074t(b0073ss0073ss0073, "secondary post request failed: " + tMXHttpResponseCode.toString());
                            return true;
                        }
                    });
                }
            }
        }).start();
    }

    private TMXProfilingHandle bss007300730073s0073(@Nonnull TMXProfilingHandle.Result result, TMXEndNotifier tMXEndNotifier, @Nonnull TMXProfilingHandle tMXProfilingHandle) {
        this.b00730073sss0073.b00780078007800780078x();
        return b007300730073s0073s0073(result, tMXEndNotifier, tMXProfilingHandle);
    }

    private String bss0073ss00730073(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nonnull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, @Nullable TMXEndNotifier tMXEndNotifier) {
        String str8;
        String str9;
        TMXEndNotifier tMXEndNotifier2 = tMXEndNotifier;
        if (yqqyqq.bi0069i0069i0069(str7) || yqqyqq.bi0069i0069i0069(str5) || yqqyqq.bi0069i0069i0069(str4) || yqqyqq.bi0069i0069i0069(str2) || yqqyqq.bi0069i0069i0069(str)) {
            str8 = b0073sss0073s;
            str9 = "Stepup Failed: Invalid parameter";
        } else {
            String str10 = yqqyqq.bi0069i0069i0069(str6) ? TMXStrongAuth.AuthMethod.TMX_USER_PRESENCE.name : str6;
            if (!TMXStrongAuth.b00640064d00640064d.equals(str7)) {
                str8 = b0073sss0073s;
                str9 = "Stepup Failed: auth_action is invalid, can't proceed";
            } else {
                final TMXStrongAuth.AuthMethod b0073s00730073s0073s = TMXStrongAuth.AuthMethod.b0073s00730073s0073s(str10);
                final String str11 = str;
                final String str12 = str2;
                final String str13 = str3;
                final String str14 = str4;
                final String str15 = str5;
                final TMXStrongAuth.StrongAuthCallback strongAuthCallback2 = strongAuthCallback;
                final TMXEndNotifier tMXEndNotifier3 = tMXEndNotifier;
                new Thread(new Runnable() {
                    public void run() {
                        jjkjkj.this.b00730073s00730073s0073(str11, str12, str13, str14, str15, b0073s00730073s0073s, false, strongAuthCallback2, tMXEndNotifier3, false);
                    }
                }).start();
                return str;
            }
        }
        yyyyqy.bt0074007400740074t(str8, str9);
        bsss00730073s0073((String) null, TMXStatusCode.TMX_StrongAuth_Failed, tMXEndNotifier2);
        return null;
    }

    /* access modifiers changed from: private */
    public TMXStatusCode bsss00730073s0073(final String str, final TMXStatusCode tMXStatusCode, @Nullable final TMXEndNotifier tMXEndNotifier) {
        if (tMXEndNotifier != null) {
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                public void run() {
                    try {
                        tMXEndNotifier.complete(new TMXProfilingHandle.Result(str, tMXStatusCode));
                    } catch (Throwable th) {
                        String b0073ss0073ss0073 = jjkjkj.b0073sss0073s;
                        yyyyqy.bt0074t00740074t(b0073ss0073ss0073, "Unexpected exception occurred when calling StepUpNotifier " + th.toString());
                    }
                }
            });
        }
        return tMXStatusCode;
    }

    public static int bsss0073s00730073(int i, int i2, String str) {
        return (int) b0073ss0073s00730073((long) i, (long) i2, str);
    }

    private boolean bsssss00730073() {
        tqtqqt tqtqqt = this.bss0073ss0073;
        boolean z = tqtqqt == null || yyqyyy.b007100710071q00710071(tqtqqt);
        return this.b00730073s00730073s == 0 ? z : z || this.b007300730073ss0073;
    }

    public abstract void b0073s0073ss0073s(@Nonnull TMXConfig tMXConfig) throws IllegalArgumentException, IllegalStateException;

    public synchronized void b0073ss00730073s0073() {
        yyyyqy.bt0074007400740074t(b0073sss0073s, "cancel()");
        if (this.b00730073sss0073.b0078x0078xx0078()) {
            b00730073ss0073s.b0074tt007400740074();
            if (this.b00730073sss0073.bx00780078xx0078()) {
                if (!this.b00730073sss0073.b0078xx0078x0078()) {
                    yyyyqy.btt0074tt0074(b0073sss0073s, "Cancel already happened");
                    return;
                }
                if (this.b00730073sss0073.bx00780078xx0078()) {
                    yyyyqy.bt0074007400740074t(b0073sss0073s, "cancelling any outstanding JNI calls");
                    qqqyqy.bg00670067g0067g().b0067g00670067gg();
                    TMXProfilingConnectionsInterface tMXProfilingConnectionsInterface = this.b0073s0073ss0073;
                    if (tMXProfilingConnectionsInterface != null) {
                        yyyyqy.bt0074007400740074t(b0073sss0073s, "cancelling active profiling request");
                        tMXProfilingConnectionsInterface.cancelProfiling();
                    }
                    Thread thread = this.bsss00730073s;
                    if (thread != null) {
                        String str = b0073sss0073s;
                        yyyyqy.bt0074007400740074t(str, "sending interrupt to profile thread TID: " + thread.getId());
                        thread.interrupt();
                    }
                    Thread thread2 = this.b0073ss00730073s;
                    if (thread2 != null) {
                        thread2.interrupt();
                    }
                    if (thread != null && thread.isAlive()) {
                        yyyyqy.bt0074007400740074t(b0073sss0073s, "waiting for profile thread to complete");
                        bs0073s0073s00730073(thread, false, this.bs00730073ss0073);
                    }
                    yyyyqy.bt0074007400740074t(b0073sss0073s, "Waiting for any outstanding JNI calls");
                    qqqyqy.bg00670067g0067g().bgggg00670067();
                }
                this.b00730073sss0073.bxx007800780078x();
            }
            if (this.b00730073sss0073.bx0078x0078x0078()) {
                yyyyqy.qyyyqy.b00740074t0074tt(b0073sss0073s, "Waiting for package scan");
                this.b00730073sss0073.b0078007800780078x0078(false, (Long) null);
            }
            this.b00730073sss0073.b0078x007800780078x();
            yyyyqy.bt0074007400740074t(b0073sss0073s, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED);
        }
    }

    public abstract void bss0073ss0073s(tqtqqt tqtqqt);

    public void deregisterUser(@Nonnull final String str, @Nullable final TMXEndNotifier tMXEndNotifier) {
        if (yqqyqq.bi0069i0069i0069(str)) {
            yyyyqy.bt0074007400740074t(b0073sss0073s, "De-registration Failed: Invalid parameter is passed to deregister method");
            bsss00730073s0073((String) null, TMXStatusCode.TMX_StrongAuth_Failed, tMXEndNotifier);
        }
        if (!this.b00730073sss0073.b0078x0078xx0078()) {
            yyyyqy.bt0074007400740074t(b0073sss0073s, "StrongAuth Failed: init() is not called");
            bsss00730073s0073((String) null, TMXStatusCode.TMX_StrongAuth_Failed, tMXEndNotifier);
            return;
        }
        new Thread(new Runnable() {
            public void run() {
                TMXStatusCode tMXStatusCode;
                TMXStatusCode tMXStatusCode2;
                try {
                    if (!jjkjkj.this.b00730073sss0073.bx007800780078x0078(jjkjkj.this.bs00730073ss0073)) {
                        yyyyqy.bt0074007400740074t(jjkjkj.b0073sss0073s, "StrongAuth Failed: Timeout while waiting for init to finish");
                        tMXStatusCode2 = TMXStatusCode.TMX_Internal_Error;
                    } else {
                        qqqtqq btt0074007400740074 = jjkjkj.b00730073ss0073s.btt0074007400740074();
                        if ((jjkjkj.this.bsss0073s0073.get() & 2097152) != 0) {
                            if (btt0074007400740074 != null) {
                                TMXStrongAuth.AuthParamResult b0075u007500750075u = btt0074007400740074.b0075u007500750075u(str);
                                if (b0075u007500750075u == null) {
                                    yyyyqy.bt0074007400740074t(jjkjkj.b0073sss0073s, "StrongAuth Failed");
                                    tMXStatusCode2 = TMXStatusCode.TMX_StrongAuth_Failed;
                                } else {
                                    tMXStatusCode = b0075u007500750075u.b00640064006400640064d.bd0064ddd0064;
                                    TMXStatusCode unused = jjkjkj.this.bsss00730073s0073((String) null, tMXStatusCode, tMXEndNotifier);
                                    return;
                                }
                            }
                        }
                        yyyyqy.bt0074t00740074t(jjkjkj.b0073sss0073s, "StrongAuth Failed: TMXAuthentication module is not valid. Please make sure the correct version of TMXAuthentication module is included in the app.");
                        tMXStatusCode2 = TMXStatusCode.TMX_StrongAuth_Failed;
                    }
                    TMXStatusCode unused2 = jjkjkj.this.bsss00730073s0073((String) null, tMXStatusCode2, tMXEndNotifier);
                } catch (IllegalArgumentException unused3) {
                    tMXStatusCode = TMXStatusCode.TMX_StrongAuth_Unsupported;
                } catch (Throwable th) {
                    TMXStatusCode unused4 = jjkjkj.this.bsss00730073s0073((String) null, (TMXStatusCode) null, tMXEndNotifier);
                    throw th;
                }
            }
        }).start();
    }

    public void init(@Nonnull TMXConfig tMXConfig) throws IllegalArgumentException, IllegalStateException {
        final tqtqqt b00730073ss0073ss = tMXConfig.b00730073ss0073ss();
        if (b00730073ss0073ss != null) {
            if (yyyyqy.b007400740074t0074t() && (tMXConfig.bss007300730073ss() & qqqqqy.be00650065e00650065) == 0) {
                yyyyqy.b00740074ttt0074(true);
            }
            if (!this.b00730073sss0073.b00780078x0078x0078()) {
                yyyyqy.bt0074007400740074t(b0073sss0073s, "Already init'd");
                return;
            }
            qqqtqt.b0079y0079y0079y();
            try {
                this.b00730073007300730073s = tMXConfig.bs00730073s0073ss();
                this.bsssss0073 = bsss0073s00730073(tMXConfig.bs0073007300730073ss(), 0, "package scan timeout");
                this.bs0073007300730073s = bsss0073s00730073(tMXConfig.b0073ss00730073ss(), 0, "init package scan timeout");
                b0073s0073ss0073s(tMXConfig);
                if (!yqqqyq.bi0069i0069ii(tMXConfig.b0073s007300730073ss())) {
                    this.b00730073sss0073.bx0078007800780078x(false);
                    throw new IllegalArgumentException("Failed to init: Invalid format for org id");
                } else if (!yqqqyq.biiii0069i(tMXConfig.b007300730073s0073ss())) {
                    this.b0073ssss0073 = new yqqqyq(tMXConfig.b007300730073s0073ss(), tMXConfig.b0073s007300730073ss(), tMXConfig.bs0073ss0073ss());
                    this.bs00730073ss0073 = bsss0073s00730073(tMXConfig.b00730073007300730073ss(), Integer.MAX_VALUE, "profileTimeout");
                    if (this.bs00730073ss0073 == 0) {
                        this.bs00730073ss0073 = TMXConfig.boooo006F006F;
                    }
                    this.b0073s0073ss0073 = tMXConfig.bsssss0073s();
                    if (this.b0073s0073ss0073 == null) {
                        yyyyqy.qyyyqy.b00740074t0074tt(b0073sss0073s, "No profilingConnections instance being passed in by setProfilingConnections, try initialising one if connection module is available.");
                        this.b0073s0073ss0073 = yyqyqy.b0067gg0067gg();
                        if (this.b0073s0073ss0073 == null) {
                            this.b00730073sss0073.bx0078007800780078x(false);
                            yyyyqy.bt0074t00740074t(b0073sss0073s, "Failed to instantiate http client");
                            throw new IllegalStateException("Failed to init: failed to instantiate http client");
                        }
                    }
                    yyyyqy.bt0074007400740074t(b0073sss0073s, "Starting init()");
                    this.b007300730073ss0073 = true;
                    final jjjjjk jjjjjk2 = this.b0073s0073s0073s;
                    if (jjjjjk2 != null) {
                        jjjjjk2.pause();
                    }
                    this.bss0073ss0073 = b00730073ss0073ss;
                    String b0079y00790079yy = b00730073ss0073ss.b0079y00790079yy();
                    this.b007300730073s0073s = b0079y00790079yy + "TDM" + tMXConfig.b0073s007300730073ss();
                    this.bsss0073s0073.set(tMXConfig.bss007300730073ss());
                    final long b0067ggggg = b00730073ss0073s.b0067ggggg();
                    final TMXConfig tMXConfig2 = tMXConfig;
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                yyyyqy.bt0074007400740074t(jjkjkj.b0073sss0073s, "Doing slow init stuff");
                                if (jjjjjk2 != null) {
                                    jjjjjk2.config(tMXConfig2);
                                }
                                qqqyqy.bg00670067g0067g().b0067gggg0067(b00730073ss0073ss, BuildConfig.JNI_FILENAME, yyyyqy.bttt00740074t(), yyyyqy.b007400740074t0074t());
                                String b0073ss0073ss0073 = jjkjkj.b0073sss0073s;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Native libs: ");
                                sb.append(qqqyqy.bg00670067g0067g().b00670067ggg0067() ? "available" : "unavailable");
                                yyyyqy.btt0074tt0074(b0073ss0073ss0073, sb.toString());
                                jjkjkj.this.bs0073sss0073 = new jkjjkj(tMXConfig2.b00730073ss0073ss(), tMXConfig2.bss007300730073ss(), jjkjkj.this.bsss0073s0073, b0067ggggg);
                                kjjjjj bs0073ss0073s0073 = jjkjkj.this.b0073ssss00730073();
                                if (bs0073ss0073s0073 != null) {
                                    String b0073ss0073ss00732 = jjkjkj.b0073sss0073s;
                                    yyyyqy.qyyyqy.bt0074tttt(b0073ss0073ss00732, "applying saved options (" + bs0073ss0073s0073.b0068hh00680068h() + " / " + bs0073ss0073s0073.bhhh00680068h() + ") to " + jjkjkj.this.bsss0073s0073.get());
                                    jjkjkj.this.b0073s0073ss00730073(bs0073ss0073s0073.bhhh00680068h(), bs0073ss0073s0073.b0068hh00680068h());
                                    yyyyqy.qyyyqy.b00740074tttt(jjkjkj.b0073sss0073s, "Got quiet period from saved preferences {}", Integer.valueOf(bs0073ss0073s0073.bh0068h00680068h()));
                                    kjjjjj unused = jjkjkj.this.bs0073s00730073s = bs0073ss0073s0073;
                                    int unused2 = jjkjkj.this.bss007300730073s = bs0073ss0073s0073.bh0068h00680068h();
                                }
                                if ((jjkjkj.this.bsss0073s0073.get() & 1048576) == 0) {
                                    jjkjkj.this.bss0073ss0073s(b00730073ss0073ss);
                                }
                                kjjjjk bs007300730073ss0073 = jjkjkj.this.bss0073s0073s;
                                if (!((jjkjkj.this.bsss0073s0073.get() & 131072) == 0 || bs007300730073ss0073 == null)) {
                                    boolean unused3 = jjkjkj.this.b0073s007300730073s = bs007300730073ss0073.bindToGooglePlayService(b00730073ss0073ss);
                                }
                                yqqyqq.b0069i00690069i0069((String) null);
                                if (!tMXConfig2.bss0073s0073ss()) {
                                    jjkjkj.b00730073ss0073s.bg0067g0067gg(tMXConfig2.b00730073ss0073ss(), jjkjkj.this.b00730073sss0073, kjkjjk.INIT, 0, jjkjkj.this.bs0073007300730073s, (TMXScanEndNotifier) null);
                                }
                                jjkjkj.this.b00730073sss0073.bx0078007800780078x(true);
                                yyyyqy.bt0074007400740074t(jjkjkj.b0073sss0073s, "init completed successfully");
                            } catch (Throwable th) {
                                jjkjkj.this.b00730073sss0073.bx0078007800780078x(false);
                                String b0073ss0073ss00733 = jjkjkj.b0073sss0073s;
                                yyyyqy.bt0074007400740074t(b0073ss0073ss00733, "Exception in init" + th.toString());
                            }
                        }
                    }).start();
                } else {
                    this.b00730073sss0073.bx0078007800780078x(false);
                    throw new IllegalArgumentException("Failed to init: Invalid format for fingerprint server");
                }
            } catch (RuntimeException e) {
                this.b00730073sss0073.bx0078007800780078x(false);
                throw e;
            }
        } else {
            throw new IllegalArgumentException("Failed to init: Invalid Context");
        }
    }

    public void pauseLocationServices(boolean z) {
        jjjjjk jjjjjk2 = this.b0073s0073s0073s;
        if (jjjjjk2 != null) {
            if (z) {
                jjjjjk2.pause();
            } else {
                jjjjjk2.resume();
            }
        }
    }

    @Nullable
    public String processStrongAuthMessage(@Nonnull TMXStrongAuth.StrongAuthConfiguration strongAuthConfiguration, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, @Nullable TMXEndNotifier tMXEndNotifier) {
        String bi006900690069i0069 = yqqyqq.bi006900690069i0069();
        String str = strongAuthConfiguration.bd0064d0064d0064;
        String str2 = strongAuthConfiguration.b0064dd0064d0064;
        return bss0073ss00730073(bi006900690069i0069, str, strongAuthConfiguration.b0064d00640064d0064, strongAuthConfiguration.bdd00640064d0064, strongAuthConfiguration.b00640064d0064d0064, strongAuthConfiguration.bd006400640064d0064, str2, strongAuthCallback, tMXEndNotifier);
    }

    @Nullable
    public String processStrongAuthMessage(@Nonnull Object obj, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, @Nullable TMXEndNotifier tMXEndNotifier) {
        String str;
        String str2;
        Object obj2 = obj;
        TMXEndNotifier tMXEndNotifier2 = tMXEndNotifier;
        if (obj2 instanceof Bundle) {
            Bundle bundle = (Bundle) obj2;
            TMXStrongAuth.StrongAuthConfiguration strongAuthConfiguration = new TMXStrongAuth.StrongAuthConfiguration();
            strongAuthConfiguration.setAuthMethod(bundle.getString(TMXStrongAuth.AUTH_METHOD));
            strongAuthConfiguration.setAuthAction(bundle.getString(TMXStrongAuth.AUTH_ACTION));
            strongAuthConfiguration.setAuthContext(bundle.getString(TMXStrongAuth.AUTH_CONTEXT));
            strongAuthConfiguration.setAuthRequestId(bundle.getString(TMXStrongAuth.AUTH_REQUEST_ID));
            strongAuthConfiguration.setAuthPrompt(bundle.getString(TMXStrongAuth.AUTH_PROMPT));
            strongAuthConfiguration.setAuthTitle(bundle.getString("title"));
            return processStrongAuthMessage(strongAuthConfiguration, strongAuthCallback, tMXEndNotifier2);
        }
        TMXStrongAuth.StrongAuthCallback strongAuthCallback2 = strongAuthCallback;
        Method b00730073ss007300730073 = kkjkjk.b00730073ss007300730073(obj.getClass(), "getData", new Class[0]);
        if (b00730073ss007300730073 == null) {
            str = b0073sss0073s;
            str2 = "Stepup Failed: Message parameter does not have \"getData\" method";
        } else {
            Object bs00730073s007300730073 = kkjkjk.bs00730073s007300730073(obj, b00730073ss007300730073, new Object[0]);
            if (!(bs00730073s007300730073 instanceof Map)) {
                str = b0073sss0073s;
                str2 = "Stepup Failed: \"getData\" returns wrong type";
            } else {
                Map map = (Map) bs00730073s007300730073;
                String bi006900690069i0069 = yqqyqq.bi006900690069i0069();
                String str3 = (String) map.get("title");
                return bss0073ss00730073(bi006900690069i0069, (String) map.get(TMXStrongAuth.AUTH_REQUEST_ID), str3, (String) map.get(TMXStrongAuth.AUTH_PROMPT), (String) map.get(TMXStrongAuth.AUTH_CONTEXT), (String) map.get(TMXStrongAuth.AUTH_METHOD), (String) map.get(TMXStrongAuth.AUTH_ACTION), strongAuthCallback, tMXEndNotifier);
            }
        }
        yyyyqy.bt0074007400740074t(str, str2);
        bsss00730073s0073((String) null, TMXStatusCode.TMX_StrongAuth_Failed, tMXEndNotifier2);
        return null;
    }

    public TMXProfilingHandle profile(@Nonnull TMXEndNotifier tMXEndNotifier) {
        return profile(new TMXProfilingOptions(), tMXEndNotifier);
    }

    public TMXProfilingHandle profile(@Nonnull TMXProfilingOptions tMXProfilingOptions, @Nonnull TMXEndNotifier tMXEndNotifier) {
        qqyyyq.bxxxx00780078().bxxx007800780078();
        if (!this.b00730073sss0073.b0078x0078xx0078()) {
            return b007300730073s0073s0073(new TMXProfilingHandle.Result((String) null, TMXStatusCode.TMX_Internal_Error), tMXEndNotifier, new jkkjjk((String) null));
        }
        if (!this.b00730073sss0073.bxx00780078x0078()) {
            return b007300730073s0073s0073(new TMXProfilingHandle.Result((String) null, TMXStatusCode.TMX_NotYet), tMXEndNotifier, new jkkjjk((String) null));
        }
        if ((this.bsss0073s0073.get() & 1048576) == 0 && !bsssss00730073()) {
            this.b00730073sss0073.b00780078007800780078x();
            return b007300730073s0073s0073(new TMXProfilingHandle.Result((String) null, TMXStatusCode.TMX_Blocked), tMXEndNotifier, new jkkjjk((String) null));
        } else if (b00730073007300730073s0073()) {
            this.b00730073sss0073.b00780078007800780078x();
            return b007300730073s0073s0073(new TMXProfilingHandle.Result((String) null, TMXStatusCode.TMX_In_Quiet_Period), tMXEndNotifier, new jkkjjk((String) null));
        } else if (tMXEndNotifier == null) {
            this.b00730073sss0073.b00780078007800780078x();
            return b007300730073s0073s0073(new TMXProfilingHandle.Result((String) null, TMXStatusCode.TMX_EndNotifier_NotFound), (TMXEndNotifier) null, new jkkjjk((String) null));
        } else {
            final String b0069006900690069i0069 = yqqyqq.b0069ii0069i0069(tMXProfilingOptions.bss00730073s0073s()) ? yqqyqq.b0069006900690069i0069(tMXProfilingOptions.bss00730073s0073s()) : yqqyqq.bi006900690069i0069();
            if (yqqyqq.bi0069i0069i0069(b0069006900690069i0069)) {
                this.b00730073sss0073.b00780078007800780078x();
                yyyyqy.bt0074t00740074t(b0073sss0073s, "Failed to start profiling: Invalid session id");
                return b007300730073s0073s0073(new TMXProfilingHandle.Result((String) null, TMXStatusCode.TMX_Internal_Error), tMXEndNotifier, new jkkjjk((String) null));
            }
            yyyyqy.bttt00740074t();
            String str = b0073sss0073s;
            yyyyqy.bt0074007400740074t(str, "starting profile request using - 6.3-80 options " + this.bsss0073s0073.get() + " profileTimeout " + this.bs00730073ss0073 + "ms java.vm.version " + System.getProperty("java.vm.version"));
            jkkjjk jkkjjk2 = new jkkjjk(b0069006900690069i0069);
            this.b0073s0073ss0073.cancelProfiling();
            jjjjjk jjjjjk2 = this.b0073s0073s0073s;
            if (jjjjjk2 != null) {
                jjjjjk2.setLocation(tMXProfilingOptions.b00730073s0073s0073s());
            }
            final TMXProfilingOptions tMXProfilingOptions2 = tMXProfilingOptions;
            final TMXEndNotifier tMXEndNotifier2 = tMXEndNotifier;
            final jkkjjk jkkjjk3 = jkkjjk2;
            this.bsss00730073s = new Thread(new Runnable() {
                public void run() {
                    jjkjkj.this.bs0073s00730073s0073(b0069006900690069i0069, tMXProfilingOptions2, tMXEndNotifier2, jkkjjk3);
                }
            });
            this.bsss00730073s.start();
            return jkkjjk2;
        }
    }

    public TMXProfilingHandle profile(@Nonnull String str, @Nonnull TMXEndNotifier tMXEndNotifier) {
        return profile(new TMXProfilingOptions().setSessionID(str), tMXEndNotifier);
    }

    @Nullable
    public String registerUser(@Nonnull String str, @Nullable String str2, @Nonnull String str3, @Nonnull TMXStrongAuth.StrongAuthCallback strongAuthCallback, @Nullable TMXEndNotifier tMXEndNotifier) {
        String bi006900690069i0069 = yqqyqq.bi006900690069i0069();
        if (yqqyqq.bi0069i0069i0069(str) || yqqyqq.bi0069i0069i0069(str3) || yqqyqq.bi0069i0069i0069(bi006900690069i0069)) {
            yyyyqy.bt0074007400740074t(b0073sss0073s, "Registration Failed: Invalid parameter is passed to register method");
            bsss00730073s0073((String) null, TMXStatusCode.TMX_StrongAuth_Failed, tMXEndNotifier);
            return null;
        }
        final String str4 = bi006900690069i0069;
        final String str5 = str2;
        final String str6 = str3;
        final String str7 = str;
        final TMXStrongAuth.StrongAuthCallback strongAuthCallback2 = strongAuthCallback;
        final TMXEndNotifier tMXEndNotifier2 = tMXEndNotifier;
        new Thread(new Runnable() {
            public void run() {
                jjkjkj.this.b00730073s00730073s0073(str4, (String) null, str5, str6, str7, TMXStrongAuth.AuthMethod.TMX_USER_PRESENCE, true, strongAuthCallback2, tMXEndNotifier2, true);
            }
        }).start();
        return bi006900690069i0069;
    }

    public boolean scanPackages() {
        return scanPackages(0, TimeUnit.SECONDS, (TMXScanEndNotifier) null);
    }

    public boolean scanPackages(int i, @Nonnull TimeUnit timeUnit, @Nullable TMXScanEndNotifier tMXScanEndNotifier) {
        int millis = (int) timeUnit.toMillis((long) i);
        int i2 = (millis != 0 || i == 0) ? millis : 1;
        if (this.b00730073sss0073.b00780078xxx0078()) {
            return b00730073ss0073s.bg0067g0067gg(this.bss0073ss0073, this.b00730073sss0073, kjkjjk.SCAN_PACKAGES, this.bsss0073s0073.get(), i2, tMXScanEndNotifier);
        }
        yyyyqy.bt0074t00740074t(b0073sss0073s, "scanPackages(scanPackages): aborted! init method is not called");
        return false;
    }

    public boolean scanPackages(TMXScanEndNotifier tMXScanEndNotifier) {
        return scanPackages(0, TimeUnit.SECONDS, tMXScanEndNotifier);
    }

    public void waitForInfoCollectionAndUpdateDefaultOptions(yqqqqq yqqqqq) throws InterruptedException, kkkjjk {
        kkjjjk kkjjjk2 = (kkjjjk) this.b0073ss00730073s;
        if (kkjjjk2 != null) {
            kkjjjk2.join((long) this.bs00730073ss0073);
            if (kkjjjk2.getState() != Thread.State.TERMINATED) {
                yyyyqy.bt0074t00740074t(b0073sss0073s, "ScanData hasn't completed before the timeout expired, aborting");
                kkjjjk2.interrupt();
                throw new kkkjjk(TMXStatusCode.TMX_ProfileTimeout_Error);
            } else if (((jkjjjk) kkjjjk2.m_runnable).b0073s0073007300730073s()) {
                throw new InterruptedException();
            }
        }
        if (b007300730073ss00730073(yqqqqq)) {
            b0073s0073ss00730073(yqqqqq.b006Dmmmm006D & qqqqqy.b00610061aa0061a, qqqqqy.b00610061aa0061a & yqqqqq.bmmmmm006D);
        }
        this.bss007300730073s = yqqqqq.bm006Dmmm006D;
        kkkkjj.b007300730073s00730073s(yqqqqq.b006D006Dmmm006D);
    }
}
