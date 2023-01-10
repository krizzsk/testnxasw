package com.didi.map.global.component.trafficreport.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.common.map.util.DLog;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.map.global.component.trafficreport.map.ReportLocMapView;
import com.didi.map.global.component.trafficreport.model.ReportItem;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class TrafficReportActivity extends AppCompatActivity implements BackHandledInterface {

    /* renamed from: a */
    private static final String f28732a = "TrafficReportActivity";

    /* renamed from: d */
    private static WeakReference<ReportCenterView> f28733d;

    /* renamed from: b */
    private ReportItem f28734b;

    /* renamed from: c */
    private String f28735c;
    public BaseFragment mCurrentFragment;

    public static void startTrafficReportActivity(Context context, WeakReference<ReportCenterView> weakReference, ReportItem reportItem, String str) {
        if (context != null) {
            f28733d = weakReference;
            Intent intent = new Intent();
            intent.setClass(context, TrafficReportActivity.class);
            intent.putExtra("request_data", reportItem);
            intent.putExtra("request_orderId", str);
            context.startActivity(intent);
            return;
        }
        DLog.m10773d(f28732a, "startContributionActivity fail: param error", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        try {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null)) {
                window.clearFlags(201326592);
                window.getDecorView().setSystemUiVisibility(1280);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(getResources().getColor(R.color.traffic_report_light_gray));
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 8192);
                }
            }
        } catch (Exception unused) {
            DLog.m10773d(f28732a, "set status bar style exception", new Object[0]);
        }
        if (getIntent() != null) {
            this.f28734b = (ReportItem) getIntent().getExtras().get("request_data");
            this.f28735c = (String) getIntent().getExtras().get("request_orderId");
        }
        if (bundle == null) {
            m22371a();
            setContentView((int) R.layout.layout_report_detail_activity);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* renamed from: a */
    private void m22371a() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        ReportDetailFragment reportDetailFragment = new ReportDetailFragment();
        Bundle bundle = new Bundle();
        ReportItem reportItem = this.f28734b;
        if (reportItem != null) {
            bundle.putSerializable("request_data", reportItem);
        }
        String str = this.f28735c;
        if (str != null) {
            bundle.putString("request_orderId", str);
        }
        reportDetailFragment.setArguments(bundle);
        beginTransaction.replace(R.id.fragment, reportDetailFragment, reportDetailFragment.getClass().getName());
        getSupportFragmentManager().popBackStackImmediate((String) null, 1);
        beginTransaction.commitAllowingStateLoss();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ReportLocMapView.getInstance(this).onResume();
    }

    public void onPause() {
        super.onPause();
        ReportLocMapView.getInstance(this).onPause();
    }

    public void onStart() {
        super.onStart();
        ReportLocMapView.getInstance(this).onStart();
    }

    public void onStop() {
        super.onStop();
        ReportLocMapView.getInstance(this).onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ReportLocMapView.getInstance(this).onDestroy();
    }

    public void onBackPressed() {
        BaseFragment baseFragment = this.mCurrentFragment;
        if (baseFragment == null || !baseFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void setSelectedFragment(BaseFragment baseFragment) {
        this.mCurrentFragment = baseFragment;
    }

    public void onConfirmPressed() {
        WeakReference<ReportCenterView> weakReference = f28733d;
        if (!(weakReference == null || weakReference.get() == null || ((ReportCenterView) f28733d.get()).mPresenter == null)) {
            ((ReportCenterView) f28733d.get()).mPresenter.onViewClose(1);
        }
        finish();
    }
}
