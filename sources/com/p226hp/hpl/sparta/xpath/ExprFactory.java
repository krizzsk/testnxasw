package com.p226hp.hpl.sparta.xpath;

import java.io.IOException;

/* renamed from: com.hp.hpl.sparta.xpath.ExprFactory */
public class ExprFactory {
    /* renamed from: a */
    static BooleanExpr m42833a(XPath xPath, SimpleStreamTokenizer simpleStreamTokenizer) throws XPathException, IOException {
        int i;
        int i2;
        int i3 = simpleStreamTokenizer.ttype;
        if (i3 != -3) {
            if (i3 == -2) {
                int i4 = simpleStreamTokenizer.nval;
                simpleStreamTokenizer.nextToken();
                return new PositionEqualsExpr(i4);
            } else if (i3 != 64) {
                throw new XPathException(xPath, "at beginning of expression", simpleStreamTokenizer, "@, number, or text()");
            } else if (simpleStreamTokenizer.nextToken() == -3) {
                String str = simpleStreamTokenizer.sval;
                int nextToken = simpleStreamTokenizer.nextToken();
                if (nextToken != 33) {
                    switch (nextToken) {
                        case 60:
                            simpleStreamTokenizer.nextToken();
                            if (simpleStreamTokenizer.ttype == 34 || simpleStreamTokenizer.ttype == 39) {
                                i = Integer.parseInt(simpleStreamTokenizer.sval);
                            } else if (simpleStreamTokenizer.ttype == -2) {
                                i = simpleStreamTokenizer.nval;
                            } else {
                                throw new XPathException(xPath, "right hand side of less-than", simpleStreamTokenizer, "quoted string or number");
                            }
                            simpleStreamTokenizer.nextToken();
                            return new AttrLessExpr(str, i);
                        case 61:
                            simpleStreamTokenizer.nextToken();
                            if (simpleStreamTokenizer.ttype == 34 || simpleStreamTokenizer.ttype == 39) {
                                String str2 = simpleStreamTokenizer.sval;
                                simpleStreamTokenizer.nextToken();
                                return new AttrEqualsExpr(str, str2);
                            }
                            throw new XPathException(xPath, "right hand side of equals", simpleStreamTokenizer, "quoted string");
                        case 62:
                            simpleStreamTokenizer.nextToken();
                            if (simpleStreamTokenizer.ttype == 34 || simpleStreamTokenizer.ttype == 39) {
                                i2 = Integer.parseInt(simpleStreamTokenizer.sval);
                            } else if (simpleStreamTokenizer.ttype == -2) {
                                i2 = simpleStreamTokenizer.nval;
                            } else {
                                throw new XPathException(xPath, "right hand side of greater-than", simpleStreamTokenizer, "quoted string or number");
                            }
                            simpleStreamTokenizer.nextToken();
                            return new AttrGreaterExpr(str, i2);
                        default:
                            return new AttrExistsExpr(str);
                    }
                } else {
                    simpleStreamTokenizer.nextToken();
                    if (simpleStreamTokenizer.ttype == 61) {
                        simpleStreamTokenizer.nextToken();
                        if (simpleStreamTokenizer.ttype == 34 || simpleStreamTokenizer.ttype == 39) {
                            String str3 = simpleStreamTokenizer.sval;
                            simpleStreamTokenizer.nextToken();
                            return new AttrNotEqualsExpr(str, str3);
                        }
                        throw new XPathException(xPath, "right hand side of !=", simpleStreamTokenizer, "quoted string");
                    }
                    throw new XPathException(xPath, "after !", simpleStreamTokenizer, "=");
                }
            } else {
                throw new XPathException(xPath, "after @", simpleStreamTokenizer, "name");
            }
        } else if (!simpleStreamTokenizer.sval.equals("text")) {
            throw new XPathException(xPath, "at beginning of expression", simpleStreamTokenizer, "text()");
        } else if (simpleStreamTokenizer.nextToken() != 40) {
            throw new XPathException(xPath, "after text", simpleStreamTokenizer, "(");
        } else if (simpleStreamTokenizer.nextToken() == 41) {
            int nextToken2 = simpleStreamTokenizer.nextToken();
            if (nextToken2 == 33) {
                simpleStreamTokenizer.nextToken();
                if (simpleStreamTokenizer.ttype == 61) {
                    simpleStreamTokenizer.nextToken();
                    if (simpleStreamTokenizer.ttype == 34 || simpleStreamTokenizer.ttype == 39) {
                        String str4 = simpleStreamTokenizer.sval;
                        simpleStreamTokenizer.nextToken();
                        return new TextNotEqualsExpr(str4);
                    }
                    throw new XPathException(xPath, "right hand side of !=", simpleStreamTokenizer, "quoted string");
                }
                throw new XPathException(xPath, "after !", simpleStreamTokenizer, "=");
            } else if (nextToken2 != 61) {
                return TextExistsExpr.f56822a;
            } else {
                simpleStreamTokenizer.nextToken();
                if (simpleStreamTokenizer.ttype == 34 || simpleStreamTokenizer.ttype == 39) {
                    String str5 = simpleStreamTokenizer.sval;
                    simpleStreamTokenizer.nextToken();
                    return new TextEqualsExpr(str5);
                }
                throw new XPathException(xPath, "right hand side of equals", simpleStreamTokenizer, "quoted string");
            }
        } else {
            throw new XPathException(xPath, "after text(", simpleStreamTokenizer, ")");
        }
    }
}
