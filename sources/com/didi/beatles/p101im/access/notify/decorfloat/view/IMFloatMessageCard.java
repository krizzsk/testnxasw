package com.didi.beatles.p101im.access.notify.decorfloat.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.notify.NotificationAdapter;
import com.didi.beatles.p101im.access.notify.decorfloat.IIMDecorFloatMsg;
import com.didi.beatles.p101im.access.notify.decorfloat.IIMDecorFloatView;
import com.didi.beatles.p101im.access.notify.decorfloat.IMDecorFloatController;
import com.didi.beatles.p101im.access.utils.Parser;
import com.didi.beatles.p101im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p101im.common.widget.IMOnAntiShakeClickListener;
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
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.omega.OmegaUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.IMInterceptEventLinearLayout;
import com.didi.beatles.p101im.views.imageView.IMRoundedImageView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.access.notify.decorfloat.view.IMFloatMessageCard */
public class IMFloatMessageCard extends FrameLayout implements LifecycleObserver, IIMDecorFloatView {

    /* renamed from: a */
    private static final String f10654a = IMFloatMessageCard.class.getSimpleName();

    /* renamed from: b */
    private static final int f10655b = 0;

    /* renamed from: c */
    private static final int f10656c = 1;

    /* renamed from: d */
    private static final int f10657d = 2;

    /* renamed from: e */
    private static final int f10658e = 122;

    /* renamed from: f */
    private static final int f10659f = 78;

    /* renamed from: k */
    private static final int f10660k = 0;

    /* renamed from: l */
    private static final int f10661l = 1;

    /* renamed from: m */
    private static final int f10662m = 2;

    /* renamed from: n */
    private static final int f10663n = 1000;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IIMDecorFloatMsg.RequestCallback f10664g;

    /* renamed from: h */
    private IMMessageCallback f10665h;

    /* renamed from: i */
    private long f10666i;

    /* renamed from: j */
    private IMMessage f10667j;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f10668o;

    /* renamed from: p */
    private View f10669p;

    public IMFloatMessageCard(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMFloatMessageCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMFloatMessageCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10665h = null;
        this.f10666i = 0;
    }

    public void setRequestCallback(IIMDecorFloatMsg.RequestCallback requestCallback) {
        this.f10664g = requestCallback;
    }

    /* renamed from: a */
    private void m9278a() {
        if (getContext() == null || !(getContext() instanceof FragmentActivity) || ((FragmentActivity) getContext()).getLifecycle() == null) {
            String str = f10654a;
            IMLog.m10021e(str, "[addLifecycleObserver] invalid activity context->" + getContext());
            return;
        }
        ((FragmentActivity) getContext()).getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroy() {
        IMLog.m10020d(f10654a, "[onActivityDestroy]");
        m9279a(0);
        long j = this.f10666i;
        if (j > 0) {
            m9290b(j);
        }
    }

    /* renamed from: b */
    private void m9289b() {
        if (getContext() == null || !(getContext() instanceof FragmentActivity) || ((FragmentActivity) getContext()).getLifecycle() == null) {
            String str = f10654a;
            IMLog.m10021e(str, "[removeLifecycleObserver] invalid activity context->" + getContext());
            return;
        }
        ((FragmentActivity) getContext()).getLifecycle().removeObserver(this);
    }

    public boolean bind(final IMMessage iMMessage) {
        ViewGroup.LayoutParams layoutParams;
        if (this.f10669p != null) {
            IMLog.m10021e(f10654a, "[bind] remove all views");
            removeAllViews();
            this.f10669p = null;
        }
        IMResource.setBusinessId(iMMessage.getBusinessId());
        View a = m9275a(iMMessage, iMMessage.showFailedMsg);
        this.f10669p = a;
        if (a == null) {
            return false;
        }
        this.f10667j = iMMessage;
        m9285a(iMMessage);
        if (!m9292b(iMMessage) || iMMessage.showFailedMsg) {
            layoutParams = m9276a((ViewGroup.LayoutParams) null, 2);
        } else {
            layoutParams = m9276a((ViewGroup.LayoutParams) null, 0);
        }
        OmegaUtil.trackExtendMsg("ddim_msg_all_display_sw", iMMessage, (Map<String, Object>) null);
        this.f10669p.setOnClickListener(new IMOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                IMFloatMessageCard.this.m9286a(iMMessage, 2);
                IMMessageTraceUtil.trackMessageCoreEvent("ddim_push_all_ck", iMMessage).add("push_type", 1).add("push_type_new", 1).report();
                IMTraceUtil.addBusinessEvent("msg_remind_ck").add("business_id", Integer.valueOf(iMMessage.getBusinessId())).add("type", 0).add("msg_id", Long.valueOf(iMMessage.getMid())).report();
            }
        });
        ((IMInterceptEventLinearLayout) this.f10669p).setSlideListener(new IMInterceptEventLinearLayout.SlideListener() {
            public void onSlideDown() {
            }

            public void onSlideUp() {
                IMFloatMessageCard.this.m9279a(1);
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_upcls_ck", iMMessage);
            }
        });
        addView(this.f10669p, layoutParams);
        IMMessageTraceUtil.trackMessageCoreEvent("ddim_push_all_sw", iMMessage).add("push_type", 1).add("push_type_new", 1).report();
        IMTraceUtil.addBusinessEvent("msg_remind_sw").add("business_id", Integer.valueOf(iMMessage.getBusinessId())).add("type", 0).add("msg_id", Long.valueOf(iMMessage.getMid())).report();
        m9278a();
        return true;
    }

    /* renamed from: a */
    private void m9285a(IMMessage iMMessage) {
        if (iMMessage != null && IMContextInfoHelper.getContext() != null && "com.sdu.didi.gsui".equals(IMContextInfoHelper.getContext().getPackageName()) && iMMessage.mact == 1) {
            IMMessageReadStatusManager.getInstance().ackHasReadMsg(iMMessage);
        }
    }

    /* renamed from: a */
    private ViewGroup.LayoutParams m9276a(ViewGroup.LayoutParams layoutParams, int i) {
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        if (i == 0) {
            layoutParams.height = IMViewUtil.dp2px(getContext(), 122.0f);
        } else if (i == 1) {
            layoutParams.height = -1;
        } else if (i == 2) {
            layoutParams.height = IMViewUtil.dp2px(getContext(), 78.0f);
        }
        return layoutParams;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9294c() {
        try {
            if (this.f10669p != null) {
                this.f10669p.setLayoutParams(m9276a(this.f10669p.getLayoutParams(), 1));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private View m9275a(final IMMessage iMMessage, boolean z) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.im_message_push_noti_view, (ViewGroup) null);
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
        if (IMEngine.getInstance(getContext()).getCurrentBusinessConfig(iMMessage.getSidType(), iMMessage.getBusinessId()).isShowPeerAvatar()) {
            if (TextUtils.isEmpty(iMMessage.getHeadUrl())) {
                m9288a(iMRoundedImageView, iMMessage.getSenderUid());
            } else {
                BtsImageLoader.getInstance().loadInto(iMMessage.getHeadUrl(), iMRoundedImageView);
            }
        }
        if (!m9292b(iMMessage)) {
            return inflate;
        }
        m9280a(iMMessage.getSid());
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
                if (IMFloatMessageCard.this.f10664g != null) {
                    IMFloatMessageCard.this.f10664g.requestCancelDismissTask();
                }
                IMFloatMessageCard.this.m9294c();
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_qkrply_ck", iMMessage);
            }
        });
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        final NotificationAdapter notificationAdapter = new NotificationAdapter(getContext(), IMContextInfoHelper.getQuickReplyList(iMMessage.getBusinessId()));
        notificationAdapter.setOnItemClickListener(new NotificationAdapter.MyItemClickListener() {
            public void onItemClick(final NotificationAdapter.ViewHolder viewHolder, String str) {
                IMFloatMessageCard.this.m9287a(iMMessage, str);
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        notificationAdapter.showHasSend(viewHolder);
                    }
                }, 200);
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        IMFloatMessageCard.this.m9279a(0);
                    }
                }, 1000);
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_qkmsg_ck", iMMessage);
            }
        });
        recyclerView.setAdapter(notificationAdapter);
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.im_notify_list_footer, recyclerView, false);
        inflate2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_other_ck", iMMessage);
                IMFloatMessageCard.this.m9286a(iMMessage, 1);
            }
        });
        inflate.findViewById(R.id.reply_float_cover).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaUtil.trackFloatWindowOmega("ddim_fc_all_mencng_ck", iMMessage);
                IMFloatMessageCard.this.m9279a(0);
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

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9279a(int i) {
        IIMDecorFloatMsg.RequestCallback requestCallback = this.f10664g;
        if (requestCallback != null) {
            requestCallback.requestDismiss(i);
            this.f10669p = null;
        }
        m9289b();
    }

    public void onFloatViewRemoved(int i) {
        this.f10669p = null;
        m9289b();
        long j = this.f10666i;
        if (j > 0) {
            m9290b(j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9286a(IMMessage iMMessage, int i) {
        m9279a(2);
        String dispatchMessageActionUrl = Parser.getDispatchMessageActionUrl(iMMessage);
        if (!TextUtils.isEmpty(dispatchMessageActionUrl)) {
            String str = f10654a;
            IMLog.m10020d(str, "IM Push Log Open Uri:" + dispatchMessageActionUrl);
            IMCommonUtil.startUriActivity(getContext(), dispatchMessageActionUrl, (Object) null);
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
        IMEngine.startIMActivityWithNewTaskFlag(getContext(), iMBusinessParam, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9287a(IMMessage iMMessage, String str) {
        if (iMMessage != null) {
            this.f10668o = iMMessage.nickName;
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
            IMLog.m10021e(f10654a, "send message failed since messageModel is null");
        }
    }

    /* renamed from: a */
    private void m9280a(long j) {
        this.f10666i = j;
        this.f10665h = new IMMessageCallback() {
            public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
            }

            public void onReadStatusChange(List<IMMessage> list, boolean z) {
            }

            public void onReceive(List<IMMessage> list) {
            }

            public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                IMFloatMessageCard.this.m9290b(iMMessage.getSid());
                if (i == 202) {
                    iMMessage.setPushText(String.format(IMFloatMessageCard.this.getContext().getString(R.string.im_float_widow_send_failed_content), new Object[]{IMFloatMessageCard.this.f10668o}));
                    iMMessage.showFailedMsg = true;
                    IMDecorFloatController.getInstance().add(iMMessage);
                }
            }
        };
        if (IMManager.getInstance().getMessageModel() != null) {
            IMManager.getInstance().getMessageModel().registerMessageCallback(this.f10665h, j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9290b(long j) {
        if (IMManager.getInstance().getMessageModel() != null) {
            IMManager.getInstance().getMessageModel().unregisterMessageCallback(j);
        }
    }

    /* renamed from: a */
    private void m9288a(IMRoundedImageView iMRoundedImageView, long j) {
        IMUser userInfoFromCache;
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userModel != null && (userInfoFromCache = userModel.getUserInfoFromCache(j)) != null && !TextUtils.isEmpty(userInfoFromCache.getAvatarUrl())) {
            BtsImageLoader.getInstance().loadInto(userInfoFromCache.getAvatarUrl(), iMRoundedImageView);
        }
    }

    /* renamed from: b */
    private boolean m9292b(IMMessage iMMessage) {
        int businessId = iMMessage.getBusinessId();
        if (!IMEngine.getInstance(getContext()).getCurrentBusinessConfig(iMMessage.getSidType(), businessId).isFloatShowQuickButton()) {
            IMLog.m10021e(f10654a, "The Apollo key isQuickButtonShow is off");
            return false;
        } else if (iMMessage.getType() != 65536) {
            IMLog.m10021e(f10654a, "msg type not text");
            return false;
        } else if (IMContextInfoHelper.getQuickReplyList(businessId) != null) {
            return true;
        } else {
            IMLog.m10021e(f10654a, "quick reply list is null");
            return false;
        }
    }
}
