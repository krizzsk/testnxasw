package com.didichuxing.apollo.sdk.log;

import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import java.util.Random;

public class LogDelegateWrapper implements ILogDelegate {

    /* renamed from: a */
    private ILogDelegate f48285a;

    /* renamed from: b */
    private final Random f48286b = new Random();

    public LogDelegateWrapper(ILogDelegate iLogDelegate) {
        LogUtils.m36179d(GlobalCashierCoreModule.APOLLO, "rate logger init");
        this.f48285a = iLogDelegate;
    }

    public void saveLog(ApolloLog apolloLog) {
        LogUtils.m36179d(GlobalCashierCoreModule.APOLLO, "use rate logger");
        Integer logRate = apolloLog.getLogRate();
        if (logRate != null && logRate.intValue() > 0 && logRate.intValue() <= 1000 && this.f48285a != null && this.f48286b.nextInt(1000) < logRate.intValue()) {
            this.f48285a.saveLog(apolloLog);
        }
    }

    public void saveErrorLog(ApolloErrorLog apolloErrorLog) {
        ILogDelegate iLogDelegate;
        if (this.f48286b.nextInt(100) == 0 && (iLogDelegate = this.f48285a) != null) {
            iLogDelegate.saveErrorLog(apolloErrorLog);
        }
    }
}
