package com.firebase.jobdispatcher;

import android.net.Uri;
import java.util.List;

public class TriggerReason {

    /* renamed from: a */
    private final List<Uri> f54688a;

    TriggerReason(List<Uri> list) {
        this.f54688a = list;
    }

    public List<Uri> getTriggeredContentUris() {
        return this.f54688a;
    }
}
