package com.kwai.koom.javaoom.analysis;

import android.app.Application;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.os.ResultReceiver;
import com.kwai.koom.javaoom.analysis.IPCReceiver;
import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;

public class HeapAnalyzeService extends IntentService {

    /* renamed from: a */
    static final /* synthetic */ boolean f58391a = (!HeapAnalyzeService.class.desiredAssertionStatus());

    /* renamed from: b */
    private static final String f58392b = "HeapAnalyzeService";

    /* renamed from: c */
    private ResultReceiver f58393c;

    /* renamed from: d */
    private C21296a f58394d;

    public HeapAnalyzeService() {
        super(f58392b);
    }

    public HeapAnalyzeService(String str) {
        super(str);
    }

    public static void runAnalysis(Application application, HeapAnalysisListener heapAnalysisListener) {
        KLog.m44291i(f58392b, "runAnalysis startService");
        Intent intent = new Intent(application, HeapAnalyzeService.class);
        intent.putExtra("receiver", m44264a(heapAnalysisListener));
        intent.putExtra(KConstants.ServiceIntent.HEAP_FILE, KHeapFile.getKHeapFile());
        application.startService(intent);
    }

    /* renamed from: a */
    private static IPCReceiver m44264a(final HeapAnalysisListener heapAnalysisListener) {
        return new IPCReceiver(new IPCReceiver.ReceiverCallback() {
            public void onSuccess() {
                KLog.m44291i(HeapAnalyzeService.f58392b, "IPC call back, heap analysis success");
                heapAnalysisListener.onHeapAnalyzed();
            }

            public void onError() {
                KLog.m44291i(HeapAnalyzeService.f58392b, "IPC call back, heap analysis failed");
                heapAnalysisListener.onHeapAnalyzeFailed();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        boolean z;
        KLog.m44291i(f58392b, "start analyze pid:" + Process.myPid());
        try {
            m44265a(intent);
            z = m44266a();
        } catch (Throwable th) {
            th.printStackTrace();
            z = false;
        }
        ResultReceiver resultReceiver = this.f58393c;
        if (resultReceiver != null) {
            resultReceiver.send(z ? 1001 : 1002, (Bundle) null);
        }
    }

    /* renamed from: a */
    private void m44265a(Intent intent) {
        if (f58391a || intent != null) {
            this.f58393c = (ResultReceiver) intent.getParcelableExtra("receiver");
            KHeapFile kHeapFile = (KHeapFile) intent.getParcelableExtra(KConstants.ServiceIntent.HEAP_FILE);
            KHeapFile.buildInstance(kHeapFile);
            if (f58391a || kHeapFile != null) {
                this.f58394d = new C21296a(kHeapFile);
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private boolean m44266a() {
        return this.f58394d.mo174086a();
    }
}
