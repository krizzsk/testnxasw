package com.p226hp.hpl.sparta;

/* renamed from: com.hp.hpl.sparta.a */
/* compiled from: BuildDocument */
class C20727a implements ParseHandler, C20730d {

    /* renamed from: a */
    private final ParseLog f56737a;

    /* renamed from: b */
    private Element f56738b;

    /* renamed from: c */
    private final Document f56739c;

    /* renamed from: d */
    private ParseSource f56740d;

    public void endDocument() {
    }

    public void startDocument() {
    }

    public C20727a() {
        this((ParseLog) null);
    }

    public C20727a(ParseLog parseLog) {
        this.f56738b = null;
        this.f56739c = new Document();
        this.f56740d = null;
        this.f56737a = parseLog == null ? DEFAULT_LOG : parseLog;
    }

    public void setParseSource(ParseSource parseSource) {
        this.f56740d = parseSource;
        this.f56739c.setSystemId(parseSource.toString());
    }

    public ParseSource getParseSource() {
        return this.f56740d;
    }

    public String toString() {
        if (this.f56740d == null) {
            return null;
        }
        return "BuildDoc: " + this.f56740d.toString();
    }

    public String getSystemId() {
        ParseSource parseSource = this.f56740d;
        if (parseSource != null) {
            return parseSource.getSystemId();
        }
        return null;
    }

    public int getLineNumber() {
        ParseSource parseSource = this.f56740d;
        if (parseSource != null) {
            return parseSource.getLineNumber();
        }
        return -1;
    }

    /* renamed from: a */
    public Document mo171195a() {
        return this.f56739c;
    }

    public void startElement(Element element) {
        Element element2 = this.f56738b;
        if (element2 == null) {
            this.f56739c.setDocumentElement(element);
        } else {
            element2.appendChild(element);
        }
        this.f56738b = element;
    }

    public void endElement(Element element) {
        this.f56738b = this.f56738b.getParentNode();
    }

    public void characters(char[] cArr, int i, int i2) {
        Element element = this.f56738b;
        if (element.getLastChild() instanceof Text) {
            ((Text) element.getLastChild()).appendData(cArr, i, i2);
        } else {
            element.mo171121a(new Text(new String(cArr, i, i2)));
        }
    }
}
