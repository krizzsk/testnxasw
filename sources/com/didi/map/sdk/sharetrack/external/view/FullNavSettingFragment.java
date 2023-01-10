package com.didi.map.sdk.sharetrack.external.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.MapSettingNavInfo;
import com.didi.map.setting.global.MapSettingWindowView;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.nightmode.sdk.NightModeManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class FullNavSettingFragment extends DialogFragment {

    /* renamed from: a */
    private TextView f31157a;

    /* renamed from: b */
    private TextView f31158b;

    /* renamed from: c */
    private TextView f31159c;

    /* renamed from: d */
    private TextView f31160d;

    /* renamed from: e */
    private ImageView f31161e;

    /* renamed from: f */
    private RelativeLayout f31162f;

    /* renamed from: g */
    private RelativeLayout f31163g;

    /* renamed from: h */
    private boolean f31164h = false;

    /* renamed from: i */
    private int f31165i = 0;

    /* renamed from: j */
    private boolean f31166j = false;

    /* renamed from: k */
    private IFullNavSettingListener f31167k;

    /* renamed from: l */
    private MapSettingNavInfo f31168l;

    /* renamed from: m */
    private MapSettingWindowView f31169m;

    /* renamed from: n */
    private ViewGroup f31170n;

    public void showSafely(FragmentManager fragmentManager, String str) {
        if (fragmentManager == null) {
            try {
                m23840a("manager is null");
            } catch (Exception e) {
                m23840a(e.getMessage());
            }
        } else if (isAdded()) {
            m23840a("added");
        } else if (fragmentManager.findFragmentByTag(str) != null) {
            m23840a("has tag");
        } else {
            showNow(fragmentManager, str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f31166j = arguments.getBoolean("is_in_night_mode", false);
        }
        if (getContext() != null) {
            this.f31164h = MapSettingFactory.createMapPreferences(getContext().getApplicationContext()).getInAppNavVoiceOpen();
            this.f31165i = MapSettingFactory.createMapPreferences(getContext().getApplicationContext()).getNavDayNightMode();
            DLog.m23962d("GoogleFull", "init voice enable: " + this.f31164h + " map color: " + this.f31165i, new Object[0]);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (getActivity() == null) {
            return null;
        }
        Dialog dialog = new Dialog(getActivity(), R.style.BottomFragmentDialog);
        dialog.requestWindowFeature(1);
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.maprouter_full_nav_setting_layout_v2, (ViewGroup) null);
        m23839a(inflate);
        m23838a();
        dialog.setContentView(inflate);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (window == null) {
            return dialog;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setAttributes(attributes);
        return dialog;
    }

    /* renamed from: a */
    private void m23839a(View view) {
        this.f31162f = (RelativeLayout) view.findViewById(R.id.maprouter_nav_full_voice_container);
        this.f31163g = (RelativeLayout) view.findViewById(R.id.maprouter_nav_full_setting_others);
        this.f31161e = (ImageView) view.findViewById(R.id.maprouter_nav_full_voice);
        this.f31157a = (TextView) view.findViewById(R.id.maprouter_nav_full_setting_color_auto);
        this.f31158b = (TextView) view.findViewById(R.id.maprouter_nav_full_setting_color_day);
        this.f31159c = (TextView) view.findViewById(R.id.maprouter_nav_full_setting_color_night);
        this.f31160d = (TextView) view.findViewById(R.id.maprouter_nav_full_setting_confirm);
        this.f31161e.setImageResource(this.f31164h ? R.drawable.maprouter_full_nav_voice_open : R.drawable.maprouter_full_nav_voice_close);
        if (Apollo.getToggle("global_driver_android_nav_mute").allow()) {
            this.f31162f.setVisibility(0);
        }
        m23841b();
    }

    /* renamed from: a */
    private void m23838a() {
        this.f31162f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m23847g(view);
            }
        });
        this.f31157a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m23846f(view);
            }
        });
        this.f31158b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m23845e(view);
            }
        });
        this.f31159c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m23844d(view);
            }
        });
        this.f31163g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m23843c(view);
            }
        });
        this.f31160d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m23842b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m23847g(View view) {
        boolean z = !this.f31164h;
        this.f31164h = z;
        this.f31161e.setImageResource(z ? R.drawable.maprouter_full_nav_voice_open : R.drawable.maprouter_full_nav_voice_close);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m23846f(View view) {
        this.f31165i = 0;
        m23841b();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m23845e(View view) {
        this.f31165i = 1;
        m23841b();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m23844d(View view) {
        this.f31165i = 2;
        m23841b();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m23843c(View view) {
        if (this.f31168l != null && getContext() != null) {
            MapSettingWindowView mapSettingWindowView = this.f31169m;
            if (mapSettingWindowView == null) {
                this.f31169m = (MapSettingWindowView) MapSettingFactory.createMapDelegate(getContext()).getSelectNavView(this.f31170n, this.f31168l);
            } else {
                mapSettingWindowView.setNavInfo(this.f31168l);
            }
            this.f31169m.show(true, false);
            dismissAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23842b(View view) {
        if (getContext() != null) {
            MapSettingFactory.createMapPreferences(getContext().getApplicationContext()).setInAppNavVoiceOpen(this.f31164h);
            MapSettingFactory.createMapPreferences(getContext().getApplicationContext()).setNavDayNightMode(this.f31165i);
            IFullNavSettingListener iFullNavSettingListener = this.f31167k;
            if (iFullNavSettingListener != null) {
                iFullNavSettingListener.onVoiceStatusChanged(this.f31164h);
                this.f31167k.onMapColorSchemeChanged(this.f31165i);
            }
            if (this.f31165i != 0) {
                NightModeManager.getInstance(getContext().getApplicationContext()).onOrderStageChanged(this.f31165i == 2);
            }
        }
        dismissAllowingStateLoss();
    }

    /* renamed from: b */
    private void m23841b() {
        int i = this.f31165i;
        if (i == 0) {
            this.f31157a.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_active);
            this.f31158b.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f31159c.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f31157a.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_active_100));
            this.f31158b.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f31159c.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f31157a.setTypeface(Typeface.defaultFromStyle(1));
            this.f31158b.setTypeface(Typeface.defaultFromStyle(0));
            this.f31159c.setTypeface(Typeface.defaultFromStyle(0));
        } else if (i == 1) {
            this.f31157a.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f31158b.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_active);
            this.f31159c.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f31157a.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f31158b.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_active_100));
            this.f31159c.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f31157a.setTypeface(Typeface.defaultFromStyle(0));
            this.f31158b.setTypeface(Typeface.defaultFromStyle(1));
            this.f31159c.setTypeface(Typeface.defaultFromStyle(0));
        } else if (i == 2) {
            this.f31157a.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f31158b.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f31159c.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_active);
            this.f31157a.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f31158b.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f31159c.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_active_100));
            this.f31157a.setTypeface(Typeface.defaultFromStyle(0));
            this.f31158b.setTypeface(Typeface.defaultFromStyle(0));
            this.f31159c.setTypeface(Typeface.defaultFromStyle(1));
        }
    }

    public void setOnSettingListener(IFullNavSettingListener iFullNavSettingListener) {
        this.f31167k = iFullNavSettingListener;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void setNavInfo(MapSettingNavInfo mapSettingNavInfo) {
        this.f31168l = mapSettingNavInfo;
    }

    public void setContainerView(ViewGroup viewGroup) {
        this.f31170n = viewGroup;
    }

    /* renamed from: a */
    private void m23840a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        OmegaSDKAdapter.trackEvent("map_inner_nav_setting_exc_ck", (Map<String, Object>) hashMap);
    }
}
