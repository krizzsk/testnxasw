package com.didi.component.estimate.newui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.didi.component.common.view.CustomeViewPager;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailTwoPriceModel;
import com.google.android.material.tabs.TabLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class EstimateDetailShareCarView extends FrameLayout {

    /* renamed from: a */
    private View f14928a;

    /* renamed from: b */
    private Context f14929b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<CarDetailModel> f14930c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ShareCarTabListener f14931d;

    /* renamed from: e */
    private CarDetailTwoPriceModel f14932e;

    /* renamed from: f */
    private ShareCarPagerAdapter f14933f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AnyCarEstimateItemModel f14934g;

    interface ShareCarTabListener {
        void chooseTab(int i);
    }

    public EstimateDetailShareCarView(Context context, List<CarDetailModel> list, AnyCarEstimateItemModel anyCarEstimateItemModel, ShareCarTabListener shareCarTabListener) {
        super(context);
        this.f14930c = list;
        this.f14931d = shareCarTabListener;
        this.f14932e = list.get(0).carTwoPrice;
        this.f14934g = anyCarEstimateItemModel;
        m12288a(context);
    }

    /* renamed from: a */
    private void m12288a(Context context) {
        this.f14929b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.estimate_detail_share_car_layout, this, true);
        this.f14928a = inflate;
        TabLayout tabLayout = (TabLayout) inflate.findViewById(R.id.estimate_detail_pager_tab);
        TabLayout.Tab newTab = tabLayout.newTab();
        TabLayout.Tab newTab2 = tabLayout.newTab();
        CarDetailTwoPriceModel carDetailTwoPriceModel = this.f14932e;
        if (!(carDetailTwoPriceModel == null || carDetailTwoPriceModel.twoPriceMactch == null || this.f14932e.twoPriceUnmatch == null)) {
            newTab.setText((CharSequence) this.f14932e.twoPriceMactch);
            newTab2.setText((CharSequence) this.f14932e.twoPriceUnmatch);
        }
        tabLayout.addTab(newTab);
        tabLayout.addTab(newTab2);
        final CustomeViewPager customeViewPager = (CustomeViewPager) this.f14928a.findViewById(R.id.viewPager);
        ShareCarPagerAdapter shareCarPagerAdapter = new ShareCarPagerAdapter(this.f14929b);
        this.f14933f = shareCarPagerAdapter;
        customeViewPager.setAdapter(shareCarPagerAdapter);
        tabLayout.addOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener) new TabLayout.BaseOnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (EstimateDetailShareCarView.this.f14931d != null) {
                    EstimateDetailShareCarView.this.f14931d.chooseTab(position);
                }
                customeViewPager.setCurrentItem(position);
            }
        });
        customeViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    class ShareCarPagerAdapter extends PagerAdapter {
        private Context mContext;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public ShareCarPagerAdapter(Context context) {
            this.mContext = context;
        }

        public int getCount() {
            return EstimateDetailShareCarView.this.f14930c.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            CarDetailFeeListView carDetailFeeListView = new CarDetailFeeListView(this.mContext, EstimateDetailShareCarView.this.f14934g);
            carDetailFeeListView.setData(((CarDetailModel) EstimateDetailShareCarView.this.f14930c.get(i)).carDetailFeeInfo);
            viewGroup.addView(carDetailFeeListView);
            return carDetailFeeListView;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }
}
