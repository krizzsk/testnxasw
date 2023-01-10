package com.didi.entrega.home.policy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.storage.AppConfigStorage;
import com.didi.entrega.customer.foundation.storage.model.AppConfig;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.SingletonFactory;
import com.didi.entrega.customer.p114h5.CustomerH5UrlConst;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IOneSdkService;
import com.didi.entrega.home.manager.HomeOmegaHelper;
import com.didi.entrega.router.DiRouter;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.taxis99.R;

public class HomePolicyHelper {
    public static final int LAW_STYLE_CHECKBOX = 2;
    public static final int LAW_STYLE_DIALOG = 1;

    /* renamed from: a */
    private static final String f22576a = HomePolicyHelper.class.getSimpleName();

    /* renamed from: b */
    private final DialogInstrument f22577b;

    /* renamed from: c */
    private boolean f22578c = false;

    /* renamed from: d */
    private boolean f22579d;

    public HomePolicyHelper(DialogInstrument dialogInstrument) {
        this.f22577b = dialogInstrument;
        this.f22579d = CustomerApolloUtil.isOpenLawDialogSwitch();
    }

    public void showFirstPolicyDialog() {
        if (getLawShowStyle() == 1) {
            m18574a();
        }
    }

    public int getLawShowStyle() {
        if (((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mHomePolicyAccepted || !this.f22579d) {
            return 0;
        }
        if (CustomerApolloUtil.lawStyle() != 0) {
            return CustomerApolloUtil.lawStyle();
        }
        return 2;
    }

    public void savePolicyAcceptedState() {
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        AppConfig data = appConfigStorage.getData();
        if (!data.mHomePolicyAccepted) {
            data.mHomePolicyAccepted = true;
            appConfigStorage.setData(data);
        }
    }

    /* renamed from: a */
    private void m18574a() {
        if (this.f22577b != null) {
            View inflate = LayoutInflater.from(GlobalContext.getContext()).inflate(R.layout.entrega_customer_item_law_check, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.customer_tv_law_item_link);
            textView.setText(ResourceHelper.getString(R.string.FoodC_home_Terms_of_ZXoU));
            String string = ResourceHelper.getString(R.string.entrega_app_name);
            ((TextView) inflate.findViewById(R.id.customer_tv_law_item_desc)).setText(ResourceHelper.getString(R.string.FoodC_home_Before_you_DXNv, string, string));
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    HomePolicyHelper.this.m18575a(view);
                }
            });
            $$Lambda$HomePolicyHelper$kNAM3TIlIdrTI4sSvXxzQZraC6U r8 = new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    HomePolicyHelper.this.m18578b(rFDialog);
                }
            };
            $$Lambda$HomePolicyHelper$ZBzUTpTg1qcfUSbLUJXCmp1v38 r9 = $$Lambda$HomePolicyHelper$ZBzUTpTg1qcfUSbLUJXCmp1v38.INSTANCE;
            if (!this.f22578c) {
                DialogUtil.showCheckLawDialog(this.f22577b, f22576a, R.string.FoodC_home_Terms_of_ZXoU, inflate, r8, r9);
                this.f22578c = true;
                HomeOmegaHelper.Companion.trackLegalSW();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18575a(View view) {
        m18577b();
        HomeOmegaHelper.Companion.trackLegalCK(22);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18578b(RFDialog rFDialog) {
        rFDialog.dismiss();
        this.f22578c = false;
        HomeOmegaHelper.Companion.trackLegalCK(21);
        savePolicyAcceptedState();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18576a(RFDialog rFDialog) {
        HomeOmegaHelper.Companion.trackLegalCK(29);
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).popBack(GlobalContext.isSuperApp());
    }

    /* renamed from: b */
    private void m18577b() {
        DiRouter.request().path("webPage").putString("url", CustomerH5UrlConst.getLawUrl()).open();
    }
}
