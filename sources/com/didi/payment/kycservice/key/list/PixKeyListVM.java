package com.didi.payment.kycservice.key.list;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.kycservice.key.list.response.PixKeyListResp;
import com.didi.payment.kycservice.net.PixNetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/payment/kycservice/key/list/PixKeyListVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "pixKeyListData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp$Data;", "getPixKeyListData", "()Landroidx/lifecycle/MutableLiveData;", "loadData", "", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixKeyListVM.kt */
public final class PixKeyListVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f33167a;

    /* renamed from: b */
    private final MutableLiveData<PixKeyListResp.Data> f33168b = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixKeyListVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f33167a = new PixNetModel(application);
    }

    public final MutableLiveData<PixKeyListResp.Data> getPixKeyListData() {
        return this.f33168b;
    }

    public void loadData() {
        this.f33167a.getPixKeyList(new PixKeyListVM$loadData$1(this));
    }
}
