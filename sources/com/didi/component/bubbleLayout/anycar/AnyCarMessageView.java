package com.didi.component.bubbleLayout.anycar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.business.util.UiUtils;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.taxis99.R;

public class AnyCarMessageView extends FrameLayout {

    /* renamed from: a */
    private Context f12845a;

    /* renamed from: b */
    private View f12846b;

    /* renamed from: c */
    private ImageView f12847c;

    /* renamed from: d */
    private TextView f12848d;

    /* renamed from: e */
    private CarMessageModel f12849e;

    public AnyCarMessageView(Context context) {
        super(context);
        m10845a(context);
    }

    public AnyCarMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10845a(context);
    }

    /* renamed from: a */
    private void m10845a(Context context) {
        this.f12845a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.anycar_message_layout, this);
        this.f12846b = inflate;
        this.f12847c = (ImageView) inflate.findViewById(R.id.iv_icon);
        this.f12848d = (TextView) this.f12846b.findViewById(R.id.tv_message);
    }

    public void setData(CarMessageModel carMessageModel) {
        this.f12849e = carMessageModel;
        update();
    }

    public void update() {
        int i;
        int i2;
        CarMessageModel carMessageModel = this.f12849e;
        if (carMessageModel == null || TextUtils.isEmpty(carMessageModel.messageBgStart) || TextUtils.isEmpty(this.f12849e.messageBgEnd)) {
            i2 = Color.parseColor("#FFDDCC");
            i = Color.parseColor("#FFF0E6");
        } else {
            try {
                i2 = Color.parseColor(this.f12849e.messageBgStart);
                i = Color.parseColor(this.f12849e.messageBgEnd);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                i2 = Color.parseColor("#FFDDCC");
                i = Color.parseColor("#FFF0E6");
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i2, i});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadii(new float[]{(float) UiUtils.dip2px(this.f12845a, 20.0f), (float) UiUtils.dip2px(this.f12845a, 20.0f), (float) UiUtils.dip2px(this.f12845a, 20.0f), (float) UiUtils.dip2px(this.f12845a, 20.0f), 0.0f, 0.0f, 0.0f, 0.0f});
        this.f12846b.setBackground(gradientDrawable);
        CarMessageModel carMessageModel2 = this.f12849e;
        if (carMessageModel2 == null || TextUtils.isEmpty(carMessageModel2.messageIcon)) {
            this.f12847c.setVisibility(8);
        } else {
            this.f12847c.setVisibility(0);
            Context context = this.f12845a;
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                Glide.with(this.f12845a).load(this.f12849e.messageIcon).into(this.f12847c);
            }
        }
        CarMessageModel carMessageModel3 = this.f12849e;
        if (carMessageModel3 != null && carMessageModel3.msg != null && !TextUtils.isEmpty(this.f12849e.msg.getContent())) {
            this.f12849e.msg.bindTextView(this.f12848d);
        }
    }
}
