package com.jumio.core.network;

import com.jumio.core.models.ApiCallDataModel;
import jumio.core.C19477g;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R(\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, mo148868d2 = {"Lcom/jumio/core/network/ApiBinding;", "Ljumio/core/g;", "", "Ljava/lang/Class;", "Lcom/jumio/core/network/ApiCall;", "getBindingClasses", "()[Ljava/lang/Class;", "bindingClasses", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: ApiBinding.kt */
public interface ApiBinding extends C19477g {
    Class<? extends ApiCall<?>>[] getBindingClasses();

    /* synthetic */ void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th);

    /* synthetic */ void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj);
}
