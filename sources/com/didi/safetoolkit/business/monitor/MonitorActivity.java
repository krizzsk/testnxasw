package com.didi.safetoolkit.business.monitor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.android.didi.safetoolkit.activity.BaseActivityWithUIStuff;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.api.ISMonitorDetailsService;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.imageloader.SfImageLoaderHolder;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.util.SfAppUtils;
import com.didi.safetoolkit.util.SfListenerManager;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class MonitorActivity extends BaseActivityWithUIStuff {
    public static final String MONITOR_STATE = "monitor_state";

    /* renamed from: a */
    private View f37158a;

    /* renamed from: b */
    private TextView f37159b;

    /* renamed from: c */
    private ImageView f37160c;

    /* renamed from: d */
    private TextView f37161d;

    /* renamed from: e */
    private TextView f37162e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Switch f37163f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ISMonitorDetailsService f37164g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfViewMonitorMenuModel f37165h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f37166i;

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_common_dialog_monitor_activity;
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f37158a = findViewById(R.id.iv_monitor_back);
        this.f37159b = (TextView) findViewById(R.id.sf_monitor_title);
        this.f37160c = (ImageView) findViewById(R.id.sf_monitor_img);
        this.f37161d = (TextView) findViewById(R.id.sf_monitor_content);
        this.f37162e = (TextView) findViewById(R.id.sf_monitor_bottom_tv);
        this.f37163f = (Switch) findViewById(R.id.sf_monitor_switch);
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        try {
            StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f37164g = (ISMonitorDetailsService) ServiceLoader.load(ISMonitorDetailsService.class, SafeToolKit.getIns().getBusinessType()).get();
        this.f37165h = (SfViewMonitorMenuModel) getIntent().getSerializableExtra("monitor_state");
        SfListenerManager.setMonitorUpdateListener(new SfListenerManager.MonitorDataUpdateListener() {
            public void monitorUpdate(SfViewMonitorMenuModel sfViewMonitorMenuModel) {
                MonitorActivity.this.m28051a(sfViewMonitorMenuModel);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initData() {
        m28051a(this.f37165h);
        if (this.f37165h != null) {
            SfOmegaUtil.OmgEventAdder addEventId = SfOmegaUtil.addEventId("user_safetyMonitoring_view_sw");
            addEventId.addKeyValue("type", Integer.valueOf(this.f37165h.isMonitoring ? 2 : 1));
            if (this.f37165h.driverData != null) {
                addEventId.addKeyValue("order_id", this.f37165h.driverData.orderId);
                addEventId.addKeyValue("trip_id", this.f37165h.driverData.tripId);
            }
            addEventId.report();
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f37158a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MonitorActivity.this.onBackPressed();
            }
        });
        this.f37163f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                if (MonitorActivity.this.f37164g != null && compoundButton.isPressed()) {
                    MonitorActivity.this.m28052a(z);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28051a(SfViewMonitorMenuModel sfViewMonitorMenuModel) {
        if (sfViewMonitorMenuModel != null) {
            this.f37166i = sfViewMonitorMenuModel.canMonitor;
            this.f37159b.setText(sfViewMonitorMenuModel.pageTitle);
            this.f37162e.setText(sfViewMonitorMenuModel.monitorStateText);
            this.f37161d.setText(sfViewMonitorMenuModel.monitorDesc);
            this.f37163f.setChecked(sfViewMonitorMenuModel.canMonitor);
            SfImageLoaderHolder.getInstance(this).loadInto(sfViewMonitorMenuModel.imgUrl, this.f37160c, SfAppUtils.isBrazilPackage(this) ? R.drawable.sf_center_place_holder_4_99 : R.drawable.sf_center_place_holder);
            if (!(sfViewMonitorMenuModel.driverData == null || -1 == sfViewMonitorMenuModel.driverData.thumbId)) {
                this.f37163f.setThumbResource(sfViewMonitorMenuModel.driverData.thumbId);
            }
            if (sfViewMonitorMenuModel.driverData != null && -1 != sfViewMonitorMenuModel.driverData.trackId) {
                this.f37163f.setTrackResource(sfViewMonitorMenuModel.driverData.trackId);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28052a(final boolean z) {
        this.f37164g.reportMonitorState(this, 1, z ? 1 : 2, new ISMonitorCallback() {
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getInt("errno") != 0) {
                        MonitorActivity.this.f37163f.setChecked(MonitorActivity.this.f37166i);
                        ToastHelper.showShortInfo(MonitorActivity.this.getContext(), jSONObject.getString("errmsg"));
                        return;
                    }
                    boolean unused = MonitorActivity.this.f37166i = z;
                    MonitorActivity.this.f37164g.refreshBubbleInfo(new MonitorConfigCallback(MonitorActivity.this));
                    SfOmegaUtil.OmgEventAdder addEventId = SfOmegaUtil.addEventId("user_safetyMonitoring_notification_change");
                    addEventId.addKeyValue("status", MonitorActivity.this.f37166i ? "open" : "close");
                    if (MonitorActivity.this.f37165h.driverData != null) {
                        addEventId.addKeyValue("order_id", MonitorActivity.this.f37165h.driverData.orderId);
                        addEventId.addKeyValue("trip_id", MonitorActivity.this.f37165h.driverData.tripId);
                    }
                    addEventId.report();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFailed(Exception exc) {
                MonitorActivity.this.f37163f.setChecked(MonitorActivity.this.f37166i);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        SfListenerManager.removeMonitorUpdateListener();
    }

    private static class MonitorConfigCallback implements ISMonitorConfigCallback {
        private MonitorActivity mActivity;
        private WeakReference<MonitorActivity> mReference;

        MonitorConfigCallback(MonitorActivity monitorActivity) {
            this.mReference = new WeakReference<>(monitorActivity);
        }

        public void onSuccess(SfViewMonitorMenuModel sfViewMonitorMenuModel) {
            MonitorActivity monitorActivity = (MonitorActivity) this.mReference.get();
            this.mActivity = monitorActivity;
            if (monitorActivity != null) {
                monitorActivity.m28051a(sfViewMonitorMenuModel);
            }
        }

        public void onFailed(String str) {
            MonitorActivity monitorActivity = this.mActivity;
            if (monitorActivity != null) {
                ToastHelper.showShortInfo((Context) monitorActivity, str);
            }
        }
    }
}
