package com.didi.onehybrid.devmode.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.onehybrid.devmode.adapter.OfflineDetailListAdapter;
import com.didi.onehybrid.devmode.interfaces.CommunicationInterface;
import com.didi.onehybrid.util.C11212Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OfflineBundleDetailFragment extends BaseFragment {
    public static final String _TAG = "OfflineBundleDetailFragment";

    /* renamed from: a */
    HashMap<String, String> f32031a;

    /* renamed from: b */
    private OfflineDetailListAdapter f32032b;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public static OfflineBundleDetailFragment newInstance(CommunicationInterface communicationInterface, HashMap<String, String> hashMap) {
        OfflineBundleDetailFragment offlineBundleDetailFragment = new OfflineBundleDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("label", _TAG);
        offlineBundleDetailFragment.setArguments(bundle);
        offlineBundleDetailFragment.setChangeToTargetFragment(communicationInterface);
        offlineBundleDetailFragment.setCache(hashMap);
        return offlineBundleDetailFragment;
    }

    public void onResume() {
        super.onResume();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            m24406a();
        }
    }

    public void setCache(HashMap<String, String> hashMap) {
        this.f32031a = hashMap;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m24406a();
    }

    /* renamed from: a */
    private void m24406a() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.f32031a.entrySet()) {
            File file = new File((String) next.getValue());
            OfflineDetailListAdapter.CacheItemInfo cacheItemInfo = new OfflineDetailListAdapter.CacheItemInfo();
            cacheItemInfo.mFileName = file.getName();
            cacheItemInfo.mFileSize = "File size :  " + C11212Util.smartConvert(file.length());
            cacheItemInfo.mFileUrl = "File source :  " + ((String) next.getKey());
            Date date = new Date(file.lastModified());
            cacheItemInfo.mModifyTime = "File modify time :  " + date.toString();
            cacheItemInfo.mFilePath = "Local path :  " + file.getAbsolutePath();
            arrayList.add(cacheItemInfo);
        }
        OfflineDetailListAdapter offlineDetailListAdapter = new OfflineDetailListAdapter(getContext(), arrayList);
        this.f32032b = offlineDetailListAdapter;
        setListAdapter(offlineDetailListAdapter);
    }
}
