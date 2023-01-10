package com.wallet.flutter.wallet_flutter.function;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.wallet.flutter.wallet_flutter.http.FlutterNetModel;
import com.wallet.flutter.wallet_flutter.http.PixOrderCreateRespEntity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u0007H\u0016J&\u0010\u001b\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\t¨\u0006 "}, mo148868d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterTopUpViewModel;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "failedResult", "Landroidx/lifecycle/MutableLiveData;", "", "getFailedResult", "()Landroidx/lifecycle/MutableLiveData;", "failedToast", "", "getFailedToast", "flutterNetModel", "Lcom/wallet/flutter/wallet_flutter/http/FlutterNetModel;", "orderId", "getOrderId", "()Ljava/lang/String;", "pwdData", "Lcom/didi/payment/wallet/password/PasswordDataVo;", "getPwdData", "successOrder", "Lcom/wallet/flutter/wallet_flutter/http/PixOrderCreateRespEntity$OrderMetaData;", "getSuccessOrder", "toH5LiveData", "getToH5LiveData", "loadData", "topUp", "map", "Ljava/util/HashMap;", "", "passwordToken", "wallet_flutter_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FlutterTopUpViewModel.kt */
public final class FlutterTopUpViewModel extends WBaseViewModel {

    /* renamed from: a */
    private final FlutterNetModel f58820a;

    /* renamed from: b */
    private final MutableLiveData<PixOrderCreateRespEntity.OrderMetaData> f58821b = new MutableLiveData<>();

    /* renamed from: c */
    private final MutableLiveData<PasswordDataVo> f58822c = new MutableLiveData<>();

    /* renamed from: d */
    private final MutableLiveData<String> f58823d = new MutableLiveData<>();

    /* renamed from: e */
    private final MutableLiveData<String> f58824e = new MutableLiveData<>();

    /* renamed from: f */
    private final MutableLiveData<Unit> f58825f = new MutableLiveData<>();

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlutterTopUpViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f58820a = new FlutterNetModel(application);
    }

    public final MutableLiveData<PixOrderCreateRespEntity.OrderMetaData> getSuccessOrder() {
        return this.f58821b;
    }

    public final String getOrderId() {
        PixOrderCreateRespEntity.OrderMetaData value = this.f58821b.getValue();
        if (value == null) {
            return null;
        }
        return value.getOrderId();
    }

    public final MutableLiveData<PasswordDataVo> getPwdData() {
        return this.f58822c;
    }

    public final MutableLiveData<String> getToH5LiveData() {
        return this.f58823d;
    }

    public final MutableLiveData<String> getFailedToast() {
        return this.f58824e;
    }

    public final MutableLiveData<Unit> getFailedResult() {
        return this.f58825f;
    }

    public static /* synthetic */ void topUp$default(FlutterTopUpViewModel flutterTopUpViewModel, HashMap hashMap, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        flutterTopUpViewModel.topUp(hashMap, str);
    }

    public final void topUp(HashMap<String, Object> hashMap, String str) {
        Intrinsics.checkNotNullParameter(hashMap, "map");
        isLoading().setValue(true);
        this.f58820a.createPixTopUpOrder(hashMap, str, new FlutterTopUpViewModel$topUp$callback$1(this));
    }
}
