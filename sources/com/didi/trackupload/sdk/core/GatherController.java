package com.didi.trackupload.sdk.core;

import android.text.TextUtils;
import com.didi.trackupload.sdk.TrackClient;
import com.didi.trackupload.sdk.core.ScheduleController;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.storage.TrackDataStorage;
import com.didi.trackupload.sdk.storage.TrackNodeEntity;
import com.didi.trackupload.sdk.utils.LogStringUtils;
import com.didi.trackupload.sdk.utils.MathUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GatherController implements ScheduleController.OnScheduleListener {
    public static final String TAG = "TrackGather";

    /* renamed from: a */
    private Map<String, GatherClient> f46556a = new HashMap();

    public void onBaseClockSchedule(long j) {
    }

    private class GatherClient {
        TrackClient client;
        boolean gatherOnce;
        int intervalSeconds;

        GatherClient(TrackClient trackClient, boolean z) {
            update(trackClient);
            this.gatherOnce = z;
        }

        /* access modifiers changed from: package-private */
        public void update(TrackClient trackClient) {
            this.client = trackClient;
            this.intervalSeconds = (int) (trackClient.getTrackOptions().getGatherIntervalMode().value() / 1000);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GatherClient)) {
                return false;
            }
            return TextUtils.equals(this.client.getTrackTag(), ((GatherClient) obj).client.getTrackTag());
        }

        public int hashCode() {
            return this.client.hashCode();
        }
    }

    public void addClient(TrackClient trackClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m34830d(TAG, "addClient client=" + trackClient.toSimpleString());
            this.f46556a.put(trackClient.getTrackTag(), new GatherClient(trackClient, true));
            m34722a();
        }
    }

    public void removeClient(TrackClient trackClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m34830d(TAG, "removeClient client=" + trackClient.toSimpleString());
            this.f46556a.remove(trackClient.getTrackTag());
            m34722a();
        }
    }

    public void updateClient(TrackClient trackClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m34830d(TAG, "updateClient client=" + trackClient.toSimpleString());
            GatherClient gatherClient = this.f46556a.get(trackClient.getTrackTag());
            if (gatherClient != null) {
                gatherClient.update(trackClient);
            }
            m34722a();
        }
    }

    /* renamed from: a */
    private void m34722a() {
        int b = ScheduleController.m34730a().mo115914b();
        int i = 0;
        for (Map.Entry<String, GatherClient> value : this.f46556a.entrySet()) {
            int i2 = ((GatherClient) value.getValue()).intervalSeconds;
            if (i2 > 0) {
                i = i != 0 ? MathUtils.gcd(i, i2) : i2;
            }
        }
        if (i > 0) {
            if (i != b) {
                ScheduleController.m34730a().mo115913a(this, i);
            }
        } else if (b > 0) {
            ScheduleController.m34730a().mo115916c();
        }
    }

    public void onEventSchedule(long j, TrackLocationInfo trackLocationInfo) {
        if (CoreThread.ensureCoreThread()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, GatherClient> value : this.f46556a.entrySet()) {
                GatherClient gatherClient = (GatherClient) value.getValue();
                if (gatherClient.intervalSeconds > 0 && (gatherClient.gatherOnce || j % ((long) gatherClient.intervalSeconds) == 0)) {
                    arrayList.add(gatherClient.client.getTrackTag());
                    gatherClient.gatherOnce = false;
                }
            }
            m34723a(arrayList, trackLocationInfo);
        }
    }

    /* renamed from: a */
    private void m34723a(List<String> list, TrackLocationInfo trackLocationInfo) {
        if (list != null && list.size() > 0 && trackLocationInfo != null) {
            TrackLog.m34830d(TAG, "gather tags=" + LogStringUtils.parseTags(list));
            TrackNodeEntity trackNodeEntity = new TrackNodeEntity();
            trackNodeEntity.assignLocInfo(trackLocationInfo);
            trackNodeEntity.setTags(list);
            TrackDataStorage.getInstance().saveTrackNodeEntity(trackNodeEntity);
        }
    }
}
