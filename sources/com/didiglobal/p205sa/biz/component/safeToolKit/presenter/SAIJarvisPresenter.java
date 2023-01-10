package com.didiglobal.p205sa.biz.component.safeToolKit.presenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.didi.bfflib.business.BffRequestUtil;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.p205sa.biz.component.safeToolKit.SAUpdateJarvisEvent;
import com.didiglobal.p205sa.biz.component.safeToolKit.view.SAIJarvisView;
import com.didiglobal.p205sa.biz.component.safeToolKit.view.SAJarvisShareFragment;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.presenter.SAIJarvisPresenter */
public abstract class SAIJarvisPresenter extends ComponentPresenterImpl<SAIJarvisView> {
    public static Object sGPageId;

    /* renamed from: a */
    String f53604a = BffConstants.AbilityID.ABILITY_JARVIS_STATUS;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f53605b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f53606c;

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<SAUpdateJarvisEvent> f53607d = new BaseEventPublisher.OnEventListener<SAUpdateJarvisEvent>() {
        public void onEvent(String str, SAUpdateJarvisEvent sAUpdateJarvisEvent) {
            if ("event_update_jarvis".equals(str) && sAUpdateJarvisEvent != null) {
                SAIJarvisPresenter.this.requestJarvisStatus(sAUpdateJarvisEvent.openManualRecord);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SAJarvisShareFragment f53608e;

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener f53609f = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                Activity activity = SAIJarvisPresenter.this.mComponentParams.getActivity();
                if (activity instanceof FragmentActivity) {
                    SAJarvisShareFragment unused = SAIJarvisPresenter.this.f53608e = SAJarvisShareFragment.newInstance();
                    SAIJarvisPresenter.this.f53608e.show(((FragmentActivity) activity).getSupportFragmentManager(), "jarvis_share_before_accepted");
                }
            }
        }
    };

    /* renamed from: g */
    private LoginListeners.LoginOutListener f53610g = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            ((SAIJarvisView) SAIJarvisPresenter.this.mView).closeSafePanel();
            ((SAIJarvisView) SAIJarvisPresenter.this.mView).setJarvisData((SfJarvisData) null);
            String unused = SAIJarvisPresenter.this.f53605b = "";
        }
    };

    /* renamed from: h */
    private BroadcastReceiver f53611h = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null) {
                action.hashCode();
                SAIJarvisPresenter.this.requestJarvisStatus();
            }
        }
    };

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<Boolean> f53612i = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                int unused = SAIJarvisPresenter.this.f53606c = 1;
            } else {
                int unused2 = SAIJarvisPresenter.this.f53606c = 0;
            }
            SAIJarvisPresenter.this.requestJarvisStatus();
        }
    };

    /* renamed from: j */
    private BffResponseListener<SfJarvisData> f53613j = new BffResponseListener<SfJarvisData>() {
        public void onFinish(SfJarvisData sfJarvisData) {
            super.onFinish(sfJarvisData);
            if (sfJarvisData == null || sfJarvisData.errno != 0) {
                ((SAIJarvisView) SAIJarvisPresenter.this.mView).setJarvisData((SfJarvisData) null);
                String unused = SAIJarvisPresenter.this.f53605b = "";
            } else if (SAIJarvisPresenter.this.f53605b != null && SAIJarvisPresenter.this.f53605b.equals(sfJarvisData.dataVer)) {
            } else {
                if (sfJarvisData.bubbles != null || sfJarvisData.banner != null || sfJarvisData.menus != null || sfJarvisData.timeline != null) {
                    ((SAIJarvisView) SAIJarvisPresenter.this.mView).setJarvisData(sfJarvisData);
                    String unused2 = SAIJarvisPresenter.this.f53605b = sfJarvisData.dataVer;
                }
            }
        }
    };
    protected ComponentParams mComponentParams;

    /* access modifiers changed from: protected */
    public abstract String getPage();

    public SAIJarvisPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        register();
    }

    /* access modifiers changed from: protected */
    public void register() {
        com.didi.component.core.event.BaseEventPublisher.getPublisher().subscribe("event_record_status_changed", this.f53612i);
        subscribe("event_Share_before_accepted", this.f53609f);
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
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.f53611h, intentFilter);
        OneLoginFacade.getFunction().addLoginOutListener(this.f53610g);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        com.didi.component.core.event.BaseEventPublisher.getPublisher().unsubscribe("event_record_status_changed", this.f53612i);
        LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.f53611h);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f53610g);
        unsubscribe("event_Share_before_accepted", this.f53609f);
    }

    public void requestJarvisStatus() {
        requestJarvisStatus(0);
    }

    public void requestJarvisStatus(int i) {
        sGPageId = OmegaSDK.getGlobalAttr("g_PageId");
        String page = getPage();
        HashMap hashMap = new HashMap();
        hashMap.put("is_oasis_driver", 0);
        hashMap.put("page", page);
        hashMap.put("data_version", "");
        hashMap.put("in_recording", Integer.valueOf(this.f53606c));
        hashMap.put("open_manual_record", Integer.valueOf(i));
        BffRequestUtil.request(this.mContext, this.f53604a, hashMap, this.f53613j);
    }

    public static String mockResponse(Context context) {
        try {
            InputStream open = context.getAssets().open("safetools.txt");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            return new String(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
        ((SAIJarvisView) this.mView).closeSafePanel();
        ((SAIJarvisView) this.mView).onRemove();
    }
}
