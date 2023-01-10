package com.didi.soda.order.component.contact;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.widget.dialog.NumProtectModel;
import com.didi.soda.order.component.contact.dialog.INumProtect;
import com.didi.soda.order.component.contact.dialog.NumProtectActivityDialog;
import com.didi.soda.order.component.contact.dialog.NumProtectPageDialog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 )2\u00020\u0001:\u0002)*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u001eH&J$\u0010 \u001a\u00020\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010!\u001a\u00020\u000fH\u0016J\u001f\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%\"\u00020&¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u001eH\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006+"}, mo148868d2 = {"Lcom/didi/soda/order/component/contact/AbstractRole;", "Lcom/didi/soda/order/component/contact/IRole;", "orderInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "(Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getOrderInfoEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "setOrderInfoEntity", "roleType", "", "getRoleType", "()I", "setRoleType", "(I)V", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setScopeContext", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "virtualCallRoleType", "getVirtualCallRoleType", "setVirtualCallRoleType", "doCall", "", "doIM", "doRealContact", "contactWay", "getLogTracker", "Lcom/didi/soda/customer/foundation/log/RecordTracker$Builder;", "message", "", "", "([Ljava/lang/String;)Lcom/didi/soda/customer/foundation/log/RecordTracker$Builder;", "virtualTelCall", "Companion", "DialogController", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AbstractRole.kt */
public abstract class AbstractRole implements IRole {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "OrderContactUtil";
    public static final int VIRTUAL_CALL_ROLE_BUSINESS = 1;
    public static final int VIRTUAL_CALL_ROLE_RIDER = 0;

    /* renamed from: a */
    private OrderInfoEntity f45913a;

    /* renamed from: b */
    private ScopeContext f45914b;
    public Context context;

    public abstract void doCall();

    public abstract void doIM();

    public abstract int getRoleType();

    public abstract int getVirtualCallRoleType();

    public abstract void setRoleType(int i);

    public abstract void setVirtualCallRoleType(int i);

    public AbstractRole(OrderInfoEntity orderInfoEntity) {
        Intrinsics.checkNotNullParameter(orderInfoEntity, "orderInfoEntity");
        this.f45913a = orderInfoEntity;
    }

    public OrderInfoEntity getOrderInfoEntity() {
        return this.f45913a;
    }

    public void setOrderInfoEntity(OrderInfoEntity orderInfoEntity) {
        Intrinsics.checkNotNullParameter(orderInfoEntity, "<set-?>");
        this.f45913a = orderInfoEntity;
    }

    public final ScopeContext getScopeContext() {
        return this.f45914b;
    }

    public final void setScopeContext(ScopeContext scopeContext) {
        this.f45914b = scopeContext;
    }

    public final Context getContext() {
        Context context2 = this.context;
        if (context2 != null) {
            return context2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public void doRealContact(Context context2, ScopeContext scopeContext, int i) {
        if (context2 == null) {
            context2 = GlobalContext.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        }
        setContext(context2);
        this.f45914b = scopeContext;
        if (i == 11) {
            doIM();
        } else if (i == 22) {
            doCall();
        }
    }

    /* access modifiers changed from: protected */
    public final void virtualTelCall() {
        LogUtil.m32584d("OrderContactUtil", "virtualTelCall + 0 rider/1 shop = 0");
        AddressEntity addressEntity = getOrderInfoEntity().addressInfo;
        String str = null;
        String str2 = addressEntity == null ? null : addressEntity.phone;
        AddressEntity addressEntity2 = getOrderInfoEntity().addressInfo;
        if (addressEntity2 != null) {
            str = addressEntity2.callingCode;
        }
        if (TextUtils.isEmpty(str)) {
            str = LoginUtil.getCallingCode();
        }
        AddressEntity addressEntity3 = getOrderInfoEntity().addressInfo;
        int i = addressEntity3 == null ? 0 : addressEntity3.countryId;
        if (i <= 0) {
            i = LoginUtil.getCountryId();
        }
        NumProtectModel numProtectModel = new NumProtectModel(str2, str, i);
        INumProtect buildDialog = DialogController.INSTANCE.buildDialog(getContext(), this.f45914b);
        String str3 = getOrderInfoEntity().orderId;
        Intrinsics.checkNotNullExpressionValue(str3, "orderInfoEntity.orderId");
        buildDialog.showNumProtectDialog(numProtectModel, str3, getVirtualCallRoleType());
    }

    public final RecordTracker.Builder getLogTracker(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "message");
        StringBuilder sb = new StringBuilder();
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        RecordTracker.Builder otherParam = RecordTracker.Builder.create().setTag("OrderContactUtil").setLogModule("m-odr|").setMessage(sb.toString()).setLogCategory("c-state|").setOtherParam("orderId", getOrderInfoEntity().orderId);
        Intrinsics.checkNotNullExpressionValue(otherParam, "create()\n               … orderInfoEntity.orderId)");
        return otherParam;
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo148868d2 = {"Lcom/didi/soda/order/component/contact/AbstractRole$Companion;", "", "()V", "TAG", "", "VIRTUAL_CALL_ROLE_BUSINESS", "", "VIRTUAL_CALL_ROLE_RIDER", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: AbstractRole.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/order/component/contact/AbstractRole$DialogController;", "", "()V", "buildDialog", "Lcom/didi/soda/order/component/contact/dialog/INumProtect;", "context", "Landroid/content/Context;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: AbstractRole.kt */
    public static final class DialogController {
        public static final DialogController INSTANCE = new DialogController();

        private DialogController() {
        }

        public final INumProtect buildDialog(Context context, ScopeContext scopeContext) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (scopeContext != null) {
                return new NumProtectPageDialog(context, scopeContext);
            }
            return new NumProtectActivityDialog(context);
        }
    }
}
