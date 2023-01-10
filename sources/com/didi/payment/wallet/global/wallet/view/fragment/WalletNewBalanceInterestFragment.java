package com.didi.payment.wallet.global.wallet.view.fragment;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.wallet.global.model.event.WalletNewBalanceLoadingEvent;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInterestResp;
import com.didi.payment.wallet.global.utils.ColorsUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceInterestContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletNewBalanceInterestPresenter;
import com.didi.payment.wallet.global.wallet.view.view.WalletBalanceIntroductionView;
import com.didi.payment.wallet.global.wallet.view.view.WalletScrollView;
import com.didi.payment.wallet.global.wallet.view.view.WalletSimpleBarChart;
import com.didi.payment.wallet.global.wallet.view.view.WalletSimpleLineChart;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

public class WalletNewBalanceInterestFragment extends Fragment implements View.OnClickListener, WalletNewBalanceInterestContract.View {
    public static final String TYPE_KEY = "FragmentType";
    public static final int TYPE_VALUE_CALLBACK = 1;
    public static final int TYPE_VALUE_INTEREST = 0;

    /* renamed from: a */
    private int f34896a = 0;

    /* renamed from: b */
    private ViewGroup f34897b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletScrollView f34898c;

    /* renamed from: d */
    private View f34899d;

    /* renamed from: e */
    private View f34900e;

    /* renamed from: f */
    private ViewGroup f34901f;

    /* renamed from: g */
    private TextView f34902g;

    /* renamed from: h */
    private TextView f34903h;

    /* renamed from: i */
    private TextView f34904i;

    /* renamed from: j */
    private TextView f34905j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public LinearLayout f34906k;

    /* renamed from: l */
    private ArrayList<TextView> f34907l;

    /* renamed from: m */
    private LinearLayout f34908m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ImageView f34909n;

    /* renamed from: o */
    private TextView f34910o;

    /* renamed from: p */
    private WalletSimpleBarChart f34911p;

    /* renamed from: q */
    private WalletSimpleLineChart f34912q;

    /* renamed from: r */
    private WalletBalanceIntroductionView f34913r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public WalletNewBalanceInterestContract.Presenter f34914s;

    /* renamed from: t */
    private String f34915t;

    /* renamed from: u */
    private int f34916u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f34917v;

    /* renamed from: w */
    private FragmentActivity f34918w;

    public void initLoadingDialog(Activity activity) {
    }

    public void releaseLoadingDialog() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f34918w = getActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f34896a = arguments.getInt(TYPE_KEY, 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.wallet_global_fragment_new_balance_interest, viewGroup, false);
        m26657a(inflate);
        WalletNewBalanceInterestPresenter walletNewBalanceInterestPresenter = new WalletNewBalanceInterestPresenter(this.f34918w, this);
        this.f34914s = walletNewBalanceInterestPresenter;
        walletNewBalanceInterestPresenter.init();
        return inflate;
    }

    /* renamed from: a */
    private void m26657a(View view) {
        this.f34897b = (ViewGroup) view.findViewById(R.id.fl_wallet_new_balance_interest_container);
        this.f34898c = (WalletScrollView) view.findViewById(R.id.sv_wallet_new_balance_interest_scroll_container);
        this.f34901f = (ViewGroup) view.findViewById(R.id.ll_wallet_new_balance_interest_content);
        this.f34902g = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_day);
        this.f34903h = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_month);
        this.f34904i = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_total);
        this.f34905j = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_amount);
        this.f34910o = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_date);
        this.f34911p = (WalletSimpleBarChart) view.findViewById(R.id.bc_wallet_new_balance_interest);
        this.f34912q = (WalletSimpleLineChart) view.findViewById(R.id.lc_wallet_new_balance_interest);
        this.f34906k = (LinearLayout) view.findViewById(R.id.ll_wallet_new_balance_interest_items_container);
        this.f34908m = (LinearLayout) view.findViewById(R.id.ll_view_all);
        this.f34909n = (ImageView) view.findViewById(R.id.iv_view_all);
        this.f34913r = (WalletBalanceIntroductionView) view.findViewById(R.id.ll_introduction_container);
        this.f34902g.setOnClickListener(this);
        this.f34903h.setOnClickListener(this);
        this.f34904i.setOnClickListener(this);
        this.f34911p.setOperationListener(new WalletSimpleBarChart.OperationListener() {
            public void onOperationStart() {
                WalletNewBalanceInterestFragment.this.f34898c.setScrollable(false);
            }

            public void onOperationEnd() {
                WalletNewBalanceInterestFragment.this.f34898c.setScrollable(true);
            }

            public void onOperationVerticalScroll() {
                WalletNewBalanceInterestFragment.this.f34898c.setScrollable(true);
            }
        });
        this.f34912q.setOperationListener(new WalletSimpleLineChart.OperationListener() {
            public void onOperationStart() {
                WalletNewBalanceInterestFragment.this.f34898c.setScrollable(false);
            }

            public void onOperationEnd() {
                WalletNewBalanceInterestFragment.this.f34898c.setScrollable(true);
            }

            public void onOperationVerticalScroll() {
                WalletNewBalanceInterestFragment.this.f34898c.setScrollable(true);
            }
        });
    }

    public void showLoadingDialog() {
        WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent = new WalletNewBalanceLoadingEvent();
        walletNewBalanceLoadingEvent.showLoading = true;
        EventBus.getDefault().post(walletNewBalanceLoadingEvent);
    }

    public void dismissLoadingDialog() {
        WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent = new WalletNewBalanceLoadingEvent();
        walletNewBalanceLoadingEvent.showLoading = false;
        EventBus.getDefault().post(walletNewBalanceLoadingEvent);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.tv_wallet_new_balance_interest_day) {
            this.f34914s.onInterestDayClicked();
        } else if (view.getId() == R.id.tv_wallet_new_balance_interest_month) {
            this.f34914s.onInterestMonthClicked();
        } else if (view.getId() == R.id.tv_wallet_new_balance_interest_total) {
            this.f34914s.onInterestTotalClicked();
        }
    }

    public void updateMetaData(WalletBalanceInterestResp.MetaInfo metaInfo) {
        this.f34898c.setVisibility(0);
        View view = this.f34899d;
        if (!(view == null || view.getParent() == null)) {
            ((ViewGroup) this.f34899d.getParent()).removeView(this.f34899d);
            this.f34899d = null;
            this.f34901f.setVisibility(0);
        }
        View view2 = this.f34900e;
        if (!(view2 == null || view2.getParent() == null)) {
            ((ViewGroup) this.f34900e.getParent()).removeView(this.f34900e);
            this.f34900e = null;
            this.f34901f.setVisibility(0);
        }
        if (metaInfo != null && !CollectionUtil.isEmpty((Object[]) metaInfo.interestTitles)) {
            this.f34906k.removeAllViews();
            if (this.f34907l == null) {
                this.f34907l = new ArrayList<>();
            }
            this.f34907l.clear();
            int i = 0;
            while (true) {
                int i2 = 8;
                if (i >= metaInfo.interestTitles.length) {
                    break;
                }
                String str = metaInfo.interestTitles[i];
                View inflate = LayoutInflater.from(this.f34918w).inflate(R.layout.wallet_global_new_balance_interest_item, this.f34906k, false);
                if (i < 3) {
                    i2 = 0;
                }
                inflate.setVisibility(i2);
                ((TextView) inflate.findViewById(R.id.tv_wallet_new_balance_interest_left)).setText(str);
                this.f34906k.addView(inflate);
                this.f34907l.add((TextView) inflate.findViewById(R.id.tv_wallet_new_balance_interest_right));
                i++;
            }
            this.f34917v = false;
            if (metaInfo.interestTitles.length > 3) {
                this.f34908m.setVisibility(0);
                this.f34908m.setOnClickListener(m26655a());
            } else {
                this.f34908m.setVisibility(8);
            }
            this.f34915t = metaInfo.symbol != null ? metaInfo.symbol : "";
            this.f34916u = metaInfo.symbolAfterValue;
        }
    }

    /* renamed from: a */
    private View.OnClickListener m26655a() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                int i = WalletNewBalanceInterestFragment.this.f34917v ? 8 : 0;
                int childCount = WalletNewBalanceInterestFragment.this.f34906k.getChildCount();
                for (int i2 = 3; i2 < childCount; i2++) {
                    View childAt = WalletNewBalanceInterestFragment.this.f34906k.getChildAt(i2);
                    if (childAt != null) {
                        childAt.setVisibility(i);
                    }
                }
                WalletNewBalanceInterestFragment walletNewBalanceInterestFragment = WalletNewBalanceInterestFragment.this;
                boolean unused = walletNewBalanceInterestFragment.f34917v = !walletNewBalanceInterestFragment.f34917v;
                WalletNewBalanceInterestFragment.this.f34909n.setImageDrawable(WalletNewBalanceInterestFragment.this.getResources().getDrawable(WalletNewBalanceInterestFragment.this.f34917v ? R.drawable.icon_balance_arrow_up : R.drawable.icon_balance_arrow_down));
            }
        };
    }

    public void showChartInDay(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr) {
        m26658a(this.f34902g);
        m26659a(interestInfoArr, strArr, (WalletSimpleBarChart.OnSelectedListener) new WalletSimpleBarChart.OnSelectedListener() {
            public void onSelectedListener(int i) {
                WalletNewBalanceInterestFragment.this.f34914s.onChartItemSelectedInDay(i);
            }
        });
    }

    public void showChartInMonth(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr) {
        m26658a(this.f34903h);
        m26659a(interestInfoArr, strArr, (WalletSimpleBarChart.OnSelectedListener) new WalletSimpleBarChart.OnSelectedListener() {
            public void onSelectedListener(int i) {
                WalletNewBalanceInterestFragment.this.f34914s.onChartItemSelectedInMonth(i);
            }
        });
    }

    /* renamed from: a */
    private void m26659a(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr, WalletSimpleBarChart.OnSelectedListener onSelectedListener) {
        this.f34912q.setVisibility(8);
        if (CollectionUtil.isEmpty((Object[]) interestInfoArr) || CollectionUtil.isEmpty((Object[]) strArr)) {
            this.f34911p.setVisibility(8);
            return;
        }
        this.f34911p.setVisibility(0);
        float[] fArr = new float[interestInfoArr.length];
        for (int i = 0; i < interestInfoArr.length; i++) {
            fArr[i] = (float) interestInfoArr[i].amount;
        }
        this.f34911p.setDataList(fArr, strArr);
        this.f34911p.setOnSelectedListener(onSelectedListener);
    }

    public void showChartInTotal(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr) {
        m26658a(this.f34904i);
        m26660a(interestInfoArr, strArr, (WalletSimpleLineChart.OnSelectedListener) new WalletSimpleLineChart.OnSelectedListener() {
            public void onSelectedListener(int i) {
                WalletNewBalanceInterestFragment.this.f34914s.onChartItemSelectedInTotal(i);
            }
        });
    }

    /* renamed from: a */
    private void m26658a(TextView textView) {
        TextView textView2 = this.f34902g;
        boolean z = true;
        textView2.setSelected(textView == textView2);
        TextView textView3 = this.f34903h;
        textView3.setSelected(textView == textView3);
        TextView textView4 = this.f34904i;
        if (textView != textView4) {
            z = false;
        }
        textView4.setSelected(z);
        TextView textView5 = this.f34902g;
        textView5.setTypeface(textView == textView5 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        TextView textView6 = this.f34903h;
        textView6.setTypeface(textView == textView6 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        TextView textView7 = this.f34904i;
        textView7.setTypeface(textView == textView7 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
    }

    /* renamed from: a */
    private void m26660a(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr, WalletSimpleLineChart.OnSelectedListener onSelectedListener) {
        this.f34911p.setVisibility(8);
        if (CollectionUtil.isEmpty((Object[]) interestInfoArr) || CollectionUtil.isEmpty((Object[]) strArr)) {
            this.f34912q.setVisibility(8);
            return;
        }
        this.f34912q.setVisibility(0);
        float[] fArr = new float[interestInfoArr.length];
        for (int i = 0; i < interestInfoArr.length; i++) {
            if (interestInfoArr[i].amount > 3.4028234663852886E38d) {
                fArr[i] = Float.MAX_VALUE;
            } else {
                fArr[i] = (float) interestInfoArr[i].amount;
            }
        }
        this.f34912q.setDataList(fArr, strArr);
        this.f34912q.setOnSelectedListener(onSelectedListener);
    }

    public void showInterestInfo(WalletBalanceInterestResp.InterestInfo interestInfo, String str) {
        String str2;
        SpannableStringBuilder spannableStringBuilder;
        if (TextUtil.isEmpty(str)) {
            this.f34910o.setText("");
        } else {
            this.f34910o.setText(str);
        }
        if (interestInfo == null) {
            this.f34905j.setText("");
            this.f34906k.setVisibility(4);
            return;
        }
        char c = interestInfo.amount < 0.0d ? '-' : '+';
        if (this.f34916u == 0) {
            str2 = c + this.f34915t;
        } else {
            str2 = this.f34915t;
        }
        int dip2px = UIUtils.dip2px(this.f34918w, 21.0f);
        SpannableString spannableString = new SpannableString(str2);
        int i = 0;
        spannableString.setSpan(new AbsoluteSizeSpan(dip2px), 0, spannableString.length(), 33);
        String str3 = interestInfo.amountText != null ? interestInfo.amountText : DCryptoMainFragment.DCRYPTO_ZERO;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (this.f34916u == 0) {
            spannableStringBuilder = spannableStringBuilder2.append(spannableString).append(" ").append(str3);
        } else {
            spannableStringBuilder = spannableStringBuilder2.append(c).append(str3).append(" ").append(spannableString);
        }
        this.f34905j.setText(spannableStringBuilder);
        if (interestInfo.amountItems == null || interestInfo.amountItems.length == 0 || this.f34907l.size() == 0) {
            this.f34906k.setVisibility(4);
            return;
        }
        this.f34906k.setVisibility(0);
        while (i < this.f34907l.size() && this.f34907l.get(i) != null) {
            if (i < interestInfo.amountItems.length) {
                this.f34907l.get(i).setText(interestInfo.amountItems[i]);
            } else {
                this.f34907l.get(i).setText("");
            }
            i++;
        }
    }

    public void showErrorPage() {
        View view = this.f34899d;
        if (view != null) {
            view.setVisibility(0);
        } else if (getActivity() != null) {
            View view2 = this.f34900e;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.f34901f.setVisibility(8);
            View inflate = LayoutInflater.from(this.f34918w).inflate(R.layout.wallet_global_activity_balance_item_network_error, this.f34901f, false);
            View findViewById = inflate.findViewById(R.id.ll_account_balance_retry_btn);
            findViewById.setBackground(m26662b());
            findViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletNewBalanceInterestFragment.this.f34914s.requestData();
                }
            });
            this.f34898c.setVisibility(0);
            this.f34901f.setVisibility(8);
            this.f34897b.addView(inflate);
            this.f34899d = inflate;
        }
    }

    /* renamed from: b */
    private Drawable m26662b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) UIUtil.dp2px(40.0f));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{ColorsUtils.parseColor("#FFF366"), ColorsUtils.parseColor("#FFC040")});
        return gradientDrawable;
    }

    public void showEmptyPage(final WalletBalanceInterestResp.MetaInfo metaInfo) {
        View view = this.f34900e;
        if (view != null) {
            view.setVisibility(0);
        } else if (getActivity() != null && metaInfo != null && metaInfo.topupBtn != null) {
            View view2 = this.f34899d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.f34901f.setVisibility(8);
            View inflate = LayoutInflater.from(this.f34918w).inflate(R.layout.wallet_global_activity_balance_item_empty_view, this.f34901f, false);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_balance_empty);
            if (!TextUtils.isEmpty(metaInfo.topupBtn.notice)) {
                textView.setText(metaInfo.topupBtn.notice);
            }
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_balance_todo);
            if (!TextUtils.isEmpty(metaInfo.topupBtn.text)) {
                textView2.setText(metaInfo.topupBtn.text);
            }
            textView2.setBackground(m26662b());
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    HashMap hashMap = new HashMap();
                    hashMap.put("pub_page", "walletbalance");
                    hashMap.put("button_name", "topup");
                    FinOmegaSDK.trackEvent("fin_walletbalance_button_ck", hashMap);
                    if (!TextUtils.isEmpty(metaInfo.topupBtn.link)) {
                        DRouter.build(metaInfo.topupBtn.link).start(WalletNewBalanceInterestFragment.this.getActivity());
                    }
                }
            });
            this.f34898c.setVisibility(0);
            this.f34901f.setVisibility(8);
            this.f34897b.addView(inflate);
            this.f34900e = inflate;
        }
    }

    public void showIntroduction(WalletBalanceInterestResp.MetaInfo metaInfo) {
        if (metaInfo == null) {
            this.f34913r.setVisibility(8);
            return;
        }
        this.f34913r.setVisibility(0);
        this.f34913r.updateContent(metaInfo.introductionTitle, metaInfo.introductions);
    }

    public int getType() {
        return this.f34896a;
    }
}
