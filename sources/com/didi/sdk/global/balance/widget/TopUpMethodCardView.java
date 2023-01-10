package com.didi.sdk.global.balance.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.balance.model.TopUpMethodItemInfo;
import com.taxis99.R;

@Deprecated
public class TopUpMethodCardView extends LinearLayout {

    /* renamed from: a */
    private static final String f38807a = "Balance";

    /* renamed from: b */
    private ImageView f38808b;

    /* renamed from: c */
    private ImageView f38809c;

    /* renamed from: d */
    private ImageView f38810d;

    /* renamed from: e */
    private TextView f38811e;

    /* renamed from: f */
    private TextView f38812f;

    /* renamed from: g */
    private TextView f38813g;

    /* renamed from: h */
    private TextView f38814h;

    /* renamed from: i */
    private boolean f38815i;

    /* renamed from: j */
    private boolean f38816j;

    /* renamed from: k */
    private TopUpMethodItemInfo f38817k;

    public enum STYLE {
        CHECK,
        CLICK
    }

    public TopUpMethodCardView(Context context) {
        super(context);
        m29222a(context);
    }

    public TopUpMethodCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29222a(context);
    }

    public TopUpMethodCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29222a(context);
    }

    /* renamed from: a */
    private void m29222a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_balance_topup_method_card, this, true);
        this.f38808b = (ImageView) inflate.findViewById(R.id.iv_topup_method_icon);
        this.f38809c = (ImageView) inflate.findViewById(R.id.iv_topup_method_check);
        this.f38810d = (ImageView) inflate.findViewById(R.id.iv_topup_method_reddot);
        this.f38811e = (TextView) inflate.findViewById(R.id.tv_topup_method_name);
        this.f38812f = (TextView) inflate.findViewById(R.id.tv_topup_method_desc);
        this.f38813g = (TextView) inflate.findViewById(R.id.tv_topup_method_value_prefix);
        this.f38814h = (TextView) inflate.findViewById(R.id.tv_topup_method_value);
    }

    public void setPayMethodItemInfo(TopUpMethodItemInfo topUpMethodItemInfo) {
        if (topUpMethodItemInfo == null) {
            SystemUtils.log(6, "Balance", "top up method item info is null", (Throwable) null, "com.didi.sdk.global.balance.widget.TopUpMethodCardView", 78);
            return;
        }
        this.f38817k = topUpMethodItemInfo;
        this.f38811e.setText(topUpMethodItemInfo.name);
        if (TextUtils.isEmpty(topUpMethodItemInfo.description)) {
            this.f38812f.setVisibility(8);
        } else {
            this.f38812f.setVisibility(0);
            this.f38812f.setText(topUpMethodItemInfo.description);
        }
        if (TextUtils.isEmpty(topUpMethodItemInfo.valuePrefix)) {
            this.f38813g.setVisibility(8);
        } else {
            this.f38813g.setVisibility(0);
            this.f38813g.setText(topUpMethodItemInfo.valuePrefix);
        }
        if (TextUtils.isEmpty(topUpMethodItemInfo.value)) {
            this.f38814h.setVisibility(8);
        } else {
            this.f38814h.setVisibility(0);
            this.f38814h.setText(topUpMethodItemInfo.value);
        }
        if (!TextUtils.isEmpty(topUpMethodItemInfo.iconUrl)) {
            GlideUtils.with2load2into(getContext(), topUpMethodItemInfo.iconUrl, this.f38808b);
        } else if (topUpMethodItemInfo.channelId != 120) {
            SystemUtils.log(4, "Balance", "No proper icon for unsupported payment channel: " + topUpMethodItemInfo.channelId, (Throwable) null, "com.didi.sdk.global.balance.widget.TopUpMethodCardView", 116);
            this.f38808b.setImageResource(R.drawable.one_payment_global_icon_cash_selector);
        } else {
            this.f38808b.setImageResource(R.drawable.one_payment_global_icon_balance_selector);
        }
    }

    public void setRedDotVisibility(boolean z) {
        SystemUtils.log(3, "Balance", "set visibility to " + z + " for " + this.f38817k.name, (Throwable) null, "com.didi.sdk.global.balance.widget.TopUpMethodCardView", 124);
        this.f38810d.setVisibility(z ? 0 : 8);
    }

    public TopUpMethodItemInfo getItemInfo() {
        return this.f38817k;
    }

    public int getChannelId() {
        TopUpMethodItemInfo topUpMethodItemInfo = this.f38817k;
        if (topUpMethodItemInfo != null) {
            return topUpMethodItemInfo.channelId;
        }
        return -1;
    }

    public void setSelectStyle(STYLE style) {
        int i;
        if (style == STYLE.CHECK) {
            try {
                i = DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.checkbox_selector);
            } catch (Exception unused) {
                i = R.drawable.one_payment_global_topup_method_check_selector;
            }
            this.f38809c.setImageResource(i);
        } else if (style == STYLE.CLICK) {
            this.f38809c.setImageResource(R.drawable.one_payment_global_check_right_arrow);
        }
    }

    public void setIsSelected(boolean z) {
        this.f38815i = z;
        this.f38809c.setSelected(z);
    }

    public boolean getIsSelected() {
        return this.f38815i;
    }

    public void setMethodClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setEnabled(boolean z) {
        this.f38816j = z;
        this.f38808b.setEnabled(z);
        this.f38811e.setEnabled(z);
        this.f38809c.setEnabled(z);
        this.f38812f.setEnabled(z);
        if (!z) {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean getEnabled() {
        return this.f38816j;
    }
}
