package com.didi.component.payentrance.model;

public class JumpableItem implements Jumpable {

    /* renamed from: a */
    private int f16747a;

    /* renamed from: b */
    private CharSequence f16748b;

    /* renamed from: c */
    private int f16749c;

    public JumpableItem(int i, CharSequence charSequence) {
        this.f16747a = i;
        this.f16748b = charSequence;
    }

    public JumpableItem(int i, int i2) {
        this.f16747a = i;
        this.f16749c = i2;
    }

    public int getId() {
        return this.f16747a;
    }

    public CharSequence getText() {
        return this.f16748b;
    }

    public int getTextRes() {
        return this.f16749c;
    }
}
