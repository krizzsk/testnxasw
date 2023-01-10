package com.didiglobal.p205sa.biz.component.safeToolKit.presenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.safeCenter.adapter.SfAdapter;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didiglobal.p205sa.biz.component.safeToolKit.SAUpdateJarvisEvent;
import com.didiglobal.p205sa.biz.component.safeToolKit.view.SAIJarvisViewV2;
import com.didiglobal.p205sa.biz.component.safeToolKit.view.SAJarvisShareFragment;
import java.util.HashMap;

/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.presenter.SAIJarvisPresenterV2 */
public abstract class SAIJarvisPresenterV2 extends ComponentPresenterImpl<SAIJarvisViewV2> {
    public static Object sGPageId;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f53614a = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f53615b;

    /* renamed from: c */
    private SfAdapter f53616c;

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<SAUpdateJarvisEvent> f53617d = new BaseEventPublisher.OnEventListener<SAUpdateJarvisEvent>() {
        public void onEvent(String str, SAUpdateJarvisEvent sAUpdateJarvisEvent) {
            if ("event_update_jarvis".equals(str) && sAUpdateJarvisEvent != null) {
                SAIJarvisPresenterV2.this.requestJarvisStatus(sAUpdateJarvisEvent.openManualRecord);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SAJarvisShareFragment f53618e;

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener f53619f = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                Activity activity = SAIJarvisPresenterV2.this.mComponentParams.getActivity();
                if (activity instanceof FragmentActivity) {
                    SAJarvisShareFragment unused = SAIJarvisPresenterV2.this.f53618e = SAJarvisShareFragment.newInstance();
                    SAIJarvisPresenterV2.this.f53618e.show(((FragmentActivity) activity).getSupportFragmentManager(), "jarvis_share_before_accepted");
                }
            }
        }
    };

    /* renamed from: g */
    private LoginListeners.LoginOutListener f53620g = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            ((SAIJarvisViewV2) SAIJarvisPresenterV2.this.mView).closeSafePanel();
            ((SAIJarvisViewV2) SAIJarvisPresenterV2.this.mView).setJarvisData((SfJarvisData) null);
            String unused = SAIJarvisPresenterV2.this.f53614a = "";
        }
    };

    /* renamed from: h */
    private BroadcastReceiver f53621h = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null) {
                action.hashCode();
                SAIJarvisPresenterV2.this.requestJarvisStatus();
            }
        }
    };

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<Boolean> f53622i = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                int unused = SAIJarvisPresenterV2.this.f53615b = 1;
            } else {
                int unused2 = SAIJarvisPresenterV2.this.f53615b = 0;
            }
            SAIJarvisPresenterV2.this.requestJarvisStatus();
        }
    };
    protected ComponentParams mComponentParams;

    /* access modifiers changed from: protected */
    public abstract String getPage();

    public SAIJarvisPresenterV2(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f53616c = new SfAdapter();
        GlobalSfManager.getInstance().setCurView(getPage(), ((SAIJarvisViewV2) this.mView).getViewOwner());
        register();
    }

    /* access modifiers changed from: protected */
    public void register() {
        com.didi.component.core.event.BaseEventPublisher.getPublisher().subscribe("event_record_status_changed", this.f53622i);
        subscribe("event_Share_before_accepted", this.f53619f);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("sf_emergency_assist_on");
        intentFilter.addAction("sf_emergency_assist_off");
        intentFilter.addAction("sf_share_success");
        intentFilter.addAction("sf_share_failed");
        intentFilter.addAction("sf_start_share");
        intentFilter.addAction("sf_add_contacts_fail");
        intentFilter.addAction("sf_add_contacts_success");
        intentFilter.addAction("sf_delete_contacts_fail");
        intentFilter.addAction("sf_delete_contacts_success");
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.f53621h, intentFilter);
        OneLoginFacade.getFunction().addLoginOutListener(this.f53620g);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        com.didi.component.core.event.BaseEventPublisher.getPublisher().unsubscribe("event_record_status_changed", this.f53622i);
        LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.f53621h);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f53620g);
        unsubscribe("event_Share_before_accepted", this.f53619f);
    }

    public void requestJarvisStatus() {
        requestJarvisStatus(0);
    }

    public void requestJarvisStatus(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", getPage());
        this.f53616c.refreshBubbleData(i, hashMap, (BffResponseListener) null);
    }

    public void onPageStop() {
        super.onPageStop();
    }

    public void onPageResume() {
        super.onPageResume();
        if (SuperAppBusinessManager.INSTANCE.isActivityResume() && SuperAppBusinessManager.INSTANCE.isSaRealShow()) {
            requestJarvisStatus();
        }
    }

    public void onPageHiddenChanged(boolean z) {
        super.onPageHiddenChanged(z);
        if (!z) {
            requestJarvisStatus();
        }
    }

    public void onPagePause() {
        super.onPagePause();
    }

    public void onRemove() {
        super.onRemove();
        unRegister();
        ((SAIJarvisViewV2) this.mView).closeSafePanel();
        ((SAIJarvisViewV2) this.mView).onRemove();
    }
}
