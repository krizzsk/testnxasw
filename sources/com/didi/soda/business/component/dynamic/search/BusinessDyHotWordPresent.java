package com.didi.soda.business.component.dynamic.search;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchHotWordEntity;
import com.didi.soda.customer.foundation.util.ClickUtils;
import java.util.List;

public class BusinessDyHotWordPresent extends IPresenter<BusinessDyHotWordView> {

    /* renamed from: a */
    private RecommendWordListener f42184a;

    /* renamed from: b */
    private List<String> f42185b;

    /* renamed from: c */
    private String f42186c;

    public void setRecommendWordListener(RecommendWordListener recommendWordListener) {
        this.f42184a = recommendWordListener;
    }

    public void clickWord(int i) {
        List<String> list = this.f42185b;
        if (list != null && i >= 0 && i < list.size() && !ClickUtils.isFastClick()) {
            String str = this.f42185b.get(i);
            RecommendWordListener recommendWordListener = this.f42184a;
            if (recommendWordListener != null) {
                recommendWordListener.onRecommendWordSearch(str, this.f42186c);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m31676a();
    }

    /* renamed from: a */
    private void m31676a() {
        BusinessInfoEntity businessInfoEntity = (BusinessInfoEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.SHOP_INFO_ENTITY);
        if (businessInfoEntity == null || businessInfoEntity.recItemSearchWords == null) {
            ((BusinessDyHotWordView) getLogicView()).setHotWords((List<String>) null);
            return;
        }
        BusinessSearchHotWordEntity businessSearchHotWordEntity = businessInfoEntity.recItemSearchWords;
        this.f42185b = businessSearchHotWordEntity.recWords;
        this.f42186c = businessSearchHotWordEntity.recId;
        ((BusinessDyHotWordView) getLogicView()).setHotWords(this.f42185b);
    }
}
