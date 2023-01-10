package p218io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import p218io.flutter.embedding.android.KeyboardManager;
import p218io.flutter.embedding.engine.systemchannels.KeyEventChannel;

/* renamed from: io.flutter.embedding.android.KeyChannelResponder */
public class KeyChannelResponder implements KeyboardManager.Responder {

    /* renamed from: a */
    private static final String f60312a = "KeyChannelResponder";

    /* renamed from: b */
    private final KeyEventChannel f60313b;

    /* renamed from: c */
    private int f60314c;

    public KeyChannelResponder(KeyEventChannel keyEventChannel) {
        this.f60313b = keyEventChannel;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Character mo182094a(int i) {
        char c = (char) i;
        if ((Integer.MIN_VALUE & i) != 0) {
            int i2 = i & Integer.MAX_VALUE;
            int i3 = this.f60314c;
            if (i3 != 0) {
                this.f60314c = KeyCharacterMap.getDeadChar(i3, i2);
            } else {
                this.f60314c = i2;
            }
        } else {
            int i4 = this.f60314c;
            if (i4 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i4, i);
                if (deadChar > 0) {
                    c = (char) deadChar;
                }
                this.f60314c = 0;
            }
        }
        return Character.valueOf(c);
    }

    public void handleEvent(KeyEvent keyEvent, KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        int action = keyEvent.getAction();
        boolean z = false;
        if (action == 0 || action == 1) {
            KeyEventChannel.FlutterKeyEvent flutterKeyEvent = new KeyEventChannel.FlutterKeyEvent(keyEvent, mo182094a(keyEvent.getUnicodeChar()));
            if (action != 0) {
                z = true;
            }
            this.f60313b.sendFlutterKeyEvent(flutterKeyEvent, z, new KeyEventChannel.EventResponseHandler() {
                public final void onFrameworkResponse(boolean z) {
                    KeyboardManager.Responder.OnKeyEventHandledCallback.this.onKeyEventHandled(Boolean.valueOf(z));
                }
            });
            return;
        }
        onKeyEventHandledCallback.onKeyEventHandled(false);
    }
}
