package com.didi.sdk.home.bizbar;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeBizNavExtendBarController {

    /* renamed from: a */
    BizGridItemAdapter f39158a;

    /* renamed from: b */
    BizGridItemAdapter f39159b;

    /* renamed from: c */
    List<TopCarGroupWrapper> f39160c = new ArrayList();

    /* renamed from: d */
    List<TopCarGroupWrapper> f39161d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewGroup f39162e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f39163f;

    /* renamed from: g */
    private View f39164g;

    /* renamed from: h */
    private View f39165h;

    /* renamed from: i */
    private GridView f39166i;

    /* renamed from: j */
    private GridView f39167j;

    /* renamed from: k */
    private View f39168k;

    /* renamed from: l */
    private boolean f39169l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public BizNavItemMgr f39170m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ExtendSelectListener f39171n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f39172o = 4;

    public interface ExtendSelectListener {
        void onSelect(CarGrop carGrop);
    }

    public HomeBizNavExtendBarController(BizNavItemMgr bizNavItemMgr) {
        this.f39170m = bizNavItemMgr;
        this.f39172o = bizNavItemMgr.getMaxColumnNum() - 1;
    }

    public void showExtendBar(Context context, ViewGroup viewGroup) {
        if (!this.f39169l) {
            this.f39162e = viewGroup;
            View inflate = LayoutInflater.from(context).inflate(R.layout.new_ui_biz_extend_bar, viewGroup, false);
            this.f39163f = inflate;
            this.f39164g = inflate.findViewById(R.id.biz_bar_expand_container);
            this.f39165h = this.f39163f.findViewById(R.id.biz_bar_expand_bg);
            m29495a();
            viewGroup.addView(this.f39163f);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.new_ui_bottom_in);
            loadAnimation.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
            this.f39164g.startAnimation(loadAnimation);
            this.f39165h.startAnimation(GlobalUIKitAnimationFactory.getAlphaAnimation(0.0f, 1.0f, GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, false, true, 400, 0, 0, (Animation.AnimationListener) null));
            this.f39170m.updateNavRedPointItemView();
            this.f39169l = true;
        }
    }

    public void hideExtendBar() {
        if (this.f39163f != null && this.f39162e != null && this.f39169l) {
            this.f39165h.startAnimation(GlobalUIKitAnimationFactory.getAlphaAnimation(1.0f, 0.0f, GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, true, false, 400, 0, 0, (Animation.AnimationListener) null));
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f39163f.getContext(), R.anim.new_ui_bottom_out);
            loadAnimation.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    HomeBizNavExtendBarController.this.f39162e.removeView(HomeBizNavExtendBarController.this.f39163f);
                }
            });
            this.f39164g.startAnimation(loadAnimation);
            this.f39169l = false;
        }
    }

    /* renamed from: a */
    private void m29495a() {
        this.f39163f.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                HomeBizNavExtendBarController.this.hideExtendBar();
                return true;
            }
        });
        GridView gridView = (GridView) this.f39163f.findViewById(R.id.biz_bar_expand_more_container);
        this.f39167j = gridView;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (HomeBizNavExtendBarController.this.f39171n != null && HomeBizNavExtendBarController.this.f39170m.getList() != null && HomeBizNavExtendBarController.this.f39170m.getList().size() > HomeBizNavExtendBarController.this.f39172o + i) {
                    TopCarGroupWrapper topCarGroupWrapper = HomeBizNavExtendBarController.this.f39170m.getList().get(i + HomeBizNavExtendBarController.this.f39172o);
                    HomeBizNavExtendBarController.this.f39170m.changeItemToMainBar(topCarGroupWrapper);
                    HomeBizNavExtendBarController.this.hideExtendBar();
                    HomeBizNavExtendBarController.this.f39171n.onSelect(topCarGroupWrapper.carGrop);
                }
            }
        });
        GridView gridView2 = (GridView) this.f39163f.findViewById(R.id.biz_bar_expand_main_container);
        this.f39166i = gridView2;
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (HomeBizNavExtendBarController.this.f39171n != null && HomeBizNavExtendBarController.this.f39170m.getList() != null && HomeBizNavExtendBarController.this.f39170m.getList().size() > i) {
                    HomeBizNavExtendBarController.this.hideExtendBar();
                    TopCarGroupWrapper topCarGroupWrapper = HomeBizNavExtendBarController.this.f39170m.getList().get(i);
                    if (topCarGroupWrapper != null) {
                        if (topCarGroupWrapper.isSelected) {
                            HomeBizNavExtendBarController.this.reportExtendHide("samebusiness");
                        }
                        HomeBizNavExtendBarController.this.f39171n.onSelect(topCarGroupWrapper.carGrop);
                    }
                }
            }
        });
        m29497b();
        this.f39158a = new BizGridItemAdapter();
        this.f39159b = new BizGridItemAdapter();
        this.f39158a.setData(this.f39161d);
        this.f39158a.f39125a = this.f39170m;
        this.f39167j.setAdapter(this.f39158a);
        this.f39159b.setData(this.f39160c);
        this.f39159b.f39125a = this.f39170m;
        this.f39166i.setAdapter(this.f39159b);
        View findViewById = this.f39163f.findViewById(R.id.biz_bar_expand_blank);
        this.f39168k = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HomeBizNavExtendBarController.this.hideExtendBar();
                HomeBizNavExtendBarController.this.reportExtendHide(InvitationPageActivity.BLANK);
            }
        });
    }

    public void setSelectListener(ExtendSelectListener extendSelectListener) {
        this.f39171n = extendSelectListener;
    }

    /* renamed from: b */
    private void m29497b() {
        this.f39160c.clear();
        this.f39161d.clear();
        for (int i = 0; i < this.f39170m.getList().size(); i++) {
            if (i < this.f39172o) {
                this.f39160c.add(this.f39170m.getList().get(i));
            } else {
                this.f39161d.add(this.f39170m.getList().get(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void reportExtendHide(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        OmegaSDKAdapter.trackEvent("ibt_gp_changebusiness_more_close_ck", (Map<String, Object>) hashMap);
    }
}
