package com.didi.beatles.p101im.views.buttonView;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.style.custom.IMCustomContext;
import com.didi.beatles.p101im.access.style.custom.IMCustomViewHelper;
import com.didi.beatles.p101im.access.style.custom.IMTopOperationCusView;
import com.didi.beatles.p101im.api.entity.IMTopOperationBody;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.widget.IMSimpleGuideView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.buttonView.IMTopOperationView */
public class IMTopOperationView extends LinearLayout {

    /* renamed from: a */
    private View f11985a;

    /* renamed from: b */
    private ImageView f11986b;

    /* renamed from: c */
    private TextView f11987c;

    /* renamed from: d */
    private TextView f11988d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IMSimpleGuideView f11989e;

    /* renamed from: f */
    private IMSession f11990f;

    /* renamed from: g */
    private IMCustomContext f11991g;

    /* renamed from: h */
    private View f11992h;

    /* renamed from: i */
    private IMTopOperationCusView f11993i;

    public IMTopOperationView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public IMTopOperationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMTopOperationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10313a();
    }

    /* renamed from: a */
    private void m10313a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bts_im_follow_layout, this, true);
        this.f11985a = inflate;
        this.f11988d = (TextView) inflate.findViewById(R.id.im_top_operation_btn);
        this.f11987c = (TextView) inflate.findViewById(R.id.im_top_operation_content);
        this.f11986b = (ImageView) inflate.findViewById(R.id.im_top_operation_icon);
    }

    public void init(IMSession iMSession, IMCustomContext iMCustomContext) {
        this.f11990f = iMSession;
        this.f11991g = iMCustomContext;
        View tryLoadCustomView = tryLoadCustomView(this);
        if (tryLoadCustomView != null) {
            IMViewUtil.hide(this.f11985a);
            addView(tryLoadCustomView);
        }
    }

    /* access modifiers changed from: protected */
    public final View tryLoadCustomView(ViewGroup viewGroup) {
        IMTopOperationCusView createTopOperationView;
        View layoutView;
        if (this.f11990f == null || (createTopOperationView = IMCustomViewHelper.createTopOperationView(IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.f11990f.getBusinessId()), this.f11991g)) == null || (layoutView = createTopOperationView.layoutView(viewGroup)) == null) {
            return null;
        }
        this.f11993i = createTopOperationView;
        this.f11992h = layoutView;
        return layoutView;
    }

    public void setData(IMTopOperationBody iMTopOperationBody) {
        IMTopOperationCusView iMTopOperationCusView = this.f11993i;
        if (iMTopOperationCusView == null || this.f11992h == null) {
            setDataImpl(iMTopOperationBody);
        } else {
            iMTopOperationCusView.bindData(iMTopOperationBody);
        }
    }

    private void setDataImpl(final IMTopOperationBody iMTopOperationBody) {
        if (iMTopOperationBody == null || TextUtils.isEmpty(iMTopOperationBody.btnText)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(iMTopOperationBody.icon)) {
            this.f11986b.setVisibility(0);
            BtsImageLoader.getInstance().loadInto(iMTopOperationBody.icon, this.f11986b);
        }
        this.f11987c.setText(iMTopOperationBody.tipText);
        if (TextUtils.isEmpty(iMTopOperationBody.btnLink)) {
            this.f11987c.setTextColor(IMResource.getColor(R.color.bts_im_color_light_gray_s));
            this.f11988d.setBackgroundColor(IMResource.getColor(R.color.bts_im_color_light_gray_s));
        } else {
            this.f11988d.setTextColor(IMResource.getColor(R.color.white));
            this.f11988d.setBackgroundColor(IMResource.getColor(R.color.im_nomix_detail_btn_color));
            this.f11988d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMCommonUtil.startUriActivity(IMTopOperationView.this.getContext(), iMTopOperationBody.btnLink);
                }
            });
        }
        this.f11988d.setText(iMTopOperationBody.btnText);
    }

    public void showGuideView(String str) {
        IMTopOperationCusView iMTopOperationCusView = this.f11993i;
        if (iMTopOperationCusView == null || this.f11992h == null) {
            m10314a(str);
        } else {
            iMTopOperationCusView.showGuideView(str);
        }
    }

    /* renamed from: a */
    private void m10314a(String str) {
        if (this.f11989e == null) {
            this.f11989e = new IMSimpleGuideView.Builder(getContext()).isShowForkView(true).setGuideText(str).setTargetView(this.f11988d).setOutsideTouchable(true).setMaxWordNumSingleLine(16).setLayoutGravity(2).setGrivaty(3).create();
        }
        postDelayed(new Runnable() {
            public void run() {
                IMTopOperationView.this.f11989e.show();
            }
        }, 500);
    }
}
