package com.didi.app.nova.support.util;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;

public class BundleBuilder {

    /* renamed from: a */
    private final Bundle f10380a;

    public BundleBuilder(Bundle bundle) {
        this.f10380a = bundle;
    }

    public BundleBuilder putAll(Bundle bundle) {
        this.f10380a.putAll(bundle);
        return this;
    }

    public BundleBuilder putBoolean(String str, boolean z) {
        this.f10380a.putBoolean(str, z);
        return this;
    }

    public BundleBuilder putBooleanArray(String str, boolean[] zArr) {
        this.f10380a.putBooleanArray(str, zArr);
        return this;
    }

    public BundleBuilder putDouble(String str, double d) {
        this.f10380a.putDouble(str, d);
        return this;
    }

    public BundleBuilder putDoubleArray(String str, double[] dArr) {
        this.f10380a.putDoubleArray(str, dArr);
        return this;
    }

    public BundleBuilder putLong(String str, long j) {
        this.f10380a.putLong(str, j);
        return this;
    }

    public BundleBuilder putLongArray(String str, long[] jArr) {
        this.f10380a.putLongArray(str, jArr);
        return this;
    }

    public BundleBuilder putString(String str, String str2) {
        this.f10380a.putString(str, str2);
        return this;
    }

    public BundleBuilder putStringArray(String str, String[] strArr) {
        this.f10380a.putStringArray(str, strArr);
        return this;
    }

    public BundleBuilder putBundle(String str, Bundle bundle) {
        this.f10380a.putBundle(str, bundle);
        return this;
    }

    public BundleBuilder putByte(String str, byte b) {
        this.f10380a.putByte(str, b);
        return this;
    }

    public BundleBuilder putByteArray(String str, byte[] bArr) {
        this.f10380a.putByteArray(str, bArr);
        return this;
    }

    public BundleBuilder putChar(String str, char c) {
        this.f10380a.putChar(str, c);
        return this;
    }

    public BundleBuilder putCharArray(String str, char[] cArr) {
        this.f10380a.putCharArray(str, cArr);
        return this;
    }

    public BundleBuilder putCharSequence(String str, CharSequence charSequence) {
        this.f10380a.putCharSequence(str, charSequence);
        return this;
    }

    public BundleBuilder putCharSequenceArray(String str, CharSequence[] charSequenceArr) {
        this.f10380a.putCharSequenceArray(str, charSequenceArr);
        return this;
    }

    public BundleBuilder putCharSequenceArrayList(String str, ArrayList<CharSequence> arrayList) {
        this.f10380a.putCharSequenceArrayList(str, arrayList);
        return this;
    }

    public BundleBuilder putInt(String str, int i) {
        this.f10380a.putInt(str, i);
        return this;
    }

    public BundleBuilder putIntArray(String str, int[] iArr) {
        this.f10380a.putIntArray(str, iArr);
        return this;
    }

    public BundleBuilder putFloat(String str, float f) {
        this.f10380a.putFloat(str, f);
        return this;
    }

    public BundleBuilder putFloatArray(String str, float[] fArr) {
        this.f10380a.putFloatArray(str, fArr);
        return this;
    }

    public BundleBuilder putIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        this.f10380a.putIntegerArrayList(str, arrayList);
        return this;
    }

    public BundleBuilder putParcelable(String str, Parcelable parcelable) {
        this.f10380a.putParcelable(str, parcelable);
        return this;
    }

    public BundleBuilder putParcelableArray(String str, Parcelable[] parcelableArr) {
        this.f10380a.putParcelableArray(str, parcelableArr);
        return this;
    }

    public BundleBuilder putParcelableArrayList(String str, ArrayList<? extends Parcelable> arrayList) {
        this.f10380a.putParcelableArrayList(str, arrayList);
        return this;
    }

    public BundleBuilder putSerializable(String str, Serializable serializable) {
        this.f10380a.putSerializable(str, serializable);
        return this;
    }

    public BundleBuilder putShort(String str, short s) {
        this.f10380a.putShort(str, s);
        return this;
    }

    public BundleBuilder putShortArray(String str, short[] sArr) {
        this.f10380a.putShortArray(str, sArr);
        return this;
    }

    public BundleBuilder putSparseParcelableArray(String str, SparseArray<? extends Parcelable> sparseArray) {
        this.f10380a.putSparseParcelableArray(str, sparseArray);
        return this;
    }

    public BundleBuilder putStringArrayList(String str, ArrayList<String> arrayList) {
        this.f10380a.putStringArrayList(str, arrayList);
        return this;
    }

    public Bundle build() {
        return this.f10380a;
    }
}
