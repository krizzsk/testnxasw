package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.core.ScheduleController;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.location.TrackLocationListener;
import com.didi.trackupload.sdk.utils.LogStringUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.Timer;
import java.util.TimerTask;

class ScheduleNormalImpl implements ScheduleController.ISchedule {

    /* renamed from: a */
    private static final int f46564a = 1000;

    /* renamed from: b */
    private ScheduleController.OnScheduleListenerWrapper f46565b;

    /* renamed from: c */
    private ScheduleController.OnScheduleListenerWrapper f46566c;

    /* renamed from: d */
    private Timer f46567d;

    /* renamed from: e */
    private BaseClockTask f46568e;

    /* renamed from: f */
    private long f46569f = 0;

    /* renamed from: g */
    private long f46570g = -1;

    /* renamed from: h */
    private TrackLocationListener f46571h = new TrackLocationListener() {
        public void onLocationChanged(final TrackLocationInfo trackLocationInfo) {
            TrackLog.m34830d(LocationCenter.TAG, "onNormalLoc " + LogStringUtils.parseLocationInfo(trackLocationInfo));
            CoreThread.post(new Runnable() {
                public void run() {
                    ScheduleNormalImpl.this.m34740a(trackLocationInfo);
                }
            });
        }

        public void onLocationError(int i, String str) {
            TrackLog.m34830d(LocationCenter.TAG, "onNormalLocError errCode=" + i + " errMsg=" + str);
            CoreThread.post(new Runnable() {
                public void run() {
                    ScheduleNormalImpl.this.m34740a((TrackLocationInfo) null);
                }
            });
        }
    };

    ScheduleNormalImpl() {
    }

    public int getGatherScheduleSeconds() {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f46565b;
        if (onScheduleListenerWrapper != null) {
            return onScheduleListenerWrapper.intervalSeconds;
        }
        return -1;
    }

    public void requestGatherSchedule(ScheduleController.OnScheduleListener onScheduleListener, int i) {
        if (onScheduleListener != null && i > 0) {
            this.f46565b = new ScheduleController.OnScheduleListenerWrapper(onScheduleListener, i);
            m34737a();
            m34743d();
        }
    }

    public void removeGatherSchedule() {
        this.f46565b = null;
        this.f46570g = -1;
        m34741b();
        m34743d();
    }

    public int getUploadScheduleSeconds() {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f46566c;
        if (onScheduleListenerWrapper != null) {
            return onScheduleListenerWrapper.intervalSeconds;
        }
        return -1;
    }

    public void requestUploadSchedule(ScheduleController.OnScheduleListener onScheduleListener, int i) {
        if (onScheduleListener != null && i > 0) {
            this.f46566c = new ScheduleController.OnScheduleListenerWrapper(onScheduleListener, i);
            m34737a();
            m34743d();
        }
    }

    public void removeUploadSchedule() {
        this.f46566c = null;
        m34741b();
        m34743d();
    }

    private class BaseClockTask extends TimerTask {
        private BaseClockTask() {
        }

        public void run() {
            CoreThread.post(new Runnable() {
                public void run() {
                    ScheduleNormalImpl.this.m34742c();
                }
            });
        }
    }

    /* renamed from: a */
    private void m34737a() {
        if (!(this.f46565b == null && this.f46566c == null) && this.f46567d == null && this.f46568e == null) {
            this.f46569f = 0;
            this.f46567d = new Timer();
            BaseClockTask baseClockTask = new BaseClockTask();
            this.f46568e = baseClockTask;
            this.f46567d.schedule(baseClockTask, 0, 1000);
        }
    }

    /* renamed from: b */
    private void m34741b() {
        BaseClockTask baseClockTask;
        if (this.f46565b == null && this.f46566c == null && this.f46567d != null && (baseClockTask = this.f46568e) != null) {
            baseClockTask.cancel();
            this.f46567d.cancel();
            this.f46569f = 0;
            this.f46568e = null;
            this.f46567d = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34740a(TrackLocationInfo trackLocationInfo) {
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper;
        long gatherScheduleSeconds = (long) getGatherScheduleSeconds();
        if (gatherScheduleSeconds > 0) {
            long j = this.f46570g;
            if (j == -1) {
                this.f46570g = 0;
            } else {
                this.f46570g = ((j / gatherScheduleSeconds) + 1) * gatherScheduleSeconds;
            }
            if (trackLocationInfo != null && (onScheduleListenerWrapper = this.f46565b) != null && this.f46570g % ((long) onScheduleListenerWrapper.intervalSeconds) == 0) {
                this.f46565b.listener.onEventSchedule(this.f46570g, trackLocationInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34742c() {
        long j = this.f46569f + 1;
        this.f46569f = j;
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper = this.f46566c;
        if (onScheduleListenerWrapper != null && j % ((long) onScheduleListenerWrapper.intervalSeconds) == 0) {
            this.f46566c.listener.onEventSchedule(j, (TrackLocationInfo) null);
        }
        ScheduleController.OnScheduleListenerWrapper onScheduleListenerWrapper2 = this.f46566c;
        if (onScheduleListenerWrapper2 != null) {
            onScheduleListenerWrapper2.listener.onBaseClockSchedule(j);
        }
    }

    /* renamed from: d */
    private void m34743d() {
        int gatherScheduleSeconds = getGatherScheduleSeconds() * 1000;
        int uploadScheduleSeconds = getUploadScheduleSeconds() * 1000;
        int min = gatherScheduleSeconds > 0 ? Math.min(Integer.MAX_VALUE, gatherScheduleSeconds) : Integer.MAX_VALUE;
        if (uploadScheduleSeconds > 0) {
            min = Math.min(min, uploadScheduleSeconds);
        }
        if (min != Integer.MAX_VALUE) {
            long j = (long) min;
            if (j != LocationCenter.getIntance().getNormalLocationUpdateIntervalMillis()) {
                LocationCenter.getIntance().requestNormalLocationUpdates(this.f46571h, j);
                return;
            }
            return;
        }
        LocationCenter.getIntance().removeNormalLocationUpdates();
    }
}
