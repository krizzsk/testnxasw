package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final class TopicsStore {
    private static WeakReference<TopicsStore> topicsStoreWeakReference;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    private SharedPreferencesQueue topicOperationsQueue;

    private TopicsStore(SharedPreferences sharedPreferences2, Executor executor) {
        this.syncExecutor = executor;
        this.sharedPreferences = sharedPreferences2;
    }

    public static synchronized TopicsStore getInstance(Context context, Executor executor) {
        synchronized (TopicsStore.class) {
            TopicsStore topicsStore = topicsStoreWeakReference != null ? (TopicsStore) topicsStoreWeakReference.get() : null;
            if (topicsStore != null) {
                return topicsStore;
            }
            TopicsStore topicsStore2 = new TopicsStore(SystemUtils.getSharedPreferences(context, "com.google.android.gms.appid", 0), executor);
            topicsStore2.initStore();
            topicsStoreWeakReference = new WeakReference<>(topicsStore2);
            return topicsStore2;
        }
    }

    private synchronized void initStore() {
        this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, "topic_operation_queue", ",", this.syncExecutor);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean addTopicOperation(TopicOperation topicOperation) {
        return this.topicOperationsQueue.add(topicOperation.serialize());
    }

    /* access modifiers changed from: package-private */
    public synchronized TopicOperation getNextTopicOperation() {
        return TopicOperation.from(this.topicOperationsQueue.peek());
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean removeTopicOperation(TopicOperation topicOperation) {
        return this.topicOperationsQueue.remove(topicOperation.serialize());
    }
}
