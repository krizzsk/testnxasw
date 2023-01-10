package com.didi.trackupload.sdk.core;

import android.text.TextUtils;
import com.didi.trackupload.sdk.ITrackDataDelegate;
import com.didi.trackupload.sdk.TrackClient;
import com.didi.trackupload.sdk.TrackOnceClient;
import com.didi.trackupload.sdk.TrackOptions;
import com.didi.trackupload.sdk.core.ScheduleController;
import com.didi.trackupload.sdk.datachannel.protobuf.ClientType;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.storage.BizNodeEntity;
import com.didi.trackupload.sdk.storage.TrackDataStorage;
import com.didi.trackupload.sdk.utils.LogStringUtils;
import com.didi.trackupload.sdk.utils.MathUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadController implements ScheduleController.OnScheduleListener {
    public static final String TAG = "TrackUpload";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Map<String, UploadClient> f46577a = new HashMap();

    class UploadClient {
        TrackClient client;
        boolean gatherActive;
        int intervalSeconds;
        boolean uploadActive = true;
        boolean uploadOnce;

        UploadClient(TrackClient trackClient, boolean z) {
            update(trackClient);
            this.uploadOnce = z;
        }

        /* access modifiers changed from: package-private */
        public void update(TrackClient trackClient) {
            this.client = trackClient;
            this.intervalSeconds = (int) (trackClient.getTrackOptions().getUploadIntervalMode().value() / 1000);
            this.gatherActive = trackClient.getTrackOptions().getGatherIntervalMode() != TrackOptions.GatherIntervalMode.NEVER;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UploadClient)) {
                return false;
            }
            return TextUtils.equals(this.client.getTrackTag(), ((UploadClient) obj).client.getTrackTag());
        }

        public int hashCode() {
            return this.client.hashCode();
        }
    }

    public void addClient(TrackClient trackClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m34830d(TAG, "addClient client=" + trackClient.toSimpleString());
            this.f46577a.put(trackClient.getTrackTag(), new UploadClient(trackClient, true));
            m34749a();
        }
    }

    public void removeClient(final TrackClient trackClient) {
        final BizNodeEntity a = m34746a(trackClient);
        TrackLog.m34830d(TAG, "removeClient client=" + trackClient.toSimpleString());
        CoreThread.post(new Runnable() {
            public void run() {
                UploadClient uploadClient = (UploadClient) UploadController.this.f46577a.get(trackClient.getTrackTag());
                if (uploadClient != null) {
                    TrackDataStorage.getInstance().saveBizNodeEntity(a);
                    uploadClient.uploadOnce = true;
                    uploadClient.uploadActive = false;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34752b(TrackClient trackClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m34830d(TAG, "removeClientInternal client=" + trackClient.toSimpleString());
            this.f46577a.remove(trackClient.getTrackTag());
            m34749a();
        }
    }

    public void updateClient(TrackClient trackClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m34830d(TAG, "updateClient client=" + trackClient.toSimpleString());
            UploadClient uploadClient = this.f46577a.get(trackClient.getTrackTag());
            if (uploadClient != null) {
                uploadClient.update(trackClient);
            }
            m34749a();
        }
    }

    public void startOnceClient(TrackOnceClient trackOnceClient) {
        if (CoreThread.ensureCoreThread()) {
            TrackLog.m34830d(TAG, "startOnceClient client=" + trackOnceClient.toSimpleString());
            m34753b(trackOnceClient);
        }
    }

    /* renamed from: a */
    private void m34749a() {
        int d = ScheduleController.m34730a().mo115917d();
        int i = 0;
        for (Map.Entry next : this.f46577a.entrySet()) {
            if (((UploadClient) next.getValue()).intervalSeconds > 0) {
                if (i != 0) {
                    i = MathUtils.gcd(i, ((UploadClient) next.getValue()).intervalSeconds);
                } else {
                    i = ((UploadClient) next.getValue()).intervalSeconds;
                }
            }
        }
        if (i > 0) {
            if (i != d) {
                ScheduleController.m34730a().mo115915b(this, i);
            }
        } else if (d > 0) {
            ScheduleController.m34730a().mo115918e();
        }
    }

    public void onEventSchedule(long j, TrackLocationInfo trackLocationInfo) {
        if (CoreThread.ensureCoreThread()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Map.Entry<String, UploadClient> value : this.f46577a.entrySet()) {
                final UploadClient uploadClient = (UploadClient) value.getValue();
                if (uploadClient.uploadOnce || j % ((long) uploadClient.intervalSeconds) == 0) {
                    z = true;
                    hashMap.put(uploadClient.client.getTrackTag(), uploadClient);
                    if (uploadClient.gatherActive || uploadClient.uploadOnce) {
                        arrayList.add(m34746a(uploadClient.client));
                    }
                    if (uploadClient.uploadOnce) {
                        uploadClient.uploadOnce = false;
                    }
                } else {
                    hashMap.put(uploadClient.client.getTrackTag(), (Object) null);
                }
                if (!uploadClient.uploadActive && !uploadClient.uploadOnce) {
                    CoreThread.post(new Runnable() {
                        public void run() {
                            UploadController.this.m34752b(uploadClient.client);
                        }
                    });
                }
            }
            if (z) {
                m34751a((Map<String, UploadClient>) hashMap, (List<BizNodeEntity>) arrayList);
            }
        }
    }

    public void onBaseClockSchedule(long j) {
        if (CoreThread.ensureCoreThread()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Map.Entry<String, UploadClient> value : this.f46577a.entrySet()) {
                final UploadClient uploadClient = (UploadClient) value.getValue();
                if (uploadClient.uploadOnce) {
                    z = true;
                    hashMap.put(uploadClient.client.getTrackTag(), uploadClient);
                    arrayList.add(m34746a(uploadClient.client));
                    uploadClient.uploadOnce = false;
                } else {
                    hashMap.put(uploadClient.client.getTrackTag(), (Object) null);
                }
                if (!uploadClient.uploadActive && !uploadClient.uploadOnce) {
                    CoreThread.post(new Runnable() {
                        public void run() {
                            UploadController.this.m34752b(uploadClient.client);
                        }
                    });
                }
            }
            if (z) {
                m34751a((Map<String, UploadClient>) hashMap, (List<BizNodeEntity>) arrayList);
            }
        }
    }

    /* renamed from: a */
    static BizNodeEntity m34746a(TrackClient trackClient) {
        ClientType protoValue = trackClient.getClientType().getProtoValue();
        ITrackDataDelegate trackDataDelegate = trackClient.getTrackDataDelegate();
        Integer num = null;
        byte[] customData = trackDataDelegate != null ? trackDataDelegate.getCustomData() : null;
        BizNodeEntity bizNodeEntity = new BizNodeEntity();
        bizNodeEntity.setTag(trackClient.getTrackTag());
        if (protoValue != null) {
            num = Integer.valueOf(protoValue.getValue());
        }
        bizNodeEntity.setClient_type(num);
        bizNodeEntity.setExtra_data(customData);
        return bizNodeEntity;
    }

    /* renamed from: a */
    static BizNodeEntity m34747a(TrackOnceClient trackOnceClient) {
        ClientType protoValue = trackOnceClient.getClientType().getProtoValue();
        ITrackDataDelegate trackDataDelegate = trackOnceClient.getTrackDataDelegate();
        Integer num = null;
        byte[] customData = trackDataDelegate != null ? trackDataDelegate.getCustomData() : null;
        BizNodeEntity bizNodeEntity = new BizNodeEntity();
        bizNodeEntity.setTag(trackOnceClient.getTrackTag());
        if (protoValue != null) {
            num = Integer.valueOf(protoValue.getValue());
        }
        bizNodeEntity.setClient_type(num);
        bizNodeEntity.setExtra_data(customData);
        return bizNodeEntity;
    }

    /* renamed from: a */
    private void m34751a(Map<String, UploadClient> map, List<BizNodeEntity> list) {
        TrackDataStorage.getInstance().saveBizNodeEntities(list);
        UploadTask uploadTask = new UploadTask(map, UploadFlags.m34754a(65536));
        TrackLog.m34830d(TAG, "upload task=" + uploadTask.toHexString() + " tags=" + LogStringUtils.parseTags((Map<String, ?>) map));
        uploadTask.mo115962a();
    }

    /* renamed from: b */
    private void m34753b(TrackOnceClient trackOnceClient) {
        UploadOnceTask uploadOnceTask = new UploadOnceTask(trackOnceClient, UploadFlags.m34754a(131072, 4));
        TrackLog.m34830d(TAG, "upload once task=" + uploadOnceTask + " tags=" + LogStringUtils.parseTags(trackOnceClient.getTrackTag()));
        uploadOnceTask.mo115946a();
    }
}
