package com.didi.sdk.sidebar.history.manager;

import com.didi.sdk.app.tap.BusinessConstants;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.sidebar.history.manager.impl.RideHistoryManagerImpl;
import com.didi.sdk.sidebar.history.manager.soda.FoodHistoryManagerImpl;

public class HistoryManagerBuilder {

    /* renamed from: d */
    private static HistoryManagerBuilder f40074d;

    /* renamed from: a */
    private IRideHistoryManager f40075a;

    /* renamed from: b */
    private IFoodHistoryManager f40076b;

    /* renamed from: c */
    private IBikeHistoryManager f40077c;

    private HistoryManagerBuilder() {
    }

    public static HistoryManagerBuilder getInstance() {
        if (f40074d == null) {
            synchronized (HistoryManagerBuilder.class) {
                if (f40074d == null) {
                    f40074d = new HistoryManagerBuilder();
                }
            }
        }
        return f40074d;
    }

    public IHistoryManager createHistoryManager(String str) {
        if ("ride".equals(str)) {
            if (this.f40075a == null) {
                this.f40075a = RideHistoryManagerImpl.getRideHistoryManager();
            }
            return this.f40075a;
        } else if ("soda".equals(str)) {
            if (this.f40076b == null) {
                this.f40076b = FoodHistoryManagerImpl.getFoodHistoryManager();
            }
            return this.f40076b;
        } else if (!BusinessConstants.TYPE_BIKE.equals(str)) {
            return null;
        } else {
            if (this.f40077c == null) {
                this.f40077c = (IBikeHistoryManager) ComponentLoadUtil.getComponent(IBikeHistoryManager.class);
            }
            return this.f40077c;
        }
    }
}
