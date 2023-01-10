package com.didi.universal.pay.biz.p173ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: com.didi.universal.pay.biz.ui.UniversalTitleView */
public class UniversalTitleView extends RelativeLayout {

    /* renamed from: a */
    private View f47761a;

    /* renamed from: b */
    private TextView f47762b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CardTitleCloseBtnListener f47763c;

    /* renamed from: com.didi.universal.pay.biz.ui.UniversalTitleView$CardTitleCloseBtnListener */
    public interface CardTitleCloseBtnListener {
        void onCloseBtnClick();
    }

    public UniversalTitleView(Context context) {
        super(context);
        m35868a();
    }

    public UniversalTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35868a();
    }

    /* renamed from: a */
    private void m35868a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.universal_title, this, true);
        this.f47761a = inflate.findViewById(R.id.universal_title_icon);
        this.f47762b = (TextView) inflate.findViewById(R.id.universal_title_name);
        this.f47761a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (UniversalTitleView.this.f47763c != null) {
                    UniversalTitleView.this.f47763c.onCloseBtnClick();
                }
            }
        });
    }

    public void setTitle(String str) {
        this.f47762b.setText(str);
    }

    public void setTitle(int i) {
        this.f47762b.setText(i);
    }

    public void setCloseIconListener(CardTitleCloseBtnListener cardTitleCloseBtnListener) {
        this.f47763c = cardTitleCloseBtnListener;
    }
}
