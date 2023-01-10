package com.didi.component.service.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.didi.safety.god.IClientAppFunction;
import com.didi.safety.god.IClientAppInfo;
import com.didi.safety.god.manager.SafetyGod;
import com.didi.safety.god.manager.SafetyGodActivityDelegate;
import com.didi.safety.god.manager.SafetyGodConfig;
import com.didi.safety.god.manager.callback.SafetyGodCallBack;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.travel.psnger.model.RGCommonPopUp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class RGBlockingPopup extends SimplePopupBase {

    /* renamed from: a */
    private static final String f17714a = "RGBLOCKING_DATA_KEY";

    /* renamed from: b */
    private static final String f17715b = "RGBLOCKING_KEEPER_ID";

    /* renamed from: c */
    private static final String f17716c = "rgblocking_card_array";

    /* renamed from: d */
    private static final String f17717d = "rgblocking_biz_code";

    /* renamed from: e */
    private static final String f17718e = "rgblocking_extension";

    /* renamed from: f */
    private static final int f17719f = 4;

    /* renamed from: g */
    private static final String f17720g = "cpf_auth_h5_url";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f17721h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f17722i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f17723j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f17724k;

    /* renamed from: l */
    private TextView f17725l;

    /* renamed from: m */
    private TextView f17726m;

    /* renamed from: n */
    private TextView f17727n;

    /* renamed from: o */
    private TextView f17728o;

    /* renamed from: p */
    private TextView f17729p;

    /* renamed from: q */
    private ImageView f17730q;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_rg_blocking_popup;
    }

    public static RGBlockingPopup getInstance(RGCommonPopUp rGCommonPopUp, String str, int i, String str2, String str3, String str4) {
        RGBlockingPopup rGBlockingPopup = new RGBlockingPopup();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f17714a, rGCommonPopUp);
        bundle.putString(f17715b, str);
        bundle.putInt(f17717d, i);
        bundle.putString(f17716c, str2);
        bundle.putString(f17720g, str3);
        bundle.putString(f17718e, str4);
        rGBlockingPopup.setArguments(bundle);
        return rGBlockingPopup;
    }

    /* JADX WARNING: type inference failed for: r1v23, types: [java.io.Serializable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
            r7 = this;
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            android.view.View r1 = r7.mRootView
            r2 = 2131433810(0x7f0b1952, float:1.8489416E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r7.f17725l = r1
            android.view.View r1 = r7.mRootView
            r2 = 2131433807(0x7f0b194f, float:1.848941E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r7.f17726m = r1
            android.view.View r1 = r7.mRootView
            r2 = 2131433808(0x7f0b1950, float:1.8489412E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r7.f17727n = r1
            android.view.View r1 = r7.mRootView
            r2 = 2131433809(0x7f0b1951, float:1.8489414E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r7.f17728o = r1
            android.view.View r1 = r7.mRootView
            r2 = 2131433806(0x7f0b194e, float:1.8489408E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r7.f17729p = r1
            android.view.View r1 = r7.mRootView
            r2 = 2131433805(0x7f0b194d, float:1.8489406E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r7.f17730q = r1
            android.os.Bundle r1 = r7.getArguments()
            r2 = 0
            if (r1 == 0) goto L_0x00b0
            android.os.Bundle r1 = r7.getArguments()
            java.lang.String r2 = "RGBLOCKING_DATA_KEY"
            java.io.Serializable r1 = r1.getSerializable(r2)
            r2 = r1
            com.didi.travel.psnger.model.RGCommonPopUp r2 = (com.didi.travel.psnger.model.RGCommonPopUp) r2
            android.os.Bundle r1 = r7.getArguments()
            java.lang.String r3 = "RGBLOCKING_KEEPER_ID"
            java.io.Serializable r1 = r1.getSerializable(r3)
            java.lang.String r1 = (java.lang.String) r1
            android.os.Bundle r3 = r7.getArguments()
            java.lang.String r4 = "rgblocking_biz_code"
            java.io.Serializable r3 = r3.getSerializable(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r7.f17721h = r3
            android.os.Bundle r3 = r7.getArguments()
            java.lang.String r4 = "rgblocking_card_array"
            java.io.Serializable r3 = r3.getSerializable(r4)
            java.lang.String r3 = (java.lang.String) r3
            r7.f17722i = r3
            android.os.Bundle r3 = r7.getArguments()
            java.lang.String r4 = "cpf_auth_h5_url"
            java.io.Serializable r3 = r3.getSerializable(r4)
            java.lang.String r3 = (java.lang.String) r3
            r7.f17723j = r3
            android.os.Bundle r3 = r7.getArguments()
            java.lang.String r4 = "rgblocking_extension"
            java.lang.String r3 = r3.getString(r4)
            r7.f17724k = r3
            goto L_0x00b1
        L_0x00b0:
            r1 = r2
        L_0x00b1:
            if (r2 == 0) goto L_0x0154
            java.util.List<com.didi.travel.psnger.model.RGCommonPopUp$RGBlockingSelection> r3 = r2.selection
            if (r3 == 0) goto L_0x0154
            java.util.List<com.didi.travel.psnger.model.RGCommonPopUp$RGBlockingSelection> r3 = r2.selection
            int r3 = r3.size()
            r4 = 2
            if (r3 < r4) goto L_0x0154
            java.util.List<com.didi.travel.psnger.model.RGCommonPopUp$RGPopUpOptions> r3 = r2.options
            if (r3 == 0) goto L_0x0154
            java.util.List<com.didi.travel.psnger.model.RGCommonPopUp$RGPopUpOptions> r3 = r2.options
            int r3 = r3.size()
            if (r3 >= r4) goto L_0x00ce
            goto L_0x0154
        L_0x00ce:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = r2.title
            java.lang.String r5 = "title"
            r3.put(r5, r4)
            java.lang.String r4 = r2.showMsg
            java.lang.String r5 = "subtitle"
            r3.put(r5, r4)
            java.lang.String r4 = "gp_RGpopup_view_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.Object>) r3)
            android.widget.TextView r3 = r7.f17725l     // Catch:{ NullPointerException -> 0x0150 }
            java.lang.String r4 = r2.title     // Catch:{ NullPointerException -> 0x0150 }
            r3.setText(r4)     // Catch:{ NullPointerException -> 0x0150 }
            android.widget.TextView r3 = r7.f17726m     // Catch:{ NullPointerException -> 0x0150 }
            java.lang.String r4 = r2.showMsg     // Catch:{ NullPointerException -> 0x0150 }
            r3.setText(r4)     // Catch:{ NullPointerException -> 0x0150 }
            android.widget.TextView r3 = r7.f17727n     // Catch:{ NullPointerException -> 0x0150 }
            java.util.List<com.didi.travel.psnger.model.RGCommonPopUp$RGBlockingSelection> r4 = r2.selection     // Catch:{ NullPointerException -> 0x0150 }
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ NullPointerException -> 0x0150 }
            com.didi.travel.psnger.model.RGCommonPopUp$RGBlockingSelection r4 = (com.didi.travel.psnger.model.RGCommonPopUp.RGBlockingSelection) r4     // Catch:{ NullPointerException -> 0x0150 }
            java.lang.String r4 = r4.text     // Catch:{ NullPointerException -> 0x0150 }
            r3.setText(r4)     // Catch:{ NullPointerException -> 0x0150 }
            android.widget.TextView r3 = r7.f17728o     // Catch:{ NullPointerException -> 0x0150 }
            java.util.List<com.didi.travel.psnger.model.RGCommonPopUp$RGBlockingSelection> r4 = r2.selection     // Catch:{ NullPointerException -> 0x0150 }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ NullPointerException -> 0x0150 }
            com.didi.travel.psnger.model.RGCommonPopUp$RGBlockingSelection r4 = (com.didi.travel.psnger.model.RGCommonPopUp.RGBlockingSelection) r4     // Catch:{ NullPointerException -> 0x0150 }
            java.lang.String r4 = r4.text     // Catch:{ NullPointerException -> 0x0150 }
            r3.setText(r4)     // Catch:{ NullPointerException -> 0x0150 }
            android.widget.TextView r3 = r7.f17728o
            com.didi.component.service.view.RGBlockingPopup$1 r4 = new com.didi.component.service.view.RGBlockingPopup$1
            r4.<init>()
            r3.setOnClickListener(r4)
            java.util.List<com.didi.travel.psnger.model.RGCommonPopUp$RGPopUpOptions> r2 = r2.options
            java.util.Iterator r2 = r2.iterator()
        L_0x0124:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0138
            java.lang.Object r3 = r2.next()
            com.didi.travel.psnger.model.RGCommonPopUp$RGPopUpOptions r3 = (com.didi.travel.psnger.model.RGCommonPopUp.RGPopUpOptions) r3
            android.widget.TextView r4 = r7.f17729p
            java.lang.String r3 = r3.text
            r4.setText(r3)
            goto L_0x0124
        L_0x0138:
            android.widget.TextView r2 = r7.f17729p
            com.didi.component.service.view.RGBlockingPopup$2 r3 = new com.didi.component.service.view.RGBlockingPopup$2
            r3.<init>(r1, r0)
            r2.setOnClickListener(r3)
            android.widget.ImageView r0 = r7.f17730q
            com.didi.component.service.view.RGBlockingPopup$3 r1 = new com.didi.component.service.view.RGBlockingPopup$3
            r1.<init>()
            r0.setOnClickListener(r1)
            r7.setCancelable(r5)
            return
        L_0x0150:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.view.RGBlockingPopup.initView():void");
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getExtendObjectResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (72 == i) {
            dismiss();
        }
    }

    public void show(FragmentManager fragmentManager) {
        if (fragmentManager != null) {
            show(fragmentManager, RGBlockingPopup.class.getName());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14991a() {
        SafetyGod.init(getContext().getApplicationContext(), new IClientAppInfo() {
            public String getA3() {
                return null;
            }

            public double getLat() {
                return 0.0d;
            }

            public double getLng() {
                return 0.0d;
            }
        });
        SafetyGod.setClientAppFunction(new IClientAppFunction() {
            public void openCustomerService() {
            }

            public void openUrl(String str) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14994a(String str, String str2, int i, String str3, String str4, SafetyGodCallBack safetyGodCallBack, Activity activity) {
        SafetyGod.launch(activity, new SafetyGodConfig.Builder().setBizCode(i).setToken(str3).setKeeperId(str2).setCardArray(str).setNation(str4).setLanguage(LocaleCodeHolder.getInstance().getCurrentLang()).setActivityDelegate(new SafetyGodActivityDelegate() {
            public Context getAttachBaseContext(Context context) {
                return null;
            }
        }).builder(), safetyGodCallBack);
    }
}
