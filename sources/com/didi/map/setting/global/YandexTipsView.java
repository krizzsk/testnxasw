package com.didi.map.setting.global;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.taxis99.R;

public class YandexTipsView {

    /* renamed from: a */
    private IMapSettingPreferences f31468a;

    /* renamed from: b */
    private Context f31469b;

    /* renamed from: c */
    private ViewGroup f31470c;

    /* renamed from: d */
    private View f31471d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View.OnClickListener f31472e;

    public YandexTipsView(Context context) {
        this.f31469b = context;
        this.f31468a = MapSettingFactory.createMapPreferences(context);
    }

    public void setParentView(ViewGroup viewGroup) {
        this.f31470c = viewGroup;
    }

    public void setOkClickListener(View.OnClickListener onClickListener) {
        this.f31472e = onClickListener;
    }

    public boolean show(String str) {
        if (this.f31470c == null) {
            Context context = this.f31469b;
            if (context instanceof Activity) {
                this.f31470c = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            }
        }
        if (this.f31470c == null) {
            return false;
        }
        if (this.f31471d != null) {
            return true;
        }
        if (this.f31468a == null) {
            this.f31468a = MapSettingFactory.createMapPreferences(this.f31469b);
        }
        if (MapSettingNavConstant.YANDEX_NAV.equals(str)) {
            if (this.f31468a.hasShowYandexNavTipsInOrder()) {
                return false;
            }
            this.f31468a.setShowYandexNavTipsInOrder(true);
        } else if (MapSettingNavConstant.YANDEX_MAP.equals(str)) {
            if (this.f31468a.hasShowYandexMapTipsInOrder()) {
                return false;
            }
            this.f31468a.setShowYandexMapTipsInOrder(true);
        }
        if (this.f31471d == null) {
            View inflate = LayoutInflater.from(this.f31470c.getContext()).inflate(R.layout.map_setting_yandex_tip_view, (ViewGroup) null);
            this.f31471d = inflate;
            inflate.findViewById(R.id.yandex_tip_confirm_btn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    YandexTipsView.this.m24025a();
                    if (YandexTipsView.this.f31472e != null) {
                        YandexTipsView.this.f31472e.onClick(view);
                    }
                }
            });
        }
        this.f31470c.addView(this.f31471d, new ViewGroup.LayoutParams(-1, -1));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24025a() {
        View view;
        ViewGroup viewGroup = this.f31470c;
        if (viewGroup != null && (view = this.f31471d) != null) {
            viewGroup.removeView(view);
            this.f31471d = null;
        }
    }
}
