package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.utils.TextUtils;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoZipCodeContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter.WalletBoletoZipCodePresenter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.taxis99.R;

public class WalletBoletoZipCodeFragment extends Fragment implements WalletBoletoZipCodeContract.View {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f34447a;

    /* renamed from: b */
    private TextView f34448b;

    /* renamed from: c */
    private ImageView f34449c;

    /* renamed from: d */
    private WalletBoletoZipCodeContract.Presenter f34450d;

    /* renamed from: e */
    private WalletLoadingContract f34451e;

    /* renamed from: f */
    private OnFragmentZipCodeInteractionListener f34452f;

    public interface OnFragmentZipCodeInteractionListener {
        void onFragmentZipCodeInteraction(AddressFromZipCodeResp.DataBean dataBean);
    }

    public void onNetworkError() {
    }

    public static WalletBoletoZipCodeFragment newInstance() {
        WalletBoletoZipCodeFragment walletBoletoZipCodeFragment = new WalletBoletoZipCodeFragment();
        walletBoletoZipCodeFragment.setArguments(new Bundle());
        return walletBoletoZipCodeFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.wallet_global_fragment_boleto_cashin_zipcode, viewGroup, false);
        m26275a(inflate);
        m26274a();
        this.f34450d = new WalletBoletoZipCodePresenter(getActivity(), this, this.f34451e);
        GlobalOmegaUtils.trackBoletoAddressPatchZipcodePageSW();
        return inflate;
    }

    /* renamed from: a */
    private void m26275a(View view) {
        this.f34447a = (EditText) view.findViewById(R.id.et_boleto_zipcode_text);
        this.f34448b = (TextView) view.findViewById(R.id.btn_boleto_zipcode_next);
        this.f34449c = (ImageView) view.findViewById(R.id.tv_boleto_zipcode_delete_btn);
    }

    /* renamed from: a */
    private void m26274a() {
        this.f34447a.post(new Runnable() {
            public void run() {
                WalletBoletoZipCodeFragment.this.f34447a.requestFocus();
            }
        });
        this.f34447a.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                WalletBoletoZipCodeFragment.this.m26276b();
                WalletBoletoZipCodeFragment.this.m26278c();
            }
        });
        this.f34448b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBoletoAddressPatchZipcodeButtonCK();
                WalletBoletoZipCodeFragment walletBoletoZipCodeFragment = WalletBoletoZipCodeFragment.this;
                walletBoletoZipCodeFragment.onButtonPressed(walletBoletoZipCodeFragment.f34447a.getText().toString());
            }
        });
        this.f34449c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoZipCodeFragment.this.f34447a.setText("");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26276b() {
        if (m26280d()) {
            this.f34449c.setVisibility(0);
        } else {
            this.f34449c.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26278c() {
        this.f34448b.setEnabled(m26280d());
    }

    /* renamed from: d */
    private boolean m26280d() {
        return !TextUtils.isEmpty(this.f34447a.getEditableText().toString());
    }

    public void onButtonPressed(String str) {
        if (str.length() != 8) {
            WalletToastNew.showFailedMsg(getActivity(), getActivity().getResources().getString(R.string.wallet_boleto_zipcode_error_toast));
            return;
        }
        WalletBoletoZipCodeContract.Presenter presenter = this.f34450d;
        if (presenter != null) {
            presenter.requestData(str);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentZipCodeInteractionListener) {
            this.f34452f = (OnFragmentZipCodeInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f34451e = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentZipCodeInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.f34452f = null;
        this.f34451e = null;
    }

    public void sendAddress(AddressFromZipCodeResp.DataBean dataBean) {
        OnFragmentZipCodeInteractionListener onFragmentZipCodeInteractionListener = this.f34452f;
        if (onFragmentZipCodeInteractionListener != null) {
            onFragmentZipCodeInteractionListener.onFragmentZipCodeInteraction(dataBean);
        }
    }
}
