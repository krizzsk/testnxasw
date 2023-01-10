package com.didi.entrega.customer.foundation.util;

import android.net.Uri;
import android.text.TextUtils;

public final class UrlBuilder {

    /* renamed from: a */
    private Uri.Builder f22011a;

    private UrlBuilder(String str) {
        this.f22011a = Uri.parse(str).buildUpon();
    }

    public static UrlBuilder create(String str) {
        return new UrlBuilder(str);
    }

    public UrlBuilder appendParam(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f22011a.appendQueryParameter(str, str2);
        }
        return this;
    }

    public String build() {
        return this.f22011a.build().toString();
    }
}
