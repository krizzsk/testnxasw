package com.didi.beatles.p101im.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.core.IMStageFeedBack;
import com.didi.beatles.p101im.access.notify.NotificationUtils;
import com.didi.beatles.p101im.adapter.ChatAdapter;
import com.didi.beatles.p101im.common.IMLifecycleHandler;
import com.didi.beatles.p101im.common.IMPollingService;
import com.didi.beatles.p101im.event.IMSessionInfoUpdateErrorEvent;
import com.didi.beatles.p101im.event.IMSessionInfoUpdateEvent;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.manager.IMStageFeedBackListerManager;
import com.didi.beatles.p101im.module.IIMSessionModule;
import com.didi.beatles.p101im.module.IMSessionCallback;
import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.omega.OmegaUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMPollingUtils;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.IMToastHelper;
import com.didi.beatles.p101im.views.IMChoiceTitleBar;
import com.didi.beatles.p101im.views.titlebar.CommonTitleBar;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.beatles.im.activity.IMMessageListActivity */
public abstract class IMMessageListActivity extends IMBaseActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, IMSessionCallback {
    protected static final String EXTRA_SESSION = "sessin_type";
    protected static final int IM_HISTORY_TYPE = -1;
    public int CHOICE_MODE = 1;
    public int SELECT_MODE = 0;

    /* renamed from: a */
    ConnectionChangeReceiver f10809a;

    /* renamed from: b */
    private ChatAdapter f10810b;

    /* renamed from: c */
    private ListView f10811c;

    /* renamed from: d */
    private List<IMSession> f10812d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f10813e;

    /* renamed from: f */
    private ImageView f10814f;

    /* renamed from: g */
    private LinearLayout f10815g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f10816h;
    protected RelativeLayout headerInfoLayout;
    protected TextView headerInfoView;

    /* renamed from: i */
    private ProgressBar f10817i;
    protected boolean isValidList = false;

    /* renamed from: j */
    private IMChoiceTitleBar f10818j;

    /* renamed from: k */
    private HashMap<Integer, View> f10819k = new HashMap<>();

    /* renamed from: l */
    private int f10820l;
    public IMLifecycleHandler.Controller mController;
    protected int mNeedSessionType;
    protected IIMSessionModule mSessionModule;
    protected TextView noMessageWording;
    protected CommonTitleBar titleBar;

    public List<IMSession> addFootView(List<IMSession> list) {
        return list;
    }

    /* access modifiers changed from: protected */
    public String getNoMsgWording() {
        return "";
    }

    public void handleEmptyCheckOverDueView(View view) {
    }

    public void handleHeaderInfoView() {
    }

    /* access modifiers changed from: protected */
    public void initTitle() {
    }

    /* access modifiers changed from: protected */
    public void loadSessionAsync() {
    }

    /* access modifiers changed from: protected */
    public abstract void parseIntent();

    public List<IMSession> removeFootView(List<IMSession> list) {
        return list;
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.bts_im_fragment_chat);
        parseIntent();
        m9459a();
        this.mController = IMLifecycleHandler.attach(this);
        m9466c();
        m9472g();
        m9463b();
        m9471f();
        EventBus.getDefault().register(this);
        NotificationUtils.cancelNotification();
    }

    /* renamed from: a */
    private void m9459a() {
        this.f10817i = (ProgressBar) findViewById(R.id.progress_bar);
        View findViewById = findViewById(R.id.layout_no_chat);
        this.f10813e = findViewById;
        this.noMessageWording = (TextView) findViewById.findViewById(R.id.tv_im_no_chat_tip1);
        this.f10815g = (LinearLayout) this.f10813e.findViewById(R.id.im_no_msg_ll);
        ImageView imageView = (ImageView) this.f10813e.findViewById(R.id.tv_im_no_chat_tip);
        this.f10814f = imageView;
        imageView.setImageResource(IMResource.getDrawableID(R.drawable.im_no_msg_bg));
        this.f10816h = (TextView) findViewById(R.id.layout_no_network);
        this.headerInfoView = (TextView) findViewById(R.id.im_msg_list_header_tv);
        this.headerInfoLayout = (RelativeLayout) findViewById(R.id.im_msg_list_header_layout);
        handleHeaderInfoView();
        this.f10816h.setText(getString(R.string.bts_im_no_network));
        this.f10811c = (ListView) findViewById(R.id.ContactListView);
    }

    /* renamed from: b */
    private void m9463b() {
        IMChoiceTitleBar iMChoiceTitleBar = (IMChoiceTitleBar) findViewById(R.id.im_choice_bar);
        this.f10818j = iMChoiceTitleBar;
        iMChoiceTitleBar.getLeftImgView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageListActivity.this.m9462a(false, true);
            }
        });
        this.f10818j.getRightTextView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageListActivity.this.m9473h();
            }
        });
    }

    /* renamed from: c */
    private void m9466c() {
        ChatAdapter chatAdapter = new ChatAdapter(this, new ChatAdapter.OnDataListener() {
            public void onDataChange(boolean z) {
                IMMessageListActivity.this.hideProgressBar();
                if (z) {
                    IMMessageListActivity.this.m9467d();
                    IMMessageListActivity iMMessageListActivity = IMMessageListActivity.this;
                    iMMessageListActivity.handleEmptyCheckOverDueView(iMMessageListActivity.f10813e);
                    return;
                }
                IMMessageListActivity.this.m9470e();
            }
        });
        this.f10810b = chatAdapter;
        this.f10811c.setAdapter(chatAdapter);
        this.f10811c.setOnItemClickListener(this);
        this.f10811c.setOnItemLongClickListener(this);
        m9474i();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9467d() {
        LinearLayout linearLayout = this.f10815g;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = this.noMessageWording;
        if (textView != null) {
            textView.setText(getNoMsgWording());
        }
        View view = this.f10813e;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m9470e() {
        View view = this.f10813e;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateEvent(IMSessionInfoUpdateEvent iMSessionInfoUpdateEvent) {
        if (iMSessionInfoUpdateEvent.imSessionList != null && iMSessionInfoUpdateEvent.imSessionList.size() > 0) {
            loadSessionAsync();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionInfoUpdateErrorEvent(IMSessionInfoUpdateErrorEvent iMSessionInfoUpdateErrorEvent) {
        if (iMSessionInfoUpdateErrorEvent.errorStatusCode == 111) {
            loadSessionAsync();
        }
    }

    /* renamed from: f */
    private void m9471f() {
        IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
        this.mSessionModule = sessionModel;
        if (sessionModel != null) {
            m9475j();
        }
    }

    /* renamed from: g */
    private void m9472g() {
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.im_title_bar);
        this.titleBar = commonTitleBar;
        commonTitleBar.initResource();
        initTitle();
        this.titleBar.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageListActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        super.onActivityDestroy();
        EventBus.getDefault().unregister(this);
        if (IMManager.getInstance().getUserModel() != null) {
            IMManager.getInstance().getUserModel().clearHolders();
        }
        m9476k();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IIMSessionModule iIMSessionModule = this.mSessionModule;
        if (iIMSessionModule != null) {
            iIMSessionModule.registerSessionCallback(this);
        }
        if (this.SELECT_MODE != 1) {
            loadSessionAsync();
        }
        IMManager.getInstance().pullMessage(0, 0, 2);
        IMPollingUtils.startPollingService(this, 60, IMPollingService.class, IMPollingService.ACTION);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        IIMSessionModule iIMSessionModule = this.mSessionModule;
        if (iIMSessionModule != null) {
            iIMSessionModule.unregisterSessionCallback(this);
        }
        IMManager.getInstance().clearIMRedDot();
        IMPollingUtils.stopPollingService(this, IMPollingService.class, IMPollingService.ACTION);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
        try {
            if (this.SELECT_MODE == this.CHOICE_MODE) {
                checkItemChoice(i, view);
                return;
            }
            IMSession iMSession = this.f10812d.get(i);
            if (iMSession != null) {
                IMStageFeedBack.OutFeedBackData outFeedBackData = new IMStageFeedBack.OutFeedBackData();
                outFeedBackData.setUid(Long.valueOf(iMSession.getPeerUid()));
                outFeedBackData.setSid(Long.valueOf(iMSession.getSessionId()));
                if (IMStageFeedBackListerManager.INSTANCE.notifyListeners(this, IMStageFeedBack.IMStage.IM_OLD_MESSAGE_LIST_ITEM_CLICK, outFeedBackData)) {
                    if (this.mSessionModule != null) {
                        this.mSessionModule.clearSessionsUnreadCount(new long[]{iMSession.getSessionId()});
                    }
                    IMLog.m10024i("intercept: IMStageFeedBack.IMStage.IM_OLD_MESSAGE_LIST_ITEM_CLICK", new Object[0]);
                    return;
                }
            }
            if (iMSession.getType() == -1) {
                m9462a(false, false);
                IMEngine.startOverdueChatListActivity(this);
                return;
            }
            OmegaUtil.trackMsgCenterOmega(iMSession.getType(), iMSession.getSessionId());
            if (iMSession != null) {
                IMBusinessParam iMBusinessParam = new IMBusinessParam();
                iMBusinessParam.setSessionId(iMSession.getSessionId());
                iMBusinessParam.setSelfUid(IMSession.getSelfId(iMSession.getUserIds()).longValue());
                iMBusinessParam.setPeerUid(IMSession.getPeerId(iMSession.getUserIds()).longValue());
                iMBusinessParam.setBusinessId(iMSession.getBusinessId());
                iMBusinessParam.setUserDraft(iMSession.getDraft());
                iMBusinessParam.setSessionType(iMSession.getType());
                iMBusinessParam.setSourceId(10);
                IMEngine.startChatDetailActivity(this, iMBusinessParam, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSessionOptionResult(List<IMSession> list, int i) {
        if (i == 3) {
            List<IMSession> list2 = this.f10812d;
            if (list2 != null) {
                list2.removeAll(list);
                this.f10810b.setData(this.f10812d);
            }
            List<IMSession> list3 = this.f10812d;
            if (list3 != null && list3.size() == 1) {
                List<IMSession> list4 = this.f10812d;
                if (list4.get(list4.size() - 1).getType() == -1) {
                    removeFootView(this.f10812d);
                }
            }
            ChatAdapter chatAdapter = this.f10810b;
            if (chatAdapter != null) {
                chatAdapter.setData(this.f10812d);
                return;
            }
            return;
        }
        IMToastHelper.showLongError((Context) this, getString(R.string.bts_im_delete_fail));
    }

    public void onSessionLoad(List<IMSession> list) {
        if (this.SELECT_MODE == this.CHOICE_MODE) {
            m9462a(false, true);
        }
        hideProgressBar();
        if (list != null) {
            IMLog.m10020d("", "IMMessageListActivity onSessionLoad:" + list.size());
        } else {
            IMLog.m10020d("", "IMMessageListActivity onSessionLoad null");
        }
        List<IMSession> list2 = this.f10812d;
        if (list2 != null) {
            list2.clear();
        }
        this.f10812d = list;
        if (!IMTextUtil.isEmpty((Collection<?>) list)) {
            Collections.sort(this.f10812d);
            IIMSessionModule iIMSessionModule = this.mSessionModule;
            if (iIMSessionModule == null || !iIMSessionModule.isHaveOverDueMessage(list.size())) {
                this.f10812d = removeFootView(this.f10812d);
            } else {
                this.f10812d = addFootView(this.f10812d);
            }
            this.f10810b.setData(this.f10812d);
            return;
        }
        List<IMSession> removeFootView = removeFootView(this.f10812d);
        this.f10812d = removeFootView;
        this.f10810b.setData(removeFootView);
    }

    public boolean isValidListUI() {
        return this.isValidList;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        IMSession item = this.f10810b.getItem(i);
        if (item != null && item.getType() == -1) {
            return true;
        }
        try {
            m9462a(true, true);
            if (this.SELECT_MODE == this.CHOICE_MODE) {
                checkItemChoice(i, view);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void checkItemChoice(int i, View view) {
        ChatAdapter.ContactViewHolder contactViewHolder = (ChatAdapter.ContactViewHolder) view.getTag();
        contactViewHolder.checkBox.toggle();
        if (contactViewHolder.checkBox.isChecked()) {
            this.f10810b.getIsSelected().put(Integer.valueOf(i), true);
            this.f10819k.put(Integer.valueOf(i), view);
            this.f10820l++;
        } else {
            this.f10810b.getIsSelected().put(Integer.valueOf(i), false);
            this.f10819k.remove(Integer.valueOf(i));
            this.f10820l--;
        }
        this.f10818j.setChoiceCount(this.f10820l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9462a(boolean z, boolean z2) {
        if (z) {
            this.SELECT_MODE = this.CHOICE_MODE;
            this.f10818j.setChoiceCount(0);
            this.f10810b.setChoiceMode(this.SELECT_MODE);
            this.titleBar.setVisibility(8);
            this.f10818j.showChoiceBar();
            this.f10812d = removeFootView(this.f10812d);
        } else {
            this.SELECT_MODE = 0;
            this.f10810b.setChoiceMode(0);
            this.titleBar.setVisibility(0);
            this.f10818j.hideChoiceBar();
            this.f10810b.getIsSelected().clear();
            this.f10820l = 0;
            if (!IMTextUtil.isEmpty((Collection<?>) this.f10812d) && z2) {
                IIMSessionModule iIMSessionModule = this.mSessionModule;
                if (iIMSessionModule == null || !iIMSessionModule.isHaveOverDueMessage(0)) {
                    this.f10812d = removeFootView(this.f10812d);
                } else {
                    this.f10812d = addFootView(this.f10812d);
                }
            }
        }
        handleHeaderInfoView();
        this.f10810b.setData(this.f10812d);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m9473h() {
        List<IMSession> list = this.f10812d;
        if (list != null && list.size() >= 0) {
            ArrayList arrayList = new ArrayList();
            if (this.f10810b.getIsSelected().size() > 0) {
                for (Integer next : this.f10810b.getIsSelected().keySet()) {
                    if (this.f10810b.isChecked(next.intValue())) {
                        if (next.intValue() <= this.f10812d.size()) {
                            try {
                                arrayList.add(this.f10812d.get(next.intValue()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.mSessionModule.deleteSession((List<IMSession>) arrayList);
                m9462a(false, true);
            }
        }
    }

    /* renamed from: i */
    private void m9474i() {
        this.f10817i.setVisibility(0);
    }

    public void hideProgressBar() {
        this.f10817i.setVisibility(8);
    }

    /* renamed from: j */
    private void m9475j() {
        IntentFilter intentFilter = new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        ConnectionChangeReceiver connectionChangeReceiver = new ConnectionChangeReceiver();
        this.f10809a = connectionChangeReceiver;
        try {
            registerReceiver(connectionChangeReceiver, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: k */
    private void m9476k() {
        ConnectionChangeReceiver connectionChangeReceiver = this.f10809a;
        if (connectionChangeReceiver != null) {
            try {
                unregisterReceiver(connectionChangeReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f10809a = null;
        }
    }

    /* renamed from: com.didi.beatles.im.activity.IMMessageListActivity$ConnectionChangeReceiver */
    public class ConnectionChangeReceiver extends BroadcastReceiver {
        public ConnectionChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null || !networkInfo.isConnected()) {
                    try {
                        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            IMMessageListActivity.this.f10816h.setVisibility(8);
                            return;
                        }
                    } catch (SecurityException e) {
                        IMLog.m10022e(e);
                    }
                    IMMessageListActivity.this.f10816h.setVisibility(0);
                    return;
                }
                IMMessageListActivity.this.f10816h.setVisibility(8);
            }
        }
    }
}
