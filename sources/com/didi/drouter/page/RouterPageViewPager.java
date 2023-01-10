package com.didi.drouter.page;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.didi.drouter.page.IPageBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouterPageViewPager extends RouterPageAbs {

    /* renamed from: a */
    private final ViewPager f20996a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final FragmentManager f20997b;

    /* renamed from: c */
    private final ViewPagerAdapter f20998c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final List<String> f20999d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<IPageBean> f21000e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<String> f21001f = new ArrayList();

    public RouterPageViewPager(FragmentManager fragmentManager, ViewPager viewPager) {
        this.f20997b = fragmentManager;
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        this.f20998c = viewPagerAdapter;
        this.f20996a = viewPager;
        viewPager.setAdapter(viewPagerAdapter);
        this.f20996a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                RouterPageViewPager.this.m17754a(i);
            }
        });
    }

    public void update(IPageBean... iPageBeanArr) {
        update((List<IPageBean>) Arrays.asList(iPageBeanArr));
    }

    public void update(List<IPageBean> list) {
        this.f21001f = (List) ((ArrayList) this.f20999d).clone();
        this.f20999d.clear();
        this.f21000e.clear();
        for (int i = 0; i < list.size(); i++) {
            this.f20999d.add(list.get(i).getPageUri());
            this.f21000e.add(list.get(i));
        }
        this.f20998c.notifyDataSetChanged();
        m17754a(this.f20996a.getCurrentItem());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17754a(int i) {
        notifyPageChanged(i < this.f21000e.size() ? this.f21000e.get(i) : new IPageBean.EmptyPageBean());
    }

    public void showPage(IPageBean iPageBean) {
        int indexOf = this.f20999d.indexOf(iPageBean.getPageUri());
        if (indexOf != -1) {
            this.f20996a.setCurrentItem(indexOf, false);
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        public int getItemPosition(Object obj) {
            return -2;
        }

        ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            RouterPageViewPager routerPageViewPager = RouterPageViewPager.this;
            Fragment newFragment = routerPageViewPager.newFragment((String) routerPageViewPager.f20999d.get(i));
            RouterPageViewPager.this.addArgsForFragment(newFragment, (RouterPageViewPager.this.f21000e.get(i) == null || ((IPageBean) RouterPageViewPager.this.f21000e.get(i)).getPageInfo() == null) ? null : ((IPageBean) RouterPageViewPager.this.f21000e.get(i)).getPageInfo());
            return newFragment;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i < RouterPageViewPager.this.f20999d.size() && i < RouterPageViewPager.this.f21001f.size() && !((String) RouterPageViewPager.this.f20999d.get(i)).equals(RouterPageViewPager.this.f21001f.get(i))) {
                FragmentTransaction beginTransaction = RouterPageViewPager.this.f20997b.beginTransaction();
                Fragment findFragmentByTag = RouterPageViewPager.this.f20997b.findFragmentByTag(RouterPageViewPager.m17756b(viewGroup.getId(), (long) i));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                    beginTransaction.commitNowAllowingStateLoss();
                }
            }
            return super.instantiateItem(viewGroup, i);
        }

        public int getCount() {
            return RouterPageViewPager.this.f20999d.size();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m17756b(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
