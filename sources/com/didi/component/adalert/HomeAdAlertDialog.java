package com.didi.component.adalert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.paxadsdk.model.AdTraceInfo;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.BaseDialogFragment;
import com.didichuxing.publicservice.resourcecontrol.utils.DensityUtil;
import com.taxis99.R;

public class HomeAdAlertDialog extends BaseDialogFragment {

    /* renamed from: a */
    private ViewGroup f12810a;

    /* renamed from: b */
    private ImageView f12811b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Builder f12812c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017496);
        setCancelable(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_dialog_home_ad_alert, viewGroup, false);
        m10809a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m10809a(View view) {
        this.f12810a = (ViewGroup) view.findViewById(R.id.global_adalert_container);
        this.f12811b = (ImageView) view.findViewById(R.id.global_image_close);
        this.f12810a.getLayoutParams().width = DensityUtil.dip2px(getContext(), 280.0f);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Builder builder = this.f12812c;
        if (!(builder == null || builder.adView == null)) {
            this.f12810a.removeAllViews();
            this.f12810a.addView(this.f12812c.adView);
        }
        this.f12811b.setOnClickListener(new View.OnClickListener() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.util.Map} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r3) {
                /*
                    r2 = this;
                    com.didi.autotracker.AutoTrackHelper.trackViewOnClick(r3)
                    com.didi.component.adalert.HomeAdAlertDialog r3 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r3 = r3.f12812c
                    if (r3 == 0) goto L_0x0060
                    com.didi.component.adalert.HomeAdAlertDialog r3 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r3 = r3.f12812c
                    com.didi.sdk.paxadsdk.model.AdTraceInfo r3 = r3.traceInfo
                    if (r3 == 0) goto L_0x0060
                    com.didi.component.adalert.HomeAdAlertDialog r3 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r3 = r3.f12812c
                    com.didi.sdk.paxadsdk.model.AdTraceInfo r3 = r3.traceInfo
                    org.json.JSONObject r3 = r3.log_data
                    if (r3 == 0) goto L_0x0060
                    com.google.gson.JsonParser r3 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x005c }
                    r3.<init>()     // Catch:{ Exception -> 0x005c }
                    com.didi.component.adalert.HomeAdAlertDialog r0 = com.didi.component.adalert.HomeAdAlertDialog.this     // Catch:{ Exception -> 0x005c }
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r0 = r0.f12812c     // Catch:{ Exception -> 0x005c }
                    com.didi.sdk.paxadsdk.model.AdTraceInfo r0 = r0.traceInfo     // Catch:{ Exception -> 0x005c }
                    org.json.JSONObject r0 = r0.log_data     // Catch:{ Exception -> 0x005c }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x005c }
                    com.google.gson.JsonElement r3 = r3.parse((java.lang.String) r0)     // Catch:{ Exception -> 0x005c }
                    com.google.gson.JsonObject r3 = (com.google.gson.JsonObject) r3     // Catch:{ Exception -> 0x005c }
                    java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x005c }
                    r0.<init>()     // Catch:{ Exception -> 0x005c }
                    if (r3 == 0) goto L_0x0056
                    com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x005c }
                    r0.<init>()     // Catch:{ Exception -> 0x005c }
                    com.didi.component.adalert.HomeAdAlertDialog$1$1 r1 = new com.didi.component.adalert.HomeAdAlertDialog$1$1     // Catch:{ Exception -> 0x005c }
                    r1.<init>()     // Catch:{ Exception -> 0x005c }
                    java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x005c }
                    java.lang.Object r3 = r0.fromJson((com.google.gson.JsonElement) r3, (java.lang.reflect.Type) r1)     // Catch:{ Exception -> 0x005c }
                    r0 = r3
                    java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x005c }
                L_0x0056:
                    java.lang.String r3 = "ibt_gp_ad_popup_close_ck"
                    com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ Exception -> 0x005c }
                    goto L_0x0060
                L_0x005c:
                    r3 = move-exception
                    r3.printStackTrace()
                L_0x0060:
                    com.didi.component.adalert.HomeAdAlertDialog r3 = com.didi.component.adalert.HomeAdAlertDialog.this
                    r3.dismiss()
                    com.didi.component.adalert.HomeAdAlertDialog r3 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r3 = r3.f12812c
                    if (r3 == 0) goto L_0x0092
                    com.didi.component.adalert.HomeAdAlertDialog r3 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r3 = r3.f12812c
                    com.didi.sdk.paxadsdk.model.AdTraceInfo r3 = r3.traceInfo
                    if (r3 == 0) goto L_0x0092
                    com.didi.sdk.paxadsdk.GlobalAdManager r3 = com.didi.sdk.paxadsdk.GlobalAdManager.getInstance()
                    com.didi.component.adalert.HomeAdAlertDialog r0 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r0 = r0.f12812c
                    com.didi.sdk.paxadsdk.model.AdTraceInfo r0 = r0.traceInfo
                    java.lang.String r0 = r0.agency
                    com.didi.component.adalert.HomeAdAlertDialog r1 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r1 = r1.f12812c
                    com.didi.sdk.paxadsdk.model.AdTraceInfo r1 = r1.traceInfo
                    java.lang.String r1 = r1.adid
                    r3.release(r0, r1)
                L_0x0092:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.adalert.HomeAdAlertDialog.C50741.onClick(android.view.View):void");
            }
        });
    }

    public Builder build() {
        Builder builder = new Builder();
        this.f12812c = builder;
        return builder;
    }

    public class Builder {
        View adView;
        AdTraceInfo traceInfo;

        public Builder() {
        }

        public Builder setAdView(AdTraceInfo adTraceInfo, View view) {
            this.traceInfo = adTraceInfo;
            this.adView = view;
            return this;
        }

        public void show(final FragmentManager fragmentManager, final String str) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    if (fragmentManager != null) {
                        HomeAdAlertDialog.this.show(fragmentManager, str);
                    }
                }
            });
        }
    }
}
