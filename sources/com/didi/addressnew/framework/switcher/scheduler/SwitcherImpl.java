package com.didi.addressnew.framework.switcher.scheduler;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import com.didi.address.FromType;
import com.didi.address.GlobalSugCallback;
import com.didi.address.framework.fragmentmarket.animator.ISwitchAnimator;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPointParam;
import com.didi.addressnew.framework.ISugMainPageView;
import com.didi.addressnew.framework.SugMainDialogActivity;
import com.didi.addressnew.framework.SugMainFullScreenActivity;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.fragmentmarket.setting.SettingFragment;
import com.didi.addressnew.framework.switcher.IComponent;
import com.didi.addressnew.framework.switcher.ISwitcher;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.CheckParamUtil;
import com.didi.addressnew.util.CommonUtils;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.feedback.FeedbackConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;

public class SwitcherImpl implements ISwitcher {

    /* renamed from: i */
    private static volatile SwitcherImpl f9233i;

    /* renamed from: a */
    private WeakReference<Activity> f9234a;
    public boolean allowPopFragment = true;

    /* renamed from: b */
    private FragmentManager f9235b;

    /* renamed from: c */
    private int f9236c;

    /* renamed from: d */
    private FragmentFactory f9237d;

    /* renamed from: e */
    private SugParams f9238e;

    /* renamed from: f */
    private IAddressResult f9239f;

    /* renamed from: g */
    private IFragment f9240g;

    /* renamed from: h */
    private GlobalSugCallback f9241h;

    /* renamed from: j */
    private ArrayDeque<IFragment> f9242j = new ArrayDeque<>();

    /* renamed from: k */
    private WayPointParam f9243k;

    /* renamed from: l */
    private int f9244l = 1;

    /* renamed from: m */
    private IAddressResult f9245m;

    /* renamed from: n */
    private long f9246n = 0;

    /* renamed from: o */
    private boolean f9247o = false;

    public void onRegister(String str, IComponent iComponent) {
    }

    public static ISwitcher getInstance() {
        if (f9233i == null) {
            SystemUtils.log(6, "error", "switcher null ex", new Throwable(), "com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl", 59);
        }
        return f9233i;
    }

    public static void createInstance(Activity activity, SugParams sugParams, GlobalSugCallback globalSugCallback) {
        SystemUtils.log(5, FeedbackConfig.FT_SUG, "SwitcherImpl::createInstance(2) +72", (Throwable) null, "com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl", 66);
        synchronized (SwitcherImpl.class) {
            f9233i = new SwitcherImpl(activity, sugParams, globalSugCallback);
        }
    }

    private SwitcherImpl(Activity activity, SugParams sugParams, GlobalSugCallback globalSugCallback) {
        SystemUtils.log(5, FeedbackConfig.FT_SUG, "SwitcherImpl::init(2) +104", (Throwable) null, "com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl", 74);
        this.f9234a = new WeakReference<>(activity);
        this.f9238e = sugParams;
        this.f9239f = new AddressResultEnhancer();
        this.f9237d = new FragmentFactory();
        this.f9241h = globalSugCallback;
        this.f9243k = this.f9238e.wayPointParam;
        CheckParamUtil.checkAddressParam(this.f9238e.addressParam, this.f9238e.fromType);
        AddressTrack.trackCheckAddressParam(activity.getApplicationContext(), this.f9238e.addressParam, this.f9238e.fromType);
        CheckParamUtil.rescueAddressParam(activity.getApplicationContext(), "Sug NEW inital", this.f9238e.addressParam);
        m8025a(activity);
    }

    /* renamed from: a */
    private void m8025a(Activity activity) {
        SystemUtils.log(5, FeedbackConfig.FT_SUG, "SwitcherImpl::startSugMainActivity() +114", new Throwable(), "com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl", 89);
        if (activity != null && !activity.isFinishing()) {
            if (m8023a() == 1) {
                SystemUtils.log(5, FeedbackConfig.FT_SUG, "SwitcherImpl::startSugMainActivity() +122", (Throwable) null, "com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl", 93);
                activity.startActivity(new Intent(activity, SugMainFullScreenActivity.class));
            } else {
                SystemUtils.log(5, FeedbackConfig.FT_SUG, "SwitcherImpl::startSugMainActivity() +125", (Throwable) null, "com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl", 96);
                activity.startActivity(new Intent(activity, SugMainDialogActivity.class));
            }
            activity.overridePendingTransition(0, 0);
        }
    }

    /* renamed from: a */
    private int m8023a() {
        GlobalSugCallback globalSugCallback = this.f9241h;
        if (globalSugCallback != null) {
            return globalSugCallback.requestSugWindowFeature();
        }
        return 2;
    }

    public void startMainFragment(FragmentManager fragmentManager, int i) {
        SugParams sugParams;
        if (fragmentManager != null) {
            this.f9235b = fragmentManager;
        }
        if (i > 0) {
            this.f9236c = i;
        }
        if (this.f9235b != null && i > 0 && (sugParams = this.f9238e) != null && this.f9239f != null) {
            CheckParamUtil.checkAddressParam(sugParams.addressParam, this.f9238e.fromType);
            m8026a(this.f9238e, this.f9239f);
        }
    }

    /* renamed from: a */
    private void m8026a(SugParams sugParams, IAddressResult iAddressResult) {
        initType(sugParams, iAddressResult);
    }

    public void switchWayPointer(SugParams sugParams, IAddressResult iAddressResult) {
        m8030a(FragmentFactory.FragmentType.WAYPOINT, sugParams, iAddressResult);
    }

    public void switchOpenRideWayPointer(SugParams sugParams, IAddressResult iAddressResult) {
        m8030a(FragmentFactory.FragmentType.OPEN_RIDE_ROUTE_EDIT, sugParams, iAddressResult);
    }

    public void switchOpenRideConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        m8030a(FragmentFactory.FragmentType.OPEN_RIDE_CONFIRM, sugParams, iAddressResult);
    }

    public void switchFull(SugParams sugParams, IAddressResult iAddressResult) {
        m8028a(FragmentFactory.FragmentType.FULL, sugParams);
    }

    public void switchSingle(SugParams sugParams, IAddressResult iAddressResult, int i) {
        m8029a(FragmentFactory.FragmentType.SINGLE, sugParams, i);
    }

    public void switchSetting(SugParams sugParams, IAddressResult iAddressResult) {
        m8028a(FragmentFactory.FragmentType.SETTING, sugParams);
    }

    public void switchMapConfirm(SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle) {
        m8032a(FragmentFactory.FragmentType.MAPCONFIRM, sugParams, iAddressResult, i, bundle);
    }

    public void switchEndConfirm(SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle) {
        m8032a(FragmentFactory.FragmentType.END_CONFIRM, sugParams, iAddressResult, i, bundle);
    }

    /* renamed from: b */
    private String m8033b() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "\n";
        if (this.f9239f == null) {
            return str5;
        }
        if (this.f9240g != null) {
            str5 = str5 + "[Fragment = " + this.f9240g.getClass().getSimpleName() + "," + (hashCode() % 100) + "][Result = " + (this.f9239f.hashCode() % 100) + "]\n";
        }
        if (this.f9239f.getAddressResult().start != null) {
            str = str5 + "[起点:" + this.f9239f.getAddressResult().start.displayName + "]\n";
        } else {
            str = str5 + "[起点没设]\n";
        }
        if (this.f9239f.getAddressResult().end != null) {
            str2 = str + "[终点:" + this.f9239f.getAddressResult().end.displayName + "]\n";
        } else {
            str2 = str + "[终点没设]\n";
        }
        if (this.f9239f.getAddressResult().home != null) {
            str3 = str2 + "[家:" + this.f9239f.getAddressResult().home.displayName + "]\n";
        } else {
            str3 = str2 + "[家没设]\n";
        }
        if (this.f9239f.getAddressResult().company != null) {
            str4 = str3 + "[公司点:" + this.f9239f.getAddressResult().company.displayName + "]\n";
        } else {
            str4 = str3 + "[公司没设]\n";
        }
        if (this.f9239f.getAddressResult().common != null) {
            return str4 + "[常点:" + this.f9239f.getAddressResult().common.displayName + "]\n";
        }
        return str4 + "[常点没设]\n";
    }

    public void switchFavorite(SugParams sugParams, IAddressResult iAddressResult) {
        m8028a(FragmentFactory.FragmentType.FAVORITE, sugParams);
    }

    public void switchEditFavorite(SugParams sugParams, IAddressResult iAddressResult) {
        m8028a(FragmentFactory.FragmentType.EDIT_FAVORITE, sugParams);
    }

    public void switchMapSelect(SugParams sugParams, IAddressResult iAddressResult, int i) {
        m8032a(FragmentFactory.FragmentType.MAPSELECT, sugParams, iAddressResult, i, (Bundle) null);
    }

    public void switchMapSelect(SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle) {
        m8032a(FragmentFactory.FragmentType.MAPSELECT, sugParams, iAddressResult, i, bundle);
    }

    public void switchBack(SugParams sugParams, IAddressResult iAddressResult) {
        m8028a(FragmentFactory.FragmentType.SWITCHBACK, sugParams);
    }

    public void switchBack(SugParams sugParams, IAddressResult iAddressResult, int i) {
        m8034b(i);
    }

    public void onCurrentFragmentAttached(IFragment iFragment) {
        IAddressResult iAddressResult;
        IAddressResult clone = this.f9239f.clone();
        if (this.f9247o && (iAddressResult = this.f9245m) != null) {
            clone = iAddressResult;
        }
        iFragment.updateAddressRetToFragment(this.f9238e, clone);
    }

    public void onStartChoosen(Address address) {
        GlobalSugCallback globalSugCallback = this.f9241h;
        if (globalSugCallback != null) {
            globalSugCallback.onStartChoosen(address);
        }
    }

    public void onActivityCloseBefore() {
        m8027a((ISugMainPageView) m8037c());
    }

    public boolean closeSessionImediately() {
        Activity c = m8037c();
        m8027a((ISugMainPageView) m8037c());
        m8040e();
        m8035b(c);
        return true;
    }

    /* renamed from: c */
    private Activity m8037c() {
        IFragment iFragment = this.f9240g;
        if (iFragment == null || iFragment.getFragment() == null) {
            return null;
        }
        return this.f9240g.getFragment().getActivity();
    }

    /* renamed from: b */
    private void m8035b(Activity activity) {
        if (activity != null && (activity instanceof ISugMainPageView)) {
            ((ISugMainPageView) activity).onCloseSugPage();
        }
    }

    public boolean closeSessionWithResult(IAddressResult iAddressResult) {
        this.f9239f.updateAllAddress(iAddressResult);
        IAddressResult iAddressResult2 = this.f9239f;
        if (iAddressResult2 == null) {
            return false;
        }
        if (!CommonUtils.isValidLocation(iAddressResult2.getAddressResult().start) && !CommonUtils.isValidLocation(this.f9239f.getAddressResult().end)) {
            return false;
        }
        if (this.f9241h != null) {
            CommonUtils.checkOrCorrectPoiid(this.f9239f.getAddressResult().start);
            CommonUtils.checkOrCorrectPoiid(this.f9239f.getAddressResult().end);
            this.f9241h.setResult(this.f9239f.getAddressResult());
        }
        m8041f();
        return true;
    }

    public boolean setResultWithoutCloseSession(IAddressResult iAddressResult) {
        this.f9239f.updateAllAddress(iAddressResult);
        IAddressResult iAddressResult2 = this.f9239f;
        if (iAddressResult2 == null) {
            return false;
        }
        if (!CommonUtils.isValidLocation(iAddressResult2.getAddressResult().start) && !CommonUtils.isValidLocation(this.f9239f.getAddressResult().end)) {
            return false;
        }
        if (this.f9241h == null) {
            return true;
        }
        CommonUtils.checkOrCorrectPoiid(this.f9239f.getAddressResult().start);
        CommonUtils.checkOrCorrectPoiid(this.f9239f.getAddressResult().end);
        this.f9241h.setResult(this.f9239f.getAddressResult());
        return true;
    }

    public boolean onBackPressed() {
        IFragment iFragment = this.f9240g;
        if (iFragment == null || iFragment.getFragment().getActivity() == null) {
            return false;
        }
        boolean onBackPressed = this.f9240g.onBackPressed();
        if (onBackPressed) {
            resetOffset();
            switchBack(this.f9238e, this.f9239f);
        }
        if ((onBackPressed || !(this.f9240g instanceof SettingFragment)) && !this.f9242j.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isCanFinishActivity() {
        return this.f9242j.size() == 1;
    }

    public void updateAddressToSwitcher(SugParams sugParams, IAddressResult iAddressResult) {
        this.f9239f.updateAllAddressAllowNullable(iAddressResult);
    }

    public void updateAddressToCurrentFragment(IFragment iFragment) {
        if (iFragment != null) {
            iFragment.updateAddressRetToFragment(this.f9238e, this.f9239f);
        }
    }

    public WayPointParam getWaypointParam() {
        return this.f9243k;
    }

    public ISwitchAnimator getSwitchAnimator() {
        GlobalSugCallback globalSugCallback = this.f9241h;
        if (globalSugCallback != null) {
            return globalSugCallback.getSwitchAnimator();
        }
        return null;
    }

    public void computeOffset() {
        this.f9244l = 0;
        if (this.f9239f.getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit || this.f9239f.getLastOperType() == AddressResultEnhancer.OperType.Cancel) {
            resetOffset();
            return;
        }
        Iterator<IFragment> descendingIterator = this.f9242j.descendingIterator();
        while (descendingIterator.hasNext()) {
            IFragment next = descendingIterator.next();
            if (next.getNodeType() == IFragment.ParentNode.CHILD) {
                this.f9244l++;
            } else if (this.f9240g == next) {
                this.f9244l++;
            } else {
                return;
            }
        }
    }

    public void resetOffset() {
        this.f9244l = 1;
    }

    public void onFragmentCancel(SugParams sugParams, IAddressResult iAddressResult) {
        this.f9239f.onCancel();
    }

    public void onFragmentConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        this.f9239f.onConfirm();
    }

    public void onHomeEnter(SugParams sugParams) {
        this.f9240g.setParentNodeType(IFragment.ParentNode.FULL);
        this.f9240g.disableAnimation(true);
    }

    public void onConfirmEnter(SugParams sugParams) {
        this.f9240g.setParentNodeType(IFragment.ParentNode.FULL);
        this.f9240g.disableAnimation(true);
    }

    public void onGetonEnter(SugParams sugParams) {
        this.f9240g.setParentNodeType(IFragment.ParentNode.FULL);
        this.f9240g.disableAnimation(true);
    }

    public void onWaittingEnter(SugParams sugParams) {
        this.f9240g.setParentNodeType(IFragment.ParentNode.FULL);
        this.f9240g.disableAnimation(true);
    }

    public void onSettingEnter(SugParams sugParams) {
        this.f9240g.setParentNodeType(IFragment.ParentNode.SETTING);
        this.f9240g.disableAnimation(true);
    }

    public void onExit() {
        f9233i = null;
    }

    /* renamed from: a */
    private void m8028a(FragmentFactory.FragmentType fragmentType, SugParams sugParams) {
        m8032a(fragmentType, sugParams, (IAddressResult) null, -1, (Bundle) null);
    }

    /* renamed from: a */
    private void m8029a(FragmentFactory.FragmentType fragmentType, SugParams sugParams, int i) {
        m8032a(fragmentType, sugParams, (IAddressResult) null, i, (Bundle) null);
    }

    /* renamed from: a */
    private void m8030a(FragmentFactory.FragmentType fragmentType, SugParams sugParams, IAddressResult iAddressResult) {
        m8032a(fragmentType, sugParams, iAddressResult, -1, (Bundle) null);
    }

    /* renamed from: a */
    private void m8031a(FragmentFactory.FragmentType fragmentType, SugParams sugParams, IAddressResult iAddressResult, int i) {
        m8032a(fragmentType, sugParams, iAddressResult, i, (Bundle) null);
    }

    /* renamed from: a */
    private void m8032a(FragmentFactory.FragmentType fragmentType, SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle) {
        if (fragmentType != FragmentFactory.FragmentType.SWITCHBACK) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f9246n >= 500) {
                this.f9246n = currentTimeMillis;
            } else {
                return;
            }
        }
        this.f9247o = false;
        FragmentTransaction fragmentTransaction = null;
        FragmentManager fragmentManager = this.f9235b;
        if (fragmentManager != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
        }
        if (fragmentType == FragmentFactory.FragmentType.SWITCHBACK) {
            try {
                if (this.allowPopFragment) {
                    this.f9235b.popBackStack();
                }
            } catch (IllegalStateException e) {
                SystemUtils.log(3, Const.POPUP, "tag", e, "com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl", 522);
            }
            if (!this.f9242j.isEmpty()) {
                IFragment peekLast = this.f9242j.peekLast();
                this.f9240g = peekLast;
                peekLast.onPageExit();
                this.f9242j.pollLast();
                Activity c = m8037c();
                IFragment iFragment = this.f9240g;
                if (iFragment != null) {
                    if (iAddressResult != null) {
                        iAddressResult.setLastPageType(iFragment.getType());
                    }
                    this.f9239f.setLastPageType(this.f9240g.getType());
                }
                if (this.f9242j.isEmpty() && this.f9241h != null) {
                    m8027a((ISugMainPageView) m8037c());
                    m8035b(c);
                    return;
                }
            }
            if (this.f9244l - 1 > 0) {
                for (int i2 = 0; i2 < this.f9244l - 1; i2++) {
                    if (this.f9235b.getBackStackEntryCount() > 0) {
                        try {
                            if (this.allowPopFragment) {
                                this.f9235b.popBackStack();
                            }
                        } catch (IllegalStateException e2) {
                            SystemUtils.log(3, Const.POPUP, "tag", e2, "com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl", 555);
                        }
                        if (!this.f9242j.isEmpty()) {
                            this.f9242j.peekLast().disableAnimation(true);
                            this.f9242j.pollLast();
                        }
                    }
                }
                if (!this.f9242j.isEmpty()) {
                    IFragment peekLast2 = this.f9242j.peekLast();
                    this.f9240g = peekLast2;
                    if (iAddressResult != null) {
                        peekLast2.updateAddressRetToFragment(sugParams, iAddressResult);
                    } else {
                        updateAddressToCurrentFragment(peekLast2);
                    }
                    this.f9240g.onPageEnter();
                }
            } else if (!this.f9242j.isEmpty()) {
                IFragment peekLast3 = this.f9242j.peekLast();
                this.f9240g = peekLast3;
                if (iAddressResult != null) {
                    peekLast3.updateAddressRetToFragment(sugParams, iAddressResult);
                } else {
                    updateAddressToCurrentFragment(peekLast3);
                }
                this.f9240g.onPageEnter();
            }
            fragmentTransaction.show(this.f9240g.getFragment());
        } else {
            Fragment fragment = this.f9237d.generateIFragment(fragmentType, sugParams, i, bundle).getFragment();
            if (!this.f9242j.isEmpty()) {
                IFragment peekLast4 = this.f9242j.peekLast();
                this.f9240g = peekLast4;
                peekLast4.onPageExit();
                if (iAddressResult != null) {
                    iAddressResult.setLastPageType(this.f9240g.getType());
                }
                this.f9239f.setLastPageType(this.f9240g.getType());
            }
            fragmentTransaction.add(this.f9236c, fragment, fragmentType.toString());
            this.f9242j.addLast((IFragment) fragment);
            this.f9240g = this.f9242j.peekLast();
            if (iAddressResult != null) {
                this.f9245m = iAddressResult;
                this.f9247o = true;
            } else {
                this.f9247o = false;
            }
            fragmentTransaction.addToBackStack("SUG");
            m8039d();
        }
        FragmentManager fragmentManager2 = this.f9235b;
        if (fragmentManager2 != null && !fragmentManager2.isDestroyed() && fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
        }
    }

    /* renamed from: d */
    private void m8039d() {
        IFragment iFragment = this.f9240g;
        if (iFragment instanceof FragmentImpl) {
            ((FragmentImpl) iFragment).setSugCallback(this.f9241h);
        }
    }

    public IAddressResult getResult() {
        return this.f9239f;
    }

    /* renamed from: com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl$1 */
    static /* synthetic */ class C38481 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$address$FromType;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.address.FromType[] r0 = com.didi.address.FromType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$address$FromType = r0
                com.didi.address.FromType r1 = com.didi.address.FromType.HOME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM_NEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.address.FromType r1 = com.didi.address.FromType.GET_ON     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.address.FromType r1 = com.didi.address.FromType.WAITRSP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.address.FromType r1 = com.didi.address.FromType.DRIVING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.address.FromType r1 = com.didi.address.FromType.SETTING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.address.FromType r1 = com.didi.address.FromType.ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.address.FromType r1 = com.didi.address.FromType.FROM_CONFIRM_ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.address.FromType r1 = com.didi.address.FromType.FROM_HOME_ROUTE_EDITOR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.address.FromType r1 = com.didi.address.FromType.OPEN_RIDE     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.address.FromType r1 = com.didi.address.FromType.OPEN_RIDE_ROUTE_EDIT     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.address.FromType r1 = com.didi.address.FromType.OPEN_RIDE_CONFIRM     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl.C38481.<clinit>():void");
        }
    }

    public void initType(SugParams sugParams, IAddressResult iAddressResult) {
        if (sugParams != null) {
            switch (C38481.$SwitchMap$com$didi$address$FromType[sugParams.fromType.ordinal()]) {
                case 1:
                    switchFull(sugParams, iAddressResult);
                    onHomeEnter(sugParams);
                    return;
                case 2:
                    m8038c(sugParams, iAddressResult);
                    onConfirmEnter(sugParams);
                    return;
                case 3:
                    switchFull(sugParams, iAddressResult);
                    onConfirmEnter(sugParams);
                    return;
                case 4:
                    switchFull(sugParams, iAddressResult);
                    onGetonEnter(sugParams);
                    return;
                case 5:
                    switchFull(sugParams, iAddressResult);
                    onWaittingEnter(sugParams);
                    return;
                case 7:
                    switchSetting(sugParams, iAddressResult);
                    onSettingEnter(sugParams);
                    return;
                case 8:
                case 9:
                case 10:
                    switchWayPointer(sugParams, iAddressResult);
                    onSettingEnter(sugParams);
                    return;
                case 11:
                    m8036b(sugParams, iAddressResult);
                    onSettingEnter(sugParams);
                    return;
                case 12:
                    switchOpenRideWayPointer(sugParams, iAddressResult);
                    onSettingEnter(sugParams);
                    return;
                case 13:
                    switchOpenRideConfirm(sugParams, iAddressResult);
                    onSettingEnter(sugParams);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    private void m8036b(SugParams sugParams, IAddressResult iAddressResult) {
        sugParams.fromType = FromType.HOME;
        m8028a(FragmentFactory.FragmentType.OPEN_RIDE, sugParams);
    }

    /* renamed from: c */
    private void m8038c(SugParams sugParams, IAddressResult iAddressResult) {
        m8028a(FragmentFactory.FragmentType.CONFIRM_NEW, sugParams);
    }

    /* renamed from: e */
    private void m8040e() {
        try {
            if (this.allowPopFragment) {
                this.f9235b.popBackStack((String) null, 1);
            }
        } catch (IllegalStateException e) {
            SystemUtils.log(3, Const.POPUP, "tag", e, "com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl", 721);
        }
        this.f9235b.executePendingTransactions();
        this.f9242j.clear();
    }

    /* renamed from: a */
    private void m8024a(int i) {
        while (this.f9235b.getBackStackEntryCount() > i) {
            this.f9235b.popBackStack();
            if (!this.f9242j.isEmpty()) {
                IFragment pollLast = this.f9242j.pollLast();
                pollLast.disableAnimation(true);
                pollLast.switchBack((SugParams) null, (IAddressResult) null);
            }
        }
    }

    /* renamed from: b */
    private void m8034b(int i) {
        if (!this.f9242j.isEmpty()) {
            this.f9242j.peekLast().switchBack((SugParams) null, (IAddressResult) null);
        }
        for (int i2 = 0; i2 < i - 1; i2++) {
            if (this.f9235b.getBackStackEntryCount() >= 0 && !this.f9242j.isEmpty()) {
                IFragment peekLast = this.f9242j.peekLast();
                peekLast.disableAnimation(true);
                peekLast.switchBack((SugParams) null, (IAddressResult) null);
            }
        }
    }

    /* renamed from: f */
    private void m8041f() {
        if (!this.f9242j.isEmpty()) {
            this.f9242j.peekLast().switchBack((SugParams) null, (IAddressResult) null);
            this.f9242j.pollLast();
        }
        Iterator it = new ArrayDeque(this.f9242j).iterator();
        while (it.hasNext()) {
            IFragment iFragment = (IFragment) it.next();
            iFragment.disableAnimation(true);
            iFragment.switchBack((SugParams) null, (IAddressResult) null);
        }
    }

    public void delSwitcherResultAddress(int i) {
        IAddressResult iAddressResult = this.f9239f;
        if (iAddressResult != null) {
            iAddressResult.setResultAllowNull(i, (Address) null);
        }
    }

    public void updataSwitcherResultAddressAllowNull(int i, Address address) {
        this.f9239f.setResultAllowNull(i, address);
    }

    public boolean isFragmentOnTop(IFragment iFragment) {
        ArrayDeque<IFragment> arrayDeque = this.f9242j;
        if (arrayDeque == null || arrayDeque.isEmpty() || iFragment != this.f9242j.peekLast()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m8027a(ISugMainPageView iSugMainPageView) {
        if (iSugMainPageView != null) {
            iSugMainPageView.postAsyncSessionCloseCallback(this.f9241h);
        }
    }
}
