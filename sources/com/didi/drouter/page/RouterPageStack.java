package com.didi.drouter.page;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.drouter.page.IPageBean;
import java.util.ArrayList;
import java.util.List;

public class RouterPageStack extends RouterPageAbs {

    /* renamed from: a */
    private final FragmentManager f20992a;

    /* renamed from: b */
    private final int f20993b;

    /* renamed from: c */
    private final List<Fragment> f20994c = new ArrayList();

    /* renamed from: d */
    private final List<IPageBean> f20995d = new ArrayList();

    public RouterPageStack(FragmentManager fragmentManager, int i) {
        this.f20992a = fragmentManager;
        this.f20993b = i;
    }

    public void showPage(IPageBean iPageBean) {
        Fragment newFragment = newFragment(iPageBean.getPageUri());
        addArgsForFragment(newFragment, iPageBean.getPageInfo());
        this.f20992a.beginTransaction().add(this.f20993b, newFragment).commitAllowingStateLoss();
        notifyPageChanged(iPageBean);
        this.f20994c.add(newFragment);
        this.f20995d.add(iPageBean);
    }

    public void popPage() {
        if (!this.f20994c.isEmpty()) {
            int size = this.f20994c.size() - 1;
            this.f20995d.remove(size);
            this.f20992a.beginTransaction().remove(this.f20994c.remove(size)).commitAllowingStateLoss();
            int i = size - 1;
            notifyPageChanged((i < 0 || i >= this.f20995d.size()) ? new IPageBean.EmptyPageBean() : this.f20995d.get(i));
        }
    }

    public IPageBean getCurPage() {
        return super.getCurPage();
    }
}
