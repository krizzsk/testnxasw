package com.didi.aoe.library.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.interpreter.InterpreterInitResult;
import com.didi.aoe.library.core.service.IAoeProcessService;
import com.didi.aoe.library.logging.Logger;
import java.util.List;

class RemoteProcessorWrapper$1 implements ServiceConnection {
    final /* synthetic */ C4161g this$0;

    RemoteProcessorWrapper$1(C4161g gVar) {
        this.this$0 = gVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Logger b = this.this$0.f10033b;
        b.debug("onServiceConnected: " + this.this$0.f10037f, new Object[0]);
        this.this$0.f10036e.set(true);
        IAoeProcessService unused = this.this$0.f10039h = IAoeProcessService.Stub.asInterface(iBinder);
        if (2 == this.this$0.f10041j) {
            C4161g gVar = this.this$0;
            InterpreterInitResult a = gVar.m8705a(gVar.f10037f, (List<AoeModelOption>) this.this$0.f10038g);
            if (this.this$0.f10040i != null) {
                this.this$0.f10040i.onInitResult(a);
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.this$0.f10033b.debug("onServiceDisconnected", new Object[0]);
        this.this$0.f10036e.set(false);
        IAoeProcessService unused = this.this$0.f10039h = null;
    }
}
