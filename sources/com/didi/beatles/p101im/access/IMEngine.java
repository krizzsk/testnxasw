package com.didi.beatles.p101im.access;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.IMGD;
import com.didi.beatles.p101im.access.callback.IMAccessSendMessageCallback;
import com.didi.beatles.p101im.access.core.IMMessageListener;
import com.didi.beatles.p101im.access.core.IMPushEngine;
import com.didi.beatles.p101im.access.core.IMSessionMessageListener;
import com.didi.beatles.p101im.access.core.IMStageFeedBack;
import com.didi.beatles.p101im.access.core.IMUnreadMsgLoadCallback;
import com.didi.beatles.p101im.access.msg.IMMessageFilter;
import com.didi.beatles.p101im.access.msg.IMMessageUpdate;
import com.didi.beatles.p101im.access.msg.IMMsg;
import com.didi.beatles.p101im.access.notify.IMFloatWindowController;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.access.utils.IMBuildConfig;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.activity.IMFeedMsgListActivity;
import com.didi.beatles.p101im.activity.IMMessageActivity;
import com.didi.beatles.p101im.activity.IMOverDueMessageListActivity;
import com.didi.beatles.p101im.activity.IMValidMessageListActivity;
import com.didi.beatles.p101im.api.entity.IMDetailBody;
import com.didi.beatles.p101im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p101im.api.entity.IMSessionExtendInfo;
import com.didi.beatles.p101im.api.url.IMApiUrl;
import com.didi.beatles.p101im.api.url.IMBaseUrl;
import com.didi.beatles.p101im.event.IMMessageColloectionUpdateEvent;
import com.didi.beatles.p101im.event.IMMessageDetailFinishEvent;
import com.didi.beatles.p101im.manager.IMBusinessManager;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.manager.IMSessionMessageListenerManager;
import com.didi.beatles.p101im.manager.IMStageFeedBackListerManager;
import com.didi.beatles.p101im.module.IIMMessageModule;
import com.didi.beatles.p101im.module.IIMSessionModule;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMMessageCallBackImp;
import com.didi.beatles.p101im.module.IMMessageCallback;
import com.didi.beatles.p101im.module.IMMessagesLoadCallback;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;
import com.didi.beatles.p101im.module.IMSessionUnreadInfoCallback;
import com.didi.beatles.p101im.module.IMSessionUnreadSysChatMsgCallback;
import com.didi.beatles.p101im.module.IMUsefulExpressionCallback;
import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.module.impl.IMCustomWordCallback;
import com.didi.beatles.p101im.module.impl.IMModelProvider;
import com.didi.beatles.p101im.net.IMThreadHelper;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMParseUtil;
import com.didi.sdk.apm.SystemUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.access.IMEngine */
public class IMEngine {

    /* renamed from: a */
    private static volatile IMEngine f10537a = null;

    /* renamed from: i */
    private static final String f10538i = "IMEngine";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f10539b;

    /* renamed from: c */
    private Map<String, IMBusinessConfig> f10540c = new HashMap();

    /* renamed from: d */
    private Map<String, IMBusinessConfigListener> f10541d = new HashMap();

    /* renamed from: e */
    private Map<String, Integer> f10542e = new HashMap();

    /* renamed from: f */
    private int f10543f = 0;

    /* renamed from: g */
    private IMBuildConfig f10544g;

    /* renamed from: h */
    private IMPushEngine f10545h = null;

    /* renamed from: com.didi.beatles.im.access.IMEngine$IMBusinessConfigListener */
    public interface IMBusinessConfigListener {
        void onNeedConfig();
    }

    public static String getIMDataVersion() {
        return IMGD.IM_DATA_VERSION;
    }

    private IMEngine(Context context) {
        this.f10539b = context;
        this.f10545h = new IMPushEngine();
    }

    public static IMEngine getInstance(Context context) {
        IMEngine iMEngine;
        if (f10537a != null) {
            return f10537a;
        }
        synchronized (IMEngine.class) {
            if (f10537a == null) {
                f10537a = new IMEngine(context);
            }
            iMEngine = f10537a;
        }
        return iMEngine;
    }

    public void initIMEngine(IMContext iMContext, IMAssister iMAssister) throws Exception {
        IMLog.m10024i(f10538i, "[im-sdk] Init IM sdk with Version:3.4.33.0.65");
        if (this.f10539b == null) {
            throw new Exception("please ensure context is not null while call @getInstance（）");
        } else if (iMAssister != null) {
            this.f10544g = new IMBuildConfig();
            IMBaseUrl iMUrlDelegate = iMContext.getIMUrlDelegate();
            if (iMUrlDelegate == null || iMUrlDelegate.getCommonHost(0) == null) {
                throw new Exception("IMUrlDelegate or Url can't be null! please check your IMContext implement");
            }
            IMApiUrl.setIMUrlDelegate(iMUrlDelegate);
            IMPushEngine iMPushEngine = this.f10545h;
            if (iMPushEngine != null) {
                iMPushEngine.initEngine(iMAssister);
            }
            m9208a(iMContext);
        } else {
            throw new Exception("mAssister cann't be null");
        }
    }

    /* renamed from: a */
    private void m9208a(final IMContext iMContext) {
        IMContextInfoHelper.inject(this.f10539b, iMContext);
        SystemUtils.startThread(new Thread(new Runnable() {
            public void run() {
                if (!IMManager.getInstance().initIM(IMEngine.this.f10539b, iMContext)) {
                }
            }
        }));
    }

    public boolean hasInit() {
        boolean isInit;
        synchronized (this) {
            isInit = IMManager.getInstance().isInit();
        }
        return isInit;
    }

    public void destroyIMEngine() {
        synchronized (this) {
            if (this.f10545h != null) {
                this.f10545h.destoryEngine();
            }
            IMManager.getInstance().destroyIM();
        }
    }

    public void registerIMResource(Map<String, Integer> map) {
        if (map == null || map.size() == 0) {
            IMLog.m10021e(f10538i, "registerIMResource a null map");
            return;
        }
        this.f10542e = map;
    }

    public void registerIMResource(String str, int i) {
        if (TextUtils.isEmpty(str) || i == 0) {
            IMLog.m10021e(f10538i, "registerIMResource failed while key = " + str + "  resourceId = " + i);
            return;
        }
        if (this.f10542e == null) {
            this.f10542e = new HashMap();
        }
        this.f10542e.put(str, Integer.valueOf(i));
    }

    public int getAppResouceId(String str) {
        Map<String, Integer> map = this.f10542e;
        if (map == null || !map.containsKey(str)) {
            return 0;
        }
        return this.f10542e.get(str).intValue();
    }

    public static void startChatListActivity(Context context) {
        startChatListActivity(context, 0);
    }

    public static void startChatListActivity(Context context, int i) {
        if (!getInstance(IMContextInfoHelper.getContext()).hasInit()) {
            IMLog.m10021e("IMPushEngine", "IM init failed!");
        } else if (i != 0 || !IMFeedMsgListActivity.useFeed()) {
            IMValidMessageListActivity.startActivity(context, i);
        } else {
            IMFeedMsgListActivity.startActivity(context);
        }
    }

    public static void startChatListActivityNewTask(Context context) {
        startChatListActivityNewTask(context, 0);
    }

    public static void startChatListActivityNewTask(Context context, int i) {
        if (!getInstance(IMContextInfoHelper.getContext()).hasInit()) {
            IMLog.m10021e("IMPushEngine", "IM init failed!");
        } else if (i != 0 || !IMFeedMsgListActivity.useFeed()) {
            IMValidMessageListActivity.startActivityWithNewTask(context, i);
        } else {
            IMFeedMsgListActivity.startActivityWithNewTask(context);
        }
    }

    public static void startOverdueChatListActivity(Context context) {
        startOverdueChatListActivity(context, 0);
    }

    public static void startOverdueChatListActivity(Context context, int i) {
        if (!getInstance(IMContextInfoHelper.getContext()).hasInit()) {
            IMLog.m10021e("IMPushEngine", "IM init failed!");
        } else if (i != 0 || !IMFeedMsgListActivity.useFeed()) {
            IMOverDueMessageListActivity.startActivity(context, i);
        } else {
            IMFeedMsgListActivity.startActivity(context);
        }
    }

    public static void startChatDetailActivity(Context context, IMBusinessParam iMBusinessParam, int i) {
        if (m9209a(iMBusinessParam)) {
            try {
                Intent intent = new Intent(context, IMMessageActivity.class);
                intent.putExtra(IMMessageActivity.EXTRA_TAG_BUSINESSS_PARAM, iMBusinessParam);
                intent.putExtra("source", i);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            } catch (Exception e) {
                IMLog.m10020d(f10538i, "startChatDetailActivity: " + e);
            }
        }
    }

    public static void startChatDetailActivity(Context context, IMBusinessParam iMBusinessParam) {
        if (m9209a(iMBusinessParam)) {
            try {
                Intent intent = new Intent(context, IMMessageActivity.class);
                intent.putExtra(IMMessageActivity.EXTRA_TAG_BUSINESSS_PARAM, iMBusinessParam);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            } catch (Exception e) {
                IMLog.m10020d(f10538i, "startChatDetailActivity: " + e);
            }
        }
    }

    public static void startIMActivityWithNewTaskFlag(Context context, IMBusinessParam iMBusinessParam, int i) {
        if (m9209a(iMBusinessParam)) {
            try {
                Intent intent = new Intent(context, IMMessageActivity.class);
                intent.putExtra(IMMessageActivity.EXTRA_TAG_BUSINESSS_PARAM, iMBusinessParam);
                intent.addFlags(268435456);
                intent.putExtra("source", i);
                context.startActivity(intent);
            } catch (Exception e) {
                IMLog.m10020d(f10538i, "startIMActivityWithNewTaskFlag: " + e);
            }
        }
    }

    public static void startIMActivityWithNewTaskFlag(Context context, IMBusinessParam iMBusinessParam) {
        if (m9209a(iMBusinessParam)) {
            try {
                Intent intent = new Intent(context, IMMessageActivity.class);
                intent.putExtra(IMMessageActivity.EXTRA_TAG_BUSINESSS_PARAM, iMBusinessParam);
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e) {
                IMLog.m10020d(f10538i, "startIMActivityWithNewTaskFlag: " + e);
            }
        }
    }

    /* renamed from: a */
    private static boolean m9209a(IMBusinessParam iMBusinessParam) {
        return iMBusinessParam != null && iMBusinessParam.getSessionId() > 0;
    }

    public static void finishChatDetailAcvitiy(long j) {
        EventBus.getDefault().post(new IMMessageDetailFinishEvent(j));
    }

    public static boolean isChatDetailAcvitiyTop(long j) {
        String topActivityNameAndProcessName = IMPushEngine.getTopActivityNameAndProcessName(IMContextInfoHelper.getContext());
        return !TextUtils.isEmpty(topActivityNameAndProcessName) && topActivityNameAndProcessName.contains(IMMessageActivity.class.getSimpleName()) && IMPushEngine.holdMessageSessionId == j;
    }

    public static void getAllUnreadMessageCount(IMSessionUnreadCallback iMSessionUnreadCallback) {
        IMManager.getInstance().getAllUnreadMessageCount(iMSessionUnreadCallback);
    }

    public static void getAllUnreadRedCount(IMSessionUnreadCallback iMSessionUnreadCallback) {
        IMManager.getInstance().getAllUnreadRedCount(iMSessionUnreadCallback);
    }

    public static void getUnreadMessageCount(long j, IMSessionUnreadCallback iMSessionUnreadCallback) {
        getUnreadMessageCount((List<Long>) Collections.singletonList(Long.valueOf(j)), iMSessionUnreadCallback);
    }

    public static void getUnreadSysChatMessageCount(List<Long> list, IMSessionUnreadSysChatMsgCallback iMSessionUnreadSysChatMsgCallback) {
        IMManager.getInstance().getUnreadSysChatMessageCount(list, iMSessionUnreadSysChatMsgCallback);
    }

    public static void getUnreadSysChatMessageCount(long j, IMSessionUnreadSysChatMsgCallback iMSessionUnreadSysChatMsgCallback) {
        getUnreadSysChatMessageCount((List<Long>) Collections.singletonList(Long.valueOf(j)), iMSessionUnreadSysChatMsgCallback);
    }

    public static void getUnreadMessageCount(List<Long> list, IMSessionUnreadCallback iMSessionUnreadCallback) {
        IMManager.getInstance().getUnreadMessageCount(list, iMSessionUnreadCallback);
    }

    public static void ackHasReadMsg(IMMessage iMMessage, IMSessionUnreadCallback iMSessionUnreadCallback) {
        if (iMMessage == null) {
            IMLog.m10021e("ackHasReadMsg input param empty", new Object[0]);
        } else {
            IMManager.getInstance().ackHasReadMessage(iMMessage.getSid(), Collections.singletonList(Long.valueOf(iMMessage.getMid())), iMSessionUnreadCallback);
        }
    }

    public void addMessageListener(IMMessageListener iMMessageListener) {
        IMManager.getInstance().addMessageListener(iMMessageListener);
    }

    public void removeMessageListener(IMMessageListener iMMessageListener) {
        IMManager.getInstance().removeMessageListener(iMMessageListener);
    }

    public static void addSessionMessageListener(IMSessionMessageListener iMSessionMessageListener) {
        IMSessionMessageListenerManager.getInstance().addMessageListener(iMSessionMessageListener);
    }

    public static void removeSessionMessageListener(IMSessionMessageListener iMSessionMessageListener) {
        IMSessionMessageListenerManager.getInstance().removeMessageListener(iMSessionMessageListener);
    }

    public static void addStageFeedBackListener(IMStageFeedBack.IMStageFeedBackListener iMStageFeedBackListener) {
        IMStageFeedBackListerManager.INSTANCE.addFeedBackListener(iMStageFeedBackListener);
    }

    public static void removeStageFeedBackListener(IMStageFeedBack.IMStageFeedBackListener iMStageFeedBackListener) {
        IMStageFeedBackListerManager.INSTANCE.removeMessageListener(iMStageFeedBackListener);
    }

    public static void registerBusinessConfigListener(Context context, int i, IMBusinessConfigListener iMBusinessConfigListener) {
        try {
            getInstance(context).f10541d.put(String.valueOf(i), iMBusinessConfigListener);
        } catch (Exception e) {
            IMTraceError.trackError("IMEngine#registerBusinessConfigListener", e);
        }
    }

    public static void registerBusinessConfig(Context context, int i, IMBusinessConfig iMBusinessConfig) {
        try {
            getInstance(context).f10540c.put(String.valueOf(i), iMBusinessConfig);
            IMStyleManager.loadStyle(i, iMBusinessConfig, iMBusinessConfig.getIMStyle());
        } catch (Exception e) {
            IMTraceError.trackError("IMEngine#registerBusinessConfig", e);
        }
    }

    public static void registerGroupBusinessConfig(Context context, int i, IMBusinessConfig iMBusinessConfig) {
        Map<String, IMBusinessConfig> map = getInstance(context).f10540c;
        map.put("group" + i, iMBusinessConfig);
    }

    public static void registerDriverSessionBusinessConfig(Context context, int i, IMBusinessConfig iMBusinessConfig) {
        Map<String, IMBusinessConfig> map = getInstance(context).f10540c;
        map.put("driver" + i, iMBusinessConfig);
    }

    public void unRegisterBusinessConfig(Context context, int i) {
        getInstance(context).f10540c.remove(Integer.valueOf(i));
    }

    public IMBusinessConfig getCurrentBusinessConfig(int i) {
        return getCurrentBusinessConfig(1, i);
    }

    public IMBusinessConfig getCurrentBusinessConfig(int i, int i2) {
        IMBusinessConfigListener iMBusinessConfigListener = this.f10541d.get(String.valueOf(i2));
        boolean z = true;
        if (iMBusinessConfigListener != null) {
            iMBusinessConfigListener.onNeedConfig();
            this.f10541d.remove(String.valueOf(i2));
            IMLog.m10024i(f10538i, "configListenerMap callback,businesid = " + i2);
        }
        IMBusinessConfig iMBusinessConfig = null;
        String str = "succeed";
        if (i == 16) {
            Map<String, IMBusinessConfig> map = this.f10540c;
            iMBusinessConfig = map.get("driver" + i2);
            StringBuilder sb = new StringBuilder();
            sb.append("get driver session config,businesid = ");
            sb.append(i2);
            if (iMBusinessConfig == null) {
                str = "failed";
            }
            sb.append(str);
            IMLog.m10020d(f10538i, sb.toString());
        } else if (i == 2) {
            Map<String, IMBusinessConfig> map2 = this.f10540c;
            iMBusinessConfig = map2.get("group" + i2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get group session config,businesid = ");
            sb2.append(i2);
            if (iMBusinessConfig == null) {
                str = "failed";
            }
            sb2.append(str);
            IMLog.m10020d(f10538i, sb2.toString());
        }
        if (iMBusinessConfig == null) {
            iMBusinessConfig = this.f10540c.get(String.valueOf(i2));
        }
        if (iMBusinessConfig == null) {
            IMLog.m10020d(f10538i, "get business from default " + i2);
            iMBusinessConfig = IMContextInfoHelper.getDefaultBusinessConfig();
        } else {
            z = false;
        }
        if (iMBusinessConfig == null) {
            IMLog.m10020d(f10538i, "get business config failed " + i2);
            iMBusinessConfig = new IMBusinessConfig(4065);
        }
        if (iMBusinessConfig.getIMStyle() == IMStyleManager.Style.UNDEFINED) {
            iMBusinessConfig.setIMStyle(IMContextInfoHelper.getStyle());
        }
        if (z) {
            IMStyleManager.loadStyle(i2, iMBusinessConfig, iMBusinessConfig.getIMStyle());
        }
        return iMBusinessConfig;
    }

    public static long generateSessionId(int i, long j) {
        return IMBusinessManager.generateSid(i, j);
    }

    public static long generateSessionId(int i, long j, boolean z) {
        return IMBusinessManager.generateSid(i, j, z);
    }

    public static void pullMessagesSync() {
        IMManager.getInstance().pullMessage(0, 0, 6);
    }

    public static void pullMessagesSync(int i) {
        IMManager.getInstance().pullMessage(i, 0, 6);
    }

    public static void closeSession(long j) {
        IMManager.getInstance().closeSession(j);
    }

    public static void sendMessageFormOutside(int i, int i2, int i3, String str, int i4, IMDetailBody iMDetailBody, int i5, IMBusinessParam iMBusinessParam, IMMessageCallback iMMessageCallback) {
        IMManager.getInstance().sendMessageFormOutside(i, i2, i3, str, i4, iMDetailBody, i5, iMBusinessParam, iMMessageCallback);
    }

    public static void sendTextMessage(IMBusinessParam iMBusinessParam, String str, IMAccessSendMessageCallback iMAccessSendMessageCallback) {
        sendTextMessage(iMBusinessParam, str, 0, iMAccessSendMessageCallback);
    }

    public static void sendTextMessage(IMBusinessParam iMBusinessParam, String str, int i, IMAccessSendMessageCallback iMAccessSendMessageCallback) {
        IMManager.getInstance().sendTextMessage(iMBusinessParam, str, i, iMAccessSendMessageCallback);
    }

    public static void forwardRobotMessage(IMBusinessParam iMBusinessParam, String str, IMAccessSendMessageCallback iMAccessSendMessageCallback) {
        IMManager.getInstance().forwardRobotMessage(iMBusinessParam, str, iMAccessSendMessageCallback);
    }

    public static void sendAudioMessage(IMBusinessParam iMBusinessParam, String str, int i, IMAccessSendMessageCallback iMAccessSendMessageCallback) {
        IMManager.getInstance().sendAudioMessage(iMBusinessParam, str, i, iMAccessSendMessageCallback);
    }

    public static void addCustomCommonWord(String str, final IMCustomWordCallback iMCustomWordCallback) {
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userModel == null) {
            IMLog.m10021e(f10538i, "addCustomCommonWord is failed due to IIMUserModule is null ! ");
        } else if (TextUtils.isEmpty(str)) {
            IMLog.m10021e(f10538i, "addCustomCommonWord is failed due to custom word is null ! ");
        } else {
            userModel.executeUsfulExpression(1, 4, str, new IMUsefulExpressionCallback() {
                public void onResponse(int i, String str) {
                    iMCustomWordCallback.onResponse(i, str, IMManager.getInstance().getCustomUsefulExpression());
                }
            });
        }
    }

    public static void getCustomCommonWord(final IMCustomWordCallback iMCustomWordCallback) {
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userModel == null) {
            IMLog.m10021e(f10538i, "getCustomCommonWord is failed due to IIMUserModule is null ! ");
            return;
        }
        userModel.executeUsfulExpression(3, 4, "", new IMUsefulExpressionCallback() {
            public void onResponse(int i, String str) {
                iMCustomWordCallback.onResponse(i, str, IMManager.getInstance().getCustomUsefulExpression());
            }
        });
    }

    public static void deleteCustomCommonWord(String str, final IMCustomWordCallback iMCustomWordCallback) {
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userModel == null) {
            IMLog.m10021e(f10538i, "deleteCustomCommonWord is failed due to IIMUserModule is null ! ");
        } else if (TextUtils.isEmpty(str)) {
            IMLog.m10021e(f10538i, "deleteCustomCommonWord is failed due to custom word is null ! ");
        } else {
            userModel.executeUsfulExpression(2, 4, str, new IMUsefulExpressionCallback() {
                public void onResponse(int i, String str) {
                    iMCustomWordCallback.onResponse(i, str, IMManager.getInstance().getCustomUsefulExpression());
                }
            });
        }
    }

    public static void editCustomCommonWord(String str, String str2, final IMCustomWordCallback iMCustomWordCallback) {
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userModel == null) {
            IMLog.m10021e(f10538i, "editCustomCommonWord is failed due to IIMUserModule is null ! ");
            return;
        }
        userModel.executeUsfulExpression(4, 4, str, str2, new IMUsefulExpressionCallback() {
            public void onResponse(int i, String str) {
                iMCustomWordCallback.onResponse(i, str, IMManager.getInstance().getCustomUsefulExpression());
            }
        });
    }

    public void updateIMUrlDelegate(IMBaseUrl iMBaseUrl) {
        IMLog.m10020d(f10538i, "updateIMUrlDelegate  apiUrl = " + iMBaseUrl);
        if (iMBaseUrl == null || iMBaseUrl.getCommonHost(0) == null) {
            IMLog.m10021e(f10538i, "updateIMUrlDelegate failed,IMBaseUrl can't be null");
            return;
        }
        String commonHost = iMBaseUrl.getCommonHost(0);
        IMBaseUrl iMUrlDelegate = IMApiUrl.getIMUrlDelegate();
        if (iMUrlDelegate == null || !TextUtils.equals(commonHost, iMUrlDelegate.getCommonHost(0))) {
            IMApiUrl.setIMUrlDelegate(iMBaseUrl);
            IIMMessageModule messageModule = IMModelProvider.getInstance().getMessageModule();
            if (messageModule == null) {
                IMLog.m10021e(f10538i, "updateIMUrlDelegate failed, MesageModule is null !");
                return;
            }
            messageModule.pullSingleMessageForUploadData(0, 0);
        }
    }

    @Deprecated
    public void notifyReceiveMsg() {
        IMSessionMessageListenerManager.getInstance().notifyListeners((Set<Long>) null);
    }

    public static void updateSessionMessages(Collection<IMMessageFilter> collection, final IMMessageUpdate iMMessageUpdate) {
        if (collection == null || collection.isEmpty() || iMMessageUpdate == null) {
            IMLog.m10019d("updateSessionMessages but param has empty");
        } else {
            IMManager.getInstance().queryMessage(collection, new IMMessageCallBackImp() {
                public void onReceive(final List<IMMessage> list) {
                    if (list == null || list.isEmpty()) {
                        IMLog.m10019d("updateSessionMessages query message is empty");
                    } else {
                        IMThreadHelper.getInstance().execute(new Runnable() {
                            public void run() {
                                final LinkedList linkedList = new LinkedList();
                                for (IMMessage iMMessage : list) {
                                    String updateContent = iMMessageUpdate.updateContent(new IMMessageFilter(iMMessage.getSid() + "", iMMessage.getMid() + "", iMMessage.getSenderUid() + ""), iMMessage.getContent());
                                    if (updateContent != null) {
                                        iMMessage.setContent(updateContent);
                                        linkedList.add(iMMessage);
                                    }
                                }
                                IMLog.m10019d("updateSessionMessages info query " + list.size() + " and update " + linkedList.size());
                                IMManager.getInstance().updateMessage(linkedList, new IMMessageCallBackImp() {
                                    public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                                        if (i == 501) {
                                            IMLog.m10019d("updateSessionMessages update message suc");
                                            EventBus.getDefault().post(new IMMessageColloectionUpdateEvent(linkedList));
                                        } else {
                                            IMLog.m10019d("updateSessionMessages update message fail");
                                        }
                                        iMMessageUpdate.onResult(i == 501);
                                    }
                                });
                            }
                        });
                    }
                }
            });
        }
    }

    public void updateSyncInfo() {
        IIMMessageModule messageModule = IMModelProvider.getInstance().getMessageModule();
        if (messageModule == null) {
            IMLog.m10021e(f10538i, "updateSyncInfo failed, MessageModule is null !");
            return;
        }
        messageModule.updateSyncInfo();
    }

    public static void getUnreadMsgInfo(final long j, final IMUnreadMsgLoadCallback iMUnreadMsgLoadCallback) {
        if (j > 0 && iMUnreadMsgLoadCallback != null) {
            if (!getInstance(IMContextInfoHelper.getContext()).hasInit()) {
                IMLog.m10021e(f10538i, "#getUnreadMsgInfo# IM init failed!");
                return;
            }
            IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
            if (sessionModel == null) {
                IMLog.m10021e(f10538i, "#getUnreadMsgInfo# is failed due to IIMSessionModule is null! ");
                return;
            }
            final IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
            if (messageModel == null) {
                IMLog.m10021e(f10538i, "#getUnreadMsgInfo# is failed due to IIMMessageModule is null! ");
                return;
            }
            sessionModel.getSessionUnreadInfo(j, new IMSessionUnreadInfoCallback() {
                public void onUnreadInfo(final int i, final int i2) {
                    messageModel.loadPeerHistoryMessage(j, 1, new IMMessagesLoadCallback() {
                        public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
                            List list2;
                            if (list == null || list.isEmpty()) {
                                list2 = null;
                            } else {
                                list2 = Arrays.asList(new IMMsg[]{new IMMsg(list.get(0))});
                            }
                            iMUnreadMsgLoadCallback.onIMMsgLoad(i, i2, list2);
                        }
                    });
                }
            });
        }
    }

    public static void enableImFloatWindow(boolean z) {
        IMFloatWindowController.setEnableFloatWindow(z);
    }

    public String getOrderIdBySession(String str) {
        IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
        if (sessionModel == null) {
            IMLog.m10021e("getOrderIdBySession sessionModule null", new Object[0]);
            return null;
        }
        long parseLong = IMParseUtil.parseLong(str);
        if (parseLong == 0) {
            IMLog.m10021e("getOrderIdBySession sessionId error " + str, new Object[0]);
            return null;
        }
        IMSession sessionFromLocal = sessionModel.getSessionFromLocal(parseLong);
        if (sessionFromLocal == null) {
            IMLog.m10021e("getOrderIdBySession session not found " + str, new Object[0]);
            return null;
        }
        IMSessionExtendInfo extendSessionInfo = sessionFromLocal.getExtendSessionInfo();
        if (extendSessionInfo != null) {
            return extendSessionInfo.orderId;
        }
        IMLog.m10021e("getOrderIdBySession session extendInfo is null " + str, new Object[0]);
        return null;
    }
}
