package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.TMXProfilingHandle;

public interface TMXEndNotifier {
    void complete(TMXProfilingHandle.Result result);
}
