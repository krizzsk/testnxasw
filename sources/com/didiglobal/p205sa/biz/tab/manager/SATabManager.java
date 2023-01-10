package com.didiglobal.p205sa.biz.tab.manager;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.business.ISaTabDelegate;
import com.didi.sdk.app.business.SaTabIds;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.p205sa.biz.fragment.SaTabFragment;
import com.didiglobal.p205sa.biz.tab.model.SaTabDataModel;
import com.didiglobal.p205sa.biz.tab.model.SaTabMenuModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo148867d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001-B/\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u0018J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0006\u0010 \u001a\u00020\u0012J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0006\u0010\"\u001a\u00020\u001bJ\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u0018H\u0002J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u001bJ \u0010(\u001a\u00020\u001b2\u0018\b\u0001\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0015j\b\u0012\u0004\u0012\u00020\u000e`\u0016J\u0006\u0010)\u001a\u00020\u001bJ\u0006\u0010*\u001a\u00020\u001bJ\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f`\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0015j\b\u0012\u0004\u0012\u00020\u000e`\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo148868d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SATabManager;", "", "supportManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "", "saTabFragment", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment;", "containerGroup", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentManager;ILcom/didiglobal/sa/biz/fragment/SaTabFragment;Landroid/view/ViewGroup;)V", "currentFragment", "Landroidx/fragment/app/Fragment;", "currentTabModel", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "supportFragmentManager", "tabFragmentMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "tabList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "canSwitch", "", "model", "clickTab", "", "isClick", "eventSwitchTab", "event", "Lcom/didiglobal/sa/biz/tab/manager/SATabManager$SaSwitchTabEvent;", "getCurrentTabId", "hasClicked", "hideFragment", "loadFragment", "refreshTab", "saTabDataModel", "Lcom/didiglobal/sa/biz/tab/model/SaTabDataModel;", "release", "setAndUpdateData", "setDefault", "showFragment", "updateTabList", "clickModel", "SaSwitchTabEvent", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SATabManager */
/* compiled from: SATabManager.kt */
public final class SATabManager {

    /* renamed from: a */
    private ArrayList<SaTabFragment.TabModel> f53752a = new ArrayList<>();

    /* renamed from: b */
    private HashMap<String, Fragment> f53753b = new HashMap<>();

    /* renamed from: c */
    private Fragment f53754c;

    /* renamed from: d */
    private int f53755d;

    /* renamed from: e */
    private SaTabFragment f53756e;

    /* renamed from: f */
    private FragmentManager f53757f;

    /* renamed from: g */
    private SaTabFragment.TabModel f53758g;

    public SATabManager(FragmentManager fragmentManager, int i, SaTabFragment saTabFragment, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(fragmentManager, "supportManager");
        Intrinsics.checkNotNullParameter(saTabFragment, "saTabFragment");
        Intrinsics.checkNotNullParameter(viewGroup, "containerGroup");
        this.f53757f = fragmentManager;
        this.f53755d = i;
        this.f53756e = saTabFragment;
        EventBus.getDefault().register(this);
        if (SaApolloUtil.INSTANCE.getSaOneState()) {
            this.f53757f.beginTransaction().add((int) R.id.saTabContainer, (Fragment) saTabFragment).commitNowAllowingStateLoss();
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = UiUtils.dip2px(DIDIApplication.getAppContext(), 70.0f);
            }
        }
    }

    public final void setAndUpdateData(ArrayList<SaTabFragment.TabModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "tabList");
        if (SaApolloUtil.INSTANCE.getSaOneState()) {
            this.f53752a.clear();
            this.f53752a.addAll(arrayList);
        }
    }

    public final void setDefault() {
        if (!SaApolloUtil.INSTANCE.getSaOneState()) {
            SaTabFragment.TabModel tabModel = new SaTabFragment.TabModel();
            SaTabMenuModel saTabMenuModel = new SaTabMenuModel();
            saTabMenuModel.setTabId(SaTabIds.TAB_HOME.getId());
            Unit unit = Unit.INSTANCE;
            tabModel.setTabMenu(saTabMenuModel);
            Unit unit2 = Unit.INSTANCE;
            m40112d(tabModel);
        } else if (!this.f53752a.isEmpty()) {
            SaTabFragment.TabModel tabModel2 = this.f53752a.get(0);
            Intrinsics.checkNotNullExpressionValue(tabModel2, "tabList[0]");
            m40108a(this, tabModel2, false, 2, (Object) null);
            SaTabFragment.TabModel tabModel3 = this.f53752a.get(0);
            Intrinsics.checkNotNullExpressionValue(tabModel3, "tabList[0]");
            m40112d(tabModel3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r0.getTabMenu();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m40109a(com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel r3) {
        /*
            r2 = this;
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r0 = r2.f53758g
            r1 = 0
            if (r0 != 0) goto L_0x0007
        L_0x0005:
            r0 = r1
            goto L_0x0012
        L_0x0007:
            com.didiglobal.sa.biz.tab.model.SaTabMenuModel r0 = r0.getTabMenu()
            if (r0 != 0) goto L_0x000e
            goto L_0x0005
        L_0x000e:
            java.lang.String r0 = r0.getTabId()
        L_0x0012:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r3 != 0) goto L_0x0017
            goto L_0x0022
        L_0x0017:
            com.didiglobal.sa.biz.tab.model.SaTabMenuModel r3 = r3.getTabMenu()
            if (r3 != 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            java.lang.String r1 = r3.getTabId()
        L_0x0022:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r3 = android.text.TextUtils.equals(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.tab.manager.SATabManager.m40109a(com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel):boolean");
    }

    /* renamed from: b */
    private final boolean m40110b(SaTabFragment.TabModel tabModel) {
        String tabId;
        Class<ISaTabDelegate> cls = ISaTabDelegate.class;
        SaTabMenuModel tabMenu = tabModel.getTabMenu();
        String str = "";
        if (!(tabMenu == null || (tabId = tabMenu.getTabId()) == null)) {
            str = tabId;
        }
        ISaTabDelegate iSaTabDelegate = (ISaTabDelegate) ServiceLoader.load(cls, str).get();
        if (iSaTabDelegate == null) {
            return true;
        }
        return iSaTabDelegate.canSwitch();
    }

    public static /* synthetic */ void clickTab$default(SATabManager sATabManager, SaTabFragment.TabModel tabModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        sATabManager.clickTab(tabModel, z);
    }

    public final void clickTab(SaTabFragment.TabModel tabModel, boolean z) {
        Intrinsics.checkNotNullParameter(tabModel, "model");
        SaTabTrackManager.INSTANCE.trackClick(tabModel, this.f53752a);
        if (m40110b(tabModel) && !m40109a(tabModel)) {
            new SaTabHotInfoManager(tabModel).clickHot();
            m40107a(tabModel, z);
            m40112d(tabModel);
        }
    }

    public final void refreshTab(SaTabDataModel saTabDataModel) {
        Object obj;
        Intrinsics.checkNotNullParameter(saTabDataModel, "saTabDataModel");
        ArrayList<SaTabFragment.TabModel> tabData = SaTabDataManager.INSTANCE.getTabData(getCurrentTabId(), saTabDataModel);
        if (tabData != null) {
            Iterator it = tabData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((SaTabFragment.TabModel) obj).isClicked()) {
                    break;
                }
            }
            SaTabFragment.TabModel tabModel = (SaTabFragment.TabModel) obj;
            if (tabModel != null) {
                setAndUpdateData(tabData);
                if (!m40109a(tabModel)) {
                    m40112d(tabModel);
                }
                m40108a(this, tabModel, false, 2, (Object) null);
            }
        }
    }

    public final String getCurrentTabId() {
        SaTabMenuModel tabMenu;
        SaTabFragment.TabModel tabModel = this.f53758g;
        String str = null;
        if (!(tabModel == null || (tabMenu = tabModel.getTabMenu()) == null)) {
            str = tabMenu.getTabId();
        }
        return str == null ? SaTabIds.TAB_HOME.getId() : str;
    }

    /* renamed from: a */
    static /* synthetic */ void m40108a(SATabManager sATabManager, SaTabFragment.TabModel tabModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        sATabManager.m40107a(tabModel, z);
    }

    /* renamed from: a */
    private final void m40107a(SaTabFragment.TabModel tabModel, boolean z) {
        tabModel.setClicked(true);
        this.f53758g = tabModel;
        m40111c(tabModel);
        SaTabFragment saTabFragment = this.f53756e;
        if (saTabFragment != null) {
            saTabFragment.refreshTab(this.f53752a, z);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m40111c(com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel r6) {
        /*
            r5 = this;
            java.util.ArrayList<com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel> r0 = r5.f53752a
            if (r0 != 0) goto L_0x0005
            goto L_0x0036
        L_0x0005:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.next()
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r1 = (com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel) r1
            r2 = 0
            r1.setClicked(r2)
            com.didiglobal.sa.biz.tab.manager.SaTabBusinessRedPointManager r2 = com.didiglobal.p205sa.biz.tab.manager.SaTabBusinessRedPointManager.INSTANCE
            com.didiglobal.sa.biz.tab.model.SaTabMenuModel r3 = r1.getTabMenu()
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.lang.String r3 = r3.getTabId()
            if (r3 != 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r4 = r3
        L_0x002e:
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel$TabPointInfo r2 = r2.getSaTabPointInfo(r4)
            r1.setTabPointInfo(r2)
            goto L_0x000b
        L_0x0036:
            java.util.ArrayList<com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel> r0 = r5.f53752a
            r1 = 0
            if (r0 != 0) goto L_0x003c
            goto L_0x0074
        L_0x003c:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0042:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0072
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r3 = (com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel) r3
            com.didiglobal.sa.biz.tab.model.SaTabMenuModel r4 = r6.getTabMenu()
            if (r4 != 0) goto L_0x0057
            r4 = r1
            goto L_0x005b
        L_0x0057:
            java.lang.String r4 = r4.getTabId()
        L_0x005b:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.didiglobal.sa.biz.tab.model.SaTabMenuModel r3 = r3.getTabMenu()
            if (r3 != 0) goto L_0x0065
            r3 = r1
            goto L_0x0069
        L_0x0065:
            java.lang.String r3 = r3.getTabId()
        L_0x0069:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.equals(r4, r3)
            if (r3 == 0) goto L_0x0042
            r1 = r2
        L_0x0072:
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r1 = (com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel) r1
        L_0x0074:
            if (r1 != 0) goto L_0x0077
            goto L_0x007b
        L_0x0077:
            r6 = 1
            r1.setClicked(r6)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.tab.manager.SATabManager.m40111c(com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel):void");
    }

    /* renamed from: d */
    private final void m40112d(SaTabFragment.TabModel tabModel) {
        ServiceLoader<S> load;
        ISaTabDelegate iSaTabDelegate;
        String tabId;
        SaTabMenuModel tabMenu = tabModel.getTabMenu();
        String str = "";
        if (!(tabMenu == null || (tabId = tabMenu.getTabId()) == null)) {
            str = tabId;
        }
        FragmentTransaction beginTransaction = this.f53757f.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
        Fragment fragment = this.f53753b.get(str);
        if (fragment == null && ((load = ServiceLoader.load(ISaTabDelegate.class, str)) == null || (iSaTabDelegate = (ISaTabDelegate) load.get()) == null || (fragment = iSaTabDelegate.getFragment()) == null)) {
            fragment = null;
        }
        if (fragment == null) {
            Fragment fragment2 = this.f53754c;
            if (fragment2 != null) {
                beginTransaction.hide(fragment2);
            }
            this.f53754c = null;
            beginTransaction.commitNowAllowingStateLoss();
            return;
        }
        if (this.f53753b.get(str) == null) {
            beginTransaction.add(this.f53755d, fragment);
            this.f53753b.put(str, fragment);
        } else {
            beginTransaction.show(fragment);
        }
        Fragment fragment3 = this.f53754c;
        if (fragment3 != null) {
            beginTransaction.hide(fragment3);
        }
        beginTransaction.commitNowAllowingStateLoss();
        this.f53754c = fragment;
    }

    public final void showFragment() {
        Fragment fragment;
        FragmentTransaction beginTransaction = this.f53757f.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
        Fragment fragment2 = this.f53754c;
        boolean z = false;
        if (fragment2 != null && !fragment2.isVisible()) {
            z = true;
        }
        if (z && (fragment = this.f53754c) != null) {
            beginTransaction.show(fragment);
        }
        SaTabFragment saTabFragment = this.f53756e;
        if (!(saTabFragment == null ? null : Boolean.valueOf(saTabFragment.isVisible())).booleanValue()) {
            beginTransaction.show(this.f53756e);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public final void hideFragment() {
        Fragment fragment = this.f53754c;
        boolean z = false;
        if (fragment != null && fragment.isHidden()) {
            z = true;
        }
        if (!z) {
            FragmentTransaction beginTransaction = this.f53757f.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
            Fragment fragment2 = this.f53754c;
            if (fragment2 != null) {
                beginTransaction.hide(fragment2);
            }
            beginTransaction.hide(this.f53756e).commitAllowingStateLoss();
        }
    }

    public final void release() {
        EventBus.getDefault().unregister(this);
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SATabManager$SaSwitchTabEvent;", "", "tabId", "", "(Ljava/lang/String;)V", "getTabId", "()Ljava/lang/String;", "setTabId", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didiglobal.sa.biz.tab.manager.SATabManager$SaSwitchTabEvent */
    /* compiled from: SATabManager.kt */
    public static final class SaSwitchTabEvent {
        private String tabId;

        public SaSwitchTabEvent(String str) {
            Intrinsics.checkNotNullParameter(str, BlocksConst.BLOCK_TAB_ID);
            this.tabId = str;
        }

        public final String getTabId() {
            return this.tabId;
        }

        public final void setTabId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tabId = str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(sticky = true, threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eventSwitchTab(com.didiglobal.p205sa.biz.tab.manager.SATabManager.SaSwitchTabEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
            r0.removeStickyEvent((java.lang.Object) r5)
            java.lang.String r0 = r5.getTabId()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0019
            return
        L_0x0019:
            java.util.ArrayList<com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel> r0 = r4.f53752a
            if (r0 != 0) goto L_0x001e
            goto L_0x0051
        L_0x001e:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r3 = (com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel) r3
            com.didiglobal.sa.biz.tab.model.SaTabMenuModel r3 = r3.getTabMenu()
            if (r3 != 0) goto L_0x0039
            goto L_0x003d
        L_0x0039:
            java.lang.String r2 = r3.getTabId()
        L_0x003d:
            java.lang.String r3 = r5.getTabId()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0024
            r2 = r1
        L_0x0048:
            com.didiglobal.sa.biz.fragment.SaTabFragment$TabModel r2 = (com.didiglobal.p205sa.biz.fragment.SaTabFragment.TabModel) r2
            if (r2 != 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            r5 = 1
            r4.clickTab(r2, r5)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.tab.manager.SATabManager.eventSwitchTab(com.didiglobal.sa.biz.tab.manager.SATabManager$SaSwitchTabEvent):void");
    }
}
