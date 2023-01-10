package com.didi.sdk.app;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.app.router.DRouterUtils;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMAssister;
import com.didi.beatles.p101im.access.IMContext;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.core.IMNotifyLister;
import com.didi.beatles.p101im.access.notify.NotificationUtils;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.access.utils.ConfigLoadListener;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.api.url.IMApiUrlGlobal;
import com.didi.beatles.p101im.api.url.IMBaseUrl;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.resource.IMThemeConstant;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushListener;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.push.manager.DPushType;
import com.didi.sdk.security.SecurityLib;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class OneMessageInit {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Logger f37963a = LoggerFactory.getLogger("OneMessageInit");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Context f37964b = null;

    /* renamed from: c */
    private static IMContext f37965c = null;

    /* renamed from: d */
    private static IMAssister f37966d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static IMNotifyLister f37967e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static IMPhoneClickListener f37968f = null;

    /* renamed from: g */
    private static final int f37969g = 201;

    /* renamed from: h */
    private static final int f37970h = 1001;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static DPushListener f37971i = new DPushListener() {
        public String topic() {
            return "4096";
        }

        public DPushType pushType() {
            return DPushType.TENCENT_PUSH;
        }

        public void pushBody(DPushBody dPushBody) {
            String str = new String(dPushBody.getData());
            if (!TextUtils.isEmpty(str) && dPushBody.getTopic().equals("4096") && OneMessageInit.f37967e != null) {
                OneMessageInit.f37967e.onPushArrive(str, 104);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static DPushListener f37972j = new DPushListener() {
        public String topic() {
            return "4096";
        }

        public DPushType pushType() {
            return DPushType.FCM_PUSH;
        }

        public void pushBody(DPushBody dPushBody) {
            String str = new String(dPushBody.getData());
            if (!TextUtils.isEmpty(str) && OneMessageInit.f37967e != null) {
                OneMessageInit.f37967e.onPushArrive(str, 104);
            }
        }
    };

    /* renamed from: k */
    private static volatile boolean f37973k = false;

    public static void initIMEngine(Context context) {
        f37963a.debug("init im", new Object[0]);
        f37964b = context.getApplicationContext();
        if (f37965c == null) {
            f37965c = m28635b(context);
        }
        if (f37966d == null) {
            f37966d = new IMAssister() {
                public void createPushChannel(IMNotifyLister iMNotifyLister) {
                    IMNotifyLister unused = OneMessageInit.f37967e = iMNotifyLister;
                    DPushManager.getInstance().registerPush(OneMessageInit.f37971i);
                    DPushManager.getInstance().registerPush(OneMessageInit.f37972j);
                }
            };
        }
        try {
            f37963a.debug("init im engine", new Object[0]);
            IMEngine.getInstance(context).initIMEngine(f37965c, f37966d);
            m28634a(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m28644i();
    }

    /* renamed from: i */
    private static void m28644i() {
        IMBusinessConfig iMBusinessConfig = new IMBusinessConfig();
        iMBusinessConfig.setIMStyle(IMStyleManager.Style.GLOBAL_PSG);
        iMBusinessConfig.registerPlugin((Integer) 1001);
        iMBusinessConfig.setConfigListener(new ConfigLoadListener() {
            public ArrayList<String> onQuickMessageLoaded(String str) {
                return OneMessageInit.m28637b(str);
            }

            public void onClickPhone(Context context, String str) {
                super.onClickPhone(context, str);
                if (OneMessageInit.f37968f != null) {
                    OneMessageInit.f37968f.clickPhone();
                } else if (!TextUtils.isEmpty(str) && context != null) {
                    OneMessageInit.actionCall(context, str);
                }
            }
        });
        IMEngine.registerBusinessConfig(f37964b, 201, iMBusinessConfig);
    }

    public static void setImPhoneClickListener(IMPhoneClickListener iMPhoneClickListener) {
        f37968f = iMPhoneClickListener;
    }

    public static void removePhoneClickListener(IMPhoneClickListener iMPhoneClickListener) {
        f37968f = null;
    }

    public static void actionCall(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    /* renamed from: a */
    private static void m28634a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationUtils.NOTIFICATION_ICON_ID, Integer.valueOf(R.drawable.global_im_notification_logo));
        hashMap.put("im_chat_user_mark_icon", Integer.valueOf(R.drawable.global_im_message_user_mark_icon));
        hashMap.put(IMThemeConstant.IM_TITLE_TEXTSIZE, Integer.valueOf(R.dimen.ms_18sp));
        hashMap.put(IMThemeConstant.IM_TITLE_FONT_COLOR, Integer.valueOf(R.color.black));
        hashMap.put(IMThemeConstant.IM_NOEMESSAGE_NEW_ICON, Integer.valueOf(R.drawable.global_im_message_icon_new));
        hashMap.put("im_nomix_orange", Integer.valueOf(R.color.global_im_caution_color));
        hashMap.put("im_common_title_bar_btn_back_selector", Integer.valueOf(R.drawable.common_title_bar_btn_back_selector));
        hashMap.put("im_overtime_icon", Integer.valueOf(R.drawable.global_im_message_icon_overtime));
        if (AppUtils.isBrazilApp(context)) {
            hashMap.put(NotificationUtils.NOTIFICATION_ICON_ID, Integer.valueOf(R.drawable.brazil_im_notification_logo));
            hashMap.put("im_nomix_onemessage_imagebg", Integer.valueOf(R.drawable.brazil_im_nomix_onemessage_imagebg));
            hashMap.put("im_chat_user_mark_icon", Integer.valueOf(R.drawable.brazil_im_message_user_mark_icon));
            hashMap.put("im_nomix_orange", Integer.valueOf(R.color.brazil_im_caution_color));
        }
        IMEngine.getInstance(context).registerIMResource(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static IMBusinessConfig m28645j() {
        IMBusinessConfig iMBusinessConfig = new IMBusinessConfig(4065);
        iMBusinessConfig.setIsFloatShowQuickButton(true);
        iMBusinessConfig.setIMStyle(IMStyleManager.Style.GLOBAL_PSG);
        iMBusinessConfig.setConfigListener(new ConfigLoadListener() {
            public ArrayList<String> onQuickMessageLoaded(String str) {
                return OneMessageInit.m28646k();
            }

            public void onClickPhone(Context context, String str) {
                super.onClickPhone(context, str);
                if (OneMessageInit.f37968f != null) {
                    OneMessageInit.f37968f.clickPhone();
                } else if (!TextUtils.isEmpty(str) && context != null) {
                    OneMessageInit.actionCall(context, str);
                }
            }
        });
        return iMBusinessConfig;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static ArrayList<String> m28646k() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_passanger_IM_quickReply_i18n");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray((String) experiment.getParam("quickReplyList", ""));
            ArrayList<String> arrayList = new ArrayList<>();
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(i, jSONArray.optString(i));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static ArrayList<String> m28637b(String str) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("vamos_IM_quickReply_i18n");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray((String) experiment.getParam("scene", ""));
            ArrayList<String> arrayList = new ArrayList<>();
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(i, jSONArray.optString(i));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void destroyIMEngine() {
        IMEngine.getInstance(f37964b).destroyIMEngine();
        f37965c = null;
        f37966d = null;
        f37967e = null;
    }

    /* renamed from: b */
    private static IMContext m28635b(final Context context) {
        return new IMContext() {
            public int getActivityTheme() {
                return R.style.GlobalActivityTheme;
            }

            public String getCurrenLoginUser() {
                return null;
            }

            public boolean getIMBottomConfig(int i) {
                return false;
            }

            public ArrayList<String> getQuickReplyList(int i) {
                return null;
            }

            public boolean isMoveInnerStorage() {
                return true;
            }

            public boolean showFeed() {
                return true;
            }

            public long getUid() {
                OneMessageInit.f37963a.debug("get uid", new Object[0]);
                try {
                    long parseLong = Long.parseLong(NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
                    if (parseLong == 0 && isLoginNow()) {
                        IMTraceUtil.addCodeErrorEvent().addErrno(9).addErrMsg("LoginFacade return uid is 0").report();
                    }
                    return parseLong;
                } catch (NumberFormatException e) {
                    OneMessageInit.f37963a.debug("init im error", new Object[0]);
                    if (isLoginNow()) {
                        IMTraceUtil.addCodeErrorEvent().addErrno(9).addErrMsg(e.getMessage()).report();
                    }
                    return 0;
                }
            }

            public String getToken() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
            }

            public boolean isLoginNow() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow();
            }

            public String getDeviceId() {
                return SecurityLib.getDeviceId(context.getApplicationContext());
            }

            public String getVersionName() {
                return SystemUtil.getVersionName(context);
            }

            public Class<?> getAppMainClass() {
                return MainActivityDispatcher.class;
            }

            public boolean isMainActivityAlive() {
                return ActivityLifecycleManager.getInstance().isMainActivityRunning();
            }

            public Uri getNotificationSoundUri() {
                return Uri.parse("android.resource://" + OneMessageInit.f37964b.getPackageName() + "/" + R.raw.global_im);
            }

            public int getAppChannel() {
                try {
                    return Integer.parseInt(AppUtils.getMetaDataByKey(EventKeys.APP_FCM_APPKEY));
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }

            public IMBaseUrl getIMUrlDelegate() {
                return new IMApiUrlGlobal();
            }

            public String getWebActivityScheme() {
                return NationTypeUtil.getNationComponentData().getProductPreFix() + IMContextInfoHelper.getContext().getString(R.string.im_common_web_uri);
            }

            public boolean handLink(Context context, String str) {
                if (TextUtils.isEmpty(str) || str.startsWith("http")) {
                    return false;
                }
                DRouterUtils.startUrlSafety(context, Uri.parse(str));
                return true;
            }

            public IMBusinessConfig getDefaultBusinessConfig() {
                return OneMessageInit.m28645j();
            }
        };
    }

    public static void init(Context context) {
        if (!f37973k) {
            f37973k = true;
            if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
                initIMEngine(context);
            }
        }
    }
}
