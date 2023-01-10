package com.didi.sdk.p155ms.push;

import android.content.Context;
import com.didi.sdk.p155ms.common.type.IMSType;

/* renamed from: com.didi.sdk.ms.push.ITokenOperation */
public interface ITokenOperation extends IMSType {
    String getTokenCached(Context context);

    String getTokenSync(Context context);

    boolean isTokenCachedSyncWithServer(Context context);
}
