package com.didi.map.setting.global;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.google.model.OmegaTraceEvent;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingBaseActivity;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.map.setting.common.MapSettingOmega;
import com.didi.map.setting.common.apollo.MapSettingApolloUtil;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.taxis99.R;
import java.util.List;

public class MapSettingNavigationActivity extends MapSettingBaseActivity {

    /* renamed from: a */
    private TextView f31421a;

    /* renamed from: b */
    private ImageView f31422b;

    /* renamed from: c */
    private List<MapSettingAppInfo> f31423c;

    /* renamed from: d */
    private boolean f31424d;

    /* renamed from: e */
    private boolean f31425e;

    /* renamed from: f */
    private LinearLayout f31426f;

    /* renamed from: g */
    private ImageView f31427g;

    /* renamed from: h */
    private View f31428h;

    /* renamed from: i */
    private RelativeLayout f31429i;

    /* renamed from: j */
    private ImageView f31430j;

    /* renamed from: k */
    private boolean f31431k;

    /* renamed from: l */
    private boolean f31432l;

    public static void startMapSettingActivity(Context context) {
        DLog.m23976d("showSettingPage1", new Object[0]);
        context.startActivity(new Intent(context, MapSettingNavigationActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.map_setting_navigation_layout);
        DLog.m23976d("the map_setting_navigation_selected = " + getResources().getString(R.string.map_setting_navigation_selected), new Object[0]);
        findViewById(R.id.map_setting_title_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingNavigationActivity.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.map_setting_title_text)).setText(getResources().getString(R.string.map_setting_navigation_title));
        this.f31422b = (ImageView) findViewById(R.id.map_setting_open_navigation);
        this.f31421a = (TextView) findViewById(R.id.map_setting_nav_text);
        this.f31426f = (LinearLayout) findViewById(R.id.map_setting_nav_voice_layout);
        this.f31427g = (ImageView) findViewById(R.id.map_setting_voice_switch);
        this.f31428h = findViewById(R.id.map_setting_nav_day_night_mode_layout);
        this.f31429i = (RelativeLayout) findViewById(R.id.map_setting_traffic_bar_switch_panel);
        this.f31430j = (ImageView) findViewById(R.id.map_setting_traffic_bar_switch);
        if (Apollo.getToggle("global_driver_android_nav_mute").allow()) {
            this.f31426f.setVisibility(0);
        }
        findViewById(R.id.map_setting_item_nav).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingSelectedActivity.startSelectedActivity(MapSettingNavigationActivity.this);
            }
        });
        if (!MapSettingApolloUtil.getTrafficBarEnable() || this.mPreferences == null || !this.mPreferences.isHawaii()) {
            this.f31429i.setVisibility(8);
        } else {
            this.f31429i.setVisibility(0);
        }
        MapSettingUtils.getCurLan(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f31423c = MapSettingNavUtils.getInstalledThirdNav(this);
        m23988b();
        m23990c();
        m23984a();
        m23992d();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (!(this.mPreferences == null || this.f31424d == this.mPreferences.getNavDefaultOpen())) {
            MapSettingOmega.add("com_mapSet_mrdh_ck").add(ParamKeys.PARAM_RES.PARAM_RES_DRIVERID, Long.valueOf(PlatInfo.getInstance().getDriverId())).add("switch", this.mPreferences.getNavDefaultOpen() ? "true" : SDKConsts.BOOLEAN_FALSE).report();
        }
        if (!(this.mPreferences == null || this.f31425e == this.mPreferences.getInAppNavVoiceOpen())) {
            MapSettingOmega.add("map_setting_voiceSwitch_ck").add(ParamKeys.PARAM_RES.PARAM_RES_DRIVERID, Long.valueOf(PlatInfo.getInstance().getDriverId())).add("state", Integer.valueOf(this.mPreferences.getInAppNavVoiceOpen() ? 1 : 0)).add("time", Long.valueOf(System.currentTimeMillis())).report();
        }
        if (MapSettingApolloUtil.getTrafficBarEnable() && this.mPreferences != null && this.mPreferences.isHawaii() && this.f31432l != this.f31431k) {
            MapSettingOmega.add("map_pub_navi_trafficbar_setting_ck").add("bar_state", Integer.valueOf(this.f31432l ? 1 : 0)).add(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(PlatInfo.getInstance().getDriverId())).add("order_id", "").add("timestamp", Long.valueOf(System.currentTimeMillis())).add(OmegaTraceEvent.CommentParamNames.TRIP_STEP, -1).report();
            DLog.m23976d("MapSettingNavigationActivity", "map_pub_navi_trafficbar_setting_ck reported" + this.f31432l);
        }
        super.onDestroy();
    }

    /* renamed from: a */
    private void m23984a() {
        if (this.mPreferences != null) {
            boolean inAppNavVoiceOpen = this.mPreferences.getInAppNavVoiceOpen();
            this.f31425e = inAppNavVoiceOpen;
            this.f31427g.setSelected(inAppNavVoiceOpen);
        }
        this.f31427g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                view.setSelected(!view.isSelected());
                if (MapSettingNavigationActivity.this.mPreferences != null) {
                    MapSettingNavigationActivity.this.mPreferences.setInAppNavVoiceOpen(view.isSelected());
                }
            }
        });
    }

    /* renamed from: b */
    private void m23988b() {
        if (this.mPreferences != null) {
            boolean navDefaultOpen = this.mPreferences.getNavDefaultOpen();
            this.f31424d = navDefaultOpen;
            this.f31422b.setSelected(navDefaultOpen);
        }
        this.f31422b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                view.setSelected(!view.isSelected());
                if (MapSettingNavigationActivity.this.mPreferences != null) {
                    MapSettingNavigationActivity.this.mPreferences.setNavDefaultOpen(view.isSelected());
                }
            }
        });
    }

    /* renamed from: c */
    private void m23990c() {
        if (this.mPreferences == null || !this.mPreferences.getNavRemember()) {
            m23986a("");
            return;
        }
        String navSelectedPath = this.mPreferences.getNavSelectedPath();
        List<MapSettingAppInfo> list = this.f31423c;
        if (list == null || list.isEmpty()) {
            m23986a("");
        } else {
            m23986a(navSelectedPath);
        }
    }

    /* renamed from: d */
    private void m23992d() {
        if (this.mPreferences != null) {
            boolean shouldShowTrafficStatusBar = this.mPreferences.getShouldShowTrafficStatusBar();
            this.f31431k = shouldShowTrafficStatusBar;
            this.f31432l = shouldShowTrafficStatusBar;
            this.f31430j.setSelected(shouldShowTrafficStatusBar);
        }
        this.f31430j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MapSettingNavigationActivity.this.m23985a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23985a(View view) {
        view.setSelected(!view.isSelected());
        if (this.mPreferences != null) {
            this.f31432l = view.isSelected();
            this.mPreferences.setShouldShowTrafficStatusBar(this.f31432l);
        }
    }

    /* renamed from: a */
    private void m23986a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f31421a.setVisibility(0);
            if (MapSettingNavConstant.LOCAL_GOOGLE_NAVI.equalsIgnoreCase(str)) {
                this.f31421a.setText(getString(R.string.map_setting_navigation_build_in));
                return;
            }
            String isContainPath = MapSettingUtils.isContainPath(this.f31423c, str);
            if (!TextUtils.isEmpty(isContainPath)) {
                this.f31421a.setText(isContainPath);
            } else {
                this.f31421a.setText("");
            }
        } else {
            this.f31421a.setVisibility(4);
        }
    }
}
