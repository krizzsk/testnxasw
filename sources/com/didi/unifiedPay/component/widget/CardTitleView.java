package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class CardTitleView extends RelativeLayout {

    /* renamed from: a */
    private View f47107a;

    /* renamed from: b */
    private TextView f47108b;

    /* renamed from: c */
    private ImageView f47109c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CardTitleCloseBtnListener f47110d;

    public interface CardTitleCloseBtnListener {
        void onCloseBtnClick();
    }

    public CardTitleView(Context context) {
        super(context);
        m35053a();
    }

    public CardTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35053a();
    }

    /* renamed from: a */
    private void m35053a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.oc_unified_pay_include_card_title, this, true);
        this.f47107a = inflate.findViewById(R.id.oc_iv_close_icon_container);
        this.f47108b = (TextView) inflate.findViewById(R.id.oc_tv_title);
        this.f47109c = (ImageView) inflate.findViewById(R.id.oc_iv_line);
        this.f47107a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardTitleView.this.f47110d != null) {
                    CardTitleView.this.f47110d.onCloseBtnClick();
                }
            }
        });
    }

    public void setTitle(String str) {
        this.f47108b.setText(str);
    }

    public void setTitle(int i) {
        this.f47108b.setText(i);
    }

    public void setCloseIconListener(CardTitleCloseBtnListener cardTitleCloseBtnListener) {
        this.f47110d = cardTitleCloseBtnListener;
    }

    public void setClosable(boolean z) {
        this.f47107a.setEnabled(z);
    }

    public void showLine(boolean z) {
        if (z) {
            this.f47109c.setVisibility(0);
        } else {
            this.f47109c.setVisibility(8);
        }
    }

    public boolean isCloseAble() {
        return this.f47107a.isEnabled();
    }
}
