package com.didi.safetoolkit.business.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.safetoolkit.activity.ActivityStack;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.safetoolkit.FlutterDataHandle;
import com.didi.safetoolkit.IFlutter2Native;
import com.didi.safetoolkit.api.ISFTripRecordingService;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.safetoolkit.business.areaCode.MandatoryGuideActivity;
import com.didi.safetoolkit.business.areaCode.ManuallyAddCodeActivity;
import com.didi.safetoolkit.business.contacts.SfContactsManageActivity;
import com.didi.safetoolkit.business.contacts.SfContactsManageOptActivity;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.emergency.SfEmergencyAssistanceActivity;
import com.didi.safetoolkit.business.emergency.store.SfEmergencyAssistanceStore;
import com.didi.safetoolkit.business.monitor.MonitorActivity;
import com.didi.safetoolkit.business.safeCenter.SfSafeCenterActivity;
import com.didi.safetoolkit.business.share.SfContactsActivity;
import com.didi.safetoolkit.business.share.model.SfContactsParam;
import com.didi.safetoolkit.business.share.store.SfContactsStore;
import com.didi.safetoolkit.business.toolkit.SfToolkitDialog;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewSafeCenterMenuModel;
import com.didi.safetoolkit.business.triprecording.TripRecordingActivity;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.safetoolkit.model.SfBaseObject;
import com.didi.safetoolkit.net.ISfRpcRequestParamListener;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfOmegaOptListener;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.widget.SfBaseDialog;
import com.didi.sdk.app.tap.BusinessConstants;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class SafeToolKit {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IFlutter2Native f37178a;

    /* renamed from: b */
    private FlutterDataHandle f37179b;

    /* renamed from: c */
    private SfToolkitDialog f37180c;

    /* renamed from: d */
    private Application f37181d;

    /* renamed from: e */
    private boolean f37182e;

    /* renamed from: f */
    private JSONObject f37183f;

    /* renamed from: g */
    private int f37184g;

    /* renamed from: h */
    private String f37185h;

    /* renamed from: i */
    private boolean f37186i;

    /* renamed from: j */
    private ISfRpcRequestParamListener f37187j;

    /* renamed from: k */
    private SfOmegaOptListener f37188k;

    /* renamed from: l */
    private boolean f37189l;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final SafeToolKit m_This = new SafeToolKit();

        private Holder() {
        }
    }

    private SafeToolKit() {
        this.f37189l = false;
    }

    public static SafeToolKit getIns() {
        return Holder.m_This;
    }

    public void initialization(Application application) {
        this.f37181d = application;
        ActivityStack.init(application);
        SfContextHelper.setContext(this.f37181d);
        this.f37182e = true;
    }

    public void startToolkitDialog(FragmentActivity fragmentActivity, String str, ArrayList<SfViewMenuModel> arrayList) {
        startToolkitDialog(fragmentActivity, true, str, arrayList);
    }

    public void startToolkitDialog(FragmentActivity fragmentActivity, boolean z, String str, ArrayList<SfViewMenuModel> arrayList) {
        if (this.f37182e) {
            if (this.f37180c == null) {
                this.f37180c = new SfToolkitDialog();
            }
            if (!this.f37180c.isShowing()) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (arrayList.size() == 0) {
                    arrayList.add(SfViewSafeCenterMenuModel.buildFallbackModel());
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("isShareCanUse", z);
                bundle.putString("orderId", str);
                bundle.putSerializable("menuList", arrayList);
                this.f37180c.setArguments(bundle);
                this.f37180c.show(fragmentActivity.getSupportFragmentManager(), "SfToolkitDialog");
            }
        }
    }

    public void dismissToolkitDialog() {
        SfToolkitDialog sfToolkitDialog;
        if (this.f37182e && (sfToolkitDialog = this.f37180c) != null) {
            sfToolkitDialog.dismissAllowingStateLoss();
        }
    }

    @Deprecated
    public void startSafeCenterPage(Context context) {
        if (this.f37182e) {
            context.startActivity(new Intent(context, SfSafeCenterActivity.class));
        }
    }

    public void startSharePage(Activity activity, int i) {
        if (this.f37182e) {
            String str = null;
            ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, getIns().getBusinessType()).get();
            if (iSfInfoService != null) {
                str = iSfInfoService.getCarOrderId();
            }
            SfContactsActivity.startActivityForResult(activity, i, new SfContactsParam().setTarget(1).setOrderId(str));
        }
    }

    public void startAreaCodeAddPage(Activity activity, int i, SfContactsManageModel sfContactsManageModel) {
        startAreaCodeAddPage(activity, i, 0, sfContactsManageModel);
    }

    public void startAreaCodeAddPage(Context context, int i, int i2, SfContactsManageModel sfContactsManageModel) {
        if (this.f37182e) {
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
        if (this.f37182e) {
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
        if (this.f37182e) {
            SfContactsActivity.startActivityForResult(activity, i, new SfContactsParam().setTarget(2).setThreshold(i2));
        }
    }

    public void startGetContactsPageByNewShare(Activity activity, int i, int i2) {
        if (this.f37182e) {
            SfContactsActivity.startActivityForResult(activity, i, new SfContactsParam().setTarget(3).setThreshold(i2));
        }
    }

    public void startContactsManagerPage(Context context) {
        if (this.f37182e) {
            context.startActivity(new Intent(context, SfContactsManageActivity.class));
        }
    }

    public void startContactsManagerOptPage(Activity activity, int i, int i2) {
        if (this.f37182e) {
            Intent intent = new Intent(activity, SfContactsManageOptActivity.class);
            intent.putExtra("target", 2);
            intent.putExtra("threshold", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    public void startContactsManagerOptPageByNewShare(Activity activity, int i, int i2) {
        if (this.f37182e) {
            Intent intent = new Intent(activity, SfContactsManageOptActivity.class);
            intent.putExtra("target", 3);
            intent.putExtra("threshold", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    public void startContactsManagerPageForResult(Activity activity, int i) {
        if (this.f37182e) {
            activity.startActivityForResult(new Intent(activity, SfContactsManageActivity.class), i);
        }
    }

    public void startContactsManagerPageForResultByNewShare(Activity activity, int i, int i2) {
        if (this.f37182e) {
            Intent intent = new Intent(activity, SfContactsManageActivity.class);
            intent.putExtra("target", 3);
            intent.putExtra("threshold", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    public void startEmergencyAssistanceActivity(Context context) {
        if (this.f37182e) {
            DRouter.build("globalOneTravel://one/safety/emergency").start();
        }
    }

    public void startEmergencyAssistanceActivity(Context context, boolean z) {
        if (this.f37182e) {
            Intent intent = new Intent(context, SfEmergencyAssistanceActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("isNotAccepted", z);
            context.startActivity(intent);
        }
    }

    public void startSafetyCenter(Context context) {
        if (this.f37182e) {
            context.startActivity(new Intent(context, SfSafeCenterActivity.class));
        }
    }

    public void retryShareBySMS() {
        SfContactsStore.getInstance().shareRetry();
    }

    public void shareToSOSContacts() {
        SfContactsStore.getInstance().shareToSOSContacts();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28067a(final Context context) {
        if (context instanceof FragmentActivity) {
            new SfBaseDialog.DialogBuilder(context).setTitle(SfStringGetter.getString(R.string.sf_cancel_fail)).setButtonLayoutGravity(1).setRightBtn(SfStringGetter.getString(R.string.sf_retry), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SfEmergencyAssistanceStore.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
                        public void onError(SfBaseObject sfBaseObject) {
                            SafeToolKit.this.m28067a(context);
                        }

                        public void onFail(int i, String str) {
                            SafeToolKit.this.m28067a(context);
                        }
                    });
                }
            }).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(true).build().show(((FragmentActivity) context).getSupportFragmentManager(), "RetryCancelPoliceDialog");
            return;
        }
        SfLog.m28132e("context must be derived from the FragmentActivity");
    }

    public void showPoliceDialog(final Context context, final String str) {
        if (context instanceof FragmentActivity) {
            new SfBaseDialog.DialogBuilder(context).setTitle(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_title)).setTitleTypeface(1).setContent(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_message)).setLeftBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_confirm_stop_btn), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SafeToolKit.this.f37178a != null) {
                        SafeToolKit.this.f37178a.buttonStatusChanged(str, "loading");
                    }
                    SfEmergencyAssistanceStore.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
                        public void onError(SfBaseObject sfBaseObject) {
                            SafeToolKit.this.m28067a(context);
                        }

                        public void onFail(int i, String str) {
                            SafeToolKit.this.m28067a(context);
                        }
                    });
                }
            }).setLeftBtnTextColorRes(R.color.sf_color_999999).setRightBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_no_stop_btn)).setRightBtnTypeface(1).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(false).build().show(((FragmentActivity) context).getSupportFragmentManager(), "StopEmerAssistConfirmDialog");
            return;
        }
        SfLog.m28132e("context must be derived from the FragmentActivity");
    }

    public void showRecoverPoliceDialog(final Context context, String str) {
        if (!inVamosBizLine()) {
            if (context instanceof FragmentActivity) {
                new SfBaseDialog.DialogBuilder(context).setTitle(SfStringGetter.getString(R.string.sf_continue)).setTitleTypeface(1).setContent(SfStringGetter.getString(R.string.sf_emergency_report)).setButtonLayoutGravity(1).setLeftBtn(SfStringGetter.getString(R.string.sf_cancel_report), (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        SfEmergencyAssistanceStore.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
                            public void onError(SfBaseObject sfBaseObject) {
                                SafeToolKit.this.m28067a(context);
                            }

                            public void onFail(int i, String str) {
                                SafeToolKit.this.m28067a(context);
                            }
                        });
                    }
                }).setLeftBtnTextColorRes(R.color.sf_color_999999).setRightBtn(SfStringGetter.getString(R.string.sf_going), (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        SafeToolKit.this.startEmergencyAssistanceActivity(context);
                    }
                }).setRightBtnTypeface(1).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(false).build().show(((FragmentActivity) context).getSupportFragmentManager(), "RecoverPoliceDialog");
                return;
            }
            SfLog.m28132e("context must be derived from the FragmentActivity");
        }
    }

    public JSONObject getPolicePhoneFromPGetConfig() {
        return this.f37183f;
    }

    public void setPolicePhoneFromPGetConfig(JSONObject jSONObject) {
        this.f37183f = jSONObject;
    }

    public int getProductId() {
        return this.f37184g;
    }

    public void setProductId(int i) {
        this.f37184g = i;
    }

    public String getBusinessType() {
        return this.f37185h;
    }

    public void setBusinessType(String str) {
        this.f37185h = str;
        m28066a();
    }

    /* renamed from: a */
    private void m28066a() {
        ISFTripRecordingService bussinessCallback = TripRecordingManager.Companion.getInstance().getBussinessCallback();
        if (bussinessCallback != null) {
            String alias = bussinessCallback.getAlias();
            if (!TextUtils.isEmpty(alias)) {
                AudioRecordManager.get().setBusinessAlias(alias);
                TripRecordingManager.Companion.getInstance().updateListener();
            }
        }
    }

    public boolean isVamosDriver() {
        return this.f37186i;
    }

    public void setVamosDriver(boolean z) {
        this.f37186i = z;
    }

    public ISfRpcRequestParamListener getRequestParamListener() {
        return this.f37187j;
    }

    public void setRequestParamListener(ISfRpcRequestParamListener iSfRpcRequestParamListener) {
        this.f37187j = iSfRpcRequestParamListener;
    }

    public static boolean inVamosBizLine() {
        return TextUtils.equals(getIns().getBusinessType(), BusinessConstants.TYPE_VAMOS);
    }

    public void startTripRecordingPage(Context context, String str, boolean z) {
        Intent intent = new Intent(context, TripRecordingActivity.class);
        intent.putExtra("recording_activity_extra_oid", str);
        SfViewRecordMenuModel sfViewRecordMenuModel = new SfViewRecordMenuModel();
        sfViewRecordMenuModel.canRecord = z;
        intent.putExtra("recording_activity_extra_record_model", sfViewRecordMenuModel);
        context.startActivity(intent);
    }

    public void startTripRecordingPage(Context context, String str, SfViewRecordMenuModel sfViewRecordMenuModel) {
        Intent intent = new Intent(context, TripRecordingActivity.class);
        intent.putExtra("recording_activity_extra_oid", str);
        intent.putExtra("recording_activity_extra_record_model", sfViewRecordMenuModel);
        context.startActivity(intent);
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

    public void updateSfDialogItem(List<SfViewMenuModel> list) {
        if (this.f37180c != null && list != null && !list.isEmpty()) {
            this.f37180c.updateSfViewMenuModelList(list);
        }
    }

    public void setOmegaOptListener(SfOmegaOptListener sfOmegaOptListener) {
        this.f37188k = sfOmegaOptListener;
    }

    public SfOmegaOptListener getSfSpListener() {
        return this.f37188k;
    }

    public void setFlutterListener(IFlutter2Native iFlutter2Native) {
        this.f37178a = iFlutter2Native;
    }

    public IFlutter2Native getmFlutterListener() {
        return this.f37178a;
    }

    public void setFlutterDataHandle(FlutterDataHandle flutterDataHandle) {
        this.f37179b = flutterDataHandle;
    }

    public FlutterDataHandle getDataHandle() {
        return this.f37179b;
    }
}
