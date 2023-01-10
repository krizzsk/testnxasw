package com.didi.soda.customer.foundation.share;

import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.customer.downgrade.CustomerDowngradeHelper;
import com.didi.soda.customer.foundation.rpc.entity.ShareCouponInfoEntity;
import com.didi.soda.web.model.ShareToolModel;
import java.util.ArrayList;
import java.util.List;

public final class ShareHelper implements IShareInterface {

    /* renamed from: a */
    private static ShareHelper f43655a;

    /* renamed from: b */
    private static IShareInterface f43656b;

    public static ShareHelper getInstance() {
        if (f43655a == null) {
            f43655a = new ShareHelper();
            if (CustomerDowngradeHelper.isDowngradeShare()) {
                f43656b = new ShareDowngradeImp();
            } else {
                f43656b = new ShareDefaultImp();
            }
        }
        return f43655a;
    }

    public void systemShare(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        f43656b.systemShare(context, shareToolModel, iPlatformShareCallback);
    }

    public void shareToPlatform(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        f43656b.shareToPlatform(context, shareToolModel, iPlatformShareCallback);
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IShareCallback iShareCallback) {
        f43656b.showSharePlatform(context, arrayList, iShareCallback);
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        f43656b.showSharePlatform(context, arrayList, iPlatformClickCallback);
    }

    public ArrayList<ShareToolModel> convertShareToolModel(List<ShareCouponInfoEntity> list) {
        return f43656b.convertShareToolModel(list);
    }
}
