package com.didi.map.setting.global.diversion;

import android.content.Context;
import android.text.TextUtils;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.apollo.MapSettingApolloUtil;
import com.didi.map.setting.common.diversion.INavDiversionPloy;
import com.didi.map.setting.common.diversion.INavDiversionProvider;
import com.didi.map.setting.common.diversion.NavDiversionApollo;
import com.didi.map.setting.common.diversion.impl.NavDiversionProviderImpl;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.global.MapSettingNavUtils;
import java.util.List;

public class NavDiversionPloyImpl implements INavDiversionPloy {

    /* renamed from: a */
    private static final String f31473a = "NavDiversion ";

    /* renamed from: b */
    private INavDiversionProvider f31474b;

    /* renamed from: c */
    private IMapSettingPreferences f31475c;

    /* renamed from: d */
    private Context f31476d;

    public static INavDiversionPloy newInstance(Context context) {
        if (MapSettingApolloUtil.isAutoOpenNav() || !NavDiversionApollo.allow() || context == null) {
            DLog.m23976d("NavDiversion create empty INavDiversionPloy", new Object[0]);
            return new INavDiversionPloy() {
                public String getDiversionTarget(List<String> list) {
                    return null;
                }

                public boolean needDiversion() {
                    return false;
                }

                public void startNav(String str) {
                }
            };
        }
        DLog.m23976d("NavDiversion create NavDiversionPloyImpl", new Object[0]);
        return new NavDiversionPloyImpl(context);
    }

    private NavDiversionPloyImpl(Context context) {
        this.f31476d = context;
        this.f31474b = new NavDiversionProviderImpl(context);
        this.f31475c = MapSettingFactory.createMapPreferences(context);
    }

    public boolean needDiversion() {
        if (m24029a()) {
            DLog.m23976d("NavDiversion has SetUp DefaultNav return false", new Object[0]);
            return false;
        }
        List<String> navFromList = NavDiversionApollo.getNavFromList();
        if (navFromList.isEmpty()) {
            DLog.m23976d("NavDiversion apolloFromList is empty return false", new Object[0]);
            return false;
        } else if (TextUtils.isEmpty(getDiversionTarget(MapSettingNavUtils.getInstallNavTypeList(MapSettingNavUtils.getInstalledThirdNav(this.f31476d))))) {
            DLog.m23976d("NavDiversion targetType is empty return false", new Object[0]);
            return false;
        } else {
            if (!this.f31474b.hasStartedNav()) {
                DLog.m23976d(f31473a, "has not Started Nav");
                if (navFromList.contains(MapSettingNavUtils.getNavTypeByPkgName(this.f31475c.getNavSelectedPath()))) {
                    DLog.m23976d(f31473a, "clear remember nav return true");
                    this.f31475c.setNavRemember(false);
                    this.f31475c.setNavSelectedPath("");
                    return true;
                }
            }
            String a = m24028a(navFromList);
            DLog.m23976d("NavDiversion common use nav is = " + a, new Object[0]);
            return !TextUtils.isEmpty(a);
        }
    }

    public String getDiversionTarget(List<String> list) {
        if (list == null || list.isEmpty()) {
            DLog.m23976d("NavDiversion installNav is empty", new Object[0]);
            return null;
        }
        List<String> navToList = NavDiversionApollo.getNavToList();
        if (navToList.isEmpty()) {
            DLog.m23976d("NavDiversion targetList is empty", new Object[0]);
            return null;
        }
        for (String next : navToList) {
            if (list.contains(next)) {
                DLog.m23976d("NavDiversion getTarget is " + next, new Object[0]);
                return next;
            }
        }
        DLog.m23976d("NavDiversion getTarget is null", new Object[0]);
        return null;
    }

    public void startNav(String str) {
        if (m24029a()) {
            this.f31474b.clearNavRecord();
            DLog.m23976d("NavDiversion clean nav records", new Object[0]);
        } else {
            this.f31474b.appendNavRecord(str);
            DLog.m23976d("NavDiversion append nav record = " + str, new Object[0]);
        }
        this.f31474b.setHasStartedNav();
    }

    /* renamed from: a */
    private String m24028a(List<String> list) {
        if (list.isEmpty()) {
            DLog.m23976d("NavDiversion apolloFromList is empty return null", new Object[0]);
            return null;
        }
        List<String> navRecord = this.f31474b.getNavRecord();
        if (navRecord.isEmpty()) {
            DLog.m23976d("NavDiversion navRecords is empty return null", new Object[0]);
            return null;
        }
        int usageThreshold = NavDiversionApollo.getUsageThreshold();
        DLog.m23976d("NavDiversion usageCount is " + usageThreshold, new Object[0]);
        for (String next : list) {
            int i = 0;
            for (String equals : navRecord) {
                if (equals.equals(next)) {
                    i++;
                }
            }
            if (i >= usageThreshold) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m24029a() {
        if (!this.f31474b.hasStartedNav()) {
            return false;
        }
        boolean navRemember = this.f31475c.getNavRemember();
        String navSelectedPath = this.f31475c.getNavSelectedPath();
        if (!navRemember || TextUtils.isEmpty(navSelectedPath)) {
            return false;
        }
        return true;
    }
}
