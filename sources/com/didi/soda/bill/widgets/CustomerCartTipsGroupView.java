package com.didi.soda.bill.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.bill.widgets.CustomerCartTipsPercentItem;
import com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.jadux.Store;
import com.didi.soda.order.component.tips.TipActionCreator;
import com.didi.soda.order.component.tips.TipState;
import com.taxis99.R;
import java.util.Map;
import p218io.reactivex.functions.Consumer;

public class CustomerCartTipsGroupView extends ViewGroup {

    /* renamed from: d */
    private static final int f41995d = ResourceHelper.getDimensionPixelSize(R.dimen.customer_16px);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Store<TipState> f41996a;

    /* renamed from: b */
    private Context f41997b;

    /* renamed from: c */
    private int f41998c = 3;

    public interface OnselectTipListener {
        void onSelectTip(int i);
    }

    public CustomerCartTipsGroupView(Context context) {
        super(context);
        m31500a(context);
    }

    public CustomerCartTipsGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31500a(context);
    }

    public CustomerCartTipsGroupView setStore(Store<TipState> store) {
        this.f41996a = store;
        store.subscribe(new Consumer<TipState>() {
            public void accept(TipState tipState) throws Exception {
                CustomerCartTipsGroupView.this.m31502a(tipState);
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th) throws Exception {
                th.printStackTrace();
            }
        });
        return this;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount;
        if (z && (childCount = getChildCount()) != 0) {
            int dip2px = DisplayUtils.dip2px(this.f41997b, 24.0f);
            int measuredWidth = getChildAt(0).getMeasuredWidth();
            int measuredHeight = getChildAt(0).getMeasuredHeight();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                int i6 = this.f41998c;
                int i7 = f41995d;
                childAt.layout((i5 % i6) * (measuredWidth + i7), (i5 / i6) * (measuredHeight + dip2px), (((i5 % i6) + 1) * measuredWidth) + ((i5 % i6) * i7), (((i5 / i6) + 1) * measuredHeight) + ((i5 / i6) * dip2px));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        measureChildren(m31504c(i), i2);
        setMeasuredDimension(m31498a(i), m31503b(i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31502a(TipState tipState) {
        if (tipState != null && tipState.mConfig != null && tipState.mConfig.tipFeeConfig != null) {
            C142333 r0 = new OnselectTipListener() {
                public void onSelectTip(int i) {
                    CustomerCartTipsGroupView.this.f41996a.dispatch(TipActionCreator.selectTip(i));
                }
            };
            TipsConfigEntity tipsConfigEntity = tipState.mConfig;
            for (int i = 0; i < tipsConfigEntity.tipFeeConfig.size(); i++) {
                if (getChildAt(i) == null) {
                    CustomerCartTipsPercentItem customerCartTipsPercentItem = new CustomerCartTipsPercentItem(this.f41997b, i);
                    customerCartTipsPercentItem.setTips(new CustomerCartTipsPercentItem.TipFeeViewModel(tipsConfigEntity.tipFeeConfig.get(i).longValue(), tipsConfigEntity.tipFeeType, tipState.mCurrency, tipState.mOrderPrice));
                    customerCartTipsPercentItem.setOnSelectTipListener(r0);
                    customerCartTipsPercentItem.setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtils.dip2px(this.f41997b, 30.0f)));
                    addView(customerCartTipsPercentItem);
                }
            }
            for (Map.Entry next : tipState.mSelectStatus.entrySet()) {
                getChildAt(((Integer) next.getKey()).intValue()).setSelected(((Boolean) next.getValue()).booleanValue());
            }
        }
    }

    /* renamed from: a */
    private int m31498a(int i) {
        return View.MeasureSpec.getSize(i);
    }

    /* renamed from: b */
    private int m31503b(int i) {
        int childCount = getChildCount();
        int i2 = 0;
        if (childCount == 0) {
            return 0;
        }
        int dip2px = DisplayUtils.dip2px(this.f41997b, 24.0f);
        int measuredHeight = childCount > 0 ? getChildAt(0).getMeasuredHeight() : 0;
        int i3 = this.f41998c;
        int i4 = childCount / i3;
        if (childCount % i3 > 0) {
            i2 = 1;
        }
        int i5 = i4 + i2;
        return (measuredHeight * i5) + (dip2px * (i5 - 1));
    }

    /* renamed from: c */
    private int m31504c(int i) {
        int size = View.MeasureSpec.getSize(i);
        int i2 = this.f41998c;
        return View.MeasureSpec.makeMeasureSpec((size - ((i2 - 1) * f41995d)) / i2, 1073741824);
    }

    /* renamed from: a */
    private void m31500a(Context context) {
        this.f41997b = context;
    }
}
