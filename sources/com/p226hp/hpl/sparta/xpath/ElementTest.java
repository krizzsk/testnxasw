package com.p226hp.hpl.sparta.xpath;

import com.p226hp.hpl.sparta.Sparta;

/* renamed from: com.hp.hpl.sparta.xpath.ElementTest */
public class ElementTest extends NodeTest {

    /* renamed from: a */
    private final String f56807a;

    public boolean isStringValue() {
        return false;
    }

    ElementTest(String str) {
        this.f56807a = Sparta.intern(str);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getTagName() {
        return this.f56807a;
    }

    public String toString() {
        return this.f56807a;
    }
}
