package com.p226hp.hpl.sparta.xpath;

import com.didi.beatles.p101im.access.utils.IMTextUtils;

/* renamed from: com.hp.hpl.sparta.xpath.AttrLessExpr */
public class AttrLessExpr extends AttrRelationalExpr {
    public AttrLessExpr(String str, int i) {
        super(str, i);
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public String toString() {
        return toString(IMTextUtils.STREET_IMAGE_TAG_START);
    }
}
