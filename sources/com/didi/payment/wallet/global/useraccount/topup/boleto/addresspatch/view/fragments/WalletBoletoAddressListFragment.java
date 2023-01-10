package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter.ListItem;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter.MyBoletoAddressListItemAdapter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoAddressListContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.AddressListStateResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter.WalletBoletoAddressListPresenter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.OnSideBarTouchListener;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.SideBar;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.SortUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class WalletBoletoAddressListFragment extends Fragment implements WalletBoletoAddressListContract.View {

    /* renamed from: b */
    private static final String f34433b = "state-or-city";

    /* renamed from: c */
    private static final String f34434c = "state";

    /* renamed from: d */
    private static final String f34435d = "city";

    /* renamed from: a */
    SideBar f34436a;

    /* renamed from: e */
    private String f34437e;

    /* renamed from: f */
    private ListFragmentExtraState f34438f;

    /* renamed from: g */
    private ListFragmentExtraCity f34439g;

    /* renamed from: h */
    private LinearLayout f34440h;

    /* renamed from: i */
    private RecyclerView f34441i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LinearLayoutManager f34442j;

    /* renamed from: k */
    private MyBoletoAddressListItemAdapter f34443k;

    /* renamed from: l */
    private OnListFragmentInteractionListener f34444l;

    /* renamed from: m */
    private WalletLoadingContract f34445m;

    /* renamed from: n */
    private WalletBoletoAddressListContract.Presenter f34446n;

    public interface OnListFragmentInteractionListener {
        void onListFragmentCityInteraction(ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment);

        void onListFragmentStateInteraction(ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment);
    }

    public static WalletBoletoAddressListFragment newInstance(ListFragmentExtraState listFragmentExtraState) {
        WalletBoletoAddressListFragment walletBoletoAddressListFragment = new WalletBoletoAddressListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f34433b, "state");
        bundle.putSerializable("state", listFragmentExtraState);
        walletBoletoAddressListFragment.setArguments(bundle);
        return walletBoletoAddressListFragment;
    }

    public static WalletBoletoAddressListFragment newInstance(ListFragmentExtraCity listFragmentExtraCity) {
        WalletBoletoAddressListFragment walletBoletoAddressListFragment = new WalletBoletoAddressListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f34433b, "city");
        bundle.putSerializable("city", listFragmentExtraCity);
        walletBoletoAddressListFragment.setArguments(bundle);
        return walletBoletoAddressListFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            String string = getArguments().getString(f34433b);
            this.f34437e = string;
            if ("city".equals(string)) {
                this.f34439g = (ListFragmentExtraCity) getArguments().getSerializable("city");
            } else if ("state".equals(this.f34437e)) {
                this.f34438f = (ListFragmentExtraState) getArguments().getSerializable("state");
            }
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m26269a();
    }

    /* renamed from: a */
    private void m26269a() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_statecityitem_list, viewGroup, false);
        m26270a(inflate);
        m26272c();
        this.f34446n = new WalletBoletoAddressListPresenter(getActivity(), this, this.f34445m);
        m26271b();
        return inflate;
    }

    /* renamed from: b */
    private void m26271b() {
        if (this.f34437e.equals("state")) {
            this.f34446n.requestStates(this.f34438f);
        } else if (this.f34437e.equals("city")) {
            this.f34446n.requestCities(this.f34439g);
        }
    }

    /* renamed from: a */
    private void m26270a(View view) {
        this.f34441i = (RecyclerView) view.findViewById(R.id.rv_address_list);
        this.f34440h = (LinearLayout) view.findViewById(R.id.ll_addr_list_empty);
        this.f34436a = (SideBar) view.findViewById(R.id.side_bar_state_city);
    }

    /* renamed from: c */
    private void m26272c() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.f34442j = linearLayoutManager;
        this.f34441i.setLayoutManager(linearLayoutManager);
        this.f34441i.setLayoutManager(this.f34442j);
        ArrayList arrayList = new ArrayList();
        this.f34436a.setOnSideBarTouchListener(SortUtil.getGroups(arrayList), new OnSideBarTouchListener() {
            public void onTouchEnd() {
            }

            public void onTouch(String str, int i) {
                if (i != -1) {
                    WalletBoletoAddressListFragment.this.f34442j.scrollToPositionWithOffset(i, 0);
                }
            }
        });
        MyBoletoAddressListItemAdapter myBoletoAddressListItemAdapter = new MyBoletoAddressListItemAdapter(arrayList, this.f34444l, this);
        this.f34443k = myBoletoAddressListItemAdapter;
        this.f34441i.setAdapter(myBoletoAddressListItemAdapter);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            this.f34444l = (OnListFragmentInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f34445m = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.f34444l = null;
        this.f34445m = null;
    }

    public void onStatesSuccessful(List<AddressListStateResp.StateBean> list) {
        ArrayList arrayList = new ArrayList();
        for (AddressListStateResp.StateBean next : list) {
            arrayList.add(new ListItem("state", next.stateName, next.stateCode));
        }
        SortUtil.sort(arrayList);
        this.f34436a.setOnSideBarTouchListener(SortUtil.getGroups(arrayList), new OnSideBarTouchListener() {
            public void onTouchEnd() {
            }

            public void onTouch(String str, int i) {
                if (i != -1) {
                    WalletBoletoAddressListFragment.this.f34442j.scrollToPositionWithOffset(i, 0);
                }
            }
        });
        this.f34443k.refresh(arrayList);
    }

    public void onCitiesSuccessful(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String listItem : list) {
            arrayList.add(new ListItem("city", listItem, (String) null));
        }
        SortUtil.sort(arrayList);
        this.f34436a.setOnSideBarTouchListener(SortUtil.getGroups(arrayList), new OnSideBarTouchListener() {
            public void onTouchEnd() {
            }

            public void onTouch(String str, int i) {
                if (i != -1) {
                    WalletBoletoAddressListFragment.this.f34442j.scrollToPositionWithOffset(i, 0);
                }
            }
        });
        this.f34443k.refresh(arrayList);
    }

    public void onNetworkError() {
        this.f34441i.setVisibility(8);
        this.f34436a.setVisibility(8);
        this.f34440h.setVisibility(0);
    }
}
