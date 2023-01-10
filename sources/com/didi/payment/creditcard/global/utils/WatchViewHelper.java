package com.didi.payment.creditcard.global.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.widget.CardEditText;
import com.didi.payment.creditcard.global.widget.CardNoWatcher;
import com.didi.payment.creditcard.global.widget.CardTypeSelectView;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public class WatchViewHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CardEditText f32945a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CardEditText f32946b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CardEditText f32947c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CardTypeSelectView f32948d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f32949e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f32950f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CheckViewHelper f32951g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ICardBinRule f32952h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CardTypeViewAnimator f32953i = new CardTypeViewAnimator();

    /* renamed from: j */
    private TextWatcher f32954j = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WatchViewHelper.this.f32950f.setEnabled(WatchViewHelper.this.f32951g.isCommitEnabled(WatchViewHelper.this.f32945a, WatchViewHelper.this.f32946b, WatchViewHelper.this.f32947c, WatchViewHelper.this.f32948d));
            WatchViewHelper.this.f32951g.resetDateEditText(WatchViewHelper.this.f32946b);
        }
    };

    /* renamed from: k */
    private View.OnFocusChangeListener f32955k = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                WatchViewHelper.this.f32951g.checkEditText(view);
            } else {
                WatchViewHelper.this.f32951g.resetEditText(view);
            }
            if (z) {
                int id = view.getId();
                if (id == R.id.et_card) {
                    GlobalOmegaUtils.trackAddCardPageCardNumberCK(view.getContext(), "");
                } else if (id == R.id.et_date) {
                    GlobalOmegaUtils.trackAddCardPageExpirationCK(view.getContext(), "");
                } else if (id == R.id.et_cvv) {
                    GlobalOmegaUtils.trackAddCardPageCvvCK(view.getContext(), "");
                }
            }
        }
    };

    /* renamed from: l */
    private CardTypeSelectView.OnCardTypeSelectChangeListener f32956l = new CardTypeSelectView.OnCardTypeSelectChangeListener() {
        public void onCardTypeSelect(int i) {
            if (!GlobalCheckUtil.checkCreditDebitCardNo(WatchViewHelper.this.f32945a.getContext(), WatchViewHelper.this.f32945a.getTextString())) {
                WatchViewHelper.this.f32945a.showError();
            }
            WatchViewHelper.this.f32950f.setEnabled(WatchViewHelper.this.f32951g.isCommitEnabled(WatchViewHelper.this.f32945a, WatchViewHelper.this.f32946b, WatchViewHelper.this.f32947c, WatchViewHelper.this.f32948d));
            if (i == 0) {
                GlobalOmegaUtils.trackAddCardPageCreditCK(WatchViewHelper.this.f32945a.getContext());
            } else if (i == 1) {
                GlobalOmegaUtils.trackAddCardPageDebitCK(WatchViewHelper.this.f32945a.getContext());
            }
        }
    };

    /* renamed from: m */
    private CardNoWatcher.CardBinCheckListener f32957m = new CardNoWatcher.CardBinCheckListener() {
        public void check(String str) {
            if (WatchViewHelper.this.f32952h.getCardType(str) == 1) {
                WatchViewHelper.this.f32945a.resetError();
                WatchViewHelper.this.f32953i.showCardTypeSelectView(WatchViewHelper.this.f32948d, WatchViewHelper.this.f32949e);
            } else {
                reset(str);
            }
            if (WatchViewHelper.this.f32951g.checkBlackCard(str)) {
                WatchViewHelper.this.f32945a.showError();
                if (str.length() == 6) {
                    ToastHelper.showShortInfo(WatchViewHelper.this.f32945a.getContext(), WatchViewHelper.this.f32945a.getContext().getString(R.string.one_payment_creditcard_global_error_not_support));
                }
            }
        }

        public void reset(String str) {
            WatchViewHelper.this.f32945a.resetError();
            WatchViewHelper.this.f32948d.resetError();
            WatchViewHelper.this.f32953i.hideCardTypeSelectView(WatchViewHelper.this.f32948d, WatchViewHelper.this.f32949e);
        }
    };

    public WatchViewHelper(ICardBinRule iCardBinRule, CheckViewHelper checkViewHelper) {
        this.f32952h = iCardBinRule;
        this.f32951g = checkViewHelper;
    }

    public void initView(CardEditText cardEditText, CardEditText cardEditText2, CardEditText cardEditText3, CardTypeSelectView cardTypeSelectView, View view, TextView textView) {
        this.f32945a = cardEditText;
        this.f32946b = cardEditText2;
        this.f32947c = cardEditText3;
        this.f32948d = cardTypeSelectView;
        this.f32949e = view;
        this.f32950f = textView;
    }

    public void resetView() {
        this.f32945a.setText("");
        this.f32945a.resetError();
        this.f32946b.setText("");
        this.f32946b.resetError();
        this.f32947c.setText("");
        this.f32947c.resetError();
        this.f32953i.hideCardTypeSelectView(this.f32948d, this.f32949e);
        this.f32950f.setEnabled(false);
    }

    public void watch() {
        m25040a();
        m25042b();
        m25044c();
        m25046d();
    }

    /* renamed from: a */
    private void m25040a() {
        CardNoWatcher cardNoWatcher = new CardNoWatcher(this.f32945a);
        cardNoWatcher.setCheckListener(this.f32957m);
        this.f32945a.addTextChangedListener(cardNoWatcher);
        this.f32945a.addTextChangedListener(this.f32954j);
        this.f32945a.setOnFocusChangeListener(this.f32955k);
    }

    /* renamed from: b */
    private void m25042b() {
        this.f32946b.addTextChangedListener(this.f32954j);
        this.f32946b.setOnFocusChangeListener(this.f32955k);
    }

    /* renamed from: c */
    private void m25044c() {
        this.f32947c.addTextChangedListener(this.f32954j);
        this.f32947c.setOnFocusChangeListener(this.f32955k);
    }

    /* renamed from: d */
    private void m25046d() {
        this.f32948d.setOnCardTypeSelectChangeListener(this.f32956l);
    }
}
