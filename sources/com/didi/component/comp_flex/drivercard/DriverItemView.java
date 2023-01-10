package com.didi.component.comp_flex.drivercard;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.FormatUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.comp_flex.drivercard.FlexTemplateDriverModel;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverItemView extends FrameLayout {

    /* renamed from: c */
    private static final String f13989c = "[";

    /* renamed from: d */
    private static final String f13990d = "]";

    /* renamed from: A */
    private long f13991A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public Map<String, Object> f13992B = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f13993a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f13994b;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f13995e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ProgressBar f13996f;

    /* renamed from: g */
    private CircleImageView f13997g;

    /* renamed from: h */
    private TextView f13998h;

    /* renamed from: i */
    private TextView f13999i;

    /* renamed from: j */
    private TextView f14000j;

    /* renamed from: k */
    private TextView f14001k;

    /* renamed from: l */
    private TextView f14002l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public TextView f14003m;

    /* renamed from: n */
    private ImageView f14004n;

    /* renamed from: o */
    private ImageView f14005o;

    /* renamed from: p */
    private View f14006p;

    /* renamed from: q */
    private LinearLayout f14007q;

    /* renamed from: r */
    private TextView f14008r;

    /* renamed from: s */
    private TextView f14009s;

    /* renamed from: t */
    private LottieAnimationView f14010t;

    /* renamed from: u */
    private LottieAnimationView f14011u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public FlexTemplateDriverModel.TemplateDriverData f14012v;

    /* renamed from: w */
    private CountDownTimer f14013w;

    /* renamed from: x */
    private int f14014x = 0;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public OnOperationDriverCardListener f14015y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public long f14016z;

    public interface OnOperationDriverCardListener {
        void engineCommit(boolean z);

        void removeItem(FlexTemplateDriverModel.TemplateDriverData templateDriverData);
    }

    public DriverItemView(Context context) {
        super(context);
        this.f13994b = context;
        m11603a(context);
    }

    public DriverItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13994b = context;
        m11603a(context);
    }

    public DriverItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13994b = context;
        m11603a(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13993a.info("onDetachedFromWindow: DriverItemView ", new Object[0]);
        CountDownTimer countDownTimer = this.f14013w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f14013w = null;
        }
    }

    public void setListener(OnOperationDriverCardListener onOperationDriverCardListener) {
        this.f14015y = onOperationDriverCardListener;
    }

    /* renamed from: a */
    private void m11603a(Context context) {
        setBackground(ContextCompat.getDrawable(this.f13994b, R.drawable.flex_list_card_common_bg));
        View inflate = LayoutInflater.from(context).inflate(R.layout.flex_driver_match_item_layout, this, false);
        this.f13995e = inflate;
        this.f13996f = (ProgressBar) inflate.findViewById(R.id.avatar_progressBar);
        this.f13997g = (CircleImageView) this.f13995e.findViewById(R.id.avatar_iv);
        this.f13998h = (TextView) this.f13995e.findViewById(R.id.fee_price);
        this.f13999i = (TextView) this.f13995e.findViewById(R.id.score_tv);
        this.f14006p = this.f13995e.findViewById(R.id.flex_driver_score_layout);
        this.f14000j = (TextView) this.f13995e.findViewById(R.id.eta_distance);
        this.f14001k = (TextView) this.f13995e.findViewById(R.id.eda);
        this.f14002l = (TextView) this.f13995e.findViewById(R.id.car_brand_tv);
        this.f14004n = (ImageView) this.f13995e.findViewById(R.id.score_iv);
        this.f14007q = (LinearLayout) this.f13995e.findViewById(R.id.flex_btn_container);
        this.f14005o = (ImageView) this.f13995e.findViewById(R.id.flex_car_img);
        this.f14003m = (TextView) this.f13995e.findViewById(R.id.countdown_tv);
        this.f14014x = 0;
        addView(this.f13995e);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11605a(final String str, String str2, final boolean z) {
        this.f14014x = z ? 1 : 2;
        OnOperationDriverCardListener onOperationDriverCardListener = this.f14015y;
        if (onOperationDriverCardListener != null) {
            onOperationDriverCardListener.engineCommit(true);
        }
        this.f13992B.put("tag", z ? "reject" : "accept");
        this.f13992B.put("time", Long.valueOf(System.currentTimeMillis() - this.f13991A));
        GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_ck");
        ((Request) DRouter.build(str).putExtra("KEY_COMMIT_SCENE", XERequestKey.SCENE_TRIP)).start(this.f13994b, new RouterCallback() {
            /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
            /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResult(com.didi.drouter.router.Result r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = "extension"
                    java.lang.String r1 = "data"
                    com.didi.component.comp_flex.drivercard.DriverItemView r2 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.sdk.logging.Logger r2 = r2.f13993a
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "onResult: 司机卡片 数据提交 link "
                    r3.append(r4)
                    java.lang.String r4 = r5
                    r3.append(r4)
                    java.lang.String r4 = " reject "
                    r3.append(r4)
                    boolean r4 = r7
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r4 = 0
                    java.lang.Object[] r5 = new java.lang.Object[r4]
                    r2.info((java.lang.String) r3, (java.lang.Object[]) r5)
                    java.lang.String r2 = "KEY_CALLBACK"
                    java.lang.String r7 = r7.getString(r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r7)
                    if (r2 == 0) goto L_0x004b
                    com.didi.component.comp_flex.drivercard.DriverItemView r7 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r7 = r7.f14015y
                    if (r7 == 0) goto L_0x004a
                    com.didi.component.comp_flex.drivercard.DriverItemView r7 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r7 = r7.f14015y
                    r7.engineCommit(r4)
                L_0x004a:
                    return
                L_0x004b:
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0082 }
                    r2.<init>(r7)     // Catch:{ JSONException -> 0x0082 }
                    boolean r7 = r2.has(r1)     // Catch:{ JSONException -> 0x0082 }
                    if (r7 == 0) goto L_0x0086
                    org.json.JSONObject r7 = r2.optJSONObject(r1)     // Catch:{ JSONException -> 0x0082 }
                    if (r7 == 0) goto L_0x0086
                    boolean r1 = r7.has(r0)     // Catch:{ JSONException -> 0x0082 }
                    if (r1 == 0) goto L_0x0086
                    org.json.JSONObject r7 = r7.optJSONObject(r0)     // Catch:{ JSONException -> 0x0082 }
                    if (r7 == 0) goto L_0x0080
                    java.lang.String r0 = "errno"
                    int r0 = r7.optInt(r0)     // Catch:{ JSONException -> 0x0082 }
                    if (r0 == 0) goto L_0x0080
                    java.lang.String r0 = "errmsg"
                    java.lang.String r7 = r7.optString(r0)     // Catch:{ JSONException -> 0x0082 }
                    com.didi.component.comp_flex.drivercard.DriverItemView r0 = com.didi.component.comp_flex.drivercard.DriverItemView.this     // Catch:{ JSONException -> 0x0082 }
                    android.content.Context r0 = r0.f13994b     // Catch:{ JSONException -> 0x0082 }
                    com.didi.global.globaluikit.toast.LEGOToastHelper.showToast(r0, r7)     // Catch:{ JSONException -> 0x0082 }
                    goto L_0x0086
                L_0x0080:
                    r7 = 1
                    goto L_0x0087
                L_0x0082:
                    r7 = move-exception
                    r7.printStackTrace()
                L_0x0086:
                    r7 = 0
                L_0x0087:
                    com.didi.component.comp_flex.drivercard.DriverItemView r0 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r0 = r0.f14015y
                    if (r0 == 0) goto L_0x00ad
                    com.didi.component.comp_flex.drivercard.DriverItemView r0 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r0 = r0.f14015y
                    r0.engineCommit(r4)
                    if (r7 == 0) goto L_0x00ad
                    boolean r7 = r7
                    if (r7 == 0) goto L_0x00ad
                    com.didi.component.comp_flex.drivercard.DriverItemView r7 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.DriverItemView$OnOperationDriverCardListener r7 = r7.f14015y
                    com.didi.component.comp_flex.drivercard.DriverItemView r0 = com.didi.component.comp_flex.drivercard.DriverItemView.this
                    com.didi.component.comp_flex.drivercard.FlexTemplateDriverModel$TemplateDriverData r0 = r0.f14012v
                    r7.removeItem(r0)
                L_0x00ad:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.comp_flex.drivercard.DriverItemView.C55091.onResult(com.didi.drouter.router.Result):void");
            }
        });
    }

    public void setData(final FlexTemplateDriverModel.TemplateDriverData templateDriverData) {
        if (templateDriverData != null) {
            this.f14012v = templateDriverData;
            if (!TextUtils.isEmpty(templateDriverData.did)) {
                this.f13992B.put(CarServerParam.PARAM_DRIVER_ID, templateDriverData.did);
            }
            if (!TextUtils.isEmpty(templateDriverData.bargainId)) {
                this.f13992B.put("budget_id", templateDriverData.bargainId);
            }
            if (templateDriverData.price != null && !TextUtils.isEmpty(templateDriverData.price.getContent())) {
                templateDriverData.price.bindTextView(this.f13998h);
                this.f13992B.put("price", templateDriverData.price.getContent());
            }
            if (templateDriverData.carBrand != null && !TextUtils.isEmpty(templateDriverData.carBrand.getContent())) {
                templateDriverData.carBrand.bindTextView(this.f14002l);
            }
            if (templateDriverData.eta != null && !TextUtils.isEmpty(templateDriverData.eta.getContent())) {
                templateDriverData.eta.bindTextView(this.f14000j);
                this.f13992B.put("eta", templateDriverData.eta.getContent());
            }
            if (templateDriverData.eda != null && !TextUtils.isEmpty(templateDriverData.eda.getContent())) {
                templateDriverData.eda.bindTextView(this.f14001k);
                this.f13992B.put("eda", templateDriverData.eda.getContent());
            }
            if (!TextUtils.isEmpty(templateDriverData.carImg)) {
                ((RequestBuilder) ((RequestBuilder) Glide.with(this.f13994b).asBitmap().load(templateDriverData.carImg).placeholder((int) R.drawable.flex_driver_default_car)).error((int) R.drawable.flex_driver_default_car)).into(this.f14005o);
            }
            if (!TextUtils.isEmpty(templateDriverData.avatar)) {
                ((RequestBuilder) ((RequestBuilder) Glide.with(this.f13994b).asBitmap().load(templateDriverData.avatar).placeholder((int) R.drawable.flex_driver_avatar)).error((int) R.drawable.flex_driver_avatar)).into((ImageView) this.f13997g);
            }
            boolean z = false;
            if (templateDriverData.star != 0.0d) {
                this.f14006p.setVisibility(0);
                if (!TextUtils.isEmpty(templateDriverData.starUrl)) {
                    ((RequestBuilder) ((RequestBuilder) Glide.with(this.f13994b.getApplicationContext()).load(templateDriverData.starUrl).placeholder((int) R.drawable.flex_driver_five_star)).error((int) R.drawable.flex_driver_five_star)).into(this.f14004n);
                }
                this.f13992B.put("driver_star", Double.valueOf(templateDriverData.star));
                this.f13999i.setText(String.valueOf(templateDriverData.star));
            } else {
                this.f14006p.setVisibility(8);
            }
            if (templateDriverData.optionBtns != null && templateDriverData.optionBtns.size() == 2) {
                for (int i = 0; i < templateDriverData.optionBtns.size(); i++) {
                    final FlexTemplateDriverModel.OptionBtn optionBtn = templateDriverData.optionBtns.get(i);
                    if (optionBtn != null) {
                        View inflate = LayoutInflater.from(this.f13994b).inflate(R.layout.flex_driver_btn_layout, this.f14007q, false);
                        if (i == 1) {
                            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = UIUtils.dip2pxInt(this.f13994b, 15.0f);
                            }
                        }
                        this.f14007q.addView(inflate);
                        TextView textView = (TextView) inflate.findViewById(R.id.flex_driver_btn);
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.flex_driver_animation_view);
                        if (optionBtn.type == 0) {
                            this.f14008r = textView;
                            this.f14010t = lottieAnimationView;
                            textView.setText(optionBtn.text);
                            this.f14008r.setBackground(DidiThemeManager.getIns().getResPicker(this.f13994b).getDrawable(R.attr.global_overall_secondary_button_selector));
                            this.f14008r.setTextColor(ContextCompat.getColorStateList(this.f13994b, DidiThemeManager.getIns().getResPicker(this.f13994b).getResIdByTheme(R.attr.global_secondary_button_text_color_selector)));
                            this.f14010t.setBackground(DidiThemeManager.getIns().getResPicker(this.f13994b).getDrawable(R.attr.global_overall_secondary_button_selector));
                            this.f14008r.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    AutoTrackHelper.trackViewOnClick(view);
                                    DriverItemView.this.m11605a(optionBtn.link, templateDriverData.did, true);
                                }
                            });
                        } else {
                            this.f14009s = textView;
                            this.f14011u = lottieAnimationView;
                            textView.setText(optionBtn.text);
                            this.f14009s.setBackground(DidiThemeManager.getIns().getResPicker(this.f13994b).getDrawable(R.attr.global_overall_main_button_selector));
                            this.f14009s.setTextColor(ContextCompat.getColorStateList(this.f13994b, DidiThemeManager.getIns().getResPicker(this.f13994b).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
                            this.f14011u.setBackground(DidiThemeManager.getIns().getResPicker(this.f13994b).getDrawable(R.attr.global_overall_main_button_selector));
                            this.f14009s.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    AutoTrackHelper.trackViewOnClick(view);
                                    DriverItemView.this.m11605a(optionBtn.link, templateDriverData.did, false);
                                }
                            });
                        }
                    }
                }
            }
            m11608b(true, false);
            m11606a(true, false);
            long j = templateDriverData.offset;
            this.f13991A = System.currentTimeMillis();
            long j2 = templateDriverData.expireTs - (this.f13991A + j);
            this.f14016z = j2;
            if (j2 > templateDriverData.ttl) {
                this.f14016z = templateDriverData.ttl;
            }
            if (this.f14016z <= 0) {
                this.f14016z = 0;
            }
            long j3 = templateDriverData.ttl / 100;
            if (this.f14016z <= 0) {
                View view = this.f13995e;
                return;
            }
            final LEGORichInfo lEGORichInfo = templateDriverData.countdownText;
            if (lEGORichInfo != null && !TextUtils.isEmpty(lEGORichInfo.getContent())) {
                this.f14003m.setVisibility(0);
                final String content = lEGORichInfo.getContent();
                int indexOf = content.indexOf("[");
                int indexOf2 = content.indexOf("]");
                String formatTime = FormatUtils.formatTime(this.f14016z / 1000);
                String substring = content.substring(indexOf, indexOf2 + 1);
                int length = formatTime.length() - substring.length();
                content.replace(substring, formatTime);
                if (length != 0) {
                    List<LEGORichInfo.RichInfo> infoList = lEGORichInfo.getInfoList();
                    if (!CollectionUtil.isEmpty((Collection<?>) infoList)) {
                        for (LEGORichInfo.RichInfo next : infoList) {
                            if (next.start == indexOf) {
                                next.length += length;
                                z = true;
                            } else if (z) {
                                next.start += length;
                            }
                        }
                    }
                }
                lEGORichInfo.setText(content.replace(substring, FormatUtils.formatTime((long) ((int) (this.f14016z / 1000)))));
                lEGORichInfo.bindTextView(this.f14003m);
                final FlexTemplateDriverModel.TemplateDriverData templateDriverData2 = templateDriverData;
                final String str = substring;
                this.f14013w = new CountDownTimer(this.f14016z, 100) {
                    int times = 0;

                    public void onTick(long j) {
                        if (!(DriverItemView.this.f13995e == null || DriverItemView.this.f13996f == null)) {
                            DriverItemView.this.f13996f.setProgress((int) (((((double) j) * 1.0d) / ((double) templateDriverData2.ttl)) * 100.0d));
                        }
                        int i = this.times;
                        if (i < 9) {
                            this.times = i + 1;
                            return;
                        }
                        this.times = 0;
                        lEGORichInfo.setText(content.replace(str, FormatUtils.formatTime((long) ((int) (j / 1000)))));
                        lEGORichInfo.bindTextView(DriverItemView.this.f14003m);
                    }

                    public void onFinish() {
                        if (!(DriverItemView.this.f13995e == null || DriverItemView.this.f14015y == null)) {
                            DriverItemView.this.f14015y.removeItem(templateDriverData2);
                        }
                        DriverItemView.this.f13992B.put("time", Long.valueOf(DriverItemView.this.f14016z));
                        GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_timeout_sw");
                    }
                }.start();
            }
            GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_sw", this.f13992B);
        }
    }

    public void updateLoadingStatus(boolean z) {
        if (z) {
            int i = this.f14014x;
            if (i == 1) {
                m11608b(false, true);
                m11606a(false, false);
            } else if (i == 2) {
                m11608b(false, false);
                m11606a(false, true);
            } else {
                m11608b(false, false);
                m11606a(false, false);
            }
        } else {
            this.f14014x = 0;
            m11608b(true, false);
            m11606a(true, false);
        }
    }

    /* renamed from: a */
    private void m11606a(boolean z, boolean z2) {
        if (z2) {
            this.f14011u.setRepeatCount(-1);
            this.f14011u.setVisibility(0);
            this.f14011u.playAnimation();
            this.f14009s.setVisibility(4);
            return;
        }
        this.f14009s.setVisibility(0);
        this.f14009s.setEnabled(z);
        this.f14011u.cancelAnimation();
        this.f14011u.setVisibility(4);
    }

    /* renamed from: b */
    private void m11608b(boolean z, boolean z2) {
        if (z2) {
            this.f14010t.setRepeatCount(-1);
            this.f14010t.setVisibility(0);
            this.f14010t.playAnimation();
            this.f14008r.setVisibility(4);
            return;
        }
        this.f14008r.setVisibility(0);
        this.f14008r.setEnabled(z);
        this.f14010t.cancelAnimation();
        this.f14010t.setVisibility(4);
    }
}
