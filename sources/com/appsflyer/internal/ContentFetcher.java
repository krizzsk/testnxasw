package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import com.appsflyer.AndroidUtils;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ContentFetcher<T> {
    public final String authority;
    public final Context context;

    /* renamed from: ı */
    private final String f1872;

    /* renamed from: ǃ */
    private final long f1873;

    /* renamed from: ι */
    private FutureTask<T> f1874 = new FutureTask<>(new Callable<T>() {
        public final T call() {
            if (ContentFetcher.this.valid()) {
                return ContentFetcher.this.query();
            }
            return null;
        }
    });

    /* access modifiers changed from: protected */
    public abstract T query();

    public ContentFetcher(Context context2, String str, String str2, long j) {
        this.context = context2;
        this.authority = str;
        this.f1872 = str2;
        this.f1873 = j;
    }

    public void start() {
        new Thread(this.f1874).start();
    }

    public T get() {
        try {
            return this.f1874.get(this.f1873, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            onError(e);
            return null;
        }
    }

    public boolean valid() {
        try {
            ProviderInfo resolveContentProvider = this.context.getPackageManager().resolveContentProvider(this.authority, 128);
            if (resolveContentProvider == null || !AndroidUtils.signature(this.context.getPackageManager(), resolveContentProvider.packageName).equalsIgnoreCase(this.f1872)) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e) {
            onError(e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onError(Exception exc) {
        AFLogger.afErrorLog(getClass().getSimpleName(), exc);
    }
}
