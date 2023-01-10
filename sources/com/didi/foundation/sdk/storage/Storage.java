package com.didi.foundation.sdk.storage;

import android.content.Context;
import android.os.Parcelable;
import com.didi.foundation.sdk.storage.IStorage;
import java.io.Serializable;

public abstract class Storage<T extends Parcelable> implements IStorage<T> {

    /* renamed from: a */
    private IStorage f23180a;

    public Storage() {
        this.f23180a = new C8971a(getClass().getName());
    }

    public Storage(String str) {
        this.f23180a = new C8971a(str);
    }

    public Storage(Context context) {
        this.f23180a = new C8971a(getClass().getName(), context);
    }

    public Storage(String str, Context context) {
        this.f23180a = new C8971a(str, context);
    }

    public T getData(String str) {
        return (Parcelable) this.f23180a.getData(str);
    }

    public void setData(String str, T t) {
        this.f23180a.setData(str, t);
    }

    public void setData(T t) {
        this.f23180a.setData(t);
    }

    public T getData() {
        return (Parcelable) this.f23180a.getData();
    }

    public void clear() {
        this.f23180a.clear();
    }

    public boolean has(String str) {
        return this.f23180a.has(str);
    }

    public void remove(String str) {
        this.f23180a.remove(str);
    }

    public boolean getBoolean(String str) {
        return this.f23180a.getBoolean(str);
    }

    public void putBoolean(String str, boolean z) {
        this.f23180a.putBoolean(str, z);
    }

    public IStorage setBoolean(String str, boolean z) {
        return this.f23180a.setBoolean(str, z);
    }

    public int getInt(String str) {
        return this.f23180a.getInt(str);
    }

    public void putInt(String str, int i) {
        this.f23180a.putInt(str, i);
    }

    public IStorage setInt(String str, int i) {
        return this.f23180a.setInt(str, i);
    }

    public float getFloat(String str) {
        return this.f23180a.getFloat(str);
    }

    public void putFloat(String str, float f) {
        this.f23180a.putFloat(str, f);
    }

    public IStorage setFloat(String str, float f) {
        return this.f23180a.setFloat(str, f);
    }

    public long getLong(String str) {
        return this.f23180a.getLong(str);
    }

    public void putLong(String str, long j) {
        this.f23180a.putLong(str, j);
    }

    public IStorage setLong(String str, long j) {
        return this.f23180a.setLong(str, j);
    }

    public String getString(String str) {
        return this.f23180a.getString(str);
    }

    public void putString(String str, String str2) {
        this.f23180a.putString(str, str2);
    }

    public IStorage setString(String str, String str2) {
        return this.f23180a.setString(str, str2);
    }

    public Serializable getSerializable(String str) {
        return this.f23180a.getSerializable(str);
    }

    public void putSerializable(String str, Serializable serializable) {
        this.f23180a.putSerializable(str, serializable);
    }

    public void commit(IStorage.Callback callback) {
        this.f23180a.commit(callback);
    }
}
