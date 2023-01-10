package com.didi.dimina.starbox.p108ui.base;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.didi.dimina.container.util.LogUtil;
import java.util.ArrayDeque;

/* renamed from: com.didi.dimina.starbox.ui.base.BaseActivity */
public abstract class BaseActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final String f19981a = "BaseActivity";

    /* renamed from: b */
    private final ArrayDeque<BaseFragment> f19982b = new ArrayDeque<>();

    public void showContent(Class<? extends BaseFragment> cls) {
        showContent(cls, (Bundle) null);
    }

    public void showContent(Class<? extends BaseFragment> cls, Bundle bundle) {
        try {
            BaseFragment baseFragment = (BaseFragment) cls.newInstance();
            if (bundle != null) {
                baseFragment.setArguments(bundle);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(16908290, (Fragment) baseFragment);
            this.f19982b.push(baseFragment);
            beginTransaction.addToBackStack("");
            beginTransaction.commit();
        } catch (InstantiationException e) {
            LogUtil.m16840e(f19981a, e.toString());
        } catch (IllegalAccessException e2) {
            LogUtil.m16840e(f19981a, e2.toString());
        }
    }

    public void onBackPressed() {
        if (this.f19982b.isEmpty()) {
            super.onBackPressed();
        } else if (!this.f19982b.getFirst().onBackPressed()) {
            this.f19982b.removeFirst();
            super.onBackPressed();
            if (this.f19982b.isEmpty()) {
                finish();
            }
        }
    }

    public void doBack(BaseFragment baseFragment) {
        if (this.f19982b.contains(baseFragment)) {
            this.f19982b.remove(baseFragment);
            getSupportFragmentManager().popBackStack();
            if (this.f19982b.isEmpty()) {
                finish();
            }
        }
    }
}
