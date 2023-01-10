package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

public class Highlight {

    /* renamed from: a */
    private float f54962a;

    /* renamed from: b */
    private float f54963b;

    /* renamed from: c */
    private float f54964c;

    /* renamed from: d */
    private float f54965d;

    /* renamed from: e */
    private int f54966e;

    /* renamed from: f */
    private int f54967f;

    /* renamed from: g */
    private int f54968g;

    /* renamed from: h */
    private YAxis.AxisDependency f54969h;

    /* renamed from: i */
    private float f54970i;

    /* renamed from: j */
    private float f54971j;

    public Highlight(float f, float f2, int i) {
        this.f54962a = Float.NaN;
        this.f54963b = Float.NaN;
        this.f54966e = -1;
        this.f54968g = -1;
        this.f54962a = f;
        this.f54963b = f2;
        this.f54967f = i;
    }

    public Highlight(float f, int i, int i2) {
        this(f, Float.NaN, i);
        this.f54968g = i2;
    }

    public Highlight(float f, float f2, float f3, float f4, int i, YAxis.AxisDependency axisDependency) {
        this.f54962a = Float.NaN;
        this.f54963b = Float.NaN;
        this.f54966e = -1;
        this.f54968g = -1;
        this.f54962a = f;
        this.f54963b = f2;
        this.f54964c = f3;
        this.f54965d = f4;
        this.f54967f = i;
        this.f54969h = axisDependency;
    }

    public Highlight(float f, float f2, float f3, float f4, int i, int i2, YAxis.AxisDependency axisDependency) {
        this(f, f2, f3, f4, i, axisDependency);
        this.f54968g = i2;
    }

    public float getX() {
        return this.f54962a;
    }

    public float getY() {
        return this.f54963b;
    }

    public float getXPx() {
        return this.f54964c;
    }

    public float getYPx() {
        return this.f54965d;
    }

    public int getDataIndex() {
        return this.f54966e;
    }

    public void setDataIndex(int i) {
        this.f54966e = i;
    }

    public int getDataSetIndex() {
        return this.f54967f;
    }

    public int getStackIndex() {
        return this.f54968g;
    }

    public boolean isStacked() {
        return this.f54968g >= 0;
    }

    public YAxis.AxisDependency getAxis() {
        return this.f54969h;
    }

    public void setDraw(float f, float f2) {
        this.f54970i = f;
        this.f54971j = f2;
    }

    public float getDrawX() {
        return this.f54970i;
    }

    public float getDrawY() {
        return this.f54971j;
    }

    public boolean equalTo(Highlight highlight) {
        return highlight != null && this.f54967f == highlight.f54967f && this.f54962a == highlight.f54962a && this.f54968g == highlight.f54968g && this.f54966e == highlight.f54966e;
    }

    public String toString() {
        return "Highlight, x: " + this.f54962a + ", y: " + this.f54963b + ", dataSetIndex: " + this.f54967f + ", stackIndex (only stacked barentry): " + this.f54968g;
    }
}
