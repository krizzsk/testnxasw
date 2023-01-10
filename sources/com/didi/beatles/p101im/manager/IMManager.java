package com.didi.beatles.p101im.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.IMEnvironment;
import com.didi.beatles.p101im.access.IMContext;
import com.didi.beatles.p101im.access.briage.IMMessageReciver;
import com.didi.beatles.p101im.access.callback.IMAccessSendMessageCallback;
import com.didi.beatles.p101im.access.core.IMMessageListener;
import com.didi.beatles.p101im.access.msg.IMMessageFilter;
import com.didi.beatles.p101im.access.notify.NotificationUtils;
import com.didi.beatles.p101im.access.notify.decorfloat.IMDecorFloatController;
import com.didi.beatles.p101im.api.IMGetParamHelper;
import com.didi.beatles.p101im.api.entity.IMBaseResponse;
import com.didi.beatles.p101im.api.entity.IMDetailBody;
import com.didi.beatles.p101im.api.entity.IMMessageDown;
import com.didi.beatles.p101im.api.entity.IMNewstandResponse;
import com.didi.beatles.p101im.api.entity.IMPullMessageResponse;
import com.didi.beatles.p101im.api.url.IMApiUrl;
import com.didi.beatles.p101im.common.IMPollingService;
import com.didi.beatles.p101im.event.IMBackgroundSendMessage;
import com.didi.beatles.p101im.event.IMEventDispatcher;
import com.didi.beatles.p101im.module.IIMGlobalModule;
import com.didi.beatles.p101im.module.IIMMessageModule;
import com.didi.beatles.p101im.module.IIMSessionModule;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMMessageCallBackImp;
import com.didi.beatles.p101im.module.IMMessageCallback;
import com.didi.beatles.p101im.module.IMNewstandInfoCallback;
import com.didi.beatles.p101im.module.IMSendMessageCallback;
import com.didi.beatles.p101im.module.IMSessionCallback;
import com.didi.beatles.p101im.module.IMSessionCallbackAdapter;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;
import com.didi.beatles.p101im.module.IMSessionUnreadSysChatMsgCallback;
import com.didi.beatles.p101im.module.IMUsefulExpressionCallback;
import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.module.entity.IMSysChatUnreadCount;
import com.didi.beatles.p101im.module.impl.IMModelProvider;
import com.didi.beatles.p101im.net.IMHttpManager;
import com.didi.beatles.p101im.net.IMNetCallback;
import com.didi.beatles.p101im.net.IMThreadHelper;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.service.IMServiceProvider;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMPollingUtils;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import com.didi.beatles.p101im.views.bottombar.IMConversationBottomBar;
import com.didi.entrega.customer.app.constant.Const;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.beatles.im.manager.IMManager */
public class IMManager extends IMBaseManager {
    public static final int MAX_REINIT_COUNT = 5;
    public static final String TAG = "IMInit";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f11088a = false;
    public static IMManager mInstance;

    /* renamed from: b */
    private IMServiceProvider f11089b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMModelProvider f11090c;

    /* renamed from: d */
    private IMMessageReciver f11091d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f11092e = false;

    /* renamed from: f */
    private Application.ActivityLifecycleCallbacks f11093f;

    /* renamed from: g */
    private int f11094g = 0;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo47259a(String str) {
    }

    private IMManager() {
        m9639b();
    }

    public static IMManager getInstance() {
        if (mInstance == null) {
            synchronized (IMManager.class) {
                if (mInstance == null) {
                    mInstance = new IMManager();
                }
            }
        }
        return mInstance;
    }

    /* renamed from: b */
    private void m9639b() {
        this.f11093f = new Application.ActivityLifecycleCallbacks() {
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                IMActivityController.getInstance().addAcitivty(activity);
            }

            public void onActivityResumed(Activity activity) {
                Class<?> appMainClass = IMContextInfoHelper.getAppMainClass();
                if (activity != null && appMainClass != null) {
                    IMActivityController.getInstance().setTopActivity(activity);
                    IMLog.m10020d("im-sdk", "resume class = " + activity.getClass().getSimpleName() + "  mainclass  = " + appMainClass.getSimpleName());
                    if (activity.getClass().getSimpleName().equals(appMainClass.getSimpleName())) {
                        IMManager.this.reInitIM(1);
                        if (!IMManager.this.f11092e) {
                            return;
                        }
                        if (!IMManager.f11088a) {
                            boolean unused = IMManager.f11088a = true;
                            IMManager.this.pullMessage(0, 0, 7);
                            return;
                        }
                        IMManager.this.pullMessage(0, 0, 2);
                    }
                }
            }

            public void onActivityPaused(Activity activity) {
                IMActivityController.getInstance().setTopActivityNull(activity);
            }

            public void onActivityDestroyed(Activity activity) {
                IMActivityController.getInstance().removeActivity(activity);
            }
        };
    }

    public boolean initIM(Context context, IMContext iMContext) {
        synchronized (this) {
            IMLog.m10024i("IMInit", "[im-sdk] initIM ..." + this.f11092e);
            if (this.f11092e) {
                return true;
            }
            try {
                m9641d();
                this.f11089b = IMServiceProvider.getInstance().init();
                IMModelProvider instance = IMModelProvider.getInstance();
                this.f11090c = instance;
                instance.init(this.f11089b);
                this.f11092e = true;
                IMEnvironment.setInitStatus(true);
                m9640c();
                m9634a(context);
                return true;
            } catch (Exception e) {
                if (IMContextInfoHelper.isLogingNow()) {
                    IMTraceUtil.CodeErrorParam addErrno = IMTraceUtil.addCodeErrorEvent().addErrno(2);
                    addErrno.addErrMsg("init im failed, exception = " + e.getMessage()).addExtendMsg(IMTextUtil.getExceptionStack(e)).report();
                    IMLog.m10021e("IMInit", "[im-sdk] initIM failed" + e.toString());
                }
                return false;
            }
        }
    }

    /* renamed from: c */
    private void m9640c() {
        IMThreadHelper.getInstance().execute(new Runnable() {
            public void run() {
                try {
                    NotificationUtils.isNotificationEnabled(IMContextInfoHelper.getContext());
                } catch (Throwable th) {
                    IMLog.m10021e("IMInit", "[traceIMInitSuccess]", th);
                }
            }
        });
    }

    /* renamed from: d */
    private void m9641d() {
        Application application = (Application) IMContextInfoHelper.getContext().getApplicationContext();
        application.unregisterActivityLifecycleCallbacks(this.f11093f);
        application.registerActivityLifecycleCallbacks(this.f11093f);
    }

    /* renamed from: a */
    private void m9634a(Context context) {
        if (this.f11091d == null) {
            IMLog.m10020d("IMInit", "registerReceiver IMMessageReceiver");
            this.f11091d = new IMMessageReciver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IMEventDispatcher.IM_ACTION_LOCATION_RESPONSE);
            intentFilter.addAction(IMEventDispatcher.RECEIVE_NEW_MESSAGE_ACTION);
            LocalBroadcastManager.getInstance(context).registerReceiver(this.f11091d, intentFilter);
        }
    }

    public void reInitIM(final int i) {
        if (!this.f11092e) {
            if (IMContextInfoHelper.getContext() == null || IMContextInfoHelper.getInfoProvider() == null) {
                IMLog.m10021e("IMInit", "[reInitIM] ... Null IMContext");
            } else if (!IMContextInfoHelper.isLogingNow()) {
                IMLog.m10021e("IMInit", "[reInitIM] ... Need login.");
            } else {
                int i2 = this.f11094g;
                if (i2 > 5) {
                    IMLog.m10021e("IMInit", "[reInitIM] ... Retry too many times.");
                    return;
                }
                final int i3 = i2 + 1;
                this.f11094g = i3;
                new Thread(new Runnable() {
                    public void run() {
                        IMLog.m10024i("IMInit", "[im-sdk] [reInitIM] start initIM.");
                        IMTraceUtil.addBusinessEvent("im_re_init").add("from", Integer.valueOf(i)).add(Const.PageParams.COUNT, Integer.valueOf(i3)).add("result", Integer.valueOf(IMManager.this.initIM(IMContextInfoHelper.getContext(), IMContextInfoHelper.getInfoProvider()) ? 1 : 0)).report();
                    }
                }).start();
            }
        }
    }

    public void destroyIM() {
        IMLog.m10024i("IMInit", "[im-sdk] destroyIM");
        this.f11092e = false;
        IMEnvironment.setInitStatus(false);
        IMServiceProvider iMServiceProvider = this.f11089b;
        if (iMServiceProvider != null) {
            iMServiceProvider.destroy();
            this.f11089b = null;
        }
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null) {
            iMModelProvider.destroy();
            this.f11090c = null;
        }
        Context context = IMContextInfoHelper.getContext();
        if (!(this.f11091d == null || context == null)) {
            IMLog.m10020d("IMInit", "unregisterReceiver IMMessageReceiver");
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f11091d);
            IMMessageListenerManager.getInstance().clear();
            this.f11091d = null;
        }
        if (context != null) {
            ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f11093f);
        }
        IMContextInfoHelper.destory();
        IMCommonContextInfoHelper.destory();
        IMDecorFloatController.getInstance().destroy();
    }

    public boolean isInit() {
        return this.f11092e;
    }

    public void pullMessage(int i, long j, int i2) {
        if (!IMContextInfoHelper.isLogingNow()) {
            IMLog.m10021e("IMInit", "No loging while pull msg");
            return;
        }
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider == null || iMModelProvider.getMessageModule() == null) {
            IMLog.m10021e("IMInit", "provider or messageModule is null while pull msg");
            return;
        }
        this.f11090c.getMessageModule().pullSingleMessage(i, j, i2);
    }

    public void getUnreadMessageCount(long j, IMSessionUnreadCallback iMSessionUnreadCallback) {
        getUnreadMessageCount((List<Long>) Collections.singletonList(Long.valueOf(j)), iMSessionUnreadCallback);
    }

    public void getUnreadMessageCount(List<Long> list, IMSessionUnreadCallback iMSessionUnreadCallback) {
        if (IMContextInfoHelper.isLogingNow()) {
            IMModelProvider iMModelProvider = this.f11090c;
            if (iMModelProvider == null || iMModelProvider.getSessionModule() == null) {
                IMLog.m10021e("IMManager", "getAllUnreadMessageCount while mModelProvider is null!");
                return;
            }
            this.f11090c.getSessionModule().findSessionUnreadCount(list, iMSessionUnreadCallback);
            return;
        }
        IMLog.m10021e("IMManager", "getAllUnreadMessageCount failed because you not login!");
        if (iMSessionUnreadCallback != null) {
            iMSessionUnreadCallback.unReadCount(0);
        }
    }

    public void getUnreadSysChatMessageCount(List<Long> list, IMSessionUnreadSysChatMsgCallback iMSessionUnreadSysChatMsgCallback) {
        if (IMContextInfoHelper.isLogingNow()) {
            IMModelProvider iMModelProvider = this.f11090c;
            if (iMModelProvider == null || iMModelProvider.getSessionModule() == null) {
                IMLog.m10021e("IMManager", "getAllUnreadMessageCount while mModelProvider is null!");
                return;
            }
            this.f11090c.getSessionModule().findSessionUnreadCount(list, iMSessionUnreadSysChatMsgCallback);
            return;
        }
        IMLog.m10021e("IMManager", "getAllUnreadMessageCount failed because you not login!");
        if (iMSessionUnreadSysChatMsgCallback != null) {
            iMSessionUnreadSysChatMsgCallback.unreadSysChatMsg(new IMSysChatUnreadCount());
        }
    }

    public void ackHasReadMessage(long j, List<Long> list, IMSessionUnreadCallback iMSessionUnreadCallback) {
        if (list == null || list.isEmpty()) {
            IMLog.m10021e("IMManager", "ackHasReadMessage input param is empty");
            return;
        }
        IMModelProvider iMModelProvider = this.f11090c;
        IIMSessionModule sessionModule = iMModelProvider != null ? iMModelProvider.getSessionModule() : null;
        if (sessionModule == null) {
            IMLog.m10026w("[ackHasReadMessage] sessionModule can't get", new Object[0]);
            return;
        }
        final long j2 = j;
        final List<Long> list2 = list;
        final IIMSessionModule iIMSessionModule = sessionModule;
        final IMSessionUnreadCallback iMSessionUnreadCallback2 = iMSessionUnreadCallback;
        sessionModule.getSessionFromLocal(j, new IMSessionCallbackAdapter() {
            public void onSessionLoad(List<IMSession> list) {
                if (list == null || list.isEmpty()) {
                    IMLog.m10024i("[ackHasReadMessage] can't load session from local " + j2, new Object[0]);
                    return;
                }
                final IIMMessageModule messageModule = IMManager.this.f11090c != null ? IMManager.this.f11090c.getMessageModule() : null;
                if (messageModule == null) {
                    IMLog.m10024i("[ackHasReadMessage] messageModule can't get", new Object[0]);
                    return;
                }
                final IMSession iMSession = list.get(0);
                ArrayList arrayList = new ArrayList(list2.size());
                for (Long valueOf : list2) {
                    arrayList.add(new IMMessageFilter(String.valueOf(j2), String.valueOf(valueOf), String.valueOf(iMSession.getPeerUid())));
                }
                messageModule.queryMessage(arrayList, new IMMessageCallBackImp() {
                    public void onReceive(List<IMMessage> list) {
                        if (list == null || list.isEmpty()) {
                            IMLog.m10024i("[ackHasReadMessage] queryMessage is empty", new Object[0]);
                            return;
                        }
                        ArrayList arrayList = new ArrayList(1);
                        for (IMMessage next : list) {
                            if (!next.isRead()) {
                                arrayList.add(Long.valueOf(next.getMid()));
                            }
                        }
                        if (arrayList.isEmpty()) {
                            IMLog.m10024i("[ackHasReadMessage] unreadMsg is empty", new Object[0]);
                            return;
                        }
                        int max = Math.max(0, iMSession.getUnreadCount() - arrayList.size());
                        messageModule.pushMessageReadStatus(j2, arrayList);
                        iIMSessionModule.setUnreadCount(j2, max);
                        if (iMSessionUnreadCallback2 != null) {
                            iMSessionUnreadCallback2.unReadCount(max);
                        }
                    }
                });
            }
        });
    }

    public void deleteMessage(IMMessage iMMessage, IMMessageCallback iMMessageCallback) {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null && iMModelProvider.getMessageModule() != null) {
            this.f11090c.getMessageModule().deleteMessage(iMMessage, iMMessageCallback);
        }
    }

    public void updateMessage(IMMessage iMMessage) {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null && iMModelProvider.getMessageModule() != null) {
            this.f11090c.getMessageModule().updateMessageAsync(iMMessage);
        }
    }

    public void updateMessage(Collection<IMMessage> collection, IMMessageCallback iMMessageCallback) {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null && iMModelProvider.getMessageModule() != null) {
            this.f11090c.getMessageModule().updateMessage(collection, iMMessageCallback);
        }
    }

    public void queryMessage(Collection<IMMessageFilter> collection, IMMessageCallback iMMessageCallback) {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null && iMModelProvider.getMessageModule() != null) {
            this.f11090c.getMessageModule().queryMessage(collection, iMMessageCallback);
        }
    }

    public void updateSession(IMMessage iMMessage) {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null && iMModelProvider.getSessionModule() != null) {
            this.f11090c.getSessionModule().updateLastMessageSync(iMMessage);
        }
    }

    public IIMSessionModule getSessionModel() {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null) {
            return iMModelProvider.getSessionModule();
        }
        return null;
    }

    public IIMMessageModule getMessageModel() {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null) {
            return iMModelProvider.getMessageModule();
        }
        return null;
    }

    public IIMUserModule getUserModel() {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null) {
            return iMModelProvider.getUserModule();
        }
        return null;
    }

    public IIMGlobalModule getGlobalModel() {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null) {
            return iMModelProvider.getGlobalModule();
        }
        return null;
    }

    public void getAllUnreadMessageCount(IMSessionUnreadCallback iMSessionUnreadCallback) {
        if (IMContextInfoHelper.isLogingNow()) {
            IMModelProvider iMModelProvider = this.f11090c;
            if (iMModelProvider == null || iMModelProvider.getSessionModule() == null) {
                IMLog.m10021e("IMManager", "getAllUnreadMessageCount while mModelProvider is null!");
                return;
            }
            this.f11090c.getSessionModule().getInvalidSessionUnreadCount(iMSessionUnreadCallback);
            return;
        }
        IMLog.m10021e("IMManager", "getAllUnreadMessageCount failed because you not login!");
        if (iMSessionUnreadCallback != null) {
            iMSessionUnreadCallback.unReadCount(0);
        }
    }

    public void getAllUnreadRedCount(IMSessionUnreadCallback iMSessionUnreadCallback) {
        if (IMContextInfoHelper.isLogingNow()) {
            IMModelProvider iMModelProvider = this.f11090c;
            if (iMModelProvider == null || iMModelProvider.getSessionModule() == null) {
                IMLog.m10021e("IMManager", "getAllUnreadRedCount while mModelProvider is null!");
                return;
            }
            this.f11090c.getSessionModule().getAllRedDotCount(iMSessionUnreadCallback);
            return;
        }
        IMLog.m10021e("IMManager", "getAllUnreadRedCount failed because you not login!");
        if (iMSessionUnreadCallback != null) {
            iMSessionUnreadCallback.unReadCount(0);
        }
    }

    public void startPollService() {
        IMPollingUtils.startPollingService(IMContextInfoHelper.getContext(), 60, IMPollingService.class, IMPollingService.ACTION);
    }

    public void stopPollService() {
        IMPollingUtils.stopPollingService(IMContextInfoHelper.getContext(), IMPollingService.class, IMPollingService.ACTION);
    }

    public void closeSession(long j) {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null && iMModelProvider.getSessionModule() != null) {
            String simpleName = IMConversationBottomBar.class.getSimpleName();
            IMLog.m10020d(simpleName, "close mSession " + j);
            IIMSessionModule sessionModule = this.f11090c.getSessionModule();
            if (sessionModule != null) {
                sessionModule.closeSession(j);
            }
        }
    }

    public void insertMessagesFromClient(final String str) {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null && iMModelProvider.getMessageModule() != null) {
            IMThreadHelper.getInstance().execute(new Runnable() {
                public void run() {
                    IMPullMessageResponse.GroupEntity groupEntity = (IMPullMessageResponse.GroupEntity) IMJsonUtil.objectFromJson(str, IMPullMessageResponse.GroupEntity.class);
                    if (groupEntity == null || groupEntity.msgs == null || groupEntity.msgs.size() == 0) {
                        IMLog.m10021e("insertMessagesFromClient failed, messages can't be null!", new Object[0]);
                    } else {
                        IMManager.this.insertMessagesFromClient(groupEntity.msgs);
                    }
                }
            });
        }
    }

    public void addMessageListener(IMMessageListener iMMessageListener) {
        IMMessageListenerManager.getInstance().addMessageListener(iMMessageListener);
    }

    public void removeMessageListener(IMMessageListener iMMessageListener) {
        IMMessageListenerManager.getInstance().removeMessageListener(iMMessageListener);
    }

    public void sendTextMessage(IMBusinessParam iMBusinessParam, String str, int i, IMAccessSendMessageCallback iMAccessSendMessageCallback) {
        IMAccessSendMessageCallback iMAccessSendMessageCallback2 = iMAccessSendMessageCallback;
        IMLog.m10020d("IMInit", C4786I.m9980t("[sendTextMessage] content=", str));
        if (iMBusinessParam == null || TextUtils.isEmpty(str)) {
            if (iMAccessSendMessageCallback2 != null) {
                iMAccessSendMessageCallback2.onSendStatusChanged(-2, str, (String) null);
            }
            IMLog.m10021e("IMInit", "[sendTextMessage] #invalid params#");
            return;
        }
        IIMSessionModule sessionModel = getInstance().getSessionModel();
        if (sessionModel != null) {
            final IMAccessSendMessageCallback iMAccessSendMessageCallback3 = iMAccessSendMessageCallback;
            final String str2 = str;
            final IMBusinessParam iMBusinessParam2 = iMBusinessParam;
            final int i2 = i;
            sessionModel.syncSessionStatus(-1, -1, iMBusinessParam, IMSession.structureSession(iMBusinessParam), new IMSessionCallback() {
                public void onSessionStatusUpdate(List<IMSession> list) {
                }

                public void onSessionOptionResult(List<IMSession> list, int i) {
                    IMLog.m10020d("IMInit", C4786I.m9980t("[sendTextMessage] #onSessionOptionResult# status=", Integer.valueOf(i)));
                    IMAccessSendMessageCallback iMAccessSendMessageCallback = iMAccessSendMessageCallback3;
                    if (iMAccessSendMessageCallback != null) {
                        iMAccessSendMessageCallback.onSendStatusChanged(-3, str2, "onSessionOptionResult");
                    }
                }

                public void onSessionLoad(List<IMSession> list) {
                    IMLog.m10020d("IMInit", C4786I.m9980t("[sendTextMessage] #onSessionLoad#"));
                    if (list == null || list.size() <= 0 || list.get(0).getSessionId() != iMBusinessParam2.getSessionId()) {
                        IMAccessSendMessageCallback iMAccessSendMessageCallback = iMAccessSendMessageCallback3;
                        if (iMAccessSendMessageCallback != null) {
                            iMAccessSendMessageCallback.onSendStatusChanged(-3, str2, "onSessionLoad#InvalidSession");
                            return;
                        }
                        return;
                    }
                    IMSession iMSession = list.get(0);
                    IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
                    if (messageModel != null) {
                        messageModel.sendTextMessage(str2, 65536, iMBusinessParam2, iMSession, (Object) null, i2, new IMSendMessageCallback() {
                            public void onSuccess(final IMMessage iMMessage) {
                                IMLog.m10020d("IMInit", C4786I.m9980t("[sendTextMessage] #onSessionLoad# -> #sendTextMessage# onSuccess"));
                                if (iMAccessSendMessageCallback3 != null) {
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            IMAccessSendMessageCallback iMAccessSendMessageCallback = iMAccessSendMessageCallback3;
                                            IMMessage iMMessage = iMMessage;
                                            iMAccessSendMessageCallback.onSendStatusChanged(0, iMMessage != null ? iMMessage.getContent() : str2, (String) null);
                                        }
                                    });
                                }
                            }

                            public void onError(String str, final int i, final String str2) {
                                IMLog.m10020d("IMInit", C4786I.m9980t("[sendTextMessage] #onSessionLoad# -> #sendTextMessage# onError  errNo=", Integer.valueOf(i), " |errMsg=", str2, " |msgContent=", str));
                                if (iMAccessSendMessageCallback3 != null) {
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            iMAccessSendMessageCallback3.onSendStatusChanged(i, str2, str2);
                                        }
                                    });
                                }
                            }
                        });
                        return;
                    }
                    IMAccessSendMessageCallback iMAccessSendMessageCallback2 = iMAccessSendMessageCallback3;
                    if (iMAccessSendMessageCallback2 != null) {
                        iMAccessSendMessageCallback2.onSendStatusChanged(-3, str2, "NullMessageModule");
                    }
                }
            });
        } else if (iMAccessSendMessageCallback2 != null) {
            iMAccessSendMessageCallback2.onSendStatusChanged(-3, str, "NullSessionModule");
        }
    }

    public void forwardRobotMessage(IMBusinessParam iMBusinessParam, String str, IMAccessSendMessageCallback iMAccessSendMessageCallback) {
        String str2 = str;
        final IMAccessSendMessageCallback iMAccessSendMessageCallback2 = iMAccessSendMessageCallback != null ? iMAccessSendMessageCallback : IMAccessSendMessageCallback.empty;
        IMLog.m10020d("IMInit", C4786I.m9980t("[forwardRobotMessage] content=", str2));
        if (iMBusinessParam == null || TextUtils.isEmpty(str)) {
            iMAccessSendMessageCallback2.onSendStatusChanged(-2, str, "ParamsEmpty");
            IMLog.m10021e("IMInit", "[forwardRobotMessage] #invalid params#");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("cont");
            String optString2 = jSONObject.optString("list_text");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                iMAccessSendMessageCallback2.onSendStatusChanged(-2, str, "ContentIncludeEmpty");
                IMLog.m10021e("IMInit", "[forwardRobotMessage] #content include empty#");
                return;
            }
            IIMSessionModule sessionModel = getInstance().getSessionModel();
            if (sessionModel != null) {
                final String str3 = str;
                final IMBusinessParam iMBusinessParam2 = iMBusinessParam;
                final String str4 = optString;
                final String str5 = optString2;
                sessionModel.syncSessionStatus(-1, -1, iMBusinessParam, IMSession.structureSession(iMBusinessParam), new IMSessionCallback() {
                    public void onSessionStatusUpdate(List<IMSession> list) {
                    }

                    public void onSessionOptionResult(List<IMSession> list, int i) {
                        IMLog.m10020d("IMInit", C4786I.m9980t("[sendTextMessage] #onSessionOptionResult# status=", Integer.valueOf(i)));
                        iMAccessSendMessageCallback2.onSendStatusChanged(-3, str3, "onSessionOptionResult");
                    }

                    public void onSessionLoad(List<IMSession> list) {
                        IMLog.m10020d("IMInit", C4786I.m9980t("[sendTextMessage] #onSessionLoad#"));
                        if (list == null || list.size() <= 0 || list.get(0).getSessionId() != iMBusinessParam2.getSessionId()) {
                            iMAccessSendMessageCallback2.onSendStatusChanged(-3, str3, "onSessionLoad#InvalidSession");
                            return;
                        }
                        IMSession iMSession = list.get(0);
                        IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
                        if (messageModel != null) {
                            EventBus.getDefault().post(new IMBackgroundSendMessage(messageModel.sendPluginMessage(3, str4, str5, 0, iMBusinessParam2, iMSession, new IMSendMessageCallback() {
                                public void onSuccess(final IMMessage iMMessage) {
                                    IMLog.m10020d("IMInit", C4786I.m9980t("[sendTextMessage] #onSessionLoad# -> #sendTextMessage# onSuccess"));
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            IMAccessSendMessageCallback iMAccessSendMessageCallback = iMAccessSendMessageCallback2;
                                            IMMessage iMMessage = iMMessage;
                                            iMAccessSendMessageCallback.onSendStatusChanged(0, iMMessage != null ? iMMessage.getContent() : str3, "success");
                                        }
                                    });
                                }

                                public void onError(String str, final int i, final String str2) {
                                    IMLog.m10020d("IMInit", C4786I.m9980t("[sendTextMessage] #onSessionLoad# -> #sendTextMessage# onError  errNo=", Integer.valueOf(i), " |errMsg=", str2, " |msgContent=", str));
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            iMAccessSendMessageCallback2.onSendStatusChanged(i, str3, str2);
                                        }
                                    });
                                }
                            })));
                            return;
                        }
                        iMAccessSendMessageCallback2.onSendStatusChanged(-3, str3, "NullMessageModule");
                    }
                });
                return;
            }
            iMAccessSendMessageCallback2.onSendStatusChanged(-3, str, "NullSessionModule");
        } catch (JSONException e) {
            iMAccessSendMessageCallback2.onSendStatusChanged(-2, str, "ContentParseError");
            IMLog.m10023e(e, "IMInit", "[forwardRobotMessage] #content json error#");
        }
    }

    public void sendAudioMessage(IMBusinessParam iMBusinessParam, String str, int i, IMAccessSendMessageCallback iMAccessSendMessageCallback) {
        if (iMAccessSendMessageCallback == null) {
            iMAccessSendMessageCallback = IMAccessSendMessageCallback.empty;
        }
        final IMAccessSendMessageCallback iMAccessSendMessageCallback2 = iMAccessSendMessageCallback;
        IMLog.m10020d("IMInit", C4786I.m9980t("[sendAudioMessage] file=", str, "time", Integer.valueOf(i)));
        if (iMBusinessParam == null || TextUtils.isEmpty(str) || i <= 0) {
            iMAccessSendMessageCallback2.onSendStatusChanged(-2, str, "ParamsEmpty");
            IMLog.m10021e("IMInit", "[sendAudioMessage] #invalid params#");
            return;
        }
        if (!new File(str).exists()) {
            iMAccessSendMessageCallback2.onSendStatusChanged(-2, str, "FileNotFound");
            IMLog.m10021e("IMInit", "[sendAudioMessage] #invalid params#");
        }
        IIMSessionModule sessionModel = getInstance().getSessionModel();
        if (sessionModel != null) {
            final String str2 = str;
            final IMBusinessParam iMBusinessParam2 = iMBusinessParam;
            final int i2 = i;
            sessionModel.syncSessionStatus(-1, -1, iMBusinessParam, IMSession.structureSession(iMBusinessParam), new IMSessionCallback() {
                public void onSessionStatusUpdate(List<IMSession> list) {
                }

                public void onSessionOptionResult(List<IMSession> list, int i) {
                    IMLog.m10020d("IMInit", C4786I.m9980t("[sendAudioMessage] #onSessionOptionResult# status=", Integer.valueOf(i)));
                    iMAccessSendMessageCallback2.onSendStatusChanged(-3, str2, "onSessionOptionResult");
                }

                public void onSessionLoad(List<IMSession> list) {
                    IMLog.m10020d("IMInit", C4786I.m9980t("[sendAudioMessage] #onSessionLoad#"));
                    if (list == null || list.size() <= 0 || list.get(0).getSessionId() != iMBusinessParam2.getSessionId()) {
                        iMAccessSendMessageCallback2.onSendStatusChanged(-3, str2, "onSessionLoad#InvalidSession");
                        return;
                    }
                    IMSession iMSession = list.get(0);
                    IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
                    if (messageModel != null) {
                        EventBus.getDefault().post(new IMBackgroundSendMessage(messageModel.sendAudioMessage(str2, i2, iMBusinessParam2, iMSession, new IMSendMessageCallback() {
                            public void onSuccess(final IMMessage iMMessage) {
                                IMLog.m10020d("IMInit", C4786I.m9980t("[sendAudioMessage] #onSessionLoad# -> #sendAudioMessage# onSuccess"));
                                UiThreadHandler.post(new Runnable() {
                                    public void run() {
                                        IMAccessSendMessageCallback iMAccessSendMessageCallback = iMAccessSendMessageCallback2;
                                        IMMessage iMMessage = iMMessage;
                                        iMAccessSendMessageCallback.onSendStatusChanged(0, iMMessage != null ? iMMessage.getContent() : str2, "success");
                                    }
                                });
                            }

                            public void onError(String str, final int i, final String str2) {
                                IMLog.m10020d("IMInit", C4786I.m9980t("[sendAudioMessage] #onSessionLoad# -> #sendAudioMessage# onError  errNo=", Integer.valueOf(i), " |errMsg=", str2, " |msgContent=", str));
                                UiThreadHandler.post(new Runnable() {
                                    public void run() {
                                        iMAccessSendMessageCallback2.onSendStatusChanged(i, str2, str2);
                                    }
                                });
                            }
                        })));
                        return;
                    }
                    iMAccessSendMessageCallback2.onSendStatusChanged(-3, str2, "NullMessageModule");
                }
            });
            return;
        }
        iMAccessSendMessageCallback2.onSendStatusChanged(-3, str, "NullSessionModule");
    }

    public void insertMessagesFromClient(List<IMMessageDown> list) {
        if (list == null || list.size() == 0) {
            IMLog.m10021e("insertMessagesFromClient failed, messages can't be null!", new Object[0]);
            return;
        }
        IMLog.m10020d("IMManager", "insertMessagesFromClient, msg size = " + list.size());
        try {
            if (this.f11090c != null && this.f11090c.getMessageModule() != null) {
                this.f11090c.getMessageModule().insertMessagesFromClient(list);
            }
        } catch (Exception e) {
            IMTraceError.trackError("IMManager#insertMessagesFromClient", e);
        }
    }

    public List<String> getCustomUsefulExpression() {
        try {
            JSONArray optJSONArray = new JSONObject(IMPreference.getInstance(IMContextInfoHelper.getContext()).getStringValue(IMPreference.USER_CUSTOM_USEFUL_EXPRESSION, "")).optJSONArray("info");
            if (optJSONArray == null) {
                IMLog.m10024i("IMInit", "[getCustomUsefulExpression] null info");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optJSONObject(i).optString("txt"));
            }
            return arrayList;
        } catch (JSONException e) {
            IMLog.m10021e("IMInit", "[getCustomUsefulExpression] #JSONException#");
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    private void m9642e() {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null && iMModelProvider.getUserModule() != null) {
            this.f11090c.getUserModule().executeUsfulExpression(3, -1, (String) null, (IMUsefulExpressionCallback) null);
        }
    }

    public void sendMessageFormOutside(int i, int i2, int i3, String str, int i4, IMDetailBody iMDetailBody, int i5, IMBusinessParam iMBusinessParam, IMMessageCallback iMMessageCallback) {
        IMModelProvider iMModelProvider = this.f11090c;
        if (iMModelProvider != null && iMModelProvider.getMessageModule() != null) {
            this.f11090c.getMessageModule().extendSendMessage(i, i2, i3, str, i4, iMDetailBody, i5, iMBusinessParam, iMMessageCallback);
        }
    }

    public boolean isIMHaveRedDot() {
        if (IMContextInfoHelper.getContext() == null || !IMContextInfoHelper.isLogingNow()) {
            return false;
        }
        return IMPreference.getInstance(IMContextInfoHelper.getContext()).isHaveRedDot();
    }

    public void clearIMRedDot() {
        if (IMContextInfoHelper.getContext() != null) {
            IMPreference.getInstance(IMContextInfoHelper.getContext()).setIsHaveRedDot(false);
        }
    }

    public void getNewstandInfo(final long j, final IMNewstandInfoCallback iMNewstandInfoCallback) {
        IMHttpManager instance = IMHttpManager.getInstance();
        instance.performCommonGet(IMApiUrl.getProfileHost() + IMApiUrl.IM_PROFILE_PATH + j, new IMNetCallback<IMNewstandResponse>() {
            public void failure(IOException iOException) {
            }

            public void success(final IMNewstandResponse iMNewstandResponse) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (iMNewstandInfoCallback != null) {
                            iMNewstandInfoCallback.onNewstandInfoLoaded(j, iMNewstandResponse);
                        }
                    }
                });
            }
        });
    }

    public void reportUserAction(int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", Long.valueOf(IMContextInfoHelper.getUid()));
        hashMap.put("appid", Long.valueOf(j));
        hashMap.put("token", IMContextInfoHelper.getToken());
        hashMap.put("optype", Integer.valueOf(i));
        IMHttpManager.getInstance().performCommonGet(IMApiUrl.getProfileHost() + IMApiUrl.IM_ACTION_REPORT_PATH + IMGetParamHelper.generateGetUrl(hashMap), new IMNetCallback<IMBaseResponse>() {
            public void failure(IOException iOException) {
            }

            public void success(IMBaseResponse iMBaseResponse) {
            }
        });
    }
}
