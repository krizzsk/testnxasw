package com.didichuxing.omega.sdk.corelink.node;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.analysis.OMGUserStateSetting;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.record.EventsRecord;
import com.didichuxing.omega.sdk.common.record.RecordFactory;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.transport.FileDisableException;
import com.didichuxing.omega.sdk.common.utils.PrismUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EventSendNode extends Thread {
    private static final long VERY_SHORT_SLEEP_INTERVAL = 7000;
    private static boolean isFirstStart = true;
    private static volatile boolean isSendEvent = false;
    private static volatile boolean isUploading = false;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static EventSendNode instance = new EventSendNode();

        private SingletonHolder() {
        }
    }

    public static EventSendNode getInstance() {
        return SingletonHolder.instance;
    }

    private EventSendNode() {
        setName("OmegaSDK.EventSendThread");
        start();
    }

    public void wakeup() {
        isSendEvent = true;
        if (!isUploading) {
            interrupt();
        }
    }

    public void run() {
        while (true) {
            if (isFirstStart) {
                try {
                    Thread.sleep(VERY_SHORT_SLEEP_INTERVAL);
                    isFirstStart = false;
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    isFirstStart = false;
                    throw th;
                }
                isFirstStart = false;
            }
            if (OmegaConfig.isDebugModel()) {
                try {
                    Thread.sleep((long) OmegaConfig.SEND_EVENT_BACKEND_THREAD_RUN_INTERVAL);
                } catch (InterruptedException unused2) {
                }
            } else {
                isUploading = true;
                if (OmegaConfig.isDebugModel() || (OMGUserStateSetting.getUserState() == OMGUserStateSetting.OMGUserState.OMGUserStateFullAuthorized && PersistentInfoCollector.getAppInSync())) {
                    sendEvent();
                }
                isUploading = false;
                if (!isSendEvent && !OmegaConfig.isDebugModel()) {
                    try {
                        Thread.sleep((long) OmegaConfig.SEND_EVENT_BACKEND_THREAD_RUN_INTERVAL);
                    } catch (InterruptedException unused3) {
                    }
                }
                isSendEvent = false;
            }
        }
    }

    static void sendEvent() {
        try {
            String[] allMkKey = EventConsumerQueueNode.getAllMkKey();
            if (allMkKey == null) {
                return;
            }
            if (allMkKey.length > 0) {
                if (OmegaConfig.isDebugModel()) {
                    allMkKey = getSortKey(allMkKey);
                }
                int length = allMkKey.length;
                int i = 0;
                while (i < length) {
                    String str = allMkKey[i];
                    if ((OMGUserStateSetting.getUserState() == OMGUserStateSetting.OMGUserState.OMGUserStateFullAuthorized && PersistentInfoCollector.getAppInSync()) || OmegaConfig.isDebugModel()) {
                        sendEvent(str);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void sendEvent(String str) {
        EventsRecord eventsRecord;
        long j = 0;
        try {
            EventMMKVLoadMessageNode.open(str);
            String[] allKeys = EventMMKVLoadMessageNode.allKeys();
            if (allKeys != null) {
                if (allKeys.length > 0) {
                    if (OmegaConfig.isDebugModel()) {
                        allKeys = getSortKey(allKeys);
                    }
                    eventsRecord = RecordFactory.createEventsRecord();
                    for (String str2 : allKeys) {
                        if (!"seq".equals(str2)) {
                            String decodeString = EventMMKVLoadMessageNode.decodeString(str2);
                            if (!TextUtils.isEmpty(decodeString)) {
                                try {
                                    String decrypt = EventSecurityNode.decrypt(Security.getKey(), decodeString);
                                    if (!TextUtils.isEmpty(decrypt)) {
                                        Event fromJson = Event.fromJson(decrypt);
                                        if (fromJson != null) {
                                            eventsRecord.addEvent(fromJson);
                                        }
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                    if (!OmegaConfig.isDebugModel()) {
                        if (EventMMKVLoadMessageNode.containsKey("seq")) {
                            j = EventMMKVLoadMessageNode.decodeLong("seq");
                        } else {
                            j = EventMMKVLoadMessageNode.saveSeq();
                            PrismUtil.invoke("SeqCheckUtil", "markPackSeq", Long.valueOf(j));
                        }
                        eventsRecord.put("seq", Long.valueOf(j));
                    }
                    EventMMKVLoadMessageNode.close();
                    if (eventsRecord != null) {
                        if ((OMGUserStateSetting.getUserState() == OMGUserStateSetting.OMGUserState.OMGUserStateFullAuthorized && PersistentInfoCollector.getAppInSync()) || OmegaConfig.isDebugModel()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            try {
                                EventUploadNode.sendRecord(eventsRecord, RecordStorage.packRecord(eventsRecord), str);
                            } catch (FileDisableException e) {
                                if (e.getType() == 1) {
                                    Security.sendMessageBigMonitorToDc_SecurityCheckUtil(eventsRecord.getEvents());
                                }
                            } catch (Throwable unused2) {
                                return;
                            }
                            EventMMKVLoadMessageNode.removeMmkvFile(str);
                            PrismUtil.invoke("SeqCheckUtil", "checkSeq", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            EventMMKVLoadMessageNode.close();
            EventMMKVLoadMessageNode.removeMmkvFile(str);
        } catch (Throwable unused3) {
            eventsRecord = null;
        }
    }

    private static String[] getSortKey(String[] strArr) {
        List asList = Arrays.asList(strArr);
        Collections.sort(asList);
        return (String[]) asList.toArray(new String[asList.size()]);
    }
}
