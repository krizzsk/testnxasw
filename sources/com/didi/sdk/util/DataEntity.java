package com.didi.sdk.util;

import android.view.View;

public class DataEntity {

    /* renamed from: a */
    private View f40293a;

    /* renamed from: b */
    private Align f40294b;

    /* renamed from: c */
    private Offset f40295c;

    /* renamed from: d */
    private IDataEntityChangeListener f40296d;

    public interface IDataEntityChangeListener {
        void onChange(String str, int i);
    }

    public static class Offset {

        /* renamed from: x */
        public int f40297x;

        /* renamed from: y */
        public int f40298y;
    }

    public void setDataEntityChangeListener(IDataEntityChangeListener iDataEntityChangeListener) {
        this.f40296d = iDataEntityChangeListener;
    }

    public IDataEntityChangeListener getDataEntityChangeListener() {
        return this.f40296d;
    }

    private DataEntity() {
    }

    public Align getAlign() {
        return this.f40294b;
    }

    public View getView() {
        return this.f40293a;
    }

    public static DataEntity create() {
        return new DataEntity();
    }

    public DataEntity setView(View view) {
        this.f40293a = view;
        return this;
    }

    public DataEntity setOffset(Offset offset) {
        this.f40295c = offset;
        return this;
    }

    public Offset getOffset() {
        return this.f40295c;
    }

    public DataEntity setAlign(Align align) {
        this.f40294b = align;
        return this;
    }

    public enum Align {
        BOTTON(80),
        CENTER(17),
        FILL_HORIZONTAL(7),
        TOP(48),
        FILL_BOTTOM_HORIZONTAL(87),
        FILL_TOP_HORIZONTAL(55);
        
        int align;

        private Align(int i) {
            this.align = i;
        }
    }
}
