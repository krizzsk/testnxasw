package com.didi.safety.god2020.p146ui;

import android.net.Uri;
import com.didi.safety.god2020.task.DetectionTask;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.safety.god2020.ui.TaskManager */
public class TaskManager {

    /* renamed from: a */
    private List<DetectionTask> f37675a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DetectionTask f37676b;

    /* renamed from: c */
    private boolean f37677c;

    public TaskManager(DetectionTask... detectionTaskArr) {
        LinkedList linkedList = new LinkedList();
        this.f37675a = linkedList;
        if (detectionTaskArr != null && detectionTaskArr.length != 0) {
            linkedList.addAll(Arrays.asList(detectionTaskArr));
        }
    }

    public void addTask(DetectionTask detectionTask) {
        this.f37675a.add(detectionTask);
    }

    public void executeTask() {
        if (!this.f37675a.isEmpty()) {
            this.f37677c = true;
            this.f37676b = this.f37675a.remove(0);
            if (this.f37675a.isEmpty()) {
                this.f37676b.setLast();
            }
            this.f37676b.start(new DetectionTask.TaskListener() {
                public void onComplete() {
                    TaskManager.this.f37676b.quitTask();
                    TaskManager.this.executeTask();
                }
            });
        }
    }

    public boolean isBegin() {
        return this.f37677c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo96521a() {
        DetectionTask detectionTask = this.f37676b;
        return detectionTask != null ? detectionTask.getCollectType() : "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo96525b() {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.logReqFocusEvent();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96523a(Map<String, Object> map) {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.logFocusEvent(map);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo96526c() {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.restartDetection();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo96527d() {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.restartFromBeginning();
        }
    }

    public void onDestroy() {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.quitTask();
            this.f37676b.onDestroy();
        }
        while (this.f37675a.size() > 0) {
            this.f37675a.remove(0).quitTask();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo96528e() {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.onBackPressed();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo96530f() {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.onBackPressCanceled();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo96531g() {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.onQuitConfirmed();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo96532h() {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.onPause();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo96533i() {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.onResume();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96522a(Uri uri) {
        DetectionTask detectionTask = this.f37676b;
        if (detectionTask != null) {
            detectionTask.onLocalPicSelected(uri);
        }
    }
}
