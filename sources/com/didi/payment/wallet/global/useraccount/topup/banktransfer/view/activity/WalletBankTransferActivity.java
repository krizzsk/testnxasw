package com.didi.payment.wallet.global.useraccount.topup.banktransfer.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.onekeyshare.ShareConfig;
import com.didi.onekeyshare.ShareFragmentListener;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.FileUtil;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.p130ui.helper.NViewHelper;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;
import com.didi.payment.commonsdk.utils.NCommonShareManager;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.banktransfer.contract.WalletBankTransferContract;
import com.didi.payment.wallet.global.useraccount.topup.banktransfer.presenter.WalletBankTransferPresenter;
import com.didi.payment.wallet.global.utils.TextViewUtils;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletTopUpOmegaUtil;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import com.taxis99.R;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.UUID;

public class WalletBankTransferActivity extends WalletBaseActivity implements WalletBankTransferContract.View {
    public static final String KEY_BANK_TRANSFER_INFO = "key_bank_transfer_info";

    /* renamed from: a */
    WalletTopUpChannelResp.ExtraDataBrazilBankTransfer f34378a;

    /* renamed from: b */
    WalletBankTransferContract.Presenter f34379b;

    /* renamed from: c */
    Bitmap f34380c;

    /* renamed from: d */
    private RelativeLayout f34381d;

    /* renamed from: e */
    private ImageView f34382e;

    /* renamed from: f */
    private TextView f34383f;

    /* renamed from: g */
    private TextView f34384g;

    /* renamed from: h */
    private TextView f34385h;

    /* renamed from: i */
    private TextView f34386i;

    /* renamed from: j */
    private TextView f34387j;

    /* renamed from: k */
    private TextView f34388k;

    /* renamed from: l */
    private TextView f34389l;

    public void onNetworkError() {
    }

    public static void launch(Context context, WalletTopUpChannelResp.ExtraDataBrazilBankTransfer extraDataBrazilBankTransfer) {
        Intent intent = new Intent(context, WalletBankTransferActivity.class);
        intent.putExtra(KEY_BANK_TRANSFER_INFO, extraDataBrazilBankTransfer);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_bank_transfer);
        m26240a((Activity) this);
        m26238a();
        this.f34379b = new WalletBankTransferPresenter(this, this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("data");
            if (string != null) {
                try {
                    this.f34378a = (WalletTopUpChannelResp.ExtraDataBrazilBankTransfer) new Gson().fromJson(URLDecoder.decode(string, "UTF-8"), WalletTopUpChannelResp.ExtraDataBrazilBankTransfer.class);
                    this.f34379b.requestData();
                } catch (Exception unused) {
                }
            } else {
                WalletTopUpChannelResp.ExtraDataBrazilBankTransfer extraDataBrazilBankTransfer = (WalletTopUpChannelResp.ExtraDataBrazilBankTransfer) extras.getSerializable(KEY_BANK_TRANSFER_INFO);
                this.f34378a = extraDataBrazilBankTransfer;
                if (extraDataBrazilBankTransfer == null) {
                    this.f34379b.requestData();
                    return;
                }
            }
            refreshUI(this.f34378a);
        }
        GlobalOmegaUtils.trackBankTransferPageSW();
    }

    /* renamed from: a */
    private void m26240a(final Activity activity) {
        LoadingProxyHolder.setProxy(new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                PayGlobalLoading.show(activity, (int) R.id.wallet_bank_transfer_title_bar, true);
            }

            public void dismissLoading() {
                PayGlobalLoading.hide();
            }
        });
    }

    /* renamed from: a */
    private void m26238a() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wallet_bank_transfer_title_bar);
        this.f34381d = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.iv_left);
        this.f34382e = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBankTransferActivity.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.tv_top_up_bank_transfer_name_content);
        this.f34383f = textView;
        m26239a(R.id.btn_copy1, textView, "name");
        TextView textView2 = (TextView) findViewById(R.id.et_topup_boleto_street_content);
        this.f34384g = textView2;
        m26239a(R.id.btn_copy2, textView2, "bank");
        TextView textView3 = (TextView) findViewById(R.id.et_topup_boleto_name_content);
        this.f34385h = textView3;
        m26239a(R.id.btn_copy3, textView3, "bank");
        TextView textView4 = (TextView) findViewById(R.id.et_topup_acount_type_content);
        this.f34389l = textView4;
        m26239a(R.id.btn_copy4, textView4, "bank_type");
        TextView textView5 = (TextView) findViewById(R.id.et_topup_boleto_number_content);
        this.f34386i = textView5;
        m26239a(R.id.btn_copy5, textView5, "agencia");
        TextView textView6 = (TextView) findViewById(R.id.et_topup_boleto_complement_content);
        this.f34387j = textView6;
        m26239a(R.id.btn_copy6, textView6, "account");
        this.f34388k = (TextView) findViewById(R.id.btn_verify_tip);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_right);
        imageView2.setImageResource(R.drawable.w_common_icon_share);
        imageView2.setVisibility(0);
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put("pub_page", "wallettopupbank");
                hashMap.put("button_position", "bank_transfer");
                WalletTopUpOmegaUtil.Companion.trackEvent("fin_wallettopup_share_ck", hashMap);
                WalletBankTransferActivity.this.m26242b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26242b() {
        this.f34381d.setVisibility(8);
        this.f34380c = NViewHelper.Companion.genBitmap(this, findViewById(R.id.tl_walletBankTransfer), true);
        final String saveFile = FileUtil.saveFile(this, this.f34380c, UUID.randomUUID().toString() + "_share_pic.png", true);
        NCommonShareManager.showCommonShareWindow(this, "", "WEB_99_DOWN_PAGE", saveFile, new NCommonShareManager.CommonShareCallback() {
            public void onComplete(SharePlatform sharePlatform) {
                WalletBankTransferActivity.this.m26244c();
            }

            public void onError(SharePlatform sharePlatform) {
                WalletBankTransferActivity.this.m26244c();
            }

            public void onCancel(SharePlatform sharePlatform) {
                WalletBankTransferActivity.this.m26244c();
                FileUtil.deleteFile(saveFile);
            }
        });
        ShareConfig.getConfig().addFragmentListener(new ShareFragmentListener() {
            public void onShow(FragmentActivity fragmentActivity) {
            }

            public void onDismiss(FragmentActivity fragmentActivity) {
                WalletBankTransferActivity.this.m26244c();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26244c() {
        if (!this.f34380c.isRecycled()) {
            this.f34380c.recycle();
        }
        this.f34381d.setVisibility(0);
    }

    /* renamed from: a */
    private void m26239a(int i, final TextView textView, final String str) {
        findViewById(i).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put("pub_page", "wallettopupbank");
                hashMap.put("button_name", str);
                WalletTopUpOmegaUtil.Companion.trackEvent("fin_wallettopupbank_copy_ck", hashMap);
                NClipBoardUtil.Companion.setClipboard(WalletBankTransferActivity.this.getContext(), textView.getText().toString());
                WalletToastNew.showSuccessMsg(WalletBankTransferActivity.this.getContext(), WalletBankTransferActivity.this.getResources().getString(R.string.Fintech_Payment_all_Copy_CfnP));
            }
        });
    }

    public void refreshUI(final WalletTopUpChannelResp.ExtraDataBrazilBankTransfer extraDataBrazilBankTransfer) {
        this.f34383f.setText(extraDataBrazilBankTransfer.holderName);
        this.f34384g.setText(extraDataBrazilBankTransfer.bankCode);
        this.f34385h.setText(extraDataBrazilBankTransfer.bankName);
        this.f34386i.setText(extraDataBrazilBankTransfer.agencyCode);
        this.f34387j.setText(extraDataBrazilBankTransfer.accountNumber);
        this.f34389l.setText(extraDataBrazilBankTransfer.accountType);
        if (!TextUtils.isEmpty(extraDataBrazilBankTransfer.amountRuleText)) {
            TextViewUtils.appendDrawableLast(this.f34388k, extraDataBrazilBankTransfer.amountRuleText, R.drawable.wallet_right_arrow_orange);
            this.f34388k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebBrowserUtil.startInternalWebActivity(WalletBankTransferActivity.this.getContext(), extraDataBrazilBankTransfer.link, "");
                    FinOmegaSDK.trackEvent("ibt_didipay_recharge_bt_verify_ck");
                }
            });
            return;
        }
        this.f34388k.setVisibility(8);
    }
}
