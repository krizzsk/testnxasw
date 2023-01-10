package com.didi.one.netdetect.task;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.PingCommand;
import com.didi.one.netdetect.command.PingResult;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.NetUtil;
import com.didi.one.netdetect.util.ONDLog;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PingTask implements Task<PingResult> {

    /* renamed from: b */
    private static final String f31926b = "OND_PingTask";

    /* renamed from: a */
    private Logger f31927a = LoggerFactory.getLogger("OneNetDetect");

    /* renamed from: c */
    private int f31928c;

    /* renamed from: d */
    private int f31929d;

    /* renamed from: e */
    private Context f31930e;

    /* renamed from: f */
    private Command.OutPutHandler<PingResult> f31931f;

    public PingTask(Context context) {
        this.f31930e = context;
    }

    public PingTask(Context context, Command.OutPutHandler<PingResult> outPutHandler) {
        this.f31930e = context;
        this.f31931f = outPutHandler;
    }

    public PingResult doTask(DetectionItem detectionItem) {
        PingResult a = m24356a(detectionItem, true);
        if (a == null || !TextUtils.isEmpty(a.getErrValue()) || a.isFailAll()) {
            return m24356a(detectionItem, false);
        }
        return a;
    }

    /* renamed from: a */
    private PingResult m24356a(DetectionItem detectionItem, boolean z) {
        if (TextUtils.isEmpty(detectionItem.url)) {
            return new PingResult(0, "ERROR", "item.url is null, " + detectionItem);
        }
        String str = "Ping native";
        ONDLog.m24359d(f31926b, z ? str : "Ping external file");
        Command.OutPutHandler<PingResult> outPutHandler = this.f31931f;
        if (outPutHandler != null) {
            StringBuilder sb = new StringBuilder();
            if (!z) {
                str = "Ping external file";
            }
            sb.append(str);
            sb.append("\r\n");
            outPutHandler.handleMsg(sb.toString());
        }
        try {
            PingCommand build = new PingCommand.Builder().setIsNative(z).setHost(NetUtil.isIpAddress(detectionItem.url) ? detectionItem.url : new URL(detectionItem.url).getHost()).setSendCount(this.f31928c).setTimeout(this.f31929d).build(this.f31930e);
            build.setOutPutHandler(this.f31931f);
            build.execute();
            ONDLog.m24359d(f31926b, "normal output:\r\n" + build.getNormalOutput());
            ONDLog.m24359d(f31926b, "error output:\r\n" + build.getErrorOutput());
            PingResult pingResult = new PingResult(this.f31928c, build.getNormalOutput(), build.getErrorOutput());
            if (pingResult.isFailAll()) {
                HashMap hashMap = new HashMap();
                hashMap.put("pingResult", pingResult.getNormalValue());
                this.f31927a.errorEvent("Ping", (Map<?, ?>) hashMap);
            }
            if (this.f31931f != null) {
                this.f31931f.handleResult(pingResult);
            }
            return pingResult;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            PingResult pingResult2 = new PingResult(0, "ERROR", e.getMessage());
            Command.OutPutHandler<PingResult> outPutHandler2 = this.f31931f;
            if (outPutHandler2 != null) {
                outPutHandler2.handleResult(pingResult2);
            }
            return pingResult2;
        }
    }

    public void setCount(int i) {
        this.f31928c = i;
    }

    public void setTimeout(int i) {
        this.f31929d = i;
    }
}
