package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.flutter.FlutterConstant;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter.ListItem;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.MyFragmentsRouter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressFragment;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressListFragment;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoZipCodeFragment;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class WalletBoletoPatchAddressActivity extends WalletBaseActivity implements WalletBoletoAddressFragment.OnFragmentAddressInteractionListener, WalletBoletoAddressListFragment.OnListFragmentInteractionListener, WalletBoletoZipCodeFragment.OnFragmentZipCodeInteractionListener {

    /* renamed from: a */
    RelativeLayout f34411a;

    /* renamed from: b */
    ImageView f34412b;

    /* renamed from: c */
    private MyFragmentsRouter f34413c;

    /* renamed from: d */
    private WalletTopUpChannelResp.ChannelBean f34414d = null;

    public static void launch(Context context, WalletTopUpChannelResp.ChannelBean channelBean) {
        Intent intent = new Intent(context, WalletBoletoPatchAddressActivity.class);
        intent.putExtra("ChannelBean", channelBean);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_boleto_cashin_patch_address);
        m26257a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initLoadingDialog(this, R.id.wallet_boleto_addr_patch_title_bar);
    }

    /* renamed from: a */
    private void m26257a() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wallet_boleto_addr_patch_title_bar);
        this.f34411a = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.iv_left);
        this.f34412b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoPatchAddressActivity.this.onBackPressed();
            }
        });
        MyFragmentsRouter myFragmentsRouter = new MyFragmentsRouter(this);
        this.f34413c = myFragmentsRouter;
        myFragmentsRouter.addZipCodeView();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f34414d = (WalletTopUpChannelResp.ChannelBean) extras.getSerializable("ChannelBean");
        }
    }

    public void onFragmentZipCodeInteraction(AddressFromZipCodeResp.DataBean dataBean) {
        this.f34413c.addAddressManuallyView(dataBean);
    }

    public void onFragmentPatchSuccessInteraction() {
        String string = getIntent().getExtras().getString("amount");
        if (!WalletApolloUtil.getTopUpIsNew() || string == null) {
            WalletRouter.gotoBoletoCashinPage(this, this.f34414d);
        } else {
            FlutterConstant.route("/wallet_topup_boleto?amount=" + string, getContext());
        }
        finish();
    }

    public void onFragmentRequestStateInteraction(ListFragmentExtraState listFragmentExtraState, WalletBoletoAddressFragment walletBoletoAddressFragment) {
        this.f34413c.showListFragmentForState(listFragmentExtraState, walletBoletoAddressFragment);
    }

    public void onFragmentRequestCityInteraction(ListFragmentExtraCity listFragmentExtraCity, WalletBoletoAddressFragment walletBoletoAddressFragment) {
        this.f34413c.showListFragmentForCity(listFragmentExtraCity, walletBoletoAddressFragment);
    }

    public void onListFragmentStateInteraction(ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment) {
        this.f34413c.backtoAddressPatchFromStatePage(this, listItem, walletBoletoAddressListFragment);
        m26258b();
    }

    public void onListFragmentCityInteraction(ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment) {
        this.f34413c.backtoAddressPatchFromCityPage(this, listItem, walletBoletoAddressListFragment);
        m26258b();
    }

    /* renamed from: b */
    private void m26258b() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}
