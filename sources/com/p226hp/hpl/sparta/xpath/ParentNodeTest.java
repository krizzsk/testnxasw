package com.p226hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.ParentNodeTest */
public class ParentNodeTest extends NodeTest {

    /* renamed from: a */
    static final ParentNodeTest f56808a = new ParentNodeTest();

    public boolean isStringValue() {
        return false;
    }

    public String toString() {
        return "..";
    }

    private ParentNodeTest() {
    }

    public void accept(Visitor visitor) throws XPathException {
        visitor.visit(this);
    }
}
