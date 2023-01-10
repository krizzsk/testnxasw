package com.didi.component.framework.template.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.merchant.MerchantActivityDeepLinkEvent;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.wallet.delegate.IWalletHomeDelegate;
import com.didi.payment.wallet.global.wallet.delegate.WalletHomeDelegate;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.home.BizEntranceFragment;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.util.EventKeys;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;
import global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@ServiceProvider(alias = "wallet", value = {Fragment.class})
public class WalletEntranceFragment extends BizEntranceFragment {

    /* renamed from: a */
    private IWalletHomeDelegate f15815a;

    /* renamed from: b */
    private BusinessContext f15816b;

    /* renamed from: c */
    private LoginListeners.LoginListener f15817c = new LoginListeners.LoginListener() {
        public void onCancel() {
        }

        public void onSuccess(Activity activity, String str) {
            WalletEntranceFragment.this.m13118b();
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<MerchantActivityDeepLinkEvent> f15818d = new BaseEventPublisher.OnEventListener<MerchantActivityDeepLinkEvent>() {
        public void onEvent(String str, MerchantActivityDeepLinkEvent merchantActivityDeepLinkEvent) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            if (merchantActivityDeepLinkEvent != null && WalletEntranceFragment.this.getActivity() != null) {
                GlobalMerchantUnifiedPayProcessor.INS.onHandleMerchantRequest(WalletEntranceFragment.this.getActivity(), merchantActivityDeepLinkEvent.getRequest());
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m13119c();
        this.f15815a = new WalletHomeDelegate(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f15816b = getBusinessContext();
        View onCreateView = this.f15815a.onCreateView(bundle);
        m13116a(onCreateView);
        m13115a();
        getBusinessContext().restoreTitleBar();
        getBusinessContext().showBizBar();
        return onCreateView;
    }

    /* renamed from: a */
    private void m13116a(View view) {
        View findViewById;
        BusinessContext businessContext = this.f15816b;
        int bizBarHeight = businessContext != null ? businessContext.getBizBarHeight() : 0;
        if (bizBarHeight != 0 && (findViewById = view.findViewById(R.id.fl_root_container)) != null) {
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + bizBarHeight);
        }
    }

    /* renamed from: a */
    private void m13115a() {
        EventBus.getDefault().register(this);
        OneLoginFacade.getFunction().addLoginListener(this.f15817c);
        BusinessContext businessContext = this.f15816b;
        if (businessContext != null) {
            businessContext.restoreTitleBar();
        }
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Service.DeepLink.EVENT_HAND_MERCHANT_DEEP_LINK, this.f15818d);
    }

    public void onBackToHome() {
        super.onBackToHome();
        BusinessContext businessContext = this.f15816b;
        if (businessContext != null) {
            businessContext.restoreTitleBar();
        }
    }

    public void onStart() {
        super.onStart();
        this.f15815a.onStart();
    }

    public void onResume() {
        super.onResume();
        this.f15815a.onResume();
    }

    public void onStop() {
        super.onStop();
        this.f15815a.onStop();
    }

    public void onLeaveHome() {
        super.onLeaveHome();
        BusinessContext businessContext = this.f15816b;
        if (businessContext != null) {
            businessContext.hideTitleBar();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        OneLoginFacade.getFunction().removeLoginListener(this.f15817c);
        this.f15815a.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.DeepLink.EVENT_HAND_MERCHANT_DEEP_LINK, this.f15818d);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSidebarAction(SidebarEvent sidebarEvent) {
        if (EventKeys.Sidebar.CLOSE_SIDEBAR.equalsIgnoreCase(sidebarEvent.type)) {
            m13119c();
        } else {
            EventKeys.Sidebar.OPEN_SIDEBAR.equalsIgnoreCase(sidebarEvent.type);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13118b() {
        this.f15815a.requestData();
    }

    /* renamed from: c */
    private void m13119c() {
        if (WalletApolloUtil.isNewPayMethodListEnable()) {
            GlobalOmegaUtils.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_home_v2");
        } else {
            GlobalOmegaUtils.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_home");
        }
    }
}
