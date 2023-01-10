package com.didi.beatles.p101im.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.collection.LongSparseArray;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.datadog.android.monitoring.internal.InternalLogsFeature;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.action.IMActionFactory;
import com.didi.beatles.p101im.access.action.IMActionItem;
import com.didi.beatles.p101im.access.core.IMPushEngine;
import com.didi.beatles.p101im.access.core.IMStageFeedBack;
import com.didi.beatles.p101im.access.notify.NotificationUtils;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.access.style.custom.IMCustomContext;
import com.didi.beatles.p101im.access.style.custom.IMCustomResHelper;
import com.didi.beatles.p101im.access.utils.ConfigLoadListener;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.api.IMApiConst;
import com.didi.beatles.p101im.api.entity.IMBaseResponse;
import com.didi.beatles.p101im.api.entity.IMConfig;
import com.didi.beatles.p101im.api.entity.IMInvokePhoneRequest;
import com.didi.beatles.p101im.api.entity.IMInvokePhoneResponse;
import com.didi.beatles.p101im.api.entity.IMLocationEntity;
import com.didi.beatles.p101im.api.entity.IMOrderStatusChangeBody;
import com.didi.beatles.p101im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p101im.api.entity.IMSessionExtendInfo;
import com.didi.beatles.p101im.api.entity.IMTopOperationBody;
import com.didi.beatles.p101im.common.IMBtsAudioHelper;
import com.didi.beatles.p101im.common.IMBtsAudioPlayer;
import com.didi.beatles.p101im.common.IMChatHelper;
import com.didi.beatles.p101im.common.IMLifecycleHandler;
import com.didi.beatles.p101im.common.IMMessageList;
import com.didi.beatles.p101im.common.IMPollingService;
import com.didi.beatles.p101im.common.audio.IMFileHelper;
import com.didi.beatles.p101im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p101im.data.IMInnerData;
import com.didi.beatles.p101im.event.IMBackgroundSendMessage;
import com.didi.beatles.p101im.event.IMEventDispatcher;
import com.didi.beatles.p101im.event.IMMessageColloectionUpdateEvent;
import com.didi.beatles.p101im.event.IMMessageDetailFinishEvent;
import com.didi.beatles.p101im.event.IMMessageEmptyEvent;
import com.didi.beatles.p101im.event.IMMessageHandleExpiredPicEvent;
import com.didi.beatles.p101im.event.IMMessageSysCardShowEvent;
import com.didi.beatles.p101im.event.IMMessageUnlockRecyclerViewEvent;
import com.didi.beatles.p101im.event.IMMessageUpdateReadStatusEvent;
import com.didi.beatles.p101im.event.IMSendAddressEvent;
import com.didi.beatles.p101im.event.IMSessionInfoUpdateErrorEvent;
import com.didi.beatles.p101im.event.IMSessionInfoUpdateEvent;
import com.didi.beatles.p101im.event.IMShowCustomWordDialogEvent;
import com.didi.beatles.p101im.event.IMSkipToMainActivityEvent;
import com.didi.beatles.p101im.event.IMViewImageEvent;
import com.didi.beatles.p101im.event.IMViewStreetImageEvent;
import com.didi.beatles.p101im.manager.IMActionTipManager;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p101im.manager.IMStageFeedBackListerManager;
import com.didi.beatles.p101im.module.IIMGlobalModule;
import com.didi.beatles.p101im.module.IIMMessageModule;
import com.didi.beatles.p101im.module.IIMSessionModule;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMEmojiModule;
import com.didi.beatles.p101im.module.IMExtendBtnModule;
import com.didi.beatles.p101im.module.IMMessageCallBackImp;
import com.didi.beatles.p101im.module.IMMessageCallback;
import com.didi.beatles.p101im.module.IMPreSendCallback;
import com.didi.beatles.p101im.module.IMSendMessageCallback;
import com.didi.beatles.p101im.module.IMSessionCallback;
import com.didi.beatles.p101im.module.IMSessionCallbackAdapter;
import com.didi.beatles.p101im.module.IMUserInfoCallback;
import com.didi.beatles.p101im.module.entity.IMAddress;
import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.module.entity.IMUser;
import com.didi.beatles.p101im.module.impl.IMGroupUserInfoCallback;
import com.didi.beatles.p101im.net.IMHttpManager;
import com.didi.beatles.p101im.net.IMNetCallback;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.omega.OmegaUtil;
import com.didi.beatles.p101im.p102db.entity.IMMessageDaoEntity;
import com.didi.beatles.p101im.picture.IMPictureSelector;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.plugin.IMHostProxy;
import com.didi.beatles.p101im.plugin.IMPluginSendListener;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p101im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p101im.protocol.model.IMBottomGuideConfig;
import com.didi.beatles.p101im.protocol.model.IMTabActionItem;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMExpoMtaManager;
import com.didi.beatles.p101im.utils.IMField;
import com.didi.beatles.p101im.utils.IMIdGenerator;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMParamUtil;
import com.didi.beatles.p101im.utils.IMPollingUtils;
import com.didi.beatles.p101im.utils.IMRTLUtils;
import com.didi.beatles.p101im.utils.IMStreetUtils;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.IMToastHelper;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import com.didi.beatles.p101im.views.IMDialogFactory;
import com.didi.beatles.p101im.views.IMRecommendEmojiView;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.beatles.p101im.views.bottombar.IMBaseBottomBar;
import com.didi.beatles.p101im.views.bottombar.IMConversationBottomBar;
import com.didi.beatles.p101im.views.buttonView.IMTopOperationView;
import com.didi.beatles.p101im.views.dialog.IMAddCommonWordDialog;
import com.didi.beatles.p101im.views.dialog.IMDialog;
import com.didi.beatles.p101im.views.eggs.IMEggsLayout;
import com.didi.beatles.p101im.views.popup.IMExtendBtnPopup;
import com.didi.beatles.p101im.views.popup.IMMessageOperatePopup;
import com.didi.beatles.p101im.views.titlebar.CommonTitleBar;
import com.didi.beatles.p101im.views.widget.IMLoadingView;
import com.didi.beatles.p101im.views.widget.IMSimpleGuideView;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.taxis99.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rui.config.RConfigConstants;

/* renamed from: com.didi.beatles.im.activity.IMMessageActivity */
public class IMMessageActivity extends IMBaseActivity implements MessageAdapter.MessageAdapterListener, IMUserInfoCallback, IMPluginSendListener, IMBaseBottomBar.BottomBarListener {
    public static long CURRENT_SID = -1;
    public static final String EXTRA_TAG_BUSINESSS_PARAM = "business_param";
    public static final String EXTRA_TAG_SOURCE = "source";

    /* renamed from: b */
    private static final String f10753b = "IMMessageActivity";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final boolean f10754c = IMField.DEBUG;

    /* renamed from: d */
    private static final int f10755d = 0;

    /* renamed from: e */
    private static final int f10756e = 1;

    /* renamed from: h */
    private static final int f10757h = 1;

    /* renamed from: i */
    private static final int f10758i = 120;

    /* renamed from: j */
    private static final int f10759j = 2;

    /* renamed from: k */
    private static final int f10760k = 3;

    /* renamed from: l */
    private static final int f10761l = 4;

    /* renamed from: m */
    private static final int f10762m = 5;

    /* renamed from: n */
    private static final int f10763n = 6;

    /* renamed from: o */
    private static final int f10764o = 7;

    /* renamed from: A */
    private IIMGlobalModule f10765A;

    /* renamed from: B */
    private final String f10766B = "IMDIALOG";
    /* access modifiers changed from: private */

    /* renamed from: C */
    public long f10767C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public IMSession f10768D;

    /* renamed from: E */
    private IMCustomContext f10769E;

    /* renamed from: F */
    private View f10770F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public IMExtendBtnPopup f10771G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public View f10772H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public IMBusinessParam f10773I = null;

    /* renamed from: J */
    private IMMessageCallback f10774J = null;

    /* renamed from: K */
    private IMSessionCallback f10775K = null;

    /* renamed from: L */
    private IMStaticSessionModuleListener f10776L = null;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public int f10777M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public boolean f10778N = true;

    /* renamed from: O */
    private IMRecommendEmojiView f10779O;

    /* renamed from: P */
    private int f10780P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public ImageView f10781Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public TextView f10782R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public Set<IMMessage> f10783S = new TreeSet($$Lambda$IMMessageActivity$KqlCFovtYRgFSON5P6eGoX3Jzz8.INSTANCE);

    /* renamed from: T */
    private int f10784T;

    /* renamed from: U */
    private LongSparseArray<IMMessage> f10785U = new LongSparseArray<>(1);
    /* access modifiers changed from: private */

    /* renamed from: V */
    public PopupWindow f10786V;

    /* renamed from: W */
    private HeadsetPlugReceiver f10787W;

    /* renamed from: X */
    private boolean f10788X;

    /* renamed from: Y */
    private boolean f10789Y = false;

    /* renamed from: Z */
    private boolean f10790Z = false;

    /* renamed from: a */
    View.OnTouchListener f10791a = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || IMMessageActivity.this.f10797g == null) {
                return false;
            }
            IMMessageActivity.this.f10797g.shrinkBottomBarByRecycle();
            return false;
        }
    };

    /* renamed from: aa */
    private boolean f10792aa = false;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public final Handler f10793ab = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 7 && IMMessageActivity.this.f10786V != null && IMMessageActivity.this.f10786V.isShowing()) {
                try {
                    IMMessageActivity.this.f10786V.dismiss();
                    PopupWindow unused = IMMessageActivity.this.f10786V = null;
                } catch (Exception e) {
                    IMLog.m10022e(e);
                }
            }
        }
    };

    /* renamed from: ac */
    private View.OnClickListener f10794ac = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (IMMessageActivity.this.f10768D.getType() == 2) {
                IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                IMGroupProfileActivity.startActivity(iMMessageActivity, iMMessageActivity.f10767C);
                return;
            }
            IMTraceUtil.addBusinessEvent("ddim_service_item_profile_ck").add("product_id", Integer.valueOf(IMMessageActivity.this.f10768D.getBusinessId())).add("no_appid", Long.valueOf(IMMessageActivity.this.f10768D.getPeerUid())).report();
            IMMessageActivity iMMessageActivity2 = IMMessageActivity.this;
            IMUserProfileActivity.startActivity(iMMessageActivity2, iMMessageActivity2.f10768D.getSessionName(), IMMessageActivity.this.f10768D.getPeerUid());
        }
    };

    /* renamed from: ad */
    private View.OnClickListener f10795ad = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (IMMessageActivity.this.f10768D != null && IMMessageActivity.this.f10768D.getExtendSessionInfo() != null) {
                IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                IMCommonUtil.startUriActivity(iMMessageActivity, iMMessageActivity.f10768D.getExtendSessionInfo().slink);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CommonTitleBar f10796f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IMBaseBottomBar f10797g;
    public IMLifecycleHandler.Controller mController;
    public View.OnLayoutChangeListener mLayoutChangeListener = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int windowHeight = IMViewUtil.getWindowHeight(IMMessageActivity.this) / 3;
            if (i8 != 0 && i4 != 0 && i8 - i4 > windowHeight) {
                IMMessageActivity.this.m9445r();
            }
        }
    };

    /* renamed from: p */
    private FrameLayout f10798p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public RecyclerView f10799q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public IMEggsLayout f10800r;

    /* renamed from: s */
    private IMTopOperationView f10801s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public MessageAdapter f10802t;

    /* renamed from: u */
    private final int f10803u = 20;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public IMBusinessConfig f10804v;

    /* renamed from: w */
    private IMDialog f10805w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public IIMSessionModule f10806x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public IIMMessageModule f10807y;

    /* renamed from: z */
    private IIMUserModule f10808z;

    public Context getHostContext() {
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m9377a(IMMessage iMMessage, IMMessage iMMessage2) {
        if (iMMessage == null || iMMessage.getCloudUniqueMsgId() == null || iMMessage2 == null || iMMessage2.getCloudUniqueMsgId() == null) {
            return 0;
        }
        return iMMessage.getCloudUniqueMsgId().compareTo(iMMessage2.getCloudUniqueMsgId());
    }

    public void sendPluginTextMessage(int i, String str, int i2, Object obj) {
        m9399a(str, i2, -1, obj);
    }

    public void sendPluginMessage(int i, String str, String str2, int i2) {
        if (this.f10807y != null && this.f10773I != null) {
            m9441p();
            m9408b(this.f10807y.sendPluginMessage(i, str, str2, i2, this.f10773I, this.f10768D, (IMSendMessageCallback) null));
        }
    }

    public void sendStreetViewMessage(int i) {
        IMBusinessParam iMBusinessParam;
        IMSession iMSession;
        if (!IMStreetUtils.canClickStreetView()) {
            IMToastHelper.showLongError(IMContextInfoHelper.getContext(), getString(R.string.im_plugin_street_image_send_frequently));
            return;
        }
        IIMMessageModule iIMMessageModule = this.f10807y;
        if (iIMMessageModule != null && (iMBusinessParam = this.f10773I) != null && (iMSession = this.f10768D) != null) {
            iIMMessageModule.sendStreetViewMessage(i, iMBusinessParam, iMSession);
        }
    }

    public void sendLocationMessage(IMSendAddressEvent iMSendAddressEvent, boolean z) {
        IMAddress iMAddress = iMSendAddressEvent.address;
        if (iMAddress == null) {
            IMLog.m10019d("[sendLocationMessage] address is null");
            return;
        }
        IIMMessageModule iIMMessageModule = this.f10807y;
        if (iIMMessageModule != null) {
            m9408b(iIMMessageModule.sendLocationMessage(buildFromAddress(iMAddress), IMApiConst.MsgTypeSendLocation, this.f10773I, this.f10768D));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveBackgroundSendMsg(IMBackgroundSendMessage iMBackgroundSendMessage) {
        if (iMBackgroundSendMessage != null && iMBackgroundSendMessage.imMessage != null && iMBackgroundSendMessage.imMessage.getSid() == this.f10768D.getSessionId()) {
            m9408b(iMBackgroundSendMessage.imMessage);
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMMessageActivity$HeadsetPlugReceiver */
    private static class HeadsetPlugReceiver extends BroadcastReceiver {
        private HeadsetPlugReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (IMMessageActivity.f10754c) {
                String tag = IMField.getTag(IMMessageActivity.f10753b);
                IMLog.m10020d(tag, "onReceive() called with: context = [" + context + "], intent = [" + intent + Const.jaRight);
            }
            IMBtsAudioHelper.stopPlaying();
        }
    }

    /* renamed from: b */
    private void m9405b() {
        try {
            this.f10787W = new HeadsetPlugReceiver();
            try {
                registerReceiver(this.f10787W, new IntentFilter("android.intent.action.HEADSET_PLUG"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private void m9413c() {
        HeadsetPlugReceiver headsetPlugReceiver = this.f10787W;
        if (headsetPlugReceiver != null) {
            try {
                unregisterReceiver(headsetPlugReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f10787W = null;
        }
    }

    public static void startActivity(Context context, IMSession iMSession) {
        Intent intent = new Intent(context, IMMessageActivity.class);
        intent.putExtra("mSession", iMSession);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        m9435m();
        if (parseIntent(getIntent())) {
            setContentView((int) R.layout.im_activity_message);
            EventBus.getDefault().register(this);
            IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
            if (sessionModel != null) {
                IMStaticSessionModuleListener iMStaticSessionModuleListener = new IMStaticSessionModuleListener(this);
                this.f10776L = iMStaticSessionModuleListener;
                sessionModel.registerSessionCallback(iMStaticSessionModuleListener);
            }
            m9417d();
        }
    }

    /* renamed from: d */
    private void m9417d() {
        setVolumeControlStream(IMContextInfoHelper.getAudioConfig().getStreamType());
        if (m9439o()) {
            IMHostProxy.getInstance().registerPluginSendListener(this);
            m9423g();
            m9381a(0);
            m9436n();
            m9425h();
            m9421f();
            NotificationUtils.cancelNotification();
            m9419e();
            IIMGlobalModule iIMGlobalModule = this.f10765A;
            if (iIMGlobalModule != null) {
                iIMGlobalModule.loadGlobalConfig(false);
            }
        }
    }

    /* renamed from: e */
    private void m9419e() {
        if (this.f10768D.getExtendSessionInfo() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(InternalLogsFeature.ENV_NAME, Integer.valueOf(this.f10777M));
            hashMap.put("uid", Long.valueOf(IMSession.getPeerId(this.f10768D.getUserIds()).longValue() & -281474976710657L));
            hashMap.put("app", getPackageName());
            hashMap.put("sou", Integer.valueOf(this.f10780P));
            hashMap.put("order_id", getOrderId());
            hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, getRouteId());
            hashMap.put("type", Integer.valueOf((this.f10768D.getPeerUid() >> 48) == 1 ? 1 : 2));
            hashMap.put("input", Integer.valueOf(this.f10768D.getExtendSessionInfo().input));
            OmegaUtil.trackIMEvent("ddim_xq_all_detail_ck", hashMap);
            if (this.f10768D.getType() == 4) {
                IMTraceUtil.addBusinessEvent("ddim_service_item_sw").add("product_id", Integer.valueOf(this.f10768D.getBusinessId())).add("no_appid", Long.valueOf(this.f10768D.getPeerUid())).add("send_uid", Long.valueOf(this.f10768D.getPeerUid())).add("from", Integer.valueOf(this.f10784T)).report();
            } else {
                IMTraceUtil.addBusinessEvent("ddim_message_dialog_sw").add("product_id", Integer.valueOf(this.f10768D.getBusinessId())).add("client_type", IMContextInfoHelper.getPackageName()).add("send_uid", Long.valueOf(this.f10768D.getPeerUid())).add("from", Integer.valueOf(this.f10784T)).add("order_id", IMParamUtil.getTraceOrderId(this.f10773I, this.f10768D)).report();
            }
        }
    }

    /* renamed from: f */
    private void m9421f() {
        IMMsgOmega.getInstance().init(IMSession.getSelfId(this.f10768D.getUserIds()).longValue() & -281474976710657L, this.f10777M);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0147, code lost:
        if (r8 != 3) goto L_0x0149;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean parseIntent(android.content.Intent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "IMMessageActivity"
            r1 = 0
            java.lang.Class<com.didi.beatles.im.module.entity.IMBusinessParam> r2 = com.didi.beatles.p101im.module.entity.IMBusinessParam.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ Exception -> 0x015c }
            r8.setExtrasClassLoader(r2)     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = "business_param"
            android.os.Parcelable r2 = r8.getParcelableExtra(r2)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMBusinessParam r2 = (com.didi.beatles.p101im.module.entity.IMBusinessParam) r2     // Catch:{ Exception -> 0x015c }
            r7.f10773I = r2     // Catch:{ Exception -> 0x015c }
            if (r2 == 0) goto L_0x0032
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r2.<init>()     // Catch:{ Exception -> 0x015c }
            java.lang.String r3 = "ParseIntent mIMBusinessParam:"
            r2.append(r3)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMBusinessParam r3 = r7.f10773I     // Catch:{ Exception -> 0x015c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x015c }
            r2.append(r3)     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.p101im.utils.IMLog.m10020d(r0, r2)     // Catch:{ Exception -> 0x015c }
        L_0x0032:
            com.didi.beatles.im.module.entity.IMBusinessParam r2 = r7.f10773I     // Catch:{ Exception -> 0x015c }
            if (r2 == 0) goto L_0x0153
            com.didi.beatles.im.module.entity.IMBusinessParam r2 = r7.f10773I     // Catch:{ Exception -> 0x015c }
            long r2 = r2.getSessionId()     // Catch:{ Exception -> 0x015c }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0044
            goto L_0x0153
        L_0x0044:
            com.didi.beatles.im.module.entity.IMBusinessParam r2 = r7.f10773I     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r2 = com.didi.beatles.p101im.module.entity.IMSession.structureSession(r2)     // Catch:{ Exception -> 0x015c }
            r7.f10768D = r2     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.IIMSessionModule r2 = r7.f10806x     // Catch:{ Exception -> 0x015c }
            r3 = 1
            if (r2 == 0) goto L_0x00d4
            com.didi.beatles.im.module.IIMSessionModule r2 = r7.f10806x     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMBusinessParam r4 = r7.f10773I     // Catch:{ Exception -> 0x015c }
            long r4 = r4.getSessionId()     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r2 = r2.getSessionFromLocal(r4)     // Catch:{ Exception -> 0x015c }
            if (r2 == 0) goto L_0x00d4
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            boolean r5 = r2.getSessionEnable()     // Catch:{ Exception -> 0x015c }
            r4.setSessionEnable(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionExtendInfo r5 = r2.getExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            r4.setExtendSessionInfo(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionClientExtendInfo r5 = r2.getClientExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            r4.setClientExtendInfo(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionServiceExtendInfo r5 = r2.getServiceExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            r4.setServiceExtendInfo(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionRecentMessages r5 = r2.getRecentMessages()     // Catch:{ Exception -> 0x015c }
            r4.setRecentMessages((com.didi.beatles.p101im.api.entity.IMSessionRecentMessages) r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            java.lang.String r5 = r2.getSessionName()     // Catch:{ Exception -> 0x015c }
            r4.setSessionName(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            int r5 = r2.getType()     // Catch:{ Exception -> 0x015c }
            r4.setType(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            java.lang.String r5 = r2.getDraft()     // Catch:{ Exception -> 0x015c }
            r4.setDraft(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            int r5 = r2.getBusinessId()     // Catch:{ Exception -> 0x015c }
            r4.setBusinessId(r5)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionExtendInfo r4 = r2.getExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            if (r4 == 0) goto L_0x00d4
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionExtendInfo r5 = r2.getExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            int r5 = r5.ack     // Catch:{ Exception -> 0x015c }
            if (r5 != r3) goto L_0x00c2
            r5 = 1
            goto L_0x00c3
        L_0x00c2:
            r5 = 0
        L_0x00c3:
            r4.supportMsgReadStatus = r5     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.api.entity.IMSessionExtendInfo r2 = r2.getExtendSessionInfo()     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = r2.lag_ty     // Catch:{ Exception -> 0x015c }
            if (r2 == 0) goto L_0x00d1
            r2 = 1
            goto L_0x00d2
        L_0x00d1:
            r2 = 0
        L_0x00d2:
            r4.supportTranslate = r2     // Catch:{ Exception -> 0x015c }
        L_0x00d4:
            com.didi.beatles.im.module.entity.IMSession r2 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            int r2 = r2.getBusinessId()     // Catch:{ Exception -> 0x015c }
            r7.f10777M = r2     // Catch:{ Exception -> 0x015c }
            android.content.Context r2 = com.didi.beatles.p101im.IMContextInfoHelper.getContext()     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.access.IMEngine r2 = com.didi.beatles.p101im.access.IMEngine.getInstance(r2)     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            int r4 = r4.getType()     // Catch:{ Exception -> 0x015c }
            int r5 = r7.f10777M     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.access.utils.IMBusinessConfig r2 = r2.getCurrentBusinessConfig(r4, r5)     // Catch:{ Exception -> 0x015c }
            r7.f10804v = r2     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r2 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            long r4 = r2.getSessionId()     // Catch:{ Exception -> 0x015c }
            r7.f10767C = r4     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.access.style.custom.IMCustomContext r2 = new com.didi.beatles.im.access.style.custom.IMCustomContext     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMBusinessParam r5 = r7.f10773I     // Catch:{ Exception -> 0x015c }
            r2.<init>(r4, r5)     // Catch:{ Exception -> 0x015c }
            r7.f10769E = r2     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = "source"
            r4 = 8
            int r8 = r8.getIntExtra(r2, r4)     // Catch:{ Exception -> 0x015c }
            r7.f10780P = r8     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r8 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            int r8 = r8.getType()     // Catch:{ Exception -> 0x015c }
            r2 = 4
            if (r8 != r2) goto L_0x0122
            com.didi.beatles.im.module.entity.IMBusinessParam r8 = r7.f10773I     // Catch:{ Exception -> 0x015c }
            int r8 = r8.getBusinessId()     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.p101im.resource.IMResource.setBusinessId(r8)     // Catch:{ Exception -> 0x015c }
            goto L_0x0127
        L_0x0122:
            int r8 = r7.f10777M     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.p101im.resource.IMResource.setBusinessId(r8)     // Catch:{ Exception -> 0x015c }
        L_0x0127:
            int r8 = r7.f10780P     // Catch:{ Exception -> 0x015c }
            com.didi.beatles.im.module.entity.IMSession r4 = r7.f10768D     // Catch:{ Exception -> 0x015c }
            int r4 = r4.getType()     // Catch:{ Exception -> 0x015c }
            r5 = 3
            r6 = 2
            if (r4 != r2) goto L_0x0143
            if (r8 == r3) goto L_0x0150
            if (r8 == r6) goto L_0x014d
            if (r8 == r5) goto L_0x014b
            r2 = 9
            if (r8 == r2) goto L_0x014f
            r2 = 10
            if (r8 == r2) goto L_0x0149
            r2 = 5
            goto L_0x0150
        L_0x0143:
            if (r8 == r3) goto L_0x014f
            if (r8 == r6) goto L_0x014d
            if (r8 == r5) goto L_0x014b
        L_0x0149:
            r2 = 3
            goto L_0x0150
        L_0x014b:
            r2 = 0
            goto L_0x0150
        L_0x014d:
            r2 = 1
            goto L_0x0150
        L_0x014f:
            r2 = 2
        L_0x0150:
            r7.f10784T = r2     // Catch:{ Exception -> 0x015c }
            return r3
        L_0x0153:
            java.lang.String r8 = "inValid ImBusinessParam When Start IMMessageActivity"
            com.didi.beatles.p101im.utils.IMLog.m10020d(r0, r8)     // Catch:{ Exception -> 0x015c }
            r7.finish()     // Catch:{ Exception -> 0x015c }
            return r1
        L_0x015c:
            r7.finish()
            java.lang.String r8 = "IMMessageActivity Can't Parse Intent Exception"
            com.didi.beatles.p101im.utils.IMLog.m10020d(r0, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.activity.IMMessageActivity.parseIntent(android.content.Intent):boolean");
    }

    /* renamed from: g */
    private void m9423g() {
        IMBusinessConfig iMBusinessConfig = this.f10804v;
        if (iMBusinessConfig != null && iMBusinessConfig.isShowEmoji() && IMInnerData.getInstance().getEmojiPrefix() == null) {
            this.f10804v.getIMEmojiList(this.f10768D.getExtendSessionInfo() != null ? this.f10768D.getExtendSessionInfo().qk_key : "", this.f10777M, new ConfigLoadListener.IMGetEmojiListCallback() {
                public void finishLoad(ArrayList<IMEmojiModule> arrayList) {
                    if (arrayList != null && arrayList.size() > 0) {
                        IMInnerData.getInstance().setEmojiPrefix(arrayList.get(0).host);
                    }
                }
            });
        }
    }

    /* renamed from: h */
    private void m9425h() {
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.im_title_bar);
        this.f10796f = commonTitleBar;
        if (commonTitleBar == null) {
            finish();
            return;
        }
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            this.f10796f.resetLayout(R.layout.im_common_title_bar_global_psg);
        } else {
            this.f10796f.initResource();
        }
        this.f10796f.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageActivity.this.m9447s();
                IMMessageActivity.this.finish();
            }
        });
        this.f10796f.setTitleConfig(this.f10804v);
        m9432l();
        m9427i();
    }

    /* renamed from: i */
    private void m9427i() {
        if (this.f10796f == null) {
            m9425h();
        }
        IMLog.m10020d(f10753b, "refreshTitleBar type = " + this.f10768D.getType() + "  num = " + this.f10768D.getGroupNum());
        String str = null;
        if (TextUtils.isEmpty(this.f10768D.getSessionName())) {
            m9443q();
        } else if (this.f10768D.getType() == 2) {
            CommonTitleBar commonTitleBar = this.f10796f;
            commonTitleBar.setTitle(this.f10768D.getSessionName() + "(" + this.f10768D.getGroupNum() + ")");
        } else {
            OmegaUtil.trackTitleNamePath((String) null, this.f10768D, 3);
            this.f10796f.setTitle(this.f10768D.getSessionName());
        }
        IMSessionExtendInfo extendSessionInfo = this.f10768D.getExtendSessionInfo();
        if (extendSessionInfo != null && !TextUtils.isEmpty(extendSessionInfo.titleExtendInfo)) {
            this.f10796f.setSubTitle(extendSessionInfo.titleExtendInfo);
        }
        if (this.f10768D.getExtendSessionInfo() != null) {
            str = this.f10768D.getExtendSessionInfo().slink;
        }
        if (this.f10768D.getType() == 2 || !TextUtils.isEmpty(str)) {
            this.f10796f.setRightImg(R.drawable.im_home_nav_my);
            if (this.f10796f.getRightTextView() != null) {
                this.f10796f.getRightTextView().setContentDescription(IMResource.getString(R.string.im_accessibility_personal));
            }
            if (this.f10768D.getType() == 4 || this.f10768D.getType() == 2) {
                this.f10796f.setRightClickListener(this.f10794ac);
            } else {
                this.f10796f.setRightClickListener(this.f10795ad);
            }
        } else {
            this.f10796f.hideRightImg();
            IMBusinessParam iMBusinessParam = this.f10773I;
            if (iMBusinessParam == null || (TextUtils.isEmpty(iMBusinessParam.getPhoneNum()) && !this.f10773I.getShowChatTitleRightIcon())) {
                m9431k();
            } else {
                m9429j();
            }
        }
    }

    /* renamed from: j */
    private void m9429j() {
        IMBusinessParam iMBusinessParam = this.f10773I;
        if (iMBusinessParam == null) {
            return;
        }
        if (!TextUtils.isEmpty(iMBusinessParam.getPhoneNum()) || this.f10773I.getShowChatTitleRightIcon()) {
            this.f10796f.setRightImg(IMResource.getDrawableID(R.drawable.im_titlebar_call_phone));
            this.f10796f.setRightClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMBusinessConfig d = IMMessageActivity.this.f10804v;
                    IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                    d.onClickPhone(iMMessageActivity, iMMessageActivity.f10773I.getPhoneNum());
                    IMBusinessConfig d2 = IMMessageActivity.this.f10804v;
                    IMMessageActivity iMMessageActivity2 = IMMessageActivity.this;
                    d2.onChatTitleRightIconClick(iMMessageActivity2, iMMessageActivity2.f10796f.getRightImg());
                }
            });
            if (!this.f10790Z && !TextUtils.isEmpty(this.f10773I.getPhoneFuncGuide()) && !IMPreference.getInstance(this).isPhoneGuideShow(IMContextInfoHelper.getUid())) {
                this.f10790Z = true;
                new IMSimpleGuideView.Builder(this).isShowForkView(true).setGuideText(this.f10773I.getPhoneFuncGuide()).setTargetView(this.f10796f.getRightTextView()).setOutsideTouchable(true).setMaxWordNumSingleLine(16).setLayoutGravity(2).setGrivaty(3).setDismissListener(new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        IMPreference.getInstance(IMMessageActivity.this).setPhoneGuideShow(IMContextInfoHelper.getUid());
                    }
                }).create().show();
            }
        }
    }

    /* renamed from: k */
    private void m9431k() {
        LinearLayout.LayoutParams layoutParams;
        IMSessionExtendInfo extendSessionInfo = this.f10768D.getExtendSessionInfo();
        if (extendSessionInfo != null && extendSessionInfo.sideMenu != null && !extendSessionInfo.sideMenu.isEmpty() && this.f10796f.getRightLayout() != null) {
            LinearLayout rightLayout = this.f10796f.getRightLayout();
            rightLayout.setVisibility(0);
            HashMap hashMap = new HashMap(2);
            for (int i = 0; i < rightLayout.getChildCount(); i++) {
                View childAt = rightLayout.getChildAt(i);
                if (childAt instanceof TextView) {
                    hashMap.put(String.valueOf(childAt.getTag()), (TextView) childAt);
                }
            }
            rightLayout.removeAllViews();
            for (int i2 = 0; i2 < extendSessionInfo.sideMenu.size(); i2++) {
                final IMSessionExtendInfo.SideMenu sideMenu = extendSessionInfo.sideMenu.get(i2);
                final TextView textView = (TextView) hashMap.get(sideMenu.type);
                if (textView == null) {
                    textView = new TextView(this);
                    textView.setTag(sideMenu.type);
                }
                if (!TextUtils.isEmpty(sideMenu.icon)) {
                    if ("phone".equals(sideMenu.icon)) {
                        textView.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_titlebar_call_phone));
                    }
                    layoutParams = new LinearLayout.LayoutParams(IMViewUtil.dp2px(this, 20.0f), IMViewUtil.dp2px(this, 20.0f));
                } else {
                    textView.setTextSize(14.0f);
                    textView.setTextColor(Color.parseColor("#1C3947"));
                    textView.setText(sideMenu.text);
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                }
                if (i2 != 0) {
                    layoutParams.leftMargin = IMViewUtil.dp2px(this, 20.0f);
                }
                rightLayout.addView(textView, layoutParams);
                textView.setOnClickListener(new IMOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        String str;
                        String str2;
                        String str3;
                        if (IMSessionExtendInfo.SideMenu.TYPE_COMPLAINT.equals(sideMenu.type)) {
                            IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("beat_p_imrpt_btn_ck").add("uid", Long.valueOf(IMContextInfoHelper.getUid()));
                            if (IMMessageActivity.this.f10768D.getExtendSessionInfo() == null) {
                                str2 = "";
                            } else {
                                str2 = IMMessageActivity.this.f10768D.getExtendSessionInfo().routeId;
                            }
                            IMTraceUtil.BusinessParam add2 = add.add(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, str2);
                            if (IMMessageActivity.this.f10768D.getExtendSessionInfo() == null) {
                                str3 = "";
                            } else {
                                str3 = IMMessageActivity.this.f10768D.getExtendSessionInfo().orderId;
                            }
                            add2.add("order_id", str3).add("rec_channel", "1").report();
                        }
                        int g = IMMessageActivity.this.f10777M;
                        if (IMMessageActivity.this.f10773I == null) {
                            str = "";
                        } else {
                            str = IMMessageActivity.this.f10773I.getPeerUid() + "";
                        }
                        IMHttpManager.getInstance().performCommonPost(new IMInvokePhoneRequest(g, str, IMMessageActivity.this.f10767C + "", sideMenu.type), new IMNetCallback<IMInvokePhoneResponse>() {
                            public void success(final IMInvokePhoneResponse iMInvokePhoneResponse) {
                                if (iMInvokePhoneResponse != null && iMInvokePhoneResponse.body != null) {
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            if (!IMTextUtil.isEmpty(iMInvokePhoneResponse.body.phone)) {
                                                IMMessageActivity.this.f10804v.onClickPhone(IMMessageActivity.this, iMInvokePhoneResponse.body.phone);
                                                if (IMMessageActivity.this.f10796f != null) {
                                                    IMMessageActivity.this.f10804v.onChatTitleRightIconClick(IMMessageActivity.this, IMMessageActivity.this.f10796f.getRightImg());
                                                }
                                            } else if (!IMTextUtil.isEmpty(iMInvokePhoneResponse.body.link)) {
                                                IMCommonUtil.startUriActivity(IMMessageActivity.this, iMInvokePhoneResponse.body.link);
                                            } else if (!IMTextUtil.isEmpty(iMInvokePhoneResponse.body.text)) {
                                                IMMessageActivity.this.m9383a((int) R.drawable.im_toast_warm, iMInvokePhoneResponse.body.text);
                                            } else {
                                                C44781.this.failure((IOException) null);
                                            }
                                        }
                                    });
                                }
                            }

                            public void failure(IOException iOException) {
                                UiThreadHandler.post(new Runnable() {
                                    public void run() {
                                        IMMessageActivity.this.m9383a((int) R.drawable.im_toast_warm, IMResource.getString(R.string.bts_im_no_network));
                                    }
                                });
                            }
                        });
                    }
                });
                if (IMSessionExtendInfo.SideMenu.TYPE_COMPLAINT.equals(sideMenu.type)) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            IMMessageActivity.this.m9384a(textView);
                        }
                    });
                    if (!this.f10792aa) {
                        this.f10792aa = true;
                        String str = "";
                        IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("beat_p_imrpt_btn_sw").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, this.f10768D.getExtendSessionInfo() == null ? str : this.f10768D.getExtendSessionInfo().routeId);
                        if (this.f10768D.getExtendSessionInfo() != null) {
                            str = this.f10768D.getExtendSessionInfo().orderId;
                        }
                        add.add("order_id", str).add("rec_channel", "1").report();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9384a(View view) {
        if (!this.f10790Z && !IMPreference.getInstance(this).isComplaintGuideShow(IMContextInfoHelper.getUid())) {
            this.f10790Z = true;
            new IMSimpleGuideView.Builder(this).isShowForkView(true).setGuideText(IMResource.getString(R.string.im_menu_complaint_guide)).setTargetView(view).setOutsideTouchable(true).setMaxWordNumSingleLine(16).setLayoutGravity(2).setGrivaty(3).setPopClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    String str = "";
                    IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("beat_p_imrpt_tips_ck").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, IMMessageActivity.this.f10768D.getExtendSessionInfo() == null ? str : IMMessageActivity.this.f10768D.getExtendSessionInfo().routeId);
                    if (IMMessageActivity.this.f10768D.getExtendSessionInfo() != null) {
                        str = IMMessageActivity.this.f10768D.getExtendSessionInfo().orderId;
                    }
                    add.add("order_id", str).report();
                }
            }).setDismissListener(new PopupWindow.OnDismissListener() {
                public void onDismiss() {
                    IMPreference.getInstance(IMMessageActivity.this).setComplaintGuideShow(IMContextInfoHelper.getUid());
                }
            }).create().show();
            String str = "";
            IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("beat_p_imrpt_tips_sw").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, this.f10768D.getExtendSessionInfo() == null ? str : this.f10768D.getExtendSessionInfo().routeId);
            if (this.f10768D.getExtendSessionInfo() != null) {
                str = this.f10768D.getExtendSessionInfo().orderId;
            }
            add.add("order_id", str).report();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m9432l() {
        if (this.f10768D.getExtendSessionInfo() != null) {
            final List<IMExtendBtnModule> list = this.f10768D.getExtendSessionInfo().more;
            if (list == null || list.size() == 0) {
                this.f10796f.setRightExtendIvVisible(8);
                return;
            }
            this.f10796f.setRightExtendIvVisible(0);
            this.f10796f.setRightExtendIv(R.drawable.im_extend_btn, new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMMessageActivity.this.f10771G == null) {
                        IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                        IMExtendBtnPopup unused = iMMessageActivity.f10771G = new IMExtendBtnPopup(iMMessageActivity, list);
                    }
                    if (IMMessageActivity.this.f10771G.isShowing()) {
                        IMMessageActivity.this.f10771G.dismiss();
                        return;
                    }
                    IMMessageActivity.this.f10771G.show(IMMessageActivity.this.f10796f.getRightExtendView());
                    IMMsgOmega.getInstance().trackMoreBtn("");
                }
            });
            return;
        }
        this.f10796f.setRightExtendIvVisible(8);
    }

    /* renamed from: m */
    private void m9435m() {
        this.f10806x = IMManager.getInstance().getSessionModel();
        this.f10807y = IMManager.getInstance().getMessageModel();
        this.f10808z = IMManager.getInstance().getUserModel();
        this.f10765A = IMManager.getInstance().getGlobalModel();
    }

    /* renamed from: n */
    private void m9436n() {
        this.mController = IMLifecycleHandler.attach(this);
        m9400a(this.f10768D.getUserIds());
        IMBtsAudioHelper.initSensorModle(new IMBtsAudioPlayer.onVoiceChannelChangeListener() {
            public void onVoiceChannelChanged(final int i) {
                IMMessageActivity.this.mController.post(new Runnable() {
                    public void run() {
                        int i = i;
                        if (i == 0) {
                            IMMessageActivity.this.m9382a((int) R.string.bts_im_change_voice_spaker, IMResource.getDrawableID(R.drawable.bts_im_voice_spaker));
                        } else if (i == 1) {
                            IMMessageActivity.this.m9382a((int) R.string.bts_im_change_voice_call, IMResource.getDrawableID(R.drawable.bts_im_voice_call));
                        } else {
                            IMMessageActivity.this.f10793ab.sendEmptyMessage(7);
                        }
                    }
                });
            }
        });
    }

    /* renamed from: a */
    private void m9400a(List<Long> list) {
        if (this.f10768D.getType() == 2) {
            IIMUserModule iIMUserModule = this.f10808z;
            if (iIMUserModule != null) {
                iIMUserModule.getUserInfo(this.f10767C, (IMGroupUserInfoCallback) new IMGroupUserInfoCallback() {
                    public void onUserInfoLoaded(List<IMUser> list) {
                        if (list == null || list.isEmpty()) {
                            IMMessageActivity.this.m9443q();
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        for (IMUser next : list) {
                            hashMap.put(Long.valueOf(next.getUid()), next);
                        }
                        IMMessageActivity.this.f10802t.setUsers(hashMap);
                        IMMessageActivity.this.f10802t.notifyDataSetChanged();
                    }
                }, false);
            }
        } else if (list != null && list.size() == 2) {
            long longValue = list.get(0).longValue();
            long longValue2 = list.get(1).longValue();
            IIMUserModule iIMUserModule2 = this.f10808z;
            if (iIMUserModule2 != null) {
                iIMUserModule2.getUserInfo(new long[]{longValue, longValue2}, (IMUserInfoCallback) this, false);
            }
        }
    }

    /* renamed from: o */
    private boolean m9439o() {
        this.f10798p = (FrameLayout) findViewById(R.id.bts_im_layout_root);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.im_conversation_recyclerview);
        this.f10799q = recyclerView;
        if (recyclerView == null) {
            finish();
            return false;
        }
        this.f10800r = (IMEggsLayout) findViewById(R.id.im_eggs_layout);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.bts_im_layout);
        linearLayout.setBackgroundColor(IMResource.getColor(R.color.im_nomix_activity_bg_color));
        this.f10799q.setBackgroundColor(IMResource.getColor(R.color.im_nomix_activity_bg_color));
        linearLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
        MessageAdapter messageAdapter = new MessageAdapter(this, this, 20, this.f10777M, this.f10768D, this.f10769E);
        this.f10802t = messageAdapter;
        messageAdapter.isShowPeerAvatar(this.f10804v.isShowPeerAvatar());
        this.f10802t.setSessionInfo(this.f10768D.supportMsgReadStatus, this.f10768D.supportTranslate);
        this.f10802t.updateRenderCardEnv(this.f10767C, IMParamUtil.getTraceOrderId(this.f10773I, this.f10768D), IMParamUtil.getTraceExtra(this.f10773I, this.f10780P));
        this.f10799q.setLayoutManager(new LinearLayoutManager(this));
        this.f10799q.setOnTouchListener(this.f10791a);
        this.f10799q.setAdapter(this.f10802t);
        this.f10799q.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f10799q.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IMMessageActivity.this.f10802t.hidePopup();
                boolean unused = IMMessageActivity.this.f10778N = true;
                if (i == 0) {
                    IMMessageActivity.this.f10802t.loadAudio(((LinearLayoutManager) IMMessageActivity.this.f10799q.getLayoutManager()).findFirstVisibleItemPosition(), ((LinearLayoutManager) IMMessageActivity.this.f10799q.getLayoutManager()).findLastVisibleItemPosition());
                    if (IMMessageActivity.this.f10802t.canLoadHistory() && ((LinearLayoutManager) IMMessageActivity.this.f10799q.getLayoutManager()).findFirstVisibleItemPosition() == 0) {
                        Long listMinPosition = IMMessageActivity.this.f10802t.getListMinPosition();
                        IMMessageActivity iMMessageActivity = IMMessageActivity.this;
                        iMMessageActivity.m9396a(Long.valueOf(iMMessageActivity.f10767C), listMinPosition, false);
                    }
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (IMMessageActivity.this.f10778N && IMMessageActivity.this.f10797g != null) {
                    IMMessageActivity.this.f10797g.shrinkBottomBarByRecycle();
                    boolean unused = IMMessageActivity.this.f10778N = false;
                }
                try {
                    int findLastVisibleItemPosition = ((LinearLayoutManager) IMMessageActivity.this.f10799q.getLayoutManager()).findLastVisibleItemPosition();
                    for (int findFirstVisibleItemPosition = ((LinearLayoutManager) IMMessageActivity.this.f10799q.getLayoutManager()).findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                        IMLog.m10020d(IMMessageActivity.f10753b, "mRecyclerView onScrolled() i:" + findFirstVisibleItemPosition);
                        if (!(IMMessageActivity.this.f10783S == null || IMMessageActivity.this.f10802t == null)) {
                            IMMessage item = IMMessageActivity.this.f10802t.getItem(findFirstVisibleItemPosition);
                            if (item.getType() != 107) {
                                IMMessageActivity.this.f10783S.add(item);
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("mRecyclerView onScrolled() omegaUpSet size=");
                        sb.append(IMMessageActivity.this.f10783S == null ? 0 : IMMessageActivity.this.f10783S.size());
                        IMLog.m10020d(IMMessageActivity.f10753b, sb.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    IMLog.m10020d(IMMessageActivity.f10753b, "mRecyclerView onScrolled() fail:" + e.getMessage());
                }
            }
        });
        this.f10779O = (IMRecommendEmojiView) findViewById(R.id.im_conversation_recommond_view);
        this.f10770F = findViewById(R.id.im_content_view);
        this.f10781Q = (ImageView) findViewById(R.id.im_no_msg_iv);
        this.f10782R = (TextView) findViewById(R.id.im_no_msg_tv);
        IMSession iMSession = this.f10768D;
        if (iMSession == null || iMSession.getType() != 4) {
            IMViewUtil.hide((View) this.f10781Q);
            IMViewUtil.hide((View) this.f10782R);
            this.f10799q.setVisibility(0);
            this.f10800r.setVisibility(0);
            IMSession iMSession2 = this.f10768D;
            int type = iMSession2 != null ? iMSession2.getType() : 0;
            IMLog.m10020d("IMview", "bg gone mSession = " + type);
        } else {
            IMViewUtil.show((View) this.f10781Q);
            IMViewUtil.show((View) this.f10782R);
            this.f10799q.setVisibility(8);
            this.f10800r.setVisibility(8);
            this.f10781Q.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_no_history_msg));
            this.f10782R.setText(IMResource.getString(R.string.im_nomix_no_history_msg_text));
            IMLog.m10020d("IMview", "has set bg");
        }
        IMTopOperationView iMTopOperationView = (IMTopOperationView) findViewById(R.id.im_top_operation_view);
        this.f10801s = iMTopOperationView;
        iMTopOperationView.init(this.f10768D, this.f10769E);
        this.f10772H = findViewById(R.id.im_detailes_loading_view);
        IMSession iMSession3 = this.f10768D;
        if (!(iMSession3 == null || iMSession3.getType() == 4)) {
            try {
                int singleChatBackgroundRes = IMCustomResHelper.get(this.f10804v).getSingleChatBackgroundRes();
                if (singleChatBackgroundRes > 0) {
                    this.f10798p.setBackgroundResource(singleChatBackgroundRes);
                }
            } catch (Exception e) {
                IMLog.m10021e(f10753b, e);
            }
        }
        return true;
    }

    public String getOrderId() {
        String str;
        IMSessionExtendInfo extendSessionInfo = this.f10768D.getExtendSessionInfo();
        if (extendSessionInfo == null) {
            str = null;
        } else {
            str = extendSessionInfo.orderId;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (this.f10773I == null) {
            return "";
        }
        return this.f10773I.getOrderId() + "";
    }

    public String getRouteId() {
        String str;
        IMSessionExtendInfo extendSessionInfo = this.f10768D.getExtendSessionInfo();
        if (extendSessionInfo == null) {
            str = null;
        } else {
            str = extendSessionInfo.routeId;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (this.f10773I == null) {
            return "";
        }
        return this.f10773I.getRouteId() + "";
    }

    public int getSourceId() {
        IMBusinessParam iMBusinessParam = this.f10773I;
        if (iMBusinessParam != null) {
            return iMBusinessParam.getSourceId();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        IMDialog iMDialog = this.f10805w;
        if (iMDialog != null) {
            iMDialog.dismiss(this.mController);
        }
        if (parseIntent(intent)) {
            m9417d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9382a(int i, int i2) {
        PopupWindow popupWindow = this.f10786V;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f10786V.dismiss();
            this.f10786V = null;
        }
        View findViewById = findViewById(R.id.bts_im_layout);
        if (findViewById != null && findViewById.getWindowToken() != null && !isFinishing()) {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.bts_im_change_voice_mode_toast, (ViewGroup) null);
            this.f10786V = new PopupWindow(inflate, -2, -2);
            ((TextView) inflate.findViewById(R.id.toast_message)).setText(getString(i));
            ((ImageView) inflate.findViewById(R.id.toast_img)).setImageResource(i2);
            this.f10786V.setFocusable(false);
            if (IMRTLUtils.isRTLLayout()) {
                this.f10786V.setAnimationStyle(R.style.btsVoiceChangeStyleRTL);
                this.f10786V.showAtLocation(findViewById, 51, 0, IMViewUtil.dp2px(this, 77.0f));
            } else {
                this.f10786V.setAnimationStyle(R.style.btsVoiceChangeStyle);
                this.f10786V.showAtLocation(findViewById, 53, 0, IMViewUtil.dp2px(this, 77.0f));
            }
            this.f10793ab.sendEmptyMessageDelayed(7, 2000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9393a(IMMessage iMMessage) {
        this.f10802t.updateItemState(iMMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9383a(int i, String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) str, 0);
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, i);
        IMTipsToast.setText(makeText, str);
    }

    /* renamed from: a */
    private void m9399a(String str, int i, int i2, Object obj) {
        if (this.f10807y != null && this.f10773I != null) {
            m9441p();
            IMBusinessParam iMBusinessParam = this.f10773I;
            iMBusinessParam.setIsQuick(i2 == 2 ? 1 : 0);
            m9408b(this.f10807y.sendTextMessage(str, i, iMBusinessParam, this.f10768D, obj, 0, (IMSendMessageCallback) null));
        }
    }

    public void sendVoiceMessage(String str, long j) {
        String audioFilePath = IMFileHelper.getAudioFilePath(str);
        int min = (int) (Math.min(j, (long) IMChatHelper.AUDIO_RECORD_MAX_DURATION) / 1000);
        if (this.f10807y != null) {
            m9441p();
            m9408b(this.f10807y.sendAudioMessage(audioFilePath, min, this.f10773I, this.f10768D, (IMSendMessageCallback) null));
        }
    }

    /* renamed from: p */
    private void m9441p() {
        OmegaUtil.trackSendMsgOmega(this.f10777M, this.f10767C, 2);
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            StatusBarLightingCompat.setStatusBarBgLightning(this, true, IMResource.getColor(R.color.im_nomix_activity_bg_color));
        } else {
            super.initStatusBar();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m9405b();
        IMPushEngine.holdMessageSessionId = this.f10767C;
        if (this.f10774J == null) {
            this.f10774J = new IMMessageCallBackImp() {
                public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                    if (!(iMSendMessageResponse == null || !iMSendMessageResponse.isSuccess() || iMSendMessageResponse.body == null || iMSendMessageResponse.body.recom == null || IMMessageActivity.this.f10797g == null)) {
                        IMMessageActivity.this.f10797g.setRecommendInfo(iMSendMessageResponse.body.recom);
                        IMLog.m10020d("IMBottombar", "结构化消息发送成功，recom = " + iMSendMessageResponse.body.recom);
                    }
                    IMMessageActivity.this.m9392a((IMBaseResponse) iMSendMessageResponse);
                    IMMessageActivity.this.m9393a(iMMessage);
                    if (IMMessageActivity.this.f10783S != null) {
                        IMMessageActivity.this.f10783S.add(iMMessage);
                    }
                }

                public void onReceive(List<IMMessage> list) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            IMMessageActivity.this.m9396a(Long.valueOf(IMMessageActivity.this.f10767C), IMMessageActivity.this.f10802t.getListMaxPosition(), true);
                        }
                    });
                }

                public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
                    IMMessageActivity.this.f10793ab.sendEmptyMessage(2);
                    if (IMTextUtil.isEmpty((Collection<?>) list) || list.size() == 0) {
                        IMMessageActivity.this.f10802t.loadHistoryList((List<IMMessage>) null, z);
                        return;
                    }
                    if (IMMessageActivity.this.f10781Q.isShown()) {
                        IMLog.m10020d("IMview", "hide nomsg show review");
                        IMMessageActivity.this.f10781Q.setVisibility(8);
                        IMMessageActivity.this.f10782R.setVisibility(8);
                        IMMessageActivity.this.f10799q.setVisibility(0);
                        IMMessageActivity.this.f10800r.setVisibility(0);
                    }
                    int findLastVisibleItemPosition = ((LinearLayoutManager) IMMessageActivity.this.f10799q.getLayoutManager()).findLastVisibleItemPosition();
                    IMMessageList<IMMessage> loadHistoryList = IMMessageActivity.this.f10802t.loadHistoryList(list, z);
                    if (z || findLastVisibleItemPosition == -1) {
                        IMMessageActivity.this.m9445r();
                    } else {
                        IMMessageActivity.this.f10799q.scrollToPosition((loadHistoryList.size() + findLastVisibleItemPosition) - 2);
                    }
                    if (!z && IMMessageActivity.this.f10768D.supportMsgReadStatus) {
                        ArrayList arrayList = new ArrayList();
                        for (IMMessage next : list) {
                            if (!next.isRead() && next.getSenderUid() == IMContextInfoHelper.getUid()) {
                                arrayList.add(Long.valueOf(next.getMid()));
                            }
                        }
                        IMLog.m10024i("IMMessageReadStatusManager", "request msgs read status,size is " + arrayList.size());
                        if (IMMessageActivity.this.f10807y != null) {
                            IMMessageActivity.this.f10807y.getMessageReadStatus(IMMessageActivity.this.f10767C, arrayList);
                        }
                    }
                }

                public void onReadStatusChange(List<IMMessage> list, boolean z) {
                    if (!z) {
                        IMMessageReadStatusManager.getInstance().removeHasReportMsg(list);
                    } else if (IMMessageActivity.this.f10802t != null) {
                        IMLog.m10024i("IMMessageReadStatusManager", "update msgs has send");
                        IMMessageActivity.this.f10802t.changeMsgReadStatus(list);
                    }
                }

                public void onReceive(String str) {
                    if (IMMessageActivity.this.f10797g != null) {
                        IMMessageActivity.this.f10797g.setRecommendInfo(str);
                    }
                }

                public long getSid() {
                    return IMMessageActivity.this.f10767C;
                }
            };
        }
        IIMMessageModule iIMMessageModule = this.f10807y;
        if (iIMMessageModule != null) {
            iIMMessageModule.registerMessageCallback(this.f10774J, this.f10767C);
            this.f10807y.pullSingleMessage(this.f10777M, 0, 2);
        }
        if (this.f10775K == null) {
            this.f10775K = new IMStaticSessionCallBack(this);
        }
        if (!(this.f10806x == null || this.f10773I == null)) {
            String simpleName = IMConversationBottomBar.class.getSimpleName();
            IMLog.m10020d(simpleName, "get mSession status " + this.f10773I.toString());
            this.f10806x.syncSessionStatus(-1, -1, this.f10773I, this.f10768D, this.f10775K);
        }
        boolean z = false;
        if (!this.f10788X) {
            Long valueOf = Long.valueOf(this.f10767C);
            Long listMaxPosition = this.f10802t.getListMaxPosition();
            if (this.f10802t.getListMaxPosition().longValue() != 0) {
                z = true;
            }
            m9396a(valueOf, listMaxPosition, z);
        } else {
            this.f10788X = false;
        }
        CURRENT_SID = this.f10767C;
        IMPollingUtils.startPollingService(this, 60, IMPollingService.class, IMPollingService.ACTION);
        this.f10789Y = true;
    }

    /* renamed from: com.didi.beatles.im.activity.IMMessageActivity$IMStaticSessionCallBack */
    private static class IMStaticSessionCallBack implements IMSessionCallback {
        private WeakReference<IMMessageActivity> mActivity;

        public void onSessionStatusUpdate(List<IMSession> list) {
        }

        public IMStaticSessionCallBack(IMMessageActivity iMMessageActivity) {
            this.mActivity = new WeakReference<>(iMMessageActivity);
        }

        public void onSessionOptionResult(List<IMSession> list, int i) {
            IMMessageActivity iMMessageActivity = (IMMessageActivity) this.mActivity.get();
            if (iMMessageActivity != null) {
                if (i == 111) {
                    if (iMMessageActivity.f10773I != null) {
                        iMMessageActivity.f10773I.clearSecret();
                    }
                    if (iMMessageActivity.f10806x != null) {
                        iMMessageActivity.f10806x.updateSessionEnableStatus(iMMessageActivity.f10767C, false, 0);
                    }
                    if (iMMessageActivity.f10768D != null) {
                        iMMessageActivity.f10768D.setSessionEnable(false);
                        if (iMMessageActivity.f10768D.getExtendSessionInfo() != null) {
                            iMMessageActivity.f10768D.getExtendSessionInfo().openActionIds = null;
                        }
                    }
                    if (iMMessageActivity.f10797g != null) {
                        iMMessageActivity.f10797g.onStatusChanged(iMMessageActivity.f10768D);
                    }
                } else if (!iMMessageActivity.f10772H.isShown() || i != -1) {
                    iMMessageActivity.f10772H.findViewById(R.id.im_detailes_loading_icon).setVisibility(8);
                    iMMessageActivity.f10772H.findViewById(R.id.im_detailes_loading_text).setVisibility(0);
                } else {
                    iMMessageActivity.f10772H.findViewById(R.id.im_detailes_loading_icon).setVisibility(8);
                    iMMessageActivity.f10772H.findViewById(R.id.im_detailes_loading_text).setVisibility(0);
                    IMLog.m10020d("IMBottombar", "隐藏 loading");
                }
            }
        }

        public void onSessionLoad(List<IMSession> list) {
            IMMessageActivity iMMessageActivity = (IMMessageActivity) this.mActivity.get();
            if (iMMessageActivity != null) {
                iMMessageActivity.m9410b(list);
                iMMessageActivity.m9432l();
            }
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMMessageActivity$IMStaticSessionModuleListener */
    private static class IMStaticSessionModuleListener extends IMSessionCallbackAdapter {
        /* access modifiers changed from: private */
        public WeakReference<IMMessageActivity> mActivity;

        IMStaticSessionModuleListener(IMMessageActivity iMMessageActivity) {
            this.mActivity = new WeakReference<>(iMMessageActivity);
        }

        public void onSessionOptionResult(List<IMSession> list, int i) {
            IMMessageActivity iMMessageActivity;
            if (i == 3 && list != null && (iMMessageActivity = (IMMessageActivity) this.mActivity.get()) != null) {
                long h = iMMessageActivity.f10767C;
                for (IMSession next : list) {
                    if (next != null && next.getSessionId() == h) {
                        IMToastHelper.showLongInfo((Context) iMMessageActivity, iMMessageActivity.getResources().getString(R.string.im_delete_session_tips));
                        UiThreadHandler.postDelayed(new Runnable() {
                            public void run() {
                                IMMessageActivity iMMessageActivity = (IMMessageActivity) IMStaticSessionModuleListener.this.mActivity.get();
                                if (iMMessageActivity != null) {
                                    iMMessageActivity.finish();
                                }
                            }
                        }, 300);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m9401a(Set<IMMessage> set) {
        if (set != null && set.size() != 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            for (IMMessage next : set) {
                sb2.append(next.getMessageExtendInfo().activity_id);
                sb.append(next.getCloudUniqueMsgId());
                if (i != set.size() - 1) {
                    sb2.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                    sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                }
                i++;
                IMLog.m10020d(f10753b, "[reportHelperChat] uniq_msg_id = " + next.getCloudUniqueMsgId() + ",msg_id = " + next.getMsgUniqueId());
            }
            IMTraceUtil.addBusinessEvent("ddim_service_item_content_sw").add("product_id", Integer.valueOf(this.f10768D.getBusinessId())).add("no_appid", Long.valueOf(this.f10768D.getPeerUid())).add("send_uid", Long.valueOf(this.f10768D.getPeerUid())).add("activity_id", sb2.toString()).add("uniq_msg_id_list", sb.toString()).report();
        }
    }

    /* renamed from: b */
    private void m9411b(Set<IMMessage> set) {
        if (set != null && set.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (IMMessage next : set) {
                sb.append(next.getCloudUniqueMsgId());
                if (i != set.size() - 1) {
                    sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                }
                i++;
                IMLog.m10020d(f10753b, "[reportChat] uniq_msg_id = " + next.getCloudUniqueMsgId() + ",msg_id = " + next.getMsgUniqueId());
            }
            IMTraceUtil.addBusinessEvent("pub_ddim_chat_item_content_sw").add("product_id", Integer.valueOf(this.f10768D.getBusinessId())).add("peer_uid", Long.valueOf(this.f10768D.getPeerUid())).add("uniq_msg_id_list", sb.toString()).report();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f10768D.supportMsgReadStatus) {
            IMMessageReadStatusManager.getInstance().reportByHand();
        }
        IMMessageReadStatusManager.getInstance().destory();
        IIMSessionModule iIMSessionModule = this.f10806x;
        if (iIMSessionModule != null) {
            iIMSessionModule.clearUnreadCount(this.f10767C);
            this.f10806x.clearHolders();
        }
        IMManager.getInstance().clearIMRedDot();
        IMStageFeedBackListerManager.INSTANCE.notifyListeners(this, IMStageFeedBack.IMStage.IM_CLEAR_UN_READ_COUNT_AFTER, (IMStageFeedBack.OutFeedBackData) null);
        IMPushEngine.holdMessageSessionId = 0;
        IMBaseBottomBar iMBaseBottomBar = this.f10797g;
        if (iMBaseBottomBar != null) {
            iMBaseBottomBar.onPause();
        }
        try {
            m9448t();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m9413c();
        IIMMessageModule iIMMessageModule = this.f10807y;
        if (iIMMessageModule != null) {
            iIMMessageModule.unregisterMessageCallback(this.f10767C);
            this.f10807y.clearHolders();
        }
        if (this.f10774J != null) {
            this.f10774J = null;
        }
        IIMUserModule iIMUserModule = this.f10808z;
        if (iIMUserModule != null) {
            iIMUserModule.clearHolders();
        }
        if (this.f10775K != null) {
            this.f10775K = null;
        }
        IMBtsAudioHelper.stopPlaying();
        IMBtsAudioHelper.cancelRecording();
        IMTipsToast.cancelAll();
        CURRENT_SID = -1;
        IMPollingUtils.stopPollingService(this, IMPollingService.class, IMPollingService.ACTION);
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        IMOrderStatusChangeBody iMOrderStatusChangeBody;
        super.onActivityDestroy();
        for (int i = 0; i < this.f10785U.size(); i++) {
            IMMessage valueAt = this.f10785U.valueAt(i);
            IMTraceUtil.addBusinessEvent("ddim_message_sys_item_sw").add("product_id", Integer.valueOf(this.f10768D.getBusinessId())).add("client_type", IMContextInfoHelper.getPackageName()).add("msg_type", Integer.valueOf(valueAt.getType())).add("msg_link", Integer.valueOf(valueAt.linkType > 0 ? 1 : 0)).add("activity_id", Long.valueOf(valueAt.getActivityId())).report();
            if (valueAt.getType() == 393219 && (iMOrderStatusChangeBody = (IMOrderStatusChangeBody) IMJsonUtil.objectFromJson(valueAt.getContent(), IMOrderStatusChangeBody.class)) != null && iMOrderStatusChangeBody.alignStyle == 2 && iMOrderStatusChangeBody.btnGroup != null) {
                IMTraceUtil.addBusinessEvent("beat_p_imrpt_succard_sw").add("uid", Long.valueOf(IMContextInfoHelper.getUid())).add("anal_txt", iMOrderStatusChangeBody.extend != null ? iMOrderStatusChangeBody.extend.analTxt : "").report();
            }
        }
        IMSession iMSession = this.f10768D;
        if (iMSession == null || iMSession.getType() != 4) {
            m9411b(this.f10783S);
        } else {
            m9401a(this.f10783S);
        }
        Set<IMMessage> set = this.f10783S;
        if (set != null) {
            set.clear();
            this.f10783S = null;
        }
        IMHostProxy.getInstance().unregisterPluginSendListener(this);
        IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
        if (sessionModel != null) {
            sessionModel.unregisterSessionCallback(this.f10776L);
        }
        if (this.f10793ab.hasMessages(7)) {
            this.f10793ab.removeMessages(7);
        }
        IMBaseBottomBar iMBaseBottomBar = this.f10797g;
        if (iMBaseBottomBar != null) {
            iMBaseBottomBar.onDestroy();
            this.f10797g = null;
        }
        EventBus.getDefault().unregister(this);
        IMBtsAudioHelper.releaseSensorModle();
        MessageAdapter messageAdapter = this.f10802t;
        if (messageAdapter != null) {
            messageAdapter.clearData();
        }
        RecyclerView recyclerView = this.f10799q;
        if (recyclerView != null) {
            recyclerView.clearOnScrollListeners();
        }
        IMMsgOmega.getInstance().destory();
        IMMessageOperatePopup.onDestory();
        IMExpoMtaManager.getInstance().clearExpoEvents();
    }

    public void onTextMessageSend(String str, int i, int i2) {
        if (i2 == 3) {
            sendStreetViewMessage(339);
        } else {
            m9399a(str, i, i2, (Object) null);
        }
    }

    public void sendTextMessage(String str, int i, Object obj) {
        if (this.f10801s != null && IMPreference.getInstance(getApplicationContext()).shouldShowTopGuide()) {
            IMPreference.getInstance(getApplicationContext()).hasShowTopViewGuide();
            this.f10801s.showGuideView(IMResource.getString(R.string.im_top_view_guide_text));
        }
        m9399a(str, i, -1, obj);
    }

    public void onEditFocus() {
        m9445r();
    }

    public void handleEvent() {
        IMBtsAudioHelper.stopPlaying();
    }

    public void showAddCustomWordDialog(String str, int i) {
        showAddCustomWordDialog(str, i, -1);
    }

    public void showAddCustomWordDialog(String str, int i, int i2) {
        m9455w();
        IMAddCommonWordDialog.show(this, this.f10777M, str, i, this.f10804v.getCommonWordType(), i2);
    }

    public List<IMActionItem> getSystemAction() {
        IMSession iMSession = this.f10768D;
        if (!(iMSession == null || iMSession.getExtendSessionInfo() == null)) {
            List<Integer> list = this.f10768D.getExtendSessionInfo().actionIds;
            List<Integer> list2 = this.f10768D.getExtendSessionInfo().openActionIds;
            IMBusinessConfig iMBusinessConfig = this.f10804v;
            List<IMActionItem> generateItems = IMActionFactory.generateItems(this, list, list2, iMBusinessConfig != null ? iMBusinessConfig.getPluginList() : null);
            IMActionTipManager.getInstance().onSystemActionsUpdated(this.f10777M, this.f10767C, this.f10768D.getPeerUid(), this.f10768D.getExtendSessionInfo().actionIds);
            if (generateItems == null || generateItems.isEmpty()) {
                return null;
            }
            return generateItems;
        }
        return null;
    }

    public List<IMActionItem> interceptMoreAction(List<IMActionItem> list) {
        if (list == null) {
            IMLog.m10019d("[interceptMoreAction] actionItems is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (IMActionItem next : list) {
            if (next.moreActionNetControlItem == null) {
                arrayList.add(next);
            } else if (m9403a(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private boolean m9403a(IMActionItem iMActionItem) {
        IMSession iMSession = this.f10768D;
        if (!(iMSession == null || iMSession.getExtendSessionInfo() == null || this.f10768D.getExtendSessionInfo().actionIds == null)) {
            if (iMActionItem != null && iMActionItem.moreActionNetControlItem != null && iMActionItem.moreActionNetControlItem.isNetControl()) {
                return this.f10768D.getExtendSessionInfo().actionIds.contains(Integer.valueOf(iMActionItem.moreActionNetControlItem.getPluginId()));
            }
            IMLog.m10019d("enableMoreActionShow actionItem moreActionNetControlItem is null or isNetControl is false");
        }
        return false;
    }

    public IMActionInvokeReturn invokeAction(IMActionItem iMActionItem, IMActionInvokeEnv iMActionInvokeEnv) {
        if (iMActionItem == null) {
            return null;
        }
        if (this.f10789Y) {
            this.f10788X = true;
        }
        if (iMActionItem.item == null) {
            iMActionItem.invokeAction(this, this.f10768D, this.f10773I);
            this.f10797g.shrinkBottomBar();
            return null;
        }
        IMActionInvokeReturn invokeAction = iMActionItem.item.invokeAction(this, iMActionInvokeEnv);
        if (invokeAction == null || invokeAction.containView == null) {
            this.f10797g.shrinkBottomBar();
        }
        return invokeAction;
    }

    public List<IMBottomGuideConfig> getBottomGuideConfigList() {
        IIMGlobalModule iIMGlobalModule = this.f10765A;
        if (iIMGlobalModule != null) {
            return iIMGlobalModule.getBtmGuideConfigList(this.f10777M);
        }
        return null;
    }

    public List<IMSessionExtendInfo.BottomTabInfo> getBottomTabList() {
        IMSession iMSession;
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG || (iMSession = this.f10768D) == null || iMSession.getExtendSessionInfo() == null) {
            return null;
        }
        return this.f10768D.getExtendSessionInfo().bottomTabInfoList;
    }

    public IMActionInvokeReturn invokeTabAction(IMTabActionItem iMTabActionItem, IMActionInvokeEnv iMActionInvokeEnv) {
        if (iMTabActionItem == null) {
            return null;
        }
        if (this.f10789Y) {
            this.f10788X = true;
        }
        IMActionInvokeReturn invokeAction = iMTabActionItem.invokeAction(this, iMActionInvokeEnv);
        if (invokeAction == null || invokeAction.containView == null) {
            this.f10797g.shrinkBottomBar();
        }
        return invokeAction;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 188) {
            List<IMLocalMedia> obtainMultipleResult = IMPictureSelector.obtainMultipleResult(intent);
            IMLog.m10020d(f10753b, C4786I.m9980t("共选择图片->", Integer.valueOf(obtainMultipleResult.size())));
            for (IMLocalMedia path : obtainMultipleResult) {
                IMLog.m10020d(f10753b, C4786I.m9980t("选择图片 -> ", path.getPath()));
            }
            this.f10807y.sendImageMessage(obtainMultipleResult, this.f10773I, this.f10768D, new IMPreSendCallback() {
                public void insertSuccess(List<IMMessage> list) {
                    IMMessageActivity.this.push(list);
                }
            });
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onViewImageEvent(IMViewImageEvent iMViewImageEvent) {
        List<IMMessage> messagesWithType = this.f10802t.getMessagesWithType(196608);
        if (messagesWithType != null) {
            ArrayList arrayList = new ArrayList();
            int size = messagesWithType.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                IMMessage iMMessage = messagesWithType.get(i2);
                if (iMMessage.getMid() == iMViewImageEvent.message.getMid()) {
                    i = i2;
                }
                String content = iMMessage.getContent();
                String file_name = iMMessage.getFile_name();
                if (!TextUtils.isEmpty(content)) {
                    arrayList.add(content);
                } else if (!TextUtils.isEmpty(file_name)) {
                    arrayList.add(file_name);
                }
            }
            this.f10788X = true;
            String str = null;
            IMSession iMSession = this.f10768D;
            if (!(iMSession == null || iMSession.getExtendSessionInfo() == null || TextUtils.isEmpty(this.f10768D.getExtendSessionInfo().watermark))) {
                str = this.f10768D.getExtendSessionInfo().watermark;
            }
            IMPictureExternalPreviewActivity.startActivity(this, i, arrayList, str);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onViewStreetImageEvent(IMViewStreetImageEvent iMViewStreetImageEvent) {
        if (iMViewStreetImageEvent.body != null && iMViewStreetImageEvent.body.streetImage != null && !TextUtils.isEmpty(iMViewStreetImageEvent.body.streetImage.imageUrl)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(iMViewStreetImageEvent.body.streetImage.imageUrl);
            this.f10788X = true;
            String str = null;
            IMSession iMSession = this.f10768D;
            if (!(iMSession == null || iMSession.getExtendSessionInfo() == null || TextUtils.isEmpty(this.f10768D.getExtendSessionInfo().watermark))) {
                str = this.f10768D.getExtendSessionInfo().watermark;
            }
            IMPictureExternalPreviewActivity.startActivity(this, 0, arrayList, str);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateMsgReadStatus(IMMessageUpdateReadStatusEvent iMMessageUpdateReadStatusEvent) {
        List<IMMessage> list = iMMessageUpdateReadStatusEvent.list;
        if (this.f10807y != null && list != null && list.size() != 0) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(Long.valueOf(list.get(i).getMid()));
            }
            this.f10807y.pushMessageReadStatus(this.f10767C, arrayList);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateMsgCollection(IMMessageColloectionUpdateEvent iMMessageColloectionUpdateEvent) {
        for (IMMessage next : iMMessageColloectionUpdateEvent.updateMessages) {
            if (next.getSid() == this.f10768D.getSessionId()) {
                this.f10802t.updateItemState(next);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleExpiredPic(IMMessageHandleExpiredPicEvent iMMessageHandleExpiredPicEvent) {
        List<IMMessage> list = iMMessageHandleExpiredPicEvent.updateMessages;
        if (list != null) {
            for (IMMessage next : list) {
                if (next.getSid() == this.f10768D.getSessionId()) {
                    this.f10802t.updateItemState(next);
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveSysCardShow(IMMessageSysCardShowEvent iMMessageSysCardShowEvent) {
        IMMessage iMMessage = iMMessageSysCardShowEvent.message;
        if (iMMessage != null && this.f10768D.getType() != 4) {
            this.f10785U.append(iMMessage.getId(), iMMessage);
        }
    }

    public void sendEmoji(String str, String str2, String str3) {
        if (this.f10807y != null && this.f10773I != null) {
            m9441p();
            String str4 = str;
            String str5 = str2;
            String str6 = str3;
            m9408b(this.f10807y.sendEmojiMessage(str4, str5, IMInnerData.getInstance().getEmojiPrefix(), str6, this.f10773I, this.f10768D));
            IMTraceUtil.addBusinessEvent("wyc_ddim_emoji_ck").add("emoji_id", str).report();
        }
    }

    public void push(List<IMMessage> list) {
        MessageAdapter messageAdapter = this.f10802t;
        if (messageAdapter != null) {
            messageAdapter.hidePopup();
            this.f10802t.addItem(list);
        }
        m9445r();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9408b(IMMessage iMMessage) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(iMMessage);
        this.f10802t.addItem(arrayList);
        if (this.f10802t.getItemCount() > 0) {
            this.f10799q.scrollToPosition(this.f10802t.getItemCount() - 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9396a(Long l, Long l2, boolean z) {
        IIMMessageModule iIMMessageModule = this.f10807y;
        if (iIMMessageModule != null) {
            iIMMessageModule.loadHistoryMessage(l.longValue(), l2.longValue(), 20, z);
        }
    }

    /* renamed from: c */
    private void m9414c(IMMessage iMMessage) {
        IMMessage iMMessage2;
        if (this.f10807y == null) {
            IMLog.m10021e(f10753b, "the messageModule is null while resend msg");
            return;
        }
        m9441p();
        iMMessage.setStatus(100);
        int type = iMMessage.getType();
        if (type == 65536) {
            iMMessage2 = this.f10807y.sendTextMessage(iMMessage, this.f10773I, this.f10768D, (IMSendMessageCallback) null);
        } else if (type == 65537) {
            iMMessage2 = this.f10807y.sendTextMessage(iMMessage, this.f10773I, this.f10768D, (IMSendMessageCallback) null);
        } else if (type == 131072) {
            iMMessage2 = this.f10807y.sendAudioMessage(iMMessage, this.f10773I, this.f10768D, (IMSendMessageCallback) null);
        } else if (type == 196608) {
            iMMessage2 = this.f10807y.sendImageMessage(iMMessage, this.f10773I, this.f10768D);
        } else if (type == 327680) {
            iMMessage2 = this.f10807y.sendTextMessage(iMMessage, this.f10773I, this.f10768D, (IMSendMessageCallback) null);
        } else if (type == 393223) {
            iMMessage2 = this.f10807y.sendTextMessage(iMMessage, this.f10773I, this.f10768D, (IMSendMessageCallback) null);
        } else if (type == 458752) {
            iMMessage2 = this.f10807y.sendTextMessage(iMMessage, this.f10773I, this.f10768D, (IMSendMessageCallback) null);
        } else if (type == 10486017) {
            iMMessage2 = this.f10807y.sendTextMessage(iMMessage, this.f10773I, this.f10768D, (IMSendMessageCallback) null);
        } else {
            return;
        }
        this.f10802t.updateItemState(iMMessage2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9392a(IMBaseResponse iMBaseResponse) {
        if (iMBaseResponse != null && this.f10807y != null && !iMBaseResponse.isSuccess()) {
            String str = iMBaseResponse.errmsg;
            int i = iMBaseResponse.errno;
            if (i == 200000010 || i == 200000011 || i == 200000012) {
                if (!TextUtils.isEmpty(str)) {
                    long uid = IMContextInfoHelper.getUid();
                    long randId = IMIdGenerator.getInstance().getRandId();
                    IMMessageDaoEntity iMMessageDaoEntity = new IMMessageDaoEntity();
                    iMMessageDaoEntity.setText_content(iMBaseResponse.errmsg);
                    iMMessageDaoEntity.setStatus(200);
                    iMMessageDaoEntity.setSession_id(this.f10767C);
                    iMMessageDaoEntity.setCreate_time(System.currentTimeMillis());
                    iMMessageDaoEntity.setType(IMApiConst.MsgTypeSystem);
                    IMMessage iMMessage = new IMMessage(iMMessageDaoEntity);
                    iMMessage.setSenderUid(uid);
                    iMMessage.setContent(iMBaseResponse.errmsg);
                    iMMessage.setUniqueId(this.f10767C, randId);
                    m9408b(iMMessage);
                    this.f10807y.insertMessage(iMMessage);
                }
            } else if (!TextUtils.isEmpty(str)) {
                m9383a((int) R.drawable.im_toast_warm, str);
            }
        }
    }

    public void onUserInfoLoaded(HashMap<Long, IMUser> hashMap, long[] jArr) {
        if (hashMap == null || hashMap.isEmpty()) {
            m9443q();
            return;
        }
        this.f10802t.setUsers(hashMap);
        this.f10802t.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m9443q() {
        IMSession iMSession = this.f10768D;
        if (iMSession == null || iMSession.getType() != 4) {
            OmegaUtil.trackTitleNamePath(getString(R.string.bts_user_default_name), this.f10768D, 4);
            this.f10796f.setTitle(IMResource.getString(R.string.bts_user_default_name));
            return;
        }
        this.f10796f.setTitle(IMResource.getString(R.string.im_details_activity_default_title));
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m9445r() {
        this.f10778N = false;
        if (this.f10799q != null && this.f10802t.getItemCount() > 0) {
            this.f10799q.scrollToPosition(this.f10802t.getItemCount() - 1);
        }
        this.f10793ab.postDelayed(new Runnable() {
            public void run() {
                boolean unused = IMMessageActivity.this.f10778N = false;
                if (IMMessageActivity.this.f10799q != null) {
                    IMMessageActivity.this.f10799q.scrollBy(0, 300);
                }
            }
        }, 100);
    }

    public void onBackPressed() {
        IMBaseBottomBar iMBaseBottomBar = this.f10797g;
        if (iMBaseBottomBar == null || !iMBaseBottomBar.onBackPressed()) {
            try {
                finish();
            } catch (Exception e) {
                IMLog.m10022e(e);
                IMTraceError.trackError("im_message_aty_back_fail", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m9447s() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getApplicationWindowToken(), 2);
            }
        } catch (Exception e) {
            IMLog.m10021e(f10753b, "[closeSoftInput]", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        MessageAdapter messageAdapter = this.f10802t;
        if (messageAdapter != null) {
            messageAdapter.hidePopup();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    public void onResendMessage(IMMessage iMMessage) {
        m9414c(iMMessage);
    }

    public boolean interceptMessageUrl(String str) {
        IMBusinessConfig iMBusinessConfig = this.f10804v;
        if (iMBusinessConfig != null) {
            return iMBusinessConfig.interceptMessageUrl(this, this.f10768D, str);
        }
        return false;
    }

    public void displayEggs(IMConfig.EggsInfo eggsInfo) {
        this.f10800r.displayEggs(eggsInfo);
    }

    /* renamed from: t */
    private void m9448t() {
        IMMessage lastMessage = this.f10802t.getLastMessage();
        if (lastMessage != null) {
            lastMessage.lastMessage = this.f10768D.getDraft();
        } else {
            lastMessage = new IMMessage(65536);
            lastMessage.setContent("");
            lastMessage.setCreateTime(System.currentTimeMillis());
            lastMessage.setSid(this.f10767C);
        }
        lastMessage.setSidType(this.f10768D.getType());
        IMManager.getInstance().updateSession(lastMessage);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateEvent(IMSessionInfoUpdateEvent iMSessionInfoUpdateEvent) {
        IMLog.m10020d("IMEventDispatcher", "NOTIFY_SEESIONINFO_CHANGE handleSessionUpdate-->");
        m9410b(iMSessionInfoUpdateEvent.imSessionList);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateErrorEvent(IMSessionInfoUpdateErrorEvent iMSessionInfoUpdateErrorEvent) {
        IMLog.m10020d("IMEventDispatcher", "NOTIFY_SEESIONINFO_CHANGE onSessionInfoUpdateErrorEvent--> " + iMSessionInfoUpdateErrorEvent.errorStatusCode);
        if (iMSessionInfoUpdateErrorEvent.errorStatusCode == 111) {
            IMBusinessParam iMBusinessParam = this.f10773I;
            if (iMBusinessParam != null) {
                iMBusinessParam.clearSecret();
            }
            this.f10806x.updateSessionEnableStatus(this.f10767C, false, 0);
            this.f10768D.setSessionEnable(false);
            IMBaseBottomBar iMBaseBottomBar = this.f10797g;
            if (iMBaseBottomBar != null) {
                iMBaseBottomBar.onStatusChanged(this.f10768D);
                return;
            }
            this.f10768D.setExtendSessionInfo(new IMSessionExtendInfo((String) null, (String) null, 0, (String) null, (String) null, 0, (String) null));
            m9381a(0);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onOuterFinishEvent(IMMessageDetailFinishEvent iMMessageDetailFinishEvent) {
        if (this.f10767C == iMMessageDetailFinishEvent.finishSessionId) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9410b(List<IMSession> list) {
        if (list != null && list.size() > 0) {
            IMSession iMSession = list.get(0);
            if (iMSession.getSessionId() == this.f10768D.getSessionId()) {
                IMBusinessParam iMBusinessParam = this.f10773I;
                if (iMBusinessParam != null) {
                    iMBusinessParam.clearSecret();
                }
                IMSession iMSession2 = this.f10768D;
                this.f10768D = iMSession;
                m9395a(iMSession2, iMSession);
                m9394a(this.f10768D);
                IMLog.m10020d("IMEventDispatcher", "NOTIFY_SEESIONINFO_CHANGE mSession status-->" + this.f10768D.getSessionEnable());
                IMSessionExtendInfo extendSessionInfo = this.f10768D.getExtendSessionInfo();
                if (extendSessionInfo != null) {
                    if (this.f10768D.getSessionEnable()) {
                        this.f10806x.updateSessionEnableStatus(this.f10767C, true, extendSessionInfo.input);
                    } else {
                        this.f10806x.updateSessionEnableStatus(this.f10767C, false, extendSessionInfo.input);
                    }
                }
                IMCustomContext iMCustomContext = this.f10769E;
                if (iMCustomContext != null) {
                    iMCustomContext.setSession(this.f10768D);
                }
                MessageAdapter messageAdapter = this.f10802t;
                if (messageAdapter != null) {
                    messageAdapter.setSessionInfo(this.f10768D.supportMsgReadStatus, this.f10768D.supportTranslate);
                }
                MessageAdapter messageAdapter2 = this.f10802t;
                if (messageAdapter2 != null) {
                    messageAdapter2.updateRenderCardEnv(this.f10767C, IMParamUtil.getTraceOrderId(this.f10773I, this.f10768D), IMParamUtil.getTraceExtra(this.f10773I, this.f10780P));
                }
                m9451u();
            }
        }
    }

    /* renamed from: u */
    private void m9451u() {
        IMSession iMSession = this.f10768D;
        if (iMSession != null && iMSession.getExtendSessionInfo() != null && this.f10807y != null && this.f10768D.getExtendSessionInfo().input == 0 && IMStreetUtils.containsStreetImage(this.f10768D)) {
            this.f10807y.handleExpiredPicture(this.f10768D.getSessionId());
        }
    }

    /* renamed from: a */
    private void m9395a(IMSession iMSession, IMSession iMSession2) {
        if (iMSession != null && iMSession2 != null) {
            int i = iMSession.getExtendSessionInfo() != null ? iMSession.getExtendSessionInfo().input : -1;
            int i2 = iMSession2.getExtendSessionInfo() != null ? iMSession2.getExtendSessionInfo().input : -1;
            IMLog.m10020d("IMBottombar", "handle bar oldstatus " + i + "   newStatus " + i2);
            if (this.f10797g == null) {
                if (i2 == 0 || i2 == 1) {
                    m9381a(0);
                } else if (i2 == 2) {
                    m9381a(1);
                }
                m9419e();
            } else if ((i == -1 || i == 0 || i == 1) && i2 == 2) {
                m9381a(1);
                return;
            } else if ((i == -1 || i == 2) && (i2 == 0 || i2 == 1)) {
                m9381a(0);
                return;
            }
            IMBaseBottomBar iMBaseBottomBar = this.f10797g;
            if (iMBaseBottomBar != null) {
                iMBaseBottomBar.onStatusChanged(this.f10768D);
                if (!TextUtils.isEmpty(iMSession2.recommendString)) {
                    this.f10797g.setRecommendInfo(this.f10768D.recommendString);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9381a(int i) {
        if (this.f10773I != null) {
            String str = null;
            if (this.f10768D.getType() == 4) {
                IMBaseBottomBar iMBaseBottomBar = this.f10797g;
                if (iMBaseBottomBar != null) {
                    iMBaseBottomBar.dettachFromParent();
                    this.f10797g = null;
                    return;
                }
                return;
            }
            IMBaseBottomBar iMBaseBottomBar2 = this.f10797g;
            if (iMBaseBottomBar2 != null) {
                iMBaseBottomBar2.onDestroyView();
                this.f10797g = null;
            }
            if (this.f10768D.getExtendSessionInfo() == null || (this.f10768D.getExtendSessionInfo().input == 2 && TextUtils.isEmpty(this.f10768D.recommendString) && TextUtils.isEmpty(IMInnerData.getInstance().getRecommendInfo(Long.valueOf(this.f10768D.getSessionId()))))) {
                this.f10772H.setVisibility(0);
                IMLoadingView iMLoadingView = (IMLoadingView) this.f10772H.findViewById(R.id.im_detailes_loading_icon);
                iMLoadingView.setVisibility(0);
                iMLoadingView.startLoading();
                this.f10772H.findViewById(R.id.im_detailes_loading_text).setVisibility(8);
                return;
            }
            if (this.f10772H.isShown()) {
                this.f10772H.setVisibility(8);
            }
            if (i == 0) {
                i = (this.f10768D.getExtendSessionInfo() != null ? this.f10768D.getExtendSessionInfo().input : 0) == 2 ? 1 : 0;
            }
            if (i == 1) {
                str = this.f10804v.getBottomBarClass();
                IMLog.m10020d("IMBottomBar", "拿到的类名" + str);
            }
            if (TextUtils.isEmpty(str)) {
                this.f10797g = IMBaseBottomBar.instantiate((Context) this, IMConversationBottomBar.class);
            } else {
                IMBaseBottomBar instantiate = IMBaseBottomBar.instantiate((Context) this, str);
                this.f10797g = instantiate;
                if (instantiate == null) {
                    this.f10797g = IMBaseBottomBar.instantiate((Context) this, IMConversationBottomBar.class);
                }
            }
            this.f10797g.setBottomBarData(this.f10768D, this.f10773I, this.f10804v, this.f10777M);
            this.f10797g.setActivityFrom(this.f10780P);
            this.f10797g.attachToParent((LinearLayout) findViewById(R.id.bts_im_layout));
            this.f10797g.setBottomBarListener(this);
            IMBaseBottomBar iMBaseBottomBar3 = this.f10797g;
            if (iMBaseBottomBar3 instanceof IMConversationBottomBar) {
                ((IMConversationBottomBar) iMBaseBottomBar3).bindEmotionInputDetector(this, this.f10770F);
                ((IMConversationBottomBar) this.f10797g).setRecommendEmojiView(this.f10779O);
            }
            this.f10797g.onActivityCreate();
            this.f10797g.onStatusChanged(this.f10768D);
            this.f10797g.setRecommendInfo(this.f10768D.recommendString);
        }
    }

    /* renamed from: a */
    private void m9394a(IMSession iMSession) {
        m9427i();
        m9415c(iMSession);
        m9409b(iMSession);
    }

    /* renamed from: b */
    private void m9409b(IMSession iMSession) {
        List<IMUser> userInfos = iMSession.getUserInfos();
        if (userInfos != null && userInfos.size() != 0) {
            HashMap hashMap = new HashMap((int) (((double) userInfos.size()) * 1.5d));
            for (IMUser next : userInfos) {
                hashMap.put(Long.valueOf(next.getUid()), next);
            }
            this.f10802t.setUsers(hashMap);
            this.f10802t.notifyDataSetChanged();
        }
    }

    /* renamed from: c */
    private void m9415c(IMSession iMSession) {
        if (iMSession.operationBody != null) {
            this.f10801s.setVisibility(0);
            this.f10801s.setData(iMSession.operationBody);
        } else if (!TextUtils.isEmpty(iMSession.getTipText())) {
            this.f10801s.setVisibility(0);
            IMTopOperationBody iMTopOperationBody = new IMTopOperationBody();
            iMTopOperationBody.btnLink = String.format(getString(R.string.im_user_profileweb_uri), new Object[]{Long.valueOf(IMSession.getPeerId(this.f10768D.getUserIds()).longValue() & -281474976710657L), 103});
            iMTopOperationBody.btnText = iMSession.getTipFol();
            iMTopOperationBody.tipText = iMSession.getTipText();
            this.f10801s.setData(iMTopOperationBody);
        } else {
            this.f10801s.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showRecommendCustomDialog(IMShowCustomWordDialogEvent iMShowCustomWordDialogEvent) {
        showAddCustomWordDialog(iMShowCustomWordDialogEvent.text, 2);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showLocationDialog(IMSendAddressEvent iMSendAddressEvent) {
        IMBusinessConfig iMBusinessConfig;
        final IMAddress iMAddress = iMSendAddressEvent.address;
        if (iMAddress != null && (iMBusinessConfig = this.f10804v) != null && iMBusinessConfig.isShowExtendIcon()) {
            IMDialog confirmDialog = IMDialogFactory.getConfirmDialog((Activity) this, IMResource.getDrawableID(R.drawable.im_dialog_icon_location), String.format(getString(R.string.bts_im_location_alert), new Object[]{iMAddress.getDisplayname()}), getString(R.string.alert_ok), getString(R.string.alert_cancel), (IMDialog.Callback) new IMDialog.Callback() {
                public void onCancel() {
                }

                public void onSubmit() {
                    if (IMMessageActivity.this.f10807y != null) {
                        IMMessageActivity.this.m9408b(IMMessageActivity.this.f10807y.sendLocationMessage(IMMessageActivity.this.buildFromAddress(iMAddress), IMApiConst.MsgTypeSendLocation, IMMessageActivity.this.f10773I, IMMessageActivity.this.f10768D));
                    }
                }
            });
            this.f10805w = confirmDialog;
            confirmDialog.show(this.mController, getSupportFragmentManager(), "show_location");
        }
    }

    public IMLocationEntity buildFromAddress(IMAddress iMAddress) {
        IMLocationEntity iMLocationEntity = new IMLocationEntity();
        iMLocationEntity.displayname = iMAddress.getDisplayname();
        iMLocationEntity.cityId = iMAddress.getCityId();
        iMLocationEntity.cityName = iMAddress.getCityName();
        iMLocationEntity.lat = iMAddress.getLat();
        iMLocationEntity.lng = iMAddress.getLng();
        iMLocationEntity.address = iMAddress.getAddress();
        iMLocationEntity.country_iso_code = iMAddress.getIsoCode();
        if (IMTextUtil.isEmpty(iMLocationEntity.address)) {
            iMLocationEntity.address = iMAddress.getDisplayname();
        }
        return iMLocationEntity;
    }

    /* renamed from: v */
    private void m9453v() {
        Intent intent = new Intent();
        intent.setAction(IMEventDispatcher.IM_ACTION_LOCATION_REQUEST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /* renamed from: w */
    private void m9455w() {
        View view = this.f10770F;
        if (view != null) {
            int height = view.getHeight();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10770F.getLayoutParams();
            layoutParams.height = height;
            layoutParams.weight = 0.0f;
            this.f10770F.setLayoutParams(layoutParams);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void unLockRecycleHeight(IMMessageUnlockRecyclerViewEvent iMMessageUnlockRecyclerViewEvent) {
        View view = this.f10770F;
        if (view != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = 0;
            layoutParams.weight = 1.0f;
            this.f10770F.setLayoutParams(layoutParams);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void skipToMainActivity(IMSkipToMainActivityEvent iMSkipToMainActivityEvent) {
        m9456x();
        m9398a(iMSkipToMainActivityEvent.url);
    }

    /* renamed from: x */
    private void m9456x() {
        if (IMContextInfoHelper.getAppMainClass() != null) {
            Intent intent = new Intent(this, IMContextInfoHelper.getAppMainClass());
            intent.addFlags(View.STATUS_BAR_TRANSIENT);
            startActivity(intent);
        }
    }

    /* renamed from: a */
    private void m9398a(String str) {
        try {
            final Intent intent = Intent.getIntent(str);
            intent.setAction("android.intent.action.VIEW");
            this.f10793ab.postDelayed(new Runnable() {
                public void run() {
                    try {
                        IMMessageActivity.this.startActivity(intent);
                    } catch (Exception e) {
                        IMLog.m10021e(IMMessageActivity.f10753b, "switchBranch", e);
                    }
                }
            }, 500);
        } catch (URISyntaxException e) {
            IMLog.m10021e(f10753b, "switchBranch", e);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void msgListIsEmpty(IMMessageEmptyEvent iMMessageEmptyEvent) {
        IMSession iMSession = this.f10768D;
        if (iMSession != null && iMSession.getType() == 4) {
            this.f10781Q.setVisibility(0);
            this.f10782R.setVisibility(0);
            this.f10799q.setVisibility(8);
            this.f10800r.setVisibility(8);
            this.f10781Q.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_no_history_msg));
            this.f10782R.setText(IMResource.getString(R.string.im_nomix_no_history_msg_text));
            IMLog.m10020d("IMview", "has set empty bg");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleInnerSchemeEvent(com.didi.beatles.p101im.event.IMInnerSchemeEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getAction()
            int r1 = r0.hashCode()
            r2 = -2098199687(0xffffffff82f00379, float:-3.5266824E-37)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x001f
            r2 = 664593897(0x279ce5e9, float:4.3547967E-15)
            if (r1 == r2) goto L_0x0015
            goto L_0x0029
        L_0x0015:
            java.lang.String r1 = "/take_photo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x001f:
            java.lang.String r1 = "/send_msg"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 0
            goto L_0x002a
        L_0x0029:
            r0 = -1
        L_0x002a:
            if (r0 == 0) goto L_0x0051
            if (r0 == r4) goto L_0x004d
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[handleInnerSchemeEvent] Invalid event : "
            r1.append(r2)
            java.lang.String r6 = r6.getAction()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0[r3] = r6
            java.lang.String r6 = "IMMessageActivity"
            com.didi.beatles.p101im.utils.IMLog.m10021e(r6, r0)
            goto L_0x0058
        L_0x004d:
            r5.m9458y()
            goto L_0x0058
        L_0x0051:
            java.lang.Object r6 = r6.getData()
            r5.m9397a((java.lang.Object) r6)
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.activity.IMMessageActivity.handleInnerSchemeEvent(com.didi.beatles.im.event.IMInnerSchemeEvent):void");
    }

    /* renamed from: a */
    private void m9397a(Object obj) {
        String str;
        if (obj instanceof IMOrderStatusChangeBody.ExtendInfo) {
            IMOrderStatusChangeBody.ExtendInfo extendInfo = (IMOrderStatusChangeBody.ExtendInfo) obj;
            IMLog.m10020d(f10753b, "[handleSendMsgScheme] " + extendInfo.msgType + " | " + extendInfo.msgData);
            if (extendInfo.msgType > 0 && extendInfo.msgData != null) {
                int i = extendInfo.msgType;
                if (i == 65536) {
                    str = extendInfo.msgData.content;
                } else if (i != 458752) {
                    str = null;
                } else {
                    str = IMJsonUtil.jsonFromObject(extendInfo.msgData);
                }
                if (str != null) {
                    m9399a(str, extendInfo.msgType, -1, (Object) null);
                }
            }
        }
    }

    /* renamed from: y */
    private void m9458y() {
        IMLog.m10020d(f10753b, "[handleTakePhotoScheme]");
        IMPictureSelector.create((Activity) this).openCamera().maxImageSize(200).glideOverride(160, 160).compress(true).minimumCompressSize(100).forResult(188);
    }
}
