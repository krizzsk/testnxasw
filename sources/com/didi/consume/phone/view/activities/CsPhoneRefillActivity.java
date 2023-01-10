package com.didi.consume.phone.view.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.consume.base.CsBaseActivity;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsOperatorListResp;
import com.didi.consume.phone.view.fragments.CsMyFragmentsRouter;
import com.didi.consume.phone.view.fragments.CsPhoneAmountFragment;
import com.didi.consume.phone.view.fragments.CsPhoneNumberFragment;
import com.didi.consume.phone.view.fragments.CsPhoneOperatorFragment;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.event.PagePopupStack;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopupHistoryActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CsPhoneRefillActivity extends CsBaseActivity implements CsPhoneAmountFragment.OnFragmentAmountInteractionListener, CsPhoneNumberFragment.OnFragmentPhoneNumberInteractionListener, CsPhoneOperatorFragment.OnFragmentOperatorInteractionListener {

    /* renamed from: a */
    private String f18144a;

    /* renamed from: b */
    private String f18145b;

    /* renamed from: c */
    private int f18146c;

    /* renamed from: d */
    private String f18147d;

    /* renamed from: e */
    private TextView f18148e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f18149f;

    /* renamed from: g */
    private ImageView f18150g;

    /* renamed from: h */
    private View.OnClickListener f18151h;

    /* renamed from: i */
    private CsMyFragmentsRouter f18152i;

    /* renamed from: j */
    private boolean f18153j;

    public void onFragmentAmountInteraction() {
    }

    public static void launch(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(context, CsPhoneRefillActivity.class);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        this.f18146c = getIntent().getIntExtra("order_type", -1);
        this.f18147d = getIntent().getStringExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_EXT_METADATA);
        SystemUtils.log(3, "hgl_tag", "orderType = " + this.f18146c + " \nextMetadata = " + this.f18147d, (Throwable) null, "com.didi.consume.phone.view.activities.CsPhoneRefillActivity", 67);
        setContentView((int) R.layout.cs_activity_phone);
        m15360a();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.initProgressDialog(this, R.id.history_contacts_title_bar);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* renamed from: a */
    private void m15360a() {
        this.f18148e = (TextView) findViewById(R.id.tv_title);
        this.f18149f = (TextView) findViewById(R.id.tv_right);
        this.f18150g = (ImageView) findViewById(R.id.iv_left);
        m15362c();
        m15361b();
        CsMyFragmentsRouter csMyFragmentsRouter = new CsMyFragmentsRouter(this);
        this.f18152i = csMyFragmentsRouter;
        csMyFragmentsRouter.addPhoneNumberView();
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                Fragment findFragmentById = CsPhoneRefillActivity.this.getSupportFragmentManager().findFragmentById(R.id.fl_boleto_addr_patch_fragment_contrainer);
                if ((findFragmentById instanceof CsPhoneAmountFragment) || (findFragmentById instanceof CsPhoneOperatorFragment)) {
                    CsPhoneRefillActivity.this.f18149f.setVisibility(4);
                } else if (findFragmentById instanceof CsPhoneNumberFragment) {
                    CsPhoneRefillActivity.this.f18149f.setVisibility(0);
                } else {
                    SystemUtils.log(6, "consume", "Fragment source not handled", (Throwable) null, "com.didi.consume.phone.view.activities.CsPhoneRefillActivity$1", 104);
                }
            }
        });
    }

    /* renamed from: b */
    private void m15361b() {
        this.f18150g.setOnClickListener(this.f18151h);
        if (this.f18146c != 1) {
            this.f18149f.setText(getString(R.string.cs_phone_toolbar_txt_right));
            this.f18149f.setVisibility(0);
            this.f18149f.setOnClickListener(this.f18151h);
        }
    }

    /* renamed from: c */
    private void m15362c() {
        this.f18151h = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.iv_left) {
                    CsPhoneRefillActivity.this.onBackPressed();
                } else if (view.getId() == R.id.tv_right) {
                    CsOmegaUtils.trackPhoneBillHistoryBtnClicked("phonenumber");
                    WalletTopupHistoryActivity.startActivity((Context) CsPhoneRefillActivity.this, 605);
                }
            }
        };
    }

    public void onFragmentPhoneNumberInteraction(String str, String str2) {
        this.f18144a = str;
        this.f18145b = str2;
        this.f18152i.addOperatorListView(str, str2);
    }

    public void onFragmentOperatorInteraction(CsOperatorListResp.Operator operator) {
        this.f18152i.addAmountListView(this.f18144a, this.f18145b, operator.operatorId, this.f18146c, this.f18147d);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPopupStack(PagePopupStack pagePopupStack) {
        SystemUtils.log(3, "hgl_tag", "activity popup :" + getClass().getSimpleName(), (Throwable) null, "com.didi.consume.phone.view.activities.CsPhoneRefillActivity", 161);
        finish();
    }
}
