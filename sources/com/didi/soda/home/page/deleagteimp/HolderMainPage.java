package com.didi.soda.home.page.deleagteimp;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.component.error.ErrorHandleComponent;
import com.didi.soda.customer.component.login.LoginLogicComponent;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.map.MapLazyLoader;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.page.CustomerMainPageDelegate;
import com.didi.soda.home.policy.HomePolicyHelper;
import com.didi.soda.home.topgun.manager.HomePolicyUpdateRepo;
import com.didi.soda.home.topgun.manager.RpcLazyLoader;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.taxis99.R;

public class HolderMainPage extends CustomerMainPageDelegate {

    /* renamed from: a */
    private static final String f45204a = "HolderMainPage";

    /* renamed from: b */
    private HomePolicyHelper f45205b;

    /* renamed from: c */
    private FrameLayout f45206c;

    /* renamed from: d */
    private Subscription f45207d = null;

    public HolderMainPage(CustomerMainPageDelegate.CustomerPageCallback customerPageCallback) {
        super(customerPageCallback);
    }

    public boolean onHandleBack() {
        return super.onHandleBack();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        this.f45206c = frameLayout;
        frameLayout.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7));
        this.f45206c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return this.f45206c;
    }

    public void onCreate(View view) {
        super.onCreate(view);
        m33544a();
        m33546b();
        getOwner().controller.addLifecycleListener(new HolderMainPageListener());
        MapLazyLoader.getLoader().loadMapNextIdle();
        RpcLazyLoader.getLoader().lazyRpc();
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new LoginLogicComponent(this.f45206c));
        addComponent(new ErrorHandleComponent(this.f45206c));
    }

    /* renamed from: a */
    private void m33544a() {
        this.f45205b = HomePolicyHelper.getInstance();
        this.f45207d = ((HomePolicyUpdateRepo) RepoFactory.getRepo(HomePolicyUpdateRepo.class)).subscribePolicyUpdateConfirmTime(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                HolderMainPage.this.m33545a((Long) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33545a(Long l) {
        HomePolicyHelper homePolicyHelper = this.f45205b;
        if (homePolicyHelper != null) {
            homePolicyHelper.savePolicyUpdateState();
        }
        Subscription subscription = this.f45207d;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    /* renamed from: b */
    private void m33546b() {
        HomeAddressEntity homeAddressEntity = (HomeAddressEntity) GsonUtil.fromJson(Uri.decode(getScopeContext().getBundle().getString("addressInfo")), HomeAddressEntity.class);
        if (homeAddressEntity != null && AddressUtil.checkAddressValid(homeAddressEntity.address)) {
            LogUtil.m32584d(f45204a, "updateAddress:" + homeAddressEntity.address);
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).setDeliveryAddress(homeAddressEntity.address, false, 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f45205b != null) {
            LogUtil.m32584d(f45204a, "mHomePolicyHelper-----resetPolicyConfig");
            this.f45205b.resetPolicyConfig();
        }
    }

    public void onPageChangeEnded() {
        super.onPageChangeEnded();
        HomePolicyHelper homePolicyHelper = this.f45205b;
        if (homePolicyHelper != null) {
            homePolicyHelper.updatePolicyConfig(GlobalContext.getPageInstrument().getDialogInstrument(), 2).needShowPolicyDialog();
        }
    }
}
