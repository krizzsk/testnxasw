package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.core.ScheduleController;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.location.TrackLocationListener;

/* renamed from: com.didi.trackupload.sdk.core.a */
/* compiled from: ScheduleDirectUploadImpl */
class C15090a implements ScheduleController.ISchedule {

    /* renamed from: a */
    private ScheduleController.OnScheduleListenerWrapper f46617a;

    /* renamed from: b */
    private ScheduleController.OnScheduleListenerWrapper f46618b;

    /* renamed from: c */
    private long f46619c = -1;

    /* renamed from: d */
    private long f46620d = -1;

    /* renamed from: e */
    private TrackLocationListener f46621e = new ScheduleDirectUploadImpl$1(this);

    /* renamed from: f */
    private TrackLocationListener f46622f = new ScheduleDirectUploadImpl$2(this);

    C15090a() {
    }

    public int getGatherScheduleSeconds() {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f46617a;
        if (onScheduleListenerWrapper != null) {
            return onScheduleListenerWrapper.intervalSeconds;
        }
        return -1;
    }

    public void requestGatherSchedule(ScheduleController.OnScheduleListener onScheduleListener, int i) {
        if (onScheduleListener != null && i > 0) {
            this.f46617a = new ScheduleController.OnScheduleListenerWrapper(onScheduleListener, i);
            m34784a();
        }
    }

    public void removeGatherSchedule() {
        this.f46617a = null;
        this.f46619c = -1;
        m34784a();
    }

    public int getUploadScheduleSeconds() {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f46618b;
        if (onScheduleListenerWrapper != null) {
            return onScheduleListenerWrapper.intervalSeconds;
        }
        return -1;
    }

    public void requestUploadSchedule(ScheduleController.OnScheduleListener onScheduleListener, int i) {
        if (onScheduleListener != null && i > 0) {
            this.f46618b = new ScheduleController.OnScheduleListenerWrapper(onScheduleListener, i);
            m34784a();
        }
    }

    public void removeUploadSchedule() {
        this.f46618b = null;
        this.f46620d = -1;
        m34784a();
        m34788b(LocationCenter.getIntance().getLastEffectiveLocation());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34786a(TrackLocationInfo trackLocationInfo) {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper;
        long gatherScheduleSeconds = (long) getGatherScheduleSeconds();
        if (gatherScheduleSeconds > 0) {
            long j = this.f46619c;
            if (j == -1) {
                this.f46619c = 0;
            } else {
                this.f46619c = ((j / gatherScheduleSeconds) + 1) * gatherScheduleSeconds;
            }
            if (trackLocationInfo != null && (onScheduleListenerWrapper = this.f46617a) != null && this.f46619c % ((long) onScheduleListenerWrapper.intervalSeconds) == 0) {
                this.f46617a.listener.onEventSchedule(this.f46619c, trackLocationInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34788b(TrackLocationInfo trackLocationInfo) {
        long uploadScheduleSeconds = (long) getUploadScheduleSeconds();
        if (uploadScheduleSeconds > 0) {
            long j = this.f46620d;
            if (j == -1) {
                this.f46620d = 0;
            } else {
                this.f46620d = ((j / uploadScheduleSeconds) + 1) * uploadScheduleSeconds;
            }
            if (trackLocationInfo != null) {
                long j2 = this.f46620d;
                ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f46618b;
                if (onScheduleListenerWrapper != null && j2 % ((long) onScheduleListenerWrapper.intervalSeconds) == 0) {
                    this.f46618b.listener.onEventSchedule(j2, trackLocationInfo);
                }
                ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper2 = this.f46618b;
                if (onScheduleListenerWrapper2 != null) {
                    onScheduleListenerWrapper2.listener.onBaseClockSchedule(j2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m34784a() {
        int gatherScheduleSeconds = getGatherScheduleSeconds() * 1000;
        int uploadScheduleSeconds = getUploadScheduleSeconds() * 1000;
        if (gatherScheduleSeconds > 0) {
            long j = (long) gatherScheduleSeconds;
            if (j != LocationCenter.getIntance().getNormalLocationUpdateIntervalMillis()) {
                LocationCenter.getIntance().requestNormalLocationUpdates(this.f46621e, j);
            }
        } else {
            LocationCenter.getIntance().removeNormalLocationUpdates();
        }
        if (uploadScheduleSeconds > 0) {
            long j2 = (long) uploadScheduleSeconds;
            if (j2 != LocationCenter.getIntance().getDirectNotifyLocationUpdateIntervalMillis()) {
                LocationCenter.getIntance().requestDirectNotifyLocationUpdates(this.f46622f, j2);
                return;
            }
            return;
        }
        LocationCenter.getIntance().removeDirectNotifyLocationUpdates();
    }
}
