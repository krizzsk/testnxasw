package com.didi.component.indriver.impl;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.util.GLog;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.common.widget.CircleProgressBar;
import com.didi.component.indriver.AbsIndriverPresenter;
import com.didi.component.indriver.model.DriverData;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class IndriverItemView extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f15997a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f15998b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CircleProgressBar f15999c;

    /* renamed from: d */
    private CircleImageView f16000d;

    /* renamed from: e */
    private TextView f16001e;

    /* renamed from: f */
    private TextView f16002f;

    /* renamed from: g */
    private TextView f16003g;

    /* renamed from: h */
    private TextView f16004h;

    /* renamed from: i */
    private TextView f16005i;

    /* renamed from: j */
    private TextView f16006j;

    /* renamed from: k */
    private TextView f16007k;

    /* renamed from: l */
    private ImageView f16008l;

    /* renamed from: m */
    private LottieAnimationView f16009m;
    protected AbsIndriverPresenter mPresenter;

    /* renamed from: n */
    private LottieAnimationView f16010n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public DriverData f16011o;

    /* renamed from: p */
    private CountDownTimer f16012p;

    /* renamed from: q */
    private int f16013q = 0;

    public IndriverItemView(Context context) {
        super(context);
        this.f15998b = context;
        m13291a(context);
    }

    public IndriverItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15998b = context;
        m13291a(context);
    }

    public IndriverItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15998b = context;
        m13291a(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.f16012p;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f16012p = null;
        }
    }

    public void setPrisenter(AbsIndriverPresenter absIndriverPresenter) {
        this.mPresenter = absIndriverPresenter;
    }

    /* renamed from: a */
    private void m13291a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.indriver_item, this, true);
        this.f15997a = inflate;
        CircleProgressBar circleProgressBar = (CircleProgressBar) inflate.findViewById(R.id.avatar_progressBar);
        this.f15999c = circleProgressBar;
        circleProgressBar.setGradientStatus(false);
        this.f15999c.setBackColor(Color.parseColor("#ff8040"));
        this.f15999c.setGradientColor(this.f15997a.getResources().getColor(R.color.global_color_gropress_indriver), this.f15997a.getResources().getColor(R.color.global_color_gropress_indriver), 30);
        this.f16000d = (CircleImageView) this.f15997a.findViewById(R.id.avatar_iv);
        this.f16001e = (TextView) this.f15997a.findViewById(R.id.name_tv);
        this.f16002f = (TextView) this.f15997a.findViewById(R.id.prive_tv);
        this.f16003g = (TextView) this.f15997a.findViewById(R.id.star_tv);
        this.f16008l = (ImageView) this.f15997a.findViewById(R.id.star_iv);
        this.f16004h = (TextView) this.f15997a.findViewById(R.id.eda_tv);
        this.f16005i = (TextView) this.f15997a.findViewById(R.id.car_brand_tv);
        this.f16006j = (TextView) this.f15997a.findViewById(R.id.reject_tv);
        this.f16007k = (TextView) this.f15997a.findViewById(R.id.accept_tv);
        this.f16009m = (LottieAnimationView) this.f15997a.findViewById(R.id.reject_animation_view);
        this.f16010n = (LottieAnimationView) this.f15997a.findViewById(R.id.accept_animation_view);
        this.f16006j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IndriverItemView.this.f16011o != null) {
                    IndriverItemView indriverItemView = IndriverItemView.this;
                    indriverItemView.m13293a(indriverItemView.f16011o.reject.link, IndriverItemView.this.f16011o.did, true);
                }
            }
        });
        this.f16007k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IndriverItemView.this.f16011o != null) {
                    IndriverItemView indriverItemView = IndriverItemView.this;
                    indriverItemView.m13293a(indriverItemView.f16011o.accept.link, IndriverItemView.this.f16011o.did, false);
                }
            }
        });
        this.f16013q = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13293a(String str, String str2, final boolean z) {
        this.f16013q = z ? 1 : 2;
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", CarOrderHelper.getOrderId());
        hashMap.put(CarServerParam.PARAM_DRIVER_ID, str2);
        GlobalOmegaUtils.trackEvent(z ? "ibt_gp_carconfirm_negotiate_detail_reject_ck" : "ibt_gp_carconfirm_negotiate_detail_accept_ck", (Map<String, Object>) hashMap);
        if (z) {
            updateLoadingStatus(true);
        } else {
            AbsIndriverPresenter absIndriverPresenter = this.mPresenter;
            if (absIndriverPresenter != null) {
                absIndriverPresenter.engineCommit(true, true);
            }
        }
        ((Request) DRouter.build(str).putExtra("KEY_COMMIT_ID", "passenger_newXpanel+bargainingCard_logic+bargaining_card")).start(this.f15998b, new RouterCallback() {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
            /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResult(com.didi.drouter.router.Result r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = "extension"
                    java.lang.String r1 = "data"
                    java.lang.String r2 = "KEY_CALLBACK"
                    java.lang.String r5 = r5.getString(r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r5)
                    r3 = 0
                    if (r2 == 0) goto L_0x0029
                    boolean r5 = r7
                    if (r5 == 0) goto L_0x001b
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    r5.updateLoadingStatus(r3)
                    goto L_0x0028
                L_0x001b:
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r5 = r5.mPresenter
                    if (r5 == 0) goto L_0x0028
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r5 = r5.mPresenter
                    r5.engineCommit(r3, r3)
                L_0x0028:
                    return
                L_0x0029:
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005e }
                    r2.<init>(r5)     // Catch:{ JSONException -> 0x005e }
                    boolean r5 = r2.has(r1)     // Catch:{ JSONException -> 0x005e }
                    if (r5 == 0) goto L_0x0062
                    org.json.JSONObject r5 = r2.optJSONObject(r1)     // Catch:{ JSONException -> 0x005e }
                    boolean r1 = r5.has(r0)     // Catch:{ JSONException -> 0x005e }
                    if (r1 == 0) goto L_0x0062
                    org.json.JSONObject r5 = r5.optJSONObject(r0)     // Catch:{ JSONException -> 0x005e }
                    if (r5 == 0) goto L_0x005c
                    java.lang.String r0 = "errno"
                    int r0 = r5.optInt(r0)     // Catch:{ JSONException -> 0x005e }
                    if (r0 == 0) goto L_0x005c
                    java.lang.String r0 = "errmsg"
                    java.lang.String r5 = r5.optString(r0)     // Catch:{ JSONException -> 0x005e }
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this     // Catch:{ JSONException -> 0x005e }
                    android.content.Context r0 = r0.f15998b     // Catch:{ JSONException -> 0x005e }
                    com.didi.sdk.util.ToastUtil.show((android.content.Context) r0, (java.lang.CharSequence) r5)     // Catch:{ JSONException -> 0x005e }
                    goto L_0x0062
                L_0x005c:
                    r5 = 1
                    goto L_0x0063
                L_0x005e:
                    r5 = move-exception
                    r5.printStackTrace()
                L_0x0062:
                    r5 = 0
                L_0x0063:
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this
                    android.view.View r0 = r0.f15997a
                    if (r0 == 0) goto L_0x008f
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r0 = r0.mPresenter
                    if (r0 == 0) goto L_0x008f
                    boolean r0 = r7
                    if (r0 == 0) goto L_0x0088
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    r5.updateLoadingStatus(r3)
                    com.didi.component.indriver.impl.IndriverItemView r5 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r5 = r5.mPresenter
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.model.DriverData r0 = r0.f16011o
                    r5.removeItem(r0)
                    goto L_0x008f
                L_0x0088:
                    com.didi.component.indriver.impl.IndriverItemView r0 = com.didi.component.indriver.impl.IndriverItemView.this
                    com.didi.component.indriver.AbsIndriverPresenter r0 = r0.mPresenter
                    r0.engineCommit(r3, r5)
                L_0x008f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.indriver.impl.IndriverItemView.C65783.onResult(com.didi.drouter.router.Result):void");
            }
        });
    }

    public void setData(DriverData driverData) {
        this.f16011o = driverData;
        this.f16001e.setText(driverData.name);
        driverData.price.bindTextView(this.f16002f);
        if (!TextUtils.isEmpty(driverData.starUrl)) {
            Glide.with(this.f15998b.getApplicationContext()).load(driverData.starUrl).into(this.f16008l);
        }
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.f15998b).asBitmap().load(driverData.avatar).placeholder((int) R.drawable.driver_default_avatar)).error((int) R.drawable.driver_default_avatar)).into((ImageView) this.f16000d);
        StringBuilder sb = new StringBuilder();
        sb.append(driverData.star);
        if (!TextUtils.isEmpty(driverData.trips)) {
            sb.append(" · ");
            sb.append(driverData.trips);
        }
        this.f16003g.setText(sb.toString());
        driverData.eta.bindTextView(this.f16004h);
        this.f16005i.setText(driverData.carBrand);
        this.f16006j.setText(driverData.reject.text);
        this.f16007k.setText(driverData.accept.text);
        m13296b(true, false);
        m13294a(true, false);
        long abs = Math.abs(driverData.expireTs - System.currentTimeMillis());
        if (abs > driverData.ttl) {
            abs = driverData.ttl;
        }
        final long j = abs;
        long j2 = driverData.ttl / 100;
        GLog.m11357e("dxt", "timeout = " + j + "/ countDownInterval " + j2);
        final DriverData driverData2 = driverData;
        this.f16012p = new CountDownTimer(j, j2) {
            public void onTick(long j) {
                if (IndriverItemView.this.f15997a != null && IndriverItemView.this.f15999c != null) {
                    IndriverItemView.this.f15999c.setPercent((float) (1.0d - ((((double) j) * 1.0d) / ((double) j))));
                }
            }

            public void onFinish() {
                if (IndriverItemView.this.f15997a != null && IndriverItemView.this.mPresenter != null) {
                    IndriverItemView.this.mPresenter.removeItem(driverData2);
                }
            }
        }.start();
    }

    public void updateLoadingStatus(boolean z) {
        if (z) {
            int i = this.f16013q;
            if (i == 1) {
                m13296b(false, true);
                m13294a(false, false);
            } else if (i == 2) {
                m13296b(false, false);
                m13294a(false, true);
            } else {
                m13296b(false, false);
                m13294a(false, false);
            }
        } else {
            this.f16013q = 0;
            m13296b(true, false);
            m13294a(true, false);
        }
    }

    /* renamed from: a */
    private void m13294a(boolean z, boolean z2) {
        if (z2) {
            this.f16010n.setRepeatCount(-1);
            this.f16010n.setVisibility(0);
            this.f16010n.playAnimation();
            this.f16007k.setVisibility(4);
            return;
        }
        this.f16007k.setVisibility(0);
        this.f16007k.setEnabled(z);
        this.f16007k.setTextColor(Color.parseColor(z ? "#ffffffff" : "#D8DADC"));
        if (z) {
            this.f16007k.setBackground(DidiThemeManager.getIns().getResPicker(this.f15998b).getDrawable(R.attr.global_overall_main_button_selector));
        } else {
            this.f16007k.setBackground(DidiThemeManager.getIns().getResPicker(this.f15998b).getDrawable(R.attr.global_overall_secondary_button_selector));
        }
        this.f16010n.cancelAnimation();
        this.f16010n.setVisibility(4);
    }

    /* renamed from: b */
    private void m13296b(boolean z, boolean z2) {
        if (z2) {
            this.f16009m.setRepeatCount(-1);
            this.f16009m.setVisibility(0);
            this.f16009m.playAnimation();
            this.f16006j.setVisibility(4);
            return;
        }
        this.f16006j.setVisibility(0);
        this.f16006j.setEnabled(z);
        this.f16006j.setTextColor(Color.parseColor(z ? "#ff000000" : "#D8DADC"));
        this.f16009m.cancelAnimation();
        this.f16009m.setVisibility(4);
    }
}
