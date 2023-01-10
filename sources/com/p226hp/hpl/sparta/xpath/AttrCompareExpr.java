package com.p226hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.p226hp.hpl.sparta.Sparta;

/* renamed from: com.hp.hpl.sparta.xpath.AttrCompareExpr */
public abstract class AttrCompareExpr extends AttrExpr {

    /* renamed from: a */
    private final String f56803a;

    AttrCompareExpr(String str, String str2) {
        super(str);
        this.f56803a = Sparta.intern(str2);
    }

    public String getAttrValue() {
        return this.f56803a;
    }

    /* access modifiers changed from: protected */
    public String toString(String str) {
        return Const.jaLeft + super.toString() + str + "'" + this.f56803a + "']";
    }
}
