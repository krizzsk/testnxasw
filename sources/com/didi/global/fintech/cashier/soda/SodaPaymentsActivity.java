package com.didi.global.fintech.cashier.soda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBasePresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierRandomVerifyActionCallBack;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.soda.contract.ISodaCashierCallback;
import com.didi.global.fintech.cashier.soda.contract.ISodaPaymentsPresenter;
import com.didi.global.fintech.cashier.soda.contract.ISodaPaymentsView;
import com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter;
import com.didi.global.fintech.cashier.soda.view.SodaPaymentsView;
import com.didi.global.fintech.cashier.user.model.GPayMethodItem;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0001)B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J4\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020$H\u0007J\u001a\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010(\u001a\u00020\u000bH\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/SodaPaymentsActivity;", "Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaPaymentsPresenter;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaPaymentsView;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaCashierCallback;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierRandomVerifyActionCallBack;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "()V", "mCurCashierAction", "", "finish", "", "getPresenter", "getView", "layoutRes", "", "onActionInterceptJumpThirdPage", "action", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCallStartActivity", "intent", "onCallStartActivityForResult", "onCashierClose", "isClickConfirmBtn", "", "isChanged", "selectedItems", "Ljava/util/ArrayList;", "Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem;", "Lkotlin/collections/ArrayList;", "onEvent", "Lcom/didi/payment/base/event/WalletRefreshDataEvent;", "onRandomVerifyResult", "code", "msg", "onResume", "Companion", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPaymentsActivity.kt */
public class SodaPaymentsActivity extends BaseCashierActivity<ISodaPaymentsPresenter, ISodaPaymentsView> implements IGlobalCashierActionInterceptCallback, IGlobalCashierRandomVerifyActionCallBack, ISodaCashierCallback {
    public static final String ARGS_IS_CHANGE = "isChanged";
    public static final String ARGS_IS_CONFIRM = "isClickConfirmBtn";
    public static final String ARGS_SELECTED_ITEMS = "selectedItems";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f23535a;

    public int layoutRes() {
        return R.layout.activity_soda_payments;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/SodaPaymentsActivity$Companion;", "", "()V", "ARGS_IS_CHANGE", "", "ARGS_IS_CONFIRM", "ARGS_SELECTED_ITEMS", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SodaPaymentsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.drawer_bottom_out);
    }

    public ISodaPaymentsPresenter getPresenter() {
        return new SodaPaymentsPresenter(this, this, getMUniqueId(), this, this);
    }

    public ISodaPaymentsView getView() {
        View findViewById = findViewById(R.id.activity_soda_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.activity_soda_root_view)");
        return new SodaPaymentsView(this, (ViewGroup) findViewById);
    }

    public void onCashierClose(boolean z, boolean z2, ArrayList<GPayMethodItem> arrayList) {
        ISodaPaymentsPresenter iSodaPaymentsPresenter = (ISodaPaymentsPresenter) getMPresenter();
        if (iSodaPaymentsPresenter != null) {
            iSodaPaymentsPresenter.unBind();
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ARGS_IS_CONFIRM, z);
        bundle.putBoolean(ARGS_IS_CHANGE, z2);
        bundle.putSerializable(ARGS_SELECTED_ITEMS, arrayList);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public void onCallStartActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public void onCallStartActivity(Intent intent) {
        startActivity(intent);
    }

    public void onBackPressed() {
        ISodaPaymentsPresenter iSodaPaymentsPresenter = (ISodaPaymentsPresenter) getMPresenter();
        if (iSodaPaymentsPresenter != null) {
            iSodaPaymentsPresenter.onBackClicked();
        }
    }

    public void onActionInterceptJumpThirdPage(String str) {
        this.f23535a = str;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (Intrinsics.areEqual((Object) this.f23535a, (Object) CashierAction.ACTION_TOP_UP)) {
            this.f23535a = null;
            onTopUp();
        }
    }

    public void onRandomVerifyResult(int i, String str) {
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierRandomVerifyActionCallBack iGlobalCashierRandomVerifyActionCallBack = mPresenter instanceof IGlobalCashierRandomVerifyActionCallBack ? (IGlobalCashierRandomVerifyActionCallBack) mPresenter : null;
        if (iGlobalCashierRandomVerifyActionCallBack != null) {
            iGlobalCashierRandomVerifyActionCallBack.onRandomVerifyResult(i, str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = -1
            if (r6 == r0) goto L_0x0007
            super.onActivityResult(r5, r6, r7)
            return
        L_0x0007:
            r0 = 1
            java.lang.String r1 = "card_index"
            r2 = 0
            if (r5 == r0) goto L_0x0055
            r3 = 2
            if (r5 == r3) goto L_0x004a
            r3 = 6
            if (r5 == r3) goto L_0x0046
            r3 = 8
            if (r5 == r3) goto L_0x0042
            r3 = 10
            if (r5 == r3) goto L_0x0042
            r3 = 300(0x12c, float:4.2E-43)
            if (r5 == r3) goto L_0x0020
            goto L_0x005f
        L_0x0020:
            if (r7 != 0) goto L_0x0024
            r1 = r2
            goto L_0x0028
        L_0x0024:
            java.lang.String r1 = r7.getStringExtra(r1)
        L_0x0028:
            if (r7 != 0) goto L_0x002b
            goto L_0x0035
        L_0x002b:
            java.lang.String r2 = "installment_number"
            int r0 = r7.getIntExtra(r2, r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
        L_0x0035:
            com.didi.global.fintech.cashier.core.contract.IGlobalCashierBasePresenter r0 = r4.getMPresenter()
            com.didi.global.fintech.cashier.soda.contract.ISodaPaymentsPresenter r0 = (com.didi.global.fintech.cashier.soda.contract.ISodaPaymentsPresenter) r0
            if (r0 != 0) goto L_0x003e
            goto L_0x005f
        L_0x003e:
            r0.onInstallmentClick(r1, r2)
            goto L_0x005f
        L_0x0042:
            r4.onTopUp()
            goto L_0x005f
        L_0x0046:
            r4.onCardVerify(r2)
            goto L_0x005f
        L_0x004a:
            if (r7 != 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            java.lang.String r2 = r7.getStringExtra(r1)
        L_0x0051:
            r4.onCardVerify(r2)
            goto L_0x005f
        L_0x0055:
            if (r7 != 0) goto L_0x0058
            goto L_0x005c
        L_0x0058:
            java.lang.String r2 = r7.getStringExtra(r1)
        L_0x005c:
            r4.onCardBind(r2)
        L_0x005f:
            super.onActivityResult(r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.soda.SodaPaymentsActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Subscribe
    public final void onEvent(WalletRefreshDataEvent walletRefreshDataEvent) {
        Intrinsics.checkNotNullParameter(walletRefreshDataEvent, "data");
        onCardVerify((String) null);
    }
}
