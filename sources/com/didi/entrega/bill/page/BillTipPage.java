package com.didi.entrega.bill.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.entrega.bill.CustomerCartChangeHandler;
import com.didi.entrega.bill.component.tip.BillTipComponent;
import com.didi.entrega.bill.model.BillTipModel;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.base.pages.FloatingCustomerPage;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.Request;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/entrega/bill/page/BillTipPage;", "Lcom/didi/entrega/customer/base/pages/FloatingCustomerPage;", "()V", "mCartContainer", "Landroid/widget/FrameLayout;", "mContentView", "Landroid/view/View;", "getPopHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getPushHandler", "initContentView", "", "onCreate", "view", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@Route(interceptors = {BillTipPageInterceptor.class}, value = {"billTipPage"})
/* compiled from: BillTipPage.kt */
public final class BillTipPage extends FloatingCustomerPage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private FrameLayout f21425a;

    /* renamed from: b */
    private View f21426b;

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        View view2 = this.f21426b;
        FrameLayout frameLayout = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        setContentView(view2);
        setType(2);
        FrameLayout frameLayout2 = this.f21425a;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCartContainer");
        } else {
            frameLayout = frameLayout2;
        }
        addComponent(new BillTipComponent(frameLayout));
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.entrega_page_bill_tip, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        this.f21426b = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.customer_fl_cart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI…stomer_fl_cart_container)");
        this.f21425a = (FrameLayout) findViewById;
    }

    public ControllerChangeHandler getPopHandler() {
        return new CustomerCartChangeHandler(R.id.entrega_custom_confirm_button, false);
    }

    public ControllerChangeHandler getPushHandler() {
        return new CustomerCartChangeHandler(R.id.entrega_custom_confirm_button, false);
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¨\u0006\b"}, mo148868d2 = {"Lcom/didi/entrega/bill/page/BillTipPage$Companion;", "", "()V", "show", "", "params", "", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BillTipPage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void show(Map<String, ? extends Object> map) {
            Object obj;
            Object obj2;
            Request.Builder path = DiRouter.request().path("billTipPage");
            Object obj3 = null;
            if (map == null) {
                obj = null;
            } else {
                obj = map.get(Const.FlutterBundleKey.TIPFEEINFO);
            }
            Request.Builder putSerializable = path.putSerializable("tip_info", obj instanceof BillTipModel ? (BillTipModel) obj : null);
            if (map == null) {
                obj2 = null;
            } else {
                obj2 = map.get("currency");
            }
            Request.Builder putString = putSerializable.putString("currency", obj2 instanceof String ? (String) obj2 : null);
            if (map != null) {
                obj3 = map.get(Const.FlutterBundleKey.TIPFEEBASEPRICE);
            }
            if (obj3 != null) {
                putString.putInt("price", ((Integer) obj3).intValue()).open();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }
}
