package com.didi.beatles.p101im.plugin.robot.net;

import com.didi.beatles.p101im.net.IMHttpManager;
import com.didi.beatles.p101im.net.IMNetCallback;
import com.didi.beatles.p101im.plugin.robot.net.callback.IMRobotConfigureCallback;
import com.didi.beatles.p101im.plugin.robot.net.callback.IMRobotPraiseListCallback;
import com.didi.beatles.p101im.plugin.robot.net.callback.IMRobotUnlockCallback;
import com.didi.beatles.p101im.plugin.robot.net.request.IMRobotGetConfigureRequest;
import com.didi.beatles.p101im.plugin.robot.net.request.IMRobotPraiseListRequest;
import com.didi.beatles.p101im.plugin.robot.net.request.IMRobotUnlockRobotRequest;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotGetConfigureResponse;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotPraiseListResponse;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotUnlockRobotResponse;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.plugin.robot.net.IMRobotStore */
public class IMRobotStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11354a = IMRobotStore.class.getSimpleName();

    /* renamed from: b */
    private final int f11355b;

    /* renamed from: c */
    private final long f11356c;

    /* renamed from: d */
    private final String f11357d;

    /* renamed from: e */
    private final String f11358e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IMRobotGetConfigureResponse.Body f11359f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Map<Integer, String> f11360g = new HashMap();

    public IMRobotStore(int i, long j, String str, String str2) {
        this.f11355b = i;
        this.f11356c = j;
        this.f11357d = str;
        this.f11358e = str2;
    }

    public void loadConfigure(final IMRobotConfigureCallback iMRobotConfigureCallback) {
        this.f11359f = null;
        this.f11360g.clear();
        IMHttpManager.getInstance().performCommonPost(new IMRobotGetConfigureRequest(this.f11355b, this.f11356c, this.f11357d, this.f11358e), new IMNetCallback<IMRobotGetConfigureResponse>() {
            public void success(final IMRobotGetConfigureResponse iMRobotGetConfigureResponse) {
                if (iMRobotGetConfigureResponse == null || !iMRobotGetConfigureResponse.isSuccess() || iMRobotGetConfigureResponse.body == null) {
                    IMLog.m10021e(IMRobotStore.f11354a, "[loadConfigure] #success# invalid data.");
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            iMRobotConfigureCallback.onFailed();
                        }
                    });
                    return;
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        IMRobotGetConfigureResponse.Body unused = IMRobotStore.this.f11359f = iMRobotGetConfigureResponse.body;
                        if (IMRobotStore.this.f11359f.praiseBtnConfigList != null) {
                            for (IMRobotGetConfigureResponse.PraiseBtnConfig next : IMRobotStore.this.f11359f.praiseBtnConfigList) {
                                IMRobotStore.this.f11360g.put(Integer.valueOf(next.type), next.btnText);
                            }
                        }
                        iMRobotConfigureCallback.onSucceed(iMRobotGetConfigureResponse.body);
                    }
                });
            }

            public void failure(IOException iOException) {
                IMLog.m10021e(IMRobotStore.f11354a, "[loadConfigure] #failure# ", iOException);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotConfigureCallback.onFailed();
                    }
                });
            }
        });
    }

    public void loadPraiseList(String str, final IMRobotPraiseListCallback iMRobotPraiseListCallback) {
        IMHttpManager.getInstance().performCommonPost(new IMRobotPraiseListRequest(this.f11355b, str, this.f11356c, this.f11357d), new IMNetCallback<IMRobotPraiseListResponse>() {
            public void success(final IMRobotPraiseListResponse iMRobotPraiseListResponse) {
                if (iMRobotPraiseListResponse == null || !iMRobotPraiseListResponse.isSuccess() || iMRobotPraiseListResponse.body == null) {
                    IMLog.m10021e(IMRobotStore.f11354a, "[loadPraiseList] #success# invalid data.");
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            iMRobotPraiseListCallback.onFailed();
                        }
                    });
                    return;
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotPraiseListCallback.onSucceed(iMRobotPraiseListResponse.body.praiseList);
                    }
                });
            }

            public void failure(IOException iOException) {
                IMLog.m10021e(IMRobotStore.f11354a, "[loadPraiseList] #failure#", iOException);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotPraiseListCallback.onFailed();
                    }
                });
            }
        });
    }

    public void unlockRobot(String str, final IMRobotUnlockCallback iMRobotUnlockCallback) {
        IMHttpManager.getInstance().performCommonPost(new IMRobotUnlockRobotRequest(this.f11355b, str), new IMNetCallback<IMRobotUnlockRobotResponse>() {
            public void success(final IMRobotUnlockRobotResponse iMRobotUnlockRobotResponse) {
                if (iMRobotUnlockRobotResponse == null || !iMRobotUnlockRobotResponse.isSuccess() || iMRobotUnlockRobotResponse.body == null) {
                    IMLog.m10021e(IMRobotStore.f11354a, "[unlockRobot] #success# invalid data.");
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            iMRobotUnlockCallback.onFailed();
                        }
                    });
                    return;
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotUnlockCallback.onSucceed(iMRobotUnlockRobotResponse.body);
                    }
                });
            }

            public void failure(IOException iOException) {
                IMLog.m10021e(IMRobotStore.f11354a, "[unlockRobot] #failure#", iOException);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        iMRobotUnlockCallback.onFailed();
                    }
                });
            }
        });
    }

    public IMRobotGetConfigureResponse.Robot getRobot(int i) {
        IMRobotGetConfigureResponse.Body body = this.f11359f;
        if (body == null || body.robotList == null || i < 0 || i >= this.f11359f.robotList.size()) {
            return null;
        }
        return this.f11359f.robotList.get(i);
    }

    public String getPraiseBtnText(int i) {
        Map<Integer, String> map = this.f11360g;
        if (map == null) {
            return null;
        }
        return map.get(Integer.valueOf(i));
    }

    public String getShareBtnText() {
        IMRobotGetConfigureResponse.Body body = this.f11359f;
        if (body != null) {
            return body.shareBtnText;
        }
        return null;
    }
}
