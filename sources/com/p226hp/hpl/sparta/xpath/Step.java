package com.p226hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.IOException;

/* renamed from: com.hp.hpl.sparta.xpath.Step */
public class Step {
    public static Step DOT = new Step(ThisNodeTest.f56824a, TrueExpr.f56825a);

    /* renamed from: a */
    private final NodeTest f56818a;

    /* renamed from: b */
    private final BooleanExpr f56819b;

    /* renamed from: c */
    private final boolean f56820c;

    Step(NodeTest nodeTest, BooleanExpr booleanExpr) {
        this.f56818a = nodeTest;
        this.f56819b = booleanExpr;
        this.f56820c = false;
    }

    Step(XPath xPath, boolean z, SimpleStreamTokenizer simpleStreamTokenizer) throws XPathException, IOException {
        this.f56820c = z;
        int i = simpleStreamTokenizer.ttype;
        if (i != -3) {
            if (i == 42) {
                this.f56818a = AllElementTest.f56802a;
            } else if (i != 46) {
                if (i != 64) {
                    throw new XPathException(xPath, "at begininning of step", simpleStreamTokenizer, "'.' or '*' or name");
                } else if (simpleStreamTokenizer.nextToken() == -3) {
                    this.f56818a = new AttrTest(simpleStreamTokenizer.sval);
                } else {
                    throw new XPathException(xPath, "after @ in node test", simpleStreamTokenizer, "name");
                }
            } else if (simpleStreamTokenizer.nextToken() == 46) {
                this.f56818a = ParentNodeTest.f56808a;
            } else {
                simpleStreamTokenizer.pushBack();
                this.f56818a = ThisNodeTest.f56824a;
            }
        } else if (!simpleStreamTokenizer.sval.equals("text")) {
            this.f56818a = new ElementTest(simpleStreamTokenizer.sval);
        } else if (simpleStreamTokenizer.nextToken() == 40 && simpleStreamTokenizer.nextToken() == 41) {
            this.f56818a = TextTest.f56823a;
        } else {
            throw new XPathException(xPath, "after text", simpleStreamTokenizer, "()");
        }
        if (simpleStreamTokenizer.nextToken() == 91) {
            simpleStreamTokenizer.nextToken();
            this.f56819b = ExprFactory.m42833a(xPath, simpleStreamTokenizer);
            if (simpleStreamTokenizer.ttype == 93) {
                simpleStreamTokenizer.nextToken();
                return;
            }
            throw new XPathException(xPath, "after predicate expression", simpleStreamTokenizer, Const.jaRight);
        }
        this.f56819b = TrueExpr.f56825a;
    }

    public String toString() {
        return this.f56818a.toString() + this.f56819b.toString();
    }

    public boolean isMultiLevel() {
        return this.f56820c;
    }

    public boolean isStringValue() {
        return this.f56818a.isStringValue();
    }

    public NodeTest getNodeTest() {
        return this.f56818a;
    }

    public BooleanExpr getPredicate() {
        return this.f56819b;
    }
}
