package p218io.flutter.plugins.sharedpreferences;

import android.content.SharedPreferences;
import p218io.flutter.plugin.common.MethodChannel;

/* renamed from: io.flutter.plugins.sharedpreferences.MethodCallHandlerImpl$1 */
class MethodCallHandlerImpl$1 implements Runnable {
    final /* synthetic */ C22166a this$0;
    final /* synthetic */ SharedPreferences.Editor val$editor;
    final /* synthetic */ MethodChannel.Result val$result;

    MethodCallHandlerImpl$1(C22166a aVar, SharedPreferences.Editor editor, MethodChannel.Result result) {
        this.this$0 = aVar;
        this.val$editor = editor;
        this.val$result = result;
    }

    public void run() {
        final boolean commit = this.val$editor.commit();
        this.this$0.f60676g.post(new Runnable() {
            public void run() {
                MethodCallHandlerImpl$1.this.val$result.success(Boolean.valueOf(commit));
            }
        });
    }
}
