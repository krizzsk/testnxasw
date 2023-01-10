package com.didi.map.setting.global;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingBaseActivity;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.map.setting.common.MapSettingNavInfo;
import com.didi.map.setting.common.MapSettingOmega;
import com.didi.map.setting.common.MapSettingViewUtils;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.map.setting.global.NavListView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class MapSettingWindowActivity extends MapSettingBaseActivity implements View.OnClickListener {

    /* renamed from: a */
    private NavListView f31439a;

    /* renamed from: b */
    private List<MapSettingAppInfo> f31440b;

    /* renamed from: c */
    private FrameLayout f31441c;

    /* renamed from: d */
    private ViewStub f31442d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MapSettingNavInfo f31443e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f31444f;

    /* renamed from: g */
    private ImageView f31445g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f31446h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f31447i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f31448j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f31449k;

    /* renamed from: l */
    private BroadcastReceiver f31450l = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && MapSettingNavConstant.BROAD_CAST_TAG.equalsIgnoreCase(intent.getAction())) {
                MapSettingWindowActivity.this.finish();
            }
        }
    };

    public static void startMapSettingWindowActivity(Context context, MapSettingNavInfo mapSettingNavInfo) {
        try {
            Intent intent = new Intent(context, MapSettingWindowActivity.class);
            intent.putExtra(MapSettingNavConstant.SETTING_NAV_SELECTED_KEY, mapSettingNavInfo);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.map_setting_window_layout);
        this.f31444f = this;
        this.f31447i = findViewById(R.id.map_setting_window_layout);
        View findViewById = findViewById(R.id.yandex_tip_layout);
        this.f31448j = findViewById;
        View findViewById2 = findViewById.findViewById(R.id.yandex_tip_confirm_btn);
        this.f31449k = findViewById2;
        findViewById2.setOnClickListener(this);
        this.f31442d = (ViewStub) findViewById(R.id.map_setting_window_title);
        if (getIntent() != null) {
            this.f31443e = (MapSettingNavInfo) getIntent().getParcelableExtra(MapSettingNavConstant.SETTING_NAV_SELECTED_KEY);
        }
        this.f31442d.setLayoutResource(R.layout.map_setting_window_title_one);
        View inflate = this.f31442d.inflate();
        if (this.mPreferences != null) {
            this.f31446h = this.mPreferences.getNavRemember();
        }
        ImageView imageView = (ImageView) findViewById(R.id.map_setting_view_remember_nav);
        this.f31445g = imageView;
        imageView.setOnClickListener(this);
        this.f31439a = (NavListView) findViewById(R.id.map_setting_window_view);
        this.f31441c = (FrameLayout) findViewById(R.id.map_setting_window_close);
        MapSettingNavInfo mapSettingNavInfo = this.f31443e;
        if (mapSettingNavInfo != null && mapSettingNavInfo.shouldHideRememberNavType) {
            this.f31446h = false;
            if (inflate != null) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.map_setting_remember_container);
                ((RelativeLayout) inflate.findViewById(R.id.map_setting_title_container)).setLayoutParams(new RelativeLayout.LayoutParams(-1, MapSettingViewUtils.dp2px(this, 60.0f)));
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, MapSettingViewUtils.dp2px(this, 60.0f)));
                relativeLayout.setVisibility(8);
            }
        }
        findViewById(R.id.shade_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingWindowActivity.this.onBackPressed();
            }
        });
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f31450l, new IntentFilter(MapSettingNavConstant.BROAD_CAST_TAG));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MapSettingNavInfo mapSettingNavInfo = this.f31443e;
        if (mapSettingNavInfo != null) {
            if (mapSettingNavInfo.shouldExcludeInnerNav) {
                this.f31440b = MapSettingNavUtils.getInstalledThirdNav(this, true);
            } else {
                this.f31440b = MapSettingNavUtils.getInstalledThirdNav(this);
            }
            List<MapSettingAppInfo> list = this.f31440b;
            if (list == null || !list.isEmpty()) {
                String navSelectedPath = this.mPreferences.getNavSelectedPath();
                if (!this.f31443e.shouldExcludeInnerNav && !MapSettingUtils.isContainMap(this.f31440b, navSelectedPath)) {
                    this.mPreferences.setNavRemember(false);
                    this.mPreferences.setNavSelectedPath("");
                }
                this.f31439a.initListData(this.f31440b, false);
                this.f31439a.setOnItemClickListener(new NavListView.OnItemClickListener() {
                    public void onItemClick(MapSettingAppInfo mapSettingAppInfo, int i) {
                        if (mapSettingAppInfo != null) {
                            if (MapSettingNavConstant.LOCAL_GOOGLE_NAVI.equals(mapSettingAppInfo.pkgName) || MapSettingUtils.isInstalledApp(MapSettingWindowActivity.this.f31444f, mapSettingAppInfo.pkgName)) {
                                if (MapSettingWindowActivity.this.f31443e != null && MapSettingWindowActivity.this.f31446h) {
                                    MapSettingWindowActivity.this.mPreferences.setNavRemember(true);
                                    MapSettingWindowActivity.this.mPreferences.setNavSelectedPath(mapSettingAppInfo.pkgName);
                                    TraceEvent.trackRememberNav(true, mapSettingAppInfo.pkgName, MapSettingWindowActivity.this.f31443e.isHawaii);
                                }
                                if (MapSettingNavConstant.YANDEX_MAP.equalsIgnoreCase(mapSettingAppInfo.pkgName)) {
                                    if (!MapSettingWindowActivity.this.mPreferences.hasShowYandexMapTips()) {
                                        MapSettingWindowActivity.this.f31447i.setVisibility(8);
                                        MapSettingWindowActivity.this.f31448j.setVisibility(0);
                                        MapSettingWindowActivity.this.f31449k.setTag(mapSettingAppInfo.pkgName);
                                        MapSettingWindowActivity.this.mPreferences.setShowYandexMapTips(true);
                                        return;
                                    }
                                } else if (MapSettingNavConstant.YANDEX_NAV.equalsIgnoreCase(mapSettingAppInfo.pkgName) && !MapSettingWindowActivity.this.mPreferences.hasShowYandexNavTips()) {
                                    MapSettingWindowActivity.this.f31447i.setVisibility(8);
                                    MapSettingWindowActivity.this.f31448j.setVisibility(0);
                                    MapSettingWindowActivity.this.f31449k.setTag(mapSettingAppInfo.pkgName);
                                    MapSettingWindowActivity.this.mPreferences.setShowYandexNavTips(true);
                                    return;
                                }
                                if (mapSettingAppInfo != null) {
                                    MapSettingWindowActivity.this.m24003a(mapSettingAppInfo.pkgName);
                                    return;
                                }
                                return;
                            }
                            SystemUtils.showToast(Toast.makeText(MapSettingWindowActivity.this.f31444f, R.string.map_setting_nav_not_install, 0));
                            MapSettingWindowActivity.this.onBackPressed();
                        }
                    }
                });
                this.f31441c.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        MapSettingWindowActivity.this.onBackPressed();
                        MapSettingOmega.add("map_gd_maplist_close_ck").report();
                    }
                });
                if (this.mPreferences != null) {
                    this.mPreferences.setWindowShow(true);
                    return;
                }
                return;
            }
            MapSettingTipActivity.startMapSettingTipActivity(this);
            this.mPreferences.setNavRemember(false);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f31450l);
        if (this.mPreferences != null) {
            this.mPreferences.setWindowShow(false);
        }
    }

    public void onBackPressed() {
        if (this.mPreferences != null) {
            this.mPreferences.setWindowShow(false);
        }
        super.onBackPressed();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.map_setting_view_remember_nav) {
            boolean z = !this.f31446h;
            this.f31446h = z;
            if (z) {
                this.f31445g.setImageResource(R.drawable.map_setting_switch_on);
            } else {
                this.f31445g.setImageResource(R.drawable.map_setting_switch_off);
            }
        } else if (view.getId() == R.id.yandex_tip_confirm_btn) {
            m24003a(this.f31449k.getTag().toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24003a(String str) {
        Intent intent;
        MapSettingNavInfo mapSettingNavInfo = this.f31443e;
        if (mapSettingNavInfo == null || !mapSettingNavInfo.isOutNav) {
            intent = new Intent(MapSettingNavConstant.BROAD_SELECTED_NAV_TAG);
        } else {
            intent = new Intent(MapSettingNavConstant.BROAD_SELECTED_OUT_NAV_TAG);
        }
        MapSettingNavInfo mapSettingNavInfo2 = this.f31443e;
        if (mapSettingNavInfo2 != null) {
            mapSettingNavInfo2.navPath = str;
        }
        intent.putExtra(MapSettingNavConstant.SETTING_NAV_SELECTED_KEY, this.f31443e);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        onBackPressed();
    }
}
