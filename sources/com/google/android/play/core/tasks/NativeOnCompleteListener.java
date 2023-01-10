package com.google.android.play.core.tasks;

public class NativeOnCompleteListener implements OnCompleteListener<Object> {

    /* renamed from: a */
    private final long f56348a;

    /* renamed from: b */
    private final int f56349b;

    public NativeOnCompleteListener(long j, int i) {
        this.f56348a = j;
        this.f56349b = i;
    }

    public native void nativeOnComplete(long j, int i, Object obj, int i2);

    public void onComplete(Task<Object> task) {
        if (!task.isComplete()) {
            int i = this.f56349b;
            StringBuilder sb = new StringBuilder(50);
            sb.append("onComplete called for incomplete task: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        } else if (task.isSuccessful()) {
            nativeOnComplete(this.f56348a, this.f56349b, task.getResult(), 0);
        } else {
            Exception exception = task.getException();
            if (!(exception instanceof C20238j)) {
                nativeOnComplete(this.f56348a, this.f56349b, (Object) null, -100);
                return;
            }
            int errorCode = ((C20238j) exception).getErrorCode();
            if (errorCode != 0) {
                nativeOnComplete(this.f56348a, this.f56349b, (Object) null, errorCode);
                return;
            }
            int i2 = this.f56349b;
            StringBuilder sb2 = new StringBuilder(51);
            sb2.append("TaskException has error code 0 on task: ");
            sb2.append(i2);
            throw new IllegalStateException(sb2.toString());
        }
    }
}
