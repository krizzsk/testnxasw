package com.didi.drouter.remote;

import android.os.RemoteException;
import com.didi.drouter.remote.IClientService;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.drouter.utils.RouterLogger;

class RemoteDispatcher$2 implements RouterCallback {
    final /* synthetic */ C8523a this$0;
    final /* synthetic */ RemoteCommand val$command;

    RemoteDispatcher$2(C8523a aVar, RemoteCommand remoteCommand) {
        this.this$0 = aVar;
        this.val$command = remoteCommand;
    }

    public void onResult(Result result) {
        if (this.val$command.f21017i != null) {
            RouterLogger.getCoreLogger().mo63950d("[Service] command \"%s\" result start callback", this.val$command);
            RemoteCommand remoteCommand = new RemoteCommand(1);
            remoteCommand.f21018j = result.isActivityStarted();
            remoteCommand.f21019k = result.getRouterSize();
            remoteCommand.f21020l = result.getExtra();
            remoteCommand.f21021m = result.getAddition();
            try {
                IClientService.Stub.asInterface(this.val$command.f21017i).callback(remoteCommand);
            } catch (RemoteException e) {
                RouterLogger.getCoreLogger().mo63951e("[Service] command \"%s\" callback Exception %s", this.val$command, e);
            }
        }
    }
}
