package com.didi.dimina.container.page;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.p065ui.launchview.DMBaseLaunchView;
import com.taxis99.R;

public class DMLaunchFragment extends Fragment implements KeyEvent.Callback {
    public static final String ARG_MINA_INDEX = "mina_index";

    /* renamed from: a */
    private int f18870a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DMMina f18871b;

    /* renamed from: c */
    private final OnBackPressedCallback f18872c = new OnBackPressedCallback(true) {
        public void handleOnBackPressed() {
            DMLaunchFragment.this.f18871b.markExitInDMMinaLaunch();
            if (DMLaunchFragment.this.f18871b.getPreInstallStatus() == 2) {
                DMLaunchFragment.this.f18871b.checkAndDoExitInMiniLaunch();
            }
        }
    };

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public static DMLaunchFragment newInstance(int i) {
        DMLaunchFragment dMLaunchFragment = new DMLaunchFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mina_index", i);
        dMLaunchFragment.setArguments(bundle);
        return dMLaunchFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f18870a = arguments.getInt("mina_index", -1);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getOnBackPressedDispatcher().addCallback(this, this.f18872c);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18871b = DMMinaPool.get(this.f18870a);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.dimina_launch_fragment, viewGroup, false);
        DMBaseLaunchView dMBaseLaunchView = null;
        try {
            Class<? extends DMBaseLaunchView> launchViewClazz = this.f18871b.getConfig().getUIConfig().getLaunchViewClazz();
            if (launchViewClazz != null) {
                Class[] clsArr = {Context.class, DMMina.class};
                dMBaseLaunchView = (DMBaseLaunchView) launchViewClazz.getConstructor(clsArr).newInstance(new Object[]{getContext(), this.f18871b});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dMBaseLaunchView != null) {
            frameLayout.addView(dMBaseLaunchView, new LinearLayout.LayoutParams(-1, -1));
        }
        return frameLayout;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f18871b.markExitInDMMinaLaunch();
        if (this.f18871b.getPreInstallStatus() != 2) {
            return true;
        }
        this.f18871b.checkAndDoExitInMiniLaunch();
        return true;
    }
}
