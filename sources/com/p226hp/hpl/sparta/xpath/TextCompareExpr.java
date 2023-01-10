package com.p226hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.TextCompareExpr */
public abstract class TextCompareExpr extends BooleanExpr {

    /* renamed from: a */
    private final String f56821a;

    TextCompareExpr(String str) {
        this.f56821a = str;
    }

    public String getValue() {
        return this.f56821a;
    }

    /* access modifiers changed from: protected */
    public String toString(String str) {
        return "[text()" + str + "'" + this.f56821a + "']";
    }
}
