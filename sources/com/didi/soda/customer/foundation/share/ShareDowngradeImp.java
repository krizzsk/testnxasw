package com.didi.soda.customer.foundation.share;

import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ShareCouponInfoEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.web.model.ShareToolModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class ShareDowngradeImp implements IShareInterface {

    /* renamed from: a */
    private static final String f43654a = "ShareDowngradeImp";

    public void systemShare(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        m32628a("systemShare");
    }

    public void shareToPlatform(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        m32628a("shareToPlatform");
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IShareCallback iShareCallback) {
        m32628a("showSharePlatform 1");
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        m32628a("showSharePlatform 2");
    }

    public ArrayList<ShareToolModel> convertShareToolModel(List<ShareCouponInfoEntity> list) {
        m32628a("convertShareToolModel");
        return null;
    }

    /* renamed from: a */
    private void m32628a(String str) {
        ToastUtil.makeText(ResourceHelper.getString(R.string.FoodC_downgrade_tip_share));
        LogUtil.m32588i(f43654a, "share down grade = " + str);
    }
}
