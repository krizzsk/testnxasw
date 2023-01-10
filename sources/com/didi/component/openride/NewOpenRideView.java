package com.didi.component.openride;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.OpenRideVisibilityEvent;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.view.LazyInflateView;
import com.taxis99.R;

public class NewOpenRideView extends LazyInflateView implements View.OnClickListener, INewOpenRideView {

    /* renamed from: a */
    private View f16559a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f16560b;

    /* renamed from: c */
    private ImageView f16561c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbsNewOpenRidePresenter f16562d;

    /* renamed from: e */
    private int f16563e = 0;

    /* renamed from: f */
    private BusinessContext f16564f;

    /* renamed from: g */
    private LEGOBubble f16565g;

    public NewOpenRideView(Context context, ViewGroup viewGroup, BusinessContext businessContext) {
        super(context, new FrameLayout(context), R.layout.new_global_open_ride_entrance);
        this.f16564f = businessContext;
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        this.f16559a = view;
        this.f16561c = (ImageView) view.findViewById(R.id.open_ride_entrance);
        this.f16560b = (ViewGroup) this.f16559a.findViewById(R.id.open_ride_bubble_container);
        this.f16561c.setOnClickListener(this);
        int i = this.f16563e;
        if (i <= 0) {
            this.f16559a.setTranslationY((float) i);
        }
        m13917b();
    }

    public void setPresenter(AbsNewOpenRidePresenter absNewOpenRidePresenter) {
        this.f16562d = absNewOpenRidePresenter;
    }

    public View getView() {
        return getRealView();
    }

    public boolean isShowTips() {
        return GlobalSPUtil.getClickedOpenRideTipCloseTimes(this.mContext) < 3 && !m13915a();
    }

    public void onClick(View view) {
        AbsNewOpenRidePresenter absNewOpenRidePresenter;
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f16561c && (absNewOpenRidePresenter = this.f16562d) != null) {
            absNewOpenRidePresenter.onOpenRideEntranceClick();
        }
    }

    /* renamed from: a */
    private boolean m13915a() {
        return TextUtils.isEmpty(FormStore.getInstance().getOpenRideBrand());
    }

    /* renamed from: b */
    private void m13917b() {
        if (!m13915a()) {
            LEGOBubble createBubble = LEGOUICreator.createBubble(this.f16559a.getContext(), String.format(getContext().getResources().getString(R.string.global_home_open_ride_tips), new Object[]{FormStore.getInstance().getOpenRideBrand()}), Color.parseColor("#5C6166"), "right", 3, true, new BubbleCloseListener() {
                public void onClick(LEGOBubble lEGOBubble) {
                    NewOpenRideView.this.f16560b.setVisibility(4);
                    GlobalOmegaUtils.trackEvent("ibt_gp_home_guidenewlearn_close_ck");
                    int clickedOpenRideTipCloseTimes = GlobalSPUtil.getClickedOpenRideTipCloseTimes(NewOpenRideView.this.mContext);
                    if (clickedOpenRideTipCloseTimes < 3) {
                        GlobalSPUtil.setClickedOpenRideTipCloseTimes(NewOpenRideView.this.mContext, clickedOpenRideTipCloseTimes + 1);
                    }
                }
            });
            this.f16565g = createBubble;
            if (createBubble.getView() != null) {
                this.f16560b.removeAllViews();
                this.f16560b.addView(this.f16565g.getView());
            }
        }
        if (isShowTips()) {
            this.f16560b.setVisibility(0);
        } else {
            this.f16560b.setVisibility(4);
        }
    }

    public void setTranslationY(int i) {
        if (i > 0) {
            return;
        }
        if (this.isInflated) {
            getView().setTranslationY((float) i);
        } else {
            this.f16563e = i;
        }
    }

    public void setVisible(final boolean z) {
        if ("ride".equals(ConfProxy.getInstance().getSelectedType())) {
            super.inflate();
            m13917b();
            if (isShowTips()) {
                GlobalOmegaUtils.trackEvent("ibt_gp_home_guidenewlearn_sw");
            }
            this.f16559a.setVisibility(z ? 0 : 4);
            this.f16564f.addViewToRightRegion(this.f16559a);
            this.f16559a.postDelayed(new Runnable() {
                public void run() {
                    int measuredHeight = (int) (((float) NewOpenRideView.this.getView().getMeasuredHeight()) - TypedValue.applyDimension(1, 2.0f, NewOpenRideView.this.getView().getResources().getDisplayMetrics()));
                    if (measuredHeight < 0) {
                        measuredHeight = 0;
                    }
                    if (z) {
                        NewOpenRideView.this.f16562d.doPublish(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_VISIBILITY_CHANGED, new OpenRideVisibilityEvent(measuredHeight, true));
                    } else {
                        NewOpenRideView.this.f16562d.doPublish(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_VISIBILITY_CHANGED, new OpenRideVisibilityEvent(measuredHeight, false));
                    }
                }
            }, 300);
        }
    }

    public boolean isVisible() {
        View view = this.f16559a;
        return view != null && view.getVisibility() == 0;
    }
}
