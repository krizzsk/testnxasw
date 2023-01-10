package com.didi.payment.creditcard.global.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class CardTypeSelectView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private View f33063a;

    /* renamed from: b */
    private View f33064b;

    /* renamed from: c */
    private ImageView f33065c;

    /* renamed from: d */
    private TextView f33066d;

    /* renamed from: e */
    private ImageView f33067e;

    /* renamed from: f */
    private TextView f33068f;

    /* renamed from: g */
    private int f33069g;

    /* renamed from: h */
    private int f33070h = 0;

    /* renamed from: i */
    private OnCardTypeSelectChangeListener f33071i;

    public interface OnCardTypeSelectChangeListener {
        void onCardTypeSelect(int i);
    }

    public CardTypeSelectView(Context context) {
        super(context);
    }

    public CardTypeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardTypeSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.one_payment_creditcard_global_v_card_type_select, this, true);
        this.f33063a = findViewById(R.id.layout_card_select_left);
        this.f33064b = findViewById(R.id.layout_card_select_right);
        this.f33065c = (ImageView) findViewById(R.id.iv_card_select_left);
        this.f33066d = (TextView) findViewById(R.id.tv_card_select_left);
        this.f33067e = (ImageView) findViewById(R.id.iv_card_select_right);
        this.f33063a.setOnClickListener(this);
        this.f33064b.setOnClickListener(this);
        this.f33068f = (TextView) findViewById(R.id.tv_card_select_right);
        this.f33069g = this.f33066d.getCurrentTextColor();
        this.f33070h = 0;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        getVisibility();
    }

    public boolean isTypeSelected() {
        return this.f33070h != 0;
    }

    public int getSelectState() {
        return this.f33070h;
    }

    public int getCardType() {
        int i = this.f33070h;
        if (i == 1) {
            return 3;
        }
        return i == 2 ? 2 : 0;
    }

    public void resetError() {
        TextView textView = this.f33066d;
        if (!(textView == null || this.f33068f == null)) {
            textView.setTextColor(this.f33069g);
            this.f33068f.setTextColor(this.f33069g);
        }
        this.f33070h = 0;
        this.f33065c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
        this.f33067e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
    }

    public void showError() {
        TextView textView = this.f33066d;
        if (!(textView == null || this.f33068f == null)) {
            textView.setTextColor(-65536);
            this.f33068f.setTextColor(-65536);
        }
        this.f33070h = 0;
        this.f33065c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
        this.f33067e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.layout_card_select_left) {
            this.f33066d.setTextColor(this.f33069g);
            this.f33068f.setTextColor(this.f33069g);
            if (this.f33070h != 1) {
                this.f33070h = 1;
                this.f33065c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_selected);
                this.f33067e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
                OnCardTypeSelectChangeListener onCardTypeSelectChangeListener = this.f33071i;
                if (onCardTypeSelectChangeListener != null) {
                    onCardTypeSelectChangeListener.onCardTypeSelect(0);
                }
            }
        } else if (id == R.id.layout_card_select_right) {
            this.f33066d.setTextColor(this.f33069g);
            this.f33068f.setTextColor(this.f33069g);
            if (this.f33070h != 2) {
                this.f33070h = 2;
                this.f33067e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_selected);
                this.f33065c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected);
                OnCardTypeSelectChangeListener onCardTypeSelectChangeListener2 = this.f33071i;
                if (onCardTypeSelectChangeListener2 != null) {
                    onCardTypeSelectChangeListener2.onCardTypeSelect(1);
                }
            }
        }
    }

    public void setOnCardTypeSelectChangeListener(OnCardTypeSelectChangeListener onCardTypeSelectChangeListener) {
        this.f33071i = onCardTypeSelectChangeListener;
    }
}
