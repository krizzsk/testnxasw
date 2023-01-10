package p218io.flutter.embedding.android;

import android.view.KeyEvent;
import android.view.View;
import java.util.HashSet;
import p218io.flutter.Log;
import p218io.flutter.plugin.editing.TextInputPlugin;

/* renamed from: io.flutter.embedding.android.KeyboardManager */
public class KeyboardManager {

    /* renamed from: a */
    private static final String f60315a = "KeyboardManager";

    /* renamed from: b */
    private final HashSet<KeyEvent> f60316b = new HashSet<>();

    /* renamed from: c */
    private final TextInputPlugin f60317c;

    /* renamed from: d */
    private final View f60318d;
    protected final Responder[] responders;

    /* renamed from: io.flutter.embedding.android.KeyboardManager$Responder */
    interface Responder {

        /* renamed from: io.flutter.embedding.android.KeyboardManager$Responder$OnKeyEventHandledCallback */
        public interface OnKeyEventHandledCallback {
            void onKeyEventHandled(Boolean bool);
        }

        void handleEvent(KeyEvent keyEvent, OnKeyEventHandledCallback onKeyEventHandledCallback);
    }

    public KeyboardManager(View view, TextInputPlugin textInputPlugin, Responder[] responderArr) {
        this.f60318d = view;
        this.f60317c = textInputPlugin;
        this.responders = responderArr;
    }

    /* renamed from: io.flutter.embedding.android.KeyboardManager$PerEventCallbackBuilder */
    private class PerEventCallbackBuilder {
        boolean isEventHandled = false;
        final KeyEvent keyEvent;
        int unrepliedCount = KeyboardManager.this.responders.length;

        /* renamed from: io.flutter.embedding.android.KeyboardManager$PerEventCallbackBuilder$Callback */
        private class Callback implements Responder.OnKeyEventHandledCallback {
            boolean isCalled;

            private Callback() {
                this.isCalled = false;
            }

            public void onKeyEventHandled(Boolean bool) {
                if (!this.isCalled) {
                    this.isCalled = true;
                    PerEventCallbackBuilder.this.unrepliedCount--;
                    PerEventCallbackBuilder perEventCallbackBuilder = PerEventCallbackBuilder.this;
                    perEventCallbackBuilder.isEventHandled = bool.booleanValue() | perEventCallbackBuilder.isEventHandled;
                    if (PerEventCallbackBuilder.this.unrepliedCount == 0 && !PerEventCallbackBuilder.this.isEventHandled) {
                        KeyboardManager.this.m45528a(PerEventCallbackBuilder.this.keyEvent);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
            }
        }

        PerEventCallbackBuilder(KeyEvent keyEvent2) {
            this.keyEvent = keyEvent2;
        }

        public Responder.OnKeyEventHandledCallback buildCallback() {
            return new Callback();
        }
    }

    public boolean handleEvent(KeyEvent keyEvent) {
        if (this.f60316b.remove(keyEvent)) {
            return false;
        }
        if (this.responders.length > 0) {
            PerEventCallbackBuilder perEventCallbackBuilder = new PerEventCallbackBuilder(keyEvent);
            for (Responder handleEvent : this.responders) {
                handleEvent.handleEvent(keyEvent, perEventCallbackBuilder.buildCallback());
            }
            return true;
        }
        m45528a(keyEvent);
        return true;
    }

    public void destroy() {
        int size = this.f60316b.size();
        if (size > 0) {
            Log.m45261w(f60315a, "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45528a(KeyEvent keyEvent) {
        if (!this.f60317c.handleKeyEvent(keyEvent) && this.f60318d != null) {
            this.f60316b.add(keyEvent);
            this.f60318d.getRootView().dispatchKeyEvent(keyEvent);
            if (this.f60316b.remove(keyEvent)) {
                Log.m45261w(f60315a, "A redispatched key event was consumed before reaching KeyboardManager");
            }
        }
    }
}
