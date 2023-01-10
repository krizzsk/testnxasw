package com.didi.component.service.activity.risk;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.service.activity.risk.bff.RiskBff;
import com.didi.component.service.activity.risk.model.RiskVerifyListItem;
import com.didi.component.service.activity.risk.model.RiskVerifyResponse;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.view.SimplePopupBase;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;

public class RiskInterceptPopup extends SimplePopupBase {

    /* renamed from: a */
    private static final String f17550a = "key_verify_mode";

    /* renamed from: b */
    private static final String f17551b = "key_extension";

    /* renamed from: c */
    private static final String f17552c = "globalOneTravel://one/safety/bind_card_verify_v1";

    /* renamed from: d */
    private TextView f17553d;

    /* renamed from: e */
    private View f17554e;

    /* renamed from: f */
    private Drawable f17555f;

    /* renamed from: g */
    private ColorStateList f17556g;

    /* renamed from: h */
    private String f17557h;

    /* renamed from: i */
    private String f17558i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ArrayList<RiskVerifyListItem> f17559j = null;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_risk_verify_dialog;
    }

    public static RiskInterceptPopup getInstance(String str, String str2) {
        RiskInterceptPopup riskInterceptPopup = new RiskInterceptPopup();
        Bundle bundle = new Bundle();
        bundle.putString(f17550a, str);
        bundle.putString(f17551b, str2);
        riskInterceptPopup.setArguments(bundle);
        return riskInterceptPopup;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f17557h = getArguments().getString(f17550a, "10");
            this.f17558i = getArguments().getString(f17551b);
        }
    }

    /* renamed from: a */
    private void m14875a() {
        if (getActivity() != null) {
            Loading.make(getContext(), LoadingRenderType.ANIMATION, this.f17554e, true, 48).show();
            if (TextUtils.isEmpty(this.f17557h)) {
                this.f17557h = "10";
            }
            RiskBff.getRiskVerifyList(getActivity(), this.f17557h, new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    RiskInterceptPopup.this.m14877b();
                    try {
                        RiskVerifyResponse riskVerifyResponse = (RiskVerifyResponse) new Gson().fromJson((JsonElement) jsonObject, RiskVerifyResponse.class);
                        if (riskVerifyResponse != null && riskVerifyResponse.errno == 0 && riskVerifyResponse.data != null && riskVerifyResponse.data.verify_list != null && !riskVerifyResponse.data.verify_list.isEmpty()) {
                            ArrayList unused = RiskInterceptPopup.this.f17559j = riskVerifyResponse.data.verify_list;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                public void onFailure(IOException iOException) {
                    RiskInterceptPopup.this.m14877b();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14877b() {
        Drawable drawable = this.f17555f;
        if (drawable != null) {
            this.f17553d.setBackground(drawable);
        }
        ColorStateList colorStateList = this.f17556g;
        if (colorStateList != null) {
            this.f17553d.setTextColor(colorStateList);
        }
        this.f17553d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                RiskInterceptPopup.this.startRiskListActivity();
                RiskInterceptPopup.this.dismiss();
            }
        });
        Loading.hide(this.f17554e);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        TextView textView = (TextView) this.mRootView.findViewById(R.id.tv_verify_btn);
        this.f17553d = textView;
        this.f17555f = textView.getBackground();
        this.f17556g = this.f17553d.getTextColors();
        this.f17553d.setBackgroundColor(getResources().getColor(R.color.oc_color_EEEEEE));
        this.f17553d.setTextColor(getResources().getColor(R.color.color_CCCCCC));
        this.f17554e = this.mRootView.findViewById(R.id.risk_verify_fallback);
        setCancelable(true);
        m14875a();
    }

    public void startRiskListActivity() {
        if (getActivity() != null) {
            if (this.f17559j == null) {
                RiskVerifyListItem createFromParcel = RiskVerifyListItem.CREATOR.createFromParcel(Parcel.obtain());
                createFromParcel.head = "";
                createFromParcel.content = getString(R.string.risk_credit_card_label);
                createFromParcel.cell_click_scheme = f17552c;
                ArrayList<RiskVerifyListItem> arrayList = new ArrayList<>();
                this.f17559j = arrayList;
                arrayList.add(createFromParcel);
            }
            Intent intent = new Intent(getActivity(), RiskUserActivity.class);
            intent.putExtra(RiskUserActivity.RISK_USER_ACTIVITY_EXTRA_VERIFY_LIST, this.f17559j);
            intent.putExtra("extension", this.f17558i);
            startActivity(intent);
        }
    }
}
