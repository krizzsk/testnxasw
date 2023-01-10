package com.didi.dvm.patch.dvm_patch;

public class PatchResponse {
    public PatchData data;
    public String errmsg = "";
    public int errno = -1;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasData() {
        /*
            r1 = this;
            int r0 = r1.errno
            if (r0 != 0) goto L_0x000e
            com.didi.dvm.patch.dvm_patch.PatchData r0 = r1.data
            if (r0 == 0) goto L_0x000e
            java.util.Map<java.lang.String, com.didi.dvm.patch.dvm_patch.PatchElement> r0 = r0.patchDataMap
            if (r0 == 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.PatchResponse.hasData():boolean");
    }
}
