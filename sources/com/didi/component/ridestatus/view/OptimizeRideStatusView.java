package com.didi.component.ridestatus.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.ridestatus.AbsRideStatusPresenter;
import com.didi.component.ridestatus.IRideStatusView;
import com.taxis99.R;

public class OptimizeRideStatusView implements IRideStatusView {

    /* renamed from: a */
    private Context f17198a;

    /* renamed from: b */
    private View f17199b;

    /* renamed from: c */
    private RelativeLayout f17200c;

    /* renamed from: d */
    private TextView f17201d;

    /* renamed from: e */
    private TextView f17202e;

    /* renamed from: f */
    private ImageView f17203f;

    /* renamed from: g */
    private ImageView f17204g;

    /* renamed from: h */
    private String f17205h;

    /* renamed from: i */
    private boolean f17206i;

    /* renamed from: j */
    private boolean f17207j;
    protected AbsRideStatusPresenter mAbsRideStatusPresenter;

    public void setActivityIcon(String str) {
    }

    public void setContextTextMinLines(int i) {
    }

    public void setIcon(Drawable drawable) {
    }

    public void setPlaceHolderTitle(String str) {
    }

    public void setPlaceHolderTitleVisible(boolean z) {
    }

    public void setTimeTextVisible(boolean z) {
    }

    public void setTipText(String str) {
    }

    public void showWhyWaitIcon(boolean z) {
    }

    public void startLottieAnimation(String str, String str2, long j) {
    }

    public void startSubTitleFadeInAnimation(long j) {
    }

    public void startTitleFadeInAnimation(long j) {
    }

    public OptimizeRideStatusView(Context context) {
        this.f17198a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_op_ride_status_important_layout, (ViewGroup) null);
        this.f17199b = inflate;
        this.f17202e = (TextView) inflate.findViewById(R.id.op_ride_status_content_text);
        if (this.f17199b.getLayoutParams() == null) {
            this.f17199b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        }
        this.f17200c = (RelativeLayout) this.f17199b.findViewById(R.id.op_ride_status_layout);
        this.f17201d = (TextView) this.f17199b.findViewById(R.id.op_ride_status_title_text);
    }

    public void setPresenter(AbsRideStatusPresenter absRideStatusPresenter) {
        this.mAbsRideStatusPresenter = absRideStatusPresenter;
    }

    public void setTitleText(String str) {
        TextView textView = this.f17201d;
        if (textView != null) {
            textView.setText(HighlightUtil.highlight(textView.getContext(), str));
        }
    }

    public void setContentText(String str) {
        TextView textView = this.f17202e;
        if (textView != null) {
            textView.setText(HighlightUtil.highlight(this.f17199b.getContext(), str));
            this.f17202e.setVisibility(0);
            this.f17205h = str;
        }
    }

    public void setBackgroudColor(String str) {
        RelativeLayout relativeLayout = this.f17200c;
        if (relativeLayout != null) {
            ((GradientDrawable) relativeLayout.getBackground()).setColor(Color.parseColor(str));
        }
    }

    public void setEnhanceIconViewUrl(String str) {
        if (this.f17203f != null && !TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT >= 17) {
                Context context = this.f17198a;
                if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                    return;
                }
            }
            Context context2 = this.f17198a;
            if (!(context2 instanceof Activity) || !((Activity) context2).isFinishing()) {
                ((RequestBuilder) Glide.with(this.f17198a).asBitmap().load(str).placeholder((Drawable) null)).into(this.f17203f);
            }
        }
    }

    public void setCloseViewVisibility(int i) {
        ImageView imageView = this.f17204g;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f17204g;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setTitleVisible(boolean z) {
        this.f17201d.setVisibility(z ? 0 : 8);
    }

    public void setContentVisible(boolean z) {
        this.f17202e.setVisibility(z ? 0 : 8);
        this.f17206i = z;
    }

    public void setTitleWarning(boolean z) {
        if (z) {
            this.f17201d.setTextColor(Color.rgb(255, 0, 0));
        } else {
            this.f17201d.setTextColor(Color.rgb(0, 0, 0));
        }
    }

    public void setContentWarning(boolean z) {
        if (z) {
            TextView textView = this.f17202e;
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.theme_high_color));
        } else {
            this.f17202e.setTextColor(Color.rgb(102, 102, 102));
        }
        this.f17207j = z;
    }

    public String getContentText() {
        return this.f17205h;
    }

    public boolean isContentVisible() {
        return this.f17206i;
    }

    public boolean isContentWarning() {
        return this.f17207j;
    }

    public View getView() {
        return this.f17199b;
    }
}
