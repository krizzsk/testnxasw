package com.didi.entrega.customer.foundation.share;

import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.web.model.ShareToolModel;
import java.util.ArrayList;

public final class ShareHelper implements IShareInterface {

    /* renamed from: a */
    private static ShareHelper f21882a;

    /* renamed from: b */
    private static IShareInterface f21883b;

    public static ShareHelper getInstance() {
        if (f21882a == null) {
            f21882a = new ShareHelper();
            f21883b = new ShareDefaultImp();
        }
        return f21882a;
    }

    public void systemShare(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        f21883b.systemShare(context, shareToolModel, iPlatformShareCallback);
    }

    public void shareToPlatform(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        f21883b.shareToPlatform(context, shareToolModel, iPlatformShareCallback);
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IShareCallback iShareCallback) {
        f21883b.showSharePlatform(context, arrayList, iShareCallback);
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        f21883b.showSharePlatform(context, arrayList, iPlatformClickCallback);
    }
}
