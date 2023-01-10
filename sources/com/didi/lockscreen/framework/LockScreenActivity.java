package com.didi.lockscreen.framework;

import android.app.Activity;
import android.app.KeyguardManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.lockscreen.LockScreenFragment;
import com.didi.lockscreen.view.LockScreenMapFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.map.MapFragment;
import com.taxis99.R;

public class LockScreenActivity extends FragmentActivity {

    /* renamed from: a */
    private LockScreenFragment f26647a;

    /* renamed from: b */
    private MapFragment f26648b;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f26649c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            LockScreenActivity.this.finish();
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<Object> f26650d = new BaseEventPublisher.OnEventListener<Object>() {
        public void onEvent(String str, Object obj) {
            LockScreenActivity.this.finish();
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Window window = getWindow();
        window.setFlags(1024, 1024);
        window.addFlags(6815872);
        setContentView((int) R.layout.global_activity_lock_screen);
        View findViewById = findViewById(R.id.rfl_global_lockscreen_container);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        marginLayoutParams.topMargin = UiUtils.getScreenHeight((Activity) this) / 5;
        findViewById.setLayoutParams(marginLayoutParams);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        this.f26648b = (LockScreenMapFragment) getSupportFragmentManager().findFragmentById(R.id.lockscreen_map_fragment);
        this.f26647a = LockScreenFragment.getInstance(marginLayoutParams.topMargin);
        BusinessContext businessContext = FormStore.getInstance().getBusinessContext();
        if (businessContext != null) {
            businessContext.setLockScreenMapFlowView(this.f26648b.getmMapFlowView());
            this.f26647a.setBusinessContext(businessContext);
        } else {
            GLog.m11356e("Lock Screen BusinessContext is null");
        }
        beginTransaction.replace(R.id.lock_screen_fragment, this.f26647a);
        beginTransaction.commit();
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.LockScreen.EVENT_ACTIVITY_CLOSE, this.f26649c);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.LockScreen.EVENT_PANEL_CLICK, this.f26650d);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        LockScreenFragment lockScreenFragment = this.f26647a;
        if (lockScreenFragment != null) {
            return lockScreenFragment.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.LockScreen.EVENT_ACTIVITY_CLOSE, this.f26649c);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.LockScreen.EVENT_PANEL_CLICK, this.f26650d);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        LockScreenFragment lockScreenFragment;
        if (!((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode() || (lockScreenFragment = this.f26647a) == null || lockScreenFragment.getBusinessContext() == null) {
            finish();
        }
        super.onStart();
        m21138a();
    }

    /* renamed from: a */
    private void m21138a() {
        MapFragment mapFragment = this.f26648b;
        if (mapFragment != null) {
            mapFragment.startInitMap();
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        MapFragment mapFragment = this.f26648b;
        if (mapFragment != null) {
            mapFragment.onLowMemory();
        }
    }
}
