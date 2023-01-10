package com.jumio.core.api;

import com.jumio.core.model.Subscriber;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiCall;
import com.jumio.core.persistence.C20987a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import jumio.core.C19475f;
import jumio.core.C19477g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, mo148868d2 = {"Lcom/jumio/core/api/SingleProcessor;", "Lcom/jumio/core/model/Subscriber;", "", "result", "", "onResult", "", "error", "onError", "Ljava/util/concurrent/ExecutorService;", "executorService", "Ljumio/core/f;", "apiCallSettings", "Ljumio/core/g;", "apiResult", "<init>", "(Ljava/util/concurrent/ExecutorService;Ljumio/core/f;Ljumio/core/g;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: SingleProcessor.kt */
public final class SingleProcessor implements Subscriber<Object> {

    /* renamed from: a */
    public final ExecutorService f57492a;

    /* renamed from: b */
    public final C19475f f57493b;

    /* renamed from: c */
    public final C19477g f57494c;

    /* renamed from: d */
    public ApiCall<?> f57495d;

    /* renamed from: e */
    public Future<ApiCall<?>> f57496e;

    public SingleProcessor(ExecutorService executorService, C19475f fVar, C19477g gVar) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(gVar, "apiResult");
        this.f57492a = executorService;
        this.f57493b = fVar;
        this.f57494c = gVar;
    }

    /* renamed from: a */
    public final void mo171965a(ApiCallDataModel<?> apiCallDataModel) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        if (this.f57496e == null) {
            Object newInstance = apiCallDataModel.getCall().getDeclaredConstructor(new Class[]{C19475f.class, ApiCallDataModel.class}).newInstance(new Object[]{this.f57493b, apiCallDataModel});
            if (newInstance != null) {
                ApiCall<?> apiCall = (ApiCall) newInstance;
                this.f57495d = apiCall;
                apiCall.add(this);
                Future<ApiCall<?>> submit = this.f57492a.submit(this.f57495d);
                if (submit != null) {
                    this.f57496e = submit;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.Future<com.jumio.core.network.ApiCall<*>>");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.jumio.core.network.ApiCall<*>");
        }
        throw new IllegalArgumentException("Another call is being executed".toString());
    }

    public void onError(Throwable th) {
        ApiCall<?> apiCall = this.f57495d;
        if (apiCall != null) {
            this.f57494c.onError(apiCall.getApiCallDataModel(), th);
        }
        this.f57496e = null;
    }

    public void onResult(Object obj) {
        ApiCall<?> apiCall = this.f57495d;
        if (apiCall != null) {
            this.f57494c.onResult(apiCall.getApiCallDataModel(), obj);
        }
        this.f57496e = null;
    }

    /* renamed from: a */
    public final ApiCallDataModel<?> mo171964a() {
        try {
            ApiCall<?> apiCall = this.f57495d;
            if (apiCall != null) {
                apiCall.removeAllSubscriber();
            }
            Future<ApiCall<?>> future = this.f57496e;
            if (future != null) {
                future.cancel(true);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f57496e = null;
            throw th;
        }
        this.f57496e = null;
        ApiCall<?> apiCall2 = this.f57495d;
        if (apiCall2 == null) {
            return null;
        }
        return apiCall2.getApiCallDataModel();
    }

    /* renamed from: a */
    public final void mo171966a(C20987a.C20988a aVar, boolean z) {
        Intrinsics.checkNotNullParameter(aVar, "persistor");
        aVar.mo172439a(z ? mo171964a() : null);
    }

    /* renamed from: a */
    public final void mo171967a(C20987a.C20989b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "restorer");
        ApiCallDataModel apiCallDataModel = (ApiCallDataModel) bVar.mo172440a();
        if (apiCallDataModel != null) {
            mo171965a((ApiCallDataModel<?>) apiCallDataModel);
        }
    }
}
