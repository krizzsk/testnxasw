package com.didiglobal.p205sa.biz.component.sapanel.omega;

import android.graphics.Rect;
import android.os.Handler;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.omega.PanelOmegaTracker */
public class PanelOmegaTracker {

    /* renamed from: b */
    private static final String f53647b = PanelOmegaTracker.class.toString();

    /* renamed from: a */
    private Logger f53648a = LoggerFactory.getLogger("PanelOmegaTracker");

    /* renamed from: c */
    private Handler f53649c = new Handler();

    /* renamed from: d */
    private final List<SACardProperty> f53650d = Collections.synchronizedList(new ArrayList());

    /* renamed from: e */
    private final List<SACardProperty> f53651e = Collections.synchronizedList(new ArrayList());

    public void setCurrentCardProperties(List<SACardProperty> list) {
        this.f53650d.clear();
        this.f53651e.clear();
        this.f53650d.addAll(list);
        this.f53649c.post(new Runnable() {
            public void run() {
                PanelOmegaTracker.this.m40024a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40024a() {
        try {
            getShowingViesWhenScrollStopped(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void omegaScrollTrack() {
        try {
            getShowingViesWhenScrollStopped(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getShowingViesWhenScrollStopped(boolean z) {
        if (!this.f53650d.isEmpty()) {
            m40027a(this.f53650d, z);
            for (int i = 0; i < this.f53650d.size(); i++) {
                SACardProperty sACardProperty = this.f53650d.get(i);
                if (!(sACardProperty == null || sACardProperty.getView() == null)) {
                    Rect rect = new Rect();
                    sACardProperty.getView().getGlobalVisibleRect(rect);
                    SACardTrackProperty sACardTrackProperty = new SACardTrackProperty();
                    sACardTrackProperty.property = sACardProperty;
                    sACardTrackProperty.f53652id = sACardProperty.getId();
                    if (sACardProperty.getView().getHeight() != 0) {
                        sACardTrackProperty.height = (((float) (rect.bottom - rect.top)) * 1.0f) / ((float) sACardProperty.getView().getHeight());
                    }
                    Logger logger = this.f53648a;
                    logger.info("onViewVisible: cardId: " + sACardProperty.getId() + "cardWidth: " + sACardProperty.getView().getWidth() + "cardHeight: " + sACardProperty.getView().getHeight(), new Object[0]);
                    if (sACardTrackProperty.height > 0.0f && !this.f53651e.contains(sACardProperty)) {
                        this.f53651e.add(sACardProperty);
                        m40026a(sACardTrackProperty, z);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m40026a(SACardTrackProperty sACardTrackProperty, boolean z) {
        SACardProperty sACardProperty = sACardTrackProperty.property;
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_MODULE_ID, sACardTrackProperty.f53652id);
        if (z) {
            hashMap.put("type", Float.valueOf(sACardTrackProperty.height));
        }
        try {
            Map<String, Object> extension = sACardProperty.getExtension();
            if (extension != null) {
                hashMap.putAll(extension);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_act_module_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m40027a(List<SACardProperty> list, boolean z) {
        try {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            HashMap hashMap = new HashMap();
            for (SACardProperty next : list) {
                sb.append(next.getId());
                sb.append(",");
                sb2.append(next.getView().getHeight());
                sb2.append(",");
                sb3.append(next.getView().getLocalVisibleRect(new Rect()));
                sb3.append(",");
            }
            hashMap.put(ParamConst.PARAM_MODULE_ID, sb.toString());
            hashMap.put("heights", sb2.toString());
            hashMap.put("visible", sb3.toString());
            hashMap.put("isfirstenter", Boolean.valueOf(z));
            OmegaSDKAdapter.trackEvent("tech_sa_pax_event_xpanel_module_sw", (Map<String, Object>) hashMap);
            String str = f53647b;
            SystemUtils.log(4, str, "omegaAllCardReport: " + hashMap.toString(), (Throwable) null, "com.didiglobal.sa.biz.component.sapanel.omega.PanelOmegaTracker", 159);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
