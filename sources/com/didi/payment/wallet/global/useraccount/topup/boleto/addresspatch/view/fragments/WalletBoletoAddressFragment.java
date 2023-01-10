package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.utils.TextUtils;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.constant.WalletConstants;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoAddressContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter.WalletBoletoAddressPresenter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.taxis99.R;

public class WalletBoletoAddressFragment extends Fragment implements WalletBoletoAddressContract.View {

    /* renamed from: a */
    private static final String f34418a = "boletoAddress";

    /* renamed from: b */
    private static final String f34419b = "SCROLL_POSITION";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AddressFromZipCodeResp.DataBean f34420c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnFragmentAddressInteractionListener f34421d;

    /* renamed from: e */
    private WalletLoadingContract f34422e;

    /* renamed from: f */
    private WalletBoletoAddressContract.Presenter f34423f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ScrollView f34424g;

    /* renamed from: h */
    private EditText f34425h;

    /* renamed from: i */
    private EditText f34426i;

    /* renamed from: j */
    private EditText f34427j;

    /* renamed from: k */
    private EditText f34428k;

    /* renamed from: l */
    private EditText f34429l;

    /* renamed from: m */
    private EditText f34430m;

    /* renamed from: n */
    private EditText f34431n;

    /* renamed from: o */
    private TextView f34432o;

    public interface OnFragmentAddressInteractionListener {
        void onFragmentPatchSuccessInteraction();

        void onFragmentRequestCityInteraction(ListFragmentExtraCity listFragmentExtraCity, WalletBoletoAddressFragment walletBoletoAddressFragment);

        void onFragmentRequestStateInteraction(ListFragmentExtraState listFragmentExtraState, WalletBoletoAddressFragment walletBoletoAddressFragment);
    }

    public void onNetworkError() {
    }

    public static WalletBoletoAddressFragment newInstance(AddressFromZipCodeResp.DataBean dataBean) {
        WalletBoletoAddressFragment walletBoletoAddressFragment = new WalletBoletoAddressFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f34418a, dataBean);
        walletBoletoAddressFragment.setArguments(bundle);
        return walletBoletoAddressFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f34420c = (AddressFromZipCodeResp.DataBean) getArguments().getSerializable(f34418a);
        }
        this.f34423f = new WalletBoletoAddressPresenter(getActivity(), this, this.f34422e);
    }

    public void onResume() {
        super.onResume();
        m26261a();
    }

    public void onPause() {
        super.onPause();
        if (this.f34420c == null) {
            this.f34420c = new AddressFromZipCodeResp.DataBean();
        }
        this.f34420c.zipCode = this.f34425h.getText().toString();
        this.f34420c.streetName = this.f34426i.getText().toString();
        this.f34420c.number = this.f34427j.getText().toString();
        this.f34420c.complement = this.f34428k.getText().toString();
        this.f34420c.neighborhood = this.f34429l.getText().toString();
        this.f34420c.state = this.f34430m.getText().toString();
        this.f34420c.city = this.f34431n.getText().toString();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.wallet_global_fragment_boleto_cashin_address, viewGroup, false);
        m26262a(inflate);
        GlobalOmegaUtils.trackBoletoAddressPatchDetailSW();
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putIntArray(f34419b, new int[]{this.f34424g.getScrollX(), this.f34424g.getScrollY()});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r3 = r3.getIntArray(f34419b);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewStateRestored(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onViewStateRestored(r3)
            if (r3 != 0) goto L_0x0006
            return
        L_0x0006:
            java.lang.String r0 = "SCROLL_POSITION"
            int[] r3 = r3.getIntArray(r0)
            if (r3 == 0) goto L_0x0018
            android.widget.ScrollView r0 = r2.f34424g
            com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressFragment$1 r1 = new com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressFragment$1
            r1.<init>(r3)
            r0.post(r1)
        L_0x0018:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressFragment.onViewStateRestored(android.os.Bundle):void");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 103) {
            this.f34420c.state = intent.getStringExtra(WalletConstants.KEY_INTENT_LIST_CALLBACK_KEY);
        } else if (i == 104) {
            this.f34420c.city = intent.getStringExtra(WalletConstants.KEY_INTENT_LIST_CALLBACK_KEY);
        }
    }

    /* renamed from: a */
    private void m26262a(View view) {
        this.f34424g = (ScrollView) view.findViewById(R.id.sv_boleto_address);
        this.f34425h = (EditText) view.findViewById(R.id.et_topup_boleto_zipcode_content);
        this.f34426i = (EditText) view.findViewById(R.id.et_topup_boleto_street_content);
        this.f34427j = (EditText) view.findViewById(R.id.et_topup_boleto_number_content);
        this.f34428k = (EditText) view.findViewById(R.id.et_topup_boleto_complement_content);
        this.f34429l = (EditText) view.findViewById(R.id.et_topup_boleto_district_content);
        this.f34430m = (EditText) view.findViewById(R.id.et_topup_boleto_state_content);
        this.f34431n = (EditText) view.findViewById(R.id.et_topup_boleto_city_content);
        this.f34432o = (TextView) view.findViewById(R.id.btn_view_boleto_submit_address);
    }

    /* renamed from: a */
    private void m26261a() {
        C119572 r0 = new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                WalletBoletoAddressFragment.this.m26263b();
            }
        };
        this.f34425h.addTextChangedListener(r0);
        this.f34426i.addTextChangedListener(r0);
        this.f34427j.addTextChangedListener(r0);
        this.f34428k.addTextChangedListener(r0);
        this.f34429l.addTextChangedListener(r0);
        this.f34430m.addTextChangedListener(r0);
        this.f34431n.addTextChangedListener(r0);
        AddressFromZipCodeResp.DataBean dataBean = this.f34420c;
        if (dataBean != null) {
            if (dataBean.zipCode != null) {
                this.f34425h.setText(this.f34420c.zipCode);
            }
            if (this.f34420c.streetName != null) {
                this.f34426i.setText(this.f34420c.streetName);
            }
            if (this.f34420c.number != null) {
                this.f34427j.setText(this.f34420c.number);
            }
            if (this.f34420c.complement != null) {
                this.f34428k.setText(this.f34420c.complement);
            }
            if (this.f34420c.neighborhood != null) {
                this.f34429l.setText(this.f34420c.neighborhood);
            }
            if (this.f34420c.state != null) {
                this.f34430m.setText(this.f34420c.state);
            }
            if (this.f34420c.city != null) {
                this.f34431n.setText(this.f34420c.city);
            }
        }
        this.f34430m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoAddressFragment.this.f34421d.onFragmentRequestStateInteraction(new ListFragmentExtraState("BR"), WalletBoletoAddressFragment.this);
            }
        });
        this.f34431n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletBoletoAddressFragment.this.f34420c.state != null && !TextUtils.isEmpty(WalletBoletoAddressFragment.this.f34420c.state)) {
                    WalletBoletoAddressFragment.this.f34421d.onFragmentRequestCityInteraction(new ListFragmentExtraCity("BR", WalletBoletoAddressFragment.this.f34420c.state), WalletBoletoAddressFragment.this);
                }
            }
        });
        this.f34432o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBoletoAddressPatchDetailBtnCK();
                WalletBoletoAddressFragment.this.onButtonPressed();
            }
        });
        this.f34425h.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
        EditText editText = this.f34425h;
        editText.setSelection(editText.length());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26263b() {
        this.f34432o.setEnabled(m26266c());
    }

    /* renamed from: c */
    private boolean m26266c() {
        return !TextUtils.isEmpty(this.f34425h.getEditableText().toString()) && !TextUtils.isEmpty(this.f34426i.getEditableText().toString()) && !TextUtils.isEmpty(this.f34429l.getEditableText().toString()) && !TextUtils.isEmpty(this.f34430m.getEditableText().toString()) && !TextUtils.isEmpty(this.f34431n.getEditableText().toString());
    }

    public void onButtonPressed() {
        this.f34420c.zipCode = this.f34425h.getText().toString();
        this.f34420c.streetName = this.f34426i.getText().toString();
        this.f34420c.number = this.f34427j.getText().toString();
        this.f34420c.complement = this.f34428k.getText().toString();
        this.f34420c.neighborhood = this.f34429l.getText().toString();
        this.f34420c.state = this.f34430m.getText().toString();
        this.f34420c.city = this.f34431n.getText().toString();
        this.f34423f.requestData(this.f34420c);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentAddressInteractionListener) {
            this.f34421d = (OnFragmentAddressInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f34422e = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentAddressInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.f34421d = null;
        this.f34422e = null;
    }

    public void onAddressPatchSuccessful() {
        OnFragmentAddressInteractionListener onFragmentAddressInteractionListener = this.f34421d;
        if (onFragmentAddressInteractionListener != null) {
            onFragmentAddressInteractionListener.onFragmentPatchSuccessInteraction();
        }
    }
}
