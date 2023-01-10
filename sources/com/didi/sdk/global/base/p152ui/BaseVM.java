package com.didi.sdk.global.base.p152ui;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH&R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\f"}, mo148868d2 = {"Lcom/didi/sdk/global/base/ui/BaseVM;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "isLoadingLD", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "isNetErrorLD", "loadData", "", "payment_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.sdk.global.base.ui.BaseVM */
/* compiled from: BaseVM.kt */
public abstract class BaseVM extends AndroidViewModel {

    /* renamed from: a */
    private final MutableLiveData<Boolean> f38853a = new MutableLiveData<>();

    /* renamed from: b */
    private final MutableLiveData<Boolean> f38854b = new MutableLiveData<>();

    public abstract void loadData();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<Boolean> isLoadingLD() {
        return this.f38853a;
    }

    public final MutableLiveData<Boolean> isNetErrorLD() {
        return this.f38854b;
    }
}
