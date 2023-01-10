package com.didi.entrega.customer.base.recycler;

import android.content.Context;
import android.text.TextUtils;
import androidx.recyclerview.widget.GridLayoutManager;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaGridLayoutManager;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;

public class CustomerNovaGridLayoutManager extends NovaGridLayoutManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f21674a;

    public CustomerNovaGridLayoutManager(Context context) {
        super(context);
    }

    public void bindSource(String str) {
        this.f21674a = str;
    }

    public void init(NovaRecyclerAdapter novaRecyclerAdapter) {
        super.init(novaRecyclerAdapter);
        final GridLayoutManager.SpanSizeLookup spanSizeLookup = getSpanSizeLookup();
        setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            public int getSpanSize(int i) {
                if (i != -1) {
                    return spanSizeLookup.getSpanSize(i);
                }
                if (TextUtils.isEmpty(CustomerNovaGridLayoutManager.this.f21674a)) {
                    return 1;
                }
                LogUtil.m18183e("CustomerNovaGridLayoutManager", "sourceName:" + CustomerNovaGridLayoutManager.this.f21674a);
                OmegaTracker.Builder.create("customer_gridlayout_spansize_error").addEventParam("sourceName", CustomerNovaGridLayoutManager.this.f21674a).build().track();
                return 1;
            }
        });
    }
}
