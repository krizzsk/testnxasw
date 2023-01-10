package com.didiglobal.dittoview.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import com.didi.sdk.apm.SystemUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class DittoNinePatchBuilder {

    /* renamed from: a */
    private int f52463a;

    /* renamed from: b */
    private int f52464b;

    /* renamed from: c */
    private Bitmap f52465c;

    /* renamed from: d */
    private Resources f52466d;

    /* renamed from: e */
    private ArrayList<Integer> f52467e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<Integer> f52468f = new ArrayList<>();

    public DittoNinePatchBuilder(Resources resources, Bitmap bitmap) {
        this.f52463a = bitmap.getWidth();
        this.f52464b = bitmap.getHeight();
        SystemUtils.log(6, "9patch", "width = " + this.f52463a + ", height = " + this.f52464b, (Throwable) null, "com.didiglobal.dittoview.util.DittoNinePatchBuilder", 27);
        this.f52465c = bitmap;
        this.f52466d = resources;
    }

    public DittoNinePatchBuilder(int i, int i2) {
        this.f52463a = i;
        this.f52464b = i2;
    }

    public DittoNinePatchBuilder addXRegion(int i, int i2) {
        this.f52467e.add(Integer.valueOf(i));
        this.f52467e.add(Integer.valueOf(i + i2));
        return this;
    }

    public DittoNinePatchBuilder addXRegionPoints(int i, int i2) {
        this.f52467e.add(Integer.valueOf(i));
        this.f52467e.add(Integer.valueOf(i2));
        return this;
    }

    public DittoNinePatchBuilder addXRegion(float f, float f2) {
        int i = (int) (f * ((float) this.f52463a));
        this.f52467e.add(Integer.valueOf(i));
        this.f52467e.add(Integer.valueOf(i + ((int) (f2 * ((float) this.f52463a)))));
        return this;
    }

    public DittoNinePatchBuilder addXRegionPoints(float f, float f2) {
        this.f52467e.add(Integer.valueOf((int) (f * ((float) this.f52463a))));
        this.f52467e.add(Integer.valueOf((int) (f2 * ((float) this.f52463a))));
        return this;
    }

    public DittoNinePatchBuilder addXCenteredRegion(int i) {
        int i2 = (this.f52463a - i) / 2;
        this.f52467e.add(Integer.valueOf(i2));
        this.f52467e.add(Integer.valueOf(i2 + i));
        return this;
    }

    public DittoNinePatchBuilder addXCenteredRegion(float f) {
        int i = this.f52463a;
        int i2 = (int) (f * ((float) i));
        int i3 = (i - i2) / 2;
        this.f52467e.add(Integer.valueOf(i3));
        this.f52467e.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public DittoNinePatchBuilder addYRegion(int i, int i2) {
        this.f52468f.add(Integer.valueOf(i));
        this.f52468f.add(Integer.valueOf(i + i2));
        return this;
    }

    public DittoNinePatchBuilder addYRegionPoints(int i, int i2) {
        this.f52468f.add(Integer.valueOf(i));
        this.f52468f.add(Integer.valueOf(i2));
        return this;
    }

    public DittoNinePatchBuilder addYRegion(float f, float f2) {
        int i = (int) (f * ((float) this.f52464b));
        this.f52468f.add(Integer.valueOf(i));
        this.f52468f.add(Integer.valueOf(i + ((int) (f2 * ((float) this.f52464b)))));
        return this;
    }

    public DittoNinePatchBuilder addYRegionPoints(float f, float f2) {
        this.f52468f.add(Integer.valueOf((int) (f * ((float) this.f52464b))));
        this.f52468f.add(Integer.valueOf((int) (f2 * ((float) this.f52464b))));
        return this;
    }

    public DittoNinePatchBuilder addYCenteredRegion(int i) {
        int i2 = (this.f52464b - i) / 2;
        this.f52468f.add(Integer.valueOf(i2));
        this.f52468f.add(Integer.valueOf(i2 + i));
        return this;
    }

    public DittoNinePatchBuilder addYCenteredRegion(float f) {
        int i = this.f52464b;
        int i2 = (int) (f * ((float) i));
        int i3 = (i - i2) / 2;
        this.f52468f.add(Integer.valueOf(i3));
        this.f52468f.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public byte[] buildChunk() {
        if (this.f52467e.size() == 0) {
            this.f52467e.add(0);
            this.f52467e.add(Integer.valueOf(this.f52463a));
        }
        if (this.f52468f.size() == 0) {
            this.f52468f.add(0);
            this.f52468f.add(Integer.valueOf(this.f52464b));
        }
        ByteBuffer order = ByteBuffer.allocate((this.f52467e.size() + 8 + this.f52468f.size() + 9) * 4).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) this.f52467e.size());
        order.put((byte) this.f52468f.size());
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        Iterator<Integer> it = this.f52467e.iterator();
        while (it.hasNext()) {
            order.putInt(it.next().intValue());
        }
        Iterator<Integer> it2 = this.f52468f.iterator();
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
        if (this.f52465c != null) {
            return new NinePatch(this.f52465c, buildChunk, (String) null);
        }
        return null;
    }

    public NinePatchDrawable build() {
        NinePatch buildNinePatch = buildNinePatch();
        if (buildNinePatch != null) {
            return new NinePatchDrawable(this.f52466d, buildNinePatch);
        }
        return null;
    }
}
