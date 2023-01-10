package com.didi.sdk.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.netreceiver.NetWorkReceiver;
import com.didi.sdk.util.Utils;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class NetWorkTitleBar extends LinearLayout {

    /* renamed from: a */
    HashMap<String, Object> f40549a = new HashMap<>();

    /* renamed from: b */
    private final String f40550b = "pas_home_error";

    /* renamed from: c */
    private final String f40551c = "network";

    /* renamed from: d */
    private final String f40552d = "location";

    /* renamed from: e */
    private final String f40553e = "privilege";

    /* renamed from: f */
    private final String f40554f = "notice";

    /* renamed from: g */
    private final String f40555g = "0";

    /* renamed from: h */
    private final String f40556h = "1";

    /* renamed from: i */
    private NetWorkReceiver f40557i = NetWorkReceiver.getInstance();

    /* renamed from: j */
    private TextView f40558j;

    /* renamed from: k */
    private String f40559k;

    /* renamed from: l */
    private String f40560l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Logger f40561m = LoggerFactory.getLogger("NetWorkTitleBar");
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f40562n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public OnViewVisibilityChangeListener f40563o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f40564p = false;

    /* renamed from: q */
    private ILocation.ILocateStatusListener f40565q = new ILocation.ILocateStatusListener() {
        public void onStatusUpdate(String str, int i, String str2) {
            boolean z = false;
            if (1 == i) {
                boolean unused = NetWorkTitleBar.this.f40564p = false;
                NetWorkTitleBar.this.m30468c();
                return;
            }
            NetWorkTitleBar netWorkTitleBar = NetWorkTitleBar.this;
            if (i == 512) {
                z = true;
            }
            boolean unused2 = netWorkTitleBar.f40564p = z;
            NetWorkTitleBar.this.m30468c();
        }
    };

    /* renamed from: r */
    private ILocation.ILocationChangedListener f40566r = new ILocation.ILocationChangedListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            if (!(dIDILocation == null || dIDILocation.getLatitude() == 0.0d || dIDILocation.getLongitude() == 0.0d)) {
                boolean unused = NetWorkTitleBar.this.f40564p = false;
            }
            NetWorkTitleBar.this.m30468c();
        }
    };

    /* renamed from: s */
    private ILocation.ILocationErrorListener f40567s = new ILocation.ILocationErrorListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
            Logger c = NetWorkTitleBar.this.f40561m;
            c.debug("onLocationError var1:" + i + " vvar2:" + errInfo.getErrNo(), new Object[0]);
            if (errInfo.getErrNo() == 101 || errInfo.getErrNo() == 201) {
                boolean unused = NetWorkTitleBar.this.f40564p = true;
                NetWorkTitleBar.this.m30468c();
                return;
            }
            boolean unused2 = NetWorkTitleBar.this.f40564p = false;
            NetWorkTitleBar.this.m30468c();
        }
    };

    /* renamed from: t */
    private NetWorkReceiver.NetWorkChangedListener f40568t = new NetWorkReceiver.NetWorkChangedListener() {
        public void onChanged(int i) {
            boolean unused = NetWorkTitleBar.this.f40562n = i != 0;
            NetWorkTitleBar.this.m30468c();
        }
    };

    public interface OnViewVisibilityChangeListener {
        void onNetWorkStateChanged(View view);
    }

    public void setOnViewVisibilityChangeListener(OnViewVisibilityChangeListener onViewVisibilityChangeListener) {
        this.f40563o = onViewVisibilityChangeListener;
    }

    public NetWorkTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40559k = context.getString(R.string.common_network_disabled);
        this.f40560l = context.getString(R.string.common_location_disabled);
        LayoutInflater.from(getContext()).inflate(R.layout.f_networktitlebar, this, true);
        TextView textView = (TextView) findViewById(R.id.textviewStatus);
        this.f40558j = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NetWorkTitleBar.this.m30470d();
            }
        });
    }

    /* renamed from: a */
    private boolean m30462a() {
        return this.f40564p;
    }

    public void setVisibility(int i) {
        if (i == 0) {
            super.setVisibility(i);
            OnViewVisibilityChangeListener onViewVisibilityChangeListener = this.f40563o;
            if (onViewVisibilityChangeListener != null) {
                onViewVisibilityChangeListener.onNetWorkStateChanged(this);
                return;
            }
            return;
        }
        m30464b();
    }

    /* renamed from: b */
    private void m30464b() {
        if (getVisibility() != 8) {
            clearAnimation();
            AnimationSet animationSet = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(500);
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    NetWorkTitleBar.this.clearAnimation();
                    NetWorkTitleBar.super.setVisibility(8);
                    if (NetWorkTitleBar.this.f40563o != null) {
                        NetWorkTitleBar.this.f40563o.onNetWorkStateChanged(NetWorkTitleBar.this);
                    }
                }
            });
            startAnimation(animationSet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m30468c() {
        boolean isLocatable = LocationPerformer.getInstance().isLocatable();
        Logger logger = this.f40561m;
        logger.info("onStatusChanged: isNetworkEnabled:" + this.f40562n + " isLocationEnabled:  " + isLocatable + "  isGpsDenied:" + this.f40564p, new Object[0]);
        if (!isLocatable && !this.f40562n) {
            this.f40558j.setText(this.f40559k);
            this.f40558j.setBackgroundColor(getResources().getColor(R.color.common_disabled_network));
            setVisibility(0);
            m30461a("1", "1");
            setContentDescription(this.f40559k);
        } else if (!isLocatable && this.f40562n) {
            this.f40558j.setText(this.f40560l);
            this.f40558j.setBackgroundColor(getResources().getColor(R.color.common_disabled_location));
            setVisibility(0);
            m30461a("0", "1");
            setContentDescription(this.f40560l);
        } else if (this.f40562n || !isLocatable) {
            setVisibility(8);
        } else {
            this.f40558j.setText(this.f40559k);
            this.f40558j.setBackgroundColor(getResources().getColor(R.color.common_disabled_network));
            setVisibility(0);
            m30461a("1", "0");
            setContentDescription(this.f40559k);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m30470d() {
        Intent intent = new Intent("android.settings.SETTINGS");
        Context context = getContext();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    private void m30461a(final String str, final String str2) {
        if ("home".equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            final String str3 = this.f40564p ? "1" : "0";
            if (!str3.equals(this.f40549a.get("privilege")) || !str.equals(this.f40549a.get("network")) || !str2.equals(this.f40549a.get("location"))) {
                ApmThreadPool.executeOnSingle(new Runnable() {
                    public void run() {
                        NetWorkTitleBar.this.f40549a.put("network", str);
                        NetWorkTitleBar.this.f40549a.put("location", str2);
                        NetWorkTitleBar.this.f40549a.put("privilege", str3);
                        HashMap<String, Object> hashMap = NetWorkTitleBar.this.f40549a;
                        NetWorkTitleBar netWorkTitleBar = NetWorkTitleBar.this;
                        hashMap.put("notice", Integer.valueOf(netWorkTitleBar.isNotificationAllowed(netWorkTitleBar.getContext())));
                        OmegaSDKAdapter.trackEvent("pas_home_error", (Map<String, Object>) NetWorkTitleBar.this.f40549a);
                        Logger c = NetWorkTitleBar.this.f40561m;
                        c.info("AddLog:" + NetWorkTitleBar.this.f40549a.toString(), new Object[0]);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m30471e();
        NetWorkReceiver.getInstance().register(this.f40568t);
        LocationPerformer.getInstance().addLocateStatusListener(this.f40565q);
        LocationPerformer.getInstance().addLocationErrorListener(this.f40567s);
        LocationPerformer.getInstance().addLocationListener(this.f40566r);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getContext().unregisterReceiver(this.f40557i);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        NetWorkReceiver.getInstance().unRegister(this.f40568t);
        LocationPerformer.getInstance().removeLocateStatusListener(this.f40565q);
        LocationPerformer.getInstance().removeLocationErrorListener(this.f40567s);
        LocationPerformer.getInstance().removeLocationListener(this.f40566r);
    }

    /* renamed from: e */
    private void m30471e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        try {
            getContext().registerReceiver(this.f40557i, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public void refreshOnResume() {
        this.f40562n = Utils.isNetworkConnected(getContext());
        m30468c();
    }

    public int isNotificationAllowed(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled() ^ true ? 1 : 0;
        }
        return 0;
    }
}
