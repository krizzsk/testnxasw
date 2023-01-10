package com.p226hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.AttrTest */
public class AttrTest extends NodeTest {

    /* renamed from: a */
    private final String f56806a;

    public boolean isStringValue() {
        return true;
    }

    AttrTest(String str) {
        this.f56806a = str;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getAttrName() {
        return this.f56806a;
    }

    public String toString() {
        return "@" + this.f56806a;
    }
}
