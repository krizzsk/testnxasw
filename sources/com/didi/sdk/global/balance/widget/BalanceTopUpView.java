package com.didi.sdk.global.balance.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.appsflyer.internal.referrer.Payload;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.balance.contract.GlobalBalanceAccountContract;
import com.didi.sdk.global.balance.model.BalanceDataConverter;
import com.didi.sdk.global.balance.model.bean.BalanceAccount;
import com.didi.sdk.global.balance.model.bean.BalancePageResponse;
import com.didi.sdk.global.balance.model.bean.TopUpMethodDetail;
import com.didi.sdk.global.balance.widget.TopUpMethodCardView;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.taxis99.R;

@Deprecated
public class BalanceTopUpView extends LinearLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    private static final String f38794a = "Balance";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f38795b;

    /* renamed from: c */
    private int f38796c;

    /* renamed from: d */
    private BalancePageResponse f38797d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GlobalBalanceAccountContract.Presenter f38798e;

    /* renamed from: f */
    private LinearLayout f38799f;

    /* renamed from: g */
    private LinearLayout f38800g;

    /* renamed from: h */
    private TopUpMethodCardView f38801h;

    /* renamed from: i */
    private TextView f38802i;

    /* renamed from: j */
    private TextView f38803j;

    /* renamed from: k */
    private TextView f38804k;

    /* renamed from: l */
    private Button f38805l;

    /* renamed from: m */
    private final boolean f38806m = false;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public BalanceTopUpView(Context context) {
        super(context);
        m29215a();
        m29216a(context);
    }

    public BalanceTopUpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29215a();
        m29216a(context);
    }

    public BalanceTopUpView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29215a();
        m29216a(context);
    }

    /* renamed from: a */
    private void m29215a() {
        this.f38796c = 0;
    }

    public void setPresenter(GlobalBalanceAccountContract.Presenter presenter) {
        this.f38798e = presenter;
    }

    public void refreshData(BalancePageResponse balancePageResponse) {
        this.f38797d = balancePageResponse;
        m29219b();
    }

    /* renamed from: a */
    private void m29216a(Context context) {
        this.f38795b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_balance_topup_view, this, true);
        this.f38799f = (LinearLayout) inflate.findViewById(R.id.ll_topup_content);
        this.f38800g = (LinearLayout) inflate.findViewById(R.id.ll_topup_empty);
        this.f38799f.setVisibility(8);
        this.f38803j = (TextView) inflate.findViewById(R.id.tv_select_topup_method_title);
        this.f38801h = (TopUpMethodCardView) inflate.findViewById(R.id.cv_default_topup_method);
        this.f38802i = (TextView) inflate.findViewById(R.id.tv_topup_legal_terms);
        this.f38805l = (Button) inflate.findViewById(R.id.btn_topup);
        this.f38804k = (TextView) inflate.findViewById(R.id.tv_balance_disabled);
    }

    /* renamed from: b */
    private void m29219b() {
        BalanceAccount balanceAccount = this.f38797d.data.allEntries.get(this.f38796c);
        if (balanceAccount.isActive.booleanValue()) {
            this.f38799f.setVisibility(0);
            this.f38800g.setVisibility(8);
            m29217a(balanceAccount);
            return;
        }
        this.f38799f.setVisibility(8);
        this.f38800g.setVisibility(0);
        m29220b(balanceAccount);
    }

    /* renamed from: a */
    private void m29217a(BalanceAccount balanceAccount) {
        final TopUpMethodDetail topUpMethodDetail = balanceAccount.topUpMethodDetail;
        this.f38801h.setPayMethodItemInfo(BalanceDataConverter.convertToPayMethodItemInfo(topUpMethodDetail));
        this.f38801h.setEnabled(true);
        boolean z = topUpMethodDetail.hasMoreTopUpMethod;
        this.f38801h.setSelectStyle(TopUpMethodCardView.STYLE.CHECK);
        this.f38801h.setIsSelected(true);
        this.f38801h.setOnClickListener((View.OnClickListener) null);
        if (!TextUtils.isEmpty(topUpMethodDetail.title)) {
            this.f38803j.setText(topUpMethodDetail.title);
        }
        if (!TextUtils.isEmpty(topUpMethodDetail.legalTermsTitle)) {
            this.f38802i.setText(topUpMethodDetail.legalTermsTitle);
        }
        if (!TextUtils.isEmpty(topUpMethodDetail.topUpDesc)) {
            this.f38805l.setText(topUpMethodDetail.topUpDesc);
        }
        this.f38802i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (BalanceTopUpView.this.f38798e != null) {
                    BalanceTopUpView.this.f38798e.jumpToLegalTermsActivity(topUpMethodDetail.legalTermsUrl, topUpMethodDetail.channelId);
                } else {
                    SystemUtils.log(6, "Balance", "presenter is null", (Throwable) null, "com.didi.sdk.global.balance.widget.BalanceTopUpView$1", 156);
                }
            }
        });
        this.f38805l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (BalanceTopUpView.this.f38798e != null) {
                    BalanceTopUpView.this.f38798e.jumpToTopUpPage(topUpMethodDetail.topUpUrl, topUpMethodDetail.channelId, 0);
                } else {
                    SystemUtils.log(6, "Balance", "presenter is null", (Throwable) null, "com.didi.sdk.global.balance.widget.BalanceTopUpView$2", 168);
                }
                GlobalOmegaUtils.trackBalanceDetailPageTopUpCK(BalanceTopUpView.this.f38795b);
            }
        });
    }

    /* renamed from: b */
    private void m29220b(BalanceAccount balanceAccount) {
        this.f38804k.setText(balanceAccount.message);
    }

    /* renamed from: c */
    private void m29221c() {
        this.f38801h.setSelectStyle(TopUpMethodCardView.STYLE.CLICK);
        this.f38801h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AlertDialog.Builder builder = new AlertDialog.Builder(BalanceTopUpView.this.f38795b);
                builder.setMessage("Not Implemented Yet").setPositiveButton(Payload.RESPONSE_OK, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                        dialogInterface.dismiss();
                    }
                });
                SystemUtils.showDialog(builder.create());
            }
        });
    }

    public void onPageSelected(int i) {
        this.f38796c = i;
        m29219b();
    }
}
