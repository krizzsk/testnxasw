package com.didi.drouter.remote;

class RemoteDispatcher$1 implements Runnable {
    final /* synthetic */ C8523a this$0;
    final /* synthetic */ RemoteCommand val$command;

    RemoteDispatcher$1(C8523a aVar, RemoteCommand remoteCommand) {
        this.this$0 = aVar;
        this.val$command = remoteCommand;
    }

    public void run() {
        this.this$0.m17778b(this.val$command);
    }
}
