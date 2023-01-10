package com.didi.beatles.p101im.net;

import com.didi.beatles.p101im.IMEnvironment;
import com.didi.beatles.p101im.api.entity.IMBaseResponse;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

/* renamed from: com.didi.beatles.im.net.IMNetCallback */
public abstract class IMNetCallback<T> implements RpcService.Callback<T> {
    private static final String TAG = "IMNetCallback";

    public abstract void failure(IOException iOException);

    public abstract void success(T t);

    public final void onSuccess(T t) {
        if (IMEnvironment.isInit()) {
            if (t == null) {
                IMLog.m10026w(TAG, "net response is null !!!");
            }
            if (t instanceof IMBaseResponse) {
                IMBaseResponse iMBaseResponse = (IMBaseResponse) t;
                if (iMBaseResponse.errno != 0) {
                    IMLog.m10026w(TAG, "net response error, errmsg = " + iMBaseResponse.errmsg);
                }
            }
            try {
                success(t);
            } catch (Exception e) {
                onFailure(new IOException());
                e.printStackTrace();
                IMLog.m10021e(TAG, "IMNetCallback execute method onSuccess failed, errMsg = " + e.toString());
                IMTraceUtil.CodeErrorParam addErrno = IMTraceUtil.addCodeErrorEvent().addErrno(6);
                addErrno.addErrMsg("errMsg = " + e.toString()).addExtendMsg(IMTextUtil.getExceptionStack(e)).report();
            }
        }
    }

    public final void onFailure(IOException iOException) {
        if (IMEnvironment.isInit()) {
            failure(iOException);
        }
    }
}
