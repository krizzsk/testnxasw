package com.didi.drouter.router;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.didi.drouter.store.RouterMeta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Result extends C8529a<Result> {

    /* renamed from: a */
    C8531c f21059a;

    /* renamed from: b */
    Class<?> f21060b;

    /* renamed from: c */
    boolean f21061c;

    /* renamed from: d */
    Fragment f21062d;

    /* renamed from: e */
    View f21063e;

    /* renamed from: f */
    private final int f21064f;

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

    Result(Request request, Map<Request, RouterMeta> map, RouterCallback routerCallback) {
        this.f21059a = new C8531c(request, map, this, routerCallback);
        this.f21064f = map != null ? map.size() : 0;
    }

    public Request getRequest() {
        return this.f21059a.f21081k;
    }

    public Class<?> getTargetClass() {
        return this.f21060b;
    }

    public boolean isActivityStarted() {
        return this.f21061c;
    }

    public Fragment getFragment() {
        return this.f21062d;
    }

    public void setFragment(Fragment fragment) {
        this.f21062d = fragment;
    }

    public View getView() {
        return this.f21063e;
    }

    public void setView(View view) {
        this.f21063e = view;
    }

    public int getRouterSize() {
        return this.f21064f;
    }
}
