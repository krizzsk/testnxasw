package com.didi.beatles.p101im.access.notify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.core.IMPushEngine;
import com.didi.beatles.p101im.access.notify.NotificationAdapter;
import com.didi.beatles.p101im.access.utils.Parser;
import com.didi.beatles.p101im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMMessageCallback;
import com.didi.beatles.p101im.module.IMSendMessageCallback;
import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.module.entity.IMUser;
import com.didi.beatles.p101im.omega.IMMessageTraceUtil;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.omega.OmegaUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.IMInterceptEventLinearLayout;
import com.didi.beatles.p101im.views.buttonView.IMPushBtnView;
import com.didi.beatles.p101im.views.imageView.IMRoundedImageView;
import com.didichuxing.omega.sdk.common.backend.ActivityLifecycleRegister;
import com.google.firebase.messaging.Constants;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.didi.beatles.im.access.notify.NotiFloatWindow */
public class NotiFloatWindow {

    /* renamed from: a */
    private static final String f10607a = "NotiFloatWindow";

    /* renamed from: b */
    private static final int f10608b = 300;

    /* renamed from: c */
    private static final int f10609c = 1000;

    /* renamed from: d */
    private static final int f10610d = 5000;

    /* renamed from: e */
    private static final int f10611e = 90;

    /* renamed from: f */
    private static final int f10612f = 120;

    /* renamed from: g */
    private static final int f10613g = 0;

    /* renamed from: h */
    private static final int f10614h = 1;

    /* renamed from: i */
    private static final int f10615i = 2;

    /* renamed from: j */
    private static final int f10616j = 3;

    /* renamed from: k */
    private static final int f10617k = 122;

    /* renamed from: l */
    private static final int f10618l = 78;

    /* renamed from: m */
    private static final int f10619m = 133;

    /* renamed from: q */
    private static NotiFloatWindow f10620q = null;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static int f10621u = 0;

    /* renamed from: w */
    private static final int f10622w = 0;

    /* renamed from: x */
    private static final int f10623x = 1;

    /* renamed from: y */
    private static final int f10624y = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public Runnable f10625A = new Runnable() {
        public void run() {
            NotiFloatWindow.this.m9248e();
        }
    };

    /* renamed from: n */
    private Context f10626n;

    /* renamed from: o */
    private View f10627o;

    /* renamed from: p */
    private Queue<IMMessage> f10628p = new LinkedList();

    /* renamed from: r */
    private IMMessageCallback f10629r = null;

    /* renamed from: s */
    private IMMessage f10630s;

    /* renamed from: t */
    private ActivityLifecycleRegister.ActivityLifecycleListener f10631t;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public String f10632v;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public Runnable f10633z = new Runnable() {
        public void run() {
            NotiFloatWindow.this.m9237b(0);
            UiThreadHandler.postDelayed(NotiFloatWindow.this.f10625A, 1000);
        }
    };

    /* renamed from: f */
    private int m9251f(IMMessage iMMessage) {
        return 5000;
    }

    /* renamed from: b */
    static /* synthetic */ int m9235b() {
        int i = f10621u;
        f10621u = i + 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m9240c() {
        int i = f10621u;
        f10621u = i - 1;
        return i;
    }

    public static NotiFloatWindow getInstance(Context context) {
        if (f10620q == null) {
            f10620q = new NotiFloatWindow(context);
        }
        return f10620q;
    }

    private NotiFloatWindow(Context context) {
        this.f10626n = context;
        m9244d();
    }

    /* renamed from: d */
    private void m9244d() {
        C43901 r0 = new ActivityLifecycleRegister.ActivityLifecycleListener() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivityStarted(Activity activity) {
                if (NotiFloatWindow.f10621u == 0) {
                    NotiFloatWindow.this.m9233a(true);
                }
                NotiFloatWindow.m9235b();
            }

            public void onActivityStopped(Activity activity) {
                NotiFloatWindow.m9240c();
                if (NotiFloatWindow.f10621u <= 0) {
                    int unused = NotiFloatWindow.f10621u = 0;
                    NotiFloatWindow.this.m9233a(false);
                }
            }
        };
        this.f10631t = r0;
        ActivityLifecycleRegister.addActivityLifecycleListener(r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9233a(boolean z) {
        Queue<IMMessage> queue = this.f10628p;
        int size = queue != null ? queue.size() : 0;
        IMLog.m10020d(f10607a, "[notifyAppStateChanged] isAppActive=" + z + " |size=" + size);
        if (!z) {
            m9255g();
            m9237b(0);
        } else if (this.f10627o == null) {
            m9253f();
            m9248e();
        }
    }

    public void destroy() {
        m9255g();
        m9237b(0);
        this.f10628p.clear();
    }

    public void add(IMMessage iMMessage) {
        if (iMMessage != null) {
            try {
                if (m9243c(iMMessage)) {
                    IMResource.setBusinessId(iMMessage.getBusinessId());
                    this.f10628p.add(iMMessage);
                    if (this.f10627o == null) {
                        UiThreadHandler.removeCallbacks(this.f10625A);
                        m9248e();
                    }
                }
            } catch (Exception e) {
                IMTraceError.trackError("im_notiwindow_add_error", e);
            }
        }
    }

    public void clearImMsg(long j) {
        Queue<IMMessage> queue = this.f10628p;
        if (queue != null && !queue.isEmpty()) {
            Iterator it = this.f10628p.iterator();
            while (it.hasNext()) {
                IMMessage iMMessage = (IMMessage) it.next();
                if ((iMMessage instanceof IMMessage) && iMMessage.getSid() == j) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m9248e() {
        Queue<IMMessage> queue = this.f10628p;
        if (queue != null && !queue.isEmpty() && !m9234a(this.f10628p.poll())) {
            m9248e();
        }
    }

    /* renamed from: a */
    private boolean m9234a(final IMMessage iMMessage) {
        WindowManager.LayoutParams layoutParams;
        if (!m9239b(iMMessage)) {
            return false;
        }
        View h = m9256h(iMMessage);
        this.f10627o = h;
        if (h == null) {
            return false;
        }
        this.f10630s = iMMessage;
        m9250e(iMMessage);
        if (iMMessage.btns != null && iMMessage.btns.size() > 0) {
            layoutParams = m9241c(3);
        } else if (!m9247d(iMMessage) || iMMessage.showFailedMsg) {
            layoutParams = m9241c(2);
        } else {
            layoutParams = m9241c(0);
        }
        OmegaUtil.trackExtendMsg("ddim_msg_all_display_sw", iMMessage, (Map<String, Object>) null);
        this.f10627o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                UiThreadHandler.postDelayed(NotiFloatWindow.this.f10625A, 1000);
                NotiFloatWindow.this.m9230a(iMMessage, 2);
                IMMessageTraceUtil.trackMessageCoreEvent("ddim_push_all_ck", iMMessage).add("push_type", 1).add("push_type_new", 1).report();
                IMTraceUtil.addBusinessEvent("msg_remind_ck").add("business_id", Integer.valueOf(iMMessage.getBusinessId())).add("type", 0).add("msg_id", Long.valueOf(iMMessage.getMid())).report();
            }
        });
        ((IMInterceptEventLinearLayout) this.f10627o).setSlideListener(new IMInterceptEventLinearLayout.SlideListener() {
            public void onSlideDown() {
            }

            public void onSlideUp() {
                UiThreadHandler.removeCallbacks(NotiFloatWindow.this.f10633z);
                NotiFloatWindow.this.m9237b(1);
                UiThreadHandler.postDelayed(NotiFloatWindow.this.f10625A, 1000);
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_upcls_ck", iMMessage);
            }
        });
        if (NotiWindowManager.addView(this.f10627o, layoutParams)) {
            IMMessageTraceUtil.trackMessageCoreEvent("ddim_push_all_sw", iMMessage).add("push_type", 1).add("push_type_new", 1).report();
            IMTraceUtil.addBusinessEvent("msg_remind_sw").add("business_id", Integer.valueOf(iMMessage.getBusinessId())).add("type", 0).add("msg_id", Long.valueOf(iMMessage.getMid())).report();
        }
        UiThreadHandler.postDelayed(this.f10633z, (long) m9251f(iMMessage));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9230a(IMMessage iMMessage, int i) {
        m9237b(2);
        String dispatchMessageActionUrl = Parser.getDispatchMessageActionUrl(iMMessage);
        if (!TextUtils.isEmpty(dispatchMessageActionUrl)) {
            IMLog.m10020d(f10607a, "IM Push Log Open Uri:" + dispatchMessageActionUrl);
            IMCommonUtil.startUriActivity(this.f10626n, dispatchMessageActionUrl, (Object) null);
            return;
        }
        IMBusinessParam iMBusinessParam = new IMBusinessParam();
        iMBusinessParam.setSessionId(iMMessage.getSid());
        iMBusinessParam.setSelfUid(IMContextInfoHelper.getUid());
        iMBusinessParam.setPeerUid(iMMessage.getSenderUid());
        iMBusinessParam.setBusinessId(iMMessage.getBusinessId());
        iMBusinessParam.setOrderId(iMMessage.getoId());
        iMBusinessParam.setRouteId(iMMessage.getRouteId());
        iMBusinessParam.setSessionType(iMMessage.getSidType());
        iMBusinessParam.setBottomInputConfig(i);
        IMEngine.startIMActivityWithNewTaskFlag(this.f10626n, iMBusinessParam, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9237b(int i) {
        View view = this.f10627o;
        if (view != null && view.isShown()) {
            m9245d(i);
        }
        View view2 = this.f10627o;
        if (view2 != null) {
            NotiWindowManager.removeView(view2);
            this.f10627o = null;
        }
    }

    /* renamed from: f */
    private void m9253f() {
        Runnable runnable = this.f10625A;
        if (runnable != null) {
            UiThreadHandler.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m9255g() {
        Runnable runnable = this.f10633z;
        if (runnable != null) {
            UiThreadHandler.removeCallbacks(runnable);
        }
    }

    /* renamed from: b */
    private boolean m9239b(IMMessage iMMessage) {
        return m9243c(iMMessage);
    }

    /* renamed from: c */
    private boolean m9243c(IMMessage iMMessage) {
        if (IMEngine.getInstance(this.f10626n).getCurrentBusinessConfig(iMMessage.getSidType(), iMMessage.getBusinessId()).isOpenGlobalAlert() && IMPushEngine.isInApplication() && !IMPushEngine.inThisMessagePage(iMMessage)) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private boolean m9247d(IMMessage iMMessage) {
        int businessId = iMMessage.getBusinessId();
        if (!IMEngine.getInstance(this.f10626n).getCurrentBusinessConfig(iMMessage.getSidType(), businessId).isFloatShowQuickButton()) {
            IMLog.m10021e(f10607a, "The Apollo key isQuickButtonShow is off");
            return false;
        } else if (iMMessage.getType() != 65536) {
            IMLog.m10021e(f10607a, "msg type not text");
            return false;
        } else if (IMContextInfoHelper.getQuickReplyList(businessId) != null) {
            return true;
        } else {
            IMLog.m10021e(f10607a, "quick reply list is null");
            return false;
        }
    }

    /* renamed from: e */
    private void m9250e(IMMessage iMMessage) {
        if (iMMessage != null && IMContextInfoHelper.getContext() != null && "com.sdu.didi.gsui".equals(IMContextInfoHelper.getContext().getPackageName()) && iMMessage.mact == 1) {
            IMMessageReadStatusManager.getInstance().ackHasReadMsg(iMMessage);
        }
    }

    /* renamed from: g */
    private int m9254g(IMMessage iMMessage) {
        return IMViewUtil.dp2px(IMContextInfoHelper.getContext(), 300.0f);
    }

    /* renamed from: c */
    private WindowManager.LayoutParams m9241c(int i) {
        WindowManager.LayoutParams baseWindowLayoutParams = NotiWindowManager.getBaseWindowLayoutParams();
        baseWindowLayoutParams.gravity = 48;
        baseWindowLayoutParams.windowAnimations = R.style.btsNotificationStyle;
        baseWindowLayoutParams.width = IMViewUtil.getWindowWidth(IMContextInfoHelper.getContext());
        if (i == 0) {
            baseWindowLayoutParams.height = IMViewUtil.dp2px(IMContextInfoHelper.getContext(), 122.0f);
        } else if (i == 1) {
            baseWindowLayoutParams.height = IMViewUtil.getWindowHeight(IMContextInfoHelper.getContext());
        } else if (i == 2) {
            baseWindowLayoutParams.height = IMViewUtil.dp2px(IMContextInfoHelper.getContext(), 78.0f);
        } else if (i == 3) {
            baseWindowLayoutParams.height = IMViewUtil.dp2px(IMContextInfoHelper.getContext(), 133.0f);
        }
        return baseWindowLayoutParams;
    }

    /* renamed from: h */
    private View m9256h(IMMessage iMMessage) {
        try {
            return m9222a(iMMessage, iMMessage.showFailedMsg);
        } catch (Exception e) {
            IMTraceError.trackError(f10607a, e);
            return null;
        }
    }

    /* renamed from: a */
    private View m9222a(final IMMessage iMMessage, boolean z) {
        IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(iMMessage.getSidType(), iMMessage.getBusinessId());
        m9224a(iMMessage.getSid());
        View inflate = LayoutInflater.from(this.f10626n).inflate(R.layout.im_message_push_noti_view, (ViewGroup) null);
        inflate.setBackgroundColor(IMResource.getColor(R.color.im_float_cover_color));
        inflate.findViewById(R.id.im_float_info_rl).setBackgroundColor(IMResource.getColor(R.color.im_nomix_color_float_window_back));
        TextView textView = (TextView) inflate.findViewById(R.id.im_content);
        TextView textView2 = (TextView) inflate.findViewById(R.id.im_push_nick);
        IMRoundedImageView iMRoundedImageView = (IMRoundedImageView) inflate.findViewById(R.id.contact_portrait);
        if (z) {
            if (!TextUtils.isEmpty(iMMessage.pushText)) {
                textView2.setText(iMMessage.pushText);
            }
            iMRoundedImageView.setImageResource(IMResource.getDrawableID(R.drawable.im_send_failed_icon));
            textView.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
            textView.setText(R.string.im_float_widow_send_failed_title);
            return inflate;
        }
        if (!TextUtils.isEmpty(iMMessage.floatPushText)) {
            textView2.setText(iMMessage.floatPushText);
        }
        if (!TextUtils.isEmpty(iMMessage.getNickName())) {
            textView.setText(iMMessage.getNickName());
        }
        if (IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(iMMessage.getSidType(), iMMessage.getBusinessId()).isShowPeerAvatar()) {
            if (TextUtils.isEmpty(iMMessage.getHeadUrl())) {
                m9232a(iMRoundedImageView, iMMessage.getSenderUid());
            } else {
                BtsImageLoader.getInstance().loadInto(iMMessage.getHeadUrl(), iMRoundedImageView);
            }
        }
        if (iMMessage.btns != null && iMMessage.btns.size() > 0) {
            IMPushBtnView iMPushBtnView = (IMPushBtnView) inflate.findViewById(R.id.im_push_view);
            iMPushBtnView.setVisibility(0);
            iMPushBtnView.setData(iMMessage);
            iMPushBtnView.setBtnOnclickListener(new IMPushBtnView.BtnOnClick() {
                public void onClick() {
                    IMManager.getInstance().clearIMRedDot();
                    NotiFloatWindow.this.m9237b(2);
                }
            });
            inflate.findViewById(R.id.push_noti_line).setVisibility(8);
            return inflate;
        } else if (!m9247d(iMMessage)) {
            return inflate;
        } else {
            inflate.findViewById(R.id.push_noti_line).setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
            inflate.findViewById(R.id.im_float_quick_reply).setBackgroundColor(IMResource.getColor(R.color.im_nomix_color_float_window_back));
            final View findViewById = inflate.findViewById(R.id.reply_container);
            final TextView textView3 = (TextView) inflate.findViewById(R.id.reply_txt);
            textView3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMMessageReadStatusManager.getInstance().ackHasReadMsg(iMMessage);
                    textView3.setVisibility(8);
                    findViewById.setVisibility(0);
                    NotiFloatWindow.this.m9255g();
                    NotiFloatWindow.this.m9257h();
                    OmegaUtil.trackFloatWindowOmega("ddim_fc_all_qkrply_ck", iMMessage);
                }
            });
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f10626n);
            recyclerView.setLayoutManager(linearLayoutManager);
            final NotificationAdapter notificationAdapter = new NotificationAdapter(this.f10626n, IMContextInfoHelper.getQuickReplyList(iMMessage.getBusinessId()));
            notificationAdapter.setOnItemClickListener(new NotificationAdapter.MyItemClickListener() {
                public void onItemClick(final NotificationAdapter.ViewHolder viewHolder, String str) {
                    NotiFloatWindow.this.m9231a(iMMessage, str);
                    UiThreadHandler.postDelayed(new Runnable() {
                        public void run() {
                            notificationAdapter.showHasSend(viewHolder);
                        }
                    }, 200);
                    UiThreadHandler.postDelayed(NotiFloatWindow.this.f10633z, 1000);
                    OmegaUtil.trackFloatWindowOmega("ddim_fc_all_qkmsg_ck", iMMessage);
                }
            });
            recyclerView.setAdapter(notificationAdapter);
            View inflate2 = LayoutInflater.from(this.f10626n).inflate(R.layout.im_notify_list_footer, recyclerView, false);
            inflate2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    OmegaUtil.trackFloatWindowOmega("ddim_fc_all_other_ck", iMMessage);
                    NotiFloatWindow.this.m9230a(iMMessage, 1);
                }
            });
            inflate.findViewById(R.id.reply_float_cover).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    OmegaUtil.trackFloatWindowOmega("ddim_fc_all_mencng_ck", iMMessage);
                    UiThreadHandler.post(NotiFloatWindow.this.f10633z);
                }
            });
            notificationAdapter.setFooterView(inflate2);
            ((IMInterceptEventLinearLayout) inflate.findViewById(R.id.notifloat_intercept_ll)).registerInterceptListener(new IMInterceptEventLinearLayout.InterceptCallback() {
                public boolean shouldIntercept() {
                    int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    ArrayList<String> quickReplyList = IMContextInfoHelper.getQuickReplyList(iMMessage.getBusinessId());
                    return quickReplyList != null && quickReplyList.size() <= findLastVisibleItemPosition;
                }
            });
            return inflate;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m9257h() {
        NotiWindowManager.updateViewLayout(this.f10627o, m9241c(1));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9231a(IMMessage iMMessage, String str) {
        if (iMMessage != null) {
            this.f10632v = iMMessage.nickName;
            IMUser iMUser = new IMUser();
            iMUser.setUid(IMContextInfoHelper.getUid());
            IMUser iMUser2 = new IMUser();
            iMUser2.setUid(iMMessage.getSenderUid());
            ArrayList arrayList = new ArrayList();
            arrayList.add(iMUser);
            arrayList.add(iMUser2);
            IMBusinessParam iMBusinessParam = new IMBusinessParam();
            iMBusinessParam.setIsQuick(1);
            IMSession iMSession = new IMSession();
            iMSession.setSessionId(iMMessage.getSid());
            iMSession.setUserInfos(arrayList);
            iMSession.setBusinessId(iMMessage.getBusinessId());
            if (IMManager.getInstance().getMessageModel() != null) {
                IMManager.getInstance().getMessageModel().sendTextMessage(str, 65536, iMBusinessParam, iMSession, (Object) null, 0, (IMSendMessageCallback) null);
                OmegaUtil.trackSendMsgOmega(iMMessage.getBusinessId(), iMMessage.getSid(), 1);
                return;
            }
            IMLog.m10021e(f10607a, "send message failed since messageModel is null");
        }
    }

    /* renamed from: d */
    private void m9245d(int i) {
        IMMessage iMMessage = this.f10630s;
        if (iMMessage != null && iMMessage.getSidType() == 4) {
            IMManager.getInstance().reportUserAction(i, this.f10630s.getSenderUid());
        }
    }

    /* renamed from: a */
    private void m9224a(long j) {
        this.f10629r = new IMMessageCallback() {
            public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
            }

            public void onReadStatusChange(List<IMMessage> list, boolean z) {
            }

            public void onReceive(List<IMMessage> list) {
            }

            public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                NotiFloatWindow.this.m9238b(iMMessage.getSid());
                if (i == 202) {
                    iMMessage.setPushText(String.format(IMContextInfoHelper.getContext().getString(R.string.im_float_widow_send_failed_content), new Object[]{NotiFloatWindow.this.f10632v}));
                    iMMessage.showFailedMsg = true;
                    NotiFloatWindow.this.add(iMMessage);
                }
            }
        };
        if (IMManager.getInstance().getMessageModel() != null) {
            IMManager.getInstance().getMessageModel().registerMessageCallback(this.f10629r, j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9238b(long j) {
        if (IMManager.getInstance().getMessageModel() != null) {
            IMManager.getInstance().getMessageModel().unregisterMessageCallback(j);
        }
    }

    /* renamed from: a */
    private void m9232a(IMRoundedImageView iMRoundedImageView, long j) {
        IMUser userInfoFromCache;
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userModel != null && (userInfoFromCache = userModel.getUserInfoFromCache(j)) != null && !TextUtils.isEmpty(userInfoFromCache.getAvatarUrl())) {
            BtsImageLoader.getInstance().loadInto(userInfoFromCache.getAvatarUrl(), iMRoundedImageView);
        }
    }

    /* renamed from: i */
    private Map<String, Object> m9258i(IMMessage iMMessage) {
        if (iMMessage == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.MessagePayloadKeys.MESSAGE_TYPE, Integer.valueOf(iMMessage.getType()));
        hashMap.put("dialogue_type", Integer.valueOf(iMMessage.getSidType()));
        hashMap.put("dialogue_id", Long.valueOf(iMMessage.getSid()));
        if (iMMessage.getMessageExtendInfo() != null) {
            hashMap.put("activity_id", Long.valueOf(iMMessage.getMessageExtendInfo().activity_id));
        } else {
            hashMap.put("activity_id", 0);
        }
        hashMap.put("business_id", Integer.valueOf(iMMessage.getBusinessId()));
        if (iMMessage.getType() == 528385) {
            hashMap.put("title", iMMessage.getTopText());
        }
        return hashMap;
    }
}
