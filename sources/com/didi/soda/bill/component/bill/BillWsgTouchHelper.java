package com.didi.soda.bill.component.bill;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.security.wireless.TouchManager;
import com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\u000bJ\f\u0010\u000e\u001a\b\u0018\u00010\u0004R\u00020\u0005J\f\u0010\u000f\u001a\b\u0018\u00010\u0004R\u00020\u0005J\f\u0010\u0010\u001a\b\u0018\u00010\u0004R\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u0014\u0010\u0003\u001a\b\u0018\u00010\u0004R\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0004R\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\u0004R\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/bill/component/bill/BillWsgTouchHelper;", "", "()V", "addressListener", "Lcom/didi/security/wireless/TouchManager$TouchListener;", "Lcom/didi/security/wireless/TouchManager;", "createOrderListener", "payChooseListener", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "attach", "", "context", "detach", "getAddressTouch", "getCreateOrderTouch", "getPayChooseTouch", "report", "shopInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo;", "Companion", "Holder", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillWsgTouchHelper.kt */
public final class BillWsgTouchHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final BillWsgTouchHelper f41532e = Holder.INSTANCE.getHolder();

    /* renamed from: a */
    private ScopeContext f41533a;

    /* renamed from: b */
    private TouchManager.TouchListener f41534b;

    /* renamed from: c */
    private TouchManager.TouchListener f41535c;

    /* renamed from: d */
    private TouchManager.TouchListener f41536d;

    public /* synthetic */ BillWsgTouchHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/bill/component/bill/BillWsgTouchHelper$Companion;", "", "()V", "instance", "Lcom/didi/soda/bill/component/bill/BillWsgTouchHelper;", "getInstance", "()Lcom/didi/soda/bill/component/bill/BillWsgTouchHelper;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BillWsgTouchHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BillWsgTouchHelper getInstance() {
            return BillWsgTouchHelper.f41532e;
        }
    }

    private BillWsgTouchHelper() {
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/bill/component/bill/BillWsgTouchHelper$Holder;", "", "()V", "holder", "Lcom/didi/soda/bill/component/bill/BillWsgTouchHelper;", "getHolder", "()Lcom/didi/soda/bill/component/bill/BillWsgTouchHelper;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BillWsgTouchHelper.kt */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static final BillWsgTouchHelper holder = new BillWsgTouchHelper((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final BillWsgTouchHelper getHolder() {
            return holder;
        }
    }

    public final void attach(ScopeContext scopeContext) {
        this.f41533a = scopeContext;
        this.f41534b = TouchManager.getInstance().make("sailing_c_cart_address_choose_ck", "1");
        this.f41535c = TouchManager.getInstance().make("sailing_c_cart_payment_choose_ck", "1");
        this.f41536d = TouchManager.getInstance().make("sailing_c_cart_pay_ck", "1");
    }

    public final void detach() {
        this.f41533a = null;
        TouchManager.getInstance().remove("sailing_c_cart_address_choose_ck");
        TouchManager.getInstance().remove("sailing_c_cart_payment_choose_ck");
        TouchManager.getInstance().remove("sailing_c_cart_pay_ck");
        this.f41534b = null;
        this.f41535c = null;
        this.f41536d = null;
    }

    public final TouchManager.TouchListener getAddressTouch() {
        if (this.f41533a != null) {
            return this.f41534b;
        }
        return null;
    }

    public final TouchManager.TouchListener getPayChooseTouch() {
        if (this.f41533a != null) {
            return this.f41535c;
        }
        return null;
    }

    public final TouchManager.TouchListener getCreateOrderTouch() {
        if (this.f41533a != null) {
            return this.f41536d;
        }
        return null;
    }

    public final void report(ShopInfo shopInfo) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (shopInfo != null) {
            try {
                T json = GsonUtil.toJson(shopInfo);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(shopInfo)");
                objectRef.element = json;
            } catch (Exception unused) {
                objectRef.element = "";
            }
        }
        UiHandlerUtil.post(new Runnable() {
            public final void run() {
                BillWsgTouchHelper.m31190a(Ref.ObjectRef.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31190a(Ref.ObjectRef objectRef) {
        Intrinsics.checkNotNullParameter(objectRef, "$dataStr");
        TouchManager.getInstance().report((String) objectRef.element);
    }
}
