package com.didi.payment.wallet.global.wallet.view.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.onehybrid.container.FusionWebChromeClient;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.FusionWebViewClient;
import com.didi.payment.base.web.WebViewModel;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class TermsAndConditionsDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private TextView f35382a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f35383b;

    /* renamed from: c */
    private ImageView f35384c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DialogBtnClickListener f35385d;

    /* renamed from: e */
    private LinearLayout f35386e;

    /* renamed from: f */
    private FusionWebView f35387f;

    /* renamed from: g */
    private Context f35388g;

    /* renamed from: h */
    private String f35389h;
    protected WebViewModel mWebViewModel;

    public interface DialogBtnClickListener {
        void onClicked(TextView textView);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.wallet_global_dialog_terms_and_conditions;
    }

    public TermsAndConditionsDialogFragment(String str, DialogBtnClickListener dialogBtnClickListener) {
        this.f35389h = str;
        this.f35385d = dialogBtnClickListener;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f35388g = getContext();
        this.f35382a = (TextView) this.mRootView.findViewById(R.id.dialog_title);
        this.f35384c = (ImageView) this.mRootView.findViewById(R.id.btn_closeImg);
        this.f35383b = (TextView) this.mRootView.findViewById(R.id.btn_agree);
        this.f35386e = (LinearLayout) this.mRootView.findViewById(R.id.web_view_container);
        FusionWebView fusionWebView = new FusionWebView(this.f35388g);
        this.f35387f = fusionWebView;
        this.f35386e.addView(fusionWebView);
        this.f35383b.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TermsAndConditionsDialogFragment.this.dismiss();
                TermsAndConditionsDialogFragment.this.f35385d.onClicked(TermsAndConditionsDialogFragment.this.f35383b);
            }
        });
        this.f35384c.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TermsAndConditionsDialogFragment.this.dismiss();
            }
        });
        String str = this.f35389h;
        if (str != null && !str.isEmpty()) {
            this.f35382a.setText(this.f35389h);
        }
        m26856a();
    }

    public void setData(String str) {
        WebViewModel webViewModel = new WebViewModel();
        this.mWebViewModel = webViewModel;
        if (str != null) {
            webViewModel.url = str;
        }
        this.mWebViewModel.isSupportCache = true;
    }

    /* renamed from: a */
    private void m26856a() {
        this.f35387f.setWebViewClient(new FusionWebViewClient(this.f35387f));
        this.f35387f.setWebChromeClient(new FusionWebChromeClient(this.f35387f));
        this.f35387f.setVerticalScrollBarEnabled(true);
        this.f35387f.setHorizontalScrollBarEnabled(false);
        this.f35387f.loadUrl(this.mWebViewModel.url);
    }

    public void onDestroy() {
        super.onDestroy();
        FusionWebView fusionWebView = this.f35387f;
        if (fusionWebView != null) {
            if (fusionWebView.getParent() != null && (this.f35387f.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f35387f.getParent()).removeView(this.f35387f);
            }
            this.f35387f.removeAllViews();
            this.f35387f.destroy();
        }
    }
}
