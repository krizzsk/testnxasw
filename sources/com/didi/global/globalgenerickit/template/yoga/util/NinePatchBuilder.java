package com.didi.global.globalgenerickit.template.yoga.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import com.didi.sdk.apm.SystemUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class NinePatchBuilder {

    /* renamed from: a */
    private int f24155a;

    /* renamed from: b */
    private int f24156b;

    /* renamed from: c */
    private Bitmap f24157c;

    /* renamed from: d */
    private Resources f24158d;

    /* renamed from: e */
    private ArrayList<Integer> f24159e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<Integer> f24160f = new ArrayList<>();

    public NinePatchBuilder(Resources resources, Bitmap bitmap) {
        this.f24155a = bitmap.getWidth();
        this.f24156b = bitmap.getHeight();
        SystemUtils.log(6, "9patch", "width = " + this.f24155a + ", height = " + this.f24156b, (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.util.NinePatchBuilder", 27);
        this.f24157c = bitmap;
        this.f24158d = resources;
    }

    public NinePatchBuilder(int i, int i2) {
        this.f24155a = i;
        this.f24156b = i2;
    }

    public NinePatchBuilder addXRegion(int i, int i2) {
        this.f24159e.add(Integer.valueOf(i));
        this.f24159e.add(Integer.valueOf(i + i2));
        return this;
    }

    public NinePatchBuilder addXRegionPoints(int i, int i2) {
        this.f24159e.add(Integer.valueOf(i));
        this.f24159e.add(Integer.valueOf(i2));
        return this;
    }

    public NinePatchBuilder addXRegion(float f, float f2) {
        int i = (int) (f * ((float) this.f24155a));
        this.f24159e.add(Integer.valueOf(i));
        this.f24159e.add(Integer.valueOf(i + ((int) (f2 * ((float) this.f24155a)))));
        return this;
    }

    public NinePatchBuilder addXRegionPoints(float f, float f2) {
        this.f24159e.add(Integer.valueOf((int) (f * ((float) this.f24155a))));
        this.f24159e.add(Integer.valueOf((int) (f2 * ((float) this.f24155a))));
        return this;
    }

    public NinePatchBuilder addXCenteredRegion(int i) {
        int i2 = (this.f24155a - i) / 2;
        this.f24159e.add(Integer.valueOf(i2));
        this.f24159e.add(Integer.valueOf(i2 + i));
        return this;
    }

    public NinePatchBuilder addXCenteredRegion(float f) {
        int i = this.f24155a;
        int i2 = (int) (f * ((float) i));
        int i3 = (i - i2) / 2;
        this.f24159e.add(Integer.valueOf(i3));
        this.f24159e.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public NinePatchBuilder addYRegion(int i, int i2) {
        this.f24160f.add(Integer.valueOf(i));
        this.f24160f.add(Integer.valueOf(i + i2));
        return this;
    }

    public NinePatchBuilder addYRegionPoints(int i, int i2) {
        this.f24160f.add(Integer.valueOf(i));
        this.f24160f.add(Integer.valueOf(i2));
        return this;
    }

    public NinePatchBuilder addYRegion(float f, float f2) {
        int i = (int) (f * ((float) this.f24156b));
        this.f24160f.add(Integer.valueOf(i));
        this.f24160f.add(Integer.valueOf(i + ((int) (f2 * ((float) this.f24156b)))));
        return this;
    }

    public NinePatchBuilder addYRegionPoints(float f, float f2) {
        this.f24160f.add(Integer.valueOf((int) (f * ((float) this.f24156b))));
        this.f24160f.add(Integer.valueOf((int) (f2 * ((float) this.f24156b))));
        return this;
    }

    public NinePatchBuilder addYCenteredRegion(int i) {
        int i2 = (this.f24156b - i) / 2;
        this.f24160f.add(Integer.valueOf(i2));
        this.f24160f.add(Integer.valueOf(i2 + i));
        return this;
    }

    public NinePatchBuilder addYCenteredRegion(float f) {
        int i = this.f24156b;
        int i2 = (int) (f * ((float) i));
        int i3 = (i - i2) / 2;
        this.f24160f.add(Integer.valueOf(i3));
        this.f24160f.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public byte[] buildChunk() {
        if (this.f24159e.size() == 0) {
            this.f24159e.add(0);
            this.f24159e.add(Integer.valueOf(this.f24155a));
        }
        if (this.f24160f.size() == 0) {
            this.f24160f.add(0);
            this.f24160f.add(Integer.valueOf(this.f24156b));
        }
        ByteBuffer order = ByteBuffer.allocate((this.f24159e.size() + 8 + this.f24160f.size() + 9) * 4).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) this.f24159e.size());
        order.put((byte) this.f24160f.size());
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        Iterator<Integer> it = this.f24159e.iterator();
        while (it.hasNext()) {
            order.putInt(it.next().intValue());
        }
        Iterator<Integer> it2 = this.f24160f.iterator();
        while (it2.hasNext()) {
            order.putInt(it2.next().intValue());
        }
        for (int i = 0; i < 9; i++) {
            order.putInt(1);
        }
        return order.array();
    }

    public NinePatch buildNinePatch() {
        byte[] buildChunk = buildChunk();
        if (this.f24157c != null) {
            return new NinePatch(this.f24157c, buildChunk, (String) null);
        }
        return null;
    }

    public NinePatchDrawable build() {
        NinePatch buildNinePatch = buildNinePatch();
        if (buildNinePatch != null) {
            return new NinePatchDrawable(this.f24158d, buildNinePatch);
        }
        return null;
    }
}
