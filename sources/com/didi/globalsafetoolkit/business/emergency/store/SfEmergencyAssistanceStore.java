package com.didi.globalsafetoolkit.business.emergency.store;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.SafeBusinessData;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgStatus;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.util.SfContextHelper;

public class SfEmergencyAssistanceStore {

    /* renamed from: a */
    private static volatile SfEmergencyAssistanceStore f24999a;

    public static SfEmergencyAssistanceStore getInstance() {
        if (f24999a == null) {
            synchronized (SfEmergencyAssistanceStore.class) {
                if (f24999a == null) {
                    f24999a = new SfEmergencyAssistanceStore();
                }
            }
        }
        return f24999a;
    }

    /* renamed from: a */
    private void m20042a(boolean z) {
        Intent intent = new Intent();
        intent.setAction(z ? "sf_emergency_assist_on" : "sf_emergency_assist_off");
        LocalBroadcastManager.getInstance(SfContextHelper.getContext()).sendBroadcast(intent);
    }

    /* renamed from: a */
    private String m20041a() {
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            return businessInfo.getOid();
        }
        return null;
    }

    /* renamed from: b */
    private String m20043b() {
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            return businessInfo.getCountryIsoCode();
        }
        return null;
    }

    public void getEmergencyInfo(SfResponseListener<SfEmgInfo> sfResponseListener) {
        GlobalSfManager.getInstance().requestEmergencyInfo(sfResponseListener);
    }

    public void getEmergencyStatus(SfResponseListener<SfEmgStatus> sfResponseListener) {
        GlobalSfManager.getInstance().getEmergencyStatus(sfResponseListener);
    }

    public void startEmergencyCall(SfResponseListener<SfBaseObject> sfResponseListener) {
        GlobalSfManager.getInstance().startEmergency(sfResponseListener);
    }

    public void stopEmergencyCall(SfResponseListener<SfBaseObject> sfResponseListener) {
        GlobalSfManager.getInstance().stopEmergencyCall(sfResponseListener);
    }
}
