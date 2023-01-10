package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.view.ITerminalWelcomeView;
import com.sdk.poibase.model.poi.FenceInfo;
import com.taxis99.R;

public class TerminalWelcomeView extends RelativeLayout implements ITerminalWelcomeView {

    /* renamed from: a */
    private TextView f27639a;

    /* renamed from: b */
    private TextView f27640b;

    /* renamed from: c */
    private ImageView f27641c;

    /* renamed from: d */
    private TextView f27642d;

    /* renamed from: e */
    private TextView f27643e;

    /* renamed from: f */
    private FenceInfo f27644f;

    /* renamed from: g */
    private boolean f27645g;

    /* renamed from: h */
    private boolean f27646h;

    /* renamed from: i */
    private boolean f27647i;

    /* renamed from: j */
    private ITerminalWelcomeView.Callback f27648j;

    /* renamed from: k */
    private Context f27649k;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m21854a(View view, MotionEvent motionEvent) {
        return true;
    }

    public TerminalWelcomeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TerminalWelcomeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TerminalWelcomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21852a(context);
    }

    /* renamed from: a */
    private void m21852a(Context context) {
        this.f27649k = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_map_departure_terminal_welcome, this);
        this.f27639a = (TextView) inflate.findViewById(R.id.welcome_title);
        this.f27640b = (TextView) inflate.findViewById(R.id.welcome_subtitle);
        this.f27641c = (ImageView) inflate.findViewById(R.id.welcome_icon);
        this.f27642d = (TextView) inflate.findViewById(R.id.set_pickup_spot);
        this.f27643e = (TextView) inflate.findViewById(R.id.select_other_area);
        Drawable drawable = inflate.getResources().getDrawable(R.drawable.map_departure_right_arrow);
        drawable.setAutoMirrored(true);
        this.f27643e.setCompoundDrawablePadding(DisplayUtils.dp2px(inflate.getContext(), 4.0f));
        this.f27643e.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        inflate.setOnTouchListener($$Lambda$TerminalWelcomeView$Vo5gI9zM2DPOCaWBkakrEHTPE.INSTANCE);
        try {
            this.f27642d.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f27642d.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f27642d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalWelcomeView.this.m21855b(view);
            }
        });
        this.f27643e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalWelcomeView.this.m21853a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21855b(View view) {
        this.f27646h = true;
        ITerminalWelcomeView.Callback callback = this.f27648j;
        if (callback != null) {
            callback.onClickSetPickupSpot();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21853a(View view) {
        this.f27647i = true;
        ITerminalWelcomeView.Callback callback = this.f27648j;
        if (callback != null) {
            callback.onClickSelectOtherArea();
        }
    }

    public void setData(FenceInfo fenceInfo) {
        if (fenceInfo == null) {
            this.f27645g = false;
            this.f27646h = false;
            this.f27647i = false;
            return;
        }
        DLog.m10773d("TerminalWelcomeView", "welcomeText: " + fenceInfo.welcomeText + "recommendText: " + fenceInfo.recommendText + "stationIcon: " + fenceInfo.stationIcon, new Object[0]);
        this.f27644f = fenceInfo;
        this.f27645g = true;
        this.f27639a.setText(fenceInfo.welcomeText);
        this.f27640b.setText(fenceInfo.recommendText);
        ((RequestBuilder) Glide.with(getContext()).load(fenceInfo.stationIcon).override(DisplayUtils.dp2px(this.f27649k, 128.0f), DisplayUtils.dp2px(this.f27649k, 146.0f))).into(this.f27641c);
    }

    public View getView() {
        if (!isValid() || this.f27646h) {
            return null;
        }
        return this;
    }

    public boolean isValid() {
        return !this.f27646h && this.f27645g;
    }

    public void setCallback(ITerminalWelcomeView.Callback callback) {
        this.f27648j = callback;
    }
}
