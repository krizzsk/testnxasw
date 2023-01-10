package com.didi.map.setting.global;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingBaseActivity;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.map.setting.global.MapSettingSelectedView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class MapSettingSelectedActivity extends MapSettingBaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MapSettingSelectedView f31433a;

    /* renamed from: b */
    private ImageView f31434b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<MapSettingAppInfo> f31435c;

    protected static void startSelectedActivity(MapSettingNavigationActivity mapSettingNavigationActivity) {
        DLog.m23976d("showSettingPage2", new Object[0]);
        mapSettingNavigationActivity.startActivity(new Intent(mapSettingNavigationActivity, MapSettingSelectedActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.map_setting_selected_layout);
        findViewById(R.id.map_setting_title_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingSelectedActivity.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.map_setting_title_text)).setText(getResources().getString(R.string.map_setting_selected_title));
        this.f31433a = (MapSettingSelectedView) findViewById(R.id.map_setting_nav_selected_group);
        ImageView imageView = (ImageView) findViewById(R.id.map_setting_remember_nav);
        this.f31434b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (MapSettingSelectedActivity.this.f31435c == null || !MapSettingSelectedActivity.this.f31435c.isEmpty()) {
                    view.setSelected(!view.isSelected());
                    if (!view.isSelected()) {
                        TraceEvent.trackRememberNav(false, "", false);
                    }
                    if (MapSettingSelectedActivity.this.mPreferences != null) {
                        MapSettingSelectedActivity.this.mPreferences.setNavRemember(view.isSelected());
                    }
                    MapSettingSelectedActivity.this.f31433a.rememberChange(view.isSelected());
                    return;
                }
                MapSettingTipActivity.startMapSettingTipActivity(MapSettingSelectedActivity.this);
                if (MapSettingSelectedActivity.this.mPreferences != null) {
                    MapSettingSelectedActivity.this.mPreferences.setNavRemember(false);
                }
                view.setSelected(false);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f31435c = MapSettingNavUtils.getInstalledThirdNav(this);
        boolean navRemember = this.mPreferences.getNavRemember();
        List<MapSettingAppInfo> list = this.f31435c;
        if (list == null || list.isEmpty()) {
            this.f31434b.setSelected(false);
            if (this.mPreferences != null && navRemember) {
                this.mPreferences.setNavRemember(false);
            }
        } else if (this.mPreferences != null && TextUtils.isEmpty(this.mPreferences.getNavSelectedPath()) && navRemember) {
            this.f31434b.setSelected(false);
            this.mPreferences.setNavRemember(false);
        } else if (this.mPreferences != null) {
            if (MapSettingUtils.isContainMap(this.f31435c, this.mPreferences.getNavSelectedPath()) || !navRemember) {
                this.f31434b.setSelected(this.mPreferences.getNavRemember());
            } else {
                this.f31434b.setSelected(false);
                this.mPreferences.setNavRemember(false);
                this.mPreferences.setNavSelectedPath("");
            }
        }
        if (this.mPreferences != null) {
            this.f31433a.initListData(this.f31435c, this.mPreferences);
        }
        this.f31433a.setOnItemClickListener(new MapSettingSelectedView.OnItemClickListener() {
            public final void onItemClick(MapSettingAppInfo mapSettingAppInfo, int i) {
                MapSettingSelectedActivity.this.m23994a(mapSettingAppInfo, i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23994a(MapSettingAppInfo mapSettingAppInfo, int i) {
        if (this.mPreferences != null) {
            this.mPreferences.setNavSelectedPath(mapSettingAppInfo.pkgName);
            TraceEvent.trackRememberNav(true, mapSettingAppInfo.pkgName, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MapSettingSelectedView mapSettingSelectedView = this.f31433a;
        if (mapSettingSelectedView != null) {
            mapSettingSelectedView.clearData();
            this.f31433a.setOnItemClickListener((MapSettingSelectedView.OnItemClickListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        List<MapSettingAppInfo> list = this.f31435c;
        if (list != null) {
            list.clear();
            this.f31435c = null;
        }
        super.onDestroy();
    }
}
