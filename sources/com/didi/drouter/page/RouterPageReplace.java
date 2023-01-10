package com.didi.drouter.page;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.drouter.page.IPageBean;

public class RouterPageReplace extends RouterPageAbs {

    /* renamed from: a */
    private final FragmentManager f20989a;

    /* renamed from: b */
    private final int f20990b;

    /* renamed from: c */
    private Fragment f20991c;

    public RouterPageReplace(FragmentManager fragmentManager, int i) {
        this.f20989a = fragmentManager;
        this.f20990b = i;
    }

    public void showPage(IPageBean iPageBean) {
        Fragment newFragment = newFragment(iPageBean.getPageUri());
        this.f20991c = newFragment;
        addArgsForFragment(newFragment, iPageBean.getPageInfo());
        this.f20989a.beginTransaction().replace(this.f20990b, this.f20991c).commitAllowingStateLoss();
        notifyPageChanged(iPageBean);
    }

    public void popPage() {
        if (this.f20991c != null) {
            this.f20989a.beginTransaction().remove(this.f20991c).commitAllowingStateLoss();
            notifyPageChanged(new IPageBean.EmptyPageBean());
            this.f20991c = null;
        }
    }
}
