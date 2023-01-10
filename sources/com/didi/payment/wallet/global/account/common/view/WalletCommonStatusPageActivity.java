package com.didi.payment.wallet.global.account.common.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.wallet.global.account.common.model.WalletCommonPageModel;
import com.didi.payment.wallet.global.model.event.WalletSignUpSuccessEvent;
import com.didi.payment.wallet.global.utils.TextViewUtils;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class WalletCommonStatusPageActivity extends WalletBaseActivity {

    /* renamed from: a */
    private static final String f34263a = "common_page_data";

    /* renamed from: b */
    private TextView f34264b;

    /* renamed from: c */
    private TextView f34265c;

    /* renamed from: d */
    private TextView f34266d;

    /* renamed from: e */
    private TextView f34267e;

    /* renamed from: f */
    private ImageView f34268f;

    /* renamed from: g */
    private View f34269g;

    /* renamed from: h */
    private LinearLayout f34270h;

    /* renamed from: i */
    private WalletCommonPageModel f34271i;

    public static void startActivity(Context context, WalletCommonPageModel walletCommonPageModel) {
        Intent intent = new Intent(context, WalletCommonStatusPageActivity.class);
        intent.putExtra(f34263a, walletCommonPageModel);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_common_status_page_activity);
        m26175c();
        m26171a();
        m26174b();
        m26176d();
        m26178f();
    }

    /* renamed from: a */
    private void m26171a() {
        this.f34264b = (TextView) findViewById(R.id.wallet_common_page_main_title_tv);
        this.f34265c = (TextView) findViewById(R.id.wallet_common_page_sub_title_tv);
        this.f34266d = (TextView) findViewById(R.id.wallet_common_page_bottom_btn);
        this.f34269g = findViewById(R.id.wallet_common_page_back_btn);
        this.f34267e = (TextView) findViewById(R.id.wallet_common_page_comment_tv);
        this.f34268f = (ImageView) findViewById(R.id.wallet_common_page_big_iv);
        this.f34270h = (LinearLayout) findViewById(R.id.wallet_common_page_wallet_container);
    }

    /* renamed from: b */
    private void m26174b() {
        C119171 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.wallet_common_page_back_btn) {
                    WalletCommonStatusPageActivity.this.onBackPressed();
                } else if (view.getId() == R.id.wallet_common_page_bottom_btn) {
                    WalletCommonStatusPageActivity.this.m26180h();
                }
            }
        };
        this.f34269g.setOnClickListener(r0);
        this.f34266d.setOnClickListener(r0);
    }

    /* renamed from: c */
    private void m26175c() {
        this.f34271i = (WalletCommonPageModel) getIntent().getSerializableExtra(f34263a);
    }

    /* renamed from: d */
    private void m26176d() {
        if (this.f34271i != null) {
            m26177e();
            this.f34268f.setImageResource(this.f34271i.topImageId);
            this.f34266d.setText(this.f34271i.buttonText);
            if (this.f34271i.accountStatus != null) {
                TextViewUtils.setText(this.f34264b, this.f34271i.accountStatus.title);
                TextViewUtils.setText(this.f34265c, this.f34271i.accountStatus.subTitle);
                TextViewUtils.setText(this.f34267e, this.f34271i.accountStatus.comment);
                m26173a(this.f34271i.accountStatus.entries);
            }
            if (this.f34271i.targetPage == 3) {
                this.f34269g.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    private void m26173a(List<IWalletService.WalletFunction> list) {
        if (list != null && list.size() != 0) {
            for (IWalletService.WalletFunction next : list) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.wallet_common_page_list_item, this.f34270h, false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = UIUtil.dip2px(this, 15.0f);
                this.f34270h.addView(linearLayout, layoutParams);
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.wallet_list_item_iv);
                TextView textView = (TextView) linearLayout.findViewById(R.id.wallet_list_item_tv);
                if (next.iconUrl != null) {
                    GlideUtils.with2load2into(this, next.iconUrl, imageView);
                }
                textView.setText(next.desc);
            }
        }
    }

    /* renamed from: e */
    private void m26177e() {
        WalletCommonPageModel walletCommonPageModel = this.f34271i;
        if (walletCommonPageModel != null) {
            int i = walletCommonPageModel.targetPage;
            if (i == 1) {
                this.f34271i.buttonText = getString(R.string.wallet_common_page_btn_verify_now);
                this.f34271i.topImageId = R.drawable.wallet_common_png_intro;
            } else if (i == 2) {
                if (this.f34271i.accountStatus == null || !this.f34271i.accountStatus.isAllowFullKyc) {
                    this.f34271i.buttonText = getString(R.string.wallet_common_page_btn_ok);
                } else {
                    this.f34271i.buttonText = getString(R.string.GRider_Optimization_Continue_NgOT);
                }
                this.f34271i.topImageId = R.drawable.wallet_common_png_on_check;
            } else if (i == 3) {
                this.f34271i.buttonText = getString(R.string.wallet_common_page_btn_get_start);
                this.f34271i.topImageId = R.drawable.wallet_common_png_create_success;
            } else if (i == 4) {
                this.f34271i.buttonText = getString(R.string.wallet_common_page_btn_try_again);
                this.f34271i.topImageId = R.drawable.wallet_common_png_create_failed;
            }
        }
    }

    /* renamed from: f */
    private void m26178f() {
        WalletCommonPageModel walletCommonPageModel = this.f34271i;
        if (walletCommonPageModel != null) {
            String str = null;
            int i = walletCommonPageModel.targetPage;
            if (i == 1) {
                str = "gp_99pay_newlearn_view_sw";
            } else if (i == 2) {
                str = "gp_99pay_examine_vew_sw";
            } else if (i == 3) {
                str = "gp_99pay_application_success_sw";
            } else if (i == 4) {
                str = "gp_99pay_application_fail_sw";
            }
            if (str != null) {
                FinOmegaSDK.trackEvent(str);
            }
        }
    }

    /* renamed from: g */
    private void m26179g() {
        WalletCommonPageModel walletCommonPageModel = this.f34271i;
        if (walletCommonPageModel != null) {
            String str = null;
            int i = walletCommonPageModel.targetPage;
            if (i == 1) {
                str = "gp_99pay_newlearn_confirm_ck";
            } else if (i == 4) {
                str = "gp_99pay_application_fail_again_ck";
            }
            if (str != null) {
                FinOmegaSDK.trackEvent(str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m26180h() {
        m26179g();
        int i = this.f34271i.targetPage;
        if (i == 1) {
            m26181i();
        } else if (i != 2) {
            if (i == 3) {
                m26182j();
            } else if (i == 4) {
                m26181i();
            }
        } else if (this.f34271i.accountStatus == null || !this.f34271i.accountStatus.isAllowFullKyc) {
            m26183k();
        } else {
            m26184l();
        }
    }

    /* renamed from: i */
    private void m26181i() {
        WalletRouter.gotoApplyAccountPage(this);
        finish();
    }

    /* renamed from: j */
    private void m26182j() {
        EventBus.getDefault().post(new WalletSignUpSuccessEvent());
        finish();
    }

    /* renamed from: k */
    private void m26183k() {
        EventBus.getDefault().post(new WalletRefreshDataEvent());
        finish();
    }

    /* renamed from: l */
    private void m26184l() {
        WalletRouter.gotoFullKycRegisterPage(this, 0);
        finish();
    }
}
