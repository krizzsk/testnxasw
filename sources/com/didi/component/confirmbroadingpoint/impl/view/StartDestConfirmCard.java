package com.didi.component.confirmbroadingpoint.impl.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.model.response.estimate.StartEndCardModel;
import com.taxis99.R;
import org.json.JSONException;
import org.json.JSONObject;

public class StartDestConfirmCard extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private Context f14528a;

    /* renamed from: b */
    private TextView f14529b;

    /* renamed from: c */
    private FrameLayout f14530c;

    /* renamed from: d */
    private StartDestConfirmView f14531d;

    /* renamed from: e */
    private TextView f14532e;

    /* renamed from: f */
    private LottieAnimationView f14533f;

    /* renamed from: g */
    private StartEndCardModel f14534g;

    /* renamed from: h */
    private View.OnClickListener f14535h;

    public StartDestConfirmCard(Context context) {
        super(context);
        m12019a();
    }

    public StartDestConfirmCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12019a();
    }

    public StartDestConfirmCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12019a();
    }

    public void setConfirmBtnClickLis(View.OnClickListener onClickListener) {
        this.f14535h = onClickListener;
    }

    /* renamed from: a */
    private void m12019a() {
        Context context = getContext();
        this.f14528a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_departure_dest_card_layout, this);
        this.f14529b = (TextView) inflate.findViewById(R.id.confirm_pickup_dropoff_point_title);
        this.f14530c = (FrameLayout) inflate.findViewById(R.id.operation_container);
        this.f14531d = (StartDestConfirmView) inflate.findViewById(R.id.confirm_pickup_dropoff_point_view);
        TextView textView = (TextView) inflate.findViewById(R.id.confirm_btn);
        this.f14532e = textView;
        textView.setOnClickListener(this);
        this.f14533f = (LottieAnimationView) inflate.findViewById(R.id.animation_view);
    }

    public void bindData(StartEndCardModel startEndCardModel) {
        this.f14534g = startEndCardModel;
        if (startEndCardModel != null) {
            if (startEndCardModel.title == null || TextUtils.isEmpty(startEndCardModel.title.getContent())) {
                this.f14529b.setVisibility(8);
            } else {
                this.f14529b.setVisibility(0);
                startEndCardModel.title.bindTextView(this.f14529b);
            }
            if (startEndCardModel.xmlData != null) {
                try {
                    final GGKData parse = new GGKData().parse(new JSONObject(startEndCardModel.xmlData.toString()));
                    parse.setCDNCallback(new GGKData.CDNCallback() {
                        public void onCDNCached() {
                            StartDestConfirmCard.this.m12021a(parse);
                        }
                    });
                    m12021a(parse);
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.f14530c.setVisibility(8);
                }
            } else {
                this.f14530c.setVisibility(8);
            }
            if (startEndCardModel.stationList == null || startEndCardModel.stationList.size() == 0) {
                this.f14531d.setVisibility(8);
            } else {
                this.f14531d.setVisibility(0);
                this.f14531d.setData(startEndCardModel.stationList);
            }
            this.f14532e.setText(getResources().getString(R.string.GRider_page_Order_tfYG));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12021a(GGKData gGKData) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.f14528a, gGKData);
        if (createTemplateView != null && createTemplateView.getView() != null) {
            this.f14530c.setVisibility(0);
            this.f14530c.addView(createTemplateView.getView());
        }
    }

    /* renamed from: a */
    private void m12022a(boolean z, boolean z2) {
        if (z2) {
            this.f14533f.setRepeatCount(-1);
            this.f14533f.setVisibility(0);
            this.f14533f.playAnimation();
            this.f14532e.setVisibility(8);
            return;
        }
        this.f14532e.setVisibility(0);
        this.f14532e.setEnabled(z);
        this.f14533f.cancelAnimation();
        this.f14533f.setVisibility(8);
    }

    /* renamed from: b */
    private void m12023b() {
        this.f14533f.setRepeatCount(-1);
        this.f14533f.setVisibility(0);
        this.f14532e.setVisibility(8);
        this.f14533f.playAnimation();
    }

    public void hideLoading() {
        this.f14533f.setVisibility(8);
        this.f14533f.cancelAnimation();
        this.f14532e.setVisibility(0);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            this.f14535h.onClick(view);
            m12023b();
        }
    }
}
