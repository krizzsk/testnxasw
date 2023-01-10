package com.p226hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.TextExistsExpr */
public class TextExistsExpr extends BooleanExpr {

    /* renamed from: a */
    static final TextExistsExpr f56822a = new TextExistsExpr();

    public String toString() {
        return "[text()]";
    }

    private TextExistsExpr() {
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }
}
