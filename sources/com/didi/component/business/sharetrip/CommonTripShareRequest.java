package com.didi.component.business.sharetrip;

import android.content.Context;
import com.didi.component.business.constant.HostConstants;
import com.didi.sdk.commonhttp.GeneralRequest;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;

public class CommonTripShareRequest extends BaseRequest {

    /* renamed from: a */
    private static CommonTripShareRequest f13187a;

    /* renamed from: b */
    private Context f13188b;

    public CommonTripShareRequest(Context context) {
        this.f13188b = context;
    }

    public static CommonTripShareRequest getInstance(Context context) {
        if (f13187a == null) {
            f13187a = new CommonTripShareRequest(context.getApplicationContext());
        }
        return f13187a;
    }

    public void getTripShareInfo(String str, int i, ResponseListener<CommonTripShareInfo> responseListener) {
        new GeneralRequest(this.f13188b, HostConstants.getHostCommon()).getShareTripInfo(str, i, getRpcCallback(responseListener, new CommonTripShareInfo()));
    }
}
