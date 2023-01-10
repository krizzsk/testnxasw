package com.didi.component.framework.pages.promo.fragment;

import com.didi.component.framework.pages.promo.helper.MapToSharePlatform;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.view.fragment.PlatformClickListener;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/component/framework/pages/promo/fragment/PromoShareFragment$onCreateView$2$1", "Lcom/didi/onekeyshare/view/fragment/PlatformClickListener;", "onClick", "", "platform", "Lcom/didi/onekeyshare/entity/SharePlatform;", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PromoShareFragment.kt */
public final class PromoShareFragment$onCreateView$2$1 implements PlatformClickListener {
    final /* synthetic */ PromoShareFragment this$0;

    PromoShareFragment$onCreateView$2$1(PromoShareFragment promoShareFragment) {
        this.this$0 = promoShareFragment;
    }

    public void onClick(SharePlatform sharePlatform) {
        String str;
        PromoShareFragment promoShareFragment = this.this$0;
        if (sharePlatform == null) {
            str = null;
        } else {
            str = sharePlatform.platformName();
        }
        PromoShareFragment.m13049a(promoShareFragment, MapToSharePlatform.PROMO_CHANNEL_CLICK, str, (Boolean) null, 4, (Object) null);
    }
}
