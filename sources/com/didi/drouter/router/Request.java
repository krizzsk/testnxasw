package com.didi.drouter.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.lifecycle.LifecycleOwner;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.InterceptorHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Request extends C8529a<Request> {

    /* renamed from: i */
    private static final AtomicInteger f21049i = new AtomicInteger(0);

    /* renamed from: a */
    Context f21050a;

    /* renamed from: b */
    LifecycleOwner f21051b;

    /* renamed from: c */
    String f21052c;

    /* renamed from: d */
    int f21053d;

    /* renamed from: e */
    int f21054e;

    /* renamed from: f */
    long f21055f;

    /* renamed from: g */
    String f21056g = String.valueOf(f21049i.getAndIncrement());

    /* renamed from: h */
    IInterceptor f21057h;

    /* renamed from: j */
    private Uri f21058j;

    public /* bridge */ /* synthetic */ Object getAddition(String str) {
        return super.getAddition(str);
    }

    public /* bridge */ /* synthetic */ Map getAddition() {
        return super.getAddition();
    }

    public /* bridge */ /* synthetic */ boolean getBoolean(String str) {
        return super.getBoolean(str);
    }

    public /* bridge */ /* synthetic */ boolean[] getBooleanArray(String str) {
        return super.getBooleanArray(str);
    }

    public /* bridge */ /* synthetic */ Bundle getBundle(String str) {
        return super.getBundle(str);
    }

    public /* bridge */ /* synthetic */ Byte getByte(String str) {
        return super.getByte(str);
    }

    public /* bridge */ /* synthetic */ byte[] getByteArray(String str) {
        return super.getByteArray(str);
    }

    public /* bridge */ /* synthetic */ char getChar(String str) {
        return super.getChar(str);
    }

    public /* bridge */ /* synthetic */ char[] getCharArray(String str) {
        return super.getCharArray(str);
    }

    public /* bridge */ /* synthetic */ CharSequence getCharSequence(String str) {
        return super.getCharSequence(str);
    }

    public /* bridge */ /* synthetic */ CharSequence[] getCharSequenceArray(String str) {
        return super.getCharSequenceArray(str);
    }

    public /* bridge */ /* synthetic */ ArrayList getCharSequenceArrayList(String str) {
        return super.getCharSequenceArrayList(str);
    }

    public /* bridge */ /* synthetic */ double getDouble(String str) {
        return super.getDouble(str);
    }

    public /* bridge */ /* synthetic */ double[] getDoubleArray(String str) {
        return super.getDoubleArray(str);
    }

    public /* bridge */ /* synthetic */ Bundle getExtra() {
        return super.getExtra();
    }

    public /* bridge */ /* synthetic */ float getFloat(String str) {
        return super.getFloat(str);
    }

    public /* bridge */ /* synthetic */ float[] getFloatArray(String str) {
        return super.getFloatArray(str);
    }

    public /* bridge */ /* synthetic */ int getInt(String str) {
        return super.getInt(str);
    }

    public /* bridge */ /* synthetic */ int[] getIntArray(String str) {
        return super.getIntArray(str);
    }

    public /* bridge */ /* synthetic */ ArrayList getIntegerArrayList(String str) {
        return super.getIntegerArrayList(str);
    }

    public /* bridge */ /* synthetic */ long getLong(String str) {
        return super.getLong(str);
    }

    public /* bridge */ /* synthetic */ long[] getLongArray(String str) {
        return super.getLongArray(str);
    }

    public /* bridge */ /* synthetic */ Parcelable getParcelable(String str) {
        return super.getParcelable(str);
    }

    public /* bridge */ /* synthetic */ Parcelable[] getParcelableArray(String str) {
        return super.getParcelableArray(str);
    }

    public /* bridge */ /* synthetic */ ArrayList getParcelableArrayList(String str) {
        return super.getParcelableArrayList(str);
    }

    public /* bridge */ /* synthetic */ Serializable getSerializable(String str) {
        return super.getSerializable(str);
    }

    public /* bridge */ /* synthetic */ short getShort(String str) {
        return super.getShort(str);
    }

    public /* bridge */ /* synthetic */ short[] getShortArray(String str) {
        return super.getShortArray(str);
    }

    public /* bridge */ /* synthetic */ SparseArray getSparseParcelableArray(String str) {
        return super.getSparseParcelableArray(str);
    }

    public /* bridge */ /* synthetic */ String getString(String str) {
        return super.getString(str);
    }

    public /* bridge */ /* synthetic */ String[] getStringArray(String str) {
        return super.getStringArray(str);
    }

    public /* bridge */ /* synthetic */ ArrayList getStringArrayList(String str) {
        return super.getStringArrayList(str);
    }

    private Request(Uri uri) {
        this.f21058j = uri;
        putExtra(Extend.REQUEST_BUILD_URI, uri.toString());
    }

    public static Request build(String str) {
        return new Request(str == null ? Uri.EMPTY : Uri.parse(str));
    }

    public void rebuild(String str, Bundle... bundleArr) {
        this.f21058j = str == null ? Uri.EMPTY : Uri.parse(str);
        Bundle bundle = new Bundle();
        if (bundleArr != null && bundleArr.length > 0) {
            for (Bundle putAll : bundleArr) {
                bundle.putAll(putAll);
            }
        }
        this.extra.clear();
        this.extra.putAll(bundle);
        this.extra.putString(Extend.REQUEST_BUILD_URI, this.f21058j.toString());
    }

    public void start() {
        start((Context) null, (RouterCallback) null);
    }

    public void start(Context context) {
        start(context, (RouterCallback) null);
    }

    public void start(Context context, RouterCallback routerCallback) {
        if (context == null) {
            context = DRouter.getContext();
        }
        this.f21050a = context;
        RouterLoader.m17788a(this, routerCallback).mo63824a();
    }

    public Context getContext() {
        return this.f21050a;
    }

    public Uri getUri() {
        return this.f21058j;
    }

    public int getRouterType() {
        return this.f21053d;
    }

    public String getNumber() {
        return this.f21056g;
    }

    public Request setHoldTimeout(long j) {
        this.f21055f = j;
        return this;
    }

    public Request setRemoteAuthority(String str) {
        this.f21052c = str;
        return this;
    }

    public Request setRemoteDeadResend(int i) {
        this.f21054e = i;
        return this;
    }

    public Request setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.f21051b = lifecycleOwner;
        return this;
    }

    public IInterceptor getInterceptor() {
        IInterceptor iInterceptor = this.f21057h;
        return iInterceptor == null ? new InterceptorHandler.Default() : iInterceptor;
    }
}
