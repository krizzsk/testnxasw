package com.didi.map.setting.global;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingFactory;
import com.taxis99.R;

public class MapSettingNavDayNightView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private TextView f31413a;

    /* renamed from: b */
    private TextView f31414b;

    /* renamed from: c */
    private TextView f31415c;

    /* renamed from: d */
    private IMapSettingPreferences f31416d;

    /* renamed from: e */
    private int f31417e;

    public MapSettingNavDayNightView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MapSettingNavDayNightView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapSettingNavDayNightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31417e = -1;
        m23979a();
    }

    /* renamed from: a */
    private void m23979a() {
        LayoutInflater.from(getContext()).inflate(R.layout.map_setting_nav_day_night_layout, this);
        this.f31413a = (TextView) findViewById(R.id.map_setting_nav_day_night_mode_auto);
        this.f31414b = (TextView) findViewById(R.id.map_setting_nav_day_night_mode_day);
        this.f31415c = (TextView) findViewById(R.id.map_setting_nav_day_night_mode_night);
        this.f31413a.setOnClickListener(this);
        this.f31414b.setOnClickListener(this);
        this.f31415c.setOnClickListener(this);
        IMapSettingPreferences createMapPreferences = MapSettingFactory.createMapPreferences(getContext());
        this.f31416d = createMapPreferences;
        int navDayNightMode = createMapPreferences.getNavDayNightMode();
        this.f31413a.setSelected(false);
        this.f31414b.setSelected(false);
        this.f31415c.setSelected(false);
        if (navDayNightMode == 0) {
            this.f31413a.setSelected(true);
        } else if (navDayNightMode == 1) {
            this.f31414b.setSelected(true);
        } else if (navDayNightMode == 2) {
            this.f31415c.setSelected(true);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f31413a) {
            setDayNightMode(0);
        } else if (view == this.f31414b) {
            setDayNightMode(1);
        } else if (view == this.f31415c) {
            setDayNightMode(2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|(3:5|6|7)(4:(1:10)(2:11|(1:13))|15|16|18)|14|15|16|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        if (com.didichuxing.nightmode.sdk.NightModeState.DAY != com.didichuxing.nightmode.sdk.NightModeManager.getInstance(getContext()).getNightModeState()) goto L_0x0045;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setDayNightMode(int r4) {
        /*
            r3 = this;
            int r0 = r3.f31417e
            if (r0 != r4) goto L_0x0005
            return
        L_0x0005:
            r3.f31417e = r4
            com.didi.map.setting.common.IMapSettingPreferences r0 = r3.f31416d
            r0.setNavDayNightMode(r4)
            android.widget.TextView r0 = r3.f31413a
            r1 = 0
            r0.setSelected(r1)
            android.widget.TextView r0 = r3.f31414b
            r0.setSelected(r1)
            android.widget.TextView r0 = r3.f31415c
            r0.setSelected(r1)
            r0 = 1
            if (r4 != 0) goto L_0x0035
            android.widget.TextView r4 = r3.f31413a
            r4.setSelected(r0)
            com.didichuxing.nightmode.sdk.NightModeState r4 = com.didichuxing.nightmode.sdk.NightModeState.DAY     // Catch:{ all -> 0x0046 }
            android.content.Context r2 = r3.getContext()     // Catch:{ all -> 0x0046 }
            com.didichuxing.nightmode.sdk.NightModeManager r2 = com.didichuxing.nightmode.sdk.NightModeManager.getInstance(r2)     // Catch:{ all -> 0x0046 }
            com.didichuxing.nightmode.sdk.NightModeState r2 = r2.getNightModeState()     // Catch:{ all -> 0x0046 }
            if (r4 == r2) goto L_0x0046
            goto L_0x0045
        L_0x0035:
            if (r4 != r0) goto L_0x003d
            android.widget.TextView r4 = r3.f31414b
            r4.setSelected(r0)
            goto L_0x0046
        L_0x003d:
            r2 = 2
            if (r4 != r2) goto L_0x0046
            android.widget.TextView r4 = r3.f31415c
            r4.setSelected(r0)
        L_0x0045:
            r1 = 1
        L_0x0046:
            android.content.Context r4 = r3.getContext()     // Catch:{ all -> 0x0051 }
            com.didichuxing.nightmode.sdk.NightModeManager r4 = com.didichuxing.nightmode.sdk.NightModeManager.getInstance(r4)     // Catch:{ all -> 0x0051 }
            r4.onOrderStageChanged(r1)     // Catch:{ all -> 0x0051 }
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.setting.global.MapSettingNavDayNightView.setDayNightMode(int):void");
    }
}
