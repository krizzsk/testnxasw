package com.p226hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.ThisNodeTest */
public class ThisNodeTest extends NodeTest {

    /* renamed from: a */
    static final ThisNodeTest f56824a = new ThisNodeTest();

    public boolean isStringValue() {
        return false;
    }

    public String toString() {
        return ".";
    }

    private ThisNodeTest() {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
