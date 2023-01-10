package com.didi.dimina.starbox.extend;

import com.didi.dimina.container.util.LogUtil;
import java.util.LinkedList;
import java.util.List;

public class ExtendEventManager {

    /* renamed from: a */
    private final List<ExtendEvent> f19868a;

    private ExtendEventManager() {
        this.f19868a = new LinkedList();
    }

    private static class ExtendEventManagerHolder {
        /* access modifiers changed from: private */
        public static final ExtendEventManager sExtendEventManager = new ExtendEventManager();

        private ExtendEventManagerHolder() {
        }
    }

    public static ExtendEventManager getExtendEventManager() {
        return ExtendEventManagerHolder.sExtendEventManager;
    }

    public List<ExtendEvent> getExtendEventList() {
        return this.f19868a;
    }

    public void registerExtendEvent(ExtendEvent extendEvent) {
        LogUtil.m16841i("ExtendEventManager -> registerExtendEvent: " + extendEvent.getEventType());
        this.f19868a.add(extendEvent);
    }

    public void unregisterExtendEvent(ExtendEvent extendEvent) {
        LogUtil.m16841i("ExtendEventManager -> unregisterExtendEvent: " + extendEvent.getEventType());
        this.f19868a.remove(extendEvent);
    }
}
