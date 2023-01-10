package com.didichuxing.xpanel.global.models.misoperation;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.models.AbsXPanelAgentModelView;
import com.taxis99.R;
import java.util.HashMap;

public class MisOperationView extends AbsXPanelAgentModelView<MisOperationData> {

    /* renamed from: a */
    private View f52071a;

    /* renamed from: b */
    private LinearLayout f52072b;

    /* renamed from: c */
    private TextView f52073c;

    /* renamed from: d */
    private TextView f52074d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageView f52075e;

    /* renamed from: f */
    private TextView[] f52076f;

    /* renamed from: g */
    private View[] f52077g;

    /* renamed from: h */
    private ImageView[] f52078h;

    /* renamed from: i */
    private View[] f52079i;

    /* renamed from: j */
    private final String f52080j = "notice";

    public boolean contain(float f, float f2) {
        return false;
    }

    public int getMarginLeft() {
        return 0;
    }

    public int getMarginRight() {
        return 0;
    }

    /* renamed from: a */
    private void m39169a() {
        this.f52073c = (TextView) this.f52071a.findViewById(R.id.oc_x_panel_operation_title);
        this.f52072b = (LinearLayout) this.f52071a.findViewById(R.id.oc_x_panel_operation_text_layout);
        this.f52074d = (TextView) this.f52071a.findViewById(R.id.oc_x_panel_operation_content);
        this.f52075e = (ImageView) this.f52071a.findViewById(R.id.oc_x_panel_operation_image);
        this.f52076f = new TextView[]{(TextView) this.f52071a.findViewById(R.id.txt0), (TextView) this.f52071a.findViewById(R.id.txt1), (TextView) this.f52071a.findViewById(R.id.txt2)};
        this.f52078h = new ImageView[]{(ImageView) this.f52071a.findViewById(R.id.image0), (ImageView) this.f52071a.findViewById(R.id.image1), (ImageView) this.f52071a.findViewById(R.id.image2)};
        this.f52077g = new View[]{null, this.f52071a.findViewById(R.id.divider0), this.f52071a.findViewById(R.id.divider1)};
        this.f52079i = new View[]{this.f52071a.findViewById(R.id.bottombar0), this.f52071a.findViewById(R.id.bottombar1), this.f52071a.findViewById(R.id.bottombar2)};
    }

    public View getView() {
        return createBgContainer(this.f52071a);
    }

    public int halfHeight() {
        return this.f52071a.getMeasuredHeight() / 2;
    }

    public void bind(MisOperationData misOperationData) {
        m39173b(misOperationData);
        m39170a(misOperationData);
        final String str = misOperationData.imageUrl;
        if (!TextUtils.isEmpty(str)) {
            final HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(misOperationData.activityId)) {
                hashMap.put("act_id", misOperationData.activityId);
            }
            final long currentTimeMillis = System.currentTimeMillis();
            loadUrlOmega(str, hashMap);
            ((RequestBuilder) Glide.with(this.mContext).load(str).error((int) R.drawable.oc_x_panel_operation_image)).into(new CustomTarget<Drawable>() {
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    MisOperationView.this.f52075e.setImageDrawable(drawable);
                    MisOperationView.this.loadUrlRetOmega(str, hashMap, 0, currentTimeMillis);
                }

                public void onLoadCleared(Drawable drawable) {
                    MisOperationView.this.loadUrlRetOmega(str, hashMap, 1, currentTimeMillis);
                }
            });
        }
    }

    /* renamed from: a */
    private void m39170a(MisOperationData misOperationData) {
        if (misOperationData.bottombarTxts != null) {
            for (final int i = 0; i < this.f52079i.length; i++) {
                if (i >= misOperationData.bottombarTxts.length) {
                    this.f52079i[i].setVisibility(8);
                    View[] viewArr = this.f52077g;
                    if (viewArr[i] != null) {
                        viewArr[i].setVisibility(8);
                    }
                } else if (!TextUtils.isEmpty(misOperationData.bottombarTxts[i])) {
                    final String str = misOperationData.bottombarLinks[i];
                    if (!TextUtils.isEmpty(str)) {
                        this.f52079i[i].setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                if (MisOperationView.this.mListener != null) {
                                    IXPanelAgentClickListener d = MisOperationView.this.mListener;
                                    String str = str;
                                    XPanelCardData c = MisOperationView.this.mCardData;
                                    if (!d.dispatchClickUri(str, c, "button_" + i)) {
                                        MisOperationView.this.mListener.clickUri(str, MisOperationView.this.mCardData);
                                    }
                                }
                                MisOperationView.this.clickButtonOmega();
                            }
                        });
                    } else {
                        this.f52079i[i].setOnClickListener((View.OnClickListener) null);
                    }
                    if (TextUtils.isEmpty(misOperationData.bottombarImages[i])) {
                        this.f52078h[i].setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(misOperationData.bottombarTxts[i])) {
                        this.f52076f[i].setText(misOperationData.bottombarTxts[i]);
                        this.f52076f[i].setVisibility(0);
                    } else {
                        this.f52076f[i].setVisibility(8);
                    }
                    View[] viewArr2 = this.f52077g;
                    if (viewArr2[i] != null) {
                        viewArr2[i].setVisibility(0);
                    }
                    this.f52079i[i].setBackgroundResource(R.drawable.oc_x_panel_operation_selector);
                    this.f52079i[i].setVisibility(0);
                } else {
                    this.f52079i[i].setVisibility(8);
                }
            }
        }
    }

    public void initView() {
        this.f52071a = LayoutInflater.from(this.mContext).inflate(R.layout.oc_x_panel_operation_view, (ViewGroup) null);
        m39169a();
    }

    public void destroy() {
        super.destroy();
    }

    /* renamed from: b */
    private void m39173b(MisOperationData misOperationData) {
        String str = misOperationData.title;
        String str2 = misOperationData.content;
        String str3 = misOperationData.imageUrl;
        final String str4 = misOperationData.link;
        if (!TextUtils.isEmpty(str)) {
            this.f52073c.setText(str);
            this.f52073c.setVisibility(0);
        } else {
            this.f52073c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f52074d.setText(str2);
            this.f52074d.setVisibility(0);
        } else {
            this.f52074d.setVisibility(8);
        }
        if (this.f52073c.getVisibility() == 0 || this.f52074d.getVisibility() == 0) {
            this.f52072b.setVisibility(0);
        }
        if (TextUtils.isEmpty(str3) || "notice".equals(misOperationData.type)) {
            this.f52075e.setVisibility(8);
        } else {
            this.f52075e.setImageDrawable(this.f52074d.getResources().getDrawable(R.drawable.oc_x_panel_operation_image));
            this.f52075e.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.f52071a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (MisOperationView.this.mListener != null && !MisOperationView.this.mListener.dispatchClickUri(str4, MisOperationView.this.mCardData, "card")) {
                        MisOperationView.this.mListener.clickUri(str4, MisOperationView.this.mCardData);
                    }
                    MisOperationView.this.clickCardOmega();
                }
            });
        } else {
            this.f52071a.setOnClickListener((View.OnClickListener) null);
        }
    }
}
