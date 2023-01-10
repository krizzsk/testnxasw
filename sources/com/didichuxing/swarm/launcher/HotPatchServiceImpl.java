package com.didichuxing.swarm.launcher;

import com.didichuxing.swarm.launcher.toolkit.HotPatchService;
import org.osgi.framework.launch.Framework;

public class HotPatchServiceImpl implements HotPatchService {

    /* renamed from: a */
    private long f51724a = 0;

    HotPatchServiceImpl(Framework framework) {
    }

    public void setVersion(long j) {
        this.f51724a = j;
    }

    public long getVersion() {
        return this.f51724a;
    }
}
