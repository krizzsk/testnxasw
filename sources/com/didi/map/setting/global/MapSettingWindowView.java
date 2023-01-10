package com.didi.map.setting.global;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.map.setting.common.MapSettingNavInfo;
import com.didi.map.setting.common.MapSettingOmega;
import com.didi.map.setting.common.MapSettingViewUtils;
import com.didi.map.setting.common.apollo.MapSettingApolloUtil;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.map.setting.global.NavListView;
import com.didi.map.setting.global.diversion.NavDiversionPloyImpl;
import com.didi.map.setting.widget.SimpleDialog;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class MapSettingWindowView implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IMapSettingPreferences f31451a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f31452b;

    /* renamed from: c */
    private NavListView f31453c;

    /* renamed from: d */
    private List<MapSettingAppInfo> f31454d;

    /* renamed from: e */
    private ImageView f31455e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f31456f;

    /* renamed from: g */
    private FrameLayout f31457g;

    /* renamed from: h */
    private ViewStub f31458h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Context f31459i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public MapSettingNavInfo f31460j;

    /* renamed from: k */
    private View f31461k;

    /* renamed from: l */
    private SimpleDialog f31462l;

    /* renamed from: m */
    private BroadcastReceiver f31463m = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equalsIgnoreCase(MapSettingNavConstant.BROAD_CAST_TAG)) {
                MapSettingWindowView.this.hide();
            }
        }
    };

    public MapSettingWindowView(Context context) {
        this.f31459i = context;
        this.f31451a = MapSettingFactory.createMapPreferences(context);
    }

    public void setParentView(ViewGroup viewGroup) {
        this.f31452b = viewGroup;
    }

    public void setNavInfo(MapSettingNavInfo mapSettingNavInfo) {
        this.f31460j = mapSettingNavInfo;
    }

    public void show() {
        show(false, true);
    }

    public void show(boolean z) {
        show(z, false);
    }

    public void show(final boolean z, final boolean z2) {
        if (this.f31461k == null && this.f31452b != null) {
            DLog.m23976d("showNavList", new Object[0]);
            this.f31461k = LayoutInflater.from(this.f31452b.getContext()).inflate(R.layout.map_setting_window_view_layout, (ViewGroup) null);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.f31456f = this.f31451a.getNavRemember();
            ViewStub viewStub = (ViewStub) this.f31461k.findViewById(R.id.map_setting_window_title);
            this.f31458h = viewStub;
            viewStub.setLayoutResource(R.layout.map_setting_window_title_one);
            this.f31458h.inflate();
            ImageView imageView = (ImageView) this.f31461k.findViewById(R.id.map_setting_view_remember_nav);
            this.f31455e = imageView;
            imageView.setOnClickListener(this);
            RelativeLayout relativeLayout = (RelativeLayout) this.f31461k.findViewById(R.id.map_setting_remember_container);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.f31461k.findViewById(R.id.map_setting_title_container);
            if (z) {
                relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, MapSettingViewUtils.dp2px(this.f31452b.getContext(), 60.0f)));
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, MapSettingViewUtils.dp2px(this.f31452b.getContext(), 60.0f)));
                relativeLayout.setVisibility(8);
            } else {
                relativeLayout.setVisibility(0);
            }
            this.f31453c = (NavListView) this.f31461k.findViewById(R.id.nav_list);
            this.f31457g = (FrameLayout) this.f31461k.findViewById(R.id.map_setting_window_close);
            this.f31461k.findViewById(R.id.shade_view).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    MapSettingWindowView.this.hide();
                }
            });
            List<MapSettingAppInfo> installedThirdNav = MapSettingNavUtils.getInstalledThirdNav(this.f31459i, z);
            this.f31454d = installedThirdNav;
            if (installedThirdNav == null || !installedThirdNav.isEmpty()) {
                String navSelectedPath = this.f31451a.getNavSelectedPath();
                if (!z && this.f31456f && !TextUtils.isEmpty(navSelectedPath) && !MapSettingUtils.isContainMap(this.f31454d, navSelectedPath)) {
                    this.f31451a.setNavRemember(false);
                    this.f31451a.setNavSelectedPath("");
                    this.f31456f = false;
                }
                NavListView navListView = this.f31453c;
                List<MapSettingAppInfo> list = this.f31454d;
                MapSettingNavInfo mapSettingNavInfo = this.f31460j;
                navListView.initListData(list, mapSettingNavInfo != null && mapSettingNavInfo.needDiversion);
                this.f31453c.setOnItemClickListener(new NavListView.OnItemClickListener() {
                    public void onItemClick(final MapSettingAppInfo mapSettingAppInfo, int i) {
                        if (mapSettingAppInfo != null) {
                            boolean z = false;
                            if (MapSettingNavConstant.LOCAL_GOOGLE_NAVI.equals(mapSettingAppInfo.pkgName) || MapSettingUtils.isInstalledApp(MapSettingWindowView.this.f31459i, mapSettingAppInfo.pkgName)) {
                                if (MapSettingWindowView.this.f31460j != null && MapSettingWindowView.this.f31456f && z2) {
                                    MapSettingWindowView.this.f31451a.setNavRemember(true);
                                    MapSettingWindowView.this.f31451a.setNavSelectedPath(mapSettingAppInfo.pkgName);
                                    TraceEvent.trackRememberNav(true, mapSettingAppInfo.pkgName, MapSettingWindowView.this.f31460j.isHawaii);
                                }
                                if (!z && MapSettingApolloUtil.isAutoOpenNav() && MapSettingWindowView.this.f31451a != null && !TextUtils.isEmpty(mapSettingAppInfo.pkgName) && !MapSettingWindowView.this.f31451a.hasUserSettingNav()) {
                                    if (mapSettingAppInfo.pkgName.equals(MapSettingWindowView.this.f31451a.getLastSelectedNav())) {
                                        MapSettingWindowView.this.f31451a.setNavRemember(true);
                                        MapSettingWindowView.this.f31451a.setNavSelectedPath(mapSettingAppInfo.pkgName);
                                        MapSettingWindowView.this.f31451a.setLastSelectedNav("");
                                        String str = mapSettingAppInfo.pkgName;
                                        if (MapSettingWindowView.this.f31460j != null && MapSettingWindowView.this.f31460j.isHawaii) {
                                            z = true;
                                        }
                                        TraceEvent.trackRememberNav(true, str, z);
                                    } else {
                                        MapSettingWindowView.this.f31451a.setLastSelectedNav(mapSettingAppInfo.pkgName);
                                    }
                                }
                                if (MapSettingNavConstant.YANDEX_MAP.equals(mapSettingAppInfo.pkgName) || (!MapSettingApolloUtil.isShowYandexNavTimes() && MapSettingNavConstant.YANDEX_NAV.equals(mapSettingAppInfo.pkgName))) {
                                    YandexTipsView yandexTipsView = new YandexTipsView(MapSettingWindowView.this.f31459i);
                                    yandexTipsView.setParentView(MapSettingWindowView.this.f31452b);
                                    if (yandexTipsView.show(mapSettingAppInfo.pkgName)) {
                                        yandexTipsView.setOkClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                AutoTrackHelper.trackViewOnClick(view);
                                                MapSettingWindowView.this.m24018a(mapSettingAppInfo);
                                            }
                                        });
                                        MapSettingWindowView.this.hide();
                                        return;
                                    }
                                }
                                MapSettingWindowView.this.hide();
                                MapSettingWindowView.this.m24018a(mapSettingAppInfo);
                                return;
                            }
                            SystemUtils.showToast(Toast.makeText(MapSettingWindowView.this.f31459i, R.string.map_setting_nav_not_install, 0));
                            MapSettingWindowView.this.hide();
                        }
                    }
                });
                this.f31457g.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        MapSettingOmega.add("map_gd_maplist_close_ck").report();
                        MapSettingWindowView.this.hide();
                    }
                });
                LocalBroadcastManager.getInstance(this.f31459i).registerReceiver(this.f31463m, new IntentFilter(MapSettingNavConstant.BROAD_CAST_TAG));
                IMapSettingPreferences iMapSettingPreferences = this.f31451a;
                if (iMapSettingPreferences != null) {
                    iMapSettingPreferences.setWindowShow(true);
                }
                Activity a = m24015a((View) this.f31452b);
                if (a != null) {
                    this.f31461k.setBackgroundColor(0);
                    SimpleDialog simpleDialog = new SimpleDialog(a);
                    this.f31462l = simpleDialog;
                    simpleDialog.setCancelable(true);
                    this.f31462l.setCanceledOnTouchOutside(false);
                    this.f31462l.setContentView(this.f31461k);
                    this.f31462l.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            MapSettingWindowView.this.m24017a(dialogInterface);
                        }
                    });
                    SystemUtils.showDialog(this.f31462l);
                    return;
                }
                this.f31452b.addView(this.f31461k, layoutParams);
                this.f31461k.bringToFront();
                return;
            }
            MapSettingTipActivity.startMapSettingTipActivity(this.f31459i);
            if (this.f31456f && z) {
                this.f31451a.setNavRemember(false);
                this.f31456f = false;
            }
            hide();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m24017a(DialogInterface dialogInterface) {
        if (this.f31462l != null) {
            hide();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24018a(MapSettingAppInfo mapSettingAppInfo) {
        Intent intent;
        MapSettingNavInfo mapSettingNavInfo = this.f31460j;
        if (mapSettingNavInfo == null || !mapSettingNavInfo.isOutNav) {
            intent = new Intent(MapSettingNavConstant.BROAD_SELECTED_NAV_TAG);
        } else {
            intent = new Intent(MapSettingNavConstant.BROAD_SELECTED_OUT_NAV_TAG);
        }
        MapSettingNavInfo mapSettingNavInfo2 = this.f31460j;
        if (!(mapSettingNavInfo2 == null || mapSettingAppInfo == null)) {
            mapSettingNavInfo2.navPath = mapSettingAppInfo.pkgName;
        }
        intent.putExtra(MapSettingNavConstant.SETTING_NAV_SELECTED_KEY, this.f31460j);
        LocalBroadcastManager.getInstance(this.f31459i).sendBroadcast(intent);
        if (mapSettingAppInfo != null) {
            String str = mapSettingAppInfo.navType;
            if (TextUtils.isEmpty(str)) {
                str = MapSettingNavUtils.getNavTypeByPkgName(mapSettingAppInfo.pkgName);
            }
            NavDiversionPloyImpl.newInstance(this.f31459i).startNav(str);
        }
    }

    /* renamed from: a */
    private Activity m24015a(View view) {
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            Context context = ((ViewGroup) parent).getContext();
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public void hide() {
        DLog.m23976d("hideNavList  Dialog = " + this.f31462l, new Object[0]);
        Context context = this.f31459i;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f31463m);
        }
        try {
            if (!(this.f31452b == null || this.f31461k == null)) {
                this.f31452b.removeView(this.f31461k);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        IMapSettingPreferences iMapSettingPreferences = this.f31451a;
        if (iMapSettingPreferences != null) {
            iMapSettingPreferences.setWindowShow(false);
        }
        try {
            if (this.f31462l != null) {
                this.f31462l.dismiss();
                this.f31462l = null;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f31461k = null;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.map_setting_view_remember_nav) {
            boolean z = !this.f31456f;
            this.f31456f = z;
            if (z) {
                this.f31455e.setImageResource(R.drawable.map_setting_switch_on);
            } else {
                this.f31455e.setImageResource(R.drawable.map_setting_switch_off);
            }
        }
    }
}
