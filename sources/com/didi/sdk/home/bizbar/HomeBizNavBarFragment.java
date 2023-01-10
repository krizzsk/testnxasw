package com.didi.sdk.home.bizbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.app.IBizNavBarDelegate;
import com.didi.sdk.home.bizbar.HomeBizNavExtendBarController;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.util.ResourcesHelper;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class HomeBizNavBarFragment extends Fragment implements IBizNavBarDelegate {

    /* renamed from: a */
    private static final String f39148a = "HomeBizNavBarFragment";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f39149b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BizNavLayout f39150c;

    /* renamed from: d */
    private View f39151d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FrameLayout f39152e;

    /* renamed from: f */
    private HomeBizNavExtendBarController f39153f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BizNavItemMgr f39154g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public BizSelectListener f39155h;

    /* renamed from: i */
    private int f39156i = 0;

    /* renamed from: j */
    private boolean f39157j = false;

    public interface BizSelectListener {
        void onSelect(CarGrop carGrop, CarGrop carGrop2, boolean z, int i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflateViewAsync = ViewEx.inflateViewAsync(layoutInflater, (int) R.layout.new_ui_f_biz_bar, (ViewGroup) null, false);
        this.f39149b = inflateViewAsync;
        this.f39150c = (BizNavLayout) inflateViewAsync.findViewById(R.id.biz_nav_layout);
        this.f39151d = this.f39149b.findViewById(R.id.biz_nav_divider);
        this.f39152e = (FrameLayout) this.f39149b.findViewById(R.id.biz_nav_container);
        return this.f39149b;
    }

    public View getItemByGroupType(String str) {
        return this.f39150c.getItemByGroupType(str);
    }

    public void showBizBar() {
        if (this.f39149b == null || this.f39156i <= 1) {
            SystemUtils.log(3, f39148a, "showBizBar:" + this.f39156i, (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 77);
            return;
        }
        SystemUtils.log(3, f39148a, "showBizBar", (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 74);
        m29485a();
    }

    public void hideBizBar() {
        if (this.f39149b != null) {
            m29489b();
        }
    }

    public int getBizBarHeight() {
        View view = this.f39149b;
        if (view == null || this.f39157j) {
            return 0;
        }
        return view.getHeight();
    }

    public void setBizBarBackgroundColor(int i) {
        BizNavLayout bizNavLayout = this.f39150c;
        if (bizNavLayout != null) {
            bizNavLayout.setBackgroundColor(i);
        }
    }

    public void showBizBarDivider() {
        View view = this.f39151d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void hideBizBarDivider() {
        View view = this.f39151d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void setConfigInfo(List<TopCarGroupWrapper> list, boolean z) {
        if (this.f39149b != null) {
            if (this.f39154g == null) {
                this.f39154g = new BizNavItemMgr(DIDIBaseApplication.getAppContext());
            }
            if (list == null || list.size() == 0 || list.size() == 1) {
                this.f39156i = 1;
                m29491c();
                return;
            }
            this.f39154g.setList(m29484a(list));
            this.f39156i = this.f39154g.getList().size();
            this.f39154g.setHotInfo(ConfProxy.getInstance().getHotInfo());
            this.f39150c.setBizNavItemMgr(this.f39154g);
            if (!z && this.f39152e.getVisibility() != 0) {
                SystemUtils.log(3, f39148a, "showBizNav", (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 134);
                m29485a();
            }
        }
    }

    /* renamed from: a */
    private void m29485a() {
        this.f39157j = false;
        this.f39149b.setVisibility(0);
        this.f39152e.setVisibility(0);
        this.f39150c.setClickable(true);
        this.f39152e.startAnimation(m29483a((int) R.anim.new_ui_bottom_in, (Animation.AnimationListener) new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                HomeBizNavBarFragment.this.m29486a(1);
            }

            public void onAnimationEnd(Animation animation) {
                HomeBizNavBarFragment.this.m29486a(2);
            }
        }));
    }

    /* renamed from: b */
    private void m29489b() {
        if (this.f39149b.getVisibility() != 4 && !this.f39157j) {
            SystemUtils.log(3, f39148a, "hideBizNav", (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 167);
            this.f39157j = true;
            this.f39150c.setClickable(false);
            this.f39152e.startAnimation(m29483a((int) R.anim.new_ui_bottom_out, (Animation.AnimationListener) new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    HomeBizNavBarFragment.this.m29486a(3);
                }

                public void onAnimationEnd(Animation animation) {
                    HomeBizNavBarFragment.this.f39149b.setVisibility(4);
                    HomeBizNavBarFragment.this.m29486a(4);
                }
            }));
        }
    }

    /* renamed from: c */
    private void m29491c() {
        if (this.f39152e.getVisibility() != 8) {
            SystemUtils.log(3, f39148a, "hideBizNavContainer", (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 194);
            this.f39152e.startAnimation(m29483a((int) R.anim.new_ui_bottom_out, (Animation.AnimationListener) new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    HomeBizNavBarFragment.this.m29486a(3);
                }

                public void onAnimationEnd(Animation animation) {
                    HomeBizNavBarFragment.this.f39152e.setVisibility(8);
                    HomeBizNavBarFragment.this.m29486a(4);
                }
            }));
        }
    }

    /* renamed from: a */
    private Animation m29483a(int i, Animation.AnimationListener animationListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f39152e.getContext(), i);
        loadAnimation.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        loadAnimation.setAnimationListener(animationListener);
        return loadAnimation;
    }

    public void switchToPage(String str) {
        TopCarGroupWrapper switchToPage = this.f39150c.switchToPage(str);
        if (switchToPage != null) {
            this.f39154g.changeItemToMainBar(switchToPage);
            this.f39150c.notifyDataChanged();
        }
        restoreToDefaultStyle();
    }

    public void showExtendBar(Context context, ViewGroup viewGroup) {
        if (this.f39153f == null) {
            HomeBizNavExtendBarController homeBizNavExtendBarController = new HomeBizNavExtendBarController(this.f39154g);
            this.f39153f = homeBizNavExtendBarController;
            homeBizNavExtendBarController.setSelectListener(new HomeBizNavExtendBarController.ExtendSelectListener() {
                public void onSelect(CarGrop carGrop) {
                    CarGrop selectedGrop = HomeBizNavBarFragment.this.f39150c.getSelectedGrop();
                    HomeBizNavBarFragment.this.f39150c.notifyDataChanged();
                    if (HomeBizNavBarFragment.this.f39155h != null) {
                        boolean z = false;
                        if (HomeBizNavBarFragment.this.f39154g.hasRedPoint(carGrop.getGroupType(), carGrop.getNavTag()) && HomeBizNavBarFragment.this.f39154g.isRedPointNeedShow()) {
                            z = true;
                            HomeBizNavBarFragment.this.f39154g.activeRedPointCount();
                        }
                        HomeBizNavBarFragment.this.f39155h.onSelect(selectedGrop, carGrop, z, 3);
                    }
                }
            });
        }
        this.f39153f.showExtendBar(context, viewGroup);
    }

    public void hideExtendBar() {
        HomeBizNavExtendBarController homeBizNavExtendBarController = this.f39153f;
        if (homeBizNavExtendBarController != null) {
            homeBizNavExtendBarController.hideExtendBar();
        }
    }

    /* renamed from: a */
    private List<TopCarGroupWrapper> m29484a(List<TopCarGroupWrapper> list) {
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).carGrop == null) {
                list.remove(i);
            }
        }
        return list;
    }

    public void restoreToDefaultStyle() {
        setBizBarBackgroundColor(ResourcesHelper.getColor(getContext(), R.color.new_ui_biz_nav_background));
        showBizBarDivider();
    }

    public void setNavSelectListener(BizSelectListener bizSelectListener) {
        this.f39155h = bizSelectListener;
        this.f39150c.setSelectListener(bizSelectListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29486a(int i) {
        BizNavBarEvent bizNavBarEvent = new BizNavBarEvent();
        bizNavBarEvent.state = i;
        bizNavBarEvent.height = getBizBarHeight();
        EventBus.getDefault().postSticky(bizNavBarEvent);
    }
}
