package com.didi.payment.pix.transfer.fragment;

import android.view.View;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/pix/transfer/fragment/PixTransferAmountEditFragment$initViewModels$4$1$2", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
public final class PixTransferAmountEditFragment$initViewModels$4$1$2 extends DoubleCheckOnClickListener {
    final /* synthetic */ Ref.ObjectRef<WalletDialog> $dialog;
    final /* synthetic */ Map<String, String> $map;
    final /* synthetic */ PasswordDataVo $vo;
    final /* synthetic */ PixTransferAmountEditFragment this$0;

    PixTransferAmountEditFragment$initViewModels$4$1$2(Map<String, String> map, Ref.ObjectRef<WalletDialog> objectRef, PixTransferAmountEditFragment pixTransferAmountEditFragment, PasswordDataVo passwordDataVo) {
        this.$map = map;
        this.$dialog = objectRef;
        this.this$0 = pixTransferAmountEditFragment;
        this.$vo = passwordDataVo;
    }

    public void doClick(View view) {
        this.$map.put("pub_button", "yes");
        FinOmegaSDK.trackEvent("ibt_password_paying_bottom_popoup_yes_ck", MapsKt.toMap(this.$map));
        OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
        if (openCertificationListener != null) {
            PaySecure.INSTANCE.createPayPassword(PasswordScene.PIX_IN.name(), openCertificationListener, new PixTransferAmountEditFragment$initViewModels$4$1$2$doClick$1(this.this$0, this.$vo));
        }
        WalletDialog walletDialog = (WalletDialog) this.$dialog.element;
        if (walletDialog != null) {
            walletDialog.dismiss();
        }
    }
}
