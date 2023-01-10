package com.didi.globalsafetoolkit.business.monitor;

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
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.globalsafetoolkit.imageloader.SfImageLoaderHolder;
import com.didi.globalsafetoolkit.omega.SfOmegaUtil;
import com.didi.globalsafetoolkit.util.SfAppUtils;
import com.didi.globalsafetoolkit.util.SfListenerManager;
import com.didi.globalsafetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class MonitorActivity extends BaseActivityWithUIStuff {
    public static final String MONITOR_STATE = "monitor_state";

    /* renamed from: a */
    private View f25052a;

    /* renamed from: b */
    private TextView f25053b;

    /* renamed from: c */
    private ImageView f25054c;

    /* renamed from: d */
    private TextView f25055d;

    /* renamed from: e */
    private TextView f25056e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Switch f25057f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SfViewMonitorMenuModel f25058g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f25059h;

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
        this.f25052a = findViewById(R.id.iv_monitor_back);
        this.f25053b = (TextView) findViewById(R.id.sf_monitor_title);
        this.f25054c = (ImageView) findViewById(R.id.sf_monitor_img);
        this.f25055d = (TextView) findViewById(R.id.sf_monitor_content);
        this.f25056e = (TextView) findViewById(R.id.sf_monitor_bottom_tv);
        this.f25057f = (Switch) findViewById(R.id.sf_monitor_switch);
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        try {
            StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f25058g = (SfViewMonitorMenuModel) getIntent().getSerializableExtra("monitor_state");
        SfListenerManager.setMonitorUpdateListener(new SfListenerManager.MonitorDataUpdateListener() {
            public void monitorUpdate(SfViewMonitorMenuModel sfViewMonitorMenuModel) {
                MonitorActivity.this.m20066a(sfViewMonitorMenuModel);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initData() {
        m20066a(this.f25058g);
        if (this.f25058g != null) {
            SfOmegaUtil.OmgEventAdder addEventId = SfOmegaUtil.addEventId("user_safetyMonitoring_view_sw");
            addEventId.addKeyValue("type", Integer.valueOf(this.f25058g.isMonitoring ? 2 : 1));
            if (this.f25058g.driverData != null) {
                addEventId.addKeyValue("order_id", this.f25058g.driverData.orderId);
                addEventId.addKeyValue("trip_id", this.f25058g.driverData.tripId);
            }
            addEventId.report();
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f25052a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MonitorActivity.this.onBackPressed();
            }
        });
        this.f25057f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                if (compoundButton.isPressed()) {
                    MonitorActivity.this.m20067a(z);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20066a(SfViewMonitorMenuModel sfViewMonitorMenuModel) {
        if (sfViewMonitorMenuModel != null) {
            this.f25059h = sfViewMonitorMenuModel.canMonitor;
            this.f25053b.setText(sfViewMonitorMenuModel.pageTitle);
            this.f25056e.setText(sfViewMonitorMenuModel.monitorStateText);
            this.f25055d.setText(sfViewMonitorMenuModel.monitorDesc);
            this.f25057f.setChecked(sfViewMonitorMenuModel.canMonitor);
            SfImageLoaderHolder.getInstance(this).loadInto(sfViewMonitorMenuModel.imgUrl, this.f25054c, SfAppUtils.isBrazilPackage(this) ? R.drawable.sf_center_place_holder_4_99 : R.drawable.sf_center_place_holder);
            if (!(sfViewMonitorMenuModel.driverData == null || -1 == sfViewMonitorMenuModel.driverData.thumbId)) {
                this.f25057f.setThumbResource(sfViewMonitorMenuModel.driverData.thumbId);
            }
            if (sfViewMonitorMenuModel.driverData != null && -1 != sfViewMonitorMenuModel.driverData.trackId) {
                this.f25057f.setTrackResource(sfViewMonitorMenuModel.driverData.trackId);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20067a(final boolean z) {
        int i = z ? 1 : 2;
        SystemUtils.log(4, "mMonitorSwitch", "onCheckedChanged: " + i, (Throwable) null, "com.didi.globalsafetoolkit.business.monitor.MonitorActivity", 148);
        GlobalSfManager.getInstance().reportMonitorState(this, 1, i, new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                try {
                    JSONObject jSONObject = new JSONObject(jsonObject.toString());
                    if (jSONObject.getInt("errno") != 0) {
                        MonitorActivity.this.f25057f.setChecked(MonitorActivity.this.f25059h);
                        ToastHelper.showShortInfo(MonitorActivity.this.getContext(), jSONObject.getString("errmsg"));
                        return;
                    }
                    boolean unused = MonitorActivity.this.f25059h = z;
                    SfOmegaUtil.OmgEventAdder addEventId = SfOmegaUtil.addEventId("user_safetyMonitoring_notification_change");
                    addEventId.addKeyValue("status", MonitorActivity.this.f25059h ? "open" : "close");
                    if (MonitorActivity.this.f25058g.driverData != null) {
                        addEventId.addKeyValue("order_id", MonitorActivity.this.f25058g.driverData.orderId);
                        addEventId.addKeyValue("trip_id", MonitorActivity.this.f25058g.driverData.tripId);
                    }
                    addEventId.report();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(IOException iOException) {
                MonitorActivity.this.f25057f.setChecked(MonitorActivity.this.f25059h);
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
                monitorActivity.m20066a(sfViewMonitorMenuModel);
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
