package com.didi.payment.pix.orderdetail.p137vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/payment/pix/orderdetail/vm/PixOrderDetailVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "detailSections", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$OrderDetail;", "getDetailSections", "()Landroidx/lifecycle/MutableLiveData;", "setDetailSections", "(Landroidx/lifecycle/MutableLiveData;)V", "pixNetModel", "Lcom/didi/payment/pix/net/PixNetModel;", "getPixNetModel", "()Lcom/didi/payment/pix/net/PixNetModel;", "setPixNetModel", "(Lcom/didi/payment/pix/net/PixNetModel;)V", "loadData", "", "loadDataByOid", "orderId", "", "orderRetry", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.pix.orderdetail.vm.PixOrderDetailVM */
/* compiled from: PixOrderDetailVM.kt */
public final class PixOrderDetailVM extends WBaseViewModel {

    /* renamed from: a */
    private PixNetModel f33643a;

    /* renamed from: b */
    private MutableLiveData<PixOrderDetailResp.OrderDetail> f33644b = new MutableLiveData<>();

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixOrderDetailVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f33643a = new PixNetModel(application);
    }

    public final PixNetModel getPixNetModel() {
        return this.f33643a;
    }

    public final void setPixNetModel(PixNetModel pixNetModel) {
        Intrinsics.checkNotNullParameter(pixNetModel, "<set-?>");
        this.f33643a = pixNetModel;
    }

    public final MutableLiveData<PixOrderDetailResp.OrderDetail> getDetailSections() {
        return this.f33644b;
    }

    public final void setDetailSections(MutableLiveData<PixOrderDetailResp.OrderDetail> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33644b = mutableLiveData;
    }

    public final void loadDataByOid(String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        isLoading().setValue(true);
        this.f33643a.getOrderDetail(str, new PixOrderDetailVM$loadDataByOid$1(this));
    }

    public final void orderRetry(String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        isLoading().setValue(true);
        this.f33643a.orderRetry(str, new PixOrderDetailVM$orderRetry$1(this, str));
    }
}
