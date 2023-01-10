package com.didi.component.comp_flex.offer_price;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.util.DecimalUtils;
import com.didi.component.common.view.AmountDecimalEditText;
import com.didi.component.core.PresenterGroup;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class FlexOfferPriceFragment extends AbsNormalFragment {
    public static final String KEY_FLEX_DATA = "felx_offer_raise_data";

    /* renamed from: a */
    private View f14019a;

    /* renamed from: b */
    private TextView f14020b;

    /* renamed from: c */
    private TextView f14021c;

    /* renamed from: d */
    private TextView f14022d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AmountDecimalEditText f14023e;

    /* renamed from: f */
    private TextView f14024f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f14025g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public BigDecimal f14026h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BigDecimal f14027i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Context f14028j;

    /* renamed from: k */
    private FlexOfferFragmentPresenter f14029k;

    /* renamed from: l */
    private View f14030l;

    /* renamed from: m */
    private final Logger f14031m = LoggerFactory.getLogger("FlexOfferPriceDialog");
    public JSONObject maxTipsSheet;
    public JSONObject minTipsSheet;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11621a(String str) {
        this.f14031m.info(str, new Object[0]);
    }

    public static FlexOfferPriceFragment newInstance(String str) {
        FlexOfferPriceFragment flexOfferPriceFragment = new FlexOfferPriceFragment();
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(KEY_FLEX_DATA, str);
        }
        flexOfferPriceFragment.setArguments(bundle);
        return flexOfferPriceFragment;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14030l = layoutInflater.inflate(R.layout.flex_offer_price_layout, viewGroup, false);
        initView();
        return this.f14030l;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f14028j = getContext();
        View findViewById = this.f14030l.findViewById(R.id.flex_back_iv);
        this.f14019a = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put("k", "click");
                hashMap.put(RavenKey.VERSION, "offerprice_back");
                GlobalOmegaUtils.trackEvent("ibt_gp_offerprice_back_ck", (Map<String, Object>) hashMap);
                FlexOfferPriceFragment.this.m11625c();
            }
        });
        this.f14020b = (TextView) this.f14030l.findViewById(R.id.price_title);
        this.f14021c = (TextView) this.f14030l.findViewById(R.id.sub_price_title);
        this.f14022d = (TextView) this.f14030l.findViewById(R.id.flex_currency_symbol);
        this.f14023e = (AmountDecimalEditText) this.f14030l.findViewById(R.id.price_input_et);
        if (DRtlToolkit.rtl()) {
            this.f14023e.setLayoutDirection(1);
        }
        this.f14024f = (TextView) this.f14030l.findViewById(R.id.reference_price);
        TextView textView = (TextView) this.f14030l.findViewById(R.id.flex_confirm_price_btn);
        this.f14025g = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FlexOfferPriceFragment.this.f14025g.setEnabled(false);
                String obj = FlexOfferPriceFragment.this.f14023e.getText().toString();
                String standardAmountString = DecimalUtils.getStandardAmountString(obj);
                FlexOfferPriceFragment flexOfferPriceFragment = FlexOfferPriceFragment.this;
                flexOfferPriceFragment.m11621a("flex_confirm_price_btn onclick price =" + standardAmountString + "/ minPrice=" + FlexOfferPriceFragment.this.f14026h + "/ maxPrice=" + FlexOfferPriceFragment.this.f14027i + "? bargainAmountInputtedText= " + obj);
                HashMap hashMap = new HashMap();
                hashMap.put("k", "click");
                hashMap.put(RavenKey.VERSION, "offerprice_request");
                hashMap.put("price", standardAmountString);
                GlobalOmegaUtils.trackEvent("ibt_gp_offerprice_request_ck", (Map<String, Object>) hashMap);
                BigDecimal bigDecimal = new BigDecimal(standardAmountString);
                if (bigDecimal.compareTo(FlexOfferPriceFragment.this.f14026h) < 0) {
                    FlexOfferPriceFragment.this.m11618a();
                } else if (bigDecimal.compareTo(FlexOfferPriceFragment.this.f14027i) > 0) {
                    FlexOfferPriceFragment.this.m11623b();
                } else {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.SendOrder.EVENT_ENTER_CONFIRM_ADDRESS, standardAmountString);
                    FlexOfferPriceFragment.this.m11625c();
                }
            }
        });
        this.f14023e.setCustomizedAfterTextChangeListener(new AmountDecimalEditText.CustomizedAfterTextChangeListener() {
            public void afterTextChanged(String str) {
                FlexOfferPriceFragment.this.f14025g.setEnabled(str != null && !TextUtils.isEmpty(str));
            }
        });
        this.f14025g.setEnabled(false);
        Bundle arguments = getArguments();
        if (!(arguments == null || arguments.getString(KEY_FLEX_DATA) == null)) {
            OfferFlexPriceModel offerFlexPriceModel = new OfferFlexPriceModel();
            offerFlexPriceModel.parse(arguments.getString(KEY_FLEX_DATA));
            setData(offerFlexPriceModel);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("k", "access");
        hashMap.put(RavenKey.VERSION, "offerprice");
        GlobalOmegaUtils.trackEvent("ibt_gp_offerprice_sw", (Map<String, Object>) hashMap);
    }

    public void autoShowKeyboard() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                ((InputMethodManager) FlexOfferPriceFragment.this.f14023e.getContext().getSystemService("input_method")).showSoftInput(FlexOfferPriceFragment.this.f14023e, 0);
            }
        }, 500);
    }

    public void hideKeyboard() {
        AmountDecimalEditText amountDecimalEditText = this.f14023e;
        if (amountDecimalEditText != null) {
            ((InputMethodManager) amountDecimalEditText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f14023e.getWindowToken(), 0);
        }
    }

    public void setData(OfferFlexPriceModel offerFlexPriceModel) {
        if (offerFlexPriceModel == null) {
            m11621a("offer price data is null");
            return;
        }
        this.f14026h = new BigDecimal(offerFlexPriceModel.min_price);
        this.f14027i = new BigDecimal(offerFlexPriceModel.max_price);
        this.minTipsSheet = offerFlexPriceModel.minTipsSheet;
        this.maxTipsSheet = offerFlexPriceModel.maxTipsSheet;
        if (!TextUtils.isEmpty(offerFlexPriceModel.recommend_price)) {
            BigDecimal bigDecimal = new BigDecimal(offerFlexPriceModel.recommend_price);
            if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
                this.f14023e.setText(Elvish.Companion.getInstance().formatNumber(bigDecimal, -1, 1));
            }
        }
        this.f14023e.requestFocus();
        offerFlexPriceModel.title.bindTextView(this.f14020b);
        offerFlexPriceModel.sub_title.bindTextView(this.f14021c);
        this.f14022d.setText(offerFlexPriceModel.currency_symbol);
        offerFlexPriceModel.reference_price.bindTextView(this.f14024f);
        this.f14025g.setText(offerFlexPriceModel.button_text);
        this.f14025g.setEnabled(false);
        try {
            this.f14025g.setBackground(DidiThemeManager.getIns().getResPicker(this.f14030l.getContext()).getDrawable(R.attr.global_overall_main_button_selector));
            this.f14025g.setTextColor(ContextCompat.getColorStateList(this.f14028j, DidiThemeManager.getIns().getResPicker(this.f14028j).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
            if (offerFlexPriceModel.button_text != null && !TextUtils.isEmpty(offerFlexPriceModel.button_text)) {
                this.f14025g.setText(offerFlexPriceModel.button_text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        autoShowKeyboard();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11618a() {
        GGKConfigManager.legoConfig(getActivity(), this.minTipsSheet, "passenger_newSheet", new GGKConfigCallbackAdapter() {
            public boolean sheetClickLis(LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
                if (lEGODrawer == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    DRouter.build(str).start(FlexOfferPriceFragment.this.f14028j);
                    FlexOfferPriceFragment.this.m11625c();
                }
                FlexOfferPriceFragment.this.f14025g.setEnabled(true);
                if (buttonModel.nodismiss == 1) {
                    return false;
                }
                lEGODrawer.dismiss();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11623b() {
        GGKConfigManager.legoConfig(getActivity(), this.maxTipsSheet, "passenger_newSheet", new GGKConfigCallbackAdapter() {
            public boolean sheetClickLis(LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
                if (lEGODrawer == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    DRouter.build(str).start(FlexOfferPriceFragment.this.f14028j);
                    FlexOfferPriceFragment.this.m11625c();
                }
                FlexOfferPriceFragment.this.f14025g.setEnabled(true);
                if (buttonModel.nodismiss == 1) {
                    return false;
                }
                lEGODrawer.dismiss();
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        FlexOfferFragmentPresenter flexOfferFragmentPresenter = new FlexOfferFragmentPresenter(getContext(), getArguments());
        this.f14029k = flexOfferFragmentPresenter;
        return flexOfferFragmentPresenter;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11625c() {
        getActivity().finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.f14030l = null;
        hideKeyboard();
    }
}
