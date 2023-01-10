package com.didi.component.phoneentrance;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.net.MailTo;
import androidx.fragment.app.FragmentActivity;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.OnlineHelpUtil;
import com.didi.component.common.voip.VoipComponentImpl;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.phoneentrance.IPhoneEntranceView;
import com.didi.component.phoneentrance.impl.PhoneSecurityDialog;
import com.didi.component.phoneentrance.model.DriverOptionData;
import com.didi.component.phoneentrance.model.DriverOptionModel;
import com.didi.component.phoneentrance.model.PassengerSheetModel;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.IMPhoneClickListener;
import com.didi.sdk.app.OneMessageInit;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogBase;
import com.didi.travel.psnger.utils.TextUtil;
import com.didichuxing.comp.telecom.biz.p177ui.calllist.PhoneClickCallback;
import com.didichuxing.comp.telecom.biz.p177ui.calllist.VoipClickCallback;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.taxis99.R;
import java.util.HashMap;

public abstract class AbsPhoneEntrancePresenter extends BaseExpressPresenter<IPhoneEntranceView> implements IPhoneEntranceView.OnPhoneEntranceClickListener {
    public static final int DIALOG_PHONE = 100;
    public static final int PHONE_DOWNGRADE_PROTECT = 5;
    public static final int PHONE_HELP_PAGE = 3;
    public static final int PHONE_OPTION_NORMAL_CALL = 2;
    public static final int PHONE_OPTION_VOIP = 4;

    /* renamed from: k */
    private static final int f17066k = 200;

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17067a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsPhoneEntrancePresenter.this.onPhoneEntranceClick();
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17068b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsPhoneEntrancePresenter.this.m14320g();
        }
    };

    /* renamed from: c */
    BaseEventPublisher.OnEventListener<Boolean> f17069c = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool != null && AbsPhoneEntrancePresenter.this.f17071e != bool.booleanValue()) {
                boolean unused = AbsPhoneEntrancePresenter.this.f17071e = bool.booleanValue();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AlertDialogBase f17070d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f17071e;

    /* renamed from: f */
    private DriverOptionModel f17072f;

    /* renamed from: g */
    private DriverOptionData f17073g;

    /* renamed from: h */
    private int f17074h;

    /* renamed from: i */
    private IMPhoneClickListener f17075i;
    protected boolean isDriverAllowContact = GlobalApolloUtil.isDriverAllowContact();
    protected boolean isGotoHelpCenter;

    /* renamed from: j */
    private boolean f17076j = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LEGODrawer f17077l;
    protected String mDriverPhone;

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m14320g() {
    }

    /* access modifiers changed from: protected */
    public boolean needShowOtherInterceptorDialog() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void showOtherInterceptorDialog() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AbsPhoneEntrancePresenter(com.didi.component.core.ComponentParams r3) {
        /*
            r2 = this;
            r2.<init>(r3)
            r0 = 0
            r2.f17076j = r0
            boolean r0 = com.didi.component.business.util.GlobalApolloUtil.isDriverAllowContact()
            r2.isDriverAllowContact = r0
            com.didi.component.phoneentrance.AbsPhoneEntrancePresenter$1 r0 = new com.didi.component.phoneentrance.AbsPhoneEntrancePresenter$1
            r0.<init>()
            r2.f17067a = r0
            com.didi.component.phoneentrance.AbsPhoneEntrancePresenter$2 r0 = new com.didi.component.phoneentrance.AbsPhoneEntrancePresenter$2
            r0.<init>()
            r2.f17068b = r0
            com.didi.component.phoneentrance.AbsPhoneEntrancePresenter$3 r0 = new com.didi.component.phoneentrance.AbsPhoneEntrancePresenter$3
            r0.<init>()
            r2.f17069c = r0
            java.lang.String r0 = "phone_option"
            java.lang.Object r0 = r3.getExtra(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0039
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0035 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0035 }
            goto L_0x003a
        L_0x0035:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0039:
            r1 = 0
        L_0x003a:
            if (r1 == 0) goto L_0x0046
            com.didi.component.phoneentrance.model.DriverOptionModel r0 = new com.didi.component.phoneentrance.model.DriverOptionModel
            r0.<init>()
            r2.f17072f = r0
            r0.parse(r1)
        L_0x0046:
            java.lang.String r0 = "source"
            java.lang.Object r3 = r3.getExtra(r0)
            java.lang.String r3 = (java.lang.String) r3
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0060
            java.lang.String r0 = "far"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0060
            r0 = 2
            r2.f17074h = r0
        L_0x0060:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0071
            java.lang.String r0 = "near"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0071
            r3 = 1
            r2.f17074h = r3
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.phoneentrance.AbsPhoneEntrancePresenter.<init>(com.didi.component.core.ComponentParams):void");
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Phone.EVENT_PHONE_MODIFY, this.f17068b);
        subscribe(BaseEventKeys.Phone.EVENT_PHONE_CLICK, this.f17067a);
        subscribe(BaseEventKeys.Phone.EVENT_ALLOW_CONTACT_DRIVER, this.f17069c);
        DriverOptionModel driverOptionModel = this.f17072f;
        if (driverOptionModel == null) {
            ((IPhoneEntranceView) this.mView).getView().setVisibility(4);
            GLog.m11353d("can't obtain order, make phone icon invisible");
            return;
        }
        this.f17073g = driverOptionModel.data;
        boolean z = false;
        ((IPhoneEntranceView) this.mView).setPhoneClickable(this.f17072f.clickable == 1);
        DriverOptionData driverOptionData = this.f17073g;
        if (driverOptionData != null) {
            this.mDriverPhone = driverOptionData.driverPhone;
            this.f17071e = this.f17073g.allowContactDriver == 1;
            if (this.f17073g.isVitual == 1) {
                z = true;
            }
            this.f17076j = z;
            C71364 r4 = new IMPhoneClickListener() {
                public void clickPhone() {
                    AbsPhoneEntrancePresenter.this.onPhoneEntranceClick();
                }
            };
            this.f17075i = r4;
            OneMessageInit.setImPhoneClickListener(r4);
        }
        this.isGotoHelpCenter = GlobalApolloUtil.isGoToHelpCenter();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Phone.EVENT_PHONE_MODIFY, this.f17068b);
        unsubscribe(BaseEventKeys.Phone.EVENT_PHONE_CLICK, this.f17067a);
        unsubscribe(BaseEventKeys.Phone.EVENT_ALLOW_CONTACT_DRIVER, this.f17069c);
        AlertDialogBase alertDialogBase = this.f17070d;
        if (alertDialogBase != null) {
            alertDialogBase.dismiss();
        }
        OneMessageInit.removePhoneClickListener(this.f17075i);
    }

    public void onPhoneEntranceClick() {
        if (CarOrderHelper.getOrder() != null) {
            m14321h();
            DriverOptionModel driverOptionModel = this.f17072f;
            if (driverOptionModel != null) {
                int i = driverOptionModel.action;
                if (i == 2) {
                    phoneCall();
                } else if (i == 3) {
                    m14314c();
                } else if (i == 4) {
                    m14312b();
                } else if (i != 5) {
                    expiredDialog4New();
                } else {
                    m14317d();
                }
            }
        }
    }

    /* renamed from: b */
    private void m14312b() {
        HashMap hashMap = new HashMap();
        hashMap.put("voip_session_id", this.f17072f.voipSessionId);
        hashMap.put(ParamConst.InfoOmega.HAS_PHONE, Integer.valueOf(!TextUtils.isEmpty(this.mDriverPhone) ? 1 : 2));
        hashMap.put("is_phone_protect", Integer.valueOf(this.f17076j ? 1 : 0));
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            VoipComponentImpl.showCallMethodDialog(currentActivity, hashMap, new PhoneClickCallback() {
                public void onClick() {
                    AbsPhoneEntrancePresenter.this.phoneCall();
                }
            }, new VoipClickCallback() {
                public boolean onClick(VoipCallModel voipCallModel) {
                    return false;
                }
            });
        }
    }

    /* renamed from: c */
    private void m14314c() {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(200);
        normalDialogInfo.setIcon(AlertController.IconType.INFO);
        normalDialogInfo.setTitle(this.mContext.getString(R.string.global_im_dialog_title));
        normalDialogInfo.setMessage(this.mContext.getString(R.string.global_im_dialog_content));
        normalDialogInfo.setPositiveText(this.mContext.getString(R.string.global_im_dialog_pos_text));
        normalDialogInfo.setNegativeText(this.mContext.getString(R.string.cancel));
        normalDialogInfo.setNeutralText(this.mContext.getString(R.string.global_im_dialog_neutral_text));
        normalDialogInfo.setCancelable(true);
        GlobalOmegaUtils.trackEvent("gd_endsIM_popup_sw");
        showDialog(normalDialogInfo);
    }

    /* renamed from: d */
    private void m14317d() {
        if (this.f17072f.passengerSheetObj != null) {
            PassengerSheetModel passengerSheetModel = new PassengerSheetModel();
            passengerSheetModel.parse(this.f17072f.passengerSheetObj);
            if (passengerSheetModel.options.size() > 1) {
                LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(passengerSheetModel.title, new LEGOBtnTextAndCallback(passengerSheetModel.options.get(0).text, new LEGOOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        AbsPhoneEntrancePresenter.this.m14318e();
                        if (AbsPhoneEntrancePresenter.this.f17077l != null) {
                            AbsPhoneEntrancePresenter.this.f17077l.dismiss();
                        }
                    }
                }));
                lEGODrawerModel1.setIsShowCloseImg(false);
                lEGODrawerModel1.setClickOutsideCanCancel(false);
                lEGODrawerModel1.setSubTitle(passengerSheetModel.subtitle);
                lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(passengerSheetModel.options.get(1).text, new LEGOOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        if (AbsPhoneEntrancePresenter.this.f17077l != null) {
                            AbsPhoneEntrancePresenter.this.f17077l.dismiss();
                        }
                    }
                }));
                this.f17077l = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m14318e() {
        String str;
        DriverOptionData driverOptionData = this.f17072f.data;
        if (driverOptionData != null) {
            int i = driverOptionData.businessId;
            if (driverOptionData.imBusinessId > 0) {
                i = driverOptionData.imBusinessId;
            }
            String valueOf = String.valueOf(driverOptionData.area);
            String str2 = driverOptionData.oid;
            long paseLong = !TextUtil.isEmpty(driverOptionData.driverId) ? TextUtil.paseLong(driverOptionData.driverId) : 0;
            long generateSessionId = IMEngine.generateSessionId(i, paseLong);
            IMBusinessParam iMBusinessParam = new IMBusinessParam();
            iMBusinessParam.setSessionId(generateSessionId);
            iMBusinessParam.setSelfUid(NationComponentDataUtil.getUid());
            iMBusinessParam.setPeerUid(paseLong);
            iMBusinessParam.setBusinessId(i);
            iMBusinessParam.setsOrderId(str2);
            iMBusinessParam.setCityID(valueOf);
            iMBusinessParam.setSecret(driverOptionData.imKey);
            iMBusinessParam.setPeerUserName(driverOptionData.name);
            iMBusinessParam.setPeerEngNickName(driverOptionData.name);
            iMBusinessParam.setPeerUserAvatar(driverOptionData.avatar);
            String userFirstName = NationComponentDataUtil.getUserFirstName();
            if (!TextUtils.isEmpty(userFirstName)) {
                iMBusinessParam.setSelfUserName(userFirstName);
                iMBusinessParam.setSelfEngNickName(userFirstName);
            } else {
                String string = ResourcesHelper.getString(this.mContext, R.string.global_im_default_name_prefix);
                String string2 = ResourcesHelper.getString(this.mContext, R.string.global_im_default_name_prefix_default);
                iMBusinessParam.setSelfUserName(string);
                iMBusinessParam.setSelfEngNickName(string2);
            }
            if (getHost() != null) {
                str = NationComponentDataUtil.getUserAvatarUrl(getHost().getContext());
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                iMBusinessParam.setSelfUserAvatar(str);
            }
            if (driverOptionData.isAvailableMsg != 0) {
                IMEngine.startChatDetailActivity(this.mContext, iMBusinessParam);
            } else if (generateSessionId > 0) {
                iMBusinessParam.setSecret("");
                IMEngine.startChatDetailActivity(this.mContext, iMBusinessParam);
                IMEngine.closeSession(generateSessionId);
                IMEngine.finishChatDetailAcvitiy(generateSessionId);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void phoneCall() {
        if (m14319f()) {
            expiredDialog4NewService();
        } else if (!TextUtils.isEmpty(this.mDriverPhone)) {
            actionCall(this.mDriverPhone);
        }
    }

    /* renamed from: f */
    private boolean m14319f() {
        return this.f17076j && !GlobalSPUtil.isNewServiceExpiredDialogShown(this.mContext);
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        if (i == 100) {
            dismissDialog(100);
            if (2 == i2) {
                DriverOptionModel driverOptionModel = this.f17072f;
                if (driverOptionModel != null) {
                    if (driverOptionModel.action == 2) {
                        if (!TextUtils.isEmpty(this.mDriverPhone)) {
                            actionCall(this.mDriverPhone);
                        }
                    } else if (!TextUtils.isEmpty(this.f17072f.scheme)) {
                        OnlineHelpUtil.startOnServiceHelp(this.mContext, this.f17072f.scheme);
                    } else {
                        OnlineHelpUtil.startOnServiceHelp(this.mContext);
                    }
                }
            } else if (1 == i2) {
                GlobalOmegaUtils.trackEvent("gd_endscall_cancel_btn_ck");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void actionCall(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void expiredDialog() {
        if (getHost() != null) {
            NormalDialogInfo normalDialogInfo = new NormalDialogInfo(100);
            normalDialogInfo.setIcon(AlertController.IconType.INFO);
            if (this.isGotoHelpCenter) {
                normalDialogInfo.setMessage(this.mContext.getString(R.string.global_phone_expired_phone_content_new));
                normalDialogInfo.setPositiveText(this.mContext.getString(R.string.global_phone_goto_help_center));
            } else {
                normalDialogInfo.setMessage(this.mContext.getString(R.string.global_phone_expired_phone_content));
                normalDialogInfo.setPositiveText(this.mContext.getString(R.string.global_phone_connect_custom_service));
                GlobalOmegaUtils.trackEvent("gd_endscall_popup_sw");
            }
            normalDialogInfo.setNegativeText(this.mContext.getString(R.string.cancel));
            normalDialogInfo.setCancelable(true);
            showDialog(normalDialogInfo);
        }
    }

    public void expiredDialog4New() {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(100);
        normalDialogInfo.setIcon(AlertController.IconType.INFO);
        normalDialogInfo.setTitle(this.mContext.getString(R.string.global_phone_expired_go_to_help_center_title));
        normalDialogInfo.setMessage(this.mContext.getString(R.string.global_phone_expired_go_to_help_center_content));
        normalDialogInfo.setPositiveText(this.mContext.getString(R.string.global_phone_goto_help_center));
        normalDialogInfo.setNegativeText(this.mContext.getString(R.string.cancel));
        normalDialogInfo.setCancelable(true);
        showDialog(normalDialogInfo);
    }

    /* access modifiers changed from: protected */
    public void expiredDialog4NewService() {
        if (getHost() != null && getHost() != null) {
            String string = ResourcesHelper.getString(this.mContext, R.string.global_phone_security_dialog_titile);
            String string2 = ResourcesHelper.getString(this.mContext, R.string.global_phone_security_dialog_content, NationTypeUtil.getNationComponentData().getBrand());
            if (!TextUtils.isEmpty(string2)) {
                string = (string + "\n\n") + string2;
            }
            String string3 = ResourcesHelper.getString(this.mContext, R.string.global_phone_security_dialog_confirm);
            String string4 = ResourcesHelper.getString(this.mContext, R.string.global_phone_security_dialog_cancel);
            PhoneSecurityDialog.Builder builder = new PhoneSecurityDialog.Builder();
            builder.setTitle(string);
            builder.setCancelListener(string4, new PhoneSecurityDialog.OnCancelClickedListener() {
                public void onCancelClicked(PhoneSecurityDialog phoneSecurityDialog) {
                    phoneSecurityDialog.dismiss();
                    AlertDialogBase unused = AbsPhoneEntrancePresenter.this.f17070d = null;
                }
            });
            builder.setConfirmListener(string3, new PhoneSecurityDialog.OnConfirmClickedListener() {
                public void onConfirmClicked(PhoneSecurityDialog phoneSecurityDialog) {
                    phoneSecurityDialog.dismiss();
                    AbsPhoneEntrancePresenter absPhoneEntrancePresenter = AbsPhoneEntrancePresenter.this;
                    absPhoneEntrancePresenter.actionCall(absPhoneEntrancePresenter.mDriverPhone);
                    AlertDialogBase unused = AbsPhoneEntrancePresenter.this.f17070d = null;
                }
            });
            this.f17070d = builder.build(this.mContext);
            Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
            if (currentActivity != null && (currentActivity instanceof FragmentActivity)) {
                FragmentActivity fragmentActivity = (FragmentActivity) currentActivity;
                if (fragmentActivity.getSupportFragmentManager() != null) {
                    GlobalSPUtil.setNewServiceExpiredDialogShown(this.mContext);
                    this.f17070d.show(fragmentActivity.getSupportFragmentManager(), (String) null);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void actionEmail(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME + str));
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("android.intent.extra.SUBJECT", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("android.intent.extra.TEXT", str3);
        }
        startActivity(intent);
    }

    /* renamed from: h */
    private void m14321h() {
        if (this.f17074h > 0) {
            GlobalOmegaUtils.trackEvent("pas_drivercard_phone_ck", "type", this.f17074h + "");
            return;
        }
        GlobalOmegaUtils.trackEvent("pas_drivercard_phone_ck");
    }
}
