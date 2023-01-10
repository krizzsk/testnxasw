package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.utils.TrackLog;

class ScheduleController {

    /* renamed from: a */
    private static final String f46562a = "TrackSchedule";

    /* renamed from: b */
    private ISchedule f46563b;

    interface ISchedule {
        int getGatherScheduleSeconds();

        int getUploadScheduleSeconds();

        void removeGatherSchedule();

        void removeUploadSchedule();

        void requestGatherSchedule(OnScheduleListener onScheduleListener, int i);

        void requestUploadSchedule(OnScheduleListener onScheduleListener, int i);
    }

    interface OnScheduleListener {
        void onBaseClockSchedule(long j);

        void onEventSchedule(long j, TrackLocationInfo trackLocationInfo);
    }

    private ScheduleController() {
        if (TrackController.getIntance().getInitParams().isDirectUploadModeEnabled()) {
            this.f46563b = new C15090a();
        } else {
            this.f46563b = new ScheduleNormalImpl();
        }
    }

    private static class SingletonHolder {
        static ScheduleController INSTANCE = new ScheduleController();

        private SingletonHolder() {
        }
    }

    /* renamed from: a */
    static ScheduleController m34730a() {
        return SingletonHolder.INSTANCE;
    }

    static class OnScheduleListenerWrapper {
        int intervalSeconds;
        OnScheduleListener listener;

        OnScheduleListenerWrapper(OnScheduleListener onScheduleListener, int i) {
            this.listener = onScheduleListener;
            this.intervalSeconds = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo115914b() {
        if (!CoreThread.ensureCoreThread()) {
            return -1;
        }
        return this.f46563b.getGatherScheduleSeconds();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115913a(OnScheduleListener onScheduleListener, int i) {
        TrackLog.m34830d(f46562a, "requestGatherSchedule interval=" + i);
        if (CoreThread.ensureCoreThread()) {
            this.f46563b.requestGatherSchedule(onScheduleListener, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo115916c() {
        TrackLog.m34830d(f46562a, "removeGatherSchedule");
        if (CoreThread.ensureCoreThread()) {
            this.f46563b.removeGatherSchedule();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo115917d() {
        if (!CoreThread.ensureCoreThread()) {
            return -1;
        }
        return this.f46563b.getUploadScheduleSeconds();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo115915b(OnScheduleListener onScheduleListener, int i) {
        TrackLog.m34830d(f46562a, "requestUploadSchedule interval=" + i);
        if (CoreThread.ensureCoreThread()) {
            this.f46563b.requestUploadSchedule(onScheduleListener, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo115918e() {
        TrackLog.m34830d(f46562a, "removeUploadSchedule");
        if (CoreThread.ensureCoreThread()) {
            this.f46563b.removeUploadSchedule();
        }
    }
}
