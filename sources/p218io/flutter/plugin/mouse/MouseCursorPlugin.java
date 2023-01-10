package p218io.flutter.plugin.mouse;

import android.view.PointerIcon;
import java.util.HashMap;
import p218io.flutter.embedding.engine.systemchannels.MouseCursorChannel;

/* renamed from: io.flutter.plugin.mouse.MouseCursorPlugin */
public class MouseCursorPlugin {

    /* renamed from: c */
    private static HashMap<String, Integer> f60612c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final MouseCursorViewDelegate f60613a;

    /* renamed from: b */
    private final MouseCursorChannel f60614b;

    /* renamed from: io.flutter.plugin.mouse.MouseCursorPlugin$MouseCursorViewDelegate */
    public interface MouseCursorViewDelegate {
        PointerIcon getSystemPointerIcon(int i);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public MouseCursorPlugin(MouseCursorViewDelegate mouseCursorViewDelegate, MouseCursorChannel mouseCursorChannel) {
        this.f60613a = mouseCursorViewDelegate;
        this.f60614b = mouseCursorChannel;
        mouseCursorChannel.setMethodHandler(new MouseCursorChannel.MouseCursorMethodHandler() {
            public void activateSystemCursor(String str) {
                MouseCursorPlugin.this.f60613a.setPointerIcon(MouseCursorPlugin.this.m45703a(str));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public PointerIcon m45703a(String str) {
        if (f60612c == null) {
            f60612c = new HashMap<String, Integer>() {
                private static final long serialVersionUID = 1;

                {
                    put("alias", 1010);
                    put("allScroll", 1013);
                    put("basic", 1000);
                    put("cell", 1006);
                    put("click", 1002);
                    put("contextMenu", 1001);
                    put("copy", 1011);
                    put("forbidden", 1012);
                    put("grab", 1020);
                    put("grabbing", 1021);
                    put("help", 1003);
                    put("move", 1013);
                    put("none", 0);
                    put("noDrop", 1012);
                    put("precise", 1007);
                    put("text", 1008);
                    put("resizeColumn", 1014);
                    put("resizeDown", 1015);
                    put("resizeUpLeft", 1016);
                    put("resizeDownRight", 1017);
                    put("resizeLeft", 1014);
                    put("resizeLeftRight", 1014);
                    put("resizeRight", 1014);
                    put("resizeRow", 1015);
                    put("resizeUp", 1015);
                    put("resizeUpDown", 1015);
                    put("resizeUpLeft", 1017);
                    put("resizeUpRight", 1016);
                    put("resizeUpLeftDownRight", 1017);
                    put("resizeUpRightDownLeft", 1016);
                    put("verticalText", 1009);
                    put("wait", 1004);
                    put("zoomIn", 1018);
                    put("zoomOut", 1019);
                }
            };
        }
        return this.f60613a.getSystemPointerIcon(f60612c.getOrDefault(str, 1000).intValue());
    }

    public void destroy() {
        this.f60614b.setMethodHandler((MouseCursorChannel.MouseCursorMethodHandler) null);
    }
}
