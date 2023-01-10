package com.didi.one.netdetect.task;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.TracePathCommand;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.NetUtil;
import com.didi.one.netdetect.util.ONDLog;
import java.net.MalformedURLException;
import java.net.URL;

public class TracePathTask implements Task<String> {

    /* renamed from: a */
    private static final String f31932a = "OND_TraceRouteTask";

    /* renamed from: b */
    private Context f31933b;

    /* renamed from: c */
    private int f31934c;

    /* renamed from: d */
    private Command.OutPutHandler<String> f31935d;

    public TracePathTask(Context context) {
        this.f31933b = context;
    }

    public TracePathTask(Context context, Command.OutPutHandler<String> outPutHandler) {
        this.f31933b = context;
        this.f31935d = outPutHandler;
    }

    public String doTask(DetectionItem detectionItem) {
        if (TextUtils.isEmpty(detectionItem.url)) {
            return null;
        }
        TracePathCommand.Builder builder = new TracePathCommand.Builder();
        try {
            builder.setHost(NetUtil.isIpAddress(detectionItem.url) ? detectionItem.url : new URL(detectionItem.url).getHost()).setMaxTTL(this.f31934c);
            TracePathCommand build = builder.build(this.f31933b);
            build.setOutPutHandler(this.f31935d);
            build.execute();
            String str = build.getNormalOutput() + "\r\n" + build.getErrorOutput();
            if (this.f31935d != null) {
                this.f31935d.handleResult(str);
            }
            ONDLog.m24359d(f31932a, str);
            return str;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setMaxTTL(int i) {
        this.f31934c = i;
    }
}
