package com.didi.component.expectation.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.util.DecimalUtils;
import com.didi.component.common.view.AmountDecimalEditText;
import com.didi.component.expectation.model.FlexRaiseSheet;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.view.SimplePopupBase;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class FlexRaiseSheetView extends ConstraintLayout {

    /* renamed from: a */
    private final Logger f15545a = LoggerFactory.getLogger("FlexRaiseSheetView");

    /* renamed from: b */
    private View f15546b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f15547c;

    /* renamed from: d */
    private TextView f15548d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f15549e;

    /* renamed from: f */
    private TextView f15550f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f15551g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f15552h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextView f15553i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AmountDecimalEditText f15554j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f15555k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public FlexRaiseSheet f15556l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public SimplePopupBase f15557m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public BigDecimal f15558n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public BigDecimal f15559o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public BigDecimal f15560p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public BigDecimal f15561q;

    /* renamed from: r */
    private String f15562r;

    public FlexRaiseSheetView(Context context) {
        super(context);
        m12848a(context);
    }

    public FlexRaiseSheetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12848a(context);
    }

    public FlexRaiseSheetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12848a(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    private void m12848a(Context context) {
        this.f15547c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_flex_raise_sheet_layout, this, true);
        this.f15546b = inflate;
        this.f15548d = (TextView) inflate.findViewById(R.id.bargain_card_title);
        this.f15549e = (TextView) this.f15546b.findViewById(R.id.bargain_reduce_price_btn);
        this.f15550f = (TextView) this.f15546b.findViewById(R.id.bargain_currency_symbol);
        this.f15554j = (AmountDecimalEditText) this.f15546b.findViewById(R.id.price_input_et);
        if (DRtlToolkit.rtl()) {
            this.f15554j.setLayoutDirection(1);
        }
        this.f15555k = this.f15546b.findViewById(R.id.price_cursor_bottomline);
        this.f15551g = (TextView) this.f15546b.findViewById(R.id.bargain_increase_price_btn);
        this.f15552h = (TextView) this.f15546b.findViewById(R.id.discount_tips);
        this.f15553i = (TextView) this.f15546b.findViewById(R.id.flex_confirm_price_btn);
        this.f15549e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String standardAmountString = DecimalUtils.getStandardAmountString(FlexRaiseSheetView.this.f15554j.getText().toString());
                BigDecimal subtract = new BigDecimal(standardAmountString).subtract(FlexRaiseSheetView.this.f15561q);
                FlexRaiseSheetView flexRaiseSheetView = FlexRaiseSheetView.this;
                flexRaiseSheetView.m12854b("reduce price " + subtract.toString() + "/ " + FlexRaiseSheetView.this.f15558n);
                if (subtract.compareTo(FlexRaiseSheetView.this.f15558n) < 0) {
                    FlexRaiseSheetView.this.f15549e.setEnabled(false);
                    return;
                }
                FlexRaiseSheetView.this.m12847a(2, standardAmountString, subtract.toString());
                FlexRaiseSheetView.this.f15551g.setEnabled(true);
                FlexRaiseSheetView.this.f15554j.setText(Elvish.Companion.getInstance().formatNumber(subtract, -1, 1));
                if (subtract.compareTo(FlexRaiseSheetView.this.f15558n) == 0) {
                    FlexRaiseSheetView.this.f15553i.setEnabled(false);
                }
            }
        });
        this.f15551g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String standardAmountString = DecimalUtils.getStandardAmountString(FlexRaiseSheetView.this.f15554j.getText().toString());
                BigDecimal add = new BigDecimal(standardAmountString).add(FlexRaiseSheetView.this.f15560p);
                FlexRaiseSheetView flexRaiseSheetView = FlexRaiseSheetView.this;
                flexRaiseSheetView.m12854b("add price " + add.toString() + "/ " + FlexRaiseSheetView.this.f15558n);
                if (add.compareTo(FlexRaiseSheetView.this.f15559o) > 0) {
                    FlexRaiseSheetView.this.f15551g.setEnabled(false);
                    return;
                }
                FlexRaiseSheetView.this.m12847a(1, standardAmountString, add.toString());
                FlexRaiseSheetView.this.f15549e.setEnabled(true);
                if (add.compareTo(FlexRaiseSheetView.this.f15558n) == 0) {
                    FlexRaiseSheetView.this.f15553i.setEnabled(false);
                }
                FlexRaiseSheetView.this.f15554j.setText(Elvish.Companion.getInstance().formatNumber(add, -1, 1));
            }
        });
        this.f15553i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FlexRaiseSheetView.this.f15553i.setEnabled(false);
                String standardAmountString = DecimalUtils.getStandardAmountString(FlexRaiseSheetView.this.f15554j.getText().toString());
                FlexRaiseSheetView.this.m12851a(standardAmountString);
                HashMap hashMap = new HashMap();
                hashMap.put("k", "click");
                hashMap.put(RavenKey.VERSION, "raisefare_confirm");
                hashMap.put("price", FlexRaiseSheetView.this.f15558n);
                hashMap.put("suggest_price", standardAmountString);
                GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_confirm_ck", (Map<String, Object>) hashMap);
            }
        });
        this.f15555k.setEnabled(false);
        this.f15554j.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                FlexRaiseSheetView.this.f15555k.setEnabled(z);
                FlexRaiseSheetView.this.f15554j.setCursorVisible(z);
                if (z) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("k", "click");
                    hashMap.put(RavenKey.VERSION, "raisefare_change_input");
                    hashMap.put("price", FlexRaiseSheetView.this.f15558n);
                    GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_change_input_ck", (Map<String, Object>) hashMap);
                }
            }
        });
        this.f15554j.setCustomizedAfterTextChangeListener(new AmountDecimalEditText.CustomizedAfterTextChangeListener() {
            public void afterTextChanged(String str) {
                FlexRaiseSheetView.this.f15553i.setEnabled(str != null && !TextUtils.isEmpty(str));
                if (TextUtils.isEmpty(str)) {
                    FlexRaiseSheetView.this.f15549e.setEnabled(false);
                    FlexRaiseSheetView.this.f15551g.setEnabled(false);
                    return;
                }
                BigDecimal bigDecimal = new BigDecimal(DecimalUtils.getStandardAmountString(str));
                if (bigDecimal.compareTo(FlexRaiseSheetView.this.f15558n) < 0) {
                    FlexRaiseSheetView.this.f15552h.setVisibility(0);
                    FlexRaiseSheetView.this.f15556l.min_tips.bindTextView(FlexRaiseSheetView.this.f15552h);
                    FlexRaiseSheetView.this.f15549e.setEnabled(false);
                    FlexRaiseSheetView.this.f15553i.setEnabled(false);
                } else if (bigDecimal.compareTo(FlexRaiseSheetView.this.f15559o) > 0) {
                    FlexRaiseSheetView.this.f15551g.setEnabled(false);
                    FlexRaiseSheetView.this.f15552h.setVisibility(0);
                    FlexRaiseSheetView.this.f15556l.max_tips.bindTextView(FlexRaiseSheetView.this.f15552h);
                    FlexRaiseSheetView.this.f15553i.setEnabled(false);
                } else {
                    FlexRaiseSheetView.this.f15552h.setVisibility(8);
                    FlexRaiseSheetView.this.f15553i.setEnabled(true);
                    FlexRaiseSheetView.this.f15551g.setEnabled(true);
                    FlexRaiseSheetView.this.f15549e.setEnabled(true);
                    if (bigDecimal.subtract(FlexRaiseSheetView.this.f15561q).compareTo(FlexRaiseSheetView.this.f15558n) < 0) {
                        FlexRaiseSheetView.this.f15549e.setEnabled(false);
                    } else if (bigDecimal.add(FlexRaiseSheetView.this.f15560p).compareTo(FlexRaiseSheetView.this.f15559o) > 0) {
                        FlexRaiseSheetView.this.f15551g.setEnabled(false);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12847a(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, "raisefare_change");
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("price", str);
        hashMap.put("suggest_price", str2);
        GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_change_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12851a(String str) {
        m12854b("price commit " + str + "/ link " + this.f15562r);
        try {
            if (!TextUtils.isEmpty(this.f15562r)) {
                String str2 = this.f15562r;
                String queryParameter = Uri.parse(str2).getQueryParameter("query");
                if (!TextUtils.isEmpty(queryParameter)) {
                    String substring = str2.substring(0, str2.indexOf("?"));
                    JSONObject jSONObject = new JSONObject(URLDecoder.decode(queryParameter, "UTF-8"));
                    jSONObject.put("new_price", str);
                    ((Request) DRouter.build(substring + "?query=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).putExtra("KEY_COMMIT_SCENE", XERequestKey.SCENE_TRIP)).start(this.f15547c, new RouterCallback() {
                        /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
                        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onResult(com.didi.drouter.router.Result r6) {
                            /*
                                r5 = this;
                                java.lang.String r0 = "extension"
                                java.lang.String r1 = "data"
                                java.lang.String r2 = "KEY_CALLBACK"
                                java.lang.String r6 = r6.getString(r2)
                                boolean r2 = android.text.TextUtils.isEmpty(r6)
                                r3 = 1
                                if (r2 == 0) goto L_0x0022
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this
                                java.lang.String r0 = "xengine commit failed"
                                r6.m12854b((java.lang.String) r0)
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this
                                android.widget.TextView r6 = r6.f15553i
                                r6.setEnabled(r3)
                                return
                            L_0x0022:
                                r2 = 0
                                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0061 }
                                r4.<init>(r6)     // Catch:{ JSONException -> 0x0061 }
                                boolean r6 = r4.has(r1)     // Catch:{ JSONException -> 0x0061 }
                                if (r6 == 0) goto L_0x005e
                                org.json.JSONObject r6 = r4.optJSONObject(r1)     // Catch:{ JSONException -> 0x0061 }
                                boolean r1 = r6.has(r0)     // Catch:{ JSONException -> 0x0061 }
                                if (r1 == 0) goto L_0x005e
                                org.json.JSONObject r6 = r6.optJSONObject(r0)     // Catch:{ JSONException -> 0x0061 }
                                if (r6 == 0) goto L_0x005f
                                java.lang.String r0 = "errno"
                                int r0 = r6.optInt(r0)     // Catch:{ JSONException -> 0x0061 }
                                if (r0 == 0) goto L_0x005f
                                java.lang.String r0 = "errmsg"
                                java.lang.String r6 = r6.optString(r0)     // Catch:{ JSONException -> 0x0061 }
                                com.didi.component.expectation.view.FlexRaiseSheetView r0 = com.didi.component.expectation.view.FlexRaiseSheetView.this     // Catch:{ JSONException -> 0x0061 }
                                android.content.Context r0 = r0.f15547c     // Catch:{ JSONException -> 0x0061 }
                                com.didi.global.globaluikit.toast.LEGOToastHelper.showToast(r0, r6)     // Catch:{ JSONException -> 0x0061 }
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this     // Catch:{ JSONException -> 0x0061 }
                                android.widget.TextView r6 = r6.f15553i     // Catch:{ JSONException -> 0x0061 }
                                r6.setEnabled(r3)     // Catch:{ JSONException -> 0x0061 }
                            L_0x005e:
                                r3 = 0
                            L_0x005f:
                                r2 = r3
                                goto L_0x0065
                            L_0x0061:
                                r6 = move-exception
                                r6.printStackTrace()
                            L_0x0065:
                                if (r2 == 0) goto L_0x0078
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this
                                com.didi.sdk.view.SimplePopupBase r6 = r6.f15557m
                                if (r6 == 0) goto L_0x0078
                                com.didi.component.expectation.view.FlexRaiseSheetView r6 = com.didi.component.expectation.view.FlexRaiseSheetView.this
                                com.didi.sdk.view.SimplePopupBase r6 = r6.f15557m
                                r6.dismiss()
                            L_0x0078:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.FlexRaiseSheetView.C63106.onResult(com.didi.drouter.router.Result):void");
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSimplePopupBase(SimplePopupBase simplePopupBase) {
        this.f15557m = simplePopupBase;
    }

    public void setData(FlexRaiseSheet flexRaiseSheet) {
        this.f15556l = flexRaiseSheet;
        if (flexRaiseSheet.config == null) {
            m12854b("data config is null");
            return;
        }
        this.f15558n = new BigDecimal(flexRaiseSheet.config.current_price);
        this.f15559o = new BigDecimal(flexRaiseSheet.config.max_price);
        this.f15560p = new BigDecimal(flexRaiseSheet.config.addPrice_count);
        this.f15561q = new BigDecimal(flexRaiseSheet.config.subPrice_count);
        this.f15562r = flexRaiseSheet.btn_submit_link;
        BigDecimal bigDecimal = new BigDecimal(flexRaiseSheet.config.current_price);
        if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
            this.f15554j.setText(Elvish.Companion.getInstance().formatNumber(bigDecimal, -1, 1));
        }
        m12846a();
    }

    /* renamed from: a */
    private void m12846a() {
        FlexRaiseSheet flexRaiseSheet = this.f15556l;
        if (flexRaiseSheet != null) {
            flexRaiseSheet.title.bindTextView(this.f15548d);
            this.f15549e.setEnabled(false);
            this.f15555k.setEnabled(false);
            this.f15553i.setEnabled(false);
            try {
                this.f15553i.setBackground(DidiThemeManager.getIns().getResPicker(this.f15547c).getDrawable(R.attr.global_overall_main_button_selector));
                this.f15553i.setTextColor(ContextCompat.getColorStateList(this.f15547c, DidiThemeManager.getIns().getResPicker(this.f15547c).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
                if (this.f15556l.btn_title != null && !TextUtils.isEmpty(this.f15556l.btn_title)) {
                    this.f15553i.setText(this.f15556l.btn_title);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f15556l.config != null) {
                if (!TextUtils.isEmpty(this.f15556l.config.subPrice_count)) {
                    this.f15549e.setText("-" + Elvish.Companion.getInstance().formatNumber(Integer.valueOf(this.f15556l.config.subPrice_count), 0, 1));
                }
                if (!TextUtils.isEmpty(this.f15556l.config.addPrice_count)) {
                    this.f15551g.setText("+" + Elvish.Companion.getInstance().formatNumber(Integer.valueOf(this.f15556l.config.addPrice_count), 0, 1));
                }
                if (!TextUtils.isEmpty(this.f15556l.config.currency_symbol)) {
                    this.f15550f.setText(this.f15556l.config.currency_symbol);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12854b(String str) {
        this.f15545a.info(str, new Object[0]);
    }
}
