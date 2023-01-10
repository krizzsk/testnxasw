package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.IMirrorCallback;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import java.util.List;

/* renamed from: com.didichuxing.sdk.alphaface.core.liveness.c */
/* compiled from: CallbackWrapper */
final class C17138c implements ILivenessCallback {

    /* renamed from: a */
    final ILivenessCallback f51296a;

    /* renamed from: b */
    final LivenessManager f51297b;

    /* renamed from: c */
    private final int f51298c;

    /* renamed from: d */
    private final int f51299d;

    /* renamed from: e */
    private int f51300e = -1;

    /* renamed from: f */
    private int f51301f = 0;

    /* renamed from: g */
    private final int f51302g;

    /* renamed from: h */
    private int f51303h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final LivenessResult f51304i;

    public C17138c(LivenessManager livenessManager) {
        this.f51297b = livenessManager;
        this.f51296a = livenessManager.mo127139b().getCallback();
        this.f51298c = livenessManager.mo127139b().getDetectTime();
        this.f51299d = livenessManager.mo127139b().getFaceErrorCountMax();
        this.f51302g = livenessManager.mo127139b().getActionTimeout();
        this.f51304i = new LivenessResult();
    }

    public void onFaceError(int i) {
        UIHandler.post(new CallbackWrapper$1(this, i));
    }

    public void onStartAction(int[] iArr) {
        UIHandler.post(new CallbackWrapper$2(this, iArr));
    }

    public void onDetectFace(IMirrorCallback.FaceInfo faceInfo) {
        UIHandler.post(new CallbackWrapper$3(this, faceInfo));
    }

    public void onMirrorSuccess(List<ILivenessCallback.PicWithScore> list, List<ILivenessCallback.PicWithScore> list2, List<ILivenessCallback.PicWithScore> list3) {
        this.f51304i.mo127150a(list, list2, list3);
        UIHandler.post(new CallbackWrapper$4(this, list, list2, list3));
    }

    public void onMirrorFaceQualityError() {
        UIHandler.post(new CallbackWrapper$5(this));
    }

    public void onMirrorProcess(long j) {
        UIHandler.post(new CallbackWrapper$6(this, (int) ((j * 100) / ((long) this.f51298c))));
    }

    public void onMirrorReset() {
        this.f51304i.mo127148a();
        UIHandler.post(new CallbackWrapper$7(this));
    }

    public void onActionReset() {
        UIHandler.post(new CallbackWrapper$8(this));
    }

    public void onActionCountdown(int i) {
        UIHandler.post(new CallbackWrapper$9(this, i));
    }

    public void onActionTimeout() {
        this.f51297b.exit();
        UIHandler.post(new CallbackWrapper$10(this));
    }

    public void onActionChange(int i, int i2, int i3, int i4) {
        UIHandler.post(new CallbackWrapper$11(this, i, i2, i3, i4));
    }

    public void onActionSuccess(List<ILivenessCallback.PicWithScore> list) {
        this.f51304i.mo127149a(list);
        this.f51297b.exit();
        UIHandler.post(new CallbackWrapper$12(this, list));
    }

    public void onActionInfo(int i, int i2, int i3, int[] iArr) {
        UIHandler.post(new CallbackWrapper$13(this, i, i2, i3, iArr));
    }

    public void onActionTip(int i) {
        if (i != this.f51303h) {
            this.f51303h = i;
            UIHandler.post(new CallbackWrapper$14(this, i));
        }
    }

    public void onActionFailed() {
        this.f51297b.exit();
        UIHandler.post(new CallbackWrapper$15(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127163a(int i) {
        if (this.f51300e == i) {
            onFaceError(i);
        } else {
            this.f51300e = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo127164b(int i) {
        int i2 = this.f51301f;
        if (i2 == this.f51299d) {
            this.f51301f = 0;
            this.f51297b.reset();
            onFaceError(i);
            return;
        }
        this.f51301f = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo127165c(int i) {
        int i2 = this.f51301f;
        if (i2 == this.f51299d) {
            this.f51301f = 0;
            onFaceError(i);
            return;
        }
        this.f51301f = i2 + 1;
    }

    public void onSuccess(LivenessResult livenessResult) {
        UIHandler.post(new CallbackWrapper$16(this, livenessResult));
    }

    public void onRestart() {
        UIHandler.post(new CallbackWrapper$17(this));
    }
}
