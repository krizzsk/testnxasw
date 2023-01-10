package com.didi.component.comp_selectseat.shiftselect;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.activity.ShiftSelectActivity;
import com.didi.component.comp_selectseat.adapter.FrequencySelectCallBack;
import com.didi.component.comp_selectseat.adapter.RecycleViewScrollableListener;
import com.didi.component.comp_selectseat.adapter.ViewPagerAdapter;
import com.didi.component.comp_selectseat.model.ItemsBean;
import com.didi.component.comp_selectseat.model.ShiftBean;
import com.didi.component.core.PresenterGroup;
import com.didi.sdk.util.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShiftSelectFragment extends AbsNormalFragment implements View.OnClickListener, IShiftSelectView {

    /* renamed from: b */
    private static final String f14286b = "ShiftSelectFragment";

    /* renamed from: A */
    private final int f14287A = 3;

    /* renamed from: B */
    private AppBarLayout f14288B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final List<Boolean> f14289C = new ArrayList();

    /* renamed from: D */
    private final TabLayout.OnTabSelectedListener f14290D = new TabLayout.OnTabSelectedListener() {
        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
            ShiftSelectFragment.this.m11862a(tab, true);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            ShiftSelectFragment.this.m11862a(tab, false);
        }
    };

    /* renamed from: E */
    private final FrequencySelectCallBack f14291E = new FrequencySelectCallBack() {
        public void onFrequencySelectCallBack(ShiftBean shiftBean, boolean z) {
            if (z) {
                ShiftBean unused = ShiftSelectFragment.this.f14309p = shiftBean;
            } else {
                ShiftBean unused2 = ShiftSelectFragment.this.f14309p = null;
            }
            ShiftSelectFragment.this.f14304k.setEnabled(z);
        }
    };

    /* renamed from: F */
    private final ViewPager2.OnPageChangeCallback f14292F = new ViewPager2.OnPageChangeCallback() {
        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            GLog.m11357e(ShiftSelectFragment.f14286b, "onPageSelected: " + i + " size== " + ShiftSelectFragment.this.f14289C.size());
            if (ShiftSelectFragment.this.f14289C.size() > 0 && i < ShiftSelectFragment.this.f14289C.size()) {
                ShiftSelectFragment shiftSelectFragment = ShiftSelectFragment.this;
                shiftSelectFragment.m11868b(((Boolean) shiftSelectFragment.f14289C.get(i)).booleanValue());
            }
        }

        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
        }
    };

    /* renamed from: G */
    private final AppBarLayout.BaseOnOffsetChangedListener f14293G = new AppBarLayout.BaseOnOffsetChangedListener() {
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int measuredHeight = ShiftSelectFragment.this.f14300g.getMeasuredHeight() + UiUtils.dip2px(ShiftSelectFragment.this.getContext(), 4.0f);
            GLog.m11361v(ShiftSelectFragment.f14286b, "mVerticalOffset= " + abs + " titleHeight= " + measuredHeight);
            if (abs < measuredHeight - 3 || measuredHeight == 0) {
                if (ShiftSelectFragment.this.f14316w == 2) {
                    int unused = ShiftSelectFragment.this.f14316w = 3;
                    ShiftSelectFragment.this.m11864a(false);
                }
            } else if (ShiftSelectFragment.this.f14316w == 0) {
                int unused2 = ShiftSelectFragment.this.f14316w = 1;
                ShiftSelectFragment.this.m11864a(true);
            }
        }
    };

    /* renamed from: H */
    private final RecycleViewScrollableListener f14294H = new RecycleViewScrollableListener() {
        public void updateScrollableList(int i, boolean z) {
            GLog.m11357e(ShiftSelectFragment.f14286b, "updateScrollableList: " + i + " scrollable== " + z + " size== " + ShiftSelectFragment.this.f14289C.size());
            if (i < ShiftSelectFragment.this.f14289C.size()) {
                ShiftSelectFragment.this.f14289C.set(i, Boolean.valueOf(z));
                ShiftSelectFragment.this.f14289C.set(i, Boolean.valueOf(z));
                ShiftSelectFragment.this.m11868b(z);
            }
        }
    };

    /* renamed from: a */
    private View f14295a;

    /* renamed from: c */
    private ImageView f14296c;

    /* renamed from: d */
    private ImageView f14297d;

    /* renamed from: e */
    private ImageView f14298e;

    /* renamed from: f */
    private TextView f14299f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f14300g;

    /* renamed from: h */
    private TextView f14301h;

    /* renamed from: i */
    private TextView f14302i;

    /* renamed from: j */
    private TabLayout f14303j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TextView f14304k;

    /* renamed from: l */
    private ViewPager2 f14305l;

    /* renamed from: m */
    private ViewPagerAdapter f14306m;

    /* renamed from: n */
    private ShiftSelectTopPresenter f14307n;

    /* renamed from: o */
    private ShiftSelectActivity f14308o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ShiftBean f14309p;

    /* renamed from: q */
    private LinearLayout f14310q;

    /* renamed from: r */
    private LinearLayout f14311r;

    /* renamed from: s */
    private LinearLayout f14312s;

    /* renamed from: t */
    private LinearLayout f14313t;

    /* renamed from: u */
    private CoordinatorLayout f14314u;

    /* renamed from: v */
    private ObjectAnimator f14315v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f14316w;

    /* renamed from: x */
    private final int f14317x = 0;

    /* renamed from: y */
    private final int f14318y = 1;

    /* renamed from: z */
    private final int f14319z = 2;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 0;
    }

    public static ShiftSelectFragment newInstance(String str) {
        ShiftSelectFragment shiftSelectFragment = new ShiftSelectFragment();
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("selectValueParams", str);
        } else {
            GLog.m11357e(f14286b, "newInstance()>> jsonObject is null ");
        }
        shiftSelectFragment.setArguments(bundle);
        return shiftSelectFragment;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14295a = layoutInflater.inflate(R.layout.shift_select_fragment, viewGroup, false);
        m11859a();
        return this.f14295a;
    }

    /* renamed from: a */
    private void m11859a() {
        ImageView imageView = (ImageView) this.f14295a.findViewById(R.id.btn_back);
        this.f14296c = imageView;
        imageView.setOnClickListener(this);
        this.f14299f = (TextView) this.f14295a.findViewById(R.id.tv_max_title);
        this.f14300g = (TextView) this.f14295a.findViewById(R.id.tv_min_title);
        this.f14301h = (TextView) this.f14295a.findViewById(R.id.tv_hint_info);
        TabLayout tabLayout = (TabLayout) this.f14295a.findViewById(R.id.rv_data);
        this.f14303j = tabLayout;
        tabLayout.addOnTabSelectedListener(this.f14290D);
        TextView textView = (TextView) this.f14295a.findViewById(R.id.btn_next);
        this.f14304k = textView;
        textView.setOnClickListener(this);
        this.f14304k.setEnabled(false);
        ViewPager2 viewPager2 = (ViewPager2) this.f14295a.findViewById(R.id.vp_frequency);
        this.f14305l = viewPager2;
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(viewPager2.getContext(), this.f14291E);
        this.f14306m = viewPagerAdapter;
        this.f14305l.setAdapter(viewPagerAdapter);
        this.f14305l.registerOnPageChangeCallback(this.f14292F);
        this.f14305l.setOffscreenPageLimit(-1);
        AppBarLayout appBarLayout = (AppBarLayout) this.f14295a.findViewById(R.id.appbar);
        this.f14288B = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.f14293G);
        this.f14314u = (CoordinatorLayout) this.f14295a.findViewById(R.id.cl_content);
        ImageView imageView2 = (ImageView) this.f14295a.findViewById(R.id.btn_back_loading);
        this.f14297d = imageView2;
        imageView2.setOnClickListener(this);
        this.f14310q = (LinearLayout) this.f14295a.findViewById(R.id.ll_loading);
        this.f14311r = (LinearLayout) this.f14295a.findViewById(R.id.ll_net_error);
        ((Button) this.f14295a.findViewById(R.id.btn_retry)).setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.f14295a.findViewById(R.id.btn_loading_error_back);
        this.f14298e = imageView3;
        imageView3.setOnClickListener(this);
        this.f14312s = (LinearLayout) this.f14295a.findViewById(R.id.ll_no_frequency);
        ((ImageView) this.f14295a.findViewById(R.id.no_frequency_btn_back)).setOnClickListener(this);
        this.f14302i = (TextView) this.f14295a.findViewById(R.id.tv_no_bus_title);
        this.f14313t = (LinearLayout) this.f14295a.findViewById(R.id.ll_bottom_content);
    }

    public void setDate(List<ItemsBean> list) {
        m11866b();
        m11863a(list);
        this.f14289C.clear();
        for (ItemsBean itemsBean : list) {
            if (itemsBean != null) {
                this.f14289C.add(false);
            }
        }
        this.f14306m.setRecycleViewSlidableListener(this.f14294H);
        this.f14306m.setDate(list);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f14308o = (ShiftSelectActivity) context;
    }

    public void showLoadingErrorUi() {
        this.f14314u.setVisibility(8);
        this.f14313t.setVisibility(8);
        this.f14310q.setVisibility(8);
        this.f14311r.setVisibility(0);
        this.f14312s.setVisibility(8);
    }

    public void showNoBusLayout(String str) {
        this.f14314u.setVisibility(8);
        this.f14313t.setVisibility(8);
        this.f14310q.setVisibility(8);
        this.f14311r.setVisibility(8);
        this.f14312s.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.f14302i.setText(str);
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f14308o = null;
        ObjectAnimator objectAnimator = this.f14315v;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f14315v.cancel();
        }
    }

    public void setMaxTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14299f.setText(str);
            this.f14299f.setAlpha(0.0f);
        }
    }

    public void setMinTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14300g.setText(str);
        }
    }

    public void setHintInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14301h.setText(str);
        }
    }

    /* renamed from: a */
    private void m11863a(final List<ItemsBean> list) {
        new TabLayoutMediator(this.f14303j, this.f14305l, new TabLayoutMediator.TabConfigurationStrategy() {
            public void onConfigureTab(TabLayout.Tab tab, int i) {
                tab.setCustomView(ShiftSelectFragment.this.m11855a((ItemsBean) list.get(i)));
            }
        }).attach();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m11855a(ItemsBean itemsBean) {
        View inflate = LayoutInflater.from(this.f14303j.getContext()).inflate(R.layout.tablayout_item_view, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.iv_week);
        TextView textView2 = (TextView) inflate.findViewById(R.id.iv_date);
        if (itemsBean != null) {
            if (!TextUtils.isEmpty(itemsBean.title)) {
                textView.setText(itemsBean.title);
            } else {
                GLog.m11357e(f14286b, "makeTabLayoutItemView>> title is null ");
            }
            if (!TextUtils.isEmpty(itemsBean.content)) {
                textView2.setText(itemsBean.content);
            } else {
                GLog.m11357e(f14286b, "makeTabLayoutItemView>> content is null ");
            }
        } else {
            GLog.m11357e(f14286b, "makeTabLayoutItemView>> itemsBean is null ");
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11862a(TabLayout.Tab tab, boolean z) {
        View customView = tab.getCustomView();
        if (customView != null) {
            TextView textView = (TextView) customView.findViewById(R.id.iv_week);
            TextView textView2 = (TextView) customView.findViewById(R.id.iv_date);
            Context context = getContext();
            if (context != null) {
                if (z) {
                    textView.setTextColor(context.getResources().getColor(R.color.tab_layout_text_selected_color));
                    textView2.setTextColor(context.getResources().getColor(R.color.tab_layout_text_selected_color));
                    return;
                }
                textView.setTextColor(context.getResources().getColor(R.color.tab_layout_text_unselected_color));
                textView2.setTextColor(context.getResources().getColor(R.color.tab_layout_text_unselected_color));
            }
        }
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        ShiftSelectTopPresenter shiftSelectTopPresenter = new ShiftSelectTopPresenter(getContext(), getArguments());
        this.f14307n = shiftSelectTopPresenter;
        return shiftSelectTopPresenter;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.btn_next) {
            if (!Utils.isFastDoubleClick()) {
                this.f14307n.onConfirmBtnClick(this.f14309p);
                this.f14308o.clickConfirm();
            }
        } else if (id == R.id.btn_back_loading || id == R.id.btn_back || id == R.id.btn_loading_error_back || id == R.id.no_frequency_btn_back) {
            HashMap hashMap = new HashMap();
            hashMap.put("k", "click");
            GlobalOmegaUtils.trackEvent("ibt_gp_minibus_shift_return_ck", (Map<String, Object>) hashMap);
            this.f14308o.finish();
        } else if (id == R.id.btn_retry) {
            this.f14307n.PageRequest();
        }
    }

    /* renamed from: b */
    private void m11866b() {
        this.f14314u.setVisibility(0);
        this.f14313t.setVisibility(0);
        this.f14310q.setVisibility(8);
        this.f14311r.setVisibility(8);
        this.f14312s.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11864a(boolean z) {
        if (z) {
            this.f14315v = ObjectAnimator.ofFloat(this.f14299f, "alpha", new float[]{0.0f, 1.0f});
        } else {
            this.f14315v = ObjectAnimator.ofFloat(this.f14299f, "alpha", new float[]{1.0f, 0.0f});
        }
        this.f14315v.setDuration(100);
        if (!this.f14315v.isRunning()) {
            this.f14315v.start();
        }
        this.f14315v.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                GLog.m11354d(ShiftSelectFragment.f14286b, "onAnimationEnd:mNavigationBarTitleStatus=  " + ShiftSelectFragment.this.f14316w);
                if (ShiftSelectFragment.this.f14316w == 1) {
                    int unused = ShiftSelectFragment.this.f14316w = 2;
                } else if (ShiftSelectFragment.this.f14316w == 3) {
                    int unused2 = ShiftSelectFragment.this.f14316w = 0;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11868b(boolean z) {
        View childAt = this.f14288B.getChildAt(0);
        if (childAt.getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams();
            GLog.m11357e(f14286b, "setAppBarLayoutScrollFlags?>>: " + z);
            if (z) {
                layoutParams.setScrollFlags(3);
            } else {
                layoutParams.setScrollFlags(0);
            }
            childAt.setLayoutParams(layoutParams);
        }
    }
}
