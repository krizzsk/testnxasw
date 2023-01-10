package com.didi.lockscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xengine.request.XESimpleReqParams;
import com.didi.component.common.base.ComponentType;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.framework.template.common.CommonTemplateFragment;
import com.didi.lockscreen.utils.LockScreenOmegaUtil;
import com.didi.lockscreen.view.LockScreenClock;
import com.didi.sdk.util.LockScreenUtilKt;
import com.taxis99.R;
import java.util.HashMap;

public class LockScreenFragment extends CommonTemplateFragment {
    public static final String MARGIN_TOP = "margin_top";

    /* renamed from: a */
    private ViewGroup f26639a;

    /* renamed from: b */
    private View f26640b;

    /* renamed from: c */
    private View f26641c;

    /* renamed from: d */
    private LockScreenClock f26642d;

    /* renamed from: e */
    private CheckBox f26643e;

    /* renamed from: f */
    private ImageView f26644f;

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<Integer> f26645g = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            LockScreenOmegaUtil.sendLockScreenShow(num.intValue());
        }
    };

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1045;
    }

    public int getRootLayout() {
        return R.layout.global_fragment_lock_screen;
    }

    public static LockScreenFragment getInstance(int i) {
        LockScreenFragment lockScreenFragment = new LockScreenFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MARGIN_TOP, i);
        lockScreenFragment.setArguments(bundle);
        return lockScreenFragment;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.LockScreen.EVENT_LOCK_SCREEN_RIDE_STATUS_SHOW, this.f26645g);
        return super.onCreateViewImpl(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyViewImpl() {
        this.f26642d.stop();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.LockScreen.EVENT_LOCK_SCREEN_RIDE_STATUS_SHOW, this.f26645g);
        super.onDestroyViewImpl();
    }

    public void initViews() {
        this.f26639a = (ViewGroup) this.mRootView.findViewById(R.id.ll_global_lockscreen_container);
        this.f26642d = (LockScreenClock) this.mRootView.findViewById(R.id.lock_screen_clock);
        this.f26641c = this.mRootView.findViewById(R.id.ll_global_lockscreen_bottom_container);
        this.f26643e = (CheckBox) this.mRootView.findViewById(R.id.cb_lock_screen_info);
        this.f26644f = (ImageView) this.mRootView.findViewById(R.id.iv_lock_screen_bottom_close);
        View findViewById = this.mRootView.findViewById(R.id.rfl_global_lockscreen_placeholder_container);
        this.f26640b = findViewById;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        marginLayoutParams.topMargin = getArguments().getInt(MARGIN_TOP, 0);
        this.f26640b.setLayoutParams(marginLayoutParams);
        this.f26644f.setOnClickListener(this);
        this.f26641c.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        super.onClick(view);
        if (view.equals(this.f26644f)) {
            if (this.f26643e.isChecked() && CarOrderHelper.getOrder() != null) {
                LockScreenUtilKt.setLockScreenNotShow(getContext(), CarOrderHelper.getOrder().oid);
            }
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.LockScreen.EVENT_ACTIVITY_CLOSE);
            LockScreenOmegaUtil.sendLockScreenCloseClick(this.f26643e.isChecked());
        } else if (view.equals(this.f26641c)) {
            CheckBox checkBox = this.f26643e;
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    /* access modifiers changed from: protected */
    public void onStartImpl() {
        super.onStartImpl();
        m21137a(XERequestKey.REQUEST_KEY_XPANEL, XERequestKey.SCENE_TRIP);
        this.f26642d.start();
    }

    /* renamed from: a */
    private void m21137a(String str, String str2) {
        XESimpleReqParams xESimpleReqParams = new XESimpleReqParams();
        xESimpleReqParams.requestKey = str;
        xESimpleReqParams.scene = str2;
        xESimpleReqParams.bizParams = new HashMap();
        xESimpleReqParams.bizParams.put("oid", CarOrderHelper.getOrder() != null ? CarOrderHelper.getOrder().oid : "");
        XEngineReq.simpleRequest(xESimpleReqParams);
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        this.mRootView.postDelayed(new Runnable() {
            public void run() {
                if (LockScreenFragment.this.getBusinessContext() != null) {
                    LockScreenFragment.this.inflateViewlessComponent("map_flow", (Bundle) null);
                }
            }
        }, 1000);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (getBusinessContext() != null) {
            inflateComponent(ComponentType.RIDE_STATUS, this.f26639a, layoutParams);
            inflateComponent(ComponentType.DRIVER_BAR, this.f26639a, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public LockScreenTemplatePresenter onCreateTopPresenter() {
        return new LockScreenTemplatePresenter(getContext(), getArguments());
    }
}
