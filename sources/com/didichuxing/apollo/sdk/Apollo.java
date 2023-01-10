package com.didichuxing.apollo.sdk;

import android.content.Context;
import com.didichuxing.apollo.sdk.dataprovider.IDataProvider;
import com.didichuxing.apollo.sdk.log.ILogDelegate;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.apollo.sdk.net.HttpRequest;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.util.HashMap;
import org.json.JSONObject;

public class Apollo {

    /* renamed from: a */
    private static C15867a f48232a = new ApolloImpl();

    public static synchronized void setContext(Context context) {
        synchronized (Apollo.class) {
            ((ApolloImpl) f48232a).setContext(context);
            WsgSecInfo.init(context);
        }
    }

    public static void init(Context context) {
        setContext(context);
    }

    public static IToggle getToggle(String str) {
        return f48232a.getToggle(str);
    }

    public static IToggle getToggle(String str, boolean z) {
        return f48232a.getToggle(str, z);
    }

    public static String getTestKey(String str) {
        return f48232a.getTestKey(str);
    }

    public static void setLogDelegate(ILogDelegate iLogDelegate) {
        f48232a.setLogDelegate(iLogDelegate);
    }

    public static void setUserInfoDelegate(IUserInfoDelegate iUserInfoDelegate) {
        f48232a.setUserInfoDelegate(iUserInfoDelegate);
    }

    public static void setAppInfoDelegate(IAppInfoDelegate iAppInfoDelegate) {
        f48232a.setAppInfoDelegate(iAppInfoDelegate);
    }

    public static void checkUpdate() {
        f48232a.checkUpdate();
    }

    public static void clearData() {
        f48232a.clearData();
    }

    public static void setDataProvider(IDataProvider iDataProvider) {
        f48232a.setDataProvider(iDataProvider);
    }

    public static void setRequestHandler(RequestHandler requestHandler) {
        f48232a.setRequestHandler(requestHandler);
    }

    public static void setNamespace(String str) {
        f48232a.setNamespace(str);
    }

    public static String getNamespace() {
        return f48232a.getNamespace();
    }

    public static void enableLooper(boolean z) {
        f48232a.enableLooper(z);
    }

    public static void enableLooper(boolean z, long j) {
        f48232a.enableLooper(z, j);
    }

    public static void startup() {
        f48232a.startup();
    }

    public static void startup(boolean z) {
        f48232a.startup(z, (IStartupCallback) null);
    }

    public static void startup(boolean z, IStartupCallback iStartupCallback) {
        f48232a.startup(z, iStartupCallback);
    }

    public static void shutdown() {
        f48232a.shutdown();
    }

    public static boolean isStared() {
        return f48232a.isStarted();
    }

    public static void setDebug(boolean z) {
        LogUtils.DEBUG = z;
    }

    public static void setServerHost(String str) {
        HttpRequest.setHost(str);
    }

    public static String getServerHost() {
        return HttpRequest.getHost();
    }

    public static void setServerPath(String str) {
        HttpRequest.setPath(str);
    }

    public static void enableUpdate(boolean z) {
        HttpRequest.setEnable(z);
    }

    public static JSONObject getJsonToggle(String str) {
        IToggle toggle = f48232a.getToggle(str);
        if (toggle != null) {
            return toggle.toJsonObject();
        }
        return new JSONObject();
    }

    public static void addCacheLoadedListener(OnCacheLoadedListener onCacheLoadedListener) {
        f48232a.addCacheLoadedListener(onCacheLoadedListener);
    }

    public static void removeCacheLoadedListener(OnCacheLoadedListener onCacheLoadedListener) {
        f48232a.removeCacheLoadedListener(onCacheLoadedListener);
    }

    public static void addToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener) {
        f48232a.addToggleStateChangeListener(onToggleStateChangeListener);
    }

    public static void removeToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener) {
        f48232a.removeToggleStateChangeListener(onToggleStateChangeListener);
    }

    public static IToggle getSyncToggle(String str, HashMap<String, String> hashMap) {
        return f48232a.getSyncToggle(str, hashMap);
    }

    public static IToggle getSyncToggle(String str, HashMap<String, String> hashMap, int i, int i2) {
        return f48232a.getSyncToggle(str, hashMap, i, i2);
    }

    public static void getAsyncToggle(String str, HashMap<String, String> hashMap, int i, int i2, IAsyncToggleCallback iAsyncToggleCallback) {
        f48232a.getAsyncToggle(str, hashMap, i, i2, iAsyncToggleCallback);
    }

    public static void resetCoolDownLogger() {
        f48232a.resetCoolDownLogger();
    }
}
