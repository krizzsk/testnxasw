package com.didi.soda.home.topgun.binder;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.home.topgun.binder.HomeHeaderItemLogicRepo;
import com.didi.soda.home.topgun.component.feed.HomeFeedPresenter;
import com.didi.soda.home.topgun.manager.FilterNoResultLogicRepo;

public class HomeComponentLogicUnit extends ComponentLogicUnit {

    /* renamed from: a */
    private HomeFeedPresenter f45240a;

    public HomeComponentLogicUnit(HomeFeedPresenter homeFeedPresenter) {
        this.f45240a = homeFeedPresenter;
    }

    public void onBindLogic() {
        ((HomeHeaderItemLogicRepo) getLogic(HomeHeaderItemLogicRepo.class)).subscribe(this.f45240a.getScopeContext(), new Action1<HomeHeaderItemLogicRepo.LogicModel>() {
            public void call(HomeHeaderItemLogicRepo.LogicModel logicModel) {
                HomeComponentLogicUnit.this.m33567a(logicModel);
            }
        });
        ((FilterNoResultLogicRepo) getLogic(FilterNoResultLogicRepo.class)).subscribe(this.f45240a.getScopeContext(), new Action1<Integer>() {
            public void call(Integer num) {
                HomeComponentLogicUnit.this.m33568a(num);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33568a(Integer num) {
        if (num.intValue() == 1) {
            this.f45240a.resetFilter();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33567a(HomeHeaderItemLogicRepo.LogicModel logicModel) {
        if (logicModel != null && TextUtils.equals(HomeHeaderItemLogicRepo.TYPE_ON_FILTER_ITEM_CLICK, logicModel.mType)) {
            this.f45240a.notifyFilterItemClick(logicModel.filterModel, logicModel.isFloating());
        }
    }
}
