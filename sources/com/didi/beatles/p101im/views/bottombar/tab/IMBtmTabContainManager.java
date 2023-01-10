package com.didi.beatles.p101im.views.bottombar.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.protocol.model.IMTabActionItem;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.bottombar.tab.IMBtmTabGroup;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabContainManager */
public class IMBtmTabContainManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11941a = IMBtmTabContainManager.class.getSimpleName();

    /* renamed from: b */
    private static final int f11942b = 0;

    /* renamed from: c */
    private static final int f11943c = 1;

    /* renamed from: d */
    private static final int f11944d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Context f11945e;

    /* renamed from: f */
    private final IMTabActionFactory f11946f;

    /* renamed from: g */
    private final int f11947g;

    /* renamed from: h */
    private ViewStub f11948h;

    /* renamed from: i */
    private IMBtmTabGroup f11949i;

    /* renamed from: j */
    private IMBtmTabContainCallback f11950j;

    /* renamed from: k */
    private List<IMTabActionItem> f11951k = new ArrayList();

    /* renamed from: l */
    private int f11952l = 0;

    /* renamed from: m */
    private Map<String, String> f11953m = null;

    /* renamed from: n */
    private IMBtmTabGroup.OnTabCheckedChangeListener f11954n = new IMBtmTabGroup.OnTabCheckedChangeListener() {
        public void onTabCheckedChanged(int i, boolean z, boolean z2) {
            IMLog.m10020d(IMBtmTabContainManager.f11941a, C4786I.m9980t("[onTabCheckedChanged] pluginId=", Integer.valueOf(i), " |checked=", Boolean.valueOf(z), " |isClick=", Boolean.valueOf(z2)));
            if (z && z2) {
                IMPreference.getInstance(IMBtmTabContainManager.this.f11945e).setBottomTabSelectPluginId(IMCommonContextInfoHelper.getUid(), i);
            }
            IMTabActionItem a = IMBtmTabContainManager.this.m10288b(i);
            if (a == null) {
                IMLog.m10020d(IMBtmTabContainManager.f11941a, C4786I.m9980t("[onTabCheckedChanged] load NULL tab action item with pluginId=", Integer.valueOf(i)));
            } else if (z) {
                IMBtmTabContainManager.this.m10286a(a, z2);
            }
        }
    };

    /* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabContainManager$IMBtmTabContainCallback */
    public interface IMBtmTabContainCallback {
        void invokeEmojiAction(boolean z);

        void invokeFuncAction(boolean z);

        void invokeMsgAction(boolean z);

        void invokePluginAction(IMTabActionItem iMTabActionItem, boolean z);
    }

    public IMBtmTabContainManager(View view, int i) {
        this.f11945e = view.getContext();
        this.f11947g = i;
        this.f11946f = new IMTabActionFactory();
        this.f11948h = (ViewStub) view.findViewById(R.id.im_stub_bottom_tab_group);
    }

    public void setExtraTraceMap(Map<String, String> map) {
        this.f11953m = map;
    }

    public void setCallback(IMBtmTabContainCallback iMBtmTabContainCallback) {
        this.f11950j = iMBtmTabContainCallback;
    }

    public void setCheck(int i) {
        if (this.f11949i != null) {
            int a = m10282a(i);
            IMLog.m10020d(f11941a, C4786I.m9980t("[setCheck] pluginId=", Integer.valueOf(i), " |newPluginId=", Integer.valueOf(a)));
            this.f11949i.setCheckId(a, false);
        }
    }

    /* renamed from: a */
    private int m10282a(int i) {
        List<IMTabActionItem> list = this.f11951k;
        if (list == null) {
            return -1;
        }
        boolean z = false;
        Iterator<IMTabActionItem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (i == it.next().pluginId) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            return i;
        }
        return -1;
    }

    public void reset() {
        IMLog.m10020d(f11941a, "[reset]");
        setCheck(-1);
    }

    public List<IMTabActionItem> getTabActionItemList() {
        return this.f11951k;
    }

    public int getCheckedPluginId() {
        IMBtmTabGroup iMBtmTabGroup = this.f11949i;
        if (iMBtmTabGroup != null) {
            return iMBtmTabGroup.getCheckedId();
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        r3 = r2.f10966id;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void refreshTabList(java.util.List<com.didi.beatles.p101im.api.entity.IMSessionExtendInfo.BottomTabInfo> r9, final int r10) {
        /*
            r8 = this;
            java.lang.String r0 = f11941a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[refreshTabList] "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            com.didi.beatles.p101im.utils.IMLog.m10020d(r0, r1)
            java.util.List<com.didi.beatles.im.protocol.model.IMTabActionItem> r0 = r8.f11951k
            r0.clear()
            r0 = 0
            if (r9 == 0) goto L_0x00ad
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L_0x0026
            goto L_0x00ad
        L_0x0026:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x002f:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x009a
            java.lang.Object r2 = r9.next()
            com.didi.beatles.im.api.entity.IMSessionExtendInfo$BottomTabInfo r2 = (com.didi.beatles.p101im.api.entity.IMSessionExtendInfo.BottomTabInfo) r2
            if (r2 == 0) goto L_0x0073
            boolean r3 = r2.ignore
            if (r3 == 0) goto L_0x0042
            goto L_0x0073
        L_0x0042:
            com.didi.beatles.im.views.bottombar.tab.IMTabActionFactory r3 = r8.f11946f
            if (r3 != 0) goto L_0x0047
            goto L_0x002f
        L_0x0047:
            int r3 = r2.f10966id
            com.didi.beatles.im.views.bottombar.tab.IMTabActionFactory r4 = r8.f11946f
            android.content.Context r5 = r8.f11945e
            com.didi.beatles.im.views.bottombar.tab.IMBtmTabContainManager$2 r6 = new com.didi.beatles.im.views.bottombar.tab.IMBtmTabContainManager$2
            r6.<init>(r3, r10)
            java.lang.String r7 = r2.name
            com.didi.beatles.im.protocol.model.IMTabActionItem r3 = r4.loadTabActionItem(r5, r3, r6, r7)
            if (r3 != 0) goto L_0x005b
            goto L_0x002f
        L_0x005b:
            android.view.View r4 = r3.customTabView
            if (r4 != 0) goto L_0x0069
            com.didi.beatles.im.views.bottombar.tab.IMBtmTabContentView r4 = new com.didi.beatles.im.views.bottombar.tab.IMBtmTabContentView
            android.content.Context r5 = r8.f11945e
            r4.<init>(r5)
            r3.setDefaultTabView(r4)
        L_0x0069:
            boolean r2 = r2.isEnable()
            r3.enable = r2
            r1.add(r3)
            goto L_0x002f
        L_0x0073:
            java.lang.String r3 = f11941a
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "[refreshTabList] tab ignore "
            r5.append(r6)
            if (r2 != 0) goto L_0x0087
            java.lang.String r2 = "empty"
            goto L_0x008d
        L_0x0087:
            int r2 = r2.f10966id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x008d:
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4[r0] = r2
            com.didi.beatles.p101im.utils.IMLog.m10024i(r3, r4)
            goto L_0x002f
        L_0x009a:
            r8.f11951k = r1
            int r9 = r8.f11952l
            r10 = 2
            if (r9 == r10) goto L_0x00a5
            r8.m10289b()
            goto L_0x00ac
        L_0x00a5:
            java.lang.String r9 = f11941a
            java.lang.String r10 = "[refreshTabList] ###STATUS_HIDDEN###"
            com.didi.beatles.p101im.utils.IMLog.m10020d(r9, r10)
        L_0x00ac:
            return
        L_0x00ad:
            r8.f11952l = r0
            com.didi.beatles.im.views.bottombar.tab.IMBtmTabGroup r9 = r8.f11949i
            com.didi.beatles.p101im.utils.IMViewUtil.hide((android.view.View) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.views.bottombar.tab.IMBtmTabContainManager.refreshTabList(java.util.List, int):void");
    }

    /* renamed from: b */
    private void m10289b() {
        List<IMTabActionItem> list = this.f11951k;
        if (list == null || list.isEmpty()) {
            this.f11952l = 0;
            IMViewUtil.hide((View) this.f11949i);
            IMLog.m10020d(f11941a, "[renderTabGroup] =NULL LIST=");
            return;
        }
        this.f11952l = 1;
        if (this.f11949i == null) {
            IMBtmTabGroup iMBtmTabGroup = (IMBtmTabGroup) this.f11948h.inflate();
            this.f11949i = iMBtmTabGroup;
            iMBtmTabGroup.setOnTabCheckedChangeListener(this.f11954n);
            this.f11949i.setExtraTraceMap(this.f11953m);
        }
        IMViewUtil.show((View) this.f11949i);
        this.f11949i.bindData(this.f11951k);
    }

    public void hideTab() {
        IMLog.m10020d(f11941a, C4786I.m9980t("[hideTab] mTabStatus=", Integer.valueOf(this.f11952l)));
        if (this.f11952l == 1) {
            this.f11952l = 2;
            IMViewUtil.hide((View) this.f11949i);
        }
    }

    public void showTab() {
        IMLog.m10020d(f11941a, C4786I.m9980t("[showTab] mTabStatus=", Integer.valueOf(this.f11952l)));
        if (this.f11952l == 2) {
            m10289b();
        }
    }

    public void clear() {
        IMViewUtil.hide((View) this.f11949i);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public IMTabActionItem m10288b(int i) {
        List<IMTabActionItem> list = this.f11951k;
        if (list == null) {
            return null;
        }
        for (IMTabActionItem next : list) {
            if (next.pluginId == i) {
                return next;
            }
        }
        IMLog.m10021e(f11941a, C4786I.m9980t("[findTabAction] Null with pluginId:", Integer.valueOf(i)));
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10286a(IMTabActionItem iMTabActionItem, boolean z) {
        if (iMTabActionItem.pluginId == 4) {
            IMBtmTabContainCallback iMBtmTabContainCallback = this.f11950j;
            if (iMBtmTabContainCallback != null) {
                iMBtmTabContainCallback.invokeMsgAction(z);
            }
        } else if (iMTabActionItem.pluginId == 6) {
            IMBtmTabContainCallback iMBtmTabContainCallback2 = this.f11950j;
            if (iMBtmTabContainCallback2 != null) {
                iMBtmTabContainCallback2.invokeEmojiAction(z);
            }
        } else if (iMTabActionItem.pluginId == 5) {
            IMBtmTabContainCallback iMBtmTabContainCallback3 = this.f11950j;
            if (iMBtmTabContainCallback3 != null) {
                iMBtmTabContainCallback3.invokeFuncAction(z);
            }
        } else {
            IMBtmTabContainCallback iMBtmTabContainCallback4 = this.f11950j;
            if (iMBtmTabContainCallback4 != null) {
                iMBtmTabContainCallback4.invokePluginAction(iMTabActionItem, z);
            }
        }
    }

    public void release() {
        this.f11950j = null;
        this.f11954n = null;
        IMTabActionFactory iMTabActionFactory = this.f11946f;
        if (iMTabActionFactory != null) {
            iMTabActionFactory.release();
        }
    }
}
