package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class Uploader {
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler workScheduler;

    @Inject
    public Uploader(Context context2, BackendRegistry backendRegistry2, EventStore eventStore2, WorkScheduler workScheduler2, Executor executor2, SynchronizationGuard synchronizationGuard, Clock clock2) {
        this.context = context2;
        this.backendRegistry = backendRegistry2;
        this.eventStore = eventStore2;
        this.workScheduler = workScheduler2;
        this.executor = executor2;
        this.guard = synchronizationGuard;
        this.clock = clock2;
    }

    /* access modifiers changed from: package-private */
    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) this.context.getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void upload(TransportContext transportContext, int i, Runnable runnable) {
        this.executor.execute(new Runnable(transportContext, i, runnable) {
            public final /* synthetic */ TransportContext f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ Runnable f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                Uploader.this.lambda$upload$1$Uploader(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.workScheduler.schedule(r4, r5 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$upload$1$Uploader(com.google.android.datatransport.runtime.TransportContext r4, int r5, java.lang.Runnable r6) {
        /*
            r3 = this;
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r1 = r3.eventStore     // Catch:{ SynchronizationException -> 0x0026 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$7iIGXG4rziTDaCv7wibWFWjAdgo r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$7iIGXG4rziTDaCv7wibWFWjAdgo     // Catch:{ SynchronizationException -> 0x0026 }
            r2.<init>()     // Catch:{ SynchronizationException -> 0x0026 }
            r0.runCriticalSection(r2)     // Catch:{ SynchronizationException -> 0x0026 }
            boolean r0 = r3.isNetworkAvailable()     // Catch:{ SynchronizationException -> 0x0026 }
            if (r0 != 0) goto L_0x0020
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$Uploader$-PizdFkrUS80CHQoeatutNhEQNk r1 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.-$$Lambda$Uploader$-PizdFkrUS80CHQoeatutNhEQNk     // Catch:{ SynchronizationException -> 0x0026 }
            r1.<init>(r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            r0.runCriticalSection(r1)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0020:
            r3.logAndUpdateState(r4, r5)     // Catch:{ SynchronizationException -> 0x0026 }
            goto L_0x002d
        L_0x0024:
            r4 = move-exception
            goto L_0x0031
        L_0x0026:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r0 = r3.workScheduler     // Catch:{ all -> 0x0024 }
            int r5 = r5 + 1
            r0.schedule(r4, r5)     // Catch:{ all -> 0x0024 }
        L_0x002d:
            r6.run()
            return
        L_0x0031:
            r6.run()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.lambda$upload$1$Uploader(com.google.android.datatransport.runtime.TransportContext, int, java.lang.Runnable):void");
    }

    public /* synthetic */ Object lambda$upload$0$Uploader(TransportContext transportContext, int i) {
        this.workScheduler.schedule(transportContext, i + 1);
        return null;
    }

    /* access modifiers changed from: package-private */
    public void logAndUpdateState(TransportContext transportContext, int i) {
        BackendResponse send;
        TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
        Iterable<PersistedEvent> iterable = (Iterable) this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection(transportContext) {
            public final /* synthetic */ TransportContext f$1;

            {
                this.f$1 = r2;
            }

            public final Object execute() {
                return Uploader.this.lambda$logAndUpdateState$2$Uploader(this.f$1);
            }
        });
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                Logging.m40763d(LOG_TAG, "Unknown backend for %s, deleting event batch for it...", (Object) transportContext);
                send = BackendResponse.fatalError();
            } else {
                ArrayList arrayList = new ArrayList();
                for (PersistedEvent event : iterable) {
                    arrayList.add(event.getEvent());
                }
                send = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
            }
            this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection(send, iterable, transportContext, i) {
                public final /* synthetic */ BackendResponse f$1;
                public final /* synthetic */ Iterable f$2;
                public final /* synthetic */ TransportContext f$3;
                public final /* synthetic */ int f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final Object execute() {
                    return Uploader.this.lambda$logAndUpdateState$3$Uploader(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        }
    }

    public /* synthetic */ Iterable lambda$logAndUpdateState$2$Uploader(TransportContext transportContext) {
        return this.eventStore.loadBatch(transportContext);
    }

    public /* synthetic */ Object lambda$logAndUpdateState$3$Uploader(BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        if (backendResponse.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
            this.eventStore.recordFailure(iterable);
            this.workScheduler.schedule(transportContext, i + 1);
            return null;
        }
        this.eventStore.recordSuccess(iterable);
        if (backendResponse.getStatus() == BackendResponse.Status.f55136OK) {
            this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + backendResponse.getNextRequestWaitMillis());
        }
        if (!this.eventStore.hasPendingEventsFor(transportContext)) {
            return null;
        }
        this.workScheduler.schedule(transportContext, 1, true);
        return null;
    }
}
