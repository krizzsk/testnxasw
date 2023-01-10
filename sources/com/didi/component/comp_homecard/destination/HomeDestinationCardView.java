package com.didi.component.comp_homecard.destination;

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
import com.didi.component.comp_homecard.destination.HomeDestinationRecAdapter;
import com.didi.component.comp_homecard.destination.IHomeDestinationCardView;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;
import java.util.List;

public class HomeDestinationCardView implements View.OnClickListener, View.OnTouchListener, IHomeDestinationCardView {

    /* renamed from: a */
    private Context f14082a;

    /* renamed from: b */
    private View f14083b;

    /* renamed from: c */
    private LinearLayout f14084c;

    /* renamed from: d */
    private RecyclerView f14085d;

    /* renamed from: e */
    private FrameLayout f14086e;

    /* renamed from: f */
    private boolean f14087f = false;

    /* renamed from: g */
    private HomeDestinationRecAdapter f14088g;

    /* renamed from: h */
    private HomeDestinationRecAdapter.OnItemClickListener f14089h;

    /* renamed from: i */
    private IHomeDestinationCardView.IClickCallBack f14090i;

    /* renamed from: j */
    private AbsHomeDestinationCardPresenter f14091j;

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public HomeDestinationCardView(BusinessContext businessContext, ViewGroup viewGroup) {
        this.f14082a = businessContext.getContext();
        m11682a();
    }

    /* renamed from: a */
    private void m11682a() {
        View inflate = LayoutInflater.from(this.f14082a).inflate(R.layout.global_home_card_view_layout, (ViewGroup) null);
        this.f14083b = inflate;
        this.f14084c = (LinearLayout) inflate.findViewById(R.id.oc_home_destination_where_to_ll_b);
        this.f14086e = (FrameLayout) this.f14083b.findViewById(R.id.discount_assistant_layout);
        this.f14084c.setOnClickListener(this);
        if (!AppUtils.isBrazilApp(this.f14082a)) {
            ((ImageView) this.f14083b.findViewById(R.id.oc_home_where_to_dot_b)).setImageResource(R.drawable.global_home_dot_destination);
        }
    }

    /* renamed from: b */
    private void m11683b() {
        RecyclerView recyclerView = (RecyclerView) this.f14083b.findViewById(R.id.oc_home_destination_recommend_rec_b);
        this.f14085d = recyclerView;
        recyclerView.setVisibility(8);
        this.f14088g = new HomeDestinationRecAdapter();
        this.f14085d.setLayoutManager(new LinearLayoutManager(this.f14082a, 1, false));
        this.f14085d.setAdapter(this.f14088g);
        HomeDestinationRecAdapter.OnItemClickListener onItemClickListener = this.f14089h;
        if (onItemClickListener != null) {
            this.f14088g.setOnItemClickListener(onItemClickListener);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        IHomeDestinationCardView.IClickCallBack iClickCallBack = this.f14090i;
        if (iClickCallBack != null) {
            iClickCallBack.clickWhereToGo();
        }
    }

    public void setRecData(List<HomeCardModel> list) {
        if (this.f14085d == null) {
            m11683b();
        }
        this.f14088g.setDataList(list);
        this.f14088g.notifyDataSetChanged();
    }

    public void showRecList() {
        RecyclerView recyclerView = this.f14085d;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    public void hideRecList() {
        RecyclerView recyclerView = this.f14085d;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    public void clearRecData() {
        HomeDestinationRecAdapter homeDestinationRecAdapter = this.f14088g;
        if (homeDestinationRecAdapter != null) {
            homeDestinationRecAdapter.cleanTheData();
            this.f14088g.notifyDataSetChanged();
        }
    }

    public boolean isRecListShown() {
        RecyclerView recyclerView = this.f14085d;
        return recyclerView != null && recyclerView.getVisibility() == 0 && this.f14085d.getWidth() > 0;
    }

    public void setClickListener(IHomeDestinationCardView.IClickCallBack iClickCallBack) {
        this.f14090i = iClickCallBack;
    }

    public void setGuessItemClickListener(HomeDestinationRecAdapter.OnItemClickListener onItemClickListener) {
        HomeDestinationRecAdapter homeDestinationRecAdapter = this.f14088g;
        if (homeDestinationRecAdapter != null) {
            homeDestinationRecAdapter.setOnItemClickListener(onItemClickListener);
        } else {
            this.f14089h = onItemClickListener;
        }
    }

    public void setVisibility(int i, Runnable runnable) {
        if (i == 0) {
            this.f14083b.setVisibility(0);
        } else {
            this.f14083b.setVisibility(4);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void showCouponAssistant(View view) {
        if (view != null) {
            this.f14086e.removeAllViews();
            this.f14086e.setVisibility(0);
            this.f14086e.addView(view);
            this.f14087f = true;
        }
    }

    public void hideCouponAssistant() {
        if (this.f14087f) {
            this.f14087f = false;
            this.f14086e.setVisibility(8);
        }
    }

    public View getView() {
        return this.f14083b;
    }

    public void setPresenter(AbsHomeDestinationCardPresenter absHomeDestinationCardPresenter) {
        this.f14091j = absHomeDestinationCardPresenter;
        setClickListener(absHomeDestinationCardPresenter);
    }
}
