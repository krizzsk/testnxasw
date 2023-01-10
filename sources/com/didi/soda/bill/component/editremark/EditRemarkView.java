package com.didi.soda.bill.component.editremark;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerEditTextCompat;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\b\u0010\u001e\u001a\u00020\u0019H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/soda/bill/component/editremark/EditRemarkView;", "Lcom/didi/soda/bill/component/Contract$AbsEditRemarkView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "confirmBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "contentEt", "Lcom/didi/soda/customer/widget/support/CustomerEditTextCompat;", "editContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mAutoShowKeyBoard", "", "originRemark", "", "getOriginRemark", "()Ljava/lang/String;", "setOriginRemark", "(Ljava/lang/String;)V", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "init", "", "initDefaultNote", "defaultNote", "onCreate", "onPause", "onResume", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EditRemarkView.kt */
public final class EditRemarkView extends Contract.AbsEditRemarkView implements IRFFloatingExpand {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CustomerEditTextCompat f41649a;

    /* renamed from: b */
    private RFMainButton f41650b;

    /* renamed from: c */
    private ConstraintLayout f41651c;

    /* renamed from: d */
    private String f41652d = "";

    /* renamed from: e */
    private boolean f41653e = true;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public final String getOriginRemark() {
        return this.f41652d;
    }

    public final void setOriginRemark(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f41652d = str;
    }

    public void onCreate() {
        super.onCreate();
        m31323a();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Context context = getContext();
        CustomerEditTextCompat customerEditTextCompat = this.f41649a;
        if (customerEditTextCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            customerEditTextCompat = null;
        }
        KeyboardUtils.hideSoftInput(context, customerEditTextCompat);
    }

    public void initDefaultNote(String str) {
        Intrinsics.checkNotNullParameter(str, "defaultNote");
        this.f41652d = str;
        CharSequence charSequence = str;
        CustomerEditTextCompat customerEditTextCompat = null;
        if (charSequence.length() == 0) {
            IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
            CustomerEditTextCompat customerEditTextCompat2 = this.f41649a;
            if (customerEditTextCompat2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            } else {
                customerEditTextCompat = customerEditTextCompat2;
            }
            iToolsService.setTypeface(customerEditTextCompat, IToolsService.FontType.LIGHT);
            return;
        }
        CustomerEditTextCompat customerEditTextCompat3 = this.f41649a;
        if (customerEditTextCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            customerEditTextCompat3 = null;
        }
        customerEditTextCompat3.setText(charSequence);
        CustomerEditTextCompat customerEditTextCompat4 = this.f41649a;
        if (customerEditTextCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            customerEditTextCompat4 = null;
        }
        customerEditTextCompat4.setSelection(str.length());
        IToolsService iToolsService2 = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
        CustomerEditTextCompat customerEditTextCompat5 = this.f41649a;
        if (customerEditTextCompat5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
        } else {
            customerEditTextCompat = customerEditTextCompat5;
        }
        iToolsService2.setTypeface(customerEditTextCompat, IToolsService.FontType.MEDIUM);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_edit_remark, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_remark_edit_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.cus…er_remark_edit_container)");
        this.f41651c = (ConstraintLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_custom_cart_note);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.customer_custom_cart_note)");
        this.f41649a = (CustomerEditTextCompat) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_custom_common_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.cus…er_custom_common_confirm)");
        this.f41650b = (RFMainButton) findViewById3;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…on_confirm)\n            }");
        return inflate;
    }

    /* renamed from: a */
    private final void m31323a() {
        RFFloatingNavBar navBar = getNavBar(getScopeContext());
        if (navBar != null) {
            navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    EditRemarkView.m31324a(EditRemarkView.this, view);
                }
            }).build());
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.customer_name_note)).build());
            navBar.setBackground(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
        }
        RFMainButton rFMainButton = this.f41650b;
        ConstraintLayout constraintLayout = null;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            rFMainButton = null;
        }
        rFMainButton.setText(getContext().getString(R.string.customer_dialog_confirm));
        RFMainButton rFMainButton2 = this.f41650b;
        if (rFMainButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            rFMainButton2 = null;
        }
        rFMainButton2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditRemarkView.m31326b(EditRemarkView.this, view);
            }
        });
        CustomerEditTextCompat customerEditTextCompat = this.f41649a;
        if (customerEditTextCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            customerEditTextCompat = null;
        }
        customerEditTextCompat.setOnTouchListener($$Lambda$EditRemarkView$BJkl4mYaySTQRaT2GyjbIr8uXS0.INSTANCE);
        CustomerEditTextCompat customerEditTextCompat2 = this.f41649a;
        if (customerEditTextCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            customerEditTextCompat2 = null;
        }
        customerEditTextCompat2.addTextChangedListener(new EditRemarkView$init$4(this));
        CustomerEditTextCompat customerEditTextCompat3 = this.f41649a;
        if (customerEditTextCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            customerEditTextCompat3 = null;
        }
        customerEditTextCompat3.setFocusable(true);
        CustomerEditTextCompat customerEditTextCompat4 = this.f41649a;
        if (customerEditTextCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            customerEditTextCompat4 = null;
        }
        customerEditTextCompat4.setFocusableInTouchMode(true);
        Context context = getContext();
        if (context != null) {
            AndroidBug5497Workaround instance = AndroidBug5497Workaround.getInstance((Activity) context);
            ScopeContext scopeContext = getScopeContext();
            ConstraintLayout constraintLayout2 = this.f41651c;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editContainer");
            } else {
                constraintLayout = constraintLayout2;
            }
            instance.assistComponent(scopeContext, constraintLayout);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31324a(EditRemarkView editRemarkView, View view) {
        Intrinsics.checkNotNullParameter(editRemarkView, "this$0");
        ((Contract.AbsEditRemarkPresenter) editRemarkView.getPresenter()).finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31326b(EditRemarkView editRemarkView, View view) {
        Intrinsics.checkNotNullParameter(editRemarkView, "this$0");
        CustomerEditTextCompat customerEditTextCompat = editRemarkView.f41649a;
        CustomerEditTextCompat customerEditTextCompat2 = null;
        if (customerEditTextCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            customerEditTextCompat = null;
        }
        Editable text = customerEditTextCompat.getText();
        CharSequence charSequence = text;
        if ((charSequence == null || charSequence.length() == 0) || text.length() < 200) {
            CustomerEditTextCompat customerEditTextCompat3 = editRemarkView.f41649a;
            if (customerEditTextCompat3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentEt");
                customerEditTextCompat3 = null;
            }
            if (!Intrinsics.areEqual((Object) String.valueOf(customerEditTextCompat3.getText()), (Object) editRemarkView.getOriginRemark())) {
                Contract.AbsEditRemarkPresenter absEditRemarkPresenter = (Contract.AbsEditRemarkPresenter) editRemarkView.getPresenter();
                CustomerEditTextCompat customerEditTextCompat4 = editRemarkView.f41649a;
                if (customerEditTextCompat4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentEt");
                    customerEditTextCompat4 = null;
                }
                absEditRemarkPresenter.updateRemark(String.valueOf(customerEditTextCompat4.getText()));
            }
            ((Contract.AbsEditRemarkPresenter) editRemarkView.getPresenter()).finish();
            BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
            String string = editRemarkView.getScopeContext().getBundle().getString("current_shop_id", "");
            Intrinsics.checkNotNullExpressionValue(string, "scopeContext.bundle.getS…eKey.CURRENT_SHOP_ID, \"\")");
            String string2 = editRemarkView.getScopeContext().getBundle().getString("cart_id", "");
            Intrinsics.checkNotNullExpressionValue(string2, "scopeContext.bundle.getS…st.BundleKey.CART_ID, \"\")");
            CustomerEditTextCompat customerEditTextCompat5 = editRemarkView.f41649a;
            if (customerEditTextCompat5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            } else {
                customerEditTextCompat2 = customerEditTextCompat5;
            }
            companion.trackCartRemarkConfirmCk(string, string2, String.valueOf(customerEditTextCompat2.getText()));
            return;
        }
        ToastUtil.showCustomerToast(editRemarkView.getScopeContext(), editRemarkView.getContext().getString(R.string.customer_bill_remark_max_length));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m31325a(View view, MotionEvent motionEvent) {
        view.getParent().requestDisallowInterceptTouchEvent(view.getScrollY() != 0);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f41653e) {
            Context context = getContext();
            CustomerEditTextCompat customerEditTextCompat = this.f41649a;
            if (customerEditTextCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentEt");
                customerEditTextCompat = null;
            }
            KeyboardUtils.showSoftInput(context, customerEditTextCompat);
            this.f41653e = false;
        }
    }
}
