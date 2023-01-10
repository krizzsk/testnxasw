package com.p226hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.AttrExpr */
public abstract class AttrExpr extends BooleanExpr {

    /* renamed from: a */
    private final String f56804a;

    AttrExpr(String str) {
        this.f56804a = str;
    }

    public String getAttrName() {
        return this.f56804a;
    }

    public String toString() {
        return "@" + this.f56804a;
    }
}
