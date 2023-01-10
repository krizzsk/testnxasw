package com.didi.beatles.p101im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.notify.NotificationUtils;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.beatles.p101im.views.titlebar.CommonTitleBar;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.activity.IMSettingsActivity */
public class IMSettingsActivity extends IMBaseActivity implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10856a = IMSettingsActivity.class.getSimpleName();

    /* renamed from: f */
    private static final String f10857f = "page_from";

    /* renamed from: b */
    private CommonTitleBar f10858b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f10859c;

    /* renamed from: d */
    private TextView f10860d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageView f10861e;

    /* renamed from: g */
    private int f10862g = -1;

    public static void startActivity(Context context, int i) {
        Intent intent = new Intent(context, IMSettingsActivity.class);
        intent.putExtra(f10857f, i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.activity_im_settings);
        m9519b();
        m9521d();
        IMTraceUtil.addBusinessEvent("ddim_setting_sw").add("from", Integer.valueOf(this.f10862g)).report();
    }

    /* renamed from: b */
    private void m9519b() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f10862g = intent.getIntExtra(f10857f, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m9520c();
    }

    /* renamed from: c */
    private void m9520c() {
        NotificationUtils.isNotificationEnabled(this, new NotificationUtils.OnIMNotificationEnableCallback() {
            public void onNotificationEnabled(boolean z) {
                IMLog.m10020d(IMSettingsActivity.f10856a, C4786I.m9980t("[onNotificationEnabled] #refreshNotificationSwitch# enable=", Boolean.valueOf(z)));
                if (z) {
                    IMSettingsActivity.this.f10859c.setText(IMSettingsActivity.this.getString(R.string.im_new_msg_notification_open));
                    IMSettingsActivity.this.f10861e.setVisibility(8);
                    return;
                }
                IMSettingsActivity.this.f10859c.setText(IMSettingsActivity.this.getString(R.string.im_new_msg_notification_unopen));
                IMSettingsActivity.this.f10861e.setVisibility(0);
            }
        });
    }

    /* renamed from: d */
    private void m9521d() {
        this.f10858b = (CommonTitleBar) findViewById(R.id.settings_title_bar);
        this.f10859c = (TextView) findViewById(R.id.tv_notification_switch);
        this.f10860d = (TextView) findViewById(R.id.tv_notification_title);
        this.f10861e = (ImageView) findViewById(R.id.iv_notification_red_dot);
        this.f10858b.setTitle(getString(R.string.im_msg_settings));
        this.f10858b.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMSettingsActivity.this.finish();
            }
        });
        this.f10860d.setText(getString(R.string.im_new_msg_notification_settings));
        this.f10859c.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.tv_notification_switch) {
            m9522e();
        }
    }

    /* renamed from: e */
    private void m9522e() {
        IMTraceUtil.addBusinessEvent("ddim_setting_newnotice_ck").report();
        NotificationUtils.isNotificationEnabled(this, new NotificationUtils.OnIMNotificationEnableCallback() {
            public void onNotificationEnabled(boolean z) {
                IMLog.m10020d(IMSettingsActivity.f10856a, C4786I.m9980t("[onNotificationEnabled] #openNotificationSettings# enable=", Boolean.valueOf(z)));
                NotificationUtils.openNotificationSettings(IMSettingsActivity.this);
            }
        });
    }

    /* renamed from: a */
    private void m9517a(String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) "", 0);
        if (Build.VERSION.SDK_INT < 14) {
            makeText.cancel();
        }
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, IMResource.getDrawableID(R.drawable.im_toast_warm));
        IMTipsToast.setText(makeText, str);
    }
}
