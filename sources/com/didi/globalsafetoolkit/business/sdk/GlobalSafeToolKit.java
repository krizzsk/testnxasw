package com.didi.globalsafetoolkit.business.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.SafeBusinessData;
import com.didi.globalsafetoolkit.business.areaCode.MandatoryGuideActivity;
import com.didi.globalsafetoolkit.business.areaCode.ManuallyAddCodeActivity;
import com.didi.globalsafetoolkit.business.contacts.SfContactsManageActivity;
import com.didi.globalsafetoolkit.business.contacts.SfContactsManageOptActivity;
import com.didi.globalsafetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.globalsafetoolkit.business.monitor.MonitorActivity;
import com.didi.globalsafetoolkit.business.safeCenter.SfSafeCenterActivity;
import com.didi.globalsafetoolkit.business.share.SfContactsActivity;
import com.didi.globalsafetoolkit.business.share.model.SfContactsParam;
import com.didi.globalsafetoolkit.business.share.store.SfContactsStore;
import com.didi.globalsafetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.globalsafetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.globalsafetoolkit.business.triprecording.GlobalTripRecordingManagerNew;
import com.didi.globalsafetoolkit.business.triprecording.TripRecordingActivity;
import com.didi.globalsafetoolkit.net.ISfRpcRequestParamListener;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.globalsafetoolkit.util.SfOmegaOptListener;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import org.json.JSONObject;

public class GlobalSafeToolKit {

    /* renamed from: a */
    private Application f25082a;

    /* renamed from: b */
    private boolean f25083b;

    /* renamed from: c */
    private JSONObject f25084c;

    /* renamed from: d */
    private int f25085d;

    /* renamed from: e */
    private String f25086e;

    /* renamed from: f */
    private ISfRpcRequestParamListener f25087f;

    /* renamed from: g */
    private SfOmegaOptListener f25088g;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final GlobalSafeToolKit m_This = new GlobalSafeToolKit();

        private Holder() {
        }
    }

    private GlobalSafeToolKit() {
    }

    public static GlobalSafeToolKit getIns() {
        return Holder.m_This;
    }

    public void initialization(Application application) {
        this.f25082a = application;
        SfContextHelper.setContext(application);
        this.f25083b = true;
    }

    @Deprecated
    public void startSafeCenterPage(Context context) {
        if (this.f25083b) {
            context.startActivity(new Intent(context, SfSafeCenterActivity.class));
        }
    }

    public void startSharePage(Activity activity, int i) {
        if (this.f25083b) {
            String str = null;
            SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
            if (businessInfo != null) {
                str = businessInfo.getOid();
            }
            SfContactsActivity.startActivityForResult(activity, i, new SfContactsParam().setTarget(1).setOrderId(str));
        }
    }

    public void startAreaCodeAddPage(Activity activity, int i, SfContactsManageModel sfContactsManageModel) {
        startAreaCodeAddPage(activity, i, 0, sfContactsManageModel);
    }

    public void startAreaCodeAddPage(Context context, int i, int i2, SfContactsManageModel sfContactsManageModel) {
        if (this.f25083b) {
            Intent intent = new Intent(context, MandatoryGuideActivity.class);
            intent.putExtra("sf_constant_manager_key", sfContactsManageModel);
            intent.putExtra("param_key_open_way_source", i2);
            if (i == 150 || i2 == 1) {
                intent.putExtra("param_key_open_from_share_dialog", true);
            }
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i);
                return;
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void startManuallyAddPage(Activity activity, int i, SfContactsManageModel sfContactsManageModel) {
        startManuallyAddPage(activity, i, 0, sfContactsManageModel);
    }

    public void startManuallyAddPage(Activity activity, int i, int i2, SfContactsManageModel sfContactsManageModel) {
        if (this.f25083b) {
            Intent intent = new Intent(activity, ManuallyAddCodeActivity.class);
            intent.putExtra("manually_add_code_key", sfContactsManageModel);
            intent.putExtra("param_key_open_way_source", i2);
            if (i == 150) {
                intent.putExtra("param_key_open_from_share_dialog", true);
            }
            activity.startActivityForResult(intent, i);
        }
    }

    public void startGetContactsPage(Activity activity, int i, int i2) {
        if (this.f25083b) {
            SfContactsActivity.startActivityForResult(activity, i, new SfContactsParam().setTarget(2).setThreshold(i2));
        }
    }

    public void startGetContactsPageByNewShare(Activity activity, int i, int i2) {
        if (this.f25083b) {
            SfContactsActivity.startActivityForResult(activity, i, new SfContactsParam().setTarget(3).setThreshold(i2));
        }
    }

    public void startContactsManagerPage(Context context) {
        if (this.f25083b) {
            context.startActivity(new Intent(context, SfContactsManageActivity.class));
        }
    }

    public void startContactsManagerOptPage(Activity activity, int i, int i2) {
        if (this.f25083b) {
            Intent intent = new Intent(activity, SfContactsManageOptActivity.class);
            intent.putExtra("target", 2);
            intent.putExtra("threshold", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    public void startContactsManagerOptPageByNewShare(Activity activity, int i, int i2) {
        if (this.f25083b) {
            Intent intent = new Intent(activity, SfContactsManageOptActivity.class);
            intent.putExtra("target", 3);
            intent.putExtra("threshold", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    public void startContactsManagerPageForResult(Activity activity, int i) {
        if (this.f25083b) {
            activity.startActivityForResult(new Intent(activity, SfContactsManageActivity.class), i);
        }
    }

    public void startContactsManagerPageForResultByNewShare(Activity activity, int i, int i2) {
        if (this.f25083b) {
            Intent intent = new Intent(activity, SfContactsManageActivity.class);
            intent.putExtra("target", 3);
            intent.putExtra("threshold", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    public void startSafetyCenter(Context context) {
        if (this.f25083b) {
            context.startActivity(new Intent(context, SfSafeCenterActivity.class));
        }
    }

    public void retryShareBySMS() {
        SfContactsStore.getInstance().shareRetry();
    }

    public void shareToSOSContacts() {
        SfContactsStore.getInstance().shareToSOSContacts();
    }

    public JSONObject getPolicePhoneFromPGetConfig() {
        return this.f25084c;
    }

    public void setPolicePhoneFromPGetConfig(JSONObject jSONObject) {
        this.f25084c = jSONObject;
    }

    public int getProductId() {
        return this.f25085d;
    }

    public void setProductId(int i) {
        this.f25085d = i;
    }

    public String getBusinessType() {
        return this.f25086e;
    }

    public void setBusinessType(String str) {
        this.f25086e = str;
        m20084a();
    }

    /* renamed from: a */
    private void m20084a() {
        String alias = GlobalSfBusinessInterface.getAlias();
        if (!TextUtils.isEmpty(alias)) {
            AudioRecordManager.get().setBusinessAlias(alias);
            GlobalTripRecordingManagerNew.Companion.getInstance().updateListener();
        }
    }

    public ISfRpcRequestParamListener getRequestParamListener() {
        return this.f25087f;
    }

    public void setRequestParamListener(ISfRpcRequestParamListener iSfRpcRequestParamListener) {
        this.f25087f = iSfRpcRequestParamListener;
    }

    public void startJarvisTripRecordingPage(Context context, String str, SfViewRecordMenuModel sfViewRecordMenuModel) {
        Intent intent = new Intent(context, TripRecordingActivity.class);
        intent.putExtra("recording_activity_extra_oid", str);
        intent.putExtra("recording_activity_extra_record_model", sfViewRecordMenuModel);
        context.startActivity(intent);
    }

    public void startMonitorDetails(Context context, SfViewMonitorMenuModel sfViewMonitorMenuModel) {
        Intent intent = new Intent(context, MonitorActivity.class);
        intent.putExtra("monitor_state", sfViewMonitorMenuModel);
        context.startActivity(intent);
    }

    public void setOmegaOptListener(SfOmegaOptListener sfOmegaOptListener) {
        this.f25088g = sfOmegaOptListener;
    }

    public SfOmegaOptListener getSfSpListener() {
        return this.f25088g;
    }
}
