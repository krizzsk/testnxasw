package com.didi.component.comp_selectseat.seatselect;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.activity.SeatSelectActivity;
import com.didi.component.comp_selectseat.adapter.LoadingTimeOutListener;
import com.didi.component.comp_selectseat.adapter.SeatSelectItemClickListener;
import com.didi.component.comp_selectseat.adapter.SeatsSelectedAdapter;
import com.didi.component.comp_selectseat.model.SeatOptionsModel;
import com.didi.component.core.PresenterGroup;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatSelectFragment extends AbsNormalFragment implements ISeatSelectView {

    /* renamed from: b */
    private static final String f14250b = "SeatSelectFragment";

    /* renamed from: A */
    private final LoadingTimeOutListener f14251A = new LoadingTimeOutListener() {
        public void showLoadingTimeoutView() {
            SeatSelectFragment.this.showOrHideLoadingTimeoutView(0);
        }
    };

    /* renamed from: a */
    float f14252a;

    /* renamed from: c */
    private String f14253c;

    /* renamed from: d */
    private View f14254d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f14255e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SeatSelectTopPresenter f14256f;

    /* renamed from: g */
    private TextView f14257g;

    /* renamed from: h */
    private TextView f14258h;

    /* renamed from: i */
    private RecyclerView f14259i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SeatsSelectedAdapter f14260j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SeatSelectActivity f14261k;

    /* renamed from: l */
    private Button f14262l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Button f14263m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LinearLayout f14264n;

    /* renamed from: o */
    private RelativeLayout f14265o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f14266p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f14267q;

    /* renamed from: r */
    private ImageView f14268r;

    /* renamed from: s */
    private boolean f14269s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f14270t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f14271u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ObjectAnimator f14272v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public JsonObject f14273w;

    /* renamed from: x */
    private JsonObject f14274x;

    /* renamed from: y */
    private final RecyclerView.OnScrollListener f14275y = new RecyclerView.OnScrollListener() {
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            SeatSelectFragment.m11821a(SeatSelectFragment.this, (float) i2);
            if (SeatSelectFragment.this.f14255e != null) {
                if (SeatSelectFragment.this.f14272v != null && SeatSelectFragment.this.f14272v.isRunning()) {
                    SeatSelectFragment.this.f14272v.cancel();
                }
                SeatSelectFragment.this.f14255e.setTranslationY(SeatSelectFragment.this.f14270t);
            }
        }
    };

    /* renamed from: z */
    private final SeatSelectItemClickListener f14276z = new SeatSelectItemClickListener() {
        public void seatSelectListener(int i, int i2, JsonObject jsonObject, float f) {
            if (SeatSelectFragment.this.f14256f != null) {
                int unused = SeatSelectFragment.this.f14266p = i;
                int unused2 = SeatSelectFragment.this.f14267q = i2;
                float unused3 = SeatSelectFragment.this.f14271u = f;
                JsonObject unused4 = SeatSelectFragment.this.f14273w = jsonObject;
                SeatSelectFragment.this.f14256f.onItemClick(i, i2);
                SeatSelectFragment seatSelectFragment = SeatSelectFragment.this;
                seatSelectFragment.slideItemBg(seatSelectFragment.f14270t, SeatSelectFragment.this.f14271u);
                SeatSelectFragment.this.f14263m.setEnabled(false);
            }
        }
    };

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 0;
    }

    /* renamed from: a */
    static /* synthetic */ float m11821a(SeatSelectFragment seatSelectFragment, float f) {
        float f2 = seatSelectFragment.f14270t - f;
        seatSelectFragment.f14270t = f2;
        return f2;
    }

    public static SeatSelectFragment newInstance(String str) {
        SeatSelectFragment seatSelectFragment = new SeatSelectFragment();
        Bundle bundle = new Bundle();
        bundle.putString("uniqueId", str);
        seatSelectFragment.setArguments(bundle);
        return seatSelectFragment;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14254d = layoutInflater.inflate(R.layout.seat_select_layout, viewGroup, false);
        m11825a();
        m11832c();
        return this.f14254d;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f14261k = (SeatSelectActivity) context;
    }

    public void onDetach() {
        super.onDetach();
        GLog.m11357e(f14250b, "onDetach");
    }

    public void onDestroy() {
        super.onDestroy();
        GLog.m11357e(f14250b, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }

    /* renamed from: a */
    private void m11825a() {
        Button button = (Button) this.f14254d.findViewById(R.id.btn_next);
        this.f14263m = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (!Utils.isFastDoubleClick()) {
                    SeatSelectFragment.this.f14261k.toNext(SeatSelectFragment.this.f14273w);
                    SeatSelectFragment.this.m11831b();
                }
            }
        });
        ImageView imageView = (ImageView) this.f14254d.findViewById(R.id.btn_back);
        this.f14268r = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SeatSelectFragment.this.m11827a("ibt_gp_minibus_seats_return_ck", "click", "return");
                SeatSelectFragment.this.f14261k.onBackPressed();
            }
        });
        this.f14257g = (TextView) this.f14254d.findViewById(R.id.tv_mainTitle);
        this.f14258h = (TextView) this.f14254d.findViewById(R.id.tv_subTitle);
        View findViewById = this.f14254d.findViewById(R.id.v_slideBg);
        this.f14255e = findViewById;
        findViewById.post(new Runnable() {
            public void run() {
                GLog.m11361v(SeatSelectFragment.f14250b, "run: " + SeatSelectFragment.this.f14255e.getY());
                SeatSelectFragment seatSelectFragment = SeatSelectFragment.this;
                seatSelectFragment.f14252a = seatSelectFragment.f14255e.getY();
            }
        });
        this.f14260j = new SeatsSelectedAdapter(this.f14261k, this.f14276z, this.f14251A);
        RecyclerView recyclerView = (RecyclerView) this.f14254d.findViewById(R.id.rv_select_seat);
        this.f14259i = recyclerView;
        recyclerView.setOnScrollListener(this.f14275y);
        this.f14259i.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f14259i.setAdapter(this.f14260j);
        this.f14265o = (RelativeLayout) this.f14254d.findViewById(R.id.rl_seat_select_content);
        this.f14264n = (LinearLayout) this.f14254d.findViewById(R.id.ll_net_error);
        Button button2 = (Button) this.f14254d.findViewById(R.id.btn_retry);
        this.f14262l = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SeatSelectFragment.this.f14264n.setVisibility(8);
                SeatSelectFragment.this.f14256f.singleCompRefresh(SeatSelectFragment.this.f14267q);
            }
        });
        ((ImageView) this.f14254d.findViewById(R.id.btn_loading_error_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SeatSelectFragment.this.f14261k.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11831b() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, GPageIdConstant.G_PAGE_ID_CONF);
        hashMap.put(RavenKey.VERSION, "next");
        this.f14256f.trackEventEstimateId(hashMap, "nextClickTrackEvent");
        if (this.f14274x != null) {
            try {
                HashMap hashMap2 = (HashMap) new Gson().fromJson((JsonElement) this.f14274x, new TypeToken<HashMap<String, Object>>() {
                }.getType());
                if (!CollectionUtils.isEmpty((Map) hashMap2)) {
                    hashMap.putAll(hashMap2);
                }
            } catch (JsonSyntaxException e) {
                GLog.m11357e(f14250b, "cardClickUseTrackEvent " + e.toString());
            }
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_minibus_seats_next_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11827a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", str2);
        hashMap.put(RavenKey.VERSION, str3);
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }

    public void slideItemBg(float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f14255e, "translationY", new float[]{f, f2});
        this.f14272v = ofFloat;
        ofFloat.setDuration(500);
        if (!this.f14272v.isRunning()) {
            this.f14272v.start();
            this.f14270t = this.f14271u;
            this.f14272v.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (SeatSelectFragment.this.f14260j != null) {
                        SeatSelectFragment.this.f14260j.showLoadingStatus();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        SeatSelectTopPresenter seatSelectTopPresenter = new SeatSelectTopPresenter(getContext(), getArguments());
        this.f14256f = seatSelectTopPresenter;
        return seatSelectTopPresenter;
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        GLog.m11357e(f14250b, "onDestroyViewImpl");
        ObjectAnimator objectAnimator = this.f14272v;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.f14254d = null;
        this.f14256f = null;
    }

    public void setSeatsData(List<SeatOptionsModel> list) {
        showOrHideLoadingTimeoutView(8);
        SeatOptionsModel seatOptionsModel = list.get(this.f14266p);
        if (seatOptionsModel != null) {
            this.f14273w = seatOptionsModel.paramsModel;
            if (seatOptionsModel.mExtension != null) {
                this.f14274x = seatOptionsModel.mExtension.mLogData;
            }
        }
        if (this.f14269s) {
            this.f14260j.setDate(list, true);
            this.f14269s = false;
        } else {
            this.f14260j.setDate(list, false);
        }
        this.f14263m.setEnabled(true);
    }

    public View getView() {
        return this.f14254d;
    }

    public void setMainTitle(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f14257g.setText(str);
        }
    }

    public void setSubTitle(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f14258h.setText(str);
        }
    }

    /* renamed from: c */
    private void m11832c() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("uniqueId");
            this.f14253c = string;
            if (!TextUtils.isEmpty(string)) {
                this.f14256f.setmUniqueId(this.f14253c);
            }
            this.f14256f.setSeatData(FormStore.getInstance().getSelectedSeat(), true);
            return;
        }
        GLog.m11357e(f14250b, "setData() >> bundle is null");
        showOrHideLoadingTimeoutView(0);
    }

    public void showOrHideLoadingTimeoutView(int i) {
        if (i == 0) {
            this.f14268r.setVisibility(8);
            this.f14257g.setVisibility(8);
            this.f14258h.setVisibility(8);
            this.f14265o.setVisibility(8);
            this.f14263m.setVisibility(8);
        } else {
            this.f14268r.setVisibility(0);
            this.f14257g.setVisibility(0);
            this.f14258h.setVisibility(0);
            this.f14265o.setVisibility(0);
            this.f14263m.setVisibility(0);
        }
        this.f14264n.setVisibility(i);
    }

    public void resetSlideBgView() {
        this.f14255e.setY(this.f14252a);
        this.f14270t = 0.0f;
        this.f14271u = 0.0f;
        this.f14266p = 0;
        this.f14267q = 0;
        this.f14269s = true;
    }

    public void onBackPress() {
        SeatSelectActivity seatSelectActivity = this.f14261k;
        if (seatSelectActivity != null) {
            seatSelectActivity.finish();
        }
    }
}
