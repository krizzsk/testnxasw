package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/UploadPhotoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "downloadUrl", "", "getDownloadUrl", "()Ljava/lang/String;", "setDownloadUrl", "(Ljava/lang/String;)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: UploadPhotoEntity.kt */
public final class UploadPhotoEntity implements IEntity {
    private String downloadUrl = "";

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final void setDownloadUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.downloadUrl = str;
    }
}
