package com.koushikdutta.async.http;

import android.text.TextUtils;

public class BasicNameValuePair implements NameValuePair, Cloneable {

    /* renamed from: a */
    private final String f58136a;

    /* renamed from: b */
    private final String f58137b;

    public BasicNameValuePair(String str, String str2) {
        if (str != null) {
            this.f58136a = str;
            this.f58137b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public String getName() {
        return this.f58136a;
    }

    public String getValue() {
        return this.f58137b;
    }

    public String toString() {
        return this.f58136a + "=" + this.f58137b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        if (!this.f58136a.equals(basicNameValuePair.f58136a) || !TextUtils.equals(this.f58137b, basicNameValuePair.f58137b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f58136a.hashCode() ^ this.f58137b.hashCode();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
