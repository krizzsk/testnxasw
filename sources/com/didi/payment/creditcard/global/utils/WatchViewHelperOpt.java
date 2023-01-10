package com.didi.payment.creditcard.global.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.p131v2.utils.BindCardApolloUtils;
import com.didi.payment.creditcard.global.p131v2.utils.CreditCardOmegaUtil;
import com.didi.payment.creditcard.global.widget.CardEditText;
import com.didi.payment.creditcard.global.widget.CardNoWatcher;
import com.didi.payment.creditcard.global.widget.CardTypeSelectOptView;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;

public class WatchViewHelperOpt {

    /* renamed from: a */
    private static final String f32958a = "2.0";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f32959b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CardEditText f32960c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CardEditText f32961d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CardEditText f32962e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f32963f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f32964g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f32965h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CardTypeSelectOptView f32966i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public TextView f32967j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ImageView f32968k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CheckViewHelperOpt f32969l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ICardBinRule f32970m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CardTypeViewAnimator f32971n = new CardTypeViewAnimator();
    /* access modifiers changed from: private */

    /* renamed from: o */
    public IOnEditFocusChangeListener f32972o;

    /* renamed from: p */
    private TextWatcher f32973p = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WatchViewHelperOpt.this.f32969l.checkCommitButton(WatchViewHelperOpt.this.f32960c, WatchViewHelperOpt.this.f32961d, WatchViewHelperOpt.this.f32962e, WatchViewHelperOpt.this.f32966i, WatchViewHelperOpt.this.f32967j);
        }
    };

    /* renamed from: q */
    private View.OnFocusChangeListener f32974q = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            int id = view.getId();
            boolean z2 = true;
            if (id == R.id.et_card) {
                if (!z) {
                    if (WatchViewHelperOpt.this.f32960c.getTextWithoutSpace().length() == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        WatchViewHelperOpt.this.f32969l.checkNumber(WatchViewHelperOpt.this.f32960c, WatchViewHelperOpt.this.f32963f);
                    }
                    CreditCardOmegaUtil.Companion.bindCardInputTrace("1", z2);
                    return;
                }
                GlobalOmegaUtils.trackAddCardPageCardNumberCK(view.getContext(), WatchViewHelperOpt.f32958a);
            } else if (id == R.id.et_date) {
                if (!z) {
                    if (WatchViewHelperOpt.this.f32961d.getTextWithoutSpace().length() == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        WatchViewHelperOpt.this.f32969l.checkDate(WatchViewHelperOpt.this.f32961d, WatchViewHelperOpt.this.f32964g);
                    }
                    CreditCardOmegaUtil.Companion.bindCardInputTrace("2", z2);
                    return;
                }
                InputTools.hideKeyboard(view);
                if (WatchViewHelperOpt.this.f32972o != null) {
                    WatchViewHelperOpt.this.f32972o.onFocusChange(view, z);
                }
                GlobalOmegaUtils.trackAddCardPageExpirationCK(view.getContext(), WatchViewHelperOpt.f32958a);
            } else if (id == R.id.et_cvv) {
                if (!z) {
                    if (WatchViewHelperOpt.this.f32962e.getTextWithoutSpace().length() == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        WatchViewHelperOpt.this.f32969l.checkSafeCode(WatchViewHelperOpt.this.f32960c, WatchViewHelperOpt.this.f32962e, WatchViewHelperOpt.this.f32965h);
                    }
                    CreditCardOmegaUtil.Companion.bindCardInputTrace("3", z2);
                } else {
                    GlobalOmegaUtils.trackAddCardPageCvvCK(view.getContext(), WatchViewHelperOpt.f32958a);
                }
                WatchViewHelperOpt watchViewHelperOpt = WatchViewHelperOpt.this;
                watchViewHelperOpt.m25057a(watchViewHelperOpt.f32960c.getTextWithoutSpace(), z);
            }
        }
    };

    /* renamed from: r */
    private CardTypeSelectOptView.OnCardTypeSelectChangeListener f32975r = new CardTypeSelectOptView.OnCardTypeSelectChangeListener() {
        public void onCardTypeSelect(int i) {
            WatchViewHelperOpt.this.f32969l.checkCommitButton(WatchViewHelperOpt.this.f32960c, WatchViewHelperOpt.this.f32961d, WatchViewHelperOpt.this.f32962e, WatchViewHelperOpt.this.f32966i, WatchViewHelperOpt.this.f32967j);
            if (i == 0) {
                GlobalOmegaUtils.trackAddCardPageCreditCK(WatchViewHelperOpt.this.f32960c.getContext());
            } else if (i == 1) {
                GlobalOmegaUtils.trackAddCardPageDebitCK(WatchViewHelperOpt.this.f32960c.getContext());
            }
            WatchViewHelperOpt.this.f32969l.setCardNumErrorMsg((String) null, WatchViewHelperOpt.this.f32963f);
        }
    };

    /* renamed from: s */
    private CardNoWatcher.CardBinCheckListener f32976s = new CardNoWatcher.CardBinCheckListener() {
        public void check(String str) {
            WatchViewHelperOpt.this.f32969l.resetNumber(WatchViewHelperOpt.this.f32963f);
            int cardType = WatchViewHelperOpt.this.f32970m.getCardType(str);
            if (cardType == 1) {
                WatchViewHelperOpt.this.f32960c.resetError();
                WatchViewHelperOpt.this.f32971n.showCardTypeSelectView(WatchViewHelperOpt.this.f32966i, (View) null);
            }
            String checkCardNumErrorMsg = WatchViewHelperOpt.this.f32969l.checkCardNumErrorMsg(str, WatchViewHelperOpt.this.f32961d);
            if (TextUtils.isEmpty(checkCardNumErrorMsg) && str != null && str.length() == 19 && cardType == 1 && !WatchViewHelperOpt.this.f32966i.isTypeSelected()) {
                checkCardNumErrorMsg = WatchViewHelperOpt.this.f32959b.getResources().getString(R.string.one_payment_creditcard_global_error_select_type);
            }
            WatchViewHelperOpt.this.f32969l.setCardNumErrorMsg(checkCardNumErrorMsg, WatchViewHelperOpt.this.f32963f);
            WatchViewHelperOpt.this.f32969l.updateNumberIcon(WatchViewHelperOpt.this.f32968k, str);
            WatchViewHelperOpt.this.m25057a(str, false);
            WatchViewHelperOpt.this.m25056a(str);
        }

        public void reset(String str) {
            check(str);
            WatchViewHelperOpt.this.f32966i.resetError();
            WatchViewHelperOpt.this.f32971n.hideCardTypeSelectView(WatchViewHelperOpt.this.f32966i, (View) null);
        }
    };

    /* renamed from: t */
    private TextWatcher f32977t = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (WatchViewHelperOpt.this.f32960c != null) {
                if (editable == null || editable.length() <= 18) {
                    WatchViewHelperOpt.this.f32960c.setTextSize(2, 18.0f);
                } else {
                    WatchViewHelperOpt.this.f32960c.setTextSize(2, 16.0f);
                }
            }
        }
    };

    /* renamed from: u */
    private TextWatcher f32978u = new TextWatcher() {
        private String mPreContent = "";

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mPreContent = charSequence.toString();
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() >= 2 && this.mPreContent.length() < editable.length()) {
                String obj = editable.toString();
                if (!obj.contains("/")) {
                    StringBuilder sb = new StringBuilder(obj);
                    sb.insert(2, "/");
                    WatchViewHelperOpt.this.f32961d.setText(sb);
                    WatchViewHelperOpt.this.f32961d.setSelection(WatchViewHelperOpt.this.f32961d.getText().length());
                }
            }
            WatchViewHelperOpt.this.f32969l.resetDate(WatchViewHelperOpt.this.f32964g);
            if (editable != null && editable.toString().trim().length() == 5 && WatchViewHelperOpt.this.f32969l.checkDate(WatchViewHelperOpt.this.f32961d, WatchViewHelperOpt.this.f32964g)) {
                WatchViewHelperOpt.this.f32962e.requestFocus();
            }
        }
    };

    /* renamed from: v */
    private TextWatcher f32979v = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            WatchViewHelperOpt.this.f32969l.resetSafeCode(WatchViewHelperOpt.this.f32965h);
            if (editable != null && editable.toString().trim().length() == 4) {
                WatchViewHelperOpt.this.f32969l.checkSafeCode(WatchViewHelperOpt.this.f32960c, WatchViewHelperOpt.this.f32962e, WatchViewHelperOpt.this.f32965h);
            }
        }
    };

    public interface IOnEditFocusChangeListener {
        void onFocusChange(View view, boolean z);
    }

    public WatchViewHelperOpt(ICardBinRule iCardBinRule, CheckViewHelperOpt checkViewHelperOpt) {
        this.f32970m = iCardBinRule;
        this.f32969l = checkViewHelperOpt;
    }

    public void initView(CardEditText cardEditText, CardEditText cardEditText2, CardEditText cardEditText3, TextView textView, TextView textView2, TextView textView3, ImageView imageView, CardTypeSelectOptView cardTypeSelectOptView, TextView textView4) {
        this.f32960c = cardEditText;
        this.f32961d = cardEditText2;
        this.f32962e = cardEditText3;
        this.f32963f = textView;
        this.f32964g = textView2;
        this.f32965h = textView3;
        this.f32968k = imageView;
        this.f32966i = cardTypeSelectOptView;
        this.f32967j = textView4;
        this.f32959b = cardEditText.getContext();
    }

    public void resetView() {
        this.f32960c.setText("");
        this.f32960c.resetError();
        this.f32961d.setText("");
        this.f32961d.resetError();
        this.f32962e.setText("");
        this.f32962e.resetError();
        this.f32971n.hideCardTypeSelectView(this.f32966i, (View) null);
        this.f32967j.setEnabled(false);
    }

    public void watch() {
        m25053a();
        m25059b();
        m25061c();
        m25063d();
    }

    /* renamed from: a */
    private void m25053a() {
        CardNoWatcher cardNoWatcher = new CardNoWatcher(this.f32960c);
        cardNoWatcher.setCheckListener(this.f32976s);
        this.f32960c.addTextChangedListener(cardNoWatcher);
        this.f32960c.addTextChangedListener(this.f32973p);
        if (BindCardApolloUtils.useNewVersion()) {
            this.f32960c.addTextChangedListener(this.f32977t);
        }
        this.f32960c.setOnFocusChangeListener(this.f32974q);
    }

    /* renamed from: b */
    private void m25059b() {
        this.f32961d.addTextChangedListener(this.f32973p);
        this.f32961d.addTextChangedListener(this.f32978u);
        this.f32961d.setOnFocusChangeListener(this.f32974q);
    }

    /* renamed from: c */
    private void m25061c() {
        this.f32962e.addTextChangedListener(this.f32973p);
        this.f32962e.addTextChangedListener(this.f32979v);
        this.f32962e.setOnFocusChangeListener(this.f32974q);
    }

    /* renamed from: d */
    private void m25063d() {
        this.f32966i.setOnCardTypeSelectChangeListener(this.f32975r);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25057a(String str, boolean z) {
        String string = this.f32959b.getResources().getString(R.string.one_payment_creditcard_global_code_hint_cvv);
        String string2 = this.f32959b.getResources().getString(R.string.one_payment_creditcard_global_code_hint_cid);
        if (TextUtils.isEmpty(str) || str.length() < 6 || (!str.startsWith(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE) && !str.startsWith("37"))) {
            if (z) {
                this.f32962e.setHint("123");
            } else {
                this.f32962e.setHint(string);
            }
        } else if (z) {
            this.f32962e.setHint("1234");
        } else {
            this.f32962e.setHint(string2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25056a(String str) {
        String trim = this.f32965h.getText().toString().trim();
        String string = this.f32959b.getResources().getString(R.string.one_payment_creditcard_global_error_safe_code);
        String string2 = this.f32959b.getResources().getString(R.string.one_payment_creditcard_global_error_cid_code);
        if (TextUtils.isEmpty(str) || str.length() < 6 || (!str.startsWith(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE) && !str.startsWith("37"))) {
            if (trim.equals(string2)) {
                this.f32965h.setText(string);
            }
        } else if (trim.equals(string)) {
            this.f32965h.setText(string2);
        }
    }

    public void setOnFocusChangeListener(IOnEditFocusChangeListener iOnEditFocusChangeListener) {
        this.f32972o = iOnEditFocusChangeListener;
    }
}
