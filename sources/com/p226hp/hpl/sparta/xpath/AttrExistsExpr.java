package com.p226hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p174dp.locsdk.Const;

/* renamed from: com.hp.hpl.sparta.xpath.AttrExistsExpr */
public class AttrExistsExpr extends AttrExpr {
    AttrExistsExpr(String str) {
        super(str);
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public String toString() {
        return Const.jaLeft + super.toString() + Const.jaRight;
    }
}
