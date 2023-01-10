package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;

/* renamed from: com.didichuxing.foundation.net.http.a */
/* compiled from: AbstractMultipartBody */
abstract class C16356a extends HttpBody implements MultipartEntity, C16358c {
    private final String mFilename;
    private final MimeType mMimeType;

    public C16356a(MimeType mimeType, String str) {
        this.mMimeType = mimeType;
        this.mFilename = str;
    }

    public String getFilename() {
        return this.mFilename;
    }

    public MimeType getContentType() {
        return this.mMimeType;
    }
}
