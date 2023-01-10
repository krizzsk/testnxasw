package com.didi.consume.phone.view.fragments;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.consume.phone.view.activities.CsPhoneRefillActivity;

public class CsMyFragmentsRouter {
    public static final String FRAGMENT_BACKSTACK_ADD_AMOUNT = "backstackAddAmount";
    public static final String FRAGMENT_BACKSTACK_ADD_CARRIER = "backstackAddCarrier";
    public static final String FRAGMENT_BACKSTACK_ADD_POST_CODE = "backstackAddCodeViewPage";
    public static final String FRAGMENT_TAG_AMOUNT = "amount";
    public static final String FRAGMENT_TAG_CARRIER = "carrier";
    public static final String FRAGMENT_TAG_DEFAULT_PHONE_NUM = "defaultPhoneNum";

    /* renamed from: b */
    private static final int f18161b = 2131430789;

    /* renamed from: a */
    private Context f18162a;
    public FragmentManager mFragmentManager;

    public CsMyFragmentsRouter(Context context) {
        this.f18162a = context;
        m15368a();
    }

    /* renamed from: a */
    private void m15368a() {
        this.mFragmentManager = ((CsPhoneRefillActivity) this.f18162a).getSupportFragmentManager();
    }

    public void addPhoneNumberView() {
        CsPhoneNumberFragment newInstance = CsPhoneNumberFragment.newInstance();
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        beginTransaction.add(f18161b, newInstance, FRAGMENT_TAG_DEFAULT_PHONE_NUM);
        beginTransaction.commitAllowingStateLoss();
    }

    public void addOperatorListView(String str, String str2) {
        CsPhoneOperatorFragment newInstance = CsPhoneOperatorFragment.newInstance(str, str2);
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        beginTransaction.addToBackStack(FRAGMENT_BACKSTACK_ADD_CARRIER);
        beginTransaction.add(f18161b, newInstance, "carrier");
        beginTransaction.setTransition(4099);
        beginTransaction.commitAllowingStateLoss();
    }

    public void addAmountListView(String str, String str2, String str3, int i, String str4) {
        CsPhoneAmountFragment newInstance = CsPhoneAmountFragment.newInstance(str, str2, str3, i, str4);
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        beginTransaction.addToBackStack(FRAGMENT_BACKSTACK_ADD_AMOUNT);
        beginTransaction.add(f18161b, newInstance, "amount");
        beginTransaction.setTransition(4099);
        beginTransaction.commitAllowingStateLoss();
    }

    public void popBackStackFromManager() {
        this.mFragmentManager.popBackStackImmediate();
    }
}
