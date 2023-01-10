package com.didi.component.homedestination.newversion.p104b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.common.model.HomeCouponPerception;
import com.didi.component.homedestination.newversion.HomeDestinationNewRecAdapter;
import com.didi.component.homedestination.newversion.p104b.IHomeDestinationPlantBNewView;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.component.homedestination.newversion.b.HomeDestinationNewPlanBView */
public class HomeDestinationNewPlanBView implements View.OnClickListener, View.OnTouchListener, IHomeDestinationPlantBNewView<HomeDestinationNewPlanBPresenter> {

    /* renamed from: a */
    private BusinessContext f15955a;

    /* renamed from: b */
    private Context f15956b;

    /* renamed from: c */
    private ViewGroup f15957c;

    /* renamed from: d */
    private View f15958d;

    /* renamed from: e */
    private LinearLayout f15959e;

    /* renamed from: f */
    private RecyclerView f15960f;

    /* renamed from: g */
    private FrameLayout f15961g;

    /* renamed from: h */
    private boolean f15962h = false;

    /* renamed from: i */
    private HomeDestinationNewRecAdapter f15963i;

    /* renamed from: j */
    private HomeDestinationNewRecAdapter.OnItemClickListener f15964j;

    /* renamed from: k */
    private IHomeDestinationPlantBNewView.IClickCallBack f15965k;

    /* renamed from: l */
    private HomeDestinationNewPlanBPresenter f15966l;

    public void hideCouponPerception() {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void showCouponPerception(HomeCouponPerception homeCouponPerception) {
    }

    public HomeDestinationNewPlanBView(BusinessContext businessContext, ViewGroup viewGroup) {
        this.f15955a = businessContext;
        this.f15956b = businessContext.getContext();
        this.f15957c = viewGroup;
        m13257a();
    }

    /* renamed from: a */
    private void m13257a() {
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(R.layout.global_home_destination_view_layout_new_ui_plan_b);
        if (viewByResId == null) {
            viewByResId = LayoutInflater.from(this.f15956b).inflate(R.layout.global_home_destination_view_layout_new_ui_plan_b, (ViewGroup) null);
        }
        this.f15958d = viewByResId;
        this.f15959e = (LinearLayout) viewByResId.findViewById(R.id.oc_home_destination_where_to_ll_b);
        this.f15961g = (FrameLayout) this.f15958d.findViewById(R.id.discount_assistant_layout);
        this.f15959e.setOnClickListener(this);
        if (!AppUtils.isBrazilApp(this.f15956b)) {
            ((ImageView) this.f15958d.findViewById(R.id.oc_home_where_to_dot_b)).setImageResource(R.drawable.global_home_dot_destination);
        }
    }

    /* renamed from: b */
    private void m13258b() {
        RecyclerView recyclerView = (RecyclerView) this.f15958d.findViewById(R.id.oc_home_destination_recommend_rec_b);
        this.f15960f = recyclerView;
        recyclerView.setVisibility(8);
        this.f15963i = new HomeDestinationNewRecAdapter();
        this.f15960f.setLayoutManager(new LinearLayoutManager(this.f15956b, 1, false));
        this.f15960f.setAdapter(this.f15963i);
        HomeDestinationNewRecAdapter.OnItemClickListener onItemClickListener = this.f15964j;
        if (onItemClickListener != null) {
            this.f15963i.setOnItemClickListener(onItemClickListener);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        IHomeDestinationPlantBNewView.IClickCallBack iClickCallBack = this.f15965k;
        if (iClickCallBack != null) {
            iClickCallBack.clickWhereToGo();
        }
    }

    public void setRecData(List<HomeCardModel> list) {
        if (this.f15960f == null) {
            m13258b();
        }
        this.f15963i.setDataList(list);
        this.f15963i.notifyDataSetChanged();
    }

    public void showRecList() {
        RecyclerView recyclerView = this.f15960f;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    public void hideRecList() {
        RecyclerView recyclerView = this.f15960f;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    public void clearRecData() {
        HomeDestinationNewRecAdapter homeDestinationNewRecAdapter = this.f15963i;
        if (homeDestinationNewRecAdapter != null) {
            homeDestinationNewRecAdapter.cleanTheData();
            this.f15963i.notifyDataSetChanged();
        }
    }

    public boolean isRecListShown() {
        RecyclerView recyclerView = this.f15960f;
        return recyclerView != null && recyclerView.getVisibility() == 0 && this.f15960f.getWidth() > 0;
    }

    public void setClickListener(IHomeDestinationPlantBNewView.IClickCallBack iClickCallBack) {
        this.f15965k = iClickCallBack;
    }

    public void setGuessItemClickListener(HomeDestinationNewRecAdapter.OnItemClickListener onItemClickListener) {
        HomeDestinationNewRecAdapter homeDestinationNewRecAdapter = this.f15963i;
        if (homeDestinationNewRecAdapter != null) {
            homeDestinationNewRecAdapter.setOnItemClickListener(onItemClickListener);
        } else {
            this.f15964j = onItemClickListener;
        }
    }

    public void setVisibility(int i) {
        setVisibility(i, (Runnable) null);
    }

    public void setVisibility(int i, Runnable runnable) {
        if (i == 0) {
            this.f15958d.setVisibility(0);
        } else {
            this.f15958d.setVisibility(4);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean isVisibility() {
        return this.f15958d.getVisibility() == 0;
    }

    public void showCouponAssistant(View view) {
        if (view != null) {
            this.f15961g.removeAllViews();
            this.f15961g.setVisibility(0);
            this.f15961g.addView(view);
            this.f15962h = true;
        }
    }

    public void hideCouponAssistant() {
        if (this.f15962h) {
            this.f15962h = false;
            this.f15961g.setVisibility(8);
        }
    }

    public View getView() {
        return this.f15958d;
    }

    public void setPresenter(HomeDestinationNewPlanBPresenter homeDestinationNewPlanBPresenter) {
        this.f15966l = homeDestinationNewPlanBPresenter;
        setClickListener(homeDestinationNewPlanBPresenter);
    }
}
