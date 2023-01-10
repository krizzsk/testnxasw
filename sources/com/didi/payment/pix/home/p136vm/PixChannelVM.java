package com.didi.payment.pix.home.p136vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.pix.home.PixChannelResp;
import com.didi.payment.pix.net.PixNetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/payment/pix/home/vm/PixChannelVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "hasLoaded", "", "getHasLoaded", "()Z", "setHasLoaded", "(Z)V", "netModel", "Lcom/didi/payment/pix/net/PixNetModel;", "pageRespLd", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/pix/home/PixChannelResp$Data;", "getPageRespLd", "()Landroidx/lifecycle/MutableLiveData;", "setPageRespLd", "(Landroidx/lifecycle/MutableLiveData;)V", "loadData", "", "notifyPageRefresh", "refreshData", "executeRightNow", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.pix.home.vm.PixChannelVM */
/* compiled from: PixChannelVM.kt */
public final class PixChannelVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f33614a;

    /* renamed from: b */
    private MutableLiveData<PixChannelResp.Data> f33615b = new MutableLiveData<>();

    /* renamed from: c */
    private boolean f33616c;

    public final void notifyPageRefresh() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixChannelVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f33614a = new PixNetModel(application2);
    }

    public final MutableLiveData<PixChannelResp.Data> getPageRespLd() {
        return this.f33615b;
    }

    public final void setPageRespLd(MutableLiveData<PixChannelResp.Data> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33615b = mutableLiveData;
    }

    public final void refreshData(boolean z) {
        this.f33616c = false;
        if (z) {
            loadData();
        }
    }

    public final boolean getHasLoaded() {
        return this.f33616c;
    }

    public final void setHasLoaded(boolean z) {
        this.f33616c = z;
    }

    public void loadData() {
        if (!this.f33616c) {
            isLoading().setValue(true);
            this.f33614a.getPixChannel(new PixChannelVM$loadData$1(this));
        }
    }
}
