package com.didi.sdk.sidebar.history;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import java.util.List;

public class HistoryListViewPagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a */
    private List<HistoryRecordFragment.HistoryListFragmentModel> f40007a;

    public int getItemPosition(Object obj) {
        return -2;
    }

    public HistoryListViewPagerAdapter(FragmentManager fragmentManager, List<HistoryRecordFragment.HistoryListFragmentModel> list) {
        super(fragmentManager);
        this.f40007a = list;
    }

    public int getCount() {
        return this.f40007a.size();
    }

    public Fragment getItem(int i) {
        return this.f40007a.get(i).historyListFragment;
    }
}
