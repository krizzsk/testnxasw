package com.didi.entrega.home.component.noservice;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.entrega.home.manager.HomeFeedRefreshRepo;
import com.didi.entrega.home.manager.HomeNoServiceRepo;
import com.didi.entrega.home.manager.HomeOtherOmegaHelper;

public class HomeNoServicePresenter extends IPresenter<HomeNoServiceView> {
    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        HomeFeedRefreshRepo.Companion.getRepo().subscribe(getScopeContext(), new Action2() {
            public final void call(Object obj, Subscription subscription) {
                HomeNoServicePresenter.this.m18554a((Integer) obj, subscription);
            }
        });
        HomeNoServiceRepo.Companion.getRep().subscribe(getScopeContext(), new Action1<Boolean>() {
            public void call(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    HomeNoServicePresenter.this.mo66822a(false);
                } else {
                    HomeNoServicePresenter.this.mo66822a(true);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18554a(Integer num, Subscription subscription) {
        mo66822a(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66822a(boolean z) {
        if (z) {
            HomeOtherOmegaHelper.trackExceptionSW(2);
        }
        ((HomeNoServiceView) getLogicView()).mo66824a(z);
    }
}
