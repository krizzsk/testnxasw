package com.didi.soda.home.topgun.widget;

import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeSceneView.kt */
final class HomeSceneView$bindData$4 extends Lambda implements Function0<Unit> {
    public static final HomeSceneView$bindData$4 INSTANCE = new HomeSceneView$bindData$4();

    HomeSceneView$bindData$4() {
        super(0);
    }

    public final void invoke() {
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).activityInvalidedRefreshHome();
    }
}
