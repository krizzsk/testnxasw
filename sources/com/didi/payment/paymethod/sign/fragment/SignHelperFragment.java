package com.didi.payment.paymethod.sign.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.payment.paymethod.sign.channel.ISignChannel;
import com.didi.payment.paymethod.sign.channel.SignChannelFactory;

public class SignHelperFragment extends Fragment {

    /* renamed from: a */
    private static final String f33552a = "SignHelperFragment";

    /* renamed from: b */
    private static final String f33553b = "SIGN_PARAM";

    /* renamed from: c */
    private ISignChannel f33554c;

    /* renamed from: d */
    private SignCallback f33555d;

    /* renamed from: e */
    private boolean f33556e;

    public static void launch(FragmentActivity fragmentActivity, SignParam signParam, SignCallback signCallback) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(f33552a);
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        beginTransaction.add((Fragment) newInstance(signParam, signCallback), f33552a);
        beginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    public static SignHelperFragment newInstance(SignParam signParam, SignCallback signCallback) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(f33553b, signParam);
        SignHelperFragment signHelperFragment = new SignHelperFragment();
        signHelperFragment.setArguments(bundle);
        signHelperFragment.setCallback(signCallback);
        return signHelperFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        SignParam signParam = (SignParam) getArguments().getSerializable(f33553b);
        if (signParam != null) {
            ISignChannel createSignChannel = SignChannelFactory.createSignChannel(getContext(), signParam.channelId);
            this.f33554c = createSignChannel;
            createSignChannel.sign(this, signParam, this.f33555d);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f33556e) {
            this.f33556e = false;
            this.f33554c.onActivityResume();
        }
    }

    public void onPause() {
        super.onPause();
        this.f33556e = true;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f33554c.release();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f33554c.onActivityResult(i2);
    }

    public void setCallback(SignCallback signCallback) {
        this.f33555d = signCallback;
    }
}
