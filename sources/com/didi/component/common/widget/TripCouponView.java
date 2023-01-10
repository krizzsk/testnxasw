package com.didi.component.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.common.util.UIUtils;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.template.yoga.util.NinePatchBuilder;
import com.taxis99.R;

public class TripCouponView extends RelativeLayout {

    /* renamed from: a */
    private Context f13870a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f13871b;

    /* renamed from: c */
    private ImageView f13872c;

    /* renamed from: d */
    private TextView f13873d;

    /* renamed from: e */
    private View f13874e;

    /* renamed from: f */
    private View f13875f;

    public static class CouponModel implements BffGsonStruct {
        public String background_image;
        public String icon;
        public String link;
        public boolean show_redDot;
        public String text;
        public String text_color;
    }

    public TripCouponView(Context context) {
        super(context);
        init(context);
    }

    public TripCouponView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public TripCouponView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        this.f13870a = context;
        this.f13871b = LayoutInflater.from(context).inflate(R.layout.g_trip_coupon_layout, this);
        this.f13872c = (ImageView) findViewById(R.id.coupon_img);
        this.f13873d = (TextView) findViewById(R.id.coupon_text);
        this.f13874e = findViewById(R.id.dot_view);
        this.f13875f = findViewById(R.id.coupon_div);
    }

    public void bindData(CouponModel couponModel) {
        if (couponModel != null) {
            if (couponModel.show_redDot) {
                this.f13874e.setVisibility(0);
                this.f13872c.setVisibility(8);
                return;
            }
            this.f13874e.setVisibility(8);
            this.f13872c.setVisibility(0);
            m11502a(couponModel);
        }
    }

    /* renamed from: a */
    private void m11502a(CouponModel couponModel) {
        if (!TextUtils.isEmpty(couponModel.text)) {
            this.f13873d.setVisibility(0);
            this.f13873d.setText(couponModel.text);
        } else {
            this.f13873d.setVisibility(8);
        }
        if (!TextUtils.isEmpty(couponModel.text_color)) {
            this.f13873d.setTextColor(Color.parseColor(couponModel.text_color));
        }
        if (!TextUtils.isEmpty(couponModel.icon)) {
            this.f13872c.setVisibility(0);
            Glide.with(this.f13870a).load(couponModel.icon).into(this.f13872c);
        } else {
            this.f13872c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(couponModel.background_image)) {
            Glide.with(this.f13870a).asBitmap().load(couponModel.background_image).into(new CustomTarget<Bitmap>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    NinePatchDrawable build = new NinePatchBuilder(TripCouponView.this.getResources(), bitmap).addXCenteredRegion(2).build();
                    if (build != null) {
                        TripCouponView.this.f13871b.setBackground(build);
                    }
                }
            });
        } else {
            this.f13871b.setBackgroundColor(Color.parseColor("#00000000"));
        }
        if (!TextUtils.isEmpty(couponModel.link)) {
            final String str = couponModel.link;
            this.f13871b.setOnClickListener(new OnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    DRouter.build(str).start();
                }
            });
        }
        if (!TextUtils.isEmpty(couponModel.icon) || !TextUtils.isEmpty(couponModel.background_image)) {
            this.f13875f.setVisibility(8);
            this.f13871b.setPadding(UIUtils.dip2pxInt(this.f13870a, 10.0f), UIUtils.dip2pxInt(this.f13870a, 5.0f), 0, 0);
            return;
        }
        this.f13875f.setVisibility(0);
        this.f13871b.setPadding(UIUtils.dip2pxInt(this.f13870a, 13.0f), 0, UIUtils.dip2pxInt(this.f13870a, 13.0f), 0);
    }
}
