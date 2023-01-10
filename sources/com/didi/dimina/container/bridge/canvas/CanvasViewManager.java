package com.didi.dimina.container.bridge.canvas;

import com.didi.dimina.container.p065ui.canvas.CanvasView;
import com.didi.dimina.container.util.LogUtil;
import java.util.concurrent.ConcurrentHashMap;

public class CanvasViewManager {

    /* renamed from: a */
    private final ConcurrentHashMap<String, CanvasView> f18597a;

    private CanvasViewManager() {
        this.f18597a = new ConcurrentHashMap<>();
    }

    private static class CanvasViewManagerHolder {
        /* access modifiers changed from: private */
        public static final CanvasViewManager mCanvasViewManager = new CanvasViewManager();

        private CanvasViewManagerHolder() {
        }
    }

    public static CanvasViewManager getCanvasViewManager() {
        return CanvasViewManagerHolder.mCanvasViewManager;
    }

    public void createCanvasView(String str, CanvasView canvasView) {
        LogUtil.m16841i("CanvasViewManager createCanvasView: canvasId => " + str + ", CanvasView => " + canvasView);
        this.f18597a.put(str, canvasView);
    }

    public CanvasView getCanvasView(String str) {
        LogUtil.m16841i("CanvasViewManager getCanvasView");
        return this.f18597a.get(str);
    }

    public void clearCanvasView(String str) {
        LogUtil.m16841i("CanvasViewManager clearCanvasView");
        this.f18597a.remove(str);
    }
}
