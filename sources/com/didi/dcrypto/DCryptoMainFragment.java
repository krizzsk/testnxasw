package com.didi.dcrypto;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.dcrypto.chart.ChartCallback;
import com.didi.dcrypto.chart.ChartUtil;
import com.didi.dcrypto.chart.ScrollViewCallback;
import com.didi.dcrypto.cryptoprice.CryptoPriceCallback;
import com.didi.dcrypto.model.AccountInfoMulticoinBalance;
import com.didi.dcrypto.model.BitcoinHistoryItemModel;
import com.didi.dcrypto.multicoin.recyclerview.BalanceAdapter;
import com.didi.dcrypto.multicoin.recyclerview.DcryptoDividerItemDecorator;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.dcrypto.util.DigitUtils;
import com.didi.dcrypto.util.MulticoinUtils;
import com.didi.dcrypto.util.OmegaUtils;
import com.didi.dcrypto.util.TextUtil;
import com.didi.dcrypto.util.TimeUtils;
import com.didi.dcrypto.util.dialog.GlobalAlertDialog;
import com.didi.dcrypto.util.network.CommonProxyHolder;
import com.didi.dcrypto.util.network.NetworkConstants;
import com.didi.dcrypto.util.network.NetworkUtils;
import com.didi.dcrypto.util.network.UrlParamsUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel4;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.api.ILoginActionApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.global.didi.elvish.Elvish;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;
import com.taxis99.R;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DCryptoMainFragment extends Fragment implements View.OnClickListener, ChartCallback, ScrollViewCallback, CryptoPriceCallback {
    public static final String CRYPTO_ACCOUNT_STATUS_NOT_APPLIED = "not_applied";
    public static final String CRYPTO_ACCOUNT_STATUS_VERIFIED = "verified_simple_account";
    public static final String CRYPTO_ACCOUNT_STATUS_VERIFYING = "verifying_simple_account";
    public static final String DCRYPTO_EMPTY_STRING = "";
    public static final String DCRYPTO_NA = "N/A";
    public static final String DCRYPTO_NULL = "null";
    public static final String DCRYPTO_ZERO = "0.00";

    /* renamed from: F */
    private static final String f18275F = "ACTIVE";

    /* renamed from: G */
    private static final String f18276G = "FILLED";

    /* renamed from: H */
    private static final String f18277H = "PARTIALLY_FILLED";

    /* renamed from: I */
    private static final String f18278I = "PARTIALLY_CANCELED";
    public static final String IS_FULL_KYC_NO = "0";
    public static final String IS_FULL_KYC_YES = "1";

    /* renamed from: J */
    private static final String f18279J = "CANCELLED";

    /* renamed from: K */
    private static String f18280K = null;

    /* renamed from: L */
    private static String f18281L = null;

    /* renamed from: M */
    private static String f18282M = null;

    /* renamed from: N */
    private static final String f18283N = "BUY";

    /* renamed from: O */
    private static final String f18284O = "SELL";

    /* renamed from: ab */
    private static boolean f18285ab = true;

    /* renamed from: c */
    private static final String f18286c = "pt-BR";

    /* renamed from: d */
    private static final String f18287d = "en-US";
    public static boolean shouldUpdatePrice = true;

    /* renamed from: A */
    private CardView f18288A;

    /* renamed from: B */
    private CardView f18289B;

    /* renamed from: C */
    private CardView f18290C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public String f18291D = "0";

    /* renamed from: E */
    private String f18292E = CRYPTO_ACCOUNT_STATUS_NOT_APPLIED;

    /* renamed from: P */
    private boolean f18293P = false;

    /* renamed from: Q */
    private Timer f18294Q;

    /* renamed from: R */
    private RadioGroup f18295R;

    /* renamed from: S */
    private RadioButton f18296S;

    /* renamed from: T */
    private RadioButton f18297T;

    /* renamed from: U */
    private RadioButton f18298U;

    /* renamed from: V */
    private RadioButton f18299V;

    /* renamed from: W */
    private RadioButton f18300W;

    /* renamed from: X */
    private RadioButton f18301X;

    /* renamed from: Y */
    private RadioButton f18302Y;

    /* renamed from: Z */
    private RadioButton f18303Z;

    /* renamed from: a */
    String f18304a = (Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());

    /* renamed from: aa */
    private RadioButton f18305aa;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public LEGODrawer f18306ac;

    /* renamed from: ad */
    private AlertDialog f18307ad;

    /* renamed from: ae */
    private AlertDialog f18308ae;

    /* renamed from: af */
    private String f18309af = "";

    /* renamed from: ag */
    private String f18310ag = "";
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public LEGODrawer f18311ah;

    /* renamed from: ai */
    private ChartUtil f18312ai;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public String f18313aj;

    /* renamed from: ak */
    private RecyclerView f18314ak;

    /* renamed from: al */
    private BalanceAdapter f18315al;

    /* renamed from: am */
    private List<AccountInfoMulticoinBalance> f18316am;

    /* renamed from: an */
    private Map<String, MulticoinState> f18317an;

    /* renamed from: ao */
    private final LoginListeners.LoginOutListener f18318ao = new LoginListeners.LoginOutListener() {
        public final void onSuccess() {
            DCryptoMainFragment.this.m15458J();
        }
    };

    /* renamed from: b */
    final int f18319b = 40;

    /* renamed from: e */
    private final String[] f18320e = {DCryptoUtils.KEY_HOME_GET_CRYPTO_PRICE, DCryptoUtils.KEY_HOME_HISTORY_ITEMS, DCryptoUtils.KEY_HOME_ACCOUNT_STATUS, DCryptoUtils.KEY_HOME_ACCOUNT_BALANCE, DCryptoUtils.KEY_HOME_DAILY_PROFIT_AND_LOSS, DCryptoUtils.KEY_HOME_UI_CONFIG, DCryptoUtils.KEY_HOME_TOP_BANNER};

    /* renamed from: f */
    private ScrollView f18321f;

    /* renamed from: g */
    private TextView f18322g;

    /* renamed from: h */
    private ImageView f18323h;

    /* renamed from: i */
    private RelativeLayout f18324i;

    /* renamed from: j */
    private ImageView f18325j;

    /* renamed from: k */
    private TextView f18326k;

    /* renamed from: l */
    private TextView f18327l;

    /* renamed from: m */
    private TextView f18328m;

    /* renamed from: n */
    private TextView f18329n;

    /* renamed from: o */
    private TextView f18330o;

    /* renamed from: p */
    private ImageView f18331p;

    /* renamed from: q */
    private TextView f18332q;

    /* renamed from: r */
    private Button f18333r;

    /* renamed from: s */
    private Button f18334s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public CardView f18335t;

    /* renamed from: u */
    private TextView f18336u;

    /* renamed from: v */
    private RelativeLayout f18337v;

    /* renamed from: w */
    private RelativeLayout f18338w;

    /* renamed from: x */
    private TextView f18339x;

    /* renamed from: y */
    private TextView f18340y;

    /* renamed from: z */
    private CardView f18341z;

    enum MulticoinState {
        HAS_TRANSACTION,
        NO_TRANSACTION
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void m15458J() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                DCryptoMainFragment.this.m15459K();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void m15459K() {
        m15480b();
        SystemUtils.log(4, "Dcrypto passport", "Passport Logout listener detected user has been logged out or kicked out", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 281);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DCryptoUtils.getBundle(this);
        this.f18313aj = NetworkConstants.CURRENCY_BTC;
        NetworkConstants.BASIC_PARAMS = UrlParamsUtils.getBasicUrlParams(getContext());
        View inflate = layoutInflater.inflate(R.layout.fragment_page_my, viewGroup, false);
        if (getContext() != null) {
            f18280K = getString(R.string.Wallet_App_process_Success_PvkG);
            f18281L = getString(R.string.Wallet_App_process_Processing_CGYA);
            f18282M = getString(R.string.Wallet_App_process_Failure_mwvP);
        }
        this.f18312ai = new ChartUtil(this, this, this, getContext(), inflate);
        m15464a(inflate);
        m15482b(inflate);
        m15491c(inflate);
        m15549u();
        m15550v();
        this.f18317an = new HashMap();
        m15499d(this.f18313aj);
        if (getContext() != null) {
            Elvish.Companion.init(getContext(), "pt_BR", "BR", "55000001");
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (f18285ab) {
            m15534l();
        }
        SystemUtils.log(4, "Dcrypto", "Dcrypto lifecycle: onResume()", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 352);
        this.f18309af = TimeUtils.getCurrentLocalDateTimeStamp();
    }

    public void onPause() {
        super.onPause();
        m15545q();
        boolean isLoginNow = OneLoginFacade.getStore().isLoginNow();
        String currentLocalDateTimeStamp = TimeUtils.getCurrentLocalDateTimeStamp();
        this.f18310ag = currentLocalDateTimeStamp;
        if (this.f18293P) {
            OmegaUtils.ibt_microinvest_mihomepurchased_page_browse_time_ex(isLoginNow, this.f18309af, currentLocalDateTimeStamp);
        } else {
            OmegaUtils.ibt_microinvest_mihomenotpurchased_page_browse_time_ex(isLoginNow, this.f18309af, currentLocalDateTimeStamp);
        }
        this.f18309af = "";
        this.f18310ag = "";
        SystemUtils.log(4, "Dcrypto", "Dcrypto lifecycle: onPause()", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 376);
    }

    public void onHiddenChanged(boolean z) {
        if (getContext() != null) {
            f18285ab = !z;
            if (!z) {
                SystemUtils.log(4, "Dcrypto", "Dcrypto lifecycle: onHiddenChange() -> Fragment Show", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 391);
                m15534l();
                return;
            }
            SystemUtils.log(4, "Dcrypto", "Dcrypto lifecycle: onHiddenChange() -> Fragment Hidden", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 396);
        }
    }

    public void onInitChart() {
        this.f18301X.performClick();
        m15490c((int) R.id.btn_crypto_graph_btn_day);
    }

    public void onReceiveData(String str, String str2) {
        this.f18312ai.updateData(str, str2);
    }

    public void onResetChart() {
        this.f18296S.performClick();
        m15481b((int) R.id.btn_coin_btc);
        this.f18296S.setChecked(true);
        this.f18298U.setChecked(false);
        this.f18300W.setChecked(false);
        this.f18299V.setChecked(false);
        this.f18297T.setChecked(false);
        this.f18301X.performClick();
        m15490c((int) R.id.btn_crypto_graph_btn_day);
        this.f18301X.setChecked(true);
        this.f18302Y.setChecked(false);
        this.f18303Z.setChecked(false);
        this.f18305aa.setChecked(false);
    }

    public void setInterceptTouch(boolean z) {
        this.f18321f.requestDisallowInterceptTouchEvent(z);
    }

    /* renamed from: a */
    private void m15463a(int i) {
        this.f18324i.setVisibility(i);
    }

    /* renamed from: a */
    private void m15476a(boolean z, String str, String str2, String str3, String str4) {
        m15463a(8);
        this.f18326k.setText(str);
        this.f18327l.setText(str2);
        if (DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON) && z && !TextUtil.isEmpty(str3)) {
            Picasso.with(getContext()).load(str3).placeholder((int) R.drawable.crypto_home_top_banner).into(this.f18325j);
        }
        NetworkConstants.urlBannerTop = str4 + NetworkConstants.BASIC_PARAMS;
        NetworkConstants.urlBannerTop = NetworkConstants.urlBannerTop.substring(0, NetworkConstants.urlBannerTop.lastIndexOf(38));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15462a() {
        if (getContext() != null) {
            LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(getString(R.string.GRider_request_For_policy_eYxl), new LEGOBtnTextAndCallback(Payload.RESPONSE_OK, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    DCryptoMainFragment.this.f18311ah.dismiss();
                    if (DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON) && DCryptoMainFragment.this.getActivity() != null) {
                        DCryptoMainFragment.this.getActivity().finish();
                    }
                }
            }));
            lEGODrawerModel1.setClickOutsideCanCancel(false);
            lEGODrawerModel1.setmBackPressedEnabled(false);
            this.f18311ah = LEGOUICreator.showDrawerTemplate(getActivity(), lEGODrawerModel1);
        }
    }

    /* renamed from: b */
    private void m15480b() {
        if (getContext() != null) {
            m15463a(0);
            m15551w();
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f18295R.getLayoutParams();
            if (getContext() != null) {
                layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (float) 0, getContext().getResources().getDisplayMetrics()), 0, 0);
            }
            this.f18295R.setLayoutParams(layoutParams);
            m15501e();
            this.f18312ai.resetChart();
            m15489c();
            m15507f();
            m15513g();
            this.f18335t.setVisibility(8);
            m15522i();
            m15518h();
            m15545q();
            m15497d((View) this.f18321f);
            DCryptoUtils.clearIPBlockTimestamp();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15489c() {
        if (getContext() != null) {
            this.f18334s.setVisibility(8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f18333r.getLayoutParams();
            if (getContext() != null) {
                layoutParams.setMarginStart((int) TypedValue.applyDimension(1, (float) 20, getContext().getResources().getDisplayMetrics()));
            }
            this.f18333r.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: d */
    private void m15496d() {
        if (getContext() != null) {
            this.f18334s.setVisibility(0);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f18333r.getLayoutParams();
            if (getContext() != null) {
                layoutParams.setMarginStart((int) TypedValue.applyDimension(1, (float) 16, getContext().getResources().getDisplayMetrics()));
            }
            this.f18333r.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m15501e() {
        if (getContext() != null) {
            shouldUpdatePrice = true;
            this.f18328m.setText("");
            this.f18329n.setText(DCRYPTO_ZERO);
            this.f18332q.setText("0.00%");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m15507f() {
        if (getContext() != null) {
            try {
                this.f18339x.setText(MulticoinUtils.getMulticoinCurrency(DigitUtils.getElvishedCurrency(Double.parseDouble(DCRYPTO_ZERO))));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "Reset Account Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 595);
                e.printStackTrace();
                this.f18339x.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f18339x.setText(DCRYPTO_NA);
            }
            m15513g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m15513g() {
        if (getContext() != null) {
            try {
                String elvishedCurrency = DigitUtils.getElvishedCurrency(Double.parseDouble(DCRYPTO_ZERO));
                this.f18340y.setTextColor(-16777216);
                this.f18340y.setText(MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "Amount Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 617);
                e.printStackTrace();
                this.f18340y.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f18340y.setText(DCRYPTO_NA);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m15518h() {
        if (getContext() != null) {
            this.f18291D = "0";
            this.f18292E = CRYPTO_ACCOUNT_STATUS_NOT_APPLIED;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m15522i() {
        if (getContext() != null) {
            RelativeLayout relativeLayout = this.f18337v;
            BitcoinHistoryItemModel bitcoinHistoryItemModel = r2;
            BitcoinHistoryItemModel bitcoinHistoryItemModel2 = new BitcoinHistoryItemModel(DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, 0);
            m15468a(relativeLayout, bitcoinHistoryItemModel);
            m15468a(this.f18338w, new BitcoinHistoryItemModel(DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, DCRYPTO_NA, 0));
            this.f18293P = false;
        }
    }

    /* renamed from: j */
    private void m15526j() {
        if (getContext() != null) {
            this.f18338w.setVisibility(8);
        }
    }

    /* renamed from: k */
    private void m15531k() {
        if (getContext() != null) {
            this.f18338w.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m15534l() {
        if (getContext() != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(OneLoginFacade.getStore().isLoginNow()) {
                public final /* synthetic */ boolean f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    SystemUtils.log(4, "DcryptoLogin", "Dcrypto Passport status at refresh(): OneLoginFacade.getStore().isLoginNow() = " + this.f$0, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 662);
                }
            });
            if (getContext() != null && !DCryptoUtils.isBubbleViewed(getContext())) {
                m15547s();
            } else if (!OneLoginFacade.getStore().isLoginNow()) {
                m15480b();
                m15546r();
                this.f18312ai.startGraphChart(this.f18313aj);
            } else {
                m15538m();
            }
        }
    }

    /* renamed from: m */
    private void m15538m() {
        if (getContext() != null) {
            m15541n();
            m15544p();
            m15543o();
            this.f18312ai.startGraphChart(this.f18313aj);
        }
    }

    /* renamed from: n */
    private void m15541n() {
        SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Try Fetch :Check timestamp", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 694);
        if (DCryptoUtils.shouldFetchIPBlock()) {
            SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Fetch NOW!!", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 696);
            DCryptoUtils.setDcryptoIPStatus(getContext(), DCryptoUtils.KEY_IP_BLOCKING_STATUS_DEFAULT);
            new GetIPBlockAsyncTask().execute(new String[]{""});
            return;
        }
        SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Try Fetch :Under Time Interval. Will not fetch.", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 701);
        if (DCryptoUtils.getDcryptoIPStatus(getContext()).equalsIgnoreCase(DCryptoUtils.KEY_IP_BLOCKING_STATUS_DEFAULT)) {
            SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Default", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 703);
        } else if (DCryptoUtils.getDcryptoIPStatus(getContext()).equalsIgnoreCase(DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK)) {
            SystemUtils.log(4, "IPBlock Cache", "Enter Cache = Block", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 706);
            this.f18312ai.getChart().post(new Runnable() {
                public final void run() {
                    DCryptoMainFragment.this.m15462a();
                }
            });
        } else {
            SystemUtils.log(4, "IPBlock Cache", "Enter Cache = UNBlock", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 711);
        }
    }

    /* renamed from: o */
    private void m15543o() {
        for (String a : this.f18320e) {
            m15471a(a);
        }
    }

    /* renamed from: a */
    private void m15471a(String str) {
        SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Start API: " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 723);
        if (str != null && !str.equalsIgnoreCase("")) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1776939641:
                    if (str.equals(DCryptoUtils.KEY_HOME_GET_CRYPTO_PRICE)) {
                        c = 0;
                        break;
                    }
                    break;
                case -780842326:
                    if (str.equals(DCryptoUtils.KEY_HOME_DAILY_PROFIT_AND_LOSS)) {
                        c = 4;
                        break;
                    }
                    break;
                case 116686890:
                    if (str.equals(DCryptoUtils.KEY_HOME_ACCOUNT_STATUS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 501780587:
                    if (str.equals(DCryptoUtils.KEY_HOME_UI_CONFIG)) {
                        c = 5;
                        break;
                    }
                    break;
                case 681795201:
                    if (str.equals(DCryptoUtils.KEY_HOME_HISTORY_ITEMS)) {
                        c = 1;
                        break;
                    }
                    break;
                case 880264612:
                    if (str.equals(DCryptoUtils.KEY_HOME_ACCOUNT_BALANCE)) {
                        c = 3;
                        break;
                    }
                    break;
                case 2032596492:
                    if (str.equals(DCryptoUtils.KEY_HOME_TOP_BANNER)) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m15546r();
                    return;
                case 1:
                    new GetTransactionHistoryAsyncTask().execute(new String[]{""});
                    return;
                case 2:
                    new GetAccountStatusAsyncTask().execute(new String[]{""});
                    return;
                case 3:
                    new GetAccountInfoAsyncTask().execute(new String[]{""});
                    return;
                case 4:
                    new GetDailyProfitLossAsyncTask().execute(new String[]{""});
                    return;
                case 5:
                    new GetUIConfigForBannersAsyncTask().execute(new String[]{""});
                    return;
                case 6:
                    new GetCryptoTopBannersAsyncTask().execute(new String[]{""});
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: p */
    private void m15544p() {
        String valueOf = String.valueOf(LoginStore.getInstance().getUid());
        String dcryptoCache = DCryptoUtils.getDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_UID);
        SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Load Cached Data: UID LoginStre: " + valueOf, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 759);
        SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Load Cached Data: UID Cached: " + dcryptoCache, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 760);
        int i = 0;
        if (!valueOf.equalsIgnoreCase(dcryptoCache)) {
            SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Clear Cache", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 769);
            String[] strArr = this.f18320e;
            int length = strArr.length;
            while (i < length) {
                DCryptoUtils.clearDcryptoCache(getContext(), strArr[i]);
                i++;
            }
            SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Update new UID: " + valueOf, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 774);
            DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_UID, valueOf);
            return;
        }
        String[] strArr2 = this.f18320e;
        int length2 = strArr2.length;
        while (i < length2) {
            m15485b(strArr2[i]);
            i++;
        }
    }

    /* renamed from: b */
    private void m15485b(String str) {
        SystemUtils.log(4, "DcryptoCache", "Dcrypto Cache: Load Cache: " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 785);
        if (getContext() != null) {
            String dcryptoCache = DCryptoUtils.getDcryptoCache(getContext(), str);
            if (!"".equalsIgnoreCase(dcryptoCache)) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -1776939641:
                        if (str.equals(DCryptoUtils.KEY_HOME_GET_CRYPTO_PRICE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -780842326:
                        if (str.equals(DCryptoUtils.KEY_HOME_DAILY_PROFIT_AND_LOSS)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 116686890:
                        if (str.equals(DCryptoUtils.KEY_HOME_ACCOUNT_STATUS)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 501780587:
                        if (str.equals(DCryptoUtils.KEY_HOME_UI_CONFIG)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 681795201:
                        if (str.equals(DCryptoUtils.KEY_HOME_HISTORY_ITEMS)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 880264612:
                        if (str.equals(DCryptoUtils.KEY_HOME_ACCOUNT_BALANCE)) {
                            c = 3;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    m15512f(dcryptoCache);
                } else if (c == 1) {
                    m15529j(dcryptoCache);
                } else if (c == 2) {
                    m15517g(dcryptoCache);
                } else if (c == 3) {
                    m15521h(dcryptoCache);
                } else if (c == 4) {
                    m15525i(dcryptoCache);
                } else if (c == 5) {
                    m15533k(dcryptoCache);
                }
            }
        }
    }

    /* renamed from: q */
    private void m15545q() {
        Timer timer;
        if (getContext() != null && (timer = this.f18294Q) != null) {
            timer.cancel();
            this.f18294Q.purge();
        }
    }

    /* renamed from: r */
    private void m15546r() {
        if (getContext() != null) {
            m15545q();
            Timer timer = new Timer();
            this.f18294Q = timer;
            timer.schedule(new GetPriceTimerTask(), 0, 5000);
        }
    }

    /* renamed from: s */
    private void m15547s() {
        if (getContext() != null) {
            SystemUtils.showDialog(this.f18307ad);
        }
    }

    /* renamed from: t */
    private void m15548t() {
        if (getContext() != null) {
            SystemUtils.showDialog(this.f18308ae);
        }
    }

    /* renamed from: u */
    private void m15549u() {
        if (getContext() != null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.BubbleDialog);
            View inflate = layoutInflater.inflate(R.layout.layout_bubble_1, (ViewGroup) null);
            builder.setView(inflate);
            AlertDialog create = builder.create();
            this.f18307ad = create;
            create.setCanceledOnTouchOutside(false);
            this.f18307ad.setCancelable(false);
            ((Button) inflate.findViewById(R.id.btn_bubble_ok)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m15542n(view);
                }
            });
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext(), R.style.BubbleDialog);
            View inflate2 = layoutInflater.inflate(R.layout.layout_bubble_2, (ViewGroup) null);
            builder2.setView(inflate2);
            this.f18308ae = builder2.create();
            this.f18308ae.setCanceledOnTouchOutside(false);
            this.f18308ae.setCancelable(false);
            ((Button) inflate2.findViewById(R.id.btn_bubble_ok)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m15539m(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void m15542n(View view) {
        this.f18307ad.dismiss();
        m15548t();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void m15539m(View view) {
        if (getContext() != null) {
            DCryptoUtils.setBubbleViewed(getContext(), true);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                DCryptoMainFragment.this.m15534l();
            }
        });
        this.f18308ae.dismiss();
    }

    /* renamed from: v */
    private void m15550v() {
        ArrayList arrayList = new ArrayList();
        this.f18316am = arrayList;
        BalanceAdapter balanceAdapter = new BalanceAdapter(arrayList, getContext(), this.f18313aj);
        this.f18315al = balanceAdapter;
        this.f18314ak.setAdapter(balanceAdapter);
        this.f18314ak.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    /* renamed from: a */
    private void m15464a(View view) {
        if (getContext() != null) {
            this.f18321f = (ScrollView) view.findViewById(R.id.sv_crypto_home);
            this.f18322g = (TextView) view.findViewById(R.id.tv_crypto_main_title);
            this.f18323h = (ImageView) view.findViewById(R.id.iv_crypto_customer_service);
            this.f18324i = (RelativeLayout) view.findViewById(R.id.rl_crypto_top_banner);
            this.f18325j = (ImageView) view.findViewById(R.id.iv_crypto_top_banner);
            this.f18326k = (TextView) view.findViewById(R.id.tv_drypto_banner_top_title);
            this.f18327l = (TextView) view.findViewById(R.id.tv_drypto_banner_top_subtitle);
            this.f18328m = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_prefix);
            this.f18329n = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_price);
            this.f18330o = (TextView) view.findViewById(R.id.tv_multicoin_title);
            this.f18331p = (ImageView) view.findViewById(R.id.iv_currency_question_mark);
            this.f18332q = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_percentage);
            this.f18295R = (RadioGroup) view.findViewById(R.id.rg_multi_coin);
            this.f18296S = (RadioButton) view.findViewById(R.id.btn_coin_btc);
            this.f18297T = (RadioButton) view.findViewById(R.id.btn_coin_eth);
            this.f18298U = (RadioButton) view.findViewById(R.id.btn_coin_usdc);
            this.f18299V = (RadioButton) view.findViewById(R.id.btn_coin_solana);
            this.f18300W = (RadioButton) view.findViewById(R.id.btn_coin_mana);
            this.f18301X = (RadioButton) view.findViewById(R.id.btn_crypto_graph_btn_day);
            this.f18302Y = (RadioButton) view.findViewById(R.id.btn_crypto_graph_btn_week);
            this.f18303Z = (RadioButton) view.findViewById(R.id.btn_crypto_graph_btn_month);
            this.f18305aa = (RadioButton) view.findViewById(R.id.btn_crypto_graph_btn_year);
            this.f18333r = (Button) view.findViewById(R.id.btn_crypto_bitcoin_buy);
            this.f18334s = (Button) view.findViewById(R.id.btn_crypto_bitcoin_sell);
            this.f18335t = (CardView) view.findViewById(R.id.cardview_crypto_bitcoin_history);
            this.f18336u = (TextView) view.findViewById(R.id.tv_crypto_bitcoint_transaction_history);
            this.f18337v = (RelativeLayout) view.findViewById(R.id.lv_crypto_bitcoin_history_item_1);
            this.f18338w = (RelativeLayout) view.findViewById(R.id.lv_crypto_bitcoin_history_item_2);
            this.f18339x = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_value_total_value_content);
            this.f18340y = (TextView) view.findViewById(R.id.tv_crypto_bitcoin_value_p_and_l);
            this.f18314ak = (RecyclerView) view.findViewById(R.id.recyclerViewMulticoinBalance);
        }
    }

    /* renamed from: b */
    private void m15482b(View view) {
        if (getContext() != null) {
            this.f18324i.setOnClickListener(this);
            this.f18323h.setOnClickListener(this);
            this.f18296S.setOnClickListener(this);
            this.f18297T.setOnClickListener(this);
            this.f18298U.setOnClickListener(this);
            this.f18299V.setOnClickListener(this);
            this.f18300W.setOnClickListener(this);
            this.f18301X.setOnClickListener(this);
            this.f18302Y.setOnClickListener(this);
            this.f18303Z.setOnClickListener(this);
            this.f18305aa.setOnClickListener(this);
            this.f18333r.setOnClickListener(this);
            this.f18334s.setOnClickListener(this);
            this.f18336u.setOnClickListener(this);
            this.f18331p.setOnClickListener(this);
        }
    }

    /* renamed from: c */
    private void m15491c(View view) {
        if (getContext() != null) {
            if (DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                this.f18322g.setVisibility(8);
                this.f18323h.setVisibility(8);
                this.f18333r.setBackgroundResource(R.drawable.roundbutton_mouton);
                this.f18333r.setTextColor(getResources().getColor(R.color.didi_black));
                this.f18334s.setBackgroundResource(R.drawable.roundbutton_mouton);
                this.f18334s.setTextColor(getResources().getColor(R.color.didi_black));
                ((ImageView) this.f18337v.findViewById(R.id.item_bitcoin_history_item_info)).setImageResource(R.drawable.bitcoin_history_icon_mouton);
                ((ImageView) this.f18338w.findViewById(R.id.item_bitcoin_history_item_info)).setImageResource(R.drawable.bitcoin_history_icon_mouton);
                Button button = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_1)).findViewById(R.id.btn_crypto_bottom_banner);
                button.setBackgroundResource(R.drawable.roundbutton_mouton);
                button.setTextColor(getResources().getColor(R.color.didi_black));
                Button button2 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_2)).findViewById(R.id.btn_crypto_bottom_banner);
                button2.setBackgroundResource(R.drawable.roundbutton_mouton);
                button2.setTextColor(getResources().getColor(R.color.didi_black));
                Button button3 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_3)).findViewById(R.id.btn_crypto_bottom_banner);
                button3.setBackgroundResource(R.drawable.roundbutton_mouton);
                button3.setTextColor(getResources().getColor(R.color.didi_black));
                Button button4 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_4)).findViewById(R.id.btn_crypto_bottom_banner);
                button4.setBackgroundResource(R.drawable.roundbutton_mouton);
                button4.setTextColor(getResources().getColor(R.color.didi_black));
            } else if (DCryptoUtils.hostAppSource.equalsIgnoreCase("latour")) {
                this.f18333r.setBackgroundResource(R.drawable.roundbutton_latour);
                this.f18333r.setTextColor(getResources().getColor(R.color.white));
                this.f18334s.setBackgroundResource(R.drawable.roundbutton_latour);
                this.f18334s.setTextColor(getResources().getColor(R.color.white));
                ((ImageView) this.f18337v.findViewById(R.id.item_bitcoin_history_item_info)).setImageResource(R.drawable.bitcoin_history_icon_latour);
                ((ImageView) this.f18338w.findViewById(R.id.item_bitcoin_history_item_info)).setImageResource(R.drawable.bitcoin_history_icon_latour);
                Button button5 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_1)).findViewById(R.id.btn_crypto_bottom_banner);
                button5.setBackgroundResource(R.drawable.roundbutton_latour);
                button5.setTextColor(getResources().getColor(R.color.white));
                Button button6 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_2)).findViewById(R.id.btn_crypto_bottom_banner);
                button6.setBackgroundResource(R.drawable.roundbutton_latour);
                button6.setTextColor(getResources().getColor(R.color.white));
                Button button7 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_3)).findViewById(R.id.btn_crypto_bottom_banner);
                button7.setBackgroundResource(R.drawable.roundbutton_latour);
                button7.setTextColor(getResources().getColor(R.color.white));
                Button button8 = (Button) ((CardView) view.findViewById(R.id.cardview_crypto_bottom_banner_4)).findViewById(R.id.btn_crypto_bottom_banner);
                button8.setBackgroundResource(R.drawable.roundbutton_latour);
                button8.setTextColor(getResources().getColor(R.color.white));
            }
        }
    }

    /* renamed from: a */
    private void m15468a(RelativeLayout relativeLayout, BitcoinHistoryItemModel bitcoinHistoryItemModel) {
        String str;
        if (getContext() != null && bitcoinHistoryItemModel != null) {
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_bitcoin_history_item_title);
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_bitcoin_history_item_date);
            TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_bitcoin_history_item_amount);
            TextView textView4 = (TextView) relativeLayout.findViewById(R.id.tv_bitcoin_history_item_status);
            if (bitcoinHistoryItemModel.remark == null || bitcoinHistoryItemModel.remark.equalsIgnoreCase("") || bitcoinHistoryItemModel.remark.equalsIgnoreCase("null")) {
                String str2 = bitcoinHistoryItemModel.side;
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 66150) {
                    if (hashCode == 2541394 && str2.equals(f18284O)) {
                        c = 1;
                    }
                } else if (str2.equals(f18283N)) {
                    c = 0;
                }
                if (c == 0) {
                    str = getString(R.string.Wallet_App_process_Purchase_zUpv);
                } else if (c != 1) {
                    str = "default";
                } else {
                    str = getString(R.string.Wallet_App_process_Sale_PNCZ);
                }
            } else {
                str = getString(R.string.Wallet_App_cashback_Bitcoin_cash_tecP);
            }
            textView.setText(str + " " + bitcoinHistoryItemModel.quantity_executed + " " + bitcoinHistoryItemModel.market_symbol.substring(0, bitcoinHistoryItemModel.market_symbol.length() - 3).toUpperCase());
            Date date = new Date(bitcoinHistoryItemModel.timestamp);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            textView2.setText(simpleDateFormat.format(date));
            if (bitcoinHistoryItemModel.quantity_executed.equalsIgnoreCase("null") || bitcoinHistoryItemModel.quantity_executed.equalsIgnoreCase(DCRYPTO_NA)) {
                textView3.setText("");
            } else {
                try {
                    textView3.setText(MulticoinUtils.getMulticoinCurrency(DigitUtils.getElvishedCurrency(Double.parseDouble(bitcoinHistoryItemModel.quantity_executed) * Double.parseDouble(bitcoinHistoryItemModel.priceAve))));
                } catch (NumberFormatException e) {
                    SystemUtils.log(6, "Dcrypto Error", "History Amount Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1100);
                    e.printStackTrace();
                    textView3.setText(DCRYPTO_NA);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    textView3.setText(DCRYPTO_NA);
                }
            }
            textView4.setText(bitcoinHistoryItemModel.state);
        }
    }

    /* renamed from: a */
    private Calendar m15461a(Date date) {
        if (getContext() == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public void updateMainPriceTitle(String str, String str2) {
        if (getContext() != null) {
            try {
                String elvishedCurrency = DigitUtils.getElvishedCurrency(Double.parseDouble(str));
                this.f18328m.setText("");
                this.f18329n.setText(MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "Today Bitcoin price Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1134);
                e.printStackTrace();
                this.f18328m.setText("");
                this.f18329n.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f18328m.setText("");
                this.f18329n.setText(DCRYPTO_NA);
            }
            if (str != null && str2 != null) {
                try {
                    double parseDouble = (Double.parseDouble(str) / Double.parseDouble(str2)) - 1.0d;
                    if (parseDouble > 0.0d) {
                        if (DCryptoUtils.hostAppSource.equalsIgnoreCase("latour")) {
                            this.f18332q.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_LATOUR));
                        } else {
                            this.f18332q.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
                        }
                        String keepNumOfDecimalDigits = DigitUtils.keepNumOfDecimalDigits(parseDouble * 100.0d, 2);
                        TextView textView = this.f18332q;
                        textView.setText("↑" + keepNumOfDecimalDigits + "%");
                        return;
                    }
                    this.f18332q.setTextColor(Color.parseColor(ColorUtils.DIDI_RED));
                    String keepNumOfDecimalDigits2 = DigitUtils.keepNumOfDecimalDigits(parseDouble * 100.0d, 2);
                    TextView textView2 = this.f18332q;
                    textView2.setText("↓" + keepNumOfDecimalDigits2 + "%");
                } catch (NumberFormatException e3) {
                    SystemUtils.log(6, "Dcrypto Error", "Bitcoin Percentage Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1174);
                    e3.printStackTrace();
                    this.f18332q.setTextColor(Color.parseColor(ColorUtils.DIDI_GREY));
                    this.f18332q.setText(DCRYPTO_NA);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    this.f18332q.setTextColor(Color.parseColor(ColorUtils.DIDI_GREY));
                    this.f18332q.setText(DCRYPTO_NA);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15486b(String str, String str2, List<AccountInfoMulticoinBalance> list) {
        if (getContext() != null) {
            try {
                this.f18339x.setText(MulticoinUtils.getMulticoinCurrency(DigitUtils.getElvishedCurrency(Double.parseDouble(str2))));
                double parseDouble = Double.parseDouble(str2);
                String.format(Locale.getDefault(), "%.8f", new Object[]{Double.valueOf(parseDouble)});
                ArrayList arrayList = new ArrayList();
                this.f18316am = arrayList;
                arrayList.addAll(list);
                BalanceAdapter balanceAdapter = new BalanceAdapter(this.f18316am, getContext(), this.f18313aj);
                this.f18315al = balanceAdapter;
                this.f18314ak.setAdapter(balanceAdapter);
                this.f18314ak.addItemDecoration(new DcryptoDividerItemDecorator(ContextCompat.getDrawable(getContext(), R.drawable.divider)));
                this.f18314ak.setLayoutManager(new LinearLayoutManager(getContext()));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "Account Balance Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1215);
                e.printStackTrace();
                this.f18339x.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f18339x.setText(DCRYPTO_NA);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15540m(String str) {
        if (getContext() != null) {
            try {
                double parseDouble = Double.parseDouble(str);
                String elvishedCurrency = DigitUtils.getElvishedCurrency(parseDouble);
                if (parseDouble >= 0.0d) {
                    if (DCryptoUtils.hostAppSource.equalsIgnoreCase("latour")) {
                        this.f18340y.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_LATOUR));
                    } else {
                        this.f18340y.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
                    }
                    TextView textView = this.f18340y;
                    textView.setText("+" + MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
                    return;
                }
                this.f18340y.setTextColor(Color.parseColor(ColorUtils.DIDI_RED));
                TextView textView2 = this.f18340y;
                textView2.setText("" + MulticoinUtils.getMulticoinCurrency(elvishedCurrency));
            } catch (NumberFormatException e) {
                SystemUtils.log(6, "Dcrypto Error", "P&L Parse Error", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1245);
                e.printStackTrace();
                this.f18340y.setTextColor(Color.parseColor(ColorUtils.DIDI_GREY));
                this.f18340y.setText(DCRYPTO_NA);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f18340y.setTextColor(Color.parseColor(ColorUtils.DIDI_GREY));
                this.f18340y.setText(DCRYPTO_NA);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void startLoginPage() {
        ILoginActionApi action;
        if (getContext() != null && (action = OneLoginFacade.getAction()) != null && getContext() != null) {
            action.go2Login(getContext());
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (getContext() != null) {
            boolean isLoginNow = OneLoginFacade.getStore().isLoginNow();
            new Handler(Looper.getMainLooper()).post(new Runnable(isLoginNow) {
                public final /* synthetic */ boolean f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    SystemUtils.log(4, "DcryptoLogin", "Dcrypto Passport status at onClick(View view): OneLoginFacade.getStore().isLoginNow() = " + this.f$0, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1275);
                }
            });
            int id = view.getId();
            if (id == R.id.btn_crypto_bitcoin_buy) {
                if (this.f18293P) {
                    OmegaUtils.ibt_microinvest_mihomepurchased_buy_ck(isLoginNow, this.f18313aj);
                } else {
                    OmegaUtils.ibt_microinvest_mihomenotpurchased_buy_ck(isLoginNow, this.f18291D, this.f18292E);
                }
                if (!isLoginNow) {
                    startLoginPage();
                } else if (CRYPTO_ACCOUNT_STATUS_NOT_APPLIED.equalsIgnoreCase(this.f18292E)) {
                    m15553y();
                } else if (CRYPTO_ACCOUNT_STATUS_VERIFIED.equalsIgnoreCase(this.f18292E)) {
                    DRouter.build("pay99://one/btc/buy_bitcoin_keyBoard?crypto=" + this.f18313aj).start(getContext());
                } else if (CRYPTO_ACCOUNT_STATUS_VERIFYING.equalsIgnoreCase(this.f18292E)) {
                    DRouter.build("pay99://one/btc/account_under_review").start(getContext());
                } else {
                    DRouter.build("pay99://one/btc/account_under_review").start(getContext());
                }
            } else if (id == R.id.btn_crypto_bitcoin_sell) {
                OmegaUtils.ibt_microinvest_mihomepurchased_sell_ck(isLoginNow, this.f18313aj);
                if (isLoginNow) {
                    DRouter.build("pay99://one/btc/sell_bitcoin_keyBoard?crypto=" + this.f18313aj).start(getContext());
                    return;
                }
                startLoginPage();
            } else if (id == R.id.tv_crypto_bitcoint_transaction_history) {
                OmegaUtils.ibt_microinvest_mihomepurchased_trx_ck();
                if (isLoginNow) {
                    DRouter.build("pay99://one/btc/transaction_history").start(getContext());
                } else {
                    startLoginPage();
                }
            } else if (id == R.id.iv_currency_question_mark) {
                m15552x();
            } else if (id == R.id.btn_crypto_graph_btn_day) {
                m15490c((int) R.id.btn_crypto_graph_btn_day);
                this.f18312ai.refreshGraph(0);
            } else if (id == R.id.btn_crypto_graph_btn_week) {
                m15490c((int) R.id.btn_crypto_graph_btn_week);
                this.f18312ai.refreshGraph(1);
            } else if (id == R.id.btn_crypto_graph_btn_month) {
                m15490c((int) R.id.btn_crypto_graph_btn_month);
                this.f18312ai.refreshGraph(2);
            } else if (id == R.id.btn_crypto_graph_btn_year) {
                m15490c((int) R.id.btn_crypto_graph_btn_year);
                this.f18312ai.refreshGraph(3);
            } else if (id == R.id.btn_coin_btc) {
                this.f18313aj = NetworkConstants.CURRENCY_BTC;
                m15499d(NetworkConstants.CURRENCY_BTC);
                m15481b((int) R.id.btn_coin_btc);
                this.f18312ai.startGraphChart(this.f18313aj);
            } else if (id == R.id.btn_coin_eth) {
                this.f18313aj = NetworkConstants.CURRENCY_ETH;
                m15499d(NetworkConstants.CURRENCY_ETH);
                m15481b((int) R.id.btn_coin_eth);
                this.f18312ai.startGraphChart(this.f18313aj);
            } else if (id == R.id.btn_coin_usdc) {
                this.f18313aj = NetworkConstants.CURRENCY_USDC;
                m15499d(NetworkConstants.CURRENCY_USDC);
                m15481b((int) R.id.btn_coin_usdc);
                this.f18312ai.startGraphChart(this.f18313aj);
            } else if (id == R.id.btn_coin_solana) {
                this.f18313aj = NetworkConstants.CURRENCY_SOLANA;
                m15499d(NetworkConstants.CURRENCY_SOLANA);
                m15481b((int) R.id.btn_coin_solana);
                this.f18312ai.startGraphChart(this.f18313aj);
            } else if (id == R.id.btn_coin_mana) {
                this.f18313aj = NetworkConstants.CURRENCY_MANA;
                m15499d(NetworkConstants.CURRENCY_MANA);
                m15481b((int) R.id.btn_coin_mana);
                this.f18312ai.startGraphChart(this.f18313aj);
            } else if (id == R.id.iv_crypto_customer_service) {
                DRouter.build(NetworkConstants.URL_CUSTOMER_SERVICE).start(getContext());
            } else if (id == R.id.rl_crypto_top_banner) {
                DRouter.build(NetworkConstants.urlBannerTop).start(getContext());
            }
        }
    }

    /* renamed from: d */
    private void m15499d(String str) {
        this.f18330o.setText(getString(R.string.multicoin_card_title, MulticoinUtils.getMulticoinName(str)));
    }

    /* renamed from: b */
    private void m15481b(int i) {
        if (getContext() != null && getContext() != null) {
            Typeface font = ResourcesCompat.getFont(getContext(), R.font.regular);
            Typeface font2 = ResourcesCompat.getFont(getContext(), R.font.bold);
            if (i == R.id.btn_coin_btc) {
                this.f18296S.setTypeface(font2, 1);
                this.f18297T.setTypeface(font, 0);
                this.f18298U.setTypeface(font, 0);
                this.f18299V.setTypeface(font, 0);
                this.f18300W.setTypeface(font, 0);
                m15505e(NetworkConstants.CURRENCY_BTC);
            } else if (i == R.id.btn_coin_eth) {
                this.f18296S.setTypeface(font, 0);
                this.f18297T.setTypeface(font2, 1);
                this.f18298U.setTypeface(font, 0);
                this.f18299V.setTypeface(font, 0);
                this.f18300W.setTypeface(font, 0);
                m15505e(NetworkConstants.CURRENCY_ETH);
            } else if (i == R.id.btn_coin_usdc) {
                this.f18296S.setTypeface(font, 0);
                this.f18297T.setTypeface(font, 0);
                this.f18298U.setTypeface(font2, 1);
                this.f18299V.setTypeface(font, 0);
                this.f18300W.setTypeface(font, 0);
                m15505e(NetworkConstants.CURRENCY_USDC);
            } else if (i == R.id.btn_coin_solana) {
                this.f18296S.setTypeface(font, 0);
                this.f18297T.setTypeface(font, 0);
                this.f18298U.setTypeface(font, 0);
                this.f18299V.setTypeface(font2, 1);
                this.f18300W.setTypeface(font, 0);
                m15505e(NetworkConstants.CURRENCY_SOLANA);
            } else if (i == R.id.btn_coin_mana) {
                this.f18296S.setTypeface(font, 0);
                this.f18297T.setTypeface(font, 0);
                this.f18298U.setTypeface(font, 0);
                this.f18299V.setTypeface(font, 0);
                this.f18300W.setTypeface(font2, 1);
                m15505e(NetworkConstants.CURRENCY_MANA);
            }
        }
    }

    /* renamed from: e */
    private void m15505e(String str) {
        MulticoinState multicoinState = this.f18317an.get(str);
        if (multicoinState == null) {
            m15489c();
        } else if (multicoinState.equals(MulticoinState.HAS_TRANSACTION)) {
            m15496d();
        } else {
            m15489c();
        }
    }

    /* renamed from: c */
    private void m15490c(int i) {
        if (getContext() != null && getContext() != null) {
            Typeface font = ResourcesCompat.getFont(getContext(), R.font.regular);
            Typeface font2 = ResourcesCompat.getFont(getContext(), R.font.bold);
            if (i == R.id.btn_crypto_graph_btn_day) {
                this.f18301X.setTypeface(font2, 1);
                this.f18302Y.setTypeface(font, 0);
                this.f18303Z.setTypeface(font, 0);
                this.f18305aa.setTypeface(font, 0);
            } else if (i == R.id.btn_crypto_graph_btn_week) {
                this.f18301X.setTypeface(font, 0);
                this.f18302Y.setTypeface(font2, 1);
                this.f18303Z.setTypeface(font, 0);
                this.f18305aa.setTypeface(font, 0);
            } else if (i == R.id.btn_crypto_graph_btn_month) {
                this.f18301X.setTypeface(font, 0);
                this.f18302Y.setTypeface(font, 0);
                this.f18303Z.setTypeface(font2, 1);
                this.f18305aa.setTypeface(font, 0);
            } else if (i == R.id.btn_crypto_graph_btn_year) {
                this.f18301X.setTypeface(font, 0);
                this.f18302Y.setTypeface(font, 0);
                this.f18303Z.setTypeface(font, 0);
                this.f18305aa.setTypeface(font2, 1);
            }
        }
    }

    /* renamed from: a */
    private void m15474a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("dcrypto_banner_top_title");
            String optString2 = jSONObject.optString("dcrypto_banner_top_subtitle");
            this.f18326k.setText(optString);
            this.f18327l.setText(optString2);
        }
    }

    /* renamed from: a */
    private void m15467a(View view, JSONObject jSONObject) {
        m15466a(view, (int) R.id.cardview_crypto_bottom_banner_1, jSONObject);
        m15466a(view, (int) R.id.cardview_crypto_bottom_banner_2, jSONObject);
        m15466a(view, (int) R.id.cardview_crypto_bottom_banner_3, jSONObject);
        m15466a(view, (int) R.id.cardview_crypto_bottom_banner_4, jSONObject);
    }

    /* renamed from: a */
    private void m15466a(View view, int i, JSONObject jSONObject) {
        CardView cardView = (CardView) view.findViewById(i);
        TextView textView = (TextView) cardView.findViewById(R.id.tv_crypto_bottom_banner_title);
        TextView textView2 = (TextView) cardView.findViewById(R.id.tv_crypto_bottom_banner_subtitle);
        Button button = (Button) cardView.findViewById(R.id.btn_crypto_bottom_banner);
        ImageView imageView = (ImageView) cardView.findViewById(R.id.iv_crypto_bottom_banner_img);
        if (i == R.id.cardview_crypto_bottom_banner_1) {
            this.f18341z = cardView;
            JSONObject optJSONObject = jSONObject.optJSONObject("dcrypto_banner_1");
            textView.setText(optJSONObject.optString("dcrypto_banner_1_title"));
            textView2.setText(optJSONObject.optString("dcrypto_banner_1_subtitle"));
            button.setText(optJSONObject.optString("dcrypto_banner_1_btn_text"));
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m15535l(view);
                }
            });
            if (getContext() != null && DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                Picasso.with(getContext()).load(optJSONObject.optString("dcrypto_banner_1_url")).placeholder((int) R.drawable.bottom_banner_pic_1).into(imageView);
            }
        } else if (i == R.id.cardview_crypto_bottom_banner_2) {
            this.f18288A = cardView;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("dcrypto_banner_2");
            textView.setText(optJSONObject2.optString("dcrypto_banner_2_title"));
            textView2.setText(optJSONObject2.optString("dcrypto_banner_2_subtitle"));
            button.setText(optJSONObject2.optString("dcrypto_banner_2_btn_text"));
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m15532k(view);
                }
            });
            if (getContext() != null && DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                Picasso.with(getContext()).load(optJSONObject2.optString("dcrypto_banner_2_url")).placeholder((int) R.drawable.bottom_banner_pic_1).into(imageView);
            }
        } else if (i == R.id.cardview_crypto_bottom_banner_3) {
            this.f18289B = cardView;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("dcrypto_banner_3");
            textView.setText(optJSONObject3.optString("dcrypto_banner_3_title"));
            textView2.setText(optJSONObject3.optString("dcrypto_banner_3_subtitle"));
            button.setText(optJSONObject3.optString("dcrypto_banner_3_btn_text"));
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m15527j(view);
                }
            });
            if (getContext() != null && DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                Picasso.with(getContext()).load(optJSONObject3.optString("dcrypto_banner_3_url")).placeholder((int) R.drawable.bottom_banner_pic_1).into(imageView);
            }
        } else if (i == R.id.cardview_crypto_bottom_banner_4) {
            this.f18290C = cardView;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("dcrypto_banner_4");
            textView.setText(optJSONObject4.optString("dcrypto_banner_4_title"));
            textView2.setText(optJSONObject4.optString("dcrypto_banner_4_subtitle"));
            button.setText(optJSONObject4.optString("dcrypto_banner_4_btn_text"));
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DCryptoMainFragment.this.m15523i(view);
                }
            });
            if (getContext() != null && DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                Picasso.with(getContext()).load(optJSONObject4.optString("dcrypto_banner_4_url")).placeholder((int) R.drawable.bottom_banner_pic_1).into(imageView);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m15535l(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_1).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void m15532k(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_2).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m15527j(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_3).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m15523i(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_4).start(getContext());
    }

    /* renamed from: w */
    private void m15551w() {
        if (getContext() != null) {
            String string = getString(R.string.Fintech_Payment_Solution_Buy_Crypto_hwEw);
            String string2 = getString(R.string.dcrypto_banner_top_subtitle);
            this.f18326k.setText(string);
            this.f18327l.setText(string2);
        }
    }

    /* renamed from: d */
    private void m15497d(View view) {
        m15465a(view, (int) R.id.cardview_crypto_bottom_banner_1);
        m15465a(view, (int) R.id.cardview_crypto_bottom_banner_2);
        m15465a(view, (int) R.id.cardview_crypto_bottom_banner_3);
        m15465a(view, (int) R.id.cardview_crypto_bottom_banner_4);
    }

    /* renamed from: a */
    private void m15465a(View view, int i) {
        if (getContext() != null) {
            CardView cardView = (CardView) view.findViewById(i);
            TextView textView = (TextView) cardView.findViewById(R.id.tv_crypto_bottom_banner_title);
            TextView textView2 = (TextView) cardView.findViewById(R.id.tv_crypto_bottom_banner_subtitle);
            Button button = (Button) cardView.findViewById(R.id.btn_crypto_bottom_banner);
            ImageView imageView = (ImageView) cardView.findViewById(R.id.iv_crypto_bottom_banner_img);
            if (DCryptoUtils.hostAppSource.equalsIgnoreCase(DCryptoUtils.SOURCE_MOUTON)) {
                button.setBackgroundResource(R.drawable.roundbutton_mouton);
            } else if (DCryptoUtils.hostAppSource.equalsIgnoreCase("latour")) {
                button.setBackgroundResource(R.drawable.roundbutton_latour);
            }
            if (i == R.id.cardview_crypto_bottom_banner_1) {
                this.f18341z = cardView;
                textView.setText(getString(R.string.dcrypto_banner_1_title));
                textView2.setText(getString(R.string.dcrypto_banner_1_subtitle));
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DCryptoMainFragment.this.m15519h(view);
                    }
                });
                imageView.setImageResource(R.drawable.bottom_banner_pic_1);
            } else if (i == R.id.cardview_crypto_bottom_banner_2) {
                this.f18288A = cardView;
                textView.setText(getString(R.string.dcrypto_banner_2_title));
                textView2.setText(getString(R.string.dcrypto_banner_2_subtitle));
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DCryptoMainFragment.this.m15514g(view);
                    }
                });
                imageView.setImageResource(R.drawable.bottom_banner_pic_2);
            } else if (i == R.id.cardview_crypto_bottom_banner_3) {
                this.f18289B = cardView;
                textView.setText(getString(R.string.dcrypto_banner_3_title));
                textView2.setText(getString(R.string.dcrypto_banner_3_subtitle));
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DCryptoMainFragment.this.m15508f(view);
                    }
                });
                imageView.setImageResource(R.drawable.bottom_banner_pic_3);
            } else if (i == R.id.cardview_crypto_bottom_banner_4) {
                this.f18290C = cardView;
                textView.setText(getString(R.string.dcrypto_banner_4_title));
                textView2.setText(getString(R.string.dcrypto_banner_4_subtitle));
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DCryptoMainFragment.this.m15502e(view);
                    }
                });
                imageView.setImageResource(R.drawable.bottom_banner_pic_4);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m15519h(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_1).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m15514g(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_2).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m15508f(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_3).start(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m15502e(View view) {
        DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_4).start(getContext());
    }

    /* renamed from: x */
    private void m15552x() {
        if (getContext() != null) {
            final GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(Payload.RESPONSE_OK);
            arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
                public void onBtnClick(DialogFragment dialogFragment, int i) {
                    globalAlertDialog.dismiss();
                }
            });
            globalAlertDialog.setButtons(arrayList);
            globalAlertDialog.setListeners(arrayList2);
            globalAlertDialog.setTitle(MulticoinUtils.getMulticoinDialogTitle(getContext(), this.f18313aj));
            globalAlertDialog.setMsg(MulticoinUtils.getMulticoinDialogSubtitle(getContext(), this.f18313aj));
            if (!globalAlertDialog.isVisible()) {
                globalAlertDialog.show(((FragmentActivity) getContext()).getSupportFragmentManager(), "pwdDialog");
            }
        }
    }

    /* renamed from: y */
    private void m15553y() {
        if (getContext() != null) {
            this.f18306ac = LEGOUICreator.showDrawerTemplate(getContext(), new LEGODrawerModel4(getString(R.string.Wallet_App_process_We_need_NqaR), getString(R.string.Wallet_App_process_You_just_supq), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                }
            }, new LEGOBtnTextAndCallback(getString(R.string.Wallet_App_process_Continue_Qujd), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (DCryptoMainFragment.this.f18291D.equalsIgnoreCase("1")) {
                        DRouter.build("pay99://one/btc/kyc_policy_page").start(DCryptoMainFragment.this.getContext());
                    } else {
                        ((Request) ((Request) DRouter.build("99OneTravel://one/full_kyc_channel").putExtra("type", "99")).putExtra("source", "7")).start(DCryptoMainFragment.this.getContext());
                    }
                    DCryptoMainFragment.this.f18306ac.dismiss();
                    OmegaUtils.ibt_microinvest_agreementpopup_continue_ck();
                }
            }), new LEGOBtnTextAndCallback(getString(R.string.Wallet_App_process_Cancel_kZXx), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    DCryptoMainFragment.this.f18306ac.dismiss();
                    OmegaUtils.ibt_microinvest_agreementpopup_cancel_ck();
                }
            })).setClickOutsideCanCancel(false).setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                }
            }));
            OmegaUtils.ibt_microinvest_agreementpopup_popup_sw();
        }
    }

    class GetPriceTimerTask extends TimerTask {
        GetPriceTimerTask() {
        }

        public void run() {
            new GetPriceAsyncTask().execute(new String[]{""});
        }
    }

    public class GetPriceAsyncTask extends AsyncTask<String, Void, String[]> {
        String server_response;

        public GetPriceAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String[] doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_GET_PRICE + ("?cryptoCurrencySymbol=" + DCryptoMainFragment.this.f18313aj + "&lang=en-US&token=") + OneLoginFacade.getStore().getToken()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetPrice requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetPriceAsyncTask", 1770);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "getprice response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetPriceAsyncTask", 1775);
                    return DCryptoMainFragment.this.m15512f(this.server_response);
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15501e();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String[] strArr) {
            super.onPostExecute(strArr);
            if (DCryptoMainFragment.shouldUpdatePrice && strArr != null && strArr.length != 0 && strArr[0] != null && strArr[1] != null) {
                SystemUtils.log(3, "Dcrypto HTTP", "" + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetPriceAsyncTask", 1809);
                DCryptoMainFragment.this.updateMainPriceTitle(strArr[0], strArr[1]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String[] m15512f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            SystemUtils.log(2, "Dcrypto HTTP", "GetPrice result = " + jSONObject.toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1821);
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (optInt == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String optString2 = optJSONObject.optString("ask_price");
                optJSONObject.optString("bid_price");
                String optString3 = optJSONObject.optString("midnight_price");
                SystemUtils.log(4, "Dcrypto HTTP", "GetPrice price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1829);
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_GET_CRYPTO_PRICE, jSONObject.toString());
                }
                return new String[]{optString2, optString3};
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    DCryptoMainFragment.this.m15501e();
                }
            });
            SystemUtils.log(4, "Dcrypto HTTP", "GetPrice error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1844);
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public class GetAccountStatusAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetAccountStatusAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_ACCOUNT_STATUS + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountStatus requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetAccountStatusAsyncTask", 1888);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetAccountStatus response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetAccountStatusAsyncTask", 1893);
                    DCryptoMainFragment.this.m15517g(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15518h();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m15517g(String str) {
        try {
            SystemUtils.log(2, "Dcrypto HTTP", "GetAccountStatus result = " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1928);
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (optInt == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.f18291D = optJSONObject.optString("is_full_kyc");
                this.f18292E = optJSONObject.optString("crypto_account_status");
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountStatus price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1941);
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_ACCOUNT_STATUS, str);
                    return;
                }
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    DCryptoMainFragment.this.m15518h();
                }
            });
            SystemUtils.log(4, "Dcrypto HTTP", "GetAccountStatus error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 1955);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class GetAccountInfoAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetAccountInfoAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_ACCOUNT_INFO + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountInfo requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetAccountInfoAsyncTask", 1977);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetAccountInfo response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetAccountInfoAsyncTask", 1982);
                    DCryptoMainFragment.this.m15521h(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15507f();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m15521h(String str) {
        ArrayList arrayList;
        String str2 = str;
        String str3 = NetworkConstants.CURRENCY_BTC;
        String str4 = "has_transaction";
        String str5 = "Default";
        try {
            SystemUtils.log(2, "Dcrypto HTTP", "GetAccountBalance result = " + str2, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2012);
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("errmsg");
            String str6 = "";
            String str7 = DCryptoUtils.KEY_HOME_ACCOUNT_BALANCE;
            if (optInt == 401) {
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountBalance errorno = " + optInt, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2018);
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountBalance error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2019);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15450B();
                    }
                });
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15507f();
                    }
                });
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), str7, str6);
                }
            } else if (optInt == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String optString2 = optJSONObject.optString("total_profit_loss");
                if ((optJSONObject.optInt(str4, 0) == 1 ? MulticoinState.HAS_TRANSACTION : MulticoinState.NO_TRANSACTION).equals(MulticoinState.HAS_TRANSACTION)) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m15449A();
                        }
                    });
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m15450B();
                        }
                    });
                }
                String optString3 = optJSONObject.optString("total_value");
                JSONArray optJSONArray = optJSONObject.optJSONArray("currency_balances");
                ArrayList arrayList2 = new ArrayList();
                int i = 0;
                while (i < optJSONArray.length()) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                    String optString4 = jSONObject2.optString(HeadCardList.HEAD_BALANCE, str5);
                    String optString5 = jSONObject2.optString("currency_symbol", str5);
                    String optString6 = jSONObject2.optString("balance_available", str5);
                    JSONArray jSONArray = optJSONArray;
                    String optString7 = jSONObject2.optString("balance_locked", str5);
                    String optString8 = jSONObject2.optString("amount_brl", str5);
                    String str8 = str7;
                    String optString9 = jSONObject2.optString("ask_price", str5);
                    String str9 = optString2;
                    String optString10 = jSONObject2.optString("bid_price", str5);
                    String str10 = optString3;
                    String optString11 = jSONObject2.optString("midnight_price", str5);
                    int i2 = i;
                    String optString12 = jSONObject2.optString("daily_profit_loss", str5);
                    ArrayList arrayList3 = arrayList2;
                    String optString13 = jSONObject2.optString("icon_url", str6);
                    String str11 = str6;
                    String str12 = str5;
                    String optString14 = jSONObject2.optString("crypto_title", str5);
                    int optInt2 = jSONObject2.optInt(str4, 0);
                    MulticoinState multicoinState = optInt2 == 1 ? MulticoinState.HAS_TRANSACTION : MulticoinState.NO_TRANSACTION;
                    boolean equalsIgnoreCase = optString5.equalsIgnoreCase(str3);
                    String str13 = NetworkConstants.CURRENCY_MANA;
                    String str14 = str3;
                    String str15 = str4;
                    String str16 = optString13;
                    int i3 = optInt2;
                    if (equalsIgnoreCase) {
                        str13 = str14;
                    } else if (optString5.equalsIgnoreCase(NetworkConstants.CURRENCY_ETH)) {
                        str13 = NetworkConstants.CURRENCY_ETH;
                    } else if (optString5.equalsIgnoreCase(NetworkConstants.CURRENCY_USDC)) {
                        str13 = NetworkConstants.CURRENCY_USDC;
                    } else if (optString5.equalsIgnoreCase(NetworkConstants.CURRENCY_SOLANA)) {
                        str13 = NetworkConstants.CURRENCY_SOLANA;
                    } else if (!optString5.equalsIgnoreCase(str13)) {
                        str13 = "null";
                    }
                    if (!str13.equalsIgnoreCase("null")) {
                        this.f18317an.put(str13, multicoinState);
                    }
                    try {
                        if (Double.parseDouble(optString6) >= 0.0d) {
                            arrayList = arrayList3;
                            try {
                                arrayList.add(new AccountInfoMulticoinBalance(optString4, optString5, optString6, optString7, optString8, optString9, optString10, optString11, optString12, i3, str16, optString14));
                            } catch (Exception e) {
                                e = e;
                            }
                        } else {
                            arrayList = arrayList3;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = arrayList3;
                        SystemUtils.log(4, "DcryptoMulticoin", e.getMessage(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2089);
                        arrayList.add(new AccountInfoMulticoinBalance(optString4, optString5, optString6, optString7, optString8, optString9, optString10, optString11, optString12, i3, str16, optString14));
                        i = i2 + 1;
                        String str17 = str;
                        arrayList2 = arrayList;
                        optJSONArray = jSONArray;
                        str7 = str8;
                        optString2 = str9;
                        optString3 = str10;
                        str6 = str11;
                        str5 = str12;
                        str3 = str14;
                        str4 = str15;
                    }
                    i = i2 + 1;
                    String str172 = str;
                    arrayList2 = arrayList;
                    optJSONArray = jSONArray;
                    str7 = str8;
                    optString2 = str9;
                    optString3 = str10;
                    str6 = str11;
                    str5 = str12;
                    str3 = str14;
                    str4 = str15;
                }
                String str18 = str7;
                new Handler(Looper.getMainLooper()).post(new Runnable(optString2, optString3, arrayList2) {
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ String f$2;
                    public final /* synthetic */ List f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        DCryptoMainFragment.this.m15486b(this.f$1, this.f$2, this.f$3);
                    }
                });
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), str18, str);
                }
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15507f();
                    }
                });
                SystemUtils.log(4, "Dcrypto HTTP", "GetAccountBalance error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2106);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public class GetDailyProfitLossAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetDailyProfitLossAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_GET_DAILY_PROFIT_LOSS + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetDailyProfitLoss requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetDailyProfitLossAsyncTask", 2126);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetDailyProfitLoss response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetDailyProfitLossAsyncTask", 2131);
                    DCryptoMainFragment.this.m15525i(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15513g();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m15525i(String str) {
        try {
            SystemUtils.log(2, "Dcrypto HTTP", "GetDailyProfitLoss result = " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2162);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (i == 0) {
                new Handler(Looper.getMainLooper()).post(new Runnable(jSONObject.optJSONObject("data").optString("daily_profit_loss")) {
                    public final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DCryptoMainFragment.this.m15540m(this.f$1);
                    }
                });
                SystemUtils.log(4, "Dcrypto HTTP", "GetDailyProfitLoss price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2170);
            } else {
                SystemUtils.log(4, "Dcrypto HTTP", "GetDailyProfitLoss error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2172);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15513g();
                    }
                });
            }
            if (getContext() != null) {
                DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_DAILY_PROFIT_AND_LOSS, str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class GetTransactionHistoryAsyncTask extends AsyncTask<String, Void, JSONObject> {
        String server_response;

        /* access modifiers changed from: protected */
        public void onPostExecute(JSONObject jSONObject) {
        }

        public GetTransactionHistoryAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public JSONObject doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_TRANSACTION_HISTORY + "?cryptoCurrencySymbol=ALL&lang=en-US&token=" + OneLoginFacade.getStore().getToken()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "GetTransactionHistory requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetTransactionHistoryAsyncTask", 2205);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetTransactionHistory response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetTransactionHistoryAsyncTask", 2209);
                    DCryptoMainFragment.this.m15529j(this.server_response);
                    return null;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.GetTransactionHistoryAsyncTask.this.mo58726xeadd0a68();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }

        /* renamed from: lambda$doInBackground$0$DCryptoMainFragment$GetTransactionHistoryAsyncTask */
        public /* synthetic */ void mo58726xeadd0a68() {
            DCryptoMainFragment.this.m15522i();
            DCryptoMainFragment.this.m15489c();
            DCryptoMainFragment.this.f18335t.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m15529j(String str) {
        try {
            SystemUtils.log(2, "Dcrypto HTTP", "GetTransactionHistory result = " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2244);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("errno");
            String optString = jSONObject.optString("errmsg");
            this.f18293P = false;
            if (i == 0) {
                JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray("orders");
                if (optJSONArray.length() > 0) {
                    this.f18293P = true;
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m15457I();
                        }
                    });
                    new Handler(Looper.getMainLooper()).post(new Runnable(m15478b(optJSONArray.optJSONObject(0))) {
                        public final /* synthetic */ BitcoinHistoryItemModel f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m15484b(this.f$1);
                        }
                    });
                    if (optJSONArray.length() > 1) {
                        new Handler(Looper.getMainLooper()).post(new Runnable(m15478b(optJSONArray.optJSONObject(1))) {
                            public final /* synthetic */ BitcoinHistoryItemModel f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                DCryptoMainFragment.this.m15470a(this.f$1);
                            }
                        });
                    }
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m15456H();
                        }
                    });
                }
                SystemUtils.log(4, "Dcrypto HTTP", "GetTransactionHistory = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2287);
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_HISTORY_ITEMS, str);
                    return;
                }
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    DCryptoMainFragment.this.m15455G();
                }
            });
            SystemUtils.log(4, "Dcrypto HTTP", "GetTransactionHistory error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2308);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void m15457I() {
        m15554z();
        OmegaUtils.ibt_microinvest_mihomepurchased_page_sw();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15484b(BitcoinHistoryItemModel bitcoinHistoryItemModel) {
        m15526j();
        m15468a(this.f18337v, bitcoinHistoryItemModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15470a(BitcoinHistoryItemModel bitcoinHistoryItemModel) {
        m15531k();
        m15468a(this.f18338w, bitcoinHistoryItemModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void m15456H() {
        m15451C();
        OmegaUtils.ibt_microinvest_mihomenotpurchased_page_sw();
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void m15455G() {
        m15522i();
        m15489c();
        this.f18335t.setVisibility(8);
        OmegaUtils.ibt_microinvest_mihomenotpurchased_page_sw();
    }

    /* renamed from: b */
    private BitcoinHistoryItemModel m15478b(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = jSONObject;
        try {
            String optString = jSONObject2.optString("sn");
            String optString2 = jSONObject2.optString("client_order_id");
            String optString3 = jSONObject2.optString("market_symbol");
            String optString4 = jSONObject2.optString("side");
            String optString5 = jSONObject2.optString(ParamConst.PARAM_CART_REMARK);
            String optString6 = jSONObject2.optString("state");
            if (!f18275F.equalsIgnoreCase(optString6) && !f18278I.equalsIgnoreCase(optString6)) {
                if (!f18277H.equalsIgnoreCase(optString6)) {
                    if (f18276G.equalsIgnoreCase(optString6)) {
                        str = "";
                    } else {
                        str = f18279J.equalsIgnoreCase(optString6) ? f18282M : DCRYPTO_NA;
                    }
                    return new BitcoinHistoryItemModel(optString, optString2, optString3, optString4, optString5, str, jSONObject2.optString("price_avg"), jSONObject2.optString(FirebaseAnalytics.Param.QUANTITY), jSONObject2.optString("quantity_executed"), jSONObject2.optString("instant_amount"), jSONObject2.optString("instant_amount_executed"), jSONObject2.optString("created_at"), jSONObject2.getLong("timestamp"));
                }
            }
            str = f18281L;
            return new BitcoinHistoryItemModel(optString, optString2, optString3, optString4, optString5, str, jSONObject2.optString("price_avg"), jSONObject2.optString(FirebaseAnalytics.Param.QUANTITY), jSONObject2.optString("quantity_executed"), jSONObject2.optString("instant_amount"), jSONObject2.optString("instant_amount_executed"), jSONObject2.optString("created_at"), jSONObject2.getLong("timestamp"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: z */
    private void m15554z() {
        if (getContext() != null) {
            this.f18335t.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m15449A() {
        if (getContext() != null) {
            m15463a(8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f18295R.getLayoutParams();
            if (getContext() != null) {
                layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (float) 30, getContext().getResources().getDisplayMetrics()), 0, 0);
            }
            this.f18295R.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m15450B() {
        m15463a(0);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f18295R.getLayoutParams();
        if (getContext() != null) {
            layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (float) 0, getContext().getResources().getDisplayMetrics()), 0, 0);
        }
        this.f18295R.setLayoutParams(layoutParams);
    }

    /* renamed from: C */
    private void m15451C() {
        if (getContext() != null) {
            m15522i();
            m15449A();
            m15489c();
            this.f18335t.setVisibility(8);
        }
    }

    public class GetUIConfigForBannersAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetUIConfigForBannersAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_GET_UI_CONFIG_FOR_BANNERS + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "get GetUIConfig requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetUIConfigForBannersAsyncTask", 2429);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetUIConfigForBannersAsyncTask", 2434);
                    DCryptoMainFragment.this.m15533k(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15452D();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m15533k(String str) {
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int i = jSONObject.getInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (i == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (this.f18304a.equalsIgnoreCase("en-US")) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject) {
                        public final /* synthetic */ JSONObject f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m15511f(this.f$1);
                        }
                    });
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject) {
                        public final /* synthetic */ JSONObject f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m15506e(this.f$1);
                        }
                    });
                } else if (this.f18304a.equalsIgnoreCase("pt-BR")) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject) {
                        public final /* synthetic */ JSONObject f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m15500d(this.f$1);
                        }
                    });
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject) {
                        public final /* synthetic */ JSONObject f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DCryptoMainFragment.this.m15494c(this.f$1);
                        }
                    });
                } else {
                    SystemUtils.log(4, "Dcrypto HTTP", "error retrieving Locale before parsing data", (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2477);
                }
                SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2482);
                if (getContext() != null) {
                    DCryptoUtils.setDcryptoCache(getContext(), DCryptoUtils.KEY_HOME_UI_CONFIG, str2);
                }
            } else {
                SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2488);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15452D();
                    }
                });
            }
            SystemUtils.log(2, "Dcrypto HTTP", "GetUIConfig result = " + str2, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2492);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m15511f(JSONObject jSONObject) {
        m15467a((View) this.f18321f, jSONObject.optJSONObject("en-US"));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m15506e(JSONObject jSONObject) {
        m15474a(jSONObject.optJSONObject("en-US").optJSONObject("dcrypto_banner_top"));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m15500d(JSONObject jSONObject) {
        m15467a((View) this.f18321f, jSONObject.optJSONObject("pt-BR"));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m15494c(JSONObject jSONObject) {
        m15474a(jSONObject.optJSONObject("pt-BR").optJSONObject("dcrypto_banner_top"));
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m15452D() {
        m15551w();
        m15497d((View) this.f18321f);
    }

    public class GetIPBlockAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetIPBlockAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_GET_IP_BLOCK + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                SystemUtils.log(4, "Dcrypto HTTP", "get IPBlock requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetIPBlockAsyncTask", 2517);
                if (httpURLConnection.getResponseCode() == 200) {
                    this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                    SystemUtils.log(4, "Dcrypto HTTP", "IPBlock response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetIPBlockAsyncTask", 2522);
                    DCryptoUtils.setIPBlockTimestamp();
                    DCryptoMainFragment.this.m15537l(this.server_response);
                    return "";
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15452D();
                    }
                });
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m15537l(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (i == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String optString2 = optJSONObject.optString("country_code");
                optJSONObject.optString("ip");
                if (optString2.equalsIgnoreCase(GlobalCountryCode.CHINA)) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m15454F();
                        }
                    });
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            DCryptoMainFragment.this.m15453E();
                        }
                    });
                }
            } else {
                SystemUtils.log(4, "Dcrypto HTTP", "processIPBlock error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2575);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        DCryptoMainFragment.this.m15452D();
                    }
                });
            }
            SystemUtils.log(2, "Dcrypto HTTP", "processIPBlock result = " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment", 2579);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void m15454F() {
        if (getContext() != null) {
            DCryptoUtils.setDcryptoIPStatus(getContext(), DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK);
        }
        this.f18312ai.getChart().post(new Runnable() {
            public final void run() {
                DCryptoMainFragment.this.m15462a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void m15453E() {
        if (getContext() != null) {
            DCryptoUtils.setDcryptoIPStatus(getContext(), DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK);
        }
    }

    public class GetCryptoTopBannersAsyncTask extends AsyncTask<String, Void, String> {
        String server_response;

        public GetCryptoTopBannersAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_CRYPTO_TOP_BANNER + OneLoginFacade.getStore().getToken() + DCryptoUtils.URL_PARAMS).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                DCryptoMainFragment.this.m15473a((URLConnection) httpURLConnection);
                SystemUtils.log(4, "Dcrypto HTTP", "get GetUIConfig requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2600);
                if (httpURLConnection.getResponseCode() != 200) {
                    return null;
                }
                this.server_response = NetworkUtils.readStream(httpURLConnection.getInputStream());
                SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig response raw = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2605);
                JSONObject jSONObject = new JSONObject(this.server_response);
                int i = jSONObject.getInt("errno");
                String optString = jSONObject.optString("errmsg");
                if (i == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    optJSONObject.optBoolean("shown", false);
                    optJSONObject.optString("title", "Default title");
                    optJSONObject.optString("subTitle", "Default subTitle");
                    optJSONObject.optString("pictureUrl", "Default pictureUrl");
                    new Handler(Looper.getMainLooper()).post(new Runnable(optJSONObject.optString("linkUrl", "Default linkUrl")) {
                        public final /* synthetic */ String f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void run() {
                            DCryptoMainFragment.GetCryptoTopBannersAsyncTask.lambda$doInBackground$0(this.f$0);
                        }
                    });
                    SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig price = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2623);
                    return "";
                }
                SystemUtils.log(4, "Dcrypto HTTP", "GetUIConfig error = " + optString, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2626);
                SystemUtils.log(2, "Dcrypto HTTP", "GetUIConfig result = " + this.server_response, (Throwable) null, "com.didi.dcrypto.DCryptoMainFragment$GetCryptoTopBannersAsyncTask", 2630);
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }

        static /* synthetic */ void lambda$doInBackground$0(String str) {
            if (str != null && !str.equalsIgnoreCase("")) {
                NetworkConstants.URL_BANNER_BOTTOM_1 = str;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15473a(URLConnection uRLConnection) {
        String str;
        Object obj = CommonProxyHolder.getProxy() == null ? null : CommonProxyHolder.getProxy().getBaseParams(getContext()).get("city_id");
        if (obj == null) {
            str = "null";
        } else {
            str = (String) obj;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Cityid", str);
        jsonObject.addProperty("FlowTag", "0");
        jsonObject.addProperty("Productid", "21032");
        jsonObject.addProperty(ServerParam.PARAM_TRIPCOUNTRY, "BR");
        jsonObject.addProperty("app_timeout_ms", "30000");
        jsonObject.addProperty("lang", "es-419");
        jsonObject.addProperty("lat", "-25.354746934932187");
        jsonObject.addProperty("lng", "-49.11376760594505");
        jsonObject.addProperty("locale", "es_CO");
        jsonObject.addProperty("location_cityid", str);
        jsonObject.addProperty("location_country", "BR");
        jsonObject.addProperty("passengerUtcOffset", "-180");
        jsonObject.addProperty("product_id", "21032");
        jsonObject.addProperty("utc_offset", "-180");
        uRLConnection.setRequestProperty("didi-header-hint-content", jsonObject.toString());
    }
}
