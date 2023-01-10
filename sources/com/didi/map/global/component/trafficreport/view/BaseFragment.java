package com.didi.map.global.component.trafficreport.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    protected BackHandledInterface mBackHandledInterface;

    public abstract boolean onBackPressed();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() instanceof BackHandledInterface) {
            this.mBackHandledInterface = (BackHandledInterface) getActivity();
            return;
        }
        throw new ClassCastException("Hosting Activity must implement BackHandledInterface");
    }

    public void onStart() {
        super.onStart();
        this.mBackHandledInterface.setSelectedFragment(this);
    }
}
