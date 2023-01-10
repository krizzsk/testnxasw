package com.didi.one.netdetect.task;

import android.content.Context;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.IfconfigCommand;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.ONDLog;

public class IfconfigTask implements Task<String> {

    /* renamed from: a */
    private static final String f31920a = "OND_IfconfigTask";

    /* renamed from: b */
    private Context f31921b;

    /* renamed from: c */
    private Command.OutPutHandler<String> f31922c;

    public IfconfigTask(Context context) {
        this.f31921b = context;
    }

    public IfconfigTask(Context context, Command.OutPutHandler<String> outPutHandler) {
        this.f31921b = context;
        this.f31922c = outPutHandler;
    }

    public String doTask(DetectionItem detectionItem) {
        IfconfigCommand build = new IfconfigCommand.Builder().build(this.f31921b);
        build.setOutPutHandler(this.f31922c);
        build.execute();
        String str = build.getNormalOutput() + "\r\n" + build.getErrorOutput();
        Command.OutPutHandler<String> outPutHandler = this.f31922c;
        if (outPutHandler != null) {
            outPutHandler.handleResult(str);
        }
        ONDLog.m24359d(f31920a, str);
        return str;
    }
}
