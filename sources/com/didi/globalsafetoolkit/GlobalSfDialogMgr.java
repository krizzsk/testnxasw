package com.didi.globalsafetoolkit;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.globalsafetoolkit.business.emergency.store.SfEmergencyAssistanceStore;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.didi.globalsafetoolkit.widget.SfBaseDialog;
import com.taxis99.R;

public class GlobalSfDialogMgr {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19956a(final Context context) {
        if (context instanceof FragmentActivity) {
            new SfBaseDialog.DialogBuilder(context).setTitle(SfStringGetter.getString(R.string.sf_cancel_fail)).setButtonLayoutGravity(1).setRightBtn(SfStringGetter.getString(R.string.sf_retry), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SfEmergencyAssistanceStore.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
                        public void onError(SfBaseObject sfBaseObject) {
                            GlobalSfDialogMgr.this.m19956a(context);
                        }

                        public void onFail(int i, String str) {
                            GlobalSfDialogMgr.this.m19956a(context);
                        }
                    });
                }
            }).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(true).build().show(((FragmentActivity) context).getSupportFragmentManager(), "RetryCancelPoliceDialog");
            return;
        }
        SfLog.m20146e("context must be derived from the FragmentActivity");
    }

    public void showCancelPoliceDialog(final Context context, final String str) {
        if (context instanceof FragmentActivity) {
            new SfBaseDialog.DialogBuilder(context).setTitle(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_title)).setTitleTypeface(1).setContent(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_message)).setLeftBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_confirm_stop_btn), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalSfManager.getInstance().getFlutterListener().buttonStatusChanged(str, "loading");
                    SfEmergencyAssistanceStore.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
                        public void onError(SfBaseObject sfBaseObject) {
                            GlobalSfDialogMgr.this.m19956a(context);
                        }

                        public void onFail(int i, String str) {
                            GlobalSfDialogMgr.this.m19956a(context);
                        }
                    });
                }
            }).setLeftBtnTextColorRes(R.color.sf_color_999999).setRightBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_no_stop_btn)).setRightBtnTypeface(1).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(false).build().show(((FragmentActivity) context).getSupportFragmentManager(), "StopEmerAssistConfirmDialog");
            return;
        }
        SfLog.m20146e("context must be derived from the FragmentActivity");
    }

    public void showRecoverPoliceDialog(final Context context) {
        if (context instanceof FragmentActivity) {
            new SfBaseDialog.DialogBuilder(context).setTitle(SfStringGetter.getString(R.string.sf_continue)).setTitleTypeface(1).setContent(SfStringGetter.getString(R.string.sf_emergency_report)).setButtonLayoutGravity(1).setLeftBtn(SfStringGetter.getString(R.string.sf_cancel_report), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalSfManager.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
                        public void onError(SfBaseObject sfBaseObject) {
                            GlobalSfDialogMgr.this.m19956a(context);
                        }

                        public void onFail(int i, String str) {
                            GlobalSfDialogMgr.this.m19956a(context);
                        }
                    });
                }
            }).setLeftBtnTextColorRes(R.color.sf_color_999999).setRightBtn(SfStringGetter.getString(R.string.sf_going), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalSfManager.getInstance().openEmergencyPage(context);
                }
            }).setRightBtnTypeface(1).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(false).build().show(((FragmentActivity) context).getSupportFragmentManager(), "RecoverPoliceDialog");
            return;
        }
        SfLog.m20146e("context must be derived from the FragmentActivity");
    }
}
