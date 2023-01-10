package com.didichuxing.foundation.net.http;

public class SimpleHttpHeader implements HttpHeader {

    /* renamed from: a */
    private final String f50151a;

    /* renamed from: b */
    private final String f50152b;

    public SimpleHttpHeader(String str, String str2) {
        this.f50151a = str;
        this.f50152b = str2;
    }

    public String getName() {
        return this.f50151a;
    }

    public String getValue() {
        return this.f50152b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleHttpHeader)) {
            return false;
        }
        SimpleHttpHeader simpleHttpHeader = (SimpleHttpHeader) obj;
        String str = this.f50151a;
        if (str == null ? simpleHttpHeader.f50151a != null : !str.equals(simpleHttpHeader.f50151a)) {
            return false;
        }
        String str2 = this.f50152b;
        String str3 = simpleHttpHeader.f50152b;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        String str = this.f50151a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f50152b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f50151a;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        sb.append(str);
        sb.append(": ");
        String str3 = this.f50152b;
        if (str3 != null) {
            str2 = str3;
        }
        sb.append(str2);
        return sb.toString();
    }
}
