package com.google.p224vr.dynamite.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.didi.sdk.apm.SystemUtils;
import dalvik.system.DexClassLoader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.vr.dynamite.client.DynamiteClient */
public final class DynamiteClient {

    /* renamed from: a */
    private static final ArrayMap<C20700e, C20699d> f56663a = new ArrayMap<>();

    private DynamiteClient() {
    }

    public static synchronized int checkVersion(Context context, String str, String str2, String str3) {
        C20700e eVar;
        synchronized (DynamiteClient.class) {
            C20701f fVar = null;
            if (str3 != null) {
                try {
                    if (!str3.isEmpty()) {
                        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)").matcher(str3);
                        if (!matcher.matches()) {
                            String valueOf = String.valueOf(str3);
                            SystemUtils.log(5, "Version", valueOf.length() != 0 ? "Failed to parse version from: ".concat(valueOf) : new String("Failed to parse version from: "), (Throwable) null, "com.google.vr.dynamite.client.DynamiteClient", 7);
                        } else {
                            fVar = new C20701f(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                        }
                    }
                } catch (RemoteException | C20698c | IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError e) {
                    Throwable th = e;
                    String valueOf2 = String.valueOf(eVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 54);
                    sb.append("Failed to load native library ");
                    sb.append(valueOf2);
                    sb.append(" from remote package:\n  ");
                    SystemUtils.log(6, "DynamiteClient", sb.toString(), th, "com.google.vr.dynamite.client.DynamiteClient", 25);
                    return -1;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (fVar == null) {
                String valueOf3 = String.valueOf(str3);
                throw new IllegalArgumentException(valueOf3.length() != 0 ? "Improperly formatted minVersion string: ".concat(valueOf3) : new String("Improperly formatted minVersion string: "));
            }
            eVar = new C20700e(str, str2);
            C20699d remoteLibraryLoaderFromInfo = getRemoteLibraryLoaderFromInfo(eVar);
            INativeLibraryLoader newNativeLibraryLoader = remoteLibraryLoaderFromInfo.mo170428a(context).newNativeLibraryLoader(ObjectWrapper.m42716a(remoteLibraryLoaderFromInfo.mo170429b(context)), ObjectWrapper.m42716a(context));
            if (newNativeLibraryLoader == null) {
                String valueOf4 = String.valueOf(eVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf4).length() + 72);
                sb2.append("Failed to load native library ");
                sb2.append(valueOf4);
                sb2.append(" from remote package: no loader available.");
                SystemUtils.log(6, "DynamiteClient", sb2.toString(), (Throwable) null, "com.google.vr.dynamite.client.DynamiteClient", 21);
                return -1;
            }
            int checkVersion = newNativeLibraryLoader.checkVersion(str3);
            return checkVersion;
        }
    }

    public static synchronized long loadNativeRemoteLibrary(Context context, String str, String str2) {
        synchronized (DynamiteClient.class) {
            C20700e eVar = new C20700e(str, str2);
            C20699d remoteLibraryLoaderFromInfo = getRemoteLibraryLoaderFromInfo(eVar);
            try {
                INativeLibraryLoader newNativeLibraryLoader = remoteLibraryLoaderFromInfo.mo170428a(context).newNativeLibraryLoader(ObjectWrapper.m42716a(remoteLibraryLoaderFromInfo.mo170429b(context)), ObjectWrapper.m42716a(context));
                if (newNativeLibraryLoader == null) {
                    String valueOf = String.valueOf(eVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 72);
                    sb.append("Failed to load native library ");
                    sb.append(valueOf);
                    sb.append(" from remote package: no loader available.");
                    SystemUtils.log(6, "DynamiteClient", sb.toString(), (Throwable) null, "com.google.vr.dynamite.client.DynamiteClient", 35);
                    return 0;
                }
                long initializeAndLoadNativeLibrary = newNativeLibraryLoader.initializeAndLoadNativeLibrary(str2);
                return initializeAndLoadNativeLibrary;
            } catch (RemoteException | C20698c | IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError e) {
                Throwable th = e;
                String valueOf2 = String.valueOf(eVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 54);
                sb2.append("Failed to load native library ");
                sb2.append(valueOf2);
                sb2.append(" from remote package:\n  ");
                SystemUtils.log(6, "DynamiteClient", sb2.toString(), th, "com.google.vr.dynamite.client.DynamiteClient", 39);
                return 0;
            }
        }
    }

    public static synchronized ClassLoader getRemoteClassLoader(Context context, String str, String str2) {
        synchronized (DynamiteClient.class) {
            Context remoteContext = getRemoteContext(context, str, str2);
            if (remoteContext == null) {
                return null;
            }
            ClassLoader classLoader = remoteContext.getClassLoader();
            return classLoader;
        }
    }

    public static synchronized ClassLoader getRemoteDexClassLoader(Context context, String str) {
        synchronized (DynamiteClient.class) {
            Context remoteContext = getRemoteContext(context, str, (String) null);
            if (remoteContext == null) {
                return null;
            }
            try {
                DexClassLoader dexClassLoader = new DexClassLoader(remoteContext.getPackageCodePath(), context.getCodeCacheDir().getAbsolutePath(), remoteContext.getApplicationInfo().nativeLibraryDir, context.getClassLoader());
                return dexClassLoader;
            } catch (RuntimeException e) {
                SystemUtils.log(6, "DynamiteClient", "Failed to create class loader for remote package\n ", e, "com.google.vr.dynamite.client.DynamiteClient", 56);
                return null;
            }
        }
    }

    public static synchronized Context getRemoteContext(Context context, String str, String str2) {
        Context b;
        synchronized (DynamiteClient.class) {
            C20700e eVar = new C20700e(str, str2);
            try {
                b = getRemoteLibraryLoaderFromInfo(eVar).mo170429b(context);
            } catch (C20698c e) {
                String valueOf = String.valueOf(eVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 52);
                sb.append("Failed to get remote Context");
                sb.append(valueOf);
                sb.append(" from remote package:\n  ");
                SystemUtils.log(6, "DynamiteClient", sb.toString(), e, "com.google.vr.dynamite.client.DynamiteClient", 62);
                return null;
            }
        }
        return b;
    }

    private static synchronized C20699d getRemoteLibraryLoaderFromInfo(C20700e eVar) {
        C20699d dVar;
        synchronized (DynamiteClient.class) {
            dVar = f56663a.get(eVar);
            if (dVar == null) {
                dVar = new C20699d(eVar);
                f56663a.put(eVar, dVar);
            }
        }
        return dVar;
    }
}
