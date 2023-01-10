package com.didi.map.setting.common.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.data.MapSettingItemInfo;
import com.didi.map.setting.common.data.MapSettingListInfo;
import com.didi.map.setting.common.delegate.IModelDelegate;
import java.util.List;

public class MapSettingModel {

    /* renamed from: a */
    private Context f31409a;

    /* renamed from: b */
    private PackageManager f31410b;

    /* renamed from: c */
    private List<ResolveInfo> f31411c;

    public MapSettingModel(Context context) {
        this.f31409a = context;
        if (context != null) {
            this.f31410b = context.getPackageManager();
        }
        m23975a();
    }

    /* renamed from: a */
    private void m23975a() {
        if (this.f31410b != null) {
            this.f31411c = this.f31410b.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:q=39.94447,116.274628")), 65536);
        }
    }

    public MapSettingListInfo getMapItemInfo(IModelDelegate iModelDelegate, boolean z, int i) {
        MapSettingListInfo listInfo;
        if (iModelDelegate == null || (listInfo = iModelDelegate.getListInfo(this, z, i)) == null) {
            return null;
        }
        listInfo.itemInfoList = iModelDelegate.getItemInfo(this);
        return listInfo;
    }

    public String getNavString(int i) {
        Context context = this.f31409a;
        return context != null ? context.getResources().getString(i) : "";
    }

    public Drawable getNavDrawable(int i) {
        Context context = this.f31409a;
        if (context != null) {
            return context.getResources().getDrawable(i);
        }
        return null;
    }

    public int getNavTextColor(int i) {
        Context context = this.f31409a;
        if (context != null) {
            return context.getResources().getColor(i);
        }
        return -1;
    }

    public MapSettingAppInfo getAppInfoByIndex(MapSettingListInfo mapSettingListInfo, int i) {
        List<MapSettingItemInfo> list;
        MapSettingItemInfo mapSettingItemInfo;
        if (mapSettingListInfo == null || (list = mapSettingListInfo.itemInfoList) == null || (mapSettingItemInfo = list.get(i)) == null) {
            return null;
        }
        return mapSettingItemInfo.appInfo;
    }

    public MapSettingAppInfo getMapSettingAppInfo(String str) {
        if (this.f31410b == null || this.f31411c == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (ResolveInfo next : this.f31411c) {
            if (!(next == null || next.activityInfo == null)) {
                String str2 = next.activityInfo.packageName;
                if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str)) {
                    String str3 = next.activityInfo.name;
                    MapSettingAppInfo mapSettingAppInfo = new MapSettingAppInfo();
                    mapSettingAppInfo.appLabel = (String) next.loadLabel(this.f31410b);
                    mapSettingAppInfo.pkgName = str2;
                    mapSettingAppInfo.appIcon = next.loadIcon(this.f31410b);
                    mapSettingAppInfo.activityName = str3;
                    return mapSettingAppInfo;
                }
            }
        }
        return null;
    }
}
