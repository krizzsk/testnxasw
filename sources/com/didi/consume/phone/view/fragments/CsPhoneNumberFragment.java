package com.didi.consume.phone.view.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.base.CsRouter;
import com.didi.consume.phone.model.CsDefaultPhoneNumberResp;
import com.didi.consume.phone.view.contract.CsCountryCodePickerContract;
import com.didi.consume.phone.view.contract.CsPhoneNumContract;
import com.didi.consume.phone.view.prsenter.CsPhoneNumPresenter;
import com.didi.consume.phone.view.widget.CountryCodePickerFragment;
import com.didi.consume.phone.view.widget.KeyboardEditText;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CsPhoneNumberFragment extends Fragment implements CsCountryCodePickerContract, CsPhoneNumContract.View {

    /* renamed from: b */
    private static final Integer f18198b = 11;

    /* renamed from: a */
    List<String> f18199a;

    /* renamed from: c */
    private View f18200c;

    /* renamed from: d */
    private TextView f18201d;

    /* renamed from: e */
    private TextView f18202e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f18203f;

    /* renamed from: g */
    private TextView f18204g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public KeyboardEditText f18205h;

    /* renamed from: i */
    private TextView f18206i;

    /* renamed from: j */
    private ImageView f18207j;

    /* renamed from: k */
    private TextView f18208k;

    /* renamed from: l */
    private TextView f18209l;

    /* renamed from: m */
    private CountryCodePickerFragment f18210m;

    /* renamed from: n */
    private CsDefaultPhoneNumberResp.HistoryDataBean f18211n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public CsPhoneNumContract.Presenter f18212o;

    /* renamed from: p */
    private WalletLoadingContract f18213p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public OnFragmentPhoneNumberInteractionListener f18214q;

    /* renamed from: r */
    private View.OnTouchListener f18215r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public KeyboardEditText.KeyboardListener f18216s;

    public interface OnFragmentPhoneNumberInteractionListener {
        void onFragmentPhoneNumberInteraction(String str, String str2);
    }

    public static CsPhoneNumberFragment newInstance() {
        return new CsPhoneNumberFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18212o = new CsPhoneNumPresenter(getActivity(), this, this.f18213p);
        View inflate = layoutInflater.inflate(R.layout.cs_fragment_phone_number, viewGroup, false);
        this.f18200c = inflate;
        m15394a(inflate);
        m15393a();
        this.f18212o.init();
        return this.f18200c;
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        if (TextUtils.isEmpty(this.f18205h.getEditableText().toString())) {
            this.f18205h.setText("");
            this.f18203f.setText("");
            this.f18212o.getDefaultPhoneNum(605);
        }
    }

    /* renamed from: a */
    private void m15394a(View view) {
        this.f18201d = (TextView) view.findViewById(R.id.tv_phone_number_title);
        this.f18202e = (TextView) view.findViewById(R.id.tv_phone_number_sub_title);
        this.f18204g = (TextView) view.findViewById(R.id.tv_phone_number_activity);
        this.f18203f = (TextView) view.findViewById(R.id.country_switch_view);
        this.f18205h = (KeyboardEditText) view.findViewById(R.id.et_phone_number);
        this.f18206i = (TextView) view.findViewById(R.id.btn_phone_number_next);
        this.f18207j = (ImageView) view.findViewById(R.id.tv_phone_number_delete_btn);
        this.f18208k = (TextView) view.findViewById(R.id.tv_kyc_tag);
        this.f18209l = (TextView) view.findViewById(R.id.tv_verify_kyc);
        this.f18210m = new CountryCodePickerFragment();
    }

    /* renamed from: a */
    private void m15393a() {
        OnTouchEventImpl onTouchEventImpl = new OnTouchEventImpl();
        this.f18215r = onTouchEventImpl;
        this.f18200c.setOnTouchListener(onTouchEventImpl);
        KeyboardVisibilityListenerImpl keyboardVisibilityListenerImpl = new KeyboardVisibilityListenerImpl();
        this.f18216s = keyboardVisibilityListenerImpl;
        this.f18205h.setOnKeyboardListener(keyboardVisibilityListenerImpl);
    }

    /* renamed from: b */
    private void m15397b() {
        this.f18203f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsPhoneNumberFragment.this.m15398c();
            }
        });
        this.f18205h.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                CsPhoneNumberFragment.this.f18205h.setTextColor(ResourcesCompat.getColor(CsPhoneNumberFragment.this.getResources(), R.color.black, CsPhoneNumberFragment.this.getActivity().getTheme()));
                CsPhoneNumberFragment.this.m15401d();
                CsPhoneNumberFragment.this.updateDeleteBtn();
            }
        });
        this.f18205h.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    CsPhoneNumberFragment.this.f18216s.onStateChanged((KeyboardEditText) null, false);
                }
                return false;
            }
        });
        this.f18206i.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                if (CsPhoneNumberFragment.this.m15402e()) {
                    CsOmegaUtils.trackPhoneBillConfirmBtnClicked("phonenumber");
                    CsPhoneNumberFragment.this.f18214q.onFragmentPhoneNumberInteraction(CsPhoneNumberFragment.this.f18203f.getText().toString(), CsPhoneNumberFragment.this.f18205h.getText().toString());
                }
            }
        });
        this.f18207j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsPhoneNumberFragment.this.f18205h.setText("");
            }
        });
    }

    public void checkPhoneNumberFormat() {
        if (!m15402e()) {
            this.f18205h.setTextColor(ResourcesCompat.getColor(getResources(), R.color.wallet_color_FF525D, getActivity().getTheme()));
            WalletToastNew.showFailedMsg(getContext(), getContext().getResources().getString(R.string.cs_phone_num_invalid_phone_num));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15398c() {
        this.f18210m.setData(this.f18199a);
        this.f18210m.setWalletSendEmailContract(this);
        if (getFragmentManager() != null) {
            this.f18210m.show(getFragmentManager(), "countryCodePicker");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m15401d() {
        this.f18206i.setEnabled(m15402e());
    }

    public void updateDeleteBtn() {
        if (!TextUtil.isEmpty(this.f18205h.getText().toString())) {
            setDeleteBtnVisible();
        } else {
            setDeleteBtnInvisible();
        }
    }

    public void setDeleteBtnInvisible() {
        this.f18207j.setVisibility(8);
    }

    public void setDeleteBtnVisible() {
        this.f18207j.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m15402e() {
        return !TextUtils.isEmpty(this.f18205h.getEditableText().toString()) && this.f18205h.getEditableText().toString().length() >= f18198b.intValue();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentPhoneNumberInteractionListener) {
            this.f18214q = (OnFragmentPhoneNumberInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f18213p = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentZipCodeInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.f18214q = null;
        this.f18213p = null;
    }

    public void showActivity(String str) {
        this.f18204g.setVisibility(0);
        this.f18204g.setText(str);
        this.f18204g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsPhoneNumberFragment.this.f18212o.jumpToActivityPage();
            }
        });
    }

    public void showPhoneNumber(final CsDefaultPhoneNumberResp.DataBean dataBean) {
        if (dataBean != null) {
            if (1 != dataBean.status && !TextUtils.isEmpty(dataBean.statusMessage)) {
                TextView textView = this.f18209l;
                textView.setText(TextHighlightUtil.highlight(dataBean.statusMessage + " >", Color.parseColor("#5C6166"), Color.parseColor("#FF8040")));
                this.f18209l.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (CsPhoneNumberFragment.this.getActivity() != null) {
                            OmegaComParams.Companion.setKYC_RESOURCE_ID("51");
                            CsRouter.gotoAccountPage(CsPhoneNumberFragment.this.getActivity(), dataBean.status, dataBean.accountStatus);
                        }
                    }
                });
            }
            if (dataBean.mobileRechargeTopMessage != null) {
                dataBean.mobileRechargeTopMessage.bindTextView(this.f18202e);
            }
            this.f18211n = dataBean.history;
            if (dataBean.phoneCountryCodes.size() > 0) {
                this.f18199a = dataBean.phoneCountryCodes;
            } else {
                ArrayList arrayList = new ArrayList();
                this.f18199a = arrayList;
                arrayList.add("+55");
            }
            this.f18203f.setEnabled(true);
            this.f18203f.setText(dataBean.phoneCountryCodes.get(0));
            this.f18205h.setEnabled(true);
            this.f18205h.setText(dataBean.history.phoneNumber);
            m15397b();
            m15401d();
        }
    }

    public void onNetworkError() {
        if (getContext() != null) {
            ArrayList arrayList = new ArrayList();
            this.f18199a = arrayList;
            arrayList.add("+55");
            this.f18199a.add("+52");
            this.f18203f.setEnabled(true);
            this.f18203f.setText(this.f18199a.get(0));
            this.f18205h.setEnabled(true);
            this.f18205h.setText("");
            m15397b();
            m15401d();
        }
    }

    public void onCountryCodeSelected(String str) {
        this.f18210m.dismissEmailDialog();
        this.f18203f.setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m15405f() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    class OnTouchEventImpl implements View.OnTouchListener {
        OnTouchEventImpl() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                View currentFocus = CsPhoneNumberFragment.this.getActivity().getCurrentFocus();
                if (currentFocus instanceof EditText) {
                    Rect rect = new Rect();
                    currentFocus.getGlobalVisibleRect(rect);
                    if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        currentFocus.clearFocus();
                        ((InputMethodManager) CsPhoneNumberFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                        CsPhoneNumberFragment.this.f18216s.onStateChanged((KeyboardEditText) null, false);
                    }
                }
            }
            return true;
        }
    }

    class KeyboardVisibilityListenerImpl implements KeyboardEditText.KeyboardListener {
        KeyboardVisibilityListenerImpl() {
        }

        public void onStateChanged(KeyboardEditText keyboardEditText, boolean z) {
            if (!z) {
                CsPhoneNumberFragment.this.checkPhoneNumberFormat();
                CsPhoneNumberFragment.this.m15405f();
                CsPhoneNumberFragment.this.setDeleteBtnInvisible();
                return;
            }
            CsPhoneNumberFragment.this.updateDeleteBtn();
        }
    }
}
