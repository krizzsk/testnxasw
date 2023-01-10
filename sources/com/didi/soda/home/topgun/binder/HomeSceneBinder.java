package com.didi.soda.home.topgun.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.home.topgun.binder.model.SceneComponentModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/HomeSceneBinder;", "Lcom/didi/soda/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/soda/home/topgun/binder/HomeSceneLogic;", "Lcom/didi/soda/home/topgun/binder/model/SceneComponentModel;", "Lcom/didi/soda/home/topgun/binder/SceneViewHolder;", "()V", "logic", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onCreateBinderLogic", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeSceneBinder.kt */
public final class HomeSceneBinder extends CustomerLogicItemBinder<HomeSceneLogic, SceneComponentModel, SceneViewHolder> {

    /* renamed from: a */
    private final HomeSceneLogic f45247a = new HomeSceneLogic();

    public Class<SceneComponentModel> bindDataType() {
        return SceneComponentModel.class;
    }

    public SceneViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_item_home_scene_comp, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new SceneViewHolder(inflate, this.f45247a);
    }

    public void bind(SceneViewHolder sceneViewHolder, SceneComponentModel sceneComponentModel) {
        Intrinsics.checkNotNullParameter(sceneViewHolder, "holder");
        long currentTimeMillis = System.currentTimeMillis();
        sceneViewHolder.bindData();
        LogUtil.m32588i("TAG", Intrinsics.stringPlus(">>>>>>> HomeSceneBinder dur - ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    public HomeSceneLogic onCreateBinderLogic() {
        return this.f45247a;
    }
}
