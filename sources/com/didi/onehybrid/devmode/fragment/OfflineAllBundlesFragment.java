package com.didi.onehybrid.devmode.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ListFragment;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.onehybrid.devmode.adapter.AllOfflineItemAdapter;
import com.didi.onehybrid.resource.offline.OfflineBundleManager;
import com.didi.onehybrid.util.C11212Util;
import java.util.ArrayList;
import java.util.Map;

public class OfflineAllBundlesFragment extends ListFragment {
    public static final String _TAG = "OfflineAllBundlesFragment";

    /* renamed from: a */
    AllOfflineItemAdapter f32028a;

    /* renamed from: b */
    private View f32029b;

    /* renamed from: c */
    private FusionRuntimeInfo f32030c;

    public static OfflineAllBundlesFragment newInstance(FusionRuntimeInfo fusionRuntimeInfo) {
        OfflineAllBundlesFragment offlineAllBundlesFragment = new OfflineAllBundlesFragment();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("label", _TAG);
        offlineAllBundlesFragment.setArguments(bundle);
        offlineAllBundlesFragment.f32030c = fusionRuntimeInfo;
        return offlineAllBundlesFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f32029b = onCreateView;
        return onCreateView;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (OfflineBundleManager.isInitialized() && this.f32030c != null) {
            OfflineBundleManager.getInstance().getOfflineInfo(this.f32030c);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : this.f32030c.getRenderInfo().bundles.entrySet()) {
                AllOfflineItemAdapter.AllOfflineItemInfo allOfflineItemInfo = new AllOfflineItemAdapter.AllOfflineItemInfo();
                allOfflineItemInfo.mBundleName = (String) next.getKey();
                allOfflineItemInfo.mSize = C11212Util.smartConvert(((Long) next.getValue()).longValue());
                arrayList.add(allOfflineItemInfo);
            }
            AllOfflineItemAdapter allOfflineItemAdapter = new AllOfflineItemAdapter(getActivity(), arrayList);
            this.f32028a = allOfflineItemAdapter;
            setListAdapter(allOfflineItemAdapter);
        }
    }
}
