package com.didi.one.netdetect.task;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.TraceRouteCommand;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.NetUtil;
import com.didi.one.netdetect.util.ONDLog;
import java.net.MalformedURLException;
import java.net.URL;

public class TraceRouteTask implements Task<String> {

    /* renamed from: a */
    private static final String f31936a = "OND_TraceRouteTask_New";

    /* renamed from: b */
    private Context f31937b;

    /* renamed from: c */
    private int f31938c;

    /* renamed from: d */
    private int f31939d;

    /* renamed from: e */
    private Command.OutPutHandler<String> f31940e;

    public TraceRouteTask(Context context) {
        this.f31937b = context;
    }

    public TraceRouteTask(Context context, Command.OutPutHandler<String> outPutHandler) {
        this.f31937b = context;
        this.f31940e = outPutHandler;
    }

    public String doTask(DetectionItem detectionItem) {
        if (TextUtils.isEmpty(detectionItem.url)) {
            return null;
        }
        try {
            TraceRouteCommand.Builder maxTTL = new TraceRouteCommand.Builder().setHost(NetUtil.isIpAddress(detectionItem.url) ? detectionItem.url : new URL(detectionItem.url).getHost()).setMaxTTL(this.f31938c);
            if (this.f31939d > 0) {
                maxTTL = maxTTL.setWaitTime(this.f31939d);
            }
            TraceRouteCommand build = maxTTL.build(this.f31937b);
            build.setOutPutHandler(this.f31940e);
            build.execute();
            String str = build.getNormalOutput() + "\r\n" + build.getErrorOutput();
            if (this.f31940e != null) {
                this.f31940e.handleResult(str);
            }
            ONDLog.m24359d(f31936a, str);
            return str;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setMaxTTL(int i) {
        this.f31938c = i;
    }

    public void setWaitTime(int i) {
        this.f31939d = i;
    }
}
