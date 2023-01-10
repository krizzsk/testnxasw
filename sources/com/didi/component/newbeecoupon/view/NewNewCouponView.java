package com.didi.component.newbeecoupon.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.model.HomeNewCouponModel;
import com.didi.component.newbeecoupon.presenter.AbsNewbeeCouponPresenter;
import com.didi.sdk.util.GlobalViewUtils;
import com.didi.sdk.view.LazyInflateView;
import com.taxis99.R;

public class NewNewCouponView extends LazyInflateView implements View.OnClickListener, INewbeeCouponView {

    /* renamed from: a */
    private Context f16533a;

    /* renamed from: b */
    private View f16534b;

    /* renamed from: c */
    private View f16535c;

    /* renamed from: d */
    private RecyclerView f16536d;

    /* renamed from: e */
    private TextView f16537e;

    /* renamed from: f */
    private View f16538f;

    /* renamed from: g */
    private AbsNewbeeCouponPresenter f16539g;

    /* renamed from: h */
    private NewMaskCouponAdapter f16540h;

    /* renamed from: i */
    private PopupWindow f16541i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f16542j;

    /* renamed from: k */
    private View f16543k;

    public NewNewCouponView(Context context) {
        super(context, (ViewGroup) null, R.layout.global_new_coupon_root);
        this.f16533a = context;
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        this.f16543k = view;
        view.setVisibility(8);
        this.f16534b = LayoutInflater.from(this.f16533a).inflate(R.layout.global_new_user_coupon, (ViewGroup) null);
        this.f16541i = new PopupWindow(this.f16534b, -1, -1);
        this.f16535c = this.f16534b.findViewById(R.id.g_new_coupon_dialog_ll);
        m13878b();
        RecyclerView recyclerView = (RecyclerView) this.f16534b.findViewById(R.id.g_new_coupon_rv);
        this.f16536d = recyclerView;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i2 != 0 && !NewNewCouponView.this.f16542j) {
                    GlobalOmegaUtils.trackEvent("gp_home_popups_sp");
                    boolean unused = NewNewCouponView.this.f16542j = true;
                }
            }
        });
        this.f16537e = (TextView) this.f16534b.findViewById(R.id.g_new_coupon_dialog_btn);
        m13875a();
        this.f16537e.setOnClickListener(this);
        View findViewById = this.f16534b.findViewById(R.id.g_new_coupon_bottom);
        this.f16538f = findViewById;
        findViewById.setOnClickListener(this);
        this.f16536d.setLayoutManager(new LinearLayoutManager(this.f16533a, 1, false));
        RecyclerView recyclerView2 = this.f16536d;
        NewMaskCouponAdapter newMaskCouponAdapter = new NewMaskCouponAdapter();
        this.f16540h = newMaskCouponAdapter;
        recyclerView2.setAdapter(newMaskCouponAdapter);
    }

    /* renamed from: a */
    private void m13875a() {
        int dipToPx = GlobalViewUtils.dipToPx(this.f16533a, 18);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) dipToPx);
        gradientDrawable.setColor(Color.parseColor("#80ffffff"));
        gradientDrawable.setStroke(UiUtils.dip2px(this.f16533a, 0.5f), Color.parseColor("#FFFFFFFF"));
        this.f16537e.setBackground(gradientDrawable);
        this.f16537e.setTextColor(Color.parseColor("#ffffff"));
    }

    /* renamed from: b */
    private void m13878b() {
        int dipToPx = GlobalViewUtils.dipToPx(this.f16533a, 10);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#fff362"), Color.parseColor("#fd9728")});
        gradientDrawable.setCornerRadius((float) dipToPx);
        this.f16535c.setBackground(gradientDrawable);
    }

    public View getView() {
        return getRealView();
    }

    public void setPresenter(AbsNewbeeCouponPresenter absNewbeeCouponPresenter) {
        this.f16539g = absNewbeeCouponPresenter;
    }

    public void show() {
        super.inflate();
        View view = this.f16543k;
        if (view != null) {
            view.setVisibility(0);
            this.f16541i.showAtLocation(this.f16543k, 17, 0, 0);
        }
    }

    public void dismiss() {
        View view = this.f16543k;
        if (view != null) {
            view.setVisibility(8);
            this.f16541i.dismiss();
        }
    }

    public void setListData(HomeNewCouponModel homeNewCouponModel) {
        NewMaskCouponAdapter newMaskCouponAdapter = this.f16540h;
        if (newMaskCouponAdapter != null) {
            newMaskCouponAdapter.setData(homeNewCouponModel);
            this.f16540h.notifyDataSetChanged();
        }
    }

    public void setButtonText(String str) {
        TextView textView;
        if (!TextUtils.isEmpty(str) && (textView = this.f16537e) != null) {
            textView.setText(str);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.g_new_coupon_dialog_btn) {
            GlobalOmegaUtils.trackEvent("gp_home_popups_ck");
            this.f16539g.onOpenSugClick();
        } else if (view.getId() == R.id.g_new_coupon_bottom) {
            this.f16539g.onMaskClicked();
        }
    }
}
