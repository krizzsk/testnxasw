package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.unifiedPay.component.widget.loading.CircularProgressBar;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;

public class LoadingStateView extends FrameLayout {

    /* renamed from: a */
    private CircularProgressBar f47116a;

    /* renamed from: b */
    private TextView f47117b;

    public enum State {
        LOADING_STATE,
        SUCCESS_STATE
    }

    public LoadingStateView(Context context) {
        super(context);
        m35055a();
    }

    public LoadingStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35055a();
    }

    /* renamed from: a */
    private void m35055a() {
        View inflate = inflate(getContext(), R.layout.oc_unified_pay_loading_view_layout, this);
        this.f47116a = (CircularProgressBar) inflate.findViewById(R.id.oc_round_progress_bar);
        this.f47117b = (TextView) inflate.findViewById(R.id.oc_tv_loading);
    }

    public void setText(String str) {
        if (UnipayTextUtil.isEmpty(str)) {
            this.f47117b.setVisibility(8);
            return;
        }
        this.f47117b.setText(str);
        this.f47117b.setVisibility(0);
    }

    public void changeState(State state) {
        if (state == State.SUCCESS_STATE) {
            this.f47116a.changeToSuccess();
        } else {
            this.f47116a.changeToLoading();
        }
    }

    public void setText(int i) {
        this.f47117b.setText(i);
        this.f47117b.setVisibility(0);
    }
}
