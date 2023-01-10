package com.jumio.core.network;

import com.jumio.commons.log.LogUtils;
import com.jumio.core.models.ApiCallDataModel;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import jumio.core.C19475f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: com.jumio.core.network.d */
/* compiled from: SimpleApiCall.kt */
public abstract class C20984d<T> extends ApiCall<T> {

    /* renamed from: d */
    public String f57760d = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C20984d(C19475f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
    }

    public void fillRequest(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        String str = this.f57760d;
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public String getBoundary() {
        return null;
    }

    public abstract String getRequest() throws Exception;

    public int prepareRequest() throws Exception {
        this.f57760d = getRequest();
        LogUtils.logServerRequest(getClass().getSimpleName(), this.f57760d);
        String str = this.f57760d;
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes.length;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
