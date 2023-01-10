package com.didi.travel.psnger.core.matchinfo;

import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.TravelSDK;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.listener.IDiDiMatchInfoCallback;
import com.didi.travel.psnger.core.model.request.BaseMatchInfoParams;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IMatchInfo;
import com.didi.travel.psnger.core.poll.BasePoller;
import com.didi.travel.psnger.core.poll.IPollCallbackProtocol;
import com.didi.travel.psnger.core.poll.adapter.PollCallbackAdapter;
import com.didi.travel.psnger.core.poll.impl.DefaultPoller;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.LogUtil;

public class MatchInfoPollingManager {

    /* renamed from: a */
    private static final int f46730a = 86400000;

    /* renamed from: b */
    private BasePoller f46731b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BaseMatchInfoParams f46732c;

    /* renamed from: d */
    private MatchInfoService f46733d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IDiDiMatchInfoCallback f46734e;

    /* renamed from: f */
    private IPollCallbackProtocol f46735f = new PollCallbackAdapter() {
        public void onSendRequest(int i) {
            if (TextUtil.isEmpty(TravelSDK.travelParam() != null ? TravelSDK.travelParam().token() : null)) {
                MatchInfoPollingManager.this.stopOrderMatchInfoPoll();
                return;
            }
            ICarOrder order = DDTravelOrderStore.getOrder();
            if (order != null && !TextUtil.isEmpty(order.getOid()) && order.getStartAddress() != null) {
                MatchInfoPollingManager.this.m34852a(false);
            }
        }
    };

    public MatchInfoPollingManager(MatchInfoService matchInfoService) {
        this.f46733d = matchInfoService;
    }

    public void startMatchInfo(boolean z, BaseMatchInfoParams baseMatchInfoParams) {
        this.f46732c = baseMatchInfoParams;
        m34852a(z);
    }

    public void setMatchCallback(IDiDiMatchInfoCallback iDiDiMatchInfoCallback) {
        this.f46734e = iDiDiMatchInfoCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34849a(long j) {
        if (j <= 1000) {
            j = 5000;
        }
        long j2 = j;
        long j3 = (long) 86399999;
        long j4 = (long) 1000;
        LogUtil.m34919fi("startOrderMatchInfoPoll maxTimeThreshold=" + j3 + ", frequencyTime=" + j2 + ", diffMaxTime=" + j4);
        if (this.f46731b == null) {
            this.f46731b = new DefaultPoller();
        }
        if (this.f46731b.checkPollerRunning()) {
            this.f46731b.stopPoll();
        }
        this.f46731b.registerPollCallback(this.f46735f);
        this.f46731b.startPoll(j3, j2, j4, true);
    }

    public void stopOrderMatchInfoPoll() {
        BasePoller basePoller = this.f46731b;
        if (basePoller != null) {
            basePoller.stopPoll();
            this.f46731b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m34853a() {
        return this.f46731b.checkPollerRunning();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34852a(final boolean z) {
        LogUtil.m34919fi("doQueryMatchInfo isInit " + z);
        if (this.f46732c == null) {
            LogUtil.m34919fi("doQueryMatchInfo mMatchInfoParams == null");
            return;
        }
        LogUtil.m34919fi("doQueryMatchInfo mMatchInfoParams != null");
        this.f46733d.getMatchInfo(TravelSDK.appContext(), this.f46732c, new ResponseListener<IMatchInfo>() {
            public void onSuccess(IMatchInfo iMatchInfo) {
                super.onSuccess(iMatchInfo);
                if (!TextUtils.equals(MatchInfoPollingManager.this.f46732c.getOid(), iMatchInfo.getOid()) && !TravelSDK.isDebug()) {
                    return;
                }
                if (z || MatchInfoPollingManager.this.m34853a()) {
                    if (iMatchInfo.isStopQuery()) {
                        if (!z) {
                            MatchInfoPollingManager.this.stopOrderMatchInfoPoll();
                        }
                    } else if (z) {
                        MatchInfoPollingManager.this.m34849a((long) (iMatchInfo.getQueryStep() * 1000));
                    }
                    if (MatchInfoPollingManager.this.f46734e != null) {
                        MatchInfoPollingManager.this.f46734e.onMatchInfoRefresh(z, iMatchInfo);
                    }
                }
            }

            public void onFail(IMatchInfo iMatchInfo) {
                super.onFail(iMatchInfo);
                if (z) {
                    MatchInfoPollingManager.this.m34849a(5000);
                }
            }

            public void onError(IMatchInfo iMatchInfo) {
                super.onError(iMatchInfo);
                if (z) {
                    MatchInfoPollingManager.this.m34849a(5000);
                }
            }
        });
    }
}
