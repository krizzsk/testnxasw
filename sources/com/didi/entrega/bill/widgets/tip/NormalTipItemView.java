package com.didi.entrega.bill.widgets.tip;

import android.content.Context;
import android.widget.FrameLayout;
import com.didi.entrega.customer.foundation.skin.SkinUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/entrega/bill/widgets/tip/NormalTipItemView;", "Landroid/widget/FrameLayout;", "Lcom/didi/entrega/bill/widgets/tip/ITipItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "tipAmountText", "Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "dynamicFitTextSize", "", "setData", "", "text", "", "isSelected", "", "setSelectedState", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NormalTipItemView.kt */
public final class NormalTipItemView extends FrameLayout implements ITipItemView {

    /* renamed from: a */
    private final CustomerAppCompatTextView f21468a;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NormalTipItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundResource(R.drawable.entrega_skin_selector_bill_tip_bg);
        CustomerAppCompatTextView customerAppCompatTextView = new CustomerAppCompatTextView(context);
        this.f21468a = customerAppCompatTextView;
        customerAppCompatTextView.setTextColor(context.getResources().getColor(R.color.rf_color_gery_1_0_000000));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f21468a, IToolsService.FontType.LIGHT);
        this.f21468a.setTextSize(1, m18058a());
        addView(this.f21468a, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    public final void setData(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f21468a.setText(str);
        setSelectedState(z);
    }

    public void setSelectedState(boolean z) {
        setSelected(z);
        if (z) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f21468a, IToolsService.FontType.MEDIUM);
            this.f21468a.setTextColor(SkinUtil.getBrandPrimaryColor());
            return;
        }
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f21468a, IToolsService.FontType.LIGHT);
        this.f21468a.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
    }

    /* renamed from: a */
    private final float m18058a() {
        return CustomerSystemUtil.getScreenWidth(getContext()) > 640 ? 18.0f : 14.0f;
    }
}
