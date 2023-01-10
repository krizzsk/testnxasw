package com.p226hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.TextTest */
public class TextTest extends NodeTest {

    /* renamed from: a */
    static final TextTest f56823a = new TextTest();

    public boolean isStringValue() {
        return true;
    }

    public String toString() {
        return "text()";
    }

    private TextTest() {
    }

    public void accept(Visitor visitor) throws XPathException {
        visitor.visit(this);
    }
}
