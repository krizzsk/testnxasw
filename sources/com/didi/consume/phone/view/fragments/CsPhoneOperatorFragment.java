package com.didi.consume.phone.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsOperatorListResp;
import com.didi.consume.phone.view.adapter.CsMobileOperatorAdapter;
import com.didi.consume.phone.view.contract.CsPhoneOperatorContract;
import com.didi.consume.phone.view.prsenter.CsPhoneOperatorPresenter;
import com.didi.payment.base.view.PayHomelandCityErrorView;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.taxis99.R;
import java.util.HashMap;

public class CsPhoneOperatorFragment extends Fragment implements CsPhoneOperatorContract.View {

    /* renamed from: a */
    private static final String f18217a = "param_country_code";

    /* renamed from: b */
    private static final String f18218b = "param_phone_num";

    /* renamed from: c */
    private String f18219c;

    /* renamed from: d */
    private String f18220d;

    /* renamed from: e */
    private LinearLayout f18221e;

    /* renamed from: f */
    private RecyclerView f18222f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CsMobileOperatorAdapter f18223g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f18224h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CsPhoneOperatorContract.Presenter f18225i;

    /* renamed from: j */
    private WalletLoadingContract f18226j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnFragmentOperatorInteractionListener f18227k;

    /* renamed from: l */
    private CsMobileOperatorAdapter.OnOperatorClickListener f18228l = new CsMobileOperatorAdapter.OnOperatorClickListener() {
        public void onClick(CsOperatorListResp.Operator operator) {
            CsPhoneOperatorFragment.this.f18223g.refreshSelectOperator(operator);
            CsPhoneOperatorFragment.this.f18224h.setEnabled(true);
            CsPhoneOperatorFragment.this.f18225i.trackOmega(0);
        }
    };

    /* renamed from: m */
    private View.OnClickListener f18229m = new NoDoubleClickListener() {
        public void onNoDoubleClick(View view) {
            if (CsPhoneOperatorFragment.this.f18223g.getCurrentSelectItem() != null) {
                CsOmegaUtils.trackPhoneBillConfirmBtnClicked(ErrorConst.ErrorParam.OPERATOR);
                CsPhoneOperatorFragment.this.f18227k.onFragmentOperatorInteraction(CsPhoneOperatorFragment.this.f18223g.getCurrentSelectItem());
            }
        }
    };

    public interface OnFragmentOperatorInteractionListener {
        void onFragmentOperatorInteraction(CsOperatorListResp.Operator operator);
    }

    public void onNetworkError() {
    }

    public static CsPhoneOperatorFragment newInstance(String str, String str2) {
        CsPhoneOperatorFragment csPhoneOperatorFragment = new CsPhoneOperatorFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f18217a, str);
        bundle.putSerializable(f18218b, str2);
        csPhoneOperatorFragment.setArguments(bundle);
        return csPhoneOperatorFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f18219c = (String) getArguments().getSerializable(f18217a);
            this.f18220d = (String) getArguments().getSerializable(f18218b);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cs_fragment_operator, viewGroup, false);
        m15411a(inflate);
        m15410a();
        this.f18225i = new CsPhoneOperatorPresenter(getActivity(), this, this.f18226j);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (this.f18223g == null) {
            this.f18225i.getOperatorList(605, this.f18219c, this.f18220d);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentOperatorInteractionListener) {
            this.f18227k = (OnFragmentOperatorInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f18226j = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentZipCodeInteractionListener");
    }

    /* renamed from: a */
    private void m15411a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_operator_content);
        this.f18221e = linearLayout;
        this.f18222f = (RecyclerView) linearLayout.findViewById(R.id.rv_operator_list);
        this.f18224h = (TextView) this.f18221e.findViewById(R.id.btn_operator_next);
    }

    /* renamed from: a */
    private void m15410a() {
        this.f18224h.setOnClickListener(this.f18229m);
    }

    public void showOperators(CsOperatorListResp csOperatorListResp) {
        this.f18223g = new CsMobileOperatorAdapter(getContext(), csOperatorListResp.data.operators, this.f18228l);
        this.f18222f.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.f18222f.setAdapter(this.f18223g);
        int intExtra = getActivity().getIntent().getIntExtra("order_type", -1);
        HashMap hashMap = new HashMap();
        int i = 1;
        if (intExtra != 1) {
            i = 0;
        }
        hashMap.put("order_type", Integer.valueOf(i));
        CsOmegaUtils.trackPhoneBillOperatorDisplay(hashMap);
    }

    public void showHomelandCityErrorPage() {
        PayHomelandCityErrorView.show(this.f18221e);
    }
}
