package com.didi.beatles.p101im.access;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.access.IMRecorderProtocol */
public class IMRecorderProtocol implements IIMRecorder {
    public static final int LEVEL_ACTIVE_BACKGROUND = 2;
    public static final int LEVEL_ACTIVE_FORGROUND = 1;
    public static final int LEVEL_BACKGROUND = 3;

    /* renamed from: a */
    private static final String f10546a = "IMRecorderProtocol";

    /* renamed from: b */
    private static final String f10547b = "request_use_reorder";

    /* renamed from: c */
    private static final String f10548c = "release_reorder";

    /* renamed from: d */
    private static volatile IIMRecorder f10549d = null;

    /* renamed from: f */
    private static int f10550f = -1;

    /* renamed from: e */
    private List<IIMRecorderProtocolHandler> f10551e = new ArrayList();

    /* renamed from: com.didi.beatles.im.access.IMRecorderProtocol$IIMRecorderProtocolHandler */
    public interface IIMRecorderProtocolHandler {
        int getLevel();

        void onRecorderAcquired();

        void onRecorderReleased(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.access.IMRecorderProtocol$IMRecorderLevel */
    public @interface IMRecorderLevel {
    }

    private IMRecorderProtocol() {
    }

    public static IIMRecorder getInstance() {
        IIMRecorder iIMRecorder;
        if (f10549d != null) {
            return f10549d;
        }
        synchronized (IMRecorderProtocol.class) {
            if (f10549d == null) {
                f10549d = new IMRecorderProtocol();
            }
            iIMRecorder = f10549d;
        }
        return iIMRecorder;
    }

    public void requireRecorder(int i) {
        f10550f = i;
        m9210a(f10547b, i);
    }

    public void releaseRecorder(int i) {
        if (f10550f == i) {
            f10550f = -1;
        }
        m9210a(f10548c, i);
    }

    public void registerRecorderProtocolHandler(IIMRecorderProtocolHandler iIMRecorderProtocolHandler) {
        this.f10551e.add(iIMRecorderProtocolHandler);
    }

    public void unRegisterRecorderProtocolHandler(IIMRecorderProtocolHandler iIMRecorderProtocolHandler) {
        this.f10551e.remove(iIMRecorderProtocolHandler);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9210a(java.lang.String r4, int r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "action "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = " "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.didi.beatles.p101im.utils.IMLog.m10019d(r0)
            int r0 = r4.hashCode()
            r1 = -992655213(0xffffffffc4d54893, float:-1706.268)
            r2 = 1
            if (r0 == r1) goto L_0x0036
            r1 = 1022965955(0x3cf938c3, float:0.030422574)
            if (r0 == r1) goto L_0x002c
            goto L_0x0040
        L_0x002c:
            java.lang.String r0 = "release_reorder"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0040
            r4 = 0
            goto L_0x0041
        L_0x0036:
            java.lang.String r0 = "request_use_reorder"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0040
            r4 = 1
            goto L_0x0041
        L_0x0040:
            r4 = -1
        L_0x0041:
            if (r4 == 0) goto L_0x0062
            if (r4 == r2) goto L_0x0046
            goto L_0x0078
        L_0x0046:
            java.util.List<com.didi.beatles.im.access.IMRecorderProtocol$IIMRecorderProtocolHandler> r4 = r3.f10551e
            java.util.Iterator r4 = r4.iterator()
        L_0x004c:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r4.next()
            com.didi.beatles.im.access.IMRecorderProtocol$IIMRecorderProtocolHandler r0 = (com.didi.beatles.p101im.access.IMRecorderProtocol.IIMRecorderProtocolHandler) r0
            int r1 = r0.getLevel()
            if (r1 < r5) goto L_0x004c
            r0.onRecorderAcquired()
            goto L_0x004c
        L_0x0062:
            java.util.List<com.didi.beatles.im.access.IMRecorderProtocol$IIMRecorderProtocolHandler> r4 = r3.f10551e
            java.util.Iterator r4 = r4.iterator()
        L_0x0068:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r4.next()
            com.didi.beatles.im.access.IMRecorderProtocol$IIMRecorderProtocolHandler r0 = (com.didi.beatles.p101im.access.IMRecorderProtocol.IIMRecorderProtocolHandler) r0
            r0.onRecorderReleased(r5)
            goto L_0x0068
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.access.IMRecorderProtocol.m9210a(java.lang.String, int):void");
    }

    public static boolean isCurrentUse() {
        return f10550f >= 1;
    }
}
