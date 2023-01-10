package com.didi.soda.home.manager;

import android.app.Activity;
import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.sdk.util.TimeUtil;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.storage.LocationSettingStorage;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LocalPermissionHelper;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.helper.CustomerLocationSettingHelper;
import com.didi.soda.home.policy.HomePolicyHelper;
import com.didi.soda.home.policy.model.LocationSettingEntity;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0004&'()B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\rJ\u001c\u0010\u001c\u001a\u00020\u00132\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u0006H\u0002J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J \u0010\"\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, mo148868d2 = {"Lcom/didi/soda/home/manager/CustomerDialogShownManager;", "", "()V", "TAG", "", "newValue", "", "currentShowDialogType", "getCurrentShowDialogType", "()I", "setCurrentShowDialogType", "(I)V", "isShownLocationPermissionDialog", "", "mCurrentLocationSettingScene", "mListeners", "", "Lcom/didi/soda/home/manager/CustomerDialogShownManager$OnDialogShownChangeListener;", "addOnDialogShownChangeListener", "", "onDialogShownChangeListener", "checkHomePopNeedShown", "checkLocationSettingDialog", "ctx", "Landroid/content/Context;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "hasActiveDialog", "notifyDialogShownChanged", "oldDialogType", "newDialogType", "onResumeCheckLocationSettingService", "removeAllListener", "removeOnDialogShownChangeListener", "showLocationDialog", "hasLocationPermission", "data", "Lcom/didi/soda/home/policy/model/LocationSettingEntity;", "Companion", "DialogType", "Holder", "OnDialogShownChangeListener", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerDialogShownManager.kt */
public final class CustomerDialogShownManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static CustomerDialogShownManager f45150f = Holder.INSTANCE.getHolder();

    /* renamed from: a */
    private final String f45151a;

    /* renamed from: b */
    private final List<OnDialogShownChangeListener> f45152b;

    /* renamed from: c */
    private int f45153c;

    /* renamed from: d */
    private boolean f45154d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f45155e;

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/home/manager/CustomerDialogShownManager$OnDialogShownChangeListener;", "", "onDialogShownChange", "", "oldDialogType", "", "newDialogDialog", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomerDialogShownManager.kt */
    public interface OnDialogShownChangeListener {
        void onDialogShownChange(@DialogType int i, @DialogType int i2);
    }

    public /* synthetic */ CustomerDialogShownManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CustomerDialogShownManager() {
        this.f45151a = "CustomerDialogShownManager";
        this.f45152b = new ArrayList();
    }

    public final int getCurrentShowDialogType() {
        return this.f45153c;
    }

    public final void setCurrentShowDialogType(int i) {
        int i2 = this.f45153c;
        this.f45153c = i;
        if (i2 != i) {
            m33521a(i2, i);
        }
        String str = this.f45151a;
        LogUtil.m32584d(str, "currentType==" + i2 + ",newType=" + i);
    }

    @Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, mo148868d2 = {"Lcom/didi/soda/home/manager/CustomerDialogShownManager$DialogType;", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: CustomerDialogShownManager.kt */
    public @interface DialogType {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int HomePop = 3;
        public static final int Location = 2;
        public static final int NONE = 0;
        public static final int Privacy = 1;

        @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo148868d2 = {"Lcom/didi/soda/home/manager/CustomerDialogShownManager$DialogType$Companion;", "", "()V", "HomePop", "", "Location", "NONE", "Privacy", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* compiled from: CustomerDialogShownManager.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int HomePop = 3;
            public static final int Location = 2;
            public static final int NONE = 0;
            public static final int Privacy = 1;

            private Companion() {
            }
        }
    }

    public final boolean hasActiveDialog() {
        return this.f45153c != 0;
    }

    /* renamed from: a */
    private final void m33521a(@DialogType int i, @DialogType int i2) {
        for (OnDialogShownChangeListener onDialogShownChange : this.f45152b) {
            onDialogShownChange.onDialogShownChange(i, i2);
        }
    }

    public final void addOnDialogShownChangeListener(OnDialogShownChangeListener onDialogShownChangeListener) {
        Intrinsics.checkNotNullParameter(onDialogShownChangeListener, "onDialogShownChangeListener");
        if (!this.f45152b.contains(onDialogShownChangeListener)) {
            this.f45152b.add(onDialogShownChangeListener);
        }
    }

    public final void removeOnDialogShownChangeListener(OnDialogShownChangeListener onDialogShownChangeListener) {
        Intrinsics.checkNotNullParameter(onDialogShownChangeListener, "onDialogShownChangeListener");
        if (this.f45152b.contains(onDialogShownChangeListener)) {
            this.f45152b.remove(onDialogShownChangeListener);
        }
    }

    public final void removeAllListener() {
        this.f45152b.clear();
    }

    public final boolean checkHomePopNeedShown() {
        return !HomePolicyHelper.getInstance().needShowPolicyDialog() && !f45150f.hasActiveDialog();
    }

    public final void checkLocationSettingDialog(Context context, ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        boolean hasLocationPermission = AddressUtil.hasLocationPermission();
        boolean isGpsEnabled = CustomerSystemUtil.isGpsEnabled(context);
        int locationSettingShownInterval = CustomerApolloUtil.getLocationSettingShownInterval();
        if ((!hasLocationPermission || !isGpsEnabled) && locationSettingShownInterval > 0) {
            LocationSettingEntity data = ((LocationSettingStorage) SingletonFactory.get(LocationSettingStorage.class)).getData();
            if (data.getLastTimeStampShownDialog() == 0 || TimeUtil.isOutOfDate(data.getLastTimeStampShownDialog(), locationSettingShownInterval)) {
                m33522a(scopeContext, hasLocationPermission, data);
            } else {
                setCurrentShowDialogType(0);
            }
        } else {
            setCurrentShowDialogType(0);
        }
    }

    /* renamed from: a */
    private final void m33522a(ScopeContext scopeContext, boolean z, LocationSettingEntity locationSettingEntity) {
        setCurrentShowDialogType(2);
        if (!z) {
            this.f45154d = true;
            HomeOmegaHelper.getInstance().locationDialogSw(false);
            DialogUtil.showOpenLocationPermissionDialog(DialogUtil.getScopeDialogInstrument(scopeContext), new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    CustomerDialogShownManager.m33523a(CustomerDialogShownManager.this, rFDialog);
                }
            }, new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    CustomerDialogShownManager.m33524b(CustomerDialogShownManager.this, rFDialog);
                }
            });
        } else {
            HomeOmegaHelper.getInstance().locationDialogSw(true);
            DialogUtil.showOpenLocationServiceDialog(DialogUtil.getScopeDialogInstrument(scopeContext), new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    CustomerDialogShownManager.m33525c(CustomerDialogShownManager.this, rFDialog);
                }
            }, new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    CustomerDialogShownManager.m33526d(CustomerDialogShownManager.this, rFDialog);
                }
            });
        }
        locationSettingEntity.setLastTimeStampShownDialog(System.currentTimeMillis());
        ((LocationSettingStorage) SingletonFactory.get(LocationSettingStorage.class)).setData(locationSettingEntity);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33523a(CustomerDialogShownManager customerDialogShownManager, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(customerDialogShownManager, "this$0");
        customerDialogShownManager.setCurrentShowDialogType(0);
        Context context = GlobalContext.getContext();
        if (context != null) {
            LocalPermissionHelper.openPermissionSetting((Activity) context);
            HomeOmegaHelper.getInstance().locationDialogCk(false, true);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33524b(CustomerDialogShownManager customerDialogShownManager, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(customerDialogShownManager, "this$0");
        customerDialogShownManager.setCurrentShowDialogType(0);
        HomeOmegaHelper.getInstance().locationDialogCk(false, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m33525c(CustomerDialogShownManager customerDialogShownManager, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(customerDialogShownManager, "this$0");
        customerDialogShownManager.setCurrentShowDialogType(0);
        customerDialogShownManager.f45155e = 3;
        CustomerLocationSettingHelper instance = CustomerLocationSettingHelper.Companion.getInstance();
        Context context = GlobalContext.getContext();
        if (context != null) {
            instance.startLocationSettingRequest((Activity) context, customerDialogShownManager.f45155e, (CustomerLocationSettingHelper.ILocationSettingRequestCallback) null);
            HomeOmegaHelper.getInstance().locationDialogCk(true, true);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m33526d(CustomerDialogShownManager customerDialogShownManager, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(customerDialogShownManager, "this$0");
        customerDialogShownManager.setCurrentShowDialogType(0);
        HomeOmegaHelper.getInstance().locationDialogCk(true, false);
    }

    public final void onResumeCheckLocationSettingService(Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        if (!this.f45154d || !AddressUtil.hasLocationPermission()) {
            int i = this.f45155e;
            if (i == 2 || i == 3) {
                CustomerLocationSettingHelper.Companion.getInstance().updateWindowShownStatus(context, this.f45155e, new CustomerDialogShownManager$onResumeCheckLocationSettingService$1(this));
                return;
            }
            return;
        }
        if (!CustomerSystemUtil.isGpsEnabled(context)) {
            this.f45155e = 2;
            CustomerLocationSettingHelper instance = CustomerLocationSettingHelper.Companion.getInstance();
            Context context2 = GlobalContext.getContext();
            if (context2 != null) {
                instance.startLocationSettingRequest((Activity) context2, this.f45155e, (CustomerLocationSettingHelper.ILocationSettingRequestCallback) null);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        } else {
            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(6);
        }
        this.f45154d = false;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/home/manager/CustomerDialogShownManager$Holder;", "", "()V", "holder", "Lcom/didi/soda/home/manager/CustomerDialogShownManager;", "getHolder", "()Lcom/didi/soda/home/manager/CustomerDialogShownManager;", "setHolder", "(Lcom/didi/soda/home/manager/CustomerDialogShownManager;)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomerDialogShownManager.kt */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static CustomerDialogShownManager holder = new CustomerDialogShownManager((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final CustomerDialogShownManager getHolder() {
            return holder;
        }

        public final void setHolder(CustomerDialogShownManager customerDialogShownManager) {
            Intrinsics.checkNotNullParameter(customerDialogShownManager, "<set-?>");
            holder = customerDialogShownManager;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo148868d2 = {"Lcom/didi/soda/home/manager/CustomerDialogShownManager$Companion;", "", "()V", "<set-?>", "Lcom/didi/soda/home/manager/CustomerDialogShownManager;", "instance", "getInstance", "()Lcom/didi/soda/home/manager/CustomerDialogShownManager;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomerDialogShownManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomerDialogShownManager getInstance() {
            return CustomerDialogShownManager.f45150f;
        }
    }
}
