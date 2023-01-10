package com.p226hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p174dp.locsdk.Const;

/* renamed from: com.hp.hpl.sparta.xpath.PositionEqualsExpr */
public class PositionEqualsExpr extends BooleanExpr {

    /* renamed from: a */
    private final int f56809a;

    public PositionEqualsExpr(int i) {
        this.f56809a = i;
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public int getPosition() {
        return this.f56809a;
    }

    public String toString() {
        return Const.jaLeft + this.f56809a + Const.jaRight;
    }
}
