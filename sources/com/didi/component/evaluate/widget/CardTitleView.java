package com.didi.component.evaluate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class CardTitleView extends RelativeLayout {

    /* renamed from: a */
    private View f15274a;

    /* renamed from: b */
    private TextView f15275b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CardTitleCloseBtnListener f15276c;

    public interface CardTitleCloseBtnListener {
        void onCloseBtnClick();
    }

    public CardTitleView(Context context) {
        super(context);
        m12592a();
    }

    public CardTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12592a();
    }

    /* renamed from: a */
    private void m12592a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_include_card_title, this, true);
        this.f15274a = inflate.findViewById(R.id.btn_card_close);
        this.f15275b = (TextView) inflate.findViewById(R.id.tv_card_title);
        this.f15274a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardTitleView.this.f15276c != null) {
                    CardTitleView.this.f15276c.onCloseBtnClick();
                }
            }
        });
    }

    public void setCloseIconListener(CardTitleCloseBtnListener cardTitleCloseBtnListener) {
        this.f15276c = cardTitleCloseBtnListener;
    }

    public void setTitleText(String str) {
        this.f15275b.setText(str);
    }

    public void setClosable(boolean z) {
        this.f15274a.setEnabled(z);
    }

    public boolean isCloseAble() {
        return this.f15274a.isEnabled();
    }
}
