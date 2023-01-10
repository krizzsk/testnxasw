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
import com.didi.payment.creditcard.global.p131v2.utils.BindCardApolloUtils;
import com.taxis99.R;

public class CardTypeSelectOptView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private View f33054a;

    /* renamed from: b */
    private View f33055b;

    /* renamed from: c */
    private ImageView f33056c;

    /* renamed from: d */
    private TextView f33057d;

    /* renamed from: e */
    private ImageView f33058e;

    /* renamed from: f */
    private TextView f33059f;

    /* renamed from: g */
    private int f33060g;

    /* renamed from: h */
    private int f33061h = 0;

    /* renamed from: i */
    private OnCardTypeSelectChangeListener f33062i;

    public interface OnCardTypeSelectChangeListener {
        void onCardTypeSelect(int i);
    }

    public CardTypeSelectOptView(Context context) {
        super(context);
    }

    public CardTypeSelectOptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardTypeSelectOptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.one_payment_creditcard_global_v_card_type_select_opt, this, true);
        this.f33054a = findViewById(R.id.layout_card_select_left);
        this.f33055b = findViewById(R.id.layout_card_select_right);
        this.f33056c = (ImageView) findViewById(R.id.iv_card_select_left);
        this.f33057d = (TextView) findViewById(R.id.tv_card_select_left);
        this.f33058e = (ImageView) findViewById(R.id.iv_card_select_right);
        this.f33054a.setOnClickListener(this);
        this.f33055b.setOnClickListener(this);
        this.f33059f = (TextView) findViewById(R.id.tv_card_select_right);
        this.f33060g = this.f33057d.getCurrentTextColor();
        this.f33061h = 0;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        getVisibility();
    }

    public boolean isTypeSelected() {
        return this.f33061h != 0;
    }

    public int getSelectState() {
        return this.f33061h;
    }

    public int getCardType() {
        int i = this.f33061h;
        if (i == 1) {
            return 3;
        }
        return i == 2 ? 2 : 0;
    }

    public void resetError() {
        TextView textView = this.f33057d;
        if (!(textView == null || this.f33059f == null)) {
            textView.setTextColor(this.f33060g);
            this.f33059f.setTextColor(this.f33060g);
        }
        this.f33061h = 0;
        this.f33056c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
        this.f33058e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
    }

    public void showError() {
        TextView textView = this.f33057d;
        if (!(textView == null || this.f33059f == null)) {
            textView.setTextColor(-65536);
            this.f33059f.setTextColor(-65536);
        }
        this.f33061h = 0;
        this.f33056c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
        this.f33058e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.layout_card_select_left) {
            this.f33057d.setTextColor(this.f33060g);
            this.f33059f.setTextColor(this.f33060g);
            if (this.f33061h != 1) {
                this.f33061h = 1;
                if (BindCardApolloUtils.useNewVersion()) {
                    this.f33056c.setImageResource(getSelectedResId());
                } else {
                    this.f33056c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_selected_opt);
                }
                this.f33058e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
                OnCardTypeSelectChangeListener onCardTypeSelectChangeListener = this.f33062i;
                if (onCardTypeSelectChangeListener != null) {
                    onCardTypeSelectChangeListener.onCardTypeSelect(0);
                }
            }
        } else if (id == R.id.layout_card_select_right) {
            this.f33057d.setTextColor(this.f33060g);
            this.f33059f.setTextColor(this.f33060g);
            if (this.f33061h != 2) {
                this.f33061h = 2;
                if (BindCardApolloUtils.useNewVersion()) {
                    this.f33058e.setImageResource(getSelectedResId());
                } else {
                    this.f33058e.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_selected_opt);
                }
                this.f33056c.setImageResource(R.drawable.one_payment_creditcard_global_cardtype_unselected_opt);
                OnCardTypeSelectChangeListener onCardTypeSelectChangeListener2 = this.f33062i;
                if (onCardTypeSelectChangeListener2 != null) {
                    onCardTypeSelectChangeListener2.onCardTypeSelect(1);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getTerminalId(getContext());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSelectedResId() {
        /*
            r2 = this;
            com.didi.payment.base.proxy.CommonProxyHolder$ICommonProxy r0 = com.didi.payment.base.proxy.CommonProxyHolder.getProxy()
            if (r0 == 0) goto L_0x0020
            android.content.Context r1 = r2.getContext()
            java.lang.Object r0 = r0.getTerminalId(r1)
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "5"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0020
            r0 = 2131234804(0x7f080ff4, float:1.8085784E38)
            return r0
        L_0x0020:
            r0 = 2131234833(0x7f081011, float:1.8085843E38)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.creditcard.global.widget.CardTypeSelectOptView.getSelectedResId():int");
    }

    public void setOnCardTypeSelectChangeListener(OnCardTypeSelectChangeListener onCardTypeSelectChangeListener) {
        this.f33062i = onCardTypeSelectChangeListener;
    }
}
