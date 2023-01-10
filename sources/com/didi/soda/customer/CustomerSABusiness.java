package com.didi.soda.customer;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.sdk.app.business.ISABusiness;
import com.didi.sdk.app.business.SaBusinessManager;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "soda", value = {ISABusiness.class})
@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/customer/CustomerSABusiness;", "Lcom/didi/sdk/app/business/ISABusiness;", "()V", "isDirectOpen", "Lcom/didi/soda/customer/DirectionInfo;", "url", "", "transitionFragment", "Landroidx/fragment/app/Fragment;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerSABusiness.kt */
public final class CustomerSABusiness implements ISABusiness {
    public Fragment transitionFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        LogUtil.m32584d("ISABusiness", Intrinsics.stringPlus("url = ", str));
        GlobalContext.fromSuperApp();
        if (CustomerApolloUtil.createFragmentAllowNull() && Intrinsics.areEqual((Object) SaBusinessManager.Companion.getIns().getCurrentBusiness(), (Object) "soda")) {
            return null;
        }
        C14369a a = m32043a(str);
        Bundle bundle = new Bundle();
        if (a.mo108031a()) {
            bundle.putString(Const.SABusiness.KEY_DIRECT_OPEN, "1");
            bundle.putString("addressInfo", a.mo108032b());
        }
        CustomerFragmentB customerFragmentB = new CustomerFragmentB();
        customerFragmentB.setArguments(bundle);
        return customerFragmentB;
    }

    /* renamed from: a */
    private final C14369a m32043a(String str) {
        if (str.length() == 0) {
            return new C14369a(false, (String) null, 2, (DefaultConstructorMarker) null);
        }
        C14369a aVar = new C14369a(false, (String) null, 3, (DefaultConstructorMarker) null);
        Uri parse = Uri.parse(str);
        if (Intrinsics.areEqual((Object) parse.getQueryParameter(Const.SABusiness.KEY_DIRECT_OPEN), (Object) "1")) {
            aVar.mo108030a(true);
        }
        try {
            String decode = Uri.decode(parse.getQueryParameter("addressInfo"));
            if (decode == null) {
                decode = "";
            }
            aVar.mo108029a(decode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar;
    }
}
