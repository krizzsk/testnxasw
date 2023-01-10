package com.didichuxing.omega.sdk.corelink.node;

import android.content.Context;
import com.didichuxing.omega.sdk.common.record.Event;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventProduceQueueNode extends Thread {
    private static BlockingQueue<Event> eventQueue = new LinkedBlockingQueue();
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        SingletonHolder1.instance.start();
    }

    private static class SingletonHolder1 {
        /* access modifiers changed from: private */
        public static EventProduceQueueNode instance = new EventProduceQueueNode();

        private SingletonHolder1() {
        }
    }

    private EventProduceQueueNode() {
        setName("OmegaSDK.EventProduceQueueThread-" + hashCode());
    }

    public static void add(Event event) {
        eventQueue.offer(event);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|(1:10)(1:11)|(3:21|22|26)(2:16|(4:18|19|20|25)(1:24))|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0024 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024 A[LOOP:0: B:7:0x0024->B:23:0x0024, LOOP_START, SYNTHETIC, Splitter:B:7:0x0024] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            android.content.Context r0 = mContext
            com.didichuxing.omega.sdk.corelink.node.EventRecordPathNode.init(r0)
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.SWITCH_OMEGA_TRACKER_NEWEDITION
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            com.didichuxing.omega.sdk.corelink.node.EventConsumerQueueNode.init()
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.SWITCH_OMEGA_TRACKER_NEWEDITION
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            android.content.Context r2 = mContext
            r0[r1] = r2
            java.lang.String r1 = "SeqCheckUtil"
            java.lang.String r2 = "init"
            com.didichuxing.omega.sdk.common.utils.PrismUtil.invoke(r1, r2, r0)
            com.didichuxing.omega.sdk.corelink.node.EventSendNode.getInstance()
        L_0x0024:
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.isDebugModel()     // Catch:{  }
            r1 = 0
            if (r0 == 0) goto L_0x0038
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{  }
            r0.<init>()     // Catch:{  }
            java.util.concurrent.BlockingQueue<com.didichuxing.omega.sdk.common.record.Event> r2 = eventQueue     // Catch:{  }
            r3 = 50
            r2.drainTo(r0, r3)     // Catch:{  }
            goto L_0x0043
        L_0x0038:
            java.util.concurrent.BlockingQueue<com.didichuxing.omega.sdk.common.record.Event> r0 = eventQueue     // Catch:{  }
            java.lang.Object r0 = r0.take()     // Catch:{  }
            com.didichuxing.omega.sdk.common.record.Event r0 = (com.didichuxing.omega.sdk.common.record.Event) r0     // Catch:{  }
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0043:
            if (r1 != 0) goto L_0x0059
            if (r0 == 0) goto L_0x004d
            int r2 = r0.size()     // Catch:{  }
            if (r2 != 0) goto L_0x0059
        L_0x004d:
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.isDebugModel()     // Catch:{  }
            if (r0 == 0) goto L_0x0024
            r0 = 30
            java.lang.Thread.sleep(r0)     // Catch:{ all -> 0x0024 }
            goto L_0x0024
        L_0x0059:
            com.didichuxing.omega.sdk.corelink.node.EventCollectNode.collectEvent(r0, r1)     // Catch:{  }
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.corelink.node.EventProduceQueueNode.run():void");
    }
}
