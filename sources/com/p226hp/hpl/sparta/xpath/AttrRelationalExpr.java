package com.p226hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p174dp.locsdk.Const;

/* renamed from: com.hp.hpl.sparta.xpath.AttrRelationalExpr */
public abstract class AttrRelationalExpr extends AttrExpr {

    /* renamed from: a */
    private final int f56805a;

    AttrRelationalExpr(String str, int i) {
        super(str);
        this.f56805a = i;
    }

    public double getAttrValue() {
        return (double) this.f56805a;
    }

    /* access modifiers changed from: protected */
    public String toString(String str) {
        return Const.jaLeft + super.toString() + str + "'" + this.f56805a + "']";
    }
}
