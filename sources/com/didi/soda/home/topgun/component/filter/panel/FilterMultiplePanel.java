package com.didi.soda.home.topgun.component.filter.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.legacy.widget.Space;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.module.AbsFilterModule;
import com.didi.soda.home.topgun.component.filter.module.CommonFilterModule;
import com.didi.soda.home.topgun.component.filter.module.FlowFilterModule;
import com.didi.soda.home.topgun.component.filter.module.SingleLineWithIconFilterModule;
import com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.model.FilterItemParam;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.HasListenerScollView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class FilterMultiplePanel extends FilterPanel implements View.OnClickListener {
    public static final int MULTIPLE_SHOW_TYPE = 3;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LinearLayout f45366a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HasListenerScollView f45367b;

    /* renamed from: c */
    private List<AbsFilterModule> f45368c = new ArrayList();

    /* renamed from: d */
    private CustomerAppCompatTextView f45369d;

    /* renamed from: e */
    private CustomerAppCompatTextView f45370e;

    /* renamed from: f */
    private ConstraintLayout f45371f;

    /* renamed from: g */
    private View f45372g;

    /* renamed from: h */
    private View f45373h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f45374i = true;

    /* renamed from: j */
    private int f45375j = 1;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<AbsFilterModule.MoudleAppearListener> f45376k = new ArrayList();

    /* renamed from: l */
    private List<AbsFilterModule.MoudleAppearListener> f45377l = new ArrayList();

    public FilterMultiplePanel(Context context) {
        super(context);
    }

    public View createRootView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_home_filter_mul_panel, (ViewGroup) null);
        this.f45366a = (LinearLayout) inflate.findViewById(R.id.customer_ll_filter_mul_panel_container);
        this.f45367b = (HasListenerScollView) inflate.findViewById(R.id.customer_ll_filter_mul_panel_scroll);
        this.f45371f = (ConstraintLayout) inflate.findViewById(R.id.customer_ll_filter_mul_panel_bottom);
        this.f45369d = (CustomerAppCompatTextView) inflate.findViewById(R.id.customer_tv_home_filter_reset);
        this.f45370e = (CustomerAppCompatTextView) inflate.findViewById(R.id.customer_tv_home_filter_confirm);
        this.f45372g = inflate.findViewById(R.id.customer_tv_home_filter_marker);
        this.f45373h = inflate.findViewById(R.id.customer_tv_home_single_filter_confirm);
        this.f45369d.setOnClickListener(this);
        this.f45370e.setOnClickListener(this);
        this.f45373h.setOnClickListener(this);
        this.f45370e.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                CustomerSystemUtil.virate(view.getContext());
                return false;
            }
        });
        this.f45367b.setOnScrollChangeListener(new HasListenerScollView.OnScrollChangeListener() {
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                if (FilterMultiplePanel.this.f45374i) {
                    FilterMultiplePanel.this.f45376k.clear();
                    FilterMultiplePanel filterMultiplePanel = FilterMultiplePanel.this;
                    filterMultiplePanel.m33706a((ViewGroup) filterMultiplePanel.f45366a, 1);
                    boolean unused = FilterMultiplePanel.this.f45374i = false;
                }
                FilterMultiplePanel.this.m33704a();
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33706a(ViewGroup viewGroup, int i) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof AbsFilterModule.MoudleAppearListener) {
                this.f45376k.add((AbsFilterModule.MoudleAppearListener) childAt);
            }
            if ((childAt instanceof ViewGroup) && i <= this.f45375j) {
                m33706a((ViewGroup) childAt, i + 1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33704a() {
        if (getFilterModel().mShowType == 4) {
            int[] iArr = new int[2];
            this.f45367b.getLocationOnScreen(iArr);
            int i = iArr[1];
            int height = ((this.f45367b.getHeight() + i) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_68px)) - this.f45367b.getPaddingBottom();
            for (AbsFilterModule.MoudleAppearListener next : this.f45376k) {
                int[] iArr2 = new int[2];
                ((View) next).getLocationOnScreen(iArr2);
                int i2 = iArr2[1];
                if (i2 < i || i2 > height) {
                    this.f45377l.remove(next);
                } else if (!this.f45377l.contains(next)) {
                    next.onMoudleAppear();
                    this.f45377l.add(next);
                }
            }
        }
    }

    public void bindData(FilterModel filterModel) {
        AbsFilterModule absFilterModule;
        super.bindData(filterModel);
        this.f45366a.removeAllViews();
        this.f45368c.clear();
        int size = filterModel.mFilterComponent.size();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= size) {
                break;
            }
            FilterModel.FilterComponentModel filterComponentModel = filterModel.mFilterComponent.get(i);
            if (filterComponentModel != null) {
                if (filterComponentModel.mType == 1) {
                    absFilterModule = new SingleLineWithIconFilterModule(this.f45366a, this.mFromScene);
                } else if (filterComponentModel.mColNum == -1) {
                    absFilterModule = new FlowFilterModule(this.f45366a, this.mFromScene);
                    absFilterModule.setMOnSWFilterItemListener(new Function2<FilterModel.FilterItemRvModel, Boolean, Unit>() {
                        public Unit invoke(FilterModel.FilterItemRvModel filterItemRvModel, Boolean bool) {
                            TopicActOmegaHelper instance = TopicActOmegaHelper.Companion.getInstance();
                            instance.headerFilterTopicCatesItemSW(FilterMultiplePanel.this.mTopicFromScence + "", FilterMultiplePanel.this.mTimePeriod, filterItemRvModel.mId);
                            return null;
                        }
                    });
                } else {
                    absFilterModule = new CommonFilterModule(this.f45366a, this.mFromScene);
                }
                boolean z2 = size < 2;
                if (i != 0) {
                    z = false;
                }
                absFilterModule.bindModuleOnPanel(z2, z, filterComponentModel, new Function2(filterModel) {
                    public final /* synthetic */ FilterModel f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final Object invoke(Object obj, Object obj2) {
                        return FilterMultiplePanel.this.m33703a(this.f$1, (FilterModel.FilterItemRvModel) obj, (Boolean) obj2);
                    }
                });
                this.f45368c.add(absFilterModule);
            }
            i++;
        }
        if (filterModel.mShowType == 4) {
            this.f45371f.setVisibility(0);
            this.f45373h.setVisibility(8);
            this.f45372g.setVisibility(0);
            this.f45367b.setPadding(0, 0, 0, DisplayUtils.dip2px(this.f45366a.getContext(), 58.0f));
            m33705a((ViewGroup) this.f45366a);
        } else if (filterModel.mShowType == 1) {
            this.f45371f.setVisibility(8);
            this.f45373h.setVisibility(8);
            this.f45372g.setVisibility(8);
            this.f45367b.setPadding(0, 0, 0, 0);
        } else if (filterModel.mShowType == 7) {
            this.f45371f.setVisibility(8);
            if (filterModel.showConfirmBtn == 1) {
                this.f45373h.setVisibility(0);
            } else {
                this.f45373h.setVisibility(8);
            }
        } else {
            this.f45371f.setVisibility(8);
            this.f45373h.setVisibility(0);
            this.f45372g.setVisibility(8);
            this.f45367b.setPadding(0, 0, 0, 0);
        }
        m33708a(filterModel);
        this.f45367b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                FilterMultiplePanel filterMultiplePanel = FilterMultiplePanel.this;
                filterMultiplePanel.m33706a((ViewGroup) filterMultiplePanel.f45366a, 1);
                FilterMultiplePanel.this.m33704a();
                FilterMultiplePanel.this.f45367b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Unit m33703a(FilterModel filterModel, FilterModel.FilterItemRvModel filterItemRvModel, Boolean bool) {
        boolean z = false;
        if (filterModel.mShowType == 4 || (filterModel.mShowType == 7 && filterModel.showConfirmBtn == 1)) {
            z = true;
        }
        if (z) {
            m33712b();
        } else {
            m33715d();
        }
        TopicActOmegaHelper instance = TopicActOmegaHelper.Companion.getInstance();
        instance.headerFilterTopicCatesItemCK(this.mTopicFromScence + "", this.mTimePeriod, filterItemRvModel.mId);
        return Unit.INSTANCE;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.customer_tv_home_filter_reset) {
            m33714c();
        } else if (view.getId() == R.id.customer_tv_home_filter_confirm || view.getId() == R.id.customer_tv_home_single_filter_confirm) {
            m33715d();
        }
    }

    /* renamed from: a */
    private void m33705a(ViewGroup viewGroup) {
        viewGroup.addView(new Space(viewGroup.getContext()), new LinearLayout.LayoutParams(0, DisplayUtils.dip2px(viewGroup.getContext(), 21.0f)));
    }

    /* renamed from: a */
    private void m33708a(FilterModel filterModel) {
        if (!filterModel.isOriginal()) {
            this.f45369d.setEnabled(true);
        } else {
            this.f45369d.setEnabled(false);
        }
    }

    /* renamed from: b */
    private void m33712b() {
        boolean z;
        Iterator<AbsFilterModule> it = this.f45368c.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().isOriginal()) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        this.f45369d.setEnabled(!z);
    }

    /* renamed from: c */
    private void m33714c() {
        for (AbsFilterModule resetFilterModule : this.f45368c) {
            resetFilterModule.resetFilterModule();
        }
        if (!getFilterModel().isOriginal()) {
            getFilterModel().reset();
        }
        doConfirm(true, true);
        HomeOmegaHelper.getInstance().trackMulFilterRest();
    }

    /* renamed from: d */
    private void m33715d() {
        for (AbsFilterModule confirmFilterModule : this.f45368c) {
            confirmFilterModule.confirmFilterModule();
        }
        doConfirm(true, false);
        FilterDataManager instanceByScene = FilterDataManager.Companion.getInstanceByScene(this.mFromScene);
        ArrayList<FilterItemParam> generateGroupOutParams = instanceByScene.generateGroupOutParams(getFilterModel());
        if (getFilterModel().mShowType == 4) {
            HomeOmegaHelper.getInstance().trackFilterMulConfirm(generateGroupOutParams, this.mFromScene, instanceByScene.getMCateId());
        } else if (getFilterModel().mShowType == 1) {
            HomeOmegaHelper.getInstance().trackFilterSortConfirm(generateGroupOutParams, this.mFromScene, instanceByScene.getMCateId());
        } else {
            HomeOmegaHelper.getInstance().traceOutsideConfirmCK(generateGroupOutParams, (getFilterModel().mFilterComponent == null || getFilterModel().mFilterComponent.isEmpty()) ? "" : String.valueOf(getFilterModel().mFilterComponent.get(0).mType), this.mFromScene);
        }
    }
}
