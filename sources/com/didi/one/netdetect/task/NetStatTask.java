package com.didi.one.netdetect.task;

import android.content.Context;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.NetstatCommand;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.ONDLog;

public class NetStatTask implements Task<String> {

    /* renamed from: a */
    private static final String f31923a = "OND_NetStatTask";

    /* renamed from: b */
    private Context f31924b;

    /* renamed from: c */
    private Command.OutPutHandler<String> f31925c;

    public NetStatTask(Context context) {
        this.f31924b = context;
    }

    public NetStatTask(Context context, Command.OutPutHandler<String> outPutHandler) {
        this.f31924b = context;
        this.f31925c = outPutHandler;
    }

    public String doTask(DetectionItem detectionItem) {
        NetstatCommand build = new NetstatCommand.Builder().setRoutingTable(false).build(this.f31924b);
        build.setOutPutHandler(this.f31925c);
        build.execute();
        String str = build.getNormalOutput() + "\r\n" + build.getErrorOutput();
        Command.OutPutHandler<String> outPutHandler = this.f31925c;
        if (outPutHandler != null) {
            outPutHandler.handleResult(str);
        }
        ONDLog.m24359d(f31923a, str);
        return str;
    }
}
