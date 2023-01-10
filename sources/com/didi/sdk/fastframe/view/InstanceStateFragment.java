package com.didi.sdk.fastframe.view;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

public class InstanceStateFragment extends Fragment {
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        restore(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        restore(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        restore(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C13030a.m29164a(bundle, (Object) this);
    }

    public void restore(Bundle bundle) {
        if (bundle != null) {
            C13030a.m29168b(bundle, this);
        }
    }
}
