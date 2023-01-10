package com.didi.onehybrid.log;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class FusionDebugActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CheckBox f32092a;

    /* renamed from: b */
    private Button f32093b;

    /* renamed from: c */
    private Button f32094c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_hybrid_debug);
        CheckBox checkBox = (CheckBox) findViewById(R.id.fusion_debug_log_checkBox);
        this.f32092a = checkBox;
        checkBox.setChecked(FusionLogHelper.isFusionLogOpen(this));
        Button button = (Button) findViewById(R.id.fusion_debug_ok_button);
        this.f32093b = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FusionDebugActivity fusionDebugActivity = FusionDebugActivity.this;
                fusionDebugActivity.m24423a(fusionDebugActivity.f32092a.isChecked());
                FusionDebugActivity.this.finish();
            }
        });
        Button button2 = (Button) findViewById(R.id.fusion_debug_cancel_button);
        this.f32094c = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FusionDebugActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24423a(boolean z) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this, "fusionlogpref", 0).edit();
        edit.putBoolean("fusionlog", z);
        edit.commit();
    }
}
