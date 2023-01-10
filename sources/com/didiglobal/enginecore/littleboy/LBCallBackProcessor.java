package com.didiglobal.enginecore.littleboy;

import android.text.TextUtils;
import com.android.didi.bfflib.utils.TrackUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.enginecore.utils.XEngineLog;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LBCallBackProcessor implements RpcService.Callback<JsonObject> {

    /* renamed from: a */
    private List<LBAbility> f52693a;

    /* renamed from: b */
    private ILBTask f52694b;

    public LBCallBackProcessor(ILBTask iLBTask, List<LBAbility> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f52693a = copyOnWriteArrayList;
        copyOnWriteArrayList.addAll(list);
        this.f52694b = iLBTask;
    }

    public void onSuccess(JsonObject jsonObject) {
        ILBTask iLBTask;
        try {
            if (this.f52694b.getStatus() == 3) {
                m39565a((JsonObject) null, (Exception) null);
            } else if (jsonObject.get("errno").getAsInt() == 0) {
                m39563a(jsonObject);
            } else {
                XEngineLog.m39594fi("bffFail" + jsonObject);
                m39565a(jsonObject, (Exception) null);
            }
            iLBTask = this.f52694b;
            if (iLBTask == null) {
                return;
            }
        } catch (Exception e) {
            TrackUtil.trackError(e instanceof JsonParseException ? 1 : 5, "", e, jsonObject.toString());
            e.printStackTrace();
            onFailure(new IOException(e));
            iLBTask = this.f52694b;
            if (iLBTask == null) {
                return;
            }
        } catch (Throwable th) {
            ILBTask iLBTask2 = this.f52694b;
            if (iLBTask2 != null) {
                iLBTask2.removeCache();
                this.f52694b.setRequesting(false);
                this.f52694b.setStatus(2);
            }
            throw th;
        }
        iLBTask.removeCache();
        this.f52694b.setRequesting(false);
        this.f52694b.setStatus(2);
    }

    public void onFailure(IOException iOException) {
        ILBTask iLBTask;
        try {
            m39565a((JsonObject) null, (Exception) iOException);
            iLBTask = this.f52694b;
            if (iLBTask == null) {
                return;
            }
        } catch (Exception e) {
            TrackUtil.trackError(e instanceof JsonParseException ? 1 : 5, "", e, "");
            e.printStackTrace();
            iLBTask = this.f52694b;
            if (iLBTask == null) {
                return;
            }
        } catch (Throwable th) {
            ILBTask iLBTask2 = this.f52694b;
            if (iLBTask2 != null) {
                iLBTask2.setRequesting(false);
                this.f52694b.removeCache();
                this.f52694b.setStatus(2);
            }
            throw th;
        }
        iLBTask.setRequesting(false);
        this.f52694b.removeCache();
        this.f52694b.setStatus(2);
    }

    /* renamed from: a */
    private void m39563a(JsonObject jsonObject) {
        XEngineLog.m39587d("bffCallbackonSuccessPrivate");
        for (LBAbility a : this.f52693a) {
            m39564a(jsonObject, a);
        }
    }

    /* renamed from: a */
    private void m39564a(JsonObject jsonObject, LBAbility lBAbility) {
        RpcService.Callback<JsonObject> callback = lBAbility.getCallback();
        if (callback != null && jsonObject.get("data") != null) {
            try {
                callback.onSuccess(m39562a(jsonObject.get("data").getAsJsonObject(), lBAbility.getRequestKey()));
            } catch (Exception e) {
                TrackUtil.trackError(e instanceof JsonParseException ? 1 : 5, "", e, jsonObject.toString());
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private JsonObject m39562a(JsonObject jsonObject, String str) {
        if (!(TextUtils.isEmpty(str) || jsonObject == null || jsonObject.keySet() == null || jsonObject.keySet().size() == 0)) {
            for (String next : jsonObject.keySet()) {
                if (str.equals(next)) {
                    return jsonObject.get(next).getAsJsonObject();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m39565a(JsonObject jsonObject, Exception exc) {
        IOException iOException;
        XEngineLog.m39594fi("bffCallbackonFailurePrivate");
        for (LBAbility callback : this.f52693a) {
            RpcService.Callback<JsonObject> callback2 = callback.getCallback();
            if (callback2 != null) {
                if (exc == null) {
                    try {
                        iOException = new IOException("网络请求失败");
                    } catch (Exception e) {
                        TrackUtil.trackError(exc instanceof JsonParseException ? 1 : 5, "", exc, jsonObject.toString());
                        e.printStackTrace();
                    }
                } else {
                    iOException = new IOException(exc);
                }
                callback2.onFailure(iOException);
            }
        }
    }
}
